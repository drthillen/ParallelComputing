package ch.ethz.dinfk.pp;

import java.util.Random;

public class Consumer extends Thread {
  private final int id;
  private final UnboundedBuffer buffer;

  public Consumer(int id, UnboundedBuffer buffer) {
    this.id = id;
    this.buffer = buffer;
  }

  @Override
  public void run() {
//    System.out.printf("[Consumer %d] ### STARTED ###\n", id);

    long prime;
    while (true) {
      synchronized (buffer) {
      while (buffer.isEmpty()) {
        try {

          buffer.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      };
        prime = buffer.remove();
        performLongRunningComputation(prime);
        buffer.notifyAll();



    }}
  }

  private void performLongRunningComputation(long prime) {
    System.out.printf("[Consumer %d] %d\n", id, prime);

    try {
      // Thread.sleep "simulates" a longer-running computation that
      // uses the prime number
      sleep(new Random().nextInt(50));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
