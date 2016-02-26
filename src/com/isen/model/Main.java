package com.isen.model;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Trame trame=new Trame();
//		trame.runTrame();
		Grid grid=new Grid();
		Ship shipP1 = new Ship(3, 5, 5, 3);//(longueur,coorX,coorY,direction)
		Ship shipP2 = new Ship(5, 7, 7, 1);
		Ship shipP3 = new Ship(6, 9, 8, 2);

		grid.setShip(shipP3);
		grid.setShip(shipP1);
		grid.setShip(shipP2);

		grid.getAttacked(5, 5);
		grid.getAttacked(6, 5);
		grid.getAttacked(7, 5);
		grid.fillHiddenGrid();
		for(int i=0;i<grid.hiddenGridToDisplay.size();i++){
			if(grid.hiddenGridToDisplay.get(i)=="X"){
				System.err.println(i);
			}
//			System.err.println(grid.hiddenGridToDisplay.get(i));
		}

	}

}
