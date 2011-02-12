<%@ include file="/html/portlet/ext/meeting_calendar/init.jsp" %>
<div id="boxcontent">
<div id="tabs">
	<ul>
		<li><a href="#tabs-1"><liferay-ui:message key="room-resource"/></a></li>
		<li><a href="#tabs-2"><liferay-ui:message key="car-resource"/></a></li>
	</ul>
	<div id="tabs-1">
		<input type="text" id="<portlet:namespace/>roomResource" title='<liferay-ui:message key="nhap-ten-phong"/>'/><input id="<portlet:namespace/>roomResourceButton" type="button" value='<liferay-ui:message key="add"/>'/>
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
			<thead>
				<tr class="portlet-section-header results-header" >
					<td width="30px"><liferay-ui:message key="stt"/></td>
					<td width="60%"><liferay-ui:message key="room-name"/></td>
					<td></td>
				</tr>
			</thead>
			<tbody id="room-resource-container">
				<tr><td colspan="3" align="center"><liferay-ui:message key="no-content-to-display"/></td></tr>
			</tbody>
		</table>
	</div>
	<div id="tabs-2">
	<input type="text" id="<portlet:namespace/>carResourceName" title='<liferay-ui:message key="nhap-ten-xe"/>'/>
	<input type="text" id="<portlet:namespace/>carResourceCode" title='<liferay-ui:message key="nhap-bien-so-xe"/>'/>
	<input id="<portlet:namespace/>carResourceButton" type="button" value='<liferay-ui:message key="add"/>'/>
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
			<thead>
				<tr class="portlet-section-header results-header" >
					<td width="30px"><liferay-ui:message key="stt"/></td>
					<td width="30%"><liferay-ui:message key="car-name"/></td>
					<td width="30%"><liferay-ui:message key="car-code"/></td>
					<td></td>
				</tr>
			</thead>
			<tbody id="car-resource-container">
				<tr><td colspan="4" align="center"><liferay-ui:message key="no-content-to-display"/></td></tr>
			</tbody>
		</table>
	</div>
</div>
</div>
<script type="text/javascript">
function <portlet:namespace/>initRoomTable() {
	Liferay.Service.MeetingCal.RoomResource.getRoomResources({},function(data){
		var exception = data.exception;
		var container = $jq("#room-resource-container");
		if (!exception) {
			if (data.length > 0) {
				container.empty();
				for (var i = 0; i < data.length; i++) {
					var room = data[i];
					var tr = $jq("<tr class='results-row'/>");
					if (i % 2 == 0) {
						tr.addClass("tr_two");
					}
					var td0 = $jq("<td align='center'/>")
					td0.text(i+1);
					var td1 = $jq("<td/>")
					var span = $jq("<span class='input room_rsrc'/>");
					span.text(room.roomName);
					span.attr("id", room.roomId);
					td1.append(span);
					var td2 = $jq("<td align='center'/>");
					var button = $jq("<img/>");
					button.attr("src", "/html/images/imgdelete.png");
					button.attr("room", room.roomId);
					button.click(function(){
						<portlet:namespace/>deleteRoom($jq(this).attr("room"));
					});
					td2.append(button);
					
					tr.append(td0);
					tr.append(td1);
					tr.append(td2);
					container.append(tr);
				}
			} else {
				container.empty().append('<tr><td colspan="3" align="center"><liferay-ui:message key="no-content-to-display"/></td></tr>');
			}
		} else {
		}
	});
}

