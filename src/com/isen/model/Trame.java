package com.isen.model;

import java.util.Scanner;

public class Trame {

	public Trame() {
		// TODO Auto-generated constructor stub
	}

	public void runTrame() {

		Scanner sc=new Scanner(System.in);

		Grid gridplayer = new Grid();
//		Grid gridcomputer=new Grid();



		Ship shipP1 = new Ship(3, 5, 5, 3);
		Ship shipP2 = new Ship(5, 7, 7, 1);
		Ship shipP3 = new Ship(6, 9, 8, 2);


		gridplayer.setShip(shipP3);
		gridplayer.setShip(shipP1);
		gridplayer.setShip(shipP2);
//
//		Ship shipC1 = new Ship(3, 4, 4, 3);
//		Ship shipC2 = new Ship(5, 8, 8, 1);
//		Ship shipC3 = new Ship(6, 10, 7, 2);
//
//
//		gridcomputer.setShip(shipC3);
//		gridcomputer.setShip(shipC1);
//		gridcomputer.setShip(shipC2);

		// gridcomputer.setShipRandomly(ship1);
		// gridcomputer.setShipRandomly(ship2);
		// gridcomputer.setShipRandomly(ship3);
		gridplayer.displayGrid();
		System.out.println();
//		gridcomputer.displayGrid();
		System.out.println();
		System.out.println();
		gridplayer.displayHiddenGrid();

		while(true){
		System.out.print("Entrer coordonnées :");
		int coorY=sc.nextInt();
		int coorX=sc.nextInt();


		gridplayer.getAttacked(coorX, coorY);
		gridplayer.displayHiddenGrid();
		}

	}
}
