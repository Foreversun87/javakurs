package ch09_multithreading.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Beispiel für die Abarbeitung eines Runnable mit einem
 * ExecutorService
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class FutureExampleWithRunnableAndResult
{
    public static void main(final String[] args)
    {
        final ExecutorService executorService =
        		              Executors.newSingleThreadExecutor();
        
		final List<Integer> result = new ArrayList<>();
		final Runnable task = new ModifyingTask(result);
		final Future<List<Integer>> future = 
				                    executorService.submit(task, result);

        accessResult(future);

        executorService.shutdown();
    }

    public static final class ModifyingTask implements Runnable
    {
        private final List<Integer> result;

        ModifyingTask(final List<Integer> result)
        {
            this.result = result;
        }

        @Override
        public void run()
        {
            result.add(Integer.valueOf(4711));
        }

        public List<Integer> getResult()
        {
            return result;
        }
    }
    
	private static void accessResult(final Future<List<Integer>> future) 
	{
		try
        {
            System.out.println("isDone? " + future.isDone());

            final List<Integer> calculatedResult = future.get();
            System.out.println("Job finished with result: " + calculatedResult);

        }
        catch (final InterruptedException e)
        {
            // Kann in diesem Beispiel nicht auftreten 
        }
        catch (final ExecutionException e)
        {
            // Kann in diesem Beispiel nicht auftreten, wird geworfen wenn 
            // versucht wird, auf ein Ergebnis eines Tasks zuzugreifen, der
            // mit einer Exception beendet wurde 
        }
	}
}
