<%@ include file="/html/portlet/nss/header/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%
	String serverURL = "/web/guest/";
%>

<!-- <div id="AVIMControl-panel"><script src="/html/js/avim.js" type="text/javascript"></script></div> -->
<div id="header">
<div class="banner">
	<object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="950" height="153">
    	    <param name="movie" value="/html/themes/nss_cttdt/images/hcs/CotSong.swf" />
    	    <param name="quality" value="high" />
    	    <param name="wmode" value="opaque" />
    	    <param name="swfversion" value="7.0.70.0" />
    	    <param name="expressinstall" value="Scripts/expressInstall.swf" />
    	    <object type="application/x-shockwave-flash" data="/html/themes/nss_cttdt/images/hcs/CotSong.swf" width="950" height="153">
    	      <param name="quality" value="high" />
    	      <param name="wmode" value="opaque" />
    	      <param name="swfversion" value="7.0.70.0" />
    	      <param name="expressinstall" value="Scripts/expressInstall.swf" />
  	      </object>
  	</object>
</div>
<div class="menu">
    <div class="Spimenu horizontalcssmenu">
    <ul class="ulcap1" id="topmenu">
					<li><a href="<%=serverURL %>"><liferay-ui:message key="nss-trang-chu" /></a></li>
					<li><a href="<%=serverURL + "tin-tuc" %>"><liferay-ui:message key="nss-tin-tuc" /></a>
						<ul>
							<li><a href="<%=serverURL + "tin-tuc-van-phong" %>"><liferay-ui:message key="nss-tin-tuc-van-phong" /></a></li>
							<li><a href="<%=serverURL + "tin-hoat-dong-hoi" %>"><liferay-ui:message key="nss-tin-hoat-dong-hoi" /></a></li>
							<li><a href="<%=serverURL + "benh-nhan-va-cong-dong" %>"><liferay-ui:message key="nss-benh-nhan-va-cong-dong" /></a></li>
							<li><a href="<%=serverURL + "tap-chi" %>"><liferay-ui:message key="nss-tap-chi" /></a></li>
							<li><a href="<%=serverURL + "an-pham" %>"><liferay-ui:message key="nss-an-pham" /></a></li>
							<li><a href="<%=serverURL + "cap-nhat-lap-phap" %>"><liferay-ui:message key="nss-cap-nhat-lap-phap" /></a></li>
						</ul>
					</li>
			    	<li><a href="<%=serverURL + "giao-duc-dao-tao" %>"><liferay-ui:message key="nss-giao-duc-dao-tao" /></a>
			    		<ul>
							<li><a href="<%=serverURL + "dao-tao-bac-si" %>"><liferay-ui:message key="nss-dao-tao-bac-si" /></a></li>
							<li><a href="<%=serverURL + "y-ta" %>"><liferay-ui:message key="nss-y-ta" /></a></li>
							<li><a href="<%=serverURL + "ky-thuat" %>"><liferay-ui:message key="nss-ky-thuat" /></a></li>
							<li><a href="<%=serverURL + "giao-duc-benh-nhan" %>"><liferay-ui:message key="nss-giao-duc-benh-nhan" /></a></li>
						</ul>
			    	</li>
			    	<li><a href="<%=serverURL + "lien-ket-chinh-phu" %>"><liferay-ui:message key="nss-lien-ket-chinh-phu" /></a>
			    		<ul>
							<li><a href="<%=serverURL + "ton-thuong-chien-tranh" %>"><liferay-ui:message key="nss-ton-thuong-chien-tranh" /></a></li>
							<li><a href="<%=serverURL + "to-chuc-y-hoc" %>"><liferay-ui:message key="nss-to-chuc-y-hoc" /></a></li>
							<li><a href="<%=serverURL + "cac-van-de-lien-quan" %>"><liferay-ui:message key="nss-cac-van-de-lien-quan" /></a></li>
							<li><a href="<%=serverURL + "cac-chinh-sach-y-te" %>"><liferay-ui:message key="nss-cac-chinh-sach-y-te" /></a></li>
						</ul>
			    	</li>
			    	<li><a href="<%=serverURL + "nghien-cuu" %>"><liferay-ui:message key="nss-nghien-cuu" /></a>
			    		<ul>
							<li><a href="<%=serverURL + "uy-ban-nghien-cuu" %>"><liferay-ui:message key="nss-uy-ban-nghien-cuu" /></a></li>
							<li><a href="<%=serverURL + "dieu-tiet-hoat-dong" %>"><liferay-ui:message key="nss-dieu-tiet-hoat-dong" /></a></li>
							<li><a href="<%=serverURL + "so-lieu-thong-ke" %>"><liferay-ui:message key="nss-so-lieu-thong-ke" /></a></li>
							<li><a href="<%=serverURL + "tong-quan-huong-dan-va-cong-nghe" %>"><liferay-ui:message key="nss-tong-quan-huong-dan-va-cong-nghe" /></a></li>
							<li><a href="<%=serverURL + "tai-lieu-nghien-cuu" %>"><liferay-ui:message key="nss-tai-lieu-nghien-cuu" /></a></li>
							<li><a href="<%=serverURL + "co-hoi-va-giai-thuong" %>"><liferay-ui:message key="nss-co-hoi-va-giai-thuong" /></a></li>
						</ul>
			    	</li>
			    	<li><a href="<%=serverURL + "tiep-xuc" %>"><liferay-ui:message key="nss-tiep-xuc" /></a>
			    		<ul>
							<li><a href="<%=serverURL + "thanh-phan-ban-chap-hanh" %>"><liferay-ui:message key="nss-thanh-phan-ban-chap-hanh" /></a></li>
							<li><a href="<%=serverURL + "thuong-truc-ban-chap-hanh" %>"><liferay-ui:message key="nss-thuong-truc-ban-chap-hanh" /></a></li>
							<li><a href="<%=serverURL + "hinh-anh-va-chuc-danh" %>"><liferay-ui:message key="nss-hinh-anh-va-chuc-danh" /></a></li>
							<li><a href="<%=serverURL + "cac-uy-ban-lien-quan" %>"><liferay-ui:message key="nss-cac-uy-ban-lien-quan" /></a></li>
						</ul>
			    	</li>
			    	<li><a href="<%=serverURL + "hoi-vien" %>"><liferay-ui:message key="nss-hoi-vien" /></a>
			    		<ul>
							<li><a href="<%=serverURL + "chan-dung-bac-si" %>"><liferay-ui:message key="nss-chan-dung-bac-si" /></a></li>
							<li><a href="<%=serverURL + "trong-ban-chap-hanh" %>"><liferay-ui:message key="nss-trong-ban-chap-hanh" /></a></li>
							<li><a href="<%=serverURL + "hoi-vien-dac-biet" %>"><liferay-ui:message key="nss-hoi-vien-dac-biet" /></a></li>
							<li><a href="<%=serverURL + "hoi-vien-thuong" %>"><liferay-ui:message key="nss-hoi-vien-thuong" /></a></li>
						</ul>
			    	</li>
		</ul>
	</div>
    
    <div class="search">
    	<liferay-ui:journal-content-search />
    </div>
</div>
</div>