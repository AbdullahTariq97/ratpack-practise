package ratpack.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ratpack.exec.ExecResult;
import ratpack.exec.Promise;
import ratpack.rx.RxRatpack;
import ratpack.test.exec.ExecHarness;
import rx.Observable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AsyncClassTest {

    /**
     * Ratpack test provides a ExecHarness class that can be used to test code non-blocking in a non-blocking way
     * https://ratpack.io/manual/current/testing.html#requestfixture
     */

    @Test
    public void testObservable() throws Exception {
        AsyncClass asyncClass = new AsyncClass();

        try (ExecHarness execHarness = ExecHarness.harness()) {
//           The .yield method Synchronously returns a promised value. The given function will execute in a separate thread. waiting for the promised value to be provided
//           The .promise method takes an observable and maps it to a promise required by the yield method
            ExecResult<List<String>> yield = execHarness.yield(execution -> RxRatpack.promise(asyncClass.getResult()));
            String dataInsideObservable = yield.getValue().get(0);
            assertThat(dataInsideObservable).isEqualTo("abdullah");
        }

    }

}
