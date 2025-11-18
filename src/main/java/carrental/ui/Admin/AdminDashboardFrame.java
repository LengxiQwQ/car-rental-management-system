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
        // 初始化默认主题为深色主题
        applyTheme("Dark");
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
            @Override  // 重写父类的actionPerformed方法，处理按钮点击事件
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
        manageStaff1 = new ManageStaff();
        manageCars1 = new ManageCars();
        reports1 = new Reports();
        systemLogs1 = new SystemLogs();
        buttonPanel = new JPanel();
        toggleButtonManageStaff = new JToggleButton();
        toggleButtonManageCars = new JToggleButton();
        toggleButtonSystemLogs = new JToggleButton();
        toggleButtonReports = new JToggleButton();
        label1 = new JLabel();
        comboBoxTheme = new JComboBox<>();

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

                //---- toggleButtonSystemLogs ----
                toggleButtonSystemLogs.setText("System Logs");

                //---- toggleButtonReports ----
                toggleButtonReports.setText("Reports");

                //---- label1 ----
                label1.setText("Admin Dashboard");
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
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(56, 56, 56)
                            .addComponent(toggleButtonManageStaff, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonManageCars, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonReports, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(toggleButtonSystemLogs, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboBoxTheme, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30))
                );
                buttonPanelLayout.setVerticalGroup(
                    buttonPanelLayout.createParallelGroup()
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBoxTheme, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toggleButtonSystemLogs, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toggleButtonReports, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toggleButtonManageCars, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toggleButtonManageStaff, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label1))
                            .addContainerGap())
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
                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
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
    private JToggleButton toggleButtonSystemLogs;
    private JToggleButton toggleButtonReports;
    private JLabel label1;
    private JComboBox<String> comboBoxTheme;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public JFrame getFreamRoot(){
        return freamRoot;
    }
}