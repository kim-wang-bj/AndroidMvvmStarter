package wq.android.mvvm.java.starter.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wq.android.mvvm.java.starter.ui.detail.fragment.DetailFragment;

@Module
interface FragmentBuilder {

    @ContributesAndroidInjector()
    DetailFragment bindDetailFragment();
}
