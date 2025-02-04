package com.example.flymate.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

      public static LocalDateTime convertStringIntoTimestamp(String dateTimeString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm");
        // Parse the string to LocalDateTime
        return LocalDateTime.parse(dateTimeString, formatter);
    }

}
