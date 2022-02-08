import static org.assertj.core.api.Assertions.assertThat;
import com.realdolmen.devops.greeting.GreetingController;
import org.junit.jupiter.api.Test;
public class GreetingControllerTest {

    private GreetingController greetingController = new GreetingController();
    @Test
    void whenCallingGreetingMethod_returnHello() {
        String answer = greetingController.hello();
        assertThat(answer).isEqualTo("hello");
    }
}
