import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResultQuery extends JFrame{
    private JButton closeButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    JPanel Query;

    public ResultQuery() {
        textField1.setText(Retailanime.Item_id);
        textField2.setText(Retailanime.ItemName);
        textField3.setText(Retailanime.Descript);
        textField4.setText(Retailanime.Media);
        textField5.setText(Retailanime.Attributes);
        textField6.setText(Retailanime.Stock);
        textField7.setText(Retailanime.Ordr_id);
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);
        textField6.setEditable(false);
        textField7.setEditable(false);
        closeButton.addActionListener(e -> dispose());
    }
}
