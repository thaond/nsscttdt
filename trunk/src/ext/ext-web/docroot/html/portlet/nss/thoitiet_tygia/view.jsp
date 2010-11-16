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
<script type="text/javascript" src="http://rilwis.googlecode.com/svn/trunk/weather.min.js"></script>
<script type="text/javascript" language="JavaScript" src="http://vnexpress.net/Service/Gold_Content.js"></Script>
<script type="text/javascript" language="JavaScript" src="http://vnexpress.net/Service/Forex_Content.js"></Script>
 <!-- Thoi tiet -->
  <div >
    <div >
      <ul class="ui-tabs-nav">
        <li id="li_1"><a href="javascript:ChangeTab(1);"><span><liferay-ui:message key="weather" /></span></a></li>
        <li id="li_2" class="current"><a href="javascript:ChangeTab(2);"><span><liferay-ui:message key="ty-gia" /></span></a></li>
      </ul>
    </div>
  </div>
  <div class="ui-tabs-panel">
<div id="box_leftpane_1" >
<div class="weather ui-tabs-panel">
		 <h3></h3>
		 <div>
			 <h4><liferay-ui:message key="ha-noi" /></h4>
			 <script type="text/javascript">
			  showWeather('hanoi, vietnam');		 </script>
		 </div>
		 <div>
			 <h4><liferay-ui:message key="da-nang" /></h4>
			 <script type="text/javascript">
			  showWeather('danang, vietnam');
			 </script>
		 </div>
		 <div>
			 <h4><liferay-ui:message key="tp-hcm" /></h4>
			 <script type="text/javascript">
			  showWeather('hochiminh, vietnam');
			 </script>
		 </div>
	</div>
	</div>
	 <!--
	<div class="tygia">
	<label><liferay-ui:message key="gia-vang" /></label>
	<ul>
		<li><liferay-ui:message key="mua-vao" /></li>
		<li><script language="javascript">
			document.write(vGoldSjcBuy);
			</script>
		</li>
	</ul>
	<ul>
		<li><liferay-ui:message key="ban-ra" /></li>
		<li><script language="javascript">
			document.write(vGoldSjcSell);
			</script>
		</li>
	</ul>
	<label><liferay-ui:message key="ty-gia" /></label>
	<ul>
		<li>USD</li>
		<li><script language="javascript">
		document.write(vCosts[0]);
			</script>
		</li>
	</ul>
	</div>
-->

<div  id="box_leftpane_2" style="display:none;">
  <!-- Ty gia -->
  <div class="tygia ui-tabs-panel">
    <!-- <span class="textgray">cap nhat luc (<{$currentTime}>)</span>  -->
    <span id="timeField_"><liferay-ui:message key="cap-nhat-luc" /><%=df.format(new Date()) %></span>
    <span class="textred textbold">
    	<img src="/html/images/vang.png" hspace="5" vspace="1" align="left" /><liferay-ui:message key="gia-vang" /></span><br>
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
      <br/>
    </div>
    <script type="text/javascript" language="JavaScript" src="http://vnexpress.net/Service/Forex_Content.js"> </Script>
    <div class="tygia">
	    <div class="conts_leftpane" style="height:160px" id="box_leftpane_4"> 
	    <span class="textred textbold"><img src="/html/images/tygia.png" hspace="5" vspace="1" align="left" /><liferay-ui:message key="ty-gia-ngoai-te" /></span><br>
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