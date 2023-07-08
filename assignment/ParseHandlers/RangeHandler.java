package com.deliveroo.assignment.ParseHandlers;

import java.util.Set;
import java.util.TreeSet;

import com.deliveroo.assignment.CronFieldType;
import com.deliveroo.assignment.InvalidCronFieldException;

public class RangeHandler implements ParseHandlerInterface {

	public Set<Integer> parseField(String text, CronFieldType type) throws InvalidCronFieldException {
		Set<Integer> values = new TreeSet<>();
        String[] range = text.split("-");
        if (range.length == 2) {
            int start = ParseHandlerInterface.parseNumber(range[0], type);
            int end = ParseHandlerInterface.parseNumber(range[1], type);
            values.addAll(ParseHandlerInterface.populateValues(text, start, end, 1, type));
        }
        return values;
	}
}
