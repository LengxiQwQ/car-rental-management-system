/*
 * Created by JFormDesigner on Tue Nov 18 19:00:15 SGT 2025
 */

package carrental.ui.Admin;

import carrental.dao.UserDAO;
import carrental.model.User;
import carrental.model.userRole;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LengxiQwQ
 */
public class ManageStaff extends JPanel {
    private UserDAO userDAO;
    private List<User> staffList;
    
    public ManageStaff() {
        initComponents();
        userDAO = new UserDAO();
        initTable();
        loadStaffData();
        setupEventListeners();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxSearchStaffType = new JComboBox<>();
        textSearchStaffContent = new JTextField();
        buttonSearchStaff = new JButton();
        scrollPane1 = new JScrollPane();
        tableStaffInfo = new JTable();
        buttonAddStaff = new JButton();
        buttonDeleteSelected = new JButton();
        buttonRefresh = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Search Staff");

        //---- comboBoxSearchStaffType ----
        comboBoxSearchStaffType.setModel(new DefaultComboBoxModel<>(new String[] {
            "Name",
            "Staff ID"
        }));

        //---- buttonSearchStaff ----
        buttonSearchStaff.setText("Search Staff");

        //======== scrollPane1 ========
        {

            //---- tableStaffInfo ----
            tableStaffInfo.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(tableStaffInfo);
        }

        //---- buttonAddStaff ----
        buttonAddStaff.setText("Add Staff");

        //---- buttonDeleteSelected ----
        buttonDeleteSelected.setText("Delete Selected");

        //---- buttonRefresh ----
        buttonRefresh.setText("Refresh");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxSearchStaffType, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(textSearchStaffContent, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonSearchStaff)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonRefresh, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonDeleteSelected)
                            .addGap(18, 18, 18)
                            .addComponent(buttonAddStaff)
                            .addGap(34, 34, 34)))
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxSearchStaffType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(buttonAddStaff)
                        .addComponent(buttonDeleteSelected)
                        .addComponent(textSearchStaffContent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSearchStaff)
                        .addComponent(buttonRefresh))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox<String> comboBoxSearchStaffType;
    private JTextField textSearchStaffContent;
    private JButton buttonSearchStaff;
    private JScrollPane scrollPane1;
    private JTable tableStaffInfo;
    private JButton buttonAddStaff;
    private JButton buttonDeleteSelected;
    private JButton buttonRefresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    
    // 初始化表格
    private void initTable() {
        // 设置表格模型
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Staff ID", "Username", "Role", "Created At"}
        );
        tableStaffInfo.setModel(model);
        
        // 设置表格列宽
        tableStaffInfo.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableStaffInfo.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableStaffInfo.getColumnModel().getColumn(2).setPreferredWidth(100);
        tableStaffInfo.getColumnModel().getColumn(3).setPreferredWidth(200);
    }
    
    // 加载员工数据
    private void loadStaffData() {
        try {
            staffList = getAllStaff();
            updateTable(staffList);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading staff data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // 获取所有员工
    private List<User> getAllStaff() {
        List<User> staffList = new ArrayList<>();
        
        try (Connection conn = carrental.db.DBConnection.getConnection();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery("SELECT id, username, role, created_at FROM users WHERE role = 'STAFF' ORDER BY id")) {
            
            while (rs.next()) {
                User staff = new User();
                staff.setUserID(rs.getString("id"));
                staff.setUsername(rs.getString("username"));
                staff.setRole(userRole.valueOf(rs.getString("role").toLowerCase()));
                staff.setDetails(rs.getString("created_at")); // 使用details字段存储创建时间
                staffList.add(staff);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return staffList;
    }
    
    // 更新表格数据
    private void updateTable(List<User> staffList) {
        DefaultTableModel model = (DefaultTableModel) tableStaffInfo.getModel();
        model.setRowCount(0); // 清空表格
        
        for (User staff : staffList) {
            model.addRow(new Object[]{
                staff.getUserID(),
                staff.getUsername(),
                staff.getRole().toString(),
                staff.getDetails() // created_at
            });
        }
    }
    
    // 设置事件监听器
    private void setupEventListeners() {
        // 搜索按钮事件
        buttonSearchStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStaff();
            }
        });
        
        // 删除选中按钮事件
        buttonDeleteSelected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedStaff();
            }
        });
        
        // 添加员工按钮事件
        buttonAddStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddStaffDialog();
            }
        });

        // 刷新按钮事件
        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
    }
    
    // 搜索员工
    private void searchStaff() {
        String searchType = (String) comboBoxSearchStaffType.getSelectedItem();
        String searchText = textSearchStaffContent.getText().trim();
        
        if (searchText.isEmpty()) {
            loadStaffData(); // 如果搜索内容为空，则显示所有员工
            return;
        }
        
        List<User> filteredList = new ArrayList<>();
        
        if ("Name".equals(searchType)) {
            // 按名称搜索
            for (User staff : staffList) {
                if (staff.getUsername().toLowerCase().contains(searchText.toLowerCase())) {
                    filteredList.add(staff);
                }
            }
        } else if ("Staff ID".equals(searchType)) {
            // 按员工ID搜索
            for (User staff : staffList) {
                if (staff.getUserID().equals(searchText)) {
                    filteredList.add(staff);
                }
            }
        }
        
        updateTable(filteredList);
    }
    
    // 删除选中的员工
    private void deleteSelectedStaff() {
        int selectedRow = tableStaffInfo.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a staff member to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this staff member?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            String staffId = tableStaffInfo.getValueAt(selectedRow, 0).toString();
            
            try {
                boolean success = userDAO.delete(Integer.parseInt(staffId));
                if (success) {
                    JOptionPane.showMessageDialog(this, "Staff member deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadStaffData(); // 重新加载数据
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete staff member.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error deleting staff member: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 刷新表格数据
    private void refreshTable() {
        // 清空搜索框
        textSearchStaffContent.setText("");

        // 重新加载所有员工数据
        loadStaffData();
    }

    // 打开添加员工对话框
    private void openAddStaffDialog() {
        AddStaff addStaffDialog = new AddStaff();
        addStaffDialog.setVisible(true);

        // 当添加员工窗口关闭后，刷新表格
        addStaffDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                refreshTable();
            }
        });
    }
}
