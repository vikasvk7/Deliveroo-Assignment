package com.deliveroo.assignment.ParseHandlers;

import java.util.Set;
import java.util.TreeSet;

import com.deliveroo.assignment.CronFieldType;
import com.deliveroo.assignment.InvalidCronFieldException;

public interface ParseHandlerInterface {

	Set<Integer> parseField(String text, CronFieldType type) throws InvalidCronFieldException;
	
	public static int parseNumber(String numString, CronFieldType type) throws InvalidCronFieldException {
        try {
            return Integer.parseInt(numString);
        } catch (NumberFormatException nfe) {
        	throw new InvalidCronFieldException("Invalid number '" + numString + "' in field " + type + ": " + nfe.getMessage());
        }
	}
	
    public static Set<Integer> populateValues(String text, int start, int end, int increment, CronFieldType type) throws InvalidCronFieldException {
    	
    	Set<Integer> values = new TreeSet<>();
    	
        if (increment == 0) {
        	throw new InvalidCronFieldException("Number " + text + " for " + type + " interval is 0");
        }
        if (end < start) {
        	throw new InvalidCronFieldException("Number " + text + " for " + type + " ends before it starts");
        }
        if (start < type.min || end > type.max) {
        	throw new InvalidCronFieldException("Number " + text + " for " + type + " is outside valid range (" + type.min + "-" + type.max + ")");
        }
        for (int i = start; i <= end; i += increment) {
            values.add(i);
        }
        return values;
    }
}
