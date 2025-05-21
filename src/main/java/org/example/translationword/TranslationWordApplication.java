package org.example.translationword;

import org.example.translationword.config.DeeplProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DeeplProperty.class)
public class TranslationWordApplication {

    public static void main(String[] args) {
        SpringApplication.run(TranslationWordApplication.class, args);
    }

}