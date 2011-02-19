create table Account_ (
	accountId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentAccountId bigint,
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
	addressId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	street1 varchar(75),
	street2 varchar(75),
	street3 varchar(75),
	city varchar(75),
	zip varchar(75),
	regionId bigint,
	countryId bigint,
	typeId integer,
	mailing smallint,
	primary_ smallint
);

create table AnnouncementsDelivery (
	deliveryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	type_ varchar(75),
	email smallint,
	sms smallint,
	website smallint
);

create table AnnouncementsEntry (
	uuid_ varchar(75),
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	title varchar(75),
	content long varchar,
	url long varchar,
	type_ varchar(75),
	displayDate timestamp,
	expirationDate timestamp,
	priority integer,
	alert smallint
);

create table AnnouncementsFlag (
	flagId bigint not null primary key,
	userId bigint,
	createDate timestamp,
	entryId bigint,
	value integer
);

create table BlogsCategory (
	categoryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentCategoryId bigint,
	name varchar(75),
	description long varchar
);

create table BlogsEntry (
	uuid_ varchar(75),
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	title varchar(150),
	urlTitle varchar(150),
	content clob,
	displayDate timestamp,
	draft smallint,
	allowTrackbacks smallint,
	trackbacks clob
);

create table BlogsStatsUser (
	statsUserId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	entryCount integer,
	lastPostDate timestamp,
	ratingsTotalEntries integer,
	ratingsTotalScore double,
	ratingsAverageScore double
);

create table BookmarksEntry (
	uuid_ varchar(75),
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	folderId bigint,
	name varchar(300),
	url long varchar,
	comments long varchar,
	visits integer,
	priority integer
);

create table BookmarksFolder (
	uuid_ varchar(75),
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	parentFolderId bigint,
	name varchar(75),
	description long varchar
);

create table CalEvent (
	uuid_ varchar(75),
	eventId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	title varchar(75),
	description long varchar,
	startDate timestamp,
	endDate timestamp,
	durationHour integer,
	durationMinute integer,
	allDay smallint,
	timeZoneSensitive smallint,
	type_ varchar(75),
	repeating smallint,
	recurrence clob,
	remindBy varchar(75),
	firstReminder integer,
	secondReminder integer
);

create table ClassName_ (
	classNameId bigint not null primary key,
	value varchar(200)
);

create table Company (
	companyId bigint not null primary key,
	accountId bigint,
	webId varchar(75),
	key_ clob,
	virtualHost varchar(75),
	mx varchar(75),
	logoId bigint
);

create table CongViec (
	macv varchar(75) not null primary key,
	tencv varchar(75),
	linhvucid varchar(75),
	nguoitao bigint,
	ngaytao timestamp,
	ngayhethan timestamp,
	nguoichidao bigint,
	doithuchien varchar(75),
	ykienchidao varchar(75),
	baocaochidao varchar(75),
	chidaothem varchar(75)
);

create table Contact_ (
	contactId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	accountId bigint,
	parentContactId bigint,
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
	currentId bigint
);

create table Country (
	countryId bigint not null primary key,
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
	fileEntryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	versionUserId bigint,
	versionUserName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	folderId bigint,
	name varchar(300),
	title varchar(300),
	description long varchar,
	version double,
	size_ integer,
	readCount integer,
	extraSettings clob
);

create table DLFileRank (
	fileRankId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	folderId bigint,
	name varchar(300)
);

create table DLFileShortcut (
	uuid_ varchar(75),
	fileShortcutId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	folderId bigint,
	toFolderId bigint,
	toName varchar(300)
);

create table DLFileVersion (
	fileVersionId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	folderId bigint,
	name varchar(300),
	version double,
	size_ integer
);

create table DLFolder (
	uuid_ varchar(75),
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentFolderId bigint,
	name varchar(100),
	description long varchar,
	lastPostDate timestamp
);

create table EmailAddress (
	emailAddressId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	address varchar(75),
	typeId integer,
	primary_ smallint
);

create table ExpandoColumn (
	columnId bigint not null primary key,
	tableId bigint,
	name varchar(75),
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
	name varchar(75)
);

create table ExpandoValue (
	valueId bigint not null primary key,
	tableId bigint,
	columnId bigint,
	rowId_ bigint,
	classNameId bigint,
	classPK bigint,
	data_ long varchar
);

create table Group_ (
	groupId bigint not null primary key,
	companyId bigint,
	creatorUserId bigint,
	classNameId bigint,
	classPK bigint,
	parentGroupId bigint,
	liveGroupId bigint,
	name varchar(75),
	description long varchar,
	type_ integer,
	typeSettings long varchar,
	friendlyURL varchar(100),
	active_ smallint
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
	uuid_ varchar(75),
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	parentFolderId bigint,
	name varchar(75),
	description long varchar
);

create table IGImage (
	uuid_ varchar(75),
	imageId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	folderId bigint,
	name varchar(75),
	description long varchar,
	smallImageId bigint,
	largeImageId bigint,
	custom1ImageId bigint,
	custom2ImageId bigint
);

create table Image (
	imageId bigint not null primary key,
	modifiedDate timestamp,
	text_ clob,
	type_ varchar(75),
	height integer,
	width integer,
	size_ integer
);

create table JournalArticle (
	uuid_ varchar(75),
	id_ bigint not null primary key,
	resourcePrimKey bigint,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	articleId varchar(75),
	version double,
	title varchar(100),
	description long varchar,
	content clob,
	type_ varchar(75),
	structureId varchar(75),
	templateId varchar(75),
	displayDate timestamp,
	approved smallint,
	approvedByUserId bigint,
	approvedByUserName varchar(75),
	approvedDate timestamp,
	expired smallint,
	expirationDate timestamp,
	reviewDate timestamp,
	indexable smallint,
	smallImage smallint,
	smallImageId bigint,
	smallImageURL varchar(75)
);

create table JournalArticleImage (
	articleImageId bigint not null primary key,
	groupId bigint,
	articleId varchar(75),
	version double,
	elName varchar(75),
	languageId varchar(75),
	tempImage smallint
);

create table JournalArticleResource (
	resourcePrimKey bigint not null primary key,
	groupId bigint,
	articleId varchar(75)
);

create table JournalContentSearch (
	contentSearchId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout smallint,
	layoutId bigint,
	portletId varchar(200),
	articleId varchar(75)
);

create table JournalFeed (
	uuid_ varchar(75),
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	feedId varchar(75),
	name varchar(75),
	description long varchar,
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
	feedVersion double
);

create table JournalStructure (
	uuid_ varchar(75),
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	structureId varchar(75),
	name varchar(75),
	description long varchar,
	xsd clob
);

create table JournalTemplate (
	uuid_ varchar(75),
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	templateId varchar(75),
	structureId varchar(75),
	name varchar(75),
	description long varchar,
	xsl clob,
	langType varchar(75),
	cacheable smallint,
	smallImage smallint,
	smallImageId bigint,
	smallImageURL varchar(75)
);

create table Layout (
	plid bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout smallint,
	layoutId bigint,
	parentLayoutId bigint,
	name long varchar,
	title long varchar,
	description long varchar,
	type_ varchar(75),
	typeSettings clob,
	hidden_ smallint,
	friendlyURL varchar(100),
	iconImage smallint,
	iconImageId bigint,
	themeId varchar(75),
	colorSchemeId varchar(75),
	wapThemeId varchar(75),
	wapColorSchemeId varchar(75),
	css long varchar,
	priority integer,
	dlFolderId bigint
);

