<%@ include file="/html/portlet/nss/visitor/init.jsp" %>

<div id="leftmenu">
<div class="toptitleleft">
    <h3><liferay-ui:message key="nss-luot-truy-cap" /></h3>
    <div class="btmtitleleft">
	    <div class="ctrtitleleft">
	    	<!-- div style="text-align: center;padding-top: 10px;"><img alt="" src="/html/images/visitor.png"></div-->
	    	<!-- http://www.freehitscounters.org/ -->
			<div align="center"><img height="25px" width="95%" src="http://imagecontents.com/counter.php?id=169212&t=16" border="0"  ></img></div>
	    </div>
    </div>
</div>
</div>


<SCRIPT>
	/* 
		function GetCookie (name) { 
			var arg = name + "="; 
			var alen = arg.length; 
			var clen = document.cookie.length; 
			var i = 0; 
			while (i < clen) {
			var j = i + alen; 
			if (document.cookie.substring(i, j) == arg) 
			return getCookieVal (j); 
			i = document.cookie.indexOf(" ", i) + 1; 
			if (i == 0) break; 
			} 
			return null;
		}
		
		function SetCookie (name, value) { 
			var argv = SetCookie.arguments; 
			var argc = SetCookie.arguments.length; 
			var expires = (argc > 2) ? argv[2] : null; 
			var path = (argc > 3) ? argv[3] : null; 
			var domain = (argc > 4) ? argv[4] : null; 
			var secure = (argc > 5) ? argv[5] : false; 
			document.cookie = name + "=" + escape (value) + 
			((expires == null) ? "" : ("; expires=" + expires.toGMTString())) + 
			((path == null) ? "" : ("; path=" + path)) + 
			((domain == null) ? "" : ("; domain=" + domain)) + 
			((secure == true) ? "; secure" : "");
		}
		
		function DeleteCookie (name) { 
			var exp = new Date(); 
			exp.setTime (exp.getTime() - 1); 
			var cval = GetCookie (name); 
			document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
		}
		
		var expDays = 30;
		var exp = new Date(); 
		exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
		
		function amt(){
			var count = GetCookie('count')
			if(count == null) {
			SetCookie('count','1')
			return 1
			}
			else {
			var newcount = parseInt(count) + 1;
			DeleteCookie('count')
			SetCookie('count',newcount,exp)
			return count
			}
		}
		
		function getCookieVal(offset) {
			var endstr = document.cookie.indexOf (";", offset);
			if (endstr == -1)
			endstr = document.cookie.length;
			return unescape(document.cookie.substring(offset, endstr));
		}
		
		document.write("You've been here <b>" + amt() + "</b> times.")
		*/
</SCRIPT>

<!-- http://whos.amung.us/showcase -->
<!-- 
<script type="text/javascript" src="http://widgets.amung.us/classic.js"></script>
<script type="text/javascript">WAU_classic('bz9ppwuik91p')</script>
-->