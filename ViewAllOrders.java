import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class ViewAllOrders extends JFrame {
    private List customerList;
    private JLabel topic;
    private JButton btnBack;

    ViewAllOrders(List customerList){
        this.customerList=customerList;

        setSize(800,400);
        setTitle("Item By Amount");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //topic
        topic = new JLabel("View All Orders", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,15));
        topic.setForeground(Color.RED);
        topic.setBounds(0,0,800,30);
        add(topic);

        //back button
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,35,80,30);
        add(btnBack);

        //back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new ViewReportsOption(customerList).setVisible(true);
            }
        });

        //table
        String[] colNames = {"Order ID","Customer ID","Size","Quantity","Amount","Status"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        FashionShopCustomerDetails[] cusArray = customerList.getObject();
        for(int i=customerList.size()-1; i>=0; i--){
            Object[] rowData = {cusArray[i].getOrderId(),cusArray[i].getPhoneNumber(),cusArray[i].getSize(),cusArray[i].getQuantity(),cusArray[i].getAmount(),cusArray[i].printOrderStatus()};
            dtm.addRow(rowData);
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(100,60,600,300);
        add(sp);
        

    }
    
}
