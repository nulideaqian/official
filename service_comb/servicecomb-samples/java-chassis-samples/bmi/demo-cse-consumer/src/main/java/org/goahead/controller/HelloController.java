package org.goahead.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.util.JSONObject1O;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.goahead.resp.BmiCalculateResp;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author Galaxy
 * @since 2022/6/5 17:38
 */
@RestSchema(schemaId = "demoCseConsumer")
@RequestMapping("/")
@Slf4j
public class HelloController {

  @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public BmiCalculateResp say(@RequestParam("height") String height, @RequestParam("weight") String weight) {
    RestTemplate restTemplate = RestTemplateBuilder.create();
    Map<String, String> queryParams = Map.of("height", height, "weight", weight);
    ResponseEntity<Object> response = restTemplate.getForEntity(
        "cse://calculator/bmi?height={height}&weight={weight}", Object.class, queryParams);
    log.info("request remote cse success, result is {}", response.getBody());
    return new ObjectMapper().convertValue(response.getBody(), BmiCalculateResp.class);
  }

}
