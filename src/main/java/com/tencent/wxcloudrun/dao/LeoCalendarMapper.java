package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holidays;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface LeoCalendarMapper {

  List<DutyRoster> getDutyRosterList();
  int updateDutyRoster(@Param("list") List<DutyRoster> list);

  List<Holidays> getHolidaysList();
}
