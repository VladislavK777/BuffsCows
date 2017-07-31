import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

//Controller
public class UserNumber extends KeyAdapter {
    private ProcessCalc processCalc;
    private GUI gui;
    boolean finishGame = false;
    int startPosX = 10;


    public UserNumber(ProcessCalc processCalc) {
        this.processCalc = processCalc;
        this.gui = new GUI(this);
    }

    public void newGame() throws IOException {
        processCalc.newGameRandomNumber();
        gui.historyPanel.removeAll();
        startPosX = 10;
        gui.button.setEnabled(true);
        gui.textField.setEnabled(true);
    }

    public int getBuffs() {
        return processCalc.buffs;
    }

    public int getCows() {
        return processCalc.cows;
    }

    public int getCount() {
        return processCalc.count;
    }

    public ArrayList<Integer> getNumber() {
        return processCalc.getRandomNumber();
    }

    public GUI getGui() {
        return gui;
    }

    public String getExtBuff() {
        return processCalc.ext_buff;
    }

    public String getExtCows() {
        return processCalc.ext_cow;
    }

    public void userNum(String s) throws IOException {
        gui.leftLabel.setText("Введите число!");
        String read = s;

        if (read.length() != 4) {
            gui.leftLabel.setText("Число должно быть 4х значное!");
            return;
        }

        String[] read_split = read.split("");

        if (read_split[0].equals(read_split[1]) ||
                read_split[0].equals(read_split[2]) ||
                read_split[0].equals(read_split[3]) ||
                read_split[1].equals(read_split[2]) ||
                read_split[1].equals(read_split[3]) ||
                read_split[2].equals(read_split[3])) {
            gui.leftLabel.setText("Числа не должны повторяться!");
            return;
        }
        processCalc.setDigUser(read_split);

        try {
            processCalc.processCal();
        } catch (NumberFormatException e) {
            gui.leftLabel.setText("Введите число!");
            return;
        }

        addLabel(getCount() + ". " + gui.textField.getText() + " - " + getBuffs() + " " + getExtBuff() + " и " + getCows() + " " + getExtCows());

        if (getBuffs() == 4) {
            finishGame = true;
        }

        if (finishGame) {
            addLabel("Вы угадали с " + getCount() + "-ой попытки!");
            gui.button.setEnabled(false);
            gui.textField.setEnabled(false);
        }
    }

    public void addLabel(String text) {
        JLabel label = new JLabel(text);
        label.setBounds(10, startPosX, 200, 15);
        startPosX += 20;
        gui.historyPanel.add(label);
        gui.historyPanel.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                userNum(gui.textField.getText());
                gui.textField.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
