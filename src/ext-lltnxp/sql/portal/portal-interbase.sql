create table Account_ (
	accountId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentAccountId int64,
	name varchar(75),
	legalName varchar(75),
	legalId varchar(75),
	legalType varchar(75),
	sicCode varchar(75),
	tickerSymbol varchar(75),
	industry varchar(75),
	type_ varchar(75),
	size_ varchar(75)
);

create table Address (
	addressId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	street1 varchar(75),
	street2 varchar(75),
	street3 varchar(75),
	city varchar(75),
	zip varchar(75),
	regionId int64,
	countryId int64,
	typeId integer,
	mailing smallint,
	primary_ smallint
);

create table AnnouncementsDelivery (
	deliveryId int64 not null primary key,
	companyId int64,
	userId int64,
	type_ varchar(75),
	email smallint,
	sms smallint,
	website smallint
);

create table AnnouncementsEntry (
	uuid_ varchar(75),
	entryId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	title varchar(75),
	content varchar(4000),
	url varchar(4000),
	type_ varchar(75),
	displayDate timestamp,
	expirationDate timestamp,
	priority integer,
	alert smallint
);

create table AnnouncementsFlag (
	flagId int64 not null primary key,
	userId int64,
	createDate timestamp,
	entryId int64,
	value integer
);

create table BlogsCategory (
	categoryId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentCategoryId int64,
	name varchar(75),
	description varchar(4000)
);

create table BlogsEntry (
	uuid_ varchar(75),
	entryId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	title varchar(150),
	urlTitle varchar(150),
	content blob,
	displayDate timestamp,
	draft smallint,
	allowTrackbacks smallint,
	trackbacks blob
);

create table BlogsStatsUser (
	statsUserId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	entryCount integer,
	lastPostDate timestamp,
	ratingsTotalEntries integer,
	ratingsTotalScore double precision,
	ratingsAverageScore double precision
);

create table BookmarksEntry (
	uuid_ varchar(75),
	entryId int64 not null primary key,
	companyId int64,
	userId int64,
	createDate timestamp,
	modifiedDate timestamp,
	folderId int64,
	name varchar(300),
	url varchar(4000),
	comments varchar(4000),
	visits integer,
	priority integer
);

create table BookmarksFolder (
	uuid_ varchar(75),
	folderId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	createDate timestamp,
	modifiedDate timestamp,
	parentFolderId int64,
	name varchar(75),
	description varchar(4000)
);

create table CalEvent (
	uuid_ varchar(75),
	eventId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	title varchar(75),
	description varchar(4000),
	startDate timestamp,
	endDate timestamp,
	durationHour integer,
	durationMinute integer,
	allDay smallint,
	timeZoneSensitive smallint,
	type_ varchar(75),
	repeating smallint,
	recurrence blob,
	remindBy varchar(75),
	firstReminder integer,
	secondReminder integer
);

create table ClassName_ (
	classNameId int64 not null primary key,
	value varchar(200)
);

create table Company (
	companyId int64 not null primary key,
	accountId int64,
	webId varchar(75),
	key_ blob,
	virtualHost varchar(75),
	mx varchar(75),
	logoId int64
);

create table CongViec (
	macv varchar(75) not null primary key,
	tencv varchar(75),
	linhvucid varchar(75),
	nguoitao int64,
	ngaytao timestamp,
	ngayhethan timestamp,
	nguoichidao int64,
	doithuchien varchar(75),
	ykienchidao varchar(75),
	baocaochidao varchar(75),
	chidaothem varchar(75)
);

create table Contact_ (
	contactId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	accountId int64,
	parentContactId int64,
	firstName varchar(75),
	middleName varchar(75),
	lastName varchar(75),
	prefixId integer,
	suffixId integer,
	male smallint,
	birthday timestamp,
	smsSn varchar(75),
	aimSn varchar(75),
	facebookSn varchar(75),
	icqSn varchar(75),
	jabberSn varchar(75),
	msnSn varchar(75),
	mySpaceSn varchar(75),
	skypeSn varchar(75),
	twitterSn varchar(75),
	ymSn varchar(75),
	employeeStatusId varchar(75),
	employeeNumber varchar(75),
	jobTitle varchar(100),
	jobClass varchar(75),
	hoursOfOperation varchar(75)
);

create table Counter (
	name varchar(75) not null primary key,
	currentId int64
);

create table Country (
	countryId int64 not null primary key,
	name varchar(75),
	a2 varchar(75),
	a3 varchar(75),
	number_ varchar(75),
	idd_ varchar(75),
	active_ smallint
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
	uuid_ varchar(75),
	fileEntryId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	versionUserId int64,
	versionUserName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	folderId int64,
	name varchar(300),
	title varchar(300),
	description varchar(4000),
	version double precision,
	size_ integer,
	readCount integer,
	extraSettings blob
);

create table DLFileRank (
	fileRankId int64 not null primary key,
	companyId int64,
	userId int64,
	createDate timestamp,
	folderId int64,
	name varchar(300)
);

create table DLFileShortcut (
	uuid_ varchar(75),
	fileShortcutId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	folderId int64,
	toFolderId int64,
	toName varchar(300)
);

create table DLFileVersion (
	fileVersionId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	folderId int64,
	name varchar(300),
	version double precision,
	size_ integer
);

create table DLFolder (
	uuid_ varchar(75),
	folderId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentFolderId int64,
	name varchar(100),
	description varchar(4000),
	lastPostDate timestamp
);

create table EmailAddress (
	emailAddressId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	address varchar(75),
	typeId integer,
	primary_ smallint
);

create table ExpandoColumn (
	columnId int64 not null primary key,
	tableId int64,
	name varchar(75),
	type_ integer
);

create table ExpandoRow (
	rowId_ int64 not null primary key,
	tableId int64,
	classPK int64
);

create table ExpandoTable (
	tableId int64 not null primary key,
	classNameId int64,
	name varchar(75)
);

create table ExpandoValue (
	valueId int64 not null primary key,
	tableId int64,
	columnId int64,
	rowId_ int64,
	classNameId int64,
	classPK int64,
	data_ varchar(4000)
);

create table Group_ (
	groupId int64 not null primary key,
	companyId int64,
	creatorUserId int64,
	classNameId int64,
	classPK int64,
	parentGroupId int64,
	liveGroupId int64,
	name varchar(75),
	description varchar(4000),
	type_ integer,
	typeSettings varchar(4000),
	friendlyURL varchar(100),
	active_ smallint
);

create table Groups_Orgs (
	groupId int64 not null,
	organizationId int64 not null,
	primary key (groupId, organizationId)
);

create table Groups_Permissions (
	groupId int64 not null,
	permissionId int64 not null,
	primary key (groupId, permissionId)
);

create table Groups_Roles (
	groupId int64 not null,
	roleId int64 not null,
	primary key (groupId, roleId)
);

create table Groups_UserGroups (
	groupId int64 not null,
	userGroupId int64 not null,
	primary key (groupId, userGroupId)
);

