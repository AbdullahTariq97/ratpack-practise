package hello;

import com.google.inject.AbstractModule;

public class ParentGuiceRegistry extends AbstractModule {

    @Override
    protected void configure() {
        bind(SomeService.class).toInstance(new SomeService()); // Creates the SomeService instance
        bind(NeedyHandler.class); // This is the class that requires the SomeService instance to be injected through its constructor

//        install(new ChildGuiceRegistry());
    }
}
