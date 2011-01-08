<%@ page import="java.sql.*" %>

<%

	Connection conn = null;
	
    try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection("jdbc:mysql://localhost/phunhuannew",
        "root", "123456");
		String s_stt=request.getParameter("stt");	
		int stt=Integer.parseInt(s_stt);
		String s_mcalID=request.getParameter("mcalId");
		String sql="Update meetingcalendar set stt="+stt+" where mcalId="+s_mcalID;
		Statement stmt = conn.createStatement() ;
		stmt.executeUpdate(sql ) ;
		stmt.close();
		conn.close();			
		
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    } 


%>