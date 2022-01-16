package utils;

import io.github.admin4j.http.core.Pair;
import io.github.admin4j.http.util.HttpUtil;
import okhttp3.Response;

/**
 * @author weimenghua
 * @time 2023-06-05 10:17
 * @description
 */
public class OkHttp {
    public static void main(String[] args) {
        Response response = HttpUtil.get("https://github.com/search", Pair.of("q", "okhttp"));
        System.out.println("response = " + response);
    }
}
