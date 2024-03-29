import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Login extends JDialog {
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel Login_Panel;

    public Login(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(Login_Panel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnOK.addActionListener(e -> {
            String email = tfEmail.getText();
            String password = String.valueOf(pfPassword.getPassword());

            user = getAuthenticatedUser(email, password);

            if (user != null) {
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(Login.this,
                        "Email or Password Invalid",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        btnCancel.addActionListener(e -> dispose());

        setVisible(true);
    }

    public User user;
    private User getAuthenticatedUser(String email, String password) {
        User user = null;

        final String databaseName = "mylite";
        final String DB_URL = "jdbc:mysql://localhost:3306/" + databaseName;
        final String USERNAME = "root";
        final String PASSWORD = "123";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM login WHERE userEmail=? AND userPassword=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.email = resultSet.getString("userEmail");
                user.password = resultSet.getString("userPassword");
                user.name = resultSet.getString("userName");
                user.phone = resultSet.getString("userPhone");
                user.address = resultSet.getString("userAddress");
            }

            stmt.close();
            conn.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Login loginForm = new Login(null);
        User user = loginForm.user;
        if (user != null) {
            System.out.println("Successful Authentication of: " + user.name);
            System.out.println("          Email: " + user.email);
            System.out.println("          Phone: " + user.phone);
            System.out.println("          Address: " + user.address);

            Retailanime h = new Retailanime();
            h.setContentPane(h.panelMain);
            h.setTitle("Retailanime");
            h.setBounds(300, 200, 1280, 720);
            h.setVisible(true);
            h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else {
            System.out.println("Authentication canceled");
        }
    }
}