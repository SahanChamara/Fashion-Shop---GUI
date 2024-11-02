import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class CatByAmount extends JFrame {
    private CustomerDetailsHandeler customerDetails;
    private JLabel topic;
    private JButton btnBack;

    CatByAmount(CustomerDetailsHandeler customerDetails){
        this.customerDetails=customerDetails;

        setSize(500,500);
        setTitle("Item By Amount");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //topic
        topic = new JLabel("Best selling categories sorted by Amount", SwingConstants.CENTER);
        topic.setFont(new Font("Arial",Font.BOLD,15));
        topic.setForeground(Color.RED);
        topic.setBounds(0,0,500,30);
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
                new ViewReportsOption(customerDetails).setVisible(true);
            }
        });

        // table
        String[] colNames = {"Size","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Sorting[] sortAmount = customerDetails.sortByAmount();
        for(int i=0; i<sortAmount.length; i++){
            Object[] rowData = {sortAmount[i].getSize(),sortAmount[i].getQuantity(),sortAmount[i].getAmount()};
            dtm.addRow(rowData);
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(100,100,300,200);
        add(sp);

    }

    
}
