<%@ include file="/html/portlet/sgs/receivergroup/init.jsp" %>
<%
int type = ParamUtil.getInteger(renderRequest, ReceiverKeys.TYPE, 0);
String updateViewId = ParamUtil.getString(renderRequest, "update_view_id", "");
String updateDataId = ParamUtil.getString(renderRequest, "update_data_id", "");
String _callback = ParamUtil.getString(renderRequest, "_callback", "");
%>
<liferay-portlet:renderURL var="edit" portletName="<%=ReceiverKeys.PORTLET_NAME %>" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="struts_action" value="/sgs/receivergroup/edit_receiver_group"></liferay-portlet:param>
	<liferay-portlet:param name="<%=ReceiverKeys.TYPE%>" value="<%=String.valueOf(type) %>"></liferay-portlet:param>
</liferay-portlet:renderURL>
<fieldset class="filborder receiver-group-content">
	<legend class="laborder"><liferay-ui:message key="receiver-group"/>&nbsp;&nbsp;&nbsp;<liferay-ui:icon image="add" url='<%= "javascript: " + renderResponse.getNamespace() + "editReciverGroup" + type + "();" %>' toolTip="them-luong" label="them-luong" message="them-luong"></liferay-ui:icon></legend>
	<div></div>
	
	<div id="nss_jstree<%=type %>">
		<ul class="jstree-no-icons" id="<portlet:namespace/>root<%=type %>"></ul>
	</div>
</fieldset>
<script type="text/javascript">
var flags<%=type%> = [];

function <portlet:namespace/>editReciverGroup<%=type%>(groupId) {
	var params = {
			'receiverGroupId' : groupId
	};
	$jq("<div/>").dialog({
		title: '<liferay-ui:message key="them-moi-cap-nhat-luong"/>',
		modal:true,
		position: 'center',
		hide: 'scale',
		show: 'scale',
		width:500,
		minWidth:500,
		height:'auto',
		minHeight:350,
		close: function (){$jq(this).remove();setTimeout('<portlet:namespace/>initTree<%=type%>()', 150);},
		buttons: {
			'<liferay-ui:message key="close"/>' : function () {$jq(this).dialog('close');}
		}
	}).html("<div class='loading-animation'/>").load('<%= edit%>', params);
}

function <portlet:namespace/>initTree<%=type%>() {
	Liferay.Service.ReceiverGroup.ReceiverGroup.getReceiverGroups(
			{
				type: '<%=type%>'
			},
			function(json) {
				var exception = json.exception;
				var fin;
				if (!exception) {
					var content = $jq("#nss_jstree<%=type %>");
					var ani = $jq("<div class='loading-animation'/>");
					content.parent().prepend(ani);
					content.empty().hide();
					var root = $jq("<ul/>");
					root.addClass("jstree-no-icons");
					
					for (var i = 0; i < json.length; i++) {
						var rg = json[i];
						var li = $jq("<li/>");
						li.attr("id", rg.receiverGroupId);
						li.addClass("branch");
						var a = $jq("<a class='_brch'/>");
						a.text(rg.receiverGroupName);
						li.append(a);
						
						var span = $jq("<span class='_button'/>");
						var button = $jq("<img/>");
						var button2 = $jq("<img/>");
						button.attr("src", "/html/images/imgedit.png");
						button2.attr("src", "/html/images/imgdelete.png");
						//button.attr("onclick", "<portlet:namespace/>editReciverGroup<%=type%>('" + rg.receiverGroupId + "')");
						button.attr("gid", rg.receiverGroupId);
						button.click(function(){
							<portlet:namespace/>editReciverGroup<%=type%>($jq(this).attr("gid"));
						});
						button2.attr("gid", rg.receiverGroupId);
						button2.click(function(){
							<portlet:namespace/>removeGroup<%=type%>($jq(this).attr("gid"));
						});
						
						span.append(button);
						span.append(button2);
						li.append(span);
						<portlet:namespace/>initBranch<%=type%>( li  ,  rg.receiverGroupId  );
						root.append(li);
					}
					content.append(root);
					setTimeout(function(){
						<portlet:namespace/>myTree<%=type%>(function (){ani.remove();});
					}, 1);
				} else {
					alert(Liferay.Language.get(exception.split(":")[1]));
					if (exception.split(":")[0].trim() == "com.liferay.portal.security.auth.PrincipalException.PrincipalException") {
						location.href = location.href;
					}
				}
				return true;
			}
			);
	return true;
}

