import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s = "电话020-43422424，或者联系邮箱”+" +
                "\"itcast@itcast.cn,电话18762832633，0203232323r\"" +
                "邮箱bozai@itcast.cn，400-100-3233 ，4001003232\";" +
                "的大家小迎山理无国中R";
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+|1[3-9]\\d{9}");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        HashSet<String> set = new HashSet<>();
        set.add("a");
        Map<String, String> map = new HashMap<>();
//        map.put("string", "sting");
        map.put(null, "sting");

        System.out.println(map);
    }

}