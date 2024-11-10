import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class viewCustomer extends JFrame{
    private JLabel topic;
    private JButton btnBack;

    viewCustomer(List customerList){
        setSize(800,500);
        setTitle("View Customers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //main topic
        topic = new JLabel("View Customers", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,15));
        topic.setForeground(Color.RED);
        topic.setBounds(0,0,800,30);
        add(topic);

        // back button
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        //back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new ViewReportsOption(customerList).setVisible(true);
            }
        });

        // Table making
        String[] colNames = {"Customer ID","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        FashionShopCustomerDetails[] cus = customerList.viewCustomer();
        for(int i=0; i<customerList.size(); i++){
            if(cus[i]!=null){
                Object[] rowData = {cus[i].getPhoneNumber(),cus[i].getQuantity(),cus[i].getAmount()};
                dtm.addRow(rowData);
            }
            
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(50,50,500,200);
        add(sp);

        
        
    }
    
}
