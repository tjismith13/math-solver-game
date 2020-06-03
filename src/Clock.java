import static java.lang.System.currentTimeMillis;

public class Clock {
    private int secondsPassed;
    private long realTime = 0;

    //Countdown clock, pass in starting time to count down from.
    //After time has been taken, continuously subtract it from exact time
    //and count number of seconds passed.
    //Return starting time - seconds passed.

    public void init(int startTimeSec) {

    }
    public int timeRemaining(int startTimeSec) {
        if(realTime != 0) {
            secondsPassed = Math.round((System.currentTimeMillis() - realTime) / 1000);
            return startTimeSec - secondsPassed;
        }
        realTime = System.currentTimeMillis();
        return startTimeSec;
    }
}
