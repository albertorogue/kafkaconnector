import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

public class MessageProducer {
    private Producer<String, String> producer;
    private String topic;

    public MessageProducer(String host, int port, String topic){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, String.format("%s:%s", host, port));
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        this.topic = topic;
        this.producer = new KafkaProducer<>(properties);
    }

    public void Send(String message){

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, null, message);

        //Sending message to Kafka Broker
        producer.send(record);
        producer.flush();
    }
}