function <portlet:namespace/>initCarTable() {
	Liferay.Service.MeetingCal.CarResource.getCarResources({}, function(data){
		var exception = data.exception;
		var container = $jq("#car-resource-container");
		if (!exception) {
			if (data.length > 0) {
				container.empty();
				for (var i = 0; i < data.length; i++) {
					var carRes = data[i];
					var tr = $jq("<tr class='results-row'/>");
					if (i % 2 == 0) {
						tr.addClass("tr_two");
					}
					var td0 = $jq("<td align='center'/>")
					td0.text(container.find("tr").length + 1);
					
					var td1 = $jq("<td/>")
					var span1 = $jq("<span class='input car_rsrc_name'/>");
					span1.text(carRes.carName);
					span1.attr("id", carRes.carId);
					td1.append(span1);
					
					var td2 = $jq("<td/>");
					var span2 = $jq("<span class='input car_rsrc_code'/>");
					span2.text(carRes.carCode);
					span2.attr("id", carRes.carId);
					td2.append(span2);
					
					var td3 = $jq("<td align='center'/>");
					var button = $jq("<img/>");
					button.attr("src", "/html/images/imgdelete.png");
					button.attr("car", carRes.carId);
					button.click(function(){
						<portlet:namespace/>deleteCar($jq(this).attr("car"));
					});
					td3.append(button);
					
					tr.append(td0);
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					container.append(tr);
				}
			} else {
				container.empty().append('<tr><td colspan="4" align="center"><liferay-ui:message key="no-content-to-display"/></td></tr>');
			}
		} else {
			
		}
	});
}

function <portlet:namespace/>deleteRoom(roomId) {
	var del = confirm('<liferay-ui:message key="ban-muon-xoa-phong-nay"/>?');
	if (del) {
		Liferay.Service.MeetingCal.RoomResource.deleteRoomResource({
			'roomId': roomId
		},function(data){
			var exception = data.exception;
			if (exception) {
				alert(Liferay.Language.get(exception.split(':')[1].trim()) + ' ');
			} else {
				<portlet:namespace/>initRoomTable();
			}
		});
		
	}
}
function <portlet:namespace/>deleteCar(carId) {
	var del = confirm('<liferay-ui:message key="ban-muon-xoa-xe-nay"/>?');
	if (del) {
		Liferay.Service.MeetingCal.CarResource.deleteCarResource({
			'carId': carId
		},function(data){
			var exception = data.exception;
			if (exception) {
				alert(Liferay.Language.get(exception.split(':')[1].trim()) + ' ');
			} else {
				<portlet:namespace/>initCarTable();
			}
		});
		
	}
}

function <portlet:namespace/>updateRoomResource(roomId, roomName, description) {
	Liferay.Service.MeetingCal.RoomResource.updateResource({
		'roomId': roomId,
		'roomName': roomName,
		'description': description
	}, function(data){
		var exception = data.exception;
		if (!exception) {
			var container = $jq("#room-resource-container");
			if (container.find("td").length == 1) {
				container.empty();
			}
			var room = data;
			var tr = $jq("<tr class='results-row'/>");
			if (container.find("tr").length % 2 == 0) {
				tr.addClass("tr_two");
			}
			var td0 = $jq("<td align='center'/>")
			td0.text(container.find("tr").length + 1);
			var td1 = $jq("<td/>")
			var span = $jq("<span class='input room_rsrc'/>");
			span.text(room.roomName);
			span.attr("id", room.roomId);
			td1.append(span);
			var td2 = $jq("<td align='center'/>");
			var button = $jq("<img/>");
			button.attr("src", "/html/images/imgdelete.png");
			button.attr("room", room.roomId);
			button.click(function(){
				<portlet:namespace/>deleteRoom($jq(this).attr("room"));
			});
			td2.append(button);
			
			tr.append(td0);
			tr.append(td1);
			tr.append(td2);
			container.append(tr);
			$jq("#<portlet:namespace/>roomResource").val('').blur();
		} else {
			alert(Liferay.Language.get(exception.split(':')[1].trim()) + ' ');
		}
	});
}