create table IGFolder (
	uuid_ varchar(75),
	folderId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	createDate timestamp,
	modifiedDate timestamp,
	parentFolderId int64,
	name varchar(75),
	description varchar(4000)
);

create table IGImage (
	uuid_ varchar(75),
	imageId int64 not null primary key,
	companyId int64,
	userId int64,
	createDate timestamp,
	modifiedDate timestamp,
	folderId int64,
	name varchar(75),
	description varchar(4000),
	smallImageId int64,
	largeImageId int64,
	custom1ImageId int64,
	custom2ImageId int64
);

create table Image (
	imageId int64 not null primary key,
	modifiedDate timestamp,
	text_ blob,
	type_ varchar(75),
	height integer,
	width integer,
	size_ integer
);

create table JournalArticle (
	uuid_ varchar(75),
	id_ int64 not null primary key,
	resourcePrimKey int64,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	articleId varchar(75),
	version double precision,
	title varchar(100),
	description varchar(4000),
	content blob,
	type_ varchar(75),
	structureId varchar(75),
	templateId varchar(75),
	displayDate timestamp,
	approved smallint,
	approvedByUserId int64,
	approvedByUserName varchar(75),
	approvedDate timestamp,
	expired smallint,
	expirationDate timestamp,
	reviewDate timestamp,
	indexable smallint,
	smallImage smallint,
	smallImageId int64,
	smallImageURL varchar(75)
);

create table JournalArticleImage (
	articleImageId int64 not null primary key,
	groupId int64,
	articleId varchar(75),
	version double precision,
	elName varchar(75),
	languageId varchar(75),
	tempImage smallint
);

create table JournalArticleResource (
	resourcePrimKey int64 not null primary key,
	groupId int64,
	articleId varchar(75)
);

create table JournalContentSearch (
	contentSearchId int64 not null primary key,
	groupId int64,
	companyId int64,
	privateLayout smallint,
	layoutId int64,
	portletId varchar(200),
	articleId varchar(75)
);

create table JournalFeed (
	uuid_ varchar(75),
	id_ int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	feedId varchar(75),
	name varchar(75),
	description varchar(4000),
	type_ varchar(75),
	structureId varchar(75),
	templateId varchar(75),
	rendererTemplateId varchar(75),
	delta integer,
	orderByCol varchar(75),
	orderByType varchar(75),
	targetLayoutFriendlyUrl varchar(75),
	targetPortletId varchar(75),
	contentField varchar(75),
	feedType varchar(75),
	feedVersion double precision
);

create table JournalStructure (
	uuid_ varchar(75),
	id_ int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	structureId varchar(75),
	name varchar(75),
	description varchar(4000),
	xsd blob
);

create table JournalTemplate (
	uuid_ varchar(75),
	id_ int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	templateId varchar(75),
	structureId varchar(75),
	name varchar(75),
	description varchar(4000),
	xsl blob,
	langType varchar(75),
	cacheable smallint,
	smallImage smallint,
	smallImageId int64,
	smallImageURL varchar(75)
);

create table Layout (
	plid int64 not null primary key,
	groupId int64,
	companyId int64,
	privateLayout smallint,
	layoutId int64,
	parentLayoutId int64,
	name varchar(4000),
	title varchar(4000),
	description varchar(4000),
	type_ varchar(75),
	typeSettings blob,
	hidden_ smallint,
	friendlyURL varchar(100),
	iconImage smallint,
	iconImageId int64,
	themeId varchar(75),
	colorSchemeId varchar(75),
	wapThemeId varchar(75),
	wapColorSchemeId varchar(75),
	css varchar(4000),
	priority integer,
	dlFolderId int64
);

create table LayoutSet (
	layoutSetId int64 not null primary key,
	groupId int64,
	companyId int64,
	privateLayout smallint,
	logo smallint,
	logoId int64,
	themeId varchar(75),
	colorSchemeId varchar(75),
	wapThemeId varchar(75),
	wapColorSchemeId varchar(75),
	css varchar(4000),
	pageCount integer,
	virtualHost varchar(75)
);

create table ListType (
	listTypeId integer not null primary key,
	name varchar(75),
	type_ varchar(75)
);

create table MBBan (
	banId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	banUserId int64
);

create table MBCategory (
	uuid_ varchar(75),
	categoryId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentCategoryId int64,
	name varchar(75),
	description varchar(4000),
	lastPostDate timestamp
);

create table MBDiscussion (
	discussionId int64 not null primary key,
	classNameId int64,
	classPK int64,
	threadId int64
);

create table MBMessage (
	uuid_ varchar(75),
	messageId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	categoryId int64,
	threadId int64,
	parentMessageId int64,
	subject varchar(75),
	body blob,
	attachments smallint,
	anonymous smallint
);

create table MBMessageFlag (
	messageFlagId int64 not null primary key,
	userId int64,
	messageId int64,
	flag integer
);

create table MBStatsUser (
	statsUserId int64 not null primary key,
	groupId int64,
	userId int64,
	messageCount integer,
	lastPostDate timestamp
);

create table MBThread (
	threadId int64 not null primary key,
	categoryId int64,
	rootMessageId int64,
	messageCount integer,
	viewCount integer,
	lastPostByUserId int64,
	lastPostDate timestamp,
	priority double precision
);

create table MeetingCalComponent (
	mcalId int64 not null primary key,
	groupIds varchar(75),
	startDate timestamp
);

create table MeetingCalendar (
	uuid_ varchar(75),
	mcalId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	state integer,
	place varchar(75),
	place_diff varchar(75),
	sponsor varchar(75),
	component varchar(75),
	note varchar(75),
	userApproved int64,
	dateApproved timestamp,
	moveMcalId int64,
	repeatWeek smallint,
	filename varchar(75),
	morning smallint,
	afternoon smallint,
	evening smallint,
	stt integer,
	prior smallint
);

create table MeetingDetailWeek (
	mdweekId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	focus varchar(75),
	note varchar(75),
	receive varchar(75),
	week integer,
	year integer
);

create table MembershipRequest (
	membershipRequestId int64 not null primary key,
	companyId int64,
	userId int64,
	createDate timestamp,
	groupId int64,
	comments varchar(4000),
	replyComments varchar(4000),
	replyDate timestamp,
	replierUserId int64,
	statusId integer
);

create table Organization_ (
	organizationId int64 not null primary key,
	companyId int64,
	parentOrganizationId int64,
	name varchar(100),
	location smallint,
	recursable smallint,
	regionId int64,
	countryId int64,
	statusId integer,
	comments varchar(4000)
);

create table OrgGroupPermission (
	organizationId int64 not null,
	groupId int64 not null,
	permissionId int64 not null,
	primary key (organizationId, groupId, permissionId)
);

create table OrgGroupRole (
	organizationId int64 not null,
	groupId int64 not null,
	roleId int64 not null,
	primary key (organizationId, groupId, roleId)
);

