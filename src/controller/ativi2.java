package controller;


import java.util.concurrent.Semaphore;

public class ativi2 extends Thread{
	private int threadId;
	String Prato;
	private Semaphore semaforo;
	
	public ativi2(int threadId, Semaphore semaforo) {
		this.threadId = threadId;
		this.semaforo = semaforo;
	}
	
	public void run() {
		Cozimento();
		Entrega();
	}

	private void Entrega() {
		
		if (threadId % 2 == 0) {
			Prato = "Lasanha a bolonhesa";	
		}
		else {
			Prato = "Sopa de cebola";
		}
		
		try {
			semaforo.acquire();
			System.out.println(Prato +" está sendo entregue.");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}finally {
			semaforo.release();
		}
		System.out.println(Prato +" foi entregue.");
	}
	
	private void Cozimento() {
		int temp = 0;
		int cont = 0;
		
		if (threadId % 2 == 0) {
			Prato = "Lasanha a bolonhesa";
			System.out.println("Começa o cozimento de uma Lasanha a bolonhesa.");
			temp = (int) ((int) ((Math.random() * 601) + 600));
		}
		else {
			Prato = "Sopa de cebola"; 
			System.out.println("Começa o cozimento de uma Sopa de cebola.");
			temp = (int) ((int) ((Math.random() * 301) + 500));
		}
		
		
		
		while (cont < temp) {
			try {
				if (cont + 100 <= temp)
					cont += 100;
				else {
					cont += temp - cont;
				}
				System.out.println("Cozinheiro " +threadId + " - " + Prato + " " + (cont * 100) / temp + "%");
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Prato+" está pronto para entrega.");
		}
	}
}