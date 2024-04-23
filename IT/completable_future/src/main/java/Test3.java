package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1");
            return "Result 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("2");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2");
            return "Result 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("3");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("3");
            return "Result 3";
        });

        System.out.println("All of before");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        System.out.println("All of after");

        allFutures.thenRun(() -> {
            // All futures completed
            String result1 = future1.join();
            String result2 = future2.join();
            String result3 = future3.join();
            System.out.println(result1 + ", " + result2 + ", " + result3);
        }).join();

        System.out.println("End program");
    }
}
