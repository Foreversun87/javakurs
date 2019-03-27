package ch09_multithreading.specialities;

import ch09_multithreading.intro.SleepUtils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Beispiel für die Nutzung eines Timers und von TimerTasks zur
 * zeitgesteuerten, periodischen Ausführung von Aufgaben 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class TimerTaskSchedulingExample 
{
	public static void main(final String[] args) throws InterruptedException 
	{
		final Timer timer = new Timer();
		timer.schedule(new DurationTimerTask("FixedDelay1"), 0, 4000);
		// timer.schedule(new DurationTimerTask("FixedDelay2"), 0, 2000);
		stopTimerAfterDelay(timer);
	
		final Timer timer2 = new Timer();
		timer2.scheduleAtFixedRate(new DurationTimerTask("FixedRate1"), 0, 4000);
		// timer2.scheduleAtFixedRate(new DurationTimerTask("FixedRate2"), 0, 2000);
		stopTimerAfterDelay(timer2);
	}
	
	private static void stopTimerAfterDelay(final Timer timer) throws InterruptedException 
	{
		Thread.sleep(30 * 1000);
		timer.cancel();
	}
	
	public static class DurationTimerTask extends TimerTask 
	{
	    private final long[] sleepTimesSecs = { 1, 2, 4 };
	    private int index = 0;
	   
	    private final String info;
	   
	    public DurationTimerTask(final String info)
	    {
	        this.info = info;
	    }
	   
	    @Override
	    public void run() {
	       
	        final long sleepTimeSecs = sleepTimesSecs[index];
	        index = (index + 1 ) % sleepTimesSecs.length;
	       
	        System.out.println(info + " -- at " + new Date() + "  sleeping " + (sleepTimeSecs) + " secs");
	        
            SleepUtils.safeSleep(TimeUnit.SECONDS, sleepTimeSecs);
	    }
	}
}
