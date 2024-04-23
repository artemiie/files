package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test6 {
  public static void main(String[] args) {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

    CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(s -> {
      System.out.println("Thread: " + Thread.currentThread().getName());
      return s.length();
    });

    transformedFuture.thenAccept(length -> {
      System.out.println("Thread: " + Thread.currentThread().getName());
      System.out.println("Length of Hello: " + length);
    });
  }
}
