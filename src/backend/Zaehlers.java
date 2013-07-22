package backend;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPBinding;

import com.owlike.genson.Genson;

/**
 * Servlet implementation class PersonContainer
 */
@WebServlet("/zaehlers")
public class Zaehlers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Zaehlers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idAsString = request.getParameter("id");

		if (idAsString == null) {
			Collection<Zaehler> allStaende = ZaehlerContainer.getInstance()
					.values();
			
			
			for (Zaehler w : allStaende) {
				response.getWriter().println(w.toString());
			}
		} else {
			try {
				long id = Long.parseLong(idAsString);
				Zaehler w = ZaehlerContainer.getInstance().load(id);

				if( w != null )
				{
					response.getWriter().println(w.toString());
				}
				else
				{
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			} catch (Exception e) {
				// ignore
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String zaehlerStand = request.getParameter("zaehlerStand");
		String zaehlerart = request.getParameter("zaehlerart");
		String url = request.getRequestURL().toString();

		Zaehler w = new Zaehler(date, zaehlerStand, zaehlerart);
		long newId = ZaehlerContainer.getInstance().save(w);

		response.setStatus(HttpServletResponse.SC_CREATED);
		response.setHeader("Location", url + "?id=" + newId);
	}

}
