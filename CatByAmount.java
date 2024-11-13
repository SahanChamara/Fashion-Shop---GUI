import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class CatByAmount extends JFrame {
    private JLabel topic;
    private JButton btnBack;

    CatByAmount( ){

        setSize(500,500);
        setTitle("Item By Amount");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //topic
        topic = new JLabel("Best selling categories sorted by Amount", SwingConstants.CENTER);
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
                FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),Integer.parseInt(cusDetails[5]));
                customerList.add(c1);
                line=br.readLine();
            }

        }catch(IOException ex){

        }

        // table
        String[] colNames = {"Size","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Sorting[] sortAmount = sortByAmount(customerList);
        for(int i=0; i<sortAmount.length; i++){
            Object[] rowData = {sortAmount[i].getSize(),sortAmount[i].getQuantity(),sortAmount[i].getAmount()};
            dtm.addRow(rowData);
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(100,100,300,200);
        add(sp);

    }

    // Sorting by Amount
    public Sorting[] sortByAmount(List customerList) {
        Sorting[] sortByAmount = new Sorting[6];
        for (int i = 0; i < sortByAmount.length; i++) {
            sortByAmount[i] = new Sorting();
        }

        FashionShopCustomerDetails[] cusDetails = customerList.getArrayObject();

        sortByAmount[0].setSize("M");
        sortByAmount[1].setSize("XL");
        sortByAmount[2].setSize("XS");
        sortByAmount[3].setSize("S");
        sortByAmount[4].setSize("XXL");
        sortByAmount[5].setSize("L");

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

        sortByAmount[0].setQuantity(0);
        sortByAmount[1].setQuantity(0);
        sortByAmount[2].setQuantity(0);
        sortByAmount[3].setQuantity(0);
        sortByAmount[4].setQuantity(0);
        sortByAmount[5].setQuantity(0);

        for (int i = 0; i < customerList.size(); i++) {
            if (cusDetails[i].getSize().equals("M")) {
                tempM4 += cusDetails[i].getQuantity();
                sortByAmount[0].setQuantity(tempM4);
            } else if (cusDetails[i].getSize().equals("XL")) {
                tempXLarge4 += cusDetails[i].getQuantity();
                sortByAmount[1].setQuantity(tempXLarge4);
            } else if (cusDetails[i].getSize().equals("XS")) {
                tempXs4 += cusDetails[i].getQuantity();
                sortByAmount[2].setQuantity(tempXs4);
            } else if (cusDetails[i].getSize().equals("S")) {
                tempSmall4 += cusDetails[i].getQuantity();
                sortByAmount[3].setQuantity(tempSmall4);
            } else if (cusDetails[i].getSize().equals("XXL")) {
                tempXtraXl4 += cusDetails[i].getQuantity();
                sortByAmount[4].setQuantity(tempXtraXl4);
            } else if (cusDetails[i].getSize().equals("L")) {
                tempLarge4 += cusDetails[i].getQuantity();
                sortByAmount[5].setQuantity(tempLarge4);
            }

            mtotal = tempM4 * 900;
            xlargetotal = tempXLarge4 * 1100;
            xstotal = tempXs4 * 600;
            smalltotal = tempSmall4 * 800;
            xtraxltotal = tempXtraXl4 * 1200;
            largetotal = tempLarge4 * 1000;

            sortByAmount[0].setAmount((double) mtotal);
            sortByAmount[1].setAmount((double) xlargetotal);
            sortByAmount[2].setAmount((double) xstotal);
            sortByAmount[3].setAmount((double) smalltotal);
            sortByAmount[4].setAmount((double) xtraxltotal);
            sortByAmount[5].setAmount((double) largetotal);

        }
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortByAmount[j].getAmount() < sortByAmount[j + 1].getAmount()) {
                    Sorting swap = sortByAmount[j];
                    sortByAmount[j] = sortByAmount[j + 1];
                    sortByAmount[j + 1] = swap;
                }
            }
        }
        return sortByAmount;
    }
    
}