create table LayoutSet (
	layoutSetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout smallint,
	logo smallint,
	logoId bigint,
	themeId varchar(75),
	colorSchemeId varchar(75),
	wapThemeId varchar(75),
	wapColorSchemeId varchar(75),
	css long varchar,
	pageCount integer,
	virtualHost varchar(75)
);

create table ListType (
	listTypeId integer not null primary key,
	name varchar(75),
	type_ varchar(75)
);

create table MBBan (
	banId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	banUserId bigint
);

create table MBCategory (
	uuid_ varchar(75),
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentCategoryId bigint,
	name varchar(75),
	description long varchar,
	lastPostDate timestamp
);

create table MBDiscussion (
	discussionId bigint not null primary key,
	classNameId bigint,
	classPK bigint,
	threadId bigint
);

create table MBMessage (
	uuid_ varchar(75),
	messageId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	categoryId bigint,
	threadId bigint,
	parentMessageId bigint,
	subject varchar(75),
	body clob,
	attachments smallint,
	anonymous smallint
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
	lastPostDate timestamp
);

create table MBThread (
	threadId bigint not null primary key,
	categoryId bigint,
	rootMessageId bigint,
	messageCount integer,
	viewCount integer,
	lastPostByUserId bigint,
	lastPostDate timestamp,
	priority double
);

create table MeetingCalComponent (
	mcalId bigint not null primary key,
	groupIds varchar(75),
	startDate timestamp
);

create table MeetingCalendar (
	uuid_ varchar(75),
	mcalId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	state integer,
	place varchar(75),
	place_diff varchar(75),
	sponsor varchar(75),
	component varchar(75),
	note varchar(75),
	userApproved bigint,
	dateApproved timestamp,
	moveMcalId bigint,
	repeatWeek smallint,
	filename varchar(75),
	morning smallint,
	afternoon smallint,
	evening smallint,
	stt integer,
	prior smallint,
	deleted smallint
);

create table MeetingDetailWeek (
	mdweekId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	focus varchar(75),
	note varchar(75),
	receive varchar(75),
	week integer,
	year integer
);

create table MembershipRequest (
	membershipRequestId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	groupId bigint,
	comments long varchar,
	replyComments long varchar,
	replyDate timestamp,
	replierUserId bigint,
	statusId integer
);

create table Organization_ (
	organizationId bigint not null primary key,
	companyId bigint,
	parentOrganizationId bigint,
	name varchar(100),
	location smallint,
	recursable smallint,
	regionId bigint,
	countryId bigint,
	statusId integer,
	comments long varchar
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
	id bigint not null primary key,
	year varchar(75),
	curvalue bigint
);

create table PML_IDTEMPLATE (
	templateId bigint not null primary key,
	format varchar(75),
	startNumber varchar(75),
	len bigint,
	description varchar(75)
);

create table PasswordPolicy (
	passwordPolicyId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	defaultPolicy smallint,
	name varchar(75),
	description long varchar,
	changeable smallint,
	changeRequired smallint,
	minAge bigint,
	checkSyntax smallint,
	allowDictionaryWords smallint,
	minLength integer,
	history smallint,
	historyCount integer,
	expireable smallint,
	maxAge bigint,
	warningTime bigint,
	graceLimit integer,
	lockout smallint,
	maxFailure integer,
	lockoutDuration bigint,
	requireUnlock smallint,
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
	createDate timestamp,
	password_ varchar(75)
);

create table Permission_ (
	permissionId bigint not null primary key,
	companyId bigint,
	actionId varchar(75),
	resourceId bigint
);

create table Phone (
	phoneId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	number_ varchar(75),
	extension varchar(75),
	typeId integer,
	primary_ smallint
);

create table PluginSetting (
	pluginSettingId bigint not null primary key,
	companyId bigint,
	pluginId varchar(75),
	pluginType varchar(75),
	roles long varchar,
	active_ smallint
);

create table PollsChoice (
	uuid_ varchar(75),
	choiceId bigint not null primary key,
	questionId bigint,
	name varchar(75),
	description varchar(1000)
);

create table PollsQuestion (
	uuid_ varchar(75),
	questionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	title varchar(500),
	description long varchar,
	expirationDate timestamp,
	lastVoteDate timestamp
);

create table PollsVote (
	voteId bigint not null primary key,
	userId bigint,
	questionId bigint,
	choiceId bigint,
	voteDate timestamp
);

create table Portlet (
	id_ bigint not null primary key,
	companyId bigint,
	portletId varchar(200),
	roles long varchar,
	active_ smallint
);

create table PortletItem (
	portletItemId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	portletId varchar(75),
	classNameId bigint
);

create table PortletPreferences (
	portletPreferencesId bigint not null primary key,
	ownerId bigint,
	ownerType integer,
	plid bigint,
	portletId varchar(200),
	preferences clob
);

create table RatingsEntry (
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
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
	regionCode varchar(75),
	name varchar(75),
	active_ smallint
);

create table Release_ (
	releaseId bigint not null primary key,
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
	resourceId bigint not null primary key,
	codeId bigint,
	primKey varchar(300)
);

create table ResourceCode (
	codeId bigint not null primary key,
	companyId bigint,
	name varchar(300),
	scope integer
);

create table Role_ (
	roleId bigint not null primary key,
	companyId bigint,
	classNameId bigint,
	classPK bigint,
	name varchar(75),
	description long varchar,
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
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	url long varchar,
	active_ smallint,
	priority integer
);

create table SCLicense (
	licenseId bigint not null primary key,
	name varchar(75),
	url long varchar,
	openSource smallint,
	active_ smallint,
	recommended smallint
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
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	type_ varchar(75),
	tags varchar(300),
	shortDescription long varchar,
	longDescription long varchar,
	pageURL long varchar,
	author varchar(75),
	repoGroupId varchar(75),
	repoArtifactId varchar(75)
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
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	productEntryId bigint,
	version varchar(75),
	changeLog long varchar,
	downloadPageURL long varchar,
	directDownloadURL varchar(2000),
	repoStoreArtifact smallint
);

create table ServiceComponent (
	serviceComponentId bigint not null primary key,
	buildNamespace varchar(75),
	buildNumber bigint,
	buildDate bigint,
	data_ clob
);

create table ShoppingCart (
	cartId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	itemIds long varchar,
	couponCodes varchar(75),
	altShipping integer,
	insure smallint
);

create table ShoppingCategory (
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	parentCategoryId bigint,
	name varchar(75),
	description long varchar
);

create table ShoppingCoupon (
	couponId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	code_ varchar(75),
	name varchar(75),
	description long varchar,
	startDate timestamp,
	endDate timestamp,
	active_ smallint,
	limitCategories long varchar,
	limitSkus long varchar,
	minOrder double,
	discount double,
	discountType varchar(75)
);

create table ShoppingItem (
	itemId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	categoryId bigint,
	sku varchar(75),
	name varchar(200),
	description long varchar,
	properties long varchar,
	fields_ smallint,
	fieldsQuantities long varchar,
	minQuantity integer,
	maxQuantity integer,
	price double,
	discount double,
	taxable smallint,
	shipping double,
	useShippingFormula smallint,
	requiresShipping smallint,
	stockQuantity integer,
	featured_ smallint,
	sale_ smallint,
	smallImage smallint,
	smallImageId bigint,
	smallImageURL varchar(75),
	mediumImage smallint,
	mediumImageId bigint,
	mediumImageURL varchar(75),
	largeImage smallint,
	largeImageId bigint,
	largeImageURL varchar(75)
);

