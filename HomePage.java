import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class HomePage extends JFrame{
        private JLabel mainTopic;

        private JButton btnPlaceOrder;
        private JButton btnSearchCustomer;
        private JButton btnSearchOrder;
        private JButton btnViewReports;
        private JButton btnSetOrderStatus;
        private JButton btnDeleteOrder;

        HomePage(){
            setSize(400,00);
            setTitle("Fashion Shop Customer Management System");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            // Main Topic
            mainTopic = new JLabel("FASHION SHOP");
            mainTopic.setFont(new Font("Arial",1,30));
            mainTopic.setHorizontalAlignment(JLabel.CENTER);
            add("North",mainTopic);


            JPanel btnPanel = new JPanel(new GridLayout(3,2));

            // Buttons
            btnPlaceOrder = new JButton("Place Order");
            btnSearchCustomer = new JButton("Search Customer");
            btnSearchOrder = new JButton("Search Order");
            btnViewReports = new JButton("View Reports");
            btnDeleteOrder = new JButton("Delete Order");
            btnSetOrderStatus = new JButton("Delete Order");


            // setting the fonts
            btnPlaceOrder.setFont(new Font("Arial",1,15));
            btnSearchCustomer.setFont(new Font("Arial",1,15));
            btnSearchOrder.setFont(new Font("Arial",1,15));
            btnViewReports.setFont(new Font("Arial",1,15));
            btnDeleteOrder.setFont(new Font("Arial",1,15));
            btnSetOrderStatus.setFont(new Font("Arial",1,15));

            // set the button into panel
            JPanel btnPlaceOrderpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel btnSearchCustomerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel btnSearchOrderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel btnViewReportPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel btnDeleteOrderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel btnSetOrderStatusPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnPlaceOrderpanel.add(btnPlaceOrder);
            btnSearchCustomerPanel.add(btnSearchCustomer);
            btnSearchOrderPanel.add(btnSearchOrder);
            btnViewReportPanel.add(btnViewReports);
            btnDeleteOrderPanel.add(btnDeleteOrder);
            btnSetOrderStatusPanel.add(btnSetOrderStatus);

            btnPanel.add(btnPlaceOrderpanel);
            btnPanel.add(btnSearchCustomerPanel);
            btnPanel.add(btnSearchOrderPanel);
            btnPanel.add(btnViewReportPanel);
            btnPanel.add(btnDeleteOrderPanel);
            btnPanel.add(btnSetOrderStatusPanel);

            add("Center",btnPanel);

        }




    
}