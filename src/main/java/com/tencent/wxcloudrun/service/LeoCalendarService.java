package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.ChangeDuty;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holiday;

import java.util.List;

public interface LeoCalendarService {

  List<DutyRoster> getDutyRosterList();
  int updateDutyRoster(List<DutyRoster> list);

  List<Holiday> getHolidayList();

  List<ChangeDuty> getChangeDutyList();
  int addChangeDutys(List<ChangeDuty> list);
  int deleteChangeDutys(List<ChangeDuty> list);
}
