package ch.ethz.dinfk.pp;

public class Main {
  public static void main(String[] args) {
    UnboundedBuffer buffer = new UnboundedBuffer();

    Producer producer = new Producer(buffer);
    producer.start();

    Consumer[] consumers = new Consumer[3];

    for (int i = 0; i < consumers.length; ++i) {
      consumers[i] = new Consumer(i, buffer);
      consumers[i].start();
    }
  }
}
