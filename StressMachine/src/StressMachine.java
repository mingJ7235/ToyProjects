import java.util.Scanner;

public class StressMachine {

    public String reply (String msg) {

        String result = "";

        if (msg.contains("?") || msg.contains("죽을래") || msg.contains("힘들어")) {
            result = "죄송합니다";
        }

        return result;
    }

    public static void main(String[] args) {

        StressMachine sm = new StressMachine();

        Scanner sc = new Scanner(System.in);
        String msg = "";

        System.out.print("하고싶은 말 : ");
        msg = sc.next();

        sm.reply(msg);
    }
}
