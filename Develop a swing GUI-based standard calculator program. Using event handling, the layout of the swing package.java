Develop a swing GUI-based standard calculator program. Using event handling, the
layout of the swing package




import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    // Text field to display numbers and results
    private JTextField textField;

    // Buttons for digits and operations
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, clrButton, delButton;

    // Panel to hold buttons
    private JPanel panel;

    // Variables for calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        setTitle("Standard Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Text field setup
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        add(textField);

        // Button setup
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("DEL");

        // Add ActionListener
        JButton[] functionButtons = {addButton, subButton, mulButton, divButton, decButton, equButton, clrButton, delButton};
        for (JButton btn : functionButtons) {
            btn.addActionListener(this);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
        }

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
        }

        // Panel for buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 350);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Add buttons to panel
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);

        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(addButton);

        panel.add(clrButton);
        panel.add(delButton);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
                return;
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText() + ".");
        } else if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                        textField.setText("");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        } else if (e.getSource() == clrButton) {
            textField.setText("");
        } else if (e.getSource() == delButton) {
            String text = textField.getText();
            if (text.length() > 0) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
