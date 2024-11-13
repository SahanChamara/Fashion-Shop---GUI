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


        // Table making
        String[] colNames = {"Customer ID","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        FashionShopCustomerDetails[] cus = viewCustomerArr(customerList);
        for(int i=0; i<customerList.size(); i++){
            // FashionShopCustomerDetails cus = customerList.get(i);
            if(cus[i]!=null){
                Object[] rowData = {cus[i].getPhoneNumber(),cus[i].getQuantity(),cus[i].getAmount()};
                dtm.addRow(rowData);
            }
            
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(50,50,500,200);
        add(sp);      
        
    }

    // View Customers
    public FashionShopCustomerDetails[] viewCustomerArr(List customerList) {
        FashionShopCustomerDetails[] viewCustomers = new FashionShopCustomerDetails[customerList.capacity()];
        boolean[] equalPass = new boolean[customerList.capacity()];
        int count = 0;
        FashionShopCustomerDetails[] cusDetails = customerList.getArrayObject();

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
