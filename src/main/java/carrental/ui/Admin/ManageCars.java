/*
 * Created by JFormDesigner on Tue Nov 18 19:00:06 SGT 2025
 */

package carrental.ui.Admin;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author LengxiQwQ
 */
public class ManageCars extends JPanel {
    public ManageCars() {
        initComponents();
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
            scrollPane1.setViewportView(tableCarInfo);
        }

        //---- buttonDeleteSelectedCar ----
        buttonDeleteSelectedCar.setText("Delete Selected");

        //---- buttonAddCar ----
        buttonAddCar.setText("Add Car");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBoxSearchCarType, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                    .addGap(73, 73, 73)
                    .addComponent(textSearchCarContent, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(buttonSearchCar)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                    .addComponent(buttonDeleteSelectedCar)
                    .addGap(18, 18, 18)
                    .addComponent(buttonAddCar)
                    .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(comboBoxSearchCarType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonDeleteSelectedCar)
                            .addComponent(buttonAddCar))
                        .addComponent(textSearchCarContent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSearchCar))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
