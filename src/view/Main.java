package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBilheteria;

public class Main {

	public static Semaphore semaforo;

	public static void main(String[] args) {
		int ingressos = 100;
		Semaphore semaforo = new Semaphore(ingressos);
		for (int i = 0; i < 100; i++) {
			Thread t = new ThreadBilheteria(i, semaforo);
			t.start();

		}
	}
}