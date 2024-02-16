import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class HelloWorldApp {

    private static MeterRegistry meterRegistry = new SimpleMeterRegistry();

    private static Counter helloCounter = Counter
            .builder("hello.count")
            .description("Number of times hello is printed")
            .register(meterRegistry);

    public static void main(String[] args) {
        System.out.println("Hello World!");

        helloCounter.increment();

        System.out.println("Hello Counter: " + helloCounter.count());

        meterRegistry.close();
    }
}
