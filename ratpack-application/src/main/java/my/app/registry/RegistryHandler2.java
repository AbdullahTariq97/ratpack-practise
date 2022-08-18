package my.app.registry;

import com.fasterxml.jackson.databind.ObjectMapper;
import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class RegistryHandler2 implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
//        Grabs user from first handler
        User user = ctx.get(User.class);
//        Operates on the user object
        User user2 = new User(user.getFirstName().toUpperCase());
//        Returns it to the client
        ObjectMapper objectMapper = new ObjectMapper();
        String userStr = objectMapper.writeValueAsString(user2);
        ctx.getResponse().send(userStr);

    }
}
