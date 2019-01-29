package wq.android.mvvm.java.starter.ui.detail;

import android.util.Log;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.di.annotation.ActivityScope;

@ActivityScope
public class DetailDataManager {

    @Inject
    public DetailDataManager() {
    }

    public void log() {
        Log.i("test", this.toString());
    }
}
