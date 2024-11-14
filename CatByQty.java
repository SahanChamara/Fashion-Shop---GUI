import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CatByQty extends JFrame {
    private JLabel topic;
    private JButton btnBack;

    CatByQty(){

        setSize(500,500);
        setTitle("Item By QTY");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //topic
        topic = new JLabel("Best selling categories sorted by quantity", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,15));
        topic.setForeground(Color.RED);
        topic.setBounds(0,0,500,30);
        add(topic);

        //back button
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,35,80,30);
        add(btnBack);

        //back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new ViewReportsOption().setVisible(true);
            }
        });

        List customerList = new List(10,0.5);
        try{
            BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
            String line = br.readLine();
            while(line!=null){
                String[] cusDetails = line.split(",");
                FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),cusDetails[5]);
                customerList.add(c1);
                line=br.readLine();
            }
            

        }catch(IOException ex){

        }

        // table
        String[] colNames = {"Size","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Sorting[] sortQty = sortByQty(customerList);
        for(int i=0; i<sortQty.length; i++){
            Object[] rowData = {sortQty[i].getSize(),sortQty[i].getQuantity(),sortQty[i].getAmount()};
            dtm.addRow(rowData);
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(100,100,300,200);
        add(sp);
    }


      // Sorting by Quantity
      public Sorting[] sortByQty(List customerList) {
        Sorting[] sortingByQuantity = new Sorting[6];
        for (int i = 0; i < sortingByQuantity.length; i++) {
            sortingByQuantity[i] = new Sorting();
        }

        FashionShopCustomerDetails[] cusDetails = customerList.getArrayObject();

        sortingByQuantity[0].setSize("M");
        sortingByQuantity[1].setSize("Xl");
        sortingByQuantity[2].setSize("XS");
        sortingByQuantity[3].setSize("S");
        sortingByQuantity[4].setSize("XXL");
        sortingByQuantity[5].setSize("L");

        int tempM4 = 0;
        int tempXs4 = 0;
        int tempXtraXl4 = 0;
        int tempXLarge4 = 0;
        int tempSmall4 = 0;
        int tempLarge4 = 0;

        int mtotal = 0;
        int xstotal = 0;
        int xtraxltotal = 0;
        int xlargetotal = 0;
        int smalltotal = 0;
        int largetotal = 0;

        sortingByQuantity[0].setQuantity(0);
        sortingByQuantity[1].setQuantity(0);
        sortingByQuantity[2].setQuantity(0);
        sortingByQuantity[3].setQuantity(0);
        sortingByQuantity[4].setQuantity(0);
        sortingByQuantity[5].setQuantity(0);

        for (int i = 0; i < customerList.size(); i++) {
            if (cusDetails[i].getSize().equals("M")) {
                tempM4 += cusDetails[i].getQuantity();
                sortingByQuantity[0].setQuantity(tempM4);

            } else if (cusDetails[i].getSize().equals("XL")) {
                tempXLarge4 += cusDetails[i].getQuantity();
                sortingByQuantity[1].setQuantity(tempXLarge4);

            } else if (cusDetails[i].getSize().equals("XS")) {
                tempXs4 += cusDetails[i].getQuantity();
                sortingByQuantity[2].setQuantity(tempXs4);

            } else if (cusDetails[i].getSize().equals("S")) {
                tempSmall4 += cusDetails[i].getQuantity();
                sortingByQuantity[3].setQuantity(tempSmall4);

            } else if (cusDetails[i].getSize().equals("XXL")) {
                tempXtraXl4 += cusDetails[i].getQuantity();
                sortingByQuantity[4].setQuantity(tempXtraXl4);

            } else if (cusDetails[i].getSize().equals("L")) {
                tempLarge4 += cusDetails[i].getQuantity();
                sortingByQuantity[5].setQuantity(tempLarge4);
            }

            mtotal = tempM4 * 900;
            xlargetotal = tempXLarge4 * 1100;
            xstotal = tempXs4 * 600;
            smalltotal = tempSmall4 * 800;
            xtraxltotal = tempXtraXl4 * 1200;
            largetotal = tempLarge4 * 1000;

            sortingByQuantity[0].setAmount((double) mtotal);
            sortingByQuantity[1].setAmount((double) xlargetotal);
            sortingByQuantity[2].setAmount((double) xstotal);
            sortingByQuantity[3].setAmount((double) smalltotal);
            sortingByQuantity[4].setAmount((double) xtraxltotal);
            sortingByQuantity[5].setAmount((double) largetotal);

        }
        // sorting part for quantity
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortingByQuantity[j].getQuantity() < sortingByQuantity[j + 1].getQuantity()) {
                    Sorting swap = sortingByQuantity[j];
                    sortingByQuantity[j] = sortingByQuantity[j + 1];
                    sortingByQuantity[j + 1] = swap;
                }
            }
        }
        return sortingByQuantity;
    }
    
}
