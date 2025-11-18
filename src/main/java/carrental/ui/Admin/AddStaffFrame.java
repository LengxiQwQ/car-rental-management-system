/*
 * Created by JFormDesigner on Tue Nov 18 23:49:36 SGT 2025
 */

package carrental.ui.Admin;

import carrental.dao.UserDAO;
import carrental.model.User;
import carrental.model.userRole;
import carrental.util.TimestampUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LengxiQwQ
 */
public class AddStaffFrame extends JFrame {
    private UserDAO userDAO;

    public AddStaffFrame() {
        initComponents();
        userDAO = new UserDAO();
        setupEventListeners();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        textFieldAddStaffID = new JTextField();
        label3 = new JLabel();
        textFieldtextFieldAddStaffName = new JTextField();
        buttonAddStaff = new JButton();
        buttonAddStaffCancel = new JButton();
        label4 = new JLabel();
        textFieldtextFieldAddStaffPassword = new JPasswordField();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Add Staff");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label2 ----
        label2.setText("Staff ID");

        //---- label3 ----
        label3.setText("Username");

        //---- buttonAddStaff ----
        buttonAddStaff.setText("Add");

        //---- buttonAddStaffCancel ----
        buttonAddStaffCancel.setText("Cancel");

        //---- label4 ----
        label4.setText("Password");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(label3))
                                    .addGap(45, 45, 45))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(48, 48, 48)))
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFieldtextFieldAddStaffName, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(textFieldAddStaffID, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(textFieldtextFieldAddStaffPassword, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(buttonAddStaffCancel)
                            .addGap(87, 87, 87)
                            .addComponent(buttonAddStaff)))
                    .addContainerGap(70, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(label1)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label2))
                        .addComponent(textFieldAddStaffID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(label3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(textFieldtextFieldAddStaffName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addComponent(textFieldtextFieldAddStaffPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAddStaff)
                        .addComponent(buttonAddStaffCancel))
                    .addGap(34, 34, 34))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField textFieldAddStaffID;
    private JLabel label3;
    private JTextField textFieldtextFieldAddStaffName;
    private JButton buttonAddStaff;
    private JButton buttonAddStaffCancel;
    private JLabel label4;
    private JPasswordField textFieldtextFieldAddStaffPassword;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 设置事件监听器
    private void setupEventListeners() {
        // 添加员工按钮事件
        buttonAddStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStaff();
            }
        });

        // 取消按钮事件
        buttonAddStaffCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 关闭窗口
            }
        });
    }

    // 添加员工
    private void addStaff() {
        String staffId = textFieldAddStaffID.getText().trim();
        String username = textFieldtextFieldAddStaffName.getText().trim();
        String password = textFieldtextFieldAddStaffPassword.getText().trim();

        // 验证输入
        if (staffId.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add staff failed: Missing required fields");
            return;
        }

        // 创建新用户对象
        User newStaff = new User();
        newStaff.setUserID(staffId);
        newStaff.setUsername(username);
        newStaff.setPassword(password);
        newStaff.setRole(userRole.staff); // 设置为员工角色

        // 添加到数据库
        try {
            boolean success = userDAO.insert(newStaff);
            if (success) {
                System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add staff successful: ID=" + staffId + ", Username=" + username);
                JOptionPane.showMessageDialog(this, "Staff added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields(); // 清空输入框
                dispose(); // 关闭窗口

                // 刷新主表格将在窗口关闭时由ManageStaff处理
            } else {
                System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add staff failed: Database error for ID=" + staffId + ", Username=" + username);
                JOptionPane.showMessageDialog(this, "Failed to add staff. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add staff error: " + ex.getMessage() + " for ID=" + staffId + ", Username=" + username);
            JOptionPane.showMessageDialog(this, "Error adding staff: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 清空输入框
    private void clearFields() {
        textFieldAddStaffID.setText("");
        textFieldtextFieldAddStaffName.setText("");
        textFieldtextFieldAddStaffPassword.setText("");
    }
}
