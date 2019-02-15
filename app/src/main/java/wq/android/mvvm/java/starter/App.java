package wq.android.mvvm.java.starter;

import android.content.Context;

import androidx.multidex.MultiDex;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import wq.android.mvvm.java.starter.di.DaggerAppComponent;

/**
 * @author Wang Qi
 */
public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends App> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
