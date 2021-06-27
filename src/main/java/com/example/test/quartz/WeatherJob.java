package com.example.test.quartz;

import com.example.test.service.ServiceJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class WeatherJob {

    // в этом методе создается обьектв  в который передается то что нужно выполнять(описсаное в классе QuartzJob)
    public void workJob() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(QuartzJob.class).build();

        //ниже приведенны 3 условия при выполнении которых будет выполнять задача описанная в кварце

        // запуск программы только 1 раз(называется - SimpleTrigger)!
        //Trigger t1 = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger").startNow().build();

        // запуск программы через определенное время(в данном случае каждую минуту)
        //Trigger t2 = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();

        // запуск программы каждые 5 сек
        Trigger t3 = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(05).repeatForever()).build();

        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();

        sc.start();
        sc.scheduleJob(job, t3);
    }

}
