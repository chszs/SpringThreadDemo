package com.chszs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.chszs.thread.PrintTask;

public class App1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/Spring-Config.xml");
		ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor)ctx.getBean("taskExecutor");
		taskExecutor.execute(new PrintTask("Thread 1"));
		taskExecutor.execute(new PrintTask("Thread 2"));
		taskExecutor.execute(new PrintTask("Thread 3"));
		taskExecutor.execute(new PrintTask("Thread 4"));
		taskExecutor.execute(new PrintTask("Thread 5"));
		// 检查活动的线程，如果活动线程数为0则关闭线程池
		for(;;){
			int count = taskExecutor.getActiveCount();
			System.out.println("Active Threads : " + count);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(count==0){
				taskExecutor.shutdown();
				break;
			}
		}
	}

}
