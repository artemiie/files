package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test2 {
    public static void main(String[] args) {

        CompletableFuture<Integer> future =
            CompletableFuture.supplyAsync(() -> 10)
                .thenApplyAsync(result -> result * 2)
                .thenApplyAsync(result -> result + 5);


        future.thenAccept(result -> System.out.println(result)).join();
    }
}