create table ShoppingItemField (
	itemFieldId bigint not null primary key,
	itemId bigint,
	name varchar(75),
	values_ long varchar,
	description long varchar
);

create table ShoppingItemPrice (
	itemPriceId bigint not null primary key,
	itemId bigint,
	minQuantity integer,
	maxQuantity integer,
	price double,
	discount double,
	taxable smallint,
	shipping double,
	useShippingFormula smallint,
	status integer
);

create table ShoppingOrder (
	orderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	number_ varchar(75),
	tax double,
	shipping double,
	altShipping varchar(75),
	requiresShipping smallint,
	insure smallint,
	insurance double,
	couponCodes varchar(75),
	couponDiscount double,
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
	comments long varchar,
	ppTxnId varchar(75),
	ppPaymentStatus varchar(75),
	ppPaymentGross double,
	ppReceiverEmail varchar(75),
	ppPayerEmail varchar(75),
	sendOrderEmail smallint,
	sendShippingEmail smallint
);

create table ShoppingOrderItem (
	orderItemId bigint not null primary key,
	orderId bigint,
	itemId varchar(75),
	sku varchar(75),
	name varchar(200),
	description long varchar,
	properties long varchar,
	price double,
	quantity integer,
	shippedDate timestamp
);

create table SocialActivity (
	activityId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	mirrorActivityId bigint,
	classNameId bigint,
	classPK bigint,
	type_ integer,
	extraData long varchar,
	receiverUserId bigint
);

create table SocialRelation (
	uuid_ varchar(75),
	relationId bigint not null primary key,
	companyId bigint,
	createDate timestamp,
	userId1 bigint,
	userId2 bigint,
	type_ integer
);

create table SocialRequest (
	uuid_ varchar(75),
	requestId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	type_ integer,
	extraData long varchar,
	receiverUserId bigint,
	status integer
);

create table Subscription (
	subscriptionId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	frequency varchar(75)
);

create table TagsAsset (
	assetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	startDate timestamp,
	endDate timestamp,
	publishDate timestamp,
	expirationDate timestamp,
	mimeType varchar(75),
	title varchar(300),
	description long varchar,
	summary long varchar,
	url long varchar,
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
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75)
);

create table TagsProperty (
	propertyId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	entryId bigint,
	key_ varchar(75),
	value varchar(300)
);

create table TagsSource (
	sourceId bigint not null primary key,
	parentSourceId bigint,
	name varchar(75),
	acronym varchar(75)
);

create table TasksProposal (
	proposalId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK varchar(75),
	name varchar(75),
	description long varchar,
	publishDate timestamp,
	dueDate timestamp
);

create table TasksReview (
	reviewId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	proposalId bigint,
	assignedByUserId bigint,
	assignedByUserName varchar(75),
	stage integer,
	completed smallint,
	rejected smallint
);

create table User_ (
	uuid_ varchar(75),
	userId bigint not null primary key,
	companyId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	defaultUser smallint,
	contactId bigint,
	password_ varchar(75),
	passwordEncrypted smallint,
	passwordReset smallint,
	passwordModifiedDate timestamp,
	graceLoginCount integer,
	screenName varchar(75),
	emailAddress varchar(75),
	openId varchar(1024),
	portraitId bigint,
	languageId varchar(75),
	timeZoneId varchar(75),
	greeting varchar(75),
	comments long varchar,
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
	userGroupId bigint not null primary key,
	companyId bigint,
	parentUserGroupId bigint,
	name varchar(75),
	description long varchar
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
	type_ varchar(75),
	description varchar(75),
	externalUserId varchar(75)
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
	modifiedDate timestamp,
	sessionId varchar(200),
	remoteAddr varchar(75),
	remoteHost varchar(75),
	userAgent varchar(200)
);

create table UserTrackerPath (
	userTrackerPathId bigint not null primary key,
	userTrackerId bigint,
	path_ long varchar,
	pathDate timestamp
);

create table WebDAVProps (
	webDavPropsId bigint not null primary key,
	companyId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	props clob
);

create table Website (
	websiteId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	classNameId bigint,
	classPK bigint,
	url long varchar,
	typeId integer,
	primary_ smallint
);

create table WikiNode (
	uuid_ varchar(75),
	nodeId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	description long varchar,
	lastPostDate timestamp
);

create table WikiPage (
	uuid_ varchar(75),
	pageId bigint not null primary key,
	resourcePrimKey bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	nodeId bigint,
	title varchar(75),
	version double,
	minorEdit smallint,
	content clob,
	summary long varchar,
	format varchar(75),
	head smallint,
	parentTitle varchar(75),
	redirectTitle varchar(75)
);

create table WikiPageResource (
	resourcePrimKey bigint not null primary key,
	nodeId bigint,
	title varchar(75)
);

