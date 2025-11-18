/*
 * Created by JFormDesigner on Tue Nov 18 00:15:51 SGT 2025
 */

package carrental.ui.Staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author LengxiQwQ
 */
public class StaffDashboardFrame {
    public StaffDashboardFrame() {
        initComponents();
        initEventListeners();
    }

    private void initEventListeners() {
        // 为每个ToggleButton添加事件监听器实现卡片切换
        toggleButtonAvailability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard("card1");
                toggleButtonAvailability.setSelected(true);
                toggleButtonCustomer.setSelected(false);
                toggleButtonRental.setSelected(false);
                toggleButtonSearchCar.setSelected(false);
            }
        });

        toggleButtonCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard("card2");
                toggleButtonAvailability.setSelected(false);
                toggleButtonCustomer.setSelected(true);
                toggleButtonRental.setSelected(false);
                toggleButtonSearchCar.setSelected(false);
            }
        });

        toggleButtonRental.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard("card3");
                toggleButtonAvailability.setSelected(false);
                toggleButtonCustomer.setSelected(false);
                toggleButtonRental.setSelected(true);
                toggleButtonSearchCar.setSelected(false);
            }
        });

        toggleButtonSearchCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard("card4");
                toggleButtonAvailability.setSelected(false);
                toggleButtonCustomer.setSelected(false);
                toggleButtonRental.setSelected(false);
                toggleButtonSearchCar.setSelected(true);
            }
        });
    }

    private void showCard(String cardName) {
        CardLayout layout = (CardLayout) cardPanel.getLayout();
        layout.show(cardPanel, cardName);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        freamRoot = new JFrame();
        cardPanel = new JPanel();
        availabilityPanel1 = new AvailabilityPanel();
        customerPanel1 = new CustomerPanel();
        manageRentalsPanel1 = new ManageRentalsPanel();
        searchCarsPanel1 = new SearchCarsPanel();
        buttonPanel = new JPanel();
        toggleButtonAvailability = new JToggleButton();
        toggleButtonCustomer = new JToggleButton();
        toggleButtonRental = new JToggleButton();
        toggleButtonSearchCar = new JToggleButton();

        //======== freamRoot ========
        {
            freamRoot.setTitle("Car Rental Management System - Staff Dashboard");
            var freamRootContentPane = freamRoot.getContentPane();

            //======== cardPanel ========
            {
                cardPanel.setLayout(new CardLayout());
                cardPanel.add(availabilityPanel1, "card1");
                cardPanel.add(customerPanel1, "card2");
                cardPanel.add(manageRentalsPanel1, "card3");
                cardPanel.add(searchCarsPanel1, "card4");
            }

            //======== buttonPanel ========
            {

                //---- toggleButtonAvailability ----
                toggleButtonAvailability.setText("Availability");

                //---- toggleButtonCustomer ----
                toggleButtonCustomer.setText("Customer");

                //---- toggleButtonRental ----
                toggleButtonRental.setText("Manage Rental");

                //---- toggleButtonSearchCar ----
                toggleButtonSearchCar.setText("Search Car");

                GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
                buttonPanel.setLayout(buttonPanelLayout);
                buttonPanelLayout.setHorizontalGroup(
                    buttonPanelLayout.createParallelGroup()
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(toggleButtonAvailability, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonCustomer, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonRental, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonSearchCar, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                buttonPanelLayout.setVerticalGroup(
                    buttonPanelLayout.createParallelGroup()
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(buttonPanelLayout.createParallelGroup()
                                .addComponent(toggleButtonAvailability, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addComponent(toggleButtonCustomer, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addComponent(toggleButtonRental, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addComponent(toggleButtonSearchCar, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
                );
            }

            GroupLayout freamRootContentPaneLayout = new GroupLayout(freamRootContentPane);
            freamRootContentPane.setLayout(freamRootContentPaneLayout);
            freamRootContentPaneLayout.setHorizontalGroup(
                freamRootContentPaneLayout.createParallelGroup()
                    .addGroup(freamRootContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(freamRootContentPaneLayout.createParallelGroup()
                            .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, freamRootContentPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cardPanel, GroupLayout.PREFERRED_SIZE, 1018, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
            );
            freamRootContentPaneLayout.setVerticalGroup(
                freamRootContentPaneLayout.createParallelGroup()
                    .addGroup(freamRootContentPaneLayout.createSequentialGroup()
                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPanel, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            freamRoot.pack();
            freamRoot.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame freamRoot;
    private JPanel cardPanel;
    private AvailabilityPanel availabilityPanel1;
    private CustomerPanel customerPanel1;
    private ManageRentalsPanel manageRentalsPanel1;
    private SearchCarsPanel searchCarsPanel1;
    private JPanel buttonPanel;
    private JToggleButton toggleButtonAvailability;
    private JToggleButton toggleButtonCustomer;
    private JToggleButton toggleButtonRental;
    private JToggleButton toggleButtonSearchCar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public JFrame getFreamRoot() {
        return freamRoot;
    }

}