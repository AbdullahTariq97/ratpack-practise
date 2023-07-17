package hello;

import javax.inject.Provider;

public class PrinterProvider implements Provider<Printer> {
    @Override
    public Printer get() {
        System.out.println("The get method of the provider was called");
        return new Printer();
    }
}