create table attact_file_document (
	attactFileDocumentId bigint not null primary key,
	attactFileDocumentTitle varchar(75),
	attactFileDocumentPath varchar(75),
	documentManagerId bigint,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table department (
	departmentId bigint not null primary key,
	departmentCode varchar(75),
	departmentName varchar(75),
	departmentDescription varchar(75),
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table document_manager (
	documentManagerId bigint not null primary key,
	documentManagerCode varchar(75),
	documentManagerCategory varchar(75),
	documentManagerStyle varchar(75),
	documentManagerDescription varchar(75),
	documentManagerDateCreate timestamp,
	documentManagerTitle varchar(75),
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table holiday_calendar (
	holidayCalendarId bigint not null primary key,
	holidayCalendarCode varchar(75),
	holidayCalendarDateCreate timestamp,
	holidayCalendarTitle varchar(75),
	holidayCalendarPath varchar(75),
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table pml_Receiver (
	receiverId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	receiverUserId bigint,
	receiverUserName varchar(75),
	viewName varchar(75),
	receiverType integer
);

create table pml_ReceiverGroup (
	receiverGroupId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	receiverGroupName varchar(75),
	description varchar(75),
	type_ integer,
	active_ smallint
);

create table pml_Reciever (
	recieverId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	recieverUserId bigint,
	recieverUserName varchar(75),
	viewName varchar(75),
	recieverType integer
);

create table pml_RecieverGroup (
	recieverGroupId bigint not null primary key,
	companyId bigint,
	userId bigint,
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
	userId bigint
);

create table pml_attachedfile (
	attachedfileid varchar(75) not null primary key,
	attachedfilecode varchar(75),
	attachedfilename varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_car_resource (
	carId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	carName varchar(255),
	carCode varchar(75),
	description long varchar
);

create table pml_career (
	careerid varchar(75) not null primary key,
	careercode varchar(75),
	careername varchar(75),
	description varchar(75),
	active varchar(75)
);

create table pml_chi_tiet_hscv (
	id_chi_tiet_hscv bigint not null primary key,
	id_ho_so_cong_viec bigint,
	id_cong_van_den bigint,
	id_cong_van_di bigint,
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
	pmlDepartmentHSCVId bigint not null primary key,
	departmentsId varchar(75),
	id_ho_so_cong_viec bigint,
	description varchar(75)
);

create table pml_delegate (
	delegateid bigint not null primary key,
	assigner bigint,
	receiver bigint,
	startdate timestamp,
	enddate timestamp,
	canceldate timestamp,
	canceldelegate varchar(75),
	datecreated timestamp
);

create table pml_departmentleader (
	departmentsId varchar(75) not null,
	userId bigint not null,
	clericalid bigint,
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
	roleid bigint,
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
	id_do_quan_trong bigint not null primary key,
	ten_do_quan_trong varchar(75)
);

create table pml_documentreceipt_issuingplace_log (
	documentReceiptIssuingPlaceLogId bigint not null primary key,
	documentReceiptId bigint,
	processor bigint,
	directProcessorId bigint,
	dateProcess timestamp,
	processInfomation varchar(75),
	receiver varchar(75),
	type_ integer,
	step integer
);

create table pml_documentreceipt_log (
	documentreceiptlogid bigint not null primary key,
	documentreceiptid bigint,
	transition_ integer,
	processer bigint,
	dateprocess timestamp,
	processinfomation varchar(75),
	receiver bigint,
	receivedate timestamp,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	type_ integer,
	expireddate timestamp,
	numdateprocess integer,
	processinstanceid bigint,
	maindepartmentprocessid varchar(75),
	mainuserprocessid bigint,
	senddatebefore timestamp,
	departmentreceiveid varchar(75),
	departmentprocessid varchar(75),
	dateProcessTime timestamp,
	receiveDateTime timestamp,
	directProcesserId bigint,
	step integer
);

create table pml_documentreceipt_wf (
	processid bigint not null primary key,
	documentreceiptid bigint,
	ismain varchar(75)
);

create table pml_documentsend_log (
	documentsendlogid bigint not null primary key,
	documentsendid bigint,
	transition_ integer,
	processer bigint,
	dateprocess timestamp,
	processinfomation varchar(75),
	receiver bigint,
	receivedate timestamp,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	expireddate timestamp,
	numdateprocess integer,
	processinstanceid bigint,
	type_ integer,
	senddatebefore timestamp,
	departmentreceiveid varchar(75),
	departmentprocessid varchar(75),
	dateprocesstime timestamp,
	receivedatetime timestamp,
	directProcesserId bigint,
	step integer
);

create table pml_documentsend_wf (
	documentsendid bigint not null primary key,
	processid bigint,
	isMain varchar(75)
);

create table pml_edm_answerdetail (
	documentreceiptid bigint not null primary key,
	documentsendid bigint
);

create table pml_edm_attachedfile (
	attachedfileid bigint not null primary key,
	objectcontentid bigint,
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
	documentreceiptid bigint not null,
	documentrecordtoid bigint not null,
	datecreate timestamp,
	datecomplete timestamp,
	soCongVanDenPhongHienTai integer,
	primary key (documentreceiptid, documentrecordtoid)
);

create table pml_edm_bookdocumentsend (
	bookdocumentsendid bigint not null primary key,
	datecreated timestamp,
	currentrecord bigint,
	departmentsid varchar(75),
	documentrecordtypeid integer,
	yearinuse varchar(75),
	active varchar(75),
	isagency varchar(75),
	agencyid varchar(75)
);

create table pml_edm_cadre (
	userid bigint not null primary key,
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
	dcuId bigint not null primary key,
	userId bigint,
	viewAllDoc smallint,
	viewDepDoc varchar(75)
);

create table pml_edm_documentdelegate (
	documentDelegateId bigint not null primary key,
	userDelegateId bigint,
	userIsDelegateId bigint,
	documentId integer,
	fromtDate timestamp,
	toDate timestamp,
	cancelDate timestamp
);

create table pml_edm_documentreceipt (
	documentReceiptId bigint not null primary key,
	levelsendid integer,
	documenttypeid bigint,
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
	statusid bigint,
	thoigiannhancvden varchar(75),
	socongvandiphucdap varchar(75),
	generalorderno bigint,
	maindepartmentprocessid varchar(75),
	mainuserprocessid bigint,
	orgexternalid bigint,
	docreceipttempid bigint,
	documentrecordtypeid integer,
	donvisaoy varchar(75)
);

create table pml_edm_documentreceipt_temp (
	documentReceiptId bigint not null primary key,
	levelsendid integer,
	documenttypeid bigint,
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
	statusid bigint,
	thoigiannhancvden varchar(75),
	socongvandiphucdap varchar(75),
	generalorderno bigint,
	maindepartmentprocessid varchar(75),
	mainuserprocessid bigint,
	orgexternalid bigint
);

create table pml_edm_documentreceiptextend (
	documentreceiptextendid bigint not null primary key,
	documentreceiptid bigint,
	documentreceiptlogid bigint,
	extendorderno integer,
	startprocessdate timestamp,
	numdayprocessbef integer,
	limitdatebef timestamp,
	extendreason varchar(75),
	numdayprocessaft integer,
	limitdateaft timestamp,
	leanonlimitdate smallint,
	extenduserid bigint,
	extenddepartmentid varchar(75)
);

create table pml_edm_documentreceiptprocesstype (
	docReceiptProcessTypeId bigint not null primary key,
	documentReceiptId bigint,
	documentReceiptLogId bigint,
	processTypeOrderNo integer,
	dateEdit timestamp,
	processTypeIdBefore varchar(75),
	processTypeIdAfter varchar(75),
	processTypeReason varchar(75),
	processerId bigint,
	departmentId varchar(75)
);

create table pml_edm_documentrecordto (
	documentrecordtoid bigint not null primary key,
	datecreate timestamp,
	currentrecord bigint,
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
	documentrelationid bigint not null primary key,
	docleftid bigint,
	docrightid bigint,
	leftisreceipt smallint,
	rightisreceipt smallint
);

create table pml_edm_documentsend (
	documentsendid bigint not null primary key,
	briefcontent varchar(75),
	documentreference varchar(75),
	receivingplace varchar(75),
	issuingdate timestamp,
	opinion varchar(75),
	editorid bigint,
	signerid bigint,
	documenttypeid bigint,
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
	statusid bigint,
	iscongvanphucdap smallint,
	numofdocref bigint,
	ispublish smallint,
	orgexternalid bigint,
	numofdirector smallint,
	documentrecordtypeid integer
);

create table pml_edm_documenttype (
	documenttypeid bigint not null primary key,
	documenttypename varchar(75),
	documentsymbol varchar(75),
	documentrecordtypeid integer,
	sendreceiptdistinction integer,
	HaveDepartExtends smallint
);

create table pml_edm_file_dinh_kem_vanbannoibo (
	fileDinhKemVanBanNoiBoId bigint not null primary key,
	tenFileFull varchar(75),
	tenFile varchar(75),
	duongDanFile varchar(75),
	tieuDe varchar(75),
	ngayTao timestamp,
	loaiFile varchar(75),
	mucDichFile varchar(75),
	vanBanNoiBoId bigint,
	userId bigint,
	groupId bigint,
	companyId bigint
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

create table pml_edm_loaivanbannoibo (
	loaiVanBanNoiBoId bigint not null primary key,
	kyHieuLoaiVanBanNoiBo varchar(75),
	tenLoaiVanBanNoiBo varchar(75),
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table pml_edm_log_vanbannoibo (
	logVanBanNoiBoId bigint not null primary key,
	buocLuanChuyen integer,
	nguoiXuLy bigint,
	ngayXuLy timestamp,
	nguoiNhan bigint,
	ngayNhan timestamp,
	trangThaiTruoc varchar(75),
	trangThaiSau varchar(75),
	ngayGui timestamp,
	phongXuLyChinh varchar(75),
	nguoiXuLyChinh bigint,
	loaiQuyTrinh integer,
	ngayHetHan timestamp,
	soNgayXuLy integer,
	processInstanceId bigint,
	thongTinXuLy varchar(75),
	step integer,
	nguoiXuLyTrucTiep bigint,
	phongXuLy varchar(75),
	phongNhan varchar(75),
	vanBanHoanThanhHayChua smallint,
	vanBanNoiBoId bigint,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table pml_edm_phong_loai_vanbannoibo (
	loaiVanBanNoiBoId bigint not null,
	phongVanBanNoiBoId varchar(75) not null,
	primary key (loaiVanBanNoiBoId, phongVanBanNoiBoId)
);

create table pml_edm_privilegelevel (
	privilegelevelid varchar(75) not null primary key,
	privilegelevelname varchar(75)
);

create table pml_edm_processdocumentreceiptdetail (
	id bigint not null primary key,
	documentreceiptid bigint,
	userid bigint,
	note varchar(75),
	datecreated timestamp,
	dateupdate timestamp
);

create table pml_edm_so_loai_vanbannoibo (
	soVanBanNoiBoId bigint not null,
	loaiVanBanNoiBoId bigint not null,
	primary key (soVanBanNoiBoId, loaiVanBanNoiBoId)
);

create table pml_edm_so_phong_vanbannoibo (
	soVanBanNoiBoId bigint not null,
	phongVanBanNoiBoId varchar(75) not null,
	primary key (soVanBanNoiBoId, phongVanBanNoiBoId)
);

create table pml_edm_sovanbannoibo (
	soVanBanNoiBoId bigint not null primary key,
	maSoVanBanNoiBo varchar(75),
	tenSoVanBanNoiBo varchar(75),
	ngayTao timestamp,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table pml_edm_vanbannoibo (
	vanBanNoiBoId bigint not null primary key,
	loaiVanBanNoiBo bigint,
	soVanBanNoiBo bigint,
	ngayTao timestamp,
	ngayKy timestamp,
	trichYeu varchar(75),
	nguoiKy bigint,
	ghiChu varchar(75),
	soVaoSoVanBanNoiBo varchar(75),
	soPhatSinhTheoNam integer,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table pml_edm_writedocumentsend (
	bookdocumentsendid bigint not null,
	documentsendid bigint not null,
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
	receiverId bigint,
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
	generalorderno bigint
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
	attachedfileid bigint not null primary key,
	filepcccid varchar(75),
	objecttype varchar(75),
	attachedfilename varchar(75),
	path varchar(75),
	datecreated timestamp,
	filetype varchar(75),
	title varchar(75)
);

create table pml_filereturninginfo (
	filereturninginfoid bigint not null primary key,
	fileid varchar(75),
	filesender varchar(75),
	licensenumber varchar(75),
	issuingdatelicense timestamp,
	receivelicensedate timestamp,
	documentnumber varchar(75),
	billnumber varchar(75),
	numbermoney bigint,
	note varchar(75),
	conclude varchar(75)
);

create table pml_filestatus (
	filestatusid bigint not null primary key,
	filestatuscode varchar(75),
	filestatusname varchar(75),
	description varchar(75),
	active varchar(75),
	type varchar(75)
);

create table pml_filestatus_stateprocess (
	id bigint not null primary key,
	filestatusid bigint,
	stateprocessid bigint,
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
	filetypedelegateid bigint not null primary key,
	filetypeid varchar(75),
	delegateid bigint
);

create table pml_ho_so_cong_viec (
	id_ho_so_cong_viec bigint not null primary key,
	userId bigint,
	userName varchar(75),
	id_hscv_cha bigint,
	so_hieu_hscv varchar(75),
	tieu_de varchar(75),
	ngay_mo_hscv timestamp,
	han_xu_ly timestamp,
	id_linh_vuc varchar(75),
	van_de_lien_quan varchar(75),
	id_do_quan_trong bigint,
	id_tinh_chat bigint,
	id_trang_thai_hscv bigint,
	tom_tat_noi_dung varchar(75),
	hoat_dong varchar(75)
);

create table pml_holiday (
	holidayid bigint not null primary key,
	holiday_type varchar(75),
	holiday_value varchar(75),
	from_date timestamp,
	to_date timestamp
);

create table pml_main_support (
	processid bigint not null primary key,
	processid_main bigint,
	type_ varchar(75),
	supportinfomation varchar(75)
);

create table pml_manage_documentworkflow (
	managedocumentworkflowid bigint not null primary key,
	workflowname varchar(75),
	version_ integer,
	type_ integer,
	description varchar(75),
	startdate timestamp,
	enddate timestamp
);

create table pml_message_note (
	messageId bigint not null primary key,
	documentId bigint,
	fromUserId bigint,
	toUserId bigint,
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
	orgexternalid bigint not null primary key,
	orgexternalcode varchar(75),
	orgexternalname varchar(75),
	isownerorg smallint
);

create table pml_paintdocument (
	paintdocumentid bigint not null primary key,
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
	processdisposeid bigint not null primary key,
	fileid varchar(75),
	transition_ integer,
	processer bigint,
	dateprocess timestamp,
	processinfomation varchar(75),
	receiver bigint,
	receivedate timestamp,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	expireddate timestamp,
	delegateuser bigint,
	senddate timestamp
);

create table pml_processtype (
	processtypeid bigint not null primary key,
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
	roomId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp,
	modifiedDate timestamp,
	roomName varchar(255),
	description long varchar
);

create table pml_saveprocesstype (
	sptid bigint not null primary key,
	docId bigint,
	flagprocesstype bigint,
	flag smallint
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
	workflow varchar(75),
	stateprocessid bigint,
	solvingtime integer,
	version_ integer
);

create table pml_stateprocess (
	stateprocessid bigint not null primary key,
	stateprocesscode varchar(75),
	stateprocessname varchar(75),
	filestatusid bigint,
	description varchar(75),
	active varchar(75)
);

create table pml_street (
	streetId varchar(75) not null primary key,
	streetName varchar(75)
);

create table pml_team (
	teamid bigint not null primary key,
	departmentid varchar(75),
	teamname varchar(75),
	description varchar(75),
	organizationid bigint,
	companyid bigint,
	specialteam varchar(75),
	teamcode varchar(75)
);

create table pml_teamleader (
	teamid bigint not null primary key,
	userid bigint
);

create table pml_template (
	templateId bigint not null primary key,
	templateCode varchar(75),
	templateName varchar(75),
	numberOfDocument integer,
	publishDate timestamp,
	departmentId varchar(75)
);

create table pml_template_file (
	fileTemplateId bigint not null primary key,
	templateId bigint,
	tenFile varchar(75),
	kichThuoc bigint,
	duongDan varchar(75)
);

create table pml_tinh_chat (
	id_tinh_chat bigint not null primary key,
	ten_tinh_chat varchar(75)
);

create table pml_trang_thai_hscv (
	id_trang_thai_hscv bigint not null primary key,
	ten_trang_thai_hscv varchar(75)
);

create table pml_transition (
	transitionid bigint not null primary key,
	transitionname varchar(75),
	filetypeid varchar(75),
	notransition integer,
	stateprocesscurrent bigint,
	stateprocessnext bigint,
	version_ varchar(75)
);

create table pml_user (
	userId bigint not null primary key,
	positionId varchar(75),
	departmentsId varchar(75),
	roleId varchar(75),
	handphone varchar(75),
	note varchar(75),
	teamid bigint,
	active smallint,
	screenname varchar(75),
	firstname varchar(75),
	middlename varchar(75),
	lastname varchar(75),
	male smallint,
	birthday timestamp,
	isleadermetting smallint,
	isvanthuphong smallint
);

create table pml_user_file_type (
	userid bigint not null,
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
	processId bigint,
	nodeId bigint
);

create table pml_workflow (
	workflowId bigint not null primary key,
	fileTypeId varchar(75),
	workflow varchar(75),
	version_ integer,
	startDate timestamp,
	endDate timestamp
);

create table report_registry_work (
	reportRegistryId bigint not null primary key,
	reportRegistryCode varchar(75),
	userCreate varchar(75),
	resultWork varchar(75),
	programWork varchar(75),
	reportDate timestamp,
	departmentId bigint,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table result_program_file (
	resultProgramId bigint not null primary key,
	resultProgramTitle varchar(75),
	resultProgramPath varchar(75),
	resultProgramCheck varchar(75),
	reportRegistryId bigint,
	userId bigint,
	groupId bigint,
	companyId bigint
);



insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (1, 'Canada', 'CA', 'CAN', '124', '001', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (2, 'China', 'CN', 'CHN', '156', '086', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (3, 'France', 'FR', 'FRA', '250', '033', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (4, 'Germany', 'DE', 'DEU', '276', '049', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (5, 'Hong Kong', 'HK', 'HKG', '344', '852', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (6, 'Hungary', 'HU', 'HUN', '348', '036', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (7, 'Israel', 'IL', 'ISR', '376', '972', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (8, 'Italy', 'IT', 'ITA', '380', '039', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (9, 'Japan', 'JP', 'JPN', '392', '081', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (10, 'South Korea', 'KR', 'KOR', '410', '082', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (11, 'Netherlands', 'NL', 'NLD', '528', '031', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (12, 'Portugal', 'PT', 'PRT', '620', '351', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (13, 'Russia', 'RU', 'RUS', '643', '007', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (14, 'Singapore', 'SG', 'SGP', '702', '065', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (15, 'Spain', 'ES', 'ESP', '724', '034', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (16, 'Turkey', 'TR', 'TUR', '792', '090', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (17, 'Vietnam', 'VM', 'VNM', '704', '084', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (18, 'United Kingdom', 'GB', 'GBR', '826', '044', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (19, 'United States', 'US', 'USA', '840', '001', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (20, 'Afghanistan', 'AF', 'AFG', '4', '093', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (21, 'Albania', 'AL', 'ALB', '8', '355', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (22, 'Algeria', 'DZ', 'DZA', '12', '213', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (23, 'American Samoa', 'AS', 'ASM', '16', '684', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (24, 'Andorra', 'AD', 'AND', '20', '376', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (25, 'Angola', 'AO', 'AGO', '24', '244', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (26, 'Anguilla', 'AI', 'AIA', '660', '264', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (27, 'Antarctica', 'AQ', 'ATA', '10', '672', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (28, 'Antigua', 'AG', 'ATG', '28', '268', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (29, 'Argentina', 'AR', 'ARG', '32', '054', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (30, 'Armenia', 'AM', 'ARM', '51', '374', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (31, 'Aruba', 'AW', 'ABW', '533', '297', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (32, 'Australia', 'AU', 'AUS', '36', '061', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (33, 'Austria', 'AT', 'AUT', '40', '043', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (34, 'Azerbaijan', 'AZ', 'AZE', '31', '994', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (35, 'Bahamas', 'BS', 'BHS', '44', '242', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (36, 'Bahrain', 'BH', 'BHR', '48', '973', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (37, 'Bangladesh', 'BD', 'BGD', '50', '880', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (38, 'Barbados', 'BB', 'BRB', '52', '246', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (39, 'Belarus', 'BY', 'BLR', '112', '375', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (40, 'Belgium', 'BE', 'BEL', '56', '032', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (41, 'Belize', 'BZ', 'BLZ', '84', '501', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (42, 'Benin', 'BJ', 'BEN', '204', '229', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (43, 'Bermuda', 'BM', 'BMU', '60', '441', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (44, 'Bhutan', 'BT', 'BTN', '64', '975', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (45, 'Bolivia', 'BO', 'BOL', '68', '591', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (46, 'Bosnia-Herzegovina', 'BA', 'BIH', '70', '387', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (47, 'Botswana', 'BW', 'BWA', '72', '267', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (48, 'Brazil', 'BR', 'BRA', '76', '055', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (49, 'British Virgin Islands', 'VG', 'VGB', '92', '284', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (50, 'Brunei', 'BN', 'BRN', '96', '673', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (51, 'Bulgaria', 'BG', 'BGR', '100', '359', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (52, 'Burkina Faso', 'BF', 'BFA', '854', '226', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (53, 'Burma (Myanmar)', 'MM', 'MMR', '104', '095', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (54, 'Burundi', 'BI', 'BDI', '108', '257', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (55, 'Cambodia', 'KH', 'KHM', '116', '855', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (56, 'Cameroon', 'CM', 'CMR', '120', '237', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (57, 'Cape Verde Island', 'CV', 'CPV', '132', '238', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (58, 'Cayman Islands', 'KY', 'CYM', '136', '345', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (59, 'Central African Republic', 'CF', 'CAF', '140', '236', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (60, 'Chad', 'TD', 'TCD', '148', '235', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (61, 'Chile', 'CL', 'CHL', '152', '056', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (62, 'Christmas Island', 'CX', 'CXR', '162', '061', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (63, 'Cocos Islands', 'CC', 'CCK', '166', '061', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (64, 'Colombia', 'CO', 'COL', '170', '057', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (65, 'Comoros', 'KM', 'COM', '174', '269', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (66, 'Republic of Congo', 'CD', 'COD', '180', '242', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (67, 'Democratic Republic of Congo', 'CG', 'COG', '178', '243', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (68, 'Cook Islands', 'CK', 'COK', '184', '682', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (69, 'Costa Rica', 'CR', 'CRI', '188', '506', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (70, 'Croatia', 'HR', 'HRV', '191', '385', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (71, 'Cuba', 'CU', 'CUB', '192', '053', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (72, 'Cyprus', 'CY', 'CYP', '196', '357', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (73, 'Czech Republic', 'CZ', 'CZE', '203', '420', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (74, 'Denmark', 'DK', 'DNK', '208', '045', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (75, 'Djibouti', 'DJ', 'DJI', '262', '253', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (76, 'Dominica', 'DM', 'DMA', '212', '767', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (77, 'Dominican Republic', 'DO', 'DOM', '214', '809', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (78, 'Ecuador', 'EC', 'ECU', '218', '593', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (79, 'Egypt', 'EG', 'EGY', '818', '020', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (80, 'El Salvador', 'SV', 'SLV', '222', '503', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (81, 'Equatorial Guinea', 'GQ', 'GNQ', '226', '240', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (82, 'Eritrea', 'ER', 'ERI', '232', '291', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (83, 'Estonia', 'EE', 'EST', '233', '372', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (84, 'Ethiopia', 'ET', 'ETH', '231', '251', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (85, 'Faeroe Islands', 'FO', 'FRO', '234', '298', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (86, 'Falkland Islands', 'FK', 'FLK', '238', '500', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (87, 'Fiji Islands', 'FJ', 'FJI', '242', '679', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (88, 'Finland', 'FI', 'FIN', '246', '358', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (89, 'French Guiana', 'GF', 'GUF', '254', '594', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (90, 'French Polynesia', 'PF', 'PYF', '258', '689', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (91, 'Gabon', 'GA', 'GAB', '266', '241', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (92, 'Gambia', 'GM', 'GMB', '270', '220', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (93, 'Georgia', 'GE', 'GEO', '268', '995', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (94, 'Ghana', 'GH', 'GHA', '288', '233', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (95, 'Gibraltar', 'GI', 'GIB', '292', '350', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (96, 'Greece', 'GR', 'GRC', '300', '030', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (97, 'Greenland', 'GL', 'GRL', '304', '299', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (98, 'Grenada', 'GD', 'GRD', '308', '473', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (99, 'Guadeloupe', 'GP', 'GLP', '312', '590', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (100, 'Guam', 'GU', 'GUM', '316', '671', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (101, 'Guatemala', 'GT', 'GTM', '320', '502', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (102, 'Guinea', 'GN', 'GIN', '324', '224', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (103, 'Guinea-Bissau', 'GW', 'GNB', '624', '245', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (104, 'Guyana', 'GY', 'GUY', '328', '592', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (105, 'Haiti', 'HT', 'HTI', '332', '509', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (106, 'Honduras', 'HN', 'HND', '340', '504', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (107, 'Iceland', 'IS', 'ISL', '352', '354', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (108, 'India', 'IN', 'IND', '356', '091', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (109, 'Indonesia', 'ID', 'IDN', '360', '062', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (110, 'Iran', 'IR', 'IRN', '364', '098', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (111, 'Iraq', 'IQ', 'IRQ', '368', '964', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (112, 'Ireland', 'IE', 'IRL', '372', '353', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (113, 'Ivory Coast', 'CI', 'CIV', '384', '225', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (114, 'Jamaica', 'JM', 'JAM', '388', '876', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (115, 'Jordan', 'JO', 'JOR', '400', '962', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (116, 'Kazakhstan', 'KZ', 'KAZ', '398', '007', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (117, 'Kenya', 'KE', 'KEN', '404', '254', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (118, 'Kiribati', 'KI', 'KIR', '408', '686', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (119, 'Kuwait', 'KW', 'KWT', '414', '965', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (120, 'North Korea', 'KP', 'PRK', '408', '850', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (121, 'Kyrgyzstan', 'KG', 'KGZ', '471', '996', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (122, 'Laos', 'LA', 'LAO', '418', '856', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (123, 'Latvia', 'LV', 'LVA', '428', '371', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (124, 'Lebanon', 'LB', 'LBN', '422', '961', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (125, 'Lesotho', 'LS', 'LSO', '426', '266', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (126, 'Liberia', 'LR', 'LBR', '430', '231', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (127, 'Libya', 'LY', 'LBY', '434', '218', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (128, 'Liechtenstein', 'LI', 'LIE', '438', '423', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (129, 'Lithuania', 'LT', 'LTU', '440', '370', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (130, 'Luxembourg', 'LU', 'LUX', '442', '352', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (131, 'Macau', 'MO', 'MAC', '446', '853', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (132, 'Macedonia', 'MK', 'MKD', '807', '389', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (133, 'Madagascar', 'MG', 'MDG', '450', '261', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (134, 'Malawi', 'MW', 'MWI', '454', '265', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (135, 'Malaysia', 'MY', 'MYS', '458', '060', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (136, 'Maldives', 'MV', 'MDV', '462', '960', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (137, 'Mali', 'ML', 'MLI', '466', '223', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (138, 'Malta', 'MT', 'MLT', '470', '356', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (139, 'Marshall Islands', 'MH', 'MHL', '584', '692', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (140, 'Martinique', 'MQ', 'MTQ', '474', '596', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (141, 'Mauritania', 'MR', 'MRT', '478', '222', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (142, 'Mauritius', 'MU', 'MUS', '480', '230', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (143, 'Mayotte Island', 'YT', 'MYT', '175', '269', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (144, 'Mexico', 'MX', 'MEX', '484', '052', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (145, 'Micronesia', 'FM', 'FSM', '583', '691', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (146, 'Moldova', 'MD', 'MDA', '498', '373', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (147, 'Monaco', 'MC', 'MCO', '492', '377', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (148, 'Mongolia', 'MN', 'MNG', '496', '976', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (149, 'Montenegro', 'ME', 'MNE', '499', '382', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (150, 'Montserrat', 'MS', 'MSR', '500', '664', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (151, 'Morocco', 'MA', 'MAR', '504', '212', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (152, 'Mozambique', 'MZ', 'MOZ', '508', '258', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (153, 'Namibia', 'NA', 'NAM', '516', '264', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (154, 'Nauru', 'NR', 'NRU', '520', '674', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (155, 'Nepal', 'NP', 'NPL', '524', '977', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (156, 'Netherlands Antilles', 'AN', 'ANT', '530', '599', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (157, 'New Caledonia', 'NC', 'NCL', '540', '687', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (158, 'New Zealand', 'NZ', 'NZL', '554', '064', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (159, 'Nicaragua', 'NI', 'NIC', '558', '505', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (160, 'Niger', 'NE', 'NER', '562', '227', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (161, 'Nigeria', 'NG', 'NGA', '566', '234', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (162, 'Niue', 'NU', 'NIU', '570', '683', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (163, 'Norfolk Island', 'NF', 'NFK', '574', '672', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (164, 'Norway', 'NO', 'NOR', '578', '047', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (165, 'Oman', 'OM', 'OMN', '512', '968', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (166, 'Pakistan', 'PK', 'PAK', '586', '092', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (167, 'Palau', 'PW', 'PLW', '585', '680', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (168, 'Palestine', 'PS', 'PSE', '275', '970', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (169, 'Panama', 'PA', 'PAN', '591', '507', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (170, 'Papua New Guinea', 'PG', 'PNG', '598', '675', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (171, 'Paraguay', 'PY', 'PRY', '600', '595', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (172, 'Peru', 'PE', 'PER', '604', '051', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (173, 'Philippines', 'PH', 'PHL', '608', '063', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (174, 'Poland', 'PL', 'POL', '616', '048', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (175, 'Puerto Rico', 'PR', 'PRI', '630', '787', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (176, 'Qatar', 'QA', 'QAT', '634', '974', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (177, 'Reunion Island', 'RE', 'REU', '638', '262', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (178, 'Romania', 'RO', 'ROU', '642', '040', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (179, 'Rwanda', 'RW', 'RWA', '646', '250', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (180, 'St. Helena', 'SH', 'SHN', '654', '290', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (181, 'St. Kitts', 'KN', 'KNA', '659', '869', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (182, 'St. Lucia', 'LC', 'LCA', '662', '758', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (183, 'St. Pierre & Miquelon', 'PM', 'SPM', '666', '508', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (184, 'St. Vincent', 'VC', 'VCT', '670', '784', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (185, 'San Marino', 'SM', 'SMR', '674', '378', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (186, 'Sao Tome & Principe', 'ST', 'STP', '678', '239', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (187, 'Saudi Arabia', 'SA', 'SAU', '682', '966', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (188, 'Senegal', 'SN', 'SEN', '686', '221', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (189, 'Serbia', 'RS', 'SRB', '688', '381', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (190, 'Seychelles', 'SC', 'SYC', '690', '248', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (191, 'Sierra Leone', 'SL', 'SLE', '694', '249', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (192, 'Slovakia', 'SK', 'SVK', '703', '421', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (193, 'Slovenia', 'SI', 'SVN', '705', '386', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (194, 'Solomon Islands', 'SB', 'SLB', '90', '677', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (195, 'Somalia', 'SO', 'SOM', '706', '252', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (196, 'South Africa', 'ZA', 'ZAF', '710', '027', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (197, 'Sri Lanka', 'LK', 'LKA', '144', '094', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (198, 'Sudan', 'SD', 'SDN', '736', '095', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (199, 'Suriname', 'SR', 'SUR', '740', '597', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (200, 'Swaziland', 'SZ', 'SWZ', '748', '268', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (201, 'Sweden', 'SE', 'SWE', '752', '046', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (202, 'Switzerland', 'CH', 'CHE', '756', '041', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (203, 'Syria', 'SY', 'SYR', '760', '963', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (204, 'Taiwan', 'TW', 'TWN', '158', '886', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (205, 'Tajikistan', 'TJ', 'TJK', '762', '992', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (206, 'Tanzania', 'TZ', 'TZA', '834', '255', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (207, 'Thailand', 'TH', 'THA', '764', '066', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (208, 'Togo', 'TG', 'TGO', '768', '228', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (209, 'Tonga', 'TO', 'TON', '776', '676', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (210, 'Trinidad & Tobago', 'TT', 'TTO', '780', '868', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (211, 'Tunisia', 'TN', 'TUN', '788', '216', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (212, 'Turkmenistan', 'TM', 'TKM', '795', '993', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (213, 'Turks & Caicos', 'TC', 'TCA', '796', '649', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (214, 'Tuvalu', 'TV', 'TUV', '798', '688', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (215, 'Uganda', 'UG', 'UGA', '800', '256', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (216, 'Ukraine', 'UA', 'UKR', '804', '380', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (217, 'United Arab Emirates', 'AE', 'ARE', '784', '971', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (218, 'Uruguay', 'UY', 'URY', '858', '598', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (219, 'Uzbekistan', 'UZ', 'UZB', '860', '998', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (220, 'Vanuatu', 'VU', 'VUT', '548', '678', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (221, 'Vatican City', 'VA', 'VAT', '336', '039', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (222, 'Venezuela', 'VE', 'VEN', '862', '058', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (223, 'Wallis & Futuna', 'WF', 'WLF', '876', '681', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (224, 'Western Samoa', 'EH', 'ESH', '732', '685', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (225, 'Yemen', 'YE', 'YEM', '887', '967', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (226, 'Zambia', 'ZM', 'ZMB', '894', '260', 1);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (227, 'Zimbabwe', 'ZW', 'ZWE', '716', '263', 1);

insert into Region (regionId, countryId, regionCode, name, active_) values (1, 19, 'AL', 'Alabama', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (2, 19, 'AK', 'Alaska', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (3, 19, 'AZ', 'Arizona', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (4, 19, 'AR', 'Arkansas', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (5, 19, 'CA', 'California', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (6, 19, 'CO', 'Colorado', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (7, 19, 'CT', 'Connecticut', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (8, 19, 'DC', 'District of Columbia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (9, 19, 'DE', 'Delaware', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (10, 19, 'FL', 'Florida', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (11, 19, 'GA', 'Georgia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (12, 19, 'HI', 'Hawaii', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (13, 19, 'ID', 'Idaho', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (14, 19, 'IL', 'Illinois', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (15, 19, 'IN', 'Indiana', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (16, 19, 'IA', 'Iowa', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (17, 19, 'KS', 'Kansas', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (18, 19, 'KY', 'Kentucky ', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (19, 19, 'LA', 'Louisiana ', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (20, 19, 'ME', 'Maine', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (21, 19, 'MD', 'Maryland', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (22, 19, 'MA', 'Massachusetts', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (23, 19, 'MI', 'Michigan', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (24, 19, 'MN', 'Minnesota', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (25, 19, 'MS', 'Mississippi', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (26, 19, 'MO', 'Missouri', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (27, 19, 'MT', 'Montana', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (28, 19, 'NE', 'Nebraska', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (29, 19, 'NV', 'Nevada', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (30, 19, 'NH', 'New Hampshire', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (31, 19, 'NJ', 'New Jersey', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (32, 19, 'NM', 'New Mexico', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (33, 19, 'NY', 'New York', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (34, 19, 'NC', 'North Carolina', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (35, 19, 'ND', 'North Dakota', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (36, 19, 'OH', 'Ohio', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (37, 19, 'OK', 'Oklahoma ', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (38, 19, 'OR', 'Oregon', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (39, 19, 'PA', 'Pennsylvania', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (40, 19, 'PR', 'Puerto Rico', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (41, 19, 'RI', 'Rhode Island', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (42, 19, 'SC', 'South Carolina', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (43, 19, 'SD', 'South Dakota', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (44, 19, 'TN', 'Tennessee', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (45, 19, 'TX', 'Texas', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (46, 19, 'UT', 'Utah', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (47, 19, 'VT', 'Vermont', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (48, 19, 'VA', 'Virginia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (49, 19, 'WA', 'Washington', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (50, 19, 'WV', 'West Virginia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (51, 19, 'WI', 'Wisconsin', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (52, 19, 'WY', 'Wyoming', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (53, 1, 'AL', 'Alberta', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (54, 1, 'BC', 'British Columbia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (55, 1, 'MB', 'Manitoba', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (56, 1, 'NB', 'New Brunswick', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (57, 1, 'NL', 'Newfoundland and Labrador', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (58, 1, 'NT', 'Northwest Territories', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (59, 1, 'NS', 'Nova Scotia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (60, 1, 'NU', 'Nunavut', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (61, 1, 'ON', 'Ontario', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (62, 1, 'PE', 'Prince Edward Island', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (63, 1, 'QC', 'Quebec', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (64, 1, 'SK', 'Saskatchewan', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (65, 1, 'YT', 'Yukon', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (66, 15, 'AN', 'Andalusia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (67, 15, 'AR', 'Aragon', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (68, 15, 'AS', 'Asturias', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (69, 15, 'IB', 'Balearic Islands', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (70, 15, 'PV', 'Basque Country', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (71, 15, 'CN', 'Canary Islands', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (72, 15, 'CB', 'Cantabria', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (73, 15, 'CL', 'Castile and Leon', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (74, 15, 'CM', 'Castile-La Mancha', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (75, 15, 'CT', 'Catalonia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (76, 15, 'CE', 'Ceuta', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (77, 15, 'EX', 'Extremadura', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (78, 15, 'GA', 'Galicia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (79, 15, 'LO', 'La Rioja', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (80, 15, 'M', 'Madrid', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (81, 15, 'ML', 'Melilla', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (82, 15, 'MU', 'Murcia', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (83, 15, 'NA', 'Navarra', 1);
insert into Region (regionId, countryId, regionCode, name, active_) values (84, 15, 'VC', 'Valencia', 1);

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


insert into Release_ (releaseId, createDate, modifiedDate, buildNumber, verified) values (1, current timestamp, current timestamp, 5102, 0);


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
	NEXT_FIRE_TIME bigint,
	PREV_FIRE_TIME bigint,
	PRIORITY integer,
	TRIGGER_STATE varchar(16) not null,
	TRIGGER_TYPE varchar(8) not null,
	START_TIME bigint not null,
	END_TIME bigint,
	CALENDAR_NAME varchar(80),
	MISFIRE_INSTR integer,
	JOB_DATA blob,
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
	FIRED_TIME bigint not null,
	PRIORITY integer not null,
	STATE varchar(16) not null,
	JOB_NAME varchar(80),
	JOB_GROUP varchar(80),
	IS_STATEFUL smallint,
	REQUESTS_RECOVERY smallint
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
