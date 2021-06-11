
import java.util.Scanner;

public class StressMachine {

    public int reply (String msg) {

        int result = 0;
        String exitmsg = "계속하시겠습니까? (y/n)";

        if (msg.contains("?") || msg.contains("죽을래") || msg.contains("힘들어")) {
            result = 0;
            System.out.println("죄송합니다");

        } else {
            result = 1;
            System.out.println(exitmsg);
        }

        return result;
    }

    public static void main(String[] args) {

        StressMachine sm = new StressMachine();

        Scanner sc = new Scanner(System.in);
        String msg = "";
        while(true) {
            if(msg != "그만하자") {
                System.out.print("하고싶은 말 : ");
                msg = sc.next();
                if (sm.reply(msg) == 0) {

                }else {
                    String choice = sc.next();

                    if (choice.equals("y") || choice.equals("Y")) {
                        continue;
                    } else {
                        System.out.println("프로그램을 종료합니다");
                        break;
                    }
                }

            } else {
                System.out.println("스트레스봇을 종료합니다.");
            }

        }
    }
}
