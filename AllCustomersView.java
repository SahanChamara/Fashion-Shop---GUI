import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class AllCustomersView extends JFrame {
    

    private JLabel topic;
    private JButton btnBack;

    AllCustomersView(){
        

        setSize(1000,600);
        setTitle("All Customer Reports");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // topic
        topic = new JLabel("All Customer Reports", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,25));
        topic.setForeground(Color.ORANGE);
        topic.setBounds(0,0,1000,30);
        add(topic);

        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,35,80,30);
        add(btnBack);

        // back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new ViewReportsOption().setVisible(true);
            }
        });

        // List customerList = new List(10,0.5);
        // try{
        //     BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
        //     String line = br.readLine();
        //     while(line!=null){
        //         String[] cusDetails = line.split(",");
        //         FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),cusDetails[5]);
        //         customerList.add(c1);
        //         line=br.readLine();
        //     }
        // }catch(IOException ex){

        // }

        // Table 
        String[] colNames = {"Customer ID","XS","S","M","L","XL","XXL","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        try{
            List customerList = CustomerController.viewCustomer();
            AllCustomers[] allCus = allCustomersReport(customerList);
            for(int i=0; i<allCus.length; i++){
                if(allCus[i].getPhoneNumber()!=null){
                    Object[] rowData = {allCus[i].getPhoneNumber(),allCus[i].getXtraSamll(),allCus[i].getSmall(),allCus[i].getMediumSize(),allCus[i].getLarge(),allCus[i].getXtraLarge(),allCus[i].getXtraXl(),allCus[i].getAmount()};
                    dtm.addRow(rowData);
                }
            }

            JTable cusTable = new JTable(dtm);
            JScrollPane sp = new JScrollPane(cusTable);
            sp.setBounds(100,100,800,400);
            add(sp);
        }catch(IOException ex){

        }

    }

     // All Customer
     public AllCustomers[] allCustomersReport(List customerList) {
        AllCustomers[] allCustomerDetails = new AllCustomers[customerList.size()];
        FashionShopCustomerDetails[] cusDetails = customerList.toArray();

        for (int i = 0; i < allCustomerDetails.length; i++) {
            allCustomerDetails[i] = new AllCustomers();
        }

        boolean equalPass[] = new boolean[customerList.size()];
        for (int i = 0; i < customerList.size(); i++) {
            if (equalPass[i]) {
                continue;
            }

            int tempMedium2 = 0;
            int tempXtraSmall2 = 0;
            int tempXtraXl2 = 0;
            int tempXtraLarge2 = 0;
            int tempSmall2 = 0;
            int tempLarge2 = 0;
            double tempAmount2 = 0;

            String customerPhoneNumber = cusDetails[i].getPhoneNumber();

            allCustomerDetails[i].setPhoneNumber(customerPhoneNumber);

            if (cusDetails[i].getSize().equals("M")) {
                tempMedium2 = cusDetails[i].getQuantity();
                allCustomerDetails[i].setMedium(tempMedium2);

            } else if (cusDetails[i].getSize().equals("XS")) {
                tempXtraSmall2 = cusDetails[i].getQuantity();
                allCustomerDetails[i].setXtraSmall(tempXtraSmall2);

            } else if (cusDetails[i].getSize().equals("XXL")) {
                tempXtraXl2 = cusDetails[i].getQuantity();
                allCustomerDetails[i].setXtraXl(tempXtraXl2);

            } else if (cusDetails[i].getSize().equals("XL")) {
                tempXtraLarge2 = cusDetails[i].getQuantity();
                allCustomerDetails[i].setXtraLarge(tempXtraLarge2);

            } else if (cusDetails[i].getSize().equals("S")) {
                tempSmall2 = cusDetails[i].getQuantity();
                allCustomerDetails[i].setSmall(tempSmall2);

            } else if (cusDetails[i].getSize().equals("L")) {
                tempLarge2 = cusDetails[i].getQuantity();
                allCustomerDetails[i].setLarge(tempLarge2);
            }

            tempAmount2 = cusDetails[i].getAmount();
            allCustomerDetails[i].setAmount(tempAmount2);
            equalPass[i] = true;

            for (int j = i + 1; j < customerList.size(); j++) {
                if (cusDetails[i].getPhoneNumber().equals(cusDetails[j].getPhoneNumber())) {
                    allCustomerDetails[i].setPhoneNumber(customerPhoneNumber);

                    if (cusDetails[i].getSize().equals("M")) {
                        tempMedium2 = cusDetails[i].getQuantity();
                        allCustomerDetails[i].setMedium(tempMedium2);
                    } else if (cusDetails[i].getSize().equals("XS")) {
                        tempXtraSmall2 = cusDetails[i].getQuantity();
                        allCustomerDetails[i].setXtraSmall(tempXtraSmall2);
                    } else if (cusDetails[i].getSize().equals("XXL")) {
                        tempXtraXl2 = cusDetails[i].getQuantity();
                        allCustomerDetails[i].setXtraXl(tempXtraXl2);
                    } else if (cusDetails[i].getSize().equals("XL")) {
                        tempXtraLarge2 = cusDetails[i].getQuantity();
                        allCustomerDetails[i].setXtraLarge(tempXtraLarge2);
                    } else if (cusDetails[i].getSize().equals("S")) {
                        tempSmall2 = cusDetails[i].getQuantity();
                        allCustomerDetails[i].setSmall(tempSmall2);
                    } else if (cusDetails[i].getSize().equals("L")) {
                        tempLarge2 = cusDetails[i].getQuantity();
                        allCustomerDetails[i].setLarge(tempLarge2);
                    }

                    tempAmount2 = cusDetails[i].getAmount();
                    allCustomerDetails[i].setAmount(tempAmount2);
                    equalPass[i] = true;
                }
            }
        }
        return allCustomerDetails;

    }
    
}
