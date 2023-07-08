package com.deliveroo.assignment;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.deliveroo.assignment.ParseHandlers.*;

public class CronField {
    private String text;
    private CronFieldType type;
    private Set<Integer> values = new TreeSet<>();

    public CronField(String text, CronFieldType type) throws InvalidCronFieldException {
        this.type = type;
        this.text = text;
        
        
        if (this.text.split(",").length > 1) {
        	values = new FixedValueHandler().parseField(this.text, this.type);
        } else if (this.text.split("-").length == 2) {
        	values = new RangeHandler().parseField(this.text, this.type);
        } else if (this.text.startsWith("*")) {
        	values = new IntervalHandler().parseField(this.text, this.type);
        }
        

        if (values.isEmpty()) {
            values.add(ParseHandlerInterface.parseNumber(this.text, this.type));
        }
    }

    public Set<Integer> getValues() {
        return values;
    }

    public String toString() {
        return values.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
