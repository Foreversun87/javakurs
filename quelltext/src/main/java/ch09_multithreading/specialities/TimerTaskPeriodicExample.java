package ch09_multithreading.specialities;

import java.util.Timer;

/**
 * Beispiel für die Nutzung eines Timers und von TimerTasks zur
 * zeitgesteuerten, periodischen Ausführung von Aufgaben 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class TimerTaskPeriodicExample
{
    public static void main(final String[] args) throws InterruptedException
    {
        final Timer timer = new Timer();

        // Eingeplante Ausführung mit INITIAL_DELAY und Verzï¿½gerung DELAY 
        final long INITIAL_DELAY_ONE_SEC = 1000;
        final long DELAY_30_SECS = 30000;
        timer.schedule(new SampleTimerTask("PeriodicRefreshing"), INITIAL_DELAY_ONE_SEC, DELAY_30_SECS);

        // Eingeplante Ausführung mit INITIAL_DELAY und Takt RATE 
        final long RATE_10_SECS = 10000;
        timer.scheduleAtFixedRate(new SampleTimerTask("10s FixedRateExecution"), INITIAL_DELAY_ONE_SEC, RATE_10_SECS);

        stopTimerAfterDelay(timer, 65 * 1000);
    }

    private TimerTaskPeriodicExample()
    {
    }

	private static void stopTimerAfterDelay(final Timer timer, final long dealyInMs) throws InterruptedException 
	{
		Thread.sleep(dealyInMs);
		timer.cancel();
	}
}