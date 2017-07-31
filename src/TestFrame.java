import java.security.MessageDigest;

public class TestFrame {
    static int n = 0;

    public String sha256(String base) {
        StringBuilder builder = new StringBuilder(base);
        StringBuffer hexString = new StringBuffer();
        builder.append(n);
        System.out.println(builder.toString());
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(builder.toString().getBytes());
            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) {
                hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

            }
            n += 1;
            //System.out.println(builder.toString());
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        TestFrame testFrame = new TestFrame();
        String s = testFrame.sha256("ВЛАД 100Р ВАНЕ;ВЛАД 50Р КАТЕ;");
        while (!s.substring(0, 5).equals("00000")) {
            s = testFrame.sha256("ВЛАД 100Р ВАНЕ;ВЛАД 50Р КАТЕ;");
            //System.out.println(s + " " + n);
        }
        System.out.println(s);

    }
}
