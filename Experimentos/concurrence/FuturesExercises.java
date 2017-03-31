/**
 * FuturesExercises.java 31/05/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.concurrence;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 31/05/2016
 *
 */
public class FuturesExercises {
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);
    /**
     *
     *
     * @param args
     */
    public static void main(final String[] args) {
        Future<String> contentsFuture;
        try {
            contentsFuture = startDownloading(new URL("http://www.google.com"));
            while (!contentsFuture.isDone()) {

                askUserToWait();

                doSomeComputationInTheMeantime();

            }

            contentsFuture.get();
        } catch (final MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     *
     *
     * @param url
     * @return
     */
    private static Future<String> startDownloading(final URL url) {
        return FuturesExercises.pool.submit(new Callable<String>() {

            @Override

            public String call() throws Exception {
                String result = null;
                try (InputStream input = url.openStream()) {
                    final BufferedReader in = new BufferedReader(
                            new InputStreamReader(url.openStream()));
                    String inputLine;
                    final StringBuilder bufer = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        bufer.append(inputLine);
                    }
                    in.close();
                    result = bufer.toString();
                }
                return result;
            }

        });
    }

    /**
     *
     *
     */
    private static void doSomeComputationInTheMeantime() {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (final InterruptedException e) {
            System.out.println("doSomeComputationInTheMeantime was interrupted with message: " + e.getMessage());
        }
    }

    /**
     * Keep the user under the illusion that everything is peachy.
     *
     */
    private static void askUserToWait() {
        System.out.println("Please wait some more seconds.");
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (final InterruptedException e) {
            System.out.println("askUserToWait was interrupted with message: " + e.getMessage());
        }
    }

}
