import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//View
public class GUI extends JPanel {
    private UserNumber userNumber;

    JTextField textField = new JTextField(10);
    JLabel leftLabel = new JLabel("Введите число:");
    JButton button = new JButton("Enter");
    JButton buttonNewGame = new JButton("New game");
    JPanel historyPanel = new JPanel();

    public GUI(UserNumber userNumber) {
        this.userNumber = userNumber;

        this.addKeyListener(userNumber);

        this.setLayout(null);
        historyPanel.setLayout(null);

        historyPanel.setBounds(220, 0, 210, 450);
        leftLabel.setBounds(10, 10, 200, 15);
        textField.setBounds(10, 30, 100, 20);
        button.setBounds(10, 60, 100, 30);
        buttonNewGame.setBounds(10, 100, 100, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userNumber.userNum(textField.getText());
                    textField.setText("");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userNumber.newGame();
                    historyPanel.repaint();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.add(historyPanel);
        this.add(leftLabel);
        this.add(textField);
        this.add(button);
        this.add(buttonNewGame);
    }
}
