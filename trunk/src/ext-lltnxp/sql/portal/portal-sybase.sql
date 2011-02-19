create table Account_ (
	accountId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	parentAccountId decimal(20,0),
	name varchar(75) null,
	legalName varchar(75) null,
	legalId varchar(75) null,
	legalType varchar(75) null,
	sicCode varchar(75) null,
	tickerSymbol varchar(75) null,
	industry varchar(75) null,
	type_ varchar(75) null,
	size_ varchar(75) null
)
go

create table Address (
	addressId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	street1 varchar(75) null,
	street2 varchar(75) null,
	street3 varchar(75) null,
	city varchar(75) null,
	zip varchar(75) null,
	regionId decimal(20,0),
	countryId decimal(20,0),
	typeId int,
	mailing int,
	primary_ int
)
go

create table AnnouncementsDelivery (
	deliveryId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	type_ varchar(75) null,
	email int,
	sms int,
	website int
)
go

create table AnnouncementsEntry (
	uuid_ varchar(75) null,
	entryId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	title varchar(75) null,
	content varchar(1000) null,
	url varchar(1000) null,
	type_ varchar(75) null,
	displayDate datetime null,
	expirationDate datetime null,
	priority int,
	alert int
)
go

create table AnnouncementsFlag (
	flagId decimal(20,0) not null primary key,
	userId decimal(20,0),
	createDate datetime null,
	entryId decimal(20,0),
	value int
)
go

create table BlogsCategory (
	categoryId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	parentCategoryId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null
)
go

create table BlogsEntry (
	uuid_ varchar(75) null,
	entryId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	title varchar(150) null,
	urlTitle varchar(150) null,
	content text null,
	displayDate datetime null,
	draft int,
	allowTrackbacks int,
	trackbacks text null
)
go

create table BlogsStatsUser (
	statsUserId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	entryCount int,
	lastPostDate datetime null,
	ratingsTotalEntries int,
	ratingsTotalScore float,
	ratingsAverageScore float
)
go

create table BookmarksEntry (
	uuid_ varchar(75) null,
	entryId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	folderId decimal(20,0),
	name varchar(300) null,
	url varchar(1000) null,
	comments varchar(1000) null,
	visits int,
	priority int
)
go

create table BookmarksFolder (
	uuid_ varchar(75) null,
	folderId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	parentFolderId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null
)
go

create table CalEvent (
	uuid_ varchar(75) null,
	eventId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	title varchar(75) null,
	description varchar(1000) null,
	startDate datetime null,
	endDate datetime null,
	durationHour int,
	durationMinute int,
	allDay int,
	timeZoneSensitive int,
	type_ varchar(75) null,
	repeating int,
	recurrence text null,
	remindBy varchar(75) null,
	firstReminder int,
	secondReminder int
)
go

create table ClassName_ (
	classNameId decimal(20,0) not null primary key,
	value varchar(200) null
)
go

create table Company (
	companyId decimal(20,0) not null primary key,
	accountId decimal(20,0),
	webId varchar(75) null,
	key_ text null,
	virtualHost varchar(75) null,
	mx varchar(75) null,
	logoId decimal(20,0)
)
go

create table CongViec (
	macv varchar(75) not null primary key,
	tencv varchar(75) null,
	linhvucid varchar(75) null,
	nguoitao decimal(20,0),
	ngaytao datetime null,
	ngayhethan datetime null,
	nguoichidao decimal(20,0),
	doithuchien varchar(75) null,
	ykienchidao varchar(75) null,
	baocaochidao varchar(75) null,
	chidaothem varchar(75) null
)
go

create table Contact_ (
	contactId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	accountId decimal(20,0),
	parentContactId decimal(20,0),
	firstName varchar(75) null,
	middleName varchar(75) null,
	lastName varchar(75) null,
	prefixId int,
	suffixId int,
	male int,
	birthday datetime null,
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
)
go

create table Counter (
	name varchar(75) not null primary key,
	currentId decimal(20,0)
)
go

create table Country (
	countryId decimal(20,0) not null primary key,
	name varchar(75) null,
	a2 varchar(75) null,
	a3 varchar(75) null,
	number_ varchar(75) null,
	idd_ varchar(75) null,
	active_ int
)
go

create table CyrusUser (
	userId varchar(75) not null primary key,
	password_ varchar(75) not null
)
go

create table CyrusVirtual (
	emailAddress varchar(75) not null primary key,
	userId varchar(75) not null
)
go

create table DLFileEntry (
	uuid_ varchar(75) null,
	fileEntryId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	versionUserId decimal(20,0),
	versionUserName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	folderId decimal(20,0),
	name varchar(300) null,
	title varchar(300) null,
	description varchar(1000) null,
	version float,
	size_ int,
	readCount int,
	extraSettings text null
)
go

create table DLFileRank (
	fileRankId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	folderId decimal(20,0),
	name varchar(300) null
)
go

create table DLFileShortcut (
	uuid_ varchar(75) null,
	fileShortcutId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	folderId decimal(20,0),
	toFolderId decimal(20,0),
	toName varchar(300) null
)
go

create table DLFileVersion (
	fileVersionId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	folderId decimal(20,0),
	name varchar(300) null,
	version float,
	size_ int
)
go

create table DLFolder (
	uuid_ varchar(75) null,
	folderId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	parentFolderId decimal(20,0),
	name varchar(100) null,
	description varchar(1000) null,
	lastPostDate datetime null
)
go

create table EmailAddress (
	emailAddressId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	address varchar(75) null,
	typeId int,
	primary_ int
)
go

create table ExpandoColumn (
	columnId decimal(20,0) not null primary key,
	tableId decimal(20,0),
	name varchar(75) null,
	type_ int
)
go

create table ExpandoRow (
	rowId_ decimal(20,0) not null primary key,
	tableId decimal(20,0),
	classPK decimal(20,0)
)
go

create table ExpandoTable (
	tableId decimal(20,0) not null primary key,
	classNameId decimal(20,0),
	name varchar(75) null
)
go

create table ExpandoValue (
	valueId decimal(20,0) not null primary key,
	tableId decimal(20,0),
	columnId decimal(20,0),
	rowId_ decimal(20,0),
	classNameId decimal(20,0),
	classPK decimal(20,0),
	data_ varchar(1000) null
)
go

create table Group_ (
	groupId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	creatorUserId decimal(20,0),
	classNameId decimal(20,0),
	classPK decimal(20,0),
	parentGroupId decimal(20,0),
	liveGroupId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null,
	type_ int,
	typeSettings varchar(1000) null,
	friendlyURL varchar(100) null,
	active_ int
)
go

create table Groups_Orgs (
	groupId decimal(20,0) not null,
	organizationId decimal(20,0) not null,
	primary key (groupId, organizationId)
)
go

create table Groups_Permissions (
	groupId decimal(20,0) not null,
	permissionId decimal(20,0) not null,
	primary key (groupId, permissionId)
)
go

create table Groups_Roles (
	groupId decimal(20,0) not null,
	roleId decimal(20,0) not null,
	primary key (groupId, roleId)
)
go

create table Groups_UserGroups (
	groupId decimal(20,0) not null,
	userGroupId decimal(20,0) not null,
	primary key (groupId, userGroupId)
)
go

create table IGFolder (
	uuid_ varchar(75) null,
	folderId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	parentFolderId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null
)
go

create table IGImage (
	uuid_ varchar(75) null,
	imageId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	folderId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null,
	smallImageId decimal(20,0),
	largeImageId decimal(20,0),
	custom1ImageId decimal(20,0),
	custom2ImageId decimal(20,0)
)
go

create table Image (
	imageId decimal(20,0) not null primary key,
	modifiedDate datetime null,
	text_ text null,
	type_ varchar(75) null,
	height int,
	width int,
	size_ int
)
go

create table JournalArticle (
	uuid_ varchar(75) null,
	id_ decimal(20,0) not null primary key,
	resourcePrimKey decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	articleId varchar(75) null,
	version float,
	title varchar(100) null,
	description varchar(1000) null,
	content text null,
	type_ varchar(75) null,
	structureId varchar(75) null,
	templateId varchar(75) null,
	displayDate datetime null,
	approved int,
	approvedByUserId decimal(20,0),
	approvedByUserName varchar(75) null,
	approvedDate datetime null,
	expired int,
	expirationDate datetime null,
	reviewDate datetime null,
	indexable int,
	smallImage int,
	smallImageId decimal(20,0),
	smallImageURL varchar(75) null
)
go

create table JournalArticleImage (
	articleImageId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	articleId varchar(75) null,
	version float,
	elName varchar(75) null,
	languageId varchar(75) null,
	tempImage int
)
go

create table JournalArticleResource (
	resourcePrimKey decimal(20,0) not null primary key,
	groupId decimal(20,0),
	articleId varchar(75) null
)
go

create table JournalContentSearch (
	contentSearchId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	privateLayout int,
	layoutId decimal(20,0),
	portletId varchar(200) null,
	articleId varchar(75) null
)
go

create table JournalFeed (
	uuid_ varchar(75) null,
	id_ decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	feedId varchar(75) null,
	name varchar(75) null,
	description varchar(1000) null,
	type_ varchar(75) null,
	structureId varchar(75) null,
	templateId varchar(75) null,
	rendererTemplateId varchar(75) null,
	delta int,
	orderByCol varchar(75) null,
	orderByType varchar(75) null,
	targetLayoutFriendlyUrl varchar(75) null,
	targetPortletId varchar(75) null,
	contentField varchar(75) null,
	feedType varchar(75) null,
	feedVersion float
)
go

create table JournalStructure (
	uuid_ varchar(75) null,
	id_ decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	structureId varchar(75) null,
	name varchar(75) null,
	description varchar(1000) null,
	xsd text null
)
go

create table JournalTemplate (
	uuid_ varchar(75) null,
	id_ decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	templateId varchar(75) null,
	structureId varchar(75) null,
	name varchar(75) null,
	description varchar(1000) null,
	xsl text null,
	langType varchar(75) null,
	cacheable int,
	smallImage int,
	smallImageId decimal(20,0),
	smallImageURL varchar(75) null
)
go

create table Layout (
	plid decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	privateLayout int,
	layoutId decimal(20,0),
	parentLayoutId decimal(20,0),
	name varchar(1000) null,
	title varchar(1000) null,
	description varchar(1000) null,
	type_ varchar(75) null,
	typeSettings text null,
	hidden_ int,
	friendlyURL varchar(100) null,
	iconImage int,
	iconImageId decimal(20,0),
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css varchar(1000) null,
	priority int,
	dlFolderId decimal(20,0)
)
go

create table LayoutSet (
	layoutSetId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	privateLayout int,
	logo int,
	logoId decimal(20,0),
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css varchar(1000) null,
	pageCount int,
	virtualHost varchar(75) null
)
go

create table ListType (
	listTypeId int not null primary key,
	name varchar(75) null,
	type_ varchar(75) null
)
go

create table MBBan (
	banId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	banUserId decimal(20,0)
)
go

create table MBCategory (
	uuid_ varchar(75) null,
	categoryId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	parentCategoryId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null,
	lastPostDate datetime null
)
go

create table MBDiscussion (
	discussionId decimal(20,0) not null primary key,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	threadId decimal(20,0)
)
go

create table MBMessage (
	uuid_ varchar(75) null,
	messageId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	categoryId decimal(20,0),
	threadId decimal(20,0),
	parentMessageId decimal(20,0),
	subject varchar(75) null,
	body text null,
	attachments int,
	anonymous int
)
go

create table MBMessageFlag (
	messageFlagId decimal(20,0) not null primary key,
	userId decimal(20,0),
	messageId decimal(20,0),
	flag int
)
go

create table MBStatsUser (
	statsUserId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	userId decimal(20,0),
	messageCount int,
	lastPostDate datetime null
)
go

create table MBThread (
	threadId decimal(20,0) not null primary key,
	categoryId decimal(20,0),
	rootMessageId decimal(20,0),
	messageCount int,
	viewCount int,
	lastPostByUserId decimal(20,0),
	lastPostDate datetime null,
	priority float
)
go

create table MeetingCalComponent (
	mcalId decimal(20,0) not null primary key,
	groupIds varchar(75) null,
	startDate datetime null
)
go

create table MeetingCalendar (
	uuid_ varchar(75) null,
	mcalId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	state int,
	place varchar(75) null,
	place_diff varchar(75) null,
	sponsor varchar(75) null,
	component varchar(75) null,
	note varchar(75) null,
	userApproved decimal(20,0),
	dateApproved datetime null,
	moveMcalId decimal(20,0),
	repeatWeek int,
	filename varchar(75) null,
	morning int,
	afternoon int,
	evening int,
	stt int,
	prior int,
	deleted int
)
go

create table MeetingDetailWeek (
	mdweekId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	focus varchar(75) null,
	note varchar(75) null,
	receive varchar(75) null,
	week int,
	year int
)
go

create table MembershipRequest (
	membershipRequestId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	groupId decimal(20,0),
	comments varchar(1000) null,
	replyComments varchar(1000) null,
	replyDate datetime null,
	replierUserId decimal(20,0),
	statusId int
)
go

create table Organization_ (
	organizationId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	parentOrganizationId decimal(20,0),
	name varchar(100) null,
	location int,
	recursable int,
	regionId decimal(20,0),
	countryId decimal(20,0),
	statusId int,
	comments varchar(1000) null
)
go

create table OrgGroupPermission (
	organizationId decimal(20,0) not null,
	groupId decimal(20,0) not null,
	permissionId decimal(20,0) not null,
	primary key (organizationId, groupId, permissionId)
)
go

create table OrgGroupRole (
	organizationId decimal(20,0) not null,
	groupId decimal(20,0) not null,
	roleId decimal(20,0) not null,
	primary key (organizationId, groupId, roleId)
)
go

create table OrgLabor (
	orgLaborId decimal(20,0) not null primary key,
	organizationId decimal(20,0),
	typeId int,
	sunOpen int,
	sunClose int,
	monOpen int,
	monClose int,
	tueOpen int,
	tueClose int,
	wedOpen int,
	wedClose int,
	thuOpen int,
	thuClose int,
	friOpen int,
	friClose int,
	satOpen int,
	satClose int
)
go

create table PML_Country (
	countryId varchar(75) not null primary key,
	countryCode varchar(75) null,
	countryName varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

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
)
go

create table PML_IDGENERATED (
	id decimal(20,0) not null primary key,
	year varchar(75) null,
	curvalue decimal(20,0)
)
go

create table PML_IDTEMPLATE (
	templateId decimal(20,0) not null primary key,
	format varchar(75) null,
	startNumber varchar(75) null,
	len decimal(20,0),
	description varchar(75) null
)
go

create table PasswordPolicy (
	passwordPolicyId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	defaultPolicy int,
	name varchar(75) null,
	description varchar(1000) null,
	changeable int,
	changeRequired int,
	minAge decimal(20,0),
	checkSyntax int,
	allowDictionaryWords int,
	minLength int,
	history int,
	historyCount int,
	expireable int,
	maxAge decimal(20,0),
	warningTime decimal(20,0),
	graceLimit int,
	lockout int,
	maxFailure int,
	lockoutDuration decimal(20,0),
	requireUnlock int,
	resetFailureCount decimal(20,0)
)
go

create table PasswordPolicyRel (
	passwordPolicyRelId decimal(20,0) not null primary key,
	passwordPolicyId decimal(20,0),
	classNameId decimal(20,0),
	classPK decimal(20,0)
)
go

create table PasswordTracker (
	passwordTrackerId decimal(20,0) not null primary key,
	userId decimal(20,0),
	createDate datetime null,
	password_ varchar(75) null
)
go

create table Permission_ (
	permissionId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	actionId varchar(75) null,
	resourceId decimal(20,0)
)
go

create table Phone (
	phoneId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	number_ varchar(75) null,
	extension varchar(75) null,
	typeId int,
	primary_ int
)
go

create table PluginSetting (
	pluginSettingId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	pluginId varchar(75) null,
	pluginType varchar(75) null,
	roles varchar(1000) null,
	active_ int
)
go

create table PollsChoice (
	uuid_ varchar(75) null,
	choiceId decimal(20,0) not null primary key,
	questionId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null
)
go

create table PollsQuestion (
	uuid_ varchar(75) null,
	questionId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	title varchar(500) null,
	description varchar(1000) null,
	expirationDate datetime null,
	lastVoteDate datetime null
)
go

create table PollsVote (
	voteId decimal(20,0) not null primary key,
	userId decimal(20,0),
	questionId decimal(20,0),
	choiceId decimal(20,0),
	voteDate datetime null
)
go

create table Portlet (
	id_ decimal(20,0) not null primary key,
	companyId decimal(20,0),
	portletId varchar(200) null,
	roles varchar(1000) null,
	active_ int
)
go

create table PortletItem (
	portletItemId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null,
	portletId varchar(75) null,
	classNameId decimal(20,0)
)
go

create table PortletPreferences (
	portletPreferencesId decimal(20,0) not null primary key,
	ownerId decimal(20,0),
	ownerType int,
	plid decimal(20,0),
	portletId varchar(200) null,
	preferences text null
)
go

create table RatingsEntry (
	entryId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	score float
)
go

create table RatingsStats (
	statsId decimal(20,0) not null primary key,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	totalEntries int,
	totalScore float,
	averageScore float
)
go

create table ReceiverGroups_Receivers (
	receiverGroupId decimal(20,0) not null,
	receiverId decimal(20,0) not null,
	primary key (receiverGroupId, receiverId)
)
go

create table RecieverGroups_Recievers (
	recieverGroupId decimal(20,0) not null,
	recieverId decimal(20,0) not null,
	primary key (recieverGroupId, recieverId)
)
go

create table Region (
	regionId decimal(20,0) not null primary key,
	countryId decimal(20,0),
	regionCode varchar(75) null,
	name varchar(75) null,
	active_ int
)
go

create table Release_ (
	releaseId decimal(20,0) not null primary key,
	createDate datetime null,
	modifiedDate datetime null,
	buildNumber int,
	buildDate datetime null,
	verified int
)
go

create table ReportsEntry (
	entryId varchar(75) not null primary key,
	companyId varchar(75) null,
	userId varchar(75) null,
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null
)
go

create table Resource_ (
	resourceId decimal(20,0) not null primary key,
	codeId decimal(20,0),
	primKey varchar(300) null
)
go

create table ResourceCode (
	codeId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	name varchar(300) null,
	scope int
)
go

create table Role_ (
	roleId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	classNameId decimal(20,0),
	classPK decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null,
	type_ int
)
go

create table Roles_Permissions (
	roleId decimal(20,0) not null,
	permissionId decimal(20,0) not null,
	primary key (roleId, permissionId)
)
go

create table SCFrameworkVersi_SCProductVers (
	frameworkVersionId decimal(20,0) not null,
	productVersionId decimal(20,0) not null,
	primary key (frameworkVersionId, productVersionId)
)
go

create table SCFrameworkVersion (
	frameworkVersionId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null,
	url varchar(1000) null,
	active_ int,
	priority int
)
go

create table SCLicense (
	licenseId decimal(20,0) not null primary key,
	name varchar(75) null,
	url varchar(1000) null,
	openSource int,
	active_ int,
	recommended int
)
go

create table SCLicenses_SCProductEntries (
	licenseId decimal(20,0) not null,
	productEntryId decimal(20,0) not null,
	primary key (licenseId, productEntryId)
)
go

create table SCProductEntry (
	productEntryId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null,
	type_ varchar(75) null,
	tags varchar(300) null,
	shortDescription varchar(1000) null,
	longDescription varchar(1000) null,
	pageURL varchar(1000) null,
	author varchar(75) null,
	repoGroupId varchar(75) null,
	repoArtifactId varchar(75) null
)
go

create table SCProductScreenshot (
	productScreenshotId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	groupId decimal(20,0),
	productEntryId decimal(20,0),
	thumbnailId decimal(20,0),
	fullImageId decimal(20,0),
	priority int
)
go

create table SCProductVersion (
	productVersionId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	productEntryId decimal(20,0),
	version varchar(75) null,
	changeLog varchar(1000) null,
	downloadPageURL varchar(1000) null,
	directDownloadURL varchar(2000) null,
	repoStoreArtifact int
)
go

create table ServiceComponent (
	serviceComponentId decimal(20,0) not null primary key,
	buildNamespace varchar(75) null,
	buildNumber decimal(20,0),
	buildDate decimal(20,0),
	data_ text null
)
go

create table ShoppingCart (
	cartId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	itemIds varchar(1000) null,
	couponCodes varchar(75) null,
	altShipping int,
	insure int
)
go

create table ShoppingCategory (
	categoryId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	parentCategoryId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null
)
go

create table ShoppingCoupon (
	couponId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	code_ varchar(75) null,
	name varchar(75) null,
	description varchar(1000) null,
	startDate datetime null,
	endDate datetime null,
	active_ int,
	limitCategories varchar(1000) null,
	limitSkus varchar(1000) null,
	minOrder float,
	discount float,
	discountType varchar(75) null
)
go

create table ShoppingItem (
	itemId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	categoryId decimal(20,0),
	sku varchar(75) null,
	name varchar(200) null,
	description varchar(1000) null,
	properties varchar(1000) null,
	fields_ int,
	fieldsQuantities varchar(1000) null,
	minQuantity int,
	maxQuantity int,
	price float,
	discount float,
	taxable int,
	shipping float,
	useShippingFormula int,
	requiresShipping int,
	stockQuantity int,
	featured_ int,
	sale_ int,
	smallImage int,
	smallImageId decimal(20,0),
	smallImageURL varchar(75) null,
	mediumImage int,
	mediumImageId decimal(20,0),
	mediumImageURL varchar(75) null,
	largeImage int,
	largeImageId decimal(20,0),
	largeImageURL varchar(75) null
)
go

create table ShoppingItemField (
	itemFieldId decimal(20,0) not null primary key,
	itemId decimal(20,0),
	name varchar(75) null,
	values_ varchar(1000) null,
	description varchar(1000) null
)
go

create table ShoppingItemPrice (
	itemPriceId decimal(20,0) not null primary key,
	itemId decimal(20,0),
	minQuantity int,
	maxQuantity int,
	price float,
	discount float,
	taxable int,
	shipping float,
	useShippingFormula int,
	status int
)
go

create table ShoppingOrder (
	orderId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	number_ varchar(75) null,
	tax float,
	shipping float,
	altShipping varchar(75) null,
	requiresShipping int,
	insure int,
	insurance float,
	couponCodes varchar(75) null,
	couponDiscount float,
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
	shipToBilling int,
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
	ccExpMonth int,
	ccExpYear int,
	ccVerNumber varchar(75) null,
	comments varchar(1000) null,
	ppTxnId varchar(75) null,
	ppPaymentStatus varchar(75) null,
	ppPaymentGross float,
	ppReceiverEmail varchar(75) null,
	ppPayerEmail varchar(75) null,
	sendOrderEmail int,
	sendShippingEmail int
)
go

create table ShoppingOrderItem (
	orderItemId decimal(20,0) not null primary key,
	orderId decimal(20,0),
	itemId varchar(75) null,
	sku varchar(75) null,
	name varchar(200) null,
	description varchar(1000) null,
	properties varchar(1000) null,
	price float,
	quantity int,
	shippedDate datetime null
)
go

create table SocialActivity (
	activityId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	mirrorActivityId decimal(20,0),
	classNameId decimal(20,0),
	classPK decimal(20,0),
	type_ int,
	extraData varchar(1000) null,
	receiverUserId decimal(20,0)
)
go

create table SocialRelation (
	uuid_ varchar(75) null,
	relationId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	createDate datetime null,
	userId1 decimal(20,0),
	userId2 decimal(20,0),
	type_ int
)
go

