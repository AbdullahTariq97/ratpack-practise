package hello;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ChildGuiceRegistry extends AbstractModule {

    protected void configure() {
        bind(SomeOtherService.class).toInstance(new SomeOtherService());

        bind(Click.class).in(Singleton.class);
        bind(MouseHandler.class);
    }
}