create table OrgLabor (
	orgLaborId int64 not null primary key,
	organizationId int64,
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
	countryCode varchar(75),
	countryName varchar(75),
	description varchar(75),
	active varchar(75)
);

create table PML_FILETYPE (
	fileTypeId varchar(75) not null primary key,
	fileTypeCode varchar(75),
	fileTypeName varchar(75),
	fieldId varchar(75),
	templateId varchar(75),
	processTime varchar(75),
	description varchar(75),
	active varchar(75),
	currentReceiptNumber varchar(75),
	receiptTemplate varchar(75)
);

create table PML_IDGENERATED (
	id int64 not null primary key,
	year varchar(75),
	curvalue int64
);

create table PML_IDTEMPLATE (
	templateId int64 not null primary key,
	format varchar(75),
	startNumber varchar(75),
	len int64,
	description varchar(75)
);

create table PasswordPolicy (
	passwordPolicyId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	defaultPolicy smallint,
	name varchar(75),
	description varchar(4000),
	changeable smallint,
	changeRequired smallint,
	minAge int64,
	checkSyntax smallint,
	allowDictionaryWords smallint,
	minLength integer,
	history smallint,
	historyCount integer,
	expireable smallint,
	maxAge int64,
	warningTime int64,
	graceLimit integer,
	lockout smallint,
	maxFailure integer,
	lockoutDuration int64,
	requireUnlock smallint,
	resetFailureCount int64
);

create table PasswordPolicyRel (
	passwordPolicyRelId int64 not null primary key,
	passwordPolicyId int64,
	classNameId int64,
	classPK int64
);

create table PasswordTracker (
	passwordTrackerId int64 not null primary key,
	userId int64,
	createDate timestamp,
	password_ varchar(75)
);

create table Permission_ (
	permissionId int64 not null primary key,
	companyId int64,
	actionId varchar(75),
	resourceId int64
);

create table Phone (
	phoneId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	number_ varchar(75),
	extension varchar(75),
	typeId integer,
	primary_ smallint
);

create table PluginSetting (
	pluginSettingId int64 not null primary key,
	companyId int64,
	pluginId varchar(75),
	pluginType varchar(75),
	roles varchar(4000),
	active_ smallint
);

create table PollsChoice (
	uuid_ varchar(75),
	choiceId int64 not null primary key,
	questionId int64,
	name varchar(75),
	description varchar(1000)
);

create table PollsQuestion (
	uuid_ varchar(75),
	questionId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	title varchar(500),
	description varchar(4000),
	expirationDate timestamp,
	lastVoteDate timestamp
);

create table PollsVote (
	voteId int64 not null primary key,
	userId int64,
	questionId int64,
	choiceId int64,
	voteDate timestamp
);

create table Portlet (
	id_ int64 not null primary key,
	companyId int64,
	portletId varchar(200),
	roles varchar(4000),
	active_ smallint
);

create table PortletItem (
	portletItemId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	portletId varchar(75),
	classNameId int64
);

create table PortletPreferences (
	portletPreferencesId int64 not null primary key,
	ownerId int64,
	ownerType integer,
	plid int64,
	portletId varchar(200),
	preferences blob
);

create table RatingsEntry (
	entryId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	score double precision
);

create table RatingsStats (
	statsId int64 not null primary key,
	classNameId int64,
	classPK int64,
	totalEntries integer,
	totalScore double precision,
	averageScore double precision
);

create table ReceiverGroups_Receivers (
	receiverGroupId int64 not null,
	receiverId int64 not null,
	primary key (receiverGroupId, receiverId)
);

create table RecieverGroups_Recievers (
	recieverGroupId int64 not null,
	recieverId int64 not null,
	primary key (recieverGroupId, recieverId)
);

create table Region (
	regionId int64 not null primary key,
	countryId int64,
	regionCode varchar(75),
	name varchar(75),
	active_ smallint
);

create table Release_ (
	releaseId int64 not null primary key,
	createDate timestamp,
	modifiedDate timestamp,
	buildNumber integer,
	buildDate timestamp,
	verified smallint
);

create table ReportsEntry (
	entryId varchar(75) not null primary key,
	companyId varchar(75),
	userId varchar(75),
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75)
);

create table Resource_ (
	resourceId int64 not null primary key,
	codeId int64,
	primKey varchar(300)
);

create table ResourceCode (
	codeId int64 not null primary key,
	companyId int64,
	name varchar(300),
	scope integer
);

create table Role_ (
	roleId int64 not null primary key,
	companyId int64,
	classNameId int64,
	classPK int64,
	name varchar(75),
	description varchar(4000),
	type_ integer
);

create table Roles_Permissions (
	roleId int64 not null,
	permissionId int64 not null,
	primary key (roleId, permissionId)
);

create table SCFrameworkVersi_SCProductVers (
	frameworkVersionId int64 not null,
	productVersionId int64 not null,
	primary key (frameworkVersionId, productVersionId)
);

create table SCFrameworkVersion (
	frameworkVersionId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	url varchar(4000),
	active_ smallint,
	priority integer
);

create table SCLicense (
	licenseId int64 not null primary key,
	name varchar(75),
	url varchar(4000),
	openSource smallint,
	active_ smallint,
	recommended smallint
);

create table SCLicenses_SCProductEntries (
	licenseId int64 not null,
	productEntryId int64 not null,
	primary key (licenseId, productEntryId)
);

create table SCProductEntry (
	productEntryId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	type_ varchar(75),
	tags varchar(300),
	shortDescription varchar(4000),
	longDescription varchar(4000),
	pageURL varchar(4000),
	author varchar(75),
	repoGroupId varchar(75),
	repoArtifactId varchar(75)
);

create table SCProductScreenshot (
	productScreenshotId int64 not null primary key,
	companyId int64,
	groupId int64,
	productEntryId int64,
	thumbnailId int64,
	fullImageId int64,
	priority integer
);

create table SCProductVersion (
	productVersionId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	productEntryId int64,
	version varchar(75),
	changeLog varchar(4000),
	downloadPageURL varchar(4000),
	directDownloadURL varchar(2000),
	repoStoreArtifact smallint
);

create table ServiceComponent (
	serviceComponentId int64 not null primary key,
	buildNamespace varchar(75),
	buildNumber int64,
	buildDate int64,
	data_ blob
);

create table ShoppingCart (
	cartId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	itemIds varchar(4000),
	couponCodes varchar(75),
	altShipping integer,
	insure smallint
);

create table ShoppingCategory (
	categoryId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentCategoryId int64,
	name varchar(75),
	description varchar(4000)
);

create table ShoppingCoupon (
	couponId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	code_ varchar(75),
	name varchar(75),
	description varchar(4000),
	startDate timestamp,
	endDate timestamp,
	active_ smallint,
	limitCategories varchar(4000),
	limitSkus varchar(4000),
	minOrder double precision,
	discount double precision,
	discountType varchar(75)
);

