package org.goahead;

import lombok.extern.slf4j.Slf4j;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Galaxy
 * @since 2022/6/5 16:51
 */
@SpringBootApplication
@EnableServiceComb
@Slf4j
public class DemoCseConsumer implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(DemoCseConsumer.class);
  }

  @Override
  public void run(String... args) throws Exception {
    // RestTemplate restTemplate = RestTemplateBuilder.create();
    // ResponseEntity<String> responseEntity = restTemplate.getForEntity(
    //     "cse://bmi/calculator/bmi?height=165&weight=75", String.class);
    // log.info("request remote cse success, result is {}", responseEntity.getBody());
  }
}
