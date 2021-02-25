package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSON {
    public static void requestURL(String url) throws IOException, InterruptedException {
        // 建立客户端
        HttpClient client = HttpClient.newHttpClient();
        // 建立连接
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        // 发送请求
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }


    /**
     * 从JSON数组的url获得String数组
     *
     * @param url
     * @return 字符串数组
     */
    public static String[] getStringArrayFromJSON(String url){
        // 解析url，返回JSON对象
        String jsonString = loadJson(url);
        // 解析 JSON Array 对象，返回字符串数组
        return decodeJson(jsonString);
    }

    /**
     * 加载url并获得JSON数据
     *
     * @param url 获得JSON的链接
     * @return 字符串形式 的 JSON对象/数组
     */
    protected static String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * 解析 字符串形式 的 JSON数组
     * 同时 将unicode代码 解析成 UTF-8字符
     * !!!!!仅限一维数组
     *
     * @param json JSON数组的字符串形式
     * @return String数组
     */
    protected static String[] decodeJson(String json){
        // 初始化返回值
        ArrayList<String> result = new ArrayList<>();
        // 设置临时缓存字符串
        StringBuilder buffer = new StringBuilder();
        // 用来检测是否在读取
        boolean isReading = false;
        // 遍历字符串的每一个字符
        for (char c : json.toCharArray()) {
            if(c == '\"'){
                if(isReading) { // 末尾回引号
                    // 所以将字符串转UTF-8字符串，并加入到List里
                    result.add(unicodeToString(buffer.toString()));
                    // 清空临时缓存
                    buffer = new StringBuilder();
                }
                isReading = ! isReading;
                continue;
            }
            // 读取引号内的字符
            if(isReading){
                buffer.append(c);
            }
        }
        // 将List转成Array返回结果
        // 如果为空，则返回长度为0的字符串数组
        return result.toArray(new String[0]);
    }

    /**
     * Unicode转 汉字字符串
     *
     * @param str \u6728
     * @return '木' 26408
     */
    protected static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }


}
