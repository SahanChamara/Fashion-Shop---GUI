import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class HomePage extends JFrame {
    private JLabel mainTopic;

    private JButton btnPlaceOrder;
    private JButton btnSearch;
    // private JButton btnSearchOrder;
    private JButton btnViewReports;
    private JButton btnSetOrderStatus;
    private JButton btnDeleteOrder;

    private CustomerDetailsHandeler customerDetails;

    HomePage(CustomerDetailsHandeler customerDetails) {
        this.customerDetails = customerDetails;

        setSize(500, 500);
        setTitle("Fashion Shop Customer Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title label
        mainTopic = new JLabel("Fashion Shop", SwingConstants.CENTER);
        mainTopic.setBounds(0, 20, 500, 50);
        mainTopic.setOpaque(true);
        mainTopic.setBackground(new Color(33, 150, 243)); // Blue background color
        mainTopic.setForeground(Color.WHITE); // White text color
        mainTopic.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(mainTopic);

        // NEw panel for the buttons
        JPanel centerPanel = new JPanel(null);
        centerPanel.setPreferredSize(new Dimension(500,400));

        // Buttons
        btnSearch = new JButton("Search");
        btnSearch.setBounds(100, 100, 200, 40);
        centerPanel.add(btnSearch);

        // serach button action
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new SearchingOption(customerDetails);
            }
        });

        btnSetOrderStatus = new JButton("Status");
        btnSetOrderStatus.setBounds(100, 160, 200, 40);
        centerPanel.add(btnSetOrderStatus);

        btnViewReports = new JButton("Reports");
        btnViewReports.setBounds(100, 220, 200, 40);
        centerPanel.add(btnViewReports);

        btnDeleteOrder = new JButton("Delete");
        btnDeleteOrder.setBounds(100, 280, 200, 40);
        centerPanel.add(btnDeleteOrder);

        // Place Order button
        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setBounds(100, 360, 200, 50);
        btnPlaceOrder.setBackground(new Color(0, 200, 200)); // Custom color for the button
        btnPlaceOrder.setForeground(Color.WHITE); // White text color

        // add action in place oreder
        btnPlaceOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){                    
                // customerDetails.incrementOid();
                new PlaceOrder(customerDetails).setVisible(true);                                      
                
            }
        });
        centerPanel.add(btnPlaceOrder);

        // Image label
        ImageIcon fashionImage = new ImageIcon("Image\\Fashion_Shop.png"); // Replace with your image path
        JLabel imageLabel = new JLabel(fashionImage);
        imageLabel.setBounds(320, 100, 200, 350); // Position image on the right
        centerPanel.add(imageLabel);

        add(centerPanel,BorderLayout.CENTER);

        // Copyright label
        JLabel copyrightLabel = new JLabel("Copyrights © iCET 2023", SwingConstants.CENTER);
        copyrightLabel.setBounds(0, 440, 500, 30);
        copyrightLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        add(copyrightLabel,BorderLayout.SOUTH);

        // Display the frame
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);

    }

}