create table SocialRequest (
	uuid_ varchar(75) null,
	requestId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	type_ int,
	extraData varchar(1000) null,
	receiverUserId decimal(20,0),
	status int
)
go

create table Subscription (
	subscriptionId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	frequency varchar(75) null
)
go

create table TagsAsset (
	assetId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	startDate datetime null,
	endDate datetime null,
	publishDate datetime null,
	expirationDate datetime null,
	mimeType varchar(75) null,
	title varchar(300) null,
	description varchar(1000) null,
	summary varchar(1000) null,
	url varchar(1000) null,
	height int,
	width int,
	priority float,
	viewCount int
)
go

create table TagsAssets_TagsEntries (
	assetId decimal(20,0) not null,
	entryId decimal(20,0) not null,
	primary key (assetId, entryId)
)
go

create table TagsEntry (
	entryId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null
)
go

create table TagsProperty (
	propertyId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	entryId decimal(20,0),
	key_ varchar(75) null,
	value varchar(300) null
)
go

create table TagsSource (
	sourceId decimal(20,0) not null primary key,
	parentSourceId decimal(20,0),
	name varchar(75) null,
	acronym varchar(75) null
)
go

create table TasksProposal (
	proposalId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK varchar(75) null,
	name varchar(75) null,
	description varchar(1000) null,
	publishDate datetime null,
	dueDate datetime null
)
go

create table TasksReview (
	reviewId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	proposalId decimal(20,0),
	assignedByUserId decimal(20,0),
	assignedByUserName varchar(75) null,
	stage int,
	completed int,
	rejected int
)
go

create table User_ (
	uuid_ varchar(75) null,
	userId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	defaultUser int,
	contactId decimal(20,0),
	password_ varchar(75) null,
	passwordEncrypted int,
	passwordReset int,
	passwordModifiedDate datetime null,
	graceLoginCount int,
	screenName varchar(75) null,
	emailAddress varchar(75) null,
	openId varchar(1024) null,
	portraitId decimal(20,0),
	languageId varchar(75) null,
	timeZoneId varchar(75) null,
	greeting varchar(75) null,
	comments varchar(1000) null,
	loginDate datetime null,
	loginIP varchar(75) null,
	lastLoginDate datetime null,
	lastLoginIP varchar(75) null,
	lastFailedLoginDate datetime null,
	failedLoginAttempts int,
	lockout int,
	lockoutDate datetime null,
	agreedToTermsOfUse int,
	active_ int
)
go

create table UserGroup (
	userGroupId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	parentUserGroupId decimal(20,0),
	name varchar(75) null,
	description varchar(1000) null
)
go

create table UserGroupRole (
	userId decimal(20,0) not null,
	groupId decimal(20,0) not null,
	roleId decimal(20,0) not null,
	primary key (userId, groupId, roleId)
)
go

create table UserIdMapper (
	userIdMapperId decimal(20,0) not null primary key,
	userId decimal(20,0),
	type_ varchar(75) null,
	description varchar(75) null,
	externalUserId varchar(75) null
)
go

create table Users_Groups (
	userId decimal(20,0) not null,
	groupId decimal(20,0) not null,
	primary key (userId, groupId)
)
go

create table Users_Orgs (
	userId decimal(20,0) not null,
	organizationId decimal(20,0) not null,
	primary key (userId, organizationId)
)
go

create table Users_Permissions (
	userId decimal(20,0) not null,
	permissionId decimal(20,0) not null,
	primary key (userId, permissionId)
)
go

create table Users_Roles (
	userId decimal(20,0) not null,
	roleId decimal(20,0) not null,
	primary key (userId, roleId)
)
go

create table Users_UserGroups (
	userId decimal(20,0) not null,
	userGroupId decimal(20,0) not null,
	primary key (userId, userGroupId)
)
go

create table UserTracker (
	userTrackerId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	modifiedDate datetime null,
	sessionId varchar(200) null,
	remoteAddr varchar(75) null,
	remoteHost varchar(75) null,
	userAgent varchar(200) null
)
go

create table UserTrackerPath (
	userTrackerPathId decimal(20,0) not null primary key,
	userTrackerId decimal(20,0),
	path_ varchar(1000) null,
	pathDate datetime null
)
go

create table WebDAVProps (
	webDavPropsId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	props text null
)
go

create table Website (
	websiteId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	url varchar(1000) null,
	typeId int,
	primary_ int
)
go

create table WikiNode (
	uuid_ varchar(75) null,
	nodeId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null,
	description varchar(1000) null,
	lastPostDate datetime null
)
go

create table WikiPage (
	uuid_ varchar(75) null,
	pageId decimal(20,0) not null primary key,
	resourcePrimKey decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	nodeId decimal(20,0),
	title varchar(75) null,
	version float,
	minorEdit int,
	content text null,
	summary varchar(1000) null,
	format varchar(75) null,
	head int,
	parentTitle varchar(75) null,
	redirectTitle varchar(75) null
)
go

create table WikiPageResource (
	resourcePrimKey decimal(20,0) not null primary key,
	nodeId decimal(20,0),
	title varchar(75) null
)
go

