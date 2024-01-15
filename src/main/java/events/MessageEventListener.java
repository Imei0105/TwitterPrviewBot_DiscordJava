package events;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class MessageEventListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);


        String twitterUrlCheck = "https://twitter.com/";
        String xUrlCheck = "https://x.com/";
        String redditUrlCheck = "https://www.reddit.com/";
        String instagramCheck = "https://www.instagram.com/";
        String tiktokCheck = "https://www.tiktok.com/";


        if (event.getAuthor().isBot())
            return;
        else {
            if (event.getMessage().getContentDisplay().equalsIgnoreCase("?help")) {
                event.getChannel().sendMessage("Bot is on duty").queue();
            } else if (event.getMessage().getContentDisplay().contains(twitterUrlCheck)) {
                StringBuilder sb = new StringBuilder("" + event.getMessage().getContentDisplay());
                sb.insert(8, "vx");
                sb.insert(0, "[Preview]");
                sb.insert(9, "(");
                sb.append(")");
                String twitterPreviewString = sb.toString();

                event.getChannel().sendMessage(twitterPreviewString).queue();
            } else if (event.getMessage().getContentDisplay().contains(xUrlCheck)) {
                StringBuilder sb = new StringBuilder("" + event.getMessage().getContentDisplay());
                sb.insert(8, "v");
                sb.insert(10, "twitter");
                sb.insert(0, "[Preview]");
                sb.insert(9, "(");
                sb.append(")");
                String twitterPreviewString = sb.toString();

                event.getChannel().sendMessage(twitterPreviewString).queue();
            } else if (event.getMessage().getContentDisplay().contains(redditUrlCheck)) {
                StringBuilder sb = new StringBuilder("" + event.getMessage().getContentDisplay());
                sb.deleteCharAt(13);
                sb.insert(13, "x");
                sb.insert(0, "[Preview]");
                sb.insert(9, "(");
                sb.append(")");
                String twitterPreviewString = sb.toString();

                event.getChannel().sendMessage(twitterPreviewString).queue();
            } else if (event.getMessage().getContentDisplay().contains(instagramCheck)) {
                StringBuilder sb = new StringBuilder("" + event.getMessage().getContentDisplay());
                sb.insert(21, "ez");
                sb.insert(0, "[Preview]");
                sb.insert(9, "(");
                sb.append(")");
                String twitterPreviewString = sb.toString();
                event.getChannel().sendMessage(twitterPreviewString).queue();
            } else if (event.getMessage().getContentDisplay().contains(tiktokCheck)) {
                StringBuilder sb = new StringBuilder("" + event.getMessage().getContentDisplay());
                sb.deleteCharAt(16);
                sb.insert(16, "x");
                sb.insert(0, "[Preview]");
                sb.insert(9, "(");
                sb.append(")");
                String twitterPreviewString = sb.toString();

                event.getChannel().sendMessage(twitterPreviewString).queue();

//        System.out.println("User send: "+event.getMessage().getContentDisplay());
            }
        }
    }
}
