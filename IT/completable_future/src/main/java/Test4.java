package IT.completable_future.src.main.java;

import java.util.concurrent.CompletableFuture;

public class Test4 {
  public static void main(String[] args) {

    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
      int result = 10 / 0; // Causes an ArithmeticException
      return result;
    });

    future.exceptionally(ex -> {
      System.out.println("Exception occurred: " + ex.getMessage());
      return 0; // Default value to return if there's an exception
    }).thenAccept(result -> {
      System.out.println("Result: " + result);
    });
  }
}
