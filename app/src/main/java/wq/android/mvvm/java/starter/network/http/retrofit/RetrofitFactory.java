package wq.android.mvvm.java.starter.network.http.retrofit;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wq.android.mvvm.java.starter.network.http.okhttp.OkHttpClientFactory;
import wq.android.mvvm.java.starter.network.http.interceptor.RetrofitCallAdapter;

/**
 * @author Wang Qi
 */
public class RetrofitFactory {

    @NonNull
    public static Retrofit get(String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .client(OkHttpClientFactory.create())
                .addCallAdapterFactory(new RetrofitCallAdapterFactory())
                .build();
    }

    @NonNull
    private static Gson createGson() {
        return new GsonBuilder()
//                .setFieldNamingStrategy(new PrefixNamingStrategy())
//                .registerTypeAdapter(Date.class, new GsonUtcDateAdapter(dateFormat))
//                .registerTypeAdapterFactory(new CappTypeAdapterFactory())
                .create();
    }

    private static class RetrofitCallAdapterFactory extends retrofit2.CallAdapter.Factory {
        RxJava2CallAdapterFactory callAdapterFactory = RxJava2CallAdapterFactory.create();

        @Override
        public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
            return new RetrofitCallAdapter(callAdapterFactory.get(returnType, annotations, retrofit));
        }
    }
}
