package naver.kiel0103.logsender;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequiredArgsConstructor
public class FrontController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/")
    public String index() {
        kafkaProducer.sendTopic(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return "MyWeb";
    }
}
