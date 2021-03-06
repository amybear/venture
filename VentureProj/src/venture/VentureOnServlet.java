package venture;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VentureOnServlet
 */
@WebServlet("/VentureOnServlet")
public class VentureOnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentureOnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher("ventureon.jsp");
		dispatch.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Rank this as a success
		
		DAL dal = (DAL)getServletContext().getAttribute("DAL");
		
		if (request.getParameter("acceptedid") != null) {
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				dal.setUserRating(user, Integer.parseInt(request.getParameter("acceptedid")), 1);
			}
		}
		
		// Write the response clean
		
		RequestDispatcher dispatch = request.getRequestDispatcher("ventureon.jsp");
		dispatch.forward(request,response);
	}

}
