import events.MessageEventListener;
import events.ReadyEventListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static void main(String[] args) throws LoginException {

        final String TOKEN = "MTE5MjAxMzAxNTM0ODk1MzEyOQ.GWLNjd.FhLLaFGhOHyFW4EEsygDfIvGoQgZyidBm0K4wU";
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);


          jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                  .addEventListeners(new ReadyEventListener(), new MessageEventListener())
                  .build();

    }
}
