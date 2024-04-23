package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test7 {
  public static void main(String[] args) {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

    CompletableFuture<Void> transformedFuture = future.thenAcceptAsync(s -> {
      System.out.println("Thread: " + Thread.currentThread().getName());
    });

    transformedFuture.thenAccept(length -> {
      System.out.println("Thread: " + Thread.currentThread().getName());
      System.out.println("Length of Hello: " + length);
    }).join();
  }
}
