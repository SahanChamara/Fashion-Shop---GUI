import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteOrder extends JFrame {
    private CustomerDetailsHandeler customerDetails;

    private JButton btnBack;
    private JButton btnSearch;
    private JButton btnDelete;

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

    DeleteOrder(CustomerDetailsHandeler customerDetails){
        setSize(500,500);
        setTitle("Delete Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // back button
        btnBack = new JButton("BACK");
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        // search button
        btnSearch = new JButton("SEARCH");
        btnSearch.setBackground(new Color(4,203,201));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(390,45,90,30);
        add(btnSearch);

        //Delete Button
        btnDelete = new JButton("DELETE");
        btnDelete.setFont(new Font("Arial",Font.BOLD,15));
        btnDelete.setBackground(new Color(153,51,0));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBounds(380,400,100,30);
        add(btnDelete);

        //Back button Action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new HomePage(customerDetails);
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
        lblOrderIdShow = new JLabel();
        lblOrderIdShow.setFont(new Font("Arial",Font.BOLD,15));
        lblOrderIdShow.setBounds(180,100,120,30);
        add(lblOrderIdShow);

        lblSizeShow = new JLabel();
        lblSizeShow.setFont((new Font("Arial",Font.BOLD,15)));
        lblSizeShow.setBounds(180,150,200,30);
        add(lblSizeShow);

        lblQtyShow = new JLabel();
        lblQtyShow.setFont(new Font("Arial",Font.BOLD,15));
        lblQtyShow.setBounds(180,200,200,30);
        add(lblQtyShow);

        lblAmountShow = new JLabel();
        lblAmountShow.setFont(new Font("Arial",Font.BOLD,15));
        lblAmountShow.setBounds(180,250,200,30);
        add(lblAmountShow);

        lblStatusShow = new JLabel();
        lblStatusShow.setFont(new Font("Arial",Font.BOLD,15));
        lblStatusShow.setBounds(180,300,200,30);
        add(lblStatusShow);

        // search button action
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                FashionShopCustomerDetails f1=customerDetails.serachOrderId(txtCustomerId.getText());
                if(f1!=null){
                    lblOrderIdShow.setText(f1.getPhoneNumber());
                    lblSizeShow.setText(f1.getSize());
                    lblQtyShow.setText(String.valueOf(f1.getQuantity()));
                    lblAmountShow.setText(String.valueOf(f1.getAmount()));
                    lblStatusShow.setText(String.valueOf(f1.getOrderStatus()));
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Order ID","Error",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

        // Delete Button Action
        btnDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                boolean isDelete = customerDetails.deleteOrder(txtCustomerId.getText());
                if(isDelete){
                    JOptionPane.showMessageDialog(null,"Order Delete Succesfull","Delete Order",JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });
    }
    
}
