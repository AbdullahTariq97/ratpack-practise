package hello;

import com.google.inject.AbstractModule;

public class ChildGuiceRegistry extends AbstractModule {

    protected void configure() {
        bind(SomeOtherService.class).toInstance(new SomeOtherService());
    }
}