create table ShoppingItem (
	itemId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	categoryId int64,
	sku varchar(75),
	name varchar(200),
	description varchar(4000),
	properties varchar(4000),
	fields_ smallint,
	fieldsQuantities varchar(4000),
	minQuantity integer,
	maxQuantity integer,
	price double precision,
	discount double precision,
	taxable smallint,
	shipping double precision,
	useShippingFormula smallint,
	requiresShipping smallint,
	stockQuantity integer,
	featured_ smallint,
	sale_ smallint,
	smallImage smallint,
	smallImageId int64,
	smallImageURL varchar(75),
	mediumImage smallint,
	mediumImageId int64,
	mediumImageURL varchar(75),
	largeImage smallint,
	largeImageId int64,
	largeImageURL varchar(75)
);

create table ShoppingItemField (
	itemFieldId int64 not null primary key,
	itemId int64,
	name varchar(75),
	values_ varchar(4000),
	description varchar(4000)
);

create table ShoppingItemPrice (
	itemPriceId int64 not null primary key,
	itemId int64,
	minQuantity integer,
	maxQuantity integer,
	price double precision,
	discount double precision,
	taxable smallint,
	shipping double precision,
	useShippingFormula smallint,
	status integer
);

create table ShoppingOrder (
	orderId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	number_ varchar(75),
	tax double precision,
	shipping double precision,
	altShipping varchar(75),
	requiresShipping smallint,
	insure smallint,
	insurance double precision,
	couponCodes varchar(75),
	couponDiscount double precision,
	billingFirstName varchar(75),
	billingLastName varchar(75),
	billingEmailAddress varchar(75),
	billingCompany varchar(75),
	billingStreet varchar(75),
	billingCity varchar(75),
	billingState varchar(75),
	billingZip varchar(75),
	billingCountry varchar(75),
	billingPhone varchar(75),
	shipToBilling smallint,
	shippingFirstName varchar(75),
	shippingLastName varchar(75),
	shippingEmailAddress varchar(75),
	shippingCompany varchar(75),
	shippingStreet varchar(75),
	shippingCity varchar(75),
	shippingState varchar(75),
	shippingZip varchar(75),
	shippingCountry varchar(75),
	shippingPhone varchar(75),
	ccName varchar(75),
	ccType varchar(75),
	ccNumber varchar(75),
	ccExpMonth integer,
	ccExpYear integer,
	ccVerNumber varchar(75),
	comments varchar(4000),
	ppTxnId varchar(75),
	ppPaymentStatus varchar(75),
	ppPaymentGross double precision,
	ppReceiverEmail varchar(75),
	ppPayerEmail varchar(75),
	sendOrderEmail smallint,
	sendShippingEmail smallint
);

create table ShoppingOrderItem (
	orderItemId int64 not null primary key,
	orderId int64,
	itemId varchar(75),
	sku varchar(75),
	name varchar(200),
	description varchar(4000),
	properties varchar(4000),
	price double precision,
	quantity integer,
	shippedDate timestamp
);

create table SocialActivity (
	activityId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	createDate timestamp,
	mirrorActivityId int64,
	classNameId int64,
	classPK int64,
	type_ integer,
	extraData varchar(4000),
	receiverUserId int64
);

create table SocialRelation (
	uuid_ varchar(75),
	relationId int64 not null primary key,
	companyId int64,
	createDate timestamp,
	userId1 int64,
	userId2 int64,
	type_ integer
);

create table SocialRequest (
	uuid_ varchar(75),
	requestId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	type_ integer,
	extraData varchar(4000),
	receiverUserId int64,
	status integer
);

create table Subscription (
	subscriptionId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	frequency varchar(75)
);

create table TagsAsset (
	assetId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	startDate timestamp,
	endDate timestamp,
	publishDate timestamp,
	expirationDate timestamp,
	mimeType varchar(75),
	title varchar(300),
	description varchar(4000),
	summary varchar(4000),
	url varchar(4000),
	height integer,
	width integer,
	priority double precision,
	viewCount integer
);

create table TagsAssets_TagsEntries (
	assetId int64 not null,
	entryId int64 not null,
	primary key (assetId, entryId)
);

create table TagsEntry (
	entryId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75)
);

create table TagsProperty (
	propertyId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	entryId int64,
	key_ varchar(75),
	value varchar(300)
);

create table TagsSource (
	sourceId int64 not null primary key,
	parentSourceId int64,
	name varchar(75),
	acronym varchar(75)
);

create table TasksProposal (
	proposalId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK varchar(75),
	name varchar(75),
	description varchar(4000),
	publishDate timestamp,
	dueDate timestamp
);

create table TasksReview (
	reviewId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	proposalId int64,
	assignedByUserId int64,
	assignedByUserName varchar(75),
	stage integer,
	completed smallint,
	rejected smallint
);

create table User_ (
	uuid_ varchar(75),
	userId int64 not null primary key,
	companyId int64,
	createDate timestamp,
	modifiedDate timestamp,
	defaultUser smallint,
	contactId int64,
	password_ varchar(75),
	passwordEncrypted smallint,
	passwordReset smallint,
	passwordModifiedDate timestamp,
	graceLoginCount integer,
	screenName varchar(75),
	emailAddress varchar(75),
	openId varchar(1024),
	portraitId int64,
	languageId varchar(75),
	timeZoneId varchar(75),
	greeting varchar(75),
	comments varchar(4000),
	loginDate timestamp,
	loginIP varchar(75),
	lastLoginDate timestamp,
	lastLoginIP varchar(75),
	lastFailedLoginDate timestamp,
	failedLoginAttempts integer,
	lockout smallint,
	lockoutDate timestamp,
	agreedToTermsOfUse smallint,
	active_ smallint
);

create table UserGroup (
	userGroupId int64 not null primary key,
	companyId int64,
	parentUserGroupId int64,
	name varchar(75),
	description varchar(4000)
);

create table UserGroupRole (
	userId int64 not null,
	groupId int64 not null,
	roleId int64 not null,
	primary key (userId, groupId, roleId)
);

create table UserIdMapper (
	userIdMapperId int64 not null primary key,
	userId int64,
	type_ varchar(75),
	description varchar(75),
	externalUserId varchar(75)
);

create table Users_Groups (
	userId int64 not null,
	groupId int64 not null,
	primary key (userId, groupId)
);

create table Users_Orgs (
	userId int64 not null,
	organizationId int64 not null,
	primary key (userId, organizationId)
);

create table Users_Permissions (
	userId int64 not null,
	permissionId int64 not null,
	primary key (userId, permissionId)
);

create table Users_Roles (
	userId int64 not null,
	roleId int64 not null,
	primary key (userId, roleId)
);

create table Users_UserGroups (
	userId int64 not null,
	userGroupId int64 not null,
	primary key (userId, userGroupId)
);

create table UserTracker (
	userTrackerId int64 not null primary key,
	companyId int64,
	userId int64,
	modifiedDate timestamp,
	sessionId varchar(200),
	remoteAddr varchar(75),
	remoteHost varchar(75),
	userAgent varchar(200)
);

create table UserTrackerPath (
	userTrackerPathId int64 not null primary key,
	userTrackerId int64,
	path_ varchar(4000),
	pathDate timestamp
);

