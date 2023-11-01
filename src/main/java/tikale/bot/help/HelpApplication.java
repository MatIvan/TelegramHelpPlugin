package tikale.bot.help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HelpApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelpApplication.class, args);
    }

}
