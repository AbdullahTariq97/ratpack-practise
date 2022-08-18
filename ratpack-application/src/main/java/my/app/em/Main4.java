package my.app.em;

import my.app.http.CarRenderer;
import ratpack.core.server.RatpackServer;
import ratpack.exec.registry.Registry;

public class Main4 {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .registry(Registry.single(new CarRenderer())) // The server will look for a corresponding renderer when you want to sent an obj in response
                .handlers(
                        chain -> chain
                                .prefix("/:strategy", chain2 -> chain2.all(new MainHandler()))

                )
        );
    }
}

