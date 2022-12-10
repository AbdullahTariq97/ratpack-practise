package hello;

public class Click {

    private static int NUMBER_OF_CLICKS = 0;

    public void increment(){
        NUMBER_OF_CLICKS++;
    }

    public int getNumberOfClicks(){
        increment();
        return NUMBER_OF_CLICKS;
    }
}
