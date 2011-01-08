

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

Liferay.Service.RecieverGroup = {
	servicePackage: "com.sgs.portlet.recievergroup.service.http."
};

Liferay.Service.RecieverGroup.RecieverGroup = {
	serviceClassName: Liferay.Service.RecieverGroup.servicePackage + "RecieverGroup" + Liferay.Service.classNameSuffix,

	addRecieverToGroup: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "addRecieverToGroup";

		return Liferay.Service.ajax(params, callback);
	},

	deleteRecieverGroup: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "deleteRecieverGroup";

		return Liferay.Service.ajax(params, callback);
	},

	getRecieverGroups: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getRecieverGroups";

		return Liferay.Service.ajax(params, callback);
	},

	removeRecieverFromGroup: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "removeRecieverFromGroup";

		return Liferay.Service.ajax(params, callback);
	},

	updateRecieverGroup: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "updateRecieverGroup";

		return Liferay.Service.ajax(params, callback);
	}
};

Liferay.Service.RecieverGroup.Reciever = {
	serviceClassName: Liferay.Service.RecieverGroup.servicePackage + "Reciever" + Liferay.Service.classNameSuffix,

	addReciever: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "addReciever";

		return Liferay.Service.ajax(params, callback);
	},

	getReciever: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getReciever";

		return Liferay.Service.ajax(params, callback);
	},

	getRecievers: function(params, callback) {
		params.serviceClassName = this.serviceClassName;
		params.serviceMethodName = "getRecievers";

		return Liferay.Service.ajax(params, callback);
	}
};

Liferay.Service.IssuingPlace = {
	servicePackage: "com.sgs.portlet.pmlissuingplace.service.http."
};