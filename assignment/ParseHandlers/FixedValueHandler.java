package com.deliveroo.assignment.ParseHandlers;

import java.util.Set;
import java.util.TreeSet;

import com.deliveroo.assignment.CronFieldType;
import com.deliveroo.assignment.InvalidCronFieldException;

public class FixedValueHandler implements ParseHandlerInterface {

	public Set<Integer> parseField(String text, CronFieldType type) throws InvalidCronFieldException {
		Set<Integer> values = new TreeSet<>();
        String[] fixedDates = text.split(",");
        if (fixedDates.length > 1) {
            for (String date : fixedDates) {
                int e = ParseHandlerInterface.parseNumber(date, type);
                values.addAll(ParseHandlerInterface.populateValues(text, e, e, 1, type));
            }
        }
        return values;
	}
}
