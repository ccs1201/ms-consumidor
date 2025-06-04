package br.com.ccs.msconsumidor;

import br.com.messagedispatcher.annotation.EnableMessageDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMessageDispatcher
public class MsConsumidorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsConsumidorApplication.class, args);
    }

}
