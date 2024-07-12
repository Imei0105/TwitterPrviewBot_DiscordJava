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
        String instagramReelCheck = "https://www.instagram.com/reel/";
        String instagramPostCheck = "https://www.instagram.com/p/";
        String tiktokCheck = "https://www.tiktok.com/";
        String vtTiktokCheck = "https://vt.tiktok.com/";

        String input = event.getMessage().getContentDisplay();
//        System.out.println("User send: "+event.getMessage().getContentDisplay());


        if (event.getAuthor().isBot()) {
            return;
        } else{
            String url = UrlCheck.getUrl(input);

            if (url.contains(twitterUrlCheck)) {
                //正則判斷是否為貼文
                String regex = "https://twitter\\.com/(.+)/status/(.+)";
//                System.out.println(event.getMessage().getContentDisplay().matches(regex));
                if(url.matches(regex)){
                    StringBuilder sb = new StringBuilder(url);
                    sb.insert(8, "vx");
                    sb.insert(0, "[Preview]");
                    sb.insert(9, "(");
                    sb.append(")");
                    String twitterPreviewString = sb.toString();

                    event.getChannel().sendMessage(twitterPreviewString).queue();
                }
            } else if (url.contains(xUrlCheck)) {
                //正則判斷是否為貼文
                String regex = "https://x\\.com/(.+)/status/(.+)";
                if(url.matches(regex)){
                    StringBuilder sb = new StringBuilder(url);
                    sb.insert(8, "v");
                    sb.insert(10, "twitter");
                    sb.insert(0, "[Preview]");
                    sb.insert(9, "(");
                    sb.append(")");
                    String twitterPreviewString = sb.toString();

                    event.getChannel().sendMessage(twitterPreviewString).queue();
                }
            } else if (url.contains(redditUrlCheck)) {
                String regex = "https://www\\.reddit\\.com/r/(.+)";
                if(url.matches(regex)){
                    StringBuilder sb = new StringBuilder(url);
                    sb.deleteCharAt(13);
                    sb.insert(13, "x");
                    sb.insert(0, "[Preview]");
                    sb.insert(9, "(");
                    sb.append(")");
                    String twitterPreviewString = sb.toString();

                    event.getChannel().sendMessage(twitterPreviewString).queue();
                }
            } else if (url.contains(instagramReelCheck) || url.contains(instagramPostCheck)) {
                StringBuilder sb = new StringBuilder(url);
//                sb.insert(12, "dd");
                sb.insert(21, "ez");
                sb.insert(0, "[Preview]");
                sb.insert(9, "(");
                sb.append(")");
                String twitterPreviewString = sb.toString();

                event.getChannel().sendMessage(twitterPreviewString).queue();

            } else if (url.contains(tiktokCheck)) {
                StringBuilder sb = new StringBuilder(url);
                sb.deleteCharAt(16);
                sb.insert(16, "x");
                sb.insert(0, "[Preview]");
                sb.insert(9, "(");
                sb.append(")");
                String twitterPreviewString = sb.toString();
                event.getChannel().sendMessage(twitterPreviewString).queue();

            } else if (url.contains(vtTiktokCheck)) {
                StringBuilder sb = new StringBuilder(url);
                sb.delete(8,11);
                sb.deleteCharAt(12);
                sb.insert(12, "x");
                sb.insert(0, "[Preview]");
                sb.insert(9, "(");
                sb.append(")");
                String twitterPreviewString = sb.toString();

                event.getChannel().sendMessage(twitterPreviewString).queue();

            }
        }
    }
}
