package transitServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-16
 * Time: ÏÂÎç7:26
 * To change this template use File | Settings | File Templates.
 */
public class Backpack2BackpackAction extends HttpServlet {
    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();

        System.out.println(servletPath);

        StringBuffer requestURL = req.getRequestURL();
        String host = requestURL.substring(0,requestURL.lastIndexOf(servletPath));

        req.getContextPath();

        System.out.println(req.getContextPath());

        String selectIndex_x = req.getParameter("selectIndex_x");
        String selectIndex_y = req.getParameter("selectIndex_y");

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("backpack_selectIndex_x",selectIndex_x);
        httpSession.setAttribute("backpack_selectIndex_y",selectIndex_y);

//        PrintWriter out = resp.getWriter();

//        req.setAttribute("messages",aaa);
//        ServletContext.getRequestDispatcher("smserror.jsp").forward(request,response);

//        RequestDispatcher requestDispatcher=req.getRequestDispatcher("../backpackscreen.jsp?preScreen=mainscreen");
//        requestDispatcher.forward(req,resp);
        resp.setContentType("text/html; charset=gb2312");
        resp.sendRedirect(req.getContextPath()+"/backpackscreen.jsp?preScreen=mainscreen");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String selectIndex_x = req.getParameter("selectIndex_x");
//        String selectIndex_y = req.getParameter("selectIndex_y");
//
//        HttpSession httpSession = req.getSession();
//        httpSession.setAttribute("backpack_selectIndex_x",selectIndex_x);
//        httpSession.setAttribute("backpack_selectIndex_y",selectIndex_y);
//
////        PrintWriter out = resp.getWriter();
//
////        req.setAttribute("messages",aaa);
////        ServletContext.getRequestDispatcher("smserror.jsp").forward(request,response);
//
//        RequestDispatcher requestDispatcher=req.getRequestDispatcher("backpackscreen.jsp");
//        requestDispatcher.forward(req,resp);
//
////        out.println("[{id:0,name:''}]");
////        out.close();
    }
}
