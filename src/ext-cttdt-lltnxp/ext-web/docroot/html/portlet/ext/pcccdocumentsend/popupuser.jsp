<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>

<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<table width='100%' height='100%' border='0' cellspacing='1' cellpadding='2' align='center'>
  		<tr height="10">	
  			<td colspan="6">	
  			
  			</td>
  		
  		</tr>
		<tr height='100%'>
		 	<td valign='top' height='180px' id='content' >
				<table id='addrecordtype' cellpadding='2' cellspacing='1' width='100%' style='border:solid 1px #A3B2CC;padding-bottom: 10px' border='0' bgcolor='#E4E4E4'>
					 
					  <tr height='30' align='center' valign='middle' class="bgdocsend-table-footer"'>
						<td width='4%'style="color: white" ><liferay-ui:message key="documentsend.stt"/></td>
						<td width='4%'style="color: white"></td>
						<td width='20%' style="color: white"><liferay-ui:message key="documentcode.screenname"/></td>
						<td style="color: white"><liferay-ui:message key="documentcode.username"/></td>
					  </tr>
					
					  <tr height="10">
					  	<td colspan="4"> </td>
					  </tr>
					  
					  <logic:iterate id="userDTOList" name="userDTOList" indexId="i" type="com.sgs.portlet.pcccdocumentsend.dto.UserDTO" scope="request" >
						  <tr  class="rowTwo" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
						  
							  	<td align="center" style="color:#c00;font-weight:bold;">
									<%=i+1 %>
								</td>
								<td align="center" >
									<span>
										<input type="radio"  name="chk" id="<portlet:namespace />chk<%=userDTOList.getUserId()%>" value="" style="text-align: center;" />
									</span>
								</td>
								
								
								<td align="left">
									<%=userDTOList.getAccount()%>
								</td>
								<td style="color:#003366;padding-left:5px;padding-right:5px" align="left">
									<span>
										<%=userDTOList.getUserName()%>
									</span>
								</td>
						
							</tr>
					  </logic:iterate>
					   
					  <tr height="15">
					  	<td colspan="5" >
					  		
					  	</td>
					  </tr>
			  	</table>
			</td>
		</tr>

		<tr >
			<td>
				<table width="100%" class="bgdocsend-table-footer" >
				
					  <tr height="35" >
					    <td><div align="right">
					        <input type="button" value='<liferay-ui:message key="documentcode.close" />'>
					        
					    </div></td>
					  </tr>
				</table>
			</td>
		</tr>

		
	</table>

  