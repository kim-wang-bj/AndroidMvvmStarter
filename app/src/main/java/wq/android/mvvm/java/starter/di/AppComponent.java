package wq.android.mvvm.java.starter.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import wq.android.mvvm.java.starter.App;

/**
 * @author wangqi
 */
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilder.class
        }
)
@Singleton
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
