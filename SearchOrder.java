import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchOrder extends JFrame {

    private CustomerDetailsHandeler customerDetails;

    private JButton btnBack;
    private JButton btnSearch;

    private JTextField txtCustomerId;

    private JLabel lblOrderId;
    private JLabel lblCustomerId;
    private JLabel lblSize;
    private JLabel lblQty;
    private JLabel lblAmount;
    private JLabel lblStatus;

    private JLabel lblOrderIdShow;   
    private JLabel lblSizeShow;
    private JLabel lblQtyShow;
    private JLabel lblAmountShow;
    private JLabel lblStatusShow;

    SearchOrder(CustomerDetailsHandeler customerDetails){
        setSize(500,500);
        setTitle("Search Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // back button
        btnBack = new JButton("BACK");
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        //Back button Action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new SearchingOption(customerDetails);
            }
        });

        lblOrderId = new JLabel("Enter Order ID: ");
        lblOrderId.setFont(new Font("SanSerif",Font.BOLD,15));
        lblOrderId.setBounds(40,50,200,20);
        add(lblOrderId);

        // enter order id text field
        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("SanSeriif",Font.BOLD,15));
        txtCustomerId.setBounds(180,45,180,30);
        add(txtCustomerId);

        // serach button
        btnSearch = new JButton("SEARCH");
        btnSearch.setBackground(new Color(4,203,201));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(390,45,90,30);
        add(btnSearch);
        
        // Labls ==================
        lblCustomerId = new JLabel("Customer ID: ");
        lblCustomerId.setFont(new Font("SanSerif",Font.BOLD,15));
        lblCustomerId.setBounds(40,100,200,30);
        add(lblCustomerId);

        lblSize = new JLabel("Size: ");
        lblSize.setFont(new Font("SanSerif",Font.BOLD,15));
        lblSize.setBounds(40,150,200,30);
        add(lblSize);

        lblQty = new JLabel("QTY: ");       
        lblQty.setFont(new Font("SanSerif",Font.BOLD,15));
        lblQty.setBounds(40,200,200,30);
        add(lblQty);

        lblAmount = new JLabel("Amount: ");
        lblAmount.setFont(new Font("SanSerif",Font.BOLD,15));
        lblAmount.setBounds(40,250,200,30);
        add(lblAmount);

        lblStatus = new JLabel("Status: ");
        lblStatus.setFont(new Font("SanSerif",Font.BOLD,15));
        lblStatus.setBounds(40,300,200,30);
        add(lblStatus);

        // retun values labls.............................................
        lblOrderIdShow = new JLabel("Test");
        lblOrderIdShow.setFont(new Font("Arial",Font.BOLD,15));
        lblOrderIdShow.setBounds(180,100,120,30);
        add(lblOrderIdShow);

        lblSizeShow = new JLabel("Test2");
        lblSizeShow.setFont((new Font("Arial",Font.BOLD,15)));
        lblSizeShow.setBounds(180,150,200,30);
        add(lblSizeShow);

        lblQtyShow = new JLabel("Test3");
        lblQtyShow.setFont(new Font("Arial",Font.BOLD,15));
        lblQtyShow.setBounds(180,200,200,30);
        add(lblQtyShow);

        lblAmountShow = new JLabel("Test4");
        lblAmountShow.setFont(new Font("Arial",Font.BOLD,15));
        lblAmountShow.setBounds(180,250,200,30);
        add(lblAmountShow);

        lblStatusShow = new JLabel("Test5");
        lblStatusShow.setFont(new Font("Arial",Font.BOLD,15));
        lblStatusShow.setBounds(180,300,200,30);
        add(lblStatusShow);

        // search button action
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                FashionShopCustomerDetails f1=customerDetails.serachOrderId(txtCustomerId.getText());
                lblOrderIdShow.setText(f1.getPhoneNumber());
                lblSizeShow.setText(f1.getSize());
                lblQtyShow.setText(String.valueOf(f1.getQuantity()));
                lblAmountShow.setText(String.valueOf(f1.getAmount()));
                lblStatusShow.setText(String.valueOf(f1.getOrderStatus()));
                
                // JOptionPane.showConfirmDialog(rootPane, "Do you want serach another customer", ABORT);

            }
        });
    }

}
