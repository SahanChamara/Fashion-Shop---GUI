import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class PlaceOrder extends JFrame{
    // private JLabel lblPlaceORder;

    private JLabel lblOrderId;
    private JLabel lblOrderIdValue;
    private JLabel lblCustomerId;
    private JLabel lblSize;
    private JLabel lblSizeHint;
    private JLabel lblQty;
    private JLabel lblAmount;
    private JLabel txtAmount;

    // private JTextField txtOrderId;
    private JTextField txtCustomerId;
    private JTextField txtSize;
    private JTextField txtQty;
    

    private JButton btnBack;
    private JButton btnPlaceOrder;

    // private String orderId;

    private CustomerDetailsHandeler customerDetails;
    
    // Default Construcotr
    PlaceOrder(CustomerDetailsHandeler customerDetails){
        this.customerDetails=customerDetails;
        
        setSize(400,400);
        setTitle("Place Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        // Back button
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.setBackground(new Color(240, 128, 128)); // Light red background
        btnBack.setForeground(Color.WHITE); // White text
        btnBack.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(btnBack);

        // Order ID label
        lblOrderId = new JLabel("Order ID :");
        lblOrderId.setBounds(50, 60, 100, 30);
        lblOrderId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblOrderId);

        // Order ID value label
        lblOrderIdValue = new JLabel();
        lblOrderIdValue.setText(customerDetails.getOrderId());
        lblOrderIdValue.setBounds(150, 60, 200, 30);
        lblOrderIdValue.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblOrderIdValue);

        // Customer ID label and text field
        lblCustomerId = new JLabel("Customer ID :");
        lblCustomerId.setBounds(50, 100, 100, 30);
        lblCustomerId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblCustomerId);

        txtCustomerId = new JTextField();
        txtCustomerId.setBounds(150, 100, 150, 30);
        add(txtCustomerId);

        // Size label and text field
        lblSize = new JLabel("Size :");
        lblSize.setBounds(50, 140, 100, 30);
        lblSize.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblSize);

        txtSize = new JTextField();
        txtSize.setBounds(150, 140, 150, 30);
        add(txtSize);

        // Size hint label
        lblSizeHint = new JLabel("(XS/S/M/L/XL/XXL)");
        lblSizeHint.setBounds(290, 140, 100, 30);
        lblSizeHint.setFont(new Font("SansSerif", Font.BOLD, 10));
        add(lblSizeHint);

        // Quantity label and text field
        lblQty = new JLabel("QTY :");
        lblQty.setBounds(50, 180, 100, 30);
        lblQty.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblQty);

        txtQty = new JTextField();
        txtQty.setBounds(150, 180, 150, 30);
        add(txtQty);

        // Amount label and text field
        lblAmount = new JLabel("Amount :");
        lblAmount.setBounds(50, 220, 100, 30);
        lblAmount.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblAmount);

        txtAmount = new JLabel();
        txtAmount.setBounds(150, 220, 150, 30);
        add(txtAmount);

        // Place button
        btnPlaceOrder = new JButton("Place");
        btnPlaceOrder.setBounds(250, 280, 80, 40);
        btnPlaceOrder.setBackground(new Color(0, 150, 136)); // Teal color
        btnPlaceOrder.setForeground(Color.WHITE); // White text
        btnPlaceOrder.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(btnPlaceOrder);


        // // BACK Button
        // JPanel btnBackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // btnBack = new JButton("Back");
        // btnBack.setBounds(10, 10, 80, 30);
        // btnBack.setBackground(new Color(240, 128, 128)); // Light red background
        // btnBack.setForeground(Color.WHITE); // White text
        // btnBackPanel.add(btnBack);

        // add("North",btnBackPanel);

        // // Labls Panel
        // JPanel allLabelsPanel = new JPanel(new GridLayout(5,1,4,4));

        // // Order ID label
        // lblOrderId = new JLabel("Order ID :");
        // //lblOrderId.setBounds(50, 60, 100, 30);
        // allLabelsPanel.add(lblOrderId);
        
        // // Customer ID label 
        // lblCustomerId = new JLabel("Customer ID :");
        // //lblCustomerId.setBounds(50, 100, 100, 30);
        // allLabelsPanel.add(lblCustomerId);

        // // Size label 
        // lblSize = new JLabel("Size :");
        // //lblSize.setBounds(50, 140, 100, 30);
        // allLabelsPanel.add(lblSize);
        
        // // Quantity label 
        // lblQty = new JLabel("QTY :");
        // //lblQty.setBounds(50, 180, 100, 30);
        // allLabelsPanel.add(lblQty);
        
        // // Amount label 
        // lblAmount = new JLabel("Amount :");
        // //lblAmount.setBounds(50, 220, 100, 30);
        // allLabelsPanel.add(lblAmount);

        // add("West",allLabelsPanel);
        // // ===========================================================

        

        // //JPanel allTextFields = new JPanel(new GridLayout(5,1));

        // // Order ID value label
        // lblOrderIdValue = new JLabel("ODR#000002");
        // lblOrderIdValue.setBounds(150, 60, 200, 30);
        // add(lblOrderIdValue);

        // //allTextFields.add(lblOrderIdValue);

        // // // Customer ID text field
        // // txtCustomerId = new JTextField();
        // // //txtCustomerId.setBounds(150, 100, 150, 30);
        // // allTextFields.add(txtCustomerId);


        // // // Size text field
        // // txtSize = new JTextField();
        // // //txtSize.setBounds(150, 140, 150, 30);
        // // allTextFields.add(txtSize);

        // // // Size hint label
        // // lblSizeHint = new JLabel("(XS/S/M/L/XL/XXL)");
        // // //lblSizeHint.setBounds(310, 140, 100, 30);
        // // lblSizeHint.setFont(new Font("SansSerif", Font.PLAIN, 10));
        // // allLabelsPanel.add(lblSizeHint);

        // // // QTY text field
        // // txtQty = new JTextField();
        // // //txtQty.setBounds(150, 180, 150, 30);
        // // allTextFields.add(txtQty);

        // // // Amount Lable
        // // txtAmount = new JLabel("Testng Amount");
        // // //txtAmount.setBounds(150, 220, 150, 30);
        // // allTextFields.add(txtAmount);

        // // add("East",allTextFields);

        // // Place button
        // // btnPlaceOrder = new JButton("Place");
        // // btnPlaceOrder.setBounds(250, 300, 80, 40);
        // // btnPlaceOrder.setBackground(new Color(0, 150, 136)); // Teal color
        // // btnPlaceOrder.setForeground(Color.WHITE); // White text
        // // add(btnPlaceOrder);

        

    }

    // PlaceOrder(String orderId){
    //     this.orderId=orderId;

    // }
}