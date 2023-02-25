package com.tencent.wxcloudrun.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LeoCalendarStartupRunner implements CommandLineRunner {

  @Autowired
  private LeoCalendarCache leoCalendarCache;

  @Override
  public void run(String... strings) throws Exception {
    leoCalendarCache.LoadDutyRoster();
    leoCalendarCache.LoadHolidays();
    leoCalendarCache.LoadChangeDuty();
  }
}
