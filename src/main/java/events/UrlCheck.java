package events;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlCheck {
    public static String getUrl(String str) {

        String regex = "https?://[a-zA-Z0-9+&@#/%?=~_|!:,.;\\-]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if(matcher.find()){

            return matcher.group();
        }
        return str;
    }
}
