package wq.android.mvvm.java.common.network.retrofit;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wq.android.mvvm.java.common.network.okhttp.OkHttpClientFactory;

/**
 * @author Wang Qi
 */
public class RetrofitFactory {

    @NonNull
    public static Retrofit get(RetrofitService service) {
        return new Retrofit.Builder()
                .baseUrl(service.getBasUrl())
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .client(OkHttpClientFactory.create())
                .addCallAdapterFactory(new RetrofitCallAdapterFactory(service))
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
        RetrofitService service;

        RetrofitCallAdapterFactory(RetrofitService service) {
            this.service = service;
        }

        @Override
        public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
            return new RetrofitCallAdapter(service, callAdapterFactory.get(returnType, annotations, retrofit));
        }
    }

    private static class RetrofitCallAdapter implements CallAdapter<Observable<RetrofitResponse<?>>, Observable<RetrofitResponse<?>>> {
        private CallAdapter<Observable<RetrofitResponse<?>>, Observable<RetrofitResponse<?>>> mCallAdapter;
        RetrofitService service;

        public RetrofitCallAdapter(RetrofitService service, CallAdapter callAdapter) {
            this.service = service;
            this.mCallAdapter = callAdapter;
        }

        @Override
        public Type responseType() {
            return mCallAdapter.responseType();
        }

        @Override
        public Observable<RetrofitResponse<?>> adapt(Call<Observable<RetrofitResponse<?>>> call) {
            return mCallAdapter.adapt(call)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(retrofitResponse -> {
                        service.getResponseInterceptor().onResponse(retrofitResponse);
                    }).onErrorResumeNext(throwable -> {
                        return Observable.error(throwable);
                    });
        }
    }
}
