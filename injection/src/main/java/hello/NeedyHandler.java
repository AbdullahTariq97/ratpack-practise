package hello;

import com.google.inject.Inject;
import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class NeedyHandler implements Handler {

    private SomeService someService;
    private SomeOtherService someOtherService;

    @Inject
    public NeedyHandler(SomeService someService, SomeOtherService someOtherService){
        this.someService = someService;
        this.someOtherService = someOtherService;
    }


    @Override
    public void handle(Context ctx) {
        someService.use();
        someOtherService.use(ctx);
    }
}
