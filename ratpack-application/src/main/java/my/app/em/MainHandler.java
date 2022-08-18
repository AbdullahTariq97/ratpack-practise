package my.app.em;

import my.app.em.strategies.BestStrategy;
import my.app.em.strategies.Strategy;
import my.app.em.strategies.WorstStrategy;
import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class MainHandler implements Handler {


    @Override
    public void handle(Context ctx) throws Exception {

        Strategy strategy;

        if(ctx.getPathTokens().get("strategy").equals("best")){
            strategy = new BestStrategy();
        } else if (ctx.getPathTokens().get("strategy").equals("worst")){
            strategy = new WorstStrategy();
        } else {
            throw new RuntimeException();

        }
        new SubclassHandler(strategy).handle(ctx);
    }
}
