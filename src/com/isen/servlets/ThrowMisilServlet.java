package com.isen.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isen.model.Grid;
import com.isen.model.Ship;


public class ThrowMisilServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		///////////////////////////////////////////////////////////////////////////////
		Grid gridplayer = getGrid(request);
		Grid gridcomputer = getComputerGrid(request);

		request.getParameter("XShip");

		Ship shipP1 = new Ship(3, 0, 0, 3);
		Ship shipP2 = new Ship(5, 7, 7, 1);
		Ship shipP3 = new Ship(6, 9, 8, 2);


		//plaçage des bateaux sur les deux grilles

		gridplayer.setShip(shipP3);
		gridplayer.setShip(shipP1);
		gridplayer.setShip(shipP2);

		gridcomputer.setShip(shipP1);
		gridcomputer.setShip(shipP2);
		gridcomputer.setShip(shipP3);
		///////////////////////////////////////////////////////////////////////////////
		if (request.getParameter("X") != null && request.getParameter("Y") != null) {
			try {
				if (request.getParameter("X") != "" && request.getParameter("Y") != "") {
					try {
						gridplayer.getAttacked(Integer.parseInt(request.getParameter("X")),
								Integer.parseInt(request.getParameter("Y")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String modif = valueOf(gridplayer.getModification());

			request.getSession().setAttribute("gridplayer", gridplayer);

			for (int i = 0; i < gridplayer.ShipList.size(); i++) {
				if (gridplayer.ShipList.get(i).userMessage != null) {
					request.setAttribute("shipmessage", gridplayer.ShipList.get(i).userMessage);
				}
			}
			request.setAttribute("gridmessage", gridplayer.userMessage);

			String cooX = request.getParameter("X");
			request.setAttribute("X", cooX);
			String cooY = request.getParameter("Y");
			request.setAttribute("Y", cooY);
			System.out.println(cooX + " " + cooY);
		}

		///////////////////////////////////////////////////////////////////////////////
		if (request.getParameter("X") != null) {
			Random rand = new Random();

			int X = (rand.nextInt(20));
			int Y = (rand.nextInt(20));
			request.setAttribute("X1", X);
			request.setAttribute("Y1", Y);
			request.getSession().setAttribute("gridcomputer", gridcomputer);
			gridcomputer.getAttacked(X, Y);

			request.getSession().setAttribute("gridcomputer", gridcomputer);
			for (int i = 0; i < gridcomputer.ShipList.size(); i++) {
				if (gridcomputer.ShipList.get(i).userMessage != null) {
					request.setAttribute("shipmessage1", gridcomputer.ShipList.get(i).userMessage);
				}
			}
			request.setAttribute("gridmessage1", gridcomputer.userMessage);
		}
		///////////////////////////////////////////////////////////////////////////////
		request.getRequestDispatcher("/AffichageGrille.jsp").forward(request, response);

	}

	public static String valueOf(Object obj) {
		return (obj == null) ? "null" : obj.toString();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
	}

	private Grid getGrid(HttpServletRequest req) {
		Object grid = req.getSession().getAttribute("grid");
		if (grid == null) {
			grid = new Grid();
			req.getSession().setAttribute("grid", grid);
		}
		return (Grid) grid;

	}

	private Grid getComputerGrid(HttpServletRequest req) {
		Object gridComputer = req.getSession().getAttribute("gridComputer");
		if (gridComputer == null) {
			gridComputer = new Grid();
			req.getSession().setAttribute("gridComputer", gridComputer);
		}
		return (Grid) gridComputer;
	}
}