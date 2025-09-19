package co.ptm.multi_binder_kinesis_rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@SpringBootApplication
public class MultiBinderKinesisRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiBinderKinesisRabbitApplication.class, args);
	}

	@Bean
	public Consumer<Message<String>> kinesisConsumerOne(){
		return message ->
				log.info(message.getPayload().toString());
	}

	@Bean
	public Consumer<Message<String>> rabbitConsumerOne(){
		return message ->
				log.info(message.getPayload().toString());
	}

}
