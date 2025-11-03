Write a GUI-based program to create a student registration and login. Store
Registration data in the Database and take Login information from the Database.




import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentAuth extends JFrame implements ActionListener {

    // Components for Registration
    private JTextField regName, regEmail;
    private JPasswordField regPassword;
    private JButton regButton, switchToLoginButton;

    // Components for Login
    private JTextField loginEmail;
    private JPasswordField loginPassword;
    private JButton loginButton, switchToRegButton;

    // Database connection
    private Connection con;

    public StudentAuth() {
        // Database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb", "root", "your_password");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed: " + e.getMessage());
            System.exit(0);
        }

        setTitle("Student Registration & Login");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        // Registration Panel
        JPanel regPanel = new JPanel();
        regPanel.setLayout(new GridLayout(5, 2, 10, 10));

        regPanel.add(new JLabel("Name:"));
        regName = new JTextField();
        regPanel.add(regName);

        regPanel.add(new JLabel("Email:"));
        regEmail = new JTextField();
        regPanel.add(regEmail);

        regPanel.add(new JLabel("Password:"));
        regPassword = new JPasswordField();
        regPanel.add(regPassword);

        regButton = new JButton("Register");
        regButton.addActionListener(this);
        regPanel.add(regButton);

        switchToLoginButton = new JButton("Go to Login");
        switchToLoginButton.addActionListener(this);
        regPanel.add(switchToLoginButton);

        add(regPanel, "registration");

        // Login Panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 2, 10, 10));

        loginPanel.add(new JLabel("Email:"));
        loginEmail = new JTextField();
        loginPanel.add(loginEmail);

        loginPanel.add(new JLabel("Password:"));
        loginPassword = new JPasswordField();
        loginPanel.add(loginPassword);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);

        switchToRegButton = new JButton("Go to Register");
        switchToRegButton.addActionListener(this);
        loginPanel.add(switchToRegButton);

        add(loginPanel, "login");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) getContentPane().getLayout();

        try {
            if (e.getSource() == regButton) {
                String name = regName.getText();
                String email = regEmail.getText();
                String password = String.valueOf(regPassword.getPassword());

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields!");
                    return;
                }

                // Insert registration data into DB
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO students(name, email, password) VALUES (?, ?, ?)");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);

                int inserted = ps.executeUpdate();
                if (inserted > 0) {
                    JOptionPane.showMessageDialog(this, "Registration Successful!");
                    regName.setText(""); regEmail.setText(""); regPassword.setText("");
                }

            } else if (e.getSource() == loginButton) {
                String email = loginEmail.getText();
                String password = String.valueOf(loginPassword.getPassword());

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Email and Password!");
                    return;
                }

                // Verify login credentials
                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM students WHERE email=? AND password=?");
                ps.setString(1, email);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + rs.getString("name"));
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Email or Password!");
                }

            } else if (e.getSource() == switchToLoginButton) {
                cl.show(getContentPane(), "login");
            } else if (e.getSource() == switchToRegButton) {
                cl.show(getContentPane(), "registration");
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(this, "Email already exists. Try another email.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentAuth();
    }
}
