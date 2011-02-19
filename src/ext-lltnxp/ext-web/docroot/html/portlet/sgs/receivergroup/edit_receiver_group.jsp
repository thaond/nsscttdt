<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.receivergroup.util.ReceiverSerializer"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/sgs/receivergroup/init.jsp" %>
<%
int type = ParamUtil.getInteger(renderRequest, ReceiverKeys.TYPE, 0);
long receiverGroupId = ParamUtil.getLong(renderRequest, "receiverGroupId", 0);
ReceiverGroup receiverGroup = null;
List<Receiver> receivers = new ArrayList<Receiver>();
try {
	if (receiverGroupId > 0) {
		receiverGroup = ReceiverGroupLocalServiceUtil.getReceiverGroup(receiverGroupId);
		receivers = receiverGroup.getReceivers();
	} 
} catch (Exception e) {}
%>



<div>
	<input id="<portlet:namespace/>RGID" type="hidden" value='<%= receiverGroup != null ? receiverGroup.getReceiverGroupId() : 0 %>'/>
	<input id="<portlet:namespace/>TYPE" type="hidden" value='<%= type %>'/>
	<ul class="_container" style="padding-bottom: 20px;">
		<li class="label float-left" style="padding: 9px 0;"><label for="<portlet:namespace/>groupName"><b><liferay-ui:message key="ten-luong"/>:&nbsp;</b></label></li>
		<li class="_content float-left">
		<span id="<portlet:namespace/>groupNameContainer">
			<% if (receiverGroup == null) {
				%>
			<input id="<portlet:namespace/>groupName" name="<portlet:namespace/>groupName" type="text"/>		
				<%
			} else {
				%>
			<span id="<portlet:namespace/>groupName"><%= HtmlUtil.escape(receiverGroup.getReceiverGroupName()) %></span>		
				<%
			}%>
		</span>
		<span class="error" id="<portlet:namespace/>groupNameMsg"></span></li>
	</ul>
	<ul class="_container">
		<li class="label float-left"><label for="<portlet:namespace/>searchBox"><b><liferay-ui:message key="noi-nhan"/>:&nbsp;</b></label></li>
		<li class="_content float-left" style="width: 75%;"><input style="width: 100%;" class="search-input" id="<portlet:namespace/>searchBox" name="<portlet:namespace/>searchBox" type="text" value="" title="<liferay-ui:message key="nhap-vao-de-tim-kiem-don-vi-nguoi-nhan-muon-them"/>"/></li>
	</ul>	
	<ul class="_container" id="<portlet:namespace/>container">
		<% for (Receiver receiver: receivers) {
			String id = "", name = "";
			switch (receiver.getReceiverType()) {
			case 1:
				try {
					User user2 = UserLocalServiceUtil.getUser(receiver.getReceiverUserId());
					id = String.valueOf(user2.getUserId());
					name = ReceiverSerializer.getFullName(user2);
				} catch (Exception e) {}
				break;
			case 3:
				try {
					PmlEdmIssuingPlace edmIssuingPlace = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(receiver.getReceiverUserName());
					id = receiver.getReceiverUserName();
					name = receiver.getReceiverUserName() + " - " + edmIssuingPlace.getIssuingPlaceName();
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
	source: "<%= themeDisplay.getPathMain() %>/sgs/receivergroup/json?type=<%= type%>",
	minLength: 0,
	select: function( event, ui ) {
		var container = $jq("#<portlet:namespace/>container");
		if (ui.item) {
			container.find("#" + ui.item.value).remove();
			var elItem = $jq("<li/>");
			var item = ui.item;
			elItem.attr("id", ui.item.value);
			elItem.addClass("_item");
			elItem.html(ui.item.label + '<img style="display: none;" src="<%=themeDisplay.getPathThemeImages()%>/arrows/02_x.png" class="_del"/>');
			elItem.prependTo(container);
			ui.item.value = '';
			<portlet:namespace/>addReceiverToGroup(elItem.attr("id"));
			<portlet:namespace/>itemAction();
		}
				
	}
});

$jq("#<portlet:namespace/>searchBox").dblclick(function(){
	$jq("#<portlet:namespace/>searchBox").autocomplete("search","%");
});

function <portlet:namespace/>addReceiverToGroup(receiverUID) {
	var receiverGroupId = $jq("#<portlet:namespace/>RGID").val();
	var type = $jq("#<portlet:namespace/>TYPE").val();
	var receiverUserId, receiverUserName;
	
	type = parseInt(type);
	switch (type) {
	case 1:
		receiverUserId = receiverUID;
		receiverUserName = "";
			break;
	case 3:
		receiverUserId = 0;
		receiverUserName = receiverUID;
			break;
		default:
			break;
	}
	
	Liferay.Service.ReceiverGroup.ReceiverGroup.addReceiverToGroup(
			{
			 'groupPK': receiverGroupId,  
			 'receiverUserId': receiverUserId,  
			 'receiverUserName': receiverUserName,
			 'receiverType':type
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

function <portlet:namespace/>removeReceiverFromGroup(eleIMG) {
	var receiverGroupId = $jq("#<portlet:namespace/>RGID").val();
	var type = $jq("#<portlet:namespace/>TYPE").val();
	var receiverUserId, receiverUserName;
	
	eleIMG = $jq(eleIMG);
	var eleLI = eleIMG.parent();
	
	type = parseInt(type);
	switch (type) {
	case 1:
		receiverUserId = eleLI.attr("id");
		receiverUserName = "";
			break;
	case 3:
		receiverUserId = 0;
		receiverUserName = eleLI.attr("id");
			break;
		default:
			break;
	}
	
	Liferay.Service.ReceiverGroup.ReceiverGroup.removeReceiverFromGroup(
			{
			 'groupPK': receiverGroupId,  
			 'receiverUserId': receiverUserId,  
			 'receiverUserName': receiverUserName,
			 'receiverType':type
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
	
	Liferay.Service.ReceiverGroup.ReceiverGroup.updateReceiverGroup({

		"receiverGroupId": $jq("#<portlet:namespace/>RGID").val(), 
		"receiverGroupName": el.val(),
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
			$jq("#<portlet:namespace/>RGID").val(json.receiverGroupId);
			el.remove();
			el = $jq("<span/>");
			el.attr("id", "<portlet:namespace/>groupName");
			el.text(json.receiverGroupName);
			el.appendTo(parent);
			el.click(function(){
				<portlet:namespace/>GNClickAction();
			});
			$jq("#<portlet:namespace/>groupNameMsg").hide();
			$jq("#<portlet:namespace/>searchBox").focus();
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
	$jq("#<portlet:namespace/>searchBox").hint({hintClass: 'i'});
	<portlet:namespace/>itemAction();
});

function <portlet:namespace/>itemAction() {
	$jq("._del").click(function(){
		<portlet:namespace/>removeReceiverFromGroup(this);
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
</style>