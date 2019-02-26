package wq.android.mvvm.java.starter.network.retrofit;

import okhttp3.OkHttpClient;

/**
 * @author Wang Qi
 */
public class OkHttpClientFactory {

    public static OkHttpClient create() {
        return new OkHttpClient();
    }
}
