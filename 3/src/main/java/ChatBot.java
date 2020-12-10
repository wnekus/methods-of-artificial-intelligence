import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.configuration.BotConfiguration;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args){
        var bot = new Bot(BotConfiguration.builder()
                                .name("DarekBot")
                                .path("src/main/resources")
                                .build());

        var chatSession = new Chat(bot);

        var input = new Scanner(System.in);
        while (!input.equals("exit")){
            var text = input.nextLine();
            var answer = chatSession.multisentenceRespond(text);
            System.out.println(answer);
        }
    }
}
