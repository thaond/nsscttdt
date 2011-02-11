create table Account_ (
	accountId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	parentAccountId bigint,
	name varchar(75) null,
	legalName varchar(75) null,
	legalId varchar(75) null,
	legalType varchar(75) null,
	sicCode varchar(75) null,
	tickerSymbol varchar(75) null,
	industry varchar(75) null,
	type_ varchar(75) null,
	size_ varchar(75) null
);

create table Address (
	addressId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	street1 varchar(75) null,
	street2 varchar(75) null,
	street3 varchar(75) null,
	city varchar(75) null,
	zip varchar(75) null,
	regionId bigint,
	countryId bigint,
	typeId integer,
	mailing boolean,
	primary_ boolean
);

create table AnnouncementsDelivery (
	deliveryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	type_ varchar(75) null,
	email boolean,
	sms boolean,
	website boolean
);

create table AnnouncementsEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	title varchar(75) null,
	content long varchar null,
	url long varchar null,
	type_ varchar(75) null,
	displayDate date null,
	expirationDate date null,
	priority integer,
	alert boolean
);

create table AnnouncementsFlag (
	flagId bigint not null primary key,
	userId bigint,
	createDate date null,
	entryId bigint,
	value integer
);

create table BlogsCategory (
	categoryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	parentCategoryId bigint,
	name varchar(75) null,
	description long varchar null
);

create table BlogsEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	title varchar(150) null,
	urlTitle varchar(150) null,
	content long varchar null,
	displayDate date null,
	draft boolean,
	allowTrackbacks boolean,
	trackbacks long varchar null
);

create table BlogsStatsUser (
	statsUserId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	entryCount integer,
	lastPostDate date null,
	ratingsTotalEntries integer,
	ratingsTotalScore double,
	ratingsAverageScore double
);

create table BookmarksEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate date null,
	modifiedDate date null,
	folderId bigint,
	name varchar(300) null,
	url long varchar null,
	comments long varchar null,
	visits integer,
	priority integer
);

create table BookmarksFolder (
	uuid_ varchar(75) null,
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate date null,
	modifiedDate date null,
	parentFolderId bigint,
	name varchar(75) null,
	description long varchar null
);

create table CalEvent (
	uuid_ varchar(75) null,
	eventId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	title varchar(75) null,
	description long varchar null,
	startDate date null,
	endDate date null,
	durationHour integer,
	durationMinute integer,
	allDay boolean,
	timeZoneSensitive boolean,
	type_ varchar(75) null,
	repeating boolean,
	recurrence long varchar null,
	remindBy varchar(75) null,
	firstReminder integer,
	secondReminder integer
);

create table ClassName_ (
	classNameId bigint not null primary key,
	value varchar(200) null
);

create table Company (
	companyId bigint not null primary key,
	accountId bigint,
	webId varchar(75) null,
	key_ long varchar null,
	virtualHost varchar(75) null,
	mx varchar(75) null,
	logoId bigint
);

create table CongViec (
	macv varchar(75) not null primary key,
	tencv varchar(75) null,
	linhvucid varchar(75) null,
	nguoitao bigint,
	ngaytao date null,
	ngayhethan date null,
	nguoichidao bigint,
	doithuchien varchar(75) null,
	ykienchidao varchar(75) null,
	baocaochidao varchar(75) null,
	chidaothem varchar(75) null
);

create table Contact_ (
	contactId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	accountId bigint,
	parentContactId bigint,
	firstName varchar(75) null,
	middleName varchar(75) null,
	lastName varchar(75) null,
	prefixId integer,
	suffixId integer,
	male boolean,
	birthday date null,
	smsSn varchar(75) null,
	aimSn varchar(75) null,
	facebookSn varchar(75) null,
	icqSn varchar(75) null,
	jabberSn varchar(75) null,
	msnSn varchar(75) null,
	mySpaceSn varchar(75) null,
	skypeSn varchar(75) null,
	twitterSn varchar(75) null,
	ymSn varchar(75) null,
	employeeStatusId varchar(75) null,
	employeeNumber varchar(75) null,
	jobTitle varchar(100) null,
	jobClass varchar(75) null,
	hoursOfOperation varchar(75) null
);

create table Counter (
	name varchar(75) not null primary key,
	currentId bigint
);

create table Country (
	countryId bigint not null primary key,
	name varchar(75) null,
	a2 varchar(75) null,
	a3 varchar(75) null,
	number_ varchar(75) null,
	idd_ varchar(75) null,
	active_ boolean
);

create table CyrusUser (
	userId varchar(75) not null primary key,
	password_ varchar(75) not null
);

create table CyrusVirtual (
	emailAddress varchar(75) not null primary key,
	userId varchar(75) not null
);

create table DLFileEntry (
	uuid_ varchar(75) null,
	fileEntryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	versionUserId bigint,
	versionUserName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	folderId bigint,
	name varchar(300) null,
	title varchar(300) null,
	description long varchar null,
	version double,
	size_ integer,
	readCount integer,
	extraSettings long varchar null
);

create table DLFileRank (
	fileRankId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate date null,
	folderId bigint,
	name varchar(300) null
);

create table DLFileShortcut (
	uuid_ varchar(75) null,
	fileShortcutId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	folderId bigint,
	toFolderId bigint,
	toName varchar(300) null
);

create table DLFileVersion (
	fileVersionId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	folderId bigint,
	name varchar(300) null,
	version double,
	size_ integer
);

create table DLFolder (
	uuid_ varchar(75) null,
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	parentFolderId bigint,
	name varchar(100) null,
	description long varchar null,
	lastPostDate date null
);

create table EmailAddress (
	emailAddressId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	address varchar(75) null,
	typeId integer,
	primary_ boolean
);

create table ExpandoColumn (
	columnId bigint not null primary key,
	tableId bigint,
	name varchar(75) null,
	type_ integer
);

create table ExpandoRow (
	rowId_ bigint not null primary key,
	tableId bigint,
	classPK bigint
);

create table ExpandoTable (
	tableId bigint not null primary key,
	classNameId bigint,
	name varchar(75) null
);

create table ExpandoValue (
	valueId bigint not null primary key,
	tableId bigint,
	columnId bigint,
	rowId_ bigint,
	classNameId bigint,
	classPK bigint,
	data_ long varchar null
);

create table Group_ (
	groupId bigint not null primary key,
	companyId bigint,
	creatorUserId bigint,
	classNameId bigint,
	classPK bigint,
	parentGroupId bigint,
	liveGroupId bigint,
	name varchar(75) null,
	description long varchar null,
	type_ integer,
	typeSettings long varchar null,
	friendlyURL varchar(100) null,
	active_ boolean
);

create table Groups_Orgs (
	groupId bigint not null,
	organizationId bigint not null,
	primary key (groupId, organizationId)
);

create table Groups_Permissions (
	groupId bigint not null,
	permissionId bigint not null,
	primary key (groupId, permissionId)
);

create table Groups_Roles (
	groupId bigint not null,
	roleId bigint not null,
	primary key (groupId, roleId)
);

create table Groups_UserGroups (
	groupId bigint not null,
	userGroupId bigint not null,
	primary key (groupId, userGroupId)
);

create table IGFolder (
	uuid_ varchar(75) null,
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate date null,
	modifiedDate date null,
	parentFolderId bigint,
	name varchar(75) null,
	description long varchar null
);

create table IGImage (
	uuid_ varchar(75) null,
	imageId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate date null,
	modifiedDate date null,
	folderId bigint,
	name varchar(75) null,
	description long varchar null,
	smallImageId bigint,
	largeImageId bigint,
	custom1ImageId bigint,
	custom2ImageId bigint
);

create table Image (
	imageId bigint not null primary key,
	modifiedDate date null,
	text_ long varchar null,
	type_ varchar(75) null,
	height integer,
	width integer,
	size_ integer
);

create table JournalArticle (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	resourcePrimKey bigint,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	articleId varchar(75) null,
	version double,
	title varchar(100) null,
	description long varchar null,
	content long varchar null,
	type_ varchar(75) null,
	structureId varchar(75) null,
	templateId varchar(75) null,
	displayDate date null,
	approved boolean,
	approvedByUserId bigint,
	approvedByUserName varchar(75) null,
	approvedDate date null,
	expired boolean,
	expirationDate date null,
	reviewDate date null,
	indexable boolean,
	smallImage boolean,
	smallImageId bigint,
	smallImageURL varchar(75) null
);

create table JournalArticleImage (
	articleImageId bigint not null primary key,
	groupId bigint,
	articleId varchar(75) null,
	version double,
	elName varchar(75) null,
	languageId varchar(75) null,
	tempImage boolean
);

create table JournalArticleResource (
	resourcePrimKey bigint not null primary key,
	groupId bigint,
	articleId varchar(75) null
);

create table JournalContentSearch (
	contentSearchId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout boolean,
	layoutId bigint,
	portletId varchar(200) null,
	articleId varchar(75) null
);

create table JournalFeed (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	feedId varchar(75) null,
	name varchar(75) null,
	description long varchar null,
	type_ varchar(75) null,
	structureId varchar(75) null,
	templateId varchar(75) null,
	rendererTemplateId varchar(75) null,
	delta integer,
	orderByCol varchar(75) null,
	orderByType varchar(75) null,
	targetLayoutFriendlyUrl varchar(75) null,
	targetPortletId varchar(75) null,
	contentField varchar(75) null,
	feedType varchar(75) null,
	feedVersion double
);

create table JournalStructure (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	structureId varchar(75) null,
	name varchar(75) null,
	description long varchar null,
	xsd long varchar null
);

create table JournalTemplate (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	templateId varchar(75) null,
	structureId varchar(75) null,
	name varchar(75) null,
	description long varchar null,
	xsl long varchar null,
	langType varchar(75) null,
	cacheable boolean,
	smallImage boolean,
	smallImageId bigint,
	smallImageURL varchar(75) null
);

create table Layout (
	plid bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout boolean,
	layoutId bigint,
	parentLayoutId bigint,
	name long varchar null,
	title long varchar null,
	description long varchar null,
	type_ varchar(75) null,
	typeSettings long varchar null,
	hidden_ boolean,
	friendlyURL varchar(100) null,
	iconImage boolean,
	iconImageId bigint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css long varchar null,
	priority integer,
	dlFolderId bigint
);

create table LayoutSet (
	layoutSetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout boolean,
	logo boolean,
	logoId bigint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css long varchar null,
	pageCount integer,
	virtualHost varchar(75) null
);

create table ListType (
	listTypeId integer not null primary key,
	name varchar(75) null,
	type_ varchar(75) null
);

create table MBBan (
	banId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	banUserId bigint
);

create table MBCategory (
	uuid_ varchar(75) null,
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	parentCategoryId bigint,
	name varchar(75) null,
	description long varchar null,
	lastPostDate date null
);

create table MBDiscussion (
	discussionId bigint not null primary key,
	classNameId bigint,
	classPK bigint,
	threadId bigint
);

create table MBMessage (
	uuid_ varchar(75) null,
	messageId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	categoryId bigint,
	threadId bigint,
	parentMessageId bigint,
	subject varchar(75) null,
	body long varchar null,
	attachments boolean,
	anonymous boolean
);

create table MBMessageFlag (
	messageFlagId bigint not null primary key,
	userId bigint,
	messageId bigint,
	flag integer
);

create table MBStatsUser (
	statsUserId bigint not null primary key,
	groupId bigint,
	userId bigint,
	messageCount integer,
	lastPostDate date null
);

create table MBThread (
	threadId bigint not null primary key,
	categoryId bigint,
	rootMessageId bigint,
	messageCount integer,
	viewCount integer,
	lastPostByUserId bigint,
	lastPostDate date null,
	priority double
);

create table MeetingCalComponent (
	mcalId bigint not null primary key,
	groupIds varchar(75) null,
	startDate date null
);

create table MeetingCalendar (
	uuid_ varchar(75) null,
	mcalId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	state integer,
	place varchar(75) null,
	place_diff varchar(75) null,
	sponsor varchar(75) null,
	component varchar(75) null,
	note varchar(75) null,
	userApproved bigint,
	dateApproved date null,
	moveMcalId bigint,
	repeatWeek boolean,
	filename varchar(75) null,
	morning boolean,
	afternoon boolean,
	evening boolean,
	stt integer,
	prior boolean
);

create table MeetingDetailWeek (
	mdweekId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	focus varchar(75) null,
	note varchar(75) null,
	receive varchar(75) null,
	week integer,
	year integer
);

create table MembershipRequest (
	membershipRequestId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate date null,
	groupId bigint,
	comments long varchar null,
	replyComments long varchar null,
	replyDate date null,
	replierUserId bigint,
	statusId integer
);

create table Organization_ (
	organizationId bigint not null primary key,
	companyId bigint,
	parentOrganizationId bigint,
	name varchar(100) null,
	location boolean,
	recursable boolean,
	regionId bigint,
	countryId bigint,
	statusId integer,
	comments long varchar null
);

create table OrgGroupPermission (
	organizationId bigint not null,
	groupId bigint not null,
	permissionId bigint not null,
	primary key (organizationId, groupId, permissionId)
);

create table OrgGroupRole (
	organizationId bigint not null,
	groupId bigint not null,
	roleId bigint not null,
	primary key (organizationId, groupId, roleId)
);

create table OrgLabor (
	orgLaborId bigint not null primary key,
	organizationId bigint,
	typeId integer,
	sunOpen integer,
	sunClose integer,
	monOpen integer,
	monClose integer,
	tueOpen integer,
	tueClose integer,
	wedOpen integer,
	wedClose integer,
	thuOpen integer,
	thuClose integer,
	friOpen integer,
	friClose integer,
	satOpen integer,
	satClose integer
);

