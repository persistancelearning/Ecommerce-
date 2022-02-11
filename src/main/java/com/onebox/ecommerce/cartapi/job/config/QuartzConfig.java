package com.onebox.ecommerce.cartapi.job.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onebox.ecommerce.cartapi.job.TimeToLiveJob;

@Configuration
public class QuartzConfig {

  @Bean
  public JobDetail jobDetails() {
    return JobBuilder.newJob(TimeToLiveJob.class).withIdentity("TimeToLiveJob").storeDurably().build();
  }

  @Bean
  public Trigger jobTrigger(JobDetail jobDetails) {
    return TriggerBuilder.newTrigger()
        .forJob(jobDetails)
        .withIdentity("TimeToLiveJob")
        .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever())
        .build();
  }

}
