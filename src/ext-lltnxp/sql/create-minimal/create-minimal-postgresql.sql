drop database lportal;
create database lportal encoding = 'UNICODE';
\c lportal;

create table Account_ (
	accountId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
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
	mailing bool,
	primary_ bool
);

create table AnnouncementsDelivery (
	deliveryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	type_ varchar(75) null,
	email bool,
	sms bool,
	website bool
);

create table AnnouncementsEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	title varchar(75) null,
	content text null,
	url text null,
	type_ varchar(75) null,
	displayDate timestamp null,
	expirationDate timestamp null,
	priority integer,
	alert bool
);

create table AnnouncementsFlag (
	flagId bigint not null primary key,
	userId bigint,
	createDate timestamp null,
	entryId bigint,
	value integer
);

create table BlogsCategory (
	categoryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentCategoryId bigint,
	name varchar(75) null,
	description text null
);

create table BlogsEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title varchar(150) null,
	urlTitle varchar(150) null,
	content text null,
	displayDate timestamp null,
	draft bool,
	allowTrackbacks bool,
	trackbacks text null
);

create table BlogsStatsUser (
	statsUserId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	entryCount integer,
	lastPostDate timestamp null,
	ratingsTotalEntries integer,
	ratingsTotalScore double precision,
	ratingsAverageScore double precision
);

create table BookmarksEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	modifiedDate timestamp null,
	folderId bigint,
	name varchar(300) null,
	url text null,
	comments text null,
	visits integer,
	priority integer
);

create table BookmarksFolder (
	uuid_ varchar(75) null,
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentFolderId bigint,
	name varchar(75) null,
	description text null
);

create table CalEvent (
	uuid_ varchar(75) null,
	eventId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title varchar(75) null,
	description text null,
	startDate timestamp null,
	endDate timestamp null,
	durationHour integer,
	durationMinute integer,
	allDay bool,
	timeZoneSensitive bool,
	type_ varchar(75) null,
	repeating bool,
	recurrence text null,
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
	key_ text null,
	virtualHost varchar(75) null,
	mx varchar(75) null,
	logoId bigint
);

create table CongViec (
	macv varchar(75) not null primary key,
	tencv varchar(75) null,
	linhvucid varchar(75) null,
	nguoitao bigint,
	ngaytao timestamp null,
	ngayhethan timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	accountId bigint,
	parentContactId bigint,
	firstName varchar(75) null,
	middleName varchar(75) null,
	lastName varchar(75) null,
	prefixId integer,
	suffixId integer,
	male bool,
	birthday timestamp null,
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
	active_ bool
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
	createDate timestamp null,
	modifiedDate timestamp null,
	folderId bigint,
	name varchar(300) null,
	title varchar(300) null,
	description text null,
	version double precision,
	size_ integer,
	readCount integer,
	extraSettings text null
);

create table DLFileRank (
	fileRankId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	folderId bigint,
	name varchar(300) null
);

create table DLFileShortcut (
	uuid_ varchar(75) null,
	fileShortcutId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	folderId bigint,
	toFolderId bigint,
	toName varchar(300) null
);

create table DLFileVersion (
	fileVersionId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	folderId bigint,
	name varchar(300) null,
	version double precision,
	size_ integer
);

create table DLFolder (
	uuid_ varchar(75) null,
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentFolderId bigint,
	name varchar(100) null,
	description text null,
	lastPostDate timestamp null
);

create table EmailAddress (
	emailAddressId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	address varchar(75) null,
	typeId integer,
	primary_ bool
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
	data_ text null
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
	description text null,
	type_ integer,
	typeSettings text null,
	friendlyURL varchar(100) null,
	active_ bool
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
	createDate timestamp null,
	modifiedDate timestamp null,
	parentFolderId bigint,
	name varchar(75) null,
	description text null
);

create table IGImage (
	uuid_ varchar(75) null,
	imageId bigint not null primary key,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	modifiedDate timestamp null,
	folderId bigint,
	name varchar(75) null,
	description text null,
	smallImageId bigint,
	largeImageId bigint,
	custom1ImageId bigint,
	custom2ImageId bigint
);

create table Image (
	imageId bigint not null primary key,
	modifiedDate timestamp null,
	text_ text null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	articleId varchar(75) null,
	version double precision,
	title varchar(100) null,
	description text null,
	content text null,
	type_ varchar(75) null,
	structureId varchar(75) null,
	templateId varchar(75) null,
	displayDate timestamp null,
	approved bool,
	approvedByUserId bigint,
	approvedByUserName varchar(75) null,
	approvedDate timestamp null,
	expired bool,
	expirationDate timestamp null,
	reviewDate timestamp null,
	indexable bool,
	smallImage bool,
	smallImageId bigint,
	smallImageURL varchar(75) null
);

create table JournalArticleImage (
	articleImageId bigint not null primary key,
	groupId bigint,
	articleId varchar(75) null,
	version double precision,
	elName varchar(75) null,
	languageId varchar(75) null,
	tempImage bool
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
	privateLayout bool,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	feedId varchar(75) null,
	name varchar(75) null,
	description text null,
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
	feedVersion double precision
);

create table JournalStructure (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	structureId varchar(75) null,
	name varchar(75) null,
	description text null,
	xsd text null
);

create table JournalTemplate (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	templateId varchar(75) null,
	structureId varchar(75) null,
	name varchar(75) null,
	description text null,
	xsl text null,
	langType varchar(75) null,
	cacheable bool,
	smallImage bool,
	smallImageId bigint,
	smallImageURL varchar(75) null
);

create table Layout (
	plid bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout bool,
	layoutId bigint,
	parentLayoutId bigint,
	name text null,
	title text null,
	description text null,
	type_ varchar(75) null,
	typeSettings text null,
	hidden_ bool,
	friendlyURL varchar(100) null,
	iconImage bool,
	iconImageId bigint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css text null,
	priority integer,
	dlFolderId bigint
);

create table LayoutSet (
	layoutSetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout bool,
	logo bool,
	logoId bigint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css text null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	banUserId bigint
);

create table MBCategory (
	uuid_ varchar(75) null,
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentCategoryId bigint,
	name varchar(75) null,
	description text null,
	lastPostDate timestamp null
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
	createDate timestamp null,
	modifiedDate timestamp null,
	categoryId bigint,
	threadId bigint,
	parentMessageId bigint,
	subject varchar(75) null,
	body text null,
	attachments bool,
	anonymous bool
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
	lastPostDate timestamp null
);

create table MBThread (
	threadId bigint not null primary key,
	categoryId bigint,
	rootMessageId bigint,
	messageCount integer,
	viewCount integer,
	lastPostByUserId bigint,
	lastPostDate timestamp null,
	priority double precision
);

create table MeetingCalComponent (
	mcalId bigint not null primary key,
	groupIds varchar(75) null,
	startDate timestamp null
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
	dateApproved timestamp null,
	moveMcalId bigint,
	repeatWeek bool,
	filename varchar(75) null,
	morning bool,
	afternoon bool,
	evening bool,
	stt integer,
	prior bool
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
	createDate timestamp null,
	groupId bigint,
	comments text null,
	replyComments text null,
	replyDate timestamp null,
	replierUserId bigint,
	statusId integer
);

create table Organization_ (
	organizationId bigint not null primary key,
	companyId bigint,
	parentOrganizationId bigint,
	name varchar(100) null,
	location bool,
	recursable bool,
	regionId bigint,
	countryId bigint,
	statusId integer,
	comments text null
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
	createDate timestamp null,
	modifiedDate timestamp null,
	defaultPolicy bool,
	name varchar(75) null,
	description text null,
	changeable bool,
	changeRequired bool,
	minAge bigint,
	checkSyntax bool,
	allowDictionaryWords bool,
	minLength integer,
	history bool,
	historyCount integer,
	expireable bool,
	maxAge bigint,
	warningTime bigint,
	graceLimit integer,
	lockout bool,
	maxFailure integer,
	lockoutDuration bigint,
	requireUnlock bool,
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
	createDate timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	number_ varchar(75) null,
	extension varchar(75) null,
	typeId integer,
	primary_ bool
);

create table PluginSetting (
	pluginSettingId bigint not null primary key,
	companyId bigint,
	pluginId varchar(75) null,
	pluginType varchar(75) null,
	roles text null,
	active_ bool
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
	createDate timestamp null,
	modifiedDate timestamp null,
	title varchar(500) null,
	description text null,
	expirationDate timestamp null,
	lastVoteDate timestamp null
);

create table PollsVote (
	voteId bigint not null primary key,
	userId bigint,
	questionId bigint,
	choiceId bigint,
	voteDate timestamp null
);

create table Portlet (
	id_ bigint not null primary key,
	companyId bigint,
	portletId varchar(200) null,
	roles text null,
	active_ bool
);

create table PortletItem (
	portletItemId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
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
	preferences text null
);

create table RatingsEntry (
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	score double precision
);

create table RatingsStats (
	statsId bigint not null primary key,
	classNameId bigint,
	classPK bigint,
	totalEntries integer,
	totalScore double precision,
	averageScore double precision
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
	active_ bool
);

create table Release_ (
	releaseId bigint not null primary key,
	createDate timestamp null,
	modifiedDate timestamp null,
	buildNumber integer,
	buildDate timestamp null,
	verified bool
);

create table ReportsEntry (
	entryId varchar(75) not null primary key,
	companyId varchar(75) null,
	userId varchar(75) null,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
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
	description text null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	url text null,
	active_ bool,
	priority integer
);

create table SCLicense (
	licenseId bigint not null primary key,
	name varchar(75) null,
	url text null,
	openSource bool,
	active_ bool,
	recommended bool
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
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	type_ varchar(75) null,
	tags varchar(300) null,
	shortDescription text null,
	longDescription text null,
	pageURL text null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	productEntryId bigint,
	version varchar(75) null,
	changeLog text null,
	downloadPageURL text null,
	directDownloadURL varchar(2000) null,
	repoStoreArtifact bool
);

create table ServiceComponent (
	serviceComponentId bigint not null primary key,
	buildNamespace varchar(75) null,
	buildNumber bigint,
	buildDate bigint,
	data_ text null
);

create table ShoppingCart (
	cartId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	itemIds text null,
	couponCodes varchar(75) null,
	altShipping integer,
	insure bool
);

create table ShoppingCategory (
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentCategoryId bigint,
	name varchar(75) null,
	description text null
);

create table ShoppingCoupon (
	couponId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	code_ varchar(75) null,
	name varchar(75) null,
	description text null,
	startDate timestamp null,
	endDate timestamp null,
	active_ bool,
	limitCategories text null,
	limitSkus text null,
	minOrder double precision,
	discount double precision,
	discountType varchar(75) null
);

create table ShoppingItem (
	itemId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	categoryId bigint,
	sku varchar(75) null,
	name varchar(200) null,
	description text null,
	properties text null,
	fields_ bool,
	fieldsQuantities text null,
	minQuantity integer,
	maxQuantity integer,
	price double precision,
	discount double precision,
	taxable bool,
	shipping double precision,
	useShippingFormula bool,
	requiresShipping bool,
	stockQuantity integer,
	featured_ bool,
	sale_ bool,
	smallImage bool,
	smallImageId bigint,
	smallImageURL varchar(75) null,
	mediumImage bool,
	mediumImageId bigint,
	mediumImageURL varchar(75) null,
	largeImage bool,
	largeImageId bigint,
	largeImageURL varchar(75) null
);

create table ShoppingItemField (
	itemFieldId bigint not null primary key,
	itemId bigint,
	name varchar(75) null,
	values_ text null,
	description text null
);

create table ShoppingItemPrice (
	itemPriceId bigint not null primary key,
	itemId bigint,
	minQuantity integer,
	maxQuantity integer,
	price double precision,
	discount double precision,
	taxable bool,
	shipping double precision,
	useShippingFormula bool,
	status integer
);

create table ShoppingOrder (
	orderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	number_ varchar(75) null,
	tax double precision,
	shipping double precision,
	altShipping varchar(75) null,
	requiresShipping bool,
	insure bool,
	insurance double precision,
	couponCodes varchar(75) null,
	couponDiscount double precision,
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
	shipToBilling bool,
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
	comments text null,
	ppTxnId varchar(75) null,
	ppPaymentStatus varchar(75) null,
	ppPaymentGross double precision,
	ppReceiverEmail varchar(75) null,
	ppPayerEmail varchar(75) null,
	sendOrderEmail bool,
	sendShippingEmail bool
);

create table ShoppingOrderItem (
	orderItemId bigint not null primary key,
	orderId bigint,
	itemId varchar(75) null,
	sku varchar(75) null,
	name varchar(200) null,
	description text null,
	properties text null,
	price double precision,
	quantity integer,
	shippedDate timestamp null
);

create table SocialActivity (
	activityId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	mirrorActivityId bigint,
	classNameId bigint,
	classPK bigint,
	type_ integer,
	extraData text null,
	receiverUserId bigint
);

create table SocialRelation (
	uuid_ varchar(75) null,
	relationId bigint not null primary key,
	companyId bigint,
	createDate timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	type_ integer,
	extraData text null,
	receiverUserId bigint,
	status integer
);

create table Subscription (
	subscriptionId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	startDate timestamp null,
	endDate timestamp null,
	publishDate timestamp null,
	expirationDate timestamp null,
	mimeType varchar(75) null,
	title varchar(300) null,
	description text null,
	summary text null,
	url text null,
	height integer,
	width integer,
	priority double precision,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null
);

create table TagsProperty (
	propertyId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK varchar(75) null,
	name varchar(75) null,
	description text null,
	publishDate timestamp null,
	dueDate timestamp null
);

