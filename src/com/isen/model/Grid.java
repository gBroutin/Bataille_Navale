package com.isen.model;

import java.util.ArrayList;

public class Grid {

	public int GRIDSIZE = 20;
	Case[][] grid;

	boolean win=false;

	boolean modificated = false;
	public String userMessage = "";
	public boolean[][] hiddenGrid = new boolean[GRIDSIZE][GRIDSIZE];

	public ArrayList<String> hiddenGridToDisplay;

	// boolean[][] grid = new boolean[GRIDSIZE][GRIDSIZE];

	public ArrayList<Ship> ShipList = new ArrayList<>();

	public boolean[][] getHiddenGrid() {
		return hiddenGrid;
	}

	public int getNumberOfCase(){
		return this.hiddenGridToDisplay.size();
	}

	public void getTheList() {
		System.out.println(hiddenGridToDisplay.size());
		for (int i = 0; i < hiddenGridToDisplay.size(); i++) {

			if (i % 20 == 0) {
				System.out.println();
			}
			System.out.print(hiddenGridToDisplay.get(i));
		}
	}

	public ArrayList<String> getList() {
		return hiddenGridToDisplay;
	}

	public Grid() {
		// TODO Auto-generated constructor stub
		this.grid = new Case[GRIDSIZE][GRIDSIZE];
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {
				this.grid[i][j] = new Case();
				this.hiddenGrid[i][j] = false;
			}
		}
	}

	public void getAttacked(int x, int y) {
		modificated = false;
		if (this.grid[x][y].isHitted()) {
			System.out.println("deja touché!!");
			userMessage="deja touché!!";
		} else {
			Ship s = this.grid[x][y].attacked();
			if (s == null) {
				System.out.println("Dans l'eau!!");
				userMessage="Dans l'eau!!";
			} else {
				if (s.isSank()) {
					System.out.println("Coulé!!");
					userMessage="Coulé!!";
				} else {
					System.out.println("touché!!");
					userMessage="touché!!";

				}
				modificated = true;
			}
		}
		hiddenGrid[x][y] = true;
	}

	public boolean setShip(Ship ship) {

		ShipList.add(ship);

		int posX = ship.posX;
		int posY = ship.posY;

		int direction = ship.direction;

		if (ship.direction == 1) {
			for (int i = 0; i < ship.length; i++) {
				if (this.grid[posX - i][posY].isEmpty() != true) {
					return false;
				}
			}
			for (int i = 0; i < ship.length; i++) {
				this.grid[posX - i][posY] = new Case(ship);
			}

		}
		if (ship.direction == 2) {
			for (int i = 0; i < ship.length; i++) {
				if (this.grid[posX][posY + i].isEmpty() != true) {
					return false;
				}
			}
			for (int i = 0; i < ship.length; i++) {
				this.grid[posX][posY + i] = new Case(ship);
			}
		}
		if (ship.direction == 3) {
			for (int i = 0; i < ship.length; i++) {
				if (this.grid[posX + i][posY].isEmpty() != true) {
					return false;
				}
			}
			for (int i = 0; i < ship.length; i++) {
				this.grid[posX + i][posY] = new Case(ship);
			}
		}
		if (ship.direction == 4) {
			for (int i = 0; i < ship.length; i++) {
				if (this.grid[posX][posY - 1].isEmpty() != true) {
					return false;
				}
			}
			for (int i = 0; i < ship.length; i++) {
				this.grid[posX][posY - 1] = new Case(ship);
			}
		}
		return true;
	}

	public void fillHiddenGrid() {
		hiddenGridToDisplay = new ArrayList<>();
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {

				if (this.hiddenGrid[i][j] == false) {
					hiddenGridToDisplay.add("-");
					// System.out.print("-");
				} else if (this.hiddenGrid[i][j] == true) {

					if (this.grid[i][j].isEmpty() == false) {
						hiddenGridToDisplay.add("X");
						// System.out.print("X");
					} else if (this.grid[i][j].isEmpty() == true) {
						hiddenGridToDisplay.add("~");
						// System.out.print("~");
					}

				}

			}
			// System.out.println();
		}
	}

	public void displayHiddenGrid() {
		// hiddenGridToDisplay= new ArrayList<>();
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {

				if (this.hiddenGrid[i][j] == false) {
					// hiddenGridToDisplay.add("-");
					System.out.print("-");
				} else if (this.hiddenGrid[i][j] == true) {

					if (this.grid[i][j].isEmpty() == false) {
						// hiddenGridToDisplay.add("X");
						System.out.print("X");
					} else if (this.grid[i][j].isEmpty() == true) {
						// hiddenGridToDisplay.add("~");
						System.out.print("~");
					}

				}

			}
			System.out.println();
		}
	}

	public boolean getModification() {
		return modificated;
	}

	public int getGridSize() {
		return GRIDSIZE;
	}

	public void displayGrid() {
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {

				if (this.grid[i][j].isEmpty() == false) {
					System.out.print("X");
				} else if (this.grid[i][j].isEmpty() == true) {
					System.out.print("~");
				}
			}
			System.out.println();
		}
	}

}
