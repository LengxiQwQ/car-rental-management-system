/*
 * Created by JFormDesigner on Tue Nov 18 18:59:51 SGT 2025
 */

package carrental.ui.Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.SwingWorker;
import javax.swing.table.*;
import java.util.List;
import carrental.model.SystemLog;
import carrental.service.LogService;
import com.toedter.calendar.*;

/**
 * @author LengxiQwQ
 */
public class SystemLogs extends JPanel {
    private LogService logService = new LogService();
    
    public SystemLogs() {
        initComponents();
        initEventHandlers();
        loadAllLogs();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxFilterbyUser = new JComboBox();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        tableLogRecords = new JTable();
        dateChooserFilterbyDate = new JDateChooser();
        label10 = new JLabel();
        buttonRefresh = new JButton();
        buttonEnterFilterbyDate = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Filter by User");

        //---- label2 ----
        label2.setText("Filter by Date");

        //======== scrollPane1 ========
        {

            //---- tableLogRecords ----
            tableLogRecords.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "操作人", "操作类型", "详情", "时间", "结果"
                }
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // 禁止编辑表格单元格
                }
            });
            
            // 设置表格列宽
            tableLogRecords.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
            tableLogRecords.getColumnModel().getColumn(1).setPreferredWidth(100); // 操作人
            tableLogRecords.getColumnModel().getColumn(2).setPreferredWidth(100); // 操作类型
            tableLogRecords.getColumnModel().getColumn(3).setPreferredWidth(300); // 详情
            tableLogRecords.getColumnModel().getColumn(4).setPreferredWidth(150); // 时间
            tableLogRecords.getColumnModel().getColumn(5).setPreferredWidth(80);  // 结果
            scrollPane1.setViewportView(tableLogRecords);
        }

        //---- label10 ----
        label10.setText("Log Records");
        label10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        label10.setHorizontalAlignment(SwingConstants.CENTER);

        //---- buttonRefresh ----
        buttonRefresh.setText("Refresh");

        //---- buttonEnterFilterbyDate ----
        buttonEnterFilterbyDate.setText("Enter");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboBoxFilterbyUser, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116)
                            .addComponent(buttonRefresh)
                            .addGap(76, 76, 76)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateChooserFilterbyDate, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonEnterFilterbyDate))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(375, 375, 375)
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 968, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(label10)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBoxFilterbyUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1)
                                    .addComponent(buttonRefresh)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(buttonEnterFilterbyDate)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateChooserFilterbyDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // 初始化事件处理器
    private void initEventHandlers() {
        buttonRefresh.addActionListener(e -> loadAllLogs());
        buttonEnterFilterbyDate.addActionListener(e -> filterLogsByDate());
    }
    
    // 加载所有日志
    private void loadAllLogs() {
        new SwingWorker<List<SystemLog>, Void>() {
            @Override
            protected List<SystemLog> doInBackground() {
                return logService.getAllLogs();
            }

            @Override
            protected void done() {
                try {
                    updateTable(get());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(SystemLogs.this, "加载日志失败: " + e.getMessage());
                }
            }
        }.execute();
    }
    
    // 按日期筛选日志
    private void filterLogsByDate() {
        LocalDateTime selectedDate = null;
        if (dateChooserFilterbyDate.getDate() != null) {
            selectedDate = dateChooserFilterbyDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime startOfDay = selectedDate.withHour(0).withMinute(0).withSecond(0).withNano(0);
            LocalDateTime endOfDay = selectedDate.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
            
            new SwingWorker<List<SystemLog>, Void>() {
                @Override
                protected List<SystemLog> doInBackground() {
                    return logService.getLogsByFilter(null, startOfDay, endOfDay);
                }

                @Override
                protected void done() {
                    try {
                        updateTable(get());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(SystemLogs.this, "筛选日志失败: " + e.getMessage());
                    }
                }
            }.execute();
        } else {
            loadAllLogs();
        }
    }
    
    // 更新表格数据
    private void updateTable(List<SystemLog> logs) {
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"ID", "操作人", "操作类型", "详情", "时间", "结果"}, 0
        );

        for (SystemLog log : logs) {
            model.addRow(new Object[]{
                    log.getLogId(),
                    log.getUsername(),
                    log.getOperationType(),
                    log.getOperationDetails(),
                    log.getOperationTime(),
                    log.getResult()
            });
        }
        tableLogRecords.setModel(model);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox comboBoxFilterbyUser;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable tableLogRecords;
    private JDateChooser dateChooserFilterbyDate;
    private JLabel label10;
    private JButton buttonRefresh;
    private JButton buttonEnterFilterbyDate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}
