package my.app.http;

import ratpack.core.handling.Context;
import ratpack.core.render.RendererSupport;

public class CarRenderer extends RendererSupport<Car> {
    @Override
    public void render(Context ctx, Car car) throws Exception {
        ctx.getResponse().send(String.format("{ \"name\" : \"%s\" \"year\" : \"%s\"} you can control how state inside object is rendered", car.getName(), car.getYear()));
    }
}
