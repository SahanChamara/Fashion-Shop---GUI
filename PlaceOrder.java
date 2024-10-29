import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class PlaceOrder extends JFrame{
    private JLabel lblPlaceORder;

    private JLabel lblOrderId;
    private JLabel lblPhoneNumber;
    private JLabel lblSize;
    private JLabel lblQty;
    private JLabel lblAmount;

    private JTextField txtOrderId;
    private JTextField txtPhoneNumber;
    private JTextField txtSize;
    private JTextField txtQty;
    private JTextField txtAmount;

    private String orderId;

    private CustomerDetailsHandeler customerDetails;
    
    PlaceOrder(CustomerDetailsHandeler customerDetails){
        this.customerDetails=customerDetails;
        setSize(500,300);
        setTitle("Place Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // makeing the Place Order Topic (Lable)...
        lblPlaceORder = new JLabel("Place Order");
        lblPlaceORder.setFont(new Font("Arial",1,25));
        JPanel lblPlaceOrderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        lblPlaceOrderPanel.add(lblPlaceORder);
        add("North",lblPlaceOrderPanel);

        // making the labls(order id,phone Number,size,qty,amount)
        JPanel allLablsPanel = new JPanel (new GridLayout(5,1,5,5));

        lblOrderId = new JLabel("  Order ID :");
        lblOrderId.setFont(new Font("Arial",1,15));
        allLablsPanel.add(lblOrderId);

        lblPhoneNumber = new JLabel("  Phone Number :");
        lblPhoneNumber.setFont(new Font("Arial",1,15));
        allLablsPanel.add(lblPhoneNumber);

        lblSize = new JLabel("  T-Shiirt Size (XS/S/M/L/XL/XXL) :");
        lblSize.setFont(new Font("Arial",1,15));
        allLablsPanel.add(lblSize);

        lblQty = new JLabel("  Quantiity :");
        lblQty.setFont(new Font("Arial",1,15));
        allLablsPanel.add(lblQty);

        lblAmount = new JLabel("  Amount :");
        lblAmount.setFont(new Font("Arial",1,15));
        allLablsPanel.add(lblAmount);

        add("West",allLablsPanel);

        // Making the Text Fields...
        JPanel allTextFieldPanel = new JPanel(new GridLayout(5,1,5,5));

        txtOrderId = new JTextField(12);
        txtOrderId.setFont(new Font("Arial",1,15));
        JPanel txtOrderIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtOrderIdPanel.add(txtOrderId);

        // set the generate order id into the text field
        txtOrderId.setText(customerDetails.getOrderId());
        allTextFieldPanel.add(txtOrderIdPanel);

        txtPhoneNumber = new JTextField(10);
        txtPhoneNumber.setFont(new Font("Arial",1,15));
        JPanel txtPhoneNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtPhoneNumberPanel.add(txtPhoneNumber);
        allTextFieldPanel.add(txtPhoneNumberPanel);

        txtSize = new JTextField(5);
        txtSize.setFont(new Font("Arial",1,15));
        JPanel txtSizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSizePanel.add(txtSize);
        allTextFieldPanel.add(txtSizePanel);

        txtQty = new JTextField(10);
        txtQty.setFont(new Font("Arial",1,15));
        JPanel txtQtyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtQtyPanel.add(txtQty);
        allTextFieldPanel.add(txtQtyPanel);

        txtAmount = new JTextField(10);
        txtAmount.setFont(new Font("Arial",1,15));
        JPanel txtAmountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtAmountPanel.add(txtAmount);
        allTextFieldPanel.add(txtAmountPanel);

        add("Center",allTextFieldPanel);

    }

    PlaceOrder(String orderId){
        this.orderId=orderId;

    }
}