package com.example.test.controllers;

import com.example.test.model.Weather;
import com.example.test.quartz.QuartzJob;
import com.example.test.service.CityService;
import com.example.test.service.JParseImpl;
import com.example.test.service.WeatherAPI;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/city")
public class CityController {
    //String name = "Kharkov";

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public @ResponseBody String getWeather(@PathVariable String name) throws SchedulerException {
        String response = WeatherAPI.getCity(name);
        JParseImpl jParse = new JParseImpl();
        Weather weather = jParse.jParse(response);

        //тут я уже пробовал как нибудь и что нибудь чтобы сработал кварц(

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = JobBuilder.newJob(QuartzJob.class).build();
//                .withIdentity("job1", "group1")
//                .storeDurably()
//                .withDescription("Test1")
//                .build();

        Trigger t3 = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(05).repeatForever()).build();

        scheduler.scheduleJob(job, t3);
        scheduler.start();

        //cityService.save(weather);
        return "Погода успешно сохранена в Базу данных" + response;
    }
}