create table TasksReview (
	reviewId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	proposalId bigint,
	assignedByUserId bigint,
	assignedByUserName varchar(75) null,
	stage integer,
	completed bool,
	rejected bool
);

create table User_ (
	uuid_ varchar(75) null,
	userId bigint not null primary key,
	companyId bigint,
	createDate timestamp null,
	modifiedDate timestamp null,
	defaultUser bool,
	contactId bigint,
	password_ varchar(75) null,
	passwordEncrypted bool,
	passwordReset bool,
	passwordModifiedDate timestamp null,
	graceLoginCount integer,
	screenName varchar(75) null,
	emailAddress varchar(75) null,
	openId varchar(1024) null,
	portraitId bigint,
	languageId varchar(75) null,
	timeZoneId varchar(75) null,
	greeting varchar(75) null,
	comments text null,
	loginDate timestamp null,
	loginIP varchar(75) null,
	lastLoginDate timestamp null,
	lastLoginIP varchar(75) null,
	lastFailedLoginDate timestamp null,
	failedLoginAttempts integer,
	lockout bool,
	lockoutDate timestamp null,
	agreedToTermsOfUse bool,
	active_ bool
);

create table UserGroup (
	userGroupId bigint not null primary key,
	companyId bigint,
	parentUserGroupId bigint,
	name varchar(75) null,
	description text null
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
	modifiedDate timestamp null,
	sessionId varchar(200) null,
	remoteAddr varchar(75) null,
	remoteHost varchar(75) null,
	userAgent varchar(200) null
);

create table UserTrackerPath (
	userTrackerPathId bigint not null primary key,
	userTrackerId bigint,
	path_ text null,
	pathDate timestamp null
);

create table WebDAVProps (
	webDavPropsId bigint not null primary key,
	companyId bigint,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	props text null
);

create table Website (
	websiteId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	url text null,
	typeId integer,
	primary_ bool
);

create table WikiNode (
	uuid_ varchar(75) null,
	nodeId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	description text null,
	lastPostDate timestamp null
);

create table WikiPage (
	uuid_ varchar(75) null,
	pageId bigint not null primary key,
	resourcePrimKey bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	nodeId bigint,
	title varchar(75) null,
	version double precision,
	minorEdit bool,
	content text null,
	summary text null,
	format varchar(75) null,
	head bool,
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
	documentManagerDateCreate timestamp null,
	documentManagerTitle varchar(75) null,
	userId bigint,
	groupId bigint,
	companyId bigint
);

create table holiday_calendar (
	holidayCalendarId bigint not null primary key,
	holidayCalendarCode varchar(75) null,
	holidayCalendarDateCreate timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	receiverGroupName varchar(75) null,
	description varchar(75) null,
	type_ integer,
	active_ bool
);

create table pml_Reciever (
	recieverId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
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
	createDate timestamp null,
	modifiedDate timestamp null,
	recieverGroupName varchar(75) null,
	description varchar(75) null,
	type_ integer,
	active_ bool
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
	createDate timestamp null,
	modifiedDate timestamp null,
	carName varchar(255) null,
	carCode varchar(75) null,
	description text null
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
	startdate timestamp null,
	enddate timestamp null,
	canceldate timestamp null,
	canceldelegate varchar(75) null,
	datecreated timestamp null
);

create table pml_departmentleader (
	departmentsId varchar(75) not null,
	userId bigint not null,
	clericalid bigint,
	main bool,
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
	dateProcess timestamp null,
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
	dateprocess timestamp null,
	processinfomation varchar(75) null,
	receiver bigint,
	receivedate timestamp null,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	type_ integer,
	expireddate timestamp null,
	numdateprocess integer,
	processinstanceid bigint,
	maindepartmentprocessid varchar(75) null,
	mainuserprocessid bigint,
	senddatebefore timestamp null,
	departmentreceiveid varchar(75) null,
	departmentprocessid varchar(75) null,
	dateProcessTime timestamp null,
	receiveDateTime timestamp null,
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
	dateprocess timestamp null,
	processinfomation varchar(75) null,
	receiver bigint,
	receivedate timestamp null,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	expireddate timestamp null,
	numdateprocess integer,
	processinstanceid bigint,
	type_ integer,
	senddatebefore timestamp null,
	departmentreceiveid varchar(75) null,
	departmentprocessid varchar(75) null,
	dateprocesstime timestamp null,
	receivedatetime timestamp null,
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
	datecreated timestamp null,
	filetype varchar(75) null,
	fileid integer,
	title varchar(75) null,
	displayorhidden bool
);

create table pml_edm_bookdocumentrecordto (
	documentreceiptid bigint not null,
	documentrecordtoid bigint not null,
	datecreate timestamp null,
	datecomplete timestamp null,
	soCongVanDenPhongHienTai integer,
	primary key (documentreceiptid, documentrecordtoid)
);

create table pml_edm_bookdocumentsend (
	bookdocumentsendid bigint not null primary key,
	datecreated timestamp null,
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
	limitviewdetail bool,
	haveprocess bool,
	confidentiallevelsymbol integer
);

create table pml_edm_docconfuser (
	dcuId bigint not null primary key,
	userId bigint,
	viewAllDoc bool,
	viewDepDoc varchar(75) null
);

create table pml_edm_documentdelegate (
	documentDelegateId bigint not null primary key,
	userDelegateId bigint,
	userIsDelegateId bigint,
	documentId integer,
	fromtDate timestamp null,
	toDate timestamp null,
	cancelDate timestamp null
);

create table pml_edm_documentreceipt (
	documentReceiptId bigint not null primary key,
	levelsendid integer,
	documenttypeid bigint,
	documentreference varchar(75) null,
	issuingplaceid varchar(75) null,
	issuingdate timestamp null,
	datearrive timestamp null,
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
	datebutphe timestamp null,
	datehoanthanh timestamp null,
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
	issuingdate timestamp null,
	datearrive timestamp null,
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
	datebutphe timestamp null,
	datehoanthanh timestamp null,
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
	startprocessdate timestamp null,
	numdayprocessbef integer,
	limitdatebef timestamp null,
	extendreason varchar(75) null,
	numdayprocessaft integer,
	limitdateaft timestamp null,
	leanonlimitdate bool,
	extenduserid bigint,
	extenddepartmentid varchar(75) null
);

create table pml_edm_documentreceiptprocesstype (
	docReceiptProcessTypeId bigint not null primary key,
	documentReceiptId bigint,
	documentReceiptLogId bigint,
	processTypeOrderNo integer,
	dateEdit timestamp null,
	processTypeIdBefore varchar(75) null,
	processTypeIdAfter varchar(75) null,
	processTypeReason varchar(75) null,
	processerId bigint,
	departmentId varchar(75) null
);

create table pml_edm_documentrecordto (
	documentrecordtoid bigint not null primary key,
	datecreate timestamp null,
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
	leftisreceipt bool,
	rightisreceipt bool
);

create table pml_edm_documentsend (
	documentsendid bigint not null primary key,
	briefcontent varchar(75) null,
	documentreference varchar(75) null,
	receivingplace varchar(75) null,
	issuingdate timestamp null,
	opinion varchar(75) null,
	editorid bigint,
	signerid bigint,
	documenttypeid bigint,
	privilegelevelid varchar(75) null,
	confidentiallevelid varchar(75) null,
	datecreated timestamp null,
	islocal bool,
	active varchar(75) null,
	senddate timestamp null,
	signername varchar(75) null,
	position_ varchar(75) null,
	numberpage varchar(75) null,
	numberpublish varchar(75) null,
	documentsendcode varchar(75) null,
	statusid bigint,
	iscongvanphucdap bool,
	numofdocref bigint,
	ispublish bool,
	orgexternalid bigint,
	numofdirector bool,
	documentrecordtypeid integer
);

create table pml_edm_documenttype (
	documenttypeid bigint not null primary key,
	documenttypename varchar(75) null,
	documentsymbol varchar(75) null,
	documentrecordtypeid integer,
	sendreceiptdistinction integer,
	HaveDepartExtends bool
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
	datecreated timestamp null,
	dateupdate timestamp null
);

create table pml_edm_writedocumentsend (
	bookdocumentsendid bigint not null,
	documentsendid bigint not null,
	datecreated timestamp null,
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
	exactReturningDate timestamp null,
	receiverId bigint,
	validDate timestamp null,
	expectedReturningDate timestamp null,
	applicationDate timestamp null,
	otherContent varchar(75) null,
	briefContent varchar(75) null,
	applicantName varchar(75) null,
	organization varchar(75) null,
	authorisedLetter varchar(75) null,
	idNumber varchar(75) null,
	issuingDate timestamp null,
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
	landCheckingDate timestamp null,
	decisionNotice varchar(75) null,
	receiver varchar(75) null,
	dateCreated timestamp null,
	lastUpdate timestamp null,
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
	inputdatadate timestamp null,
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
	datecreated timestamp null,
	filetype varchar(75) null,
	title varchar(75) null
);

create table pml_filereturninginfo (
	filereturninginfoid bigint not null primary key,
	fileid varchar(75) null,
	filesender varchar(75) null,
	licensenumber varchar(75) null,
	issuingdatelicense timestamp null,
	receivelicensedate timestamp null,
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
	ngay_mo_hscv timestamp null,
	han_xu_ly timestamp null,
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
	from_date timestamp null,
	to_date timestamp null
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
	startdate timestamp null,
	enddate timestamp null
);

create table pml_message_note (
	messageId bigint not null primary key,
	documentId bigint,
	fromUserId bigint,
	toUserId bigint,
	createDate timestamp null,
	objectType varchar(75) null,
	isAlert bool
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
	isownerorg bool
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
	dateprocess timestamp null,
	processinfomation varchar(75) null,
	receiver bigint,
	receivedate timestamp null,
	stateprocessidbefore bigint,
	stateprocessidafter bigint,
	expireddate timestamp null,
	delegateuser bigint,
	senddate timestamp null
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
	createDate timestamp null,
	modifiedDate timestamp null,
	roomName varchar(255) null,
	description text null
);

create table pml_saveprocesstype (
	sptid bigint not null primary key,
	docId bigint,
	flagprocesstype bigint,
	flag bool
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
	publishDate timestamp null,
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
	active bool,
	screenname varchar(75) null,
	firstname varchar(75) null,
	middlename varchar(75) null,
	lastname varchar(75) null,
	male bool,
	birthday timestamp null,
	isleadermetting bool
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
	startDate timestamp null,
	endDate timestamp null
);

