package transitServlet;

import com.fancyy.json.util.JSON;
import elements.EnemyTeam;
import elements.screen.TeamScreenItemObj;
import service.InfoTransition;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-9
 * Time: 下午8:35
 * To change this template use File | Settings | File Templates.
 */
public class GameToGameServlet extends HttpServlet {
    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String enemy_index = req.getParameter("enemy_index");
        String anger_x_array_string = req.getParameter("anger_x_array_string");
        String enemy_hpNumber_array_string = req.getParameter("enemy_hpNumber_array_string");
        String hero_hpNumber_array_string = req.getParameter("hero_hpNumber_array_string");
        String warship_img_array_x = req.getParameter("warship_img_array_x");

        HttpSession httpSession = req.getSession();

        httpSession.setAttribute("anger_x_array_string",anger_x_array_string);
//        System.out.println("enemy_hpNumber_array_string=="+enemy_hpNumber_array_string);
        httpSession.setAttribute("enemy_hpNumber_array_string",enemy_hpNumber_array_string);
        httpSession.setAttribute("hero_hpNumber_array_string",hero_hpNumber_array_string);
        httpSession.setAttribute("warship_img_array_x",warship_img_array_x);

        List<EnemyTeam> enemyTeamList = new ArrayList<EnemyTeam>();

        if(httpSession.getAttribute("enemy_team")!=null){

            String enemy_team = (String) httpSession.getAttribute("enemy_team");

            enemyTeamList = (List<EnemyTeam>) JSON.toObject(enemy_team, EnemyTeam.class);

            if(req.getParameter("enemy_index")!=null){
                String enemy_index = req.getParameter("enemy_index");

                httpSession.setAttribute("enemy_team", InfoTransition.updateEnemyTeam(enemyTeamList, Integer.valueOf(enemy_index)));
            }
        }

        //取得Application对象
        ServletContext application=this.getServletContext();
        String account = null;
        TeamScreenItemObj teamScreenItemObj = null;

        if(httpSession.getAttribute("UserID")!=null){
            account = (String) httpSession.getAttribute("UserID");
            if(application.getAttribute(account+"_TeamScreenItemObj")!=null){
                teamScreenItemObj = (TeamScreenItemObj) JSON.toObject((String) application.getAttribute(account + "_TeamScreenItemObj"), TeamScreenItemObj.class);
            }
        }

        if(req.getParameter("hero_index")!=null){
            String hero_index = req.getParameter("hero_index");
            String type = req.getParameter("type");

            application.setAttribute(account + "_TeamScreenItemObj",InfoTransition.updateHeroTeam(teamScreenItemObj,Integer.valueOf(type),Integer.valueOf(hero_index)));
        }

        PrintWriter out = resp.getWriter();

        out.println("[{id:0,name:''}]");
        out.close();

    }
}
