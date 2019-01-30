package wq.android.mvvm.java.starter.di;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import wq.android.mvvm.java.starter.App;
import wq.android.mvvm.java.starter.di.annotation.AppScope;

/**
 * @author wangqi
 */
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilder.class
        }
)
@AppScope
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
