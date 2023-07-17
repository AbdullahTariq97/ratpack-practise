package testing;

import org.junit.jupiter.api.Test;
import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://ratpack.io/manual/current/testing.html#requestfixture
 * */

public class DummyHandlerTest {

    @Test
    public void handlerTest() throws Exception {
        DummyHandler dummyHandler = new DummyHandler();
        // Thw request fixture instance that will be passed to this callback by this handle method represent the request inside the context
        // Which gets passed to the .handle(Context context) method of a handler
        // The handle method will return an object containing the value that the handler rendered
        // alternatively the object provides methods to check the updated statement of the context or if the handler delegeated to another handler

        HandlingResult result = RequestFixture.handle(dummyHandler, requestFixture -> requestFixture.header("Name", "abdullah"));

        assertThat(result.rendered(String.class)).isEqualTo("abdullah"); // The value from the header was returned from the handler
        assertThat(result.isCalledNext()).isFalse(); // The handler never delegated to another handler
    }


}
