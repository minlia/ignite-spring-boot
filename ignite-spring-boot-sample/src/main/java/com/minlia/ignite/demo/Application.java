package com.minlia.ignite.demo;

import org.apache.ignite.Ignite;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.minlia.ignite.spring.IgniteApplicationContext;
import com.minlia.ignite.spring.annotations.IgniteResource;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setApplicationContextClass(IgniteApplicationContext.class);
        app.run(args);
    }

    @Bean
    public CommandLineRunner runIgnite() {
        return new CommandLineRunner() {
            @IgniteResource(gridName = "test", clientMode = true)
            private Ignite igniteClient;

            public void run(String... args) throws Exception {
                igniteClient.compute().broadcast(() -> System.out.println("Hello World!"));
                igniteClient.close();
            }
        };
    }
}