function <portlet:namespace/>registerUpdateEle<%=type %>() {
	var tree = $jq("#nss_jstree<%=type %>");
	var ref = $jq.jstree._reference(tree);
	try {
		tree.bind("change_state.jstree", function(){
			setTimeout(function() {
				var data = new Object();
				ref.get_checked().each(function(){
					if ($jq(this).is(".branch")) {
						$jq(this).find("li").each(function(){
							data[$jq(this).attr("id")] = $jq(this).text().trim();
							return data;
						});
					} else {
						data[$jq(this).attr("id")] = $jq(this).text().trim();
						return data;
					}
				});
				var ele = $jq("#<%=updateDataId%>");
				if (ele.length > 0) {
					if (ele.get(0).tagName.toLowerCase() == 'select') {
						ele.find("option").each(function(){
							data[$jq(this).val()] = $jq(this).text().trim();
						});
						ele.empty();
						for (var a in data) {
							var e = $jq("<option/>");
							e.val(a);
							e.text(data[a]);
							ele.append(e);
						}
					} else {
						var values = "";
						for (var a in data) {
							values += data[a] + "; ";
						}
						ele.val(values);
					}
				}
			}, 150);
		});
	} catch (err){}
}

function <portlet:namespace/>initBranch<%=type%>(li, groupId) {
	if (!flags<%=type%>) {
		window.flags<%=type%> = [];
	}
	flags<%=type%>[flags<%=type%>.length] = "wait";
	Liferay.Service.ReceiverGroup.Receiver.getReceivers(
			{
				"receiverGroupId": groupId
			}, function(data) {
				var exp = data.exception;
				if (!exp) {
					var ul = $jq("<ul/>");
					for (var j = 0; j < data.length; j++) {
						var r = data[j];
						var li2 = $jq("<li/>");
						switch (r.receiverType) {
						case 1:
							li2.attr("id", r.receiverUserId);
							break;
						case 3:
							li2.attr("id", r.receiverUserName);
							break;
						}
						li2.addClass("leaf");
						var a2 = $jq("<a class='_lf'/>");
						a2.text(r.viewName);
						li2.append(a2);
						ul.append(li2);
						
					}
					li.append(ul);
				} else {
					alert(Liferay.Language.get(exp.split(":")[1]));
					if (exp.split(":")[0].trim() == "com.liferay.portal.security.auth.PrincipalException.PrincipalException") {
						location.href = location.href;
					}
				}
				flags<%=type%>.splice(0,1);
			}
		);
}

function <portlet:namespace/>myTree<%=type%>(_callback) {
	if (flags<%=type%>.length == 0) {
		var tree = 	$jq("#nss_jstree<%=type %>").jstree({
			"core": {"animation": 0},
			"themes" : {
				"theme" : "classic",
				"dots" : true,
				"icons" : false
			},
			 "plugins" : [ "themes", "html_data", "checkbox" ]
		});
		//<portlet:namespace/>checkedEvent<%=type %>();
		//<portlet:namespace/>registerUpdateEle<%=type %>();
		tree.fadeIn(150);
		if (_callback) {
			_callback();
		}
		<% if (_callback.length() > 0) {%>
		try {
			var callback_ = <%= _callback%>;
			callback_();
		} catch (err){alert(err);}
		<%}%>
	}
	else {
		setTimeout(function(){
			<portlet:namespace/>myTree<%=type%>(_callback);
		}, 500);
	}
}

function <portlet:namespace/>checkedEvent<%=type %>() {
	var tree = $jq("#nss_jstree<%=type %>");
	var ref = $jq.jstree._reference(tree);
	$jq("._brch").click(function() {
		var cur = $jq(this).parent().get(0);
		var el = $jq(this);
		tree.find(".branch").each(function() {
			if (this.id != cur.id) {
				ref.change_state("#" + this.id, true);
			}
		});
	});
	$jq("._lf").click(function() {
		var cur = $jq(this).parents('.branch').get(0);
		var el = $jq(this);
		tree.find(".branch").each(function() {
			if (this.id != cur.id) {
				ref.change_state("#" + this.id, true);
			}
		});
	});
}

function <portlet:namespace/>removeGroup<%=type%>(groupId) {
	var del = confirm('<liferay-ui:message key="ban-muon-xoa-luong-nay"/>');
	if (!del) {
		return;
	}
	Liferay.Service.ReceiverGroup.ReceiverGroup.deleteReceiverGroup(
			{
				"receiverGroupId": groupId
			}, function (json) {
				var exception = json.exception;
				if (!exception) {
					try {
						setTimeout('<portlet:namespace/>initTree<%=type%>()', 150);						
					}catch (err){}
				} else {
					alert(Liferay.Language.get(exception.split(":")[1]));
					if (exception.split(":")[0].trim() == "com.liferay.portal.security.auth.PrincipalException.PrincipalException") {
						location.href = location.href;
					} else {
						setTimeout('<portlet:namespace/>initTree<%=type%>()', 150);
					}
				}
			}
			);
}

$jq(document).ready(function(){
	<portlet:namespace/>initTree<%=type%>();
});
</script>
<style type="text/css">
.receiver-group-content {
	min-height: 200px;
}

#nss_jstree<%=type %> li.branch{
	position: relative;
	border-bottom: 1px dotted #AAAAAA;
	width: 100%;
	min-height: 25px;
}

a._brch {
	padding: 5px;
}

._button {
	padding: 5px;
	position: absolute;
	right: 5%;
}

.btn {
}

</style>
