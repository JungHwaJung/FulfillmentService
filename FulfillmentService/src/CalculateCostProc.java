

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class CalculateCostProc
 */
@WebServlet("/CalculateCostProc")
public class CalculateCostProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(CalculateCostProc.class);

    public CalculateCostProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CalculateCostDAO cDao = null;
		CalculateCostDTO cDto = null;
		List<CalculateCostDTO> calList = null;
		int id = 0;
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		
		switch(action) {
		case "calculate":
			LOG.trace("calculate 시작");

			//if(!request.getParameter("id").equals("")) {
			//	id = Integer.parseInt(request.getParameter("id"));
			//}
			cDao = new CalculateCostDAO();
			calList = cDao.selectAll();
			//cDto = (CalculateCostDTO) cDao.selectAll();

			
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("admin/monthlySalesHistory.jsp");
			rd.forward(request, response);
			LOG.trace("calculate 성공");
			break;
		}
		
	}
}
