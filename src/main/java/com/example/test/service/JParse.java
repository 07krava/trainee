package com.example.test.service;

import com.example.test.model.Weather;
import net.minidev.json.JSONObject;

import java.util.Map;

public interface JParse {

    public Weather jParse(Object json);
}
