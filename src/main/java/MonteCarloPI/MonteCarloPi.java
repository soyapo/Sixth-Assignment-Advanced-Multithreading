package MonteCarloPI;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MonteCarloPi {

    static final long NUM_POINTS = 50_000_000L;
    static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        // Without Threads
        System.out.println("Single threaded calculation started: ");
        long startTime = System.nanoTime();
        double piWithoutThreads = estimatePiWithoutThreads(NUM_POINTS);
        long endTime = System.nanoTime();
        System.out.println("Monte Carlo Pi Approximation (single thread): " + piWithoutThreads);
        System.out.println("Time taken (single threads): " + (endTime - startTime) / 1_000_000 + " ms");

        // With Threads
        System.out.println("Multi threaded calculation started: ");
        startTime = System.nanoTime();
        double piWithThreads = estimatePiWithThreads(NUM_POINTS, NUM_THREADS);
        endTime = System.nanoTime();
        System.out.println("Monte Carlo Pi Approximation (Multi-threaded): " + piWithThreads);
        System.out.println("Time taken (Multi-threaded): " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // TODO: Monte Carlo Pi Approximation without threads
    public static double estimatePiWithoutThreads(long numPoints)
    {
        // TODO: Implement this method to calculate Pi using a single thread
        return 0;
    }

    // TODO : Monte Carlo Pi Approximation with threads
    public static double estimatePiWithThreads(long numPoints, int numThreads) throws InterruptedException, ExecutionException
    {
        // TODO: Implement this method to calculate Pi using multiple threads
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        // HINT: You may need to create some local variables

        // TODO: Divide the work into tasks for each thread

        //TODO: do not remember to shutdown executor
        //TODO: wait for executor to be fully terminated
        //TODO: complete the calculation and return the result
        return 0;
    }
}