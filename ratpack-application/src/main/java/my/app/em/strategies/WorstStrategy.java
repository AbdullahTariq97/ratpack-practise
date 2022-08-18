package my.app.em.strategies;

import ratpack.core.handling.Context;

public class WorstStrategy implements Strategy {

    @Override
    public void doItsThing(Context context) {
       context.getResponse().send("using the worst strategy");
    }
}
