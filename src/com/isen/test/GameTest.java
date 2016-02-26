package com.isen.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.isen.model.Grid;
import com.isen.model.Ship;

import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
	private Grid grid;

	@Before
	public void doBefore() {
		grid = new Grid();
		Ship shipP1 = new Ship(3, 5, 5, 3);// (longueur,coorX,coorY,direction)
		Ship shipP2 = new Ship(5, 7, 7, 1);
		Ship shipP3 = new Ship(6, 9, 8, 2);

		grid.setShip(shipP3);
		grid.setShip(shipP1);
		grid.setShip(shipP2);
	}

	@Test
	public void test_initialisation_grille() {
		grid.fillHiddenGrid();
		for (int i = 0; i < grid.hiddenGridToDisplay.size(); i++) {
			assertThat(grid.hiddenGridToDisplay.get(i)).isEqualTo("-");
		}

	}

	@Test
	public void test_rater() {
		grid.getAttacked(1, 1);
		int res = 1 * 20 + 1;// res=X*20+Y
		grid.fillHiddenGrid();

		assertThat(grid.hiddenGridToDisplay.get(res)).isEqualTo("~");
		assertThat(grid.userMessage).isEqualTo("Dans l'eau!!");
	}

	@Test
	public void test_toucher() {
		grid.getAttacked(5, 5);
		int res = 5 * 20 + 5;// res=X*20+Y
		grid.fillHiddenGrid();

		assertThat(grid.hiddenGridToDisplay.get(res)).isEqualTo("X");
		assertThat(grid.userMessage).isEqualTo("touché!!");
	}

	@Test
	public void test_couler() {
		grid.getAttacked(5, 5);
		grid.getAttacked(6, 5);
		grid.getAttacked(7, 5);
		grid.fillHiddenGrid();
		assertThat(grid.hiddenGridToDisplay.get(5 * 20 + 5)).isEqualTo("X");
		assertThat(grid.hiddenGridToDisplay.get(6 * 20 + 5)).isEqualTo("X");
		assertThat(grid.hiddenGridToDisplay.get(7 * 20 + 5)).isEqualTo("X");
		assertThat(grid.userMessage).isEqualTo("Coulé!!");
	}


}
