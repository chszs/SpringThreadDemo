package com.chszs.thread;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
public class PrintThread extends Thread{
	@Override
	public void run(){
		System.out.println(getName() + " is running.");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(getName() + " is running again.");
	}
}
