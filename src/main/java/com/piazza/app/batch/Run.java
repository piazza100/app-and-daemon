package com.piazza.app.batch;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String args[]) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "classpath:/context-batch.xml", "classpath:/context-db.xml" });
		Calendar today = Calendar.getInstance();

		// if (args.length == 0) {
		// usage();
		// ((ConfigurableApplicationContext) ctx).close();
		// return;
		// }

		// if ("RepaymentMonth".equals(args[0])) {
		DailyApp sync = ctx.getBean(DailyApp.class);
		sync.start();

		// } else {
		// usage();
		// }

		((ConfigurableApplicationContext) ctx).close();
	}

	private static void usage() {
		System.out.println("Invalid Argument");
	}
}