package wq.android.mvvm.java.starter.core;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.jakewharton.rxbinding3.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author Kim.WangTJ
 */
public class CustomBindingAdapter {

    @BindingAdapter("android:onClickListenerThrottleFirst500")
    public static void onClickListenerThrottleFirst500(final View v, final View.OnClickListener onClickListener) {
        onClickThrottleFirst(v, 500, view -> onClickListener.onClick(view));
    }

    @BindingAdapter("android:onClickThrottleFirst500")
    public static void onClickThrottleFirst500(View v, Consumer<View> consumer) {
        onClickThrottleFirst(v, 500, consumer);
    }

    @BindingAdapter("android:onClickListenerThrottleFirst1000")
    public static void onClickListenerThrottleFirst1000(final View v, final View.OnClickListener onClickListener) {
        onClickThrottleFirst(v, 1000, view -> onClickListener.onClick(view));
    }

    @BindingAdapter("android:onClickThrottleFirst1000")
    public static void onClickThrottleFirst1000(View v, Consumer<View> consumer) {
        onClickThrottleFirst(v, 1000, consumer);
    }

    private static void onClickThrottleFirst(View v, int duration, Consumer<View> consumer) {
        Disposable disposable = RxView.clicks(v)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .throttleFirst(duration, TimeUnit.MILLISECONDS)
                .map(o -> v)
                .subscribe(consumer);
        v.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                if (disposable != null && !disposable.isDisposed()) {
                    disposable.dispose();
                }
            }
        });
    }
}
