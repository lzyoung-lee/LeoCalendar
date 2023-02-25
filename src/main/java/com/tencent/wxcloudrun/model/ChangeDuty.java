package com.tencent.wxcloudrun.model;
import lombok.Data;
import java.io.Serializable;

@Data
public class ChangeDuty implements Serializable {

  private Integer month;
  private Integer day;
  private String name;
  private Integer dutyId;

  ChangeDuty() {
    month = 0;
    day = 0;
    name = "";
    dutyId = 0;
  }
}
