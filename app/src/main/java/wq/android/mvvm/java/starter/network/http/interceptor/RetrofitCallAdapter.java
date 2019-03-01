package wq.android.mvvm.java.starter.network.http.interceptor;

import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.CallAdapter;
import wq.android.mvvm.java.starter.network.entity.Response;
import wq.android.mvvm.java.starter.network.http.ResponseCode;
import wq.android.mvvm.java.starter.network.http.retrofit.RetrofitException;

/**
 * @author Wang Qi
 */
public class RetrofitCallAdapter implements CallAdapter<Observable<Response<?>>, Observable<Response<?>>> {
    private CallAdapter<Observable<Response<?>>, Observable<Response<?>>> mCallAdapter;

    public RetrofitCallAdapter(CallAdapter callAdapter) {
        this.mCallAdapter = callAdapter;
    }

    @Override
    public Type responseType() {
        return mCallAdapter.responseType();
    }

    @Override
    public Observable<Response<?>> adapt(Call<Observable<Response<?>>> call) {
        return mCallAdapter.adapt(call)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(response -> {
                    if (response.getCode() != ResponseCode.OK.getCode()) {
                        throw new RetrofitException(response);
                    }
                }).onErrorResumeNext(throwable -> {
                    return Observable.error(throwable);
                });
    }
}