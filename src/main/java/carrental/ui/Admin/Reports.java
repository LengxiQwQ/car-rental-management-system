/*
 * Created by JFormDesigner on Tue Nov 18 18:59:59 SGT 2025
 */

package carrental.ui.Admin;

import carrental.model.Car;
import carrental.model.Rental;
import carrental.service.CarService;
import carrental.service.RentalService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.*;
import com.toedter.calendar.*;
import java.util.Date;

/**
 * @author LengxiQwQ
 */
public class Reports extends JPanel {
    private RentalService rentalService;
    private CarService carService;
    
    public Reports() {
        rentalService = new RentalService();
        carService = new CarService();
        initComponents();
        
        // 初始化表格列名
        String[] columnNames = {"Rental ID", "Customer Name", "Car Model", "Start Date", "Expected Return", "Actual Return", "Status", "Total Cost"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tableRentalHistory.setModel(model);
        
        // 加载初始数据
        loadRentalData();
        updateStatistics();
        
        // 添加按钮事件监听器
        buttonGenerateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReportByDate();
            }
        });
        
        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadRentalData();
                updateStatistics();
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        tableRentalHistory = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        buttonGenerateReport = new JButton();
        label9 = new JLabel();
        dateChooserFromDate = new JDateChooser();
        dateChooserToDate = new JDateChooser();
        label4 = new JLabel();
        label5 = new JLabel();
        labelTotalRentals = new JLabel();
        labelAvailableCars = new JLabel();
        label10 = new JLabel();
        buttonRefresh = new JButton();

        //======== this ========

        //======== scrollPane1 ========
        {

            //---- tableRentalHistory ----
            tableRentalHistory.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(tableRentalHistory);
        }

        //---- label1 ----
        label1.setText("From date");

        //---- label2 ----
        label2.setText("To date");

        //---- buttonGenerateReport ----
        buttonGenerateReport.setText("Generate Report");

        //---- label9 ----
        label9.setText("Reports");
        label9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        label9.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label4 ----
        label4.setText("Total Rentals: ");

        //---- label5 ----
        label5.setText("Available Cars: ");

        //---- labelTotalRentals ----
        labelTotalRentals.setText("0");

        //---- labelAvailableCars ----
        labelAvailableCars.setText("0");

        //---- label10 ----
        label10.setText("Rental History");
        label10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        label10.setHorizontalAlignment(SwingConstants.CENTER);

        //---- buttonRefresh ----
        buttonRefresh.setText("Refresh");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 51, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(18, 18, 18)
                                    .addComponent(labelTotalRentals))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelAvailableCars))
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 42, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonGenerateReport, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                    .addComponent(buttonRefresh))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(dateChooserToDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateChooserFromDate, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 671, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(225, 225, 225)
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label10))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(labelTotalRentals))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(labelAvailableCars))
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                .addComponent(dateChooserFromDate, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(dateChooserToDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonGenerateReport, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonRefresh, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                            .addGap(222, 222, 222))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(25, Short.MAX_VALUE))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable tableRentalHistory;
    private JLabel label1;
    private JLabel label2;
    private JButton buttonGenerateReport;
    private JLabel label9;
    private JDateChooser dateChooserFromDate;
    private JDateChooser dateChooserToDate;
    private JLabel label4;
    private JLabel label5;
    private JLabel labelTotalRentals;
    private JLabel labelAvailableCars;
    private JLabel label10;
    private JButton buttonRefresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    
    // 加载所有租赁数据到表格
    private void loadRentalData() {
        try {
            List<Rental> rentals = rentalService.getAllRentals();
            updateTableData(rentals);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading rental data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // 根据日期范围生成报告
    private void generateReportByDate() {
        Date fromDate = dateChooserFromDate.getDate();
        Date toDate = dateChooserToDate.getDate();
        
        if (fromDate == null || toDate == null) {
            JOptionPane.showMessageDialog(this, "Please select both from and to dates", "Date Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (fromDate.after(toDate)) {
            JOptionPane.showMessageDialog(this, "From date cannot be after to date", "Date Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            List<Rental> rentals = rentalService.getAllRentals();
            
            // 筛选日期范围内的租赁记录
            rentals.removeIf(rental -> {
                java.util.Date rentalDate = java.sql.Date.valueOf(rental.getStartDate());
                return rentalDate.before(fromDate) || rentalDate.after(toDate);
            });
            
            updateTableData(rentals);
            
            // 显示筛选后的统计信息
            labelTotalRentals.setText(String.valueOf(rentals.size()));
            
            JOptionPane.showMessageDialog(this, "Report generated successfully for the selected date range", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error generating report: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // 更新表格数据
    private void updateTableData(List<Rental> rentals) {
        DefaultTableModel model = (DefaultTableModel) tableRentalHistory.getModel();
        model.setRowCount(0); // 清空现有数据
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        for (Rental rental : rentals) {
            Vector<Object> row = new Vector<>();
            row.add(rental.getRentalID());
            row.add(rental.getCustomer().getcustomerName());
            row.add(rental.getCar().getModel());
            row.add(dateFormat.format(java.sql.Date.valueOf(rental.getStartDate())));
            row.add(dateFormat.format(java.sql.Date.valueOf(rental.getExpectedReturnDate())));
            
            if (rental.getActualReturnDate() != null) {
                row.add(dateFormat.format(java.sql.Date.valueOf(rental.getActualReturnDate())));
            } else {
                row.add("Not Returned");
            }
            
            row.add(rental.getStatus());
            row.add(String.format("%.2f", rental.getTotalCost()));
            
            model.addRow(row);
        }
    }
    
    // 更新统计信息
    private void updateStatistics() {
        try {
            // 获取所有租赁记录
            List<Rental> rentals = rentalService.getAllRentals();
            labelTotalRentals.setText(String.valueOf(rentals.size()));
            
            // 获取可用车辆数量
            List<Car> availableCars = carService.getAvailableCars();
            labelAvailableCars.setText(String.valueOf(availableCars.size()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating statistics: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
