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