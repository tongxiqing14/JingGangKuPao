package transitServlet;

import beans.FighterBean;
import elements.screen.TitleItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-4
 * Time: 下午12:02
 * To change this template use File | Settings | File Templates.
 */
public class TeamToTeamServlet extends HttpServlet {

    private int item_index = 0;
    private int selected_item_index = 0;

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String grouptype = null;

        if(req.getParameter("transit")!=null&&req.getParameter("transit").equals("true")) {
            if(req.getParameter("grouptype")!=null){
                grouptype = req.getParameter("grouptype");
                req.getSession().setAttribute("grouptype",req.getParameter("grouptype"));
            }
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/teamscreen.jsp?select_Index="+grouptype);
        }else {
            HttpSession httpSession = req.getSession();

            int tem_item_index = -1;
            int selected_item_sum = 0;
            int already_selected_item_sum = 0;

            if(req.getParameter("grouptype")!=null){
                grouptype = req.getParameter("grouptype");
                req.getSession().setAttribute("grouptype",req.getParameter("grouptype"));
            }

            if(null!=req.getParameter("item_index")){                       /**未选中改为已选中*/
                item_index = Integer.valueOf(req.getParameter("item_index"));
                List<FighterBean> getHeroList = (List<FighterBean>) httpSession.getAttribute("getHeroList");

                for(int i=0; i<getHeroList.size();i++){
                    if(getHeroList.get(i).isSelect_flag()){
                        selected_item_sum ++;
                    }
                }

                if(selected_item_sum < 6){
                    for(int i=0; i<getHeroList.size();i++){
                        if(!getHeroList.get(i).isSelect_flag()&&getHeroList.get(i).getType()==(Integer.valueOf(req.getParameter("grouptype")))){
                            tem_item_index++;                                                /**未选中，且是对应group type*/
                        }

                        if(tem_item_index == item_index){
                            getHeroList.get(i).setSelect_flag(true);

                            for(int j=0; j<getHeroList.size();j++){
                                if(getHeroList.get(j).getType()==getHeroList.get(i).getType()&&getHeroList.get(j).isSelect_flag()){
                                    already_selected_item_sum ++;
                                    if(getHeroList.get(j).getType()==0&&already_selected_item_sum>1){
                                        getHeroList.get(i).setSelect_flag(false);
                                        break;
                                    }else if(getHeroList.get(j).getType()==1&&already_selected_item_sum>2){
                                        getHeroList.get(i).setSelect_flag(false);
                                        break;
                                    }else if(getHeroList.get(j).getType()==2&&already_selected_item_sum>2){
                                        getHeroList.get(i).setSelect_flag(false);
                                        break;
                                    }

                                }
                            }

                            break;
                        }
                    }
                }
            }else if(null!=req.getParameter("selected_item_index")){                /**已选中改为未选中*/
                selected_item_index = Integer.valueOf(req.getParameter("selected_item_index"));
                List<FighterBean> selectHeroList = (List<FighterBean>) httpSession.getAttribute("selectHeroList");

                for(int i=0; i<selectHeroList.size();i++){
                    if(selectHeroList.get(i).isSelect_flag()){
                        tem_item_index++;
                    }
                    if(tem_item_index == selected_item_index){
                        selectHeroList.get(i).setSelect_flag(false);
                        break;
                    }
                }

                List<FighterBean> fighterBeans = (List<FighterBean>) httpSession.getAttribute("_FighterData");
                for(FighterBean heroItem : fighterBeans){
                    if(heroItem.getFighter_id() == selectHeroList.get(selected_item_index).getFighter_id()){
                        heroItem.setSelect_flag(false);
                    }
                }
            }

            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/teamscreen.jsp?select_Index="+grouptype);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        int tem_item_index = -1;
        int selected_item_sum = 0;
        int already_selected_item_sum = 0;

        if(req.getParameter("grouptype")!=null){
            req.getSession().setAttribute("grouptype",req.getParameter("grouptype"));
        }

        if(null!=req.getParameter("item_index")){                       /**未选中改为已选中*/
            item_index = Integer.valueOf(req.getParameter("item_index"));
            List<FighterBean> getHeroList = (List<FighterBean>) httpSession.getAttribute("getHeroList");

            for(int i=0; i<getHeroList.size();i++){
                if(getHeroList.get(i).isSelect_flag()){
                    selected_item_sum ++;
                }
            }

            if(selected_item_sum < 6){
                for(int i=0; i<getHeroList.size();i++){
                    if(!getHeroList.get(i).isSelect_flag()&&getHeroList.get(i).getType()==(Integer.valueOf(req.getParameter("grouptype")))){
                        tem_item_index++;                                                /**未选中，且是对应group type*/
                    }

                    if(tem_item_index == item_index){
                        getHeroList.get(i).setSelect_flag(true);

                        for(int j=0; j<getHeroList.size();j++){
                            if(getHeroList.get(j).getType()==getHeroList.get(i).getType()&&getHeroList.get(j).isSelect_flag()){
                                already_selected_item_sum ++;
                                if(getHeroList.get(j).getType()==0&&already_selected_item_sum>1){
                                    getHeroList.get(i).setSelect_flag(false);
                                    break;
                                }else if(getHeroList.get(j).getType()==1&&already_selected_item_sum>2){
                                    getHeroList.get(i).setSelect_flag(false);
                                    break;
                                }else if(getHeroList.get(j).getType()==2&&already_selected_item_sum>2){
                                    getHeroList.get(i).setSelect_flag(false);
                                    break;
                                }

                            }
                        }

                        break;
                    }
                }
            }
        }else if(null!=req.getParameter("selected_item_index")){                /**已选中改为未选中*/
            selected_item_index = Integer.valueOf(req.getParameter("selected_item_index"));
            List<FighterBean> selectHeroList = (List<FighterBean>) httpSession.getAttribute("selectHeroList");

            for(int i=0; i<selectHeroList.size();i++){
                if(selectHeroList.get(i).isSelect_flag()){
                    tem_item_index++;
                }
                if(tem_item_index == selected_item_index){
                    selectHeroList.get(i).setSelect_flag(false);
                    break;
                }
            }

            List<FighterBean> fighterBeans = (List<FighterBean>) httpSession.getAttribute("_FighterData");
            for(FighterBean heroItem : fighterBeans){
                if(heroItem.getFighter_id() == selectHeroList.get(selected_item_index).getFighter_id()){
                    heroItem.setSelect_flag(false);
                }
            }
        }

        PrintWriter out = resp.getWriter();

        out.println("[{id:0,name:''}]");
        out.close();

    }
}
