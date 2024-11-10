import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class SearchCustomer extends JFrame {
    private JLabel lblCustomerId;
    private JLabel lbltotal;
    private JLabel lbltotalView;

    private JTextField txtCustomerId;

    private JButton btnBack;
    private JButton btnSearch;    

    private List customerList;

    SearchCustomer(List customerList){
        this.customerList=customerList;

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
                new SearchingOption(customerList);
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

        //Total Label
        lbltotal = new JLabel("Total :");
        lbltotal.setFont(new Font("Arial",Font.BOLD,15));
        lbltotal.setBounds(50,300,70,30);;
        add(lbltotal);

        // total view lable
        lbltotalView = new JLabel("");
        lbltotalView.setFont(new Font("Arial",Font.BOLD,15));
        lbltotalView.setBounds(200,300,70,30);

        //Search Button
        btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(350,55,90,20);
        btnSearch.setBackground(new Color(240,128,128));
        btnSearch.setForeground(Color.BLACK);
        add(btnSearch);

        //ID validation and printing the table
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){                
                customerList.serachCustomerId(txtCustomerId.getText());
                if(customerList.getNumberValid()==true){                                    
                    Object[][] customerData = {
                        {"L",customerList.getLarge(),customerList.getLargeAmount()},
                        {"M",customerList.getMedium(),customerList.getMediumAmount()},
                        {"XS",customerList.getXtraSmall(),customerList.getXtraSmallAmount()},
                        {"S",customerList.getSmall(),customerList.getSmallAmount()},
                        {"XL",customerList.getXtraLarge(),customerList.getXtraLargeAmount()},
                        {"XXL",customerList.getXtraXl(),customerList.getXtraXlAmount()},
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

                    lbltotalView.setText(String.valueOf(customerList.getSearchTotalAmount()));

                    customerList.tempCountUpdate();
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Customer ID");
                }              
            }
        });
    }
    
}
