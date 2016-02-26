<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Contenst-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="TableauLayout.css" type="text/css">
<title>BattleShip Game</title>
</head>
<body>
	<%@ page import="com.isen.model.*"%>

	<div class="tableaux">
		<!-- Grille que le joueur doit attaquer -->
		<!-- --------------------------------------------------------------------------------------------------- -->
		<%
			Grid newGrid = (Grid) session.getAttribute("gridplayer");
			System.out.println("Etat de l'objet 1: " + newGrid);
		%>

		<%
			// 		}
		%>
		<TABLE BORDER="0">
			<CAPTION>Grille à attaquer</CAPTION>
			<TH></TH>
			<%
				int cpt = 0;
				int tmp = 0;
				if (newGrid != null) {
			%>
			<%
				// 			int coox = Integer.parseInt(request.getParameter("X"));
					// 			int cooy = Integer.parseInt(request.getParameter("Y"));
					for (int i = 0; i < 20; i++) {
			%>
			<td width="25"><%=i%></td>

			<%
				}
					// 				newGrid.fillHiddenGrid();
					// 				for (int i = 0; i < newGrid.hiddenGridToDisplay.size(); i++) {
			%>


			<%-- 		<p><%=newGrid.hiddenGridToDisplay.get(i)%></p> --%>

			<%
				// 			}
			%>
			<%
				newGrid.fillHiddenGrid();
					// 				System.out.println(newGrid.hiddenGridToDisplay);
					int numeroLigne = 0;
					do {
			%>
			<tr>
				<td width="25"><%=numeroLigne%></td>
				<%
					numeroLigne++;
				%>
				<td width="25"><%=newGrid.hiddenGridToDisplay.get(cpt)%></td>
				<%
					for (int i = cpt + 1; i < newGrid.hiddenGridToDisplay.size(); i++) {

								if (i % 20 == 0 && i != 0) {
									break;
								} else {
								}
								String p = newGrid.hiddenGridToDisplay.get(i);
				%>

				<td width="25"><%=p%></td>


				<%
					}
							cpt = cpt + 20;
							System.out.println(cpt);
				%>
			</tr>
			<%
				} while (cpt < 400);
					System.out.println(newGrid.hiddenGridToDisplay);
			%>
			<%

			%>
			<%
				}
			%>


		</TABLE>

		<!-- --------------------------------------------------------------------------------------------------- -->
		<p>${modif }X:${X }Y:${Y }</p>
		<p>${shipmessage }</p>
		<p>${gridmessage }</p>
		<div align="left" style="margin-top: 50px;">
			<form action="ThrowMisilServlet">
				X: <input type="text" name="X"> Y: <input type="text"
					name="Y"> <br> <br> <input type="submit"
					value="Lancer le missile">
			</form>

		</div>
		<p>Vous avez joué aux coordonnées X:${X } Y:${Y }</p>
	</div>













	<div class="tableaux">
		<!-- Grille que le joueur doit attaquer -->
		<!-- --------------------------------------------------------------------------------------------------- -->
		<%
			Grid newGrid1 = (Grid) session.getAttribute("gridcomputer");
			System.out.println("Etat de l'objet 2: " + newGrid);
		%>

		<%
			// 		}
		%>
		<TABLE BORDER="0">
			<CAPTION>Grille avec vos bateaux</CAPTION>
			<TH></TH>
			<%
				int cpt1 = 0;
				int tmp1 = 0;
				if (newGrid1 != null) {
			%>
			<%
				// 			int coox = Integer.parseInt(request.getParameter("X"));
					// 			int cooy = Integer.parseInt(request.getParameter("Y"));
					for (int i = 0; i < 20; i++) {
			%>
			<td width="25"><%=i%></td>

			<%
				}
					// 				newGrid.fillHiddenGrid();
					// 				for (int i = 0; i < newGrid.hiddenGridToDisplay.size(); i++) {
			%>


			<%-- 		<p><%=newGrid.hiddenGridToDisplay.get(i)%></p> --%>

			<%
				// 			}
			%>
			<%
				newGrid1.fillHiddenGrid();
					// 				System.out.println(newGrid.hiddenGridToDisplay);
					int numeroLigne = 0;
					do {
			%>
			<tr>
				<td width="25"><%=numeroLigne%></td>
				<%
					numeroLigne++;
				%>
				<td width="25"><%=newGrid1.hiddenGridToDisplay.get(cpt1)%></td>
				<%
					for (int i = cpt1 + 1; i < newGrid1.hiddenGridToDisplay.size(); i++) {

								if (i % 20 == 0 && i != 0) {
									break;
								} else {
								}
								String p = newGrid1.hiddenGridToDisplay.get(i);
				%>

				<td width="25"><%=p%></td>


				<%
					}
							cpt1 = cpt1 + 20;
							System.out.println(cpt1);
				%>
			</tr>
			<%
				} while (cpt1 < 400);
					System.out.println(newGrid1.hiddenGridToDisplay);
			%>
			<%

			%>
			<%
				}
			%>


		</TABLE>

		<!-- --------------------------------------------------------------------------------------------------- -->
		<p>${modif1 }X:${X1 }Y:${Y1 }</p>
		<p>${shipmessage1 }</p>
		<p>${gridmessage1 }</p>
	</div>


<div>
<p>Information sur les signes:</p>
<p> - => case inconnue</p>
<p> ~ => case vide</p>
<p> X => case dans la laquelle un bateau est touché</p>
</div>





</body>

</html>