package controller;

import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {
	private int idComprador;
	private static int ingressos = 100;
	private Semaphore semaforo;

	public ThreadBilheteria(int idThread, Semaphore semaforo) {
		//this.idComprador = idComprador;
		this.semaforo = semaforo;
		this.idComprador = (int)(Math.random() * 10 + 10);
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			fazerCompra();
			validarCompra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	public void fazerLogin() {
		System.out.println("Seja bem vindo cliente nº " + idComprador + " realize seu login.");
		int tempoLogin = (int) ((Math.random() * 1950) + 50);
		if (tempoLogin >= 1000) {
			System.out.println("Tempo Esgotado! Seu login expirou.");
		} else {
			try {
				Thread.sleep(tempoLogin);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public void fazerCompra() {
		System.out.println("Seu login foi realizado, boas compras!");
		int tempoCompra = (int) ((Math.random() * 2001) + 1000);
		if (tempoCompra >= 2500) {
			System.out.println("Tempo de compra excedido! Sua compra foi cancelada.");
		} else {
			try {
				Thread.sleep(tempoCompra);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public void validarCompra() {
		int qtdingressos = (int) ((Math.random() * 4) + 1);
		if (qtdingressos < ingressos) {
			ingressos -= qtdingressos;
			System.out.println(
					"Cliente " + idComprador + " comprou " + qtdingressos + " ingressos restantes = " + ingressos);
		} else {
			System.out.println("Os ingressos esgotaram!");
		}
	}

}