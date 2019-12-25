package com.example.springssm.config;

import com.example.springssm.controller.quartz.testquartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: taoshengjie
 * @Date: 2019/11/12 17:33
 * @Description:
 */
@Configuration
public class quartzconfig {
//        @Bean
//        public JobDetail testQuartz1() {
//            return JobBuilder.newJob(testquartz.class).withIdentity("testTask1").storeDurably().build();
//        }
//
//        @Bean
//        public Trigger testQuartzTrigger1() {
//            //5秒执行一次
//            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                    .withIntervalInSeconds(5)
//                    .repeatForever();
//            return TriggerBuilder.newTrigger().forJob(testQuartz1())
//                    .withIdentity("testTask1")
//                    .withSchedule(scheduleBuilder)
//                    .build();
//        }

        @Bean
        public JobDetail testQuartz2() {
            return JobBuilder.newJob(testquartz.class).withIdentity("testTask2").storeDurably().build();
        }

        @Bean
        public Trigger testQuartzTrigger2() {
            //cron方式，每隔5秒执行一次
            return TriggerBuilder.newTrigger().forJob(testQuartz2())
                    .withIdentity("testTask2")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 18 * * ? "))
                    .build();
        }

}
