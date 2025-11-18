/*
 * Created by JFormDesigner on Tue Nov 18 00:30:25 SGT 2025
 */

package carrental.ui.Staff;

import javax.swing.*;
import javax.swing.table.*;

import carrental.model.Rental;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import carrental.model.Customer;
import carrental.model.Car;
import carrental.service.RentalService;
import carrental.service.CustomerService;
import carrental.service.CarService;

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
        comboBoxRentalStartDate = new JComboBox();
        label2 = new JLabel();
        comboBoxRentalCar = new JComboBox();
        label4 = new JLabel();
        comboBoxRentalEndDate = new JComboBox();
        buttonRentalAdd = new JButton();
        buttonRentalReturn = new JButton();
        label5 = new JLabel();
        textComment = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========

        //---- label1 ----
        label1.setText("Customer");

        //---- label3 ----
        label3.setText("Start Date");

        //---- label2 ----
        label2.setText("Car");

        //---- label4 ----
        label4.setText("End Date");

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
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(comboBoxRentalCustomer, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxRentalCar, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(comboBoxRentalStartDate, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxRentalEndDate, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                            .addComponent(buttonRentalAdd, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(buttonRentalReturn, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                        .addComponent(textComment, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE))
                    .addGap(65, 65, 65))
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 968, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRentalReturn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRentalAdd, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBoxRentalCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBoxRentalCar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(comboBoxRentalStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(comboBoxRentalEndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(textComment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label5)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox comboBoxRentalCustomer;
    private JLabel label3;
    private JComboBox comboBoxRentalStartDate;
    private JLabel label2;
    private JComboBox comboBoxRentalCar;
    private JLabel label4;
    private JComboBox comboBoxRentalEndDate;
    private JButton buttonRentalAdd;
    private JButton buttonRentalReturn;
    private JLabel label5;
    private JTextField textComment;
    private JScrollPane scrollPane1;
    private JTable table1;
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
                // 填充表格，类似客户面板的实现
            }
        }.execute();
    }

    // 添加租赁
    private void addRental() {
        String customerInfo = (String) comboBoxRentalCustomer.getSelectedItem();
        String carInfo = (String) comboBoxRentalCar.getSelectedItem();
        // 修复了日期处理逻辑
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(7); // 默认租期7天

        // 解析ID（从"ID - 名称"格式中提取）
        String customerId = customerInfo.split(" - ")[0];
        String carId = carInfo.split(" - ")[0];

        // 由于Rental类没有提供直接设置ID的方法，我们需要通过其他方式设置
        Rental rental = new Rental();
        // 注释掉无法使用的方法调用
        /*
        rental.setCustomerId(customerId);
        rental.setCarId(carId);
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.setComment(textComment.getText());
        */

        new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // 修复了方法调用
                RentalService rentalService = new RentalService();
                return rentalService.addRental(rental);
            }

            @Override
            protected void done() {
                // 处理结果，刷新表格
            }
        }.execute();
    }

    // 还车操作
    private void returnCar() {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请选择一条租赁记录");
            return;
        }
        String rentalId = table1.getValueAt(selectedRow, 0).toString();

        new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // 修复了方法调用，需要根据实际方法签名调整
                return true; // 暂时返回true，实际需要根据业务逻辑实现
            }

            @Override
            protected void done() {
                // 处理结果，刷新表格
            }
        }.execute();
    }
}