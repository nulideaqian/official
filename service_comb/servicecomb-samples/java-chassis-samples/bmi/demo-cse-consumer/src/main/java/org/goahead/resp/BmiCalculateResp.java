package org.goahead.resp;

import lombok.Data;

/**
 * @author Galaxy
 * @since 2022/6/5 18:12
 */
@Data
public class BmiCalculateResp {

  private double result;

  private String instanceId;

  private String callTime;

}
