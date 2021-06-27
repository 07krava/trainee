package com.example.test.quartz;

import com.example.test.model.Weather;
import com.example.test.service.JParseImpl;
import com.example.test.service.ServiceJob;
import com.example.test.service.WeatherAPI;
import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzJob implements Job {

    private ServiceJob serviceJob;
    @SneakyThrows
    @Override

    /* это стандартный метод в котором задается та работа которая будет выполняться с помощью кварца*/
    public void execute(JobExecutionContext jobExecutionContext) {
       // String response = WeatherAPI.getCity(name);
        JParseImpl jParse = new JParseImpl();
        // здесь в методе getCityAPI() должна быть переменная которую я не могу добавить потому что она нигде не инициализированна
        String nameTest = serviceJob.getCityAPI();
        Weather weather = jParse.jParse(nameTest);

    }
}
