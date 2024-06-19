import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMGUI extends JFrame {
    private double balance;
    private JTextField amountField;
    private JTextArea displayArea;

    public ATMGUI() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        balance = 0.0;

        // Creating the display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setText("Balance: " + balance);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Creating the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        inputPanel.add(new JLabel("Enter amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawListener());
        inputPanel.add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositListener());
        inputPanel.add(depositButton);

        add(inputPanel, BorderLayout.NORTH);

        // Creating the bottom panel for balance check and exit
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new CheckBalanceListener());
        bottomPanel.add(checkBalanceButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.addActionListener(new ExitListener());
        bottomPanel.add(exitButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private class WithdrawListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (balance >= amount) {
                    balance -= amount;
                    displayArea.setText("Balance: " + balance + "\nPlease collect your money.");
                } else {
                    displayArea.setText("Balance: " + balance + "\nInsufficient balance.");
                }
            } catch (NumberFormatException ex) {
                displayArea.setText("Balance: " + balance + "\nInvalid amount.");
            }
            amountField.setText("");
        }
    }

    private class DepositListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                balance += amount;
                displayArea.setText("Balance: " + balance + "\nYour money has been successfully deposited.");
            } catch (NumberFormatException ex) {
                displayArea.setText("Balance: " + balance + "\nInvalid amount.");
            }
            amountField.setText("");
        }
    }

    private class CheckBalanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("Balance: " + balance);
        }
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ATMGUI.this, "Thank you for using the ATM. Goodbye!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATMGUI atmGUI = new ATMGUI();
            atmGUI.setVisible(true);
        });
    }
}
