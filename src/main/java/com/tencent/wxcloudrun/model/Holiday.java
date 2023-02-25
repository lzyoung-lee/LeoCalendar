package com.tencent.wxcloudrun.model;
import lombok.Data;
import java.io.Serializable;

@Data
public class Holiday implements Serializable {

  private Integer id;
  private Integer month;
  private Integer day;
  private Boolean type;
  private String info;

  Holiday() {
    id = 0;
    month = 0;
    day = 0;
    type = true;
    info = "";
  }
}
