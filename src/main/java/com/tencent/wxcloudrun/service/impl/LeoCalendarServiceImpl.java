package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.cache.LeoCalendarCache;
import com.tencent.wxcloudrun.dao.LeoCalendarMapper;
import com.tencent.wxcloudrun.model.ChangeDuty;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holiday;
import com.tencent.wxcloudrun.service.LeoCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeoCalendarServiceImpl implements LeoCalendarService {

  final LeoCalendarMapper leoCalendarMapper;

  public LeoCalendarServiceImpl(@Autowired LeoCalendarMapper leoCalendarMapper) {
    this.leoCalendarMapper = leoCalendarMapper;
  }

  @Override
  public List<DutyRoster> getDutyRosterList() {
    return LeoCalendarCache.dutyRosterList;
  }

  @Override
  public int updateDutyRoster(List<DutyRoster> list) {
    int result = leoCalendarMapper.updateDutyRoster(list);
    if(result > 0) {
      LeoCalendarCache.dutyRosterList = list;
    }
    
    return result;
  }

  @Override
  public List<Holiday> getHolidayList() {
    return LeoCalendarCache.holidayList;
  }

  @Override
  public List<ChangeDuty> getChangeDutyList() {
    return LeoCalendarCache.changeDutyList;
  }

  @Override
  public int addChangeDutys(List<ChangeDuty> list) {
    int result = leoCalendarMapper.addChangeDutys(list);
    if(result > 0) {
      for (ChangeDuty changeDuty : list) {
        ChangeDuty data = LeoCalendarCache.changeDutyList.stream()
        .filter(item -> ((changeDuty.getMonth() == item.getMonth()) && (changeDuty.getDay() == item.getDay())))
        .findAny().orElse(null);
        
        if(null != data) {
          int index = LeoCalendarCache.changeDutyList.indexOf(data);
          LeoCalendarCache.changeDutyList.set(index, changeDuty);
        } else {
          LeoCalendarCache.changeDutyList.add(changeDuty);
        }
      }
    }

    return result;
  }

  @Override
  public int deleteChangeDutys(List<ChangeDuty> list) {
    int result = leoCalendarMapper.deleteChangeDutys(list);
    if(result > 0) {
      for (ChangeDuty changeDuty : list) {
        LeoCalendarCache.changeDutyList.remove(changeDuty);
        ChangeDuty data = LeoCalendarCache.changeDutyList.stream()
        .filter(item -> ((changeDuty.getMonth() == item.getMonth()) && (changeDuty.getDay() == item.getDay())))
        .findAny().orElse(null);

        if(null != data) {
          LeoCalendarCache.changeDutyList.remove(data);
        }
      }
    }

    System.out.println(LeoCalendarCache.changeDutyList);
    return result;
  }

}
