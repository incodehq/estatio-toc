package org.incode.estatiotoc.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        WebappModule.class
})
public class EstatioTocApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstatioTocApplication.class, args);
    }

}
