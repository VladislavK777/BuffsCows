import java.io.IOException;
import java.util.ArrayList;

//Model
public class ProcessCalc {
    int count;
    int buffs;
    int cows;
    int a, b, c, d;
    private ArrayList<Integer> randomNumber;
    private String[] digUser;
    String ext_buff;
    String ext_cow;

    public ProcessCalc() throws IOException {
        this.randomNumber = randomNumber();
    }

    public void newGameRandomNumber() {
        this.randomNumber = randomNumber();
        count = 0;
    }

    public ArrayList<Integer> getRandomNumber() {
        return randomNumber;
    }

    private ArrayList<Integer> randomNumber() {
        ArrayList<Integer> dig = new ArrayList<>();
        a = (int) (Math.random() * 10);
        b = (int) (Math.random() * 10);
        c = (int) (Math.random() * 10);
        d = (int) (Math.random() * 10);
        while (b == a) {
            b = (int) (Math.random() * 10);
        }
        while (c == a || c == b) {
            c = (int) (Math.random() * 10);
        }
        while (d == a || d == b || d == c) {
            d = (int) (Math.random() * 10);
        }
        dig.add(a);
        dig.add(b);
        dig.add(c);
        dig.add(d);

        return dig;
    }

    public void setDigUser(String[] digUser) {
        this.digUser = digUser;
    }

    public void processCal() throws IOException {
        buffs = 0;
        cows = 0;

        if (randomNumber.get(0) == Integer.parseInt(digUser[0])) {
            buffs++;
        }
        if (randomNumber.get(1) == Integer.parseInt(digUser[1])) {
            buffs++;
        }
        if (randomNumber.get(2) == Integer.parseInt(digUser[2])) {
            buffs++;
        }
        if (randomNumber.get(3) == Integer.parseInt(digUser[3])) {
            buffs++;
        }
        if (randomNumber.get(0) != Integer.parseInt(digUser[0]) && randomNumber.contains(Integer.parseInt(digUser[0]))) {
            cows++;
        }
        if (randomNumber.get(1) != Integer.parseInt(digUser[1]) && randomNumber.contains(Integer.parseInt(digUser[1]))) {
            cows++;
        }
        if (randomNumber.get(2) != Integer.parseInt(digUser[2]) && randomNumber.contains(Integer.parseInt(digUser[2]))) {
            cows++;
        }
        if (randomNumber.get(3) != Integer.parseInt(digUser[3]) && randomNumber.contains(Integer.parseInt(digUser[3]))) {
            cows++;
        }
        if (buffs == 1) {
            ext_buff = "бык";
        } else if (buffs > 1) {
            ext_buff = "быка";
        } else if (buffs == 0) {
            ext_buff = "быков";
        }
        if (cows == 1) {
            ext_cow = "корова";
        } else if (cows > 1) {
            ext_cow = "коровы";
        } else if (cows == 0) {
            ext_cow = "коров";
        }
        count++;
    }
}
