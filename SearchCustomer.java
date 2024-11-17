import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class SearchCustomer extends JFrame {
    private JLabel lblCustomerId;
    private JLabel lbltotal;
    private JLabel lbltotalView;

    private JTextField txtCustomerId;

    private JButton btnBack;
    private JButton btnSearch;

    // private int tempMedium;
    // private int tempXtraSmall;
    // private int tempXtraXl;
    // private int tempXtraLarge;
    // private int tempSmall;
    // private int tempLarge;

    // private double mediumAmount;
    // private double xtraLargeAmount;
    // private double xtraxXlAmount;
    // private double xtraSmallAmount;
    // private double smallAmount;
    // private double largeAmount;
    // private double searchTotalAmount;

    // private boolean numbervalid;

    SearchCustomer() {
        
        //numbervalid=false;

        setSize(500, 400);
        setTitle("Search Customer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Back Button
        btnBack = new JButton("BACK");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.setBackground(new Color(240, 128, 128));
        btnBack.setForeground(Color.WHITE);
        add(btnBack);

        // Back button action
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new SearchingOption();
            }
        });

        // Customer ID Lable
        lblCustomerId = new JLabel("Enter Customer ID: ");
        lblCustomerId.setFont(new Font("sanSerif", Font.BOLD, 12));
        lblCustomerId.setBounds(50, 50, 200, 30);
        add(lblCustomerId);

        // Customer ID Text Field (Phone Number)
        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("sanSerif", Font.PLAIN, 12));
        txtCustomerId.setBounds(180, 55, 120, 22);
        add(txtCustomerId);

        // Total Label
        lbltotal = new JLabel("Total :");
        lbltotal.setFont(new Font("Arial", Font.BOLD, 15));
        lbltotal.setBounds(50, 300, 70, 30);
        ;
        add(lbltotal);

        // total view lable
        lbltotalView = new JLabel("");
        lbltotalView.setFont(new Font("Arial", Font.BOLD, 15));
        lbltotalView.setBounds(200, 300, 70, 30);

        // Search Button
        btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(350, 55, 90, 20);
        btnSearch.setBackground(new Color(240, 128, 128));
        btnSearch.setForeground(Color.BLACK);
        add(btnSearch);

        // ID validation and printing the table
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //String cusPhoneNumber = txtCustomerId.getText();

                // try {
                //     BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
                //     String line = br.readLine();
                //     while (line != null) {
                //         String phoneNum = line.substring(10, 20);
                //         if (cusPhoneNumber.equals(phoneNum)) {
                //             numbervalid=true;
                //             String[] cusDetails = line.split(",");

                //             serachCustomerId(cusDetails[0], cusDetails[2], Integer.parseInt(cusDetails[3]));
                //         }
                //         line=br.readLine();
                //     }
                // } catch (IOException ex) {

                // }

                // CustomerController cusControll = new CustomerController();

                txtCustomerIdActionPerformed(evt);

                // serachCustomerId(txtCustomerId.getText());
                // if (cusControll.getNumberValid() == false) {
                //     Object[][] customerData = {
                //             { "L", cusControll.getLarge(), cusControll.getLargeAmount() },
                //             { "M", cusControll.getMedium(), cusControll.getMediumAmount() },
                //             { "XS", cusControll.getXtraSmall(), cusControll.getXtraSmallAmount() },
                //             { "S", cusControll.getSmall(), cusControll.getSmallAmount() },
                //             { "XL", cusControll.getXtraLarge(), cusControll.getXtraLargeAmount() },
                //             { "XXL", cusControll.getXtraXl(), cusControll.getXtraXlAmount() },
                //     };

                //     String[] colNames = { "Size", "Quantiity", "Amount" };

                //     JTable cusDetails = new JTable(customerData, colNames);

                //     // center the table values
                //     DefaultTableCellRenderer centerValues = new DefaultTableCellRenderer();
                //     centerValues.setHorizontalAlignment(SwingConstants.CENTER);
                //     for (int i = 0; i < cusDetails.getColumnCount(); i++) {
                //         cusDetails.getColumnModel().getColumn(i).setCellRenderer(centerValues);
                //     }

                //     JScrollPane scrollPane = new JScrollPane(cusDetails);
                //     scrollPane.setBounds(50, 100, 400, 100);
                //     add(scrollPane);

                //     lbltotalView.setText(String.valueOf(cusControll.getSearchTotalAmount()));

                //     cusControll.tempCountUpdate();

                // } else {
                //     JOptionPane.showMessageDialog(null, "Invalid Customer ID");
                // }
            }
        });
    }

    // txtcus id action perforemd
    private void txtCustomerIdActionPerformed(ActionEvent evt){
        CustomerController cusControll = new CustomerController();
        try{
            cusControll.searchCustomer(txtCustomerId.getText());

            if (cusControll.getNumberValid() == true) {
                Object[][] customerData = {
                        { "L", cusControll.getLarge(), cusControll.getLargeAmount() },
                        { "M", cusControll.getMedium(), cusControll.getMediumAmount() },
                        { "XS", cusControll.getXtraSmall(), cusControll.getXtraSmallAmount() },
                        { "S", cusControll.getSmall(), cusControll.getSmallAmount() },
                        { "XL", cusControll.getXtraLarge(), cusControll.getXtraLargeAmount() },
                        { "XXL", cusControll.getXtraXl(), cusControll.getXtraXlAmount() },
                };

                String[] colNames = { "Size", "Quantiity", "Amount" };

                JTable cusDetails = new JTable(customerData, colNames);

                // center the table values
                DefaultTableCellRenderer centerValues = new DefaultTableCellRenderer();
                centerValues.setHorizontalAlignment(SwingConstants.CENTER);
                for (int i = 0; i < cusDetails.getColumnCount(); i++) {
                    cusDetails.getColumnModel().getColumn(i).setCellRenderer(centerValues);
                }

                JScrollPane scrollPane = new JScrollPane(cusDetails);
                scrollPane.setBounds(50, 100, 400, 100);
                add(scrollPane);

                lbltotalView.setText(String.valueOf(cusControll.getSearchTotalAmount()));

                cusControll.tempCountUpdate();

            } else {
                JOptionPane.showMessageDialog(null, "Invalid Customer ID");
            }
           
        }catch(IOException ex){

        }
    }


    // // serarch by custoemer id...................
    // public void searchCustomerId(String cusEnterPhonenum, String cusSize, int qty) {
    //     // numbervalid = false;

    //     if (cusSize.equals("M")) {
    //         tempMedium += qty;
    //     } else if (cusSize.equals("XS")) {
    //         tempXtraSmall += qty;
    //     } else if (cusSize.equals("XXL")) {
    //         tempXtraXl += qty;
    //     } else if (cusSize.equals("XL")) {
    //         tempXtraLarge += qty;
    //     } else if (cusSize.equals("S")) {
    //         tempSmall += qty;
    //     } else if (cusSize.equals("L")) {
    //         tempLarge += qty;
    //     }
    //     tempAmountCalculation();

    // }

    // public boolean getNumberValid() {
    //     return this.numbervalid;
    // }

    // public void tempAmountCalculation() {
    //     mediumAmount = tempMedium * 900;
    //     xtraLargeAmount = tempXtraLarge * 1100;
    //     xtraxXlAmount = tempXtraXl * 1200;
    //     xtraSmallAmount = tempXtraSmall * 600;
    //     smallAmount = tempSmall * 800;
    //     largeAmount = tempLarge * 1000;
    //     searchTotalAmount = mediumAmount + xtraLargeAmount + xtraxXlAmount + xtraSmallAmount + smallAmount
    //             + largeAmount;
    // }

    // public int getMedium() {
    //     return this.tempMedium;
    // }

    // public int getXtraSmall() {
    //     return this.tempXtraSmall;
    // }

    // public int getXtraXl() {
    //     return this.tempXtraXl;
    // }

    // public int getXtraLarge() {
    //     return this.tempXtraLarge;
    // }

    // public int getSmall() {
    //     return this.tempSmall;
    // }

    // public int getLarge() {
    //     return this.tempLarge;
    // }

    // // amount getters
    // public double getMediumAmount() {
    //     return this.mediumAmount;
    // }

    // public double getXtraLargeAmount() {
    //     return this.xtraLargeAmount;
    // }

    // public double getXtraXlAmount() {
    //     return this.xtraxXlAmount;
    // }

    // public double getXtraSmallAmount() {
    //     return this.xtraSmallAmount;
    // }

    // public double getSmallAmount() {
    //     return this.smallAmount;
    // }

    // public double getLargeAmount() {
    //     return this.largeAmount;
    // }

    // public double getSearchTotalAmount() {
    //     return this.searchTotalAmount;
    // }

    // public void tempCountUpdate() {
    //     this.tempMedium = 0;
    //     this.tempXtraLarge = 0;
    //     this.tempXtraXl = 0;
    //     this.tempXtraSmall = 0;
    //     this.tempSmall = 0;
    //     this.tempLarge = 0;
    // }

}
