package wq.android.mvvm.java.starter.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wq.android.mvvm.java.starter.ui.detail.DetailActivity;
import wq.android.mvvm.java.starter.ui.detail.DetailFragmentProvider;
import wq.android.mvvm.java.starter.ui.main.MainActivity;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {DetailFragmentProvider.class})
    abstract DetailActivity bindDetailActivity();

}
