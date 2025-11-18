/*
 * Created by JFormDesigner on Tue Nov 18 20:27:01 SGT 2025
 */

package carrental.ui.Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author LengxiQwQ
 */
public class AdminDashboardFrame {
    public AdminDashboardFrame() {
        initComponents();
        initEventListeners();
    }

    private void initEventListeners() {
        // 为每个ToggleButton添加事件监听器实现卡片切换
        toggleButtonManageStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard("card1");
                toggleButtonManageStaff.setSelected(true);
                toggleButtonManageCars.setSelected(false);
                toggleButtonReports.setSelected(false);
                toggleButtonSystemLogs.setSelected(false);
            }
        });

        toggleButtonManageCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard("card2");
                toggleButtonManageStaff.setSelected(false);
                toggleButtonManageCars.setSelected(true);
                toggleButtonReports.setSelected(false);
                toggleButtonSystemLogs.setSelected(false);
            }
        });

        toggleButtonReports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard("card3");
                toggleButtonManageStaff.setSelected(false);
                toggleButtonManageCars.setSelected(false);
                toggleButtonReports.setSelected(true);
                toggleButtonSystemLogs.setSelected(false);
            }
        });

        toggleButtonSystemLogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard("card4");
                toggleButtonManageStaff.setSelected(false);
                toggleButtonManageCars.setSelected(false);
                toggleButtonReports.setSelected(false);
                toggleButtonSystemLogs.setSelected(true);
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
        manageStaff1 = new ManageStaff();
        manageCars1 = new ManageCars();
        reports1 = new Reports();
        systemLogs1 = new SystemLogs();
        buttonPanel = new JPanel();
        toggleButtonManageStaff = new JToggleButton();
        toggleButtonManageCars = new JToggleButton();
        toggleButtonReports = new JToggleButton();
        toggleButtonSystemLogs = new JToggleButton();

        //======== freamRoot ========
        {
            freamRoot.setTitle("Car Rental Management System - Administer Dashboard");
            var freamRootContentPane = freamRoot.getContentPane();

            //======== cardPanel ========
            {
                cardPanel.setLayout(new CardLayout());
                cardPanel.add(manageStaff1, "card1");
                cardPanel.add(manageCars1, "card2");
                cardPanel.add(reports1, "card3");
                cardPanel.add(systemLogs1, "card4");
            }

            //======== buttonPanel ========
            {

                //---- toggleButtonManageStaff ----
                toggleButtonManageStaff.setText("Manage Staff");

                //---- toggleButtonManageCars ----
                toggleButtonManageCars.setText("Manage Cars");

                //---- toggleButtonReports ----
                toggleButtonReports.setText("Reports");

                //---- toggleButtonSystemLogs ----
                toggleButtonSystemLogs.setText("System Logs");

                GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
                buttonPanel.setLayout(buttonPanelLayout);
                buttonPanelLayout.setHorizontalGroup(
                    buttonPanelLayout.createParallelGroup()
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(toggleButtonManageStaff, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonManageCars, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonReports, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonSystemLogs, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                buttonPanelLayout.setVerticalGroup(
                    buttonPanelLayout.createParallelGroup()
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(buttonPanelLayout.createParallelGroup()
                                .addComponent(toggleButtonManageStaff, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addComponent(toggleButtonManageCars, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addComponent(toggleButtonReports, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addComponent(toggleButtonSystemLogs, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
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
    private ManageStaff manageStaff1;
    private ManageCars manageCars1;
    private Reports reports1;
    private SystemLogs systemLogs1;
    private JPanel buttonPanel;
    private JToggleButton toggleButtonManageStaff;
    private JToggleButton toggleButtonManageCars;
    private JToggleButton toggleButtonReports;
    private JToggleButton toggleButtonSystemLogs;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public JFrame getFreamRoot(){
        return freamRoot;
    }
}