package com.hit.eryi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@Slf4j
@SpringBootApplication
public class EryiApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(EryiApplication.class);
        //apollo 配置从profile中取
        Environment env = app.run(args).getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "com.hit.eryi Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "Swagger API:http://127.0.0.1:{}/swagger-ui.html\n\t" +
                        "Druid index:http://127.0.0.1:{}/druid/index.html\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.port"),
                env.getProperty("server.port"));
    }

}
