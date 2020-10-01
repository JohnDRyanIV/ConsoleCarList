package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListItemHelper dao = new ListItemHelper();
		String act = request.getParameter("doThisToCar");
		// redirect to viewAllItems servlet after changes, unless they add or edit a car
		String path = "/viewAllCarsServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListItem carToDelete = dao.searchForItemById(tempId);
				dao.deleteItem(carToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a car");
			}
		}
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListItem carToEdit = dao.searchForItemById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/edit-car.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a car");
			}
		}
		else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
