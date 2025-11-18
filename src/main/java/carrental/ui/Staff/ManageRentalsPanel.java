/*
 * Created by JFormDesigner on Tue Nov 18 00:30:25 SGT 2025
 */

package carrental.ui.Staff;

// import javax.security.auth.login.LoginContext; // 移除错误的导入
import javax.swing.*;
import javax.swing.table.*;

import carrental.model.*;
import carrental.service.LogService;
import carrental.util.IPUtil;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import carrental.service.RentalService;
import carrental.service.CustomerService;
import carrental.service.CarService;
import com.toedter.calendar.*;

/**
 * @author LengxiQwQ
 */
public class ManageRentalsPanel extends JPanel {
    public ManageRentalsPanel() {
        initComponents();
        initData();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxRentalCustomer = new JComboBox();
        label3 = new JLabel();
        label2 = new JLabel();
        comboBoxRentalCar = new JComboBox();
        buttonRentalAdd = new JButton();
        buttonRentalReturn = new JButton();
        label5 = new JLabel();
        textComment = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label4 = new JLabel();
        dateChooserStartDate = new JDateChooser();
        dateChooserEndDate = new JDateChooser();

        //======== this ========

        //---- label1 ----
        label1.setText("Customer");

        //---- label3 ----
        label3.setText("Start Date");

        //---- label2 ----
        label2.setText("Car");

        //---- buttonRentalAdd ----
        buttonRentalAdd.setText("Add Rental");

        //---- buttonRentalReturn ----
        buttonRentalReturn.setText("Return Car");

        //---- label5 ----
        label5.setText("Comment");

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- label4 ----
        label4.setText("End Date");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboBoxRentalCustomer, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addComponent(comboBoxRentalCar, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateChooserEndDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateChooserStartDate, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                            .addComponent(buttonRentalAdd, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(buttonRentalReturn, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                        .addComponent(textComment, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE))
                    .addGap(65, 65, 65))
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(comboBoxRentalCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3))
                                    .addGap(8, 8, 8)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(comboBoxRentalCar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dateChooserStartDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateChooserEndDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(textComment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRentalReturn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRentalAdd, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox comboBoxRentalCustomer;
    private JLabel label3;
    private JLabel label2;
    private JComboBox comboBoxRentalCar;
    private JButton buttonRentalAdd;
    private JButton buttonRentalReturn;
    private JLabel label5;
    private JTextField textComment;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label4;
    private JDateChooser dateChooserStartDate;
    private JDateChooser dateChooserEndDate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    // 在ManageRentalsPanel类中添加
    private void initData() {
        loadRentals();
        loadCustomersToCombo();
        loadCarsToCombo();
        // 移除了不存在的方法调用

        buttonRentalAdd.addActionListener(e -> addRental());
        buttonRentalReturn.addActionListener(e -> returnCar());
    }

    // 加载客户到下拉框
    private void loadCustomersToCombo() {
        new SwingWorker<List<Customer>, Void>() {
            @Override
            protected List<Customer> doInBackground() throws Exception {
                CustomerService customerService = new CustomerService();
                return customerService.getAllCustomers();
            }

            @Override
            protected void done() {
                try {
                    List<Customer> customers = get();
                    comboBoxRentalCustomer.removeAllItems();
                    for (Customer customer : customers) {
                        // 在下拉框中显示客户ID和姓名，便于识别
                        comboBoxRentalCustomer.addItem(customer.getCustomerID() + " - " + customer.getcustomerName());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ManageRentalsPanel.this, "加载客户失败: " + ex.getMessage());
                }
            }
        }.execute();
    }

    // 加载车辆到下拉框
    private void loadCarsToCombo() {
        new SwingWorker<List<Car>, Void>() {
            @Override
            protected List<Car> doInBackground() throws Exception {
                CarService carService = new CarService();
                // 只加载可用状态的车辆
                return carService.getAvailableCars();
            }

            @Override
            protected void done() {
                try {
                    List<Car> cars = get();
                    comboBoxRentalCar.removeAllItems();
                    for (Car car : cars) {
                        // 在下拉框中显示车辆ID和型号，便于识别
                        comboBoxRentalCar.addItem(car.getCarID() + " - " + car.getModel() + " (" + car.getLicensePlate() + ")");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ManageRentalsPanel.this, "加载车辆失败: " + ex.getMessage());
                }
            }
        }.execute();
    }

    // 加载租赁记录
    private void loadRentals() {
        new SwingWorker<List<Rental>, Void>() {
            @Override
            protected List<Rental> doInBackground() throws Exception {
                // 使用正确的服务方法
                RentalService rentalService = new RentalService();
                return rentalService.getAllRentals();
            }

            @Override
            protected void done() {
                try {
                    List<Rental> rentals = get(); // 获取后台线程返回的租赁记录列表
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();

                    // 设置表格列名（根据实际需要调整）
                    model.setColumnIdentifiers(new String[]{
                            "租赁ID", "客户姓名", "车辆型号", "开始日期", "预计归还日期",
                            "实际归还日期", "状态", "总费用"
                    });

                    model.setRowCount(0); // 清空表格现有数据

                    // 填充数据到表格
                    for (Rental rental : rentals) {
                        model.addRow(new Object[]{
                                rental.getRentalID(),
                                rental.getCustomer().getcustomerName(), // 需确保Customer有getcustomerName()方法
                                rental.getCar().getModel(), // 需确保Car有getModel()方法
                                rental.getStartDate(),
                                rental.getExpectedReturnDate(),
                                rental.getActualReturnDate(),
                                rental.getStatus(),
                                rental.getTotalCost()
                        });
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ManageRentalsPanel.this,
                            "加载租赁记录失败: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
                // 填充表格，类似客户面板的实现
        }.execute();
    }

    // 添加租赁
    private void addRental() {
        String customerInfo = (String) comboBoxRentalCustomer.getSelectedItem();
        String carInfo = (String) comboBoxRentalCar.getSelectedItem();
        // 修复了日期处理逻辑
        LocalDate startDate = getStartDate();
        LocalDate endDate = getEndDate(); // 租期

        // 解析ID（从"ID - 名称"格式中提取）
        String customerId = customerInfo.split(" - ")[0];
        String carId = carInfo.split(" - ")[0];

        // 由于Rental类没有提供直接设置ID的方法，我们需要通过其他方式设置
        // 注释掉无法使用的方法调用
        /*
        rental.setCustomerId(customerId);
        rental.setCarId(carId);
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.setComment(textComment.getText());
        */
        // 1. 校验输入
        Customer selectedCustomer = null;
        try {
            selectedCustomer = getSelectedCustomer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Car selectedCar = null;
        try {
            selectedCar = getSelectedCar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (selectedCustomer == null || selectedCar == null || startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "请填写完整信息");
            return;
        }

        if (startDate.isAfter(endDate)) {
            JOptionPane.showMessageDialog(this, "结束日期不能早于开始日期");
            return;
        }

        // 2. 构建Rental对象
        Rental rental = new Rental();
        rental.setCustomer(selectedCustomer);
        rental.setCar(selectedCar);
        rental.setStartDate(startDate);
        rental.setExpectedReturnDate(endDate);

        // 获取当前登录员工信息
        User currentStaff = getCurrentStaff();
        if (currentStaff != null) {
            try {
                // 将用户ID字符串转换为整数
                int staffId = Integer.parseInt(currentStaff.getUserID());
                rental.setStaffId(staffId);
            } catch (NumberFormatException e) {
                // 如果转换失败，使用默认值1
                rental.setStaffId(1);
            }
        } else {
            // 如果没有获取到员工信息，使用默认值1
            rental.setStaffId(1);
        }

        // 3. 调用服务层保存
        boolean success = false;
        try {
            RentalService rentalService = new RentalService();
            success = rentalService.checkoutCar(rental, currentStaff);

            if (success) {
                JOptionPane.showMessageDialog(this, "租车记录添加成功");
                loadRentals(); // 刷新表格
            } else {
                JOptionPane.showMessageDialog(this, "添加失败");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "添加失败：" + e.getMessage());
            e.printStackTrace();
        }
        // 租车成功后
        if (success) {
            SystemLog currentUser = null;
            new LogService().recordLog(
                    currentUser.getUsername(),
                    "租车操作",
                    "租赁车辆ID: " + selectedCar.getCarID() +
                            ", 客户ID: " + selectedCustomer.getCustomerID() +
                            ", 租期: " + startDate + "至" + endDate,
                    IPUtil.getLocalIp(),
                    true
            );
        }
    }

    // 辅助方法：从下拉框获取选中的客户
    private Customer getSelectedCustomer() throws SQLException {
        String selectedItem = (String) comboBoxRentalCustomer.getSelectedItem();
        if (selectedItem == null) return null;
        String customerId = selectedItem.split(" - ")[0]; // 提取客户ID
        return new CustomerService().getCustomerById(customerId); // 需CustomerService实现此方法
    }

    // 辅助方法：从下拉框获取选中的车辆
    private Car getSelectedCar() throws SQLException {
        String selectedItem = (String) comboBoxRentalCar.getSelectedItem();
        if (selectedItem == null) return null;
        String carId = selectedItem.split(" - ")[0]; // 假设格式为"ID - 型号"
        List<Car> cars = new CarService().getCarById(carId);
        return cars.isEmpty() ? null : cars.get(0); // 获取列表中的第一个车辆
    }

    // 辅助方法：转换日期选择器的日期为LocalDate
    private LocalDate getStartDate() {
        Date date = dateChooserStartDate.getDate();
        return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
    }

    private LocalDate getEndDate() {
        Date date = dateChooserEndDate.getDate();
        return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
    }

    // 辅助方法：获取当前登录员工（需根据实际登录逻辑实现）
    private User getCurrentStaff() {
        // 示例：创建一个临时用户对象，实际应从登录状态获取
        User staff = new User();
        staff.setUserID("1"); // 使用默认员工ID
        staff.setUsername("staff"); // 默认用户名
        // 实际项目中应替换为真实的登录用户获取逻辑
        return staff;
    }
    private void returnCar() {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请选择一条租赁记录");
            return;
        }
        String rentalId = table1.getValueAt(selectedRow, 0).toString();
        
        try {
            RentalService rentalService = new RentalService();
            User currentStaff = getCurrentStaff();
            
            // 使用当前日期作为实际归还日期
            BigDecimal totalFee = rentalService.returnCar(rentalId, LocalDate.now(), currentStaff);
            JOptionPane.showMessageDialog(this, "车辆归还成功，总费用：" + totalFee);
            loadRentals(); // 刷新表格
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "归还失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

}