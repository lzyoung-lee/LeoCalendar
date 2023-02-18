package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.DutyRoster;

import java.util.List;

public interface DutyRosterService {

  List<DutyRoster> getDutyRosterList();
  int updateDutyRoster(List<DutyRoster> list);
}
