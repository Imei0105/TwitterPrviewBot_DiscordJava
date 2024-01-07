package events;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEventListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);

//        String twitterExist = "https://twitter\\.com/";
//        Pattern twitterPattern = Pattern.compile(twitterExist);
//        Matcher twitterMatcher = twitterPattern.matcher(""+event.getMessage());

        String twitterUrlCheck = "https://twitter.com/";

        if(event.getAuthor().isBot())
            return;
        else{
            if(event.getMessage().getContentDisplay().equalsIgnoreCase("?help")){
                event.getChannel().sendMessage("Bot is on duty").queue();
            }else if(event.getMessage().getContentDisplay().contains(twitterUrlCheck)){
                StringBuilder sb = new StringBuilder(""+event.getMessage().getContentDisplay());
                sb.insert(8,"vx");
                String twitterPreviewString = sb.toString();

                event.getChannel().sendMessage(twitterPreviewString).queue();
            }

        }

//        System.out.println("User send: "+event.getMessage().getContentDisplay());
    }
}
