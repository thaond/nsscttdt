create table Account_ (
	accountId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentAccountId LONG,
	name VARCHAR(75) null,
	legalName VARCHAR(75) null,
	legalId VARCHAR(75) null,
	legalType VARCHAR(75) null,
	sicCode VARCHAR(75) null,
	tickerSymbol VARCHAR(75) null,
	industry VARCHAR(75) null,
	type_ VARCHAR(75) null,
	size_ VARCHAR(75) null
);

create table Address (
	addressId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	street1 VARCHAR(75) null,
	street2 VARCHAR(75) null,
	street3 VARCHAR(75) null,
	city VARCHAR(75) null,
	zip VARCHAR(75) null,
	regionId LONG,
	countryId LONG,
	typeId INTEGER,
	mailing BOOLEAN,
	primary_ BOOLEAN
);

create table AnnouncementsDelivery (
	deliveryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	type_ VARCHAR(75) null,
	email BOOLEAN,
	sms BOOLEAN,
	website BOOLEAN
);

create table AnnouncementsEntry (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	title VARCHAR(75) null,
	content STRING null,
	url STRING null,
	type_ VARCHAR(75) null,
	displayDate DATE null,
	expirationDate DATE null,
	priority INTEGER,
	alert BOOLEAN
);

create table AnnouncementsFlag (
	flagId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	entryId LONG,
	value INTEGER
);

