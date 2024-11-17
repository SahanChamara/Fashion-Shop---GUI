import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class SearchingOption extends JFrame{
    SearchingOption(){        

        Icon qIcon = UIManager.getIcon("OptionPane.questionIcon");

        Object[] buttons = {"Search Customer", "Search Order", "Cancel"};

        int selection=JOptionPane.showOptionDialog(
            null,
            "Please Select the Option",     //select option text
            "Search Option",        // JPane box Title
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            qIcon,
            buttons,
            buttons[0]
        );
        switch (selection) {
            case 0:
                new SearchCustomer().setVisible(true);                
                break;
            case 1:
                new SearchOrder().setVisible(true);
                break;
            case 2:
                // dispose();        
            default:
                System.out.println("Default");
        }
    }
    
}
