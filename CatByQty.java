import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class CatByQty extends JFrame {
    private List customerList;
    private JLabel topic;
    private JButton btnBack;

    CatByQty(List customerList){
        this.customerList=customerList;

        setSize(500,500);
        setTitle("Item By QTY");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //topic
        topic = new JLabel("Best selling categories sorted by quantity", SwingConstants.CENTER);
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
                new ViewReportsOption(customerList).setVisible(true);
            }
        });

        // table
        String[] colNames = {"Size","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Sorting[] sortQty = customerList.sortByQty();
        for(int i=0; i<sortQty.length; i++){
            Object[] rowData = {sortQty[i].getSize(),sortQty[i].getQuantity(),sortQty[i].getAmount()};
            dtm.addRow(rowData);
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(100,100,300,200);
        add(sp);
    }
    
}
