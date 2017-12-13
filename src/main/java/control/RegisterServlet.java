package control;

import entity.User;
import org.apache.log4j.Logger;
import persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;



@WebServlet(
        urlPatterns = {"/addUser"}
)
public class RegisterServlet extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = new User(userId, password);
        try {
            UserDao registerUser = new UserDao();
            boolean result = registerUser.register(user);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Successful</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if(result){
                out.println("<h1>Thanks for Registering with us :</h1>");
                out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
            }else{
                out.println("<h1>Registration Failed</h1>");
                out.println("To try again<a href=register.jsp>Click here</a>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
