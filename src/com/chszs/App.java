package com.chszs;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chszs.config.AppConfig;
import com.chszs.thread.PrintThread;

public class App {
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PrintThread printThread1 = (PrintThread)ctx.getBean("printThread");
		printThread1.setName("Thread 1");
		
		PrintThread printThread2 = (PrintThread)ctx.getBean("printThread");
		printThread2.setName("Thread 2");
		
		PrintThread printThread3 = (PrintThread)ctx.getBean("printThread");
		printThread3.setName("Thread 3");
		
		PrintThread printThread4 = (PrintThread)ctx.getBean("printThread");
		printThread4.setName("Thread 4");
		
		PrintThread printThread5 = (PrintThread)ctx.getBean("printThread");
		printThread5.setName("Thread 5");
		
		printThread1.start();
		printThread2.start();
		printThread3.start();
		printThread4.start();
		printThread5.start();
	}
}
