package wq.android.mvvm.java.starter.network.http.okhttp;

import android.util.ArrayMap;

import java.util.Map;

/**
 * @author Wang Qi
 * @date 2019-03-12
 */
public class OkHttpConfig {

    public static class CommonHeader {
        private static final ArrayMap<String, String> COMMON_HEADERS = new ArrayMap<>();

        static {
            COMMON_HEADERS.put("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)");
        }

        public static Map<String, String> values() {
            return COMMON_HEADERS;
        }
    }
}
