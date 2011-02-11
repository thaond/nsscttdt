

Liferay.Service.QA = {
	servicePackage: "com.sgs.portlet.qa.service.http."
};

Liferay.Service.Cal = {
	servicePackage: "com.sgs.portlet.calendar.service.http."
};

Liferay.Service.Calendar = {
	servicePackage: "com.sgs.portlet.calendar.service.http."
};

Liferay.Service.PmlDocument = {
	servicePackage: "com.sgs.portlet.document.service.http."
};

Liferay.Service.IssuingPlace = {
	servicePackage: "com.sgs.portlet.pmlissuingplace.service.http."
};

Liferay.Service.ReportRegistryWork = {
	servicePackage: "com.sgs.portlet.report_registry_work.service.http."
};

Liferay.Service.DocumentManager = {
	servicePackage: "com.sgs.portlet.document_manager.service.http."
};

Liferay.Service.ReceiverGroup = {
	servicePackage: "com.sgs.portlet.receivergroup.service.http."
};

Liferay.Service.ReceiverGroup.ReceiverGroup = {
	serviceClassName: Liferay.Service.ReceiverGroup.servicePackage + "ReceiverGroup" + Liferay.Service.classNameSuffix,

	addReceiverToGroup: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "addReceiverToGroup";

		return Liferay.Service.ajax(params, callback);
	},

	deleteReceiverGroup: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "deleteReceiverGroup";

		return Liferay.Service.ajax(params, callback);
	},

	getReceiverGroups: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getReceiverGroups";

		return Liferay.Service.ajax(params, callback);
	},

	removeReceiverFromGroup: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "removeReceiverFromGroup";

		return Liferay.Service.ajax(params, callback);
	},

	updateReceiverGroup: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "updateReceiverGroup";

		return Liferay.Service.ajax(params, callback);
	}
};

Liferay.Service.ReceiverGroup.Receiver = {
	serviceClassName: Liferay.Service.ReceiverGroup.servicePackage + "Receiver" + Liferay.Service.classNameSuffix,

	addReceiver: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "addReceiver";

		return Liferay.Service.ajax(params, callback);
	},

	getReceiver: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getReceiver";

		return Liferay.Service.ajax(params, callback);
	},

	getReceivers: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getReceivers";

		return Liferay.Service.ajax(params, callback);
	}
};

Liferay.Service.HolidayCalendar = {
	servicePackage: "com.sgs.portlet.holiday_calendar.service.http."
};

Liferay.Service.MeetingCal = {
	servicePackage: "com.ext.portlet.meetingcalendar.service.http."
};

Liferay.Service.MeetingCal.MeetingCalendar = {
	serviceClassName: Liferay.Service.MeetingCal.servicePackage + "MeetingCalendar" + Liferay.Service.classNameSuffix,

	addEvent: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "addEvent";

		return Liferay.Service.ajax(params, callback);
	},

	deleteEvent: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "deleteEvent";

		return Liferay.Service.ajax(params, callback);
	},

	getEvent: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getEvent";

		return Liferay.Service.ajax(params, callback);
	},

	updateEvent: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "updateEvent";

		return Liferay.Service.ajax(params, callback);
	}
};

Liferay.Service.MeetingCal.PmlScreenCalendarHeight = {
	serviceClassName: Liferay.Service.MeetingCal.servicePackage + "PmlScreenCalendarHeight" + Liferay.Service.classNameSuffix,

	getScreenCalendarHeigth: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getScreenCalendarHeigth";

		return Liferay.Service.ajax(params, callback);
	}
};

Liferay.Service.MeetingCal.RoomResource = {
	serviceClassName: Liferay.Service.MeetingCal.servicePackage + "RoomResource" + Liferay.Service.classNameSuffix,

	updateResource: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "updateResource";

		return Liferay.Service.ajax(params, callback);
	},

	getRoomResources: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getRoomResources";

		return Liferay.Service.ajax(params, callback);
	},

	deleteRoomResource: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "deleteRoomResource";

		return Liferay.Service.ajax(params, callback);
	}
};

Liferay.Service.MeetingCal.CarResource = {
	serviceClassName: Liferay.Service.MeetingCal.servicePackage + "CarResource" + Liferay.Service.classNameSuffix,

	updateCarResource: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "updateCarResource";

		return Liferay.Service.ajax(params, callback);
	},

	getCarResources: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getCarResources";

		return Liferay.Service.ajax(params, callback);
	},

	deleteCarResource: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "deleteCarResource";

		return Liferay.Service.ajax(params, callback);
	}
};

Liferay.Service.pml_ho_so_cong_viec = {
	servicePackage: "com.sgs.portlet.pml_ho_so_cong_viec.service.http."
};

Liferay.Service.PmlDocumentReceipt = {
	servicePackage: "com.sgs.portlet.document.receipt.service.http."
};

Liferay.Service.PmlDocumentSend = {
	servicePackage: "com.sgs.portlet.document.send.service.http."
};

Liferay.Service.User = {
	servicePackage: "com.sgs.portlet.pmluser.service.http."
};