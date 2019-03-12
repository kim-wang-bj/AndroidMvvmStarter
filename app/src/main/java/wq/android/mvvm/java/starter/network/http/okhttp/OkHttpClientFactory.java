package wq.android.mvvm.java.starter.network.http.okhttp;

import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import wq.android.mvvm.java.starter.BuildConfig;
import wq.android.mvvm.java.starter.network.http.HttpConfig;

/**
 * @author Wang Qi
 */
public class OkHttpClientFactory {

    public static OkHttpClient create() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        addHeaderInterceptor(builder);
        addLoggerInterceptor(builder);
        return builder.build();
    }

    private static void addHeaderInterceptor(OkHttpClient.Builder builder) {
        Map<String, String> headers = HttpConfig.CommonHeaders.values();
        Interceptor interceptor = chain -> {
            Request.Builder requestBuilder = chain.request().newBuilder();
            for (String key : headers.keySet()) {
                requestBuilder.removeHeader(key);
                requestBuilder.addHeader(key, headers.get(key));
            }
            return chain.proceed(requestBuilder.build());
        };
        builder.addInterceptor(interceptor);
    }

    private static void addLoggerInterceptor(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logInterceptor);
        }
    }
}
