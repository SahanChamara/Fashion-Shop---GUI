import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class SearchCustomer extends JFrame {
    private JLabel lblCustomerId;

    private JTextField txtCustomerId;

    private JButton btnBack;
    private JButton btnSearch;

    private CustomerDetailsHandeler customerDetails;

    SearchCustomer(CustomerDetailsHandeler customerDetails){
        this.customerDetails=customerDetails;

        setSize(400,400);
        setTitle("Search Customer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Back Button
        btnBack = new JButton("BACK");
        btnBack.setBounds(10,10,80,30);
        btnBack.setBackground(new Color(240,128,128));
        btnBack.setForeground(Color.WHITE);
        add(btnBack);

        // Customer ID Lable 
        lblCustomerId = new JLabel("Enter Customer ID: ");
        lblCustomerId.setFont(new Font("sanSerif",Font.BOLD,15));
        lblCustomerId.setBounds(50,50,200,30);
        add(lblCustomerId);

        //Customer ID Text Field (Phone Number)
        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("sanSerif",Font.PLAIN,15));
        txtCustomerId.setBounds(150,50,100,30);
        add(txtCustomerId);

        //Search Button
        btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(280,50,100,25);
        btnSearch.setBackground(new Color(240,128,128));
        btnSearch.setForeground(Color.BLACK);
        add(btnSearch);

    }
    
}
