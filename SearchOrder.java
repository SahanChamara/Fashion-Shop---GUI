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
    private JLabel lblCustomerIdShow;
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

        btnBack = new JButton("BACK");
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        lblOrderId = new JLabel("Enter Order ID: ");
        lblOrderId.setFont(new Font("SanSerif",Font.BOLD,15));
        lblOrderId.setBounds(40,50,200,20);
        add(lblOrderId);

        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("SanSeriif",Font.BOLD,15));
        txtCustomerId.setBounds(180,45,180,30);
        add(txtCustomerId);

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

        // retun values labls
        
            


    }

}
