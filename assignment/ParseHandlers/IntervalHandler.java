package com.deliveroo.assignment.ParseHandlers;

import java.util.Set;

import com.deliveroo.assignment.CronFieldType;
import com.deliveroo.assignment.InvalidCronFieldException;

public class IntervalHandler implements ParseHandlerInterface {

	public Set<Integer> parseField(String text, CronFieldType type) throws InvalidCronFieldException {
        int interval = 1;
        String[] intervals = text.split("/");
        if (intervals.length > 2) {
        	throw new InvalidCronFieldException("Number " + text + " for " + type + "has too many intervals");
        }
        if (intervals.length == 2) {
            interval = ParseHandlerInterface.parseNumber(intervals[1], type);
        }
        return ParseHandlerInterface.populateValues(text, type.min, type.max, interval, type);
	}

}
