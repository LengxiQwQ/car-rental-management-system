/*
 * Created by JFormDesigner on Tue Nov 18 00:15:51 SGT 2025
 */

package carrental.ui.Staff;

import java.awt.*;
import javax.swing.*;

/**
 * @author LengxiQwQ
 */
public class StaffDashboardFrame extends JFrame {
    public StaffDashboardFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        availabilityPanel1 = new AvailabilityPanel();
        customerPanel1 = new CustomerPanel();
        manageRentalsPanel1 = new ManageRentalsPanel();
        searchCarsPanel1 = new SearchCarsPanel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new CardLayout());
        contentPane.add(availabilityPanel1, "card1");
        contentPane.add(customerPanel1, "card2");
        contentPane.add(manageRentalsPanel1, "card3");
        contentPane.add(searchCarsPanel1, "card4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private AvailabilityPanel availabilityPanel1;
    private CustomerPanel customerPanel1;
    private ManageRentalsPanel manageRentalsPanel1;
    private SearchCarsPanel searchCarsPanel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    //public JFrame getCardPanel() {
    //    return cardPanel;
    //}

}
