package wq.android.mvvm.java.starter;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import wq.android.mvvm.java.starter.di.DaggerAppComponent;

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends App> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
