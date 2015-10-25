package edu.avans.ivh5.shared.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatter {

    private DateFormatter() { // private constructor, shouldn't be instaniated
        throw new UnsupportedOperationException("Don't instantiate DateFormatter");
    }
    
    static SimpleDateFormat dateFormat;
    
    static {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    public static String dateToString(java.util.Date date) {
        return dateFormat.format(date);
    }
    
    public static java.util.Date stringToDate(String date)
    {
        try
        {
            return dateFormat.parse(date);
        }
        catch(ParseException e)
        {
            throw new RuntimeException("Invalid date format");
        }
    }
    
}
