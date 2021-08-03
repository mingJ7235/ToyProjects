import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ReplaceTest {

    @Autowired
            @Qualifier("SmsProvider")
    NotificationProvider sendManager;

    @Test
    void ReplaceTest() {
        System.out.println("RESUST : "+ "abc #{고객이름} #{고객정보1} bbc"
                .replaceAll("#\\{고객이름}", "김현욱"));
    }

    @Test
    @SuppressWarnings("serial")
    void KakaoSendTest() {
        Member member = new Member();
        MemberPlan plan = new MemberPlan();
        String templateCode = "기간 만료 안내";
        Map<String, String> criteria = CriteriaBuilder.member(member).build();

        sendManager.sendMessage(templateCode, criteria);
    }
}
