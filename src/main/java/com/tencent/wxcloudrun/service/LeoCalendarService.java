package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holidays;

import java.util.List;

public interface LeoCalendarService {

  List<DutyRoster> getDutyRosterList();
  int updateDutyRoster(List<DutyRoster> list);

  List<Holidays> getHolidaysList();
}
