<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.recievergroup.util.RecieverSerializer"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/sgs/recievergroup/init.jsp" %>
<%
int type = ParamUtil.getInteger(renderRequest, RecieverKeys.TYPE, 0);
long recieverGroupId = ParamUtil.getLong(renderRequest, "recieverGroupId", 0);
RecieverGroup recieverGroup = null;
List<Reciever> recievers = new ArrayList<Reciever>();
try {
	if (recieverGroupId > 0) {
		recieverGroup = RecieverGroupLocalServiceUtil.getRecieverGroup(recieverGroupId);
		recievers = recieverGroup.getRecievers();
	} 
} catch (Exception e) {}

%>



<div>
	<input id="<portlet:namespace/>RGID" type="hidden" value='<%= recieverGroup != null ? recieverGroup.getRecieverGroupId() : 0 %>'/>
	<input id="<portlet:namespace/>TYPE" type="hidden" value='<%= type %>'/>
	<ul class="_container" style="padding-bottom: 20px;">
		<li class="label float-left" style="padding: 9px 0;"><label for="<portlet:namespace/>groupName"><liferay-ui:message key="ten-luong"/>:&nbsp;</label></li>
		<li class="_content float-left">
		<span id="<portlet:namespace/>groupNameContainer">
			<% if (recieverGroup == null) {
				%>
			<input id="<portlet:namespace/>groupName" name="<portlet:namespace/>groupName" type="text"/>		
				<%
			} else {
				%>
			<span id="<portlet:namespace/>groupName"><%= HtmlUtil.escape(recieverGroup.getRecieverGroupName()) %></span>		
				<%
			}%>
		</span>
		<span class="error" id="<portlet:namespace/>groupNameMsg"></span></li>
	</ul>
	<ul class="_container">
		<li class="label float-left"><label for="<portlet:namespace/>searchBox"><liferay-ui:message key="noi-nhan"/>:&nbsp;</label></li>
		<li class="_content float-left" style="width: 75%;"><input style="width: 100%;" class="search-input i" id="<portlet:namespace/>searchBox" name="<portlet:namespace/>searchBox" type="text" value="<liferay-ui:message key="nhap-vao-de-tim-kiem-don-vi-nguoi-nhan-muon-them"/>"/></li>
	</ul>	
	<ul class="_container" id="<portlet:namespace/>container">
		<% for (Reciever reciever: recievers) {
			String id = "", name = "";
			switch (reciever.getRecieverType()) {
			case 1:
				try {
					User user2 = UserLocalServiceUtil.getUser(reciever.getRecieverUserId());
					id = String.valueOf(user2.getUserId());
					name = RecieverSerializer.getFullName(user2);
				} catch (Exception e) {}
				break;
			case 3:
				try {
					PmlEdmIssuingPlace edmIssuingPlace = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(reciever.getRecieverUserName());
					id = reciever.getRecieverUserName();
					name = reciever.getRecieverUserName() + " - " + edmIssuingPlace.getIssuingPlaceName();
				} catch (Exception e) {}
				break;
			}
			%>
			<li class="_item" id='<%=id%>'><%=name + "<img style=\"display: none;\" src=\"" + themeDisplay.getPathThemeImages() + "/arrows/02_x.png\" class=\"_del\"/>"%></li>
			<%
		}%>
	</ul>
</div>

<script type="text/javascript">
$jq("#<portlet:namespace/>searchBox").autocomplete({
	source: "<%= themeDisplay.getPathMain() %>/sgs/recievergroup/json?type=<%= type%>",
	select: function( event, ui ) {
		var container = $jq("#<portlet:namespace/>container");
		if (ui.item) {
			$jq("#" + ui.item.value).remove();
			var elItem = $jq("<li/>");
			var item = ui.item;
			elItem.attr("id", ui.item.value);
			elItem.addClass("_item");
			elItem.html(ui.item.label + '<img style="display: none;" src="<%=themeDisplay.getPathThemeImages()%>/arrows/02_x.png" class="_del"/>');
			elItem.prependTo(container);
			ui.item.value = '';
			<portlet:namespace/>addRecieverToGroup(elItem.attr("id"));
			<portlet:namespace/>itemAction();
		}
				
	}
});

