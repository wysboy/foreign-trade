package org.jeecg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
@SpringBootApplication
//@EnableAutoConfiguration
public class JeecgApplication {

  public static void main(String[] args)  {
    ConfigurableApplicationContext application = SpringApplication.run(JeecgApplication.class, args);
  }
}