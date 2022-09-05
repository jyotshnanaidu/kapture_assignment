package com.example.kapture_assignment.service;

import com.example.kapture_assignment.Repository.CallRepository;
import com.example.kapture_assignment.modal.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class CallService {

    @Autowired
    private CallRepository callRepository;

    public String getHourWithLongestCalls(String date) {
        String result = "";
        try {
            if (date != null && !date.equals("")) {
                LocalDate localDate = LocalDate.parse(date);
                ResultEntity hourCallLongest = callRepository.getHourWithLongestCalls(localDate);
                String time = "";
                Integer hour = hourCallLongest.getHour();

                if (hour >= 12) {
                    time = "PM";
                } else {
                    time = "AM";
                }
                result = "Hour of the day when the call volume is highest is " + hour + time + "-" + (hour + 1) + time;
            }
        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    public String getHourWithHighestVolume(String date) {
        String result = null;
        try {
            if (date != null && !date.equals("")) {
                LocalDate localDate = LocalDate.parse(date);
                ResultEntity hourVolumeHighest = callRepository.getHourWithHighestVolume(localDate);
                String time = "";
                Integer hour = hourVolumeHighest.getHour();

                if (hour >= 12) {
                    time = "PM";
                } else {
                    time = "AM";
                }
                result = "Hour of the day when the call volume is highest is " + hour + time + "-" + (hour + 1) + time;
            }
        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    public String getDayWithLongestVolume() {
        String result = "";
        try {
            ResultEntity dayVolumeHighest = callRepository.getDayWithLongestVolume();

            if (dayVolumeHighest != null) {
                String Month = "";
                Integer monthFromDatabase = dayVolumeHighest.getMonth();
                String day = dayVolumeHighest.getDay();
                Integer year = dayVolumeHighest.getYear();

                switch (monthFromDatabase) {
                    case 1:
                        Month = "January";
                        break;
                    case 2:
                        Month = "February";
                        break;
                    case 3:
                        Month = "March";
                        break;
                    case 4:
                        Month = "April";
                        break;
                    case 5:
                        Month = "May";
                        break;
                    case 6:
                        Month = "June";
                        break;
                    case 7:
                        Month = "July";
                        break;
                    case 8:
                        Month = "August";
                        break;
                    case 9:
                        Month = "September";
                        break;
                    case 10:
                        Month = "October";
                        break;
                    case 11:
                        Month = "November";
                        break;
                    case 12:
                        Month = "December";
                }

                result = "Day : " + day + ", Month : " + Month + ", Year : " + year;
            }
        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    public String getDayWithLongestDuration() {
        String result = "";
        try {
            ResultEntity dayCallLongest = callRepository.getDayWithLongestDuration();

            if (dayCallLongest != null) {
                String Month = "";
                Integer monthFromDatabase = dayCallLongest.getMonth();
                String day = dayCallLongest.getDay();
                Integer week = dayCallLongest.getWeek();
                Integer year = dayCallLongest.getYear();

                switch (monthFromDatabase) {
                    case 1:
                        Month = "January";
                        break;
                    case 2:
                        Month = "February";
                        break;
                    case 3:
                        Month = "March";
                        break;
                    case 4:
                        Month = "April";
                        break;
                    case 5:
                        Month = "May";
                        break;
                    case 6:
                        Month = "June";
                        break;
                    case 7:
                        Month = "July";
                        break;
                    case 8:
                        Month = "August";
                        break;
                    case 9:
                        Month = "September";
                        break;
                    case 10:
                        Month = "October";
                        break;
                    case 11:
                        Month = "November";
                        break;
                    case 12:
                        Month = "December";
                }

                result = "Day : " + day + ", Week : " + week + ", Month : " + Month + ", Year : " + year;
            }
        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }
}