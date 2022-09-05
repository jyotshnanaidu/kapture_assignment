package com.example.kapture_assignment.controller;

import com.example.kapture_assignment.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

@RestController
@RequestMapping("/api/v1/calls")
public class Controller {

    @Autowired
    private final CallService service;

    public Controller(CallService service) {
        this.service = service;
    }

    @GetMapping("/hour/longest/{date}")
    //url = http://localhost:8090/api/v1/calls/hour/longest/2021-01-13
    String getHourWithLongestCalls(@PathVariable String date) throws ParseException {
        return service.getHourWithLongestCalls(date);
    }

    @GetMapping("/calls/{date}")
    //url = http://localhost:8090/api/v1/calls/calls/2021-01-13
    String getHourWithHighestVolume(@PathVariable String date) {
        return service.getHourWithHighestVolume(date);
    }

    @GetMapping("/week/volume")
    //url = http://localhost:8090/api/v1/calls/week/volume
    String getDayWithLongestVolume() {
        return service.getDayWithLongestVolume();
    }

    @GetMapping("/week/longest")
    //url = http://localhost:8090/api/v1/calls/week/longestō
    String getDayWithLongestDuration() {
        return service.getDayWithLongestDuration();
    }

}