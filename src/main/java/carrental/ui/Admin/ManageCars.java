/*
 * Created by JFormDesigner on Tue Nov 18 19:00:06 SGT 2025
 */

package carrental.ui.Admin;

import carrental.dao.CarDAO;
import carrental.model.Car;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LengxiQwQ
 */
public class ManageCars extends JPanel {
    private CarDAO carDAO;
    private List<Car> carList;
    
    public ManageCars() {
        initComponents();
        carDAO = new CarDAO();
        initTable();
        loadCarData();
        setupEventListeners();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxSearchCarType = new JComboBox<>();
        textSearchCarContent = new JTextField();
        buttonSearchCar = new JButton();
        scrollPane1 = new JScrollPane();
        tableCarInfo = new JTable();
        buttonDeleteSelectedCar = new JButton();
        buttonAddCar = new JButton();
        buttonRefresh = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Search Car Type");

        //---- comboBoxSearchCarType ----
        comboBoxSearchCarType.setModel(new DefaultComboBoxModel<>(new String[] {
            "Car ID",
            "License",
            "Model",
            "Color",
            "Year"
        }));

        //---- buttonSearchCar ----
        buttonSearchCar.setText("Search Car");

        //======== scrollPane1 ========
        {

            //---- tableCarInfo ----
            tableCarInfo.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    null, null, null, null
                }
            ));
            scrollPane1.setViewportView(tableCarInfo);
        }

        //---- buttonDeleteSelectedCar ----
        buttonDeleteSelectedCar.setText("Delete Selected");

        //---- buttonAddCar ----
        buttonAddCar.setText("Add Car");

        //---- buttonRefresh ----
        buttonRefresh.setText("Refresh & Save Change");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBoxSearchCarType, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textSearchCarContent, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(buttonSearchCar)
                    .addGap(35, 35, 35)
                    .addComponent(buttonRefresh)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(buttonDeleteSelectedCar)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(buttonAddCar)
                    .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(comboBoxSearchCarType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textSearchCarContent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSearchCar)
                        .addComponent(buttonDeleteSelectedCar)
                        .addComponent(buttonAddCar)
                        .addComponent(buttonRefresh))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox<String> comboBoxSearchCarType;
    private JTextField textSearchCarContent;
    private JButton buttonSearchCar;
    private JScrollPane scrollPane1;
    private JTable tableCarInfo;
    private JButton buttonDeleteSelectedCar;
    private JButton buttonAddCar;
    private JButton buttonRefresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    
    // 初始化表格
    private void initTable() {
        // 设置表格模型
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Car ID", "Brand", "Model", "Year", "License Plate", "Color", "Status", "Daily Fee"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 允许编辑除ID外的所有列
                return column != 0;
            }
        };
        tableCarInfo.setModel(model);
        
        // 设置表格列宽
        tableCarInfo.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableCarInfo.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableCarInfo.getColumnModel().getColumn(2).setPreferredWidth(120);
        tableCarInfo.getColumnModel().getColumn(3).setPreferredWidth(60);
        tableCarInfo.getColumnModel().getColumn(4).setPreferredWidth(120);
        tableCarInfo.getColumnModel().getColumn(5).setPreferredWidth(80);
        tableCarInfo.getColumnModel().getColumn(6).setPreferredWidth(100);
        tableCarInfo.getColumnModel().getColumn(7).setPreferredWidth(80);

        // 添加表格模型监听器，监听单元格编辑事件
        tableCarInfo.getModel().addTableModelListener(new javax.swing.event.TableModelListener() {
            @Override
            public void tableChanged(javax.swing.event.TableModelEvent e) {
                // 表格数据已更改，点击刷新按钮时会自动保存
            }
        });
    }
    
    // 加载车辆数据
    private void loadCarData() {
        try {
            carList = getAllCars();
            updateTable(carList);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading car data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // 获取所有车辆
    private List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        
        try (Connection conn = carrental.db.DBConnection.getConnection();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM cars ORDER BY id")) {
            
            while (rs.next()) {
                Car car = new Car();
                car.setCarID(rs.getString("id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setLicensePlate(rs.getString("license_plate"));
                car.setColor(rs.getString("color"));
                car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                car.setPrice(rs.getDouble("daily_fee"));
                car.setStock(rs.getInt("stock"));
                carList.add(car);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return carList;
    }
    
    // 更新表格数据
    private void updateTable(List<Car> carList) {
        DefaultTableModel model = (DefaultTableModel) tableCarInfo.getModel();
        model.setRowCount(0); // 清空表格
        
        for (Car car : carList) {
            model.addRow(new Object[]{
                car.getCarID(),
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getLicensePlate(),
                car.getColor(),
                car.getStatus(),
                car.getPrice()
            });
        }
    }
    
    // 设置事件监听器
    private void setupEventListeners() {
        // 搜索按钮事件
        buttonSearchCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCars();
            }
        });
        
        // 删除选中按钮事件
        buttonDeleteSelectedCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedCar();
            }
        });
        
        // 添加车辆按钮事件 - 根据要求，不实现此功能
        buttonAddCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ManageCars.this, "Add Car functionality is not implemented.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // 刷新按钮事件（合并保存和刷新功能）
        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAndRefreshTable();
            }
        });
    }
    
    // 搜索车辆
    private void searchCars() {
        String searchType = (String) comboBoxSearchCarType.getSelectedItem();
        String searchText = textSearchCarContent.getText().trim();
        
        if (searchText.isEmpty()) {
            loadCarData(); // 如果搜索内容为空，则显示所有车辆
            return;
        }
        
        List<Car> filteredList = new ArrayList<>();
        
        try {
            if ("Car ID".equals(searchType)) {
                // 按车辆ID搜索
                Car car = carDAO.findById(searchText);
                if (car != null) {
                    filteredList.add(car);
                }
            } else if ("License".equals(searchType)) {
                // 按车牌号搜索
                Car car = carDAO.findByLicense(searchText);
                if (car != null) {
                    filteredList.add(car);
                }
            } else if ("Model".equals(searchType)) {
                // 按车型搜索
                filteredList = carDAO.findByModel(searchText);
            } else if ("Color".equals(searchType)) {
                // 按颜色搜索
                filteredList = searchByColor(searchText);
            } else if ("Year".equals(searchType)) {
                // 按年份搜索
                try {
                    int year = Integer.parseInt(searchText);
                    filteredList = searchByYear(year);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error searching cars: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        updateTable(filteredList);
    }
    
    // 按颜色搜索车辆
    private List<Car> searchByColor(String color) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE color LIKE ?";
        try (Connection conn = carrental.db.DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + color + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setCarID(rs.getString("id"));
                    car.setBrand(rs.getString("brand"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getInt("year"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setColor(rs.getString("color"));
                    car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                    car.setPrice(rs.getDouble("daily_fee"));
                    car.setStock(rs.getInt("stock"));
                    cars.add(car);
                }
            }
        }
        return cars;
    }
    
    // 按年份搜索车辆
    private List<Car> searchByYear(int year) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE year = ?";
        try (Connection conn = carrental.db.DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, year);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setCarID(rs.getString("id"));
                    car.setBrand(rs.getString("brand"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getInt("year"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setColor(rs.getString("color"));
                    car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                    car.setPrice(rs.getDouble("daily_fee"));
                    car.setStock(rs.getInt("stock"));
                    cars.add(car);
                }
            }
        }
        return cars;
    }
    
    // 删除选中的车辆
    private void deleteSelectedCar() {
        int selectedRow = tableCarInfo.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a car to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this car?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            String carId = tableCarInfo.getValueAt(selectedRow, 0).toString();
            
            try {
                boolean success = deleteCar(carId);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Car deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadCarData(); // 重新加载数据
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete car.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error deleting car: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // 删除车辆
    private boolean deleteCar(String carId) throws SQLException {
        // 首先检查该车辆是否在租赁记录中有引用
        if (hasRentalRecords(carId)) {
            JOptionPane.showMessageDialog(this, "Cannot delete this car because it has rental records.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String sql = "DELETE FROM cars WHERE id = ?";
        try (Connection conn = carrental.db.DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, carId);
            return pstmt.executeUpdate() > 0;
        }
    }
    
    // 检查车辆是否有租赁记录
    private boolean hasRentalRecords(String carId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM rentals WHERE car_id = ?";
        try (Connection conn = carrental.db.DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, carId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    // 保存并刷新表格
    private void saveAndRefreshTable() {
        DefaultTableModel model = (DefaultTableModel) tableCarInfo.getModel();
        int rowCount = model.getRowCount();
        int colCount = model.getColumnCount();

        try {
            // 遍历表格中的每一行
            for (int row = 0; row < rowCount; row++) {
                // 获取车辆ID
                String carId = model.getValueAt(row, 0).toString();

                // 遍历每一列（除ID外的所有列）
                for (int col = 1; col < colCount; col++) {
                    Object newValue = model.getValueAt(row, col);
                    String columnName = model.getColumnName(col);

                    // 获取原始数据进行比较
                    Car originalCar = null;
                    for (Car car : carList) {
                        if (car.getCarID().equals(carId)) {
                            originalCar = car;
                            break;
                        }
                    }

                    if (originalCar != null) {
                        String oldValue = "";
                        if (col == 1) oldValue = originalCar.getBrand();
                        else if (col == 2) oldValue = originalCar.getModel();
                        else if (col == 3) oldValue = String.valueOf(originalCar.getYear());
                        else if (col == 4) oldValue = originalCar.getLicensePlate();
                        else if (col == 5) oldValue = originalCar.getColor();
                        else if (col == 6) oldValue = originalCar.getStatus().toString();
                        else if (col == 7) oldValue = String.valueOf(originalCar.getPrice());

                        // 如果值有变化，则更新数据库
                        if (!newValue.toString().equals(oldValue)) {
                            if ("Brand".equals(columnName)) {
                                carDAO.updateBrand(carId, newValue.toString());
                                originalCar.setBrand(newValue.toString());
                            } else if ("Model".equals(columnName)) {
                                carDAO.updateModel(carId, newValue.toString());
                                originalCar.setModel(newValue.toString());
                            } else if ("Year".equals(columnName)) {
                                try {
                                    int year = Integer.parseInt(newValue.toString());
                                    carDAO.updateYear(carId, year);
                                    originalCar.setYear(year);
                                } catch (NumberFormatException ex) {
                                    // 忽略无效的年份
                                }
                            } else if ("License Plate".equals(columnName)) {
                                carDAO.updateLicensePlate(carId, newValue.toString());
                                originalCar.setLicensePlate(newValue.toString());
                            } else if ("Color".equals(columnName)) {
                                carDAO.updateColor(carId, newValue.toString());
                                originalCar.setColor(newValue.toString());
                            } else if ("Status".equals(columnName)) {
                                try {
                                    Car.CarStatus status = Car.CarStatus.valueOf(newValue.toString().toUpperCase());
                                    carDAO.updateStatus(carId, status);
                                    originalCar.setStatus(status);
                                } catch (IllegalArgumentException ex) {
                                    // 忽略无效的状态
                                }
                            } else if ("Daily Fee".equals(columnName)) {
                                try {
                                    double fee = Double.parseDouble(newValue.toString());
                                    carDAO.updateDailyFee(carId, fee);
                                    originalCar.setPrice(fee);
                                } catch (NumberFormatException ex) {
                                    // 忽略无效的租金
                                }
                            }
                        }
                    }
                }
            }

            // 重新加载数据
            loadCarData();
        } catch (Exception ex) {
            // 静默处理异常，不显示弹窗
            ex.printStackTrace();
        }
    }
}
