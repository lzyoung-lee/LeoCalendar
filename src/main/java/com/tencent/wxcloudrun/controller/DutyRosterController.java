package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.service.DutyRosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DutyRoster控制器
 */
@RestController

public class DutyRosterController {

  final DutyRosterService dutyRosterService;
  final Logger logger;

  public DutyRosterController(@Autowired DutyRosterService dutyRosterService) {
    this.dutyRosterService = dutyRosterService;
    this.logger = LoggerFactory.getLogger(DutyRosterController.class);
  }


  /**
   * 获取值班表
   * @return API response json
   */
  @GetMapping(value = "/api/getDutyRosterList")
  ApiResponse getDutyRosterList() {
    logger.info("/api/getDutyRosterList request");
    List<DutyRoster> dutyRosterList = dutyRosterService.getDutyRosterList();
    return ApiResponse.ok(dutyRosterList);
  }

  /**
   * 更新值班表
   */
  @PostMapping(value = "/api/updateDutyRoster")
  ApiResponse updateDutyRoster(List<DutyRoster> list) {
    logger.info("/api/updateDutyRoster request");
    int result = dutyRosterService.updateDutyRoster(list);
    return ApiResponse.ok(result);
  }
}