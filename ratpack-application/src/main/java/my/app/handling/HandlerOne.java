package my.app.handling;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class HandlerOne implements Handler {

    // This does not do anything but delegates to next handler in chain
    @Override
    public void handle(Context ctx) throws Exception {
         ctx.next(); // delegates to next handler in the chain
    }
}
