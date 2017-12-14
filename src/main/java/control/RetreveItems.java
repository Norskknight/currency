package control;

import entity.ItemsItem;
import org.apache.log4j.Logger;
import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(
        urlPatterns = {"/retreveItems"}
)
public class RetreveItems extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDao();
        //String user = request.getRemoteUser();
       //long userId = userDao.getUserId(user);
        List<ItemsItem> res = userDao.getUserItems(1);
        PrintWriter out = response.getWriter();

        out.println("<table>");
        out.println("<tr><th>Name</th><th>Price</th></tr>");
        for (ItemsItem item:res) {
            out.println("<tr>");
            out.println("<td>");
            out.println(item.getTypeLine());
            out.println("</td>");
            out.println("<td>");
            out.println(item.getNote());
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
