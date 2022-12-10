package hello;

import ratpack.core.server.RatpackServer;
import ratpack.guice.Guice;

/**
 The ratpack-guice extension provides integration with Google Guice.
 ]The primary feature of this extension is to allow the server registry to be built by Guice.
 That is, a Guice Injector can be presented as a Ratpack Registry

 read Binder.java docs for more information on binding

 https://ratpack.io/manual/current/api/ratpack/guice/Guice.html
 * */

public class Main5 {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .registry(Guice.registry(b -> b.module(ParentGuiceRegistry.class)))
                // We need to provide the Guice registry as the input to the ratpack server registry
                .handlers(
                        chain -> chain
                                .prefix("inject", chain2 -> chain2.all(NeedyHandler.class))
                                .prefix("mouse", chain1 -> chain1.all(MouseHandler.class))

                )
        );
    }
}
