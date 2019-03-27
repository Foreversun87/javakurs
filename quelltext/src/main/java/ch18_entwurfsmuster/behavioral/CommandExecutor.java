package ch18_entwurfsmuster.behavioral;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm zur Demonstration des Befehl-Musters
 * <br>
 * Die Klasse <code>CommandExecutor</code> stellt einen Executor f�r Kommandos dar. 
 * Alle Kommandos, die in  * die Abarbeitungsqueue eingestellt wurden, werden der Reihe nach bearbeitet.
 * <br>
 * Der entscheidende Unterschied zum ersten Beispiel SimpleCommandExample ist,
 * dass hier die Kommandos eingeplant werden und die Ausf�hrung durch eine andere
 * Einheit, den CommandExecutor, erfolgt und nicht dirket per Methodenaufruf.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class CommandExecutor implements Runnable
{
   private static final ICommand NULL_COMMAND = new ICommand()
   {
       @Override
       public void execute()
       {
       }

       @Override
       public String toString()
       {
           return "NULL_COMMAND";
       }
   };
    
   private final Deque<ICommand> commands = new LinkedBlockingDeque<ICommand>();
    
    public static void main(final String[] args) throws InterruptedException
    {
        // Die Abarbeitung der Kommandos erfolgt nebenl�ufig
        // zu den folgenden Aktionen
        final CommandExecutor executor = new CommandExecutor();
        final Thread executorThread = new Thread(executor);
        executorThread.start();

        // Client erzeugt Kommandos
        final ICommand command1 = new PrintTextCommand("Dies ist ein Text");
        final ICommand command2 = new WaitCommand();
        final ICommand command3 = new PrintTextCommand("Der Test ist beendet!");

        // Client �bergibt Kommandos an Executor
        executor.registerCommand(command1);
        executor.registerCommand(command2);
        executor.registerCommand(command3);
        
        // wait and quit
        Thread.sleep(7_000);
        executorThread.interrupt();
    }
    
    public void registerCommand(final ICommand commandToExecute)
    {
        if (commandToExecute == null)
            throw new IllegalArgumentException("Passed command must not be null!");

        commands.offer(commandToExecute);
    }

    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            final ICommand commandToExecute = getAndRemoveNextCommand();
            commandToExecute.execute();

            SleepUtils.safeSleep(50); // Vermeide CPU-Belastung
        }
    }

    private ICommand getAndRemoveNextCommand()
    {
        final ICommand commandToExecute = commands.poll();
        if (commandToExecute == null)
            return NULL_COMMAND;

        return commandToExecute;
    }

    interface ICommand
    {
        void execute();
    }

    public static class PrintTextCommand implements ICommand
    {
        final String text;

        public PrintTextCommand(final String text)
        {
            this.text = text;
        }

        @Override
        public void execute()
        {
            System.out.println(text);
        }

        @Override
        public String toString()
        {
            return "PrintTextCommand [text=" + text + "]";
        }
    }

    public static class WaitCommand implements ICommand
    {
        final int WAIT_TIME_IN_SEC = 3;

        @Override
        public void execute()
        {
            for (int i = 0; i < WAIT_TIME_IN_SEC; i++)
            {
                if (Thread.currentThread().isInterrupted())
                {
                    break;
                }
                
                System.out.print(".");

                SleepUtils.safeSleep(1000);
            }
            System.out.println();
        }

        @Override
        public String toString()
        {
            return "WaitCommand [WAIT_TIME_IN_SEC=" + WAIT_TIME_IN_SEC + "]";
        }
    }
}