/*
 * Created by JFormDesigner on Tue Nov 18 19:00:16 SGT 2025
 */

package carrental.ui.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author LengxiQwQ
 */
public class AdminDashboardFrame  {

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        freamRoot = new JFrame();
        cardPanel = new JPanel();
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
    private JPanel buttonPanel;
    private JToggleButton toggleButtonManageStaff;
    private JToggleButton toggleButtonManageCars;
    private JToggleButton toggleButtonReports;
    private JToggleButton toggleButtonSystemLogs;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
