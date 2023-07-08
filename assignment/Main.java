package com.deliveroo.assignment;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Invalid number of arguments! Please provide a valid cron expression");
            return;
        }

        try {
            CronParser cpr = new CronParser(args[0]);
            System.out.println(cpr);

        } catch (InvalidCronFieldException invalidCronExpression) {
            System.err.println(invalidCronExpression.getMessage());
        }
	}

}