create table report_registry_work (
	reportRegistryId bigint not null primary key,
	reportRegistryCode varchar(75) null,
	userCreate varchar(75) null,
	resultWork varchar(75) null,
	programWork varchar(75) null,
	reportDate timestamp null,
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



insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (1, 'Canada', 'CA', 'CAN', '124', '001', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (2, 'China', 'CN', 'CHN', '156', '086', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (3, 'France', 'FR', 'FRA', '250', '033', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (4, 'Germany', 'DE', 'DEU', '276', '049', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (5, 'Hong Kong', 'HK', 'HKG', '344', '852', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (6, 'Hungary', 'HU', 'HUN', '348', '036', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (7, 'Israel', 'IL', 'ISR', '376', '972', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (8, 'Italy', 'IT', 'ITA', '380', '039', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (9, 'Japan', 'JP', 'JPN', '392', '081', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (10, 'South Korea', 'KR', 'KOR', '410', '082', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (11, 'Netherlands', 'NL', 'NLD', '528', '031', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (12, 'Portugal', 'PT', 'PRT', '620', '351', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (13, 'Russia', 'RU', 'RUS', '643', '007', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (14, 'Singapore', 'SG', 'SGP', '702', '065', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (15, 'Spain', 'ES', 'ESP', '724', '034', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (16, 'Turkey', 'TR', 'TUR', '792', '090', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (17, 'Vietnam', 'VM', 'VNM', '704', '084', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (18, 'United Kingdom', 'GB', 'GBR', '826', '044', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (19, 'United States', 'US', 'USA', '840', '001', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (20, 'Afghanistan', 'AF', 'AFG', '4', '093', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (21, 'Albania', 'AL', 'ALB', '8', '355', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (22, 'Algeria', 'DZ', 'DZA', '12', '213', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (23, 'American Samoa', 'AS', 'ASM', '16', '684', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (24, 'Andorra', 'AD', 'AND', '20', '376', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (25, 'Angola', 'AO', 'AGO', '24', '244', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (26, 'Anguilla', 'AI', 'AIA', '660', '264', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (27, 'Antarctica', 'AQ', 'ATA', '10', '672', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (28, 'Antigua', 'AG', 'ATG', '28', '268', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (29, 'Argentina', 'AR', 'ARG', '32', '054', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (30, 'Armenia', 'AM', 'ARM', '51', '374', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (31, 'Aruba', 'AW', 'ABW', '533', '297', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (32, 'Australia', 'AU', 'AUS', '36', '061', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (33, 'Austria', 'AT', 'AUT', '40', '043', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (34, 'Azerbaijan', 'AZ', 'AZE', '31', '994', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (35, 'Bahamas', 'BS', 'BHS', '44', '242', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (36, 'Bahrain', 'BH', 'BHR', '48', '973', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (37, 'Bangladesh', 'BD', 'BGD', '50', '880', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (38, 'Barbados', 'BB', 'BRB', '52', '246', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (39, 'Belarus', 'BY', 'BLR', '112', '375', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (40, 'Belgium', 'BE', 'BEL', '56', '032', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (41, 'Belize', 'BZ', 'BLZ', '84', '501', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (42, 'Benin', 'BJ', 'BEN', '204', '229', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (43, 'Bermuda', 'BM', 'BMU', '60', '441', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (44, 'Bhutan', 'BT', 'BTN', '64', '975', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (45, 'Bolivia', 'BO', 'BOL', '68', '591', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (46, 'Bosnia-Herzegovina', 'BA', 'BIH', '70', '387', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (47, 'Botswana', 'BW', 'BWA', '72', '267', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (48, 'Brazil', 'BR', 'BRA', '76', '055', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (49, 'British Virgin Islands', 'VG', 'VGB', '92', '284', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (50, 'Brunei', 'BN', 'BRN', '96', '673', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (51, 'Bulgaria', 'BG', 'BGR', '100', '359', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (52, 'Burkina Faso', 'BF', 'BFA', '854', '226', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (53, 'Burma (Myanmar)', 'MM', 'MMR', '104', '095', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (54, 'Burundi', 'BI', 'BDI', '108', '257', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (55, 'Cambodia', 'KH', 'KHM', '116', '855', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (56, 'Cameroon', 'CM', 'CMR', '120', '237', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (57, 'Cape Verde Island', 'CV', 'CPV', '132', '238', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (58, 'Cayman Islands', 'KY', 'CYM', '136', '345', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (59, 'Central African Republic', 'CF', 'CAF', '140', '236', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (60, 'Chad', 'TD', 'TCD', '148', '235', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (61, 'Chile', 'CL', 'CHL', '152', '056', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (62, 'Christmas Island', 'CX', 'CXR', '162', '061', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (63, 'Cocos Islands', 'CC', 'CCK', '166', '061', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (64, 'Colombia', 'CO', 'COL', '170', '057', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (65, 'Comoros', 'KM', 'COM', '174', '269', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (66, 'Republic of Congo', 'CD', 'COD', '180', '242', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (67, 'Democratic Republic of Congo', 'CG', 'COG', '178', '243', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (68, 'Cook Islands', 'CK', 'COK', '184', '682', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (69, 'Costa Rica', 'CR', 'CRI', '188', '506', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (70, 'Croatia', 'HR', 'HRV', '191', '385', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (71, 'Cuba', 'CU', 'CUB', '192', '053', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (72, 'Cyprus', 'CY', 'CYP', '196', '357', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (73, 'Czech Republic', 'CZ', 'CZE', '203', '420', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (74, 'Denmark', 'DK', 'DNK', '208', '045', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (75, 'Djibouti', 'DJ', 'DJI', '262', '253', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (76, 'Dominica', 'DM', 'DMA', '212', '767', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (77, 'Dominican Republic', 'DO', 'DOM', '214', '809', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (78, 'Ecuador', 'EC', 'ECU', '218', '593', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (79, 'Egypt', 'EG', 'EGY', '818', '020', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (80, 'El Salvador', 'SV', 'SLV', '222', '503', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (81, 'Equatorial Guinea', 'GQ', 'GNQ', '226', '240', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (82, 'Eritrea', 'ER', 'ERI', '232', '291', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (83, 'Estonia', 'EE', 'EST', '233', '372', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (84, 'Ethiopia', 'ET', 'ETH', '231', '251', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (85, 'Faeroe Islands', 'FO', 'FRO', '234', '298', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (86, 'Falkland Islands', 'FK', 'FLK', '238', '500', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (87, 'Fiji Islands', 'FJ', 'FJI', '242', '679', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (88, 'Finland', 'FI', 'FIN', '246', '358', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (89, 'French Guiana', 'GF', 'GUF', '254', '594', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (90, 'French Polynesia', 'PF', 'PYF', '258', '689', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (91, 'Gabon', 'GA', 'GAB', '266', '241', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (92, 'Gambia', 'GM', 'GMB', '270', '220', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (93, 'Georgia', 'GE', 'GEO', '268', '995', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (94, 'Ghana', 'GH', 'GHA', '288', '233', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (95, 'Gibraltar', 'GI', 'GIB', '292', '350', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (96, 'Greece', 'GR', 'GRC', '300', '030', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (97, 'Greenland', 'GL', 'GRL', '304', '299', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (98, 'Grenada', 'GD', 'GRD', '308', '473', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (99, 'Guadeloupe', 'GP', 'GLP', '312', '590', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (100, 'Guam', 'GU', 'GUM', '316', '671', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (101, 'Guatemala', 'GT', 'GTM', '320', '502', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (102, 'Guinea', 'GN', 'GIN', '324', '224', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (103, 'Guinea-Bissau', 'GW', 'GNB', '624', '245', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (104, 'Guyana', 'GY', 'GUY', '328', '592', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (105, 'Haiti', 'HT', 'HTI', '332', '509', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (106, 'Honduras', 'HN', 'HND', '340', '504', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (107, 'Iceland', 'IS', 'ISL', '352', '354', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (108, 'India', 'IN', 'IND', '356', '091', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (109, 'Indonesia', 'ID', 'IDN', '360', '062', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (110, 'Iran', 'IR', 'IRN', '364', '098', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (111, 'Iraq', 'IQ', 'IRQ', '368', '964', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (112, 'Ireland', 'IE', 'IRL', '372', '353', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (113, 'Ivory Coast', 'CI', 'CIV', '384', '225', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (114, 'Jamaica', 'JM', 'JAM', '388', '876', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (115, 'Jordan', 'JO', 'JOR', '400', '962', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (116, 'Kazakhstan', 'KZ', 'KAZ', '398', '007', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (117, 'Kenya', 'KE', 'KEN', '404', '254', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (118, 'Kiribati', 'KI', 'KIR', '408', '686', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (119, 'Kuwait', 'KW', 'KWT', '414', '965', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (120, 'North Korea', 'KP', 'PRK', '408', '850', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (121, 'Kyrgyzstan', 'KG', 'KGZ', '471', '996', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (122, 'Laos', 'LA', 'LAO', '418', '856', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (123, 'Latvia', 'LV', 'LVA', '428', '371', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (124, 'Lebanon', 'LB', 'LBN', '422', '961', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (125, 'Lesotho', 'LS', 'LSO', '426', '266', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (126, 'Liberia', 'LR', 'LBR', '430', '231', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (127, 'Libya', 'LY', 'LBY', '434', '218', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (128, 'Liechtenstein', 'LI', 'LIE', '438', '423', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (129, 'Lithuania', 'LT', 'LTU', '440', '370', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (130, 'Luxembourg', 'LU', 'LUX', '442', '352', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (131, 'Macau', 'MO', 'MAC', '446', '853', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (132, 'Macedonia', 'MK', 'MKD', '807', '389', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (133, 'Madagascar', 'MG', 'MDG', '450', '261', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (134, 'Malawi', 'MW', 'MWI', '454', '265', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (135, 'Malaysia', 'MY', 'MYS', '458', '060', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (136, 'Maldives', 'MV', 'MDV', '462', '960', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (137, 'Mali', 'ML', 'MLI', '466', '223', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (138, 'Malta', 'MT', 'MLT', '470', '356', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (139, 'Marshall Islands', 'MH', 'MHL', '584', '692', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (140, 'Martinique', 'MQ', 'MTQ', '474', '596', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (141, 'Mauritania', 'MR', 'MRT', '478', '222', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (142, 'Mauritius', 'MU', 'MUS', '480', '230', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (143, 'Mayotte Island', 'YT', 'MYT', '175', '269', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (144, 'Mexico', 'MX', 'MEX', '484', '052', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (145, 'Micronesia', 'FM', 'FSM', '583', '691', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (146, 'Moldova', 'MD', 'MDA', '498', '373', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (147, 'Monaco', 'MC', 'MCO', '492', '377', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (148, 'Mongolia', 'MN', 'MNG', '496', '976', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (149, 'Montenegro', 'ME', 'MNE', '499', '382', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (150, 'Montserrat', 'MS', 'MSR', '500', '664', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (151, 'Morocco', 'MA', 'MAR', '504', '212', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (152, 'Mozambique', 'MZ', 'MOZ', '508', '258', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (153, 'Namibia', 'NA', 'NAM', '516', '264', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (154, 'Nauru', 'NR', 'NRU', '520', '674', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (155, 'Nepal', 'NP', 'NPL', '524', '977', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (156, 'Netherlands Antilles', 'AN', 'ANT', '530', '599', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (157, 'New Caledonia', 'NC', 'NCL', '540', '687', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (158, 'New Zealand', 'NZ', 'NZL', '554', '064', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (159, 'Nicaragua', 'NI', 'NIC', '558', '505', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (160, 'Niger', 'NE', 'NER', '562', '227', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (161, 'Nigeria', 'NG', 'NGA', '566', '234', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (162, 'Niue', 'NU', 'NIU', '570', '683', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (163, 'Norfolk Island', 'NF', 'NFK', '574', '672', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (164, 'Norway', 'NO', 'NOR', '578', '047', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (165, 'Oman', 'OM', 'OMN', '512', '968', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (166, 'Pakistan', 'PK', 'PAK', '586', '092', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (167, 'Palau', 'PW', 'PLW', '585', '680', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (168, 'Palestine', 'PS', 'PSE', '275', '970', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (169, 'Panama', 'PA', 'PAN', '591', '507', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (170, 'Papua New Guinea', 'PG', 'PNG', '598', '675', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (171, 'Paraguay', 'PY', 'PRY', '600', '595', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (172, 'Peru', 'PE', 'PER', '604', '051', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (173, 'Philippines', 'PH', 'PHL', '608', '063', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (174, 'Poland', 'PL', 'POL', '616', '048', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (175, 'Puerto Rico', 'PR', 'PRI', '630', '787', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (176, 'Qatar', 'QA', 'QAT', '634', '974', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (177, 'Reunion Island', 'RE', 'REU', '638', '262', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (178, 'Romania', 'RO', 'ROU', '642', '040', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (179, 'Rwanda', 'RW', 'RWA', '646', '250', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (180, 'St. Helena', 'SH', 'SHN', '654', '290', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (181, 'St. Kitts', 'KN', 'KNA', '659', '869', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (182, 'St. Lucia', 'LC', 'LCA', '662', '758', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (183, 'St. Pierre & Miquelon', 'PM', 'SPM', '666', '508', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (184, 'St. Vincent', 'VC', 'VCT', '670', '784', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (185, 'San Marino', 'SM', 'SMR', '674', '378', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (186, 'Sao Tome & Principe', 'ST', 'STP', '678', '239', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (187, 'Saudi Arabia', 'SA', 'SAU', '682', '966', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (188, 'Senegal', 'SN', 'SEN', '686', '221', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (189, 'Serbia', 'RS', 'SRB', '688', '381', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (190, 'Seychelles', 'SC', 'SYC', '690', '248', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (191, 'Sierra Leone', 'SL', 'SLE', '694', '249', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (192, 'Slovakia', 'SK', 'SVK', '703', '421', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (193, 'Slovenia', 'SI', 'SVN', '705', '386', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (194, 'Solomon Islands', 'SB', 'SLB', '90', '677', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (195, 'Somalia', 'SO', 'SOM', '706', '252', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (196, 'South Africa', 'ZA', 'ZAF', '710', '027', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (197, 'Sri Lanka', 'LK', 'LKA', '144', '094', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (198, 'Sudan', 'SD', 'SDN', '736', '095', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (199, 'Suriname', 'SR', 'SUR', '740', '597', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (200, 'Swaziland', 'SZ', 'SWZ', '748', '268', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (201, 'Sweden', 'SE', 'SWE', '752', '046', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (202, 'Switzerland', 'CH', 'CHE', '756', '041', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (203, 'Syria', 'SY', 'SYR', '760', '963', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (204, 'Taiwan', 'TW', 'TWN', '158', '886', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (205, 'Tajikistan', 'TJ', 'TJK', '762', '992', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (206, 'Tanzania', 'TZ', 'TZA', '834', '255', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (207, 'Thailand', 'TH', 'THA', '764', '066', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (208, 'Togo', 'TG', 'TGO', '768', '228', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (209, 'Tonga', 'TO', 'TON', '776', '676', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (210, 'Trinidad & Tobago', 'TT', 'TTO', '780', '868', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (211, 'Tunisia', 'TN', 'TUN', '788', '216', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (212, 'Turkmenistan', 'TM', 'TKM', '795', '993', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (213, 'Turks & Caicos', 'TC', 'TCA', '796', '649', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (214, 'Tuvalu', 'TV', 'TUV', '798', '688', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (215, 'Uganda', 'UG', 'UGA', '800', '256', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (216, 'Ukraine', 'UA', 'UKR', '804', '380', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (217, 'United Arab Emirates', 'AE', 'ARE', '784', '971', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (218, 'Uruguay', 'UY', 'URY', '858', '598', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (219, 'Uzbekistan', 'UZ', 'UZB', '860', '998', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (220, 'Vanuatu', 'VU', 'VUT', '548', '678', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (221, 'Vatican City', 'VA', 'VAT', '336', '039', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (222, 'Venezuela', 'VE', 'VEN', '862', '058', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (223, 'Wallis & Futuna', 'WF', 'WLF', '876', '681', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (224, 'Western Samoa', 'EH', 'ESH', '732', '685', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (225, 'Yemen', 'YE', 'YEM', '887', '967', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (226, 'Zambia', 'ZM', 'ZMB', '894', '260', true);
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (227, 'Zimbabwe', 'ZW', 'ZWE', '716', '263', true);

insert into Region (regionId, countryId, regionCode, name, active_) values (1, 19, 'AL', 'Alabama', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (2, 19, 'AK', 'Alaska', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (3, 19, 'AZ', 'Arizona', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (4, 19, 'AR', 'Arkansas', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (5, 19, 'CA', 'California', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (6, 19, 'CO', 'Colorado', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (7, 19, 'CT', 'Connecticut', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (8, 19, 'DC', 'District of Columbia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (9, 19, 'DE', 'Delaware', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (10, 19, 'FL', 'Florida', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (11, 19, 'GA', 'Georgia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (12, 19, 'HI', 'Hawaii', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (13, 19, 'ID', 'Idaho', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (14, 19, 'IL', 'Illinois', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (15, 19, 'IN', 'Indiana', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (16, 19, 'IA', 'Iowa', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (17, 19, 'KS', 'Kansas', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (18, 19, 'KY', 'Kentucky ', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (19, 19, 'LA', 'Louisiana ', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (20, 19, 'ME', 'Maine', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (21, 19, 'MD', 'Maryland', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (22, 19, 'MA', 'Massachusetts', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (23, 19, 'MI', 'Michigan', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (24, 19, 'MN', 'Minnesota', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (25, 19, 'MS', 'Mississippi', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (26, 19, 'MO', 'Missouri', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (27, 19, 'MT', 'Montana', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (28, 19, 'NE', 'Nebraska', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (29, 19, 'NV', 'Nevada', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (30, 19, 'NH', 'New Hampshire', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (31, 19, 'NJ', 'New Jersey', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (32, 19, 'NM', 'New Mexico', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (33, 19, 'NY', 'New York', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (34, 19, 'NC', 'North Carolina', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (35, 19, 'ND', 'North Dakota', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (36, 19, 'OH', 'Ohio', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (37, 19, 'OK', 'Oklahoma ', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (38, 19, 'OR', 'Oregon', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (39, 19, 'PA', 'Pennsylvania', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (40, 19, 'PR', 'Puerto Rico', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (41, 19, 'RI', 'Rhode Island', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (42, 19, 'SC', 'South Carolina', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (43, 19, 'SD', 'South Dakota', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (44, 19, 'TN', 'Tennessee', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (45, 19, 'TX', 'Texas', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (46, 19, 'UT', 'Utah', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (47, 19, 'VT', 'Vermont', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (48, 19, 'VA', 'Virginia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (49, 19, 'WA', 'Washington', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (50, 19, 'WV', 'West Virginia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (51, 19, 'WI', 'Wisconsin', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (52, 19, 'WY', 'Wyoming', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (53, 1, 'AL', 'Alberta', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (54, 1, 'BC', 'British Columbia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (55, 1, 'MB', 'Manitoba', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (56, 1, 'NB', 'New Brunswick', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (57, 1, 'NL', 'Newfoundland and Labrador', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (58, 1, 'NT', 'Northwest Territories', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (59, 1, 'NS', 'Nova Scotia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (60, 1, 'NU', 'Nunavut', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (61, 1, 'ON', 'Ontario', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (62, 1, 'PE', 'Prince Edward Island', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (63, 1, 'QC', 'Quebec', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (64, 1, 'SK', 'Saskatchewan', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (65, 1, 'YT', 'Yukon', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (66, 15, 'AN', 'Andalusia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (67, 15, 'AR', 'Aragon', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (68, 15, 'AS', 'Asturias', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (69, 15, 'IB', 'Balearic Islands', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (70, 15, 'PV', 'Basque Country', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (71, 15, 'CN', 'Canary Islands', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (72, 15, 'CB', 'Cantabria', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (73, 15, 'CL', 'Castile and Leon', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (74, 15, 'CM', 'Castile-La Mancha', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (75, 15, 'CT', 'Catalonia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (76, 15, 'CE', 'Ceuta', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (77, 15, 'EX', 'Extremadura', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (78, 15, 'GA', 'Galicia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (79, 15, 'LO', 'La Rioja', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (80, 15, 'M', 'Madrid', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (81, 15, 'ML', 'Melilla', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (82, 15, 'MU', 'Murcia', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (83, 15, 'NA', 'Navarra', true);
insert into Region (regionId, countryId, regionCode, name, active_) values (84, 15, 'VC', 'Valencia', true);

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


insert into Release_ (releaseId, createDate, modifiedDate, buildNumber, verified) values (1, current_timestamp, current_timestamp, 5102, false);


create table QUARTZ_JOB_DETAILS (
	JOB_NAME varchar(80) not null,
	JOB_GROUP varchar(80) not null,
	DESCRIPTION varchar(120) null,
	JOB_CLASS_NAME varchar(128) not null,
	IS_DURABLE bool not null,
	IS_VOLATILE bool not null,
	IS_STATEFUL bool not null,
	REQUESTS_RECOVERY bool not null,
	JOB_DATA bytea null,
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
	IS_VOLATILE bool not null,
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
	JOB_DATA bytea null,
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
	BLOB_DATA bytea null,
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
	CALENDAR bytea not null
);

create table QUARTZ_PAUSED_TRIGGER_GRPS (
	TRIGGER_GROUP varchar(80) not null primary key
);

create table QUARTZ_FIRED_TRIGGERS (
	ENTRY_ID varchar(95) not null primary key,
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	IS_VOLATILE bool not null,
	INSTANCE_NAME varchar(80) not null,
	FIRED_TIME bigint not null,
	PRIORITY integer not null,
	STATE varchar(16) not null,
	JOB_NAME varchar(80) null,
	JOB_GROUP varchar(80) null,
	IS_STATEFUL bool null,
	REQUESTS_RECOVERY bool null
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


create index IX_93D5AD4E on Address (companyId);
create index IX_ABD7DAC0 on Address (companyId, classNameId);
create index IX_71CB1123 on Address (companyId, classNameId, classPK);
create index IX_923BD178 on Address (companyId, classNameId, classPK, mailing);
create index IX_9226DBB4 on Address (companyId, classNameId, classPK, primary_);
create index IX_5BC8B0D4 on Address (userId);

create index IX_6EDB9600 on AnnouncementsDelivery (userId);
create index IX_BA4413D5 on AnnouncementsDelivery (userId, type_);

create index IX_A6EF0B81 on AnnouncementsEntry (classNameId, classPK);
create index IX_14F06A6B on AnnouncementsEntry (classNameId, classPK, alert);
create index IX_D49C2E66 on AnnouncementsEntry (userId);
create index IX_1AFBDE08 on AnnouncementsEntry (uuid_);

create index IX_9C7EB9F on AnnouncementsFlag (entryId);
create index IX_4539A99C on AnnouncementsFlag (userId, entryId, value);

create index IX_72EF6041 on BlogsEntry (companyId);
create index IX_3D3D30B0 on BlogsEntry (companyId, draft);
create index IX_81A50303 on BlogsEntry (groupId);
create index IX_5FF14FAE on BlogsEntry (groupId, draft);
create index IX_DB780A20 on BlogsEntry (groupId, urlTitle);
create index IX_C07CA83D on BlogsEntry (groupId, userId);
create index IX_BC2A3534 on BlogsEntry (groupId, userId, draft);
create index IX_69157A4D on BlogsEntry (uuid_);
create index IX_1B1040FD on BlogsEntry (uuid_, groupId);

create index IX_90CDA39A on BlogsStatsUser (companyId, entryCount);
create index IX_43840EEB on BlogsStatsUser (groupId);
create index IX_28C78D5C on BlogsStatsUser (groupId, entryCount);
create index IX_82254C25 on BlogsStatsUser (groupId, userId);
create index IX_BB51F1D9 on BlogsStatsUser (userId);

create index IX_443BDC38 on BookmarksEntry (folderId);
create index IX_B670BA39 on BookmarksEntry (uuid_);

create index IX_2ABA25D7 on BookmarksFolder (companyId);
create index IX_7F703619 on BookmarksFolder (groupId);
create index IX_967799C0 on BookmarksFolder (groupId, parentFolderId);
create index IX_451E7AE3 on BookmarksFolder (uuid_);
create index IX_DC2F8927 on BookmarksFolder (uuid_, groupId);

create index IX_12EE4898 on CalEvent (groupId);
create index IX_4FDDD2BF on CalEvent (groupId, repeating);
create index IX_FCD7C63D on CalEvent (groupId, type_);
create index IX_C1AD2122 on CalEvent (uuid_);
create index IX_5CCE79C8 on CalEvent (uuid_, groupId);

create index IX_B27A301F on ClassName_ (value);

create index IX_38EFE3FD on Company (logoId);
create index IX_12566EC2 on Company (mx);
create index IX_975996C0 on Company (virtualHost);
create index IX_EC00543C on Company (webId);

create index IX_66D496A3 on Contact_ (companyId);

create index IX_717B97E1 on Country (a2);
create index IX_717B9BA2 on Country (a3);
create index IX_25D734CD on Country (active_);
create index IX_19DA007B on Country (name);

create index IX_4CB1B2B4 on DLFileEntry (companyId);
create index IX_24A846D1 on DLFileEntry (folderId);
create index IX_8F6C75D0 on DLFileEntry (folderId, name);
create index IX_A9951F17 on DLFileEntry (folderId, title);
create index IX_64F0FE40 on DLFileEntry (uuid_);

create index IX_CE705D48 on DLFileRank (companyId, userId, folderId, name);
create index IX_40B56512 on DLFileRank (folderId, name);
create index IX_EED06670 on DLFileRank (userId);

create index IX_E56EC6AD on DLFileShortcut (folderId);
create index IX_CA2708A2 on DLFileShortcut (toFolderId, toName);
create index IX_4831EBE4 on DLFileShortcut (uuid_);

create index IX_9CD91DB6 on DLFileVersion (folderId, name);
create index IX_6C5E6512 on DLFileVersion (folderId, name, version);

create index IX_A74DB14C on DLFolder (companyId);
create index IX_F2EA1ACE on DLFolder (groupId);
create index IX_49C37475 on DLFolder (groupId, parentFolderId);
create index IX_902FD874 on DLFolder (groupId, parentFolderId, name);
create index IX_51556082 on DLFolder (parentFolderId, name);
create index IX_CBC408D8 on DLFolder (uuid_);
create index IX_3CC1DED2 on DLFolder (uuid_, groupId);

create index IX_1BB072CA on EmailAddress (companyId);
create index IX_49D2DEC4 on EmailAddress (companyId, classNameId);
create index IX_551A519F on EmailAddress (companyId, classNameId, classPK);
create index IX_2A2CB130 on EmailAddress (companyId, classNameId, classPK, primary_);
create index IX_7B43CD8 on EmailAddress (userId);

create index IX_A8C0CBE8 on ExpandoColumn (tableId);
create index IX_FEFC8DA7 on ExpandoColumn (tableId, name);

create index IX_D3F5D7AE on ExpandoRow (tableId);
create index IX_81EFBFF5 on ExpandoRow (tableId, classPK);

create index IX_F0A86A4F on ExpandoTable (classNameId);
create index IX_DED782CE on ExpandoTable (classNameId, name);

create index IX_B29FEF17 on ExpandoValue (classNameId, classPK);
create index IX_F7DD0987 on ExpandoValue (columnId);
create index IX_9DDD21E5 on ExpandoValue (columnId, rowId_);
create index IX_9112A7A0 on ExpandoValue (rowId_);
create index IX_F0566A77 on ExpandoValue (tableId);
create index IX_886B68D1 on ExpandoValue (tableId, columnId, classNameId, classPK);
create index IX_B5984EDA on ExpandoValue (tableId, columnId, rowId_);
create index IX_B71E92D5 on ExpandoValue (tableId, rowId_);

create index IX_D0D5E397 on Group_ (companyId, classNameId, classPK);
create index IX_5BDDB872 on Group_ (companyId, friendlyURL);
create index IX_5AA68501 on Group_ (companyId, name);
create index IX_16218A38 on Group_ (liveGroupId);

create index LIFERAY_001 on Groups_Permissions (permissionId);

create index IX_60214CF6 on IGFolder (companyId);
create index IX_206498F8 on IGFolder (groupId);
create index IX_1A605E9F on IGFolder (groupId, parentFolderId);
create index IX_9BBAFB1E on IGFolder (groupId, parentFolderId, name);
create index IX_F73C0982 on IGFolder (uuid_);
create index IX_B10EFD68 on IGFolder (uuid_, groupId);

create index IX_E597322D on IGImage (custom1ImageId);
create index IX_D9E0A34C on IGImage (custom2ImageId);
create index IX_4438CA80 on IGImage (folderId);
create index IX_BCB13A3F on IGImage (folderId, name);
create index IX_64F0B572 on IGImage (largeImageId);
create index IX_D3D32126 on IGImage (smallImageId);
create index IX_265BB0F1 on IGImage (uuid_);

create index IX_6A925A4D on Image (size_);

create index IX_DFF98523 on JournalArticle (companyId);
create index IX_9356F865 on JournalArticle (groupId);
create index IX_68C0F69C on JournalArticle (groupId, articleId);
create index IX_8DBF1387 on JournalArticle (groupId, articleId, approved);
create index IX_85C52EEC on JournalArticle (groupId, articleId, version);
create index IX_2E207659 on JournalArticle (groupId, structureId);
create index IX_8DEAE14E on JournalArticle (groupId, templateId);
create index IX_EF9B7028 on JournalArticle (smallImageId);
create index IX_F029602F on JournalArticle (uuid_);
create index IX_3463D95B on JournalArticle (uuid_, groupId);

create index IX_3B51BB68 on JournalArticleImage (groupId);
create index IX_158B526F on JournalArticleImage (groupId, articleId, version);
create index IX_D67292FC on JournalArticleImage (groupId, articleId, version, elName, languageId);
create index IX_D4121315 on JournalArticleImage (tempImage);

create index IX_F8433677 on JournalArticleResource (groupId);
create index IX_88DF994A on JournalArticleResource (groupId, articleId);

create index IX_6838E427 on JournalContentSearch (groupId, articleId);
create index IX_20962903 on JournalContentSearch (groupId, privateLayout);
create index IX_7CC7D73E on JournalContentSearch (groupId, privateLayout, articleId);
create index IX_B3B318DC on JournalContentSearch (groupId, privateLayout, layoutId);
create index IX_7ACC74C9 on JournalContentSearch (groupId, privateLayout, layoutId, portletId);
create index IX_C3AA93B8 on JournalContentSearch (groupId, privateLayout, layoutId, portletId, articleId);

create index IX_35A2DB2F on JournalFeed (groupId);
create index IX_65576CBC on JournalFeed (groupId, feedId);
create index IX_50C36D79 on JournalFeed (uuid_);
create index IX_39031F51 on JournalFeed (uuid_, groupId);

create index IX_B97F5608 on JournalStructure (groupId);
create index IX_AB6E9996 on JournalStructure (groupId, structureId);
create index IX_8831E4FC on JournalStructure (structureId);
create index IX_6702CA92 on JournalStructure (uuid_);
create index IX_42E86E58 on JournalStructure (uuid_, groupId);

create index IX_77923653 on JournalTemplate (groupId);
create index IX_1701CB2B on JournalTemplate (groupId, structureId);
create index IX_E802AA3C on JournalTemplate (groupId, templateId);
create index IX_25FFB6FA on JournalTemplate (smallImageId);
create index IX_1B12CA20 on JournalTemplate (templateId);
create index IX_2857419D on JournalTemplate (uuid_);
create index IX_62D1B3AD on JournalTemplate (uuid_, groupId);

create index IX_C7FBC998 on Layout (companyId);
create index IX_FAD05595 on Layout (dlFolderId);
create index IX_C099D61A on Layout (groupId);
create index IX_705F5AA3 on Layout (groupId, privateLayout);
create index IX_BC2C4231 on Layout (groupId, privateLayout, friendlyURL);
create index IX_7162C27C on Layout (groupId, privateLayout, layoutId);
create index IX_6DE88B06 on Layout (groupId, privateLayout, parentLayoutId);
create index IX_1A1B61D2 on Layout (groupId, privateLayout, type_);
create index IX_23922F7D on Layout (iconImageId);

create index IX_A40B8BEC on LayoutSet (groupId);
create index IX_48550691 on LayoutSet (groupId, privateLayout);
create index IX_5ABC2905 on LayoutSet (virtualHost);

create index IX_2932DD37 on ListType (type_);

create index IX_69951A25 on MBBan (banUserId);
create index IX_5C3FF12A on MBBan (groupId);
create index IX_8ABC4E3B on MBBan (groupId, banUserId);
create index IX_48814BBA on MBBan (userId);

create index IX_BC735DCF on MBCategory (companyId);
create index IX_BB870C11 on MBCategory (groupId);
create index IX_ED292508 on MBCategory (groupId, parentCategoryId);
create index IX_C2626EDB on MBCategory (uuid_);
create index IX_F7D28C2F on MBCategory (uuid_, groupId);

create index IX_79D0120B on MBDiscussion (classNameId);
create index IX_33A4DE38 on MBDiscussion (classNameId, classPK);
create index IX_B5CA2DC on MBDiscussion (threadId);

create index IX_3C865EE5 on MBMessage (categoryId);
create index IX_138C7F1E on MBMessage (categoryId, threadId);
create index IX_B1432D30 on MBMessage (companyId);
create index IX_75B95071 on MBMessage (threadId);
create index IX_A7038CD7 on MBMessage (threadId, parentMessageId);
create index IX_C57B16BC on MBMessage (uuid_);

create index IX_D180D4AE on MBMessageFlag (messageId);
create index IX_7B2917BE on MBMessageFlag (userId);
create index IX_94A83834 on MBMessageFlag (userId, messageId);

create index IX_A00A898F on MBStatsUser (groupId);
create index IX_FAB5A88B on MBStatsUser (groupId, messageCount);
create index IX_9168E2C9 on MBStatsUser (groupId, userId);
create index IX_847F92B5 on MBStatsUser (userId);

create index IX_CB854772 on MBThread (categoryId);

create index IX_FA179180 on MeetingCalComponent (mcalId);

create index IX_F199C38B on MeetingCalendar (groupId);
create index IX_3B1B516 on MeetingCalendar (groupId, state);
create index IX_5AD0BCD5 on MeetingCalendar (uuid_);
create index IX_A1E35775 on MeetingCalendar (uuid_, groupId);

create index IX_67E076A0 on MeetingDetailWeek (mdweekId);
create index IX_D15DC0FF on MeetingDetailWeek (week, year);

create index IX_8A1CC4B on MembershipRequest (groupId);
create index IX_C28C72EC on MembershipRequest (groupId, statusId);
create index IX_66D70879 on MembershipRequest (userId);

create index IX_A425F71A on OrgGroupPermission (groupId);
create index IX_6C53DA4E on OrgGroupPermission (permissionId);

create index IX_4A527DD3 on OrgGroupRole (groupId);
create index IX_AB044D1C on OrgGroupRole (roleId);

create index IX_6AF0D434 on OrgLabor (organizationId);

create index IX_834BCEB6 on Organization_ (companyId);
create index IX_E301BDF5 on Organization_ (companyId, name);
create index IX_418E4522 on Organization_ (companyId, parentOrganizationId);

create index IX_D7390C66 on PML_Country (active);
create index IX_3A155227 on PML_Country (countryCode);
create index IX_10E0D02 on PML_Country (countryCode, countryName, description);
create index IX_4C196F45 on PML_Country (countryName);
create index IX_DA792540 on PML_Country (description);

create index IX_88570760 on PML_FILETYPE (description);
create index IX_128135D9 on PML_FILETYPE (fieldId);
create index IX_3D91D363 on PML_FILETYPE (fileTypeCode);
create index IX_5686E658 on PML_FILETYPE (fileTypeCode, fileTypeName);
create index IX_4F95F081 on PML_FILETYPE (fileTypeName);
create index IX_D75327B6 on PML_FILETYPE (receiptTemplate);

create index IX_4A476C8F on PML_IDGENERATED (curvalue);
create index IX_2502809B on PML_IDGENERATED (year);
create index IX_B91244C0 on PML_IDGENERATED (year, curvalue);

create index IX_584A1DA1 on PML_IDTEMPLATE (description);
create index IX_9C8A9C16 on PML_IDTEMPLATE (format);
create index IX_80B4ACD6 on PML_IDTEMPLATE (format, description);

create index IX_2C1142E on PasswordPolicy (companyId, defaultPolicy);
create index IX_3FBFA9F4 on PasswordPolicy (companyId, name);

create index IX_C3A17327 on PasswordPolicyRel (classNameId, classPK);
create index IX_ED7CF243 on PasswordPolicyRel (passwordPolicyId, classNameId, classPK);

create index IX_326F75BD on PasswordTracker (userId);

create index IX_4D19C2B8 on Permission_ (actionId, resourceId);
create index IX_F090C113 on Permission_ (resourceId);

create index IX_9F704A14 on Phone (companyId);
create index IX_A2E4AFBA on Phone (companyId, classNameId);
create index IX_9A53569 on Phone (companyId, classNameId, classPK);
create index IX_812CE07A on Phone (companyId, classNameId, classPK, primary_);
create index IX_F202B9CE on Phone (userId);

create index IX_B9746445 on PluginSetting (companyId);
create index IX_7171B2E8 on PluginSetting (companyId, pluginId, pluginType);

create index IX_EC370F10 on PollsChoice (questionId);
create index IX_D76DD2CF on PollsChoice (questionId, name);
create index IX_6660B399 on PollsChoice (uuid_);

create index IX_9FF342EA on PollsQuestion (groupId);
create index IX_51F087F4 on PollsQuestion (uuid_);
create index IX_F3C9F36 on PollsQuestion (uuid_, groupId);

create index IX_D5DF7B54 on PollsVote (choiceId);
create index IX_12112599 on PollsVote (questionId);
create index IX_1BBFD4D3 on PollsVote (questionId, userId);

create index IX_80CC9508 on Portlet (companyId);
create index IX_12B5E51D on Portlet (companyId, portletId);

create index IX_96BDD537 on PortletItem (groupId, classNameId);
create index IX_D699243F on PortletItem (groupId, name, portletId, classNameId);
create index IX_2C61314E on PortletItem (groupId, portletId);
create index IX_E922D6C0 on PortletItem (groupId, portletId, classNameId);
create index IX_8E71167F on PortletItem (groupId, portletId, classNameId, name);
create index IX_33B8CE8D on PortletItem (groupId, portletId, name);

create index IX_E4F13E6E on PortletPreferences (ownerId, ownerType, plid);
create index IX_C7057FF7 on PortletPreferences (ownerId, ownerType, plid, portletId);
create index IX_F15C1C4F on PortletPreferences (plid);
create index IX_D340DB76 on PortletPreferences (plid, portletId);

create index IX_16184D57 on RatingsEntry (classNameId, classPK);
create index IX_B47E3C11 on RatingsEntry (userId, classNameId, classPK);

create index IX_A6E99284 on RatingsStats (classNameId, classPK);

create index IX_2D9A426F on Region (active_);
create index IX_16D87CA7 on Region (countryId);
create index IX_11FB3E42 on Region (countryId, active_);

create index IX_882E56F on ReportsEntry (companyId);
create index IX_C74E5453 on ReportsEntry (userId);

create index IX_717FDD47 on ResourceCode (companyId);
create index IX_A32C097E on ResourceCode (companyId, name, scope);
create index IX_AACAFF40 on ResourceCode (name);

create index IX_2578FBD3 on Resource_ (codeId);
create index IX_67DE7856 on Resource_ (codeId, primKey);

create index IX_449A10B9 on Role_ (companyId);
create index IX_A88E424E on Role_ (companyId, classNameId, classPK);
create index IX_EBC931B8 on Role_ (companyId, name);

create index LIFERAY_002 on Roles_Permissions (permissionId);

create index IX_C98C0D78 on SCFrameworkVersion (companyId);
create index IX_272991FA on SCFrameworkVersion (groupId);
create index IX_6E1764F on SCFrameworkVersion (groupId, active_);

create index IX_1C841592 on SCLicense (active_);
create index IX_5327BB79 on SCLicense (active_, recommended);

create index IX_5D25244F on SCProductEntry (companyId);
create index IX_72F87291 on SCProductEntry (groupId);
create index IX_98E6A9CB on SCProductEntry (groupId, userId);
create index IX_7311E812 on SCProductEntry (repoGroupId, repoArtifactId);

create index IX_AE8224CC on SCProductScreenshot (fullImageId);
create index IX_467956FD on SCProductScreenshot (productEntryId);
create index IX_DA913A55 on SCProductScreenshot (productEntryId, priority);
create index IX_6C572DAC on SCProductScreenshot (thumbnailId);

create index IX_7020130F on SCProductVersion (directDownloadURL);
create index IX_8377A211 on SCProductVersion (productEntryId);

create index IX_7338606F on ServiceComponent (buildNamespace);
create index IX_4F0315B8 on ServiceComponent (buildNamespace, buildNumber);

create index IX_C28B41DC on ShoppingCart (groupId);
create index IX_FC46FE16 on ShoppingCart (groupId, userId);
create index IX_54101CC8 on ShoppingCart (userId);

create index IX_5F615D3E on ShoppingCategory (groupId);
create index IX_1E6464F5 on ShoppingCategory (groupId, parentCategoryId);

create index IX_DC60CFAE on ShoppingCoupon (code_);
create index IX_3251AF16 on ShoppingCoupon (groupId);

create index IX_C8EACF2E on ShoppingItem (categoryId);
create index IX_1C717CA6 on ShoppingItem (companyId, sku);
create index IX_903DC750 on ShoppingItem (largeImageId);
create index IX_D217AB30 on ShoppingItem (mediumImageId);
create index IX_FF203304 on ShoppingItem (smallImageId);

create index IX_6D5F9B87 on ShoppingItemField (itemId);

create index IX_EA6FD516 on ShoppingItemPrice (itemId);

create index IX_1D15553E on ShoppingOrder (groupId);
create index IX_119B5630 on ShoppingOrder (groupId, userId, ppPaymentStatus);
create index IX_D7D6E87A on ShoppingOrder (number_);
create index IX_F474FD89 on ShoppingOrder (ppTxnId);

create index IX_B5F82C7A on ShoppingOrderItem (orderId);

create index IX_82E39A0C on SocialActivity (classNameId);
create index IX_A853C757 on SocialActivity (classNameId, classPK);
create index IX_64B1BC66 on SocialActivity (companyId);
create index IX_2A2468 on SocialActivity (groupId);
create index IX_8F32DEC9 on SocialActivity (groupId, userId, createDate, classNameId, classPK, type_, receiverUserId);
create index IX_1271F25F on SocialActivity (mirrorActivityId);
create index IX_1F00C374 on SocialActivity (mirrorActivityId, classNameId, classPK);
create index IX_121CA3CB on SocialActivity (receiverUserId);
create index IX_3504B8BC on SocialActivity (userId);

create index IX_61171E99 on SocialRelation (companyId);
create index IX_95135D1C on SocialRelation (companyId, type_);
create index IX_C31A64C6 on SocialRelation (type_);
create index IX_5A40CDCC on SocialRelation (userId1);
create index IX_4B52BE89 on SocialRelation (userId1, type_);
create index IX_12A92145 on SocialRelation (userId1, userId2, type_);
create index IX_5A40D18D on SocialRelation (userId2);
create index IX_3F9C2FA8 on SocialRelation (userId2, type_);
create index IX_F0CA24A5 on SocialRelation (uuid_);

create index IX_A90FE5A0 on SocialRequest (companyId);
create index IX_32292ED1 on SocialRequest (receiverUserId);
create index IX_D9380CB7 on SocialRequest (receiverUserId, status);
create index IX_80F7A9C2 on SocialRequest (userId);
create index IX_36A90CA7 on SocialRequest (userId, classNameId, classPK, type_, receiverUserId);
create index IX_F3BFB48D on SocialRequest (userId, classNameId, classPK, type_, receiverUserId, status);
create index IX_CC86A444 on SocialRequest (userId, classNameId, classPK, type_, status);
create index IX_AB5906A8 on SocialRequest (userId, status);
create index IX_49D5872C on SocialRequest (uuid_);
create index IX_4F973EFE on SocialRequest (uuid_, groupId);

create index IX_786D171A on Subscription (companyId, classNameId, classPK);
create index IX_2E1A92D4 on Subscription (companyId, userId, classNameId, classPK);
create index IX_54243AFD on Subscription (userId);

create index IX_1AB6D6D2 on TagsAsset (classNameId, classPK);
create index IX_AB3D8BCB on TagsAsset (companyId);

create index IX_10563688 on TagsEntry (companyId, name);

create index IX_C134234 on TagsProperty (companyId);
create index IX_EB974D08 on TagsProperty (companyId, key_);
create index IX_5200A629 on TagsProperty (entryId);
create index IX_F505253D on TagsProperty (entryId, key_);

create index IX_181A4A1B on TasksProposal (classNameId, classPK);
create index IX_7FB27324 on TasksProposal (groupId);
create index IX_6EEC675E on TasksProposal (groupId, userId);

create index IX_4D0C7F8D on TasksReview (proposalId);
create index IX_70AFEA01 on TasksReview (proposalId, stage);
create index IX_1894B29A on TasksReview (proposalId, stage, completed);
create index IX_41AFC20C on TasksReview (proposalId, stage, completed, rejected);
create index IX_36F512E6 on TasksReview (userId);
create index IX_5C6BE4C7 on TasksReview (userId, proposalId);

create index IX_524FEFCE on UserGroup (companyId);
create index IX_23EAD0D on UserGroup (companyId, name);
create index IX_69771487 on UserGroup (companyId, parentUserGroupId);

create index IX_1B988D7A on UserGroupRole (groupId);
create index IX_871412DF on UserGroupRole (groupId, roleId);
create index IX_887A2C95 on UserGroupRole (roleId);
create index IX_887BE56A on UserGroupRole (userId);
create index IX_4D040680 on UserGroupRole (userId, groupId);

create index IX_41A32E0D on UserIdMapper (type_, externalUserId);
create index IX_E60EA987 on UserIdMapper (userId);
create index IX_D1C44A6E on UserIdMapper (userId, type_);

create index IX_29BA1CF5 on UserTracker (companyId);
create index IX_46B0AE8E on UserTracker (sessionId);
create index IX_E4EFBA8D on UserTracker (userId);

create index IX_14D8BCC0 on UserTrackerPath (userTrackerId);

create index IX_3A1E834E on User_ (companyId);
create index IX_6EF03E4E on User_ (companyId, defaultUser);
create index IX_615E9F7A on User_ (companyId, emailAddress);
create index IX_765A87C6 on User_ (companyId, password_);
create index IX_C5806019 on User_ (companyId, screenName);
create index IX_9782AD88 on User_ (companyId, userId);
create index IX_5ADBE171 on User_ (contactId);
create index IX_762F63C6 on User_ (emailAddress);
create index IX_A9ED7DD3 on User_ (openId);
create index IX_A18034A4 on User_ (portraitId);
create index IX_E0422BDA on User_ (uuid_);

create index LIFERAY_003 on Users_Permissions (permissionId);

create index IX_97DFA146 on WebDAVProps (classNameId, classPK);

create index IX_96F07007 on Website (companyId);
create index IX_4F0F0CA7 on Website (companyId, classNameId);
create index IX_F960131C on Website (companyId, classNameId, classPK);
create index IX_1AA07A6D on Website (companyId, classNameId, classPK, primary_);
create index IX_F75690BB on Website (userId);

create index IX_5D6FE3F0 on WikiNode (companyId);
create index IX_B480A672 on WikiNode (groupId);
create index IX_920CD8B1 on WikiNode (groupId, name);
create index IX_6C112D7C on WikiNode (uuid_);
create index IX_7609B2AE on WikiNode (uuid_, groupId);

create index IX_A2001730 on WikiPage (format);
create index IX_C8A9C476 on WikiPage (nodeId);
create index IX_E7F635CA on WikiPage (nodeId, head);
create index IX_65E84AF4 on WikiPage (nodeId, head, parentTitle);
create index IX_46EEF3C8 on WikiPage (nodeId, parentTitle);
create index IX_1ECC7656 on WikiPage (nodeId, redirectTitle);
create index IX_997EEDD2 on WikiPage (nodeId, title);
create index IX_E745EA26 on WikiPage (nodeId, title, head);
create index IX_3D4AF476 on WikiPage (nodeId, title, version);
create index IX_9C0E478F on WikiPage (uuid_);

create index IX_21277664 on WikiPageResource (nodeId, title);

create index IX_2A105741 on holiday_calendar (holidayCalendarTitle);

create index IX_2FEAD0BC on pml_Receiver (userId, receiverType);
create index IX_A43BE445 on pml_Receiver (userId, receiverUserId, receiverType);
create index IX_F4C2DEF5 on pml_Receiver (userId, receiverUserName, receiverType);
create index IX_506889AC on pml_Receiver (userName, receiverType);
create index IX_E189BD35 on pml_Receiver (userName, receiverUserId, receiverType);
create index IX_15FE3BE5 on pml_Receiver (userName, receiverUserName, receiverType);

create index IX_B2593D80 on pml_ReceiverGroup (userId);
create index IX_8D936189 on pml_ReceiverGroup (userId, active_);
create index IX_68769EB on pml_ReceiverGroup (userId, receiverGroupName);
create index IX_D502FC55 on pml_ReceiverGroup (userId, type_);
create index IX_1C1A8254 on pml_ReceiverGroup (userId, type_, active_);
create index IX_897D5E30 on pml_ReceiverGroup (userName);
create index IX_9F9106D9 on pml_ReceiverGroup (userName, active_);
create index IX_FDC9B5A5 on pml_ReceiverGroup (userName, type_);

create index IX_94534BCC on pml_Reciever (userId, recieverType);
create index IX_635945DD on pml_Reciever (userId, recieverUserId, recieverType);
create index IX_4935BC8D on pml_Reciever (userId, recieverUserName, recieverType);
create index IX_23C602BC on pml_Reciever (userName, recieverType);
create index IX_31E01CCD on pml_Reciever (userName, recieverUserId, recieverType);
create index IX_9162977D on pml_Reciever (userName, recieverUserName, recieverType);

create index IX_1A370FF8 on pml_RecieverGroup (userId);
create index IX_6F8ED611 on pml_RecieverGroup (userId, active_);
create index IX_C41AA2EB on pml_RecieverGroup (userId, recieverGroupName);
create index IX_B2E1F2DD on pml_RecieverGroup (userId, type_);
create index IX_51B464CC on pml_RecieverGroup (userId, type_, active_);
create index IX_713072A8 on pml_RecieverGroup (userName);
create index IX_F0817961 on pml_RecieverGroup (userName, active_);
create index IX_DFC52A2D on pml_RecieverGroup (userName, type_);

create index IX_F88C2FA1 on pml_agency (agencycode);
create index IX_F036A8A7 on pml_agency (agencycode, agencyname, description);
create index IX_A904CBF on pml_agency (agencyname);
create index IX_64EE6A51 on pml_agency (description);

create index IX_B1E9DBB8 on pml_agencyleader (agencyId);
create index IX_39E841FE on pml_agencyleader (userId);

create index IX_DAEDA857 on pml_attachedfile (attachedfilecode);
create index IX_3B085E76 on pml_attachedfile (attachedfilecode, attachedfilename, description);
create index IX_ECF1C575 on pml_attachedfile (attachedfilename);
create index IX_3648AFD6 on pml_attachedfile (description);

create index IX_BD1C5906 on pml_car_resource (carCode, companyId);
create index IX_BB4C3AF9 on pml_car_resource (companyId);

create index IX_8A35C013 on pml_career (careercode);
create index IX_5E23A45C on pml_career (careercode, careername, description);
create index IX_9C39DD31 on pml_career (careername);
create index IX_F31FDB8 on pml_career (description);

create index IX_923002F7 on pml_chi_tiet_hscv (id_cong_van_den);
create index IX_C2A6BC7F on pml_chi_tiet_hscv (id_cong_van_di);
create index IX_F7D3D244 on pml_chi_tiet_hscv (id_ho_so_cong_viec);
create index IX_1B406F27 on pml_chi_tiet_hscv (id_ho_so_cong_viec, id_cong_van_den);
create index IX_7CC00A4F on pml_chi_tiet_hscv (id_ho_so_cong_viec, id_cong_van_di);

create index IX_3461E29B on pml_city (active);
create index IX_FDA6104D on pml_city (cityCode);
create index IX_3FA09675 on pml_city (cityCode, cityName, description);
create index IX_FAA2D6B on pml_city (cityName);
create index IX_B4C69D60 on pml_city (countryid);
create index IX_FDD6E82B on pml_city (description);

create index IX_B0F6ED33 on pml_conf_phongban_hscv (departmentsId);

create index IX_5C17FC4B on pml_delegate (assigner);
create index IX_99BC9FAE on pml_delegate (assigner, receiver);
create index IX_771BE1E7 on pml_delegate (assigner, receiver, startdate, enddate);
create index IX_200281EE on pml_delegate (canceldelegate);
create index IX_45A908CF on pml_delegate (datecreated);
create index IX_2B691F9E on pml_delegate (receiver);
create index IX_1DD7D351 on pml_delegate (receiver, canceldelegate);
create index IX_A14C32B1 on pml_delegate (receiver, startdate, canceldate, canceldelegate);
create index IX_2BF909D7 on pml_delegate (receiver, startdate, enddate);
create index IX_5B262B8A on pml_delegate (receiver, startdate, enddate, canceldelegate);

create index IX_448EF07B on pml_departmentleader (clericalid);
create index IX_D88249DB on pml_departmentleader (departmentsId);
create index IX_39C00108 on pml_departmentleader (departmentsId, main);
create index IX_BA719715 on pml_departmentleader (departmentsId, userId);
create index IX_4DBA96BE on pml_departmentleader (main);
create index IX_BA1D974B on pml_departmentleader (userId);

create index IX_F958ACE1 on pml_departments (abbreviatename);
create index IX_CC20E6B1 on pml_departments (active);
create index IX_6B9E2EEB on pml_departments (agencyId);
create index IX_6BACBACB on pml_departments (agencyid);
create index IX_14823E3F on pml_departments (departmentsParentId);
create index IX_8D4EA2A7 on pml_departments (departmentscode);
create index IX_9EEF10DB on pml_departments (departmentscode, agencyId);
create index IX_9EFD9CBB on pml_departments (departmentscode, agencyid);
create index IX_63A5BF8D on pml_departments (departmentscode, departmentsname, abbreviatename, description);
create index IX_A696C777 on pml_departments (departmentscode, departmentsname, description);
create index IX_9F52BFC5 on pml_departments (departmentsname);
create index IX_9DBEEDFF on pml_departments (departmentsparentid);
create index IX_5E6501D5 on pml_departments (description);
create index IX_D3074E90 on pml_departments (hasteam);
create index IX_1EFA98FC on pml_departments (roleid);

create index IX_57BED4FE on pml_district (active);
create index IX_65B319BE on pml_district (cityID);
create index IX_31B0FBA8 on pml_district (description);
create index IX_1A5F56D3 on pml_district (districtCode);
create index IX_E7D49132 on pml_district (districtCode, districtName, cityID, description);
create index IX_2C6373F1 on pml_district (districtName);

create index IX_7DDBAE38 on pml_do_quan_trong (ten_do_quan_trong);

create index IX_D48B8868 on pml_documentreceipt_issuingplace_log (documentReceiptId, processor, step);
create index IX_7CF5591A on pml_documentreceipt_issuingplace_log (documentReceiptId, step);

create index IX_61702019 on pml_documentreceipt_log (dateprocess);
create index IX_F2B17075 on pml_documentreceipt_log (departmentprocess);
create index IX_C34DE10 on pml_documentreceipt_log (departmentprocessid);
create index IX_5DA377E9 on pml_documentreceipt_log (departmentreceive);
create index IX_82C2D884 on pml_documentreceipt_log (departmentreceiveid);
create index IX_9AC1A170 on pml_documentreceipt_log (documentreceiptid);
create index IX_F13EA49C on pml_documentreceipt_log (documentreceiptid, processer);
create index IX_60F6FFCE on pml_documentreceipt_log (documentreceiptid, processer, receivedate, stateprocessidafter);
create index IX_51D1F577 on pml_documentreceipt_log (documentreceiptid, processer, stateprocessidafter);
create index IX_B32A8F5C on pml_documentreceipt_log (documentreceiptid, processer, step);
create index IX_4569DA93 on pml_documentreceipt_log (documentreceiptid, receiver);
create index IX_5130EFE0 on pml_documentreceipt_log (documentreceiptid, receiver, stateprocessidafter);
create index IX_D3E3577A on pml_documentreceipt_log (documentreceiptid, receiver, stateprocessidafter, transition_);
create index IX_402827C on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore);
create index IX_BEAAE410 on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore, processer);
create index IX_1A7DDC9F on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore, receiver);
create index IX_24299D30 on pml_documentreceipt_log (documentreceiptid, step);
create index IX_F97BAFEA on pml_documentreceipt_log (documentreceiptid, transition_);
create index IX_5BF8A5E2 on pml_documentreceipt_log (documentreceiptid, transition_, processer);
create index IX_9F0F4A65 on pml_documentreceipt_log (documentreceiptid, type_);
create index IX_1C2DC0EB on pml_documentreceipt_log (expireddate);
create index IX_5B3152F7 on pml_documentreceipt_log (maindepartmentprocessid);
create index IX_189C629E on pml_documentreceipt_log (mainuserprocessid);
create index IX_BE581447 on pml_documentreceipt_log (numdateprocess);
create index IX_EB41C334 on pml_documentreceipt_log (processer);
create index IX_8A503D37 on pml_documentreceipt_log (processinstanceid);
create index IX_1DCAA8B5 on pml_documentreceipt_log (processinstanceid, stateprocessidafter, dateprocess);
create index IX_990CD0CE on pml_documentreceipt_log (processinstanceid, stateprocessidbefore, dateprocess);
create index IX_C9F630BE on pml_documentreceipt_log (processinstanceid, type_);
create index IX_2A554629 on pml_documentreceipt_log (receivedate);
create index IX_55BC88FB on pml_documentreceipt_log (receiver);
create index IX_DC6AC441 on pml_documentreceipt_log (senddatebefore);
create index IX_DF02C5BB on pml_documentreceipt_log (stateprocessidafter);
create index IX_1CFAD4E4 on pml_documentreceipt_log (stateprocessidbefore);
create index IX_B5D974FD on pml_documentreceipt_log (type_);

create index IX_F9949A1 on pml_documentreceipt_wf (documentreceiptid);
create index IX_813F3D38 on pml_documentreceipt_wf (documentreceiptid, ismain);

create index IX_BF3D5193 on pml_documentsend_log (dateprocess);
create index IX_EDDF58A on pml_documentsend_log (departmentprocessid);
create index IX_856BEFFE on pml_documentsend_log (departmentreceiveid);
create index IX_95446B90 on pml_documentsend_log (documentsendid);
create index IX_D42E467C on pml_documentsend_log (documentsendid, processer);
create index IX_166629AE on pml_documentsend_log (documentsendid, processer, receivedate, stateprocessidafter);
create index IX_B9A43F97 on pml_documentsend_log (documentsendid, processer, stateprocessidafter);
create index IX_7B91493C on pml_documentsend_log (documentsendid, processer, step);
create index IX_970E7CB3 on pml_documentsend_log (documentsendid, receiver);
create index IX_BA24F49C on pml_documentsend_log (documentsendid, stateprocessidbefore);
create index IX_825026BF on pml_documentsend_log (documentsendid, stateprocessidbefore, receiver);
create index IX_FCB44F50 on pml_documentsend_log (documentsendid, step);
create index IX_DF0A59CA on pml_documentsend_log (documentsendid, transition_);
create index IX_79FAF265 on pml_documentsend_log (expireddate);
create index IX_87E8B88D on pml_documentsend_log (numdateprocess);
create index IX_6BC10B2E on pml_documentsend_log (processer);
create index IX_9727582F on pml_documentsend_log (processinstanceid, stateprocessidafter, dateprocess);
create index IX_4B461094 on pml_documentsend_log (processinstanceid, stateprocessidbefore, dateprocess);
create index IX_882277A3 on pml_documentsend_log (receivedate);
create index IX_309759C1 on pml_documentsend_log (receiver);
create index IX_A5FB6887 on pml_documentsend_log (senddatebefore);
create index IX_E1ABDD35 on pml_documentsend_log (stateprocessidafter);
create index IX_6F74ACAA on pml_documentsend_log (stateprocessidbefore);

create index IX_EF559A19 on pml_documentsend_wf (processid);

create index IX_DF61BFE8 on pml_edm_answerdetail (documentsendid);

create index IX_9A5F97E6 on pml_edm_attachedfile (attachedfilename);
create index IX_9AA1EC3 on pml_edm_attachedfile (datecreated);
create index IX_BC68EC12 on pml_edm_attachedfile (fileid);
create index IX_59EC5531 on pml_edm_attachedfile (filetype);
create index IX_38A173FE on pml_edm_attachedfile (objectcontentid);
create index IX_3B07BA2B on pml_edm_attachedfile (objectcontentid, objecttype);
create index IX_AC46B6B4 on pml_edm_attachedfile (objectcontentid, objecttype, displayorhidden);
create index IX_F431D674 on pml_edm_attachedfile (objecttype);
create index IX_45D87F60 on pml_edm_attachedfile (path);

create index IX_B6759412 on pml_edm_bookdocumentrecordto (datecomplete);
create index IX_AA87ECD5 on pml_edm_bookdocumentrecordto (datecreate);
create index IX_3104DFB1 on pml_edm_bookdocumentrecordto (documentreceiptid);
create index IX_896B2527 on pml_edm_bookdocumentrecordto (documentreceiptid, documentrecordtoid);
create index IX_E6BAE7AD on pml_edm_bookdocumentrecordto (documentrecordtoid);

create index IX_C213CCC7 on pml_edm_bookdocumentsend (agencyid);
create index IX_6951E23A on pml_edm_bookdocumentsend (agencyid, departmentsid, documentrecordtypeid);
create index IX_C2147AA3 on pml_edm_bookdocumentsend (agencyid, yearinuse, documentrecordtypeid);
create index IX_B3B1DB27 on pml_edm_bookdocumentsend (currentrecord);
create index IX_12A9A257 on pml_edm_bookdocumentsend (datecreated);
create index IX_7E34CBD9 on pml_edm_bookdocumentsend (departmentsid);
create index IX_DB1A8728 on pml_edm_bookdocumentsend (documentrecordtypeid);
create index IX_217A93FC on pml_edm_bookdocumentsend (documentrecordtypeid, agencyid);
create index IX_BD633DC4 on pml_edm_bookdocumentsend (documentrecordtypeid, departmentsid);
create index IX_5C6A0756 on pml_edm_bookdocumentsend (yearinuse, agencyid);
create index IX_D6B7D2AA on pml_edm_bookdocumentsend (yearinuse, departmentsid);
create index IX_79A204DF on pml_edm_bookdocumentsend (yearinuse, departmentsid, documentrecordtypeid);

create index IX_CE3025EE on pml_edm_cadre (departmentsid);
create index IX_EA107351 on pml_edm_cadre (handphone);
create index IX_393FE4B6 on pml_edm_cadre (positionid);

create index IX_F30AEFD6 on pml_edm_confidentiallevel (confidentiallevelname);

create index IX_8A4FDF66 on pml_edm_docconfuser (userId);

create index IX_F635B970 on pml_edm_documentdelegate (userIsDelegateId);

create index IX_6C706605 on pml_edm_documentreceipt (confidentiallevelid);
create index IX_A5806B65 on pml_edm_documentreceipt (docreceipttempid);
create index IX_F7702835 on pml_edm_documentreceipt (docreceipttempid, orgexternalid);
create index IX_195C7CCB on pml_edm_documentreceipt (documenttype);
create index IX_344E2CE6 on pml_edm_documentreceipt (documenttypeid);
create index IX_F4D3AF82 on pml_edm_documentreceipt (issuingplaceid);
create index IX_44318C15 on pml_edm_documentreceipt (levelsendid);
create index IX_5095AB4D on pml_edm_documentreceipt (maindepartmentprocessid);
create index IX_A4E73374 on pml_edm_documentreceipt (mainuserprocessid);
create index IX_FE328031 on pml_edm_documentreceipt (numberlocaldocumentreceipt);
create index IX_1C937938 on pml_edm_documentreceipt (orgexternalid);
create index IX_7D644D84 on pml_edm_documentreceipt (privilegelevelid);
create index IX_41D2A81C on pml_edm_documentreceipt (socongvandiphucdap);
create index IX_FF31DE83 on pml_edm_documentreceipt (statusid);

create index IX_8ABCB96A on pml_edm_documentreceipt_temp (confidentiallevelid);
create index IX_4B990106 on pml_edm_documentreceipt_temp (documenttype);
create index IX_C97A8E61 on pml_edm_documentreceipt_temp (documenttypeid);
create index IX_8A0010FD on pml_edm_documentreceipt_temp (issuingplaceid);
create index IX_1C86147A on pml_edm_documentreceipt_temp (levelsendid);
create index IX_FC432 on pml_edm_documentreceipt_temp (maindepartmentprocessid);
create index IX_1C8B1C19 on pml_edm_documentreceipt_temp (mainuserprocessid);
create index IX_BA18BC33 on pml_edm_documentreceipt_temp (numberdocumentreceipt, orgexternalid);
create index IX_6FC9812C on pml_edm_documentreceipt_temp (numberlocaldocumentreceipt);
create index IX_31E77C5D on pml_edm_documentreceipt_temp (orgexternalid);
create index IX_78FE3C3F on pml_edm_documentreceipt_temp (privilegelevelid);
create index IX_BEABD417 on pml_edm_documentreceipt_temp (socongvandiphucdap);
create index IX_FFB7B83E on pml_edm_documentreceipt_temp (statusid);

create index IX_3CFED46C on pml_edm_documentreceiptextend (documentreceiptid);

create index IX_26138E35 on pml_edm_documentreceiptprocesstype (documentReceiptId);

create index IX_38A6EC62 on pml_edm_documentrecordto (agencyid);
create index IX_909AF77F on pml_edm_documentrecordto (agencyid, departmentsid, documentrecordtypeid);
create index IX_59EE8497 on pml_edm_documentrecordto (agencyid, documentrecordtypeid);
create index IX_84DCFA68 on pml_edm_documentrecordto (agencyid, yearinuse, documentrecordtypeid);
create index IX_4FB9446C on pml_edm_documentrecordto (currentrecord);
create index IX_E515482C on pml_edm_documentrecordto (datecreate);
create index IX_1A3C351E on pml_edm_documentrecordto (departmentsid);
create index IX_544C1643 on pml_edm_documentrecordto (documentrecordtypeid);
create index IX_5643D57 on pml_edm_documentrecordto (documentrecordtypeid, agencyid);
create index IX_E1643549 on pml_edm_documentrecordto (documentrecordtypeid, departmentsid);
create index IX_62D856C7 on pml_edm_documentrecordto (yearinuse);
create index IX_478CA8DB on pml_edm_documentrecordto (yearinuse, agencyid);
create index IX_30065C45 on pml_edm_documentrecordto (yearinuse, departmentsid);
create index IX_3B7B983A on pml_edm_documentrecordto (yearinuse, departmentsid, documentrecordtypeid);

create index IX_ACE905D4 on pml_edm_documentrecordtype (documentrecordtypecode);
create index IX_BEED22F2 on pml_edm_documentrecordtype (documentrecordtypename);

create index IX_E0C0939E on pml_edm_documentrelation (docleftid, docrightid, leftisreceipt, rightisreceipt);
create index IX_2FABC48B on pml_edm_documentrelation (docleftid, leftisreceipt);
create index IX_ED893A57 on pml_edm_documentrelation (docrightid, rightisreceipt);

create index IX_96281CBD on pml_edm_documentsend (confidentiallevelid);
create index IX_7FB46F6 on pml_edm_documentsend (documentreference);
create index IX_ABCFC10E on pml_edm_documentsend (documentsendcode);
create index IX_665D232E on pml_edm_documentsend (documenttypeid);
create index IX_609C46C6 on pml_edm_documentsend (editorid);
create index IX_468C1E97 on pml_edm_documentsend (iscongvanphucdap);
create index IX_1D01FC6A on pml_edm_documentsend (issuingdate);
create index IX_348309D6 on pml_edm_documentsend (numberpage);
create index IX_1C0C48C on pml_edm_documentsend (numberpublish);
create index IX_FD2899F0 on pml_edm_documentsend (orgexternalid);
create index IX_E564F13C on pml_edm_documentsend (position_);
create index IX_678ED1CC on pml_edm_documentsend (privilegelevelid);
create index IX_F6373734 on pml_edm_documentsend (senddate);
create index IX_83BE6E03 on pml_edm_documentsend (signerid);
create index IX_965879F3 on pml_edm_documentsend (signername);
create index IX_CC292ACB on pml_edm_documentsend (statusid);

create index IX_35C5C011 on pml_edm_documenttype (HaveDepartExtends);
create index IX_FC3F0EF1 on pml_edm_documenttype (documentrecordtypeid);
create index IX_189CF563 on pml_edm_documenttype (documentsymbol);
create index IX_2DA48310 on pml_edm_documenttype (documenttypename);
create index IX_CA49CA8C on pml_edm_documenttype (sendreceiptdistinction);

create index IX_7506C14C on pml_edm_issuingplace (address);
create index IX_E2A13874 on pml_edm_issuingplace (email);
create index IX_D322EF77 on pml_edm_issuingplace (handphone);
create index IX_51947C2A on pml_edm_issuingplace (issuingplacecode);
create index IX_63989948 on pml_edm_issuingplace (issuingplacename);
create index IX_40E6F8AC on pml_edm_issuingplace (tablephone);

create index IX_6B1386B8 on pml_edm_levelsend (levelsendcode);
create index IX_7D17A3D6 on pml_edm_levelsend (levelsendname);

create index IX_96C78722 on pml_edm_levelsenddetail (issuingPlaceId);
create index IX_A510EC75 on pml_edm_levelsenddetail (levelsendid);
create index IX_6FFCD535 on pml_edm_levelsenddetail (levelsendid, issuingPlaceId);

create index IX_55886F8C on pml_edm_privilegelevel (privilegelevelname);

create index IX_707D1D62 on pml_edm_processdocumentreceiptdetail (documentreceiptid);
create index IX_F222C540 on pml_edm_processdocumentreceiptdetail (userid);

create index IX_F963C762 on pml_edm_writedocumentsend (bookdocumentsendid);
create index IX_438BB903 on pml_edm_writedocumentsend (datecreated);
create index IX_34A68AF9 on pml_edm_writedocumentsend (documentsendid);

create index IX_15C023FC on pml_field (departmentsId);
create index IX_4483E71C on pml_field (description);
create index IX_C99E25E7 on pml_field (fieldCode);
create index IX_4D7208CE on pml_field (fieldCode, fieldName);
create index IX_DBA24305 on pml_field (fieldName);

create index IX_596B556B on pml_file (applicantName);
create index IX_D45EFE9C on pml_file (applicationDate);
create index IX_4D50D500 on pml_file (authorisedLetter);
create index IX_A972ABD8 on pml_file (dateCreated);
create index IX_5351F437 on pml_file (fileTypeId);
create index IX_5F9DE377 on pml_file (fileTypeId, applicationDate);
create index IX_E3AD19AC on pml_file (fileTypeId, exactReturningDate);
create index IX_A4791A88 on pml_file (fileTypeId, numberReceipt);
create index IX_B02ADD59 on pml_file (organization);
create index IX_38EB14CC on pml_file (permanentAddress);

create index IX_61D51B08 on pml_file_attachedfile (attachedFileId);
create index IX_4977F9B8 on pml_file_attachedfile (attachedFileName);
create index IX_56516844 on pml_file_attachedfile (fileId);

create index IX_71CC95A4 on pml_file_pccc (applicantcategory);
create index IX_41FD1EE7 on pml_file_pccc (fileName);
create index IX_F0267148 on pml_file_pccc (projectname);
create index IX_AACDDDA2 on pml_file_pccc (receiveofunit);

create index IX_84D37C45 on pml_filepccc_attachedfile (attachedfilename);
create index IX_2D22BB04 on pml_filepccc_attachedfile (datecreated);
create index IX_582E144 on pml_filepccc_attachedfile (filepcccid);
create index IX_C0016E71 on pml_filepccc_attachedfile (filepcccid, objecttype);
create index IX_665E0890 on pml_filepccc_attachedfile (filetype);
create index IX_AB042E13 on pml_filepccc_attachedfile (objecttype);
create index IX_40B0BA3F on pml_filepccc_attachedfile (path);

create index IX_1D541E7E on pml_filereturninginfo (billnumber);
create index IX_6C028719 on pml_filereturninginfo (conclude);
create index IX_18347992 on pml_filereturninginfo (documentnumber);
create index IX_31A6CC45 on pml_filereturninginfo (fileid);
create index IX_674A1FCA on pml_filereturninginfo (fileid, filereturninginfoid);
create index IX_E90EDEDF on pml_filereturninginfo (filesender);
create index IX_415DBCEB on pml_filereturninginfo (issuingdatelicense);
create index IX_870F0CC0 on pml_filereturninginfo (licensenumber);
create index IX_62C25CE0 on pml_filereturninginfo (note);
create index IX_CA4BAECD on pml_filereturninginfo (numbermoney);
create index IX_4B4BAA1A on pml_filereturninginfo (receivelicensedate);

create index IX_5935E6C8 on pml_filestatus (description);
create index IX_22A22EF3 on pml_filestatus (filestatuscode);
create index IX_267CE161 on pml_filestatus (filestatuscode, type);
create index IX_34A64C11 on pml_filestatus (filestatusname);
create index IX_8037DA92 on pml_filestatus (type);

create index IX_1AB3D3C2 on pml_filestatus_stateprocess (filestatusid);
create index IX_CC0394F on pml_filestatus_stateprocess (filestatusid, stateprocessid);
create index IX_46DF2252 on pml_filestatus_stateprocess (stateprocessid);

create index IX_A0F11380 on pml_filetype (description);
create index IX_894651F9 on pml_filetype (fieldId);
create index IX_38394B43 on pml_filetype (fileTypeCode);
create index IX_BF4F1638 on pml_filetype (fileTypeCode, fileTypeName);
create index IX_4A3D6861 on pml_filetype (fileTypeName);
create index IX_BDCA23D6 on pml_filetype (receiptTemplate);

create index IX_3F989A8E on pml_filetype_attachedfile (attachedFileId);
create index IX_C459AFBE on pml_filetype_attachedfile (attachedFileName);
create index IX_685D30A4 on pml_filetype_attachedfile (attachedFileName, note);
create index IX_8EEEF5BD on pml_filetype_attachedfile (attachedFileName, original, copy_, note);
create index IX_16CE77B on pml_filetype_attachedfile (copy_);
create index IX_1D1C5FC0 on pml_filetype_attachedfile (copy_, fileTypeId);
create index IX_A8123DA4 on pml_filetype_attachedfile (fileTypeId);
create index IX_C87FFF85 on pml_filetype_attachedfile (note);
create index IX_7969B8CA on pml_filetype_attachedfile (note, fileTypeId);
create index IX_96238524 on pml_filetype_attachedfile (original);
create index IX_204EC7E9 on pml_filetype_attachedfile (original, fileTypeId);

create index IX_EEEA49C5 on pml_filetypedelegate (delegateid);
create index IX_8711D276 on pml_filetypedelegate (filetypeid);
create index IX_4F36494A on pml_filetypedelegate (filetypeid, delegateid);

create index IX_22B22256 on pml_ho_so_cong_viec (id_do_quan_trong);
create index IX_4B004359 on pml_ho_so_cong_viec (id_hscv_cha);
create index IX_E4A110BA on pml_ho_so_cong_viec (id_linh_vuc);
create index IX_3583860E on pml_ho_so_cong_viec (id_tinh_chat);
create index IX_F5AC1C84 on pml_ho_so_cong_viec (id_trang_thai_hscv);
create index IX_6641DAF3 on pml_ho_so_cong_viec (so_hieu_hscv);
create index IX_8CAC1550 on pml_ho_so_cong_viec (userId);

create index IX_6FE7F965 on pml_holiday (from_date);
create index IX_DA2F71DD on pml_holiday (from_date, to_date);
create index IX_BE96F7E3 on pml_holiday (holiday_type);
create index IX_B000EB7 on pml_holiday (holiday_type, holiday_value);
create index IX_54EFF34C on pml_holiday (holiday_value);
create index IX_AC2C1974 on pml_holiday (to_date);

create index IX_B6A8CE01 on pml_main_support (processid_main);
create index IX_2B8908B4 on pml_main_support (processid_main, type_);
create index IX_3DADA2F6 on pml_main_support (supportinfomation);
create index IX_B29867F6 on pml_main_support (type_);

create index IX_2070F48B on pml_manage_documentworkflow (type_);
create index IX_55510545 on pml_manage_documentworkflow (version_);
create index IX_56BF56C8 on pml_manage_documentworkflow (workflowname);

create index IX_D3C8915E on pml_message_note (createDate);
create index IX_3B0D672A on pml_message_note (documentId);
create index IX_5187B7B on pml_message_note (documentId, fromUserId, objectType);
create index IX_F26FDBA4 on pml_message_note (fromUserId);
create index IX_CC62AA2E on pml_message_note (fromUserId, documentId);
create index IX_BFE701F5 on pml_message_note (toUserId);

create index IX_9E1C1904 on pml_nation (countryid);
create index IX_E7BC0ACF on pml_nation (description);
create index IX_7BB3C125 on pml_nation (nationcode);
create index IX_AD004521 on pml_nation (nationcode, nationname, description);
create index IX_B64C62E0 on pml_nation (nationcode, nationname, description, countryid);
create index IX_8DB7DE43 on pml_nation (nationname);

create index IX_3DC4D7DC on pml_organization_external (isownerorg);
create index IX_DC4571BF on pml_organization_external (orgexternalcode);
create index IX_EE498EDD on pml_organization_external (orgexternalname);

create index IX_1A4A0D1A on pml_paintdocument (fileid);
create index IX_9AF230CE on pml_paintdocument (quantity);

create index IX_F9124CAD on pml_position (description);
create index IX_C722BFA9 on pml_position (positioncode);
create index IX_40E870BB on pml_position (positioncode, positionname, description);
create index IX_D926DCC7 on pml_position (positionname);

create index IX_16BA87EB on pml_processdispose (dateprocess);
create index IX_5A6F9F0A on pml_processdispose (delegateuser);
create index IX_D17828BD on pml_processdispose (expireddate);
create index IX_86178411 on pml_processdispose (fileid);
create index IX_ACA8C122 on pml_processdispose (fileid, stateprocessidafter);
create index IX_414465D on pml_processdispose (fileid, stateprocessidbefore);
create index IX_B8C0DAE9 on pml_processdispose (fileid, transition_);
create index IX_947F786 on pml_processdispose (processer);
create index IX_DF9FADFB on pml_processdispose (receivedate);
create index IX_DAD58269 on pml_processdispose (receiver);
create index IX_73C1DF0 on pml_processdispose (senddate);
create index IX_D3193B8D on pml_processdispose (stateprocessidafter);
create index IX_ABB31952 on pml_processdispose (stateprocessidbefore);
create index IX_347BF054 on pml_processdispose (transition_);

create index IX_6740CD8E on pml_processtype (flagprocesstype);
create index IX_6F02DFE on pml_processtype (name);

create index IX_8189A9C0 on pml_role (description);
create index IX_3EA90583 on pml_role (rolecode);
create index IX_5A584BB4 on pml_role (rolecode, rolename, description);
create index IX_50AD22A1 on pml_role (rolename);

create index IX_5B7B5B20 on pml_room_resource (companyId);
create index IX_9C76B966 on pml_room_resource (roomName, companyId);

create index IX_7C75D901 on pml_saveprocesstype (docId);
create index IX_2F8EFE4B on pml_saveprocesstype (flagprocesstype);

create index IX_4BE268DA on pml_signer (userId);

create index IX_D9BC27D7 on pml_state_department (departmentid);
create index IX_D57677B5 on pml_state_department (statewfid);

create index IX_923D54E6 on pml_state_wf (solvingtime);
create index IX_E95EB980 on pml_state_wf (stateprocessid);
create index IX_DDD4126 on pml_state_wf (workflow);
create index IX_FFD4EEAE on pml_state_wf (workflow, stateprocessid, version_);
create index IX_83F19D61 on pml_state_wf (workflow, version_);

create index IX_9225FC78 on pml_stateprocess (description);
create index IX_7608CFF1 on pml_stateprocess (filestatusid);
create index IX_75268613 on pml_stateprocess (stateprocesscode);
create index IX_D2E7C250 on pml_stateprocess (stateprocesscode, stateprocessname);
create index IX_872AA331 on pml_stateprocess (stateprocessname);

create index IX_C8F855DB on pml_street (streetName);

create index IX_81CDA715 on pml_team (companyid);
create index IX_5F105874 on pml_team (departmentid);
create index IX_4F4A1B2 on pml_team (departmentid, teamcode);
create index IX_F351D895 on pml_team (organizationid);
create index IX_8D369D91 on pml_team (teamcode);
create index IX_9F3ABAAF on pml_team (teamname);

create index IX_8A699036 on pml_teamleader (userid);

create index IX_9088E4B1 on pml_template (departmentId);

create index IX_723E8560 on pml_template_file (templateId);

create index IX_81341A38 on pml_tinh_chat (ten_tinh_chat);

create index IX_787D1D78 on pml_trang_thai_hscv (ten_trang_thai_hscv);

create index IX_39228010 on pml_transition (filetypeid);
create index IX_994CBFCB on pml_transition (filetypeid, version_);
create index IX_8BB21315 on pml_transition (notransition);
create index IX_20816340 on pml_transition (stateprocesscurrent);
create index IX_40267CB0 on pml_transition (stateprocessnext);
create index IX_D61160DF on pml_transition (transitionname);
create index IX_96AFFA06 on pml_transition (version_);

create index IX_4871D6EB on pml_user (departmentsId);
create index IX_6DFE34E5 on pml_user (departmentsId, active);
create index IX_4A13A6AE on pml_user (handphone);
create index IX_8EF417A7 on pml_user (note);
create index IX_D9949119 on pml_user (positionId);
create index IX_54858438 on pml_user (positionId, departmentsId, roleId);
create index IX_3439E366 on pml_user (roleId);
create index IX_E0B7E5AD on pml_user (teamid);

create index IX_25F95C64 on pml_user_file_type (filetypeid);
create index IX_82420779 on pml_user_file_type (userid);

create index IX_E695A0FF on pml_wards (description);
create index IX_A171A34A on pml_wards (districtId);
create index IX_D65D0747 on pml_wards (wardsCode);
create index IX_139E1304 on pml_wards (wardsCode, wardsName, districtId, description);
create index IX_E8612465 on pml_wards (wardsName);

create index IX_6F3C858B on pml_wf_onedoor (nodeId);
create index IX_30AE8040 on pml_wf_onedoor (processId);

create index IX_4C98D3A on pml_workflow (fileTypeId);
create index IX_5BD98D66 on pml_workflow (fileTypeId, startDate);
create index IX_4ACCE075 on pml_workflow (fileTypeId, version_);
create index IX_77A8AE63 on pml_workflow (workflow, version_);


