/*
 * Created by JFormDesigner on Tue Nov 18 00:30:23 SGT 2025
 */

package carrental.ui.Staff;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

import carrental.model.Car;
import carrental.service.CarService;
import carrental.service.LogService;
import carrental.util.TimestampUtil;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author LengxiQwQ
 */
public class AvailabilityPanel extends JPanel {
    public AvailabilityPanel() {
        initComponents();
        initListeners();
        loadCars(); // 初始加载
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxFilter = new JComboBox<>();
        buttonRefresh = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        tableCarAvailability = new JTable();

        //======== this ========

        //---- label1 ----
        label1.setText("Filter");

        //---- comboBoxFilter ----
        comboBoxFilter.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Available",
            "Rented",
            "Maintenance"
        }));

        //---- buttonRefresh ----
        buttonRefresh.setText("Refresh");

        //---- label2 ----
        label2.setText("Car Inventory Table");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //======== scrollPane1 ========
        {

            //---- tableCarAvailability ----
            tableCarAvailability.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(tableCarAvailability);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 964, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBoxFilter, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                    .addGap(172, 172, 172)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRefresh, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(buttonRefresh)
                        .addComponent(label2))
                    .addGap(26, 26, 26)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox<String> comboBoxFilter;
    private JButton buttonRefresh;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable tableCarAvailability;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    // 在AvailabilityPanel类中添加
    private void initListeners() {
        buttonRefresh.addActionListener(e -> {
            loadCars();
        });
        comboBoxFilter.addActionListener(e -> {
            loadCars(); // 筛选变化时刷新
        });
    }

    private void loadCars() {
        String status = (String) comboBoxFilter.getSelectedItem();
        new SwingWorker<List<Car>, Void>() {
            @Override
            protected List<Car> doInBackground() throws Exception {
                CarService service = new CarService();
                if ("All".equals(status)) {
                    return service.getAllCars();
                } else {
                    return service.getCarsByStatus(status);
                }
            }

            @Override
            protected void done() {
                try {
                    List<Car> cars = get();
                    DefaultTableModel model = (DefaultTableModel) tableCarAvailability.getModel();
                    model.setColumnIdentifiers(new String[]{"ID", "License Plate", "Model", "Year", "Color", "Status", "Price/Day"});
                    model.setRowCount(0);
                    for (Car car : cars) {
                        model.addRow(new Object[]{
                                car.getCarID(), car.getLicensePlate(), car.getModel(),
                                car.getYear(), car.getColor(), car.getStatus(), car.getPrice()
                        });
                    }

                    // 记录筛选日志
                    new LogService().recordLog(
                            getCurrentUser(),
                            "Car Availability",
                            "Filtered cars by status: " + status + ". Found " + cars.size() + " results.",
                            true
                    );
                } catch (Exception ex) {
                    String errorMsg = "Failed to load cars: " + ex.getMessage();
                    JOptionPane.showMessageDialog(AvailabilityPanel.this, errorMsg);
                    System.out.println(TimestampUtil.getCurrentTimestamp() + " [ERROR] " + errorMsg);

                    // 记录错误日志
                    new LogService().recordLog(
                            getCurrentUser(),
                            "Car Availability",
                            "Error loading cars with status: " + status + " - " + ex.getMessage(),
                            false
                    );
                }
            }
        }.execute();
    }

    // 获取当前登录用户
    private String getCurrentUser() {
        // 这里应该从登录会话中获取当前用户名
        // 暂时返回默认值
        return "staff";
    }
}