/*
 * Created by JFormDesigner on Wed Nov 19 01:36:28 SGT 2025
 */

package carrental.ui.Staff;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.toedter.calendar.*;
import carrental.model.Rental;
import carrental.model.User;
import carrental.service.RentalService;
import carrental.service.VehicleStatusService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author LengxiQwQ
 */
public class ReTurnCarFrame extends JFrame {
    private Rental selectedRental;

    // 默认构造函数
    public ReTurnCarFrame() {
        initComponents();
        setupButtonActions();
    }

    // 带租赁记录参数的构造函数
    public ReTurnCarFrame(Rental rental) {
        this.selectedRental = rental;
        initComponents();
        setupButtonActions();
        displayRentalInfo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        buttonAddReturnCar = new JButton();
        buttonCancelReturnCar = new JButton();
        textVehicleStatus = new JTextField();
        label6 = new JLabel();
        dateChooserActualReturnData = new JDateChooser();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Return Car");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label2 ----
        label2.setText("Actual Return Date");

        //---- buttonAddReturnCar ----
        buttonAddReturnCar.setText("Add");

        //---- buttonCancelReturnCar ----
        buttonCancelReturnCar.setText("Cancel");

        //---- label6 ----
        label6.setText("Vehicle Status");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label6)
                                .addComponent(buttonCancelReturnCar, GroupLayout.Alignment.TRAILING))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(dateChooserActualReturnData, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textVehicleStatus, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(buttonAddReturnCar))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(label1)))
                    .addContainerGap(61, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(label1)
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dateChooserActualReturnData, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textVehicleStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCancelReturnCar)
                        .addComponent(buttonAddReturnCar))
                    .addContainerGap(61, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // 显示租赁记录信息
    private void displayRentalInfo() {
        if (selectedRental != null) {
            // 设置默认归还日期为当前日期
            dateChooserActualReturnData.setDate(new Date());
            // 设置默认车辆状态
            textVehicleStatus.setText("Good");
        }
    }

    // 设置按钮事件
    private void setupButtonActions() {
        buttonAddReturnCar.addActionListener(e -> processReturn());
        buttonCancelReturnCar.addActionListener(e -> dispose());
    }

    // 处理还车
    private void processReturn() {
        if (selectedRental == null) {
            JOptionPane.showMessageDialog(this, "没有选择租赁记录");
            return;
        }

        try {
            // 获取实际归还日期
            Date selectedDate = dateChooserActualReturnData.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(this, "请选择归还日期");
                return;
            }

            LocalDate actualReturnDate = selectedDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

            // 获取车辆状态
            String vehicleStatus = textVehicleStatus.getText().trim();
            if (vehicleStatus.isEmpty()) {
                vehicleStatus = "良好"; // 默认状态
            }

            // 调用还车服务
            RentalService rentalService = new RentalService();
            VehicleStatusService vehicleStatusService = new VehicleStatusService();
            User currentStaff = getCurrentStaff();

            // 执行还车操作
            String rentalId = String.valueOf(selectedRental.getRentalID());
            BigDecimal totalFee = rentalService.returnCar(rentalId, actualReturnDate, currentStaff);

            // 记录车辆状态
            String carId = selectedRental.getCar().getCarID();
            boolean statusRecorded = vehicleStatusService.recordReturnStatus(
                carId, 
                selectedRental.getRentalID(), 
                vehicleStatus, 
                "还车时记录", 
                currentStaff
            );

            if (!statusRecorded) {
                JOptionPane.showMessageDialog(this, "还车成功，但车辆状态记录失败");
            }

            JOptionPane.showMessageDialog(this, "车辆归还成功！ 总费用: " + totalFee);

            // 关闭窗口
            dispose();

            // 刷新父窗口中的表格（如果可能）
            refreshParentTable();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "还车失败: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // 获取当前登录员工
    private User getCurrentStaff() {
        // 示例：创建一个临时用户对象，实际应从登录状态获取
        User staff = new User();
        staff.setUserID("1"); // 使用默认员工ID
        staff.setUsername("staff"); // 默认用户名
        // 实际项目中应替换为真实的登录用户获取逻辑
        return staff;
    }

    // 刷新父窗口中的表格
    private void refreshParentTable() {
        // 获取所有打开的窗口，查找ManageRentalsPanel实例
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                // 获取框架中的内容面板
                Container contentPane = ((JFrame) window).getContentPane();
                // 查找ManageRentalsPanel实例
                findAndRefreshPanel(contentPane);
            }
        }
    }

    // 递归查找并刷新ManageRentalsPanel
    private void findAndRefreshPanel(Container container) {
        // 检查当前容器是否是ManageRentalsPanel
        if (container instanceof ManageRentalsPanel) {
            ((ManageRentalsPanel) container).loadRentals();
            return;
        }

        // 递归检查所有子组件
        for (Component component : container.getComponents()) {
            if (component instanceof Container) {
                findAndRefreshPanel((Container) component);
            }
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JButton buttonAddReturnCar;
    private JButton buttonCancelReturnCar;
    private JTextField textVehicleStatus;
    private JLabel label6;
    private JDateChooser dateChooserActualReturnData;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
