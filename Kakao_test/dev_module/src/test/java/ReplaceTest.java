import org.junit.jupiter.api.Test;

public class ReplaceTest {

    @Test
    void ReplaceTest() {
        System.out.println("RESUST : "+ "abc #{고객이름} #{고객정보1} bbc"
                .replaceAll("#\\{고객이름}", "김현욱"));
    }
}