function <portlet:namespace/>updateCarResource(carId, carCode, carName, description) {
	Liferay.Service.MeetingCal.CarResource.updateCarResource({
		'carId': carId,
		'carCode': carCode,
		'carName': carName,
		'description': description
	},function(data){
		var exception = data.exception;
		if (!exception) {
			var container = $jq("#car-resource-container");
			if (container.find("td").length == 1) {
				container.empty();
			}
			var carRes = data;
			var tr = $jq("<tr class='results-row'/>");
			if (container.find("tr").length % 2 == 0) {
				tr.addClass("tr_two");
			}
			var td0 = $jq("<td align='center'/>")
			td0.text(container.find("tr").length + 1);
			
			var td1 = $jq("<td/>")
			var span1 = $jq("<span class='input car_rsrc_name'/>");
			span1.text(carRes.carName);
			span1.attr("id", 'name' + carRes.carId);
			td1.append(span1);
			
			var td2 = $jq("<td/>");
			var span2 = $jq("<span class='input car_rsrc_code'/>");
			span2.text(carRes.carCode);
			span2.attr("id", 'code' + carRes.carId);
			td2.append(span2);
			
			var td3 = $jq("<td align='center'/>");
			var button = $jq("<img/>");
			button.attr("src", "/html/images/imgdelete.png");
			button.attr("car", carRes.carId);
			button.click(function(){
				<portlet:namespace/>deleteCar($jq(this).attr("car"));
			});
			td3.append(button);
			
			tr.append(td0);
			tr.append(td1);
			tr.append(td2);
			tr.append(td3);
			container.append(tr);
			$jq("#<portlet:namespace/>carResourceName").val('').blur();
			$jq("#<portlet:namespace/>carResourceCode").val('').blur();
		} else {
			alert(Liferay.Language.get(exception.split(':')[1].trim()) + ' ');
		}
	});
}

