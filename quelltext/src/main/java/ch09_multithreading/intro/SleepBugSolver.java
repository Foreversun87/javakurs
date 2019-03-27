package ch09_multithreading.intro;

/**
 * Diese Klasse behebt einen Fehler im JDK, der daffür sorgt, dass bei kurzen 
 * Sleep-Zeiten und hoher Prozessorbelastung die Windows Systemuhr beschleunigt 
 * wird. Dies kann sich besonders negativ bei verteilten Systemen auswirken.
 * <br>
 * Die von SUN vorgeschlagene Lösung: Einen langen Sleep durchführen. 
 * <br>
 * <b>Usage:</b> 
 * <br>
 * <code>new SleepBugSolver().start();</code>
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class SleepBugSolver extends Thread
{
    public SleepBugSolver()
    {
        setDaemon(true);
    }

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(Integer.MAX_VALUE);
            }
            catch (final InterruptedException ex)
            {
                // Spezialfall: hier Exception bewusst ignorieren
            }
        }
    }
}