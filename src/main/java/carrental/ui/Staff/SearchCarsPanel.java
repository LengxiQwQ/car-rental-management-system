/*
 * Created by JFormDesigner on Tue Nov 18 00:28:17 SGT 2025
 */

package carrental.ui.Staff;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import java.util.List;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import carrental.model.Car;
import carrental.service.CarService;
/**
 * @author LengxiQwQ
 */
public class SearchCarsPanel extends JPanel {
    public SearchCarsPanel() {
        initComponents();
        initListeners();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxSearchType = new JComboBox<>();
        textSearchContent = new JTextField();
        buttonSearchCar = new JButton();
        scrollPane1 = new JScrollPane();
        tableCarInfo = new JTable();

        //======== this ========

        //---- label1 ----
        label1.setText("Search Type");

        //---- comboBoxSearchType ----
        comboBoxSearchType.setModel(new DefaultComboBoxModel<>(new String[] {
            "ID",
            "License",
            "Model"
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
                    {null, null, null, null},
                },
                new String[] {
                    null, null, null, null
                }
            ));
            scrollPane1.setViewportView(tableCarInfo);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBoxSearchType, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                    .addComponent(textSearchContent, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(buttonSearchCar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                    .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxSearchType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(buttonSearchCar)
                        .addComponent(textSearchContent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox<String> comboBoxSearchType;
    private JTextField textSearchContent;
    private JButton buttonSearchCar;
    private JScrollPane scrollPane1;
    private JTable tableCarInfo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    // 在SearchCarsPanel类中添加
    private void initListeners() {
        buttonSearchCar.addActionListener(e -> searchCars());
    }

    private void searchCars() {
        String searchType = (String) comboBoxSearchType.getSelectedItem();
        String content = textSearchContent.getText().trim();

        new SwingWorker<List<Car>, Void>() {
            @Override
            protected List<Car> doInBackground() throws Exception {
                CarService service = new CarService();
                switch (searchType) {
                    case "ID": return service.getCarById(content);
                    case "License": return service.getCarByLicense(content);
                    case "Model": return service.getCarsByModel(content);
                    default: return Collections.emptyList();
                }
            }

            @Override
            protected void done() {
                try {
                    List<Car> cars = get();
                    DefaultTableModel model = (DefaultTableModel) tableCarInfo.getModel();
                    model.setColumnIdentifiers(new String[]{"ID", "车牌", "型号", "颜色", "状态"});
                    model.setRowCount(0);
                    for (Car car : cars) {
                        model.addRow(new Object[]{
                                car.getId(), car.getLicensePlate(), car.getModel(),
                                car.getColor(), car.getStatus()
                        });
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SearchCarsPanel.this, "搜索失败: " + ex.getMessage());
                }
            }
        }.execute();
    }

}
