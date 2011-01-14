<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.WindowState"%>

<script type="text/javascript">
	var incstt = 0;
	var incstt1 = 0;
	
	function checkValidate(){
		if(checkInput() == false || checkFileUpload() == false || checkFileUpload1() == false){
			return false;
		}else{
			fileUpload();
			fileUpload1();
		}
	}
	
	function checkInput(){
		if(document.<portlet:namespace/>fm.<portlet:namespace/>reportRegistryCode.value == ""){
			alert("<liferay-ui:message key='input-department-code'/>");
			return false;
		}
		if(document.<portlet:namespace/>fm.<portlet:namespace/>department.value == ""){
			alert("<liferay-ui:message key='input-department-name'/>");
			return false;
		}
	}
	
	function uploadResultFile(){
		var table=document.getElementById('addfileupload').insertRow(1);
		
		var title = table.insertCell(0);
		var nameDocument = table.insertCell(1);
		var deleteRow = table.insertCell(2);

		table.style.backgroundColor = "white";
		table.setAttribute("class", "portlet-section-header results-row");
		table.setAttribute("className", "portlet-section-header results-row");
		title.innerHTML="<input style='width: 90%'  name='<portlet:namespace/>titlefile' type='text' maxlength='255' id='titlefile" +incstt+"'>";
		nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>namefile" +incstt+"' id='namefile" +incstt+"' onchange='getFileNameForTitle(this)'>";
		deleteRow.innerHTML="<div align='center'><input style='width: 80%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input></div>";
		incstt += 1;
	}
	
	function uploadProgramFile(){
		var table=document.getElementById('addfileupload1').insertRow(1);
		
		var title = table.insertCell(0);
		var nameDocument = table.insertCell(1);
		var deleteRow = table.insertCell(2);

		table.style.backgroundColor = "white";
		table.setAttribute("class", "portlet-section-header results-row");
		table.setAttribute("className", "portlet-section-header results-row");
		title.innerHTML="<input style='width: 90%'  name='<portlet:namespace/>titlefile1' type='text' maxlength='255' id='titlefile1" +incstt1+"'>";
		nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>namefile1" +incstt1+"' id='namefile1" +incstt1+"' onchange='getFileNameForTitle1(this)'>";
		deleteRow.innerHTML="<div align='center'><input style='width: 80%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow1(this)' ></input></div>";
		incstt1 += 1;
	}
	
	function getFileNameForTitle(obj) {
		if (obj.type != "file") return;
		var id = obj.id;
		var filePath = obj.value;
		if (id != null && id != "") {
			var numOfId = id.replace("namefile", "");
			var titleObj = document.getElementById("titlefile" + numOfId);
			if (titleObj != null && titleObj.type == "text" && filePath.length > 0) {
				var arrTmp = filePath.split("\\");
				if (arrTmp.length > 0) {
					var fileName = arrTmp[arrTmp.length - 1];
					if (fileName.length > 0) {
						var lastIdxDot = fileName.lastIndexOf(".");
						if (lastIdxDot > 0) {
							titleObj.value = fileName.substring(0, lastIdxDot);
						}
					} 
				} 
			} 
		} 
	}
	
	function getFileNameForTitle1(obj) {
		if (obj.type != "file") return;
		var id = obj.id;
		var filePath = obj.value;
		if (id != null && id != "") {
			var numOfId = id.replace("namefile1", "");
			var titleObj = document.getElementById("titlefile1" + numOfId);
			if (titleObj != null && titleObj.type == "text" && filePath.length > 0) {
				var arrTmp = filePath.split("\\");
				if (arrTmp.length > 0) {
					var fileName = arrTmp[arrTmp.length - 1];
					if (fileName.length > 0) {
						var lastIdxDot = fileName.lastIndexOf(".");
						if (lastIdxDot > 0) {
							titleObj.value = fileName.substring(0, lastIdxDot);
						}
					} 
				} 
			} 
		} 
	}

	function deleteRow(row){
		 var i=row.parentNode.parentNode.parentNode.rowIndex;
		 document.getElementById('addfileupload').deleteRow(i);
	}
	
	function deleteRow1(row){
		 var i=row.parentNode.parentNode.parentNode.rowIndex;
		 document.getElementById('addfileupload1').deleteRow(i);
	}
	
	function fileUpload() {
		var listNameRow = "";
		var valueNameFile ="";
		var tileFile ="";
		for(i = 0; i < incstt; i++) {
			if(document.getElementById('namefile'+ i)) {			
				listNameRow += "namefile" + i + "_";
				valueNameFile += document.getElementById('namefile'+ i).value +"/";
			}

			if (document.getElementById('titlefile'+ i)) {
				tileFile += document.getElementById('titlefile'+ i).value + "#";	
			}
		}
		document.getElementById('nameFieldRow').value = listNameRow;
		document.getElementById('nameFiles').value = valueNameFile;
		document.getElementById('titleFiles').value = tileFile;		
	}
	
	function fileUpload1() {
		var listNameRow = "";
		var valueNameFile ="";
		var tileFile ="";
		for(i = 0; i < incstt1; i++) {
			if(document.getElementById('namefile1'+ i)) {			
				listNameRow += "namefile1" + i + "_";
				valueNameFile += document.getElementById('namefile1'+ i).value +"/";
			}

			if (document.getElementById('titlefile1'+ i)) {
				tileFile += document.getElementById('titlefile1'+ i).value + "#";	
			}
		}
		document.getElementById('nameFieldRow1').value = listNameRow;
		document.getElementById('nameFiles1').value = valueNameFile;
		document.getElementById('titleFiles1').value = tileFile;		
	}
	
	function checkFileUpload() {
		var result = true;
		for(i = incstt - 1; i >= 0; i--) {
			if(document.getElementById('namefile'+ i)) {			
				var valueNameFile1 = document.getElementById('namefile'+ i).value;
				var fileTitle = document.getElementById('titlefile'+ i);
				var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();

				if (valueNameFile1 == "") {
					alert("<liferay-ui:message key='chon-tap-tin-dinh-kem'/>");
					document.getElementById('namefile'+ i).focus();
					fileTitle.focus();
					result = false;
					break;
				}

				var typeStandard = "xls,html,htm,doc,docx,xlsx,pdf";	
				
				if(typeStandard.search(type.toLowerCase()) == -1) {
					alert("<liferay-ui:message key='sai-dinh-dang'/>");
					fileTitle.focus();
					result = false;	
					break;
				}

				if (fileTitle.value.trim() == "") {
					alert("<liferay-ui:message key='nhap-tieu-de'/>");
					fileTitle.focus();
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	function checkFileUpload1() {
		var result = true;
		for(i = incstt - 1; i >= 0; i--) {
			if(document.getElementById('namefile1'+ i)) {			
				var valueNameFile1 = document.getElementById('namefile1'+ i).value;
				var fileTitle = document.getElementById('titlefile1'+ i);
				var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();

				if (valueNameFile1 == "") {
					alert("<liferay-ui:message key='chon-tap-tin-dinh-kem'/>");
					document.getElementById('namefile1'+ i).focus();
					fileTitle.focus();
					result = false;
					break;
				}

				var typeStandard = "xls,html,htm,doc,docx,xlsx,pdf";	
				
				if(typeStandard.search(type.toLowerCase()) == -1) {
					alert("<liferay-ui:message key='sai-dinh-dang'/>");
					fileTitle.focus();
					result = false;	
					break;
				}

				if (fileTitle.value.trim() == "") {
					alert("<liferay-ui:message key='nhap-tieu-de'/>");
					fileTitle.focus();
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	function deleteConfirm(url) {
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			location.href = url;
		}
	}
	
	function sendSelect(){
		submitForm(document.<portlet:namespace/>fm,
			"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
			<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
			<portlet:param name="tabs1" value="Report-Registry" />
			<portlet:param name="varAction" value="reportregistry" />
			<portlet:param name="<%=Constants.CMD%>" value="SELECT" />
			</portlet:actionURL>");
	}
	
	function checkDate() {
	  	 if (checkDateFrom() == false || checkDateTo() == false){
	      	 return false;
	   	 } else {
	    	 return true;
	     }
	}

	function checkDateFrom(){
		var dateFrom = document.<portlet:namespace />fm.<portlet:namespace />dateFrom.value;
	    if((dateFrom != "") && (isDateTime(dateFrom) == false)){
	    	return false;
	    }else{
	    	return true;
	    }
	}
	    
	function checkDateTo(){
		var dateTo = document.<portlet:namespace />fm.<portlet:namespace />dateTo.value;
	   	if((dateTo != "") && (isDateTime(dateTo) == false)){
	    	return false;
	    }else{
	    	return true;
	    }
	}

	var dtCh= "/";
	function isInteger(s){
	   var i;
	   	for (i = 0; i < s.length; i++){   
	       var c = s.charAt(i);
	       if (((c < "0") || (c > "9"))) return false;
	   	}
	   return true;
	}

	function stripCharsInBag(s, bag){
	   var i;
	   var returnString = "";
	   	for(i = 0; i < s.length; i++){   
	        var c = s.charAt(i);
	        if (bag.indexOf(c) == -1) returnString += c;
	    }
	   return returnString;
	}

	function daysInFebruary (year){
	   return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
	}
	   
	function DaysArray(n) {
	   for(var i = 1; i <= n; i++) {
	    	this[i] = 31
	    	if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
	    	if (i==2) {this[i] = 29}
	   } 
	   return this
	}

	function isDateTime(dtStr){
	    var daysInMonth = DaysArray(12)
	    var pos1=dtStr.indexOf(dtCh)
	    var pos2=dtStr.indexOf(dtCh,pos1+1)
	    var strDay=dtStr.substring(0,pos1)
	    var strMonth=dtStr.substring(pos1+1,pos2)
	    var strYear=dtStr.substring(pos2+1)
	    strYr=strYear
	    if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	    if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	    	for (var i = 1; i <= 3; i++) {
	    		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	    	}
	    month=parseInt(strMonth)
	    day=parseInt(strDay)
	    year=parseInt(strYr)
	    	if (pos1==-1 || pos2==-1){
	    		alert("<liferay-ui:message key='input-date-validate-dd-mm-yyyy'/>")
	    		return false
	    	}
	    	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
	    		alert("<liferay-ui:message key='input-date-validate'/>")
	    		return false
	    	}
	    	if (strMonth.length<1 || month<1 || month>12){
	    		alert("<liferay-ui:message key='input-month-validate'/>")
	    		return false
	    	}
	    	if (strYear.length != 4 || year==0){
	    		alert("<liferay-ui:message key='input-year-validate'/>")
	    		return false
	    	}
	    	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
	    		alert("<liferay-ui:message key='input-date-validate-dd-mm-yyyy'/>")
	    		return false
	    	}
	    	return true
	    }
	
</script>