$jq(function(){
	$jq("#<portlet:namespace/>roomResource, #<portlet:namespace/>carResourceName, #<portlet:namespace/>carResourceCode").blur(function(){
		$jq(this).val($jq(this).val().trim());
	});
	$jq("#<portlet:namespace/>roomResourceButton").click(function(){
		var input = $jq("#<portlet:namespace/>roomResource");
		if (input.val().length == 0) {
			alert(Liferay.Language.get("xin-nhap-ten-phong-muon-them"));
			input.focus();
			return;
		} else {
			<portlet:namespace/>updateRoomResource(-1, input.val(), "");
		}
	});
	$jq("#<portlet:namespace/>roomResource").keyup(function(event){
		if (event.keyCode == $jq.ui.keyCode.ENTER) {
			var input = $jq("#<portlet:namespace/>roomResource");
			if (input.val().length == 0) {
				alert(Liferay.Language.get("xin-nhap-ten-phong-muon-them"));
				input.focus();
				return;
			} else {
				<portlet:namespace/>updateRoomResource(-1, input.val(), "");
			}
		}
	});
	$jq("#<portlet:namespace/>carResourceButton").click(function(){
		var name = $jq("#<portlet:namespace/>carResourceName");
		var code = $jq("#<portlet:namespace/>carResourceCode");
		if (name.val().length == 0) {
			alert(Liferay.Language.get("xin-nhap-ten-xe-muon-them"));
			name.focus();
			return;
		} else if (code.val().length == 0) {
			alert(Liferay.Language.get("xin-nhap-bien-so-xe-muon-them"));
			code.focus();
			return;
		} else {
			<portlet:namespace/>updateCarResource(-1, code.val(), name.val(), "");
		}
	});
	$jq("#<portlet:namespace/>carResourceName, #<portlet:namespace/>carResourceCode").keyup(function(event){
		if (event.keyCode == $jq.ui.keyCode.ENTER) {
			var name = $jq("#<portlet:namespace/>carResourceName");
			var code = $jq("#<portlet:namespace/>carResourceCode");
			if (name.val().length == 0) {
				alert(Liferay.Language.get("xin-nhap-ten-xe-muon-them"));
				name.focus();
				return;
			} else if (code.val().length == 0) {
				alert(Liferay.Language.get("xin-nhap-bien-so-xe-muon-them"));
				code.focus();
				return;
			} else {
				<portlet:namespace/>updateCarResource(-1, code.val(), name.val(), "");
			}
		}
	});
	$jq("#tabs").tabs();
	<portlet:namespace/>initRoomTable();
	<portlet:namespace/>initCarTable();
	$jq('span.input').live('click', function(){
		var ele = $jq(this);
		var id = ele.attr('id');
		var name = ele.text();
		var input = $jq("<input type='text'/>");
		input.attr('id', id);
		input.val(name);
		input.attr('class', ele.attr('class'));
		input.removeClass('input');
		input.insertBefore(ele);
		ele.remove();
		input.focus();
	});
	$jq('input.room_rsrc').live('blur keyup', function(event){
		var ele = $jq(this);
		if (event.type == 'focusout' || event.keyCode == $jq.ui.keyCode.ENTER) {
			Liferay.Service.MeetingCal.RoomResource.updateResource({
				'roomId': ele.attr('id'),
				'roomName': ele.val().trim(),
				'description': ''
			}, function(data){
				var exception = data.exception;
				if (!exception) {
					var span = $jq("<span class='input room_rsrc'/>");
					span.attr('id', data.roomId);
					span.text(data.roomName);
					span.insertBefore(ele);
					ele.remove();
				} else {
					ele.focus();
					var span = $jq("<span class='error'/>");
					span.insertAfter(ele);
					span.text(Liferay.Language.get(exception.split(':')[1].trim()) + ' ');
					span.fadeIn(30);
					setTimeout(function(){
						span.fadeOut(1000, function(){
							$jq(this).remove();
						});
					},2000);
				}
			});
		}
	});
	$jq('input.car_rsrc_name').live('blur keyup', function(event){
		var ele = $jq(this);
		if (event.type == 'focusout' || event.keyCode == $jq.ui.keyCode.ENTER) {
			Liferay.Service.MeetingCal.CarResource.updateCarResource({
				'carId': ele.attr('id'),
				'carCode': null,
				'carName': ele.val().trim(),
				'description': null
			},function(data){
				var exception = data.exception;
				if (!exception) {
					var span = $jq("<span class='input car_rsrc_name'/>");
					span.attr('id', data.carId);
					span.text(data.carName);
					span.insertBefore(ele);
					ele.remove();
				} else {
					ele.focus();
					var span = $jq("<span class='error'/>");
					span.insertAfter(ele);
					span.text(Liferay.Language.get(exception.split(':')[1].trim()) + ' ');
					span.fadeIn(30);
					setTimeout(function(){
						span.fadeOut(1000, function(){
							$jq(this).remove();
						});
					},2000);
				}
			});
		}
	});
	$jq('input.car_rsrc_code').live('blur keyup', function(event){
		var ele = $jq(this);
		if (event.type == 'focusout' || event.keyCode == $jq.ui.keyCode.ENTER) {
			Liferay.Service.MeetingCal.CarResource.updateCarResource({
				'carId': ele.attr('id'),
				'carCode': ele.val().trim(),
				'carName': null,
				'description': null
			},function(data){
				var exception = data.exception;
				if (!exception) {
					var span = $jq("<span class='input car_rsrc_name'/>");
					span.attr('id', data.carId);
					span.text(data.carCode);
					span.insertBefore(ele);
					ele.remove();
				} else {
					ele.focus();
					var span = $jq("<span class='error'/>");
					span.insertAfter(ele);
					span.text(Liferay.Language.get(exception.split(':')[1].trim()) + ' ');
					span.fadeIn(30);
					setTimeout(function(){
						span.fadeOut(1000, function(){
							$jq(this).remove();
						});
					},2000);
				}
			});
		}
	});
	$jq("#tabs input[type=text]").hint({hintClass: 'i'});
	$jq("#tabs td").live('click', function(){
		$jq(this).find('span').click();
	});
	/*$jq('span.input').each(function(){
		$jq(this).parent().live('click', function(){
			$jq(this).find('span').click();
		});
	});*/
});
</script>
<style type="text/css">
.input:HOVER{ border: 1px solid #7BD5EB; padding: 5px; background: #FFF;}
</style>