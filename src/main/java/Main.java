public class Main {
    public static void main(String args[]) throws InterruptedException {
        MessageProducer producer = new MessageProducer("localhost", 9092, "helloKafka");
        MessageConsumer consumer = new MessageConsumer("localhost", 9092, "helloKafka");

        Thread producerThread = new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                producer.Send(Long.toString(System.currentTimeMillis()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();

        consumer.Consume();
    }
}
