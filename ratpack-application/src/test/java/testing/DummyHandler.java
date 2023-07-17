package testing;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class DummyHandler implements Handler {
    @Override
    public void handle(Context ctx) {
        ctx.render(ctx.getRequest().getHeaders().get("Name"));
    }
}
