package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ChangeDuty;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holiday;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface LeoCalendarMapper {

  List<DutyRoster> getDutyRosterList();
  int updateDutyRoster(@Param("list") List<DutyRoster> list);

  List<Holiday> getHolidayList();

  List<ChangeDuty> getChangeDutyList();
  int addChangeDutys(@Param("list") List<ChangeDuty> list);
  int deleteChangeDutys(@Param("list") List<ChangeDuty> list);
  int clearChangeDuty();
}