function <portlet:namespace/>addRecieverToGroup(recieverUID) {
	var recieverGroupId = $jq("#<portlet:namespace/>RGID").val();
	var type = $jq("#<portlet:namespace/>TYPE").val();
	var recieverUserId, recieverUserName;
	
	type = parseInt(type);
	switch (type) {
	case 1:
		recieverUserId = recieverUID;
		recieverUserName = "";
			break;
	case 3:
		recieverUserId = 0;
		recieverUserName = recieverUID;
			break;
		default:
			break;
	}
	
	Liferay.Service.RecieverGroup.RecieverGroup.addRecieverToGroup(
			{
			 'groupPK': recieverGroupId,  
			 'recieverUserId': recieverUserId,  
			 'recieverUserName': recieverUserName,
			 'recieverType':type
			},
			function(json) {
				var exception = json.exception;
				if (!exception) {
					try {
						//setTimeout('<portlet:namespace/>initTree()', 150);
						
					}catch (err){}
				} else {
					alert(Liferay.Language.get(exception.split(":")[1].trim()));
					if (exception.split(":")[0].trim() == "com.liferay.portal.security.auth.PrincipalException.PrincipalException") {
						location.href = location.href;
					}
				}
			}
	);
}

function <portlet:namespace/>removeRecieverFromGroup(eleIMG) {
	var recieverGroupId = $jq("#<portlet:namespace/>RGID").val();
	var type = $jq("#<portlet:namespace/>TYPE").val();
	var recieverUserId, recieverUserName;
	
	eleIMG = $jq(eleIMG);
	var eleLI = eleIMG.parent();
	
	type = parseInt(type);
	switch (type) {
	case 1:
		recieverUserId = eleLI.attr("id");
		recieverUserName = "";
			break;
	case 3:
		recieverUserId = 0;
		recieverUserName = eleLI.attr("id");
			break;
		default:
			break;
	}
	
	Liferay.Service.RecieverGroup.RecieverGroup.removeRecieverFromGroup(
			{
			 'groupPK': recieverGroupId,  
			 'recieverUserId': recieverUserId,  
			 'recieverUserName': recieverUserName,
			 'recieverType':type
			},
			function(json) {
				var exception = json.exception;
				if (!exception) {
					eleLI.remove();
					try {
						//setTimeout('<portlet:namespace/>initTree()', 150);
						
					}catch (err){}
				} else {
					alert(Liferay.Language.get(exception.split(":")[1].trim()));
					if (exception.split(":")[0].trim() == "com.liferay.portal.security.auth.PrincipalException.PrincipalException") {
						location.href = location.href;
					}
				}
				
			}
	);
}

function <portlet:namespace/>saveGroup() {
	var el = $jq("#<portlet:namespace/>groupName");
	var type = $jq("#<portlet:namespace/>TYPE").val();
	var parent = el.parent();
	
	if (!el.val() || el.val().trim().length == 0) {
		$jq("#<portlet:namespace/>groupNameMsg").show().text(Liferay.Language.get("enter-group-name"));
		setTimeout("$jq(\"#<portlet:namespace/>groupName\").focus()", 50);
		return;
	}
	
	Liferay.Service.RecieverGroup.RecieverGroup.updateRecieverGroup({

		"recieverGroupId": $jq("#<portlet:namespace/>RGID").val(), 
		"recieverGroupName": el.val(),
		"description": "", 
		"type": type, 
		"active": true
		
	}, function(json) {
		var exception = json.exception;
		if (exception) {
			$jq("#<portlet:namespace/>groupNameMsg").show().text(Liferay.Language.get(exception.split(":")[1].trim()));
			setTimeout("$jq(\"#<portlet:namespace/>groupName\").focus()", 50);
			if (exception.split(":")[0].trim() == "com.liferay.portal.security.auth.PrincipalException.PrincipalException") {
				location.href = location.href;
			}
		} else {
			$jq("#<portlet:namespace/>RGID").val(json.recieverGroupId);
			el.remove();
			el = $jq("<span/>");
			el.attr("id", "<portlet:namespace/>groupName");
			el.text(json.recieverGroupName);
			el.appendTo(parent);
			el.click(function(){
				<portlet:namespace/>GNClickAction();
			});
			$jq("#<portlet:namespace/>groupNameMsg").hide();			
			try {
				//setTimeout('<portlet:namespace/>initTree()', 150);
				
			}catch (err){}
		}
	}
	);
}

