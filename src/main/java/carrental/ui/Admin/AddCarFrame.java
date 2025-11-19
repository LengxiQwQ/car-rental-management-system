/*
 * Created by JFormDesigner on Tue Nov 18 23:49:20 SGT 2025
 */

package carrental.ui.Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import carrental.dao.CarDAO;
import carrental.model.Car;
import carrental.service.LogService;
import carrental.util.TimestampUtil;

/**
 * @author LengxiQwQ
 */
public class AddCarFrame extends JFrame {
    private CarDAO carDAO;
    private LogService logService = new LogService();

    public AddCarFrame() {
        initComponents();
        carDAO = new CarDAO();
        setupEventListeners();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        textFieldAddCarID = new JTextField();
        label3 = new JLabel();
        textFieldtextFieldAddCarBrand = new JTextField();
        textFieldAddCarYear = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textFieldAddCarModel = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        textFieldAddCarLicencePlate = new JTextField();
        textFieldAddCarColor = new JTextField();
        textFieldAddCarDailyFee = new JTextField();
        buttonAddCar = new JButton();
        buttonAddCarCancel = new JButton();
        comboBoxAddCarStatus = new JComboBox<>();
        // 设置下拉列表选项
        comboBoxAddCarStatus.addItem("AVAILABLE");
        comboBoxAddCarStatus.addItem("RENTED");
        comboBoxAddCarStatus.addItem("MAINTENANCE");
        // 设置默认选中项
        comboBoxAddCarStatus.setSelectedItem("AVAILABLE");

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Add Car");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label2 ----
        label2.setText("Car ID");

        //---- label3 ----
        label3.setText("Brand");

        //---- label4 ----
        label4.setText("Year");

        //---- label5 ----
        label5.setText("Model");

        //---- label6 ----
        label6.setText("Daily fee");

        //---- label7 ----
        label7.setText("Status");

        //---- label8 ----
        label8.setText("Color");

        //---- label9 ----
        label9.setText("Licence plate");

        //---- buttonAddCar ----
        buttonAddCar.setText("Add");

        //---- buttonAddCarCancel ----
        buttonAddCarCancel.setText("Cancel");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(75, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(buttonAddCarCancel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAddCar))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label2)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label7)
                                .addComponent(label8)
                                .addComponent(label6)
                                .addComponent(label9))
                            .addGap(21, 21, 21)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFieldAddCarColor, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(textFieldAddCarDailyFee, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(textFieldAddCarID, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(textFieldAddCarLicencePlate, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(textFieldtextFieldAddCarBrand, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(textFieldAddCarModel, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(textFieldAddCarYear, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(label1)
                                .addComponent(comboBoxAddCarStatus, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                    .addContainerGap(94, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(label1)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textFieldAddCarID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textFieldtextFieldAddCarBrand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textFieldAddCarModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textFieldAddCarYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldAddCarLicencePlate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8)
                        .addComponent(textFieldAddCarColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(comboBoxAddCarStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(textFieldAddCarDailyFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAddCar)
                        .addComponent(buttonAddCarCancel))
                    .addContainerGap(41, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // 设置事件监听器
    private void setupEventListeners() {
        // 添加车辆按钮事件
        buttonAddCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar();
            }
        });

        // 取消按钮事件
        buttonAddCarCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 关闭窗口
            }
        });
    }

    // 添加车辆
    private void addCar() {
        String carId = textFieldAddCarID.getText().trim();
        String brand = textFieldtextFieldAddCarBrand.getText().trim();
        String model = textFieldAddCarModel.getText().trim();
        String yearStr = textFieldAddCarYear.getText().trim();
        String licensePlate = textFieldAddCarLicencePlate.getText().trim();
        String color = textFieldAddCarColor.getText().trim();
        String status = comboBoxAddCarStatus.getSelectedItem().toString().trim();
        String dailyFeeStr = textFieldAddCarDailyFee.getText().trim();

        // 验证输入
        if (carId.isEmpty() || brand.isEmpty() || model.isEmpty() || yearStr.isEmpty() ||
            licensePlate.isEmpty() || color.isEmpty() || status.isEmpty() || dailyFeeStr.isEmpty()) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add car failed: Missing required fields");
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            logService.recordLog(getCurrentUser(), "Car Management", "Failed to add car: missing required fields", false);
            return;
        }

        int year;
        double dailyFee;

        try {
            year = Integer.parseInt(yearStr);
            dailyFee = Double.parseDouble(dailyFeeStr);
        } catch (NumberFormatException ex) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add car failed: Invalid number format");
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for year and daily fee.", "Error", JOptionPane.ERROR_MESSAGE);
            logService.recordLog(getCurrentUser(), "Car Management", "Failed to add car: invalid number format", false);
            return;
        }

        // 创建新车辆对象
        Car newCar = new Car();
        newCar.setCarID(carId);
        newCar.setBrand(brand);
        newCar.setModel(model);
        newCar.setYear(year);
        newCar.setLicensePlate(licensePlate);
        newCar.setColor(color);
        try {
            newCar.setStatus(Car.CarStatus.valueOf(status.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add car failed: Invalid status - " + status);
            JOptionPane.showMessageDialog(this, "Invalid status. Please use: AVAILABLE, RENTED, or MAINTENANCE.", "Error", JOptionPane.ERROR_MESSAGE);
            logService.recordLog(getCurrentUser(), "Car Management", "Failed to add car: invalid status - " + status, false);
            return;
        }
        newCar.setPrice(dailyFee);
        newCar.setStock(1); // 默认库存为1

        // 添加到数据库
        try {
            boolean success = carDAO.insert(newCar);
            if (success) {
                System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add car successful: ID=" + carId + ", Brand=" + brand + ", Model=" + model);
                JOptionPane.showMessageDialog(this, "Car added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                logService.recordLog(getCurrentUser(), "Car Management", "Added car: ID=" + carId + ", Brand=" + brand + ", Model=" + model, true);
                clearFields(); // 清空输入框
                dispose(); // 关闭窗口

                // 刷新主表格将在窗口关闭时由ManageCars处理
            } else {
                System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add car failed: Database error for ID=" + carId + ", Brand=" + brand + ", Model=" + model);
                JOptionPane.showMessageDialog(this, "Failed to add car. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                logService.recordLog(getCurrentUser(), "Car Management", "Failed to add car: database error for ID=" + carId, false);
            }
        } catch (Exception ex) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " [Admin] Add car error: " + ex.getMessage() + " for ID=" + carId + ", Brand=" + brand + ", Model=" + model);
            JOptionPane.showMessageDialog(this, "Error adding car: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logService.recordLog(getCurrentUser(), "Car Management", "Error adding car: " + ex.getMessage() + " for ID=" + carId, false);
        }
    }

    // 清空输入框
    private void clearFields() {
        textFieldAddCarID.setText("");
        textFieldtextFieldAddCarBrand.setText("");
        textFieldAddCarModel.setText("");
        textFieldAddCarYear.setText("");
        textFieldAddCarLicencePlate.setText("");
        textFieldAddCarColor.setText("");
        comboBoxAddCarStatus.setSelectedIndex(0); // 重置为默认值
        textFieldAddCarDailyFee.setText("");
    }

    // 获取当前登录用户
    private String getCurrentUser() {
        // 这里应该从登录会话中获取当前用户名
        // 暂时返回默认值
        return "admin";
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField textFieldAddCarID;
    private JLabel label3;
    private JTextField textFieldtextFieldAddCarBrand;
    private JTextField textFieldAddCarYear;
    private JLabel label4;
    private JLabel label5;
    private JTextField textFieldAddCarModel;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField textFieldAddCarLicencePlate;
    private JTextField textFieldAddCarColor;
    private JTextField textFieldAddCarDailyFee;
    private JButton buttonAddCar;
    private JButton buttonAddCarCancel;
    private JComboBox<String> comboBoxAddCarStatus;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
