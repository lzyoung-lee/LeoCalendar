package com.tencent.wxcloudrun.model;
import lombok.Data;
import java.io.Serializable;

@Data
public class Holidays implements Serializable {

  private Integer id;
  private Integer month;
  private Integer day;
  private Boolean type;
  private String info;

  Holidays() {
    id = 0;
    month = 0;
    day = 0;
    type = true;
    info = "";
  }
}
