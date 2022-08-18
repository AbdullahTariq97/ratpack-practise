package my.app.http;


import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class ResponseHandler1 implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        Car car = new Car("ford", "1997");
        // sending json
        // / The server will look for a corresponding renderer when you want to sent an obj in response. This needs to be put into the registry
        ctx.render(car);
    }
}