create table WebDAVProps (
	webDavPropsId int64 not null primary key,
	companyId int64,
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	props blob
);

create table Website (
	websiteId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId int64,
	classPK int64,
	url varchar(4000),
	typeId integer,
	primary_ smallint
);

create table WikiNode (
	uuid_ varchar(75),
	nodeId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	description varchar(4000),
	lastPostDate timestamp
);

create table WikiPage (
	uuid_ varchar(75),
	pageId int64 not null primary key,
	resourcePrimKey int64,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	nodeId int64,
	title varchar(75),
	version double precision,
	minorEdit smallint,
	content blob,
	summary varchar(4000),
	format varchar(75),
	head smallint,
	parentTitle varchar(75),
	redirectTitle varchar(75)
);

create table WikiPageResource (
	resourcePrimKey int64 not null primary key,
	nodeId int64,
	title varchar(75)
);

create table attact_file_document (
	attactFileDocumentId int64 not null primary key,
	attactFileDocumentTitle varchar(75),
	attactFileDocumentPath varchar(75),
	documentManagerId int64,
	userId int64,
	groupId int64,
	companyId int64
);

create table department (
	departmentId int64 not null primary key,
	departmentCode varchar(75),
	departmentName varchar(75),
	departmentDescription varchar(75),
	userId int64,
	groupId int64,
	companyId int64
);

create table document_manager (
	documentManagerId int64 not null primary key,
	documentManagerCode varchar(75),
	documentManagerCategory varchar(75),
	documentManagerStyle varchar(75),
	documentManagerDescription varchar(75),
	documentManagerDateCreate timestamp,
	documentManagerTitle varchar(75),
	userId int64,
	groupId int64,
	companyId int64
);

create table holiday_calendar (
	holidayCalendarId int64 not null primary key,
	holidayCalendarCode varchar(75),
	holidayCalendarDateCreate timestamp,
	holidayCalendarTitle varchar(75),
	holidayCalendarPath varchar(75),
	userId int64,
	groupId int64,
	companyId int64
);

create table pml_Receiver (
	receiverId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	receiverUserId int64,
	receiverUserName varchar(75),
	viewName varchar(75),
	receiverType integer
);

create table pml_ReceiverGroup (
	receiverGroupId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	receiverGroupName varchar(75),
	description varchar(75),
	type_ integer,
	active_ smallint
);

create table pml_Reciever (
	recieverId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	recieverUserId int64,
	recieverUserName varchar(75),
	viewName varchar(75),
	recieverType integer
);

create table pml_RecieverGroup (
	recieverGroupId int64 not null primary key,
	companyId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	recieverGroupName varchar(75),
	description varchar(75),
	type_ integer,
	active_ smallint
);

