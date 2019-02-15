package wq.android.mvvm.java.starter.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wq.android.mvvm.java.starter.di.annotation.scope.ActivityScope;
import wq.android.mvvm.java.starter.ui.detail.DetailActivity;
import wq.android.mvvm.java.starter.ui.main.MainActivity;

@Module
interface ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = FragmentBuilder.class)
    MainActivity bindMainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = FragmentBuilder.class)
    DetailActivity bindDetailActivity();
}
