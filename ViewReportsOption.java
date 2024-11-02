import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewReportsOption extends JFrame{
    private JButton btnBack;
    private JButton btnViewCustomers;
    private JButton btnBestInCustomers;
    private JButton btnAllCustomers;
    private JButton btnCatByQty;
    private JButton btnCatByAmount;
    private JButton btnOrdersByAmount;
    private JButton btnAllOrders;

    private CustomerDetailsHandeler customerDetails;

    ViewReportsOption(CustomerDetailsHandeler customerDetails){
        this.customerDetails=customerDetails;

        // making the window
        setSize(800,400);
        setTitle("'View Customers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //Back button
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        //Back button Action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new HomePage(customerDetails);
            }
        });

        //View Customer Button
        btnViewCustomers = new JButton("View Customer");
        btnViewCustomers.setFont(new Font("Arial",Font.BOLD,15));
        btnViewCustomers.setBackground(new Color(0,204,51));
        btnViewCustomers.setForeground(Color.WHITE);
        btnViewCustomers.setBounds(40,80,200,40);
        add(btnViewCustomers);

        //Best IN Cusstomers button
        btnBestInCustomers = new JButton("Best In Customers");
        btnBestInCustomers.setFont(new Font("Arial",Font.BOLD,15));
        btnBestInCustomers.setBackground(new Color(0,204,51));
        btnBestInCustomers.setForeground(Color.WHITE);
        btnBestInCustomers.setBounds(40,160,200,40);
        add(btnBestInCustomers);

        // All Customers Button
        btnAllCustomers = new JButton("All Customer");
        btnAllCustomers.setFont(new Font("Arial",Font.BOLD,15));
        btnAllCustomers.setBackground(new Color(0,204,51));
        btnAllCustomers.setForeground(Color.WHITE);
        btnAllCustomers.setBounds(40,240,200,40);
        add(btnAllCustomers);

        // Cat by Qty button
        btnCatByQty = new JButton("Categorized By QTY");
        btnCatByQty.setFont(new Font("Arial",Font.BOLD,15));
        btnCatByQty.setBackground(Color.BLUE);
        btnCatByQty.setForeground(Color.WHITE);
        btnCatByQty.setBounds(290,120,200,40);
        add(btnCatByQty);

        // Cat by Amount
        btnCatByAmount = new JButton("categorized By Amount");
        btnCatByAmount.setFont(new Font("Arial",Font.BOLD,15));
        btnCatByAmount.setBackground(Color.BLUE);
        btnCatByAmount.setForeground(Color.WHITE);
        btnCatByAmount.setBounds(290,200,200,40);
        add(btnCatByAmount);

        // Orders By Amount
        btnOrdersByAmount = new JButton("Orders By Amount");
        btnOrdersByAmount.setFont(new Font("Arial",Font.BOLD,15));
        btnOrdersByAmount.setBackground(new Color(102,102,102));
        btnOrdersByAmount.setForeground(Color.WHITE);
        btnOrdersByAmount.setBounds(550,120,200,40);
        add(btnOrdersByAmount);

        // ALl Orders
        btnAllOrders = new JButton("All Orders");
        btnAllOrders.setFont(new Font("Arial",Font.BOLD,15));
        btnAllOrders.setBackground(new Color(102,102,102));
        btnAllOrders.setForeground(Color.WHITE);
        btnAllOrders.setBounds(550,200,200,40);
        add(btnAllOrders);
    }
    
}
