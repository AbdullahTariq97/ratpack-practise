package my.app.handling;

import ratpack.core.server.RatpackServer;

// https://ratpack.io/manual/current/http.html

public class Main {

    /**
     This is the entry point of a Ratpack application
     The .start() method accepts an Action functional interface. It is provided with a type RatpackServerSpec
     using the server spec object you can define the 3 most important configs for a ratpack application (server config, base registry and root handler)
     1) To define the base registry call .registryOf()  - A registry is a store of objects. There may be different registries in a application. Object are keyed using types
     2) To define the handlers use .handlers() method - they receive http requests as part of context. they operate on the context, send response or delegate to next handler in chain. A chain of handlers can be formed.
     3) To define server config use .serverConfig()


     What is a context?
     1) Access the HTTP request and response

     2) Delegation (via the next() and insert(ratpack.core.handling.Handler...) family of methods)
     If the chain has already been built, outside, connecting the current Handler with another Handler then context.next() will delegate to next handler in the chain
     If the chain has not been built, outside, then it can be built internally so context.insert(new Handler2(), new Handler3()) delegates the processing to handler 2 and then handler 3

     If a handler is not going to generate a response, it must delegate to another handler.
     It can either insert one or more handlers, or simply defer to the next handler.
     The .handlers() method accepts an action/consumer which is passed a chain. The chain instance can be used to build chain of handlers

     3) Access to contextual objects from registry
     object can put be put inside the context registry from upstream handlers and made accessible in downstream handlers

     How to build the chain?
     chain.path(String path, Handler handler) : this can be used to match request path to single handler. Useful when you want to build chain internally to the handler
     .prefix(String path, Action<Chain> chain) : this can be used to match request path to chain of handlers built using .all().all()
     .get(String path, Handler handler): this can be used to match request path and http method to single handler. similar method for post and delete exist

     Http chain?
     :placeholder : this placeholder can be accessed by ctx.getPathToken
     sending back response to client: context.getResponse.send("abc") or context.render("abc")

     */

    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(
                        chain -> chain
                                .path("send", context -> context.getResponse().send("sending"))
                                .path("render", context -> context.render("render"))
                                .prefix("delegate-outside", chain2 -> chain2.all(new HandlerOne()).all(new HandlerTwo()))
                                .prefix("delegate-inside", chain2 -> chain2.all(new HandlerThree()))
                                .get("get", ctx -> ctx.render("using the get handler"))
                                .post("post", ctx -> ctx.render("using the post handler"))
                                .onlyIf(ctx -> ctx.getRequest().getHeaders().contains("onlyif"), new HandlerFour())
                                .when(ctx -> ctx.getRequest().getHeaders().contains("when"), chain2 -> chain2.all(new HandlerTwo()))

                )
        );
    }
}