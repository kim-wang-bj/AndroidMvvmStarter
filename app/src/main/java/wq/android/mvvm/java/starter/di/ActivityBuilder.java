package wq.android.mvvm.java.starter.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wq.android.mvvm.java.starter.ui.detail.DetailActivity;
import wq.android.mvvm.java.starter.ui.main.MainActivity;

@Module
interface ActivityBuilder {

    @ContributesAndroidInjector()
    MainActivity bindMainActivity();

    @ContributesAndroidInjector()
    DetailActivity bindDetailActivity();
}
