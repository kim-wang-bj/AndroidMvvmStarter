package wq.android.mvvm.java.starter.core;

import android.text.Editable;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author Wang Qi
 */
public class CustomBindingAdapter {
    public interface AfterTextChanged {
        void afterTextChanged(Editable s);
    }

    public interface BeforeTextChanged {
        void beforeTextChanged(CharSequence s, int start, int count, int after);
    }

    public interface OnTextChanged {
        void onTextChanged(CharSequence s, int start, int before, int count);
    }

    @BindingAdapter(value = {"android:beforeTextChangedDebounce500", "android:onTextChangedDebounce500",
            "android:afterTextChangedDebounce500"}, requireAll = false)
    public static void setTextWatcher(TextView view, final BeforeTextChanged before,
                                      final OnTextChanged on, final AfterTextChanged after) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        if (after != null) {
            compositeDisposable.add(RxTextView.afterTextChangeEvents(view)
                    .debounce(500, TimeUnit.MILLISECONDS)
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(event -> after.afterTextChanged(event.getEditable())));
        }

        if (before != null) {
            //void beforeTextChanged(CharSequence s, int start, int count, int after);
            compositeDisposable.add(RxTextView.beforeTextChangeEvents(view)
                    .debounce(500, TimeUnit.MILLISECONDS)
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(event -> before.beforeTextChanged(event.getText(), event.getStart(), event.getCount(), event.getAfter())));
        }

        if (on != null) {
            //void onTextChanged(CharSequence s, int start, int before, int count);
            compositeDisposable.add(RxTextView.textChangeEvents(view)
                    .debounce(500, TimeUnit.MILLISECONDS)
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(event -> on.onTextChanged(event.getText(), event.getStart(), event.getBefore(), event.getCount())));
        }

        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
                    compositeDisposable.clear();
                }
            }
        });

    }

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
