package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test8 {
  public static void main(String[] args) {
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
      System.out.println("Thread: " + Thread.currentThread().getName());
      System.out.println("Hello from async task");
    });

    future.join();
  }
}
