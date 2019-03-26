package wq.android.mvvm.java.starter.dagger;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import wq.android.mvvm.java.common.dagger.annotation.AppScope;
import wq.android.mvvm.java.starter.App;

/**
 * @author Wang Qi
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