create table attact_file_document (
	attactFileDocumentId decimal(20,0) not null primary key,
	attactFileDocumentTitle varchar(75) null,
	attactFileDocumentPath varchar(75) null,
	documentManagerId decimal(20,0),
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table department (
	departmentId decimal(20,0) not null primary key,
	departmentCode varchar(75) null,
	departmentName varchar(75) null,
	departmentDescription varchar(75) null,
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table document_manager (
	documentManagerId decimal(20,0) not null primary key,
	documentManagerCode varchar(75) null,
	documentManagerCategory varchar(75) null,
	documentManagerStyle varchar(75) null,
	documentManagerDescription varchar(75) null,
	documentManagerDateCreate datetime null,
	documentManagerTitle varchar(75) null,
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table holiday_calendar (
	holidayCalendarId decimal(20,0) not null primary key,
	holidayCalendarCode varchar(75) null,
	holidayCalendarDateCreate datetime null,
	holidayCalendarTitle varchar(75) null,
	holidayCalendarPath varchar(75) null,
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table pml_Receiver (
	receiverId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	receiverUserId decimal(20,0),
	receiverUserName varchar(75) null,
	viewName varchar(75) null,
	receiverType int
)
go

create table pml_ReceiverGroup (
	receiverGroupId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	receiverGroupName varchar(75) null,
	description varchar(75) null,
	type_ int,
	active_ int
)
go

create table pml_Reciever (
	recieverId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	recieverUserId decimal(20,0),
	recieverUserName varchar(75) null,
	viewName varchar(75) null,
	recieverType int
)
go

create table pml_RecieverGroup (
	recieverGroupId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	recieverGroupName varchar(75) null,
	description varchar(75) null,
	type_ int,
	active_ int
)
go

create table pml_agency (
	agencyid varchar(75) not null primary key,
	agencycode varchar(75) null,
	agencyname varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_agencyleader (
	agencyId varchar(75) not null primary key,
	userId decimal(20,0)
)
go

create table pml_attachedfile (
	attachedfileid varchar(75) not null primary key,
	attachedfilecode varchar(75) null,
	attachedfilename varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_car_resource (
	carId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	carName varchar(255) null,
	carCode varchar(75) null,
	description varchar(1000) null
)
go

create table pml_career (
	careerid varchar(75) not null primary key,
	careercode varchar(75) null,
	careername varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_chi_tiet_hscv (
	id_chi_tiet_hscv decimal(20,0) not null primary key,
	id_ho_so_cong_viec decimal(20,0),
	id_cong_van_den decimal(20,0),
	id_cong_van_di decimal(20,0),
	di_den varchar(75) null
)
go

create table pml_city (
	cityID varchar(75) not null primary key,
	cityCode varchar(75) null,
	cityName varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	countryid varchar(75) null
)
go

create table pml_conf_phongban_hscv (
	pmlDepartmentHSCVId decimal(20,0) not null primary key,
	departmentsId varchar(75) null,
	id_ho_so_cong_viec decimal(20,0),
	description varchar(75) null
)
go

create table pml_delegate (
	delegateid decimal(20,0) not null primary key,
	assigner decimal(20,0),
	receiver decimal(20,0),
	startdate datetime null,
	enddate datetime null,
	canceldate datetime null,
	canceldelegate varchar(75) null,
	datecreated datetime null
)
go

create table pml_departmentleader (
	departmentsId varchar(75) not null,
	userId decimal(20,0) not null,
	clericalid decimal(20,0),
	main int,
	primary key (departmentsId, userId)
)
go

create table pml_departments (
	departmentsid varchar(75) not null primary key,
	departmentsparentid varchar(75) null,
	departmentscode varchar(75) null,
	departmentsname varchar(75) null,
	abbreviatename varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	agencyid varchar(75) null,
	roleid decimal(20,0),
	hasteam varchar(75) null
)
go

create table pml_district (
	districtId varchar(75) not null primary key,
	districtCode varchar(75) null,
	districtName varchar(75) null,
	cityID varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_do_quan_trong (
	id_do_quan_trong decimal(20,0) not null primary key,
	ten_do_quan_trong varchar(75) null
)
go

create table pml_documentreceipt_issuingplace_log (
	documentReceiptIssuingPlaceLogId decimal(20,0) not null primary key,
	documentReceiptId decimal(20,0),
	processor decimal(20,0),
	directProcessorId decimal(20,0),
	dateProcess datetime null,
	processInfomation varchar(75) null,
	receiver varchar(75) null,
	type_ int,
	step int
)
go

create table pml_documentreceipt_log (
	documentreceiptlogid decimal(20,0) not null primary key,
	documentreceiptid decimal(20,0),
	transition_ int,
	processer decimal(20,0),
	dateprocess datetime null,
	processinfomation varchar(75) null,
	receiver decimal(20,0),
	receivedate datetime null,
	stateprocessidbefore decimal(20,0),
	stateprocessidafter decimal(20,0),
	type_ int,
	expireddate datetime null,
	numdateprocess int,
	processinstanceid decimal(20,0),
	maindepartmentprocessid varchar(75) null,
	mainuserprocessid decimal(20,0),
	senddatebefore datetime null,
	departmentreceiveid varchar(75) null,
	departmentprocessid varchar(75) null,
	dateProcessTime datetime null,
	receiveDateTime datetime null,
	directProcesserId decimal(20,0),
	step int
)
go

create table pml_documentreceipt_wf (
	processid decimal(20,0) not null primary key,
	documentreceiptid decimal(20,0),
	ismain varchar(75) null
)
go

create table pml_documentsend_log (
	documentsendlogid decimal(20,0) not null primary key,
	documentsendid decimal(20,0),
	transition_ int,
	processer decimal(20,0),
	dateprocess datetime null,
	processinfomation varchar(75) null,
	receiver decimal(20,0),
	receivedate datetime null,
	stateprocessidbefore decimal(20,0),
	stateprocessidafter decimal(20,0),
	expireddate datetime null,
	numdateprocess int,
	processinstanceid decimal(20,0),
	type_ int,
	senddatebefore datetime null,
	departmentreceiveid varchar(75) null,
	departmentprocessid varchar(75) null,
	dateprocesstime datetime null,
	receivedatetime datetime null,
	directProcesserId decimal(20,0),
	step int
)
go

create table pml_documentsend_wf (
	documentsendid decimal(20,0) not null primary key,
	processid decimal(20,0),
	isMain varchar(75) null
)
go

create table pml_edm_answerdetail (
	documentreceiptid decimal(20,0) not null primary key,
	documentsendid decimal(20,0)
)
go

create table pml_edm_attachedfile (
	attachedfileid decimal(20,0) not null primary key,
	objectcontentid decimal(20,0),
	objecttype varchar(75) null,
	attachedfilename varchar(75) null,
	path varchar(75) null,
	datecreated datetime null,
	filetype varchar(75) null,
	fileid int,
	title varchar(75) null,
	displayorhidden int
)
go

create table pml_edm_bookdocumentrecordto (
	documentreceiptid decimal(20,0) not null,
	documentrecordtoid decimal(20,0) not null,
	datecreate datetime null,
	datecomplete datetime null,
	soCongVanDenPhongHienTai int,
	primary key (documentreceiptid, documentrecordtoid)
)
go

create table pml_edm_bookdocumentsend (
	bookdocumentsendid decimal(20,0) not null primary key,
	datecreated datetime null,
	currentrecord decimal(20,0),
	departmentsid varchar(75) null,
	documentrecordtypeid int,
	yearinuse varchar(75) null,
	active varchar(75) null,
	isagency varchar(75) null,
	agencyid varchar(75) null
)
go

create table pml_edm_cadre (
	userid decimal(20,0) not null primary key,
	positionid varchar(75) null,
	departmentsid varchar(75) null,
	handphone varchar(75) null,
	note varchar(75) null,
	active varchar(75) null
)
go

create table pml_edm_confidentiallevel (
	confidentiallevelid varchar(75) not null primary key,
	confidentiallevelname varchar(75) null,
	limitviewdetail int,
	haveprocess int,
	confidentiallevelsymbol int
)
go

create table pml_edm_docconfuser (
	dcuId decimal(20,0) not null primary key,
	userId decimal(20,0),
	viewAllDoc int,
	viewDepDoc varchar(75) null
)
go

create table pml_edm_documentdelegate (
	documentDelegateId decimal(20,0) not null primary key,
	userDelegateId decimal(20,0),
	userIsDelegateId decimal(20,0),
	documentId int,
	fromtDate datetime null,
	toDate datetime null,
	cancelDate datetime null
)
go

create table pml_edm_documentreceipt (
	documentReceiptId decimal(20,0) not null primary key,
	levelsendid int,
	documenttypeid decimal(20,0),
	documentreference varchar(75) null,
	issuingplaceid varchar(75) null,
	issuingdate datetime null,
	datearrive datetime null,
	signer varchar(75) null,
	privilegelevelid varchar(75) null,
	confidentiallevelid varchar(75) null,
	opinion varchar(75) null,
	briefcontent varchar(75) null,
	ispublic varchar(75) null,
	numberdocumentreceipt varchar(75) null,
	processtime int,
	status varchar(75) null,
	active varchar(75) null,
	numberlocaldocumentreceipt varchar(75) null,
	issuingplaceothername varchar(75) null,
	documenttype varchar(75) null,
	datebutphe datetime null,
	datehoanthanh datetime null,
	statusid decimal(20,0),
	thoigiannhancvden varchar(75) null,
	socongvandiphucdap varchar(75) null,
	generalorderno decimal(20,0),
	maindepartmentprocessid varchar(75) null,
	mainuserprocessid decimal(20,0),
	orgexternalid decimal(20,0),
	docreceipttempid decimal(20,0),
	documentrecordtypeid int,
	donvisaoy varchar(75) null
)
go

create table pml_edm_documentreceipt_temp (
	documentReceiptId decimal(20,0) not null primary key,
	levelsendid int,
	documenttypeid decimal(20,0),
	documentreference varchar(75) null,
	issuingplaceid varchar(75) null,
	issuingdate datetime null,
	datearrive datetime null,
	signer varchar(75) null,
	privilegelevelid varchar(75) null,
	confidentiallevelid varchar(75) null,
	opinion varchar(75) null,
	briefcontent varchar(75) null,
	ispublic varchar(75) null,
	numberdocumentreceipt varchar(75) null,
	processtime int,
	status varchar(75) null,
	active varchar(75) null,
	numberlocaldocumentreceipt varchar(75) null,
	issuingplaceothername varchar(75) null,
	documenttype varchar(75) null,
	datebutphe datetime null,
	datehoanthanh datetime null,
	statusid decimal(20,0),
	thoigiannhancvden varchar(75) null,
	socongvandiphucdap varchar(75) null,
	generalorderno decimal(20,0),
	maindepartmentprocessid varchar(75) null,
	mainuserprocessid decimal(20,0),
	orgexternalid decimal(20,0)
)
go

create table pml_edm_documentreceiptextend (
	documentreceiptextendid decimal(20,0) not null primary key,
	documentreceiptid decimal(20,0),
	documentreceiptlogid decimal(20,0),
	extendorderno int,
	startprocessdate datetime null,
	numdayprocessbef int,
	limitdatebef datetime null,
	extendreason varchar(75) null,
	numdayprocessaft int,
	limitdateaft datetime null,
	leanonlimitdate int,
	extenduserid decimal(20,0),
	extenddepartmentid varchar(75) null
)
go

create table pml_edm_documentreceiptprocesstype (
	docReceiptProcessTypeId decimal(20,0) not null primary key,
	documentReceiptId decimal(20,0),
	documentReceiptLogId decimal(20,0),
	processTypeOrderNo int,
	dateEdit datetime null,
	processTypeIdBefore varchar(75) null,
	processTypeIdAfter varchar(75) null,
	processTypeReason varchar(75) null,
	processerId decimal(20,0),
	departmentId varchar(75) null
)
go

create table pml_edm_documentrecordto (
	documentrecordtoid decimal(20,0) not null primary key,
	datecreate datetime null,
	currentrecord decimal(20,0),
	departmentsid varchar(75) null,
	documentrecordtypeid int,
	yearinuse varchar(75) null,
	active varchar(75) null,
	isagency varchar(75) null,
	agencyid varchar(75) null
)
go

create table pml_edm_documentrecordtype (
	documentrecordtypeid int not null primary key,
	documentrecordtypename varchar(75) null,
	documentrecordtypecode varchar(75) null
)
go

create table pml_edm_documentrelation (
	documentrelationid decimal(20,0) not null primary key,
	docleftid decimal(20,0),
	docrightid decimal(20,0),
	leftisreceipt int,
	rightisreceipt int
)
go

create table pml_edm_documentsend (
	documentsendid decimal(20,0) not null primary key,
	briefcontent varchar(75) null,
	documentreference varchar(75) null,
	receivingplace varchar(75) null,
	issuingdate datetime null,
	opinion varchar(75) null,
	editorid decimal(20,0),
	signerid decimal(20,0),
	documenttypeid decimal(20,0),
	privilegelevelid varchar(75) null,
	confidentiallevelid varchar(75) null,
	datecreated datetime null,
	islocal int,
	active varchar(75) null,
	senddate datetime null,
	signername varchar(75) null,
	position_ varchar(75) null,
	numberpage varchar(75) null,
	numberpublish varchar(75) null,
	documentsendcode varchar(75) null,
	statusid decimal(20,0),
	iscongvanphucdap int,
	numofdocref decimal(20,0),
	ispublish int,
	orgexternalid decimal(20,0),
	numofdirector int,
	documentrecordtypeid int
)
go

create table pml_edm_documenttype (
	documenttypeid decimal(20,0) not null primary key,
	documenttypename varchar(75) null,
	documentsymbol varchar(75) null,
	documentrecordtypeid int,
	sendreceiptdistinction int,
	HaveDepartExtends int
)
go

create table pml_edm_file_dinh_kem_vanbannoibo (
	fileDinhKemVanBanNoiBoId decimal(20,0) not null primary key,
	tenFileFull varchar(75) null,
	tenFile varchar(75) null,
	duongDanFile varchar(75) null,
	tieuDe varchar(75) null,
	ngayTao datetime null,
	loaiFile varchar(75) null,
	mucDichFile varchar(75) null,
	vanBanNoiBoId decimal(20,0),
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

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
)
go

create table pml_edm_levelsend (
	levelsendid int not null primary key,
	levelsendname varchar(75) null,
	levelsendcode varchar(75) null
)
go

create table pml_edm_levelsenddetail (
	levelsendid int not null,
	issuingPlaceId varchar(75) not null,
	primary key (levelsendid, issuingPlaceId)
)
go

create table pml_edm_loaivanbannoibo (
	loaiVanBanNoiBoId decimal(20,0) not null primary key,
	kyHieuLoaiVanBanNoiBo varchar(75) null,
	tenLoaiVanBanNoiBo varchar(75) null,
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table pml_edm_log_vanbannoibo (
	logVanBanNoiBoId decimal(20,0) not null primary key,
	buocLuanChuyen int,
	nguoiXuLy decimal(20,0),
	ngayXuLy datetime null,
	nguoiNhan decimal(20,0),
	ngayNhan datetime null,
	trangThaiTruoc varchar(75) null,
	trangThaiSau varchar(75) null,
	ngayGui datetime null,
	phongXuLyChinh varchar(75) null,
	nguoiXuLyChinh decimal(20,0),
	loaiQuyTrinh int,
	ngayHetHan datetime null,
	soNgayXuLy int,
	processInstanceId decimal(20,0),
	thongTinXuLy varchar(75) null,
	step int,
	nguoiXuLyTrucTiep decimal(20,0),
	phongXuLy varchar(75) null,
	phongNhan varchar(75) null,
	vanBanHoanThanhHayChua int,
	vanBanNoiBoId decimal(20,0),
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table pml_edm_phong_loai_vanbannoibo (
	loaiVanBanNoiBoId decimal(20,0) not null,
	phongVanBanNoiBoId varchar(75) not null,
	primary key (loaiVanBanNoiBoId, phongVanBanNoiBoId)
)
go

create table pml_edm_privilegelevel (
	privilegelevelid varchar(75) not null primary key,
	privilegelevelname varchar(75) null
)
go

create table pml_edm_processdocumentreceiptdetail (
	id decimal(20,0) not null primary key,
	documentreceiptid decimal(20,0),
	userid decimal(20,0),
	note varchar(75) null,
	datecreated datetime null,
	dateupdate datetime null
)
go

create table pml_edm_so_loai_vanbannoibo (
	soVanBanNoiBoId decimal(20,0) not null,
	loaiVanBanNoiBoId decimal(20,0) not null,
	primary key (soVanBanNoiBoId, loaiVanBanNoiBoId)
)
go

create table pml_edm_so_phong_vanbannoibo (
	soVanBanNoiBoId decimal(20,0) not null,
	phongVanBanNoiBoId varchar(75) not null,
	primary key (soVanBanNoiBoId, phongVanBanNoiBoId)
)
go

create table pml_edm_sovanbannoibo (
	soVanBanNoiBoId decimal(20,0) not null primary key,
	maSoVanBanNoiBo varchar(75) null,
	tenSoVanBanNoiBo varchar(75) null,
	ngayTao datetime null,
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table pml_edm_vanbannoibo (
	vanBanNoiBoId decimal(20,0) not null primary key,
	loaiVanBanNoiBo decimal(20,0),
	soVanBanNoiBo decimal(20,0),
	ngayTao datetime null,
	ngayKy datetime null,
	trichYeu varchar(75) null,
	nguoiKy decimal(20,0),
	ghiChu varchar(75) null,
	soVaoSoVanBanNoiBo varchar(75) null,
	soPhatSinhTheoNam int,
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table pml_edm_writedocumentsend (
	bookdocumentsendid decimal(20,0) not null,
	documentsendid decimal(20,0) not null,
	datecreated datetime null,
	soCongVanDiPhongHienTai int,
	primary key (bookdocumentsendid, documentsendid)
)
go

create table pml_field (
	fieldId varchar(75) not null primary key,
	fieldCode varchar(75) null,
	fieldName varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	departmentsId varchar(75) null
)
go

create table pml_file (
	fileId varchar(75) not null primary key,
	cityId varchar(75) null,
	districtId varchar(75) null,
	wardsId varchar(75) null,
	streetId varchar(75) null,
	exactReturningDate datetime null,
	receiverId decimal(20,0),
	validDate datetime null,
	expectedReturningDate datetime null,
	applicationDate datetime null,
	otherContent varchar(75) null,
	briefContent varchar(75) null,
	applicantName varchar(75) null,
	organization varchar(75) null,
	authorisedLetter varchar(75) null,
	idNumber varchar(75) null,
	issuingDate datetime null,
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
	solvingTime int,
	amendedContent varchar(75) null,
	landCheckingDate datetime null,
	decisionNotice varchar(75) null,
	receiver varchar(75) null,
	dateCreated datetime null,
	lastUpdate datetime null,
	lasttestprocessinfo varchar(75) null,
	active varchar(75) null,
	generalorderno decimal(20,0)
)
go

create table pml_file_attachedfile (
	fileAttachedFileId varchar(75) not null primary key,
	fileId varchar(75) null,
	original int,
	copy_ int,
	attachedFileId varchar(75) null,
	attachedFileName varchar(75) null,
	note varchar(75) null
)
go

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
	filenumber int,
	inputdatadate datetime null,
	noteinformationmanagement varchar(75) null,
	totalhour int,
	totaldate int,
	conclusion varchar(75) null,
	receiveofunit varchar(75) null,
	applicanttime varchar(75) null
)
go

create table pml_filepccc_attachedfile (
	attachedfileid decimal(20,0) not null primary key,
	filepcccid varchar(75) null,
	objecttype varchar(75) null,
	attachedfilename varchar(75) null,
	path varchar(75) null,
	datecreated datetime null,
	filetype varchar(75) null,
	title varchar(75) null
)
go

create table pml_filereturninginfo (
	filereturninginfoid decimal(20,0) not null primary key,
	fileid varchar(75) null,
	filesender varchar(75) null,
	licensenumber varchar(75) null,
	issuingdatelicense datetime null,
	receivelicensedate datetime null,
	documentnumber varchar(75) null,
	billnumber varchar(75) null,
	numbermoney decimal(20,0),
	note varchar(75) null,
	conclude varchar(75) null
)
go

create table pml_filestatus (
	filestatusid decimal(20,0) not null primary key,
	filestatuscode varchar(75) null,
	filestatusname varchar(75) null,
	description varchar(75) null,
	active varchar(75) null,
	type varchar(75) null
)
go

create table pml_filestatus_stateprocess (
	id decimal(20,0) not null primary key,
	filestatusid decimal(20,0),
	stateprocessid decimal(20,0),
	description varchar(75) null
)
go

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
)
go

create table pml_filetype_attachedfile (
	filetypeAttachedFileId varchar(75) not null primary key,
	fileTypeId varchar(75) null,
	original int,
	copy_ int,
	attachedFileId varchar(75) null,
	attachedFileName varchar(75) null,
	note varchar(75) null
)
go

create table pml_filetypedelegate (
	filetypedelegateid decimal(20,0) not null primary key,
	filetypeid varchar(75) null,
	delegateid decimal(20,0)
)
go

create table pml_ho_so_cong_viec (
	id_ho_so_cong_viec decimal(20,0) not null primary key,
	userId decimal(20,0),
	userName varchar(75) null,
	id_hscv_cha decimal(20,0),
	so_hieu_hscv varchar(75) null,
	tieu_de varchar(75) null,
	ngay_mo_hscv datetime null,
	han_xu_ly datetime null,
	id_linh_vuc varchar(75) null,
	van_de_lien_quan varchar(75) null,
	id_do_quan_trong decimal(20,0),
	id_tinh_chat decimal(20,0),
	id_trang_thai_hscv decimal(20,0),
	tom_tat_noi_dung varchar(75) null,
	hoat_dong varchar(75) null
)
go

create table pml_holiday (
	holidayid decimal(20,0) not null primary key,
	holiday_type varchar(75) null,
	holiday_value varchar(75) null,
	from_date datetime null,
	to_date datetime null
)
go

create table pml_main_support (
	processid decimal(20,0) not null primary key,
	processid_main decimal(20,0),
	type_ varchar(75) null,
	supportinfomation varchar(75) null
)
go

create table pml_manage_documentworkflow (
	managedocumentworkflowid decimal(20,0) not null primary key,
	workflowname varchar(75) null,
	version_ int,
	type_ int,
	description varchar(75) null,
	startdate datetime null,
	enddate datetime null
)
go

create table pml_message_note (
	messageId decimal(20,0) not null primary key,
	documentId decimal(20,0),
	fromUserId decimal(20,0),
	toUserId decimal(20,0),
	createDate datetime null,
	objectType varchar(75) null,
	isAlert int
)
go

create table pml_nation (
	nationid varchar(75) not null primary key,
	nationcode varchar(75) null,
	nationname varchar(75) null,
	countryid varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_organization_external (
	orgexternalid decimal(20,0) not null primary key,
	orgexternalcode varchar(75) null,
	orgexternalname varchar(75) null,
	isownerorg int
)
go

create table pml_paintdocument (
	paintdocumentid decimal(20,0) not null primary key,
	fileid varchar(75) null,
	paintdocumentname varchar(75) null,
	quantity int,
	note varchar(75) null
)
go

create table pml_position (
	positionid varchar(75) not null primary key,
	positioncode varchar(75) null,
	positionname varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_processdispose (
	processdisposeid decimal(20,0) not null primary key,
	fileid varchar(75) null,
	transition_ int,
	processer decimal(20,0),
	dateprocess datetime null,
	processinfomation varchar(75) null,
	receiver decimal(20,0),
	receivedate datetime null,
	stateprocessidbefore decimal(20,0),
	stateprocessidafter decimal(20,0),
	expireddate datetime null,
	delegateuser decimal(20,0),
	senddate datetime null
)
go

create table pml_processtype (
	processtypeid decimal(20,0) not null primary key,
	name varchar(75) null,
	flagprocesstype int
)
go

create table pml_role (
	roleid varchar(75) not null primary key,
	rolecode varchar(75) null,
	rolename varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_room_resource (
	roomId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	roomName varchar(255) null,
	description varchar(1000) null
)
go

create table pml_saveprocesstype (
	sptid decimal(20,0) not null primary key,
	docId decimal(20,0),
	flagprocesstype decimal(20,0),
	flag int
)
go

create table pml_screecalendar_heigth (
	screesalendarheigthid decimal(20,0) not null primary key
)
go

create table pml_screencalendar_height (
	screencalendarheightid decimal(20,0) not null primary key
)
go

create table pml_signer (
	signerId decimal(20,0) not null primary key,
	userId decimal(20,0)
)
go

create table pml_state_department (
	departmentid varchar(75) not null,
	statewfid decimal(20,0) not null,
	primary key (departmentid, statewfid)
)
go

create table pml_state_wf (
	statewfid decimal(20,0) not null primary key,
	workflow varchar(75) null,
	stateprocessid decimal(20,0),
	solvingtime int,
	version_ int
)
go

create table pml_stateprocess (
	stateprocessid decimal(20,0) not null primary key,
	stateprocesscode varchar(75) null,
	stateprocessname varchar(75) null,
	filestatusid decimal(20,0),
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_street (
	streetId varchar(75) not null primary key,
	streetName varchar(75) null
)
go

create table pml_team (
	teamid decimal(20,0) not null primary key,
	departmentid varchar(75) null,
	teamname varchar(75) null,
	description varchar(75) null,
	organizationid decimal(20,0),
	companyid decimal(20,0),
	specialteam varchar(75) null,
	teamcode varchar(75) null
)
go

create table pml_teamleader (
	teamid decimal(20,0) not null primary key,
	userid decimal(20,0)
)
go

create table pml_template (
	templateId decimal(20,0) not null primary key,
	templateCode varchar(75) null,
	templateName varchar(75) null,
	numberOfDocument int,
	publishDate datetime null,
	departmentId varchar(75) null
)
go

create table pml_template_file (
	fileTemplateId decimal(20,0) not null primary key,
	templateId decimal(20,0),
	tenFile varchar(75) null,
	kichThuoc decimal(20,0),
	duongDan varchar(75) null
)
go

create table pml_tinh_chat (
	id_tinh_chat decimal(20,0) not null primary key,
	ten_tinh_chat varchar(75) null
)
go

create table pml_trang_thai_hscv (
	id_trang_thai_hscv decimal(20,0) not null primary key,
	ten_trang_thai_hscv varchar(75) null
)
go

create table pml_transition (
	transitionid decimal(20,0) not null primary key,
	transitionname varchar(75) null,
	filetypeid varchar(75) null,
	notransition int,
	stateprocesscurrent decimal(20,0),
	stateprocessnext decimal(20,0),
	version_ varchar(75) null
)
go

create table pml_user (
	userId decimal(20,0) not null primary key,
	positionId varchar(75) null,
	departmentsId varchar(75) null,
	roleId varchar(75) null,
	handphone varchar(75) null,
	note varchar(75) null,
	teamid decimal(20,0),
	active int,
	screenname varchar(75) null,
	firstname varchar(75) null,
	middlename varchar(75) null,
	lastname varchar(75) null,
	male int,
	birthday datetime null,
	isleadermetting int,
	isvanthuphong int
)
go

create table pml_user_file_type (
	userid decimal(20,0) not null,
	filetypeid varchar(75) not null,
	description varchar(75) null,
	primary key (userid, filetypeid)
)
go

create table pml_wards (
	wardsId varchar(75) not null primary key,
	wardsCode varchar(75) null,
	wardsName varchar(75) null,
	districtId varchar(75) null,
	description varchar(75) null,
	active varchar(75) null
)
go

create table pml_wf_onedoor (
	fileId varchar(75) not null primary key,
	processId decimal(20,0),
	nodeId decimal(20,0)
)
go

create table pml_workflow (
	workflowId decimal(20,0) not null primary key,
	fileTypeId varchar(75) null,
	workflow varchar(75) null,
	version_ int,
	startDate datetime null,
	endDate datetime null
)
go

create table report_registry_work (
	reportRegistryId decimal(20,0) not null primary key,
	reportRegistryCode varchar(75) null,
	userCreate varchar(75) null,
	resultWork varchar(75) null,
	programWork varchar(75) null,
	reportDate datetime null,
	departmentId decimal(20,0),
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table result_program_file (
	resultProgramId decimal(20,0) not null primary key,
	resultProgramTitle varchar(75) null,
	resultProgramPath varchar(75) null,
	resultProgramCheck varchar(75) null,
	reportRegistryId decimal(20,0),
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go



insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (1, 'Canada', 'CA', 'CAN', '124', '001', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (2, 'China', 'CN', 'CHN', '156', '086', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (3, 'France', 'FR', 'FRA', '250', '033', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (4, 'Germany', 'DE', 'DEU', '276', '049', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (5, 'Hong Kong', 'HK', 'HKG', '344', '852', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (6, 'Hungary', 'HU', 'HUN', '348', '036', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (7, 'Israel', 'IL', 'ISR', '376', '972', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (8, 'Italy', 'IT', 'ITA', '380', '039', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (9, 'Japan', 'JP', 'JPN', '392', '081', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (10, 'South Korea', 'KR', 'KOR', '410', '082', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (11, 'Netherlands', 'NL', 'NLD', '528', '031', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (12, 'Portugal', 'PT', 'PRT', '620', '351', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (13, 'Russia', 'RU', 'RUS', '643', '007', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (14, 'Singapore', 'SG', 'SGP', '702', '065', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (15, 'Spain', 'ES', 'ESP', '724', '034', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (16, 'Turkey', 'TR', 'TUR', '792', '090', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (17, 'Vietnam', 'VM', 'VNM', '704', '084', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (18, 'United Kingdom', 'GB', 'GBR', '826', '044', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (19, 'United States', 'US', 'USA', '840', '001', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (20, 'Afghanistan', 'AF', 'AFG', '4', '093', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (21, 'Albania', 'AL', 'ALB', '8', '355', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (22, 'Algeria', 'DZ', 'DZA', '12', '213', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (23, 'American Samoa', 'AS', 'ASM', '16', '684', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (24, 'Andorra', 'AD', 'AND', '20', '376', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (25, 'Angola', 'AO', 'AGO', '24', '244', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (26, 'Anguilla', 'AI', 'AIA', '660', '264', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (27, 'Antarctica', 'AQ', 'ATA', '10', '672', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (28, 'Antigua', 'AG', 'ATG', '28', '268', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (29, 'Argentina', 'AR', 'ARG', '32', '054', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (30, 'Armenia', 'AM', 'ARM', '51', '374', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (31, 'Aruba', 'AW', 'ABW', '533', '297', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (32, 'Australia', 'AU', 'AUS', '36', '061', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (33, 'Austria', 'AT', 'AUT', '40', '043', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (34, 'Azerbaijan', 'AZ', 'AZE', '31', '994', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (35, 'Bahamas', 'BS', 'BHS', '44', '242', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (36, 'Bahrain', 'BH', 'BHR', '48', '973', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (37, 'Bangladesh', 'BD', 'BGD', '50', '880', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (38, 'Barbados', 'BB', 'BRB', '52', '246', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (39, 'Belarus', 'BY', 'BLR', '112', '375', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (40, 'Belgium', 'BE', 'BEL', '56', '032', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (41, 'Belize', 'BZ', 'BLZ', '84', '501', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (42, 'Benin', 'BJ', 'BEN', '204', '229', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (43, 'Bermuda', 'BM', 'BMU', '60', '441', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (44, 'Bhutan', 'BT', 'BTN', '64', '975', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (45, 'Bolivia', 'BO', 'BOL', '68', '591', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (46, 'Bosnia-Herzegovina', 'BA', 'BIH', '70', '387', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (47, 'Botswana', 'BW', 'BWA', '72', '267', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (48, 'Brazil', 'BR', 'BRA', '76', '055', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (49, 'British Virgin Islands', 'VG', 'VGB', '92', '284', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (50, 'Brunei', 'BN', 'BRN', '96', '673', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (51, 'Bulgaria', 'BG', 'BGR', '100', '359', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (52, 'Burkina Faso', 'BF', 'BFA', '854', '226', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (53, 'Burma (Myanmar)', 'MM', 'MMR', '104', '095', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (54, 'Burundi', 'BI', 'BDI', '108', '257', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (55, 'Cambodia', 'KH', 'KHM', '116', '855', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (56, 'Cameroon', 'CM', 'CMR', '120', '237', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (57, 'Cape Verde Island', 'CV', 'CPV', '132', '238', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (58, 'Cayman Islands', 'KY', 'CYM', '136', '345', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (59, 'Central African Republic', 'CF', 'CAF', '140', '236', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (60, 'Chad', 'TD', 'TCD', '148', '235', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (61, 'Chile', 'CL', 'CHL', '152', '056', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (62, 'Christmas Island', 'CX', 'CXR', '162', '061', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (63, 'Cocos Islands', 'CC', 'CCK', '166', '061', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (64, 'Colombia', 'CO', 'COL', '170', '057', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (65, 'Comoros', 'KM', 'COM', '174', '269', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (66, 'Republic of Congo', 'CD', 'COD', '180', '242', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (67, 'Democratic Republic of Congo', 'CG', 'COG', '178', '243', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (68, 'Cook Islands', 'CK', 'COK', '184', '682', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (69, 'Costa Rica', 'CR', 'CRI', '188', '506', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (70, 'Croatia', 'HR', 'HRV', '191', '385', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (71, 'Cuba', 'CU', 'CUB', '192', '053', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (72, 'Cyprus', 'CY', 'CYP', '196', '357', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (73, 'Czech Republic', 'CZ', 'CZE', '203', '420', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (74, 'Denmark', 'DK', 'DNK', '208', '045', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (75, 'Djibouti', 'DJ', 'DJI', '262', '253', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (76, 'Dominica', 'DM', 'DMA', '212', '767', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (77, 'Dominican Republic', 'DO', 'DOM', '214', '809', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (78, 'Ecuador', 'EC', 'ECU', '218', '593', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (79, 'Egypt', 'EG', 'EGY', '818', '020', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (80, 'El Salvador', 'SV', 'SLV', '222', '503', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (81, 'Equatorial Guinea', 'GQ', 'GNQ', '226', '240', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (82, 'Eritrea', 'ER', 'ERI', '232', '291', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (83, 'Estonia', 'EE', 'EST', '233', '372', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (84, 'Ethiopia', 'ET', 'ETH', '231', '251', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (85, 'Faeroe Islands', 'FO', 'FRO', '234', '298', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (86, 'Falkland Islands', 'FK', 'FLK', '238', '500', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (87, 'Fiji Islands', 'FJ', 'FJI', '242', '679', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (88, 'Finland', 'FI', 'FIN', '246', '358', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (89, 'French Guiana', 'GF', 'GUF', '254', '594', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (90, 'French Polynesia', 'PF', 'PYF', '258', '689', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (91, 'Gabon', 'GA', 'GAB', '266', '241', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (92, 'Gambia', 'GM', 'GMB', '270', '220', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (93, 'Georgia', 'GE', 'GEO', '268', '995', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (94, 'Ghana', 'GH', 'GHA', '288', '233', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (95, 'Gibraltar', 'GI', 'GIB', '292', '350', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (96, 'Greece', 'GR', 'GRC', '300', '030', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (97, 'Greenland', 'GL', 'GRL', '304', '299', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (98, 'Grenada', 'GD', 'GRD', '308', '473', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (99, 'Guadeloupe', 'GP', 'GLP', '312', '590', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (100, 'Guam', 'GU', 'GUM', '316', '671', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (101, 'Guatemala', 'GT', 'GTM', '320', '502', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (102, 'Guinea', 'GN', 'GIN', '324', '224', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (103, 'Guinea-Bissau', 'GW', 'GNB', '624', '245', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (104, 'Guyana', 'GY', 'GUY', '328', '592', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (105, 'Haiti', 'HT', 'HTI', '332', '509', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (106, 'Honduras', 'HN', 'HND', '340', '504', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (107, 'Iceland', 'IS', 'ISL', '352', '354', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (108, 'India', 'IN', 'IND', '356', '091', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (109, 'Indonesia', 'ID', 'IDN', '360', '062', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (110, 'Iran', 'IR', 'IRN', '364', '098', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (111, 'Iraq', 'IQ', 'IRQ', '368', '964', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (112, 'Ireland', 'IE', 'IRL', '372', '353', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (113, 'Ivory Coast', 'CI', 'CIV', '384', '225', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (114, 'Jamaica', 'JM', 'JAM', '388', '876', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (115, 'Jordan', 'JO', 'JOR', '400', '962', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (116, 'Kazakhstan', 'KZ', 'KAZ', '398', '007', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (117, 'Kenya', 'KE', 'KEN', '404', '254', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (118, 'Kiribati', 'KI', 'KIR', '408', '686', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (119, 'Kuwait', 'KW', 'KWT', '414', '965', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (120, 'North Korea', 'KP', 'PRK', '408', '850', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (121, 'Kyrgyzstan', 'KG', 'KGZ', '471', '996', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (122, 'Laos', 'LA', 'LAO', '418', '856', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (123, 'Latvia', 'LV', 'LVA', '428', '371', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (124, 'Lebanon', 'LB', 'LBN', '422', '961', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (125, 'Lesotho', 'LS', 'LSO', '426', '266', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (126, 'Liberia', 'LR', 'LBR', '430', '231', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (127, 'Libya', 'LY', 'LBY', '434', '218', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (128, 'Liechtenstein', 'LI', 'LIE', '438', '423', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (129, 'Lithuania', 'LT', 'LTU', '440', '370', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (130, 'Luxembourg', 'LU', 'LUX', '442', '352', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (131, 'Macau', 'MO', 'MAC', '446', '853', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (132, 'Macedonia', 'MK', 'MKD', '807', '389', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (133, 'Madagascar', 'MG', 'MDG', '450', '261', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (134, 'Malawi', 'MW', 'MWI', '454', '265', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (135, 'Malaysia', 'MY', 'MYS', '458', '060', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (136, 'Maldives', 'MV', 'MDV', '462', '960', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (137, 'Mali', 'ML', 'MLI', '466', '223', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (138, 'Malta', 'MT', 'MLT', '470', '356', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (139, 'Marshall Islands', 'MH', 'MHL', '584', '692', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (140, 'Martinique', 'MQ', 'MTQ', '474', '596', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (141, 'Mauritania', 'MR', 'MRT', '478', '222', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (142, 'Mauritius', 'MU', 'MUS', '480', '230', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (143, 'Mayotte Island', 'YT', 'MYT', '175', '269', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (144, 'Mexico', 'MX', 'MEX', '484', '052', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (145, 'Micronesia', 'FM', 'FSM', '583', '691', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (146, 'Moldova', 'MD', 'MDA', '498', '373', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (147, 'Monaco', 'MC', 'MCO', '492', '377', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (148, 'Mongolia', 'MN', 'MNG', '496', '976', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (149, 'Montenegro', 'ME', 'MNE', '499', '382', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (150, 'Montserrat', 'MS', 'MSR', '500', '664', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (151, 'Morocco', 'MA', 'MAR', '504', '212', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (152, 'Mozambique', 'MZ', 'MOZ', '508', '258', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (153, 'Namibia', 'NA', 'NAM', '516', '264', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (154, 'Nauru', 'NR', 'NRU', '520', '674', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (155, 'Nepal', 'NP', 'NPL', '524', '977', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (156, 'Netherlands Antilles', 'AN', 'ANT', '530', '599', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (157, 'New Caledonia', 'NC', 'NCL', '540', '687', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (158, 'New Zealand', 'NZ', 'NZL', '554', '064', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (159, 'Nicaragua', 'NI', 'NIC', '558', '505', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (160, 'Niger', 'NE', 'NER', '562', '227', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (161, 'Nigeria', 'NG', 'NGA', '566', '234', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (162, 'Niue', 'NU', 'NIU', '570', '683', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (163, 'Norfolk Island', 'NF', 'NFK', '574', '672', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (164, 'Norway', 'NO', 'NOR', '578', '047', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (165, 'Oman', 'OM', 'OMN', '512', '968', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (166, 'Pakistan', 'PK', 'PAK', '586', '092', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (167, 'Palau', 'PW', 'PLW', '585', '680', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (168, 'Palestine', 'PS', 'PSE', '275', '970', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (169, 'Panama', 'PA', 'PAN', '591', '507', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (170, 'Papua New Guinea', 'PG', 'PNG', '598', '675', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (171, 'Paraguay', 'PY', 'PRY', '600', '595', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (172, 'Peru', 'PE', 'PER', '604', '051', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (173, 'Philippines', 'PH', 'PHL', '608', '063', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (174, 'Poland', 'PL', 'POL', '616', '048', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (175, 'Puerto Rico', 'PR', 'PRI', '630', '787', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (176, 'Qatar', 'QA', 'QAT', '634', '974', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (177, 'Reunion Island', 'RE', 'REU', '638', '262', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (178, 'Romania', 'RO', 'ROU', '642', '040', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (179, 'Rwanda', 'RW', 'RWA', '646', '250', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (180, 'St. Helena', 'SH', 'SHN', '654', '290', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (181, 'St. Kitts', 'KN', 'KNA', '659', '869', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (182, 'St. Lucia', 'LC', 'LCA', '662', '758', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (183, 'St. Pierre & Miquelon', 'PM', 'SPM', '666', '508', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (184, 'St. Vincent', 'VC', 'VCT', '670', '784', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (185, 'San Marino', 'SM', 'SMR', '674', '378', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (186, 'Sao Tome & Principe', 'ST', 'STP', '678', '239', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (187, 'Saudi Arabia', 'SA', 'SAU', '682', '966', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (188, 'Senegal', 'SN', 'SEN', '686', '221', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (189, 'Serbia', 'RS', 'SRB', '688', '381', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (190, 'Seychelles', 'SC', 'SYC', '690', '248', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (191, 'Sierra Leone', 'SL', 'SLE', '694', '249', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (192, 'Slovakia', 'SK', 'SVK', '703', '421', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (193, 'Slovenia', 'SI', 'SVN', '705', '386', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (194, 'Solomon Islands', 'SB', 'SLB', '90', '677', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (195, 'Somalia', 'SO', 'SOM', '706', '252', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (196, 'South Africa', 'ZA', 'ZAF', '710', '027', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (197, 'Sri Lanka', 'LK', 'LKA', '144', '094', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (198, 'Sudan', 'SD', 'SDN', '736', '095', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (199, 'Suriname', 'SR', 'SUR', '740', '597', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (200, 'Swaziland', 'SZ', 'SWZ', '748', '268', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (201, 'Sweden', 'SE', 'SWE', '752', '046', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (202, 'Switzerland', 'CH', 'CHE', '756', '041', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (203, 'Syria', 'SY', 'SYR', '760', '963', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (204, 'Taiwan', 'TW', 'TWN', '158', '886', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (205, 'Tajikistan', 'TJ', 'TJK', '762', '992', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (206, 'Tanzania', 'TZ', 'TZA', '834', '255', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (207, 'Thailand', 'TH', 'THA', '764', '066', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (208, 'Togo', 'TG', 'TGO', '768', '228', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (209, 'Tonga', 'TO', 'TON', '776', '676', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (210, 'Trinidad & Tobago', 'TT', 'TTO', '780', '868', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (211, 'Tunisia', 'TN', 'TUN', '788', '216', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (212, 'Turkmenistan', 'TM', 'TKM', '795', '993', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (213, 'Turks & Caicos', 'TC', 'TCA', '796', '649', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (214, 'Tuvalu', 'TV', 'TUV', '798', '688', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (215, 'Uganda', 'UG', 'UGA', '800', '256', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (216, 'Ukraine', 'UA', 'UKR', '804', '380', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (217, 'United Arab Emirates', 'AE', 'ARE', '784', '971', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (218, 'Uruguay', 'UY', 'URY', '858', '598', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (219, 'Uzbekistan', 'UZ', 'UZB', '860', '998', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (220, 'Vanuatu', 'VU', 'VUT', '548', '678', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (221, 'Vatican City', 'VA', 'VAT', '336', '039', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (222, 'Venezuela', 'VE', 'VEN', '862', '058', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (223, 'Wallis & Futuna', 'WF', 'WLF', '876', '681', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (224, 'Western Samoa', 'EH', 'ESH', '732', '685', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (225, 'Yemen', 'YE', 'YEM', '887', '967', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (226, 'Zambia', 'ZM', 'ZMB', '894', '260', 1)
go
insert into Country (countryId, name, a2, a3, number_, idd_, active_) values (227, 'Zimbabwe', 'ZW', 'ZWE', '716', '263', 1)
go

insert into Region (regionId, countryId, regionCode, name, active_) values (1, 19, 'AL', 'Alabama', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (2, 19, 'AK', 'Alaska', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3, 19, 'AZ', 'Arizona', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4, 19, 'AR', 'Arkansas', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (5, 19, 'CA', 'California', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (6, 19, 'CO', 'Colorado', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (7, 19, 'CT', 'Connecticut', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8, 19, 'DC', 'District of Columbia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (9, 19, 'DE', 'Delaware', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (10, 19, 'FL', 'Florida', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (11, 19, 'GA', 'Georgia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (12, 19, 'HI', 'Hawaii', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (13, 19, 'ID', 'Idaho', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (14, 19, 'IL', 'Illinois', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15, 19, 'IN', 'Indiana', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (16, 19, 'IA', 'Iowa', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (17, 19, 'KS', 'Kansas', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (18, 19, 'KY', 'Kentucky ', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19, 19, 'LA', 'Louisiana ', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (20, 19, 'ME', 'Maine', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (21, 19, 'MD', 'Maryland', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (22, 19, 'MA', 'Massachusetts', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (23, 19, 'MI', 'Michigan', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (24, 19, 'MN', 'Minnesota', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (25, 19, 'MS', 'Mississippi', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (26, 19, 'MO', 'Missouri', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (27, 19, 'MT', 'Montana', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (28, 19, 'NE', 'Nebraska', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (29, 19, 'NV', 'Nevada', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (30, 19, 'NH', 'New Hampshire', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (31, 19, 'NJ', 'New Jersey', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (32, 19, 'NM', 'New Mexico', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (33, 19, 'NY', 'New York', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (34, 19, 'NC', 'North Carolina', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (35, 19, 'ND', 'North Dakota', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (36, 19, 'OH', 'Ohio', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (37, 19, 'OK', 'Oklahoma ', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (38, 19, 'OR', 'Oregon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (39, 19, 'PA', 'Pennsylvania', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (40, 19, 'PR', 'Puerto Rico', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (41, 19, 'RI', 'Rhode Island', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (42, 19, 'SC', 'South Carolina', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (43, 19, 'SD', 'South Dakota', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (44, 19, 'TN', 'Tennessee', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (45, 19, 'TX', 'Texas', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (46, 19, 'UT', 'Utah', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (47, 19, 'VT', 'Vermont', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (48, 19, 'VA', 'Virginia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (49, 19, 'WA', 'Washington', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (50, 19, 'WV', 'West Virginia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (51, 19, 'WI', 'Wisconsin', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (52, 19, 'WY', 'Wyoming', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (53, 1, 'AL', 'Alberta', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (54, 1, 'BC', 'British Columbia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (55, 1, 'MB', 'Manitoba', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (56, 1, 'NB', 'New Brunswick', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (57, 1, 'NL', 'Newfoundland and Labrador', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (58, 1, 'NT', 'Northwest Territories', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (59, 1, 'NS', 'Nova Scotia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (60, 1, 'NU', 'Nunavut', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (61, 1, 'ON', 'Ontario', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (62, 1, 'PE', 'Prince Edward Island', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (63, 1, 'QC', 'Quebec', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (64, 1, 'SK', 'Saskatchewan', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (65, 1, 'YT', 'Yukon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (66, 15, 'AN', 'Andalusia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (67, 15, 'AR', 'Aragon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (68, 15, 'AS', 'Asturias', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (69, 15, 'IB', 'Balearic Islands', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (70, 15, 'PV', 'Basque Country', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (71, 15, 'CN', 'Canary Islands', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (72, 15, 'CB', 'Cantabria', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (73, 15, 'CL', 'Castile and Leon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (74, 15, 'CM', 'Castile-La Mancha', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (75, 15, 'CT', 'Catalonia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (76, 15, 'CE', 'Ceuta', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (77, 15, 'EX', 'Extremadura', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (78, 15, 'GA', 'Galicia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (79, 15, 'LO', 'La Rioja', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (80, 15, 'M', 'Madrid', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (81, 15, 'ML', 'Melilla', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (82, 15, 'MU', 'Murcia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (83, 15, 'NA', 'Navarra', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (84, 15, 'VC', 'Valencia', 1)
go

--
-- List types for accounts
--

insert into ListType (listTypeId, name, type_) values (10000, 'Billing', 'com.liferay.portal.model.Account.address')
go
insert into ListType (listTypeId, name, type_) values (10001, 'Other', 'com.liferay.portal.model.Account.address')
go
insert into ListType (listTypeId, name, type_) values (10002, 'P.O. Box', 'com.liferay.portal.model.Account.address')
go
insert into ListType (listTypeId, name, type_) values (10003, 'Shipping', 'com.liferay.portal.model.Account.address')
go

insert into ListType (listTypeId, name, type_) values (10004, 'E-mail', 'com.liferay.portal.model.Account.emailAddress')
go
insert into ListType (listTypeId, name, type_) values (10005, 'E-mail 2', 'com.liferay.portal.model.Account.emailAddress')
go
insert into ListType (listTypeId, name, type_) values (10006, 'E-mail 3', 'com.liferay.portal.model.Account.emailAddress')
go

insert into ListType (listTypeId, name, type_) values (10007, 'Fax', 'com.liferay.portal.model.Account.phone')
go
insert into ListType (listTypeId, name, type_) values (10008, 'Local', 'com.liferay.portal.model.Account.phone')
go
insert into ListType (listTypeId, name, type_) values (10009, 'Other', 'com.liferay.portal.model.Account.phone')
go
insert into ListType (listTypeId, name, type_) values (10010, 'Toll-Free', 'com.liferay.portal.model.Account.phone')
go
insert into ListType (listTypeId, name, type_) values (10011, 'TTY', 'com.liferay.portal.model.Account.phone')
go

insert into ListType (listTypeId, name, type_) values (10012, 'Intranet', 'com.liferay.portal.model.Account.website')
go
insert into ListType (listTypeId, name, type_) values (10013, 'Public', 'com.liferay.portal.model.Account.website')
go

--
-- List types for contacts
--

insert into ListType (listTypeId, name, type_) values (11000, 'Business', 'com.liferay.portal.model.Contact.address')
go
insert into ListType (listTypeId, name, type_) values (11001, 'Other', 'com.liferay.portal.model.Contact.address')
go
insert into ListType (listTypeId, name, type_) values (11002, 'Personal', 'com.liferay.portal.model.Contact.address')
go

insert into ListType (listTypeId, name, type_) values (11003, 'E-mail', 'com.liferay.portal.model.Contact.emailAddress')
go
insert into ListType (listTypeId, name, type_) values (11004, 'E-mail 2', 'com.liferay.portal.model.Contact.emailAddress')
go
insert into ListType (listTypeId, name, type_) values (11005, 'E-mail 3', 'com.liferay.portal.model.Contact.emailAddress')
go

insert into ListType (listTypeId, name, type_) values (11006, 'Business', 'com.liferay.portal.model.Contact.phone')
go
insert into ListType (listTypeId, name, type_) values (11007, 'Business Fax', 'com.liferay.portal.model.Contact.phone')
go
insert into ListType (listTypeId, name, type_) values (11008, 'Mobile', 'com.liferay.portal.model.Contact.phone')
go
insert into ListType (listTypeId, name, type_) values (11009, 'Other', 'com.liferay.portal.model.Contact.phone')
go
insert into ListType (listTypeId, name, type_) values (11010, 'Pager', 'com.liferay.portal.model.Contact.phone')
go
insert into ListType (listTypeId, name, type_) values (11011, 'Personal', 'com.liferay.portal.model.Contact.phone')
go
insert into ListType (listTypeId, name, type_) values (11012, 'Personal Fax', 'com.liferay.portal.model.Contact.phone')
go
insert into ListType (listTypeId, name, type_) values (11013, 'TTY', 'com.liferay.portal.model.Contact.phone')
go

insert into ListType (listTypeId, name, type_) values (11014, 'Dr.', 'com.liferay.portal.model.Contact.prefix')
go
insert into ListType (listTypeId, name, type_) values (11015, 'Mr.', 'com.liferay.portal.model.Contact.prefix')
go
insert into ListType (listTypeId, name, type_) values (11016, 'Mrs.', 'com.liferay.portal.model.Contact.prefix')
go
insert into ListType (listTypeId, name, type_) values (11017, 'Ms.', 'com.liferay.portal.model.Contact.prefix')
go

insert into ListType (listTypeId, name, type_) values (11020, 'II', 'com.liferay.portal.model.Contact.suffix')
go
insert into ListType (listTypeId, name, type_) values (11021, 'III', 'com.liferay.portal.model.Contact.suffix')
go
insert into ListType (listTypeId, name, type_) values (11022, 'IV', 'com.liferay.portal.model.Contact.suffix')
go
insert into ListType (listTypeId, name, type_) values (11023, 'Jr.', 'com.liferay.portal.model.Contact.suffix')
go
insert into ListType (listTypeId, name, type_) values (11024, 'PhD.', 'com.liferay.portal.model.Contact.suffix')
go
insert into ListType (listTypeId, name, type_) values (11025, 'Sr.', 'com.liferay.portal.model.Contact.suffix')
go

insert into ListType (listTypeId, name, type_) values (11026, 'Blog', 'com.liferay.portal.model.Contact.website')
go
insert into ListType (listTypeId, name, type_) values (11027, 'Business', 'com.liferay.portal.model.Contact.website')
go
insert into ListType (listTypeId, name, type_) values (11028, 'Other', 'com.liferay.portal.model.Contact.website')
go
insert into ListType (listTypeId, name, type_) values (11029, 'Personal', 'com.liferay.portal.model.Contact.website')
go

--
-- List types for organizations
--

insert into ListType (listTypeId, name, type_) values (12000, 'Billing', 'com.liferay.portal.model.Organization.address')
go
insert into ListType (listTypeId, name, type_) values (12001, 'Other', 'com.liferay.portal.model.Organization.address')
go
insert into ListType (listTypeId, name, type_) values (12002, 'P.O. Box', 'com.liferay.portal.model.Organization.address')
go
insert into ListType (listTypeId, name, type_) values (12003, 'Shipping', 'com.liferay.portal.model.Organization.address')
go

insert into ListType (listTypeId, name, type_) values (12004, 'E-mail', 'com.liferay.portal.model.Organization.emailAddress')
go
insert into ListType (listTypeId, name, type_) values (12005, 'E-mail 2', 'com.liferay.portal.model.Organization.emailAddress')
go
insert into ListType (listTypeId, name, type_) values (12006, 'E-mail 3', 'com.liferay.portal.model.Organization.emailAddress')
go

insert into ListType (listTypeId, name, type_) values (12007, 'Fax', 'com.liferay.portal.model.Organization.phone')
go
insert into ListType (listTypeId, name, type_) values (12008, 'Local', 'com.liferay.portal.model.Organization.phone')
go
insert into ListType (listTypeId, name, type_) values (12009, 'Other', 'com.liferay.portal.model.Organization.phone')
go
insert into ListType (listTypeId, name, type_) values (12010, 'Toll-Free', 'com.liferay.portal.model.Organization.phone')
go
insert into ListType (listTypeId, name, type_) values (12011, 'TTY', 'com.liferay.portal.model.Organization.phone')
go

insert into ListType (listTypeId, name, type_) values (12012, 'Administrative', 'com.liferay.portal.model.Organization.service')
go
insert into ListType (listTypeId, name, type_) values (12013, 'Contracts', 'com.liferay.portal.model.Organization.service')
go
insert into ListType (listTypeId, name, type_) values (12014, 'Donation', 'com.liferay.portal.model.Organization.service')
go
insert into ListType (listTypeId, name, type_) values (12015, 'Retail', 'com.liferay.portal.model.Organization.service')
go
insert into ListType (listTypeId, name, type_) values (12016, 'Training', 'com.liferay.portal.model.Organization.service')
go

insert into ListType (listTypeId, name, type_) values (12017, 'Full Member', 'com.liferay.portal.model.Organization.status')
go
insert into ListType (listTypeId, name, type_) values (12018, 'Provisional Member', 'com.liferay.portal.model.Organization.status')
go

insert into ListType (listTypeId, name, type_) values (12019, 'Intranet', 'com.liferay.portal.model.Organization.website')
go
insert into ListType (listTypeId, name, type_) values (12020, 'Public', 'com.liferay.portal.model.Organization.website')
go



insert into Counter values ('com.liferay.counter.model.Counter', 10000)
go






insert into Company (companyId, accountId, webId, virtualHost, mx) values (1, 7, 'liferay.com', 'localhost', 'liferay.com')
go
insert into Account_ (accountId, companyId, userId, userName, createDate, modifiedDate, parentAccountId, name, legalName, legalId, legalType, sicCode, tickerSymbol, industry, type_, size_) values (7, 1, 5, '', getdate(), getdate(), 0, 'Liferay', 'Liferay, Inc.', '', '', '', '', '', '', '')
go


insert into ClassName_ (classNameId, value) values (8, 'com.liferay.portal.model.Organization')
go
insert into ClassName_ (classNameId, value) values (9, 'com.liferay.portal.model.User')
go


insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (10, 1, 0, 0, 'Administrator', '', 1)
go
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (11, 1, 0, 0, 'Guest', '', 1)
go
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (12, 1, 0, 0, 'Power User', '', 1)
go
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (13, 1, 0, 0, 'User', '', 1)
go


insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (14, 1, 5, 0, 0, 0, 0, 'Guest', '/guest', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (15, 1, 14, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (16, 1, 14, 0, 0, 'classic', '01', 0)
go


insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (17, 1, 0, 'Liferay, Inc.', 0, 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (18, 1, 5, 8, 17, 0, 0, '18', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (19, 1, 18, 1, 0, 'classic', '01', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (20, 1, 18, 0, 0, 'classic', '01', 1)
go
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (21, 18, 1, 0, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Liferay, Inc. Extranet</name>
</root>', 'portlet', 'layout-template-id=2_columns_ii
column-1=3,
column-2=19,', 0, '', 0)
go
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (22, 18, 1, 1, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Liferay, Inc. Intranet</name>
</root>', 'portlet', 'layout-template-id=2_columns_ii
column-1=3,
column-2=19,', 0, '', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (23, 1, 17, 'Liferay Engineering', 0, 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (24, 1, 5, 8, 23, 0, 0, '24', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (25, 1, 24, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (26, 1, 24, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (27, 1, 17, 'Liferay Consulting', 0, 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (28, 1, 5, 8, 27, 0, 0, '28', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (29, 1, 28, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (30, 1, 28, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (31, 1, 17, 'Liferay Support', 0, 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (32, 1, 5, 8, 31, 0, 0, '32', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (33, 1, 32, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (34, 1, 32, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (35, 1, 17, 'Liferay Sales', 0, 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (36, 1, 5, 8, 35, 0, 0, '36', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (37, 1, 36, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (38, 1, 36, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (39, 1, 17, 'Liferay Marketing', 0, 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (40, 1, 5, 8, 39, 0, 0, '40', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (41, 1, 40, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (42, 1, 40, 0, 0, 'classic', '01', 0)
go


insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (43, 1, 17, 'Liferay Los Angeles', 1, 0, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (44, 1, 5, 8, 43, 0, 0, '44', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (45, 1, 44, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (46, 1, 44, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (47, 1, 17, 'Liferay San Francisco', 1, 0, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (48, 1, 5, 8, 47, 0, 0, '48', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (49, 1, 48, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (50, 1, 48, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (51, 1, 17, 'Liferay Chicago', 1, 0, 14, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (52, 1, 5, 8, 51, 0, 0, '52', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (53, 1, 52, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (54, 1, 52, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (55, 1, 17, 'Liferay New York', 1, 0, 33, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (56, 1, 5, 8, 55, 0, 0, '56', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (57, 1, 56, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (58, 1, 56, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (59, 1, 17, 'Liferay Sao Paulo', 1, 0, 0, 48, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (60, 1, 5, 8, 59, 0, 0, '60', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (61, 1, 60, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (62, 1, 60, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (63, 1, 17, 'Liferay Frankfurt', 1, 0, 0, 4, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (64, 1, 5, 8, 63, 0, 0, '64', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (65, 1, 64, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (66, 1, 64, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (67, 1, 17, 'Liferay Madrid', 1, 0, 0, 15, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (68, 1, 5, 8, 67, 0, 0, '68', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (69, 1, 68, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (70, 1, 68, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (71, 1, 17, 'Liferay Dalian', 1, 0, 0, 2, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (72, 1, 5, 8, 71, 0, 0, '72', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (73, 1, 72, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (74, 1, 72, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (75, 1, 17, 'Liferay Hong Kong', 1, 0, 0, 2, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (76, 1, 5, 8, 75, 0, 0, '76', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (77, 1, 76, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (78, 1, 76, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, location, recursable, regionId, countryId, statusId, comments) values (79, 1, 17, 'Liferay Kuala Lumpur', 1, 0, 0, 135, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (80, 1, 5, 8, 79, 0, 0, '80', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (81, 1, 80, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (82, 1, 80, 0, 0, 'classic', '01', 0)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (5, 1, getdate(), getdate(), 1, 6, 'password', 0, 0, '5', 'default@liferay.com', 'Welcome!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (6, 1, 5, '', getdate(), getdate(), 7, 0, '', '', '', 1, '19700101')
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (2, 1, getdate(), getdate(), 0, 3, 'test', 0, 0, 'joebloggs', 'test@liferay.com', 'Welcome Joe Bloggs!', getdate(), 0, 0, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (3, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Joe', '', 'Bloggs', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (83, 1, 2, 9, 2, 0, 0, '83', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (84, 1, 83, 1, 0, 'classic', '01', 2)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (85, 1, 83, 0, 0, 'classic', '01', 0)
go
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (86, 83, 1, 1, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Home</name>
</root>', 'portlet', 'column-1=71_INSTANCE_OY0d,82,23,61,
column-2=9,79,29,8,19,
layout-template-id=2_columns_ii
', 0, '/home', 0)
go
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (87, 83, 1, 1, 2, 0, '<?xml version="1.0"?>

<root>
  <name>Plugins</name>
</root>', 'portlet', 'column-1=
column-2=111,
layout-template-id=2_columns_ii
', 0, '/plugins', 1)
go

insert into Users_Groups values (2, 14)
go

insert into Users_Orgs (userId, organizationId) values (2, 17)
go
insert into Users_Orgs (userId, organizationId) values (2, 43)
go

insert into Users_Roles values (2, 10)
go
insert into Users_Roles values (2, 12)
go
insert into Users_Roles values (2, 13)
go


insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (88, 1, getdate(), getdate(), 0, 89, 'test', 0, 0, 'lax1', 'test.lax.1@liferay.com', 'Welcome Test LAX 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (89, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (90, 1, 88, 9, 88, 0, 0, '90', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (91, 1, 90, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (92, 1, 90, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (88, 14)
go

insert into Users_Orgs (userId, organizationId) values (88, 17)
go
insert into Users_Orgs (userId, organizationId) values (88, 43)
go

insert into Users_Roles values (88, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (93, 1, getdate(), getdate(), 0, 94, 'test', 0, 0, 'lax2', 'test.lax.2@liferay.com', 'Welcome Test LAX 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (94, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (95, 1, 93, 9, 93, 0, 0, '95', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (96, 1, 95, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (97, 1, 95, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (93, 14)
go

insert into Users_Orgs (userId, organizationId) values (93, 17)
go
insert into Users_Orgs (userId, organizationId) values (93, 43)
go

insert into Users_Roles values (93, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (98, 1, getdate(), getdate(), 0, 99, 'test', 0, 0, 'lax3', 'test.lax.3@liferay.com', 'Welcome Test LAX 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (99, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (100, 1, 98, 9, 98, 0, 0, '100', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (101, 1, 100, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (102, 1, 100, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (98, 14)
go

insert into Users_Orgs (userId, organizationId) values (98, 17)
go
insert into Users_Orgs (userId, organizationId) values (98, 43)
go

insert into Users_Roles values (98, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (103, 1, getdate(), getdate(), 0, 104, 'test', 0, 0, 'lax4', 'test.lax.4@liferay.com', 'Welcome Test LAX 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (104, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (105, 1, 103, 9, 103, 0, 0, '105', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (106, 1, 105, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (107, 1, 105, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (103, 14)
go

insert into Users_Orgs (userId, organizationId) values (103, 17)
go
insert into Users_Orgs (userId, organizationId) values (103, 43)
go

insert into Users_Roles values (103, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (108, 1, getdate(), getdate(), 0, 109, 'test', 0, 0, 'lax5', 'test.lax.5@liferay.com', 'Welcome Test LAX 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (109, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (110, 1, 108, 9, 108, 0, 0, '110', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (111, 1, 110, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (112, 1, 110, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (108, 14)
go

insert into Users_Orgs (userId, organizationId) values (108, 17)
go
insert into Users_Orgs (userId, organizationId) values (108, 43)
go

insert into Users_Roles values (108, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (113, 1, getdate(), getdate(), 0, 114, 'test', 0, 0, 'lax6', 'test.lax.6@liferay.com', 'Welcome Test LAX 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (114, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (115, 1, 113, 9, 113, 0, 0, '115', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (116, 1, 115, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (117, 1, 115, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (113, 14)
go

insert into Users_Orgs (userId, organizationId) values (113, 17)
go
insert into Users_Orgs (userId, organizationId) values (113, 43)
go

insert into Users_Roles values (113, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (118, 1, getdate(), getdate(), 0, 119, 'test', 0, 0, 'lax7', 'test.lax.7@liferay.com', 'Welcome Test LAX 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (119, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (120, 1, 118, 9, 118, 0, 0, '120', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (121, 1, 120, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (122, 1, 120, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (118, 14)
go

insert into Users_Orgs (userId, organizationId) values (118, 17)
go
insert into Users_Orgs (userId, organizationId) values (118, 43)
go

insert into Users_Roles values (118, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (123, 1, getdate(), getdate(), 0, 124, 'test', 0, 0, 'lax8', 'test.lax.8@liferay.com', 'Welcome Test LAX 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (124, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (125, 1, 123, 9, 123, 0, 0, '125', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (126, 1, 125, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (127, 1, 125, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (123, 14)
go

insert into Users_Orgs (userId, organizationId) values (123, 17)
go
insert into Users_Orgs (userId, organizationId) values (123, 43)
go

insert into Users_Roles values (123, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (128, 1, getdate(), getdate(), 0, 129, 'test', 0, 0, 'lax9', 'test.lax.9@liferay.com', 'Welcome Test LAX 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (129, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (130, 1, 128, 9, 128, 0, 0, '130', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (131, 1, 130, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (132, 1, 130, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (128, 14)
go

insert into Users_Orgs (userId, organizationId) values (128, 17)
go
insert into Users_Orgs (userId, organizationId) values (128, 43)
go

insert into Users_Roles values (128, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (133, 1, getdate(), getdate(), 0, 134, 'test', 0, 0, 'lax10', 'test.lax.10@liferay.com', 'Welcome Test LAX 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (134, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (135, 1, 133, 9, 133, 0, 0, '135', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (136, 1, 135, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (137, 1, 135, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (133, 14)
go

insert into Users_Orgs (userId, organizationId) values (133, 17)
go
insert into Users_Orgs (userId, organizationId) values (133, 43)
go

insert into Users_Roles values (133, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (138, 1, getdate(), getdate(), 0, 139, 'test', 0, 0, 'lax11', 'test.lax.11@liferay.com', 'Welcome Test LAX 11!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (139, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 11', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (140, 1, 138, 9, 138, 0, 0, '140', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (141, 1, 140, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (142, 1, 140, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (138, 14)
go

insert into Users_Orgs (userId, organizationId) values (138, 17)
go
insert into Users_Orgs (userId, organizationId) values (138, 43)
go

insert into Users_Roles values (138, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (143, 1, getdate(), getdate(), 0, 144, 'test', 0, 0, 'lax12', 'test.lax.12@liferay.com', 'Welcome Test LAX 12!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (144, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 12', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (145, 1, 143, 9, 143, 0, 0, '145', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (146, 1, 145, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (147, 1, 145, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (143, 14)
go

insert into Users_Orgs (userId, organizationId) values (143, 17)
go
insert into Users_Orgs (userId, organizationId) values (143, 43)
go

insert into Users_Roles values (143, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (148, 1, getdate(), getdate(), 0, 149, 'test', 0, 0, 'lax13', 'test.lax.13@liferay.com', 'Welcome Test LAX 13!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (149, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 13', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (150, 1, 148, 9, 148, 0, 0, '150', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (151, 1, 150, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (152, 1, 150, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (148, 14)
go

insert into Users_Orgs (userId, organizationId) values (148, 17)
go
insert into Users_Orgs (userId, organizationId) values (148, 43)
go

insert into Users_Roles values (148, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (153, 1, getdate(), getdate(), 0, 154, 'test', 0, 0, 'lax14', 'test.lax.14@liferay.com', 'Welcome Test LAX 14!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (154, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 14', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (155, 1, 153, 9, 153, 0, 0, '155', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (156, 1, 155, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (157, 1, 155, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (153, 14)
go

insert into Users_Orgs (userId, organizationId) values (153, 17)
go
insert into Users_Orgs (userId, organizationId) values (153, 43)
go

insert into Users_Roles values (153, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (158, 1, getdate(), getdate(), 0, 159, 'test', 0, 0, 'lax15', 'test.lax.15@liferay.com', 'Welcome Test LAX 15!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (159, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 15', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (160, 1, 158, 9, 158, 0, 0, '160', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (161, 1, 160, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (162, 1, 160, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (158, 14)
go

insert into Users_Orgs (userId, organizationId) values (158, 17)
go
insert into Users_Orgs (userId, organizationId) values (158, 43)
go

insert into Users_Roles values (158, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (163, 1, getdate(), getdate(), 0, 164, 'test', 0, 0, 'lax16', 'test.lax.16@liferay.com', 'Welcome Test LAX 16!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (164, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 16', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (165, 1, 163, 9, 163, 0, 0, '165', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (166, 1, 165, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (167, 1, 165, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (163, 14)
go

insert into Users_Orgs (userId, organizationId) values (163, 17)
go
insert into Users_Orgs (userId, organizationId) values (163, 43)
go

insert into Users_Roles values (163, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (168, 1, getdate(), getdate(), 0, 169, 'test', 0, 0, 'lax17', 'test.lax.17@liferay.com', 'Welcome Test LAX 17!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (169, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 17', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (170, 1, 168, 9, 168, 0, 0, '170', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (171, 1, 170, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (172, 1, 170, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (168, 14)
go

insert into Users_Orgs (userId, organizationId) values (168, 17)
go
insert into Users_Orgs (userId, organizationId) values (168, 43)
go

insert into Users_Roles values (168, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (173, 1, getdate(), getdate(), 0, 174, 'test', 0, 0, 'lax18', 'test.lax.18@liferay.com', 'Welcome Test LAX 18!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (174, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 18', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (175, 1, 173, 9, 173, 0, 0, '175', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (176, 1, 175, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (177, 1, 175, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (173, 14)
go

insert into Users_Orgs (userId, organizationId) values (173, 17)
go
insert into Users_Orgs (userId, organizationId) values (173, 43)
go

insert into Users_Roles values (173, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (178, 1, getdate(), getdate(), 0, 179, 'test', 0, 0, 'lax19', 'test.lax.19@liferay.com', 'Welcome Test LAX 19!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (179, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 19', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (180, 1, 178, 9, 178, 0, 0, '180', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (181, 1, 180, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (182, 1, 180, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (178, 14)
go

insert into Users_Orgs (userId, organizationId) values (178, 17)
go
insert into Users_Orgs (userId, organizationId) values (178, 43)
go

insert into Users_Roles values (178, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (183, 1, getdate(), getdate(), 0, 184, 'test', 0, 0, 'lax20', 'test.lax.20@liferay.com', 'Welcome Test LAX 20!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (184, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 20', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (185, 1, 183, 9, 183, 0, 0, '185', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (186, 1, 185, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (187, 1, 185, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (183, 14)
go

insert into Users_Orgs (userId, organizationId) values (183, 17)
go
insert into Users_Orgs (userId, organizationId) values (183, 43)
go

insert into Users_Roles values (183, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (188, 1, getdate(), getdate(), 0, 189, 'test', 0, 0, 'lax21', 'test.lax.21@liferay.com', 'Welcome Test LAX 21!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (189, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 21', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (190, 1, 188, 9, 188, 0, 0, '190', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (191, 1, 190, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (192, 1, 190, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (188, 14)
go

insert into Users_Orgs (userId, organizationId) values (188, 17)
go
insert into Users_Orgs (userId, organizationId) values (188, 43)
go

insert into Users_Roles values (188, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (193, 1, getdate(), getdate(), 0, 194, 'test', 0, 0, 'lax22', 'test.lax.22@liferay.com', 'Welcome Test LAX 22!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (194, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 22', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (195, 1, 193, 9, 193, 0, 0, '195', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (196, 1, 195, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (197, 1, 195, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (193, 14)
go

insert into Users_Orgs (userId, organizationId) values (193, 17)
go
insert into Users_Orgs (userId, organizationId) values (193, 43)
go

insert into Users_Roles values (193, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (198, 1, getdate(), getdate(), 0, 199, 'test', 0, 0, 'lax23', 'test.lax.23@liferay.com', 'Welcome Test LAX 23!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (199, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 23', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (200, 1, 198, 9, 198, 0, 0, '200', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (201, 1, 200, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (202, 1, 200, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (198, 14)
go

insert into Users_Orgs (userId, organizationId) values (198, 17)
go
insert into Users_Orgs (userId, organizationId) values (198, 43)
go

insert into Users_Roles values (198, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (203, 1, getdate(), getdate(), 0, 204, 'test', 0, 0, 'lax24', 'test.lax.24@liferay.com', 'Welcome Test LAX 24!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (204, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 24', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (205, 1, 203, 9, 203, 0, 0, '205', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (206, 1, 205, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (207, 1, 205, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (203, 14)
go

insert into Users_Orgs (userId, organizationId) values (203, 17)
go
insert into Users_Orgs (userId, organizationId) values (203, 43)
go

insert into Users_Roles values (203, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (208, 1, getdate(), getdate(), 0, 209, 'test', 0, 0, 'lax25', 'test.lax.25@liferay.com', 'Welcome Test LAX 25!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (209, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 25', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (210, 1, 208, 9, 208, 0, 0, '210', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (211, 1, 210, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (212, 1, 210, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (208, 14)
go

insert into Users_Orgs (userId, organizationId) values (208, 17)
go
insert into Users_Orgs (userId, organizationId) values (208, 43)
go

insert into Users_Roles values (208, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (213, 1, getdate(), getdate(), 0, 214, 'test', 0, 0, 'lax26', 'test.lax.26@liferay.com', 'Welcome Test LAX 26!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (214, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 26', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (215, 1, 213, 9, 213, 0, 0, '215', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (216, 1, 215, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (217, 1, 215, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (213, 14)
go

insert into Users_Orgs (userId, organizationId) values (213, 17)
go
insert into Users_Orgs (userId, organizationId) values (213, 43)
go

insert into Users_Roles values (213, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (218, 1, getdate(), getdate(), 0, 219, 'test', 0, 0, 'lax27', 'test.lax.27@liferay.com', 'Welcome Test LAX 27!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (219, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 27', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (220, 1, 218, 9, 218, 0, 0, '220', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (221, 1, 220, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (222, 1, 220, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (218, 14)
go

insert into Users_Orgs (userId, organizationId) values (218, 17)
go
insert into Users_Orgs (userId, organizationId) values (218, 43)
go

insert into Users_Roles values (218, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (223, 1, getdate(), getdate(), 0, 224, 'test', 0, 0, 'lax28', 'test.lax.28@liferay.com', 'Welcome Test LAX 28!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (224, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 28', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (225, 1, 223, 9, 223, 0, 0, '225', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (226, 1, 225, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (227, 1, 225, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (223, 14)
go

insert into Users_Orgs (userId, organizationId) values (223, 17)
go
insert into Users_Orgs (userId, organizationId) values (223, 43)
go

insert into Users_Roles values (223, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (228, 1, getdate(), getdate(), 0, 229, 'test', 0, 0, 'lax29', 'test.lax.29@liferay.com', 'Welcome Test LAX 29!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (229, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 29', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (230, 1, 228, 9, 228, 0, 0, '230', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (231, 1, 230, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (232, 1, 230, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (228, 14)
go

insert into Users_Orgs (userId, organizationId) values (228, 17)
go
insert into Users_Orgs (userId, organizationId) values (228, 43)
go

insert into Users_Roles values (228, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (233, 1, getdate(), getdate(), 0, 234, 'test', 0, 0, 'lax30', 'test.lax.30@liferay.com', 'Welcome Test LAX 30!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (234, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 30', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (235, 1, 233, 9, 233, 0, 0, '235', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (236, 1, 235, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (237, 1, 235, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (233, 14)
go

insert into Users_Orgs (userId, organizationId) values (233, 17)
go
insert into Users_Orgs (userId, organizationId) values (233, 43)
go

insert into Users_Roles values (233, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (238, 1, getdate(), getdate(), 0, 239, 'test', 0, 0, 'lax31', 'test.lax.31@liferay.com', 'Welcome Test LAX 31!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (239, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 31', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (240, 1, 238, 9, 238, 0, 0, '240', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (241, 1, 240, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (242, 1, 240, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (238, 14)
go

insert into Users_Orgs (userId, organizationId) values (238, 17)
go
insert into Users_Orgs (userId, organizationId) values (238, 43)
go

insert into Users_Roles values (238, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (243, 1, getdate(), getdate(), 0, 244, 'test', 0, 0, 'lax32', 'test.lax.32@liferay.com', 'Welcome Test LAX 32!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (244, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 32', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (245, 1, 243, 9, 243, 0, 0, '245', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (246, 1, 245, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (247, 1, 245, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (243, 14)
go

insert into Users_Orgs (userId, organizationId) values (243, 17)
go
insert into Users_Orgs (userId, organizationId) values (243, 43)
go

insert into Users_Roles values (243, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (248, 1, getdate(), getdate(), 0, 249, 'test', 0, 0, 'lax33', 'test.lax.33@liferay.com', 'Welcome Test LAX 33!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (249, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 33', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (250, 1, 248, 9, 248, 0, 0, '250', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (251, 1, 250, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (252, 1, 250, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (248, 14)
go

insert into Users_Orgs (userId, organizationId) values (248, 17)
go
insert into Users_Orgs (userId, organizationId) values (248, 43)
go

insert into Users_Roles values (248, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (253, 1, getdate(), getdate(), 0, 254, 'test', 0, 0, 'lax34', 'test.lax.34@liferay.com', 'Welcome Test LAX 34!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (254, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 34', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (255, 1, 253, 9, 253, 0, 0, '255', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (256, 1, 255, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (257, 1, 255, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (253, 14)
go

insert into Users_Orgs (userId, organizationId) values (253, 17)
go
insert into Users_Orgs (userId, organizationId) values (253, 43)
go

insert into Users_Roles values (253, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (258, 1, getdate(), getdate(), 0, 259, 'test', 0, 0, 'lax35', 'test.lax.35@liferay.com', 'Welcome Test LAX 35!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (259, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 35', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (260, 1, 258, 9, 258, 0, 0, '260', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (261, 1, 260, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (262, 1, 260, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (258, 14)
go

insert into Users_Orgs (userId, organizationId) values (258, 17)
go
insert into Users_Orgs (userId, organizationId) values (258, 43)
go

insert into Users_Roles values (258, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (263, 1, getdate(), getdate(), 0, 264, 'test', 0, 0, 'lax36', 'test.lax.36@liferay.com', 'Welcome Test LAX 36!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (264, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 36', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (265, 1, 263, 9, 263, 0, 0, '265', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (266, 1, 265, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (267, 1, 265, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (263, 14)
go

insert into Users_Orgs (userId, organizationId) values (263, 17)
go
insert into Users_Orgs (userId, organizationId) values (263, 43)
go

insert into Users_Roles values (263, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (268, 1, getdate(), getdate(), 0, 269, 'test', 0, 0, 'lax37', 'test.lax.37@liferay.com', 'Welcome Test LAX 37!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (269, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 37', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (270, 1, 268, 9, 268, 0, 0, '270', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (271, 1, 270, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (272, 1, 270, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (268, 14)
go

insert into Users_Orgs (userId, organizationId) values (268, 17)
go
insert into Users_Orgs (userId, organizationId) values (268, 43)
go

insert into Users_Roles values (268, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (273, 1, getdate(), getdate(), 0, 274, 'test', 0, 0, 'lax38', 'test.lax.38@liferay.com', 'Welcome Test LAX 38!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (274, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 38', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (275, 1, 273, 9, 273, 0, 0, '275', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (276, 1, 275, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (277, 1, 275, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (273, 14)
go

insert into Users_Orgs (userId, organizationId) values (273, 17)
go
insert into Users_Orgs (userId, organizationId) values (273, 43)
go

insert into Users_Roles values (273, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (278, 1, getdate(), getdate(), 0, 279, 'test', 0, 0, 'lax39', 'test.lax.39@liferay.com', 'Welcome Test LAX 39!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (279, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 39', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (280, 1, 278, 9, 278, 0, 0, '280', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (281, 1, 280, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (282, 1, 280, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (278, 14)
go

insert into Users_Orgs (userId, organizationId) values (278, 17)
go
insert into Users_Orgs (userId, organizationId) values (278, 43)
go

insert into Users_Roles values (278, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (283, 1, getdate(), getdate(), 0, 284, 'test', 0, 0, 'lax40', 'test.lax.40@liferay.com', 'Welcome Test LAX 40!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (284, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 40', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (285, 1, 283, 9, 283, 0, 0, '285', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (286, 1, 285, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (287, 1, 285, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (283, 14)
go

insert into Users_Orgs (userId, organizationId) values (283, 17)
go
insert into Users_Orgs (userId, organizationId) values (283, 43)
go

insert into Users_Roles values (283, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (288, 1, getdate(), getdate(), 0, 289, 'test', 0, 0, 'lax41', 'test.lax.41@liferay.com', 'Welcome Test LAX 41!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (289, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 41', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (290, 1, 288, 9, 288, 0, 0, '290', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (291, 1, 290, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (292, 1, 290, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (288, 14)
go

insert into Users_Orgs (userId, organizationId) values (288, 17)
go
insert into Users_Orgs (userId, organizationId) values (288, 43)
go

insert into Users_Roles values (288, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (293, 1, getdate(), getdate(), 0, 294, 'test', 0, 0, 'lax42', 'test.lax.42@liferay.com', 'Welcome Test LAX 42!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (294, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 42', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (295, 1, 293, 9, 293, 0, 0, '295', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (296, 1, 295, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (297, 1, 295, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (293, 14)
go

insert into Users_Orgs (userId, organizationId) values (293, 17)
go
insert into Users_Orgs (userId, organizationId) values (293, 43)
go

insert into Users_Roles values (293, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (298, 1, getdate(), getdate(), 0, 299, 'test', 0, 0, 'lax43', 'test.lax.43@liferay.com', 'Welcome Test LAX 43!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (299, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 43', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (300, 1, 298, 9, 298, 0, 0, '300', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (301, 1, 300, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (302, 1, 300, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (298, 14)
go

insert into Users_Orgs (userId, organizationId) values (298, 17)
go
insert into Users_Orgs (userId, organizationId) values (298, 43)
go

insert into Users_Roles values (298, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (303, 1, getdate(), getdate(), 0, 304, 'test', 0, 0, 'lax44', 'test.lax.44@liferay.com', 'Welcome Test LAX 44!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (304, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 44', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (305, 1, 303, 9, 303, 0, 0, '305', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (306, 1, 305, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (307, 1, 305, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (303, 14)
go

insert into Users_Orgs (userId, organizationId) values (303, 17)
go
insert into Users_Orgs (userId, organizationId) values (303, 43)
go

insert into Users_Roles values (303, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (308, 1, getdate(), getdate(), 0, 309, 'test', 0, 0, 'lax45', 'test.lax.45@liferay.com', 'Welcome Test LAX 45!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (309, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 45', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (310, 1, 308, 9, 308, 0, 0, '310', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (311, 1, 310, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (312, 1, 310, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (308, 14)
go

insert into Users_Orgs (userId, organizationId) values (308, 17)
go
insert into Users_Orgs (userId, organizationId) values (308, 43)
go

insert into Users_Roles values (308, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (313, 1, getdate(), getdate(), 0, 314, 'test', 0, 0, 'lax46', 'test.lax.46@liferay.com', 'Welcome Test LAX 46!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (314, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 46', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (315, 1, 313, 9, 313, 0, 0, '315', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (316, 1, 315, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (317, 1, 315, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (313, 14)
go

insert into Users_Orgs (userId, organizationId) values (313, 17)
go
insert into Users_Orgs (userId, organizationId) values (313, 43)
go

insert into Users_Roles values (313, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (318, 1, getdate(), getdate(), 0, 319, 'test', 0, 0, 'lax47', 'test.lax.47@liferay.com', 'Welcome Test LAX 47!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (319, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 47', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (320, 1, 318, 9, 318, 0, 0, '320', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (321, 1, 320, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (322, 1, 320, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (318, 14)
go

insert into Users_Orgs (userId, organizationId) values (318, 17)
go
insert into Users_Orgs (userId, organizationId) values (318, 43)
go

insert into Users_Roles values (318, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (323, 1, getdate(), getdate(), 0, 324, 'test', 0, 0, 'lax48', 'test.lax.48@liferay.com', 'Welcome Test LAX 48!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (324, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 48', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (325, 1, 323, 9, 323, 0, 0, '325', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (326, 1, 325, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (327, 1, 325, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (323, 14)
go

insert into Users_Orgs (userId, organizationId) values (323, 17)
go
insert into Users_Orgs (userId, organizationId) values (323, 43)
go

insert into Users_Roles values (323, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (328, 1, getdate(), getdate(), 0, 329, 'test', 0, 0, 'lax49', 'test.lax.49@liferay.com', 'Welcome Test LAX 49!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (329, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 49', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (330, 1, 328, 9, 328, 0, 0, '330', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (331, 1, 330, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (332, 1, 330, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (328, 14)
go

insert into Users_Orgs (userId, organizationId) values (328, 17)
go
insert into Users_Orgs (userId, organizationId) values (328, 43)
go

insert into Users_Roles values (328, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (333, 1, getdate(), getdate(), 0, 334, 'test', 0, 0, 'lax50', 'test.lax.50@liferay.com', 'Welcome Test LAX 50!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (334, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 50', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (335, 1, 333, 9, 333, 0, 0, '335', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (336, 1, 335, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (337, 1, 335, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (333, 14)
go

insert into Users_Orgs (userId, organizationId) values (333, 17)
go
insert into Users_Orgs (userId, organizationId) values (333, 43)
go

insert into Users_Roles values (333, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (338, 1, getdate(), getdate(), 0, 339, 'test', 0, 0, 'lax51', 'test.lax.51@liferay.com', 'Welcome Test LAX 51!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (339, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 51', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (340, 1, 338, 9, 338, 0, 0, '340', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (341, 1, 340, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (342, 1, 340, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (338, 14)
go

insert into Users_Orgs (userId, organizationId) values (338, 17)
go
insert into Users_Orgs (userId, organizationId) values (338, 43)
go

insert into Users_Roles values (338, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (343, 1, getdate(), getdate(), 0, 344, 'test', 0, 0, 'lax52', 'test.lax.52@liferay.com', 'Welcome Test LAX 52!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (344, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 52', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (345, 1, 343, 9, 343, 0, 0, '345', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (346, 1, 345, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (347, 1, 345, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (343, 14)
go

insert into Users_Orgs (userId, organizationId) values (343, 17)
go
insert into Users_Orgs (userId, organizationId) values (343, 43)
go

insert into Users_Roles values (343, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (348, 1, getdate(), getdate(), 0, 349, 'test', 0, 0, 'lax53', 'test.lax.53@liferay.com', 'Welcome Test LAX 53!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (349, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 53', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (350, 1, 348, 9, 348, 0, 0, '350', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (351, 1, 350, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (352, 1, 350, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (348, 14)
go

insert into Users_Orgs (userId, organizationId) values (348, 17)
go
insert into Users_Orgs (userId, organizationId) values (348, 43)
go

insert into Users_Roles values (348, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (353, 1, getdate(), getdate(), 0, 354, 'test', 0, 0, 'lax54', 'test.lax.54@liferay.com', 'Welcome Test LAX 54!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (354, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 54', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (355, 1, 353, 9, 353, 0, 0, '355', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (356, 1, 355, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (357, 1, 355, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (353, 14)
go

insert into Users_Orgs (userId, organizationId) values (353, 17)
go
insert into Users_Orgs (userId, organizationId) values (353, 43)
go

insert into Users_Roles values (353, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (358, 1, getdate(), getdate(), 0, 359, 'test', 0, 0, 'lax55', 'test.lax.55@liferay.com', 'Welcome Test LAX 55!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (359, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 55', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (360, 1, 358, 9, 358, 0, 0, '360', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (361, 1, 360, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (362, 1, 360, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (358, 14)
go

insert into Users_Orgs (userId, organizationId) values (358, 17)
go
insert into Users_Orgs (userId, organizationId) values (358, 43)
go

insert into Users_Roles values (358, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (363, 1, getdate(), getdate(), 0, 364, 'test', 0, 0, 'lax56', 'test.lax.56@liferay.com', 'Welcome Test LAX 56!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (364, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 56', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (365, 1, 363, 9, 363, 0, 0, '365', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (366, 1, 365, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (367, 1, 365, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (363, 14)
go

insert into Users_Orgs (userId, organizationId) values (363, 17)
go
insert into Users_Orgs (userId, organizationId) values (363, 43)
go

insert into Users_Roles values (363, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (368, 1, getdate(), getdate(), 0, 369, 'test', 0, 0, 'lax57', 'test.lax.57@liferay.com', 'Welcome Test LAX 57!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (369, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 57', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (370, 1, 368, 9, 368, 0, 0, '370', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (371, 1, 370, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (372, 1, 370, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (368, 14)
go

insert into Users_Orgs (userId, organizationId) values (368, 17)
go
insert into Users_Orgs (userId, organizationId) values (368, 43)
go

insert into Users_Roles values (368, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (373, 1, getdate(), getdate(), 0, 374, 'test', 0, 0, 'lax58', 'test.lax.58@liferay.com', 'Welcome Test LAX 58!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (374, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 58', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (375, 1, 373, 9, 373, 0, 0, '375', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (376, 1, 375, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (377, 1, 375, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (373, 14)
go

insert into Users_Orgs (userId, organizationId) values (373, 17)
go
insert into Users_Orgs (userId, organizationId) values (373, 43)
go

insert into Users_Roles values (373, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (378, 1, getdate(), getdate(), 0, 379, 'test', 0, 0, 'lax59', 'test.lax.59@liferay.com', 'Welcome Test LAX 59!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (379, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 59', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (380, 1, 378, 9, 378, 0, 0, '380', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (381, 1, 380, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (382, 1, 380, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (378, 14)
go

insert into Users_Orgs (userId, organizationId) values (378, 17)
go
insert into Users_Orgs (userId, organizationId) values (378, 43)
go

insert into Users_Roles values (378, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (383, 1, getdate(), getdate(), 0, 384, 'test', 0, 0, 'lax60', 'test.lax.60@liferay.com', 'Welcome Test LAX 60!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (384, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 60', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (385, 1, 383, 9, 383, 0, 0, '385', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (386, 1, 385, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (387, 1, 385, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (383, 14)
go

insert into Users_Orgs (userId, organizationId) values (383, 17)
go
insert into Users_Orgs (userId, organizationId) values (383, 43)
go

insert into Users_Roles values (383, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (388, 1, getdate(), getdate(), 0, 389, 'test', 0, 0, 'lax61', 'test.lax.61@liferay.com', 'Welcome Test LAX 61!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (389, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 61', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (390, 1, 388, 9, 388, 0, 0, '390', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (391, 1, 390, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (392, 1, 390, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (388, 14)
go

insert into Users_Orgs (userId, organizationId) values (388, 17)
go
insert into Users_Orgs (userId, organizationId) values (388, 43)
go

insert into Users_Roles values (388, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (393, 1, getdate(), getdate(), 0, 394, 'test', 0, 0, 'lax62', 'test.lax.62@liferay.com', 'Welcome Test LAX 62!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (394, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 62', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (395, 1, 393, 9, 393, 0, 0, '395', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (396, 1, 395, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (397, 1, 395, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (393, 14)
go

insert into Users_Orgs (userId, organizationId) values (393, 17)
go
insert into Users_Orgs (userId, organizationId) values (393, 43)
go

insert into Users_Roles values (393, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (398, 1, getdate(), getdate(), 0, 399, 'test', 0, 0, 'lax63', 'test.lax.63@liferay.com', 'Welcome Test LAX 63!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (399, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 63', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (400, 1, 398, 9, 398, 0, 0, '400', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (401, 1, 400, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (402, 1, 400, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (398, 14)
go

insert into Users_Orgs (userId, organizationId) values (398, 17)
go
insert into Users_Orgs (userId, organizationId) values (398, 43)
go

insert into Users_Roles values (398, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (403, 1, getdate(), getdate(), 0, 404, 'test', 0, 0, 'lax64', 'test.lax.64@liferay.com', 'Welcome Test LAX 64!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (404, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 64', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (405, 1, 403, 9, 403, 0, 0, '405', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (406, 1, 405, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (407, 1, 405, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (403, 14)
go

insert into Users_Orgs (userId, organizationId) values (403, 17)
go
insert into Users_Orgs (userId, organizationId) values (403, 43)
go

insert into Users_Roles values (403, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (408, 1, getdate(), getdate(), 0, 409, 'test', 0, 0, 'lax65', 'test.lax.65@liferay.com', 'Welcome Test LAX 65!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (409, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 65', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (410, 1, 408, 9, 408, 0, 0, '410', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (411, 1, 410, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (412, 1, 410, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (408, 14)
go

insert into Users_Orgs (userId, organizationId) values (408, 17)
go
insert into Users_Orgs (userId, organizationId) values (408, 43)
go

insert into Users_Roles values (408, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (413, 1, getdate(), getdate(), 0, 414, 'test', 0, 0, 'lax66', 'test.lax.66@liferay.com', 'Welcome Test LAX 66!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (414, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 66', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (415, 1, 413, 9, 413, 0, 0, '415', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (416, 1, 415, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (417, 1, 415, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (413, 14)
go

insert into Users_Orgs (userId, organizationId) values (413, 17)
go
insert into Users_Orgs (userId, organizationId) values (413, 43)
go

insert into Users_Roles values (413, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (418, 1, getdate(), getdate(), 0, 419, 'test', 0, 0, 'lax67', 'test.lax.67@liferay.com', 'Welcome Test LAX 67!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (419, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 67', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (420, 1, 418, 9, 418, 0, 0, '420', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (421, 1, 420, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (422, 1, 420, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (418, 14)
go

insert into Users_Orgs (userId, organizationId) values (418, 17)
go
insert into Users_Orgs (userId, organizationId) values (418, 43)
go

insert into Users_Roles values (418, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (423, 1, getdate(), getdate(), 0, 424, 'test', 0, 0, 'lax68', 'test.lax.68@liferay.com', 'Welcome Test LAX 68!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (424, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 68', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (425, 1, 423, 9, 423, 0, 0, '425', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (426, 1, 425, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (427, 1, 425, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (423, 14)
go

insert into Users_Orgs (userId, organizationId) values (423, 17)
go
insert into Users_Orgs (userId, organizationId) values (423, 43)
go

insert into Users_Roles values (423, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (428, 1, getdate(), getdate(), 0, 429, 'test', 0, 0, 'lax69', 'test.lax.69@liferay.com', 'Welcome Test LAX 69!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (429, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 69', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (430, 1, 428, 9, 428, 0, 0, '430', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (431, 1, 430, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (432, 1, 430, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (428, 14)
go

insert into Users_Orgs (userId, organizationId) values (428, 17)
go
insert into Users_Orgs (userId, organizationId) values (428, 43)
go

insert into Users_Roles values (428, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (433, 1, getdate(), getdate(), 0, 434, 'test', 0, 0, 'lax70', 'test.lax.70@liferay.com', 'Welcome Test LAX 70!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (434, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 70', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (435, 1, 433, 9, 433, 0, 0, '435', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (436, 1, 435, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (437, 1, 435, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (433, 14)
go

insert into Users_Orgs (userId, organizationId) values (433, 17)
go
insert into Users_Orgs (userId, organizationId) values (433, 43)
go

insert into Users_Roles values (433, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (438, 1, getdate(), getdate(), 0, 439, 'test', 0, 0, 'lax71', 'test.lax.71@liferay.com', 'Welcome Test LAX 71!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (439, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 71', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (440, 1, 438, 9, 438, 0, 0, '440', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (441, 1, 440, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (442, 1, 440, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (438, 14)
go

insert into Users_Orgs (userId, organizationId) values (438, 17)
go
insert into Users_Orgs (userId, organizationId) values (438, 43)
go

insert into Users_Roles values (438, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (443, 1, getdate(), getdate(), 0, 444, 'test', 0, 0, 'lax72', 'test.lax.72@liferay.com', 'Welcome Test LAX 72!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (444, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 72', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (445, 1, 443, 9, 443, 0, 0, '445', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (446, 1, 445, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (447, 1, 445, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (443, 14)
go

insert into Users_Orgs (userId, organizationId) values (443, 17)
go
insert into Users_Orgs (userId, organizationId) values (443, 43)
go

insert into Users_Roles values (443, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (448, 1, getdate(), getdate(), 0, 449, 'test', 0, 0, 'lax73', 'test.lax.73@liferay.com', 'Welcome Test LAX 73!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (449, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 73', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (450, 1, 448, 9, 448, 0, 0, '450', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (451, 1, 450, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (452, 1, 450, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (448, 14)
go

insert into Users_Orgs (userId, organizationId) values (448, 17)
go
insert into Users_Orgs (userId, organizationId) values (448, 43)
go

insert into Users_Roles values (448, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (453, 1, getdate(), getdate(), 0, 454, 'test', 0, 0, 'lax74', 'test.lax.74@liferay.com', 'Welcome Test LAX 74!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (454, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 74', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (455, 1, 453, 9, 453, 0, 0, '455', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (456, 1, 455, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (457, 1, 455, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (453, 14)
go

insert into Users_Orgs (userId, organizationId) values (453, 17)
go
insert into Users_Orgs (userId, organizationId) values (453, 43)
go

insert into Users_Roles values (453, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (458, 1, getdate(), getdate(), 0, 459, 'test', 0, 0, 'lax75', 'test.lax.75@liferay.com', 'Welcome Test LAX 75!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (459, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 75', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (460, 1, 458, 9, 458, 0, 0, '460', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (461, 1, 460, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (462, 1, 460, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (458, 14)
go

insert into Users_Orgs (userId, organizationId) values (458, 17)
go
insert into Users_Orgs (userId, organizationId) values (458, 43)
go

insert into Users_Roles values (458, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (463, 1, getdate(), getdate(), 0, 464, 'test', 0, 0, 'lax76', 'test.lax.76@liferay.com', 'Welcome Test LAX 76!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (464, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 76', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (465, 1, 463, 9, 463, 0, 0, '465', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (466, 1, 465, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (467, 1, 465, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (463, 14)
go

insert into Users_Orgs (userId, organizationId) values (463, 17)
go
insert into Users_Orgs (userId, organizationId) values (463, 43)
go

insert into Users_Roles values (463, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (468, 1, getdate(), getdate(), 0, 469, 'test', 0, 0, 'lax77', 'test.lax.77@liferay.com', 'Welcome Test LAX 77!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (469, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 77', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (470, 1, 468, 9, 468, 0, 0, '470', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (471, 1, 470, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (472, 1, 470, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (468, 14)
go

insert into Users_Orgs (userId, organizationId) values (468, 17)
go
insert into Users_Orgs (userId, organizationId) values (468, 43)
go

insert into Users_Roles values (468, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (473, 1, getdate(), getdate(), 0, 474, 'test', 0, 0, 'lax78', 'test.lax.78@liferay.com', 'Welcome Test LAX 78!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (474, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 78', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (475, 1, 473, 9, 473, 0, 0, '475', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (476, 1, 475, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (477, 1, 475, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (473, 14)
go

insert into Users_Orgs (userId, organizationId) values (473, 17)
go
insert into Users_Orgs (userId, organizationId) values (473, 43)
go

insert into Users_Roles values (473, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (478, 1, getdate(), getdate(), 0, 479, 'test', 0, 0, 'lax79', 'test.lax.79@liferay.com', 'Welcome Test LAX 79!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (479, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 79', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (480, 1, 478, 9, 478, 0, 0, '480', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (481, 1, 480, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (482, 1, 480, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (478, 14)
go

insert into Users_Orgs (userId, organizationId) values (478, 17)
go
insert into Users_Orgs (userId, organizationId) values (478, 43)
go

insert into Users_Roles values (478, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (483, 1, getdate(), getdate(), 0, 484, 'test', 0, 0, 'lax80', 'test.lax.80@liferay.com', 'Welcome Test LAX 80!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (484, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 80', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (485, 1, 483, 9, 483, 0, 0, '485', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (486, 1, 485, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (487, 1, 485, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (483, 14)
go

insert into Users_Orgs (userId, organizationId) values (483, 17)
go
insert into Users_Orgs (userId, organizationId) values (483, 43)
go

insert into Users_Roles values (483, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (488, 1, getdate(), getdate(), 0, 489, 'test', 0, 0, 'lax81', 'test.lax.81@liferay.com', 'Welcome Test LAX 81!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (489, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 81', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (490, 1, 488, 9, 488, 0, 0, '490', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (491, 1, 490, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (492, 1, 490, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (488, 14)
go

insert into Users_Orgs (userId, organizationId) values (488, 17)
go
insert into Users_Orgs (userId, organizationId) values (488, 43)
go

insert into Users_Roles values (488, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (493, 1, getdate(), getdate(), 0, 494, 'test', 0, 0, 'lax82', 'test.lax.82@liferay.com', 'Welcome Test LAX 82!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (494, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 82', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (495, 1, 493, 9, 493, 0, 0, '495', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (496, 1, 495, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (497, 1, 495, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (493, 14)
go

insert into Users_Orgs (userId, organizationId) values (493, 17)
go
insert into Users_Orgs (userId, organizationId) values (493, 43)
go

insert into Users_Roles values (493, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (498, 1, getdate(), getdate(), 0, 499, 'test', 0, 0, 'lax83', 'test.lax.83@liferay.com', 'Welcome Test LAX 83!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (499, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 83', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (500, 1, 498, 9, 498, 0, 0, '500', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (501, 1, 500, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (502, 1, 500, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (498, 14)
go

insert into Users_Orgs (userId, organizationId) values (498, 17)
go
insert into Users_Orgs (userId, organizationId) values (498, 43)
go

insert into Users_Roles values (498, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (503, 1, getdate(), getdate(), 0, 504, 'test', 0, 0, 'lax84', 'test.lax.84@liferay.com', 'Welcome Test LAX 84!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (504, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 84', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (505, 1, 503, 9, 503, 0, 0, '505', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (506, 1, 505, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (507, 1, 505, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (503, 14)
go

insert into Users_Orgs (userId, organizationId) values (503, 17)
go
insert into Users_Orgs (userId, organizationId) values (503, 43)
go

insert into Users_Roles values (503, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (508, 1, getdate(), getdate(), 0, 509, 'test', 0, 0, 'lax85', 'test.lax.85@liferay.com', 'Welcome Test LAX 85!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (509, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 85', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (510, 1, 508, 9, 508, 0, 0, '510', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (511, 1, 510, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (512, 1, 510, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (508, 14)
go

insert into Users_Orgs (userId, organizationId) values (508, 17)
go
insert into Users_Orgs (userId, organizationId) values (508, 43)
go

insert into Users_Roles values (508, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (513, 1, getdate(), getdate(), 0, 514, 'test', 0, 0, 'lax86', 'test.lax.86@liferay.com', 'Welcome Test LAX 86!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (514, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 86', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (515, 1, 513, 9, 513, 0, 0, '515', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (516, 1, 515, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (517, 1, 515, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (513, 14)
go

insert into Users_Orgs (userId, organizationId) values (513, 17)
go
insert into Users_Orgs (userId, organizationId) values (513, 43)
go

insert into Users_Roles values (513, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (518, 1, getdate(), getdate(), 0, 519, 'test', 0, 0, 'lax87', 'test.lax.87@liferay.com', 'Welcome Test LAX 87!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (519, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 87', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (520, 1, 518, 9, 518, 0, 0, '520', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (521, 1, 520, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (522, 1, 520, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (518, 14)
go

insert into Users_Orgs (userId, organizationId) values (518, 17)
go
insert into Users_Orgs (userId, organizationId) values (518, 43)
go

insert into Users_Roles values (518, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (523, 1, getdate(), getdate(), 0, 524, 'test', 0, 0, 'lax88', 'test.lax.88@liferay.com', 'Welcome Test LAX 88!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (524, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 88', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (525, 1, 523, 9, 523, 0, 0, '525', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (526, 1, 525, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (527, 1, 525, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (523, 14)
go

insert into Users_Orgs (userId, organizationId) values (523, 17)
go
insert into Users_Orgs (userId, organizationId) values (523, 43)
go

insert into Users_Roles values (523, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (528, 1, getdate(), getdate(), 0, 529, 'test', 0, 0, 'lax89', 'test.lax.89@liferay.com', 'Welcome Test LAX 89!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (529, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 89', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (530, 1, 528, 9, 528, 0, 0, '530', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (531, 1, 530, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (532, 1, 530, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (528, 14)
go

insert into Users_Orgs (userId, organizationId) values (528, 17)
go
insert into Users_Orgs (userId, organizationId) values (528, 43)
go

insert into Users_Roles values (528, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (533, 1, getdate(), getdate(), 0, 534, 'test', 0, 0, 'lax90', 'test.lax.90@liferay.com', 'Welcome Test LAX 90!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (534, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 90', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (535, 1, 533, 9, 533, 0, 0, '535', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (536, 1, 535, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (537, 1, 535, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (533, 14)
go

insert into Users_Orgs (userId, organizationId) values (533, 17)
go
insert into Users_Orgs (userId, organizationId) values (533, 43)
go

insert into Users_Roles values (533, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (538, 1, getdate(), getdate(), 0, 539, 'test', 0, 0, 'lax91', 'test.lax.91@liferay.com', 'Welcome Test LAX 91!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (539, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 91', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (540, 1, 538, 9, 538, 0, 0, '540', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (541, 1, 540, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (542, 1, 540, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (538, 14)
go

insert into Users_Orgs (userId, organizationId) values (538, 17)
go
insert into Users_Orgs (userId, organizationId) values (538, 43)
go

insert into Users_Roles values (538, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (543, 1, getdate(), getdate(), 0, 544, 'test', 0, 0, 'lax92', 'test.lax.92@liferay.com', 'Welcome Test LAX 92!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (544, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 92', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (545, 1, 543, 9, 543, 0, 0, '545', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (546, 1, 545, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (547, 1, 545, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (543, 14)
go

insert into Users_Orgs (userId, organizationId) values (543, 17)
go
insert into Users_Orgs (userId, organizationId) values (543, 43)
go

insert into Users_Roles values (543, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (548, 1, getdate(), getdate(), 0, 549, 'test', 0, 0, 'lax93', 'test.lax.93@liferay.com', 'Welcome Test LAX 93!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (549, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 93', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (550, 1, 548, 9, 548, 0, 0, '550', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (551, 1, 550, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (552, 1, 550, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (548, 14)
go

insert into Users_Orgs (userId, organizationId) values (548, 17)
go
insert into Users_Orgs (userId, organizationId) values (548, 43)
go

insert into Users_Roles values (548, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (553, 1, getdate(), getdate(), 0, 554, 'test', 0, 0, 'lax94', 'test.lax.94@liferay.com', 'Welcome Test LAX 94!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (554, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 94', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (555, 1, 553, 9, 553, 0, 0, '555', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (556, 1, 555, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (557, 1, 555, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (553, 14)
go

insert into Users_Orgs (userId, organizationId) values (553, 17)
go
insert into Users_Orgs (userId, organizationId) values (553, 43)
go

insert into Users_Roles values (553, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (558, 1, getdate(), getdate(), 0, 559, 'test', 0, 0, 'lax95', 'test.lax.95@liferay.com', 'Welcome Test LAX 95!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (559, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 95', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (560, 1, 558, 9, 558, 0, 0, '560', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (561, 1, 560, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (562, 1, 560, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (558, 14)
go

insert into Users_Orgs (userId, organizationId) values (558, 17)
go
insert into Users_Orgs (userId, organizationId) values (558, 43)
go

insert into Users_Roles values (558, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (563, 1, getdate(), getdate(), 0, 564, 'test', 0, 0, 'lax96', 'test.lax.96@liferay.com', 'Welcome Test LAX 96!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (564, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 96', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (565, 1, 563, 9, 563, 0, 0, '565', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (566, 1, 565, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (567, 1, 565, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (563, 14)
go

insert into Users_Orgs (userId, organizationId) values (563, 17)
go
insert into Users_Orgs (userId, organizationId) values (563, 43)
go

insert into Users_Roles values (563, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (568, 1, getdate(), getdate(), 0, 569, 'test', 0, 0, 'lax97', 'test.lax.97@liferay.com', 'Welcome Test LAX 97!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (569, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 97', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (570, 1, 568, 9, 568, 0, 0, '570', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (571, 1, 570, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (572, 1, 570, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (568, 14)
go

insert into Users_Orgs (userId, organizationId) values (568, 17)
go
insert into Users_Orgs (userId, organizationId) values (568, 43)
go

insert into Users_Roles values (568, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (573, 1, getdate(), getdate(), 0, 574, 'test', 0, 0, 'lax98', 'test.lax.98@liferay.com', 'Welcome Test LAX 98!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (574, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 98', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (575, 1, 573, 9, 573, 0, 0, '575', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (576, 1, 575, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (577, 1, 575, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (573, 14)
go

insert into Users_Orgs (userId, organizationId) values (573, 17)
go
insert into Users_Orgs (userId, organizationId) values (573, 43)
go

insert into Users_Roles values (573, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (578, 1, getdate(), getdate(), 0, 579, 'test', 0, 0, 'lax99', 'test.lax.99@liferay.com', 'Welcome Test LAX 99!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (579, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 99', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (580, 1, 578, 9, 578, 0, 0, '580', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (581, 1, 580, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (582, 1, 580, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (578, 14)
go

insert into Users_Orgs (userId, organizationId) values (578, 17)
go
insert into Users_Orgs (userId, organizationId) values (578, 43)
go

insert into Users_Roles values (578, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (583, 1, getdate(), getdate(), 0, 584, 'test', 0, 0, 'lax100', 'test.lax.100@liferay.com', 'Welcome Test LAX 100!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (584, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 100', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (585, 1, 583, 9, 583, 0, 0, '585', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (586, 1, 585, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (587, 1, 585, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (583, 14)
go

insert into Users_Orgs (userId, organizationId) values (583, 17)
go
insert into Users_Orgs (userId, organizationId) values (583, 43)
go

insert into Users_Roles values (583, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (588, 1, getdate(), getdate(), 0, 589, 'test', 0, 0, 'sfo1', 'test.sfo.1@liferay.com', 'Welcome Test SFO 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (589, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (590, 1, 588, 9, 588, 0, 0, '590', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (591, 1, 590, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (592, 1, 590, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (588, 14)
go

insert into Users_Orgs (userId, organizationId) values (588, 17)
go
insert into Users_Orgs (userId, organizationId) values (588, 47)
go

insert into Users_Roles values (588, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (593, 1, getdate(), getdate(), 0, 594, 'test', 0, 0, 'sfo2', 'test.sfo.2@liferay.com', 'Welcome Test SFO 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (594, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (595, 1, 593, 9, 593, 0, 0, '595', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (596, 1, 595, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (597, 1, 595, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (593, 14)
go

insert into Users_Orgs (userId, organizationId) values (593, 17)
go
insert into Users_Orgs (userId, organizationId) values (593, 47)
go

insert into Users_Roles values (593, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (598, 1, getdate(), getdate(), 0, 599, 'test', 0, 0, 'sfo3', 'test.sfo.3@liferay.com', 'Welcome Test SFO 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (599, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (600, 1, 598, 9, 598, 0, 0, '600', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (601, 1, 600, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (602, 1, 600, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (598, 14)
go

insert into Users_Orgs (userId, organizationId) values (598, 17)
go
insert into Users_Orgs (userId, organizationId) values (598, 47)
go

insert into Users_Roles values (598, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (603, 1, getdate(), getdate(), 0, 604, 'test', 0, 0, 'sfo4', 'test.sfo.4@liferay.com', 'Welcome Test SFO 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (604, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (605, 1, 603, 9, 603, 0, 0, '605', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (606, 1, 605, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (607, 1, 605, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (603, 14)
go

insert into Users_Orgs (userId, organizationId) values (603, 17)
go
insert into Users_Orgs (userId, organizationId) values (603, 47)
go

insert into Users_Roles values (603, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (608, 1, getdate(), getdate(), 0, 609, 'test', 0, 0, 'sfo5', 'test.sfo.5@liferay.com', 'Welcome Test SFO 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (609, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (610, 1, 608, 9, 608, 0, 0, '610', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (611, 1, 610, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (612, 1, 610, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (608, 14)
go

insert into Users_Orgs (userId, organizationId) values (608, 17)
go
insert into Users_Orgs (userId, organizationId) values (608, 47)
go

insert into Users_Roles values (608, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (613, 1, getdate(), getdate(), 0, 614, 'test', 0, 0, 'sfo6', 'test.sfo.6@liferay.com', 'Welcome Test SFO 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (614, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (615, 1, 613, 9, 613, 0, 0, '615', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (616, 1, 615, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (617, 1, 615, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (613, 14)
go

insert into Users_Orgs (userId, organizationId) values (613, 17)
go
insert into Users_Orgs (userId, organizationId) values (613, 47)
go

insert into Users_Roles values (613, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (618, 1, getdate(), getdate(), 0, 619, 'test', 0, 0, 'sfo7', 'test.sfo.7@liferay.com', 'Welcome Test SFO 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (619, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (620, 1, 618, 9, 618, 0, 0, '620', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (621, 1, 620, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (622, 1, 620, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (618, 14)
go

insert into Users_Orgs (userId, organizationId) values (618, 17)
go
insert into Users_Orgs (userId, organizationId) values (618, 47)
go

insert into Users_Roles values (618, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (623, 1, getdate(), getdate(), 0, 624, 'test', 0, 0, 'sfo8', 'test.sfo.8@liferay.com', 'Welcome Test SFO 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (624, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (625, 1, 623, 9, 623, 0, 0, '625', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (626, 1, 625, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (627, 1, 625, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (623, 14)
go

insert into Users_Orgs (userId, organizationId) values (623, 17)
go
insert into Users_Orgs (userId, organizationId) values (623, 47)
go

insert into Users_Roles values (623, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (628, 1, getdate(), getdate(), 0, 629, 'test', 0, 0, 'sfo9', 'test.sfo.9@liferay.com', 'Welcome Test SFO 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (629, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (630, 1, 628, 9, 628, 0, 0, '630', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (631, 1, 630, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (632, 1, 630, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (628, 14)
go

insert into Users_Orgs (userId, organizationId) values (628, 17)
go
insert into Users_Orgs (userId, organizationId) values (628, 47)
go

insert into Users_Roles values (628, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (633, 1, getdate(), getdate(), 0, 634, 'test', 0, 0, 'sfo10', 'test.sfo.10@liferay.com', 'Welcome Test SFO 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (634, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (635, 1, 633, 9, 633, 0, 0, '635', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (636, 1, 635, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (637, 1, 635, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (633, 14)
go

insert into Users_Orgs (userId, organizationId) values (633, 17)
go
insert into Users_Orgs (userId, organizationId) values (633, 47)
go

insert into Users_Roles values (633, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (638, 1, getdate(), getdate(), 0, 639, 'test', 0, 0, 'ord1', 'test.ord.1@liferay.com', 'Welcome Test ORD 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (639, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (640, 1, 638, 9, 638, 0, 0, '640', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (641, 1, 640, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (642, 1, 640, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (638, 14)
go

insert into Users_Orgs (userId, organizationId) values (638, 17)
go
insert into Users_Orgs (userId, organizationId) values (638, 51)
go

insert into Users_Roles values (638, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (643, 1, getdate(), getdate(), 0, 644, 'test', 0, 0, 'ord2', 'test.ord.2@liferay.com', 'Welcome Test ORD 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (644, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (645, 1, 643, 9, 643, 0, 0, '645', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (646, 1, 645, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (647, 1, 645, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (643, 14)
go

insert into Users_Orgs (userId, organizationId) values (643, 17)
go
insert into Users_Orgs (userId, organizationId) values (643, 51)
go

insert into Users_Roles values (643, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (648, 1, getdate(), getdate(), 0, 649, 'test', 0, 0, 'ord3', 'test.ord.3@liferay.com', 'Welcome Test ORD 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (649, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (650, 1, 648, 9, 648, 0, 0, '650', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (651, 1, 650, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (652, 1, 650, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (648, 14)
go

insert into Users_Orgs (userId, organizationId) values (648, 17)
go
insert into Users_Orgs (userId, organizationId) values (648, 51)
go

insert into Users_Roles values (648, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (653, 1, getdate(), getdate(), 0, 654, 'test', 0, 0, 'ord4', 'test.ord.4@liferay.com', 'Welcome Test ORD 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (654, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (655, 1, 653, 9, 653, 0, 0, '655', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (656, 1, 655, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (657, 1, 655, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (653, 14)
go

insert into Users_Orgs (userId, organizationId) values (653, 17)
go
insert into Users_Orgs (userId, organizationId) values (653, 51)
go

insert into Users_Roles values (653, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (658, 1, getdate(), getdate(), 0, 659, 'test', 0, 0, 'ord5', 'test.ord.5@liferay.com', 'Welcome Test ORD 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (659, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (660, 1, 658, 9, 658, 0, 0, '660', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (661, 1, 660, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (662, 1, 660, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (658, 14)
go

insert into Users_Orgs (userId, organizationId) values (658, 17)
go
insert into Users_Orgs (userId, organizationId) values (658, 51)
go

insert into Users_Roles values (658, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (663, 1, getdate(), getdate(), 0, 664, 'test', 0, 0, 'ord6', 'test.ord.6@liferay.com', 'Welcome Test ORD 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (664, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (665, 1, 663, 9, 663, 0, 0, '665', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (666, 1, 665, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (667, 1, 665, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (663, 14)
go

insert into Users_Orgs (userId, organizationId) values (663, 17)
go
insert into Users_Orgs (userId, organizationId) values (663, 51)
go

insert into Users_Roles values (663, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (668, 1, getdate(), getdate(), 0, 669, 'test', 0, 0, 'ord7', 'test.ord.7@liferay.com', 'Welcome Test ORD 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (669, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (670, 1, 668, 9, 668, 0, 0, '670', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (671, 1, 670, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (672, 1, 670, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (668, 14)
go

insert into Users_Orgs (userId, organizationId) values (668, 17)
go
insert into Users_Orgs (userId, organizationId) values (668, 51)
go

insert into Users_Roles values (668, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (673, 1, getdate(), getdate(), 0, 674, 'test', 0, 0, 'ord8', 'test.ord.8@liferay.com', 'Welcome Test ORD 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (674, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (675, 1, 673, 9, 673, 0, 0, '675', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (676, 1, 675, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (677, 1, 675, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (673, 14)
go

insert into Users_Orgs (userId, organizationId) values (673, 17)
go
insert into Users_Orgs (userId, organizationId) values (673, 51)
go

insert into Users_Roles values (673, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (678, 1, getdate(), getdate(), 0, 679, 'test', 0, 0, 'ord9', 'test.ord.9@liferay.com', 'Welcome Test ORD 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (679, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (680, 1, 678, 9, 678, 0, 0, '680', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (681, 1, 680, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (682, 1, 680, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (678, 14)
go

insert into Users_Orgs (userId, organizationId) values (678, 17)
go
insert into Users_Orgs (userId, organizationId) values (678, 51)
go

insert into Users_Roles values (678, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (683, 1, getdate(), getdate(), 0, 684, 'test', 0, 0, 'ord10', 'test.ord.10@liferay.com', 'Welcome Test ORD 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (684, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (685, 1, 683, 9, 683, 0, 0, '685', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (686, 1, 685, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (687, 1, 685, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (683, 14)
go

insert into Users_Orgs (userId, organizationId) values (683, 17)
go
insert into Users_Orgs (userId, organizationId) values (683, 51)
go

insert into Users_Roles values (683, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (688, 1, getdate(), getdate(), 0, 689, 'test', 0, 0, 'nyc1', 'test.nyc.1@liferay.com', 'Welcome Test NYC 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (689, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (690, 1, 688, 9, 688, 0, 0, '690', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (691, 1, 690, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (692, 1, 690, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (688, 14)
go

insert into Users_Orgs (userId, organizationId) values (688, 17)
go
insert into Users_Orgs (userId, organizationId) values (688, 55)
go

insert into Users_Roles values (688, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (693, 1, getdate(), getdate(), 0, 694, 'test', 0, 0, 'nyc2', 'test.nyc.2@liferay.com', 'Welcome Test NYC 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (694, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (695, 1, 693, 9, 693, 0, 0, '695', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (696, 1, 695, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (697, 1, 695, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (693, 14)
go

insert into Users_Orgs (userId, organizationId) values (693, 17)
go
insert into Users_Orgs (userId, organizationId) values (693, 55)
go

insert into Users_Roles values (693, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (698, 1, getdate(), getdate(), 0, 699, 'test', 0, 0, 'nyc3', 'test.nyc.3@liferay.com', 'Welcome Test NYC 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (699, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (700, 1, 698, 9, 698, 0, 0, '700', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (701, 1, 700, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (702, 1, 700, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (698, 14)
go

insert into Users_Orgs (userId, organizationId) values (698, 17)
go
insert into Users_Orgs (userId, organizationId) values (698, 55)
go

insert into Users_Roles values (698, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (703, 1, getdate(), getdate(), 0, 704, 'test', 0, 0, 'nyc4', 'test.nyc.4@liferay.com', 'Welcome Test NYC 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (704, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (705, 1, 703, 9, 703, 0, 0, '705', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (706, 1, 705, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (707, 1, 705, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (703, 14)
go

insert into Users_Orgs (userId, organizationId) values (703, 17)
go
insert into Users_Orgs (userId, organizationId) values (703, 55)
go

insert into Users_Roles values (703, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (708, 1, getdate(), getdate(), 0, 709, 'test', 0, 0, 'nyc5', 'test.nyc.5@liferay.com', 'Welcome Test NYC 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (709, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (710, 1, 708, 9, 708, 0, 0, '710', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (711, 1, 710, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (712, 1, 710, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (708, 14)
go

insert into Users_Orgs (userId, organizationId) values (708, 17)
go
insert into Users_Orgs (userId, organizationId) values (708, 55)
go

insert into Users_Roles values (708, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (713, 1, getdate(), getdate(), 0, 714, 'test', 0, 0, 'nyc6', 'test.nyc.6@liferay.com', 'Welcome Test NYC 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (714, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (715, 1, 713, 9, 713, 0, 0, '715', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (716, 1, 715, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (717, 1, 715, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (713, 14)
go

insert into Users_Orgs (userId, organizationId) values (713, 17)
go
insert into Users_Orgs (userId, organizationId) values (713, 55)
go

insert into Users_Roles values (713, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (718, 1, getdate(), getdate(), 0, 719, 'test', 0, 0, 'nyc7', 'test.nyc.7@liferay.com', 'Welcome Test NYC 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (719, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (720, 1, 718, 9, 718, 0, 0, '720', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (721, 1, 720, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (722, 1, 720, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (718, 14)
go

insert into Users_Orgs (userId, organizationId) values (718, 17)
go
insert into Users_Orgs (userId, organizationId) values (718, 55)
go

insert into Users_Roles values (718, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (723, 1, getdate(), getdate(), 0, 724, 'test', 0, 0, 'nyc8', 'test.nyc.8@liferay.com', 'Welcome Test NYC 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (724, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (725, 1, 723, 9, 723, 0, 0, '725', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (726, 1, 725, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (727, 1, 725, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (723, 14)
go

insert into Users_Orgs (userId, organizationId) values (723, 17)
go
insert into Users_Orgs (userId, organizationId) values (723, 55)
go

insert into Users_Roles values (723, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (728, 1, getdate(), getdate(), 0, 729, 'test', 0, 0, 'nyc9', 'test.nyc.9@liferay.com', 'Welcome Test NYC 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (729, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (730, 1, 728, 9, 728, 0, 0, '730', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (731, 1, 730, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (732, 1, 730, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (728, 14)
go

insert into Users_Orgs (userId, organizationId) values (728, 17)
go
insert into Users_Orgs (userId, organizationId) values (728, 55)
go

insert into Users_Roles values (728, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (733, 1, getdate(), getdate(), 0, 734, 'test', 0, 0, 'nyc10', 'test.nyc.10@liferay.com', 'Welcome Test NYC 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (734, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (735, 1, 733, 9, 733, 0, 0, '735', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (736, 1, 735, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (737, 1, 735, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (733, 14)
go

insert into Users_Orgs (userId, organizationId) values (733, 17)
go
insert into Users_Orgs (userId, organizationId) values (733, 55)
go

insert into Users_Roles values (733, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (738, 1, getdate(), getdate(), 0, 739, 'test', 0, 0, 'gru1', 'test.gru.1@liferay.com', 'Welcome Test GRU 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (739, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (740, 1, 738, 9, 738, 0, 0, '740', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (741, 1, 740, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (742, 1, 740, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (738, 14)
go

insert into Users_Orgs (userId, organizationId) values (738, 17)
go
insert into Users_Orgs (userId, organizationId) values (738, 59)
go

insert into Users_Roles values (738, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (743, 1, getdate(), getdate(), 0, 744, 'test', 0, 0, 'gru2', 'test.gru.2@liferay.com', 'Welcome Test GRU 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (744, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (745, 1, 743, 9, 743, 0, 0, '745', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (746, 1, 745, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (747, 1, 745, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (743, 14)
go

insert into Users_Orgs (userId, organizationId) values (743, 17)
go
insert into Users_Orgs (userId, organizationId) values (743, 59)
go

insert into Users_Roles values (743, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (748, 1, getdate(), getdate(), 0, 749, 'test', 0, 0, 'gru3', 'test.gru.3@liferay.com', 'Welcome Test GRU 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (749, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (750, 1, 748, 9, 748, 0, 0, '750', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (751, 1, 750, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (752, 1, 750, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (748, 14)
go

insert into Users_Orgs (userId, organizationId) values (748, 17)
go
insert into Users_Orgs (userId, organizationId) values (748, 59)
go

insert into Users_Roles values (748, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (753, 1, getdate(), getdate(), 0, 754, 'test', 0, 0, 'gru4', 'test.gru.4@liferay.com', 'Welcome Test GRU 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (754, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (755, 1, 753, 9, 753, 0, 0, '755', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (756, 1, 755, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (757, 1, 755, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (753, 14)
go

insert into Users_Orgs (userId, organizationId) values (753, 17)
go
insert into Users_Orgs (userId, organizationId) values (753, 59)
go

insert into Users_Roles values (753, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (758, 1, getdate(), getdate(), 0, 759, 'test', 0, 0, 'gru5', 'test.gru.5@liferay.com', 'Welcome Test GRU 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (759, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (760, 1, 758, 9, 758, 0, 0, '760', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (761, 1, 760, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (762, 1, 760, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (758, 14)
go

insert into Users_Orgs (userId, organizationId) values (758, 17)
go
insert into Users_Orgs (userId, organizationId) values (758, 59)
go

insert into Users_Roles values (758, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (763, 1, getdate(), getdate(), 0, 764, 'test', 0, 0, 'gru6', 'test.gru.6@liferay.com', 'Welcome Test GRU 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (764, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (765, 1, 763, 9, 763, 0, 0, '765', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (766, 1, 765, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (767, 1, 765, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (763, 14)
go

insert into Users_Orgs (userId, organizationId) values (763, 17)
go
insert into Users_Orgs (userId, organizationId) values (763, 59)
go

insert into Users_Roles values (763, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (768, 1, getdate(), getdate(), 0, 769, 'test', 0, 0, 'gru7', 'test.gru.7@liferay.com', 'Welcome Test GRU 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (769, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (770, 1, 768, 9, 768, 0, 0, '770', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (771, 1, 770, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (772, 1, 770, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (768, 14)
go

insert into Users_Orgs (userId, organizationId) values (768, 17)
go
insert into Users_Orgs (userId, organizationId) values (768, 59)
go

insert into Users_Roles values (768, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (773, 1, getdate(), getdate(), 0, 774, 'test', 0, 0, 'gru8', 'test.gru.8@liferay.com', 'Welcome Test GRU 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (774, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (775, 1, 773, 9, 773, 0, 0, '775', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (776, 1, 775, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (777, 1, 775, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (773, 14)
go

insert into Users_Orgs (userId, organizationId) values (773, 17)
go
insert into Users_Orgs (userId, organizationId) values (773, 59)
go

insert into Users_Roles values (773, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (778, 1, getdate(), getdate(), 0, 779, 'test', 0, 0, 'gru9', 'test.gru.9@liferay.com', 'Welcome Test GRU 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (779, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (780, 1, 778, 9, 778, 0, 0, '780', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (781, 1, 780, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (782, 1, 780, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (778, 14)
go

insert into Users_Orgs (userId, organizationId) values (778, 17)
go
insert into Users_Orgs (userId, organizationId) values (778, 59)
go

insert into Users_Roles values (778, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (783, 1, getdate(), getdate(), 0, 784, 'test', 0, 0, 'gru10', 'test.gru.10@liferay.com', 'Welcome Test GRU 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (784, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (785, 1, 783, 9, 783, 0, 0, '785', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (786, 1, 785, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (787, 1, 785, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (783, 14)
go

insert into Users_Orgs (userId, organizationId) values (783, 17)
go
insert into Users_Orgs (userId, organizationId) values (783, 59)
go

insert into Users_Roles values (783, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (788, 1, getdate(), getdate(), 0, 789, 'test', 0, 0, 'fra1', 'test.fra.1@liferay.com', 'Welcome Test FRA 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (789, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (790, 1, 788, 9, 788, 0, 0, '790', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (791, 1, 790, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (792, 1, 790, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (788, 14)
go

insert into Users_Orgs (userId, organizationId) values (788, 17)
go
insert into Users_Orgs (userId, organizationId) values (788, 63)
go

insert into Users_Roles values (788, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (793, 1, getdate(), getdate(), 0, 794, 'test', 0, 0, 'fra2', 'test.fra.2@liferay.com', 'Welcome Test FRA 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (794, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (795, 1, 793, 9, 793, 0, 0, '795', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (796, 1, 795, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (797, 1, 795, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (793, 14)
go

insert into Users_Orgs (userId, organizationId) values (793, 17)
go
insert into Users_Orgs (userId, organizationId) values (793, 63)
go

insert into Users_Roles values (793, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (798, 1, getdate(), getdate(), 0, 799, 'test', 0, 0, 'fra3', 'test.fra.3@liferay.com', 'Welcome Test FRA 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (799, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (800, 1, 798, 9, 798, 0, 0, '800', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (801, 1, 800, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (802, 1, 800, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (798, 14)
go

insert into Users_Orgs (userId, organizationId) values (798, 17)
go
insert into Users_Orgs (userId, organizationId) values (798, 63)
go

insert into Users_Roles values (798, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (803, 1, getdate(), getdate(), 0, 804, 'test', 0, 0, 'fra4', 'test.fra.4@liferay.com', 'Welcome Test FRA 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (804, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (805, 1, 803, 9, 803, 0, 0, '805', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (806, 1, 805, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (807, 1, 805, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (803, 14)
go

insert into Users_Orgs (userId, organizationId) values (803, 17)
go
insert into Users_Orgs (userId, organizationId) values (803, 63)
go

insert into Users_Roles values (803, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (808, 1, getdate(), getdate(), 0, 809, 'test', 0, 0, 'fra5', 'test.fra.5@liferay.com', 'Welcome Test FRA 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (809, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (810, 1, 808, 9, 808, 0, 0, '810', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (811, 1, 810, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (812, 1, 810, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (808, 14)
go

insert into Users_Orgs (userId, organizationId) values (808, 17)
go
insert into Users_Orgs (userId, organizationId) values (808, 63)
go

insert into Users_Roles values (808, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (813, 1, getdate(), getdate(), 0, 814, 'test', 0, 0, 'fra6', 'test.fra.6@liferay.com', 'Welcome Test FRA 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (814, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (815, 1, 813, 9, 813, 0, 0, '815', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (816, 1, 815, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (817, 1, 815, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (813, 14)
go

insert into Users_Orgs (userId, organizationId) values (813, 17)
go
insert into Users_Orgs (userId, organizationId) values (813, 63)
go

insert into Users_Roles values (813, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (818, 1, getdate(), getdate(), 0, 819, 'test', 0, 0, 'fra7', 'test.fra.7@liferay.com', 'Welcome Test FRA 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (819, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (820, 1, 818, 9, 818, 0, 0, '820', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (821, 1, 820, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (822, 1, 820, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (818, 14)
go

insert into Users_Orgs (userId, organizationId) values (818, 17)
go
insert into Users_Orgs (userId, organizationId) values (818, 63)
go

insert into Users_Roles values (818, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (823, 1, getdate(), getdate(), 0, 824, 'test', 0, 0, 'fra8', 'test.fra.8@liferay.com', 'Welcome Test FRA 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (824, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (825, 1, 823, 9, 823, 0, 0, '825', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (826, 1, 825, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (827, 1, 825, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (823, 14)
go

insert into Users_Orgs (userId, organizationId) values (823, 17)
go
insert into Users_Orgs (userId, organizationId) values (823, 63)
go

insert into Users_Roles values (823, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (828, 1, getdate(), getdate(), 0, 829, 'test', 0, 0, 'fra9', 'test.fra.9@liferay.com', 'Welcome Test FRA 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (829, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (830, 1, 828, 9, 828, 0, 0, '830', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (831, 1, 830, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (832, 1, 830, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (828, 14)
go

insert into Users_Orgs (userId, organizationId) values (828, 17)
go
insert into Users_Orgs (userId, organizationId) values (828, 63)
go

insert into Users_Roles values (828, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (833, 1, getdate(), getdate(), 0, 834, 'test', 0, 0, 'fra10', 'test.fra.10@liferay.com', 'Welcome Test FRA 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (834, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (835, 1, 833, 9, 833, 0, 0, '835', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (836, 1, 835, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (837, 1, 835, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (833, 14)
go

insert into Users_Orgs (userId, organizationId) values (833, 17)
go
insert into Users_Orgs (userId, organizationId) values (833, 63)
go

insert into Users_Roles values (833, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (838, 1, getdate(), getdate(), 0, 839, 'test', 0, 0, 'mad1', 'test.mad.1@liferay.com', 'Welcome Test MAD 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (839, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (840, 1, 838, 9, 838, 0, 0, '840', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (841, 1, 840, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (842, 1, 840, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (838, 14)
go

insert into Users_Orgs (userId, organizationId) values (838, 17)
go
insert into Users_Orgs (userId, organizationId) values (838, 67)
go

insert into Users_Roles values (838, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (843, 1, getdate(), getdate(), 0, 844, 'test', 0, 0, 'mad2', 'test.mad.2@liferay.com', 'Welcome Test MAD 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (844, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (845, 1, 843, 9, 843, 0, 0, '845', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (846, 1, 845, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (847, 1, 845, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (843, 14)
go

insert into Users_Orgs (userId, organizationId) values (843, 17)
go
insert into Users_Orgs (userId, organizationId) values (843, 67)
go

insert into Users_Roles values (843, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (848, 1, getdate(), getdate(), 0, 849, 'test', 0, 0, 'mad3', 'test.mad.3@liferay.com', 'Welcome Test MAD 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (849, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (850, 1, 848, 9, 848, 0, 0, '850', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (851, 1, 850, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (852, 1, 850, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (848, 14)
go

insert into Users_Orgs (userId, organizationId) values (848, 17)
go
insert into Users_Orgs (userId, organizationId) values (848, 67)
go

insert into Users_Roles values (848, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (853, 1, getdate(), getdate(), 0, 854, 'test', 0, 0, 'mad4', 'test.mad.4@liferay.com', 'Welcome Test MAD 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (854, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (855, 1, 853, 9, 853, 0, 0, '855', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (856, 1, 855, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (857, 1, 855, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (853, 14)
go

insert into Users_Orgs (userId, organizationId) values (853, 17)
go
insert into Users_Orgs (userId, organizationId) values (853, 67)
go

insert into Users_Roles values (853, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (858, 1, getdate(), getdate(), 0, 859, 'test', 0, 0, 'mad5', 'test.mad.5@liferay.com', 'Welcome Test MAD 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (859, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (860, 1, 858, 9, 858, 0, 0, '860', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (861, 1, 860, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (862, 1, 860, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (858, 14)
go

insert into Users_Orgs (userId, organizationId) values (858, 17)
go
insert into Users_Orgs (userId, organizationId) values (858, 67)
go

insert into Users_Roles values (858, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (863, 1, getdate(), getdate(), 0, 864, 'test', 0, 0, 'mad6', 'test.mad.6@liferay.com', 'Welcome Test MAD 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (864, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (865, 1, 863, 9, 863, 0, 0, '865', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (866, 1, 865, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (867, 1, 865, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (863, 14)
go

insert into Users_Orgs (userId, organizationId) values (863, 17)
go
insert into Users_Orgs (userId, organizationId) values (863, 67)
go

insert into Users_Roles values (863, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (868, 1, getdate(), getdate(), 0, 869, 'test', 0, 0, 'mad7', 'test.mad.7@liferay.com', 'Welcome Test MAD 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (869, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (870, 1, 868, 9, 868, 0, 0, '870', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (871, 1, 870, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (872, 1, 870, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (868, 14)
go

insert into Users_Orgs (userId, organizationId) values (868, 17)
go
insert into Users_Orgs (userId, organizationId) values (868, 67)
go

insert into Users_Roles values (868, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (873, 1, getdate(), getdate(), 0, 874, 'test', 0, 0, 'mad8', 'test.mad.8@liferay.com', 'Welcome Test MAD 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (874, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (875, 1, 873, 9, 873, 0, 0, '875', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (876, 1, 875, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (877, 1, 875, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (873, 14)
go

insert into Users_Orgs (userId, organizationId) values (873, 17)
go
insert into Users_Orgs (userId, organizationId) values (873, 67)
go

insert into Users_Roles values (873, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (878, 1, getdate(), getdate(), 0, 879, 'test', 0, 0, 'mad9', 'test.mad.9@liferay.com', 'Welcome Test MAD 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (879, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (880, 1, 878, 9, 878, 0, 0, '880', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (881, 1, 880, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (882, 1, 880, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (878, 14)
go

insert into Users_Orgs (userId, organizationId) values (878, 17)
go
insert into Users_Orgs (userId, organizationId) values (878, 67)
go

insert into Users_Roles values (878, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (883, 1, getdate(), getdate(), 0, 884, 'test', 0, 0, 'mad10', 'test.mad.10@liferay.com', 'Welcome Test MAD 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (884, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (885, 1, 883, 9, 883, 0, 0, '885', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (886, 1, 885, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (887, 1, 885, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (883, 14)
go

insert into Users_Orgs (userId, organizationId) values (883, 17)
go
insert into Users_Orgs (userId, organizationId) values (883, 67)
go

insert into Users_Roles values (883, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (888, 1, getdate(), getdate(), 0, 889, 'test', 0, 0, 'dlc1', 'test.dlc.1@liferay.com', 'Welcome Test DLC 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (889, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (890, 1, 888, 9, 888, 0, 0, '890', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (891, 1, 890, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (892, 1, 890, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (888, 14)
go

insert into Users_Orgs (userId, organizationId) values (888, 17)
go
insert into Users_Orgs (userId, organizationId) values (888, 71)
go

insert into Users_Roles values (888, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (893, 1, getdate(), getdate(), 0, 894, 'test', 0, 0, 'dlc2', 'test.dlc.2@liferay.com', 'Welcome Test DLC 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (894, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (895, 1, 893, 9, 893, 0, 0, '895', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (896, 1, 895, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (897, 1, 895, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (893, 14)
go

insert into Users_Orgs (userId, organizationId) values (893, 17)
go
insert into Users_Orgs (userId, organizationId) values (893, 71)
go

insert into Users_Roles values (893, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (898, 1, getdate(), getdate(), 0, 899, 'test', 0, 0, 'dlc3', 'test.dlc.3@liferay.com', 'Welcome Test DLC 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (899, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (900, 1, 898, 9, 898, 0, 0, '900', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (901, 1, 900, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (902, 1, 900, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (898, 14)
go

insert into Users_Orgs (userId, organizationId) values (898, 17)
go
insert into Users_Orgs (userId, organizationId) values (898, 71)
go

insert into Users_Roles values (898, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (903, 1, getdate(), getdate(), 0, 904, 'test', 0, 0, 'dlc4', 'test.dlc.4@liferay.com', 'Welcome Test DLC 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (904, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (905, 1, 903, 9, 903, 0, 0, '905', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (906, 1, 905, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (907, 1, 905, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (903, 14)
go

insert into Users_Orgs (userId, organizationId) values (903, 17)
go
insert into Users_Orgs (userId, organizationId) values (903, 71)
go

insert into Users_Roles values (903, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (908, 1, getdate(), getdate(), 0, 909, 'test', 0, 0, 'dlc5', 'test.dlc.5@liferay.com', 'Welcome Test DLC 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (909, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (910, 1, 908, 9, 908, 0, 0, '910', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (911, 1, 910, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (912, 1, 910, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (908, 14)
go

insert into Users_Orgs (userId, organizationId) values (908, 17)
go
insert into Users_Orgs (userId, organizationId) values (908, 71)
go

insert into Users_Roles values (908, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (913, 1, getdate(), getdate(), 0, 914, 'test', 0, 0, 'dlc6', 'test.dlc.6@liferay.com', 'Welcome Test DLC 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (914, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (915, 1, 913, 9, 913, 0, 0, '915', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (916, 1, 915, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (917, 1, 915, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (913, 14)
go

insert into Users_Orgs (userId, organizationId) values (913, 17)
go
insert into Users_Orgs (userId, organizationId) values (913, 71)
go

insert into Users_Roles values (913, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (918, 1, getdate(), getdate(), 0, 919, 'test', 0, 0, 'dlc7', 'test.dlc.7@liferay.com', 'Welcome Test DLC 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (919, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (920, 1, 918, 9, 918, 0, 0, '920', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (921, 1, 920, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (922, 1, 920, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (918, 14)
go

insert into Users_Orgs (userId, organizationId) values (918, 17)
go
insert into Users_Orgs (userId, organizationId) values (918, 71)
go

insert into Users_Roles values (918, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (923, 1, getdate(), getdate(), 0, 924, 'test', 0, 0, 'dlc8', 'test.dlc.8@liferay.com', 'Welcome Test DLC 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (924, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (925, 1, 923, 9, 923, 0, 0, '925', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (926, 1, 925, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (927, 1, 925, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (923, 14)
go

insert into Users_Orgs (userId, organizationId) values (923, 17)
go
insert into Users_Orgs (userId, organizationId) values (923, 71)
go

insert into Users_Roles values (923, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (928, 1, getdate(), getdate(), 0, 929, 'test', 0, 0, 'dlc9', 'test.dlc.9@liferay.com', 'Welcome Test DLC 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (929, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (930, 1, 928, 9, 928, 0, 0, '930', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (931, 1, 930, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (932, 1, 930, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (928, 14)
go

insert into Users_Orgs (userId, organizationId) values (928, 17)
go
insert into Users_Orgs (userId, organizationId) values (928, 71)
go

insert into Users_Roles values (928, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (933, 1, getdate(), getdate(), 0, 934, 'test', 0, 0, 'dlc10', 'test.dlc.10@liferay.com', 'Welcome Test DLC 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (934, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (935, 1, 933, 9, 933, 0, 0, '935', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (936, 1, 935, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (937, 1, 935, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (933, 14)
go

insert into Users_Orgs (userId, organizationId) values (933, 17)
go
insert into Users_Orgs (userId, organizationId) values (933, 71)
go

insert into Users_Roles values (933, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (938, 1, getdate(), getdate(), 0, 939, 'test', 0, 0, 'hkg1', 'test.hkg.1@liferay.com', 'Welcome Test HKG 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (939, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (940, 1, 938, 9, 938, 0, 0, '940', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (941, 1, 940, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (942, 1, 940, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (938, 14)
go

insert into Users_Orgs (userId, organizationId) values (938, 17)
go
insert into Users_Orgs (userId, organizationId) values (938, 75)
go

insert into Users_Roles values (938, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (943, 1, getdate(), getdate(), 0, 944, 'test', 0, 0, 'hkg2', 'test.hkg.2@liferay.com', 'Welcome Test HKG 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (944, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (945, 1, 943, 9, 943, 0, 0, '945', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (946, 1, 945, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (947, 1, 945, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (943, 14)
go

insert into Users_Orgs (userId, organizationId) values (943, 17)
go
insert into Users_Orgs (userId, organizationId) values (943, 75)
go

insert into Users_Roles values (943, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (948, 1, getdate(), getdate(), 0, 949, 'test', 0, 0, 'hkg3', 'test.hkg.3@liferay.com', 'Welcome Test HKG 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (949, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (950, 1, 948, 9, 948, 0, 0, '950', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (951, 1, 950, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (952, 1, 950, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (948, 14)
go

insert into Users_Orgs (userId, organizationId) values (948, 17)
go
insert into Users_Orgs (userId, organizationId) values (948, 75)
go

insert into Users_Roles values (948, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (953, 1, getdate(), getdate(), 0, 954, 'test', 0, 0, 'hkg4', 'test.hkg.4@liferay.com', 'Welcome Test HKG 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (954, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (955, 1, 953, 9, 953, 0, 0, '955', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (956, 1, 955, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (957, 1, 955, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (953, 14)
go

insert into Users_Orgs (userId, organizationId) values (953, 17)
go
insert into Users_Orgs (userId, organizationId) values (953, 75)
go

insert into Users_Roles values (953, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (958, 1, getdate(), getdate(), 0, 959, 'test', 0, 0, 'hkg5', 'test.hkg.5@liferay.com', 'Welcome Test HKG 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (959, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (960, 1, 958, 9, 958, 0, 0, '960', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (961, 1, 960, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (962, 1, 960, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (958, 14)
go

insert into Users_Orgs (userId, organizationId) values (958, 17)
go
insert into Users_Orgs (userId, organizationId) values (958, 75)
go

insert into Users_Roles values (958, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (963, 1, getdate(), getdate(), 0, 964, 'test', 0, 0, 'hkg6', 'test.hkg.6@liferay.com', 'Welcome Test HKG 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (964, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (965, 1, 963, 9, 963, 0, 0, '965', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (966, 1, 965, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (967, 1, 965, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (963, 14)
go

insert into Users_Orgs (userId, organizationId) values (963, 17)
go
insert into Users_Orgs (userId, organizationId) values (963, 75)
go

insert into Users_Roles values (963, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (968, 1, getdate(), getdate(), 0, 969, 'test', 0, 0, 'hkg7', 'test.hkg.7@liferay.com', 'Welcome Test HKG 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (969, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (970, 1, 968, 9, 968, 0, 0, '970', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (971, 1, 970, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (972, 1, 970, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (968, 14)
go

insert into Users_Orgs (userId, organizationId) values (968, 17)
go
insert into Users_Orgs (userId, organizationId) values (968, 75)
go

insert into Users_Roles values (968, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (973, 1, getdate(), getdate(), 0, 974, 'test', 0, 0, 'hkg8', 'test.hkg.8@liferay.com', 'Welcome Test HKG 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (974, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (975, 1, 973, 9, 973, 0, 0, '975', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (976, 1, 975, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (977, 1, 975, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (973, 14)
go

insert into Users_Orgs (userId, organizationId) values (973, 17)
go
insert into Users_Orgs (userId, organizationId) values (973, 75)
go

insert into Users_Roles values (973, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (978, 1, getdate(), getdate(), 0, 979, 'test', 0, 0, 'hkg9', 'test.hkg.9@liferay.com', 'Welcome Test HKG 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (979, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (980, 1, 978, 9, 978, 0, 0, '980', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (981, 1, 980, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (982, 1, 980, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (978, 14)
go

insert into Users_Orgs (userId, organizationId) values (978, 17)
go
insert into Users_Orgs (userId, organizationId) values (978, 75)
go

insert into Users_Roles values (978, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (983, 1, getdate(), getdate(), 0, 984, 'test', 0, 0, 'hkg10', 'test.hkg.10@liferay.com', 'Welcome Test HKG 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (984, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (985, 1, 983, 9, 983, 0, 0, '985', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (986, 1, 985, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (987, 1, 985, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (983, 14)
go

insert into Users_Orgs (userId, organizationId) values (983, 17)
go
insert into Users_Orgs (userId, organizationId) values (983, 75)
go

insert into Users_Roles values (983, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (988, 1, getdate(), getdate(), 0, 989, 'test', 0, 0, 'kul1', 'test.kul.1@liferay.com', 'Welcome Test KUL 1!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (989, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (990, 1, 988, 9, 988, 0, 0, '990', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (991, 1, 990, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (992, 1, 990, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (988, 14)
go

insert into Users_Orgs (userId, organizationId) values (988, 17)
go
insert into Users_Orgs (userId, organizationId) values (988, 79)
go

insert into Users_Roles values (988, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (993, 1, getdate(), getdate(), 0, 994, 'test', 0, 0, 'kul2', 'test.kul.2@liferay.com', 'Welcome Test KUL 2!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (994, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (995, 1, 993, 9, 993, 0, 0, '995', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (996, 1, 995, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (997, 1, 995, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (993, 14)
go

insert into Users_Orgs (userId, organizationId) values (993, 17)
go
insert into Users_Orgs (userId, organizationId) values (993, 79)
go

insert into Users_Roles values (993, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (998, 1, getdate(), getdate(), 0, 999, 'test', 0, 0, 'kul3', 'test.kul.3@liferay.com', 'Welcome Test KUL 3!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (999, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1000, 1, 998, 9, 998, 0, 0, '1000', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1001, 1, 1000, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1002, 1, 1000, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (998, 14)
go

insert into Users_Orgs (userId, organizationId) values (998, 17)
go
insert into Users_Orgs (userId, organizationId) values (998, 79)
go

insert into Users_Roles values (998, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1003, 1, getdate(), getdate(), 0, 1004, 'test', 0, 0, 'kul4', 'test.kul.4@liferay.com', 'Welcome Test KUL 4!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1004, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1005, 1, 1003, 9, 1003, 0, 0, '1005', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1006, 1, 1005, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1007, 1, 1005, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1003, 14)
go

insert into Users_Orgs (userId, organizationId) values (1003, 17)
go
insert into Users_Orgs (userId, organizationId) values (1003, 79)
go

insert into Users_Roles values (1003, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1008, 1, getdate(), getdate(), 0, 1009, 'test', 0, 0, 'kul5', 'test.kul.5@liferay.com', 'Welcome Test KUL 5!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1009, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1010, 1, 1008, 9, 1008, 0, 0, '1010', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1011, 1, 1010, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1012, 1, 1010, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1008, 14)
go

insert into Users_Orgs (userId, organizationId) values (1008, 17)
go
insert into Users_Orgs (userId, organizationId) values (1008, 79)
go

insert into Users_Roles values (1008, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1013, 1, getdate(), getdate(), 0, 1014, 'test', 0, 0, 'kul6', 'test.kul.6@liferay.com', 'Welcome Test KUL 6!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1014, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1015, 1, 1013, 9, 1013, 0, 0, '1015', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1016, 1, 1015, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1017, 1, 1015, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1013, 14)
go

insert into Users_Orgs (userId, organizationId) values (1013, 17)
go
insert into Users_Orgs (userId, organizationId) values (1013, 79)
go

insert into Users_Roles values (1013, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1018, 1, getdate(), getdate(), 0, 1019, 'test', 0, 0, 'kul7', 'test.kul.7@liferay.com', 'Welcome Test KUL 7!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1019, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1020, 1, 1018, 9, 1018, 0, 0, '1020', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1021, 1, 1020, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1022, 1, 1020, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1018, 14)
go

insert into Users_Orgs (userId, organizationId) values (1018, 17)
go
insert into Users_Orgs (userId, organizationId) values (1018, 79)
go

insert into Users_Roles values (1018, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1023, 1, getdate(), getdate(), 0, 1024, 'test', 0, 0, 'kul8', 'test.kul.8@liferay.com', 'Welcome Test KUL 8!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1024, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1025, 1, 1023, 9, 1023, 0, 0, '1025', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1026, 1, 1025, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1027, 1, 1025, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1023, 14)
go

insert into Users_Orgs (userId, organizationId) values (1023, 17)
go
insert into Users_Orgs (userId, organizationId) values (1023, 79)
go

insert into Users_Roles values (1023, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1028, 1, getdate(), getdate(), 0, 1029, 'test', 0, 0, 'kul9', 'test.kul.9@liferay.com', 'Welcome Test KUL 9!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1029, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1030, 1, 1028, 9, 1028, 0, 0, '1030', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1031, 1, 1030, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1032, 1, 1030, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1028, 14)
go

insert into Users_Orgs (userId, organizationId) values (1028, 17)
go
insert into Users_Orgs (userId, organizationId) values (1028, 79)
go

insert into Users_Roles values (1028, 13)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1033, 1, getdate(), getdate(), 0, 1034, 'test', 0, 0, 'kul10', 'test.kul.10@liferay.com', 'Welcome Test KUL 10!', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1034, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1035, 1, 1033, 9, 1033, 0, 0, '1035', '', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1036, 1, 1035, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1037, 1, 1035, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1033, 14)
go

insert into Users_Orgs (userId, organizationId) values (1033, 17)
go
insert into Users_Orgs (userId, organizationId) values (1033, 79)
go

insert into Users_Roles values (1033, 13)
go












insert into Release_ (releaseId, createDate, modifiedDate, buildNumber, verified) values (1, getdate(), getdate(), 5102, 0)
go


create table QUARTZ_JOB_DETAILS (
	JOB_NAME varchar(80) not null,
	JOB_GROUP varchar(80) not null,
	DESCRIPTION varchar(120) null,
	JOB_CLASS_NAME varchar(128) not null,
	IS_DURABLE int not null,
	IS_VOLATILE int not null,
	IS_STATEFUL int not null,
	REQUESTS_RECOVERY int not null,
	JOB_DATA image null,
	primary key (JOB_NAME, JOB_GROUP)
)
go

create table QUARTZ_JOB_LISTENERS (
	JOB_NAME varchar(80) not null,
	JOB_GROUP varchar(80) not null,
	JOB_LISTENER varchar(80) not null,
	primary key (JOB_NAME, JOB_GROUP, JOB_LISTENER)
)
go

create table QUARTZ_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	JOB_NAME varchar(80) not null,
	JOB_GROUP varchar(80) not null,
	IS_VOLATILE int not null,
	DESCRIPTION varchar(120) null,
	NEXT_FIRE_TIME decimal(20,0) null,
	PREV_FIRE_TIME decimal(20,0) null,
	PRIORITY int null,
	TRIGGER_STATE varchar(16) not null,
	TRIGGER_TYPE varchar(8) not null,
	START_TIME decimal(20,0) not null,
	END_TIME decimal(20,0) null,
	CALENDAR_NAME varchar(80) null,
	MISFIRE_INSTR int null,
	JOB_DATA image null,
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
)
go

create table QUARTZ_SIMPLE_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	REPEAT_COUNT decimal(20,0) not null,
	REPEAT_INTERVAL decimal(20,0) not null,
	TIMES_TRIGGERED decimal(20,0) not null,
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
)
go

create table QUARTZ_CRON_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	CRON_EXPRESSION varchar(80) not null,
	TIME_ZONE_ID varchar(80),
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
)
go

create table QUARTZ_BLOB_TRIGGERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	BLOB_DATA image null,
	primary key (TRIGGER_NAME, TRIGGER_GROUP)
)
go

create table QUARTZ_TRIGGER_LISTENERS (
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	TRIGGER_LISTENER varchar(80) not null,
	primary key (TRIGGER_NAME, TRIGGER_GROUP, TRIGGER_LISTENER)
)
go

create table QUARTZ_CALENDARS (
	CALENDAR_NAME varchar(80) not null primary key,
	CALENDAR image not null
)
go

create table QUARTZ_PAUSED_TRIGGER_GRPS (
	TRIGGER_GROUP varchar(80) not null primary key
)
go

create table QUARTZ_FIRED_TRIGGERS (
	ENTRY_ID varchar(95) not null primary key,
	TRIGGER_NAME varchar(80) not null,
	TRIGGER_GROUP varchar(80) not null,
	IS_VOLATILE int not null,
	INSTANCE_NAME varchar(80) not null,
	FIRED_TIME decimal(20,0) not null,
	PRIORITY int not null,
	STATE varchar(16) not null,
	JOB_NAME varchar(80) null,
	JOB_GROUP varchar(80) null,
	IS_STATEFUL int null,
	REQUESTS_RECOVERY int null
)
go

create table QUARTZ_SCHEDULER_STATE (
	INSTANCE_NAME varchar(80) not null primary key,
	LAST_CHECKIN_TIME decimal(20,0) not null,
	CHECKIN_INTERVAL decimal(20,0) not null
)
go

create table QUARTZ_LOCKS (
	LOCK_NAME varchar(40) not null primary key
)
go

go

insert into QUARTZ_LOCKS values('TRIGGER_ACCESS')
go
insert into QUARTZ_LOCKS values('JOB_ACCESS')
go
insert into QUARTZ_LOCKS values('CALENDAR_ACCESS')
go
insert into QUARTZ_LOCKS values('STATE_ACCESS')
go
insert into QUARTZ_LOCKS values('MISFIRE_ACCESS')
go

create index IX_F7655CC3 on QUARTZ_TRIGGERS (NEXT_FIRE_TIME)
go
create index IX_9955EFB5 on QUARTZ_TRIGGERS (TRIGGER_STATE)
go
create index IX_8040C593 on QUARTZ_TRIGGERS (TRIGGER_STATE, NEXT_FIRE_TIME)
go
create index IX_804154AF on QUARTZ_FIRED_TRIGGERS (INSTANCE_NAME)
go
create index IX_BAB9A1F7 on QUARTZ_FIRED_TRIGGERS (JOB_GROUP)
go
create index IX_ADEE6A17 on QUARTZ_FIRED_TRIGGERS (JOB_NAME)
go
create index IX_64B194F2 on QUARTZ_FIRED_TRIGGERS (TRIGGER_GROUP)
go
create index IX_5FEABBC on QUARTZ_FIRED_TRIGGERS (TRIGGER_NAME)
go
create index IX_20D8706C on QUARTZ_FIRED_TRIGGERS (TRIGGER_NAME, TRIGGER_GROUP)
go



go
