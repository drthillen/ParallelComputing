package ch.ethz.dinfk.pp;

public class Producer extends Thread {
  private final UnboundedBuffer buffer;

  public Producer(UnboundedBuffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    // System.out.println("[Producer] ### STARTED ###");

    // Start with a large (potentially non-prime) value to slow down producer.
    // The starting value must be odd; otherwise, computeNextPrime will fail!
    long prime = Long.MAX_VALUE / 1_000_000 - 1;
    int i = 0;
    while (true && i++ < 1_00) {
      prime = computeNextPrime(prime);

      buffer.add(prime);
    }
  }

  // A straightforward (and inefficient) prime number generator
  private long computeNextPrime(long start) {
    assert start % 2 == 1 : "start value must be odd, but got " + start;

    long next = start + 2;

    while (!isPrime(next))
      next += 2;

    System.out.printf("[Producer]   %d\n", next);

    return next;
  }

  // A straightforward (and inefficient) prime number tester
  private boolean isPrime(long n) {
    assert 2 <= n : "n value must be at least 2, but got " + n;

    long root = (long) Math.sqrt(n);

    for (long i = 2; i <= root; ++i)
      if (n % i == 0)
        return false;

    return true;
  }
}
