<%@page session="true"%>
<html>
<body bgcolor="salmon">
<center>
<%
out.print(request.getSession().getId());

boolean killSession = false;
if(request.getParameter("killsession")!=null){
	killSession = true;
	
}

%>
<h1>Tomcat / JBOSS 1</h1>

<p>
Select your Apache server: <br />
<a href="<%= response.encodeURL("http://cwd0059:8080/index.jsp")%>">Apache 1</a><br />
<a href="<%= response.encodeURL("http://cwd0059:8088/index.jsp")%>">Apache 2</a><br />
Select the jk-status info:
<a href="http://cwd0059:8080/jkstat/">Status of Connector on Apache 1</a><br />
<a href="http://cwd0059:8088/jkstat/">Status of Connector on Apache 2</a><br />

</p>

<%if(!killSession){%>


<p>
My object in session is:<%= session.getAttribute("testObject")%>
Setting my object in session to: "Value from Server 1".<br />
<%
if(session.getAttribute("testObject")==null){
	session.setAttribute("testObject",new String("Value from Server 1"));
}
%>
Click on the other Apache server to see if the object is still there.
</p>

<form method="post">

<input type="submit" value="kill session" class="button" name="killsession"/>

</form>
<%}else{%>

<h2> session killed. <a href="/index.jsp">click here to request another page</a> </h2>

<%session.invalidate();%>

<%}%>
</center>
</body>
</html>