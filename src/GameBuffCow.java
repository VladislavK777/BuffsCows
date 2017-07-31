import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameBuffCow {
    public static void main(String[] args) throws IOException {
        ProcessCalc processCalc = new ProcessCalc();
        UserNumber userNumber = new UserNumber(processCalc);
        JFrame frame = new JFrame("Buffs&Cows");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 485));
        frame.setResizable(false);
        frame.setContentPane(userNumber.getGui());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
