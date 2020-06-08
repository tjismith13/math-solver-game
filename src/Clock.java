import static java.lang.System.currentTimeMillis;

public class Clock {
    private long secondsPassed;
    private long realTime = 0;
    private int startTimeSec;

    //Countdown clock, pass in starting time to count down from.
    //After time has been taken, continuously subtract it from exact time
    //and count number of seconds passed.
    public void init(int startTimeSec) {
        this.startTimeSec = startTimeSec;
        realTime = System.currentTimeMillis();
    }

    //Return time remaining
    public long timeRemaining() {
        if(realTime != 0) {
            secondsPassed = (System.currentTimeMillis() - realTime) / 1000;
        }
        return startTimeSec - secondsPassed;
    }
}
