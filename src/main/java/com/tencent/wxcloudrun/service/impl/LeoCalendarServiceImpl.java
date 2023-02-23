package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.cache.LeoCalendarCache;
import com.tencent.wxcloudrun.dao.LeoCalendarMapper;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holidays;
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
  public List<Holidays> getHolidaysList() {
    return LeoCalendarCache.holidaysList;
  }
}
