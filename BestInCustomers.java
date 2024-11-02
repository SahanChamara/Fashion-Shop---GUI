import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class BestInCustomers extends JFrame {
    private JButton btnBack;
    private JLabel topic;

    private CustomerDetailsHandeler customerDetails;

    BestInCustomers(CustomerDetailsHandeler customerDetails){
        this.customerDetails=customerDetails;

        setSize(800,500);
        setTitle("Best In Customers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // main topic
        topic = new JLabel("BEST IN CUSTOMERS", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,15));
        topic.setForeground(Color.BLUE);
        topic.setBounds(0,0,800,30);
        add(topic);

        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        // back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new HomePage(customerDetails);
            }
        });

        // making the table
        String[] colNames = {"Customer ID","Quantity","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        FashionShopCustomerDetails[] bInCus=customerDetails.bestInCusSort();
        for(int i=0; i<bInCus.length; i++){
            if(bInCus[i]!=null){
                if(bInCus[i].getQuantity()!=0){
                    Object[] rowData = {bInCus[i].getPhoneNumber(),bInCus[i].getQuantity(),bInCus[i].getAmount()};
                    dtm.addRow(rowData);
                }
            }
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(70,60,600,150);        
        add(sp);

    }
    
}
