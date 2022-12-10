package hello;


import com.google.inject.Inject;
import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class MouseHandler implements Handler {

    private final Click click;

    @Inject
    public MouseHandler(Click click){
        this.click = click;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        int clicks = click.getNumberOfClicks();
        ctx.render("There are " + clicks + " clicks");
    }
}
