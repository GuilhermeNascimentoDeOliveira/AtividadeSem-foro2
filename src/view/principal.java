package view;

import java.util.concurrent.Semaphore;

import controller.ativi2;

public class principal {

	public static void main(String[] args) {
		Semaphore semaforo =  new Semaphore(1);
		
		for(int threadId = 1; threadId < 6; threadId++) {
			Thread threadC = new ativi2(threadId, semaforo);
			threadC.start();
			
			
		}
		
	}

}