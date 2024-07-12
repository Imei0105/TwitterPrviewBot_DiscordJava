import events.MessageEventListener;
import events.ReadyEventListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static void main(String[] args) throws LoginException {

        final String TOKEN = System.getenv("TOKEN");
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);


          jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                  .addEventListeners(new ReadyEventListener(), new MessageEventListener())
                  .build();

    }
}
