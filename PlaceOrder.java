import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class PlaceOrder extends JFrame {
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

    private boolean isNumber;
    private boolean isSize;
    private boolean isQty;

    private double amount;

    // private String orderId;

    // Default Construcotr
    PlaceOrder() {

        setSize(400, 400);
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

        // Back Button Action
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new HomePage().setVisible(true);
            }
        });

        // Order ID label
        lblOrderId = new JLabel("Order ID :");
        lblOrderId.setBounds(50, 60, 100, 30);
        lblOrderId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblOrderId);

        // Order ID value label
        lblOrderIdValue = new JLabel();

        // set the generating order id
        lblOrderIdValue.setText(generateOrderId());
        lblOrderIdValue.setBounds(150, 60, 200, 30);
        lblOrderIdValue.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblOrderIdValue);

        // Customer ID label
        lblCustomerId = new JLabel("Customer ID :");
        lblCustomerId.setBounds(50, 100, 100, 30);
        lblCustomerId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblCustomerId);

        // Customer ID text field
        txtCustomerId = new JTextField();
        txtCustomerId.setBounds(150, 100, 150, 30);
        // Customer ID Validation
        txtCustomerId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // retun the user input phone number to validation method
                isNumber = phoneNumber(txtCustomerId.getText());
                if (!isNumber) {                    
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number");
                }
            }
        });
        add(txtCustomerId);

        // Size label
        lblSize = new JLabel("Size :");
        lblSize.setBounds(50, 140, 100, 30);
        lblSize.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblSize);

        // Size text field
        txtSize = new JTextField();
        txtSize.setBounds(150, 140, 150, 30);

        // Size Validation
        txtSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // reutn the user input size into validation method
                isSize = tShirtSizeValidation(txtSize.getText());
                if (!isSize) {
                    JOptionPane.showMessageDialog(null, "Invalid Size");
                }
            }
        });
        add(txtSize);

        // Size hint label
        lblSizeHint = new JLabel("(XS/S/M/L/XL/XXL)");
        lblSizeHint.setBounds(299, 140, 100, 30);
        lblSizeHint.setFont(new Font("SansSerif", Font.BOLD, 9));
        add(lblSizeHint);

        // Quantity label
        lblQty = new JLabel("QTY :");
        lblQty.setBounds(50, 180, 100, 30);
        lblQty.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblQty);

        // Quantity text field
        txtQty = new JTextField();
        txtQty.setBounds(150, 180, 150, 30);

        // Amount label and text field
        lblAmount = new JLabel("Amount :");
        lblAmount.setBounds(50, 220, 100, 30);
        lblAmount.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblAmount);

        txtAmount = new JLabel("0.00");
        txtAmount.setBounds(150, 220, 150, 30);
        add(txtAmount);

        // Quantity Validation
        txtQty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                isQty =quantityValidation(txtQty.getText());
                if (!isQty) {
                    JOptionPane.showMessageDialog(null, "Quantity is Not Valid");
                } else {
                    amount = amountCalculation(txtQty.getText(), txtSize.getText());
                    txtAmount.setText(String.valueOf(amount));
                }
            }
        });
        add(txtQty);

        // Place button
        btnPlaceOrder = new JButton("Place");
        btnPlaceOrder.setBounds(250, 280, 80, 40);
        btnPlaceOrder.setBackground(new Color(0, 150, 136)); // Teal color
        btnPlaceOrder.setForeground(Color.WHITE); // White text
        btnPlaceOrder.setFont(new Font("SansSerif", Font.BOLD, 14));

        // Place Order Action
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // double amount =
                amountCalculation(txtQty.getText(), txtSize.getText());
                txtAmount.setText(String.valueOf(amount));

                if ((isNumber) && (isSize) && (isQty)) {
                    JOptionPane.showMessageDialog(null, "Order Place Succesfull");

                    String orderId = lblOrderIdValue.getText();
                    String phoneNumber = txtCustomerId.getText();
                    String size = txtSize.getText();
                    int qty = Integer.parseInt(txtQty.getText());
                    int orderStatus = 0;

                    // FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(orderId, phoneNumber, size, qty,amount,orderStatus);
                    // customerList.add(c1);

                    // order details writing for the text file
                    try{
                        FileWriter fw = new FileWriter("CustomerDetails.txt",true);
                        fw.write(orderId+","+phoneNumber+","+size+","+qty+","+amount+","+orderStatus+"\n");
                        fw.close();     // or you can write fw.flush();
                    }catch(IOException ex){

                    }                   

                    //generateOrderId();
                    //customerList.orderNumber++;
                    dispose();
                    new PlaceOrder().setVisible(true);

                    //System.out.println(c1.toString());
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Order Place UN Successful");
                }
            }
        });
        add(btnPlaceOrder);
    }

    // generating the order id
    private String generateOrderId(){
        String lastLine = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
            String line = br.readLine();
            while(line!=null){
                lastLine=line;
                line = br.readLine();
            }
        }catch(IOException ex){

        }
        if(lastLine==null){            
            return "ODR#00001";            
        }else{            
            int newId = Integer.parseInt(lastLine.substring(4,9));
            return String.format("ODR#%05d",newId+1);
            
        }

    }

     // Phone Number Validation
     public boolean phoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10 || phoneNumber.charAt(0) != '0') {
            return false;
        }
        return true;
    }

    // T-Shirt Size Validatiob
    public boolean tShirtSizeValidation(String tShirtSize) {
        tShirtSize = tShirtSize.toUpperCase();
        if (tShirtSize.equals("XS") || tShirtSize.equals("S") || tShirtSize.equals("M")
                || tShirtSize.equals("L") || tShirtSize.equals("XL")
                || tShirtSize.equals("XXL")) {
            return true;
        } else {
            return false;
        }

    }

     // Quantiity Validation
     public boolean quantityValidation(String qty) {
        if (Integer.parseInt(qty) > 0) {
            return true;
        } else {
            return false;
        }

    }

    // Amount Calculation
    public double amountCalculation(String qty, String tShirtSize) {
        tShirtSize = tShirtSize.toUpperCase();

        double amount = 0;
        int quantiity = Integer.parseInt(qty);
        switch (tShirtSize) {
            case "XS":
                amount = quantiity * 600;
                break;
            case "S":
                amount = quantiity * 800;
                break;
            case "M":
                amount = quantiity * 900;
                break;
            case "L":
                amount = quantiity * 1000;
                break;
            case "XL":
                amount = quantiity * 1100;
                break;
            case "XXL":
                amount = quantiity * 1200;
                break;

        }
        return amount;

    }
}