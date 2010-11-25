<%@page import="com.nss.portlet.thoitiet_tygia.util.Weather"%>
<%@page import="com.nss.portlet.thoitiet_tygia.util.WeatherUtil"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/nss/thoitiet_tygia/init.jsp" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
 <link rel="stylesheet" href="/html/css/jquery.tabs.css" type="text/css" media="print, projection, screen">
<%
DateFormat df = new SimpleDateFormat("HH : mm", new Locale("vi", "VN"));
%>

<script language="javascript">
	var xhReq = new XMLHttpRequest();
	
	function ChangeTab(id)
	{
		document.getElementById("box_leftpane_1").style.display="none";
		document.getElementById("li_1").className="";
		document.getElementById("box_leftpane_2").style.display="none";
		document.getElementById("li_2").className="";
		document.getElementById("box_leftpane_4").style.display="none";	
		if(id==2)
		{
			document.getElementById("box_leftpane_"+(id+2)).style.display="";
		}
		document.getElementById("box_leftpane_"+id).style.display="";
		document.getElementById("li_"+id).className="current";
		
	}
</script>

<link type="text/css" rel="stylesheet" href="/html/portlet/nss/thoitiet_tygia/css/thoitiet_tygia.css" />
<script type="text/javascript" language="JavaScript" src="http://vnexpress.net/Service/Gold_Content.js"></Script>
<script type="text/javascript" language="JavaScript" src="http://vnexpress.net/Service/Forex_Content.js"></Script>
<!-- Thoi tiet -->
<div class="toptitleright">
    <h3><liferay-ui:message key="nss-thoi-tiet-ty-gia" /></h3>
    <div class="btmtitleright">
    <div class="ctrtitleright">
		<div >
		      <ul class="ui-tabs-nav">
		        <li id="li_1" ><a href="javascript:ChangeTab(1);"><span><liferay-ui:message key="weather" /></span></a></li>
		        <li id="li_2"><a href="javascript:ChangeTab(2);"><span><liferay-ui:message key="ty-gia" /></span></a></li>
		      </ul>
		</div>
		<div class="ui-tabs-panel">
		<div id="box_leftpane_1" >
		<div class="weather" style="height:269px;overflow: auto;overflow-x: hidden">
				 <h3></h3>
				 <div class="divlist">
				 <!-- Tu Da sua doi 17/11/2010 -->
					 <h4><liferay-ui:message key="ha-noi" /></h4>
					 <%
					List<Weather> list = WeatherUtil.getWeather("http://vnexpress.net/ListFile/Weather/HaNoi.xml");
					if(list.size()>0){
						String img = "<img src='http://vnexpress.net/Images/Weather/" + list.get(0).getAdImg()+"'/>";
						String img1 = "<img src='http://vnexpress.net/Images/Weather/" + list.get(0).getAdImg1()+"'/>";
						String img2 = "<img src='http://vnexpress.net/Images/Weather/" + list.get(0).getAdImg2()+"'/>";
					%>
					<%= img + img1 + img2 %>
					<img src='http://vnexpress.net/Images/Weather/c.gif'/>
					<br>
					<div class="content_weather" style="padding-left: 25px;">
					<%= list.get(0).getWeather()  %>
					</div>
					<%
					}
					%>
				 </div>
				 <div class="divlist">
					 <h4><liferay-ui:message key="da-nang" /></h4>
					 <%
					List<Weather> list1 = WeatherUtil.getWeather("http://vnexpress.net/ListFile/Weather/DaNang.xml");
					if(list1.size()>0){
						String img = "<img src='http://vnexpress.net/Images/Weather/" + list1.get(0).getAdImg()+"'/>";
						String img1 = "<img src='http://vnexpress.net/Images/Weather/" + list1.get(0).getAdImg1()+"'/>";
						String img2 = "<img src='http://vnexpress.net/Images/Weather/" + list1.get(0).getAdImg2()+"'/>";
					%>
					<%= img + img1 + img2 %>
					<img src='http://vnexpress.net/Images/Weather/c.gif'/>
					<br>
					<div class="content_weather" style="padding-left: 25px;">
					<%= list1.get(0).getWeather()  %>
					</div>
					<%
					}
					%>
				 </div >
				 <div class="divlist">
					 <h4><liferay-ui:message key="tp-hcm" /></h4>
					 <%
					List<Weather> list2 = WeatherUtil.getWeather("http://vnexpress.net/ListFile/Weather/HCM.xml");
					if(list.size()>0){
						String img = "<img src='http://vnexpress.net/Images/Weather/" + list2.get(0).getAdImg()+"'/>";
						String img1 = "<img src='http://vnexpress.net/Images/Weather/" + list2.get(0).getAdImg1()+"'/>";
						String img2 = "<img src='http://vnexpress.net/Images/Weather/" + list2.get(0).getAdImg2()+"'/>";
					%>
					<%= img + img1 + img2 %>
					<img src='http://vnexpress.net/Images/Weather/c.gif'/>
					<br>
					<div class="content_weather" style="padding-left: 25px;">
					<%= list2.get(0).getWeather()  %>
					</div>
					<%
					}
					%>
					<!-- ket thuc qua trinh sua cua Tu -->
				 </div>
			</div>
		</div>
		<div  id="box_leftpane_2" style="display:none;">
		  <!-- Ty gia -->
		  <span id="timeField_"><liferay-ui:message key="cap-nhat-luc" />&nbsp;:<%=df.format(new Date()) %></span><br>
		  <div class="tygia" style="height:115px;overflow: auto;overflow-x: hidden">
		    <span class="textred textbold">
		    	<img src="/html/images/vang.png" hspace="5" vspace="1" align="middle"/><liferay-ui:message key="gia-vang" />
		    </span><br>
		      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="info-tb">
		        <tr class="title_black textbold">
		          <td height="24" align="center" class="info-tb-title"><liferay-ui:message key="loai" /></td>
		          <td align="center" class="info-tb-title"><liferay-ui:message key="mua-vao" /></td>
		          <td align="center" class="info-tb-title"><liferay-ui:message key="ban-ra" /></td>
		        </tr>
		        <tr>
		          <td align="center" class="textbold">SJC</td>
		          <td align="center"><script language="javascript"> document.write(vGoldSjcBuy); </script></td>
		          <td align="center"><script language="javascript"> document.write(vGoldSjcSell); </script></td>
		        </tr>
		        <tr>
		          <td align="center" class="textbold">SBJ</td>
		          <td align="center"><script language="javascript"> document.write(vGoldSbjBuy); </script></td>
		          <td align="center"><script language="javascript"> document.write(vGoldSbjSell); </script></td>
		        </tr>
		      </table>
		    </div>
		    <script type="text/javascript" language="JavaScript" src="http://vnexpress.net/Service/Forex_Content.js"> </Script>
		    <div class="tygia">
			    <div class="conts_leftpane" id="box_leftpane_4" style="height:115px;overflow: auto;overflow-x: hidden"> 
			    <span class="textred textbold"><img src="/html/images/tygia.png" hspace="5" vspace="1" align="middle" /><liferay-ui:message key="ty-gia-ngoai-te" />
			   </span><br>
			      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="info-tb">
			        <tr class="title_black textbold">
			          <td height="24" align="center" class="info-tb-title"><liferay-ui:message key="ten-ngoai-te" /></td>
			          <td align="center" class="info-tb-title"><liferay-ui:message key="ty-gia" /> (VND)</td>
			        </tr>
			        <tr>
			          <script language="javascript"> var i=0; for (i=0;i<=6;i++) { if(vCosts[i] != "-") {document.write("<tr><td align='center' class='textbold'>" + vForexs[i] +"</td><td align='center'>" + vCosts[i] + "</td></tr>");} } </script>
			        </tr>
			      </table>
			    </div>
		    </div>
		   </div>
		</div>
</div>
</div>
</div>
<script type="text/javascript">
document.getElementById('li_1').className = "current";
</script>