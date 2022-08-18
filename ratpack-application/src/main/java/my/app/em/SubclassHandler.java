package my.app.em;

import my.app.em.strategies.Strategy;
import ratpack.core.handling.Context;

public class SubclassHandler extends SuperclassHandler{

    private Strategy strategy;

    public SubclassHandler(Strategy strategy){
        this.strategy = strategy;
    }


    @Override
    public void doHandle(Context context) {
        strategy.doItsThing(context);
    }
}
