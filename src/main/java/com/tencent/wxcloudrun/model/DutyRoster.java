package com.tencent.wxcloudrun.model;
import lombok.Data;
import java.io.Serializable;

@Data
public class DutyRoster implements Serializable {

  private Integer id;
  private String name;
  private Integer order;
  private String color;
}
