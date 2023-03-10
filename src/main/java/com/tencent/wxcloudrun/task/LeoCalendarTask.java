package com.tencent.wxcloudrun.task;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tencent.wxcloudrun.cache.LeoCalendarCache;
import com.tencent.wxcloudrun.dao.LeoCalendarMapper;
import com.tencent.wxcloudrun.model.ChangeDuty;
import com.tencent.wxcloudrun.model.DutyRoster;
import com.tencent.wxcloudrun.model.Holiday;

@Component
public class LeoCalendarTask {

    @Autowired
    private LeoCalendarMapper leoCalendarMapper;

    @Scheduled(cron="0 50 23 28-31 * ?") // 每月最后一日的晚上23:50触发
    public void ReOrderDutyRoster() {

        Calendar calendar = Calendar.getInstance();
        System.out.println("xxxxxx day: " + calendar.get(Calendar.DATE) + ", daysOfMonth: " + daysOfMonth());
        if(calendar.get(Calendar.DATE) != daysOfMonth())
            return;

        // 重新计算下个月的排班表
        List<DutyRoster> dutyRosterList = LeoCalendarCache.dutyRosterList.stream().collect(Collectors.toList());
        int workdays = workdaysOfMonth();
        int size = dutyRosterList.size();
        int moveSize = workdays % size;
        Collections.rotate(dutyRosterList, -moveSize); // 左移moveSize
        for (int index = 0; index < size; ++index) {
            DutyRoster dutyRoster = dutyRosterList.get(index);
            dutyRoster.setOrderNo(index + 1);
        }

        int result = leoCalendarMapper.updateDutyRoster(dutyRosterList);
        if(result > 0) {
            LeoCalendarCache.dutyRosterList = dutyRosterList;
        }

        // 清空当月change_duty数据
        int month = calendar.get(Calendar.MONTH) + 1;
        List<ChangeDuty> changeDutyList = LeoCalendarCache.changeDutyList.stream()
        .filter(item -> (month == item.getMonth())).collect(Collectors.toList());
        int deleteResult = leoCalendarMapper.deleteChangeDutys(changeDutyList);
        if(deleteResult > 0) {
            LeoCalendarCache.changeDutyList.removeAll(changeDutyList);
        }
    }

    // 当月工作日
    private int workdaysOfMonth() {

        int wordays = 0;
        int daysOfMonth = daysOfMonth();
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        for(int index = 1; index <= daysOfMonth; ++index) {
            int day = index;
            calendar.set(Calendar.DATE, day);
            Holiday holiday = LeoCalendarCache.holidayList.stream()
            .filter(item -> ((month == item.getMonth()) && (day == item.getDay())))
            .findAny().orElse(null);

            if(null != holiday) {
                if(!holiday.getType()) {
                    wordays++;
                }
            } else {
                int weekday = calendar.get(Calendar.DAY_OF_WEEK);
                if((1 != weekday) && (7 != weekday)) {
                    wordays++;
                }
            }
        }

        return wordays;
    }

    // 当月的天数
    private int daysOfMonth() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.get(Calendar.DATE);
    }
}
