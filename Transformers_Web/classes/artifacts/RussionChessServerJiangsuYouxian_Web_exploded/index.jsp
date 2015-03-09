<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%
    String servletPath = request.getServletPath();
    StringBuffer requestURL = request.getRequestURL();
    String host = requestURL.substring(0,requestURL.lastIndexOf(servletPath));

    String ServerURL = application.getInitParameter("ServerURL");
    String UserID = request.getParameter("Account");
    String UserPassword = "1";
    String adAccount = request.getParameter("adAccount");
    String NickName = "1";
    String IconAddr = "1";
    String ProductID = request.getParameter("GameID");
    String ReturnURL = request.getParameter("ReturnURL");
    String UserToken = request.getParameter("UserToken");
    String IsAutoTopUp = application.getInitParameter("IsAutoTopUp");
    String IsButtonOnOK = application.getInitParameter("IsButtonOnOK");
    String IsActiveOnOK = application.getInitParameter("IsActiveOnOK");
    String ImageURL = application.getInitParameter("ImageURL");


    if(UserID==null||UserID.equals("")){
        //response.sendRedirect(ReturnURL);
        UserID = (String)session.getAttribute("UserID");
        UserPassword = (String)session.getAttribute("UserPassword");
        adAccount = (String)session.getAttribute("adAccount");
        NickName = (String)session.getAttribute("NickName");
        IconAddr = (String)session.getAttribute("IconAddr");
        ProductID = (String)session.getAttribute("ProductID");
        ReturnURL = (String)session.getAttribute("ReturnURL");
        UserToken = (String)session.getAttribute("UserToken");
    }else{
        session.setAttribute("UserID",UserID);
        session.setAttribute("UserPassword",UserPassword);
        session.setAttribute("adAccount",adAccount);
        session.setAttribute("NickName",NickName);
        session.setAttribute("IconAddr",IconAddr);
        session.setAttribute("ProductID",ProductID);
        session.setAttribute("ReturnURL",ReturnURL);
        session.setAttribute("UserToken",UserToken);
    }

%>

<html>
<head>


</head>

<!--script language="javascript">
 	window.document.onkeypress = function(keyEvent) 
	{
		keyEvent = keyEvent ? keyEvent : window.event;
		var keyvalue = keyEvent.which ? keyEvent.which : keyEvent.keyCode;
		
		if( keyvalue == 0x0300 )
		{
			document.write("处理虚拟键值事件");
		}
	}
 	
</script-->

<script language="javascript1.3">
    function PageScroll(evt)
    {
    evt = evt ? evt : window.event;
    var keyCode = evt.which ? evt.which : evt.keyCode;

    if(keyCode != null)  /* 返回 */
    {
    window.location="<%=ReturnURL%>";
    }
    return;
    }
    setTimeout("document.onkeypress = PageScroll",4000);
</script>



<body style="background-color:#000000">



<img id="loading" src="images/loading.png" style="position:absolute; left:0px; top:0px; z-index:1"/>

<div style="position:absolute; left:0px; top:0px; width:640px; height:526px; z-index:1">
    <!--<object id="j2meapp" classid="clsid:72E6F181-D1B0-4C22-B0D7-4A0740EEAEF5" width="640" height="530">-->
    <object id="j2meapp" classid="ipanel:j2me-midp2" width="640" height="530">
        <param name="-Xkeypass" value="true" />
        <param name="bgcolor" value="#000000" />
        <param name="jad" value="CP901002/HouseBroom.jad" />
        <param name="jar" value="CP901002/HouseBroom.jar" />
        <param name="J2MEVersion" value=" MIDP 2.0,CLDC 1.1" />
        <param name="ServerURL" value="<%=ServerURL%>" />
        <param name="Account" value="<%=UserID%>" />
        <param name="ADAccount" value="<%=adAccount%>" />
        <param name="GameID" value="<%=ProductID%>" />
        <param name="UserToken" value="<%=UserToken%>" />
        <param name="IsAutoTopUp" value="<%=IsAutoTopUp%>" />
        <param name="IsButtonOnOK" value="<%=IsButtonOnOK%>" />
        <param name="IsActiveOnOK" value="<%=IsActiveOnOK%>" />
        <%--<param name="ImageURL" value="<%=ImageURL%>" />--%>
        <param name="sessionId" value="<%=session.getId()%>" />
        <param name="web_service_url" value="<%=host%>/HttpService/" />
    </object>
</div>
</body>
</html>
