package my.app.http;

import ratpack.core.server.RatpackServer;
import ratpack.exec.registry.Registry;

//https://ratpack.io/manual/current/api/ratpack/core/jackson/Jackson.html#rendering

public class Main3 {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .registry(Registry.single(new CarRenderer())) // The server will look for a corresponding renderer when you want to sent an obj in response
                .handlers(
                        chain -> chain
                                .prefix("obj-response-custom-renderer", chain2 -> chain2.all(new ResponseHandler1()))
                                .prefix("json-response", chain2 -> chain2.all(new ResponseHandler2()))


                )
        );
    }
}
