import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class AllCustomersView extends JFrame {
    private CustomerDetailsHandeler customerDetails;

    private JLabel topic;
    private JButton btnBack;

    AllCustomersView(CustomerDetailsHandeler customerDetails){
        this.customerDetails=customerDetails;

        setSize(1000,600);
        setTitle("All Customer Reports");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // topic
        topic = new JLabel("All Customer Reports", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,25));
        topic.setForeground(Color.ORANGE);
        topic.setBounds(0,0,1000,30);
        add(topic);

        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,35,80,30);
        add(btnBack);

        // back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new ViewReportsOption(customerDetails).setVisible(true);
            }
        });

        // Table 
        String[] colNames = {"Customer ID","XS","S","M","L","XL","XXL","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        AllCustomers[] allCus = customerDetails.allCustomersReport();
        for(int i=0; i<allCus.length; i++){
            if(allCus[i].getPhoneNumber()!=null){
                Object[] rowData = {allCus[i].getPhoneNumber(),allCus[i].getXtraSamll(),allCus[i].getSmall(),allCus[i].getMediumSize(),allCus[i].getLarge(),allCus[i].getXtraLarge(),allCus[i].getXtraXl(),allCus[i].getAmount()};
                dtm.addRow(rowData);
            }
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(100,100,800,400);
        add(sp);

    }
    
}
