package ratpack.testing;

import rx.Observable;

public class AsyncClass {

    public Observable<String> getResult() {
        return Observable.just("abdullah");
    }
}
