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

create table department (
	departmentId bigint not null primary key,
	departmentCode varchar(75) null,
	departmentName varchar(75) null,
	departmentDescription varchar(75) null,
	userId bigint,
	groupId bigint,
	companyId bigint
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
	numofdirector bool
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

create table pml_nation (
	nationid varchar(75) not null primary key,
	nationcode varchar(75) null,
	nationname varchar(75) null,
	countryid varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
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

create table pml_saveprocesstype (
	sptid bigint not null primary key,
	docId bigint,
	flagprocesstype bigint,
	flag bool
);

create table pml_signer (
	signerid bigint not null primary key,
	userid bigint
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
	birthday timestamp null
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
	resultWork varchar(75) null,
	programWork varchar(75) null,
	reportDate timestamp null,
	departmentId bigint,
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






insert into Company (companyId, accountId, webId, virtualHost, mx) values (1, 7, 'liferay.com', 'localhost', 'liferay.com');
insert into Account_ (accountId, companyId, userId, userName, createDate, modifiedDate, parentAccountId, name, legalName, legalId, legalType, sicCode, tickerSymbol, industry, type_, size_) values (7, 1, 5, '', current_timestamp, current_timestamp, 0, 'Liferay', 'Liferay, Inc.', '', '', '', '', '', '', '');


insert into ClassName_ (classNameId, value) values (8, 'com.liferay.portal.model.Organization');
insert into ClassName_ (classNameId, value) values (9, 'com.liferay.portal.model.User');


insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (10, 1, 0, 0, 'Administrator', '', 1);
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (11, 1, 0, 0, 'Guest', '', 1);
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (12, 1, 0, 0, 'Power User', '', 1);
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (13, 1, 0, 0, 'User', '', 1);


insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (14, 1, 5, 0, 0, 0, 0, 'Guest', '/guest', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (15, 1, 14, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (16, 1, 14, false, false, 'classic', '01', 0);


insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (17, 1, 0, 'Liferay, Inc.', false, true, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (18, 1, 5, 8, 17, 0, 0, '18', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (19, 1, 18, true, false, 'classic', '01', 1);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (20, 1, 18, false, false, 'classic', '01', 1);
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (21, 18, 1, false, 1, 0, '<?xml version="1.0"?>\n\n<root>\n  <name>Liferay, Inc. Extranet</name>\n</root>', 'portlet', 'layout-template-id=2_columns_ii\ncolumn-1=3,\ncolumn-2=19,', false, '', 0);
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (22, 18, 1, true, 1, 0, '<?xml version="1.0"?>\n\n<root>\n  <name>Liferay, Inc. Intranet</name>\n</root>', 'portlet', 'layout-template-id=2_columns_ii\ncolumn-1=3,\ncolumn-2=19,', false, '', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (23, 1, 17, 'Liferay Engineering', false, true, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (24, 1, 5, 8, 23, 0, 0, '24', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (25, 1, 24, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (26, 1, 24, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (27, 1, 17, 'Liferay Consulting', false, true, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (28, 1, 5, 8, 27, 0, 0, '28', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (29, 1, 28, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (30, 1, 28, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (31, 1, 17, 'Liferay Support', false, true, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (32, 1, 5, 8, 31, 0, 0, '32', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (33, 1, 32, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (34, 1, 32, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (35, 1, 17, 'Liferay Sales', false, true, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (36, 1, 5, 8, 35, 0, 0, '36', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (37, 1, 36, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (38, 1, 36, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (39, 1, 17, 'Liferay Marketing', false, true, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (40, 1, 5, 8, 39, 0, 0, '40', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (41, 1, 40, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (42, 1, 40, false, false, 'classic', '01', 0);


insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (43, 1, 17, 'Liferay Los Angeles', true, false, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (44, 1, 5, 8, 43, 0, 0, '44', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (45, 1, 44, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (46, 1, 44, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (47, 1, 17, 'Liferay San Francisco', true, false, 5, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (48, 1, 5, 8, 47, 0, 0, '48', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (49, 1, 48, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (50, 1, 48, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (51, 1, 17, 'Liferay Chicago', true, false, 14, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (52, 1, 5, 8, 51, 0, 0, '52', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (53, 1, 52, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (54, 1, 52, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (55, 1, 17, 'Liferay New York', true, false, 33, 19, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (56, 1, 5, 8, 55, 0, 0, '56', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (57, 1, 56, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (58, 1, 56, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (59, 1, 17, 'Liferay Sao Paulo', true, false, 0, 48, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (60, 1, 5, 8, 59, 0, 0, '60', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (61, 1, 60, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (62, 1, 60, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (63, 1, 17, 'Liferay Frankfurt', true, false, 0, 4, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (64, 1, 5, 8, 63, 0, 0, '64', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (65, 1, 64, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (66, 1, 64, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (67, 1, 17, 'Liferay Madrid', true, false, 0, 15, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (68, 1, 5, 8, 67, 0, 0, '68', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (69, 1, 68, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (70, 1, 68, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (71, 1, 17, 'Liferay Dalian', true, false, 0, 2, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (72, 1, 5, 8, 71, 0, 0, '72', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (73, 1, 72, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (74, 1, 72, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (75, 1, 17, 'Liferay Hong Kong', true, false, 0, 2, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (76, 1, 5, 8, 75, 0, 0, '76', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (77, 1, 76, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (78, 1, 76, false, false, 'classic', '01', 0);

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (79, 1, 17, 'Liferay Kuala Lumpur', true, false, 0, 135, 12017, '');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (80, 1, 5, 8, 79, 0, 0, '80', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (81, 1, 80, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (82, 1, 80, false, false, 'classic', '01', 0);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (5, 1, current_timestamp, current_timestamp, true, 6, 'password', false, false, '5', 'default@liferay.com', 'Welcome!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (6, 1, 5, '', current_timestamp, current_timestamp, 7, 0, '', '', '', true, '01/01/1970');

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (2, 1, current_timestamp, current_timestamp, false, 3, 'test', false, false, 'joebloggs', 'test@liferay.com', 'Welcome Joe Bloggs!', current_timestamp, 0, false, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (3, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Joe', '', 'Bloggs', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (83, 1, 2, 9, 2, 0, 0, '83', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (84, 1, 83, true, false, 'classic', '01', 2);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (85, 1, 83, false, false, 'classic', '01', 0);
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (86, 83, 1, true, 1, 0, '<?xml version="1.0"?>\n\n<root>\n  <name>Home</name>\n</root>', 'portlet', 'column-1=71_INSTANCE_OY0d,82,23,61,\ncolumn-2=9,79,29,8,19,\nlayout-template-id=2_columns_ii\n', false, '/home', 0);
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (87, 83, 1, true, 2, 0, '<?xml version="1.0"?>\n\n<root>\n  <name>Plugins</name>\n</root>', 'portlet', 'column-1=\ncolumn-2=111,\nlayout-template-id=2_columns_ii\n', false, '/plugins', 1);

insert into Users_Groups values (2, 14);

insert into Users_Orgs (userId, organizationId) values (2, 17);
insert into Users_Orgs (userId, organizationId) values (2, 43);

insert into Users_Roles values (2, 10);
insert into Users_Roles values (2, 12);
insert into Users_Roles values (2, 13);


insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (88, 1, current_timestamp, current_timestamp, false, 89, 'test', false, false, 'lax1', 'test.lax.1@liferay.com', 'Welcome Test LAX 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (89, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (90, 1, 88, 9, 88, 0, 0, '90', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (91, 1, 90, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (92, 1, 90, false, false, 'classic', '01', 0);

insert into Users_Groups values (88, 14);

insert into Users_Orgs (userId, organizationId) values (88, 17);
insert into Users_Orgs (userId, organizationId) values (88, 43);

insert into Users_Roles values (88, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (93, 1, current_timestamp, current_timestamp, false, 94, 'test', false, false, 'lax2', 'test.lax.2@liferay.com', 'Welcome Test LAX 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (94, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (95, 1, 93, 9, 93, 0, 0, '95', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (96, 1, 95, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (97, 1, 95, false, false, 'classic', '01', 0);

insert into Users_Groups values (93, 14);

insert into Users_Orgs (userId, organizationId) values (93, 17);
insert into Users_Orgs (userId, organizationId) values (93, 43);

insert into Users_Roles values (93, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (98, 1, current_timestamp, current_timestamp, false, 99, 'test', false, false, 'lax3', 'test.lax.3@liferay.com', 'Welcome Test LAX 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (99, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (100, 1, 98, 9, 98, 0, 0, '100', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (101, 1, 100, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (102, 1, 100, false, false, 'classic', '01', 0);

insert into Users_Groups values (98, 14);

insert into Users_Orgs (userId, organizationId) values (98, 17);
insert into Users_Orgs (userId, organizationId) values (98, 43);

insert into Users_Roles values (98, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (103, 1, current_timestamp, current_timestamp, false, 104, 'test', false, false, 'lax4', 'test.lax.4@liferay.com', 'Welcome Test LAX 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (104, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (105, 1, 103, 9, 103, 0, 0, '105', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (106, 1, 105, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (107, 1, 105, false, false, 'classic', '01', 0);

insert into Users_Groups values (103, 14);

insert into Users_Orgs (userId, organizationId) values (103, 17);
insert into Users_Orgs (userId, organizationId) values (103, 43);

insert into Users_Roles values (103, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (108, 1, current_timestamp, current_timestamp, false, 109, 'test', false, false, 'lax5', 'test.lax.5@liferay.com', 'Welcome Test LAX 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (109, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (110, 1, 108, 9, 108, 0, 0, '110', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (111, 1, 110, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (112, 1, 110, false, false, 'classic', '01', 0);

insert into Users_Groups values (108, 14);

insert into Users_Orgs (userId, organizationId) values (108, 17);
insert into Users_Orgs (userId, organizationId) values (108, 43);

insert into Users_Roles values (108, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (113, 1, current_timestamp, current_timestamp, false, 114, 'test', false, false, 'lax6', 'test.lax.6@liferay.com', 'Welcome Test LAX 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (114, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (115, 1, 113, 9, 113, 0, 0, '115', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (116, 1, 115, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (117, 1, 115, false, false, 'classic', '01', 0);

insert into Users_Groups values (113, 14);

insert into Users_Orgs (userId, organizationId) values (113, 17);
insert into Users_Orgs (userId, organizationId) values (113, 43);

insert into Users_Roles values (113, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (118, 1, current_timestamp, current_timestamp, false, 119, 'test', false, false, 'lax7', 'test.lax.7@liferay.com', 'Welcome Test LAX 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (119, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (120, 1, 118, 9, 118, 0, 0, '120', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (121, 1, 120, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (122, 1, 120, false, false, 'classic', '01', 0);

insert into Users_Groups values (118, 14);

insert into Users_Orgs (userId, organizationId) values (118, 17);
insert into Users_Orgs (userId, organizationId) values (118, 43);

insert into Users_Roles values (118, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (123, 1, current_timestamp, current_timestamp, false, 124, 'test', false, false, 'lax8', 'test.lax.8@liferay.com', 'Welcome Test LAX 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (124, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (125, 1, 123, 9, 123, 0, 0, '125', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (126, 1, 125, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (127, 1, 125, false, false, 'classic', '01', 0);

insert into Users_Groups values (123, 14);

insert into Users_Orgs (userId, organizationId) values (123, 17);
insert into Users_Orgs (userId, organizationId) values (123, 43);

insert into Users_Roles values (123, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (128, 1, current_timestamp, current_timestamp, false, 129, 'test', false, false, 'lax9', 'test.lax.9@liferay.com', 'Welcome Test LAX 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (129, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (130, 1, 128, 9, 128, 0, 0, '130', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (131, 1, 130, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (132, 1, 130, false, false, 'classic', '01', 0);

insert into Users_Groups values (128, 14);

insert into Users_Orgs (userId, organizationId) values (128, 17);
insert into Users_Orgs (userId, organizationId) values (128, 43);

insert into Users_Roles values (128, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (133, 1, current_timestamp, current_timestamp, false, 134, 'test', false, false, 'lax10', 'test.lax.10@liferay.com', 'Welcome Test LAX 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (134, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (135, 1, 133, 9, 133, 0, 0, '135', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (136, 1, 135, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (137, 1, 135, false, false, 'classic', '01', 0);

insert into Users_Groups values (133, 14);

insert into Users_Orgs (userId, organizationId) values (133, 17);
insert into Users_Orgs (userId, organizationId) values (133, 43);

insert into Users_Roles values (133, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (138, 1, current_timestamp, current_timestamp, false, 139, 'test', false, false, 'lax11', 'test.lax.11@liferay.com', 'Welcome Test LAX 11!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (139, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 11', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (140, 1, 138, 9, 138, 0, 0, '140', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (141, 1, 140, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (142, 1, 140, false, false, 'classic', '01', 0);

insert into Users_Groups values (138, 14);

insert into Users_Orgs (userId, organizationId) values (138, 17);
insert into Users_Orgs (userId, organizationId) values (138, 43);

insert into Users_Roles values (138, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (143, 1, current_timestamp, current_timestamp, false, 144, 'test', false, false, 'lax12', 'test.lax.12@liferay.com', 'Welcome Test LAX 12!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (144, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 12', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (145, 1, 143, 9, 143, 0, 0, '145', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (146, 1, 145, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (147, 1, 145, false, false, 'classic', '01', 0);

insert into Users_Groups values (143, 14);

insert into Users_Orgs (userId, organizationId) values (143, 17);
insert into Users_Orgs (userId, organizationId) values (143, 43);

insert into Users_Roles values (143, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (148, 1, current_timestamp, current_timestamp, false, 149, 'test', false, false, 'lax13', 'test.lax.13@liferay.com', 'Welcome Test LAX 13!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (149, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 13', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (150, 1, 148, 9, 148, 0, 0, '150', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (151, 1, 150, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (152, 1, 150, false, false, 'classic', '01', 0);

insert into Users_Groups values (148, 14);

insert into Users_Orgs (userId, organizationId) values (148, 17);
insert into Users_Orgs (userId, organizationId) values (148, 43);

insert into Users_Roles values (148, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (153, 1, current_timestamp, current_timestamp, false, 154, 'test', false, false, 'lax14', 'test.lax.14@liferay.com', 'Welcome Test LAX 14!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (154, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 14', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (155, 1, 153, 9, 153, 0, 0, '155', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (156, 1, 155, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (157, 1, 155, false, false, 'classic', '01', 0);

insert into Users_Groups values (153, 14);

insert into Users_Orgs (userId, organizationId) values (153, 17);
insert into Users_Orgs (userId, organizationId) values (153, 43);

insert into Users_Roles values (153, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (158, 1, current_timestamp, current_timestamp, false, 159, 'test', false, false, 'lax15', 'test.lax.15@liferay.com', 'Welcome Test LAX 15!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (159, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 15', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (160, 1, 158, 9, 158, 0, 0, '160', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (161, 1, 160, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (162, 1, 160, false, false, 'classic', '01', 0);

insert into Users_Groups values (158, 14);

insert into Users_Orgs (userId, organizationId) values (158, 17);
insert into Users_Orgs (userId, organizationId) values (158, 43);

insert into Users_Roles values (158, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (163, 1, current_timestamp, current_timestamp, false, 164, 'test', false, false, 'lax16', 'test.lax.16@liferay.com', 'Welcome Test LAX 16!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (164, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 16', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (165, 1, 163, 9, 163, 0, 0, '165', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (166, 1, 165, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (167, 1, 165, false, false, 'classic', '01', 0);

insert into Users_Groups values (163, 14);

insert into Users_Orgs (userId, organizationId) values (163, 17);
insert into Users_Orgs (userId, organizationId) values (163, 43);

insert into Users_Roles values (163, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (168, 1, current_timestamp, current_timestamp, false, 169, 'test', false, false, 'lax17', 'test.lax.17@liferay.com', 'Welcome Test LAX 17!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (169, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 17', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (170, 1, 168, 9, 168, 0, 0, '170', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (171, 1, 170, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (172, 1, 170, false, false, 'classic', '01', 0);

insert into Users_Groups values (168, 14);

insert into Users_Orgs (userId, organizationId) values (168, 17);
insert into Users_Orgs (userId, organizationId) values (168, 43);

insert into Users_Roles values (168, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (173, 1, current_timestamp, current_timestamp, false, 174, 'test', false, false, 'lax18', 'test.lax.18@liferay.com', 'Welcome Test LAX 18!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (174, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 18', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (175, 1, 173, 9, 173, 0, 0, '175', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (176, 1, 175, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (177, 1, 175, false, false, 'classic', '01', 0);

insert into Users_Groups values (173, 14);

insert into Users_Orgs (userId, organizationId) values (173, 17);
insert into Users_Orgs (userId, organizationId) values (173, 43);

insert into Users_Roles values (173, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (178, 1, current_timestamp, current_timestamp, false, 179, 'test', false, false, 'lax19', 'test.lax.19@liferay.com', 'Welcome Test LAX 19!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (179, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 19', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (180, 1, 178, 9, 178, 0, 0, '180', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (181, 1, 180, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (182, 1, 180, false, false, 'classic', '01', 0);

insert into Users_Groups values (178, 14);

insert into Users_Orgs (userId, organizationId) values (178, 17);
insert into Users_Orgs (userId, organizationId) values (178, 43);

insert into Users_Roles values (178, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (183, 1, current_timestamp, current_timestamp, false, 184, 'test', false, false, 'lax20', 'test.lax.20@liferay.com', 'Welcome Test LAX 20!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (184, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 20', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (185, 1, 183, 9, 183, 0, 0, '185', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (186, 1, 185, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (187, 1, 185, false, false, 'classic', '01', 0);

insert into Users_Groups values (183, 14);

insert into Users_Orgs (userId, organizationId) values (183, 17);
insert into Users_Orgs (userId, organizationId) values (183, 43);

insert into Users_Roles values (183, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (188, 1, current_timestamp, current_timestamp, false, 189, 'test', false, false, 'lax21', 'test.lax.21@liferay.com', 'Welcome Test LAX 21!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (189, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 21', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (190, 1, 188, 9, 188, 0, 0, '190', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (191, 1, 190, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (192, 1, 190, false, false, 'classic', '01', 0);

insert into Users_Groups values (188, 14);

insert into Users_Orgs (userId, organizationId) values (188, 17);
insert into Users_Orgs (userId, organizationId) values (188, 43);

insert into Users_Roles values (188, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (193, 1, current_timestamp, current_timestamp, false, 194, 'test', false, false, 'lax22', 'test.lax.22@liferay.com', 'Welcome Test LAX 22!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (194, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 22', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (195, 1, 193, 9, 193, 0, 0, '195', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (196, 1, 195, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (197, 1, 195, false, false, 'classic', '01', 0);

insert into Users_Groups values (193, 14);

insert into Users_Orgs (userId, organizationId) values (193, 17);
insert into Users_Orgs (userId, organizationId) values (193, 43);

insert into Users_Roles values (193, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (198, 1, current_timestamp, current_timestamp, false, 199, 'test', false, false, 'lax23', 'test.lax.23@liferay.com', 'Welcome Test LAX 23!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (199, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 23', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (200, 1, 198, 9, 198, 0, 0, '200', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (201, 1, 200, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (202, 1, 200, false, false, 'classic', '01', 0);

insert into Users_Groups values (198, 14);

insert into Users_Orgs (userId, organizationId) values (198, 17);
insert into Users_Orgs (userId, organizationId) values (198, 43);

insert into Users_Roles values (198, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (203, 1, current_timestamp, current_timestamp, false, 204, 'test', false, false, 'lax24', 'test.lax.24@liferay.com', 'Welcome Test LAX 24!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (204, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 24', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (205, 1, 203, 9, 203, 0, 0, '205', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (206, 1, 205, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (207, 1, 205, false, false, 'classic', '01', 0);

insert into Users_Groups values (203, 14);

insert into Users_Orgs (userId, organizationId) values (203, 17);
insert into Users_Orgs (userId, organizationId) values (203, 43);

insert into Users_Roles values (203, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (208, 1, current_timestamp, current_timestamp, false, 209, 'test', false, false, 'lax25', 'test.lax.25@liferay.com', 'Welcome Test LAX 25!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (209, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 25', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (210, 1, 208, 9, 208, 0, 0, '210', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (211, 1, 210, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (212, 1, 210, false, false, 'classic', '01', 0);

insert into Users_Groups values (208, 14);

insert into Users_Orgs (userId, organizationId) values (208, 17);
insert into Users_Orgs (userId, organizationId) values (208, 43);

insert into Users_Roles values (208, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (213, 1, current_timestamp, current_timestamp, false, 214, 'test', false, false, 'lax26', 'test.lax.26@liferay.com', 'Welcome Test LAX 26!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (214, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 26', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (215, 1, 213, 9, 213, 0, 0, '215', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (216, 1, 215, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (217, 1, 215, false, false, 'classic', '01', 0);

insert into Users_Groups values (213, 14);

insert into Users_Orgs (userId, organizationId) values (213, 17);
insert into Users_Orgs (userId, organizationId) values (213, 43);

insert into Users_Roles values (213, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (218, 1, current_timestamp, current_timestamp, false, 219, 'test', false, false, 'lax27', 'test.lax.27@liferay.com', 'Welcome Test LAX 27!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (219, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 27', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (220, 1, 218, 9, 218, 0, 0, '220', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (221, 1, 220, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (222, 1, 220, false, false, 'classic', '01', 0);

insert into Users_Groups values (218, 14);

insert into Users_Orgs (userId, organizationId) values (218, 17);
insert into Users_Orgs (userId, organizationId) values (218, 43);

insert into Users_Roles values (218, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (223, 1, current_timestamp, current_timestamp, false, 224, 'test', false, false, 'lax28', 'test.lax.28@liferay.com', 'Welcome Test LAX 28!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (224, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 28', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (225, 1, 223, 9, 223, 0, 0, '225', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (226, 1, 225, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (227, 1, 225, false, false, 'classic', '01', 0);

insert into Users_Groups values (223, 14);

insert into Users_Orgs (userId, organizationId) values (223, 17);
insert into Users_Orgs (userId, organizationId) values (223, 43);

insert into Users_Roles values (223, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (228, 1, current_timestamp, current_timestamp, false, 229, 'test', false, false, 'lax29', 'test.lax.29@liferay.com', 'Welcome Test LAX 29!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (229, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 29', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (230, 1, 228, 9, 228, 0, 0, '230', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (231, 1, 230, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (232, 1, 230, false, false, 'classic', '01', 0);

insert into Users_Groups values (228, 14);

insert into Users_Orgs (userId, organizationId) values (228, 17);
insert into Users_Orgs (userId, organizationId) values (228, 43);

insert into Users_Roles values (228, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (233, 1, current_timestamp, current_timestamp, false, 234, 'test', false, false, 'lax30', 'test.lax.30@liferay.com', 'Welcome Test LAX 30!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (234, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 30', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (235, 1, 233, 9, 233, 0, 0, '235', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (236, 1, 235, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (237, 1, 235, false, false, 'classic', '01', 0);

insert into Users_Groups values (233, 14);

insert into Users_Orgs (userId, organizationId) values (233, 17);
insert into Users_Orgs (userId, organizationId) values (233, 43);

insert into Users_Roles values (233, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (238, 1, current_timestamp, current_timestamp, false, 239, 'test', false, false, 'lax31', 'test.lax.31@liferay.com', 'Welcome Test LAX 31!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (239, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 31', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (240, 1, 238, 9, 238, 0, 0, '240', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (241, 1, 240, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (242, 1, 240, false, false, 'classic', '01', 0);

insert into Users_Groups values (238, 14);

insert into Users_Orgs (userId, organizationId) values (238, 17);
insert into Users_Orgs (userId, organizationId) values (238, 43);

insert into Users_Roles values (238, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (243, 1, current_timestamp, current_timestamp, false, 244, 'test', false, false, 'lax32', 'test.lax.32@liferay.com', 'Welcome Test LAX 32!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (244, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 32', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (245, 1, 243, 9, 243, 0, 0, '245', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (246, 1, 245, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (247, 1, 245, false, false, 'classic', '01', 0);

insert into Users_Groups values (243, 14);

insert into Users_Orgs (userId, organizationId) values (243, 17);
insert into Users_Orgs (userId, organizationId) values (243, 43);

insert into Users_Roles values (243, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (248, 1, current_timestamp, current_timestamp, false, 249, 'test', false, false, 'lax33', 'test.lax.33@liferay.com', 'Welcome Test LAX 33!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (249, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 33', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (250, 1, 248, 9, 248, 0, 0, '250', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (251, 1, 250, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (252, 1, 250, false, false, 'classic', '01', 0);

insert into Users_Groups values (248, 14);

insert into Users_Orgs (userId, organizationId) values (248, 17);
insert into Users_Orgs (userId, organizationId) values (248, 43);

insert into Users_Roles values (248, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (253, 1, current_timestamp, current_timestamp, false, 254, 'test', false, false, 'lax34', 'test.lax.34@liferay.com', 'Welcome Test LAX 34!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (254, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 34', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (255, 1, 253, 9, 253, 0, 0, '255', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (256, 1, 255, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (257, 1, 255, false, false, 'classic', '01', 0);

insert into Users_Groups values (253, 14);

insert into Users_Orgs (userId, organizationId) values (253, 17);
insert into Users_Orgs (userId, organizationId) values (253, 43);

insert into Users_Roles values (253, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (258, 1, current_timestamp, current_timestamp, false, 259, 'test', false, false, 'lax35', 'test.lax.35@liferay.com', 'Welcome Test LAX 35!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (259, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 35', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (260, 1, 258, 9, 258, 0, 0, '260', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (261, 1, 260, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (262, 1, 260, false, false, 'classic', '01', 0);

insert into Users_Groups values (258, 14);

insert into Users_Orgs (userId, organizationId) values (258, 17);
insert into Users_Orgs (userId, organizationId) values (258, 43);

insert into Users_Roles values (258, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (263, 1, current_timestamp, current_timestamp, false, 264, 'test', false, false, 'lax36', 'test.lax.36@liferay.com', 'Welcome Test LAX 36!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (264, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 36', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (265, 1, 263, 9, 263, 0, 0, '265', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (266, 1, 265, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (267, 1, 265, false, false, 'classic', '01', 0);

insert into Users_Groups values (263, 14);

insert into Users_Orgs (userId, organizationId) values (263, 17);
insert into Users_Orgs (userId, organizationId) values (263, 43);

insert into Users_Roles values (263, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (268, 1, current_timestamp, current_timestamp, false, 269, 'test', false, false, 'lax37', 'test.lax.37@liferay.com', 'Welcome Test LAX 37!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (269, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 37', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (270, 1, 268, 9, 268, 0, 0, '270', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (271, 1, 270, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (272, 1, 270, false, false, 'classic', '01', 0);

insert into Users_Groups values (268, 14);

insert into Users_Orgs (userId, organizationId) values (268, 17);
insert into Users_Orgs (userId, organizationId) values (268, 43);

insert into Users_Roles values (268, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (273, 1, current_timestamp, current_timestamp, false, 274, 'test', false, false, 'lax38', 'test.lax.38@liferay.com', 'Welcome Test LAX 38!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (274, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 38', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (275, 1, 273, 9, 273, 0, 0, '275', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (276, 1, 275, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (277, 1, 275, false, false, 'classic', '01', 0);

insert into Users_Groups values (273, 14);

insert into Users_Orgs (userId, organizationId) values (273, 17);
insert into Users_Orgs (userId, organizationId) values (273, 43);

insert into Users_Roles values (273, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (278, 1, current_timestamp, current_timestamp, false, 279, 'test', false, false, 'lax39', 'test.lax.39@liferay.com', 'Welcome Test LAX 39!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (279, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 39', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (280, 1, 278, 9, 278, 0, 0, '280', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (281, 1, 280, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (282, 1, 280, false, false, 'classic', '01', 0);

insert into Users_Groups values (278, 14);

insert into Users_Orgs (userId, organizationId) values (278, 17);
insert into Users_Orgs (userId, organizationId) values (278, 43);

insert into Users_Roles values (278, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (283, 1, current_timestamp, current_timestamp, false, 284, 'test', false, false, 'lax40', 'test.lax.40@liferay.com', 'Welcome Test LAX 40!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (284, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 40', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (285, 1, 283, 9, 283, 0, 0, '285', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (286, 1, 285, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (287, 1, 285, false, false, 'classic', '01', 0);

insert into Users_Groups values (283, 14);

insert into Users_Orgs (userId, organizationId) values (283, 17);
insert into Users_Orgs (userId, organizationId) values (283, 43);

insert into Users_Roles values (283, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (288, 1, current_timestamp, current_timestamp, false, 289, 'test', false, false, 'lax41', 'test.lax.41@liferay.com', 'Welcome Test LAX 41!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (289, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 41', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (290, 1, 288, 9, 288, 0, 0, '290', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (291, 1, 290, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (292, 1, 290, false, false, 'classic', '01', 0);

insert into Users_Groups values (288, 14);

insert into Users_Orgs (userId, organizationId) values (288, 17);
insert into Users_Orgs (userId, organizationId) values (288, 43);

insert into Users_Roles values (288, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (293, 1, current_timestamp, current_timestamp, false, 294, 'test', false, false, 'lax42', 'test.lax.42@liferay.com', 'Welcome Test LAX 42!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (294, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 42', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (295, 1, 293, 9, 293, 0, 0, '295', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (296, 1, 295, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (297, 1, 295, false, false, 'classic', '01', 0);

insert into Users_Groups values (293, 14);

insert into Users_Orgs (userId, organizationId) values (293, 17);
insert into Users_Orgs (userId, organizationId) values (293, 43);

insert into Users_Roles values (293, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (298, 1, current_timestamp, current_timestamp, false, 299, 'test', false, false, 'lax43', 'test.lax.43@liferay.com', 'Welcome Test LAX 43!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (299, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 43', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (300, 1, 298, 9, 298, 0, 0, '300', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (301, 1, 300, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (302, 1, 300, false, false, 'classic', '01', 0);

insert into Users_Groups values (298, 14);

insert into Users_Orgs (userId, organizationId) values (298, 17);
insert into Users_Orgs (userId, organizationId) values (298, 43);

insert into Users_Roles values (298, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (303, 1, current_timestamp, current_timestamp, false, 304, 'test', false, false, 'lax44', 'test.lax.44@liferay.com', 'Welcome Test LAX 44!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (304, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 44', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (305, 1, 303, 9, 303, 0, 0, '305', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (306, 1, 305, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (307, 1, 305, false, false, 'classic', '01', 0);

insert into Users_Groups values (303, 14);

insert into Users_Orgs (userId, organizationId) values (303, 17);
insert into Users_Orgs (userId, organizationId) values (303, 43);

insert into Users_Roles values (303, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (308, 1, current_timestamp, current_timestamp, false, 309, 'test', false, false, 'lax45', 'test.lax.45@liferay.com', 'Welcome Test LAX 45!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (309, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 45', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (310, 1, 308, 9, 308, 0, 0, '310', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (311, 1, 310, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (312, 1, 310, false, false, 'classic', '01', 0);

insert into Users_Groups values (308, 14);

insert into Users_Orgs (userId, organizationId) values (308, 17);
insert into Users_Orgs (userId, organizationId) values (308, 43);

insert into Users_Roles values (308, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (313, 1, current_timestamp, current_timestamp, false, 314, 'test', false, false, 'lax46', 'test.lax.46@liferay.com', 'Welcome Test LAX 46!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (314, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 46', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (315, 1, 313, 9, 313, 0, 0, '315', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (316, 1, 315, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (317, 1, 315, false, false, 'classic', '01', 0);

insert into Users_Groups values (313, 14);

insert into Users_Orgs (userId, organizationId) values (313, 17);
insert into Users_Orgs (userId, organizationId) values (313, 43);

insert into Users_Roles values (313, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (318, 1, current_timestamp, current_timestamp, false, 319, 'test', false, false, 'lax47', 'test.lax.47@liferay.com', 'Welcome Test LAX 47!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (319, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 47', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (320, 1, 318, 9, 318, 0, 0, '320', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (321, 1, 320, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (322, 1, 320, false, false, 'classic', '01', 0);

insert into Users_Groups values (318, 14);

insert into Users_Orgs (userId, organizationId) values (318, 17);
insert into Users_Orgs (userId, organizationId) values (318, 43);

insert into Users_Roles values (318, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (323, 1, current_timestamp, current_timestamp, false, 324, 'test', false, false, 'lax48', 'test.lax.48@liferay.com', 'Welcome Test LAX 48!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (324, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 48', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (325, 1, 323, 9, 323, 0, 0, '325', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (326, 1, 325, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (327, 1, 325, false, false, 'classic', '01', 0);

insert into Users_Groups values (323, 14);

insert into Users_Orgs (userId, organizationId) values (323, 17);
insert into Users_Orgs (userId, organizationId) values (323, 43);

insert into Users_Roles values (323, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (328, 1, current_timestamp, current_timestamp, false, 329, 'test', false, false, 'lax49', 'test.lax.49@liferay.com', 'Welcome Test LAX 49!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (329, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 49', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (330, 1, 328, 9, 328, 0, 0, '330', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (331, 1, 330, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (332, 1, 330, false, false, 'classic', '01', 0);

insert into Users_Groups values (328, 14);

insert into Users_Orgs (userId, organizationId) values (328, 17);
insert into Users_Orgs (userId, organizationId) values (328, 43);

insert into Users_Roles values (328, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (333, 1, current_timestamp, current_timestamp, false, 334, 'test', false, false, 'lax50', 'test.lax.50@liferay.com', 'Welcome Test LAX 50!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (334, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 50', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (335, 1, 333, 9, 333, 0, 0, '335', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (336, 1, 335, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (337, 1, 335, false, false, 'classic', '01', 0);

insert into Users_Groups values (333, 14);

insert into Users_Orgs (userId, organizationId) values (333, 17);
insert into Users_Orgs (userId, organizationId) values (333, 43);

insert into Users_Roles values (333, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (338, 1, current_timestamp, current_timestamp, false, 339, 'test', false, false, 'lax51', 'test.lax.51@liferay.com', 'Welcome Test LAX 51!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (339, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 51', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (340, 1, 338, 9, 338, 0, 0, '340', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (341, 1, 340, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (342, 1, 340, false, false, 'classic', '01', 0);

insert into Users_Groups values (338, 14);

insert into Users_Orgs (userId, organizationId) values (338, 17);
insert into Users_Orgs (userId, organizationId) values (338, 43);

insert into Users_Roles values (338, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (343, 1, current_timestamp, current_timestamp, false, 344, 'test', false, false, 'lax52', 'test.lax.52@liferay.com', 'Welcome Test LAX 52!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (344, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 52', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (345, 1, 343, 9, 343, 0, 0, '345', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (346, 1, 345, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (347, 1, 345, false, false, 'classic', '01', 0);

insert into Users_Groups values (343, 14);

insert into Users_Orgs (userId, organizationId) values (343, 17);
insert into Users_Orgs (userId, organizationId) values (343, 43);

insert into Users_Roles values (343, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (348, 1, current_timestamp, current_timestamp, false, 349, 'test', false, false, 'lax53', 'test.lax.53@liferay.com', 'Welcome Test LAX 53!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (349, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 53', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (350, 1, 348, 9, 348, 0, 0, '350', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (351, 1, 350, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (352, 1, 350, false, false, 'classic', '01', 0);

insert into Users_Groups values (348, 14);

insert into Users_Orgs (userId, organizationId) values (348, 17);
insert into Users_Orgs (userId, organizationId) values (348, 43);

insert into Users_Roles values (348, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (353, 1, current_timestamp, current_timestamp, false, 354, 'test', false, false, 'lax54', 'test.lax.54@liferay.com', 'Welcome Test LAX 54!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (354, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 54', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (355, 1, 353, 9, 353, 0, 0, '355', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (356, 1, 355, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (357, 1, 355, false, false, 'classic', '01', 0);

insert into Users_Groups values (353, 14);

insert into Users_Orgs (userId, organizationId) values (353, 17);
insert into Users_Orgs (userId, organizationId) values (353, 43);

insert into Users_Roles values (353, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (358, 1, current_timestamp, current_timestamp, false, 359, 'test', false, false, 'lax55', 'test.lax.55@liferay.com', 'Welcome Test LAX 55!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (359, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 55', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (360, 1, 358, 9, 358, 0, 0, '360', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (361, 1, 360, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (362, 1, 360, false, false, 'classic', '01', 0);

insert into Users_Groups values (358, 14);

insert into Users_Orgs (userId, organizationId) values (358, 17);
insert into Users_Orgs (userId, organizationId) values (358, 43);

insert into Users_Roles values (358, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (363, 1, current_timestamp, current_timestamp, false, 364, 'test', false, false, 'lax56', 'test.lax.56@liferay.com', 'Welcome Test LAX 56!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (364, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 56', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (365, 1, 363, 9, 363, 0, 0, '365', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (366, 1, 365, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (367, 1, 365, false, false, 'classic', '01', 0);

insert into Users_Groups values (363, 14);

insert into Users_Orgs (userId, organizationId) values (363, 17);
insert into Users_Orgs (userId, organizationId) values (363, 43);

insert into Users_Roles values (363, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (368, 1, current_timestamp, current_timestamp, false, 369, 'test', false, false, 'lax57', 'test.lax.57@liferay.com', 'Welcome Test LAX 57!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (369, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 57', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (370, 1, 368, 9, 368, 0, 0, '370', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (371, 1, 370, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (372, 1, 370, false, false, 'classic', '01', 0);

insert into Users_Groups values (368, 14);

insert into Users_Orgs (userId, organizationId) values (368, 17);
insert into Users_Orgs (userId, organizationId) values (368, 43);

insert into Users_Roles values (368, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (373, 1, current_timestamp, current_timestamp, false, 374, 'test', false, false, 'lax58', 'test.lax.58@liferay.com', 'Welcome Test LAX 58!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (374, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 58', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (375, 1, 373, 9, 373, 0, 0, '375', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (376, 1, 375, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (377, 1, 375, false, false, 'classic', '01', 0);

insert into Users_Groups values (373, 14);

insert into Users_Orgs (userId, organizationId) values (373, 17);
insert into Users_Orgs (userId, organizationId) values (373, 43);

insert into Users_Roles values (373, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (378, 1, current_timestamp, current_timestamp, false, 379, 'test', false, false, 'lax59', 'test.lax.59@liferay.com', 'Welcome Test LAX 59!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (379, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 59', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (380, 1, 378, 9, 378, 0, 0, '380', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (381, 1, 380, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (382, 1, 380, false, false, 'classic', '01', 0);

insert into Users_Groups values (378, 14);

insert into Users_Orgs (userId, organizationId) values (378, 17);
insert into Users_Orgs (userId, organizationId) values (378, 43);

insert into Users_Roles values (378, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (383, 1, current_timestamp, current_timestamp, false, 384, 'test', false, false, 'lax60', 'test.lax.60@liferay.com', 'Welcome Test LAX 60!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (384, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 60', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (385, 1, 383, 9, 383, 0, 0, '385', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (386, 1, 385, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (387, 1, 385, false, false, 'classic', '01', 0);

insert into Users_Groups values (383, 14);

insert into Users_Orgs (userId, organizationId) values (383, 17);
insert into Users_Orgs (userId, organizationId) values (383, 43);

insert into Users_Roles values (383, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (388, 1, current_timestamp, current_timestamp, false, 389, 'test', false, false, 'lax61', 'test.lax.61@liferay.com', 'Welcome Test LAX 61!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (389, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 61', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (390, 1, 388, 9, 388, 0, 0, '390', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (391, 1, 390, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (392, 1, 390, false, false, 'classic', '01', 0);

insert into Users_Groups values (388, 14);

insert into Users_Orgs (userId, organizationId) values (388, 17);
insert into Users_Orgs (userId, organizationId) values (388, 43);

insert into Users_Roles values (388, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (393, 1, current_timestamp, current_timestamp, false, 394, 'test', false, false, 'lax62', 'test.lax.62@liferay.com', 'Welcome Test LAX 62!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (394, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 62', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (395, 1, 393, 9, 393, 0, 0, '395', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (396, 1, 395, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (397, 1, 395, false, false, 'classic', '01', 0);

insert into Users_Groups values (393, 14);

insert into Users_Orgs (userId, organizationId) values (393, 17);
insert into Users_Orgs (userId, organizationId) values (393, 43);

insert into Users_Roles values (393, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (398, 1, current_timestamp, current_timestamp, false, 399, 'test', false, false, 'lax63', 'test.lax.63@liferay.com', 'Welcome Test LAX 63!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (399, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 63', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (400, 1, 398, 9, 398, 0, 0, '400', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (401, 1, 400, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (402, 1, 400, false, false, 'classic', '01', 0);

insert into Users_Groups values (398, 14);

insert into Users_Orgs (userId, organizationId) values (398, 17);
insert into Users_Orgs (userId, organizationId) values (398, 43);

insert into Users_Roles values (398, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (403, 1, current_timestamp, current_timestamp, false, 404, 'test', false, false, 'lax64', 'test.lax.64@liferay.com', 'Welcome Test LAX 64!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (404, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 64', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (405, 1, 403, 9, 403, 0, 0, '405', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (406, 1, 405, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (407, 1, 405, false, false, 'classic', '01', 0);

insert into Users_Groups values (403, 14);

insert into Users_Orgs (userId, organizationId) values (403, 17);
insert into Users_Orgs (userId, organizationId) values (403, 43);

insert into Users_Roles values (403, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (408, 1, current_timestamp, current_timestamp, false, 409, 'test', false, false, 'lax65', 'test.lax.65@liferay.com', 'Welcome Test LAX 65!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (409, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 65', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (410, 1, 408, 9, 408, 0, 0, '410', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (411, 1, 410, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (412, 1, 410, false, false, 'classic', '01', 0);

insert into Users_Groups values (408, 14);

insert into Users_Orgs (userId, organizationId) values (408, 17);
insert into Users_Orgs (userId, organizationId) values (408, 43);

insert into Users_Roles values (408, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (413, 1, current_timestamp, current_timestamp, false, 414, 'test', false, false, 'lax66', 'test.lax.66@liferay.com', 'Welcome Test LAX 66!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (414, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 66', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (415, 1, 413, 9, 413, 0, 0, '415', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (416, 1, 415, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (417, 1, 415, false, false, 'classic', '01', 0);

insert into Users_Groups values (413, 14);

insert into Users_Orgs (userId, organizationId) values (413, 17);
insert into Users_Orgs (userId, organizationId) values (413, 43);

insert into Users_Roles values (413, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (418, 1, current_timestamp, current_timestamp, false, 419, 'test', false, false, 'lax67', 'test.lax.67@liferay.com', 'Welcome Test LAX 67!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (419, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 67', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (420, 1, 418, 9, 418, 0, 0, '420', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (421, 1, 420, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (422, 1, 420, false, false, 'classic', '01', 0);

insert into Users_Groups values (418, 14);

insert into Users_Orgs (userId, organizationId) values (418, 17);
insert into Users_Orgs (userId, organizationId) values (418, 43);

insert into Users_Roles values (418, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (423, 1, current_timestamp, current_timestamp, false, 424, 'test', false, false, 'lax68', 'test.lax.68@liferay.com', 'Welcome Test LAX 68!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (424, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 68', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (425, 1, 423, 9, 423, 0, 0, '425', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (426, 1, 425, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (427, 1, 425, false, false, 'classic', '01', 0);

insert into Users_Groups values (423, 14);

insert into Users_Orgs (userId, organizationId) values (423, 17);
insert into Users_Orgs (userId, organizationId) values (423, 43);

insert into Users_Roles values (423, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (428, 1, current_timestamp, current_timestamp, false, 429, 'test', false, false, 'lax69', 'test.lax.69@liferay.com', 'Welcome Test LAX 69!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (429, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 69', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (430, 1, 428, 9, 428, 0, 0, '430', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (431, 1, 430, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (432, 1, 430, false, false, 'classic', '01', 0);

insert into Users_Groups values (428, 14);

insert into Users_Orgs (userId, organizationId) values (428, 17);
insert into Users_Orgs (userId, organizationId) values (428, 43);

insert into Users_Roles values (428, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (433, 1, current_timestamp, current_timestamp, false, 434, 'test', false, false, 'lax70', 'test.lax.70@liferay.com', 'Welcome Test LAX 70!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (434, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 70', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (435, 1, 433, 9, 433, 0, 0, '435', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (436, 1, 435, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (437, 1, 435, false, false, 'classic', '01', 0);

insert into Users_Groups values (433, 14);

insert into Users_Orgs (userId, organizationId) values (433, 17);
insert into Users_Orgs (userId, organizationId) values (433, 43);

insert into Users_Roles values (433, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (438, 1, current_timestamp, current_timestamp, false, 439, 'test', false, false, 'lax71', 'test.lax.71@liferay.com', 'Welcome Test LAX 71!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (439, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 71', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (440, 1, 438, 9, 438, 0, 0, '440', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (441, 1, 440, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (442, 1, 440, false, false, 'classic', '01', 0);

insert into Users_Groups values (438, 14);

insert into Users_Orgs (userId, organizationId) values (438, 17);
insert into Users_Orgs (userId, organizationId) values (438, 43);

insert into Users_Roles values (438, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (443, 1, current_timestamp, current_timestamp, false, 444, 'test', false, false, 'lax72', 'test.lax.72@liferay.com', 'Welcome Test LAX 72!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (444, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 72', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (445, 1, 443, 9, 443, 0, 0, '445', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (446, 1, 445, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (447, 1, 445, false, false, 'classic', '01', 0);

insert into Users_Groups values (443, 14);

insert into Users_Orgs (userId, organizationId) values (443, 17);
insert into Users_Orgs (userId, organizationId) values (443, 43);

insert into Users_Roles values (443, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (448, 1, current_timestamp, current_timestamp, false, 449, 'test', false, false, 'lax73', 'test.lax.73@liferay.com', 'Welcome Test LAX 73!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (449, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 73', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (450, 1, 448, 9, 448, 0, 0, '450', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (451, 1, 450, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (452, 1, 450, false, false, 'classic', '01', 0);

insert into Users_Groups values (448, 14);

insert into Users_Orgs (userId, organizationId) values (448, 17);
insert into Users_Orgs (userId, organizationId) values (448, 43);

insert into Users_Roles values (448, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (453, 1, current_timestamp, current_timestamp, false, 454, 'test', false, false, 'lax74', 'test.lax.74@liferay.com', 'Welcome Test LAX 74!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (454, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 74', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (455, 1, 453, 9, 453, 0, 0, '455', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (456, 1, 455, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (457, 1, 455, false, false, 'classic', '01', 0);

insert into Users_Groups values (453, 14);

insert into Users_Orgs (userId, organizationId) values (453, 17);
insert into Users_Orgs (userId, organizationId) values (453, 43);

insert into Users_Roles values (453, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (458, 1, current_timestamp, current_timestamp, false, 459, 'test', false, false, 'lax75', 'test.lax.75@liferay.com', 'Welcome Test LAX 75!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (459, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 75', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (460, 1, 458, 9, 458, 0, 0, '460', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (461, 1, 460, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (462, 1, 460, false, false, 'classic', '01', 0);

insert into Users_Groups values (458, 14);

insert into Users_Orgs (userId, organizationId) values (458, 17);
insert into Users_Orgs (userId, organizationId) values (458, 43);

insert into Users_Roles values (458, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (463, 1, current_timestamp, current_timestamp, false, 464, 'test', false, false, 'lax76', 'test.lax.76@liferay.com', 'Welcome Test LAX 76!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (464, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 76', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (465, 1, 463, 9, 463, 0, 0, '465', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (466, 1, 465, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (467, 1, 465, false, false, 'classic', '01', 0);

insert into Users_Groups values (463, 14);

insert into Users_Orgs (userId, organizationId) values (463, 17);
insert into Users_Orgs (userId, organizationId) values (463, 43);

insert into Users_Roles values (463, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (468, 1, current_timestamp, current_timestamp, false, 469, 'test', false, false, 'lax77', 'test.lax.77@liferay.com', 'Welcome Test LAX 77!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (469, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 77', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (470, 1, 468, 9, 468, 0, 0, '470', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (471, 1, 470, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (472, 1, 470, false, false, 'classic', '01', 0);

insert into Users_Groups values (468, 14);

insert into Users_Orgs (userId, organizationId) values (468, 17);
insert into Users_Orgs (userId, organizationId) values (468, 43);

insert into Users_Roles values (468, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (473, 1, current_timestamp, current_timestamp, false, 474, 'test', false, false, 'lax78', 'test.lax.78@liferay.com', 'Welcome Test LAX 78!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (474, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 78', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (475, 1, 473, 9, 473, 0, 0, '475', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (476, 1, 475, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (477, 1, 475, false, false, 'classic', '01', 0);

insert into Users_Groups values (473, 14);

insert into Users_Orgs (userId, organizationId) values (473, 17);
insert into Users_Orgs (userId, organizationId) values (473, 43);

insert into Users_Roles values (473, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (478, 1, current_timestamp, current_timestamp, false, 479, 'test', false, false, 'lax79', 'test.lax.79@liferay.com', 'Welcome Test LAX 79!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (479, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 79', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (480, 1, 478, 9, 478, 0, 0, '480', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (481, 1, 480, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (482, 1, 480, false, false, 'classic', '01', 0);

insert into Users_Groups values (478, 14);

insert into Users_Orgs (userId, organizationId) values (478, 17);
insert into Users_Orgs (userId, organizationId) values (478, 43);

insert into Users_Roles values (478, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (483, 1, current_timestamp, current_timestamp, false, 484, 'test', false, false, 'lax80', 'test.lax.80@liferay.com', 'Welcome Test LAX 80!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (484, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 80', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (485, 1, 483, 9, 483, 0, 0, '485', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (486, 1, 485, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (487, 1, 485, false, false, 'classic', '01', 0);

insert into Users_Groups values (483, 14);

insert into Users_Orgs (userId, organizationId) values (483, 17);
insert into Users_Orgs (userId, organizationId) values (483, 43);

insert into Users_Roles values (483, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (488, 1, current_timestamp, current_timestamp, false, 489, 'test', false, false, 'lax81', 'test.lax.81@liferay.com', 'Welcome Test LAX 81!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (489, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 81', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (490, 1, 488, 9, 488, 0, 0, '490', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (491, 1, 490, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (492, 1, 490, false, false, 'classic', '01', 0);

insert into Users_Groups values (488, 14);

insert into Users_Orgs (userId, organizationId) values (488, 17);
insert into Users_Orgs (userId, organizationId) values (488, 43);

insert into Users_Roles values (488, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (493, 1, current_timestamp, current_timestamp, false, 494, 'test', false, false, 'lax82', 'test.lax.82@liferay.com', 'Welcome Test LAX 82!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (494, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 82', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (495, 1, 493, 9, 493, 0, 0, '495', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (496, 1, 495, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (497, 1, 495, false, false, 'classic', '01', 0);

insert into Users_Groups values (493, 14);

insert into Users_Orgs (userId, organizationId) values (493, 17);
insert into Users_Orgs (userId, organizationId) values (493, 43);

insert into Users_Roles values (493, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (498, 1, current_timestamp, current_timestamp, false, 499, 'test', false, false, 'lax83', 'test.lax.83@liferay.com', 'Welcome Test LAX 83!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (499, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 83', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (500, 1, 498, 9, 498, 0, 0, '500', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (501, 1, 500, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (502, 1, 500, false, false, 'classic', '01', 0);

insert into Users_Groups values (498, 14);

insert into Users_Orgs (userId, organizationId) values (498, 17);
insert into Users_Orgs (userId, organizationId) values (498, 43);

insert into Users_Roles values (498, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (503, 1, current_timestamp, current_timestamp, false, 504, 'test', false, false, 'lax84', 'test.lax.84@liferay.com', 'Welcome Test LAX 84!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (504, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 84', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (505, 1, 503, 9, 503, 0, 0, '505', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (506, 1, 505, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (507, 1, 505, false, false, 'classic', '01', 0);

insert into Users_Groups values (503, 14);

insert into Users_Orgs (userId, organizationId) values (503, 17);
insert into Users_Orgs (userId, organizationId) values (503, 43);

insert into Users_Roles values (503, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (508, 1, current_timestamp, current_timestamp, false, 509, 'test', false, false, 'lax85', 'test.lax.85@liferay.com', 'Welcome Test LAX 85!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (509, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 85', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (510, 1, 508, 9, 508, 0, 0, '510', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (511, 1, 510, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (512, 1, 510, false, false, 'classic', '01', 0);

insert into Users_Groups values (508, 14);

insert into Users_Orgs (userId, organizationId) values (508, 17);
insert into Users_Orgs (userId, organizationId) values (508, 43);

insert into Users_Roles values (508, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (513, 1, current_timestamp, current_timestamp, false, 514, 'test', false, false, 'lax86', 'test.lax.86@liferay.com', 'Welcome Test LAX 86!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (514, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 86', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (515, 1, 513, 9, 513, 0, 0, '515', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (516, 1, 515, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (517, 1, 515, false, false, 'classic', '01', 0);

insert into Users_Groups values (513, 14);

insert into Users_Orgs (userId, organizationId) values (513, 17);
insert into Users_Orgs (userId, organizationId) values (513, 43);

insert into Users_Roles values (513, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (518, 1, current_timestamp, current_timestamp, false, 519, 'test', false, false, 'lax87', 'test.lax.87@liferay.com', 'Welcome Test LAX 87!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (519, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 87', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (520, 1, 518, 9, 518, 0, 0, '520', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (521, 1, 520, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (522, 1, 520, false, false, 'classic', '01', 0);

insert into Users_Groups values (518, 14);

insert into Users_Orgs (userId, organizationId) values (518, 17);
insert into Users_Orgs (userId, organizationId) values (518, 43);

insert into Users_Roles values (518, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (523, 1, current_timestamp, current_timestamp, false, 524, 'test', false, false, 'lax88', 'test.lax.88@liferay.com', 'Welcome Test LAX 88!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (524, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 88', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (525, 1, 523, 9, 523, 0, 0, '525', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (526, 1, 525, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (527, 1, 525, false, false, 'classic', '01', 0);

insert into Users_Groups values (523, 14);

insert into Users_Orgs (userId, organizationId) values (523, 17);
insert into Users_Orgs (userId, organizationId) values (523, 43);

insert into Users_Roles values (523, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (528, 1, current_timestamp, current_timestamp, false, 529, 'test', false, false, 'lax89', 'test.lax.89@liferay.com', 'Welcome Test LAX 89!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (529, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 89', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (530, 1, 528, 9, 528, 0, 0, '530', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (531, 1, 530, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (532, 1, 530, false, false, 'classic', '01', 0);

insert into Users_Groups values (528, 14);

insert into Users_Orgs (userId, organizationId) values (528, 17);
insert into Users_Orgs (userId, organizationId) values (528, 43);

insert into Users_Roles values (528, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (533, 1, current_timestamp, current_timestamp, false, 534, 'test', false, false, 'lax90', 'test.lax.90@liferay.com', 'Welcome Test LAX 90!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (534, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 90', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (535, 1, 533, 9, 533, 0, 0, '535', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (536, 1, 535, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (537, 1, 535, false, false, 'classic', '01', 0);

insert into Users_Groups values (533, 14);

insert into Users_Orgs (userId, organizationId) values (533, 17);
insert into Users_Orgs (userId, organizationId) values (533, 43);

insert into Users_Roles values (533, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (538, 1, current_timestamp, current_timestamp, false, 539, 'test', false, false, 'lax91', 'test.lax.91@liferay.com', 'Welcome Test LAX 91!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (539, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 91', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (540, 1, 538, 9, 538, 0, 0, '540', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (541, 1, 540, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (542, 1, 540, false, false, 'classic', '01', 0);

insert into Users_Groups values (538, 14);

insert into Users_Orgs (userId, organizationId) values (538, 17);
insert into Users_Orgs (userId, organizationId) values (538, 43);

insert into Users_Roles values (538, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (543, 1, current_timestamp, current_timestamp, false, 544, 'test', false, false, 'lax92', 'test.lax.92@liferay.com', 'Welcome Test LAX 92!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (544, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 92', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (545, 1, 543, 9, 543, 0, 0, '545', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (546, 1, 545, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (547, 1, 545, false, false, 'classic', '01', 0);

insert into Users_Groups values (543, 14);

insert into Users_Orgs (userId, organizationId) values (543, 17);
insert into Users_Orgs (userId, organizationId) values (543, 43);

insert into Users_Roles values (543, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (548, 1, current_timestamp, current_timestamp, false, 549, 'test', false, false, 'lax93', 'test.lax.93@liferay.com', 'Welcome Test LAX 93!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (549, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 93', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (550, 1, 548, 9, 548, 0, 0, '550', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (551, 1, 550, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (552, 1, 550, false, false, 'classic', '01', 0);

insert into Users_Groups values (548, 14);

insert into Users_Orgs (userId, organizationId) values (548, 17);
insert into Users_Orgs (userId, organizationId) values (548, 43);

insert into Users_Roles values (548, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (553, 1, current_timestamp, current_timestamp, false, 554, 'test', false, false, 'lax94', 'test.lax.94@liferay.com', 'Welcome Test LAX 94!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (554, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 94', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (555, 1, 553, 9, 553, 0, 0, '555', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (556, 1, 555, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (557, 1, 555, false, false, 'classic', '01', 0);

insert into Users_Groups values (553, 14);

insert into Users_Orgs (userId, organizationId) values (553, 17);
insert into Users_Orgs (userId, organizationId) values (553, 43);

insert into Users_Roles values (553, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (558, 1, current_timestamp, current_timestamp, false, 559, 'test', false, false, 'lax95', 'test.lax.95@liferay.com', 'Welcome Test LAX 95!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (559, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 95', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (560, 1, 558, 9, 558, 0, 0, '560', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (561, 1, 560, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (562, 1, 560, false, false, 'classic', '01', 0);

insert into Users_Groups values (558, 14);

insert into Users_Orgs (userId, organizationId) values (558, 17);
insert into Users_Orgs (userId, organizationId) values (558, 43);

insert into Users_Roles values (558, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (563, 1, current_timestamp, current_timestamp, false, 564, 'test', false, false, 'lax96', 'test.lax.96@liferay.com', 'Welcome Test LAX 96!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (564, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 96', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (565, 1, 563, 9, 563, 0, 0, '565', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (566, 1, 565, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (567, 1, 565, false, false, 'classic', '01', 0);

insert into Users_Groups values (563, 14);

insert into Users_Orgs (userId, organizationId) values (563, 17);
insert into Users_Orgs (userId, organizationId) values (563, 43);

insert into Users_Roles values (563, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (568, 1, current_timestamp, current_timestamp, false, 569, 'test', false, false, 'lax97', 'test.lax.97@liferay.com', 'Welcome Test LAX 97!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (569, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 97', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (570, 1, 568, 9, 568, 0, 0, '570', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (571, 1, 570, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (572, 1, 570, false, false, 'classic', '01', 0);

insert into Users_Groups values (568, 14);

insert into Users_Orgs (userId, organizationId) values (568, 17);
insert into Users_Orgs (userId, organizationId) values (568, 43);

insert into Users_Roles values (568, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (573, 1, current_timestamp, current_timestamp, false, 574, 'test', false, false, 'lax98', 'test.lax.98@liferay.com', 'Welcome Test LAX 98!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (574, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 98', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (575, 1, 573, 9, 573, 0, 0, '575', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (576, 1, 575, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (577, 1, 575, false, false, 'classic', '01', 0);

insert into Users_Groups values (573, 14);

insert into Users_Orgs (userId, organizationId) values (573, 17);
insert into Users_Orgs (userId, organizationId) values (573, 43);

insert into Users_Roles values (573, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (578, 1, current_timestamp, current_timestamp, false, 579, 'test', false, false, 'lax99', 'test.lax.99@liferay.com', 'Welcome Test LAX 99!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (579, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 99', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (580, 1, 578, 9, 578, 0, 0, '580', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (581, 1, 580, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (582, 1, 580, false, false, 'classic', '01', 0);

insert into Users_Groups values (578, 14);

insert into Users_Orgs (userId, organizationId) values (578, 17);
insert into Users_Orgs (userId, organizationId) values (578, 43);

insert into Users_Roles values (578, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (583, 1, current_timestamp, current_timestamp, false, 584, 'test', false, false, 'lax100', 'test.lax.100@liferay.com', 'Welcome Test LAX 100!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (584, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'LAX 100', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (585, 1, 583, 9, 583, 0, 0, '585', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (586, 1, 585, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (587, 1, 585, false, false, 'classic', '01', 0);

insert into Users_Groups values (583, 14);

insert into Users_Orgs (userId, organizationId) values (583, 17);
insert into Users_Orgs (userId, organizationId) values (583, 43);

insert into Users_Roles values (583, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (588, 1, current_timestamp, current_timestamp, false, 589, 'test', false, false, 'sfo1', 'test.sfo.1@liferay.com', 'Welcome Test SFO 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (589, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (590, 1, 588, 9, 588, 0, 0, '590', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (591, 1, 590, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (592, 1, 590, false, false, 'classic', '01', 0);

insert into Users_Groups values (588, 14);

insert into Users_Orgs (userId, organizationId) values (588, 17);
insert into Users_Orgs (userId, organizationId) values (588, 47);

insert into Users_Roles values (588, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (593, 1, current_timestamp, current_timestamp, false, 594, 'test', false, false, 'sfo2', 'test.sfo.2@liferay.com', 'Welcome Test SFO 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (594, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (595, 1, 593, 9, 593, 0, 0, '595', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (596, 1, 595, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (597, 1, 595, false, false, 'classic', '01', 0);

insert into Users_Groups values (593, 14);

insert into Users_Orgs (userId, organizationId) values (593, 17);
insert into Users_Orgs (userId, organizationId) values (593, 47);

insert into Users_Roles values (593, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (598, 1, current_timestamp, current_timestamp, false, 599, 'test', false, false, 'sfo3', 'test.sfo.3@liferay.com', 'Welcome Test SFO 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (599, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (600, 1, 598, 9, 598, 0, 0, '600', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (601, 1, 600, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (602, 1, 600, false, false, 'classic', '01', 0);

insert into Users_Groups values (598, 14);

insert into Users_Orgs (userId, organizationId) values (598, 17);
insert into Users_Orgs (userId, organizationId) values (598, 47);

insert into Users_Roles values (598, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (603, 1, current_timestamp, current_timestamp, false, 604, 'test', false, false, 'sfo4', 'test.sfo.4@liferay.com', 'Welcome Test SFO 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (604, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (605, 1, 603, 9, 603, 0, 0, '605', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (606, 1, 605, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (607, 1, 605, false, false, 'classic', '01', 0);

insert into Users_Groups values (603, 14);

insert into Users_Orgs (userId, organizationId) values (603, 17);
insert into Users_Orgs (userId, organizationId) values (603, 47);

insert into Users_Roles values (603, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (608, 1, current_timestamp, current_timestamp, false, 609, 'test', false, false, 'sfo5', 'test.sfo.5@liferay.com', 'Welcome Test SFO 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (609, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (610, 1, 608, 9, 608, 0, 0, '610', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (611, 1, 610, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (612, 1, 610, false, false, 'classic', '01', 0);

insert into Users_Groups values (608, 14);

insert into Users_Orgs (userId, organizationId) values (608, 17);
insert into Users_Orgs (userId, organizationId) values (608, 47);

insert into Users_Roles values (608, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (613, 1, current_timestamp, current_timestamp, false, 614, 'test', false, false, 'sfo6', 'test.sfo.6@liferay.com', 'Welcome Test SFO 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (614, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (615, 1, 613, 9, 613, 0, 0, '615', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (616, 1, 615, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (617, 1, 615, false, false, 'classic', '01', 0);

insert into Users_Groups values (613, 14);

insert into Users_Orgs (userId, organizationId) values (613, 17);
insert into Users_Orgs (userId, organizationId) values (613, 47);

insert into Users_Roles values (613, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (618, 1, current_timestamp, current_timestamp, false, 619, 'test', false, false, 'sfo7', 'test.sfo.7@liferay.com', 'Welcome Test SFO 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (619, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (620, 1, 618, 9, 618, 0, 0, '620', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (621, 1, 620, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (622, 1, 620, false, false, 'classic', '01', 0);

insert into Users_Groups values (618, 14);

insert into Users_Orgs (userId, organizationId) values (618, 17);
insert into Users_Orgs (userId, organizationId) values (618, 47);

insert into Users_Roles values (618, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (623, 1, current_timestamp, current_timestamp, false, 624, 'test', false, false, 'sfo8', 'test.sfo.8@liferay.com', 'Welcome Test SFO 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (624, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (625, 1, 623, 9, 623, 0, 0, '625', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (626, 1, 625, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (627, 1, 625, false, false, 'classic', '01', 0);

insert into Users_Groups values (623, 14);

insert into Users_Orgs (userId, organizationId) values (623, 17);
insert into Users_Orgs (userId, organizationId) values (623, 47);

insert into Users_Roles values (623, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (628, 1, current_timestamp, current_timestamp, false, 629, 'test', false, false, 'sfo9', 'test.sfo.9@liferay.com', 'Welcome Test SFO 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (629, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (630, 1, 628, 9, 628, 0, 0, '630', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (631, 1, 630, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (632, 1, 630, false, false, 'classic', '01', 0);

insert into Users_Groups values (628, 14);

insert into Users_Orgs (userId, organizationId) values (628, 17);
insert into Users_Orgs (userId, organizationId) values (628, 47);

insert into Users_Roles values (628, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (633, 1, current_timestamp, current_timestamp, false, 634, 'test', false, false, 'sfo10', 'test.sfo.10@liferay.com', 'Welcome Test SFO 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (634, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'SFO 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (635, 1, 633, 9, 633, 0, 0, '635', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (636, 1, 635, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (637, 1, 635, false, false, 'classic', '01', 0);

insert into Users_Groups values (633, 14);

insert into Users_Orgs (userId, organizationId) values (633, 17);
insert into Users_Orgs (userId, organizationId) values (633, 47);

insert into Users_Roles values (633, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (638, 1, current_timestamp, current_timestamp, false, 639, 'test', false, false, 'ord1', 'test.ord.1@liferay.com', 'Welcome Test ORD 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (639, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (640, 1, 638, 9, 638, 0, 0, '640', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (641, 1, 640, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (642, 1, 640, false, false, 'classic', '01', 0);

insert into Users_Groups values (638, 14);

insert into Users_Orgs (userId, organizationId) values (638, 17);
insert into Users_Orgs (userId, organizationId) values (638, 51);

insert into Users_Roles values (638, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (643, 1, current_timestamp, current_timestamp, false, 644, 'test', false, false, 'ord2', 'test.ord.2@liferay.com', 'Welcome Test ORD 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (644, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (645, 1, 643, 9, 643, 0, 0, '645', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (646, 1, 645, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (647, 1, 645, false, false, 'classic', '01', 0);

insert into Users_Groups values (643, 14);

insert into Users_Orgs (userId, organizationId) values (643, 17);
insert into Users_Orgs (userId, organizationId) values (643, 51);

insert into Users_Roles values (643, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (648, 1, current_timestamp, current_timestamp, false, 649, 'test', false, false, 'ord3', 'test.ord.3@liferay.com', 'Welcome Test ORD 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (649, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (650, 1, 648, 9, 648, 0, 0, '650', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (651, 1, 650, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (652, 1, 650, false, false, 'classic', '01', 0);

insert into Users_Groups values (648, 14);

insert into Users_Orgs (userId, organizationId) values (648, 17);
insert into Users_Orgs (userId, organizationId) values (648, 51);

insert into Users_Roles values (648, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (653, 1, current_timestamp, current_timestamp, false, 654, 'test', false, false, 'ord4', 'test.ord.4@liferay.com', 'Welcome Test ORD 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (654, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (655, 1, 653, 9, 653, 0, 0, '655', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (656, 1, 655, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (657, 1, 655, false, false, 'classic', '01', 0);

insert into Users_Groups values (653, 14);

insert into Users_Orgs (userId, organizationId) values (653, 17);
insert into Users_Orgs (userId, organizationId) values (653, 51);

insert into Users_Roles values (653, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (658, 1, current_timestamp, current_timestamp, false, 659, 'test', false, false, 'ord5', 'test.ord.5@liferay.com', 'Welcome Test ORD 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (659, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (660, 1, 658, 9, 658, 0, 0, '660', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (661, 1, 660, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (662, 1, 660, false, false, 'classic', '01', 0);

insert into Users_Groups values (658, 14);

insert into Users_Orgs (userId, organizationId) values (658, 17);
insert into Users_Orgs (userId, organizationId) values (658, 51);

insert into Users_Roles values (658, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (663, 1, current_timestamp, current_timestamp, false, 664, 'test', false, false, 'ord6', 'test.ord.6@liferay.com', 'Welcome Test ORD 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (664, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (665, 1, 663, 9, 663, 0, 0, '665', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (666, 1, 665, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (667, 1, 665, false, false, 'classic', '01', 0);

insert into Users_Groups values (663, 14);

insert into Users_Orgs (userId, organizationId) values (663, 17);
insert into Users_Orgs (userId, organizationId) values (663, 51);

insert into Users_Roles values (663, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (668, 1, current_timestamp, current_timestamp, false, 669, 'test', false, false, 'ord7', 'test.ord.7@liferay.com', 'Welcome Test ORD 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (669, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (670, 1, 668, 9, 668, 0, 0, '670', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (671, 1, 670, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (672, 1, 670, false, false, 'classic', '01', 0);

insert into Users_Groups values (668, 14);

insert into Users_Orgs (userId, organizationId) values (668, 17);
insert into Users_Orgs (userId, organizationId) values (668, 51);

insert into Users_Roles values (668, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (673, 1, current_timestamp, current_timestamp, false, 674, 'test', false, false, 'ord8', 'test.ord.8@liferay.com', 'Welcome Test ORD 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (674, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (675, 1, 673, 9, 673, 0, 0, '675', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (676, 1, 675, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (677, 1, 675, false, false, 'classic', '01', 0);

insert into Users_Groups values (673, 14);

insert into Users_Orgs (userId, organizationId) values (673, 17);
insert into Users_Orgs (userId, organizationId) values (673, 51);

insert into Users_Roles values (673, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (678, 1, current_timestamp, current_timestamp, false, 679, 'test', false, false, 'ord9', 'test.ord.9@liferay.com', 'Welcome Test ORD 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (679, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (680, 1, 678, 9, 678, 0, 0, '680', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (681, 1, 680, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (682, 1, 680, false, false, 'classic', '01', 0);

insert into Users_Groups values (678, 14);

insert into Users_Orgs (userId, organizationId) values (678, 17);
insert into Users_Orgs (userId, organizationId) values (678, 51);

insert into Users_Roles values (678, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (683, 1, current_timestamp, current_timestamp, false, 684, 'test', false, false, 'ord10', 'test.ord.10@liferay.com', 'Welcome Test ORD 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (684, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'ORD 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (685, 1, 683, 9, 683, 0, 0, '685', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (686, 1, 685, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (687, 1, 685, false, false, 'classic', '01', 0);

insert into Users_Groups values (683, 14);

insert into Users_Orgs (userId, organizationId) values (683, 17);
insert into Users_Orgs (userId, organizationId) values (683, 51);

insert into Users_Roles values (683, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (688, 1, current_timestamp, current_timestamp, false, 689, 'test', false, false, 'nyc1', 'test.nyc.1@liferay.com', 'Welcome Test NYC 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (689, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (690, 1, 688, 9, 688, 0, 0, '690', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (691, 1, 690, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (692, 1, 690, false, false, 'classic', '01', 0);

insert into Users_Groups values (688, 14);

insert into Users_Orgs (userId, organizationId) values (688, 17);
insert into Users_Orgs (userId, organizationId) values (688, 55);

insert into Users_Roles values (688, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (693, 1, current_timestamp, current_timestamp, false, 694, 'test', false, false, 'nyc2', 'test.nyc.2@liferay.com', 'Welcome Test NYC 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (694, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (695, 1, 693, 9, 693, 0, 0, '695', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (696, 1, 695, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (697, 1, 695, false, false, 'classic', '01', 0);

insert into Users_Groups values (693, 14);

insert into Users_Orgs (userId, organizationId) values (693, 17);
insert into Users_Orgs (userId, organizationId) values (693, 55);

insert into Users_Roles values (693, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (698, 1, current_timestamp, current_timestamp, false, 699, 'test', false, false, 'nyc3', 'test.nyc.3@liferay.com', 'Welcome Test NYC 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (699, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (700, 1, 698, 9, 698, 0, 0, '700', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (701, 1, 700, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (702, 1, 700, false, false, 'classic', '01', 0);

insert into Users_Groups values (698, 14);

insert into Users_Orgs (userId, organizationId) values (698, 17);
insert into Users_Orgs (userId, organizationId) values (698, 55);

insert into Users_Roles values (698, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (703, 1, current_timestamp, current_timestamp, false, 704, 'test', false, false, 'nyc4', 'test.nyc.4@liferay.com', 'Welcome Test NYC 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (704, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (705, 1, 703, 9, 703, 0, 0, '705', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (706, 1, 705, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (707, 1, 705, false, false, 'classic', '01', 0);

insert into Users_Groups values (703, 14);

insert into Users_Orgs (userId, organizationId) values (703, 17);
insert into Users_Orgs (userId, organizationId) values (703, 55);

insert into Users_Roles values (703, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (708, 1, current_timestamp, current_timestamp, false, 709, 'test', false, false, 'nyc5', 'test.nyc.5@liferay.com', 'Welcome Test NYC 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (709, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (710, 1, 708, 9, 708, 0, 0, '710', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (711, 1, 710, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (712, 1, 710, false, false, 'classic', '01', 0);

insert into Users_Groups values (708, 14);

insert into Users_Orgs (userId, organizationId) values (708, 17);
insert into Users_Orgs (userId, organizationId) values (708, 55);

insert into Users_Roles values (708, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (713, 1, current_timestamp, current_timestamp, false, 714, 'test', false, false, 'nyc6', 'test.nyc.6@liferay.com', 'Welcome Test NYC 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (714, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (715, 1, 713, 9, 713, 0, 0, '715', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (716, 1, 715, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (717, 1, 715, false, false, 'classic', '01', 0);

insert into Users_Groups values (713, 14);

insert into Users_Orgs (userId, organizationId) values (713, 17);
insert into Users_Orgs (userId, organizationId) values (713, 55);

insert into Users_Roles values (713, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (718, 1, current_timestamp, current_timestamp, false, 719, 'test', false, false, 'nyc7', 'test.nyc.7@liferay.com', 'Welcome Test NYC 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (719, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (720, 1, 718, 9, 718, 0, 0, '720', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (721, 1, 720, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (722, 1, 720, false, false, 'classic', '01', 0);

insert into Users_Groups values (718, 14);

insert into Users_Orgs (userId, organizationId) values (718, 17);
insert into Users_Orgs (userId, organizationId) values (718, 55);

insert into Users_Roles values (718, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (723, 1, current_timestamp, current_timestamp, false, 724, 'test', false, false, 'nyc8', 'test.nyc.8@liferay.com', 'Welcome Test NYC 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (724, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (725, 1, 723, 9, 723, 0, 0, '725', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (726, 1, 725, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (727, 1, 725, false, false, 'classic', '01', 0);

insert into Users_Groups values (723, 14);

insert into Users_Orgs (userId, organizationId) values (723, 17);
insert into Users_Orgs (userId, organizationId) values (723, 55);

insert into Users_Roles values (723, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (728, 1, current_timestamp, current_timestamp, false, 729, 'test', false, false, 'nyc9', 'test.nyc.9@liferay.com', 'Welcome Test NYC 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (729, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (730, 1, 728, 9, 728, 0, 0, '730', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (731, 1, 730, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (732, 1, 730, false, false, 'classic', '01', 0);

insert into Users_Groups values (728, 14);

insert into Users_Orgs (userId, organizationId) values (728, 17);
insert into Users_Orgs (userId, organizationId) values (728, 55);

insert into Users_Roles values (728, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (733, 1, current_timestamp, current_timestamp, false, 734, 'test', false, false, 'nyc10', 'test.nyc.10@liferay.com', 'Welcome Test NYC 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (734, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'NYC 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (735, 1, 733, 9, 733, 0, 0, '735', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (736, 1, 735, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (737, 1, 735, false, false, 'classic', '01', 0);

insert into Users_Groups values (733, 14);

insert into Users_Orgs (userId, organizationId) values (733, 17);
insert into Users_Orgs (userId, organizationId) values (733, 55);

insert into Users_Roles values (733, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (738, 1, current_timestamp, current_timestamp, false, 739, 'test', false, false, 'gru1', 'test.gru.1@liferay.com', 'Welcome Test GRU 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (739, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (740, 1, 738, 9, 738, 0, 0, '740', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (741, 1, 740, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (742, 1, 740, false, false, 'classic', '01', 0);

insert into Users_Groups values (738, 14);

insert into Users_Orgs (userId, organizationId) values (738, 17);
insert into Users_Orgs (userId, organizationId) values (738, 59);

insert into Users_Roles values (738, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (743, 1, current_timestamp, current_timestamp, false, 744, 'test', false, false, 'gru2', 'test.gru.2@liferay.com', 'Welcome Test GRU 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (744, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (745, 1, 743, 9, 743, 0, 0, '745', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (746, 1, 745, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (747, 1, 745, false, false, 'classic', '01', 0);

insert into Users_Groups values (743, 14);

insert into Users_Orgs (userId, organizationId) values (743, 17);
insert into Users_Orgs (userId, organizationId) values (743, 59);

insert into Users_Roles values (743, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (748, 1, current_timestamp, current_timestamp, false, 749, 'test', false, false, 'gru3', 'test.gru.3@liferay.com', 'Welcome Test GRU 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (749, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (750, 1, 748, 9, 748, 0, 0, '750', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (751, 1, 750, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (752, 1, 750, false, false, 'classic', '01', 0);

insert into Users_Groups values (748, 14);

insert into Users_Orgs (userId, organizationId) values (748, 17);
insert into Users_Orgs (userId, organizationId) values (748, 59);

insert into Users_Roles values (748, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (753, 1, current_timestamp, current_timestamp, false, 754, 'test', false, false, 'gru4', 'test.gru.4@liferay.com', 'Welcome Test GRU 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (754, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (755, 1, 753, 9, 753, 0, 0, '755', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (756, 1, 755, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (757, 1, 755, false, false, 'classic', '01', 0);

insert into Users_Groups values (753, 14);

insert into Users_Orgs (userId, organizationId) values (753, 17);
insert into Users_Orgs (userId, organizationId) values (753, 59);

insert into Users_Roles values (753, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (758, 1, current_timestamp, current_timestamp, false, 759, 'test', false, false, 'gru5', 'test.gru.5@liferay.com', 'Welcome Test GRU 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (759, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (760, 1, 758, 9, 758, 0, 0, '760', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (761, 1, 760, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (762, 1, 760, false, false, 'classic', '01', 0);

insert into Users_Groups values (758, 14);

insert into Users_Orgs (userId, organizationId) values (758, 17);
insert into Users_Orgs (userId, organizationId) values (758, 59);

insert into Users_Roles values (758, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (763, 1, current_timestamp, current_timestamp, false, 764, 'test', false, false, 'gru6', 'test.gru.6@liferay.com', 'Welcome Test GRU 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (764, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (765, 1, 763, 9, 763, 0, 0, '765', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (766, 1, 765, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (767, 1, 765, false, false, 'classic', '01', 0);

insert into Users_Groups values (763, 14);

insert into Users_Orgs (userId, organizationId) values (763, 17);
insert into Users_Orgs (userId, organizationId) values (763, 59);

insert into Users_Roles values (763, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (768, 1, current_timestamp, current_timestamp, false, 769, 'test', false, false, 'gru7', 'test.gru.7@liferay.com', 'Welcome Test GRU 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (769, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (770, 1, 768, 9, 768, 0, 0, '770', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (771, 1, 770, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (772, 1, 770, false, false, 'classic', '01', 0);

insert into Users_Groups values (768, 14);

insert into Users_Orgs (userId, organizationId) values (768, 17);
insert into Users_Orgs (userId, organizationId) values (768, 59);

insert into Users_Roles values (768, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (773, 1, current_timestamp, current_timestamp, false, 774, 'test', false, false, 'gru8', 'test.gru.8@liferay.com', 'Welcome Test GRU 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (774, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (775, 1, 773, 9, 773, 0, 0, '775', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (776, 1, 775, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (777, 1, 775, false, false, 'classic', '01', 0);

insert into Users_Groups values (773, 14);

insert into Users_Orgs (userId, organizationId) values (773, 17);
insert into Users_Orgs (userId, organizationId) values (773, 59);

insert into Users_Roles values (773, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (778, 1, current_timestamp, current_timestamp, false, 779, 'test', false, false, 'gru9', 'test.gru.9@liferay.com', 'Welcome Test GRU 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (779, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (780, 1, 778, 9, 778, 0, 0, '780', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (781, 1, 780, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (782, 1, 780, false, false, 'classic', '01', 0);

insert into Users_Groups values (778, 14);

insert into Users_Orgs (userId, organizationId) values (778, 17);
insert into Users_Orgs (userId, organizationId) values (778, 59);

insert into Users_Roles values (778, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (783, 1, current_timestamp, current_timestamp, false, 784, 'test', false, false, 'gru10', 'test.gru.10@liferay.com', 'Welcome Test GRU 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (784, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'GRU 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (785, 1, 783, 9, 783, 0, 0, '785', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (786, 1, 785, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (787, 1, 785, false, false, 'classic', '01', 0);

insert into Users_Groups values (783, 14);

insert into Users_Orgs (userId, organizationId) values (783, 17);
insert into Users_Orgs (userId, organizationId) values (783, 59);

insert into Users_Roles values (783, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (788, 1, current_timestamp, current_timestamp, false, 789, 'test', false, false, 'fra1', 'test.fra.1@liferay.com', 'Welcome Test FRA 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (789, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (790, 1, 788, 9, 788, 0, 0, '790', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (791, 1, 790, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (792, 1, 790, false, false, 'classic', '01', 0);

insert into Users_Groups values (788, 14);

insert into Users_Orgs (userId, organizationId) values (788, 17);
insert into Users_Orgs (userId, organizationId) values (788, 63);

insert into Users_Roles values (788, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (793, 1, current_timestamp, current_timestamp, false, 794, 'test', false, false, 'fra2', 'test.fra.2@liferay.com', 'Welcome Test FRA 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (794, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (795, 1, 793, 9, 793, 0, 0, '795', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (796, 1, 795, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (797, 1, 795, false, false, 'classic', '01', 0);

insert into Users_Groups values (793, 14);

insert into Users_Orgs (userId, organizationId) values (793, 17);
insert into Users_Orgs (userId, organizationId) values (793, 63);

insert into Users_Roles values (793, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (798, 1, current_timestamp, current_timestamp, false, 799, 'test', false, false, 'fra3', 'test.fra.3@liferay.com', 'Welcome Test FRA 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (799, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (800, 1, 798, 9, 798, 0, 0, '800', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (801, 1, 800, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (802, 1, 800, false, false, 'classic', '01', 0);

insert into Users_Groups values (798, 14);

insert into Users_Orgs (userId, organizationId) values (798, 17);
insert into Users_Orgs (userId, organizationId) values (798, 63);

insert into Users_Roles values (798, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (803, 1, current_timestamp, current_timestamp, false, 804, 'test', false, false, 'fra4', 'test.fra.4@liferay.com', 'Welcome Test FRA 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (804, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (805, 1, 803, 9, 803, 0, 0, '805', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (806, 1, 805, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (807, 1, 805, false, false, 'classic', '01', 0);

insert into Users_Groups values (803, 14);

insert into Users_Orgs (userId, organizationId) values (803, 17);
insert into Users_Orgs (userId, organizationId) values (803, 63);

insert into Users_Roles values (803, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (808, 1, current_timestamp, current_timestamp, false, 809, 'test', false, false, 'fra5', 'test.fra.5@liferay.com', 'Welcome Test FRA 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (809, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (810, 1, 808, 9, 808, 0, 0, '810', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (811, 1, 810, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (812, 1, 810, false, false, 'classic', '01', 0);

insert into Users_Groups values (808, 14);

insert into Users_Orgs (userId, organizationId) values (808, 17);
insert into Users_Orgs (userId, organizationId) values (808, 63);

insert into Users_Roles values (808, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (813, 1, current_timestamp, current_timestamp, false, 814, 'test', false, false, 'fra6', 'test.fra.6@liferay.com', 'Welcome Test FRA 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (814, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (815, 1, 813, 9, 813, 0, 0, '815', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (816, 1, 815, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (817, 1, 815, false, false, 'classic', '01', 0);

insert into Users_Groups values (813, 14);

insert into Users_Orgs (userId, organizationId) values (813, 17);
insert into Users_Orgs (userId, organizationId) values (813, 63);

insert into Users_Roles values (813, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (818, 1, current_timestamp, current_timestamp, false, 819, 'test', false, false, 'fra7', 'test.fra.7@liferay.com', 'Welcome Test FRA 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (819, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (820, 1, 818, 9, 818, 0, 0, '820', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (821, 1, 820, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (822, 1, 820, false, false, 'classic', '01', 0);

insert into Users_Groups values (818, 14);

insert into Users_Orgs (userId, organizationId) values (818, 17);
insert into Users_Orgs (userId, organizationId) values (818, 63);

insert into Users_Roles values (818, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (823, 1, current_timestamp, current_timestamp, false, 824, 'test', false, false, 'fra8', 'test.fra.8@liferay.com', 'Welcome Test FRA 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (824, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (825, 1, 823, 9, 823, 0, 0, '825', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (826, 1, 825, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (827, 1, 825, false, false, 'classic', '01', 0);

insert into Users_Groups values (823, 14);

insert into Users_Orgs (userId, organizationId) values (823, 17);
insert into Users_Orgs (userId, organizationId) values (823, 63);

insert into Users_Roles values (823, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (828, 1, current_timestamp, current_timestamp, false, 829, 'test', false, false, 'fra9', 'test.fra.9@liferay.com', 'Welcome Test FRA 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (829, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (830, 1, 828, 9, 828, 0, 0, '830', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (831, 1, 830, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (832, 1, 830, false, false, 'classic', '01', 0);

insert into Users_Groups values (828, 14);

insert into Users_Orgs (userId, organizationId) values (828, 17);
insert into Users_Orgs (userId, organizationId) values (828, 63);

insert into Users_Roles values (828, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (833, 1, current_timestamp, current_timestamp, false, 834, 'test', false, false, 'fra10', 'test.fra.10@liferay.com', 'Welcome Test FRA 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (834, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'FRA 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (835, 1, 833, 9, 833, 0, 0, '835', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (836, 1, 835, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (837, 1, 835, false, false, 'classic', '01', 0);

insert into Users_Groups values (833, 14);

insert into Users_Orgs (userId, organizationId) values (833, 17);
insert into Users_Orgs (userId, organizationId) values (833, 63);

insert into Users_Roles values (833, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (838, 1, current_timestamp, current_timestamp, false, 839, 'test', false, false, 'mad1', 'test.mad.1@liferay.com', 'Welcome Test MAD 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (839, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (840, 1, 838, 9, 838, 0, 0, '840', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (841, 1, 840, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (842, 1, 840, false, false, 'classic', '01', 0);

insert into Users_Groups values (838, 14);

insert into Users_Orgs (userId, organizationId) values (838, 17);
insert into Users_Orgs (userId, organizationId) values (838, 67);

insert into Users_Roles values (838, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (843, 1, current_timestamp, current_timestamp, false, 844, 'test', false, false, 'mad2', 'test.mad.2@liferay.com', 'Welcome Test MAD 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (844, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (845, 1, 843, 9, 843, 0, 0, '845', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (846, 1, 845, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (847, 1, 845, false, false, 'classic', '01', 0);

insert into Users_Groups values (843, 14);

insert into Users_Orgs (userId, organizationId) values (843, 17);
insert into Users_Orgs (userId, organizationId) values (843, 67);

insert into Users_Roles values (843, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (848, 1, current_timestamp, current_timestamp, false, 849, 'test', false, false, 'mad3', 'test.mad.3@liferay.com', 'Welcome Test MAD 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (849, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (850, 1, 848, 9, 848, 0, 0, '850', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (851, 1, 850, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (852, 1, 850, false, false, 'classic', '01', 0);

insert into Users_Groups values (848, 14);

insert into Users_Orgs (userId, organizationId) values (848, 17);
insert into Users_Orgs (userId, organizationId) values (848, 67);

insert into Users_Roles values (848, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (853, 1, current_timestamp, current_timestamp, false, 854, 'test', false, false, 'mad4', 'test.mad.4@liferay.com', 'Welcome Test MAD 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (854, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (855, 1, 853, 9, 853, 0, 0, '855', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (856, 1, 855, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (857, 1, 855, false, false, 'classic', '01', 0);

insert into Users_Groups values (853, 14);

insert into Users_Orgs (userId, organizationId) values (853, 17);
insert into Users_Orgs (userId, organizationId) values (853, 67);

insert into Users_Roles values (853, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (858, 1, current_timestamp, current_timestamp, false, 859, 'test', false, false, 'mad5', 'test.mad.5@liferay.com', 'Welcome Test MAD 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (859, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (860, 1, 858, 9, 858, 0, 0, '860', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (861, 1, 860, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (862, 1, 860, false, false, 'classic', '01', 0);

insert into Users_Groups values (858, 14);

insert into Users_Orgs (userId, organizationId) values (858, 17);
insert into Users_Orgs (userId, organizationId) values (858, 67);

insert into Users_Roles values (858, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (863, 1, current_timestamp, current_timestamp, false, 864, 'test', false, false, 'mad6', 'test.mad.6@liferay.com', 'Welcome Test MAD 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (864, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (865, 1, 863, 9, 863, 0, 0, '865', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (866, 1, 865, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (867, 1, 865, false, false, 'classic', '01', 0);

insert into Users_Groups values (863, 14);

insert into Users_Orgs (userId, organizationId) values (863, 17);
insert into Users_Orgs (userId, organizationId) values (863, 67);

insert into Users_Roles values (863, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (868, 1, current_timestamp, current_timestamp, false, 869, 'test', false, false, 'mad7', 'test.mad.7@liferay.com', 'Welcome Test MAD 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (869, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (870, 1, 868, 9, 868, 0, 0, '870', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (871, 1, 870, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (872, 1, 870, false, false, 'classic', '01', 0);

insert into Users_Groups values (868, 14);

insert into Users_Orgs (userId, organizationId) values (868, 17);
insert into Users_Orgs (userId, organizationId) values (868, 67);

insert into Users_Roles values (868, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (873, 1, current_timestamp, current_timestamp, false, 874, 'test', false, false, 'mad8', 'test.mad.8@liferay.com', 'Welcome Test MAD 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (874, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (875, 1, 873, 9, 873, 0, 0, '875', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (876, 1, 875, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (877, 1, 875, false, false, 'classic', '01', 0);

insert into Users_Groups values (873, 14);

insert into Users_Orgs (userId, organizationId) values (873, 17);
insert into Users_Orgs (userId, organizationId) values (873, 67);

insert into Users_Roles values (873, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (878, 1, current_timestamp, current_timestamp, false, 879, 'test', false, false, 'mad9', 'test.mad.9@liferay.com', 'Welcome Test MAD 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (879, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (880, 1, 878, 9, 878, 0, 0, '880', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (881, 1, 880, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (882, 1, 880, false, false, 'classic', '01', 0);

insert into Users_Groups values (878, 14);

insert into Users_Orgs (userId, organizationId) values (878, 17);
insert into Users_Orgs (userId, organizationId) values (878, 67);

insert into Users_Roles values (878, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (883, 1, current_timestamp, current_timestamp, false, 884, 'test', false, false, 'mad10', 'test.mad.10@liferay.com', 'Welcome Test MAD 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (884, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'MAD 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (885, 1, 883, 9, 883, 0, 0, '885', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (886, 1, 885, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (887, 1, 885, false, false, 'classic', '01', 0);

insert into Users_Groups values (883, 14);

insert into Users_Orgs (userId, organizationId) values (883, 17);
insert into Users_Orgs (userId, organizationId) values (883, 67);

insert into Users_Roles values (883, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (888, 1, current_timestamp, current_timestamp, false, 889, 'test', false, false, 'dlc1', 'test.dlc.1@liferay.com', 'Welcome Test DLC 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (889, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (890, 1, 888, 9, 888, 0, 0, '890', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (891, 1, 890, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (892, 1, 890, false, false, 'classic', '01', 0);

insert into Users_Groups values (888, 14);

insert into Users_Orgs (userId, organizationId) values (888, 17);
insert into Users_Orgs (userId, organizationId) values (888, 71);

insert into Users_Roles values (888, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (893, 1, current_timestamp, current_timestamp, false, 894, 'test', false, false, 'dlc2', 'test.dlc.2@liferay.com', 'Welcome Test DLC 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (894, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (895, 1, 893, 9, 893, 0, 0, '895', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (896, 1, 895, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (897, 1, 895, false, false, 'classic', '01', 0);

insert into Users_Groups values (893, 14);

insert into Users_Orgs (userId, organizationId) values (893, 17);
insert into Users_Orgs (userId, organizationId) values (893, 71);

insert into Users_Roles values (893, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (898, 1, current_timestamp, current_timestamp, false, 899, 'test', false, false, 'dlc3', 'test.dlc.3@liferay.com', 'Welcome Test DLC 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (899, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (900, 1, 898, 9, 898, 0, 0, '900', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (901, 1, 900, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (902, 1, 900, false, false, 'classic', '01', 0);

insert into Users_Groups values (898, 14);

insert into Users_Orgs (userId, organizationId) values (898, 17);
insert into Users_Orgs (userId, organizationId) values (898, 71);

insert into Users_Roles values (898, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (903, 1, current_timestamp, current_timestamp, false, 904, 'test', false, false, 'dlc4', 'test.dlc.4@liferay.com', 'Welcome Test DLC 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (904, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (905, 1, 903, 9, 903, 0, 0, '905', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (906, 1, 905, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (907, 1, 905, false, false, 'classic', '01', 0);

insert into Users_Groups values (903, 14);

insert into Users_Orgs (userId, organizationId) values (903, 17);
insert into Users_Orgs (userId, organizationId) values (903, 71);

insert into Users_Roles values (903, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (908, 1, current_timestamp, current_timestamp, false, 909, 'test', false, false, 'dlc5', 'test.dlc.5@liferay.com', 'Welcome Test DLC 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (909, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (910, 1, 908, 9, 908, 0, 0, '910', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (911, 1, 910, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (912, 1, 910, false, false, 'classic', '01', 0);

insert into Users_Groups values (908, 14);

insert into Users_Orgs (userId, organizationId) values (908, 17);
insert into Users_Orgs (userId, organizationId) values (908, 71);

insert into Users_Roles values (908, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (913, 1, current_timestamp, current_timestamp, false, 914, 'test', false, false, 'dlc6', 'test.dlc.6@liferay.com', 'Welcome Test DLC 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (914, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (915, 1, 913, 9, 913, 0, 0, '915', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (916, 1, 915, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (917, 1, 915, false, false, 'classic', '01', 0);

insert into Users_Groups values (913, 14);

insert into Users_Orgs (userId, organizationId) values (913, 17);
insert into Users_Orgs (userId, organizationId) values (913, 71);

insert into Users_Roles values (913, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (918, 1, current_timestamp, current_timestamp, false, 919, 'test', false, false, 'dlc7', 'test.dlc.7@liferay.com', 'Welcome Test DLC 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (919, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (920, 1, 918, 9, 918, 0, 0, '920', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (921, 1, 920, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (922, 1, 920, false, false, 'classic', '01', 0);

insert into Users_Groups values (918, 14);

insert into Users_Orgs (userId, organizationId) values (918, 17);
insert into Users_Orgs (userId, organizationId) values (918, 71);

insert into Users_Roles values (918, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (923, 1, current_timestamp, current_timestamp, false, 924, 'test', false, false, 'dlc8', 'test.dlc.8@liferay.com', 'Welcome Test DLC 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (924, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (925, 1, 923, 9, 923, 0, 0, '925', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (926, 1, 925, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (927, 1, 925, false, false, 'classic', '01', 0);

insert into Users_Groups values (923, 14);

insert into Users_Orgs (userId, organizationId) values (923, 17);
insert into Users_Orgs (userId, organizationId) values (923, 71);

insert into Users_Roles values (923, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (928, 1, current_timestamp, current_timestamp, false, 929, 'test', false, false, 'dlc9', 'test.dlc.9@liferay.com', 'Welcome Test DLC 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (929, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (930, 1, 928, 9, 928, 0, 0, '930', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (931, 1, 930, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (932, 1, 930, false, false, 'classic', '01', 0);

insert into Users_Groups values (928, 14);

insert into Users_Orgs (userId, organizationId) values (928, 17);
insert into Users_Orgs (userId, organizationId) values (928, 71);

insert into Users_Roles values (928, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (933, 1, current_timestamp, current_timestamp, false, 934, 'test', false, false, 'dlc10', 'test.dlc.10@liferay.com', 'Welcome Test DLC 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (934, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'DLC 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (935, 1, 933, 9, 933, 0, 0, '935', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (936, 1, 935, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (937, 1, 935, false, false, 'classic', '01', 0);

insert into Users_Groups values (933, 14);

insert into Users_Orgs (userId, organizationId) values (933, 17);
insert into Users_Orgs (userId, organizationId) values (933, 71);

insert into Users_Roles values (933, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (938, 1, current_timestamp, current_timestamp, false, 939, 'test', false, false, 'hkg1', 'test.hkg.1@liferay.com', 'Welcome Test HKG 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (939, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (940, 1, 938, 9, 938, 0, 0, '940', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (941, 1, 940, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (942, 1, 940, false, false, 'classic', '01', 0);

insert into Users_Groups values (938, 14);

insert into Users_Orgs (userId, organizationId) values (938, 17);
insert into Users_Orgs (userId, organizationId) values (938, 75);

insert into Users_Roles values (938, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (943, 1, current_timestamp, current_timestamp, false, 944, 'test', false, false, 'hkg2', 'test.hkg.2@liferay.com', 'Welcome Test HKG 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (944, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (945, 1, 943, 9, 943, 0, 0, '945', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (946, 1, 945, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (947, 1, 945, false, false, 'classic', '01', 0);

insert into Users_Groups values (943, 14);

insert into Users_Orgs (userId, organizationId) values (943, 17);
insert into Users_Orgs (userId, organizationId) values (943, 75);

insert into Users_Roles values (943, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (948, 1, current_timestamp, current_timestamp, false, 949, 'test', false, false, 'hkg3', 'test.hkg.3@liferay.com', 'Welcome Test HKG 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (949, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (950, 1, 948, 9, 948, 0, 0, '950', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (951, 1, 950, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (952, 1, 950, false, false, 'classic', '01', 0);

insert into Users_Groups values (948, 14);

insert into Users_Orgs (userId, organizationId) values (948, 17);
insert into Users_Orgs (userId, organizationId) values (948, 75);

insert into Users_Roles values (948, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (953, 1, current_timestamp, current_timestamp, false, 954, 'test', false, false, 'hkg4', 'test.hkg.4@liferay.com', 'Welcome Test HKG 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (954, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (955, 1, 953, 9, 953, 0, 0, '955', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (956, 1, 955, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (957, 1, 955, false, false, 'classic', '01', 0);

insert into Users_Groups values (953, 14);

insert into Users_Orgs (userId, organizationId) values (953, 17);
insert into Users_Orgs (userId, organizationId) values (953, 75);

insert into Users_Roles values (953, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (958, 1, current_timestamp, current_timestamp, false, 959, 'test', false, false, 'hkg5', 'test.hkg.5@liferay.com', 'Welcome Test HKG 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (959, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (960, 1, 958, 9, 958, 0, 0, '960', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (961, 1, 960, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (962, 1, 960, false, false, 'classic', '01', 0);

insert into Users_Groups values (958, 14);

insert into Users_Orgs (userId, organizationId) values (958, 17);
insert into Users_Orgs (userId, organizationId) values (958, 75);

insert into Users_Roles values (958, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (963, 1, current_timestamp, current_timestamp, false, 964, 'test', false, false, 'hkg6', 'test.hkg.6@liferay.com', 'Welcome Test HKG 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (964, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (965, 1, 963, 9, 963, 0, 0, '965', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (966, 1, 965, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (967, 1, 965, false, false, 'classic', '01', 0);

insert into Users_Groups values (963, 14);

insert into Users_Orgs (userId, organizationId) values (963, 17);
insert into Users_Orgs (userId, organizationId) values (963, 75);

insert into Users_Roles values (963, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (968, 1, current_timestamp, current_timestamp, false, 969, 'test', false, false, 'hkg7', 'test.hkg.7@liferay.com', 'Welcome Test HKG 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (969, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (970, 1, 968, 9, 968, 0, 0, '970', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (971, 1, 970, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (972, 1, 970, false, false, 'classic', '01', 0);

insert into Users_Groups values (968, 14);

insert into Users_Orgs (userId, organizationId) values (968, 17);
insert into Users_Orgs (userId, organizationId) values (968, 75);

insert into Users_Roles values (968, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (973, 1, current_timestamp, current_timestamp, false, 974, 'test', false, false, 'hkg8', 'test.hkg.8@liferay.com', 'Welcome Test HKG 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (974, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (975, 1, 973, 9, 973, 0, 0, '975', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (976, 1, 975, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (977, 1, 975, false, false, 'classic', '01', 0);

insert into Users_Groups values (973, 14);

insert into Users_Orgs (userId, organizationId) values (973, 17);
insert into Users_Orgs (userId, organizationId) values (973, 75);

insert into Users_Roles values (973, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (978, 1, current_timestamp, current_timestamp, false, 979, 'test', false, false, 'hkg9', 'test.hkg.9@liferay.com', 'Welcome Test HKG 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (979, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (980, 1, 978, 9, 978, 0, 0, '980', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (981, 1, 980, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (982, 1, 980, false, false, 'classic', '01', 0);

insert into Users_Groups values (978, 14);

insert into Users_Orgs (userId, organizationId) values (978, 17);
insert into Users_Orgs (userId, organizationId) values (978, 75);

insert into Users_Roles values (978, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (983, 1, current_timestamp, current_timestamp, false, 984, 'test', false, false, 'hkg10', 'test.hkg.10@liferay.com', 'Welcome Test HKG 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (984, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'HKG 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (985, 1, 983, 9, 983, 0, 0, '985', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (986, 1, 985, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (987, 1, 985, false, false, 'classic', '01', 0);

insert into Users_Groups values (983, 14);

insert into Users_Orgs (userId, organizationId) values (983, 17);
insert into Users_Orgs (userId, organizationId) values (983, 75);

insert into Users_Roles values (983, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (988, 1, current_timestamp, current_timestamp, false, 989, 'test', false, false, 'kul1', 'test.kul.1@liferay.com', 'Welcome Test KUL 1!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (989, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 1', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (990, 1, 988, 9, 988, 0, 0, '990', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (991, 1, 990, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (992, 1, 990, false, false, 'classic', '01', 0);

insert into Users_Groups values (988, 14);

insert into Users_Orgs (userId, organizationId) values (988, 17);
insert into Users_Orgs (userId, organizationId) values (988, 79);

insert into Users_Roles values (988, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (993, 1, current_timestamp, current_timestamp, false, 994, 'test', false, false, 'kul2', 'test.kul.2@liferay.com', 'Welcome Test KUL 2!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (994, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 2', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (995, 1, 993, 9, 993, 0, 0, '995', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (996, 1, 995, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (997, 1, 995, false, false, 'classic', '01', 0);

insert into Users_Groups values (993, 14);

insert into Users_Orgs (userId, organizationId) values (993, 17);
insert into Users_Orgs (userId, organizationId) values (993, 79);

insert into Users_Roles values (993, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (998, 1, current_timestamp, current_timestamp, false, 999, 'test', false, false, 'kul3', 'test.kul.3@liferay.com', 'Welcome Test KUL 3!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (999, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 3', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1000, 1, 998, 9, 998, 0, 0, '1000', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1001, 1, 1000, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1002, 1, 1000, false, false, 'classic', '01', 0);

insert into Users_Groups values (998, 14);

insert into Users_Orgs (userId, organizationId) values (998, 17);
insert into Users_Orgs (userId, organizationId) values (998, 79);

insert into Users_Roles values (998, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1003, 1, current_timestamp, current_timestamp, false, 1004, 'test', false, false, 'kul4', 'test.kul.4@liferay.com', 'Welcome Test KUL 4!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1004, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 4', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1005, 1, 1003, 9, 1003, 0, 0, '1005', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1006, 1, 1005, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1007, 1, 1005, false, false, 'classic', '01', 0);

insert into Users_Groups values (1003, 14);

insert into Users_Orgs (userId, organizationId) values (1003, 17);
insert into Users_Orgs (userId, organizationId) values (1003, 79);

insert into Users_Roles values (1003, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1008, 1, current_timestamp, current_timestamp, false, 1009, 'test', false, false, 'kul5', 'test.kul.5@liferay.com', 'Welcome Test KUL 5!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1009, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 5', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1010, 1, 1008, 9, 1008, 0, 0, '1010', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1011, 1, 1010, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1012, 1, 1010, false, false, 'classic', '01', 0);

insert into Users_Groups values (1008, 14);

insert into Users_Orgs (userId, organizationId) values (1008, 17);
insert into Users_Orgs (userId, organizationId) values (1008, 79);

insert into Users_Roles values (1008, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1013, 1, current_timestamp, current_timestamp, false, 1014, 'test', false, false, 'kul6', 'test.kul.6@liferay.com', 'Welcome Test KUL 6!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1014, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 6', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1015, 1, 1013, 9, 1013, 0, 0, '1015', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1016, 1, 1015, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1017, 1, 1015, false, false, 'classic', '01', 0);

insert into Users_Groups values (1013, 14);

insert into Users_Orgs (userId, organizationId) values (1013, 17);
insert into Users_Orgs (userId, organizationId) values (1013, 79);

insert into Users_Roles values (1013, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1018, 1, current_timestamp, current_timestamp, false, 1019, 'test', false, false, 'kul7', 'test.kul.7@liferay.com', 'Welcome Test KUL 7!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1019, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 7', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1020, 1, 1018, 9, 1018, 0, 0, '1020', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1021, 1, 1020, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1022, 1, 1020, false, false, 'classic', '01', 0);

insert into Users_Groups values (1018, 14);

insert into Users_Orgs (userId, organizationId) values (1018, 17);
insert into Users_Orgs (userId, organizationId) values (1018, 79);

insert into Users_Roles values (1018, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1023, 1, current_timestamp, current_timestamp, false, 1024, 'test', false, false, 'kul8', 'test.kul.8@liferay.com', 'Welcome Test KUL 8!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1024, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 8', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1025, 1, 1023, 9, 1023, 0, 0, '1025', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1026, 1, 1025, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1027, 1, 1025, false, false, 'classic', '01', 0);

insert into Users_Groups values (1023, 14);

insert into Users_Orgs (userId, organizationId) values (1023, 17);
insert into Users_Orgs (userId, organizationId) values (1023, 79);

insert into Users_Roles values (1023, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1028, 1, current_timestamp, current_timestamp, false, 1029, 'test', false, false, 'kul9', 'test.kul.9@liferay.com', 'Welcome Test KUL 9!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1029, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 9', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1030, 1, 1028, 9, 1028, 0, 0, '1030', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1031, 1, 1030, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1032, 1, 1030, false, false, 'classic', '01', 0);

insert into Users_Groups values (1028, 14);

insert into Users_Orgs (userId, organizationId) values (1028, 17);
insert into Users_Orgs (userId, organizationId) values (1028, 79);

insert into Users_Roles values (1028, 13);

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1033, 1, current_timestamp, current_timestamp, false, 1034, 'test', false, false, 'kul10', 'test.kul.10@liferay.com', 'Welcome Test KUL 10!', current_timestamp, 0, true, true);
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1034, 1, 2, 'Joe Bloggs', current_timestamp, current_timestamp, 7, 0, 'Test', '', 'KUL 10', true, '01/01/1970');

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1035, 1, 1033, 9, 1033, 0, 0, '1035', '', true);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1036, 1, 1035, true, false, 'classic', '01', 0);
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1037, 1, 1035, false, false, 'classic', '01', 0);

insert into Users_Groups values (1033, 14);

insert into Users_Orgs (userId, organizationId) values (1033, 17);
insert into Users_Orgs (userId, organizationId) values (1033, 79);

insert into Users_Roles values (1033, 13);












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

create index IX_9E1C1904 on pml_nation (countryid);
create index IX_E7BC0ACF on pml_nation (description);
create index IX_7BB3C125 on pml_nation (nationcode);
create index IX_AD004521 on pml_nation (nationcode, nationname, description);
create index IX_B64C62E0 on pml_nation (nationcode, nationname, description, countryid);
create index IX_8DB7DE43 on pml_nation (nationname);

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

create index IX_7C75D901 on pml_saveprocesstype (docId);
create index IX_2F8EFE4B on pml_saveprocesstype (flagprocesstype);

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

create index IX_CDE798CE on report_registry_work (reportRegistryId);