function <portlet:namespace/>GNClickAction() {
	el = $jq("#<portlet:namespace/>groupName");
	var parent = el.parent();
	var name = el.text();
	el.remove();
	el = $jq("<input/>");
	el.attr("type", "text");
	el.attr("id", "<portlet:namespace/>groupName");
	el.val(name);
	el.appendTo(parent);
	el.blur(function(){
		<portlet:namespace/>saveGroup();
	});
	el.keyup(function(event){
		var keyCode = $jq.ui.keyCode;
		if (event.keyCode == keyCode.ENTER || event.keyCode == keyCode.NUMPAD_ENTER) {
			<portlet:namespace/>saveGroup();				
		}
	});
	el.focus();
	el.select();
}

$jq(function(){
	var groupName =	$jq("#<portlet:namespace/>groupName");
	if (groupName.get(0).tagName.toLowerCase() == 'input') {
		groupName.focus();
		groupName.blur(function(){
			<portlet:namespace/>saveGroup();
		});
		groupName.keyup(function(event){
			var keyCode = $jq.ui.keyCode;
			if (event.keyCode == keyCode.ENTER || event.keyCode == keyCode.NUMPAD_ENTER) {
				<portlet:namespace/>saveGroup();				
			}
		});
	} else {
		groupName.click(function(){
			<portlet:namespace/>GNClickAction();
		});
	}
	$jq("#<portlet:namespace/>searchBox").focus(function(){
		var el = $jq(this);
		if (el.val() == '<liferay-ui:message key="nhap-vao-de-tim-kiem-don-vi-nguoi-nhan-muon-them"/>') {
			el.val('');
			el.removeClass('i');
		} else {
			el.select();
		}
	});
	$jq("#<portlet:namespace/>searchBox").blur(function(){
		var el = $jq(this);
		if (el.val().trim().length == 0) {
			el.val('<liferay-ui:message key="nhap-vao-de-tim-kiem-don-vi-nguoi-nhan-muon-them"/>');
			el.addClass('i');
		}
	});
	<portlet:namespace/>itemAction();
});

function <portlet:namespace/>itemAction() {
	$jq("._del").click(function(){
		<portlet:namespace/>removeRecieverFromGroup(this);
	});
	var item = $jq("._item");
	item.mouseover(function(){
		$jq(this).find("img").show();
	});
	item.mouseout(function(){
		$jq(this).find("img").hide();
	});
}
</script>
<style type="text/css">
.label {width: 25%; text-align: right;}
._container {width: 100%; float: left;}
.float-left {float: left; padding: 4px 0 4px 0;}
.content {width: 75%;}
._del {float: right;}
._item {margin-left: 25%; padding: 4px; border-bottom: 1px dotted #DDDDDD; cursor: pointer;}
._item:HOVER {background-color: #BBEDFC}
input#<portlet:namespace/>groupName {display: block;}
span#<portlet:namespace/>groupName {display: block; padding: 4px; border: 1px solid #FFFFFF;}
#<portlet:namespace/>groupName:HOVER{ border: 1px solid #7BD5EB; }
.error {color: red;}
.i {
	font-style: italic;
	color: #AAAAAA;
}
label {
	font-weight: bold;
}
</style>