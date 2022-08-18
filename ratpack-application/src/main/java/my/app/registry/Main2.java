package my.app.registry;

import ratpack.core.server.RatpackServer;


public class Main2 {

    /**
     3) Access to contextual objects from registry
     object can put be put inside the context registry from upstream handlers and made accessible in downstream handlers
     */
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(
                        chain -> chain
                                .prefix("registry", chain2 -> chain2.all(new RegistryHandler1()))

                )
        );
    }
}