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
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 966, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxFilter, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96)
                            .addComponent(buttonRefresh, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(buttonRefresh)
                        .addComponent(comboBoxFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(26, 26, 26)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
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
        buttonRefresh.addActionListener(e -> loadCars());
        comboBoxFilter.addActionListener(e -> loadCars()); // 筛选变化时刷新
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
                    model.setColumnIdentifiers(new String[]{"ID", "车牌", "型号", "年份", "颜色", "状态", "租金/天"});
                    model.setRowCount(0);
                    for (Car car : cars) {
                        model.addRow(new Object[]{
                                car.getCarID(), car.getLicensePlate(), car.getModel(),
                                car.getYear(), car.getColor(), car.getStatus(), car.getPrice()
                        });
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AvailabilityPanel.this, "加载车辆失败: " + ex.getMessage());
                }
            }
        }.execute();
    }
}