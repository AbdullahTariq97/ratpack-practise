package hello;

import com.google.inject.Inject;
import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

import javax.inject.Provider;

public class NeedyHandler implements Handler {

    private SomeService someService;
    private SomeOtherService someOtherService;
    private final Provider<Printer> printerProvider;

    @Inject
    public NeedyHandler(SomeService someService, SomeOtherService someOtherService, Provider<Printer> printerProvider){
        this.someService = someService;
        this.someOtherService = someOtherService;
        this.printerProvider = printerProvider;
    }


    @Override
    public void handle(Context ctx) {
        System.out.println("I handle something");
        someService.use();
        someOtherService.use(ctx);
        printerProvider.get();
    }
}
