package my.app.handling;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class HandlerFour implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        ctx.getResponse().send("using handler four");
    }
}
