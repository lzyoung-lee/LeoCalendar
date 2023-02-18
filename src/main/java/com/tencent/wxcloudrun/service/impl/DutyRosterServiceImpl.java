package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.DutyRosterMapper;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.service.DutyRosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DutyRosterServiceImpl implements DutyRosterService {

  final DutyRosterMapper dutyRosterMapper;

  public DutyRosterServiceImpl(@Autowired DutyRosterMapper dutyRosterMapper) {
    this.dutyRosterMapper = dutyRosterMapper;
  }

  @Override
  public List<DutyRoster> getDutyRosterList() {
    return dutyRosterMapper.getDutyRosterList();
  }

  @override
  public int updateDutyRoster(List<DutyRoster> list) {
    return dutyRosterMapper.updateDutyRoster(list);
  }
}
