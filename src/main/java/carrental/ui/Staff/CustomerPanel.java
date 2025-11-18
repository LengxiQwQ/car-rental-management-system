/*
 * Created by JFormDesigner on Tue Nov 18 00:37:45 SGT 2025
 */

package carrental.ui.Staff;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

import carrental.model.Customer;
import carrental.model.SystemLog;
import carrental.service.CustomerService;
import carrental.service.LogService;
import carrental.util.TimestampUtil;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author LengxiQwQ
 */
public class CustomerPanel extends JPanel {
    public CustomerPanel() {
        initComponents();
        initData();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        tableCustomerInfo = new JTable();
        label8 = new JLabel();
        label1 = new JLabel();
        textInputCustomerID = new JTextField();
        label2 = new JLabel();
        textInputName = new JTextField();
        label3 = new JLabel();
        textInputPhone = new JTextField();
        label4 = new JLabel();
        textInputIDCardNumber = new JTextField();
        label5 = new JLabel();
        textInputEmail = new JTextField();
        label6 = new JLabel();
        textInputAddress = new JTextField();
        label7 = new JLabel();
        textInputDriverLicenseNumber = new JTextField();
        buttonSave = new JButton();
        textSearch = new JTextField();
        buttonSearch = new JButton();
        label9 = new JLabel();

        //======== this ========

        //======== scrollPane1 ========
        {

            //---- tableCustomerInfo ----
            tableCustomerInfo.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(tableCustomerInfo);
        }

        //---- label8 ----
        label8.setText("Selected Customer Details:");
        label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- label1 ----
        label1.setText("Customer ID");

        //---- label2 ----
        label2.setText("Full name");

        //---- label3 ----
        label3.setText("Phone number");

        //---- label4 ----
        label4.setText("ID card number");

        //---- label5 ----
        label5.setText("Email address");

        //---- label6 ----
        label6.setText("Address");

        //---- label7 ----
        label7.setText("Driver license number");

        //---- buttonSave ----
        buttonSave.setText("Save Change");

        //---- buttonSearch ----
        buttonSearch.setText("Search");

        //---- label9 ----
        label9.setText("Customer Manager");
        label9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(26, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textInputEmail)
                                    .addComponent(textInputAddress)
                                    .addComponent(textInputIDCardNumber)
                                    .addComponent(textInputPhone)
                                    .addComponent(textInputName)
                                    .addComponent(textInputCustomerID, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textInputDriverLicenseNumber, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(textSearch, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonSearch)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label8)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(label9)))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(label9)
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonSearch)
                                .addComponent(textSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(label8)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(textInputCustomerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(textInputName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(textInputPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textInputIDCardNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(textInputEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(textInputAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(textInputDriverLicenseNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54)
                            .addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable tableCustomerInfo;
    private JLabel label8;
    private JLabel label1;
    private JTextField textInputCustomerID;
    private JLabel label2;
    private JTextField textInputName;
    private JLabel label3;
    private JTextField textInputPhone;
    private JLabel label4;
    private JTextField textInputIDCardNumber;
    private JLabel label5;
    private JTextField textInputEmail;
    private JLabel label6;
    private JTextField textInputAddress;
    private JLabel label7;
    private JTextField textInputDriverLicenseNumber;
    private JButton buttonSave;
    private JTextField textSearch;
    private JButton buttonSearch;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
// 在CustomerPanel类的initComponents()后添加初始化方法
    private void initData() {
        // 加载客户列表到表格
        loadCustomerTable();
        // 为搜索按钮添加监听
        buttonSearch.addActionListener(e -> {
            searchCustomer();
        });
        // 为保存按钮添加监听
        buttonSave.addActionListener(e -> {
            saveCustomer();
        });
        // 为表格添加选中监听（选中行时填充表单）
        tableCustomerInfo.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tableCustomerInfo.getSelectedRow();
                if (selectedRow != -1) {
                    String customerId = tableCustomerInfo.getValueAt(selectedRow, 0).toString();
                    fillCustomerForm(selectedRow);
                }
            }
        });
    }

    // 加载客户数据到表格
    private void loadCustomerTable() {
        new SwingWorker<List<Customer>, Void>() {
            @Override
            protected List<Customer> doInBackground() throws Exception {
                return new CustomerService().getAllCustomers(); // 调用Service层
            }

            @Override
            protected void done() {
                try {
                    List<Customer> customers = get();
                    DefaultTableModel model = (DefaultTableModel) tableCustomerInfo.getModel();
                    model.setColumnIdentifiers(new String[]{"ID", "Name", "Phone", "ID Card", "Email", "Address", "Driver License"});
                    model.setRowCount(0); // 清空表格
                    for (Customer c : customers) {
                        model.addRow(new Object[]{
                                c.getCustomerID(), c.getcustomerName(), c.getPhone(),
                                c.getIdCardNumber(), c.getEmail(), c.getAddress(), c.getDriverLicenseNumber()
                        });
                    }
                } catch (Exception ex) {
                    String errorMsg = "Failed to load customers: " + ex.getMessage();
    JOptionPane.showMessageDialog(CustomerPanel.this, errorMsg);
    System.out.println(TimestampUtil.getCurrentTimestamp() + " [ERROR] " + errorMsg);
                    ex.printStackTrace();
                }
            }
        }.execute();
    }

    // 搜索客户
    private void searchCustomer() {
        String keyword = textSearch.getText().trim();
        new SwingWorker<List<Customer>, Void>() {
            @Override
            protected List<Customer> doInBackground() throws Exception {
                return new CustomerService().searchCustomers(keyword);
            }

            @Override
            protected void done() {
                // 与loadCustomerTable()类似，更新表格数据
            }
        }.execute();
    }

    // 保存客户信息
    private void saveCustomer() {
        Customer customer = new Customer();
        customer.setCustomerID(textInputCustomerID.getText());
        customer.setName(textInputName.getText());
        try {
            customer.setPhone(textInputPhone.getText());
        } catch (NumberFormatException e) {
            String errorMsg = "Phone number format is incorrect";
    JOptionPane.showMessageDialog(this, errorMsg);
    System.out.println(TimestampUtil.getCurrentTimestamp() + " [ERROR] " + errorMsg);
            return;
        }
        try {
            customer.setIdCardNumber(textInputIDCardNumber.getText());
        } catch (NumberFormatException e) {
            String errorMsg = "ID card number format is incorrect";
    JOptionPane.showMessageDialog(this, errorMsg);
    System.out.println(TimestampUtil.getCurrentTimestamp() + " [ERROR] " + errorMsg);
            return;
        }
        customer.setEmail(textInputEmail.getText());
        customer.setAddress(textInputAddress.getText());
        try {
            customer.setDriverLicenseNumber(textInputDriverLicenseNumber.getText());
        } catch (NumberFormatException e) {
            String errorMsg = "Driver license number format is incorrect";
    JOptionPane.showMessageDialog(this, errorMsg);
    System.out.println(TimestampUtil.getCurrentTimestamp() + " [ERROR] " + errorMsg);
            return;
        }

        new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return new CustomerService().saveCustomer(customer); // 新增或更新客户
            }

            @Override
            protected void done() {
                try {
                    if (get()) {
                        String successMsg = "Save successful";
    JOptionPane.showMessageDialog(CustomerPanel.this, successMsg);
    System.out.println(TimestampUtil.getCurrentTimestamp() + " [SUCCESS] " + successMsg + " for customer: " + customer.getCustomerID());
                        loadCustomerTable(); // 刷新表格
                    } else {
                        String failMsg = "Save failed";
    JOptionPane.showMessageDialog(CustomerPanel.this, failMsg);
    System.out.println(TimestampUtil.getCurrentTimestamp() + " [ERROR] " + failMsg + " for customer: " + customer.getCustomerID());
                    }
                } catch (Exception ex) {
                    String errorMsg = "Save error: " + ex.getMessage();
    JOptionPane.showMessageDialog(CustomerPanel.this, errorMsg);
    System.out.println(TimestampUtil.getCurrentTimestamp() + " [ERROR] " + errorMsg);
                }
            }
        }.execute();
        // 保存客户成功后
        boolean success = false;
        if (success) {
            SystemLog currentUser = null;
            boolean isNew = false;
            new LogService().recordLog(
                    currentUser.getUsername(),
                    "客户管理",
                    (isNew ? "新增" : "更新") + "客户ID: " + customer.getCustomerID(),

                    true
            );
        }
    }

    // 填充表单（从选中的表格行）
    private void fillCustomerForm(int row) {
        DefaultTableModel model = (DefaultTableModel) tableCustomerInfo.getModel();
        textInputCustomerID.setText(model.getValueAt(row, 0).toString());
        textInputName.setText(model.getValueAt(row, 1).toString());
        textInputPhone.setText(model.getValueAt(row, 2).toString());
        textInputIDCardNumber.setText(model.getValueAt(row, 3).toString());
        textInputEmail.setText(model.getValueAt(row, 4).toString());
        textInputAddress.setText(model.getValueAt(row, 5).toString());
        textInputDriverLicenseNumber.setText(model.getValueAt(row, 6).toString());
    }
}