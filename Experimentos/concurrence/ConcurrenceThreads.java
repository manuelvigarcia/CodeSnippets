/**
 * ConcurrenceThreads.java 27/05/2016
 *
 * Copyright © 2016 Manuel Vicente García Rodríguez.
 */
package train.java.concurrence;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 27/05/2016
 *
 */
public class ConcurrenceThreads {

    /**Task in the old style*/
    final MyRunnableTask myTask = new MyRunnableTask();
    final MyCallableTask myCall = new MyCallableTask("task00");
    final MyPeriodicTask myCounter = new MyPeriodicTask();

    /**
     * Execution method. To try out the experiment.
     *
     * @param args
     */
    public static void main(final String[] args) {
        final Runnable task = () -> {
            try {
                final String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.MILLISECONDS.sleep(400);
                System.out.println("Foo . " + name);
                TimeUnit.MILLISECONDS.sleep(400);
                System.out.println("Foo . . " + name);
                TimeUnit.MILLISECONDS.sleep(400);
                System.out.println("Foo . . . " + name);
                TimeUnit.MILLISECONDS.sleep(400);
                System.out.println("Foo . . . . " + name);
                TimeUnit.MILLISECONDS.sleep(400);
                System.out.println("Foo . . . . . Bar " + name);
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        };

        System.out.println("------ Runnables.");

        task.run();


        final Thread thread = new Thread(task);
        thread.start();

        final ConcurrenceThreads ct = new ConcurrenceThreads();
        final Thread myThread = new Thread(ct.getTask());
        myThread.start();
        try {
            myThread.join();  //Wait for it...
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------ Done with Runnables.");

        System.out.println("------ Executors.");
        //final ExecutorService executor = Executors.newSingleThreadExecutor(); // sólo un hilo
        final ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> {
            final String threadName = Thread.currentThread().getName();
            System.out.println("Hello Executors. " + threadName);
        });

        executor.submit(task);
        executor.submit(ct.getTask());

        System.out.println("------ Callables.");
        final String leadSpace = "                   ";

        final Callable<Integer> returnTask = () -> {
            try {
                final String callableName = Thread.currentThread().getName();
                final String leadingSpace = "                   ";
                System.out.println(leadingSpace + "Hello Callables. " + callableName);
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "C");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Ca");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Cal");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Call");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Calla");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Callab");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Callabl");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Callable");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Callable.");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(leadingSpace + "Callable. Done.");
                System.out.println(leadingSpace + "I'm done already. " + callableName);
                return 123;
            }
            catch (final InterruptedException e) {
                throw new IllegalStateException(leadSpace + "task interrupted", e);
            }
        };

        final Future<Integer> future = executor.submit(returnTask);

        System.out.println(leadSpace + "future done? " + future.isDone());

        Integer result = null;
        try {
            result = future.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        System.out.print(leadSpace + "future done, now? " + future.isDone());  //now it is. Because we've called get()
        System.out.println(". The result: " + result);


        try {
            System.out.println(leadSpace + "attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (final InterruptedException e) {
            System.err.println(leadSpace + "tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println(leadSpace + "cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println(leadSpace + "shutdown finished");
        }
        System.out.println("------ Done with Executor example.");

        System.out.println("------ InvokeAll.");

        final ExecutorService executor2 = Executors.newWorkStealingPool();


        final Callable<String> thisCallable01 = () -> "task01";
        final Callable<String> thisCallable02 = () -> "task02";
        final Callable<String> thisCallable03 = () -> "task03";
        final List<Callable<String>> theseCallables0 = Arrays.asList(ct.getCall(), thisCallable01, thisCallable02, thisCallable03);

        try {
            executor2.invokeAll(theseCallables0)
            .stream()
            .map(future2 -> {
                try {
                    return future2.get();
                }
                catch (final Exception e) {
                    throw new IllegalStateException(e);
                }
            })
            .forEach(System.out::println);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------ Scheduled Executor example.");

        final ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(1);
        executor3.scheduleAtFixedRate(ct.getCounter(), 5000, 2000, TimeUnit.MILLISECONDS);
        final Runnable scheduledTask = () -> System.out.println("Scheduling: " + System.nanoTime());
        final ScheduledFuture<?> scheduledFuture = executor3.schedule(scheduledTask, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(1337);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        final long remainingDelay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms\n", remainingDelay);
        final Runnable laterTask = () -> System.out.println("Periodic: " + (System.nanoTime() / 1000.0F));

        final int initialDelay = 0;
        final int period = 1;
        executor3.scheduleAtFixedRate(laterTask, initialDelay, period, TimeUnit.SECONDS);

        final Runnable taskFixed = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Fixed: " + (System.nanoTime() / 1000.0F));
            }
            catch (final InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        executor3.scheduleWithFixedDelay(taskFixed, 0, 1, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (final InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("--------------------------------  shutdonw executors.");
        try {
            System.out.println(leadSpace + leadSpace + "attempt to shutdown executor");
            executor2.shutdown();
            executor2.awaitTermination(5, TimeUnit.SECONDS);
            executor3.shutdown();
            executor3.awaitTermination(10, TimeUnit.SECONDS);
        }
        catch (final InterruptedException e) {
            System.err.println(leadSpace + leadSpace + "tasks interrupted");
        }
        finally {
            if ((!executor3.isTerminated()) || (!executor2.isTerminated())) {
                System.err.println(leadSpace + leadSpace + "cancel non-finished tasks");
            }
            executor2.shutdownNow();
            executor3.shutdownNow();
            System.out.println(leadSpace + leadSpace + "shutdown finished");
        }




        System.out.println("Done!");
        System.out.println("paralelism: " + ForkJoinPool.getCommonPoolParallelism());
    }



    /** Retrieve the task for this instance. */
    MyRunnableTask getTask() {
        return this.myTask;
    }

    MyCallableTask getCall() {
        return this.myCall;
    }

    MyPeriodicTask getCounter() {
        return this.myCounter;
    }

    /** Declaration of a task that can be run.*/
    private class MyRunnableTask implements Runnable {
        @Override
        public void run() {
            try {
                final String name = Thread.currentThread().getName();
                System.out.println("Lis " + name);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Lis . " + name);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Lis . . " + name);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Lis . . . " + name);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Lis . . . To " + name);
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /** Declaration of a task that can be called. */
    private class MyCallableTask implements Callable<String> {
        String result;
        @Override
        public String call() {
            return this.result;
        }
        public MyCallableTask(final String result) {
            this.result = result;
        }
    }

    /** Declaration of a task that can be executed periodically */
    private class MyPeriodicTask implements Runnable {
        String name = null;
        long startTime = 0;
        long now = 0;
        @Override
        public void run() {
            this.now = System.currentTimeMillis();
            if (this.name == null) {
                this.name = Thread.currentThread().getName();
                this.startTime = this.now;
                System.out.println("-----------------------------> " + this.name + " is awake now: " + this.now + "; counting seconds");
            } else {
                System.out.println("-----------------------------> " + this.name + ": " + ((this.now - this.startTime)/1000.0F));
            }
        }
    }
}
