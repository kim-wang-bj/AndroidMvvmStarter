package wq.android.mvvm.java.starter.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wq.android.mvvm.java.starter.di.annotation.scope.FragmentScope;
import wq.android.mvvm.java.starter.ui.detail.fragment.DetailFragment;

@Module
interface FragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector()
    DetailFragment bindDetailFragment();
}
