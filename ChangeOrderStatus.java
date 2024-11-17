import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

class ChangeOrderStatus extends JFrame {

    private JButton btnBack;
    private JButton btnSearch;
    private JButton btnChangeStatus;

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

    ChangeOrderStatus() {

        setSize(500, 500);
        setTitle("Change Order Status");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // back button
        btnBack = new JButton("BACK");
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0, 0, 80, 30);
        add(btnBack);

        // search button
        btnSearch = new JButton("SEARCH");
        btnSearch.setBackground(new Color(4, 203, 201));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(390, 45, 90, 30);
        add(btnSearch);

        // Change Status Button
        btnChangeStatus = new JButton("CHANGE STATUS");
        btnChangeStatus.setFont(new Font("Arial", Font.BOLD, 12));
        btnChangeStatus.setBackground(new Color(135, 193, 255));
        btnChangeStatus.setForeground(Color.WHITE);
        btnChangeStatus.setBounds(320, 400, 150, 30);
        add(btnChangeStatus);

        // Back button Action
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new HomePage();
            }
        });

        lblOrderId = new JLabel("Enter Order ID: ");
        lblOrderId.setFont(new Font("SanSerif", Font.BOLD, 15));
        lblOrderId.setBounds(40, 50, 200, 20);
        add(lblOrderId);

        // enter order id text field
        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("SanSeriif", Font.BOLD, 15));
        txtCustomerId.setBounds(180, 45, 180, 30);
        add(txtCustomerId);

        // Labls ==================
        lblCustomerId = new JLabel("Customer ID: ");
        lblCustomerId.setFont(new Font("SanSerif", Font.BOLD, 15));
        lblCustomerId.setBounds(40, 100, 200, 30);
        add(lblCustomerId);

        lblSize = new JLabel("Size: ");
        lblSize.setFont(new Font("SanSerif", Font.BOLD, 15));
        lblSize.setBounds(40, 150, 200, 30);
        add(lblSize);

        lblQty = new JLabel("QTY: ");
        lblQty.setFont(new Font("SanSerif", Font.BOLD, 15));
        lblQty.setBounds(40, 200, 200, 30);
        add(lblQty);

        lblAmount = new JLabel("Amount: ");
        lblAmount.setFont(new Font("SanSerif", Font.BOLD, 15));
        lblAmount.setBounds(40, 250, 200, 30);
        add(lblAmount);

        lblStatus = new JLabel("Status: ");
        lblStatus.setFont(new Font("SanSerif", Font.BOLD, 15));
        lblStatus.setBounds(40, 300, 200, 30);
        add(lblStatus);

        // retun values labls.............................................
        lblOrderIdShow = new JLabel();
        lblOrderIdShow.setFont(new Font("Arial", Font.BOLD, 15));
        lblOrderIdShow.setBounds(180, 100, 120, 30);
        add(lblOrderIdShow);

        lblSizeShow = new JLabel();
        lblSizeShow.setFont((new Font("Arial", Font.BOLD, 15)));
        lblSizeShow.setBounds(180, 150, 200, 30);
        add(lblSizeShow);

        lblQtyShow = new JLabel();
        lblQtyShow.setFont(new Font("Arial", Font.BOLD, 15));
        lblQtyShow.setBounds(180, 200, 200, 30);
        add(lblQtyShow);

        lblAmountShow = new JLabel();
        lblAmountShow.setFont(new Font("Arial", Font.BOLD, 15));
        lblAmountShow.setBounds(180, 250, 200, 30);
        add(lblAmountShow);

        lblStatusShow = new JLabel();
        lblStatusShow.setFont(new Font("Arial", Font.BOLD, 15));
        lblStatusShow.setBounds(180, 300, 200, 30);
        add(lblStatusShow);

        // search button action
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // FashionShopCustomerDetails
                // f1=customerList.serachOrderId(txtCustomerId.getText());
                // if(f1!=null){
                // lblOrderIdShow.setText(f1.getPhoneNumber());
                // lblSizeShow.setText(f1.getSize());
                // lblQtyShow.setText(String.valueOf(f1.getQuantity()));
                // lblAmountShow.setText(String.valueOf(f1.getAmount()));
                // lblStatusShow.setText(String.valueOf(f1.printOrderStatus()));
                // }else{
                // JOptionPane.showMessageDialog(null,"Invalid Order
                // ID","Error",JOptionPane.ERROR_MESSAGE);
                // }

                String newLine = null;
                try {
                    BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
                    String line = br.readLine();
                    while (line != null) {
                        String id = line.substring(0, 9);
                        if (id.equalsIgnoreCase(txtCustomerId.getText())) {
                            newLine = line;
                            break;
                        }
                        line = br.readLine();
                    }
                } catch (IOException ex) {

                }
                if (newLine != null) {
                    String[] cusDetails = newLine.split(",");
                    lblOrderIdShow.setText(cusDetails[1]);
                    lblSizeShow.setText(cusDetails[2]);
                    lblQtyShow.setText(cusDetails[3]);
                    lblAmountShow.setText(cusDetails[4]);
                    lblStatusShow.setText(cusDetails[5]);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Order ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Change Stataus Button Action
        btnChangeStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // int status = customerList.changeOrderStatus(txtCustomerId.getText());
                String status = null;

                List customerList = new List(10, 0.5);
                try {
                    BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
                    String line = br.readLine();
                    while (line != null) {
                        String[] cusDetails = line.split(",");
                        status = cusDetails[5];
                        line = br.readLine();
                    }
                } catch (IOException ex) {

                }

                if (status.equals("Processing")) {
                    System.out.println(status);
                    Icon qIcon = UIManager.getIcon("JOptionPane.questionIcon");
                    Object[] buttons = { "Delivering", "Delivered" };

                    int selection = JOptionPane.showOptionDialog(
                            null,
                            "Please Select the Status",
                            "Status",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            qIcon,
                            buttons,
                            buttons[0]);
                    switch (selection) {
                        case 0:
                            try {
                                BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
                                String line = br.readLine();
                                while (line != null) {
                                    String[] cusDetails = line.split(",");
                                    if (cusDetails[0].equals(txtCustomerId.getText())) {
                                        String st = "Delivering";
                                        FashionShopCustomerDetails temp = new FashionShopCustomerDetails(cusDetails[0],
                                                cusDetails[1], cusDetails[2], Integer.parseInt(cusDetails[3]),
                                                Double.parseDouble(cusDetails[4]), st);
                                        customerList.add(temp);
                                    } else {
                                        FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(cusDetails[0],
                                                cusDetails[1], cusDetails[2], Integer.parseInt(cusDetails[3]),
                                                Double.parseDouble(cusDetails[4]), cusDetails[5]);
                                        customerList.add(c1);
                                    }
                                    line = br.readLine();
                                }

                                FileWriter fw = new FileWriter("CustomerDetails.txt");
                                for (int i = 0; i < customerList.size(); i++) {
                                    FashionShopCustomerDetails c1 = customerList.get(i);
                                    fw.write(c1.toString() + "\n");
                                }
                                fw.close();
                            } catch (IOException ex) {

                            }
                            // setOrderStatus("Delivering",(txtCustomerId.getText()),customerList);
                            break;
                        case 1:
                            try{
                                BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
                                String line = br.readLine();
                                while(line!=null){
                                    String[] cusDetails = line.split(",");
                                    if(cusDetails[0].equals(txtCustomerId.getText())){
                                        String st = "Delivered";
                                        FashionShopCustomerDetails temp = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),st);
                                        customerList.add(temp);
                                    }else{
                                        FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),cusDetails[5]);
                                        customerList.add(c1);
                                    }
                                    line=br.readLine();
                                }
                                FileWriter fw = new FileWriter("CustomerDetails.txt");
                                for(int i=0; i<customerList.size(); i++){
                                    FashionShopCustomerDetails c1 = customerList.get(i);
                                    fw.write(c1.toString()+"\n");
                                }
                                fw.close();
                            }catch(IOException ex){

                            }
                            // setOrderStatus("Delivered",(txtCustomerId.getText()),customerList);
                            break;
                        default:
                            System.out.println("default");
                            break;
                    }
                } else if (status.equals("Delivering")) {
                    System.out.println(status);
                    Icon qIcon = UIManager.getIcon("JOptionPane.questionIcon");
                    Object[] button = { "Delivered" };

                    int selection = JOptionPane.showOptionDialog(
                            null,
                            "Please select the Status",
                            "Status",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            qIcon,
                            button,
                            button[0]);
                    switch (selection) {
                        case 0:
                            try{
                                BufferedReader br = new BufferedReader(new FileReader("CustomerReader.txt"));
                                String line = br.readLine();
                                while(line!=null){
                                    String[] cusDetails = line.split(",");
                                    if(cusDetails[0].equals(txtCustomerId.getText())){
                                        String st = "Delivered";
                                        FashionShopCustomerDetails temp = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),st);
                                        customerList.add(temp);
                                    }else{
                                        FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),cusDetails[5]);
                                        customerList.add(c1);
                                    }
                                    line = br.readLine();
                                }
                                FileWriter fw = new FileWriter("CustomerDetails.txt");
                                for(int i=0; i<customerList.size(); i++){
                                    FashionShopCustomerDetails c1 = customerList.get(i);
                                    fw.write(c1.toString()+"\n");
                                }
                                fw.close();
                            }catch(IOException ex){

                            }
                            //setOrderStatus("Delivered", (txtCustomerId.getText()), customerList);
                            break;
                        default:
                            System.out.println("Default");
                            break;
                    }
                } else if (status.equals("Delivered")) {
                    System.out.println(status);
                    JOptionPane.showMessageDialog(null, "Cant Change this order status...order already delivered...!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // public void setOrderStatus(String status, String orderId, List customerList) {
    //     FashionShopCustomerDetails[] cusDetails = customerList.getArrayObject();
    //     for (int i = 0; i < customerList.size(); i++) {
    //         if (orderId.equals(cusDetails[i].getOrderId())) {
    //             if (status.equals("Delivering")) {
    //                 cusDetails[i].setOrderStatus("Delivering");
    //                 break;
    //             } else if (status.equals("Delivered")) {
    //                 cusDetails[i].setOrderStatus("Delivered");
    //                 break;
    //             }
    //         }

    //     }
    // }
}
