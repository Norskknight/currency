package control;

import entity.Useritems;
import org.apache.log4j.Logger;
import persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.isNull;

@WebServlet(
        urlPatterns = {"/addItem"}
)
public class UserItem extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String item = req.getParameter("item");
        String user = req.getRemoteUser();

        UserDao userDao = new UserDao();
        long userId = userDao.getUserId(user);
        log.info("user id"+userId);
        log.info("item "+item);
        if (!isNull(item)) {
            Useritems userItem = new Useritems(userId, item);
            log.info(userItem);
            userDao.addUserItem(userItem);
        }

        resp.sendRedirect("account.jsp");
    }

}
