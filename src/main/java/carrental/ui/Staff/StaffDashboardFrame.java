/*
 * Created by JFormDesigner on Tue Nov 18 00:15:51 SGT 2025
 */

package carrental.ui.Staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author LengxiQwQ
 */
public class StaffDashboardFrame {
    public StaffDashboardFrame() {
        initComponents();
        initEventListeners();
        // 初始化默认主题为深色主题
        applyTheme("Dark");
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
        
        // 主题切换事件监听器
        comboBoxTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTheme = (String) comboBoxTheme.getSelectedItem();
                applyTheme(selectedTheme);
            }
        });
    }

    private void showCard(String cardName) {
        CardLayout layout = (CardLayout) cardPanel.getLayout();
        layout.show(cardPanel, cardName);
    }
    
    // 应用主题的方法
    private void applyTheme(String theme) {
        try {
            if ("Dark".equals(theme)) {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            } else {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            }
            SwingUtilities.updateComponentTreeUI(freamRoot);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        toggleButtonCustomer = new JToggleButton();
        toggleButtonSearchCar = new JToggleButton();
        toggleButtonRental = new JToggleButton();
        toggleButtonAvailability = new JToggleButton();
        label1 = new JLabel();
        comboBoxTheme = new JComboBox<>();

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

                //---- toggleButtonCustomer ----
                toggleButtonCustomer.setText("Customer");

                //---- toggleButtonSearchCar ----
                toggleButtonSearchCar.setText("Search Car");

                //---- toggleButtonRental ----
                toggleButtonRental.setText("Manage Rental");

                //---- toggleButtonAvailability ----
                toggleButtonAvailability.setText("Availability");

                //---- label1 ----
                label1.setText("Staff Dashboard");
                label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));

                //---- comboBoxTheme ----
                comboBoxTheme.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Dark",
                    "Light"
                }));

                GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
                buttonPanel.setLayout(buttonPanelLayout);
                buttonPanelLayout.setHorizontalGroup(
                    buttonPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toggleButtonAvailability, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonRental, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonSearchCar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonCustomer, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboBoxTheme, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))
                );
                buttonPanelLayout.setVerticalGroup(
                    buttonPanelLayout.createParallelGroup()
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                            .addGap(0, 10, Short.MAX_VALUE)
                            .addGroup(buttonPanelLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.TRAILING, buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBoxTheme, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toggleButtonCustomer, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toggleButtonSearchCar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toggleButtonRental, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toggleButtonAvailability, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
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
    private JToggleButton toggleButtonCustomer;
    private JToggleButton toggleButtonSearchCar;
    private JToggleButton toggleButtonRental;
    private JToggleButton toggleButtonAvailability;
    private JLabel label1;
    private JComboBox<String> comboBoxTheme;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public JFrame getFreamRoot() {
        return freamRoot;
    }
}