Liferay.Service.register("Liferay.Service.JournalWorkflow", "com.nss.portlet.journalworkflow.service");

Liferay.Service.register("Liferay.Service.Reports", "com.ext.portlet.reports.service");

Liferay.Service.register("Liferay.Service.VanBanPhapQuy", "com.nss.portlet.van_ban_phap_quy.service");

Liferay.Service.register("Liferay.Service.LinhVucVanBan", "com.nss.portlet.linh_vuc_van_ban.service");

Liferay.Service.register("Liferay.Service.LoaiVanBan", "com.nss.portlet.loai_van_ban.service");


Liferay.Service.register("Liferay.Service.Partner", "com.nss.portlet.partner.service");

Liferay.Service.register("Liferay.Service.LienKetWebsite", "com.nss.portlet.link.service");

Liferay.Service.register("Liferay.Service.QuangCao", "com.nss.portlet.adv.service");

Liferay.Service.register("Liferay.Service.CauHoiQA", "com.nss.portlet.qa_cau_hoi.service");

Liferay.Service.register("Liferay.Service.QAChuDeCauHoi", "com.nss.portlet.qa_chu_de.service");

Liferay.Service.register("Liferay.Service.QAPhanQuyen", "com.nss.portlet.qa_phan_quyen.service");

Liferay.Service.register("Liferay.Service.CauTraLoiQA", "com.nss.portlet.qa_cau_tra_loi.service");

Liferay.Service.register("Liferay.Service.MB", "com.liferay.portlet.messageboards.service");

Liferay.Service.registerClass(
	Liferay.Service.MB, "MBCategory",
	{
		addCategory: true,
		updateCategory: true,
		deleteCategory: true,
		getCategory: true,
		getCategories: true,
		getCategoriesCount: true,
		subscribeCategory: true,
		unsubscribeCategory: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.MB, "MBMessage",
	{
		addDiscussionMessage: true,
		addMessage: true,
		deleteDiscussionMessage: true,
		deleteMessage: true,
		getCategoryMessages: true,
		getCategoryMessagesCount: true,
		getMessage: true,
		getMessageDisplay: true,
		subscribeMessage: true,
		unsubscribeMessage: true,
		updateDiscussionMessage: true,
		updateMessage: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.MB, "MBThread",
	{
		deleteThread: true,
		moveThread: true,
		splitThread: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.MB, "MBBan",
	{
		addBan: true,
		deleteBan: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.MB, "MBMessageFlag",
	{
		addAnswerFlag: true,
		deleteAnswerFlag: true
	}
);

Liferay.Service.register("Liferay.Service.MediaChuDe", "com.nss.portlet.media_chu_de.service");

Liferay.Service.register("Liferay.Service.MediaLibrary", "com.nss.portlet.media_library.service");

Liferay.Service.register("Liferay.Service.DigitalSignature", "com.nss.portlet.digitalsignature.service");

Liferay.Service.register("Liferay.Service.ImageSigner", "com.nss.portlet.image_signer.service");

Liferay.Service.register("Liferay.Service.managementworkflowjournal", "com.nss.portlet.managementworkflowjournal.service");

Liferay.Service.register("Liferay.Service.department", "com.nss.portlet.department.service");

Liferay.Service.register("Liferay.Service.position", "com.nss.portlet.position.service");

Liferay.Service.register("Liferay.Service.Field", "com.nss.portlet.documentfield.service");

Liferay.Service.register("Liferay.Service.PhoneBook", "com.nss.portlet.phone_book.service");