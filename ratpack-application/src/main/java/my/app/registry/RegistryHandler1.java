package my.app.registry;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;
import ratpack.exec.registry.Registry;

public class RegistryHandler1 implements Handler {

//    context.getExecution().add(ConsumedRequestBody.class, new ConsumedRequestBody(bodyText));
    @Override
    public void handle(Context ctx) throws Exception {
//       Create a user object and puts in into context registry
        User user = new User("abdullah");
//        We can pass the registry context to the next handler in the chain using
        ctx.insert(Registry.single(User.class, user), new RegistryHandler2());
    }
}
