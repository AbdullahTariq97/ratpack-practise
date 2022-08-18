package hello;

import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class NeedyHandler implements Handler {

    private SomeService someService;
//    private SomeOtherService someOtherService;

    @Inject
    public NeedyHandler(SomeService someService){
        this.someService = someService;
//        this.someOtherService = someOtherService;
    }


    @Override
    public void handle(Context ctx) throws Exception {
        someService.use();
//        someOtherService.use();

    }
}
