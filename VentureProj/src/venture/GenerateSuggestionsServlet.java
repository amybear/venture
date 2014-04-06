package venture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateSuggestionsServlet
 */
@WebServlet("/GenerateSuggestionsServlet")
public class GenerateSuggestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateSuggestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		double lat = Double.parseDouble((String)request.getParameter("latitude"));
		double lng = Double.parseDouble((String)request.getParameter("longitude"));
		
		double boxSize = 1.0;
		
		request.setAttribute("modeOfTransit", "driving");
		if (request.getParameter("transport") != null) {
			boolean isWalk = request.getParameter("transport").equals("walking");
			boolean isBike = request.getParameter("transport").equals("bicycling");
			boolean isDrive = request.getParameter("transport").equals("driving");
			boolean isBus = request.getParameter("transport").equals("transit");
			
			if (isWalk) {
				boxSize = 0.01;
				request.setAttribute("modeOfTransit", "walking");
			} else if (isBike) {
				boxSize = 0.05;
				request.setAttribute("modeOfTransit", "bicycling");
			} else if (isDrive) {
				boxSize = 0.5;
				request.setAttribute("modeOfTransit", "driving");
			} else if (isBus) {
				boxSize = 0.5;
				request.setAttribute("modeOfTransit", "transit");
			} 
		} 
		System.out.println(boxSize);
		
		boolean isParks = (request.getParameter("parks") == null || request.getParameter("parks").equals("YES"));
		boolean isBars = (request.getParameter("bars") == null || request.getParameter("bars").equals("YES"));
		boolean isFood = (request.getParameter("food") == null || request.getParameter("food").equals("YES"));
		boolean isMovies = (request.getParameter("movies") == null || request.getParameter("movies").equals("YES"));
		boolean isShopping = (request.getParameter("shopping") == null || request.getParameter("shopping").equals("YES"));
		boolean isOther = (request.getParameter("other") == null || request.getParameter("other").equals("YES"));
		
		request.setAttribute("isParks", isParks ? "YES" : "NO");
		request.setAttribute("isFood", isFood ? "YES" : "NO");
		request.setAttribute("isMovies", isMovies ? "YES" : "NO");
		request.setAttribute("isShopping", isShopping ? "YES" : "NO");
		request.setAttribute("isOther", isOther ? "YES" : "NO");
		request.setAttribute("isBars", isBars ? "YES" : "NO");
		
		//DO ALL OF THE THINGS
		DAL dal = (DAL)getServletContext().getAttribute("DAL");
		System.out.println(isParks + " " + isFood + " " + isMovies + " " + isShopping + " " + isOther);
		ArrayList<Activity> activities = dal.getSuggestions(lat, lng, boxSize, isParks, isBars, isFood, isMovies, isShopping, isOther);
		request.setAttribute("latitude", request.getParameter("latitude"));
		request.setAttribute("longitude", request.getParameter("longitude"));
		
		if (activities.isEmpty()) {
			RequestDispatcher dispatch = request.getRequestDispatcher("noSuggestions.jsp");
			dispatch.forward(request, response);
			return;
		}
		
		Random generator = new Random();
		int randomInt = generator.nextInt(activities.size());
		
		request.setAttribute("activity", activities.get(randomInt));
		RequestDispatcher dispatch = request.getRequestDispatcher("suggestions.jsp");
		dispatch.forward(request,response);
	}

}
