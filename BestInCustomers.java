import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.io.*;

class BestInCustomers extends JFrame {
    private JButton btnBack;
    private JLabel topic;

    BestInCustomers(){
        setSize(800,500);
        setTitle("Best In Customers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // main topic
        topic = new JLabel("BEST IN CUSTOMERS", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,15));
        topic.setForeground(Color.BLUE);
        topic.setBounds(0,0,800,30);
        add(topic);

        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        // back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new HomePage();
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

        // making the table
        String[] colNames = {"Customer ID","Quantity","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        FashionShopCustomerDetails[] bInCus=bestInCusSort(customerList);
        for(int i=0; i<bInCus.length; i++){
            if(bInCus[i]!=null){
                if(bInCus[i].getQuantity()!=0){
                    Object[] rowData = {bInCus[i].getPhoneNumber(),bInCus[i].getQuantity(),bInCus[i].getAmount()};
                    dtm.addRow(rowData);
                }
            }
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(70,60,600,150);        
        add(sp);
    }

    // Best In Customers Sorting Part
    public FashionShopCustomerDetails[] bestInCusSort(List customerList) {
        FashionShopCustomerDetails[] viewBestCustomers = new FashionShopCustomerDetails[customerList.capacity()];
        boolean[] equalPass = new boolean[customerList.capacity()];
        int count = 0;
        
        FashionShopCustomerDetails[] cusDetails = customerList.getArrayObject();

        for (int i = 0; i < customerList.size(); i++) {
            if (equalPass[i]) {
                continue;
            }

            viewBestCustomers[count] = new FashionShopCustomerDetails();

            int tempqty = cusDetails[i].getQuantity();
            double tempAmount = cusDetails[i].getAmount();
            equalPass[i] = true;

            for (int j = i + 1; j < customerList.size(); j++) {
                if (cusDetails[i].getPhoneNumber().equals(cusDetails[j].getPhoneNumber())) {
                    tempqty += cusDetails[j].getQuantity();
                    tempAmount += cusDetails[j].getAmount();
                    equalPass[j] = true;
                }
            }
            String customerPhoneNumber = cusDetails[i].getPhoneNumber();

            viewBestCustomers[count].setBestInCustomers(customerPhoneNumber, tempqty, tempAmount);
            count++;
        }

        // Sorting loop in best in customer....
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (viewBestCustomers[j] != null && viewBestCustomers[j + 1] != null) {
                    if (viewBestCustomers[j].getQuantity() != 0 && viewBestCustomers[j + 1].getQuantity() != 0) {
                        if (viewBestCustomers[j].getAmount() < viewBestCustomers[j + 1].getAmount()) {
                            FashionShopCustomerDetails swap = viewBestCustomers[j];
                            viewBestCustomers[j] = viewBestCustomers[j + 1];
                            viewBestCustomers[j + 1] = swap;
                        }
                    }

                }
            }
        }
        return viewBestCustomers;

    }
    
}
