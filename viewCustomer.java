import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class viewCustomer extends JFrame{
    private JLabel topic;
    private JButton btnBack;

    viewCustomer(){
        setSize(800,500);
        setTitle("View Customers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //main topic
        topic = new JLabel("View Customers", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,15));
        topic.setForeground(Color.RED);
        topic.setBounds(0,0,800,30);
        add(topic);

        // back button
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        //back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new ViewReportsOption().setVisible(true);
            }
        });

         
        
        //Table Making
        String[] colNames = {"Customer ID","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        try{
            List customerList = CustomerController.viewCustomer();
            for(int i=0; i<customerList.size(); i++){
                FashionShopCustomerDetails c1 = customerList.get(i);
                Object[] rowData = {c1.getPhoneNumber(),c1.getQuantity(),c1.getAmount()};
                dtm.addRow(rowData);
            }

            JTable cusTable = new JTable(dtm);
            JScrollPane sp = new JScrollPane(cusTable);
            sp.setBounds(50,50,500,200);
            add(sp);
        }catch(IOException ex){

        }
    }

    // View Customers
    public FashionShopCustomerDetails[] viewCustomerArr(List customerList) {
        FashionShopCustomerDetails[] viewCustomers = new FashionShopCustomerDetails[customerList.size()];
        boolean[] equalPass = new boolean[customerList.size()];
        int count = 0;
        FashionShopCustomerDetails[] cusDetails = customerList.toArray();

        for (int i = 0; i < customerList.size(); i++) {
            if (equalPass[i]) {
                continue;
            }
            viewCustomers[count] = new FashionShopCustomerDetails();
            

            int tempQty = cusDetails[i].getQuantity();
            double tempAmount = cusDetails[i].getAmount();
            equalPass[i] = true;

            for (int j = i + 1; j < customerList.size(); j++) {
                if (cusDetails[i].getPhoneNumber().equals(cusDetails[j].getPhoneNumber())) {
                    tempQty += cusDetails[i].getQuantity();
                    tempAmount += cusDetails[i].getAmount();
                    equalPass[j] = true;
                }
            }

            String cusPhoneNumber = cusDetails[i].getPhoneNumber();
            viewCustomers[count].setViewCustomers(cusPhoneNumber, tempQty, tempAmount);
            count++;
        }
        return viewCustomers;
    }
    
}
