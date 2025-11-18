/*
 * Created by JFormDesigner on Tue Nov 18 00:28:17 SGT 2025
 */

package carrental.ui.Staff;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author LengxiQwQ
 */
public class SearchCarsPanel extends JPanel {
    public SearchCarsPanel() {
        initComponents();
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
        setLayout(new FormLayout(
            "default, $lcgap, 56dlu, $lcgap, 107dlu, $lcgap, 30dlu, $lcgap, 136dlu, $lcgap, 66dlu",
            "2*(default, $lgap), 306dlu"));

        //---- label1 ----
        label1.setText("Search Type");
        add(label1, CC.xy(3, 3));

        //---- comboBoxSearchType ----
        comboBoxSearchType.setModel(new DefaultComboBoxModel<>(new String[] {
            "ID",
            "License",
            "Model"
        }));
        add(comboBoxSearchType, CC.xy(5, 3));
        add(textSearchContent, CC.xy(9, 3));

        //---- buttonSearchCar ----
        buttonSearchCar.setText("Search Car");
        add(buttonSearchCar, CC.xy(11, 3));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tableCarInfo);
        }
        add(scrollPane1, CC.xywh(3, 5, 9, 1));
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
}
