package naver.kiel0103.logsender;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "log-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendTopic(String timestamp) {
        kafkaTemplate.send(TOPIC, "time:" + timestamp);
    }
}
