package ratpack.testing;

import org.junit.jupiter.api.Test;
import ratpack.exec.Promise;
import rx.Observable;

import static ratpack.rx.RxRatpack.promiseSingle;

public class ObserableTest {

    @Test
    public void test(){
        Observable<Integer> observable = Observable.just("abc").map(input -> {
            System.out.println("entering map");
            return 123;
        });
        promiseSingle(observable).then(value -> System.out.println("I got value of " + value));
    }
}
