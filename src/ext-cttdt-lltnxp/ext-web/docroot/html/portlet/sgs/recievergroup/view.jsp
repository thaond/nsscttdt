<%@ include file="/html/portlet/sgs/recievergroup/init.jsp" %>
<%
int type = ParamUtil.getInteger(renderRequest, RecieverKeys.TYPE, 3);
%>

<div><input type="button" onclick="<portlet:namespace/>editReciverGroup();" value='<liferay-ui:message key="them-luong"/>'/></div>
<liferay-portlet:renderURL var="edit" portletName="<%=RecieverKeys.PORTLET_NAME %>" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="struts_action" value="/sgs/recievergroup/edit_reciever_group"></liferay-portlet:param>
	<liferay-portlet:param name="type" value="3"></liferay-portlet:param>
</liferay-portlet:renderURL>
<div class="boxcontent">
<div id="nss_jstree">
	<ul class="jstree-no-icons" id="<portlet:namespace/>root"></ul>
</div>
</div>
<script type="text/javascript">
function <portlet:namespace/>editReciverGroup(groupId) {
	var params = {
			'recieverGroupId' : groupId
	};
	$jq("<div/>").dialog({
		title: '<liferay-ui:message key="them-moi-cap-nhat-luong"/>',
		modal:true,
		position: 'center',
		width:500,
		minWidth:500,
		height:'auto',
		minHeight:350,
		close: function (){$jq(this).remove();setTimeout('<portlet:namespace/>initTree()', 150);},
		buttons: {
			'<liferay-ui:message key="close"/>' : function () {$jq(this).dialog('close');}
		}
	}).html("<div class='loading-animation'/>").load('<%= edit%>', params);
}

function <portlet:namespace/>initTree() {
	Liferay.Service.RecieverGroup.RecieverGroup.getRecieverGroups(
			{
				type: '<%=type%>'
			},
			function(json) {
				var exception = json.exception;
				if (!exception) {
					var content = $jq("#nss_jstree");
					content.empty();
					var root = $jq("<ul/>");
					root.addClass("jstree-no-icons");
					
					for (var i = 0; i < json.length; i++) {
						var rg = json[i];
						var li = $jq("<li/>");
						li.attr("id", rg.recieverGroupId);
						li.addClass("branch");
						var a = $jq("<a class='_brch'/>");
						a.text(rg.recieverGroupName);
						li.append(a);
						
						var span = $jq("<span class='_button'/>");
						var button = $jq("<img/>");
						var button2 = $jq("<img/>");
						button.attr("src", "/html/images/imgedit.png");
						button2.attr("src", "/html/images/imgdelete.png");
						//button.attr("onclick", "<portlet:namespace/>editReciverGroup('" + rg.recieverGroupId + "')");
						button.attr("gid", rg.recieverGroupId);
						button.click(function(){
							<portlet:namespace/>editReciverGroup($jq(this).attr("gid"));
						});
						button2.attr("gid", rg.recieverGroupId);
						button2.click(function(){
							<portlet:namespace/>removeGroup($jq(this).attr("gid"));
						});
						
						span.append(button);
						span.append(button2);
						li.append(span);
						<portlet:namespace/>initBranch(li, rg.recieverGroupId);
						root.append(li);
					}
					content.append(root);
					setTimeout('<portlet:namespace/>myTree()', 150);
					
				} else {
					alert(Liferay.Language.get(exception.split(":")[1]));
					if (exception.split(":")[0].trim() == "com.liferay.portal.security.auth.PrincipalException.PrincipalException") {
						location.href = location.href;
					}
				}
			}
			);
}

function <portlet:namespace/>initBranch(li, groupId) {
	Liferay.Service.RecieverGroup.Reciever.getRecievers(
			{
				"recieverGroupId": groupId
			}, function(data) {
				var exp = data.exception;
				if (!exp) {
					var ul = $jq("<ul/>");
					for (var j = 0; j < data.length; j++) {
						var r = data[j];
						var li2 = $jq("<li/>");
						switch (r.recieverType) {
						case 1:
							li2.attr("id", r.recieverUserId);
							break;
						case 3:
							li2.attr("id", r.recieverUserName);
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
			}
		);
}

function <portlet:namespace/>myTree() {
	var tree = 	$jq("#nss_jstree").jstree({
			"core": {"animation": 0},
			"themes" : {
				"theme" : "classic",
				"dots" : true,
				"icons" : false
			},
			 "plugins" : [ "themes", "html_data", "checkbox" ]
		});
	<portlet:namespace/>checkedEvent();
	tree.fadeIn(1000);
}

function <portlet:namespace/>checkedEvent() {
	var tree = $jq("#nss_jstree");
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

function <portlet:namespace/>removeGroup(groupId) {
	var del = confirm('<liferay-ui:message key="ban-muon-xoa-luong-nay"/>');
	if (!del) {
		return;
	}
	Liferay.Service.RecieverGroup.RecieverGroup.deleteRecieverGroup(
			{
				"recieverGroupId": groupId
			}, function (json) {
				var exception = json.exception;
				if (!exception) {
					try {
						setTimeout('<portlet:namespace/>initTree()', 150);						
					}catch (err){}
				} else {
					alert(Liferay.Language.get(exception.split(":")[1]));
					if (exception.split(":")[0].trim() == "com.liferay.portal.security.auth.PrincipalException.PrincipalException") {
						location.href = location.href;
					} else {
						setTimeout('<portlet:namespace/>initTree()', 150);
					}
				}
			}
			);
}

$jq(function(){
	<portlet:namespace/>initTree();
});
</script>
<style type="text/css">
#nss_jstree li.branch{
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
