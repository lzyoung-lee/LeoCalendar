package com.tencent.wxcloudrun.model;
import lombok.Data;
import java.io.Serializable;

@Data
public class DutyRoster implements Serializable {

  private Integer id;
  private String name;
  private Integer orderNo;
  private String color;

  DutyRoster() {
    id = 0;
    name = "";
    orderNo = 0;
    color = "";
  }
}
