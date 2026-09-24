package co.edu.jdc.sigepaisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SigepaisaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigepaisaApplication.class, args);
    }
}
