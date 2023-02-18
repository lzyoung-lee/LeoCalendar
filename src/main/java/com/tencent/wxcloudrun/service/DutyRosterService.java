package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.DutyRoster;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DutyRosterService {

  List<DutyRoster> getDutyRosterList();
  int updateDutyRoster(@Param("list") List<DutyRoster> list);
}
