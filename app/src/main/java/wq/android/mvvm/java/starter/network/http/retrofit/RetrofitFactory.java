package wq.android.mvvm.java.starter.network.http.retrofit;

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
import wq.android.mvvm.java.starter.network.entity.RetrofitResponse;
import wq.android.mvvm.java.starter.network.http.okhttp.OkHttpClientFactory;

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

    private static class RetrofitCallAdapter implements CallAdapter<Observable<RetrofitResponse<?>>, Observable<RetrofitResponse<?>>> {
        private CallAdapter<Observable<RetrofitResponse<?>>, Observable<RetrofitResponse<?>>> mCallAdapter;

        public RetrofitCallAdapter(CallAdapter callAdapter) {
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
                        if (retrofitResponse.getStatus() != RetrofitResponse.Status.OK.value()) {
                            throw new RetrofitException(retrofitResponse);
                        }
                    }).onErrorResumeNext(throwable -> {
                        return Observable.error(throwable);
                    });
        }
    }
}