create table PML_Country (
	countryId varchar(75) not null primary key,
	countryCode varchar(75) null,
	countryName varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table PML_FILETYPE (
	fileTypeId varchar(75) not null primary key,
	fileTypeCode varchar(75) null,
	fileTypeName varchar(75) null,
	fieldId varchar(75) null,
	templateId varchar(75) null,
	processTime varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	currentReceiptNumber varchar(75) null,
	receiptTemplate varchar(75) null
);

create table PML_IDGENERATED (
	id bigint not null primary key,
	year varchar(75) null,
	curvalue bigint
);

create table PML_IDTEMPLATE (
	templateId bigint not null primary key,
	format varchar(75) null,
	startNumber varchar(75) null,
	len bigint,
	description varchar(75) null
);

create table PasswordPolicy (
	passwordPolicyId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	defaultPolicy boolean,
	name varchar(75) null,
	description long varchar null,
	changeable boolean,
	changeRequired boolean,
	minAge bigint,
	checkSyntax boolean,
	allowDictionaryWords boolean,
	minLength integer,
	history boolean,
	historyCount integer,
	expireable boolean,
	maxAge bigint,
	warningTime bigint,
	graceLimit integer,
	lockout boolean,
	maxFailure integer,
	lockoutDuration bigint,
	requireUnlock boolean,
	resetFailureCount bigint
);

create table PasswordPolicyRel (
	passwordPolicyRelId bigint not null primary key,
	passwordPolicyId bigint,
	classNameId bigint,
	classPK bigint
);

create table PasswordTracker (
	passwordTrackerId bigint not null primary key,
	userId bigint,
	createDate date null,
	password_ varchar(75) null
);

create table Permission_ (
	permissionId bigint not null primary key,
	companyId bigint,
	actionId varchar(75) null,
	resourceId bigint
);

create table Phone (
	phoneId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	number_ varchar(75) null,
	extension varchar(75) null,
	typeId integer,
	primary_ boolean
);

create table PluginSetting (
	pluginSettingId bigint not null primary key,
	companyId bigint,
	pluginId varchar(75) null,
	pluginType varchar(75) null,
	roles long varchar null,
	active_ boolean
);

create table PollsChoice (
	uuid_ varchar(75) null,
	choiceId bigint not null primary key,
	questionId bigint,
	name varchar(75) null,
	description varchar(1000) null
);

create table PollsQuestion (
	uuid_ varchar(75) null,
	questionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	title varchar(500) null,
	description long varchar null,
	expirationDate date null,
	lastVoteDate date null
);

create table PollsVote (
	voteId bigint not null primary key,
	userId bigint,
	questionId bigint,
	choiceId bigint,
	voteDate date null
);

create table Portlet (
	id_ bigint not null primary key,
	companyId bigint,
	portletId varchar(200) null,
	roles long varchar null,
	active_ boolean
);

create table PortletItem (
	portletItemId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	name varchar(75) null,
	portletId varchar(75) null,
	classNameId bigint
);

create table PortletPreferences (
	portletPreferencesId bigint not null primary key,
	ownerId bigint,
	ownerType integer,
	plid bigint,
	portletId varchar(200) null,
	preferences long varchar null
);

create table RatingsEntry (
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	score double
);

create table RatingsStats (
	statsId bigint not null primary key,
	classNameId bigint,
	classPK bigint,
	totalEntries integer,
	totalScore double,
	averageScore double
);

create table ReceiverGroups_Receivers (
	receiverGroupId bigint not null,
	receiverId bigint not null,
	primary key (receiverGroupId, receiverId)
);

create table RecieverGroups_Recievers (
	recieverGroupId bigint not null,
	recieverId bigint not null,
	primary key (recieverGroupId, recieverId)
);

create table Region (
	regionId bigint not null primary key,
	countryId bigint,
	regionCode varchar(75) null,
	name varchar(75) null,
	active_ boolean
);

create table Release_ (
	releaseId bigint not null primary key,
	createDate date null,
	modifiedDate date null,
	buildNumber integer,
	buildDate date null,
	verified boolean
);

create table ReportsEntry (
	entryId varchar(75) not null primary key,
	companyId varchar(75) null,
	userId varchar(75) null,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	name varchar(75) null
);

create table Resource_ (
	resourceId bigint not null primary key,
	codeId bigint,
	primKey varchar(300) null
);

create table ResourceCode (
	codeId bigint not null primary key,
	companyId bigint,
	name varchar(300) null,
	scope integer
);

create table Role_ (
	roleId bigint not null primary key,
	companyId bigint,
	classNameId bigint,
	classPK bigint,
	name varchar(75) null,
	description long varchar null,
	type_ integer
);

create table Roles_Permissions (
	roleId bigint not null,
	permissionId bigint not null,
	primary key (roleId, permissionId)
);

create table SCFrameworkVersi_SCProductVers (
	frameworkVersionId bigint not null,
	productVersionId bigint not null,
	primary key (frameworkVersionId, productVersionId)
);

create table SCFrameworkVersion (
	frameworkVersionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	name varchar(75) null,
	url long varchar null,
	active_ boolean,
	priority integer
);

create table SCLicense (
	licenseId bigint not null primary key,
	name varchar(75) null,
	url long varchar null,
	openSource boolean,
	active_ boolean,
	recommended boolean
);

create table SCLicenses_SCProductEntries (
	licenseId bigint not null,
	productEntryId bigint not null,
	primary key (licenseId, productEntryId)
);

create table SCProductEntry (
	productEntryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	name varchar(75) null,
	type_ varchar(75) null,
	tags varchar(300) null,
	shortDescription long varchar null,
	longDescription long varchar null,
	pageURL long varchar null,
	author varchar(75) null,
	repoGroupId varchar(75) null,
	repoArtifactId varchar(75) null
);

create table SCProductScreenshot (
	productScreenshotId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	productEntryId bigint,
	thumbnailId bigint,
	fullImageId bigint,
	priority integer
);

create table SCProductVersion (
	productVersionId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	productEntryId bigint,
	version varchar(75) null,
	changeLog long varchar null,
	downloadPageURL long varchar null,
	directDownloadURL varchar(2000) null,
	repoStoreArtifact boolean
);

create table ServiceComponent (
	serviceComponentId bigint not null primary key,
	buildNamespace varchar(75) null,
	buildNumber bigint,
	buildDate bigint,
	data_ long varchar null
);

create table ShoppingCart (
	cartId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	itemIds long varchar null,
	couponCodes varchar(75) null,
	altShipping integer,
	insure boolean
);

create table ShoppingCategory (
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	parentCategoryId bigint,
	name varchar(75) null,
	description long varchar null
);

create table ShoppingCoupon (
	couponId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	code_ varchar(75) null,
	name varchar(75) null,
	description long varchar null,
	startDate date null,
	endDate date null,
	active_ boolean,
	limitCategories long varchar null,
	limitSkus long varchar null,
	minOrder double,
	discount double,
	discountType varchar(75) null
);

create table ShoppingItem (
	itemId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	categoryId bigint,
	sku varchar(75) null,
	name varchar(200) null,
	description long varchar null,
	properties long varchar null,
	fields_ boolean,
	fieldsQuantities long varchar null,
	minQuantity integer,
	maxQuantity integer,
	price double,
	discount double,
	taxable boolean,
	shipping double,
	useShippingFormula boolean,
	requiresShipping boolean,
	stockQuantity integer,
	featured_ boolean,
	sale_ boolean,
	smallImage boolean,
	smallImageId bigint,
	smallImageURL varchar(75) null,
	mediumImage boolean,
	mediumImageId bigint,
	mediumImageURL varchar(75) null,
	largeImage boolean,
	largeImageId bigint,
	largeImageURL varchar(75) null
);

create table ShoppingItemField (
	itemFieldId bigint not null primary key,
	itemId bigint,
	name varchar(75) null,
	values_ long varchar null,
	description long varchar null
);

create table ShoppingItemPrice (
	itemPriceId bigint not null primary key,
	itemId bigint,
	minQuantity integer,
	maxQuantity integer,
	price double,
	discount double,
	taxable boolean,
	shipping double,
	useShippingFormula boolean,
	status integer
);

create table ShoppingOrder (
	orderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	number_ varchar(75) null,
	tax double,
	shipping double,
	altShipping varchar(75) null,
	requiresShipping boolean,
	insure boolean,
	insurance double,
	couponCodes varchar(75) null,
	couponDiscount double,
	billingFirstName varchar(75) null,
	billingLastName varchar(75) null,
	billingEmailAddress varchar(75) null,
	billingCompany varchar(75) null,
	billingStreet varchar(75) null,
	billingCity varchar(75) null,
	billingState varchar(75) null,
	billingZip varchar(75) null,
	billingCountry varchar(75) null,
	billingPhone varchar(75) null,
	shipToBilling boolean,
	shippingFirstName varchar(75) null,
	shippingLastName varchar(75) null,
	shippingEmailAddress varchar(75) null,
	shippingCompany varchar(75) null,
	shippingStreet varchar(75) null,
	shippingCity varchar(75) null,
	shippingState varchar(75) null,
	shippingZip varchar(75) null,
	shippingCountry varchar(75) null,
	shippingPhone varchar(75) null,
	ccName varchar(75) null,
	ccType varchar(75) null,
	ccNumber varchar(75) null,
	ccExpMonth integer,
	ccExpYear integer,
	ccVerNumber varchar(75) null,
	comments long varchar null,
	ppTxnId varchar(75) null,
	ppPaymentStatus varchar(75) null,
	ppPaymentGross double,
	ppReceiverEmail varchar(75) null,
	ppPayerEmail varchar(75) null,
	sendOrderEmail boolean,
	sendShippingEmail boolean
);

create table ShoppingOrderItem (
	orderItemId bigint not null primary key,
	orderId bigint,
	itemId varchar(75) null,
	sku varchar(75) null,
	name varchar(200) null,
	description long varchar null,
	properties long varchar null,
	price double,
	quantity integer,
	shippedDate date null
);

create table SocialActivity (
	activityId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate date null,
	mirrorActivityId bigint,
	classNameId bigint,
	classPK bigint,
	type_ integer,
	extraData long varchar null,
	receiverUserId bigint
);

create table SocialRelation (
	uuid_ varchar(75) null,
	relationId bigint not null primary key,
	companyId bigint,
	createDate date null,
	userId1 bigint,
	userId2 bigint,
	type_ integer
);

create table SocialRequest (
	uuid_ varchar(75) null,
	requestId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	type_ integer,
	extraData long varchar null,
	receiverUserId bigint,
	status integer
);

create table Subscription (
	subscriptionId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	frequency varchar(75) null
);

create table TagsAsset (
	assetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	startDate date null,
	endDate date null,
	publishDate date null,
	expirationDate date null,
	mimeType varchar(75) null,
	title varchar(300) null,
	description long varchar null,
	summary long varchar null,
	url long varchar null,
	height integer,
	width integer,
	priority double,
	viewCount integer
);

create table TagsAssets_TagsEntries (
	assetId bigint not null,
	entryId bigint not null,
	primary key (assetId, entryId)
);

create table TagsEntry (
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	name varchar(75) null
);

create table TagsProperty (
	propertyId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	entryId bigint,
	key_ varchar(75) null,
	value varchar(300) null
);

create table TagsSource (
	sourceId bigint not null primary key,
	parentSourceId bigint,
	name varchar(75) null,
	acronym varchar(75) null
);

create table TasksProposal (
	proposalId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK varchar(75) null,
	name varchar(75) null,
	description long varchar null,
	publishDate date null,
	dueDate date null
);

create table TasksReview (
	reviewId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	proposalId bigint,
	assignedByUserId bigint,
	assignedByUserName varchar(75) null,
	stage integer,
	completed boolean,
	rejected boolean
);

create table User_ (
	uuid_ varchar(75) null,
	userId bigint not null primary key,
	companyId bigint,
	createDate date null,
	modifiedDate date null,
	defaultUser boolean,
	contactId bigint,
	password_ varchar(75) null,
	passwordEncrypted boolean,
	passwordReset boolean,
	passwordModifiedDate date null,
	graceLoginCount integer,
	screenName varchar(75) null,
	emailAddress varchar(75) null,
	openId varchar(1024) null,
	portraitId bigint,
	languageId varchar(75) null,
	timeZoneId varchar(75) null,
	greeting varchar(75) null,
	comments long varchar null,
	loginDate date null,
	loginIP varchar(75) null,
	lastLoginDate date null,
	lastLoginIP varchar(75) null,
	lastFailedLoginDate date null,
	failedLoginAttempts integer,
	lockout boolean,
	lockoutDate date null,
	agreedToTermsOfUse boolean,
	active_ boolean
);

create table UserGroup (
	userGroupId bigint not null primary key,
	companyId bigint,
	parentUserGroupId bigint,
	name varchar(75) null,
	description long varchar null
);

create table UserGroupRole (
	userId bigint not null,
	groupId bigint not null,
	roleId bigint not null,
	primary key (userId, groupId, roleId)
);

create table UserIdMapper (
	userIdMapperId bigint not null primary key,
	userId bigint,
	type_ varchar(75) null,
	description varchar(75) null,
	externalUserId varchar(75) null
);

create table Users_Groups (
	userId bigint not null,
	groupId bigint not null,
	primary key (userId, groupId)
);

create table Users_Orgs (
	userId bigint not null,
	organizationId bigint not null,
	primary key (userId, organizationId)
);

create table Users_Permissions (
	userId bigint not null,
	permissionId bigint not null,
	primary key (userId, permissionId)
);

create table Users_Roles (
	userId bigint not null,
	roleId bigint not null,
	primary key (userId, roleId)
);

create table Users_UserGroups (
	userId bigint not null,
	userGroupId bigint not null,
	primary key (userId, userGroupId)
);

create table UserTracker (
	userTrackerId bigint not null primary key,
	companyId bigint,
	userId bigint,
	modifiedDate date null,
	sessionId varchar(200) null,
	remoteAddr varchar(75) null,
	remoteHost varchar(75) null,
	userAgent varchar(200) null
);

create table UserTrackerPath (
	userTrackerPathId bigint not null primary key,
	userTrackerId bigint,
	path_ long varchar null,
	pathDate date null
);

create table WebDAVProps (
	webDavPropsId bigint not null primary key,
	companyId bigint,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	props long varchar null
);

create table Website (
	websiteId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	classNameId bigint,
	classPK bigint,
	url long varchar null,
	typeId integer,
	primary_ boolean
);

create table WikiNode (
	uuid_ varchar(75) null,
	nodeId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	name varchar(75) null,
	description long varchar null,
	lastPostDate date null
);

create table WikiPage (
	uuid_ varchar(75) null,
	pageId bigint not null primary key,
	resourcePrimKey bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	nodeId bigint,
	title varchar(75) null,
	version double,
	minorEdit boolean,
	content long varchar null,
	summary long varchar null,
	format varchar(75) null,
	head boolean,
	parentTitle varchar(75) null,
	redirectTitle varchar(75) null
);

create table WikiPageResource (
	resourcePrimKey bigint not null primary key,
	nodeId bigint,
	title varchar(75) null
);

create table attact_file_document (
	attactFileDocumentId bigint not null primary key,
	attactFileDocumentTitle varchar(75) null,
	attactFileDocumentPath varchar(75) null,
	documentManagerId bigint,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table department (
	departmentId bigint not null primary key,
	departmentCode varchar(75) null,
	departmentName varchar(75) null,
	departmentDescription varchar(75) null,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table document_manager (
	documentManagerId bigint not null primary key,
	documentManagerCode varchar(75) null,
	documentManagerCategory varchar(75) null,
	documentManagerStyle varchar(75) null,
	documentManagerDescription varchar(75) null,
	documentManagerDateCreate date null,
	documentManagerTitle varchar(75) null,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table holiday_calendar (
	holidayCalendarId bigint not null primary key,
	holidayCalendarCode varchar(75) null,
	holidayCalendarDateCreate date null,
	holidayCalendarTitle varchar(75) null,
	holidayCalendarPath varchar(75) null,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table pml_Receiver (
	receiverId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	receiverUserId bigint,
	receiverUserName varchar(75) null,
	viewName varchar(75) null,
	receiverType integer
);

create table pml_ReceiverGroup (
	receiverGroupId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	receiverGroupName varchar(75) null,
	description varchar(75) null,
	type_ integer,
	active_ boolean
);

create table pml_Reciever (
	recieverId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	recieverUserId bigint,
	recieverUserName varchar(75) null,
	viewName varchar(75) null,
	recieverType integer
);

create table pml_RecieverGroup (
	recieverGroupId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	recieverGroupName varchar(75) null,
	description varchar(75) null,
	type_ integer,
	active_ boolean
);

create table pml_agency (
	agencyid varchar(75) not null primary key,
	agencycode varchar(75) null,
	agencyname varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_agencyleader (
	agencyId varchar(75) not null primary key,
	userId bigint
);

create table pml_attachedfile (
	attachedfileid varchar(75) not null primary key,
	attachedfilecode varchar(75) null,
	attachedfilename varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_car_resource (
	carId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate date null,
	modifiedDate date null,
	carName varchar(255) null,
	carCode varchar(75) null,
	description long varchar null
);

create table pml_career (
	careerid varchar(75) not null primary key,
	careercode varchar(75) null,
	careername varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_chi_tiet_hscv (
	id_chi_tiet_hscv bigint not null primary key,
	id_ho_so_cong_viec bigint,
	id_cong_van_den bigint,
	id_cong_van_di bigint,
	di_den varchar(75) null
);

create table pml_city (
	cityID varchar(75) not null primary key,
	cityCode varchar(75) null,
	cityName varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	countryid varchar(75) null
);

create table pml_conf_phongban_hscv (
	pmlDepartmentHSCVId bigint not null primary key,
	departmentsId varchar(75) null,
	id_ho_so_cong_viec bigint,
	description varchar(75) null
);

create table pml_delegate (
	delegateid bigint not null primary key,
	assigner bigint,
	receiver bigint,
	startdate date null,
	enddate date null,
	canceldate date null,
	canceldelegate varchar(75) null,
	datecreated date null
);

create table pml_departmentleader (
	departmentsId varchar(75) not null,
	userId bigint not null,
	clericalid bigint,
	main boolean,
	primary key (departmentsId, userId)
);

create table pml_departments (
	departmentsid varchar(75) not null primary key,
	departmentsparentid varchar(75) null,
	departmentscode varchar(75) null,
	departmentsname varchar(75) null,
	abbreviatename varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	agencyid varchar(75) null,
	roleid bigint,
	hasteam varchar(75) null
);

create table pml_district (
	districtId varchar(75) not null primary key,
	districtCode varchar(75) null,
	districtName varchar(75) null,
	cityID varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_do_quan_trong (
	id_do_quan_trong bigint not null primary key,
	ten_do_quan_trong varchar(75) null
);

create table pml_documentreceipt_issuingplace_log (
	documentReceiptIssuingPlaceLogId bigint not null primary key,
	documentReceiptId bigint,
	processor bigint,
	directProcessorId bigint,
	dateProcess date null,
	processInfomation varchar(75) null,
	receiver varchar(75) null,
	type_ integer,
	step integer
);

create table pml_documentreceipt_log (
	documentreceiptlogid bigint not null primary key,
	documentreceiptid bigint,
	transition_ integer,
	processer bigint,
	dateprocess date null,
	processinfomation varchar(75) null,
	receiver bigint,
	receivedate date null,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	type_ integer,
	expireddate date null,
	numdateprocess integer,
	processinstanceid bigint,
	maindepartmentprocessid varchar(75) null,
	mainuserprocessid bigint,
	senddatebefore date null,
	departmentreceiveid varchar(75) null,
	departmentprocessid varchar(75) null,
	dateProcessTime date null,
	receiveDateTime date null,
	directProcesserId bigint,
	step integer
);

create table pml_documentreceipt_wf (
	processid bigint not null primary key,
	documentreceiptid bigint,
	ismain varchar(75) null
);

create table pml_documentsend_log (
	documentsendlogid bigint not null primary key,
	documentsendid bigint,
	transition_ integer,
	processer bigint,
	dateprocess date null,
	processinfomation varchar(75) null,
	receiver bigint,
	receivedate date null,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	expireddate date null,
	numdateprocess integer,
	processinstanceid bigint,
	type_ integer,
	senddatebefore date null,
	departmentreceiveid varchar(75) null,
	departmentprocessid varchar(75) null,
	dateprocesstime date null,
	receivedatetime date null,
	directProcesserId bigint,
	step integer
);

create table pml_documentsend_wf (
	documentsendid bigint not null primary key,
	processid bigint,
	isMain varchar(75) null
);

create table pml_edm_answerdetail (
	documentreceiptid bigint not null primary key,
	documentsendid bigint
);

create table pml_edm_attachedfile (
	attachedfileid bigint not null primary key,
	objectcontentid bigint,
	objecttype varchar(75) null,
	attachedfilename varchar(75) null,
	path varchar(75) null,
	datecreated date null,
	filetype varchar(75) null,
	fileid integer,
	title varchar(75) null,
	displayorhidden boolean
);

create table pml_edm_bookdocumentrecordto (
	documentreceiptid bigint not null,
	documentrecordtoid bigint not null,
	datecreate date null,
	datecomplete date null,
	soCongVanDenPhongHienTai integer,
	primary key (documentreceiptid, documentrecordtoid)
);

create table pml_edm_bookdocumentsend (
	bookdocumentsendid bigint not null primary key,
	datecreated date null,
	currentrecord bigint,
	departmentsid varchar(75) null,
	documentrecordtypeid integer,
	yearinuse varchar(75) null,
	active varchar(75) null,
	isagency varchar(75) null,
	agencyid varchar(75) null
);

create table pml_edm_cadre (
	userid bigint not null primary key,
	positionid varchar(75) null,
	departmentsid varchar(75) null,
	handphone varchar(75) null,
	note varchar(75) null,
	active varchar(75) null
);

create table pml_edm_confidentiallevel (
	confidentiallevelid varchar(75) not null primary key,
	confidentiallevelname varchar(75) null,
	limitviewdetail boolean,
	haveprocess boolean,
	confidentiallevelsymbol integer
);

create table pml_edm_docconfuser (
	dcuId bigint not null primary key,
	userId bigint,
	viewAllDoc boolean,
	viewDepDoc varchar(75) null
);

create table pml_edm_documentdelegate (
	documentDelegateId bigint not null primary key,
	userDelegateId bigint,
	userIsDelegateId bigint,
	documentId integer,
	fromtDate date null,
	toDate date null,
	cancelDate date null
);

create table pml_edm_documentreceipt (
	documentReceiptId bigint not null primary key,
	levelsendid integer,
	documenttypeid bigint,
	documentreference varchar(75) null,
	issuingplaceid varchar(75) null,
	issuingdate date null,
	datearrive date null,
	signer varchar(75) null,
	privilegelevelid varchar(75) null,
	confidentiallevelid varchar(75) null,
	opinion varchar(75) null,
	briefcontent varchar(75) null,
	ispublic varchar(75) null,
	numberdocumentreceipt varchar(75) null,
	processtime integer,
	status varchar(75) null,
	active varchar(75) null,
	numberlocaldocumentreceipt varchar(75) null,
	issuingplaceothername varchar(75) null,
	documenttype varchar(75) null,
	datebutphe date null,
	datehoanthanh date null,
	statusid bigint,
	thoigiannhancvden varchar(75) null,
	socongvandiphucdap varchar(75) null,
	generalorderno bigint,
	maindepartmentprocessid varchar(75) null,
	mainuserprocessid bigint,
	orgexternalid bigint,
	docreceipttempid bigint,
	documentrecordtypeid integer,
	donvisaoy varchar(75) null
);

create table pml_edm_documentreceipt_temp (
	documentReceiptId bigint not null primary key,
	levelsendid integer,
	documenttypeid bigint,
	documentreference varchar(75) null,
	issuingplaceid varchar(75) null,
	issuingdate date null,
	datearrive date null,
	signer varchar(75) null,
	privilegelevelid varchar(75) null,
	confidentiallevelid varchar(75) null,
	opinion varchar(75) null,
	briefcontent varchar(75) null,
	ispublic varchar(75) null,
	numberdocumentreceipt varchar(75) null,
	processtime integer,
	status varchar(75) null,
	active varchar(75) null,
	numberlocaldocumentreceipt varchar(75) null,
	issuingplaceothername varchar(75) null,
	documenttype varchar(75) null,
	datebutphe date null,
	datehoanthanh date null,
	statusid bigint,
	thoigiannhancvden varchar(75) null,
	socongvandiphucdap varchar(75) null,
	generalorderno bigint,
	maindepartmentprocessid varchar(75) null,
	mainuserprocessid bigint,
	orgexternalid bigint
);

create table pml_edm_documentreceiptextend (
	documentreceiptextendid bigint not null primary key,
	documentreceiptid bigint,
	documentreceiptlogid bigint,
	extendorderno integer,
	startprocessdate date null,
	numdayprocessbef integer,
	limitdatebef date null,
	extendreason varchar(75) null,
	numdayprocessaft integer,
	limitdateaft date null,
	leanonlimitdate boolean,
	extenduserid bigint,
	extenddepartmentid varchar(75) null
);

create table pml_edm_documentreceiptprocesstype (
	docReceiptProcessTypeId bigint not null primary key,
	documentReceiptId bigint,
	documentReceiptLogId bigint,
	processTypeOrderNo integer,
	dateEdit date null,
	processTypeIdBefore varchar(75) null,
	processTypeIdAfter varchar(75) null,
	processTypeReason varchar(75) null,
	processerId bigint,
	departmentId varchar(75) null
);

create table pml_edm_documentrecordto (
	documentrecordtoid bigint not null primary key,
	datecreate date null,
	currentrecord bigint,
	departmentsid varchar(75) null,
	documentrecordtypeid integer,
	yearinuse varchar(75) null,
	active varchar(75) null,
	isagency varchar(75) null,
	agencyid varchar(75) null
);

create table pml_edm_documentrecordtype (
	documentrecordtypeid integer not null primary key,
	documentrecordtypename varchar(75) null,
	documentrecordtypecode varchar(75) null
);

create table pml_edm_documentrelation (
	documentrelationid bigint not null primary key,
	docleftid bigint,
	docrightid bigint,
	leftisreceipt boolean,
	rightisreceipt boolean
);

create table pml_edm_documentsend (
	documentsendid bigint not null primary key,
	briefcontent varchar(75) null,
	documentreference varchar(75) null,
	receivingplace varchar(75) null,
	issuingdate date null,
	opinion varchar(75) null,
	editorid bigint,
	signerid bigint,
	documenttypeid bigint,
	privilegelevelid varchar(75) null,
	confidentiallevelid varchar(75) null,
	datecreated date null,
	islocal boolean,
	active varchar(75) null,
	senddate date null,
	signername varchar(75) null,
	position_ varchar(75) null,
	numberpage varchar(75) null,
	numberpublish varchar(75) null,
	documentsendcode varchar(75) null,
	statusid bigint,
	iscongvanphucdap boolean,
	numofdocref bigint,
	ispublish boolean,
	orgexternalid bigint,
	numofdirector boolean,
	documentrecordtypeid integer
);

create table pml_edm_documenttype (
	documenttypeid bigint not null primary key,
	documenttypename varchar(75) null,
	documentsymbol varchar(75) null,
	documentrecordtypeid integer,
	sendreceiptdistinction integer,
	HaveDepartExtends boolean
);

create table pml_edm_issuingplace (
	issuingplaceid varchar(75) not null primary key,
	issuingplacename varchar(75) null,
	tablephone varchar(75) null,
	handphone varchar(75) null,
	email varchar(75) null,
	address varchar(75) null,
	active varchar(75) null,
	note varchar(75) null,
	issuingplacecode varchar(75) null,
	signer varchar(75) null
);

create table pml_edm_levelsend (
	levelsendid integer not null primary key,
	levelsendname varchar(75) null,
	levelsendcode varchar(75) null
);

create table pml_edm_levelsenddetail (
	levelsendid integer not null,
	issuingPlaceId varchar(75) not null,
	primary key (levelsendid, issuingPlaceId)
);

create table pml_edm_privilegelevel (
	privilegelevelid varchar(75) not null primary key,
	privilegelevelname varchar(75) null
);

create table pml_edm_processdocumentreceiptdetail (
	id bigint not null primary key,
	documentreceiptid bigint,
	userid bigint,
	note varchar(75) null,
	datecreated date null,
	dateupdate date null
);

create table pml_edm_writedocumentsend (
	bookdocumentsendid bigint not null,
	documentsendid bigint not null,
	datecreated date null,
	soCongVanDiPhongHienTai integer,
	primary key (bookdocumentsendid, documentsendid)
);

create table pml_field (
	fieldId varchar(75) not null primary key,
	fieldCode varchar(75) null,
	fieldName varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	departmentsId varchar(75) null
);

create table pml_file (
	fileId varchar(75) not null primary key,
	cityId varchar(75) null,
	districtId varchar(75) null,
	wardsId varchar(75) null,
	streetId varchar(75) null,
	exactReturningDate date null,
	receiverId bigint,
	validDate date null,
	expectedReturningDate date null,
	applicationDate date null,
	otherContent varchar(75) null,
	briefContent varchar(75) null,
	applicantName varchar(75) null,
	organization varchar(75) null,
	authorisedLetter varchar(75) null,
	idNumber varchar(75) null,
	issuingDate date null,
	issuingPlace varchar(75) null,
	telephone varchar(75) null,
	gender varchar(75) null,
	streetNumber varchar(75) null,
	permanentAddress varchar(75) null,
	contactInfomation varchar(75) null,
	oldNumberReceipt varchar(75) null,
	numberReceipt varchar(75) null,
	fileTypeId varchar(75) null,
	fieldId varchar(75) null,
	solvingTime integer,
	amendedContent varchar(75) null,
	landCheckingDate date null,
	decisionNotice varchar(75) null,
	receiver varchar(75) null,
	dateCreated date null,
	lastUpdate date null,
	lasttestprocessinfo varchar(75) null,
	active varchar(75) null,
	generalorderno bigint
);

create table pml_file_attachedfile (
	fileAttachedFileId varchar(75) not null primary key,
	fileId varchar(75) null,
	original integer,
	copy_ integer,
	attachedFileId varchar(75) null,
	attachedFileName varchar(75) null,
	note varchar(75) null
);

create table pml_file_pccc (
	fileid varchar(75) not null primary key,
	fileName varchar(75) null,
	applicantrepresentation varchar(75) null,
	applicanttelephone varchar(75) null,
	receiverrepresentation varchar(75) null,
	receivertelephone varchar(75) null,
	projectname varchar(75) null,
	applicantcategory varchar(75) null,
	addressbuilder varchar(75) null,
	investor varchar(75) null,
	designCop varchar(75) null,
	filenumber integer,
	inputdatadate date null,
	noteinformationmanagement varchar(75) null,
	totalhour integer,
	totaldate integer,
	conclusion varchar(75) null,
	receiveofunit varchar(75) null,
	applicanttime varchar(75) null
);

create table pml_filepccc_attachedfile (
	attachedfileid bigint not null primary key,
	filepcccid varchar(75) null,
	objecttype varchar(75) null,
	attachedfilename varchar(75) null,
	path varchar(75) null,
	datecreated date null,
	filetype varchar(75) null,
	title varchar(75) null
);

create table pml_filereturninginfo (
	filereturninginfoid bigint not null primary key,
	fileid varchar(75) null,
	filesender varchar(75) null,
	licensenumber varchar(75) null,
	issuingdatelicense date null,
	receivelicensedate date null,
	documentnumber varchar(75) null,
	billnumber varchar(75) null,
	numbermoney bigint,
	note varchar(75) null,
	conclude varchar(75) null
);

create table pml_filestatus (
	filestatusid bigint not null primary key,
	filestatuscode varchar(75) null,
	filestatusname varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	type varchar(75) null
);

create table pml_filestatus_stateprocess (
	id bigint not null primary key,
	filestatusid bigint,
	stateprocessid bigint,
	description varchar(75) null
);

create table pml_filetype (
	fileTypeId varchar(75) not null primary key,
	fileTypeCode varchar(75) null,
	fileTypeName varchar(75) null,
	fieldId varchar(75) null,
	templateId varchar(75) null,
	processTime varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	currentReceiptNumber varchar(75) null,
	receiptTemplate varchar(75) null
);

create table pml_filetype_attachedfile (
	filetypeAttachedFileId varchar(75) not null primary key,
	fileTypeId varchar(75) null,
	original integer,
	copy_ integer,
	attachedFileId varchar(75) null,
	attachedFileName varchar(75) null,
	note varchar(75) null
);

create table pml_filetypedelegate (
	filetypedelegateid bigint not null primary key,
	filetypeid varchar(75) null,
	delegateid bigint
);

create table pml_ho_so_cong_viec (
	id_ho_so_cong_viec bigint not null primary key,
	userId bigint,
	userName varchar(75) null,
	id_hscv_cha bigint,
	so_hieu_hscv varchar(75) null,
	tieu_de varchar(75) null,
	ngay_mo_hscv date null,
	han_xu_ly date null,
	id_linh_vuc varchar(75) null,
	van_de_lien_quan varchar(75) null,
	id_do_quan_trong bigint,
	id_tinh_chat bigint,
	id_trang_thai_hscv bigint,
	tom_tat_noi_dung varchar(75) null,
	hoat_dong varchar(75) null
);

create table pml_holiday (
	holidayid bigint not null primary key,
	holiday_type varchar(75) null,
	holiday_value varchar(75) null,
	from_date date null,
	to_date date null
);

create table pml_main_support (
	processid bigint not null primary key,
	processid_main bigint,
	type_ varchar(75) null,
	supportinfomation varchar(75) null
);

create table pml_manage_documentworkflow (
	managedocumentworkflowid bigint not null primary key,
	workflowname varchar(75) null,
	version_ integer,
	type_ integer,
	description varchar(75) null,
	startdate date null,
	enddate date null
);

create table pml_message_note (
	messageId bigint not null primary key,
	documentId bigint,
	fromUserId bigint,
	toUserId bigint,
	createDate date null,
	objectType varchar(75) null,
	isAlert boolean
);

create table pml_nation (
	nationid varchar(75) not null primary key,
	nationcode varchar(75) null,
	nationname varchar(75) null,
	countryid varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_organization_external (
	orgexternalid bigint not null primary key,
	orgexternalcode varchar(75) null,
	orgexternalname varchar(75) null,
	isownerorg boolean
);

create table pml_paintdocument (
	paintdocumentid bigint not null primary key,
	fileid varchar(75) null,
	paintdocumentname varchar(75) null,
	quantity integer,
	note varchar(75) null
);

create table pml_position (
	positionid varchar(75) not null primary key,
	positioncode varchar(75) null,
	positionname varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_processdispose (
	processdisposeid bigint not null primary key,
	fileid varchar(75) null,
	transition_ integer,
	processer bigint,
	dateprocess date null,
	processinfomation varchar(75) null,
	receiver bigint,
	receivedate date null,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	expireddate date null,
	delegateuser bigint,
	senddate date null
);

create table pml_processtype (
	processtypeid bigint not null primary key,
	name varchar(75) null,
	flagprocesstype integer
);

create table pml_role (
	roleid varchar(75) not null primary key,
	rolecode varchar(75) null,
	rolename varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_room_resource (
	roomId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate date null,
	modifiedDate date null,
	roomName varchar(255) null,
	description long varchar null
);

create table pml_saveprocesstype (
	sptid bigint not null primary key,
	docId bigint,
	flagprocesstype bigint,
	flag boolean
);

create table pml_screecalendar_heigth (
	screesalendarheigthid bigint not null primary key
);

create table pml_screencalendar_height (
	screencalendarheightid bigint not null primary key
);

create table pml_signer (
	signerId bigint not null primary key,
	userId bigint
);

create table pml_state_department (
	departmentid varchar(75) not null,
	statewfid bigint not null,
	primary key (departmentid, statewfid)
);

create table pml_state_wf (
	statewfid bigint not null primary key,
	workflow varchar(75) null,
	stateprocessid bigint,
	solvingtime integer,
	version_ integer
);

create table pml_stateprocess (
	stateprocessid bigint not null primary key,
	stateprocesscode varchar(75) null,
	stateprocessname varchar(75) null,
	filestatusid bigint,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_street (
	streetId varchar(75) not null primary key,
	streetName varchar(75) null
);

create table pml_team (
	teamid bigint not null primary key,
	departmentid varchar(75) null,
	teamname varchar(75) null,
	description varchar(75) null,
	organizationid bigint,
	companyid bigint,
	specialteam varchar(75) null,
	teamcode varchar(75) null
);

create table pml_teamleader (
	teamid bigint not null primary key,
	userid bigint
);

create table pml_template (
	templateId bigint not null primary key,
	templateCode varchar(75) null,
	templateName varchar(75) null,
	numberOfDocument integer,
	publishDate date null,
	departmentId varchar(75) null
);

create table pml_template_file (
	fileTemplateId bigint not null primary key,
	templateId bigint,
	tenFile varchar(75) null,
	kichThuoc bigint,
	duongDan varchar(75) null
);

create table pml_tinh_chat (
	id_tinh_chat bigint not null primary key,
	ten_tinh_chat varchar(75) null
);

create table pml_trang_thai_hscv (
	id_trang_thai_hscv bigint not null primary key,
	ten_trang_thai_hscv varchar(75) null
);

create table pml_transition (
	transitionid bigint not null primary key,
	transitionname varchar(75) null,
	filetypeid varchar(75) null,
	notransition integer,
	stateprocesscurrent bigint,
	stateprocessnext bigint,
	version_ varchar(75) null
);

create table pml_user (
	userId bigint not null primary key,
	positionId varchar(75) null,
	departmentsId varchar(75) null,
	roleId varchar(75) null,
	handphone varchar(75) null,
	note varchar(75) null,
	teamid bigint,
	active boolean,
	screenname varchar(75) null,
	firstname varchar(75) null,
	middlename varchar(75) null,
	lastname varchar(75) null,
	male boolean,
	birthday date null,
	isleadermetting boolean
);

create table pml_user_file_type (
	userid bigint not null,
	filetypeid varchar(75) not null,
	description varchar(75) null,
	primary key (userid, filetypeid)
);

create table pml_wards (
	wardsId varchar(75) not null primary key,
	wardsCode varchar(75) null,
	wardsName varchar(75) null,
	districtId varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
);

create table pml_wf_onedoor (
	fileId varchar(75) not null primary key,
	processId bigint,
	nodeId bigint
);

create table pml_workflow (
	workflowId bigint not null primary key,
	fileTypeId varchar(75) null,
	workflow varchar(75) null,
	version_ integer,
	startDate date null,
	endDate date null
);

create table report_registry_work (
	reportRegistryId bigint not null primary key,
	reportRegistryCode varchar(75) null,
	userCreate varchar(75) null,
	resultWork varchar(75) null,
	programWork varchar(75) null,
	reportDate date null,
	departmentId bigint,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table result_program_file (
	resultProgramId bigint not null primary key,
	resultProgramTitle varchar(75) null,
	resultProgramPath varchar(75) null,
	resultProgramCheck varchar(75) null,
	reportRegistryId bigint,
	userId bigint,
	groupId bigint,
	companyId bigint
);



insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (1, 'Canada', 'CA', 'CAN', '124', '001', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (2, 'China', 'CN', 'CHN', '156', '086', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (3, 'France', 'FR', 'FRA', '250', '033', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (4, 'Germany', 'DE', 'DEU', '276', '049', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (5, 'Hong Kong', 'HK', 'HKG', '344', '852', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (6, 'Hungary', 'HU', 'HUN', '348', '036', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (7, 'Israel', 'IL', 'ISR', '376', '972', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (8, 'Italy', 'IT', 'ITA', '380', '039', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (9, 'Japan', 'JP', 'JPN', '392', '081', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (10, 'South Korea', 'KR', 'KOR', '410', '082', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (11, 'Netherlands', 'NL', 'NLD', '528', '031', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (12, 'Portugal', 'PT', 'PRT', '620', '351', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (13, 'Russia', 'RU', 'RUS', '643', '007', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (14, 'Singapore', 'SG', 'SGP', '702', '065', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (15, 'Spain', 'ES', 'ESP', '724', '034', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (16, 'Turkey', 'TR', 'TUR', '792', '090', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (17, 'Vietnam', 'VM', 'VNM', '704', '084', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (18, 'United Kingdom', 'GB', 'GBR', '826', '044', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (19, 'United States', 'US', 'USA', '840', '001', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (20, 'Afghanistan', 'AF', 'AFG', '4', '093', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (21, 'Albania', 'AL', 'ALB', '8', '355', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (22, 'Algeria', 'DZ', 'DZA', '12', '213', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (23, 'American Samoa', 'AS', 'ASM', '16', '684', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (24, 'Andorra', 'AD', 'AND', '20', '376', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (25, 'Angola', 'AO', 'AGO', '24', '244', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (26, 'Anguilla', 'AI', 'AIA', '660', '264', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (27, 'Antarctica', 'AQ', 'ATA', '10', '672', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (28, 'Antigua', 'AG', 'ATG', '28', '268', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (29, 'Argentina', 'AR', 'ARG', '32', '054', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (30, 'Armenia', 'AM', 'ARM', '51', '374', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (31, 'Aruba', 'AW', 'ABW', '533', '297', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (32, 'Australia', 'AU', 'AUS', '36', '061', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (33, 'Austria', 'AT', 'AUT', '40', '043', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (34, 'Azerbaijan', 'AZ', 'AZE', '31', '994', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (35, 'Bahamas', 'BS', 'BHS', '44', '242', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (36, 'Bahrain', 'BH', 'BHR', '48', '973', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (37, 'Bangladesh', 'BD', 'BGD', '50', '880', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (38, 'Barbados', 'BB', 'BRB', '52', '246', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (39, 'Belarus', 'BY', 'BLR', '112', '375', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (40, 'Belgium', 'BE', 'BEL', '56', '032', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (41, 'Belize', 'BZ', 'BLZ', '84', '501', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (42, 'Benin', 'BJ', 'BEN', '204', '229', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (43, 'Bermuda', 'BM', 'BMU', '60', '441', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (44, 'Bhutan', 'BT', 'BTN', '64', '975', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (45, 'Bolivia', 'BO', 'BOL', '68', '591', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (46, 'Bosnia-Herzegovina', 'BA', 'BIH', '70', '387', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (47, 'Botswana', 'BW', 'BWA', '72', '267', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (48, 'Brazil', 'BR', 'BRA', '76', '055', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (49, 'British Virgin Islands', 'VG', 'VGB', '92', '284', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (50, 'Brunei', 'BN', 'BRN', '96', '673', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (51, 'Bulgaria', 'BG', 'BGR', '100', '359', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (52, 'Burkina Faso', 'BF', 'BFA', '854', '226', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (53, 'Burma (Myanmar)', 'MM', 'MMR', '104', '095', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (54, 'Burundi', 'BI', 'BDI', '108', '257', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (55, 'Cambodia', 'KH', 'KHM', '116', '855', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (56, 'Cameroon', 'CM', 'CMR', '120', '237', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (57, 'Cape Verde Island', 'CV', 'CPV', '132', '238', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (58, 'Cayman Islands', 'KY', 'CYM', '136', '345', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (59, 'Central African Republic', 'CF', 'CAF', '140', '236', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (60, 'Chad', 'TD', 'TCD', '148', '235', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (61, 'Chile', 'CL', 'CHL', '152', '056', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (62, 'Christmas Island', 'CX', 'CXR', '162', '061', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (63, 'Cocos Islands', 'CC', 'CCK', '166', '061', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (64, 'Colombia', 'CO', 'COL', '170', '057', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (65, 'Comoros', 'KM', 'COM', '174', '269', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (66, 'Republic of Congo', 'CD', 'COD', '180', '242', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (67, 'Democratic Republic of Congo', 'CG', 'COG', '178', '243', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (68, 'Cook Islands', 'CK', 'COK', '184', '682', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (69, 'Costa Rica', 'CR', 'CRI', '188', '506', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (70, 'Croatia', 'HR', 'HRV', '191', '385', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (71, 'Cuba', 'CU', 'CUB', '192', '053', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (72, 'Cyprus', 'CY', 'CYP', '196', '357', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (73, 'Czech Republic', 'CZ', 'CZE', '203', '420', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (74, 'Denmark', 'DK', 'DNK', '208', '045', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (75, 'Djibouti', 'DJ', 'DJI', '262', '253', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (76, 'Dominica', 'DM', 'DMA', '212', '767', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (77, 'Dominican Republic', 'DO', 'DOM', '214', '809', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (78, 'Ecuador', 'EC', 'ECU', '218', '593', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (79, 'Egypt', 'EG', 'EGY', '818', '020', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (80, 'El Salvador', 'SV', 'SLV', '222', '503', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (81, 'Equatorial Guinea', 'GQ', 'GNQ', '226', '240', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (82, 'Eritrea', 'ER', 'ERI', '232', '291', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (83, 'Estonia', 'EE', 'EST', '233', '372', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (84, 'Ethiopia', 'ET', 'ETH', '231', '251', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (85, 'Faeroe Islands', 'FO', 'FRO', '234', '298', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (86, 'Falkland Islands', 'FK', 'FLK', '238', '500', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (87, 'Fiji Islands', 'FJ', 'FJI', '242', '679', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (88, 'Finland', 'FI', 'FIN', '246', '358', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (89, 'French Guiana', 'GF', 'GUF', '254', '594', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (90, 'French Polynesia', 'PF', 'PYF', '258', '689', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (91, 'Gabon', 'GA', 'GAB', '266', '241', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (92, 'Gambia', 'GM', 'GMB', '270', '220', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (93, 'Georgia', 'GE', 'GEO', '268', '995', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (94, 'Ghana', 'GH', 'GHA', '288', '233', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (95, 'Gibraltar', 'GI', 'GIB', '292', '350', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (96, 'Greece', 'GR', 'GRC', '300', '030', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (97, 'Greenland', 'GL', 'GRL', '304', '299', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (98, 'Grenada', 'GD', 'GRD', '308', '473', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (99, 'Guadeloupe', 'GP', 'GLP', '312', '590', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (100, 'Guam', 'GU', 'GUM', '316', '671', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (101, 'Guatemala', 'GT', 'GTM', '320', '502', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (102, 'Guinea', 'GN', 'GIN', '324', '224', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (103, 'Guinea-Bissau', 'GW', 'GNB', '624', '245', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (104, 'Guyana', 'GY', 'GUY', '328', '592', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (105, 'Haiti', 'HT', 'HTI', '332', '509', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (106, 'Honduras', 'HN', 'HND', '340', '504', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (107, 'Iceland', 'IS', 'ISL', '352', '354', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (108, 'India', 'IN', 'IND', '356', '091', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (109, 'Indonesia', 'ID', 'IDN', '360', '062', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (110, 'Iran', 'IR', 'IRN', '364', '098', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (111, 'Iraq', 'IQ', 'IRQ', '368', '964', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (112, 'Ireland', 'IE', 'IRL', '372', '353', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (113, 'Ivory Coast', 'CI', 'CIV', '384', '225', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (114, 'Jamaica', 'JM', 'JAM', '388', '876', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (115, 'Jordan', 'JO', 'JOR', '400', '962', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (116, 'Kazakhstan', 'KZ', 'KAZ', '398', '007', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (117, 'Kenya', 'KE', 'KEN', '404', '254', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (118, 'Kiribati', 'KI', 'KIR', '408', '686', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (119, 'Kuwait', 'KW', 'KWT', '414', '965', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (120, 'North Korea', 'KP', 'PRK', '408', '850', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (121, 'Kyrgyzstan', 'KG', 'KGZ', '471', '996', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (122, 'Laos', 'LA', 'LAO', '418', '856', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (123, 'Latvia', 'LV', 'LVA', '428', '371', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (124, 'Lebanon', 'LB', 'LBN', '422', '961', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (125, 'Lesotho', 'LS', 'LSO', '426', '266', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (126, 'Liberia', 'LR', 'LBR', '430', '231', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (127, 'Libya', 'LY', 'LBY', '434', '218', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (128, 'Liechtenstein', 'LI', 'LIE', '438', '423', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (129, 'Lithuania', 'LT', 'LTU', '440', '370', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (130, 'Luxembourg', 'LU', 'LUX', '442', '352', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (131, 'Macau', 'MO', 'MAC', '446', '853', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (132, 'Macedonia', 'MK', 'MKD', '807', '389', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (133, 'Madagascar', 'MG', 'MDG', '450', '261', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (134, 'Malawi', 'MW', 'MWI', '454', '265', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (135, 'Malaysia', 'MY', 'MYS', '458', '060', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (136, 'Maldives', 'MV', 'MDV', '462', '960', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (137, 'Mali', 'ML', 'MLI', '466', '223', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (138, 'Malta', 'MT', 'MLT', '470', '356', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (139, 'Marshall Islands', 'MH', 'MHL', '584', '692', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (140, 'Martinique', 'MQ', 'MTQ', '474', '596', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (141, 'Mauritania', 'MR', 'MRT', '478', '222', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (142, 'Mauritius', 'MU', 'MUS', '480', '230', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (143, 'Mayotte Island', 'YT', 'MYT', '175', '269', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (144, 'Mexico', 'MX', 'MEX', '484', '052', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (145, 'Micronesia', 'FM', 'FSM', '583', '691', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (146, 'Moldova', 'MD', 'MDA', '498', '373', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (147, 'Monaco', 'MC', 'MCO', '492', '377', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (148, 'Mongolia', 'MN', 'MNG', '496', '976', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (149, 'Montenegro', 'ME', 'MNE', '499', '382', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (150, 'Montserrat', 'MS', 'MSR', '500', '664', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (151, 'Morocco', 'MA', 'MAR', '504', '212', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (152, 'Mozambique', 'MZ', 'MOZ', '508', '258', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (153, 'Namibia', 'NA', 'NAM', '516', '264', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (154, 'Nauru', 'NR', 'NRU', '520', '674', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (155, 'Nepal', 'NP', 'NPL', '524', '977', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (156, 'Netherlands Antilles', 'AN', 'ANT', '530', '599', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (157, 'New Caledonia', 'NC', 'NCL', '540', '687', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (158, 'New Zealand', 'NZ', 'NZL', '554', '064', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (159, 'Nicaragua', 'NI', 'NIC', '558', '505', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (160, 'Niger', 'NE', 'NER', '562', '227', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (161, 'Nigeria', 'NG', 'NGA', '566', '234', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (162, 'Niue', 'NU', 'NIU', '570', '683', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (163, 'Norfolk Island', 'NF', 'NFK', '574', '672', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (164, 'Norway', 'NO', 'NOR', '578', '047', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (165, 'Oman', 'OM', 'OMN', '512', '968', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (166, 'Pakistan', 'PK', 'PAK', '586', '092', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (167, 'Palau', 'PW', 'PLW', '585', '680', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (168, 'Palestine', 'PS', 'PSE', '275', '970', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (169, 'Panama', 'PA', 'PAN', '591', '507', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (170, 'Papua New Guinea', 'PG', 'PNG', '598', '675', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (171, 'Paraguay', 'PY', 'PRY', '600', '595', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (172, 'Peru', 'PE', 'PER', '604', '051', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (173, 'Philippines', 'PH', 'PHL', '608', '063', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (174, 'Poland', 'PL', 'POL', '616', '048', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (175, 'Puerto Rico', 'PR', 'PRI', '630', '787', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (176, 'Qatar', 'QA', 'QAT', '634', '974', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (177, 'Reunion Island', 'RE', 'REU', '638', '262', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (178, 'Romania', 'RO', 'ROU', '642', '040', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (179, 'Rwanda', 'RW', 'RWA', '646', '250', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (180, 'St. Helena', 'SH', 'SHN', '654', '290', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (181, 'St. Kitts', 'KN', 'KNA', '659', '869', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (182, 'St. Lucia', 'LC', 'LCA', '662', '758', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (183, 'St. Pierre & Miquelon', 'PM', 'SPM', '666', '508', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (184, 'St. Vincent', 'VC', 'VCT', '670', '784', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (185, 'San Marino', 'SM', 'SMR', '674', '378', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (186, 'Sao Tome & Principe', 'ST', 'STP', '678', '239', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (187, 'Saudi Arabia', 'SA', 'SAU', '682', '966', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (188, 'Senegal', 'SN', 'SEN', '686', '221', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (189, 'Serbia', 'RS', 'SRB', '688', '381', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (190, 'Seychelles', 'SC', 'SYC', '690', '248', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (191, 'Sierra Leone', 'SL', 'SLE', '694', '249', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (192, 'Slovakia', 'SK', 'SVK', '703', '421', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (193, 'Slovenia', 'SI', 'SVN', '705', '386', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (194, 'Solomon Islands', 'SB', 'SLB', '90', '677', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (195, 'Somalia', 'SO', 'SOM', '706', '252', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (196, 'South Africa', 'ZA', 'ZAF', '710', '027', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (197, 'Sri Lanka', 'LK', 'LKA', '144', '094', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (198, 'Sudan', 'SD', 'SDN', '736', '095', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (199, 'Suriname', 'SR', 'SUR', '740', '597', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (200, 'Swaziland', 'SZ', 'SWZ', '748', '268', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (201, 'Sweden', 'SE', 'SWE', '752', '046', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (202, 'Switzerland', 'CH', 'CHE', '756', '041', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (203, 'Syria', 'SY', 'SYR', '760', '963', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (204, 'Taiwan', 'TW', 'TWN', '158', '886', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (205, 'Tajikistan', 'TJ', 'TJK', '762', '992', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (206, 'Tanzania', 'TZ', 'TZA', '834', '255', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (207, 'Thailand', 'TH', 'THA', '764', '066', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (208, 'Togo', 'TG', 'TGO', '768', '228', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (209, 'Tonga', 'TO', 'TON', '776', '676', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (210, 'Trinidad & Tobago', 'TT', 'TTO', '780', '868', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (211, 'Tunisia', 'TN', 'TUN', '788', '216', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (212, 'Turkmenistan', 'TM', 'TKM', '795', '993', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (213, 'Turks & Caicos', 'TC', 'TCA', '796', '649', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (214, 'Tuvalu', 'TV', 'TUV', '798', '688', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (215, 'Uganda', 'UG', 'UGA', '800', '256', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (216, 'Ukraine', 'UA', 'UKR', '804', '380', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (217, 'United Arab Emirates', 'AE', 'ARE', '784', '971', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (218, 'Uruguay', 'UY', 'URY', '858', '598', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (219, 'Uzbekistan', 'UZ', 'UZB', '860', '998', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (220, 'Vanuatu', 'VU', 'VUT', '548', '678', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (221, 'Vatican City', 'VA', 'VAT', '336', '039', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (222, 'Venezuela', 'VE', 'VEN', '862', '058', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (223, 'Wallis & Futuna', 'WF', 'WLF', '876', '681', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (224, 'Western Samoa', 'EH', 'ESH', '732', '685', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (225, 'Yemen', 'YE', 'YEM', '887', '967', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (226, 'Zambia', 'ZM', 'ZMB', '894', '260', TRUE);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (227, 'Zimbabwe', 'ZW', 'ZWE', '716', '263', TRUE);

insert into Region (regionId, countryId, regionCode, name, active_) values (1, 19, 'AL', 'Alabama', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (2, 19, 'AK', 'Alaska', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (3, 19, 'AZ', 'Arizona', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (4, 19, 'AR', 'Arkansas', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (5, 19, 'CA', 'California', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (6, 19, 'CO', 'Colorado', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (7, 19, 'CT', 'Connecticut', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (8, 19, 'DC', 'District of Columbia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (9, 19, 'DE', 'Delaware', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (10, 19, 'FL', 'Florida', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (11, 19, 'GA', 'Georgia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (12, 19, 'HI', 'Hawaii', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (13, 19, 'ID', 'Idaho', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (14, 19, 'IL', 'Illinois', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (15, 19, 'IN', 'Indiana', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (16, 19, 'IA', 'Iowa', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (17, 19, 'KS', 'Kansas', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (18, 19, 'KY', 'Kentucky ', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (19, 19, 'LA', 'Louisiana ', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (20, 19, 'ME', 'Maine', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (21, 19, 'MD', 'Maryland', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (22, 19, 'MA', 'Massachusetts', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (23, 19, 'MI', 'Michigan', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (24, 19, 'MN', 'Minnesota', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (25, 19, 'MS', 'Mississippi', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (26, 19, 'MO', 'Missouri', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (27, 19, 'MT', 'Montana', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (28, 19, 'NE', 'Nebraska', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (29, 19, 'NV', 'Nevada', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (30, 19, 'NH', 'New Hampshire', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (31, 19, 'NJ', 'New Jersey', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (32, 19, 'NM', 'New Mexico', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (33, 19, 'NY', 'New York', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (34, 19, 'NC', 'North Carolina', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (35, 19, 'ND', 'North Dakota', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (36, 19, 'OH', 'Ohio', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (37, 19, 'OK', 'Oklahoma ', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (38, 19, 'OR', 'Oregon', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (39, 19, 'PA', 'Pennsylvania', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (40, 19, 'PR', 'Puerto Rico', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (41, 19, 'RI', 'Rhode Island', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (42, 19, 'SC', 'South Carolina', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (43, 19, 'SD', 'South Dakota', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (44, 19, 'TN', 'Tennessee', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (45, 19, 'TX', 'Texas', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (46, 19, 'UT', 'Utah', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (47, 19, 'VT', 'Vermont', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (48, 19, 'VA', 'Virginia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (49, 19, 'WA', 'Washington', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (50, 19, 'WV', 'West Virginia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (51, 19, 'WI', 'Wisconsin', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (52, 19, 'WY', 'Wyoming', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (53, 1, 'AL', 'Alberta', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (54, 1, 'BC', 'British Columbia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (55, 1, 'MB', 'Manitoba', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (56, 1, 'NB', 'New Brunswick', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (57, 1, 'NL', 'Newfoundland and Labrador', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (58, 1, 'NT', 'Northwest Territories', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (59, 1, 'NS', 'Nova Scotia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (60, 1, 'NU', 'Nunavut', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (61, 1, 'ON', 'Ontario', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (62, 1, 'PE', 'Prince Edward Island', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (63, 1, 'QC', 'Quebec', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (64, 1, 'SK', 'Saskatchewan', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (65, 1, 'YT', 'Yukon', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (66, 15, 'AN', 'Andalusia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (67, 15, 'AR', 'Aragon', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (68, 15, 'AS', 'Asturias', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (69, 15, 'IB', 'Balearic Islands', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (70, 15, 'PV', 'Basque Country', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (71, 15, 'CN', 'Canary Islands', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (72, 15, 'CB', 'Cantabria', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (73, 15, 'CL', 'Castile and Leon', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (74, 15, 'CM', 'Castile-La Mancha', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (75, 15, 'CT', 'Catalonia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (76, 15, 'CE', 'Ceuta', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (77, 15, 'EX', 'Extremadura', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (78, 15, 'GA', 'Galicia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (79, 15, 'LO', 'La Rioja', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (80, 15, 'M', 'Madrid', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (81, 15, 'ML', 'Melilla', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (82, 15, 'MU', 'Murcia', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (83, 15, 'NA', 'Navarra', TRUE);
insert into Region (regionId, countryId, regionCode, name, active_) values (84, 15, 'VC', 'Valencia', TRUE);

--
-- List types for accounts
--

insert into ListType (listTypeId, name, type_) values (10000, 'Billing', 'com.liferay.portal.model.Account.address');
insert into ListType (listTypeId, name, type_) values (10001, 'Other', 'com.liferay.portal.model.Account.address');
insert into ListType (listTypeId, name, type_) values (10002, 'P.O. Box', 'com.liferay.portal.model.Account.address');
insert into ListType (listTypeId, name, type_) values (10003, 'Shipping', 'com.liferay.portal.model.Account.address');

insert into ListType (listTypeId, name, type_) values (10004, 'E-mail', 'com.liferay.portal.model.Account.emailAddress');
insert into ListType (listTypeId, name, type_) values (10005, 'E-mail 2', 'com.liferay.portal.model.Account.emailAddress');
insert into ListType (listTypeId, name, type_) values (10006, 'E-mail 3', 'com.liferay.portal.model.Account.emailAddress');

insert into ListType (listTypeId, name, type_) values (10007, 'Fax', 'com.liferay.portal.model.Account.phone');
insert into ListType (listTypeId, name, type_) values (10008, 'Local', 'com.liferay.portal.model.Account.phone');
insert into ListType (listTypeId, name, type_) values (10009, 'Other', 'com.liferay.portal.model.Account.phone');
insert into ListType (listTypeId, name, type_) values (10010, 'Toll-Free', 'com.liferay.portal.model.Account.phone');
insert into ListType (listTypeId, name, type_) values (10011, 'TTY', 'com.liferay.portal.model.Account.phone');

insert into ListType (listTypeId, name, type_) values (10012, 'Intranet', 'com.liferay.portal.model.Account.website');
insert into ListType (listTypeId, name, type_) values (10013, 'Public', 'com.liferay.portal.model.Account.website');

--
-- List types for contacts
--

insert into ListType (listTypeId, name, type_) values (11000, 'Business', 'com.liferay.portal.model.Contact.address');
insert into ListType (listTypeId, name, type_) values (11001, 'Other', 'com.liferay.portal.model.Contact.address');
insert into ListType (listTypeId, name, type_) values (11002, 'Personal', 'com.liferay.portal.model.Contact.address');

insert into ListType (listTypeId, name, type_) values (11003, 'E-mail', 'com.liferay.portal.model.Contact.emailAddress');
insert into ListType (listTypeId, name, type_) values (11004, 'E-mail 2', 'com.liferay.portal.model.Contact.emailAddress');
insert into ListType (listTypeId, name, type_) values (11005, 'E-mail 3', 'com.liferay.portal.model.Contact.emailAddress');

insert into ListType (listTypeId, name, type_) values (11006, 'Business', 'com.liferay.portal.model.Contact.phone');
insert into ListType (listTypeId, name, type_) values (11007, 'Business Fax', 'com.liferay.portal.model.Contact.phone');
insert into ListType (listTypeId, name, type_) values (11008, 'Mobile', 'com.liferay.portal.model.Contact.phone');
insert into ListType (listTypeId, name, type_) values (11009, 'Other', 'com.liferay.portal.model.Contact.phone');
insert into ListType (listTypeId, name, type_) values (11010, 'Pager', 'com.liferay.portal.model.Contact.phone');
insert into ListType (listTypeId, name, type_) values (11011, 'Personal', 'com.liferay.portal.model.Contact.phone');
insert into ListType (listTypeId, name, type_) values (11012, 'Personal Fax', 'com.liferay.portal.model.Contact.phone');
insert into ListType (listTypeId, name, type_) values (11013, 'TTY', 'com.liferay.portal.model.Contact.phone');

insert into ListType (listTypeId, name, type_) values (11014, 'Dr.', 'com.liferay.portal.model.Contact.prefix');
insert into ListType (listTypeId, name, type_) values (11015, 'Mr.', 'com.liferay.portal.model.Contact.prefix');
insert into ListType (listTypeId, name, type_) values (11016, 'Mrs.', 'com.liferay.portal.model.Contact.prefix');
insert into ListType (listTypeId, name, type_) values (11017, 'Ms.', 'com.liferay.portal.model.Contact.prefix');

insert into ListType (listTypeId, name, type_) values (11020, 'II', 'com.liferay.portal.model.Contact.suffix');
insert into ListType (listTypeId, name, type_) values (11021, 'III', 'com.liferay.portal.model.Contact.suffix');
insert into ListType (listTypeId, name, type_) values (11022, 'IV', 'com.liferay.portal.model.Contact.suffix');
insert into ListType (listTypeId, name, type_) values (11023, 'Jr.', 'com.liferay.portal.model.Contact.suffix');
insert into ListType (listTypeId, name, type_) values (11024, 'PhD.', 'com.liferay.portal.model.Contact.suffix');
insert into ListType (listTypeId, name, type_) values (11025, 'Sr.', 'com.liferay.portal.model.Contact.suffix');

insert into ListType (listTypeId, name, type_) values (11026, 'Blog', 'com.liferay.portal.model.Contact.website');
insert into ListType (listTypeId, name, type_) values (11027, 'Business', 'com.liferay.portal.model.Contact.website');
insert into ListType (listTypeId, name, type_) values (11028, 'Other', 'com.liferay.portal.model.Contact.website');
insert into ListType (listTypeId, name, type_) values (11029, 'Personal', 'com.liferay.portal.model.Contact.website');

--
-- List types for organizations
--

insert into ListType (listTypeId, name, type_) values (12000, 'Billing', 'com.liferay.portal.model.Organization.address');
insert into ListType (listTypeId, name, type_) values (12001, 'Other', 'com.liferay.portal.model.Organization.address');
insert into ListType (listTypeId, name, type_) values (12002, 'P.O. Box', 'com.liferay.portal.model.Organization.address');
insert into ListType (listTypeId, name, type_) values (12003, 'Shipping', 'com.liferay.portal.model.Organization.address');

insert into ListType (listTypeId, name, type_) values (12004, 'E-mail', 'com.liferay.portal.model.Organization.emailAddress');
insert into ListType (listTypeId, name, type_) values (12005, 'E-mail 2', 'com.liferay.portal.model.Organization.emailAddress');
insert into ListType (listTypeId, name, type_) values (12006, 'E-mail 3', 'com.liferay.portal.model.Organization.emailAddress');

insert into ListType (listTypeId, name, type_) values (12007, 'Fax', 'com.liferay.portal.model.Organization.phone');
insert into ListType (listTypeId, name, type_) values (12008, 'Local', 'com.liferay.portal.model.Organization.phone');
insert into ListType (listTypeId, name, type_) values (12009, 'Other', 'com.liferay.portal.model.Organization.phone');
insert into ListType (listTypeId, name, type_) values (12010, 'Toll-Free', 'com.liferay.portal.model.Organization.phone');
insert into ListType (listTypeId, name, type_) values (12011, 'TTY', 'com.liferay.portal.model.Organization.phone');

insert into ListType (listTypeId, name, type_) values (12012, 'Administrative', 'com.liferay.portal.model.Organization.service');
insert into ListType (listTypeId, name, type_) values (12013, 'Contracts', 'com.liferay.portal.model.Organization.service');
insert into ListType (listTypeId, name, type_) values (12014, 'Donation', 'com.liferay.portal.model.Organization.service');
insert into ListType (listTypeId, name, type_) values (12015, 'Retail', 'com.liferay.portal.model.Organization.service');
insert into ListType (listTypeId, name, type_) values (12016, 'Training', 'com.liferay.portal.model.Organization.service');

insert into ListType (listTypeId, name, type_) values (12017, 'Full Member', 'com.liferay.portal.model.Organization.status');
insert into ListType (listTypeId, name, type_) values (12018, 'Provisional Member', 'com.liferay.portal.model.Organization.status');

insert into ListType (listTypeId, name, type_) values (12019, 'Intranet', 'com.liferay.portal.model.Organization.website');
insert into ListType (listTypeId, name, type_) values (12020, 'Public', 'com.liferay.portal.model.Organization.website');



insert into Counter values ('com.liferay.counter.model.Counter', 10000);






insert into Company (companyId, accountId, webId, virtualHost, mx) values (1, 7, 'liferay.com', 'localhost', 'liferay.com');
insert into Account_ (accountId, companyId, userId, userName, createDate, modifiedDate, parentAccountId, name, legalName, legalId, legalType, sicCode, tickerSymbol, industry, type_, size_) values (7, 1, 5, '', current_timestamp, current_timestamp, 0, 'Liferay', 'Liferay, Inc.', '', '', '', '', '', '', '');


insert into ClassName_ (classNameId, value) values (8, 'com.liferay.portal.model.Organization');
insert into ClassName_ (classNameId, value) values (9, 'com.liferay.portal.model.User');


insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (10, 1, 0, 0, 'Administrator', '', 1);
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (11, 1, 0, 0, 'Guest', '', 1);
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (12, 1, 0, 0, 'Power User', '', 1);
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (13, 1, 0, 0, 'User', '', 1);


insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (14, 1, 5, 0, 0, 0, 0, 'Guest', '/guest', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (15, 1, 14, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (16, 1, 14, FALSE, FALSE, 'classic', '01', 0);


insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (17, 1, 0, 'Liferay, Inc.', FALSE, TRUE, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (18, 1, 5, 8, 17, 0, 0, '18', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (19, 1, 18, TRUE, FALSE, 'classic', '01', 1);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (20, 1, 18, FALSE, FALSE, 'classic', '01', 1);
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (21, 18, 1, FALSE, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Liferay, Inc. Extranet</name>
</root>', 'portlet', 'layout-template-id=2_columns_ii
column-1=3,
column-2=19,', FALSE, '', 0);
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (22, 18, 1, TRUE, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Liferay, Inc. Intranet</name>
</root>', 'portlet', 'layout-template-id=2_columns_ii
column-1=3,
column-2=19,', FALSE, '', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (23, 1, 17, 'Liferay Engineering', FALSE, TRUE, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (24, 1, 5, 8, 23, 0, 0, '24', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (25, 1, 24, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (26, 1, 24, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (27, 1, 17, 'Liferay Consulting', FALSE, TRUE, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (28, 1, 5, 8, 27, 0, 0, '28', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (29, 1, 28, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (30, 1, 28, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (31, 1, 17, 'Liferay Support', FALSE, TRUE, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (32, 1, 5, 8, 31, 0, 0, '32', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (33, 1, 32, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (34, 1, 32, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (35, 1, 17, 'Liferay Sales', FALSE, TRUE, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (36, 1, 5, 8, 35, 0, 0, '36', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (37, 1, 36, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (38, 1, 36, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (39, 1, 17, 'Liferay Marketing', FALSE, TRUE, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (40, 1, 5, 8, 39, 0, 0, '40', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (41, 1, 40, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (42, 1, 40, FALSE, FALSE, 'classic', '01', 0);


insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (43, 1, 17, 'Liferay Los Angeles', TRUE, FALSE, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (44, 1, 5, 8, 43, 0, 0, '44', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (45, 1, 44, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (46, 1, 44, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (47, 1, 17, 'Liferay San Francisco', TRUE, FALSE, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (48, 1, 5, 8, 47, 0, 0, '48', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (49, 1, 48, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (50, 1, 48, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (51, 1, 17, 'Liferay Chicago', TRUE, FALSE, 14, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (52, 1, 5, 8, 51, 0, 0, '52', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (53, 1, 52, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (54, 1, 52, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (55, 1, 17, 'Liferay New York', TRUE, FALSE, 33, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (56, 1, 5, 8, 55, 0, 0, '56', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (57, 1, 56, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (58, 1, 56, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (59, 1, 17, 'Liferay Sao Paulo', TRUE, FALSE, 0, 48, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (60, 1, 5, 8, 59, 0, 0, '60', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (61, 1, 60, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (62, 1, 60, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (63, 1, 17, 'Liferay Frankfurt', TRUE, FALSE, 0, 4, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (64, 1, 5, 8, 63, 0, 0, '64', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (65, 1, 64, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (66, 1, 64, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (67, 1, 17, 'Liferay Madrid', TRUE, FALSE, 0, 15, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (68, 1, 5, 8, 67, 0, 0, '68', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (69, 1, 68, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (70, 1, 68, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (71, 1, 17, 'Liferay Dalian', TRUE, FALSE, 0, 2, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (72, 1, 5, 8, 71, 0, 0, '72', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (73, 1, 72, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (74, 1, 72, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (75, 1, 17, 'Liferay Hong Kong', TRUE, FALSE, 0, 2, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (76, 1, 5, 8, 75, 0, 0, '76', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (77, 1, 76, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (78, 1, 76, FALSE, FALSE, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (79, 1, 17, 'Liferay Kuala Lumpur', TRUE, FALSE, 0, 135, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (80, 1, 5, 8, 79, 0, 0, '80', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (81, 1, 80, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (82, 1, 80, FALSE, FALSE, 'classic', '01', 0);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (5, 1, current_timestamp, current_timestamp, TRUE, 6, 'password', FALSE, FALSE, '5', 'default@liferay.com', 'Welcome!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (6, 1, 5, '', current_timestamp, current_timestamp, 7, 0, '', '', '', TRUE, '1970-01-01');

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (2, 1, current_timestamp, current_timestamp, FALSE, 3, 'test', FALSE, FALSE, 'joebloggs', 'test@liferay.com', 'Welcome Joe Bloggs!', current_timestamp, 0, FALSE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (3, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Joe', '', 'Bloggs', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (83, 1, 2, 9, 2, 0, 0, '83', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (84, 1, 83, TRUE, FALSE, 'classic', '01', 2);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (85, 1, 83, FALSE, FALSE, 'classic', '01', 0);
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (86, 83, 1, TRUE, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Home</name>
</root>', 'portlet', 'column-1=71_INSTANCE_OY0d,82,23,61,
column-2=9,79,29,8,19,
layout-template-id=2_columns_ii
', FALSE, '/home', 0);
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (87, 83, 1, TRUE, 2, 0, '<?xml version="1.0"?>

<root>
  <name>Plugins</name>
</root>', 'portlet', 'column-1=
column-2=111,
layout-template-id=2_columns_ii
', FALSE, '/plugins', 1);

insert into Users_Groups values (2, 14);

insert into Users_Orgs (userId, organizationId) values (2, 17);
insert into Users_Orgs (userId, organizationId) values (2, 43);

insert into Users_Roles values (2, 10);
insert into Users_Roles values (2, 12);
insert into Users_Roles values (2, 13);


insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (88, 1, current_timestamp, current_timestamp, FALSE, 89, 'test', FALSE, FALSE, 'lax1', 'test.lax.1@liferay.com', 'Welcome Test LAX 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (89, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (90, 1, 88, 9, 88, 0, 0, '90', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (91, 1, 90, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (92, 1, 90, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (88, 14);

insert into Users_Orgs (userId, organizationId) values (88, 17);
insert into Users_Orgs (userId, organizationId) values (88, 43);

insert into Users_Roles values (88, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (93, 1, current_timestamp, current_timestamp, FALSE, 94, 'test', FALSE, FALSE, 'lax2', 'test.lax.2@liferay.com', 'Welcome Test LAX 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (94, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (95, 1, 93, 9, 93, 0, 0, '95', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (96, 1, 95, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (97, 1, 95, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (93, 14);

insert into Users_Orgs (userId, organizationId) values (93, 17);
insert into Users_Orgs (userId, organizationId) values (93, 43);

insert into Users_Roles values (93, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (98, 1, current_timestamp, current_timestamp, FALSE, 99, 'test', FALSE, FALSE, 'lax3', 'test.lax.3@liferay.com', 'Welcome Test LAX 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (99, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (100, 1, 98, 9, 98, 0, 0, '100', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (101, 1, 100, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (102, 1, 100, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (98, 14);

insert into Users_Orgs (userId, organizationId) values (98, 17);
insert into Users_Orgs (userId, organizationId) values (98, 43);

insert into Users_Roles values (98, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (103, 1, current_timestamp, current_timestamp, FALSE, 104, 'test', FALSE, FALSE, 'lax4', 'test.lax.4@liferay.com', 'Welcome Test LAX 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (104, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (105, 1, 103, 9, 103, 0, 0, '105', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (106, 1, 105, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (107, 1, 105, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (103, 14);

insert into Users_Orgs (userId, organizationId) values (103, 17);
insert into Users_Orgs (userId, organizationId) values (103, 43);

insert into Users_Roles values (103, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (108, 1, current_timestamp, current_timestamp, FALSE, 109, 'test', FALSE, FALSE, 'lax5', 'test.lax.5@liferay.com', 'Welcome Test LAX 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (109, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (110, 1, 108, 9, 108, 0, 0, '110', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (111, 1, 110, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (112, 1, 110, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (108, 14);

insert into Users_Orgs (userId, organizationId) values (108, 17);
insert into Users_Orgs (userId, organizationId) values (108, 43);

insert into Users_Roles values (108, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (113, 1, current_timestamp, current_timestamp, FALSE, 114, 'test', FALSE, FALSE, 'lax6', 'test.lax.6@liferay.com', 'Welcome Test LAX 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (114, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (115, 1, 113, 9, 113, 0, 0, '115', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (116, 1, 115, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (117, 1, 115, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (113, 14);

insert into Users_Orgs (userId, organizationId) values (113, 17);
insert into Users_Orgs (userId, organizationId) values (113, 43);

insert into Users_Roles values (113, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (118, 1, current_timestamp, current_timestamp, FALSE, 119, 'test', FALSE, FALSE, 'lax7', 'test.lax.7@liferay.com', 'Welcome Test LAX 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (119, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (120, 1, 118, 9, 118, 0, 0, '120', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (121, 1, 120, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (122, 1, 120, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (118, 14);

insert into Users_Orgs (userId, organizationId) values (118, 17);
insert into Users_Orgs (userId, organizationId) values (118, 43);

insert into Users_Roles values (118, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (123, 1, current_timestamp, current_timestamp, FALSE, 124, 'test', FALSE, FALSE, 'lax8', 'test.lax.8@liferay.com', 'Welcome Test LAX 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (124, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (125, 1, 123, 9, 123, 0, 0, '125', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (126, 1, 125, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (127, 1, 125, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (123, 14);

insert into Users_Orgs (userId, organizationId) values (123, 17);
insert into Users_Orgs (userId, organizationId) values (123, 43);

insert into Users_Roles values (123, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (128, 1, current_timestamp, current_timestamp, FALSE, 129, 'test', FALSE, FALSE, 'lax9', 'test.lax.9@liferay.com', 'Welcome Test LAX 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (129, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (130, 1, 128, 9, 128, 0, 0, '130', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (131, 1, 130, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (132, 1, 130, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (128, 14);

insert into Users_Orgs (userId, organizationId) values (128, 17);
insert into Users_Orgs (userId, organizationId) values (128, 43);

insert into Users_Roles values (128, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (133, 1, current_timestamp, current_timestamp, FALSE, 134, 'test', FALSE, FALSE, 'lax10', 'test.lax.10@liferay.com', 'Welcome Test LAX 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (134, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (135, 1, 133, 9, 133, 0, 0, '135', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (136, 1, 135, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (137, 1, 135, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (133, 14);

insert into Users_Orgs (userId, organizationId) values (133, 17);
insert into Users_Orgs (userId, organizationId) values (133, 43);

insert into Users_Roles values (133, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (138, 1, current_timestamp, current_timestamp, FALSE, 139, 'test', FALSE, FALSE, 'lax11', 'test.lax.11@liferay.com', 'Welcome Test LAX 11!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (139, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 11', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (140, 1, 138, 9, 138, 0, 0, '140', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (141, 1, 140, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (142, 1, 140, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (138, 14);

insert into Users_Orgs (userId, organizationId) values (138, 17);
insert into Users_Orgs (userId, organizationId) values (138, 43);

insert into Users_Roles values (138, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (143, 1, current_timestamp, current_timestamp, FALSE, 144, 'test', FALSE, FALSE, 'lax12', 'test.lax.12@liferay.com', 'Welcome Test LAX 12!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (144, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 12', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (145, 1, 143, 9, 143, 0, 0, '145', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (146, 1, 145, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (147, 1, 145, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (143, 14);

insert into Users_Orgs (userId, organizationId) values (143, 17);
insert into Users_Orgs (userId, organizationId) values (143, 43);

insert into Users_Roles values (143, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (148, 1, current_timestamp, current_timestamp, FALSE, 149, 'test', FALSE, FALSE, 'lax13', 'test.lax.13@liferay.com', 'Welcome Test LAX 13!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (149, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 13', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (150, 1, 148, 9, 148, 0, 0, '150', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (151, 1, 150, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (152, 1, 150, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (148, 14);

insert into Users_Orgs (userId, organizationId) values (148, 17);
insert into Users_Orgs (userId, organizationId) values (148, 43);

insert into Users_Roles values (148, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (153, 1, current_timestamp, current_timestamp, FALSE, 154, 'test', FALSE, FALSE, 'lax14', 'test.lax.14@liferay.com', 'Welcome Test LAX 14!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (154, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 14', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (155, 1, 153, 9, 153, 0, 0, '155', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (156, 1, 155, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (157, 1, 155, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (153, 14);

insert into Users_Orgs (userId, organizationId) values (153, 17);
insert into Users_Orgs (userId, organizationId) values (153, 43);

insert into Users_Roles values (153, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (158, 1, current_timestamp, current_timestamp, FALSE, 159, 'test', FALSE, FALSE, 'lax15', 'test.lax.15@liferay.com', 'Welcome Test LAX 15!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (159, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 15', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (160, 1, 158, 9, 158, 0, 0, '160', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (161, 1, 160, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (162, 1, 160, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (158, 14);

insert into Users_Orgs (userId, organizationId) values (158, 17);
insert into Users_Orgs (userId, organizationId) values (158, 43);

insert into Users_Roles values (158, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (163, 1, current_timestamp, current_timestamp, FALSE, 164, 'test', FALSE, FALSE, 'lax16', 'test.lax.16@liferay.com', 'Welcome Test LAX 16!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (164, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 16', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (165, 1, 163, 9, 163, 0, 0, '165', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (166, 1, 165, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (167, 1, 165, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (163, 14);

insert into Users_Orgs (userId, organizationId) values (163, 17);
insert into Users_Orgs (userId, organizationId) values (163, 43);

insert into Users_Roles values (163, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (168, 1, current_timestamp, current_timestamp, FALSE, 169, 'test', FALSE, FALSE, 'lax17', 'test.lax.17@liferay.com', 'Welcome Test LAX 17!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (169, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 17', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (170, 1, 168, 9, 168, 0, 0, '170', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (171, 1, 170, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (172, 1, 170, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (168, 14);

insert into Users_Orgs (userId, organizationId) values (168, 17);
insert into Users_Orgs (userId, organizationId) values (168, 43);

insert into Users_Roles values (168, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (173, 1, current_timestamp, current_timestamp, FALSE, 174, 'test', FALSE, FALSE, 'lax18', 'test.lax.18@liferay.com', 'Welcome Test LAX 18!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (174, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 18', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (175, 1, 173, 9, 173, 0, 0, '175', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (176, 1, 175, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (177, 1, 175, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (173, 14);

insert into Users_Orgs (userId, organizationId) values (173, 17);
insert into Users_Orgs (userId, organizationId) values (173, 43);

insert into Users_Roles values (173, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (178, 1, current_timestamp, current_timestamp, FALSE, 179, 'test', FALSE, FALSE, 'lax19', 'test.lax.19@liferay.com', 'Welcome Test LAX 19!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (179, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 19', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (180, 1, 178, 9, 178, 0, 0, '180', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (181, 1, 180, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (182, 1, 180, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (178, 14);

insert into Users_Orgs (userId, organizationId) values (178, 17);
insert into Users_Orgs (userId, organizationId) values (178, 43);

insert into Users_Roles values (178, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (183, 1, current_timestamp, current_timestamp, FALSE, 184, 'test', FALSE, FALSE, 'lax20', 'test.lax.20@liferay.com', 'Welcome Test LAX 20!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (184, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 20', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (185, 1, 183, 9, 183, 0, 0, '185', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (186, 1, 185, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (187, 1, 185, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (183, 14);

insert into Users_Orgs (userId, organizationId) values (183, 17);
insert into Users_Orgs (userId, organizationId) values (183, 43);

insert into Users_Roles values (183, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (188, 1, current_timestamp, current_timestamp, FALSE, 189, 'test', FALSE, FALSE, 'lax21', 'test.lax.21@liferay.com', 'Welcome Test LAX 21!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (189, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 21', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (190, 1, 188, 9, 188, 0, 0, '190', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (191, 1, 190, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (192, 1, 190, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (188, 14);

insert into Users_Orgs (userId, organizationId) values (188, 17);
insert into Users_Orgs (userId, organizationId) values (188, 43);

insert into Users_Roles values (188, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (193, 1, current_timestamp, current_timestamp, FALSE, 194, 'test', FALSE, FALSE, 'lax22', 'test.lax.22@liferay.com', 'Welcome Test LAX 22!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (194, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 22', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (195, 1, 193, 9, 193, 0, 0, '195', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (196, 1, 195, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (197, 1, 195, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (193, 14);

insert into Users_Orgs (userId, organizationId) values (193, 17);
insert into Users_Orgs (userId, organizationId) values (193, 43);

insert into Users_Roles values (193, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (198, 1, current_timestamp, current_timestamp, FALSE, 199, 'test', FALSE, FALSE, 'lax23', 'test.lax.23@liferay.com', 'Welcome Test LAX 23!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (199, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 23', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (200, 1, 198, 9, 198, 0, 0, '200', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (201, 1, 200, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (202, 1, 200, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (198, 14);

insert into Users_Orgs (userId, organizationId) values (198, 17);
insert into Users_Orgs (userId, organizationId) values (198, 43);

insert into Users_Roles values (198, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (203, 1, current_timestamp, current_timestamp, FALSE, 204, 'test', FALSE, FALSE, 'lax24', 'test.lax.24@liferay.com', 'Welcome Test LAX 24!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (204, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 24', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (205, 1, 203, 9, 203, 0, 0, '205', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (206, 1, 205, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (207, 1, 205, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (203, 14);

insert into Users_Orgs (userId, organizationId) values (203, 17);
insert into Users_Orgs (userId, organizationId) values (203, 43);

insert into Users_Roles values (203, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (208, 1, current_timestamp, current_timestamp, FALSE, 209, 'test', FALSE, FALSE, 'lax25', 'test.lax.25@liferay.com', 'Welcome Test LAX 25!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (209, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 25', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (210, 1, 208, 9, 208, 0, 0, '210', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (211, 1, 210, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (212, 1, 210, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (208, 14);

insert into Users_Orgs (userId, organizationId) values (208, 17);
insert into Users_Orgs (userId, organizationId) values (208, 43);

insert into Users_Roles values (208, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (213, 1, current_timestamp, current_timestamp, FALSE, 214, 'test', FALSE, FALSE, 'lax26', 'test.lax.26@liferay.com', 'Welcome Test LAX 26!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (214, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 26', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (215, 1, 213, 9, 213, 0, 0, '215', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (216, 1, 215, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (217, 1, 215, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (213, 14);

insert into Users_Orgs (userId, organizationId) values (213, 17);
insert into Users_Orgs (userId, organizationId) values (213, 43);

insert into Users_Roles values (213, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (218, 1, current_timestamp, current_timestamp, FALSE, 219, 'test', FALSE, FALSE, 'lax27', 'test.lax.27@liferay.com', 'Welcome Test LAX 27!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (219, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 27', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (220, 1, 218, 9, 218, 0, 0, '220', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (221, 1, 220, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (222, 1, 220, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (218, 14);

insert into Users_Orgs (userId, organizationId) values (218, 17);
insert into Users_Orgs (userId, organizationId) values (218, 43);

insert into Users_Roles values (218, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (223, 1, current_timestamp, current_timestamp, FALSE, 224, 'test', FALSE, FALSE, 'lax28', 'test.lax.28@liferay.com', 'Welcome Test LAX 28!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (224, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 28', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (225, 1, 223, 9, 223, 0, 0, '225', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (226, 1, 225, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (227, 1, 225, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (223, 14);

insert into Users_Orgs (userId, organizationId) values (223, 17);
insert into Users_Orgs (userId, organizationId) values (223, 43);

insert into Users_Roles values (223, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (228, 1, current_timestamp, current_timestamp, FALSE, 229, 'test', FALSE, FALSE, 'lax29', 'test.lax.29@liferay.com', 'Welcome Test LAX 29!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (229, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 29', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (230, 1, 228, 9, 228, 0, 0, '230', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (231, 1, 230, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (232, 1, 230, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (228, 14);

insert into Users_Orgs (userId, organizationId) values (228, 17);
insert into Users_Orgs (userId, organizationId) values (228, 43);

insert into Users_Roles values (228, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (233, 1, current_timestamp, current_timestamp, FALSE, 234, 'test', FALSE, FALSE, 'lax30', 'test.lax.30@liferay.com', 'Welcome Test LAX 30!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (234, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 30', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (235, 1, 233, 9, 233, 0, 0, '235', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (236, 1, 235, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (237, 1, 235, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (233, 14);

insert into Users_Orgs (userId, organizationId) values (233, 17);
insert into Users_Orgs (userId, organizationId) values (233, 43);

insert into Users_Roles values (233, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (238, 1, current_timestamp, current_timestamp, FALSE, 239, 'test', FALSE, FALSE, 'lax31', 'test.lax.31@liferay.com', 'Welcome Test LAX 31!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (239, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 31', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (240, 1, 238, 9, 238, 0, 0, '240', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (241, 1, 240, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (242, 1, 240, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (238, 14);

insert into Users_Orgs (userId, organizationId) values (238, 17);
insert into Users_Orgs (userId, organizationId) values (238, 43);

insert into Users_Roles values (238, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (243, 1, current_timestamp, current_timestamp, FALSE, 244, 'test', FALSE, FALSE, 'lax32', 'test.lax.32@liferay.com', 'Welcome Test LAX 32!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (244, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 32', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (245, 1, 243, 9, 243, 0, 0, '245', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (246, 1, 245, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (247, 1, 245, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (243, 14);

insert into Users_Orgs (userId, organizationId) values (243, 17);
insert into Users_Orgs (userId, organizationId) values (243, 43);

insert into Users_Roles values (243, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (248, 1, current_timestamp, current_timestamp, FALSE, 249, 'test', FALSE, FALSE, 'lax33', 'test.lax.33@liferay.com', 'Welcome Test LAX 33!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (249, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 33', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (250, 1, 248, 9, 248, 0, 0, '250', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (251, 1, 250, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (252, 1, 250, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (248, 14);

insert into Users_Orgs (userId, organizationId) values (248, 17);
insert into Users_Orgs (userId, organizationId) values (248, 43);

insert into Users_Roles values (248, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (253, 1, current_timestamp, current_timestamp, FALSE, 254, 'test', FALSE, FALSE, 'lax34', 'test.lax.34@liferay.com', 'Welcome Test LAX 34!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (254, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 34', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (255, 1, 253, 9, 253, 0, 0, '255', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (256, 1, 255, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (257, 1, 255, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (253, 14);

insert into Users_Orgs (userId, organizationId) values (253, 17);
insert into Users_Orgs (userId, organizationId) values (253, 43);

insert into Users_Roles values (253, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (258, 1, current_timestamp, current_timestamp, FALSE, 259, 'test', FALSE, FALSE, 'lax35', 'test.lax.35@liferay.com', 'Welcome Test LAX 35!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (259, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 35', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (260, 1, 258, 9, 258, 0, 0, '260', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (261, 1, 260, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (262, 1, 260, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (258, 14);

insert into Users_Orgs (userId, organizationId) values (258, 17);
insert into Users_Orgs (userId, organizationId) values (258, 43);

insert into Users_Roles values (258, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (263, 1, current_timestamp, current_timestamp, FALSE, 264, 'test', FALSE, FALSE, 'lax36', 'test.lax.36@liferay.com', 'Welcome Test LAX 36!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (264, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 36', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (265, 1, 263, 9, 263, 0, 0, '265', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (266, 1, 265, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (267, 1, 265, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (263, 14);

insert into Users_Orgs (userId, organizationId) values (263, 17);
insert into Users_Orgs (userId, organizationId) values (263, 43);

insert into Users_Roles values (263, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (268, 1, current_timestamp, current_timestamp, FALSE, 269, 'test', FALSE, FALSE, 'lax37', 'test.lax.37@liferay.com', 'Welcome Test LAX 37!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (269, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 37', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (270, 1, 268, 9, 268, 0, 0, '270', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (271, 1, 270, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (272, 1, 270, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (268, 14);

insert into Users_Orgs (userId, organizationId) values (268, 17);
insert into Users_Orgs (userId, organizationId) values (268, 43);

insert into Users_Roles values (268, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (273, 1, current_timestamp, current_timestamp, FALSE, 274, 'test', FALSE, FALSE, 'lax38', 'test.lax.38@liferay.com', 'Welcome Test LAX 38!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (274, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 38', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (275, 1, 273, 9, 273, 0, 0, '275', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (276, 1, 275, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (277, 1, 275, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (273, 14);

insert into Users_Orgs (userId, organizationId) values (273, 17);
insert into Users_Orgs (userId, organizationId) values (273, 43);

insert into Users_Roles values (273, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (278, 1, current_timestamp, current_timestamp, FALSE, 279, 'test', FALSE, FALSE, 'lax39', 'test.lax.39@liferay.com', 'Welcome Test LAX 39!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (279, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 39', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (280, 1, 278, 9, 278, 0, 0, '280', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (281, 1, 280, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (282, 1, 280, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (278, 14);

insert into Users_Orgs (userId, organizationId) values (278, 17);
insert into Users_Orgs (userId, organizationId) values (278, 43);

insert into Users_Roles values (278, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (283, 1, current_timestamp, current_timestamp, FALSE, 284, 'test', FALSE, FALSE, 'lax40', 'test.lax.40@liferay.com', 'Welcome Test LAX 40!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (284, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 40', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (285, 1, 283, 9, 283, 0, 0, '285', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (286, 1, 285, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (287, 1, 285, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (283, 14);

insert into Users_Orgs (userId, organizationId) values (283, 17);
insert into Users_Orgs (userId, organizationId) values (283, 43);

insert into Users_Roles values (283, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (288, 1, current_timestamp, current_timestamp, FALSE, 289, 'test', FALSE, FALSE, 'lax41', 'test.lax.41@liferay.com', 'Welcome Test LAX 41!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (289, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 41', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (290, 1, 288, 9, 288, 0, 0, '290', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (291, 1, 290, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (292, 1, 290, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (288, 14);

insert into Users_Orgs (userId, organizationId) values (288, 17);
insert into Users_Orgs (userId, organizationId) values (288, 43);

insert into Users_Roles values (288, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (293, 1, current_timestamp, current_timestamp, FALSE, 294, 'test', FALSE, FALSE, 'lax42', 'test.lax.42@liferay.com', 'Welcome Test LAX 42!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (294, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 42', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (295, 1, 293, 9, 293, 0, 0, '295', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (296, 1, 295, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (297, 1, 295, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (293, 14);

insert into Users_Orgs (userId, organizationId) values (293, 17);
insert into Users_Orgs (userId, organizationId) values (293, 43);

insert into Users_Roles values (293, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (298, 1, current_timestamp, current_timestamp, FALSE, 299, 'test', FALSE, FALSE, 'lax43', 'test.lax.43@liferay.com', 'Welcome Test LAX 43!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (299, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 43', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (300, 1, 298, 9, 298, 0, 0, '300', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (301, 1, 300, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (302, 1, 300, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (298, 14);

insert into Users_Orgs (userId, organizationId) values (298, 17);
insert into Users_Orgs (userId, organizationId) values (298, 43);

insert into Users_Roles values (298, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (303, 1, current_timestamp, current_timestamp, FALSE, 304, 'test', FALSE, FALSE, 'lax44', 'test.lax.44@liferay.com', 'Welcome Test LAX 44!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (304, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 44', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (305, 1, 303, 9, 303, 0, 0, '305', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (306, 1, 305, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (307, 1, 305, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (303, 14);

insert into Users_Orgs (userId, organizationId) values (303, 17);
insert into Users_Orgs (userId, organizationId) values (303, 43);

insert into Users_Roles values (303, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (308, 1, current_timestamp, current_timestamp, FALSE, 309, 'test', FALSE, FALSE, 'lax45', 'test.lax.45@liferay.com', 'Welcome Test LAX 45!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (309, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 45', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (310, 1, 308, 9, 308, 0, 0, '310', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (311, 1, 310, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (312, 1, 310, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (308, 14);

insert into Users_Orgs (userId, organizationId) values (308, 17);
insert into Users_Orgs (userId, organizationId) values (308, 43);

insert into Users_Roles values (308, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (313, 1, current_timestamp, current_timestamp, FALSE, 314, 'test', FALSE, FALSE, 'lax46', 'test.lax.46@liferay.com', 'Welcome Test LAX 46!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (314, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 46', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (315, 1, 313, 9, 313, 0, 0, '315', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (316, 1, 315, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (317, 1, 315, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (313, 14);

insert into Users_Orgs (userId, organizationId) values (313, 17);
insert into Users_Orgs (userId, organizationId) values (313, 43);

insert into Users_Roles values (313, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (318, 1, current_timestamp, current_timestamp, FALSE, 319, 'test', FALSE, FALSE, 'lax47', 'test.lax.47@liferay.com', 'Welcome Test LAX 47!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (319, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 47', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (320, 1, 318, 9, 318, 0, 0, '320', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (321, 1, 320, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (322, 1, 320, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (318, 14);

insert into Users_Orgs (userId, organizationId) values (318, 17);
insert into Users_Orgs (userId, organizationId) values (318, 43);

insert into Users_Roles values (318, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (323, 1, current_timestamp, current_timestamp, FALSE, 324, 'test', FALSE, FALSE, 'lax48', 'test.lax.48@liferay.com', 'Welcome Test LAX 48!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (324, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 48', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (325, 1, 323, 9, 323, 0, 0, '325', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (326, 1, 325, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (327, 1, 325, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (323, 14);

insert into Users_Orgs (userId, organizationId) values (323, 17);
insert into Users_Orgs (userId, organizationId) values (323, 43);

insert into Users_Roles values (323, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (328, 1, current_timestamp, current_timestamp, FALSE, 329, 'test', FALSE, FALSE, 'lax49', 'test.lax.49@liferay.com', 'Welcome Test LAX 49!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (329, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 49', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (330, 1, 328, 9, 328, 0, 0, '330', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (331, 1, 330, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (332, 1, 330, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (328, 14);

insert into Users_Orgs (userId, organizationId) values (328, 17);
insert into Users_Orgs (userId, organizationId) values (328, 43);

insert into Users_Roles values (328, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (333, 1, current_timestamp, current_timestamp, FALSE, 334, 'test', FALSE, FALSE, 'lax50', 'test.lax.50@liferay.com', 'Welcome Test LAX 50!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (334, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 50', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (335, 1, 333, 9, 333, 0, 0, '335', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (336, 1, 335, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (337, 1, 335, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (333, 14);

insert into Users_Orgs (userId, organizationId) values (333, 17);
insert into Users_Orgs (userId, organizationId) values (333, 43);

insert into Users_Roles values (333, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (338, 1, current_timestamp, current_timestamp, FALSE, 339, 'test', FALSE, FALSE, 'lax51', 'test.lax.51@liferay.com', 'Welcome Test LAX 51!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (339, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 51', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (340, 1, 338, 9, 338, 0, 0, '340', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (341, 1, 340, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (342, 1, 340, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (338, 14);

insert into Users_Orgs (userId, organizationId) values (338, 17);
insert into Users_Orgs (userId, organizationId) values (338, 43);

insert into Users_Roles values (338, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (343, 1, current_timestamp, current_timestamp, FALSE, 344, 'test', FALSE, FALSE, 'lax52', 'test.lax.52@liferay.com', 'Welcome Test LAX 52!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (344, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 52', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (345, 1, 343, 9, 343, 0, 0, '345', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (346, 1, 345, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (347, 1, 345, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (343, 14);

insert into Users_Orgs (userId, organizationId) values (343, 17);
insert into Users_Orgs (userId, organizationId) values (343, 43);

insert into Users_Roles values (343, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (348, 1, current_timestamp, current_timestamp, FALSE, 349, 'test', FALSE, FALSE, 'lax53', 'test.lax.53@liferay.com', 'Welcome Test LAX 53!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (349, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 53', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (350, 1, 348, 9, 348, 0, 0, '350', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (351, 1, 350, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (352, 1, 350, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (348, 14);

insert into Users_Orgs (userId, organizationId) values (348, 17);
insert into Users_Orgs (userId, organizationId) values (348, 43);

insert into Users_Roles values (348, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (353, 1, current_timestamp, current_timestamp, FALSE, 354, 'test', FALSE, FALSE, 'lax54', 'test.lax.54@liferay.com', 'Welcome Test LAX 54!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (354, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 54', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (355, 1, 353, 9, 353, 0, 0, '355', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (356, 1, 355, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (357, 1, 355, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (353, 14);

insert into Users_Orgs (userId, organizationId) values (353, 17);
insert into Users_Orgs (userId, organizationId) values (353, 43);

insert into Users_Roles values (353, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (358, 1, current_timestamp, current_timestamp, FALSE, 359, 'test', FALSE, FALSE, 'lax55', 'test.lax.55@liferay.com', 'Welcome Test LAX 55!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (359, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 55', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (360, 1, 358, 9, 358, 0, 0, '360', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (361, 1, 360, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (362, 1, 360, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (358, 14);

insert into Users_Orgs (userId, organizationId) values (358, 17);
insert into Users_Orgs (userId, organizationId) values (358, 43);

insert into Users_Roles values (358, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (363, 1, current_timestamp, current_timestamp, FALSE, 364, 'test', FALSE, FALSE, 'lax56', 'test.lax.56@liferay.com', 'Welcome Test LAX 56!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (364, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 56', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (365, 1, 363, 9, 363, 0, 0, '365', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (366, 1, 365, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (367, 1, 365, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (363, 14);

insert into Users_Orgs (userId, organizationId) values (363, 17);
insert into Users_Orgs (userId, organizationId) values (363, 43);

insert into Users_Roles values (363, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (368, 1, current_timestamp, current_timestamp, FALSE, 369, 'test', FALSE, FALSE, 'lax57', 'test.lax.57@liferay.com', 'Welcome Test LAX 57!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (369, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 57', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (370, 1, 368, 9, 368, 0, 0, '370', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (371, 1, 370, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (372, 1, 370, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (368, 14);

insert into Users_Orgs (userId, organizationId) values (368, 17);
insert into Users_Orgs (userId, organizationId) values (368, 43);

insert into Users_Roles values (368, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (373, 1, current_timestamp, current_timestamp, FALSE, 374, 'test', FALSE, FALSE, 'lax58', 'test.lax.58@liferay.com', 'Welcome Test LAX 58!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (374, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 58', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (375, 1, 373, 9, 373, 0, 0, '375', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (376, 1, 375, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (377, 1, 375, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (373, 14);

insert into Users_Orgs (userId, organizationId) values (373, 17);
insert into Users_Orgs (userId, organizationId) values (373, 43);

insert into Users_Roles values (373, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (378, 1, current_timestamp, current_timestamp, FALSE, 379, 'test', FALSE, FALSE, 'lax59', 'test.lax.59@liferay.com', 'Welcome Test LAX 59!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (379, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 59', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (380, 1, 378, 9, 378, 0, 0, '380', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (381, 1, 380, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (382, 1, 380, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (378, 14);

insert into Users_Orgs (userId, organizationId) values (378, 17);
insert into Users_Orgs (userId, organizationId) values (378, 43);

insert into Users_Roles values (378, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (383, 1, current_timestamp, current_timestamp, FALSE, 384, 'test', FALSE, FALSE, 'lax60', 'test.lax.60@liferay.com', 'Welcome Test LAX 60!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (384, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 60', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (385, 1, 383, 9, 383, 0, 0, '385', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (386, 1, 385, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (387, 1, 385, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (383, 14);

insert into Users_Orgs (userId, organizationId) values (383, 17);
insert into Users_Orgs (userId, organizationId) values (383, 43);

insert into Users_Roles values (383, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (388, 1, current_timestamp, current_timestamp, FALSE, 389, 'test', FALSE, FALSE, 'lax61', 'test.lax.61@liferay.com', 'Welcome Test LAX 61!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (389, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 61', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (390, 1, 388, 9, 388, 0, 0, '390', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (391, 1, 390, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (392, 1, 390, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (388, 14);

insert into Users_Orgs (userId, organizationId) values (388, 17);
insert into Users_Orgs (userId, organizationId) values (388, 43);

insert into Users_Roles values (388, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (393, 1, current_timestamp, current_timestamp, FALSE, 394, 'test', FALSE, FALSE, 'lax62', 'test.lax.62@liferay.com', 'Welcome Test LAX 62!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (394, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 62', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (395, 1, 393, 9, 393, 0, 0, '395', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (396, 1, 395, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (397, 1, 395, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (393, 14);

insert into Users_Orgs (userId, organizationId) values (393, 17);
insert into Users_Orgs (userId, organizationId) values (393, 43);

insert into Users_Roles values (393, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (398, 1, current_timestamp, current_timestamp, FALSE, 399, 'test', FALSE, FALSE, 'lax63', 'test.lax.63@liferay.com', 'Welcome Test LAX 63!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (399, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 63', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (400, 1, 398, 9, 398, 0, 0, '400', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (401, 1, 400, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (402, 1, 400, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (398, 14);

insert into Users_Orgs (userId, organizationId) values (398, 17);
insert into Users_Orgs (userId, organizationId) values (398, 43);

insert into Users_Roles values (398, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (403, 1, current_timestamp, current_timestamp, FALSE, 404, 'test', FALSE, FALSE, 'lax64', 'test.lax.64@liferay.com', 'Welcome Test LAX 64!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (404, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 64', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (405, 1, 403, 9, 403, 0, 0, '405', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (406, 1, 405, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (407, 1, 405, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (403, 14);

insert into Users_Orgs (userId, organizationId) values (403, 17);
insert into Users_Orgs (userId, organizationId) values (403, 43);

insert into Users_Roles values (403, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (408, 1, current_timestamp, current_timestamp, FALSE, 409, 'test', FALSE, FALSE, 'lax65', 'test.lax.65@liferay.com', 'Welcome Test LAX 65!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (409, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 65', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (410, 1, 408, 9, 408, 0, 0, '410', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (411, 1, 410, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (412, 1, 410, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (408, 14);

insert into Users_Orgs (userId, organizationId) values (408, 17);
insert into Users_Orgs (userId, organizationId) values (408, 43);

insert into Users_Roles values (408, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (413, 1, current_timestamp, current_timestamp, FALSE, 414, 'test', FALSE, FALSE, 'lax66', 'test.lax.66@liferay.com', 'Welcome Test LAX 66!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (414, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 66', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (415, 1, 413, 9, 413, 0, 0, '415', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (416, 1, 415, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (417, 1, 415, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (413, 14);

insert into Users_Orgs (userId, organizationId) values (413, 17);
insert into Users_Orgs (userId, organizationId) values (413, 43);

insert into Users_Roles values (413, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (418, 1, current_timestamp, current_timestamp, FALSE, 419, 'test', FALSE, FALSE, 'lax67', 'test.lax.67@liferay.com', 'Welcome Test LAX 67!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (419, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 67', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (420, 1, 418, 9, 418, 0, 0, '420', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (421, 1, 420, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (422, 1, 420, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (418, 14);

insert into Users_Orgs (userId, organizationId) values (418, 17);
insert into Users_Orgs (userId, organizationId) values (418, 43);

insert into Users_Roles values (418, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (423, 1, current_timestamp, current_timestamp, FALSE, 424, 'test', FALSE, FALSE, 'lax68', 'test.lax.68@liferay.com', 'Welcome Test LAX 68!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (424, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 68', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (425, 1, 423, 9, 423, 0, 0, '425', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (426, 1, 425, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (427, 1, 425, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (423, 14);

insert into Users_Orgs (userId, organizationId) values (423, 17);
insert into Users_Orgs (userId, organizationId) values (423, 43);

insert into Users_Roles values (423, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (428, 1, current_timestamp, current_timestamp, FALSE, 429, 'test', FALSE, FALSE, 'lax69', 'test.lax.69@liferay.com', 'Welcome Test LAX 69!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (429, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 69', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (430, 1, 428, 9, 428, 0, 0, '430', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (431, 1, 430, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (432, 1, 430, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (428, 14);

insert into Users_Orgs (userId, organizationId) values (428, 17);
insert into Users_Orgs (userId, organizationId) values (428, 43);

insert into Users_Roles values (428, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (433, 1, current_timestamp, current_timestamp, FALSE, 434, 'test', FALSE, FALSE, 'lax70', 'test.lax.70@liferay.com', 'Welcome Test LAX 70!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (434, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 70', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (435, 1, 433, 9, 433, 0, 0, '435', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (436, 1, 435, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (437, 1, 435, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (433, 14);

insert into Users_Orgs (userId, organizationId) values (433, 17);
insert into Users_Orgs (userId, organizationId) values (433, 43);

insert into Users_Roles values (433, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (438, 1, current_timestamp, current_timestamp, FALSE, 439, 'test', FALSE, FALSE, 'lax71', 'test.lax.71@liferay.com', 'Welcome Test LAX 71!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (439, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 71', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (440, 1, 438, 9, 438, 0, 0, '440', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (441, 1, 440, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (442, 1, 440, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (438, 14);

insert into Users_Orgs (userId, organizationId) values (438, 17);
insert into Users_Orgs (userId, organizationId) values (438, 43);

insert into Users_Roles values (438, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (443, 1, current_timestamp, current_timestamp, FALSE, 444, 'test', FALSE, FALSE, 'lax72', 'test.lax.72@liferay.com', 'Welcome Test LAX 72!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (444, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 72', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (445, 1, 443, 9, 443, 0, 0, '445', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (446, 1, 445, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (447, 1, 445, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (443, 14);

insert into Users_Orgs (userId, organizationId) values (443, 17);
insert into Users_Orgs (userId, organizationId) values (443, 43);

insert into Users_Roles values (443, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (448, 1, current_timestamp, current_timestamp, FALSE, 449, 'test', FALSE, FALSE, 'lax73', 'test.lax.73@liferay.com', 'Welcome Test LAX 73!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (449, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 73', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (450, 1, 448, 9, 448, 0, 0, '450', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (451, 1, 450, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (452, 1, 450, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (448, 14);

insert into Users_Orgs (userId, organizationId) values (448, 17);
insert into Users_Orgs (userId, organizationId) values (448, 43);

insert into Users_Roles values (448, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (453, 1, current_timestamp, current_timestamp, FALSE, 454, 'test', FALSE, FALSE, 'lax74', 'test.lax.74@liferay.com', 'Welcome Test LAX 74!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (454, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 74', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (455, 1, 453, 9, 453, 0, 0, '455', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (456, 1, 455, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (457, 1, 455, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (453, 14);

insert into Users_Orgs (userId, organizationId) values (453, 17);
insert into Users_Orgs (userId, organizationId) values (453, 43);

insert into Users_Roles values (453, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (458, 1, current_timestamp, current_timestamp, FALSE, 459, 'test', FALSE, FALSE, 'lax75', 'test.lax.75@liferay.com', 'Welcome Test LAX 75!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (459, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 75', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (460, 1, 458, 9, 458, 0, 0, '460', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (461, 1, 460, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (462, 1, 460, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (458, 14);

insert into Users_Orgs (userId, organizationId) values (458, 17);
insert into Users_Orgs (userId, organizationId) values (458, 43);

insert into Users_Roles values (458, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (463, 1, current_timestamp, current_timestamp, FALSE, 464, 'test', FALSE, FALSE, 'lax76', 'test.lax.76@liferay.com', 'Welcome Test LAX 76!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (464, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 76', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (465, 1, 463, 9, 463, 0, 0, '465', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (466, 1, 465, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (467, 1, 465, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (463, 14);

insert into Users_Orgs (userId, organizationId) values (463, 17);
insert into Users_Orgs (userId, organizationId) values (463, 43);

insert into Users_Roles values (463, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (468, 1, current_timestamp, current_timestamp, FALSE, 469, 'test', FALSE, FALSE, 'lax77', 'test.lax.77@liferay.com', 'Welcome Test LAX 77!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (469, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 77', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (470, 1, 468, 9, 468, 0, 0, '470', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (471, 1, 470, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (472, 1, 470, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (468, 14);

insert into Users_Orgs (userId, organizationId) values (468, 17);
insert into Users_Orgs (userId, organizationId) values (468, 43);

insert into Users_Roles values (468, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (473, 1, current_timestamp, current_timestamp, FALSE, 474, 'test', FALSE, FALSE, 'lax78', 'test.lax.78@liferay.com', 'Welcome Test LAX 78!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (474, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 78', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (475, 1, 473, 9, 473, 0, 0, '475', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (476, 1, 475, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (477, 1, 475, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (473, 14);

insert into Users_Orgs (userId, organizationId) values (473, 17);
insert into Users_Orgs (userId, organizationId) values (473, 43);

insert into Users_Roles values (473, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (478, 1, current_timestamp, current_timestamp, FALSE, 479, 'test', FALSE, FALSE, 'lax79', 'test.lax.79@liferay.com', 'Welcome Test LAX 79!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (479, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 79', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (480, 1, 478, 9, 478, 0, 0, '480', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (481, 1, 480, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (482, 1, 480, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (478, 14);

insert into Users_Orgs (userId, organizationId) values (478, 17);
insert into Users_Orgs (userId, organizationId) values (478, 43);

insert into Users_Roles values (478, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (483, 1, current_timestamp, current_timestamp, FALSE, 484, 'test', FALSE, FALSE, 'lax80', 'test.lax.80@liferay.com', 'Welcome Test LAX 80!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (484, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 80', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (485, 1, 483, 9, 483, 0, 0, '485', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (486, 1, 485, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (487, 1, 485, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (483, 14);

insert into Users_Orgs (userId, organizationId) values (483, 17);
insert into Users_Orgs (userId, organizationId) values (483, 43);

insert into Users_Roles values (483, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (488, 1, current_timestamp, current_timestamp, FALSE, 489, 'test', FALSE, FALSE, 'lax81', 'test.lax.81@liferay.com', 'Welcome Test LAX 81!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (489, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 81', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (490, 1, 488, 9, 488, 0, 0, '490', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (491, 1, 490, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (492, 1, 490, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (488, 14);

insert into Users_Orgs (userId, organizationId) values (488, 17);
insert into Users_Orgs (userId, organizationId) values (488, 43);

insert into Users_Roles values (488, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (493, 1, current_timestamp, current_timestamp, FALSE, 494, 'test', FALSE, FALSE, 'lax82', 'test.lax.82@liferay.com', 'Welcome Test LAX 82!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (494, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 82', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (495, 1, 493, 9, 493, 0, 0, '495', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (496, 1, 495, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (497, 1, 495, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (493, 14);

insert into Users_Orgs (userId, organizationId) values (493, 17);
insert into Users_Orgs (userId, organizationId) values (493, 43);

insert into Users_Roles values (493, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (498, 1, current_timestamp, current_timestamp, FALSE, 499, 'test', FALSE, FALSE, 'lax83', 'test.lax.83@liferay.com', 'Welcome Test LAX 83!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (499, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 83', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (500, 1, 498, 9, 498, 0, 0, '500', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (501, 1, 500, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (502, 1, 500, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (498, 14);

insert into Users_Orgs (userId, organizationId) values (498, 17);
insert into Users_Orgs (userId, organizationId) values (498, 43);

insert into Users_Roles values (498, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (503, 1, current_timestamp, current_timestamp, FALSE, 504, 'test', FALSE, FALSE, 'lax84', 'test.lax.84@liferay.com', 'Welcome Test LAX 84!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (504, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 84', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (505, 1, 503, 9, 503, 0, 0, '505', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (506, 1, 505, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (507, 1, 505, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (503, 14);

insert into Users_Orgs (userId, organizationId) values (503, 17);
insert into Users_Orgs (userId, organizationId) values (503, 43);

insert into Users_Roles values (503, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (508, 1, current_timestamp, current_timestamp, FALSE, 509, 'test', FALSE, FALSE, 'lax85', 'test.lax.85@liferay.com', 'Welcome Test LAX 85!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (509, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 85', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (510, 1, 508, 9, 508, 0, 0, '510', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (511, 1, 510, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (512, 1, 510, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (508, 14);

insert into Users_Orgs (userId, organizationId) values (508, 17);
insert into Users_Orgs (userId, organizationId) values (508, 43);

insert into Users_Roles values (508, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (513, 1, current_timestamp, current_timestamp, FALSE, 514, 'test', FALSE, FALSE, 'lax86', 'test.lax.86@liferay.com', 'Welcome Test LAX 86!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (514, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 86', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (515, 1, 513, 9, 513, 0, 0, '515', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (516, 1, 515, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (517, 1, 515, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (513, 14);

insert into Users_Orgs (userId, organizationId) values (513, 17);
insert into Users_Orgs (userId, organizationId) values (513, 43);

insert into Users_Roles values (513, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (518, 1, current_timestamp, current_timestamp, FALSE, 519, 'test', FALSE, FALSE, 'lax87', 'test.lax.87@liferay.com', 'Welcome Test LAX 87!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (519, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 87', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (520, 1, 518, 9, 518, 0, 0, '520', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (521, 1, 520, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (522, 1, 520, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (518, 14);

insert into Users_Orgs (userId, organizationId) values (518, 17);
insert into Users_Orgs (userId, organizationId) values (518, 43);

insert into Users_Roles values (518, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (523, 1, current_timestamp, current_timestamp, FALSE, 524, 'test', FALSE, FALSE, 'lax88', 'test.lax.88@liferay.com', 'Welcome Test LAX 88!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (524, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 88', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (525, 1, 523, 9, 523, 0, 0, '525', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (526, 1, 525, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (527, 1, 525, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (523, 14);

insert into Users_Orgs (userId, organizationId) values (523, 17);
insert into Users_Orgs (userId, organizationId) values (523, 43);

insert into Users_Roles values (523, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (528, 1, current_timestamp, current_timestamp, FALSE, 529, 'test', FALSE, FALSE, 'lax89', 'test.lax.89@liferay.com', 'Welcome Test LAX 89!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (529, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 89', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (530, 1, 528, 9, 528, 0, 0, '530', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (531, 1, 530, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (532, 1, 530, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (528, 14);

insert into Users_Orgs (userId, organizationId) values (528, 17);
insert into Users_Orgs (userId, organizationId) values (528, 43);

insert into Users_Roles values (528, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (533, 1, current_timestamp, current_timestamp, FALSE, 534, 'test', FALSE, FALSE, 'lax90', 'test.lax.90@liferay.com', 'Welcome Test LAX 90!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (534, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 90', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (535, 1, 533, 9, 533, 0, 0, '535', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (536, 1, 535, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (537, 1, 535, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (533, 14);

insert into Users_Orgs (userId, organizationId) values (533, 17);
insert into Users_Orgs (userId, organizationId) values (533, 43);

insert into Users_Roles values (533, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (538, 1, current_timestamp, current_timestamp, FALSE, 539, 'test', FALSE, FALSE, 'lax91', 'test.lax.91@liferay.com', 'Welcome Test LAX 91!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (539, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 91', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (540, 1, 538, 9, 538, 0, 0, '540', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (541, 1, 540, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (542, 1, 540, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (538, 14);

insert into Users_Orgs (userId, organizationId) values (538, 17);
insert into Users_Orgs (userId, organizationId) values (538, 43);

insert into Users_Roles values (538, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (543, 1, current_timestamp, current_timestamp, FALSE, 544, 'test', FALSE, FALSE, 'lax92', 'test.lax.92@liferay.com', 'Welcome Test LAX 92!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (544, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 92', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (545, 1, 543, 9, 543, 0, 0, '545', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (546, 1, 545, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (547, 1, 545, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (543, 14);

insert into Users_Orgs (userId, organizationId) values (543, 17);
insert into Users_Orgs (userId, organizationId) values (543, 43);

insert into Users_Roles values (543, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (548, 1, current_timestamp, current_timestamp, FALSE, 549, 'test', FALSE, FALSE, 'lax93', 'test.lax.93@liferay.com', 'Welcome Test LAX 93!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (549, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 93', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (550, 1, 548, 9, 548, 0, 0, '550', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (551, 1, 550, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (552, 1, 550, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (548, 14);

insert into Users_Orgs (userId, organizationId) values (548, 17);
insert into Users_Orgs (userId, organizationId) values (548, 43);

insert into Users_Roles values (548, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (553, 1, current_timestamp, current_timestamp, FALSE, 554, 'test', FALSE, FALSE, 'lax94', 'test.lax.94@liferay.com', 'Welcome Test LAX 94!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (554, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 94', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (555, 1, 553, 9, 553, 0, 0, '555', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (556, 1, 555, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (557, 1, 555, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (553, 14);

insert into Users_Orgs (userId, organizationId) values (553, 17);
insert into Users_Orgs (userId, organizationId) values (553, 43);

insert into Users_Roles values (553, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (558, 1, current_timestamp, current_timestamp, FALSE, 559, 'test', FALSE, FALSE, 'lax95', 'test.lax.95@liferay.com', 'Welcome Test LAX 95!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (559, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 95', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (560, 1, 558, 9, 558, 0, 0, '560', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (561, 1, 560, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (562, 1, 560, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (558, 14);

insert into Users_Orgs (userId, organizationId) values (558, 17);
insert into Users_Orgs (userId, organizationId) values (558, 43);

insert into Users_Roles values (558, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (563, 1, current_timestamp, current_timestamp, FALSE, 564, 'test', FALSE, FALSE, 'lax96', 'test.lax.96@liferay.com', 'Welcome Test LAX 96!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (564, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 96', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (565, 1, 563, 9, 563, 0, 0, '565', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (566, 1, 565, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (567, 1, 565, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (563, 14);

insert into Users_Orgs (userId, organizationId) values (563, 17);
insert into Users_Orgs (userId, organizationId) values (563, 43);

insert into Users_Roles values (563, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (568, 1, current_timestamp, current_timestamp, FALSE, 569, 'test', FALSE, FALSE, 'lax97', 'test.lax.97@liferay.com', 'Welcome Test LAX 97!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (569, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 97', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (570, 1, 568, 9, 568, 0, 0, '570', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (571, 1, 570, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (572, 1, 570, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (568, 14);

insert into Users_Orgs (userId, organizationId) values (568, 17);
insert into Users_Orgs (userId, organizationId) values (568, 43);

insert into Users_Roles values (568, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (573, 1, current_timestamp, current_timestamp, FALSE, 574, 'test', FALSE, FALSE, 'lax98', 'test.lax.98@liferay.com', 'Welcome Test LAX 98!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (574, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 98', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (575, 1, 573, 9, 573, 0, 0, '575', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (576, 1, 575, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (577, 1, 575, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (573, 14);

insert into Users_Orgs (userId, organizationId) values (573, 17);
insert into Users_Orgs (userId, organizationId) values (573, 43);

insert into Users_Roles values (573, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (578, 1, current_timestamp, current_timestamp, FALSE, 579, 'test', FALSE, FALSE, 'lax99', 'test.lax.99@liferay.com', 'Welcome Test LAX 99!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (579, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 99', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (580, 1, 578, 9, 578, 0, 0, '580', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (581, 1, 580, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (582, 1, 580, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (578, 14);

insert into Users_Orgs (userId, organizationId) values (578, 17);
insert into Users_Orgs (userId, organizationId) values (578, 43);

insert into Users_Roles values (578, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (583, 1, current_timestamp, current_timestamp, FALSE, 584, 'test', FALSE, FALSE, 'lax100', 'test.lax.100@liferay.com', 'Welcome Test LAX 100!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (584, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 100', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (585, 1, 583, 9, 583, 0, 0, '585', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (586, 1, 585, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (587, 1, 585, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (583, 14);

insert into Users_Orgs (userId, organizationId) values (583, 17);
insert into Users_Orgs (userId, organizationId) values (583, 43);

insert into Users_Roles values (583, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (588, 1, current_timestamp, current_timestamp, FALSE, 589, 'test', FALSE, FALSE, 'sfo1', 'test.sfo.1@liferay.com', 'Welcome Test SFO 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (589, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (590, 1, 588, 9, 588, 0, 0, '590', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (591, 1, 590, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (592, 1, 590, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (588, 14);

insert into Users_Orgs (userId, organizationId) values (588, 17);
insert into Users_Orgs (userId, organizationId) values (588, 47);

insert into Users_Roles values (588, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (593, 1, current_timestamp, current_timestamp, FALSE, 594, 'test', FALSE, FALSE, 'sfo2', 'test.sfo.2@liferay.com', 'Welcome Test SFO 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (594, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (595, 1, 593, 9, 593, 0, 0, '595', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (596, 1, 595, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (597, 1, 595, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (593, 14);

insert into Users_Orgs (userId, organizationId) values (593, 17);
insert into Users_Orgs (userId, organizationId) values (593, 47);

insert into Users_Roles values (593, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (598, 1, current_timestamp, current_timestamp, FALSE, 599, 'test', FALSE, FALSE, 'sfo3', 'test.sfo.3@liferay.com', 'Welcome Test SFO 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (599, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (600, 1, 598, 9, 598, 0, 0, '600', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (601, 1, 600, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (602, 1, 600, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (598, 14);

insert into Users_Orgs (userId, organizationId) values (598, 17);
insert into Users_Orgs (userId, organizationId) values (598, 47);

insert into Users_Roles values (598, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (603, 1, current_timestamp, current_timestamp, FALSE, 604, 'test', FALSE, FALSE, 'sfo4', 'test.sfo.4@liferay.com', 'Welcome Test SFO 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (604, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (605, 1, 603, 9, 603, 0, 0, '605', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (606, 1, 605, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (607, 1, 605, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (603, 14);

insert into Users_Orgs (userId, organizationId) values (603, 17);
insert into Users_Orgs (userId, organizationId) values (603, 47);

insert into Users_Roles values (603, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (608, 1, current_timestamp, current_timestamp, FALSE, 609, 'test', FALSE, FALSE, 'sfo5', 'test.sfo.5@liferay.com', 'Welcome Test SFO 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (609, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (610, 1, 608, 9, 608, 0, 0, '610', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (611, 1, 610, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (612, 1, 610, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (608, 14);

insert into Users_Orgs (userId, organizationId) values (608, 17);
insert into Users_Orgs (userId, organizationId) values (608, 47);

insert into Users_Roles values (608, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (613, 1, current_timestamp, current_timestamp, FALSE, 614, 'test', FALSE, FALSE, 'sfo6', 'test.sfo.6@liferay.com', 'Welcome Test SFO 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (614, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (615, 1, 613, 9, 613, 0, 0, '615', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (616, 1, 615, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (617, 1, 615, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (613, 14);

insert into Users_Orgs (userId, organizationId) values (613, 17);
insert into Users_Orgs (userId, organizationId) values (613, 47);

insert into Users_Roles values (613, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (618, 1, current_timestamp, current_timestamp, FALSE, 619, 'test', FALSE, FALSE, 'sfo7', 'test.sfo.7@liferay.com', 'Welcome Test SFO 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (619, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (620, 1, 618, 9, 618, 0, 0, '620', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (621, 1, 620, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (622, 1, 620, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (618, 14);

insert into Users_Orgs (userId, organizationId) values (618, 17);
insert into Users_Orgs (userId, organizationId) values (618, 47);

insert into Users_Roles values (618, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (623, 1, current_timestamp, current_timestamp, FALSE, 624, 'test', FALSE, FALSE, 'sfo8', 'test.sfo.8@liferay.com', 'Welcome Test SFO 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (624, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (625, 1, 623, 9, 623, 0, 0, '625', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (626, 1, 625, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (627, 1, 625, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (623, 14);

insert into Users_Orgs (userId, organizationId) values (623, 17);
insert into Users_Orgs (userId, organizationId) values (623, 47);

insert into Users_Roles values (623, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (628, 1, current_timestamp, current_timestamp, FALSE, 629, 'test', FALSE, FALSE, 'sfo9', 'test.sfo.9@liferay.com', 'Welcome Test SFO 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (629, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (630, 1, 628, 9, 628, 0, 0, '630', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (631, 1, 630, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (632, 1, 630, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (628, 14);

insert into Users_Orgs (userId, organizationId) values (628, 17);
insert into Users_Orgs (userId, organizationId) values (628, 47);

insert into Users_Roles values (628, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (633, 1, current_timestamp, current_timestamp, FALSE, 634, 'test', FALSE, FALSE, 'sfo10', 'test.sfo.10@liferay.com', 'Welcome Test SFO 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (634, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (635, 1, 633, 9, 633, 0, 0, '635', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (636, 1, 635, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (637, 1, 635, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (633, 14);

insert into Users_Orgs (userId, organizationId) values (633, 17);
insert into Users_Orgs (userId, organizationId) values (633, 47);

insert into Users_Roles values (633, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (638, 1, current_timestamp, current_timestamp, FALSE, 639, 'test', FALSE, FALSE, 'ord1', 'test.ord.1@liferay.com', 'Welcome Test ORD 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (639, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (640, 1, 638, 9, 638, 0, 0, '640', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (641, 1, 640, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (642, 1, 640, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (638, 14);

insert into Users_Orgs (userId, organizationId) values (638, 17);
insert into Users_Orgs (userId, organizationId) values (638, 51);

insert into Users_Roles values (638, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (643, 1, current_timestamp, current_timestamp, FALSE, 644, 'test', FALSE, FALSE, 'ord2', 'test.ord.2@liferay.com', 'Welcome Test ORD 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (644, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (645, 1, 643, 9, 643, 0, 0, '645', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (646, 1, 645, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (647, 1, 645, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (643, 14);

insert into Users_Orgs (userId, organizationId) values (643, 17);
insert into Users_Orgs (userId, organizationId) values (643, 51);

insert into Users_Roles values (643, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (648, 1, current_timestamp, current_timestamp, FALSE, 649, 'test', FALSE, FALSE, 'ord3', 'test.ord.3@liferay.com', 'Welcome Test ORD 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (649, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (650, 1, 648, 9, 648, 0, 0, '650', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (651, 1, 650, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (652, 1, 650, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (648, 14);

insert into Users_Orgs (userId, organizationId) values (648, 17);
insert into Users_Orgs (userId, organizationId) values (648, 51);

insert into Users_Roles values (648, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (653, 1, current_timestamp, current_timestamp, FALSE, 654, 'test', FALSE, FALSE, 'ord4', 'test.ord.4@liferay.com', 'Welcome Test ORD 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (654, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (655, 1, 653, 9, 653, 0, 0, '655', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (656, 1, 655, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (657, 1, 655, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (653, 14);

insert into Users_Orgs (userId, organizationId) values (653, 17);
insert into Users_Orgs (userId, organizationId) values (653, 51);

insert into Users_Roles values (653, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (658, 1, current_timestamp, current_timestamp, FALSE, 659, 'test', FALSE, FALSE, 'ord5', 'test.ord.5@liferay.com', 'Welcome Test ORD 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (659, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (660, 1, 658, 9, 658, 0, 0, '660', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (661, 1, 660, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (662, 1, 660, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (658, 14);

insert into Users_Orgs (userId, organizationId) values (658, 17);
insert into Users_Orgs (userId, organizationId) values (658, 51);

insert into Users_Roles values (658, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (663, 1, current_timestamp, current_timestamp, FALSE, 664, 'test', FALSE, FALSE, 'ord6', 'test.ord.6@liferay.com', 'Welcome Test ORD 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (664, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (665, 1, 663, 9, 663, 0, 0, '665', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (666, 1, 665, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (667, 1, 665, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (663, 14);

insert into Users_Orgs (userId, organizationId) values (663, 17);
insert into Users_Orgs (userId, organizationId) values (663, 51);

insert into Users_Roles values (663, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (668, 1, current_timestamp, current_timestamp, FALSE, 669, 'test', FALSE, FALSE, 'ord7', 'test.ord.7@liferay.com', 'Welcome Test ORD 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (669, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (670, 1, 668, 9, 668, 0, 0, '670', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (671, 1, 670, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (672, 1, 670, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (668, 14);

insert into Users_Orgs (userId, organizationId) values (668, 17);
insert into Users_Orgs (userId, organizationId) values (668, 51);

insert into Users_Roles values (668, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (673, 1, current_timestamp, current_timestamp, FALSE, 674, 'test', FALSE, FALSE, 'ord8', 'test.ord.8@liferay.com', 'Welcome Test ORD 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (674, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (675, 1, 673, 9, 673, 0, 0, '675', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (676, 1, 675, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (677, 1, 675, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (673, 14);

insert into Users_Orgs (userId, organizationId) values (673, 17);
insert into Users_Orgs (userId, organizationId) values (673, 51);

insert into Users_Roles values (673, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (678, 1, current_timestamp, current_timestamp, FALSE, 679, 'test', FALSE, FALSE, 'ord9', 'test.ord.9@liferay.com', 'Welcome Test ORD 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (679, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (680, 1, 678, 9, 678, 0, 0, '680', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (681, 1, 680, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (682, 1, 680, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (678, 14);

insert into Users_Orgs (userId, organizationId) values (678, 17);
insert into Users_Orgs (userId, organizationId) values (678, 51);

insert into Users_Roles values (678, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (683, 1, current_timestamp, current_timestamp, FALSE, 684, 'test', FALSE, FALSE, 'ord10', 'test.ord.10@liferay.com', 'Welcome Test ORD 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (684, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (685, 1, 683, 9, 683, 0, 0, '685', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (686, 1, 685, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (687, 1, 685, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (683, 14);

insert into Users_Orgs (userId, organizationId) values (683, 17);
insert into Users_Orgs (userId, organizationId) values (683, 51);

insert into Users_Roles values (683, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (688, 1, current_timestamp, current_timestamp, FALSE, 689, 'test', FALSE, FALSE, 'nyc1', 'test.nyc.1@liferay.com', 'Welcome Test NYC 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (689, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (690, 1, 688, 9, 688, 0, 0, '690', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (691, 1, 690, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (692, 1, 690, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (688, 14);

insert into Users_Orgs (userId, organizationId) values (688, 17);
insert into Users_Orgs (userId, organizationId) values (688, 55);

insert into Users_Roles values (688, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (693, 1, current_timestamp, current_timestamp, FALSE, 694, 'test', FALSE, FALSE, 'nyc2', 'test.nyc.2@liferay.com', 'Welcome Test NYC 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (694, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (695, 1, 693, 9, 693, 0, 0, '695', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (696, 1, 695, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (697, 1, 695, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (693, 14);

insert into Users_Orgs (userId, organizationId) values (693, 17);
insert into Users_Orgs (userId, organizationId) values (693, 55);

insert into Users_Roles values (693, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (698, 1, current_timestamp, current_timestamp, FALSE, 699, 'test', FALSE, FALSE, 'nyc3', 'test.nyc.3@liferay.com', 'Welcome Test NYC 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (699, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (700, 1, 698, 9, 698, 0, 0, '700', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (701, 1, 700, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (702, 1, 700, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (698, 14);

insert into Users_Orgs (userId, organizationId) values (698, 17);
insert into Users_Orgs (userId, organizationId) values (698, 55);

insert into Users_Roles values (698, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (703, 1, current_timestamp, current_timestamp, FALSE, 704, 'test', FALSE, FALSE, 'nyc4', 'test.nyc.4@liferay.com', 'Welcome Test NYC 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (704, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (705, 1, 703, 9, 703, 0, 0, '705', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (706, 1, 705, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (707, 1, 705, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (703, 14);

insert into Users_Orgs (userId, organizationId) values (703, 17);
insert into Users_Orgs (userId, organizationId) values (703, 55);

insert into Users_Roles values (703, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (708, 1, current_timestamp, current_timestamp, FALSE, 709, 'test', FALSE, FALSE, 'nyc5', 'test.nyc.5@liferay.com', 'Welcome Test NYC 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (709, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (710, 1, 708, 9, 708, 0, 0, '710', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (711, 1, 710, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (712, 1, 710, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (708, 14);

insert into Users_Orgs (userId, organizationId) values (708, 17);
insert into Users_Orgs (userId, organizationId) values (708, 55);

insert into Users_Roles values (708, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (713, 1, current_timestamp, current_timestamp, FALSE, 714, 'test', FALSE, FALSE, 'nyc6', 'test.nyc.6@liferay.com', 'Welcome Test NYC 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (714, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (715, 1, 713, 9, 713, 0, 0, '715', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (716, 1, 715, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (717, 1, 715, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (713, 14);

insert into Users_Orgs (userId, organizationId) values (713, 17);
insert into Users_Orgs (userId, organizationId) values (713, 55);

insert into Users_Roles values (713, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (718, 1, current_timestamp, current_timestamp, FALSE, 719, 'test', FALSE, FALSE, 'nyc7', 'test.nyc.7@liferay.com', 'Welcome Test NYC 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (719, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (720, 1, 718, 9, 718, 0, 0, '720', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (721, 1, 720, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (722, 1, 720, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (718, 14);

insert into Users_Orgs (userId, organizationId) values (718, 17);
insert into Users_Orgs (userId, organizationId) values (718, 55);

insert into Users_Roles values (718, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (723, 1, current_timestamp, current_timestamp, FALSE, 724, 'test', FALSE, FALSE, 'nyc8', 'test.nyc.8@liferay.com', 'Welcome Test NYC 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (724, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (725, 1, 723, 9, 723, 0, 0, '725', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (726, 1, 725, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (727, 1, 725, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (723, 14);

insert into Users_Orgs (userId, organizationId) values (723, 17);
insert into Users_Orgs (userId, organizationId) values (723, 55);

insert into Users_Roles values (723, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (728, 1, current_timestamp, current_timestamp, FALSE, 729, 'test', FALSE, FALSE, 'nyc9', 'test.nyc.9@liferay.com', 'Welcome Test NYC 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (729, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (730, 1, 728, 9, 728, 0, 0, '730', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (731, 1, 730, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (732, 1, 730, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (728, 14);

insert into Users_Orgs (userId, organizationId) values (728, 17);
insert into Users_Orgs (userId, organizationId) values (728, 55);

insert into Users_Roles values (728, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (733, 1, current_timestamp, current_timestamp, FALSE, 734, 'test', FALSE, FALSE, 'nyc10', 'test.nyc.10@liferay.com', 'Welcome Test NYC 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (734, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (735, 1, 733, 9, 733, 0, 0, '735', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (736, 1, 735, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (737, 1, 735, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (733, 14);

insert into Users_Orgs (userId, organizationId) values (733, 17);
insert into Users_Orgs (userId, organizationId) values (733, 55);

insert into Users_Roles values (733, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (738, 1, current_timestamp, current_timestamp, FALSE, 739, 'test', FALSE, FALSE, 'gru1', 'test.gru.1@liferay.com', 'Welcome Test GRU 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (739, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (740, 1, 738, 9, 738, 0, 0, '740', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (741, 1, 740, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (742, 1, 740, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (738, 14);

insert into Users_Orgs (userId, organizationId) values (738, 17);
insert into Users_Orgs (userId, organizationId) values (738, 59);

insert into Users_Roles values (738, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (743, 1, current_timestamp, current_timestamp, FALSE, 744, 'test', FALSE, FALSE, 'gru2', 'test.gru.2@liferay.com', 'Welcome Test GRU 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (744, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (745, 1, 743, 9, 743, 0, 0, '745', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (746, 1, 745, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (747, 1, 745, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (743, 14);

insert into Users_Orgs (userId, organizationId) values (743, 17);
insert into Users_Orgs (userId, organizationId) values (743, 59);

insert into Users_Roles values (743, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (748, 1, current_timestamp, current_timestamp, FALSE, 749, 'test', FALSE, FALSE, 'gru3', 'test.gru.3@liferay.com', 'Welcome Test GRU 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (749, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (750, 1, 748, 9, 748, 0, 0, '750', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (751, 1, 750, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (752, 1, 750, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (748, 14);

insert into Users_Orgs (userId, organizationId) values (748, 17);
insert into Users_Orgs (userId, organizationId) values (748, 59);

insert into Users_Roles values (748, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (753, 1, current_timestamp, current_timestamp, FALSE, 754, 'test', FALSE, FALSE, 'gru4', 'test.gru.4@liferay.com', 'Welcome Test GRU 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (754, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (755, 1, 753, 9, 753, 0, 0, '755', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (756, 1, 755, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (757, 1, 755, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (753, 14);

insert into Users_Orgs (userId, organizationId) values (753, 17);
insert into Users_Orgs (userId, organizationId) values (753, 59);

insert into Users_Roles values (753, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (758, 1, current_timestamp, current_timestamp, FALSE, 759, 'test', FALSE, FALSE, 'gru5', 'test.gru.5@liferay.com', 'Welcome Test GRU 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (759, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (760, 1, 758, 9, 758, 0, 0, '760', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (761, 1, 760, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (762, 1, 760, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (758, 14);

insert into Users_Orgs (userId, organizationId) values (758, 17);
insert into Users_Orgs (userId, organizationId) values (758, 59);

insert into Users_Roles values (758, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (763, 1, current_timestamp, current_timestamp, FALSE, 764, 'test', FALSE, FALSE, 'gru6', 'test.gru.6@liferay.com', 'Welcome Test GRU 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (764, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (765, 1, 763, 9, 763, 0, 0, '765', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (766, 1, 765, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (767, 1, 765, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (763, 14);

insert into Users_Orgs (userId, organizationId) values (763, 17);
insert into Users_Orgs (userId, organizationId) values (763, 59);

insert into Users_Roles values (763, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (768, 1, current_timestamp, current_timestamp, FALSE, 769, 'test', FALSE, FALSE, 'gru7', 'test.gru.7@liferay.com', 'Welcome Test GRU 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (769, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (770, 1, 768, 9, 768, 0, 0, '770', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (771, 1, 770, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (772, 1, 770, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (768, 14);

insert into Users_Orgs (userId, organizationId) values (768, 17);
insert into Users_Orgs (userId, organizationId) values (768, 59);

insert into Users_Roles values (768, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (773, 1, current_timestamp, current_timestamp, FALSE, 774, 'test', FALSE, FALSE, 'gru8', 'test.gru.8@liferay.com', 'Welcome Test GRU 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (774, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (775, 1, 773, 9, 773, 0, 0, '775', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (776, 1, 775, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (777, 1, 775, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (773, 14);

insert into Users_Orgs (userId, organizationId) values (773, 17);
insert into Users_Orgs (userId, organizationId) values (773, 59);

insert into Users_Roles values (773, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (778, 1, current_timestamp, current_timestamp, FALSE, 779, 'test', FALSE, FALSE, 'gru9', 'test.gru.9@liferay.com', 'Welcome Test GRU 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (779, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (780, 1, 778, 9, 778, 0, 0, '780', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (781, 1, 780, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (782, 1, 780, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (778, 14);

insert into Users_Orgs (userId, organizationId) values (778, 17);
insert into Users_Orgs (userId, organizationId) values (778, 59);

insert into Users_Roles values (778, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (783, 1, current_timestamp, current_timestamp, FALSE, 784, 'test', FALSE, FALSE, 'gru10', 'test.gru.10@liferay.com', 'Welcome Test GRU 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (784, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (785, 1, 783, 9, 783, 0, 0, '785', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (786, 1, 785, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (787, 1, 785, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (783, 14);

insert into Users_Orgs (userId, organizationId) values (783, 17);
insert into Users_Orgs (userId, organizationId) values (783, 59);

insert into Users_Roles values (783, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (788, 1, current_timestamp, current_timestamp, FALSE, 789, 'test', FALSE, FALSE, 'fra1', 'test.fra.1@liferay.com', 'Welcome Test FRA 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (789, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (790, 1, 788, 9, 788, 0, 0, '790', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (791, 1, 790, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (792, 1, 790, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (788, 14);

insert into Users_Orgs (userId, organizationId) values (788, 17);
insert into Users_Orgs (userId, organizationId) values (788, 63);

insert into Users_Roles values (788, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (793, 1, current_timestamp, current_timestamp, FALSE, 794, 'test', FALSE, FALSE, 'fra2', 'test.fra.2@liferay.com', 'Welcome Test FRA 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (794, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (795, 1, 793, 9, 793, 0, 0, '795', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (796, 1, 795, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (797, 1, 795, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (793, 14);

insert into Users_Orgs (userId, organizationId) values (793, 17);
insert into Users_Orgs (userId, organizationId) values (793, 63);

insert into Users_Roles values (793, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (798, 1, current_timestamp, current_timestamp, FALSE, 799, 'test', FALSE, FALSE, 'fra3', 'test.fra.3@liferay.com', 'Welcome Test FRA 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (799, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (800, 1, 798, 9, 798, 0, 0, '800', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (801, 1, 800, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (802, 1, 800, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (798, 14);

insert into Users_Orgs (userId, organizationId) values (798, 17);
insert into Users_Orgs (userId, organizationId) values (798, 63);

insert into Users_Roles values (798, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (803, 1, current_timestamp, current_timestamp, FALSE, 804, 'test', FALSE, FALSE, 'fra4', 'test.fra.4@liferay.com', 'Welcome Test FRA 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (804, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (805, 1, 803, 9, 803, 0, 0, '805', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (806, 1, 805, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (807, 1, 805, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (803, 14);

insert into Users_Orgs (userId, organizationId) values (803, 17);
insert into Users_Orgs (userId, organizationId) values (803, 63);

insert into Users_Roles values (803, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (808, 1, current_timestamp, current_timestamp, FALSE, 809, 'test', FALSE, FALSE, 'fra5', 'test.fra.5@liferay.com', 'Welcome Test FRA 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (809, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (810, 1, 808, 9, 808, 0, 0, '810', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (811, 1, 810, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (812, 1, 810, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (808, 14);

insert into Users_Orgs (userId, organizationId) values (808, 17);
insert into Users_Orgs (userId, organizationId) values (808, 63);

insert into Users_Roles values (808, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (813, 1, current_timestamp, current_timestamp, FALSE, 814, 'test', FALSE, FALSE, 'fra6', 'test.fra.6@liferay.com', 'Welcome Test FRA 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (814, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (815, 1, 813, 9, 813, 0, 0, '815', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (816, 1, 815, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (817, 1, 815, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (813, 14);

insert into Users_Orgs (userId, organizationId) values (813, 17);
insert into Users_Orgs (userId, organizationId) values (813, 63);

insert into Users_Roles values (813, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (818, 1, current_timestamp, current_timestamp, FALSE, 819, 'test', FALSE, FALSE, 'fra7', 'test.fra.7@liferay.com', 'Welcome Test FRA 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (819, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (820, 1, 818, 9, 818, 0, 0, '820', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (821, 1, 820, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (822, 1, 820, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (818, 14);

insert into Users_Orgs (userId, organizationId) values (818, 17);
insert into Users_Orgs (userId, organizationId) values (818, 63);

insert into Users_Roles values (818, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (823, 1, current_timestamp, current_timestamp, FALSE, 824, 'test', FALSE, FALSE, 'fra8', 'test.fra.8@liferay.com', 'Welcome Test FRA 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (824, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (825, 1, 823, 9, 823, 0, 0, '825', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (826, 1, 825, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (827, 1, 825, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (823, 14);

insert into Users_Orgs (userId, organizationId) values (823, 17);
insert into Users_Orgs (userId, organizationId) values (823, 63);

insert into Users_Roles values (823, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (828, 1, current_timestamp, current_timestamp, FALSE, 829, 'test', FALSE, FALSE, 'fra9', 'test.fra.9@liferay.com', 'Welcome Test FRA 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (829, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (830, 1, 828, 9, 828, 0, 0, '830', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (831, 1, 830, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (832, 1, 830, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (828, 14);

insert into Users_Orgs (userId, organizationId) values (828, 17);
insert into Users_Orgs (userId, organizationId) values (828, 63);

insert into Users_Roles values (828, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (833, 1, current_timestamp, current_timestamp, FALSE, 834, 'test', FALSE, FALSE, 'fra10', 'test.fra.10@liferay.com', 'Welcome Test FRA 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (834, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (835, 1, 833, 9, 833, 0, 0, '835', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (836, 1, 835, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (837, 1, 835, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (833, 14);

insert into Users_Orgs (userId, organizationId) values (833, 17);
insert into Users_Orgs (userId, organizationId) values (833, 63);

insert into Users_Roles values (833, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (838, 1, current_timestamp, current_timestamp, FALSE, 839, 'test', FALSE, FALSE, 'mad1', 'test.mad.1@liferay.com', 'Welcome Test MAD 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (839, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (840, 1, 838, 9, 838, 0, 0, '840', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (841, 1, 840, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (842, 1, 840, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (838, 14);

insert into Users_Orgs (userId, organizationId) values (838, 17);
insert into Users_Orgs (userId, organizationId) values (838, 67);

insert into Users_Roles values (838, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (843, 1, current_timestamp, current_timestamp, FALSE, 844, 'test', FALSE, FALSE, 'mad2', 'test.mad.2@liferay.com', 'Welcome Test MAD 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (844, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (845, 1, 843, 9, 843, 0, 0, '845', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (846, 1, 845, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (847, 1, 845, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (843, 14);

insert into Users_Orgs (userId, organizationId) values (843, 17);
insert into Users_Orgs (userId, organizationId) values (843, 67);

insert into Users_Roles values (843, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (848, 1, current_timestamp, current_timestamp, FALSE, 849, 'test', FALSE, FALSE, 'mad3', 'test.mad.3@liferay.com', 'Welcome Test MAD 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (849, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (850, 1, 848, 9, 848, 0, 0, '850', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (851, 1, 850, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (852, 1, 850, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (848, 14);

insert into Users_Orgs (userId, organizationId) values (848, 17);
insert into Users_Orgs (userId, organizationId) values (848, 67);

insert into Users_Roles values (848, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (853, 1, current_timestamp, current_timestamp, FALSE, 854, 'test', FALSE, FALSE, 'mad4', 'test.mad.4@liferay.com', 'Welcome Test MAD 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (854, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (855, 1, 853, 9, 853, 0, 0, '855', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (856, 1, 855, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (857, 1, 855, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (853, 14);

insert into Users_Orgs (userId, organizationId) values (853, 17);
insert into Users_Orgs (userId, organizationId) values (853, 67);

insert into Users_Roles values (853, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (858, 1, current_timestamp, current_timestamp, FALSE, 859, 'test', FALSE, FALSE, 'mad5', 'test.mad.5@liferay.com', 'Welcome Test MAD 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (859, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (860, 1, 858, 9, 858, 0, 0, '860', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (861, 1, 860, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (862, 1, 860, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (858, 14);

insert into Users_Orgs (userId, organizationId) values (858, 17);
insert into Users_Orgs (userId, organizationId) values (858, 67);

insert into Users_Roles values (858, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (863, 1, current_timestamp, current_timestamp, FALSE, 864, 'test', FALSE, FALSE, 'mad6', 'test.mad.6@liferay.com', 'Welcome Test MAD 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (864, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (865, 1, 863, 9, 863, 0, 0, '865', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (866, 1, 865, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (867, 1, 865, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (863, 14);

insert into Users_Orgs (userId, organizationId) values (863, 17);
insert into Users_Orgs (userId, organizationId) values (863, 67);

insert into Users_Roles values (863, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (868, 1, current_timestamp, current_timestamp, FALSE, 869, 'test', FALSE, FALSE, 'mad7', 'test.mad.7@liferay.com', 'Welcome Test MAD 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (869, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (870, 1, 868, 9, 868, 0, 0, '870', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (871, 1, 870, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (872, 1, 870, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (868, 14);

insert into Users_Orgs (userId, organizationId) values (868, 17);
insert into Users_Orgs (userId, organizationId) values (868, 67);

insert into Users_Roles values (868, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (873, 1, current_timestamp, current_timestamp, FALSE, 874, 'test', FALSE, FALSE, 'mad8', 'test.mad.8@liferay.com', 'Welcome Test MAD 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (874, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (875, 1, 873, 9, 873, 0, 0, '875', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (876, 1, 875, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (877, 1, 875, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (873, 14);

insert into Users_Orgs (userId, organizationId) values (873, 17);
insert into Users_Orgs (userId, organizationId) values (873, 67);

insert into Users_Roles values (873, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (878, 1, current_timestamp, current_timestamp, FALSE, 879, 'test', FALSE, FALSE, 'mad9', 'test.mad.9@liferay.com', 'Welcome Test MAD 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (879, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (880, 1, 878, 9, 878, 0, 0, '880', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (881, 1, 880, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (882, 1, 880, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (878, 14);

insert into Users_Orgs (userId, organizationId) values (878, 17);
insert into Users_Orgs (userId, organizationId) values (878, 67);

insert into Users_Roles values (878, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (883, 1, current_timestamp, current_timestamp, FALSE, 884, 'test', FALSE, FALSE, 'mad10', 'test.mad.10@liferay.com', 'Welcome Test MAD 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (884, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (885, 1, 883, 9, 883, 0, 0, '885', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (886, 1, 885, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (887, 1, 885, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (883, 14);

insert into Users_Orgs (userId, organizationId) values (883, 17);
insert into Users_Orgs (userId, organizationId) values (883, 67);

insert into Users_Roles values (883, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (888, 1, current_timestamp, current_timestamp, FALSE, 889, 'test', FALSE, FALSE, 'dlc1', 'test.dlc.1@liferay.com', 'Welcome Test DLC 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (889, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (890, 1, 888, 9, 888, 0, 0, '890', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (891, 1, 890, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (892, 1, 890, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (888, 14);

insert into Users_Orgs (userId, organizationId) values (888, 17);
insert into Users_Orgs (userId, organizationId) values (888, 71);

insert into Users_Roles values (888, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (893, 1, current_timestamp, current_timestamp, FALSE, 894, 'test', FALSE, FALSE, 'dlc2', 'test.dlc.2@liferay.com', 'Welcome Test DLC 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (894, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (895, 1, 893, 9, 893, 0, 0, '895', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (896, 1, 895, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (897, 1, 895, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (893, 14);

insert into Users_Orgs (userId, organizationId) values (893, 17);
insert into Users_Orgs (userId, organizationId) values (893, 71);

insert into Users_Roles values (893, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (898, 1, current_timestamp, current_timestamp, FALSE, 899, 'test', FALSE, FALSE, 'dlc3', 'test.dlc.3@liferay.com', 'Welcome Test DLC 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (899, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (900, 1, 898, 9, 898, 0, 0, '900', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (901, 1, 900, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (902, 1, 900, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (898, 14);

insert into Users_Orgs (userId, organizationId) values (898, 17);
insert into Users_Orgs (userId, organizationId) values (898, 71);

insert into Users_Roles values (898, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (903, 1, current_timestamp, current_timestamp, FALSE, 904, 'test', FALSE, FALSE, 'dlc4', 'test.dlc.4@liferay.com', 'Welcome Test DLC 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (904, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (905, 1, 903, 9, 903, 0, 0, '905', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (906, 1, 905, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (907, 1, 905, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (903, 14);

insert into Users_Orgs (userId, organizationId) values (903, 17);
insert into Users_Orgs (userId, organizationId) values (903, 71);

insert into Users_Roles values (903, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (908, 1, current_timestamp, current_timestamp, FALSE, 909, 'test', FALSE, FALSE, 'dlc5', 'test.dlc.5@liferay.com', 'Welcome Test DLC 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (909, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (910, 1, 908, 9, 908, 0, 0, '910', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (911, 1, 910, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (912, 1, 910, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (908, 14);

insert into Users_Orgs (userId, organizationId) values (908, 17);
insert into Users_Orgs (userId, organizationId) values (908, 71);

insert into Users_Roles values (908, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (913, 1, current_timestamp, current_timestamp, FALSE, 914, 'test', FALSE, FALSE, 'dlc6', 'test.dlc.6@liferay.com', 'Welcome Test DLC 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (914, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (915, 1, 913, 9, 913, 0, 0, '915', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (916, 1, 915, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (917, 1, 915, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (913, 14);

insert into Users_Orgs (userId, organizationId) values (913, 17);
insert into Users_Orgs (userId, organizationId) values (913, 71);

insert into Users_Roles values (913, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (918, 1, current_timestamp, current_timestamp, FALSE, 919, 'test', FALSE, FALSE, 'dlc7', 'test.dlc.7@liferay.com', 'Welcome Test DLC 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (919, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (920, 1, 918, 9, 918, 0, 0, '920', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (921, 1, 920, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (922, 1, 920, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (918, 14);

insert into Users_Orgs (userId, organizationId) values (918, 17);
insert into Users_Orgs (userId, organizationId) values (918, 71);

insert into Users_Roles values (918, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (923, 1, current_timestamp, current_timestamp, FALSE, 924, 'test', FALSE, FALSE, 'dlc8', 'test.dlc.8@liferay.com', 'Welcome Test DLC 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (924, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (925, 1, 923, 9, 923, 0, 0, '925', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (926, 1, 925, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (927, 1, 925, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (923, 14);

insert into Users_Orgs (userId, organizationId) values (923, 17);
insert into Users_Orgs (userId, organizationId) values (923, 71);

insert into Users_Roles values (923, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (928, 1, current_timestamp, current_timestamp, FALSE, 929, 'test', FALSE, FALSE, 'dlc9', 'test.dlc.9@liferay.com', 'Welcome Test DLC 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (929, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (930, 1, 928, 9, 928, 0, 0, '930', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (931, 1, 930, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (932, 1, 930, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (928, 14);

insert into Users_Orgs (userId, organizationId) values (928, 17);
insert into Users_Orgs (userId, organizationId) values (928, 71);

insert into Users_Roles values (928, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (933, 1, current_timestamp, current_timestamp, FALSE, 934, 'test', FALSE, FALSE, 'dlc10', 'test.dlc.10@liferay.com', 'Welcome Test DLC 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (934, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (935, 1, 933, 9, 933, 0, 0, '935', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (936, 1, 935, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (937, 1, 935, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (933, 14);

insert into Users_Orgs (userId, organizationId) values (933, 17);
insert into Users_Orgs (userId, organizationId) values (933, 71);

insert into Users_Roles values (933, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (938, 1, current_timestamp, current_timestamp, FALSE, 939, 'test', FALSE, FALSE, 'hkg1', 'test.hkg.1@liferay.com', 'Welcome Test HKG 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (939, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (940, 1, 938, 9, 938, 0, 0, '940', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (941, 1, 940, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (942, 1, 940, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (938, 14);

insert into Users_Orgs (userId, organizationId) values (938, 17);
insert into Users_Orgs (userId, organizationId) values (938, 75);

insert into Users_Roles values (938, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (943, 1, current_timestamp, current_timestamp, FALSE, 944, 'test', FALSE, FALSE, 'hkg2', 'test.hkg.2@liferay.com', 'Welcome Test HKG 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (944, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (945, 1, 943, 9, 943, 0, 0, '945', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (946, 1, 945, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (947, 1, 945, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (943, 14);

insert into Users_Orgs (userId, organizationId) values (943, 17);
insert into Users_Orgs (userId, organizationId) values (943, 75);

insert into Users_Roles values (943, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (948, 1, current_timestamp, current_timestamp, FALSE, 949, 'test', FALSE, FALSE, 'hkg3', 'test.hkg.3@liferay.com', 'Welcome Test HKG 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (949, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (950, 1, 948, 9, 948, 0, 0, '950', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (951, 1, 950, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (952, 1, 950, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (948, 14);

insert into Users_Orgs (userId, organizationId) values (948, 17);
insert into Users_Orgs (userId, organizationId) values (948, 75);

insert into Users_Roles values (948, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (953, 1, current_timestamp, current_timestamp, FALSE, 954, 'test', FALSE, FALSE, 'hkg4', 'test.hkg.4@liferay.com', 'Welcome Test HKG 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (954, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (955, 1, 953, 9, 953, 0, 0, '955', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (956, 1, 955, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (957, 1, 955, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (953, 14);

insert into Users_Orgs (userId, organizationId) values (953, 17);
insert into Users_Orgs (userId, organizationId) values (953, 75);

insert into Users_Roles values (953, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (958, 1, current_timestamp, current_timestamp, FALSE, 959, 'test', FALSE, FALSE, 'hkg5', 'test.hkg.5@liferay.com', 'Welcome Test HKG 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (959, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (960, 1, 958, 9, 958, 0, 0, '960', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (961, 1, 960, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (962, 1, 960, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (958, 14);

insert into Users_Orgs (userId, organizationId) values (958, 17);
insert into Users_Orgs (userId, organizationId) values (958, 75);

insert into Users_Roles values (958, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (963, 1, current_timestamp, current_timestamp, FALSE, 964, 'test', FALSE, FALSE, 'hkg6', 'test.hkg.6@liferay.com', 'Welcome Test HKG 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (964, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (965, 1, 963, 9, 963, 0, 0, '965', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (966, 1, 965, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (967, 1, 965, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (963, 14);

insert into Users_Orgs (userId, organizationId) values (963, 17);
insert into Users_Orgs (userId, organizationId) values (963, 75);

insert into Users_Roles values (963, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (968, 1, current_timestamp, current_timestamp, FALSE, 969, 'test', FALSE, FALSE, 'hkg7', 'test.hkg.7@liferay.com', 'Welcome Test HKG 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (969, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (970, 1, 968, 9, 968, 0, 0, '970', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (971, 1, 970, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (972, 1, 970, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (968, 14);

insert into Users_Orgs (userId, organizationId) values (968, 17);
insert into Users_Orgs (userId, organizationId) values (968, 75);

insert into Users_Roles values (968, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (973, 1, current_timestamp, current_timestamp, FALSE, 974, 'test', FALSE, FALSE, 'hkg8', 'test.hkg.8@liferay.com', 'Welcome Test HKG 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (974, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (975, 1, 973, 9, 973, 0, 0, '975', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (976, 1, 975, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (977, 1, 975, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (973, 14);

insert into Users_Orgs (userId, organizationId) values (973, 17);
insert into Users_Orgs (userId, organizationId) values (973, 75);

insert into Users_Roles values (973, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (978, 1, current_timestamp, current_timestamp, FALSE, 979, 'test', FALSE, FALSE, 'hkg9', 'test.hkg.9@liferay.com', 'Welcome Test HKG 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (979, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (980, 1, 978, 9, 978, 0, 0, '980', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (981, 1, 980, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (982, 1, 980, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (978, 14);

insert into Users_Orgs (userId, organizationId) values (978, 17);
insert into Users_Orgs (userId, organizationId) values (978, 75);

insert into Users_Roles values (978, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (983, 1, current_timestamp, current_timestamp, FALSE, 984, 'test', FALSE, FALSE, 'hkg10', 'test.hkg.10@liferay.com', 'Welcome Test HKG 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (984, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (985, 1, 983, 9, 983, 0, 0, '985', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (986, 1, 985, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (987, 1, 985, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (983, 14);

insert into Users_Orgs (userId, organizationId) values (983, 17);
insert into Users_Orgs (userId, organizationId) values (983, 75);

insert into Users_Roles values (983, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (988, 1, current_timestamp, current_timestamp, FALSE, 989, 'test', FALSE, FALSE, 'kul1', 'test.kul.1@liferay.com', 'Welcome Test KUL 1!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (989, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 1', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (990, 1, 988, 9, 988, 0, 0, '990', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (991, 1, 990, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (992, 1, 990, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (988, 14);

insert into Users_Orgs (userId, organizationId) values (988, 17);
insert into Users_Orgs (userId, organizationId) values (988, 79);

insert into Users_Roles values (988, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (993, 1, current_timestamp, current_timestamp, FALSE, 994, 'test', FALSE, FALSE, 'kul2', 'test.kul.2@liferay.com', 'Welcome Test KUL 2!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (994, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 2', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (995, 1, 993, 9, 993, 0, 0, '995', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (996, 1, 995, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (997, 1, 995, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (993, 14);

insert into Users_Orgs (userId, organizationId) values (993, 17);
insert into Users_Orgs (userId, organizationId) values (993, 79);

insert into Users_Roles values (993, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (998, 1, current_timestamp, current_timestamp, FALSE, 999, 'test', FALSE, FALSE, 'kul3', 'test.kul.3@liferay.com', 'Welcome Test KUL 3!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (999, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 3', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1000, 1, 998, 9, 998, 0, 0, '1000', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1001, 1, 1000, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1002, 1, 1000, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (998, 14);

insert into Users_Orgs (userId, organizationId) values (998, 17);
insert into Users_Orgs (userId, organizationId) values (998, 79);

insert into Users_Roles values (998, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1003, 1, current_timestamp, current_timestamp, FALSE, 1004, 'test', FALSE, FALSE, 'kul4', 'test.kul.4@liferay.com', 'Welcome Test KUL 4!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1004, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 4', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1005, 1, 1003, 9, 1003, 0, 0, '1005', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1006, 1, 1005, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1007, 1, 1005, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (1003, 14);

insert into Users_Orgs (userId, organizationId) values (1003, 17);
insert into Users_Orgs (userId, organizationId) values (1003, 79);

insert into Users_Roles values (1003, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1008, 1, current_timestamp, current_timestamp, FALSE, 1009, 'test', FALSE, FALSE, 'kul5', 'test.kul.5@liferay.com', 'Welcome Test KUL 5!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1009, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 5', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1010, 1, 1008, 9, 1008, 0, 0, '1010', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1011, 1, 1010, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1012, 1, 1010, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (1008, 14);

insert into Users_Orgs (userId, organizationId) values (1008, 17);
insert into Users_Orgs (userId, organizationId) values (1008, 79);

insert into Users_Roles values (1008, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1013, 1, current_timestamp, current_timestamp, FALSE, 1014, 'test', FALSE, FALSE, 'kul6', 'test.kul.6@liferay.com', 'Welcome Test KUL 6!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1014, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 6', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1015, 1, 1013, 9, 1013, 0, 0, '1015', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1016, 1, 1015, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1017, 1, 1015, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (1013, 14);

insert into Users_Orgs (userId, organizationId) values (1013, 17);
insert into Users_Orgs (userId, organizationId) values (1013, 79);

insert into Users_Roles values (1013, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1018, 1, current_timestamp, current_timestamp, FALSE, 1019, 'test', FALSE, FALSE, 'kul7', 'test.kul.7@liferay.com', 'Welcome Test KUL 7!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1019, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 7', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1020, 1, 1018, 9, 1018, 0, 0, '1020', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1021, 1, 1020, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1022, 1, 1020, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (1018, 14);

insert into Users_Orgs (userId, organizationId) values (1018, 17);
insert into Users_Orgs (userId, organizationId) values (1018, 79);

insert into Users_Roles values (1018, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1023, 1, current_timestamp, current_timestamp, FALSE, 1024, 'test', FALSE, FALSE, 'kul8', 'test.kul.8@liferay.com', 'Welcome Test KUL 8!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1024, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 8', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1025, 1, 1023, 9, 1023, 0, 0, '1025', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1026, 1, 1025, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1027, 1, 1025, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (1023, 14);

insert into Users_Orgs (userId, organizationId) values (1023, 17);
insert into Users_Orgs (userId, organizationId) values (1023, 79);

insert into Users_Roles values (1023, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1028, 1, current_timestamp, current_timestamp, FALSE, 1029, 'test', FALSE, FALSE, 'kul9', 'test.kul.9@liferay.com', 'Welcome Test KUL 9!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1029, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 9', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1030, 1, 1028, 9, 1028, 0, 0, '1030', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1031, 1, 1030, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1032, 1, 1030, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (1028, 14);

insert into Users_Orgs (userId, organizationId) values (1028, 17);
insert into Users_Orgs (userId, organizationId) values (1028, 79);

insert into Users_Roles values (1028, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1033, 1, current_timestamp, current_timestamp, FALSE, 1034, 'test', FALSE, FALSE, 'kul10', 'test.kul.10@liferay.com', 'Welcome Test KUL 10!', current_timestamp, 0, TRUE, TRUE);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1034, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 10', TRUE, '1970-01-01');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1035, 1, 1033, 9, 1033, 0, 0, '1035', '', TRUE);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1036, 1, 1035, TRUE, FALSE, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1037, 1, 1035, FALSE, FALSE, 'classic', '01', 0);

insert into Users_Groups values (1033, 14);

insert into Users_Orgs (userId, organizationId) values (1033, 17);
insert into Users_Orgs (userId, organizationId) values (1033, 79);

insert into Users_Roles values (1033, 13);












insert into Release_ (releaseId, createDate, modifiedDate, buildNumber, verified) values (1, current_timestamp, current_timestamp, 5102, FALSE);


create table QUARTZ_JOB_DETAILS (
	JOB_NAME varchar(80) not null,
	JOB_GROUP varchar(80) not null,
	DESCRIPTION varchar(120) null,
	JOB_CLASS_NAME varchar(128) not null,
	IS_DURABLE boolean not null,
	IS_VOLATILE boolean not null,
	IS_STATEFUL boolean not null,
	REQUESTS_RECOVERY boolean not null,
	JOB_DATA binary null,
	primary key (JOB_NAME, JOB_GROUP)
);

create table QUARTZ_JOB_LISTENERS (
	JOB_NAME varchar(80) not null,
	JOB_GROUP varchar(80) not null,
	JOB_LISTENER varchar(80) not null,
	primary key (JOB_NAME, JOB_GROUP, JOB_LISTENER)
);

create table QUARTZ_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	JOB_NAME varchar(80) not null,
	JOB_GROUP varchar(80) not null,
	IS_VOLATILE boolean not null,
	DESCRIPTION varchar(120) null,
	NEXT_FIRE_TIME bigint null,
	PREV_FIRE_TIME bigint null,
	PRIORITY integer null,
	TRIGGER_STATE varchar(16) not null,
	TRIGGER_TYPE varchar(8) not null,
	START_TIME bigint not null,
	END_TIME bigint null,
	CALENDAR_NAME varchar(80) null,
	MISFIRE_INSTR integer null,
	JOB_DATA binary null,
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
);

create table QUARTZ_SIMPLE_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	REPEAT_COUNT bigint not null,
	REPEAT_INTERVAL bigint not null,
	TIMES_TRIGGERED bigint not null,
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
);

create table QUARTZ_CRON_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	CRON_EXPRESSION varchar(80) not null,
	TIME_ZONE_ID varchar(80),
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
);

create table QUARTZ_BLOB_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	BLOB_DATA binary null,
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
);

create table QUARTZ_TRIGGER_LISTENERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	TRIGGER_LISTENER varchar(80) not null,
	primary key (TRIGGER_NAME, TRIGGER_GROUP, TRIGGER_LISTENER)
);

create table QUARTZ_CALENDARS (
	CALENDAR_NAME varchar(80) not null primary key,
	CALENDAR binary not null
);

create table QUARTZ_PAUSED_TRIGGER_GRPS (
	TRIGGER_GROUP varchar(80) not null primary key
);

create table QUARTZ_FIRED_TRIGGERS (
	ENTRY_ID varchar(95) not null primary key,
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	IS_VOLATILE boolean not null,
	INSTANCE_NAME varchar(80) not null,
	FIRED_TIME bigint not null,
	PRIORITY integer not null,
	STATE varchar(16) not null,
	JOB_NAME varchar(80) null,
	JOB_GROUP varchar(80) null,
	IS_STATEFUL boolean null,
	REQUESTS_RECOVERY boolean null
);

create table QUARTZ_SCHEDULER_STATE (
	INSTANCE_NAME varchar(80) not null primary key,
	LAST_CHECKIN_TIME bigint not null,
	CHECKIN_INTERVAL bigint not null
);

create table QUARTZ_LOCKS (
	LOCK_NAME varchar(40) not null primary key
);

commit;

insert into QUARTZ_LOCKS values('TRIGGER_ACCESS');
insert into QUARTZ_LOCKS values('JOB_ACCESS');
insert into QUARTZ_LOCKS values('CALENDAR_ACCESS');
insert into QUARTZ_LOCKS values('STATE_ACCESS');
insert into QUARTZ_LOCKS values('MISFIRE_ACCESS');

create index IX_F7655CC3 on QUARTZ_TRIGGERS (NEXT_FIRE_TIME);
create index IX_9955EFB5 on QUARTZ_TRIGGERS (TRIGGER_STATE);
create index IX_8040C593 on QUARTZ_TRIGGERS (TRIGGER_STATE, NEXT_FIRE_TIME);
create index IX_804154AF on QUARTZ_FIRED_TRIGGERS (INSTANCE_NAME);
create index IX_BAB9A1F7 on QUARTZ_FIRED_TRIGGERS (JOB_GROUP);
create index IX_ADEE6A17 on QUARTZ_FIRED_TRIGGERS (JOB_NAME);
create index IX_64B194F2 on QUARTZ_FIRED_TRIGGERS (TRIGGER_GROUP);
create index IX_5FEABBC on QUARTZ_FIRED_TRIGGERS (TRIGGER_NAME);
create index IX_20D8706C on QUARTZ_FIRED_TRIGGERS (TRIGGER_NAME, TRIGGER_GROUP);



commit;
