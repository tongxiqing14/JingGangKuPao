package transitServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by TOSHIBA on 2014/10/26.
 */
public class Hero2HeroAction extends HttpServlet {
    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=gb2312");
        resp.sendRedirect(req.getContextPath()+"/hero.jsp?selectIndex="+req.getParameter("selectIndex"));

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
