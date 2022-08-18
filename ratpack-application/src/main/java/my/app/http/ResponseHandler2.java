package my.app.http;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;
import ratpack.core.jackson.Jackson;

public class ResponseHandler2 implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        Boat boat = new Boat("royal navy");
        // To avoid creating an custom rendered for our boat we can create Renderable object using jackson.json method
        // Jackson will need the object to have getters and setters. Then on their own are not sufficient to create renderable object
        ctx.render(Jackson.json(boat));
    }
}
