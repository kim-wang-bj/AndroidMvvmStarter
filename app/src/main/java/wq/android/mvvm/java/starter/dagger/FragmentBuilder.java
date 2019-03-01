package wq.android.mvvm.java.starter.dagger;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wq.android.mvvm.java.starter.dagger.annotation.scope.FragmentScope;
import wq.android.mvvm.java.starter.ui.detail.fragment.DetailFragment;

/**
 * @author Wang Qi
 */
@Module
public interface FragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector()
    DetailFragment bindDetailFragment();
}