package my.app.em;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public abstract class SuperclassHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        doHandle(ctx);
    }

    public abstract void doHandle(Context context);
}