create table pml_agency (
	agencyid varchar(75) not null primary key,
	agencycode varchar(75),
	agencyname varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_agencyleader (
	agencyId varchar(75) not null primary key,
	userId int64
);

create table pml_attachedfile (
	attachedfileid varchar(75) not null primary key,
	attachedfilecode varchar(75),
	attachedfilename varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_car_resource (
	carId int64 not null primary key,
	companyId int64,
	userId int64,
	createDate timestamp,
	modifiedDate timestamp,
	carName varchar(255),
	carCode varchar(75),
	description varchar(4000)
);

create table pml_career (
	careerid varchar(75) not null primary key,
	careercode varchar(75),
	careername varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_chi_tiet_hscv (
	id_chi_tiet_hscv int64 not null primary key,
	id_ho_so_cong_viec int64,
	id_cong_van_den int64,
	id_cong_van_di int64,
	di_den varchar(75)
);

create table pml_city (
	cityID varchar(75) not null primary key,
	cityCode varchar(75),
	cityName varchar(75),
	description varchar(75),
	active varchar(75),
	countryid varchar(75)
);

create table pml_conf_phongban_hscv (
	pmlDepartmentHSCVId int64 not null primary key,
	departmentsId varchar(75),
	id_ho_so_cong_viec int64,
	description varchar(75)
);

create table pml_delegate (
	delegateid int64 not null primary key,
	assigner int64,
	receiver int64,
	startdate timestamp,
	enddate timestamp,
	canceldate timestamp,
	canceldelegate varchar(75),
	datecreated timestamp
);

create table pml_departmentleader (
	departmentsId varchar(75) not null,
	userId int64 not null,
	clericalid int64,
	main smallint,
	primary key (departmentsId, userId)
);

create table pml_departments (
	departmentsid varchar(75) not null primary key,
	departmentsparentid varchar(75),
	departmentscode varchar(75),
	departmentsname varchar(75),
	abbreviatename varchar(75),
	description varchar(75),
	active varchar(75),
	agencyid varchar(75),
	roleid int64,
	hasteam varchar(75)
);

create table pml_district (
	districtId varchar(75) not null primary key,
	districtCode varchar(75),
	districtName varchar(75),
	cityID varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_do_quan_trong (
	id_do_quan_trong int64 not null primary key,
	ten_do_quan_trong varchar(75)
);

create table pml_documentreceipt_issuingplace_log (
	documentReceiptIssuingPlaceLogId int64 not null primary key,
	documentReceiptId int64,
	processor int64,
	directProcessorId int64,
	dateProcess timestamp,
	processInfomation varchar(75),
	receiver varchar(75),
	type_ integer,
	step integer
);

create table pml_documentreceipt_log (
	documentreceiptlogid int64 not null primary key,
	documentreceiptid int64,
	transition_ integer,
	processer int64,
	dateprocess timestamp,
	processinfomation varchar(75),
	receiver int64,
	receivedate timestamp,
	stateprocessidbefore int64,
	stateprocessidafter int64,
	type_ integer,
	expireddate timestamp,
	numdateprocess integer,
	processinstanceid int64,
	maindepartmentprocessid varchar(75),
	mainuserprocessid int64,
	senddatebefore timestamp,
	departmentreceiveid varchar(75),
	departmentprocessid varchar(75),
	dateProcessTime timestamp,
	receiveDateTime timestamp,
	directProcesserId int64,
	step integer
);

create table pml_documentreceipt_wf (
	processid int64 not null primary key,
	documentreceiptid int64,
	ismain varchar(75)
);

create table pml_documentsend_log (
	documentsendlogid int64 not null primary key,
	documentsendid int64,
	transition_ integer,
	processer int64,
	dateprocess timestamp,
	processinfomation varchar(75),
	receiver int64,
	receivedate timestamp,
	stateprocessidbefore int64,
	stateprocessidafter int64,
	expireddate timestamp,
	numdateprocess integer,
	processinstanceid int64,
	type_ integer,
	senddatebefore timestamp,
	departmentreceiveid varchar(75),
	departmentprocessid varchar(75),
	dateprocesstime timestamp,
	receivedatetime timestamp,
	directProcesserId int64,
	step integer
);

create table pml_documentsend_wf (
	documentsendid int64 not null primary key,
	processid int64,
	isMain varchar(75)
);

create table pml_edm_answerdetail (
	documentreceiptid int64 not null primary key,
	documentsendid int64
);

create table pml_edm_attachedfile (
	attachedfileid int64 not null primary key,
	objectcontentid int64,
	objecttype varchar(75),
	attachedfilename varchar(75),
	path varchar(75),
	datecreated timestamp,
	filetype varchar(75),
	fileid integer,
	title varchar(75),
	displayorhidden smallint
);

create table pml_edm_bookdocumentrecordto (
	documentreceiptid int64 not null,
	documentrecordtoid int64 not null,
	datecreate timestamp,
	datecomplete timestamp,
	soCongVanDenPhongHienTai integer,
	primary key (documentreceiptid, documentrecordtoid)
);

create table pml_edm_bookdocumentsend (
	bookdocumentsendid int64 not null primary key,
	datecreated timestamp,
	currentrecord int64,
	departmentsid varchar(75),
	documentrecordtypeid integer,
	yearinuse varchar(75),
	active varchar(75),
	isagency varchar(75),
	agencyid varchar(75)
);

create table pml_edm_cadre (
	userid int64 not null primary key,
	positionid varchar(75),
	departmentsid varchar(75),
	handphone varchar(75),
	note varchar(75),
	active varchar(75)
);

create table pml_edm_confidentiallevel (
	confidentiallevelid varchar(75) not null primary key,
	confidentiallevelname varchar(75),
	limitviewdetail smallint,
	haveprocess smallint,
	confidentiallevelsymbol integer
);

create table pml_edm_docconfuser (
	dcuId int64 not null primary key,
	userId int64,
	viewAllDoc smallint,
	viewDepDoc varchar(75)
);

create table pml_edm_documentdelegate (
	documentDelegateId int64 not null primary key,
	userDelegateId int64,
	userIsDelegateId int64,
	documentId integer,
	fromtDate timestamp,
	toDate timestamp,
	cancelDate timestamp
);

create table pml_edm_documentreceipt (
	documentReceiptId int64 not null primary key,
	levelsendid integer,
	documenttypeid int64,
	documentreference varchar(75),
	issuingplaceid varchar(75),
	issuingdate timestamp,
	datearrive timestamp,
	signer varchar(75),
	privilegelevelid varchar(75),
	confidentiallevelid varchar(75),
	opinion varchar(75),
	briefcontent varchar(75),
	ispublic varchar(75),
	numberdocumentreceipt varchar(75),
	processtime integer,
	status varchar(75),
	active varchar(75),
	numberlocaldocumentreceipt varchar(75),
	issuingplaceothername varchar(75),
	documenttype varchar(75),
	datebutphe timestamp,
	datehoanthanh timestamp,
	statusid int64,
	thoigiannhancvden varchar(75),
	socongvandiphucdap varchar(75),
	generalorderno int64,
	maindepartmentprocessid varchar(75),
	mainuserprocessid int64,
	orgexternalid int64,
	docreceipttempid int64,
	documentrecordtypeid integer,
	donvisaoy varchar(75)
);

create table pml_edm_documentreceipt_temp (
	documentReceiptId int64 not null primary key,
	levelsendid integer,
	documenttypeid int64,
	documentreference varchar(75),
	issuingplaceid varchar(75),
	issuingdate timestamp,
	datearrive timestamp,
	signer varchar(75),
	privilegelevelid varchar(75),
	confidentiallevelid varchar(75),
	opinion varchar(75),
	briefcontent varchar(75),
	ispublic varchar(75),
	numberdocumentreceipt varchar(75),
	processtime integer,
	status varchar(75),
	active varchar(75),
	numberlocaldocumentreceipt varchar(75),
	issuingplaceothername varchar(75),
	documenttype varchar(75),
	datebutphe timestamp,
	datehoanthanh timestamp,
	statusid int64,
	thoigiannhancvden varchar(75),
	socongvandiphucdap varchar(75),
	generalorderno int64,
	maindepartmentprocessid varchar(75),
	mainuserprocessid int64,
	orgexternalid int64
);

create table pml_edm_documentreceiptextend (
	documentreceiptextendid int64 not null primary key,
	documentreceiptid int64,
	documentreceiptlogid int64,
	extendorderno integer,
	startprocessdate timestamp,
	numdayprocessbef integer,
	limitdatebef timestamp,
	extendreason varchar(75),
	numdayprocessaft integer,
	limitdateaft timestamp,
	leanonlimitdate smallint,
	extenduserid int64,
	extenddepartmentid varchar(75)
);

create table pml_edm_documentreceiptprocesstype (
	docReceiptProcessTypeId int64 not null primary key,
	documentReceiptId int64,
	documentReceiptLogId int64,
	processTypeOrderNo integer,
	dateEdit timestamp,
	processTypeIdBefore varchar(75),
	processTypeIdAfter varchar(75),
	processTypeReason varchar(75),
	processerId int64,
	departmentId varchar(75)
);

create table pml_edm_documentrecordto (
	documentrecordtoid int64 not null primary key,
	datecreate timestamp,
	currentrecord int64,
	departmentsid varchar(75),
	documentrecordtypeid integer,
	yearinuse varchar(75),
	active varchar(75),
	isagency varchar(75),
	agencyid varchar(75)
);

create table pml_edm_documentrecordtype (
	documentrecordtypeid integer not null primary key,
	documentrecordtypename varchar(75),
	documentrecordtypecode varchar(75)
);

create table pml_edm_documentrelation (
	documentrelationid int64 not null primary key,
	docleftid int64,
	docrightid int64,
	leftisreceipt smallint,
	rightisreceipt smallint
);

create table pml_edm_documentsend (
	documentsendid int64 not null primary key,
	briefcontent varchar(75),
	documentreference varchar(75),
	receivingplace varchar(75),
	issuingdate timestamp,
	opinion varchar(75),
	editorid int64,
	signerid int64,
	documenttypeid int64,
	privilegelevelid varchar(75),
	confidentiallevelid varchar(75),
	datecreated timestamp,
	islocal smallint,
	active varchar(75),
	senddate timestamp,
	signername varchar(75),
	position_ varchar(75),
	numberpage varchar(75),
	numberpublish varchar(75),
	documentsendcode varchar(75),
	statusid int64,
	iscongvanphucdap smallint,
	numofdocref int64,
	ispublish smallint,
	orgexternalid int64,
	numofdirector smallint,
	documentrecordtypeid integer
);

create table pml_edm_documenttype (
	documenttypeid int64 not null primary key,
	documenttypename varchar(75),
	documentsymbol varchar(75),
	documentrecordtypeid integer,
	sendreceiptdistinction integer,
	HaveDepartExtends smallint
);

create table pml_edm_issuingplace (
	issuingplaceid varchar(75) not null primary key,
	issuingplacename varchar(75),
	tablephone varchar(75),
	handphone varchar(75),
	email varchar(75),
	address varchar(75),
	active varchar(75),
	note varchar(75),
	issuingplacecode varchar(75),
	signer varchar(75)
);

create table pml_edm_levelsend (
	levelsendid integer not null primary key,
	levelsendname varchar(75),
	levelsendcode varchar(75)
);

create table pml_edm_levelsenddetail (
	levelsendid integer not null,
	issuingPlaceId varchar(75) not null,
	primary key (levelsendid, issuingPlaceId)
);

create table pml_edm_privilegelevel (
	privilegelevelid varchar(75) not null primary key,
	privilegelevelname varchar(75)
);

create table pml_edm_processdocumentreceiptdetail (
	id int64 not null primary key,
	documentreceiptid int64,
	userid int64,
	note varchar(75),
	datecreated timestamp,
	dateupdate timestamp
);

create table pml_edm_writedocumentsend (
	bookdocumentsendid int64 not null,
	documentsendid int64 not null,
	datecreated timestamp,
	soCongVanDiPhongHienTai integer,
	primary key (bookdocumentsendid, documentsendid)
);

create table pml_field (
	fieldId varchar(75) not null primary key,
	fieldCode varchar(75),
	fieldName varchar(75),
	description varchar(75),
	active varchar(75),
	departmentsId varchar(75)
);

create table pml_file (
	fileId varchar(75) not null primary key,
	cityId varchar(75),
	districtId varchar(75),
	wardsId varchar(75),
	streetId varchar(75),
	exactReturningDate timestamp,
	receiverId int64,
	validDate timestamp,
	expectedReturningDate timestamp,
	applicationDate timestamp,
	otherContent varchar(75),
	briefContent varchar(75),
	applicantName varchar(75),
	organization varchar(75),
	authorisedLetter varchar(75),
	idNumber varchar(75),
	issuingDate timestamp,
	issuingPlace varchar(75),
	telephone varchar(75),
	gender varchar(75),
	streetNumber varchar(75),
	permanentAddress varchar(75),
	contactInfomation varchar(75),
	oldNumberReceipt varchar(75),
	numberReceipt varchar(75),
	fileTypeId varchar(75),
	fieldId varchar(75),
	solvingTime integer,
	amendedContent varchar(75),
	landCheckingDate timestamp,
	decisionNotice varchar(75),
	receiver varchar(75),
	dateCreated timestamp,
	lastUpdate timestamp,
	lasttestprocessinfo varchar(75),
	active varchar(75),
	generalorderno int64
);

create table pml_file_attachedfile (
	fileAttachedFileId varchar(75) not null primary key,
	fileId varchar(75),
	original integer,
	copy_ integer,
	attachedFileId varchar(75),
	attachedFileName varchar(75),
	note varchar(75)
);

create table pml_file_pccc (
	fileid varchar(75) not null primary key,
	fileName varchar(75),
	applicantrepresentation varchar(75),
	applicanttelephone varchar(75),
	receiverrepresentation varchar(75),
	receivertelephone varchar(75),
	projectname varchar(75),
	applicantcategory varchar(75),
	addressbuilder varchar(75),
	investor varchar(75),
	designCop varchar(75),
	filenumber integer,
	inputdatadate timestamp,
	noteinformationmanagement varchar(75),
	totalhour integer,
	totaldate integer,
	conclusion varchar(75),
	receiveofunit varchar(75),
	applicanttime varchar(75)
);

create table pml_filepccc_attachedfile (
	attachedfileid int64 not null primary key,
	filepcccid varchar(75),
	objecttype varchar(75),
	attachedfilename varchar(75),
	path varchar(75),
	datecreated timestamp,
	filetype varchar(75),
	title varchar(75)
);

create table pml_filereturninginfo (
	filereturninginfoid int64 not null primary key,
	fileid varchar(75),
	filesender varchar(75),
	licensenumber varchar(75),
	issuingdatelicense timestamp,
	receivelicensedate timestamp,
	documentnumber varchar(75),
	billnumber varchar(75),
	numbermoney int64,
	note varchar(75),
	conclude varchar(75)
);

create table pml_filestatus (
	filestatusid int64 not null primary key,
	filestatuscode varchar(75),
	filestatusname varchar(75),
	description varchar(75),
	active varchar(75),
	type varchar(75)
);

create table pml_filestatus_stateprocess (
	id int64 not null primary key,
	filestatusid int64,
	stateprocessid int64,
	description varchar(75)
);

create table pml_filetype (
	fileTypeId varchar(75) not null primary key,
	fileTypeCode varchar(75),
	fileTypeName varchar(75),
	fieldId varchar(75),
	templateId varchar(75),
	processTime varchar(75),
	description varchar(75),
	active varchar(75),
	currentReceiptNumber varchar(75),
	receiptTemplate varchar(75)
);

create table pml_filetype_attachedfile (
	filetypeAttachedFileId varchar(75) not null primary key,
	fileTypeId varchar(75),
	original integer,
	copy_ integer,
	attachedFileId varchar(75),
	attachedFileName varchar(75),
	note varchar(75)
);

create table pml_filetypedelegate (
	filetypedelegateid int64 not null primary key,
	filetypeid varchar(75),
	delegateid int64
);

create table pml_ho_so_cong_viec (
	id_ho_so_cong_viec int64 not null primary key,
	userId int64,
	userName varchar(75),
	id_hscv_cha int64,
	so_hieu_hscv varchar(75),
	tieu_de varchar(75),
	ngay_mo_hscv timestamp,
	han_xu_ly timestamp,
	id_linh_vuc varchar(75),
	van_de_lien_quan varchar(75),
	id_do_quan_trong int64,
	id_tinh_chat int64,
	id_trang_thai_hscv int64,
	tom_tat_noi_dung varchar(75),
	hoat_dong varchar(75)
);

create table pml_holiday (
	holidayid int64 not null primary key,
	holiday_type varchar(75),
	holiday_value varchar(75),
	from_date timestamp,
	to_date timestamp
);

create table pml_main_support (
	processid int64 not null primary key,
	processid_main int64,
	type_ varchar(75),
	supportinfomation varchar(75)
);

create table pml_manage_documentworkflow (
	managedocumentworkflowid int64 not null primary key,
	workflowname varchar(75),
	version_ integer,
	type_ integer,
	description varchar(75),
	startdate timestamp,
	enddate timestamp
);

create table pml_message_note (
	messageId int64 not null primary key,
	documentId int64,
	fromUserId int64,
	toUserId int64,
	createDate timestamp,
	objectType varchar(75),
	isAlert smallint
);

create table pml_nation (
	nationid varchar(75) not null primary key,
	nationcode varchar(75),
	nationname varchar(75),
	countryid varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_organization_external (
	orgexternalid int64 not null primary key,
	orgexternalcode varchar(75),
	orgexternalname varchar(75),
	isownerorg smallint
);

create table pml_paintdocument (
	paintdocumentid int64 not null primary key,
	fileid varchar(75),
	paintdocumentname varchar(75),
	quantity integer,
	note varchar(75)
);

create table pml_position (
	positionid varchar(75) not null primary key,
	positioncode varchar(75),
	positionname varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_processdispose (
	processdisposeid int64 not null primary key,
	fileid varchar(75),
	transition_ integer,
	processer int64,
	dateprocess timestamp,
	processinfomation varchar(75),
	receiver int64,
	receivedate timestamp,
	stateprocessidbefore int64,
	stateprocessidafter int64,
	expireddate timestamp,
	delegateuser int64,
	senddate timestamp
);

create table pml_processtype (
	processtypeid int64 not null primary key,
	name varchar(75),
	flagprocesstype integer
);

create table pml_role (
	roleid varchar(75) not null primary key,
	rolecode varchar(75),
	rolename varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_room_resource (
	roomId int64 not null primary key,
	companyId int64,
	userId int64,
	createDate timestamp,
	modifiedDate timestamp,
	roomName varchar(255),
	description varchar(4000)
);

create table pml_saveprocesstype (
	sptid int64 not null primary key,
	docId int64,
	flagprocesstype int64,
	flag smallint
);

create table pml_screecalendar_heigth (
	screesalendarheigthid int64 not null primary key
);

create table pml_screencalendar_height (
	screencalendarheightid int64 not null primary key
);

create table pml_signer (
	signerId int64 not null primary key,
	userId int64
);

create table pml_state_department (
	departmentid varchar(75) not null,
	statewfid int64 not null,
	primary key (departmentid, statewfid)
);

create table pml_state_wf (
	statewfid int64 not null primary key,
	workflow varchar(75),
	stateprocessid int64,
	solvingtime integer,
	version_ integer
);

create table pml_stateprocess (
	stateprocessid int64 not null primary key,
	stateprocesscode varchar(75),
	stateprocessname varchar(75),
	filestatusid int64,
	description varchar(75),
	active varchar(75)
);

create table pml_street (
	streetId varchar(75) not null primary key,
	streetName varchar(75)
);

create table pml_team (
	teamid int64 not null primary key,
	departmentid varchar(75),
	teamname varchar(75),
	description varchar(75),
	organizationid int64,
	companyid int64,
	specialteam varchar(75),
	teamcode varchar(75)
);

create table pml_teamleader (
	teamid int64 not null primary key,
	userid int64
);

create table pml_template (
	templateId int64 not null primary key,
	templateCode varchar(75),
	templateName varchar(75),
	numberOfDocument integer,
	publishDate timestamp,
	departmentId varchar(75)
);

create table pml_template_file (
	fileTemplateId int64 not null primary key,
	templateId int64,
	tenFile varchar(75),
	kichThuoc int64,
	duongDan varchar(75)
);

create table pml_tinh_chat (
	id_tinh_chat int64 not null primary key,
	ten_tinh_chat varchar(75)
);

create table pml_trang_thai_hscv (
	id_trang_thai_hscv int64 not null primary key,
	ten_trang_thai_hscv varchar(75)
);

create table pml_transition (
	transitionid int64 not null primary key,
	transitionname varchar(75),
	filetypeid varchar(75),
	notransition integer,
	stateprocesscurrent int64,
	stateprocessnext int64,
	version_ varchar(75)
);

create table pml_user (
	userId int64 not null primary key,
	positionId varchar(75),
	departmentsId varchar(75),
	roleId varchar(75),
	handphone varchar(75),
	note varchar(75),
	teamid int64,
	active smallint,
	screenname varchar(75),
	firstname varchar(75),
	middlename varchar(75),
	lastname varchar(75),
	male smallint,
	birthday timestamp,
	isleadermetting smallint
);

create table pml_user_file_type (
	userid int64 not null,
	filetypeid varchar(75) not null,
	description varchar(75),
	primary key (userid, filetypeid)
);

create table pml_wards (
	wardsId varchar(75) not null primary key,
	wardsCode varchar(75),
	wardsName varchar(75),
	districtId varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_wf_onedoor (
	fileId varchar(75) not null primary key,
	processId int64,
	nodeId int64
);

create table pml_workflow (
	workflowId int64 not null primary key,
	fileTypeId varchar(75),
	workflow varchar(75),
	version_ integer,
	startDate timestamp,
	endDate timestamp
);

create table report_registry_work (
	reportRegistryId int64 not null primary key,
	reportRegistryCode varchar(75),
	userCreate varchar(75),
	resultWork varchar(75),
	programWork varchar(75),
	reportDate timestamp,
	departmentId int64,
	userId int64,
	groupId int64,
	companyId int64
);

create table result_program_file (
	resultProgramId int64 not null primary key,
	resultProgramTitle varchar(75),
	resultProgramPath varchar(75),
	resultProgramCheck varchar(75),
	reportRegistryId int64,
	userId int64,
	groupId int64,
	companyId int64
);





--
-- List types for accounts
--





--
-- List types for contacts
--







--
-- List types for organizations
--


































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































create table QUARTZ_JOB_DETAILS (
	JOB_NAME varchar(80) not null,
	JOB_GROUP varchar(80) not null,
	DESCRIPTION varchar(120),
	JOB_CLASS_NAME varchar(128) not null,
	IS_DURABLE smallint not null,
	IS_VOLATILE smallint not null,
	IS_STATEFUL smallint not null,
	REQUESTS_RECOVERY smallint not null,
	JOB_DATA blob,
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
	IS_VOLATILE smallint not null,
	DESCRIPTION varchar(120),
	NEXT_FIRE_TIME int64,
	PREV_FIRE_TIME int64,
	PRIORITY integer,
	TRIGGER_STATE varchar(16) not null,
	TRIGGER_TYPE varchar(8) not null,
	START_TIME int64 not null,
	END_TIME int64,
	CALENDAR_NAME varchar(80),
	MISFIRE_INSTR integer,
	JOB_DATA blob,
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
);

create table QUARTZ_SIMPLE_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	REPEAT_COUNT int64 not null,
	REPEAT_INTERVAL int64 not null,
	TIMES_TRIGGERED int64 not null,
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
	BLOB_DATA blob,
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
	CALENDAR blob not null
);

create table QUARTZ_PAUSED_TRIGGER_GRPS (
	TRIGGER_GROUP varchar(80) not null primary key
);

create table QUARTZ_FIRED_TRIGGERS (
	ENTRY_ID varchar(95) not null primary key,
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	IS_VOLATILE smallint not null,
	INSTANCE_NAME varchar(80) not null,
	FIRED_TIME int64 not null,
	PRIORITY integer not null,
	STATE varchar(16) not null,
	JOB_NAME varchar(80),
	JOB_GROUP varchar(80),
	IS_STATEFUL smallint,
	REQUESTS_RECOVERY smallint
);

create table QUARTZ_SCHEDULER_STATE (
	INSTANCE_NAME varchar(80) not null primary key,
	LAST_CHECKIN_TIME int64 not null,
	CHECKIN_INTERVAL int64 not null
);

create table QUARTZ_LOCKS (
	LOCK_NAME varchar(40) not null primary key
);

commit;


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
