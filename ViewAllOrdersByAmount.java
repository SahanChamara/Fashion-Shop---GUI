import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ViewAllOrdersByAmount extends JFrame {

    private JLabel topic;
    private JButton btnBack;

    ViewAllOrdersByAmount(){
        setSize(800,400);
        setTitle("All Orders By Amount");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //topic
        topic = new JLabel("View All Orders By Amount", SwingConstants.CENTER);
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
                new ViewReportsOption().setVisible(true);
            }
        });

        // List customerList = new List(10,0.5);
        // try{
        //     BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
        //     String line = br.readLine();
        //     while(line!=null){
        //         String[] cusDetails = line.split(",");
        //         FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),cusDetails[5]);
        //         customerList.add(c1);
        //         line=br.readLine();
        //     }
            

        // }catch(IOException ex){

        // }

        //table
        String[] colNames = {"Order ID","Customer ID","Size","Quantity","Amount","Status"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        try{            
            List customerList = CustomerController.viewCustomer();
            FashionShopCustomerDetails[] cusArray = allOrdersByAmount(customerList);
            for(int i=0; i<customerList.size(); i++){
                Object[] rowData = {cusArray[i].getOrderId(),cusArray[i].getPhoneNumber(),cusArray[i].getSize(),cusArray[i].getQuantity(),cusArray[i].getAmount(),cusArray[i].getOrderStatus()};
                dtm.addRow(rowData);
            }

            JTable cusTable = new JTable(dtm);
            JScrollPane sp = new JScrollPane(cusTable);
            sp.setBounds(100,60,600,300);
            add(sp);
        }catch(IOException ex){

        }
        
        
    }

    // Orders by Amount all orders print
    public FashionShopCustomerDetails[] allOrdersByAmount(List customerList) {
        FashionShopCustomerDetails[] cusDetails = customerList.toArray();

        FashionShopCustomerDetails[] sortingByAmount = new FashionShopCustomerDetails[customerList.size()];
        for (int i = 0; i < customerList.size(); i++) {
            sortingByAmount[i] = cusDetails[i];
        }

        for (int i = customerList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                if (sortingByAmount[j].getAmount() < sortingByAmount[j + 1].getAmount()) {
                    FashionShopCustomerDetails swap = cusDetails[j];
                    sortingByAmount[j] = sortingByAmount[j + 1];
                    sortingByAmount[j + 1] = swap;
                }
        }
        return sortingByAmount;

    }

}
