package hello;

import ratpack.core.handling.Context;

public class SomeOtherService {
    public void use(Context context) {
        System.out.println("use some other service");
        context.render("service response");

    }
}
