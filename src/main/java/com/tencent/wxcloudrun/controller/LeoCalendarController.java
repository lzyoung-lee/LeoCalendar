package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holidays;
import com.tencent.wxcloudrun.service.LeoCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DutyRoster控制器
 */
@RestController

public class LeoCalendarController {

  final LeoCalendarService leoCalendarService;
  final Logger logger;

  public LeoCalendarController(@Autowired LeoCalendarService leoCalendarService) {
    this.leoCalendarService = leoCalendarService;
    this.logger = LoggerFactory.getLogger(LeoCalendarController.class);
  }


  /**
   * 获取值班表
   */
  @GetMapping(value = "/api/getDutyRosterList")
  ApiResponse getDutyRosterList() {
    logger.info("/api/getDutyRosterList request");
    List<DutyRoster> dutyRosterList = leoCalendarService.getDutyRosterList();
    return ApiResponse.ok(dutyRosterList);
  }

  /**
   * 更新值班表
   */
  @PostMapping(value = "/api/updateDutyRoster")
  ApiResponse updateDutyRoster(@RequestBody List<DutyRoster> list) {
    logger.info("/api/updateDutyRoster request");
    int result = leoCalendarService.updateDutyRoster(list);
    return ApiResponse.ok(result);
  }

  /**
   * 获取节假日表
   */
  @GetMapping(value = "/api/getHolidaysList")
  ApiResponse getHolidaysList() {
    logger.info("/api/getHolidaysList request");
    List<Holidays> holidaysList = leoCalendarService.getHolidaysList();
    return ApiResponse.ok(holidaysList);
  }

}