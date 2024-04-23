package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test5 {
    public static void main(String[] args) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int result = 10 / 0; // Causes an ArithmeticException
            return result;
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return 20;
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        allFutures.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null; // Default value to return if there's an exception
        }).thenRun(() -> {
            // All futures completed
            int result1 = future1.exceptionally(throwable -> {
                System.out.println("Future 1 throw and exception");
                return 0;
            }).join();

            int result2 = future2.exceptionally(throwable -> {
                System.out.println("Future 2 throw and exception");
                return 0;
            }).join();

            int result3 = future3.exceptionally(throwable -> {
                System.out.println("Future 3 throw and exception");
                return 0;
            }).join();

            System.out.println(result1 + ", " + result2 + ", " + result3);
        });
    }
}
