package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.DutyRoster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface DutyRosterMapper {

  List<DutyRoster> getDutyRosterList();
  // DutyRoster getDutyRoster(@Param("id") Integer id);
}
