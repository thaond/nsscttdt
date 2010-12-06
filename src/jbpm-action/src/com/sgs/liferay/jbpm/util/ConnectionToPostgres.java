package com.sgs.liferay.jbpm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sgs.liferay.jbpm.component.StrutsTaskAction;
import com.sgs.liferay.jbpm.component.TaskAction;

public class ConnectionToPostgres {

	private static Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/lportal", "postgres", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static StrutsTaskAction getStrutsTaskAction(String nameTask, long taskId){
		StrutsTaskAction strutsTaskAction = new StrutsTaskAction();
		Connection con = ConnectionToPostgres.createConnection();
		String query = "SELECT n.transition, n.view_task, n.action_task  FROM pml_wf_thong_tin_node as n WHERE n.ten_task = '"+ nameTask + "'";
		Statement st = null;
		ResultSet res = null;
		try {
			 st = con.createStatement();
			 res = st.executeQuery(query);
			 while (res.next()) {
				 
				 strutsTaskAction.setForm(res.getString(2));
				 strutsTaskAction.setTaskActionName(nameTask);
				 strutsTaskAction.setTransition(res.getString(1));
				 
				if (taskId == -1){ 
					if (! TaskAction.NONE_FORM.equals(res.getString(2))) {
						strutsTaskAction.setStrutsAction(res.getString(2));
					}
				 
					else {
						strutsTaskAction.setStrutsAction(res.getString(3));
					}
				}
				
				else {
					strutsTaskAction.setStrutsAction(res.getString(3));
				}
			}
			 res.close();
			 st.close();
			 con.close();
		} catch (Exception e) {
			System.out.println("khong get duoc task");
				try {
					res.close();
					 st.close();
					 con.close();
				} catch (Exception e1) {
				}
			
		}
		
		return strutsTaskAction;
	}
	
	public static String[] getListUser(String nodeNameNext){
		String [] arr = null;
		
		Connection con = ConnectionToPostgres.createConnection();
		String query = "SELECT n.user_id  FROM pml_wf_thong_tin_node as n WHERE n.ten_node = '"+ nodeNameNext + "'";
		Statement st = null;
		ResultSet res = null;
		try {
			 st = con.createStatement();
			 res = st.executeQuery(query);
			 
			 while (res.next()) {
				 arr = res.getString(1).split("_"); 
				
			}
			 res.close();
			 st.close();
			 con.close();
		} catch (Exception e) {
			System.out.println("khong get duoc task");
				try {
					res.close();
					 st.close();
					 con.close();
				} catch (Exception e1) {
				}
			
		}
		return arr;
	}
	
	public static void main(String[] args) {
		String [] arr = ConnectionToPostgres.getListUser("tasknode2");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
