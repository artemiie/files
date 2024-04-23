package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test9 {
  public static void main(String[] args) {
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");

    CompletableFuture<String> future2 = future1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> s + " World"));

    future2.thenAccept(result -> System.out.println(result)).join();
  }
}
