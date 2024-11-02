import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
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

        setSize(500,400);
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

        // Back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new SearchingOption(customerDetails);
            }
        });

        // Customer ID Lable 
        lblCustomerId = new JLabel("Enter Customer ID: ");
        lblCustomerId.setFont(new Font("sanSerif",Font.BOLD,12));
        lblCustomerId.setBounds(50,50,200,30);
        add(lblCustomerId);

        //Customer ID Text Field (Phone Number)
        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("sanSerif",Font.PLAIN,12));
        txtCustomerId.setBounds(180,55,120,22);
        add(txtCustomerId);

        //Search Button
        btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(350,55,90,20);
        btnSearch.setBackground(new Color(240,128,128));
        btnSearch.setForeground(Color.BLACK);

        // ID validation and printing the table
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){                
                customerDetails.serachCustomerId(txtCustomerId.getText());
                if(customerDetails.getNumberValid()==true){                                    
                    Object[][] customerData = {
                        {"L",customerDetails.getLarge(),customerDetails.getLargeAmount()},
                        {"M",customerDetails.getMedium(),customerDetails.getMediumAmount()},
                        {"XS",customerDetails.getXtraSmall(),customerDetails.getXtraSmallAmount()},
                        {"S",customerDetails.getSmall(),customerDetails.getSmallAmount()},
                        {"XL",customerDetails.getXtraLarge(),customerDetails.getXtraLargeAmount()},
                        {"XXL",customerDetails.getXtraXl(),customerDetails.getXtraXlAmount()},
                    };
            
                    String [] colNames = {"Size","Quantiity","Amount"};
            
                    JTable cusDetails = new JTable(customerData,colNames);
            
                    //center the table values
                    DefaultTableCellRenderer centerValues = new DefaultTableCellRenderer();
                    centerValues.setHorizontalAlignment(SwingConstants.CENTER);
                    for (int i = 0; i < cusDetails.getColumnCount(); i++) {
                        cusDetails.getColumnModel().getColumn(i).setCellRenderer(centerValues);
                    }
            
                    JScrollPane scrollPane = new JScrollPane(cusDetails);
                    scrollPane.setBounds(50,100,400,100);
                    add(scrollPane);

                    customerDetails.tempCountUpdate();
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Customer ID");
                }              
            }
        });
        add(btnSearch);
    }
    
}
