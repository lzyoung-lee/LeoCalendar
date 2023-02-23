package com.tencent.wxcloudrun.cache;

import com.tencent.wxcloudrun.dao.LeoCalendarMapper;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holidays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class LeoCalendarCache {

  public static List<DutyRoster> dutyRosterList;
  public static List<Holidays> holidaysList;

  @Autowired
  private LeoCalendarMapper leoCalendarMapper;

  public void LoadDutyRoster() {
    dutyRosterList = leoCalendarMapper.getDutyRosterList();
    Collections.sort(dutyRosterList, new Comparator<DutyRoster>() {
        @Override
        public int compare(DutyRoster obj1, DutyRoster obj2) {
            return obj1.getOrderNo() - obj2.getOrderNo();
        }
    });
    System.out.println(dutyRosterList);
  }

  public void LoadHolidays() {
    holidaysList = leoCalendarMapper.getHolidaysList();
    System.out.println(holidaysList);
  }
}