create table BlogsCategory (
	categoryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentCategoryId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table BlogsEntry (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(150) null,
	urlTitle VARCHAR(150) null,
	content TEXT null,
	displayDate DATE null,
	draft BOOLEAN,
	allowTrackbacks BOOLEAN,
	trackbacks TEXT null
);

create table BlogsStatsUser (
	statsUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	entryCount INTEGER,
	lastPostDate DATE null,
	ratingsTotalEntries INTEGER,
	ratingsTotalScore DOUBLE,
	ratingsAverageScore DOUBLE
);

create table BookmarksEntry (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	name VARCHAR(300) null,
	url STRING null,
	comments STRING null,
	visits INTEGER,
	priority INTEGER
);

create table BookmarksFolder (
	uuid_ VARCHAR(75) null,
	folderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	parentFolderId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table CalEvent (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description STRING null,
	startDate DATE null,
	endDate DATE null,
	durationHour INTEGER,
	durationMinute INTEGER,
	allDay BOOLEAN,
	timeZoneSensitive BOOLEAN,
	type_ VARCHAR(75) null,
	repeating BOOLEAN,
	recurrence TEXT null,
	remindBy VARCHAR(75) null,
	firstReminder INTEGER,
	secondReminder INTEGER
);

create table ClassName_ (
	classNameId LONG not null primary key,
	value VARCHAR(200) null
);

create table Company (
	companyId LONG not null primary key,
	accountId LONG,
	webId VARCHAR(75) null,
	key_ TEXT null,
	virtualHost VARCHAR(75) null,
	mx VARCHAR(75) null,
	logoId LONG
);

create table CongViec (
	macv VARCHAR(75) not null primary key,
	tencv VARCHAR(75) null,
	linhvucid VARCHAR(75) null,
	nguoitao LONG,
	ngaytao DATE null,
	ngayhethan DATE null,
	nguoichidao LONG,
	doithuchien VARCHAR(75) null,
	ykienchidao VARCHAR(75) null,
	baocaochidao VARCHAR(75) null,
	chidaothem VARCHAR(75) null
);

create table Contact_ (
	contactId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	accountId LONG,
	parentContactId LONG,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	prefixId INTEGER,
	suffixId INTEGER,
	male BOOLEAN,
	birthday DATE null,
	smsSn VARCHAR(75) null,
	aimSn VARCHAR(75) null,
	facebookSn VARCHAR(75) null,
	icqSn VARCHAR(75) null,
	jabberSn VARCHAR(75) null,
	msnSn VARCHAR(75) null,
	mySpaceSn VARCHAR(75) null,
	skypeSn VARCHAR(75) null,
	twitterSn VARCHAR(75) null,
	ymSn VARCHAR(75) null,
	employeeStatusId VARCHAR(75) null,
	employeeNumber VARCHAR(75) null,
	jobTitle VARCHAR(100) null,
	jobClass VARCHAR(75) null,
	hoursOfOperation VARCHAR(75) null
);

create table Counter (
	name VARCHAR(75) not null primary key,
	currentId LONG
);

create table Country (
	countryId LONG not null primary key,
	name VARCHAR(75) null,
	a2 VARCHAR(75) null,
	a3 VARCHAR(75) null,
	number_ VARCHAR(75) null,
	idd_ VARCHAR(75) null,
	active_ BOOLEAN
);

create table CyrusUser (
	userId VARCHAR(75) not null primary key,
	password_ VARCHAR(75) not null
);

create table CyrusVirtual (
	emailAddress VARCHAR(75) not null primary key,
	userId VARCHAR(75) not null
);

create table DLFileEntry (
	uuid_ VARCHAR(75) null,
	fileEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	versionUserId LONG,
	versionUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	name VARCHAR(300) null,
	title VARCHAR(300) null,
	description STRING null,
	version DOUBLE,
	size_ INTEGER,
	readCount INTEGER,
	extraSettings TEXT null
);

create table DLFileRank (
	fileRankId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	folderId LONG,
	name VARCHAR(300) null
);

create table DLFileShortcut (
	uuid_ VARCHAR(75) null,
	fileShortcutId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	toFolderId LONG,
	toName VARCHAR(300) null
);

create table DLFileVersion (
	fileVersionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	folderId LONG,
	name VARCHAR(300) null,
	version DOUBLE,
	size_ INTEGER
);

create table DLFolder (
	uuid_ VARCHAR(75) null,
	folderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentFolderId LONG,
	name VARCHAR(100) null,
	description STRING null,
	lastPostDate DATE null
);

create table EmailAddress (
	emailAddressId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	address VARCHAR(75) null,
	typeId INTEGER,
	primary_ BOOLEAN
);

create table ExpandoColumn (
	columnId LONG not null primary key,
	tableId LONG,
	name VARCHAR(75) null,
	type_ INTEGER
);

create table ExpandoRow (
	rowId_ LONG not null primary key,
	tableId LONG,
	classPK LONG
);

create table ExpandoTable (
	tableId LONG not null primary key,
	classNameId LONG,
	name VARCHAR(75) null
);

create table ExpandoValue (
	valueId LONG not null primary key,
	tableId LONG,
	columnId LONG,
	rowId_ LONG,
	classNameId LONG,
	classPK LONG,
	data_ STRING null
);

create table Group_ (
	groupId LONG not null primary key,
	companyId LONG,
	creatorUserId LONG,
	classNameId LONG,
	classPK LONG,
	parentGroupId LONG,
	liveGroupId LONG,
	name VARCHAR(75) null,
	description STRING null,
	type_ INTEGER,
	typeSettings STRING null,
	friendlyURL VARCHAR(100) null,
	active_ BOOLEAN
);

create table Groups_Orgs (
	groupId LONG not null,
	organizationId LONG not null,
	primary key (groupId, organizationId)
);

create table Groups_Permissions (
	groupId LONG not null,
	permissionId LONG not null,
	primary key (groupId, permissionId)
);

create table Groups_Roles (
	groupId LONG not null,
	roleId LONG not null,
	primary key (groupId, roleId)
);

create table Groups_UserGroups (
	groupId LONG not null,
	userGroupId LONG not null,
	primary key (groupId, userGroupId)
);

create table IGFolder (
	uuid_ VARCHAR(75) null,
	folderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	parentFolderId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table IGImage (
	uuid_ VARCHAR(75) null,
	imageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	name VARCHAR(75) null,
	description STRING null,
	smallImageId LONG,
	largeImageId LONG,
	custom1ImageId LONG,
	custom2ImageId LONG
);

create table Image (
	imageId LONG not null primary key,
	modifiedDate DATE null,
	text_ TEXT null,
	type_ VARCHAR(75) null,
	height INTEGER,
	width INTEGER,
	size_ INTEGER
);

create table JournalArticle (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	resourcePrimKey LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	articleId VARCHAR(75) null,
	version DOUBLE,
	title VARCHAR(100) null,
	description STRING null,
	content TEXT null,
	type_ VARCHAR(75) null,
	structureId VARCHAR(75) null,
	templateId VARCHAR(75) null,
	displayDate DATE null,
	approved BOOLEAN,
	approvedByUserId LONG,
	approvedByUserName VARCHAR(75) null,
	approvedDate DATE null,
	expired BOOLEAN,
	expirationDate DATE null,
	reviewDate DATE null,
	indexable BOOLEAN,
	smallImage BOOLEAN,
	smallImageId LONG,
	smallImageURL VARCHAR(75) null
);

create table JournalArticleImage (
	articleImageId LONG not null primary key,
	groupId LONG,
	articleId VARCHAR(75) null,
	version DOUBLE,
	elName VARCHAR(75) null,
	languageId VARCHAR(75) null,
	tempImage BOOLEAN
);

create table JournalArticleResource (
	resourcePrimKey LONG not null primary key,
	groupId LONG,
	articleId VARCHAR(75) null
);

create table JournalContentSearch (
	contentSearchId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	privateLayout BOOLEAN,
	layoutId LONG,
	portletId VARCHAR(200) null,
	articleId VARCHAR(75) null
);

create table JournalFeed (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	feedId VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	type_ VARCHAR(75) null,
	structureId VARCHAR(75) null,
	templateId VARCHAR(75) null,
	rendererTemplateId VARCHAR(75) null,
	delta INTEGER,
	orderByCol VARCHAR(75) null,
	orderByType VARCHAR(75) null,
	targetLayoutFriendlyUrl VARCHAR(75) null,
	targetPortletId VARCHAR(75) null,
	contentField VARCHAR(75) null,
	feedType VARCHAR(75) null,
	feedVersion DOUBLE
);

create table JournalStructure (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	structureId VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	xsd TEXT null
);

create table JournalTemplate (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	templateId VARCHAR(75) null,
	structureId VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	xsl TEXT null,
	langType VARCHAR(75) null,
	cacheable BOOLEAN,
	smallImage BOOLEAN,
	smallImageId LONG,
	smallImageURL VARCHAR(75) null
);

create table Layout (
	plid LONG not null primary key,
	groupId LONG,
	companyId LONG,
	privateLayout BOOLEAN,
	layoutId LONG,
	parentLayoutId LONG,
	name STRING null,
	title STRING null,
	description STRING null,
	type_ VARCHAR(75) null,
	typeSettings TEXT null,
	hidden_ BOOLEAN,
	friendlyURL VARCHAR(100) null,
	iconImage BOOLEAN,
	iconImageId LONG,
	themeId VARCHAR(75) null,
	colorSchemeId VARCHAR(75) null,
	wapThemeId VARCHAR(75) null,
	wapColorSchemeId VARCHAR(75) null,
	css STRING null,
	priority INTEGER,
	dlFolderId LONG
);

create table LayoutSet (
	layoutSetId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	privateLayout BOOLEAN,
	logo BOOLEAN,
	logoId LONG,
	themeId VARCHAR(75) null,
	colorSchemeId VARCHAR(75) null,
	wapThemeId VARCHAR(75) null,
	wapColorSchemeId VARCHAR(75) null,
	css STRING null,
	pageCount INTEGER,
	virtualHost VARCHAR(75) null
);

create table ListType (
	listTypeId INTEGER not null primary key,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null
);

create table MBBan (
	banId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	banUserId LONG
);

create table MBCategory (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentCategoryId LONG,
	name VARCHAR(75) null,
	description STRING null,
	lastPostDate DATE null
);

create table MBDiscussion (
	discussionId LONG not null primary key,
	classNameId LONG,
	classPK LONG,
	threadId LONG
);

create table MBMessage (
	uuid_ VARCHAR(75) null,
	messageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryId LONG,
	threadId LONG,
	parentMessageId LONG,
	subject VARCHAR(75) null,
	body TEXT null,
	attachments BOOLEAN,
	anonymous BOOLEAN
);

create table MBMessageFlag (
	messageFlagId LONG not null primary key,
	userId LONG,
	messageId LONG,
	flag INTEGER
);

create table MBStatsUser (
	statsUserId LONG not null primary key,
	groupId LONG,
	userId LONG,
	messageCount INTEGER,
	lastPostDate DATE null
);

create table MBThread (
	threadId LONG not null primary key,
	categoryId LONG,
	rootMessageId LONG,
	messageCount INTEGER,
	viewCount INTEGER,
	lastPostByUserId LONG,
	lastPostDate DATE null,
	priority DOUBLE
);

create table MeetingCalComponent (
	mcalId LONG not null primary key,
	groupIds VARCHAR(75) null,
	startDate DATE null
);

create table MeetingCalendar (
	uuid_ VARCHAR(75) null,
	mcalId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	state INTEGER,
	place VARCHAR(75) null,
	place_diff VARCHAR(75) null,
	sponsor VARCHAR(75) null,
	component VARCHAR(75) null,
	note VARCHAR(75) null,
	userApproved LONG,
	dateApproved DATE null,
	moveMcalId LONG,
	repeatWeek BOOLEAN,
	filename VARCHAR(75) null,
	morning BOOLEAN,
	afternoon BOOLEAN,
	evening BOOLEAN,
	stt INTEGER,
	prior BOOLEAN
);

create table MeetingDetailWeek (
	mdweekId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	focus VARCHAR(75) null,
	note VARCHAR(75) null,
	receive VARCHAR(75) null,
	week INTEGER,
	year INTEGER
);

create table MembershipRequest (
	membershipRequestId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	groupId LONG,
	comments STRING null,
	replyComments STRING null,
	replyDate DATE null,
	replierUserId LONG,
	statusId INTEGER
);

create table Organization_ (
	organizationId LONG not null primary key,
	companyId LONG,
	parentOrganizationId LONG,
	name VARCHAR(100) null,
	location BOOLEAN,
	recursable BOOLEAN,
	regionId LONG,
	countryId LONG,
	statusId INTEGER,
	comments STRING null
);

create table OrgGroupPermission (
	organizationId LONG not null,
	groupId LONG not null,
	permissionId LONG not null,
	primary key (organizationId, groupId, permissionId)
);

create table OrgGroupRole (
	organizationId LONG not null,
	groupId LONG not null,
	roleId LONG not null,
	primary key (organizationId, groupId, roleId)
);

create table OrgLabor (
	orgLaborId LONG not null primary key,
	organizationId LONG,
	typeId INTEGER,
	sunOpen INTEGER,
	sunClose INTEGER,
	monOpen INTEGER,
	monClose INTEGER,
	tueOpen INTEGER,
	tueClose INTEGER,
	wedOpen INTEGER,
	wedClose INTEGER,
	thuOpen INTEGER,
	thuClose INTEGER,
	friOpen INTEGER,
	friClose INTEGER,
	satOpen INTEGER,
	satClose INTEGER
);

create table PML_Country (
	countryId VARCHAR(75) not null primary key,
	countryCode VARCHAR(75) null,
	countryName VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table PML_FILETYPE (
	fileTypeId VARCHAR(75) not null primary key,
	fileTypeCode VARCHAR(75) null,
	fileTypeName VARCHAR(75) null,
	fieldId VARCHAR(75) null,
	templateId VARCHAR(75) null,
	processTime VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null,
	currentReceiptNumber VARCHAR(75) null,
	receiptTemplate VARCHAR(75) null
);

create table PML_IDGENERATED (
	id LONG not null primary key,
	year VARCHAR(75) null,
	curvalue LONG
);

create table PML_IDTEMPLATE (
	templateId LONG not null primary key,
	format VARCHAR(75) null,
	startNumber VARCHAR(75) null,
	len LONG,
	description VARCHAR(75) null
);

create table PasswordPolicy (
	passwordPolicyId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	defaultPolicy BOOLEAN,
	name VARCHAR(75) null,
	description STRING null,
	changeable BOOLEAN,
	changeRequired BOOLEAN,
	minAge LONG,
	checkSyntax BOOLEAN,
	allowDictionaryWords BOOLEAN,
	minLength INTEGER,
	history BOOLEAN,
	historyCount INTEGER,
	expireable BOOLEAN,
	maxAge LONG,
	warningTime LONG,
	graceLimit INTEGER,
	lockout BOOLEAN,
	maxFailure INTEGER,
	lockoutDuration LONG,
	requireUnlock BOOLEAN,
	resetFailureCount LONG
);

create table PasswordPolicyRel (
	passwordPolicyRelId LONG not null primary key,
	passwordPolicyId LONG,
	classNameId LONG,
	classPK LONG
);

create table PasswordTracker (
	passwordTrackerId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	password_ VARCHAR(75) null
);

create table Permission_ (
	permissionId LONG not null primary key,
	companyId LONG,
	actionId VARCHAR(75) null,
	resourceId LONG
);

create table Phone (
	phoneId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	number_ VARCHAR(75) null,
	extension VARCHAR(75) null,
	typeId INTEGER,
	primary_ BOOLEAN
);

create table PluginSetting (
	pluginSettingId LONG not null primary key,
	companyId LONG,
	pluginId VARCHAR(75) null,
	pluginType VARCHAR(75) null,
	roles STRING null,
	active_ BOOLEAN
);

create table PollsChoice (
	uuid_ VARCHAR(75) null,
	choiceId LONG not null primary key,
	questionId LONG,
	name VARCHAR(75) null,
	description VARCHAR(1000) null
);

create table PollsQuestion (
	uuid_ VARCHAR(75) null,
	questionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(500) null,
	description STRING null,
	expirationDate DATE null,
	lastVoteDate DATE null
);

create table PollsVote (
	voteId LONG not null primary key,
	userId LONG,
	questionId LONG,
	choiceId LONG,
	voteDate DATE null
);

create table Portlet (
	id_ LONG not null primary key,
	companyId LONG,
	portletId VARCHAR(200) null,
	roles STRING null,
	active_ BOOLEAN
);

create table PortletItem (
	portletItemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	portletId VARCHAR(75) null,
	classNameId LONG
);

create table PortletPreferences (
	portletPreferencesId LONG not null primary key,
	ownerId LONG,
	ownerType INTEGER,
	plid LONG,
	portletId VARCHAR(200) null,
	preferences TEXT null
);

create table RatingsEntry (
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	score DOUBLE
);

create table RatingsStats (
	statsId LONG not null primary key,
	classNameId LONG,
	classPK LONG,
	totalEntries INTEGER,
	totalScore DOUBLE,
	averageScore DOUBLE
);

create table ReceiverGroups_Receivers (
	receiverGroupId LONG not null,
	receiverId LONG not null,
	primary key (receiverGroupId, receiverId)
);

create table RecieverGroups_Recievers (
	recieverGroupId LONG not null,
	recieverId LONG not null,
	primary key (recieverGroupId, recieverId)
);

create table Region (
	regionId LONG not null primary key,
	countryId LONG,
	regionCode VARCHAR(75) null,
	name VARCHAR(75) null,
	active_ BOOLEAN
);

create table Release_ (
	releaseId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	buildNumber INTEGER,
	buildDate DATE null,
	verified BOOLEAN
);

create table ReportsEntry (
	entryId VARCHAR(75) not null primary key,
	companyId VARCHAR(75) null,
	userId VARCHAR(75) null,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table Resource_ (
	resourceId LONG not null primary key,
	codeId LONG,
	primKey VARCHAR(300) null
);

create table ResourceCode (
	codeId LONG not null primary key,
	companyId LONG,
	name VARCHAR(300) null,
	scope INTEGER
);

create table Role_ (
	roleId LONG not null primary key,
	companyId LONG,
	classNameId LONG,
	classPK LONG,
	name VARCHAR(75) null,
	description STRING null,
	type_ INTEGER
);

create table Roles_Permissions (
	roleId LONG not null,
	permissionId LONG not null,
	primary key (roleId, permissionId)
);

create table SCFrameworkVersi_SCProductVers (
	frameworkVersionId LONG not null,
	productVersionId LONG not null,
	primary key (frameworkVersionId, productVersionId)
);

create table SCFrameworkVersion (
	frameworkVersionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	url STRING null,
	active_ BOOLEAN,
	priority INTEGER
);

create table SCLicense (
	licenseId LONG not null primary key,
	name VARCHAR(75) null,
	url STRING null,
	openSource BOOLEAN,
	active_ BOOLEAN,
	recommended BOOLEAN
);

create table SCLicenses_SCProductEntries (
	licenseId LONG not null,
	productEntryId LONG not null,
	primary key (licenseId, productEntryId)
);

create table SCProductEntry (
	productEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null,
	tags VARCHAR(300) null,
	shortDescription STRING null,
	longDescription STRING null,
	pageURL STRING null,
	author VARCHAR(75) null,
	repoGroupId VARCHAR(75) null,
	repoArtifactId VARCHAR(75) null
);

create table SCProductScreenshot (
	productScreenshotId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	productEntryId LONG,
	thumbnailId LONG,
	fullImageId LONG,
	priority INTEGER
);

create table SCProductVersion (
	productVersionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	productEntryId LONG,
	version VARCHAR(75) null,
	changeLog STRING null,
	downloadPageURL STRING null,
	directDownloadURL VARCHAR(2000) null,
	repoStoreArtifact BOOLEAN
);

create table ServiceComponent (
	serviceComponentId LONG not null primary key,
	buildNamespace VARCHAR(75) null,
	buildNumber LONG,
	buildDate LONG,
	data_ TEXT null
);

create table ShoppingCart (
	cartId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	itemIds STRING null,
	couponCodes VARCHAR(75) null,
	altShipping INTEGER,
	insure BOOLEAN
);

create table ShoppingCategory (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentCategoryId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table ShoppingCoupon (
	couponId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	startDate DATE null,
	endDate DATE null,
	active_ BOOLEAN,
	limitCategories STRING null,
	limitSkus STRING null,
	minOrder DOUBLE,
	discount DOUBLE,
	discountType VARCHAR(75) null
);

create table ShoppingItem (
	itemId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryId LONG,
	sku VARCHAR(75) null,
	name VARCHAR(200) null,
	description STRING null,
	properties STRING null,
	fields_ BOOLEAN,
	fieldsQuantities STRING null,
	minQuantity INTEGER,
	maxQuantity INTEGER,
	price DOUBLE,
	discount DOUBLE,
	taxable BOOLEAN,
	shipping DOUBLE,
	useShippingFormula BOOLEAN,
	requiresShipping BOOLEAN,
	stockQuantity INTEGER,
	featured_ BOOLEAN,
	sale_ BOOLEAN,
	smallImage BOOLEAN,
	smallImageId LONG,
	smallImageURL VARCHAR(75) null,
	mediumImage BOOLEAN,
	mediumImageId LONG,
	mediumImageURL VARCHAR(75) null,
	largeImage BOOLEAN,
	largeImageId LONG,
	largeImageURL VARCHAR(75) null
);

create table ShoppingItemField (
	itemFieldId LONG not null primary key,
	itemId LONG,
	name VARCHAR(75) null,
	values_ STRING null,
	description STRING null
);

create table ShoppingItemPrice (
	itemPriceId LONG not null primary key,
	itemId LONG,
	minQuantity INTEGER,
	maxQuantity INTEGER,
	price DOUBLE,
	discount DOUBLE,
	taxable BOOLEAN,
	shipping DOUBLE,
	useShippingFormula BOOLEAN,
	status INTEGER
);

create table ShoppingOrder (
	orderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	number_ VARCHAR(75) null,
	tax DOUBLE,
	shipping DOUBLE,
	altShipping VARCHAR(75) null,
	requiresShipping BOOLEAN,
	insure BOOLEAN,
	insurance DOUBLE,
	couponCodes VARCHAR(75) null,
	couponDiscount DOUBLE,
	billingFirstName VARCHAR(75) null,
	billingLastName VARCHAR(75) null,
	billingEmailAddress VARCHAR(75) null,
	billingCompany VARCHAR(75) null,
	billingStreet VARCHAR(75) null,
	billingCity VARCHAR(75) null,
	billingState VARCHAR(75) null,
	billingZip VARCHAR(75) null,
	billingCountry VARCHAR(75) null,
	billingPhone VARCHAR(75) null,
	shipToBilling BOOLEAN,
	shippingFirstName VARCHAR(75) null,
	shippingLastName VARCHAR(75) null,
	shippingEmailAddress VARCHAR(75) null,
	shippingCompany VARCHAR(75) null,
	shippingStreet VARCHAR(75) null,
	shippingCity VARCHAR(75) null,
	shippingState VARCHAR(75) null,
	shippingZip VARCHAR(75) null,
	shippingCountry VARCHAR(75) null,
	shippingPhone VARCHAR(75) null,
	ccName VARCHAR(75) null,
	ccType VARCHAR(75) null,
	ccNumber VARCHAR(75) null,
	ccExpMonth INTEGER,
	ccExpYear INTEGER,
	ccVerNumber VARCHAR(75) null,
	comments STRING null,
	ppTxnId VARCHAR(75) null,
	ppPaymentStatus VARCHAR(75) null,
	ppPaymentGross DOUBLE,
	ppReceiverEmail VARCHAR(75) null,
	ppPayerEmail VARCHAR(75) null,
	sendOrderEmail BOOLEAN,
	sendShippingEmail BOOLEAN
);

create table ShoppingOrderItem (
	orderItemId LONG not null primary key,
	orderId LONG,
	itemId VARCHAR(75) null,
	sku VARCHAR(75) null,
	name VARCHAR(200) null,
	description STRING null,
	properties STRING null,
	price DOUBLE,
	quantity INTEGER,
	shippedDate DATE null
);

create table SocialActivity (
	activityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	mirrorActivityId LONG,
	classNameId LONG,
	classPK LONG,
	type_ INTEGER,
	extraData STRING null,
	receiverUserId LONG
);

create table SocialRelation (
	uuid_ VARCHAR(75) null,
	relationId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	userId1 LONG,
	userId2 LONG,
	type_ INTEGER
);

create table SocialRequest (
	uuid_ VARCHAR(75) null,
	requestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	type_ INTEGER,
	extraData STRING null,
	receiverUserId LONG,
	status INTEGER
);

create table Subscription (
	subscriptionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	frequency VARCHAR(75) null
);

create table TagsAsset (
	assetId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	startDate DATE null,
	endDate DATE null,
	publishDate DATE null,
	expirationDate DATE null,
	mimeType VARCHAR(75) null,
	title VARCHAR(300) null,
	description STRING null,
	summary STRING null,
	url STRING null,
	height INTEGER,
	width INTEGER,
	priority DOUBLE,
	viewCount INTEGER
);

create table TagsAssets_TagsEntries (
	assetId LONG not null,
	entryId LONG not null,
	primary key (assetId, entryId)
);

create table TagsEntry (
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table TagsProperty (
	propertyId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	entryId LONG,
	key_ VARCHAR(75) null,
	value VARCHAR(300) null
);

create table TagsSource (
	sourceId LONG not null primary key,
	parentSourceId LONG,
	name VARCHAR(75) null,
	acronym VARCHAR(75) null
);

create table TasksProposal (
	proposalId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	publishDate DATE null,
	dueDate DATE null
);

create table TasksReview (
	reviewId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	proposalId LONG,
	assignedByUserId LONG,
	assignedByUserName VARCHAR(75) null,
	stage INTEGER,
	completed BOOLEAN,
	rejected BOOLEAN
);

create table User_ (
	uuid_ VARCHAR(75) null,
	userId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	defaultUser BOOLEAN,
	contactId LONG,
	password_ VARCHAR(75) null,
	passwordEncrypted BOOLEAN,
	passwordReset BOOLEAN,
	passwordModifiedDate DATE null,
	graceLoginCount INTEGER,
	screenName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	openId VARCHAR(1024) null,
	portraitId LONG,
	languageId VARCHAR(75) null,
	timeZoneId VARCHAR(75) null,
	greeting VARCHAR(75) null,
	comments STRING null,
	loginDate DATE null,
	loginIP VARCHAR(75) null,
	lastLoginDate DATE null,
	lastLoginIP VARCHAR(75) null,
	lastFailedLoginDate DATE null,
	failedLoginAttempts INTEGER,
	lockout BOOLEAN,
	lockoutDate DATE null,
	agreedToTermsOfUse BOOLEAN,
	active_ BOOLEAN
);

create table UserGroup (
	userGroupId LONG not null primary key,
	companyId LONG,
	parentUserGroupId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table UserGroupRole (
	userId LONG not null,
	groupId LONG not null,
	roleId LONG not null,
	primary key (userId, groupId, roleId)
);

create table UserIdMapper (
	userIdMapperId LONG not null primary key,
	userId LONG,
	type_ VARCHAR(75) null,
	description VARCHAR(75) null,
	externalUserId VARCHAR(75) null
);

create table Users_Groups (
	userId LONG not null,
	groupId LONG not null,
	primary key (userId, groupId)
);

create table Users_Orgs (
	userId LONG not null,
	organizationId LONG not null,
	primary key (userId, organizationId)
);

create table Users_Permissions (
	userId LONG not null,
	permissionId LONG not null,
	primary key (userId, permissionId)
);

create table Users_Roles (
	userId LONG not null,
	roleId LONG not null,
	primary key (userId, roleId)
);

create table Users_UserGroups (
	userId LONG not null,
	userGroupId LONG not null,
	primary key (userId, userGroupId)
);

create table UserTracker (
	userTrackerId LONG not null primary key,
	companyId LONG,
	userId LONG,
	modifiedDate DATE null,
	sessionId VARCHAR(200) null,
	remoteAddr VARCHAR(75) null,
	remoteHost VARCHAR(75) null,
	userAgent VARCHAR(200) null
);

create table UserTrackerPath (
	userTrackerPathId LONG not null primary key,
	userTrackerId LONG,
	path_ STRING null,
	pathDate DATE null
);

create table WebDAVProps (
	webDavPropsId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	props TEXT null
);

create table Website (
	websiteId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	url STRING null,
	typeId INTEGER,
	primary_ BOOLEAN
);

create table WikiNode (
	uuid_ VARCHAR(75) null,
	nodeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description STRING null,
	lastPostDate DATE null
);

create table WikiPage (
	uuid_ VARCHAR(75) null,
	pageId LONG not null primary key,
	resourcePrimKey LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nodeId LONG,
	title VARCHAR(75) null,
	version DOUBLE,
	minorEdit BOOLEAN,
	content TEXT null,
	summary STRING null,
	format VARCHAR(75) null,
	head BOOLEAN,
	parentTitle VARCHAR(75) null,
	redirectTitle VARCHAR(75) null
);

create table WikiPageResource (
	resourcePrimKey LONG not null primary key,
	nodeId LONG,
	title VARCHAR(75) null
);

create table attact_file_document (
	attactFileDocumentId LONG not null primary key,
	attactFileDocumentTitle VARCHAR(75) null,
	attactFileDocumentPath VARCHAR(75) null,
	documentManagerId LONG,
	userId LONG,
	groupId LONG,
	companyId LONG
);

create table department (
	departmentId LONG not null primary key,
	departmentCode VARCHAR(75) null,
	departmentName VARCHAR(75) null,
	departmentDescription VARCHAR(75) null,
	userId LONG,
	groupId LONG,
	companyId LONG
);

create table document_manager (
	documentManagerId LONG not null primary key,
	documentManagerCode VARCHAR(75) null,
	documentManagerCategory VARCHAR(75) null,
	documentManagerStyle VARCHAR(75) null,
	documentManagerDescription VARCHAR(75) null,
	documentManagerDateCreate DATE null,
	documentManagerTitle VARCHAR(75) null,
	userId LONG,
	groupId LONG,
	companyId LONG
);

create table holiday_calendar (
	holidayCalendarId LONG not null primary key,
	holidayCalendarCode VARCHAR(75) null,
	holidayCalendarDateCreate DATE null,
	holidayCalendarTitle VARCHAR(75) null,
	holidayCalendarPath VARCHAR(75) null,
	userId LONG,
	groupId LONG,
	companyId LONG
);

create table pml_Receiver (
	receiverId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	receiverUserId LONG,
	receiverUserName VARCHAR(75) null,
	viewName VARCHAR(75) null,
	receiverType INTEGER
);

create table pml_ReceiverGroup (
	receiverGroupId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	receiverGroupName VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ INTEGER,
	active_ BOOLEAN
);

create table pml_Reciever (
	recieverId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	recieverUserId LONG,
	recieverUserName VARCHAR(75) null,
	viewName VARCHAR(75) null,
	recieverType INTEGER
);

create table pml_RecieverGroup (
	recieverGroupId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	recieverGroupName VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ INTEGER,
	active_ BOOLEAN
);

create table pml_agency (
	agencyid VARCHAR(75) not null primary key,
	agencycode VARCHAR(75) null,
	agencyname VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_agencyleader (
	agencyId VARCHAR(75) not null primary key,
	userId LONG
);

create table pml_attachedfile (
	attachedfileid VARCHAR(75) not null primary key,
	attachedfilecode VARCHAR(75) null,
	attachedfilename VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_car_resource (
	carId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	carName VARCHAR(255) null,
	carCode VARCHAR(75) null,
	description STRING null
);

create table pml_career (
	careerid VARCHAR(75) not null primary key,
	careercode VARCHAR(75) null,
	careername VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_chi_tiet_hscv (
	id_chi_tiet_hscv LONG not null primary key,
	id_ho_so_cong_viec LONG,
	id_cong_van_den LONG,
	id_cong_van_di LONG,
	di_den VARCHAR(75) null
);

create table pml_city (
	cityID VARCHAR(75) not null primary key,
	cityCode VARCHAR(75) null,
	cityName VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null,
	countryid VARCHAR(75) null
);

create table pml_conf_phongban_hscv (
	pmlDepartmentHSCVId LONG not null primary key,
	departmentsId VARCHAR(75) null,
	id_ho_so_cong_viec LONG,
	description VARCHAR(75) null
);

create table pml_delegate (
	delegateid LONG not null primary key,
	assigner LONG,
	receiver LONG,
	startdate DATE null,
	enddate DATE null,
	canceldate DATE null,
	canceldelegate VARCHAR(75) null,
	datecreated DATE null
);

create table pml_departmentleader (
	departmentsId VARCHAR(75) not null,
	userId LONG not null,
	clericalid LONG,
	main BOOLEAN,
	primary key (departmentsId, userId)
);

create table pml_departments (
	departmentsid VARCHAR(75) not null primary key,
	departmentsparentid VARCHAR(75) null,
	departmentscode VARCHAR(75) null,
	departmentsname VARCHAR(75) null,
	abbreviatename VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null,
	agencyid VARCHAR(75) null,
	roleid LONG,
	hasteam VARCHAR(75) null
);

create table pml_district (
	districtId VARCHAR(75) not null primary key,
	districtCode VARCHAR(75) null,
	districtName VARCHAR(75) null,
	cityID VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_do_quan_trong (
	id_do_quan_trong LONG not null primary key,
	ten_do_quan_trong VARCHAR(75) null
);

create table pml_documentreceipt_issuingplace_log (
	documentReceiptIssuingPlaceLogId LONG not null primary key,
	documentReceiptId LONG,
	processor LONG,
	directProcessorId LONG,
	dateProcess DATE null,
	processInfomation VARCHAR(75) null,
	receiver VARCHAR(75) null,
	type_ INTEGER,
	step INTEGER
);

create table pml_documentreceipt_log (
	documentreceiptlogid LONG not null primary key,
	documentreceiptid LONG,
	transition_ INTEGER,
	processer LONG,
	dateprocess DATE null,
	processinfomation VARCHAR(75) null,
	receiver LONG,
	receivedate DATE null,
	stateprocessidbefore LONG,
	stateprocessidafter LONG,
	type_ INTEGER,
	expireddate DATE null,
	numdateprocess INTEGER,
	processinstanceid LONG,
	maindepartmentprocessid VARCHAR(75) null,
	mainuserprocessid LONG,
	senddatebefore DATE null,
	departmentreceiveid VARCHAR(75) null,
	departmentprocessid VARCHAR(75) null,
	dateProcessTime DATE null,
	receiveDateTime DATE null,
	directProcesserId LONG,
	step INTEGER
);

create table pml_documentreceipt_wf (
	processid LONG not null primary key,
	documentreceiptid LONG,
	ismain VARCHAR(75) null
);

create table pml_documentsend_log (
	documentsendlogid LONG not null primary key,
	documentsendid LONG,
	transition_ INTEGER,
	processer LONG,
	dateprocess DATE null,
	processinfomation VARCHAR(75) null,
	receiver LONG,
	receivedate DATE null,
	stateprocessidbefore LONG,
	stateprocessidafter LONG,
	expireddate DATE null,
	numdateprocess INTEGER,
	processinstanceid LONG,
	type_ INTEGER,
	senddatebefore DATE null,
	departmentreceiveid VARCHAR(75) null,
	departmentprocessid VARCHAR(75) null,
	dateprocesstime DATE null,
	receivedatetime DATE null,
	directProcesserId LONG,
	step INTEGER
);

create table pml_documentsend_wf (
	documentsendid LONG not null primary key,
	processid LONG,
	isMain VARCHAR(75) null
);

create table pml_edm_answerdetail (
	documentreceiptid LONG not null primary key,
	documentsendid LONG
);

create table pml_edm_attachedfile (
	attachedfileid LONG not null primary key,
	objectcontentid LONG,
	objecttype VARCHAR(75) null,
	attachedfilename VARCHAR(75) null,
	path VARCHAR(75) null,
	datecreated DATE null,
	filetype VARCHAR(75) null,
	fileid INTEGER,
	title VARCHAR(75) null,
	displayorhidden BOOLEAN
);

create table pml_edm_bookdocumentrecordto (
	documentreceiptid LONG not null,
	documentrecordtoid LONG not null,
	datecreate DATE null,
	datecomplete DATE null,
	soCongVanDenPhongHienTai INTEGER,
	primary key (documentreceiptid, documentrecordtoid)
);

create table pml_edm_bookdocumentsend (
	bookdocumentsendid LONG not null primary key,
	datecreated DATE null,
	currentrecord LONG,
	departmentsid VARCHAR(75) null,
	documentrecordtypeid INTEGER,
	yearinuse VARCHAR(75) null,
	active VARCHAR(75) null,
	isagency VARCHAR(75) null,
	agencyid VARCHAR(75) null
);

create table pml_edm_cadre (
	userid LONG not null primary key,
	positionid VARCHAR(75) null,
	departmentsid VARCHAR(75) null,
	handphone VARCHAR(75) null,
	note VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_edm_confidentiallevel (
	confidentiallevelid VARCHAR(75) not null primary key,
	confidentiallevelname VARCHAR(75) null,
	limitviewdetail BOOLEAN,
	haveprocess BOOLEAN,
	confidentiallevelsymbol INTEGER
);

create table pml_edm_docconfuser (
	dcuId LONG not null primary key,
	userId LONG,
	viewAllDoc BOOLEAN,
	viewDepDoc VARCHAR(75) null
);

create table pml_edm_documentdelegate (
	documentDelegateId LONG not null primary key,
	userDelegateId LONG,
	userIsDelegateId LONG,
	documentId INTEGER,
	fromtDate DATE null,
	toDate DATE null,
	cancelDate DATE null
);

create table pml_edm_documentreceipt (
	documentReceiptId LONG not null primary key,
	levelsendid INTEGER,
	documenttypeid LONG,
	documentreference VARCHAR(75) null,
	issuingplaceid VARCHAR(75) null,
	issuingdate DATE null,
	datearrive DATE null,
	signer VARCHAR(75) null,
	privilegelevelid VARCHAR(75) null,
	confidentiallevelid VARCHAR(75) null,
	opinion VARCHAR(75) null,
	briefcontent VARCHAR(75) null,
	ispublic VARCHAR(75) null,
	numberdocumentreceipt VARCHAR(75) null,
	processtime INTEGER,
	status VARCHAR(75) null,
	active VARCHAR(75) null,
	numberlocaldocumentreceipt VARCHAR(75) null,
	issuingplaceothername VARCHAR(75) null,
	documenttype VARCHAR(75) null,
	datebutphe DATE null,
	datehoanthanh DATE null,
	statusid LONG,
	thoigiannhancvden VARCHAR(75) null,
	socongvandiphucdap VARCHAR(75) null,
	generalorderno LONG,
	maindepartmentprocessid VARCHAR(75) null,
	mainuserprocessid LONG,
	orgexternalid LONG,
	docreceipttempid LONG,
	documentrecordtypeid INTEGER,
	donvisaoy VARCHAR(75) null
);

create table pml_edm_documentreceipt_temp (
	documentReceiptId LONG not null primary key,
	levelsendid INTEGER,
	documenttypeid LONG,
	documentreference VARCHAR(75) null,
	issuingplaceid VARCHAR(75) null,
	issuingdate DATE null,
	datearrive DATE null,
	signer VARCHAR(75) null,
	privilegelevelid VARCHAR(75) null,
	confidentiallevelid VARCHAR(75) null,
	opinion VARCHAR(75) null,
	briefcontent VARCHAR(75) null,
	ispublic VARCHAR(75) null,
	numberdocumentreceipt VARCHAR(75) null,
	processtime INTEGER,
	status VARCHAR(75) null,
	active VARCHAR(75) null,
	numberlocaldocumentreceipt VARCHAR(75) null,
	issuingplaceothername VARCHAR(75) null,
	documenttype VARCHAR(75) null,
	datebutphe DATE null,
	datehoanthanh DATE null,
	statusid LONG,
	thoigiannhancvden VARCHAR(75) null,
	socongvandiphucdap VARCHAR(75) null,
	generalorderno LONG,
	maindepartmentprocessid VARCHAR(75) null,
	mainuserprocessid LONG,
	orgexternalid LONG
);

create table pml_edm_documentreceiptextend (
	documentreceiptextendid LONG not null primary key,
	documentreceiptid LONG,
	documentreceiptlogid LONG,
	extendorderno INTEGER,
	startprocessdate DATE null,
	numdayprocessbef INTEGER,
	limitdatebef DATE null,
	extendreason VARCHAR(75) null,
	numdayprocessaft INTEGER,
	limitdateaft DATE null,
	leanonlimitdate BOOLEAN,
	extenduserid LONG,
	extenddepartmentid VARCHAR(75) null
);

create table pml_edm_documentreceiptprocesstype (
	docReceiptProcessTypeId LONG not null primary key,
	documentReceiptId LONG,
	documentReceiptLogId LONG,
	processTypeOrderNo INTEGER,
	dateEdit DATE null,
	processTypeIdBefore VARCHAR(75) null,
	processTypeIdAfter VARCHAR(75) null,
	processTypeReason VARCHAR(75) null,
	processerId LONG,
	departmentId VARCHAR(75) null
);

create table pml_edm_documentrecordto (
	documentrecordtoid LONG not null primary key,
	datecreate DATE null,
	currentrecord LONG,
	departmentsid VARCHAR(75) null,
	documentrecordtypeid INTEGER,
	yearinuse VARCHAR(75) null,
	active VARCHAR(75) null,
	isagency VARCHAR(75) null,
	agencyid VARCHAR(75) null
);

create table pml_edm_documentrecordtype (
	documentrecordtypeid INTEGER not null primary key,
	documentrecordtypename VARCHAR(75) null,
	documentrecordtypecode VARCHAR(75) null
);

create table pml_edm_documentrelation (
	documentrelationid LONG not null primary key,
	docleftid LONG,
	docrightid LONG,
	leftisreceipt BOOLEAN,
	rightisreceipt BOOLEAN
);

create table pml_edm_documentsend (
	documentsendid LONG not null primary key,
	briefcontent VARCHAR(75) null,
	documentreference VARCHAR(75) null,
	receivingplace VARCHAR(75) null,
	issuingdate DATE null,
	opinion VARCHAR(75) null,
	editorid LONG,
	signerid LONG,
	documenttypeid LONG,
	privilegelevelid VARCHAR(75) null,
	confidentiallevelid VARCHAR(75) null,
	datecreated DATE null,
	islocal BOOLEAN,
	active VARCHAR(75) null,
	senddate DATE null,
	signername VARCHAR(75) null,
	position_ VARCHAR(75) null,
	numberpage VARCHAR(75) null,
	numberpublish VARCHAR(75) null,
	documentsendcode VARCHAR(75) null,
	statusid LONG,
	iscongvanphucdap BOOLEAN,
	numofdocref LONG,
	ispublish BOOLEAN,
	orgexternalid LONG,
	numofdirector BOOLEAN,
	documentrecordtypeid INTEGER
);

create table pml_edm_documenttype (
	documenttypeid LONG not null primary key,
	documenttypename VARCHAR(75) null,
	documentsymbol VARCHAR(75) null,
	documentrecordtypeid INTEGER,
	sendreceiptdistinction INTEGER,
	HaveDepartExtends BOOLEAN
);

create table pml_edm_issuingplace (
	issuingplaceid VARCHAR(75) not null primary key,
	issuingplacename VARCHAR(75) null,
	tablephone VARCHAR(75) null,
	handphone VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	active VARCHAR(75) null,
	note VARCHAR(75) null,
	issuingplacecode VARCHAR(75) null,
	signer VARCHAR(75) null
);

create table pml_edm_levelsend (
	levelsendid INTEGER not null primary key,
	levelsendname VARCHAR(75) null,
	levelsendcode VARCHAR(75) null
);

create table pml_edm_levelsenddetail (
	levelsendid INTEGER not null,
	issuingPlaceId VARCHAR(75) not null,
	primary key (levelsendid, issuingPlaceId)
);

create table pml_edm_privilegelevel (
	privilegelevelid VARCHAR(75) not null primary key,
	privilegelevelname VARCHAR(75) null
);

create table pml_edm_processdocumentreceiptdetail (
	id LONG not null primary key,
	documentreceiptid LONG,
	userid LONG,
	note VARCHAR(75) null,
	datecreated DATE null,
	dateupdate DATE null
);

create table pml_edm_writedocumentsend (
	bookdocumentsendid LONG not null,
	documentsendid LONG not null,
	datecreated DATE null,
	soCongVanDiPhongHienTai INTEGER,
	primary key (bookdocumentsendid, documentsendid)
);

create table pml_field (
	fieldId VARCHAR(75) not null primary key,
	fieldCode VARCHAR(75) null,
	fieldName VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null,
	departmentsId VARCHAR(75) null
);

create table pml_file (
	fileId VARCHAR(75) not null primary key,
	cityId VARCHAR(75) null,
	districtId VARCHAR(75) null,
	wardsId VARCHAR(75) null,
	streetId VARCHAR(75) null,
	exactReturningDate DATE null,
	receiverId LONG,
	validDate DATE null,
	expectedReturningDate DATE null,
	applicationDate DATE null,
	otherContent VARCHAR(75) null,
	briefContent VARCHAR(75) null,
	applicantName VARCHAR(75) null,
	organization VARCHAR(75) null,
	authorisedLetter VARCHAR(75) null,
	idNumber VARCHAR(75) null,
	issuingDate DATE null,
	issuingPlace VARCHAR(75) null,
	telephone VARCHAR(75) null,
	gender VARCHAR(75) null,
	streetNumber VARCHAR(75) null,
	permanentAddress VARCHAR(75) null,
	contactInfomation VARCHAR(75) null,
	oldNumberReceipt VARCHAR(75) null,
	numberReceipt VARCHAR(75) null,
	fileTypeId VARCHAR(75) null,
	fieldId VARCHAR(75) null,
	solvingTime INTEGER,
	amendedContent VARCHAR(75) null,
	landCheckingDate DATE null,
	decisionNotice VARCHAR(75) null,
	receiver VARCHAR(75) null,
	dateCreated DATE null,
	lastUpdate DATE null,
	lasttestprocessinfo VARCHAR(75) null,
	active VARCHAR(75) null,
	generalorderno LONG
);

create table pml_file_attachedfile (
	fileAttachedFileId VARCHAR(75) not null primary key,
	fileId VARCHAR(75) null,
	original INTEGER,
	copy_ INTEGER,
	attachedFileId VARCHAR(75) null,
	attachedFileName VARCHAR(75) null,
	note VARCHAR(75) null
);

create table pml_file_pccc (
	fileid VARCHAR(75) not null primary key,
	fileName VARCHAR(75) null,
	applicantrepresentation VARCHAR(75) null,
	applicanttelephone VARCHAR(75) null,
	receiverrepresentation VARCHAR(75) null,
	receivertelephone VARCHAR(75) null,
	projectname VARCHAR(75) null,
	applicantcategory VARCHAR(75) null,
	addressbuilder VARCHAR(75) null,
	investor VARCHAR(75) null,
	designCop VARCHAR(75) null,
	filenumber INTEGER,
	inputdatadate DATE null,
	noteinformationmanagement VARCHAR(75) null,
	totalhour INTEGER,
	totaldate INTEGER,
	conclusion VARCHAR(75) null,
	receiveofunit VARCHAR(75) null,
	applicanttime VARCHAR(75) null
);

create table pml_filepccc_attachedfile (
	attachedfileid LONG not null primary key,
	filepcccid VARCHAR(75) null,
	objecttype VARCHAR(75) null,
	attachedfilename VARCHAR(75) null,
	path VARCHAR(75) null,
	datecreated DATE null,
	filetype VARCHAR(75) null,
	title VARCHAR(75) null
);

create table pml_filereturninginfo (
	filereturninginfoid LONG not null primary key,
	fileid VARCHAR(75) null,
	filesender VARCHAR(75) null,
	licensenumber VARCHAR(75) null,
	issuingdatelicense DATE null,
	receivelicensedate DATE null,
	documentnumber VARCHAR(75) null,
	billnumber VARCHAR(75) null,
	numbermoney LONG,
	note VARCHAR(75) null,
	conclude VARCHAR(75) null
);

create table pml_filestatus (
	filestatusid LONG not null primary key,
	filestatuscode VARCHAR(75) null,
	filestatusname VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null,
	type VARCHAR(75) null
);

create table pml_filestatus_stateprocess (
	id LONG not null primary key,
	filestatusid LONG,
	stateprocessid LONG,
	description VARCHAR(75) null
);

create table pml_filetype (
	fileTypeId VARCHAR(75) not null primary key,
	fileTypeCode VARCHAR(75) null,
	fileTypeName VARCHAR(75) null,
	fieldId VARCHAR(75) null,
	templateId VARCHAR(75) null,
	processTime VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null,
	currentReceiptNumber VARCHAR(75) null,
	receiptTemplate VARCHAR(75) null
);

create table pml_filetype_attachedfile (
	filetypeAttachedFileId VARCHAR(75) not null primary key,
	fileTypeId VARCHAR(75) null,
	original INTEGER,
	copy_ INTEGER,
	attachedFileId VARCHAR(75) null,
	attachedFileName VARCHAR(75) null,
	note VARCHAR(75) null
);

create table pml_filetypedelegate (
	filetypedelegateid LONG not null primary key,
	filetypeid VARCHAR(75) null,
	delegateid LONG
);

create table pml_ho_so_cong_viec (
	id_ho_so_cong_viec LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	id_hscv_cha LONG,
	so_hieu_hscv VARCHAR(75) null,
	tieu_de VARCHAR(75) null,
	ngay_mo_hscv DATE null,
	han_xu_ly DATE null,
	id_linh_vuc VARCHAR(75) null,
	van_de_lien_quan VARCHAR(75) null,
	id_do_quan_trong LONG,
	id_tinh_chat LONG,
	id_trang_thai_hscv LONG,
	tom_tat_noi_dung VARCHAR(75) null,
	hoat_dong VARCHAR(75) null
);

create table pml_holiday (
	holidayid LONG not null primary key,
	holiday_type VARCHAR(75) null,
	holiday_value VARCHAR(75) null,
	from_date DATE null,
	to_date DATE null
);

create table pml_main_support (
	processid LONG not null primary key,
	processid_main LONG,
	type_ VARCHAR(75) null,
	supportinfomation VARCHAR(75) null
);

create table pml_manage_documentworkflow (
	managedocumentworkflowid LONG not null primary key,
	workflowname VARCHAR(75) null,
	version_ INTEGER,
	type_ INTEGER,
	description VARCHAR(75) null,
	startdate DATE null,
	enddate DATE null
);

create table pml_message_note (
	messageId LONG not null primary key,
	documentId LONG,
	fromUserId LONG,
	toUserId LONG,
	createDate DATE null,
	objectType VARCHAR(75) null,
	isAlert BOOLEAN
);

create table pml_nation (
	nationid VARCHAR(75) not null primary key,
	nationcode VARCHAR(75) null,
	nationname VARCHAR(75) null,
	countryid VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_organization_external (
	orgexternalid LONG not null primary key,
	orgexternalcode VARCHAR(75) null,
	orgexternalname VARCHAR(75) null,
	isownerorg BOOLEAN
);

create table pml_paintdocument (
	paintdocumentid LONG not null primary key,
	fileid VARCHAR(75) null,
	paintdocumentname VARCHAR(75) null,
	quantity INTEGER,
	note VARCHAR(75) null
);

create table pml_position (
	positionid VARCHAR(75) not null primary key,
	positioncode VARCHAR(75) null,
	positionname VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_processdispose (
	processdisposeid LONG not null primary key,
	fileid VARCHAR(75) null,
	transition_ INTEGER,
	processer LONG,
	dateprocess DATE null,
	processinfomation VARCHAR(75) null,
	receiver LONG,
	receivedate DATE null,
	stateprocessidbefore LONG,
	stateprocessidafter LONG,
	expireddate DATE null,
	delegateuser LONG,
	senddate DATE null
);

create table pml_processtype (
	processtypeid LONG not null primary key,
	name VARCHAR(75) null,
	flagprocesstype INTEGER
);

create table pml_role (
	roleid VARCHAR(75) not null primary key,
	rolecode VARCHAR(75) null,
	rolename VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_room_resource (
	roomId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	roomName VARCHAR(255) null,
	description STRING null
);

create table pml_saveprocesstype (
	sptid LONG not null primary key,
	docId LONG,
	flagprocesstype LONG,
	flag BOOLEAN
);

create table pml_screecalendar_heigth (
	screesalendarheigthid LONG not null primary key
);

create table pml_screencalendar_height (
	screencalendarheightid LONG not null primary key
);

create table pml_signer (
	signerId LONG not null primary key,
	userId LONG
);

create table pml_state_department (
	departmentid VARCHAR(75) not null,
	statewfid LONG not null,
	primary key (departmentid, statewfid)
);

create table pml_state_wf (
	statewfid LONG not null primary key,
	workflow VARCHAR(75) null,
	stateprocessid LONG,
	solvingtime INTEGER,
	version_ INTEGER
);

create table pml_stateprocess (
	stateprocessid LONG not null primary key,
	stateprocesscode VARCHAR(75) null,
	stateprocessname VARCHAR(75) null,
	filestatusid LONG,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_street (
	streetId VARCHAR(75) not null primary key,
	streetName VARCHAR(75) null
);

create table pml_team (
	teamid LONG not null primary key,
	departmentid VARCHAR(75) null,
	teamname VARCHAR(75) null,
	description VARCHAR(75) null,
	organizationid LONG,
	companyid LONG,
	specialteam VARCHAR(75) null,
	teamcode VARCHAR(75) null
);

create table pml_teamleader (
	teamid LONG not null primary key,
	userid LONG
);

create table pml_template (
	templateId LONG not null primary key,
	templateCode VARCHAR(75) null,
	templateName VARCHAR(75) null,
	numberOfDocument INTEGER,
	publishDate DATE null,
	departmentId VARCHAR(75) null
);

create table pml_template_file (
	fileTemplateId LONG not null primary key,
	templateId LONG,
	tenFile VARCHAR(75) null,
	kichThuoc LONG,
	duongDan VARCHAR(75) null
);

create table pml_tinh_chat (
	id_tinh_chat LONG not null primary key,
	ten_tinh_chat VARCHAR(75) null
);

create table pml_trang_thai_hscv (
	id_trang_thai_hscv LONG not null primary key,
	ten_trang_thai_hscv VARCHAR(75) null
);

create table pml_transition (
	transitionid LONG not null primary key,
	transitionname VARCHAR(75) null,
	filetypeid VARCHAR(75) null,
	notransition INTEGER,
	stateprocesscurrent LONG,
	stateprocessnext LONG,
	version_ VARCHAR(75) null
);

create table pml_user (
	userId LONG not null primary key,
	positionId VARCHAR(75) null,
	departmentsId VARCHAR(75) null,
	roleId VARCHAR(75) null,
	handphone VARCHAR(75) null,
	note VARCHAR(75) null,
	teamid LONG,
	active BOOLEAN,
	screenname VARCHAR(75) null,
	firstname VARCHAR(75) null,
	middlename VARCHAR(75) null,
	lastname VARCHAR(75) null,
	male BOOLEAN,
	birthday DATE null,
	isleadermetting BOOLEAN,
	isvanthuphong BOOLEAN
);

create table pml_user_file_type (
	userid LONG not null,
	filetypeid VARCHAR(75) not null,
	description VARCHAR(75) null,
	primary key (userid, filetypeid)
);

create table pml_wards (
	wardsId VARCHAR(75) not null primary key,
	wardsCode VARCHAR(75) null,
	wardsName VARCHAR(75) null,
	districtId VARCHAR(75) null,
	description VARCHAR(75) null,
	active VARCHAR(75) null
);

create table pml_wf_onedoor (
	fileId VARCHAR(75) not null primary key,
	processId LONG,
	nodeId LONG
);

create table pml_workflow (
	workflowId LONG not null primary key,
	fileTypeId VARCHAR(75) null,
	workflow VARCHAR(75) null,
	version_ INTEGER,
	startDate DATE null,
	endDate DATE null
);

create table report_registry_work (
	reportRegistryId LONG not null primary key,
	reportRegistryCode VARCHAR(75) null,
	userCreate VARCHAR(75) null,
	resultWork VARCHAR(75) null,
	programWork VARCHAR(75) null,
	reportDate DATE null,
	departmentId LONG,
	userId LONG,
	groupId LONG,
	companyId LONG
);

create table result_program_file (
	resultProgramId LONG not null primary key,
	resultProgramTitle VARCHAR(75) null,
	resultProgramPath VARCHAR(75) null,
	resultProgramCheck VARCHAR(75) null,
	reportRegistryId LONG,
	userId LONG,
	groupId LONG,
	companyId LONG
);
