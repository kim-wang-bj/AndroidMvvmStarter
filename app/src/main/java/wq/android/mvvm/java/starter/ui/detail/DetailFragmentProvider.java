package wq.android.mvvm.java.starter.ui.detail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wq.android.mvvm.java.starter.ui.detail.fragment.DetailFragment;
import wq.android.mvvm.java.starter.ui.detail.fragment.DetailFragmentModule;

@Module
public abstract class DetailFragmentProvider {

    @ContributesAndroidInjector(modules = DetailFragmentModule.class)
    abstract DetailFragment provideDetailFragmentFactory();
}
