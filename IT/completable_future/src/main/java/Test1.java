package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test1 {
    public static void main(String[] args) {
        CompletableFuture<String> future =
            CompletableFuture.supplyAsync(
                () -> {
                    try {
                        System.out.println("Hello");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Hello, world!";
                });

        System.out.println("World");

        future.thenAccept(System.out::println).join();
    }
}
