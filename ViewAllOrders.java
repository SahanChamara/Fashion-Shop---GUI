import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ViewAllOrders extends JFrame {

    private JLabel topic;
    private JButton btnBack;

    ViewAllOrders() {

        setSize(800, 400);
        setTitle("Item By Amount");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // topic
        topic = new JLabel("View All Orders", SwingConstants.CENTER);
        topic.setFont(new Font("Arial", Font.BOLD, 15));
        topic.setForeground(Color.RED);
        topic.setBounds(0, 0, 800, 30);
        add(topic);

        // back button
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0, 35, 80, 30);
        add(btnBack);

        // back button action
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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

        // table
        String[] colNames = { "Order ID", "Customer ID", "Size", "Quantity", "Amount", "Status" };
        DefaultTableModel dtm = new DefaultTableModel(colNames, 0);

        // FashionShopCustomerDetails[] cusArray = getObject(customerList);
        // for (int i = customerList.size() - 1; i >= 0; i--) {
        //     Object[] rowData = { cusArray[i].getOrderId(), cusArray[i].getPhoneNumber(), cusArray[i].getSize(),
        //             cusArray[i].getQuantity(), cusArray[i].getAmount(), cusArray[i].getOrderStatus()};
        //     dtm.addRow(rowData);
        // }

        // JTable cusTable = new JTable(dtm);
        // JScrollPane sp = new JScrollPane(cusTable);
        // sp.setBounds(100, 60, 600, 300);
        // add(sp);

        try{
            List customerList = CustomerController.viewCustomer();
            for(int i=0; i<customerList.size(); i++){
                FashionShopCustomerDetails c1 = customerList.get(i);
                Object[] rowData = {c1.getOrderId(),c1.getPhoneNumber(),c1.getSize(),c1.getQuantity(),c1.getAmount(),c1.getOrderStatus()};
                dtm.addRow(rowData);
            }

            JTable cusTable = new JTable(dtm);
            JScrollPane sp = new JScrollPane(cusTable);
            sp.setBounds(100,60,600,300);
            add(sp);
        }catch(IOException ex){

        }

    }

    // get Object by print the view all orders
    // public FashionShopCustomerDetails[] getObject(List customerList) {
    //     FashionShopCustomerDetails[] cusDetails = customerList.getArrayObject();

    //     FashionShopCustomerDetails[] tempArray = new FashionShopCustomerDetails[customerList.capacity()];
    //     for (int i = 0; i < customerList.capacity(); i++) {
    //         tempArray[i] = cusDetails[i];
    //     }
    //     return tempArray;
    // }

}
