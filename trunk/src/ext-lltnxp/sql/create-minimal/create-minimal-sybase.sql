use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

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
	prior int
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
	isleadermetting int
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


create index IX_93D5AD4E on Address (companyId)
go
create index IX_ABD7DAC0 on Address (companyId, classNameId)
go
create index IX_71CB1123 on Address (companyId, classNameId, classPK)
go
create index IX_5BC8B0D4 on Address (userId)
go

create index IX_6EDB9600 on AnnouncementsDelivery (userId)
go
create index IX_BA4413D5 on AnnouncementsDelivery (userId, type_)
go

create index IX_A6EF0B81 on AnnouncementsEntry (classNameId, classPK)
go
create index IX_D49C2E66 on AnnouncementsEntry (userId)
go
create index IX_1AFBDE08 on AnnouncementsEntry (uuid_)
go

create index IX_9C7EB9F on AnnouncementsFlag (entryId)
go
create index IX_4539A99C on AnnouncementsFlag (userId, entryId, value)
go

create index IX_72EF6041 on BlogsEntry (companyId)
go
create index IX_81A50303 on BlogsEntry (groupId)
go
create index IX_DB780A20 on BlogsEntry (groupId, urlTitle)
go
create index IX_C07CA83D on BlogsEntry (groupId, userId)
go
create index IX_69157A4D on BlogsEntry (uuid_)
go
create index IX_1B1040FD on BlogsEntry (uuid_, groupId)
go

create index IX_90CDA39A on BlogsStatsUser (companyId, entryCount)
go
create index IX_43840EEB on BlogsStatsUser (groupId)
go
create index IX_28C78D5C on BlogsStatsUser (groupId, entryCount)
go
create index IX_82254C25 on BlogsStatsUser (groupId, userId)
go
create index IX_BB51F1D9 on BlogsStatsUser (userId)
go

create index IX_443BDC38 on BookmarksEntry (folderId)
go
create index IX_B670BA39 on BookmarksEntry (uuid_)
go

create index IX_2ABA25D7 on BookmarksFolder (companyId)
go
create index IX_7F703619 on BookmarksFolder (groupId)
go
create index IX_967799C0 on BookmarksFolder (groupId, parentFolderId)
go
create index IX_451E7AE3 on BookmarksFolder (uuid_)
go
create index IX_DC2F8927 on BookmarksFolder (uuid_, groupId)
go

create index IX_12EE4898 on CalEvent (groupId)
go
create index IX_FCD7C63D on CalEvent (groupId, type_)
go
create index IX_C1AD2122 on CalEvent (uuid_)
go
create index IX_5CCE79C8 on CalEvent (uuid_, groupId)
go

create index IX_B27A301F on ClassName_ (value)
go

create index IX_38EFE3FD on Company (logoId)
go
create index IX_12566EC2 on Company (mx)
go
create index IX_975996C0 on Company (virtualHost)
go
create index IX_EC00543C on Company (webId)
go

create index IX_66D496A3 on Contact_ (companyId)
go

create index IX_717B97E1 on Country (a2)
go
create index IX_717B9BA2 on Country (a3)
go
create index IX_19DA007B on Country (name)
go

create index IX_4CB1B2B4 on DLFileEntry (companyId)
go
create index IX_24A846D1 on DLFileEntry (folderId)
go
create index IX_8F6C75D0 on DLFileEntry (folderId, name)
go
create index IX_A9951F17 on DLFileEntry (folderId, title)
go
create index IX_64F0FE40 on DLFileEntry (uuid_)
go

create index IX_CE705D48 on DLFileRank (companyId, userId, folderId, name)
go
create index IX_40B56512 on DLFileRank (folderId, name)
go
create index IX_EED06670 on DLFileRank (userId)
go

create index IX_E56EC6AD on DLFileShortcut (folderId)
go
create index IX_CA2708A2 on DLFileShortcut (toFolderId, toName)
go
create index IX_4831EBE4 on DLFileShortcut (uuid_)
go

create index IX_9CD91DB6 on DLFileVersion (folderId, name)
go
create index IX_6C5E6512 on DLFileVersion (folderId, name, version)
go

create index IX_A74DB14C on DLFolder (companyId)
go
create index IX_F2EA1ACE on DLFolder (groupId)
go
create index IX_49C37475 on DLFolder (groupId, parentFolderId)
go
create index IX_902FD874 on DLFolder (groupId, parentFolderId, name)
go
create index IX_51556082 on DLFolder (parentFolderId, name)
go
create index IX_CBC408D8 on DLFolder (uuid_)
go
create index IX_3CC1DED2 on DLFolder (uuid_, groupId)
go

create index IX_1BB072CA on EmailAddress (companyId)
go
create index IX_49D2DEC4 on EmailAddress (companyId, classNameId)
go
create index IX_551A519F on EmailAddress (companyId, classNameId, classPK)
go
create index IX_7B43CD8 on EmailAddress (userId)
go

create index IX_A8C0CBE8 on ExpandoColumn (tableId)
go
create index IX_FEFC8DA7 on ExpandoColumn (tableId, name)
go

create index IX_D3F5D7AE on ExpandoRow (tableId)
go
create index IX_81EFBFF5 on ExpandoRow (tableId, classPK)
go

create index IX_F0A86A4F on ExpandoTable (classNameId)
go
create index IX_DED782CE on ExpandoTable (classNameId, name)
go

create index IX_B29FEF17 on ExpandoValue (classNameId, classPK)
go
create index IX_F7DD0987 on ExpandoValue (columnId)
go
create index IX_9DDD21E5 on ExpandoValue (columnId, rowId_)
go
create index IX_9112A7A0 on ExpandoValue (rowId_)
go
create index IX_F0566A77 on ExpandoValue (tableId)
go
create index IX_886B68D1 on ExpandoValue (tableId, columnId, classNameId, classPK)
go
create index IX_B5984EDA on ExpandoValue (tableId, columnId, rowId_)
go
create index IX_B71E92D5 on ExpandoValue (tableId, rowId_)
go

create index IX_D0D5E397 on Group_ (companyId, classNameId, classPK)
go
create index IX_5BDDB872 on Group_ (companyId, friendlyURL)
go
create index IX_5AA68501 on Group_ (companyId, name)
go
create index IX_16218A38 on Group_ (liveGroupId)
go

create index LIFERAY_001 on Groups_Permissions (permissionId)
go

create index IX_60214CF6 on IGFolder (companyId)
go
create index IX_206498F8 on IGFolder (groupId)
go
create index IX_1A605E9F on IGFolder (groupId, parentFolderId)
go
create index IX_9BBAFB1E on IGFolder (groupId, parentFolderId, name)
go
create index IX_F73C0982 on IGFolder (uuid_)
go
create index IX_B10EFD68 on IGFolder (uuid_, groupId)
go

create index IX_E597322D on IGImage (custom1ImageId)
go
create index IX_D9E0A34C on IGImage (custom2ImageId)
go
create index IX_4438CA80 on IGImage (folderId)
go
create index IX_BCB13A3F on IGImage (folderId, name)
go
create index IX_64F0B572 on IGImage (largeImageId)
go
create index IX_D3D32126 on IGImage (smallImageId)
go
create index IX_265BB0F1 on IGImage (uuid_)
go

create index IX_6A925A4D on Image (size_)
go

create index IX_DFF98523 on JournalArticle (companyId)
go
create index IX_9356F865 on JournalArticle (groupId)
go
create index IX_68C0F69C on JournalArticle (groupId, articleId)
go
create index IX_85C52EEC on JournalArticle (groupId, articleId, version)
go
create index IX_2E207659 on JournalArticle (groupId, structureId)
go
create index IX_8DEAE14E on JournalArticle (groupId, templateId)
go
create index IX_EF9B7028 on JournalArticle (smallImageId)
go
create index IX_F029602F on JournalArticle (uuid_)
go
create index IX_3463D95B on JournalArticle (uuid_, groupId)
go

create index IX_3B51BB68 on JournalArticleImage (groupId)
go
create index IX_158B526F on JournalArticleImage (groupId, articleId, version)
go
create index IX_D67292FC on JournalArticleImage (groupId, articleId, version, elName, languageId)
go

create index IX_F8433677 on JournalArticleResource (groupId)
go
create index IX_88DF994A on JournalArticleResource (groupId, articleId)
go

create index IX_6838E427 on JournalContentSearch (groupId, articleId)
go

create index IX_35A2DB2F on JournalFeed (groupId)
go
create index IX_65576CBC on JournalFeed (groupId, feedId)
go
create index IX_50C36D79 on JournalFeed (uuid_)
go
create index IX_39031F51 on JournalFeed (uuid_, groupId)
go

create index IX_B97F5608 on JournalStructure (groupId)
go
create index IX_AB6E9996 on JournalStructure (groupId, structureId)
go
create index IX_8831E4FC on JournalStructure (structureId)
go
create index IX_6702CA92 on JournalStructure (uuid_)
go
create index IX_42E86E58 on JournalStructure (uuid_, groupId)
go

create index IX_77923653 on JournalTemplate (groupId)
go
create index IX_1701CB2B on JournalTemplate (groupId, structureId)
go
create index IX_E802AA3C on JournalTemplate (groupId, templateId)
go
create index IX_25FFB6FA on JournalTemplate (smallImageId)
go
create index IX_1B12CA20 on JournalTemplate (templateId)
go
create index IX_2857419D on JournalTemplate (uuid_)
go
create index IX_62D1B3AD on JournalTemplate (uuid_, groupId)
go

create index IX_C7FBC998 on Layout (companyId)
go
create index IX_FAD05595 on Layout (dlFolderId)
go
create index IX_C099D61A on Layout (groupId)
go
create index IX_23922F7D on Layout (iconImageId)
go

create index IX_A40B8BEC on LayoutSet (groupId)
go
create index IX_5ABC2905 on LayoutSet (virtualHost)
go

create index IX_2932DD37 on ListType (type_)
go

create index IX_69951A25 on MBBan (banUserId)
go
create index IX_5C3FF12A on MBBan (groupId)
go
create index IX_8ABC4E3B on MBBan (groupId, banUserId)
go
create index IX_48814BBA on MBBan (userId)
go

create index IX_BC735DCF on MBCategory (companyId)
go
create index IX_BB870C11 on MBCategory (groupId)
go
create index IX_ED292508 on MBCategory (groupId, parentCategoryId)
go
create index IX_C2626EDB on MBCategory (uuid_)
go
create index IX_F7D28C2F on MBCategory (uuid_, groupId)
go

create index IX_79D0120B on MBDiscussion (classNameId)
go
create index IX_33A4DE38 on MBDiscussion (classNameId, classPK)
go
create index IX_B5CA2DC on MBDiscussion (threadId)
go

create index IX_3C865EE5 on MBMessage (categoryId)
go
create index IX_138C7F1E on MBMessage (categoryId, threadId)
go
create index IX_B1432D30 on MBMessage (companyId)
go
create index IX_75B95071 on MBMessage (threadId)
go
create index IX_A7038CD7 on MBMessage (threadId, parentMessageId)
go
create index IX_C57B16BC on MBMessage (uuid_)
go

create index IX_D180D4AE on MBMessageFlag (messageId)
go
create index IX_7B2917BE on MBMessageFlag (userId)
go
create index IX_94A83834 on MBMessageFlag (userId, messageId)
go

create index IX_A00A898F on MBStatsUser (groupId)
go
create index IX_FAB5A88B on MBStatsUser (groupId, messageCount)
go
create index IX_9168E2C9 on MBStatsUser (groupId, userId)
go
create index IX_847F92B5 on MBStatsUser (userId)
go

create index IX_CB854772 on MBThread (categoryId)
go

create index IX_FA179180 on MeetingCalComponent (mcalId)
go

create index IX_F199C38B on MeetingCalendar (groupId)
go
create index IX_3B1B516 on MeetingCalendar (groupId, state)
go
create index IX_5AD0BCD5 on MeetingCalendar (uuid_)
go
create index IX_A1E35775 on MeetingCalendar (uuid_, groupId)
go

create index IX_67E076A0 on MeetingDetailWeek (mdweekId)
go
create index IX_D15DC0FF on MeetingDetailWeek (week, year)
go

create index IX_8A1CC4B on MembershipRequest (groupId)
go
create index IX_C28C72EC on MembershipRequest (groupId, statusId)
go
create index IX_66D70879 on MembershipRequest (userId)
go

create index IX_A425F71A on OrgGroupPermission (groupId)
go
create index IX_6C53DA4E on OrgGroupPermission (permissionId)
go

create index IX_4A527DD3 on OrgGroupRole (groupId)
go
create index IX_AB044D1C on OrgGroupRole (roleId)
go

create index IX_6AF0D434 on OrgLabor (organizationId)
go

create index IX_834BCEB6 on Organization_ (companyId)
go
create index IX_E301BDF5 on Organization_ (companyId, name)
go
create index IX_418E4522 on Organization_ (companyId, parentOrganizationId)
go

create index IX_D7390C66 on PML_Country (active)
go
create index IX_3A155227 on PML_Country (countryCode)
go
create index IX_10E0D02 on PML_Country (countryCode, countryName, description)
go
create index IX_4C196F45 on PML_Country (countryName)
go
create index IX_DA792540 on PML_Country (description)
go

create index IX_88570760 on PML_FILETYPE (description)
go
create index IX_128135D9 on PML_FILETYPE (fieldId)
go
create index IX_3D91D363 on PML_FILETYPE (fileTypeCode)
go
create index IX_5686E658 on PML_FILETYPE (fileTypeCode, fileTypeName)
go
create index IX_4F95F081 on PML_FILETYPE (fileTypeName)
go
create index IX_D75327B6 on PML_FILETYPE (receiptTemplate)
go

create index IX_4A476C8F on PML_IDGENERATED (curvalue)
go
create index IX_2502809B on PML_IDGENERATED (year)
go
create index IX_B91244C0 on PML_IDGENERATED (year, curvalue)
go

create index IX_584A1DA1 on PML_IDTEMPLATE (description)
go
create index IX_9C8A9C16 on PML_IDTEMPLATE (format)
go
create index IX_80B4ACD6 on PML_IDTEMPLATE (format, description)
go

create index IX_3FBFA9F4 on PasswordPolicy (companyId, name)
go

create index IX_C3A17327 on PasswordPolicyRel (classNameId, classPK)
go
create index IX_ED7CF243 on PasswordPolicyRel (passwordPolicyId, classNameId, classPK)
go

create index IX_326F75BD on PasswordTracker (userId)
go

create index IX_4D19C2B8 on Permission_ (actionId, resourceId)
go
create index IX_F090C113 on Permission_ (resourceId)
go

create index IX_9F704A14 on Phone (companyId)
go
create index IX_A2E4AFBA on Phone (companyId, classNameId)
go
create index IX_9A53569 on Phone (companyId, classNameId, classPK)
go
create index IX_F202B9CE on Phone (userId)
go

create index IX_B9746445 on PluginSetting (companyId)
go
create index IX_7171B2E8 on PluginSetting (companyId, pluginId, pluginType)
go

create index IX_EC370F10 on PollsChoice (questionId)
go
create index IX_D76DD2CF on PollsChoice (questionId, name)
go
create index IX_6660B399 on PollsChoice (uuid_)
go

create index IX_9FF342EA on PollsQuestion (groupId)
go
create index IX_51F087F4 on PollsQuestion (uuid_)
go
create index IX_F3C9F36 on PollsQuestion (uuid_, groupId)
go

create index IX_D5DF7B54 on PollsVote (choiceId)
go
create index IX_12112599 on PollsVote (questionId)
go
create index IX_1BBFD4D3 on PollsVote (questionId, userId)
go

create index IX_80CC9508 on Portlet (companyId)
go
create index IX_12B5E51D on Portlet (companyId, portletId)
go

create index IX_96BDD537 on PortletItem (groupId, classNameId)
go
create index IX_D699243F on PortletItem (groupId, name, portletId, classNameId)
go
create index IX_2C61314E on PortletItem (groupId, portletId)
go
create index IX_E922D6C0 on PortletItem (groupId, portletId, classNameId)
go
create index IX_8E71167F on PortletItem (groupId, portletId, classNameId, name)
go
create index IX_33B8CE8D on PortletItem (groupId, portletId, name)
go

create index IX_E4F13E6E on PortletPreferences (ownerId, ownerType, plid)
go
create index IX_C7057FF7 on PortletPreferences (ownerId, ownerType, plid, portletId)
go
create index IX_F15C1C4F on PortletPreferences (plid)
go
create index IX_D340DB76 on PortletPreferences (plid, portletId)
go

create index IX_16184D57 on RatingsEntry (classNameId, classPK)
go
create index IX_B47E3C11 on RatingsEntry (userId, classNameId, classPK)
go

create index IX_A6E99284 on RatingsStats (classNameId, classPK)
go

create index IX_16D87CA7 on Region (countryId)
go

create index IX_882E56F on ReportsEntry (companyId)
go
create index IX_C74E5453 on ReportsEntry (userId)
go

create index IX_717FDD47 on ResourceCode (companyId)
go
create index IX_A32C097E on ResourceCode (companyId, name, scope)
go
create index IX_AACAFF40 on ResourceCode (name)
go

create index IX_2578FBD3 on Resource_ (codeId)
go
create index IX_67DE7856 on Resource_ (codeId, primKey)
go

create index IX_449A10B9 on Role_ (companyId)
go
create index IX_A88E424E on Role_ (companyId, classNameId, classPK)
go
create index IX_EBC931B8 on Role_ (companyId, name)
go

create index LIFERAY_002 on Roles_Permissions (permissionId)
go

create index IX_C98C0D78 on SCFrameworkVersion (companyId)
go
create index IX_272991FA on SCFrameworkVersion (groupId)
go


create index IX_5D25244F on SCProductEntry (companyId)
go
create index IX_72F87291 on SCProductEntry (groupId)
go
create index IX_98E6A9CB on SCProductEntry (groupId, userId)
go
create index IX_7311E812 on SCProductEntry (repoGroupId, repoArtifactId)
go

create index IX_AE8224CC on SCProductScreenshot (fullImageId)
go
create index IX_467956FD on SCProductScreenshot (productEntryId)
go
create index IX_DA913A55 on SCProductScreenshot (productEntryId, priority)
go
create index IX_6C572DAC on SCProductScreenshot (thumbnailId)
go

create index IX_7020130F on SCProductVersion (directDownloadURL)
go
create index IX_8377A211 on SCProductVersion (productEntryId)
go

create index IX_7338606F on ServiceComponent (buildNamespace)
go
create index IX_4F0315B8 on ServiceComponent (buildNamespace, buildNumber)
go

create index IX_C28B41DC on ShoppingCart (groupId)
go
create index IX_FC46FE16 on ShoppingCart (groupId, userId)
go
create index IX_54101CC8 on ShoppingCart (userId)
go

create index IX_5F615D3E on ShoppingCategory (groupId)
go
create index IX_1E6464F5 on ShoppingCategory (groupId, parentCategoryId)
go

create index IX_DC60CFAE on ShoppingCoupon (code_)
go
create index IX_3251AF16 on ShoppingCoupon (groupId)
go

create index IX_C8EACF2E on ShoppingItem (categoryId)
go
create index IX_1C717CA6 on ShoppingItem (companyId, sku)
go
create index IX_903DC750 on ShoppingItem (largeImageId)
go
create index IX_D217AB30 on ShoppingItem (mediumImageId)
go
create index IX_FF203304 on ShoppingItem (smallImageId)
go

create index IX_6D5F9B87 on ShoppingItemField (itemId)
go

create index IX_EA6FD516 on ShoppingItemPrice (itemId)
go

create index IX_1D15553E on ShoppingOrder (groupId)
go
create index IX_119B5630 on ShoppingOrder (groupId, userId, ppPaymentStatus)
go
create index IX_D7D6E87A on ShoppingOrder (number_)
go
create index IX_F474FD89 on ShoppingOrder (ppTxnId)
go

create index IX_B5F82C7A on ShoppingOrderItem (orderId)
go

create index IX_82E39A0C on SocialActivity (classNameId)
go
create index IX_A853C757 on SocialActivity (classNameId, classPK)
go
create index IX_64B1BC66 on SocialActivity (companyId)
go
create index IX_2A2468 on SocialActivity (groupId)
go
create index IX_8F32DEC9 on SocialActivity (groupId, userId, createDate, classNameId, classPK, type_, receiverUserId)
go
create index IX_1271F25F on SocialActivity (mirrorActivityId)
go
create index IX_1F00C374 on SocialActivity (mirrorActivityId, classNameId, classPK)
go
create index IX_121CA3CB on SocialActivity (receiverUserId)
go
create index IX_3504B8BC on SocialActivity (userId)
go

create index IX_61171E99 on SocialRelation (companyId)
go
create index IX_95135D1C on SocialRelation (companyId, type_)
go
create index IX_C31A64C6 on SocialRelation (type_)
go
create index IX_5A40CDCC on SocialRelation (userId1)
go
create index IX_4B52BE89 on SocialRelation (userId1, type_)
go
create index IX_12A92145 on SocialRelation (userId1, userId2, type_)
go
create index IX_5A40D18D on SocialRelation (userId2)
go
create index IX_3F9C2FA8 on SocialRelation (userId2, type_)
go
create index IX_F0CA24A5 on SocialRelation (uuid_)
go

create index IX_A90FE5A0 on SocialRequest (companyId)
go
create index IX_32292ED1 on SocialRequest (receiverUserId)
go
create index IX_D9380CB7 on SocialRequest (receiverUserId, status)
go
create index IX_80F7A9C2 on SocialRequest (userId)
go
create index IX_36A90CA7 on SocialRequest (userId, classNameId, classPK, type_, receiverUserId)
go
create index IX_F3BFB48D on SocialRequest (userId, classNameId, classPK, type_, receiverUserId, status)
go
create index IX_CC86A444 on SocialRequest (userId, classNameId, classPK, type_, status)
go
create index IX_AB5906A8 on SocialRequest (userId, status)
go
create index IX_49D5872C on SocialRequest (uuid_)
go
create index IX_4F973EFE on SocialRequest (uuid_, groupId)
go

create index IX_786D171A on Subscription (companyId, classNameId, classPK)
go
create index IX_2E1A92D4 on Subscription (companyId, userId, classNameId, classPK)
go
create index IX_54243AFD on Subscription (userId)
go

create index IX_1AB6D6D2 on TagsAsset (classNameId, classPK)
go
create index IX_AB3D8BCB on TagsAsset (companyId)
go

create index IX_10563688 on TagsEntry (companyId, name)
go

create index IX_C134234 on TagsProperty (companyId)
go
create index IX_EB974D08 on TagsProperty (companyId, key_)
go
create index IX_5200A629 on TagsProperty (entryId)
go
create index IX_F505253D on TagsProperty (entryId, key_)
go

create index IX_181A4A1B on TasksProposal (classNameId, classPK)
go
create index IX_7FB27324 on TasksProposal (groupId)
go
create index IX_6EEC675E on TasksProposal (groupId, userId)
go

create index IX_4D0C7F8D on TasksReview (proposalId)
go
create index IX_70AFEA01 on TasksReview (proposalId, stage)
go
create index IX_36F512E6 on TasksReview (userId)
go
create index IX_5C6BE4C7 on TasksReview (userId, proposalId)
go

create index IX_524FEFCE on UserGroup (companyId)
go
create index IX_23EAD0D on UserGroup (companyId, name)
go
create index IX_69771487 on UserGroup (companyId, parentUserGroupId)
go

create index IX_1B988D7A on UserGroupRole (groupId)
go
create index IX_871412DF on UserGroupRole (groupId, roleId)
go
create index IX_887A2C95 on UserGroupRole (roleId)
go
create index IX_887BE56A on UserGroupRole (userId)
go
create index IX_4D040680 on UserGroupRole (userId, groupId)
go

create index IX_41A32E0D on UserIdMapper (type_, externalUserId)
go
create index IX_E60EA987 on UserIdMapper (userId)
go
create index IX_D1C44A6E on UserIdMapper (userId, type_)
go

create index IX_29BA1CF5 on UserTracker (companyId)
go
create index IX_46B0AE8E on UserTracker (sessionId)
go
create index IX_E4EFBA8D on UserTracker (userId)
go

create index IX_14D8BCC0 on UserTrackerPath (userTrackerId)
go

create index IX_3A1E834E on User_ (companyId)
go
create index IX_615E9F7A on User_ (companyId, emailAddress)
go
create index IX_765A87C6 on User_ (companyId, password_)
go
create index IX_C5806019 on User_ (companyId, screenName)
go
create index IX_9782AD88 on User_ (companyId, userId)
go
create index IX_5ADBE171 on User_ (contactId)
go
create index IX_762F63C6 on User_ (emailAddress)
go
create index IX_A9ED7DD3 on User_ (openId)
go
create index IX_A18034A4 on User_ (portraitId)
go
create index IX_E0422BDA on User_ (uuid_)
go

create index LIFERAY_003 on Users_Permissions (permissionId)
go

create index IX_97DFA146 on WebDAVProps (classNameId, classPK)
go

create index IX_96F07007 on Website (companyId)
go
create index IX_4F0F0CA7 on Website (companyId, classNameId)
go
create index IX_F960131C on Website (companyId, classNameId, classPK)
go
create index IX_F75690BB on Website (userId)
go

create index IX_5D6FE3F0 on WikiNode (companyId)
go
create index IX_B480A672 on WikiNode (groupId)
go
create index IX_920CD8B1 on WikiNode (groupId, name)
go
create index IX_6C112D7C on WikiNode (uuid_)
go
create index IX_7609B2AE on WikiNode (uuid_, groupId)
go

create index IX_A2001730 on WikiPage (format)
go
create index IX_C8A9C476 on WikiPage (nodeId)
go
create index IX_46EEF3C8 on WikiPage (nodeId, parentTitle)
go
create index IX_1ECC7656 on WikiPage (nodeId, redirectTitle)
go
create index IX_997EEDD2 on WikiPage (nodeId, title)
go
create index IX_3D4AF476 on WikiPage (nodeId, title, version)
go
create index IX_9C0E478F on WikiPage (uuid_)
go

create index IX_21277664 on WikiPageResource (nodeId, title)
go

create index IX_2A105741 on holiday_calendar (holidayCalendarTitle)
go

create index IX_2FEAD0BC on pml_Receiver (userId, receiverType)
go
create index IX_A43BE445 on pml_Receiver (userId, receiverUserId, receiverType)
go
create index IX_F4C2DEF5 on pml_Receiver (userId, receiverUserName, receiverType)
go
create index IX_506889AC on pml_Receiver (userName, receiverType)
go
create index IX_E189BD35 on pml_Receiver (userName, receiverUserId, receiverType)
go
create index IX_15FE3BE5 on pml_Receiver (userName, receiverUserName, receiverType)
go

create index IX_B2593D80 on pml_ReceiverGroup (userId)
go
create index IX_68769EB on pml_ReceiverGroup (userId, receiverGroupName)
go
create index IX_D502FC55 on pml_ReceiverGroup (userId, type_)
go
create index IX_897D5E30 on pml_ReceiverGroup (userName)
go
create index IX_FDC9B5A5 on pml_ReceiverGroup (userName, type_)
go

create index IX_94534BCC on pml_Reciever (userId, recieverType)
go
create index IX_635945DD on pml_Reciever (userId, recieverUserId, recieverType)
go
create index IX_4935BC8D on pml_Reciever (userId, recieverUserName, recieverType)
go
create index IX_23C602BC on pml_Reciever (userName, recieverType)
go
create index IX_31E01CCD on pml_Reciever (userName, recieverUserId, recieverType)
go
create index IX_9162977D on pml_Reciever (userName, recieverUserName, recieverType)
go

create index IX_1A370FF8 on pml_RecieverGroup (userId)
go
create index IX_C41AA2EB on pml_RecieverGroup (userId, recieverGroupName)
go
create index IX_B2E1F2DD on pml_RecieverGroup (userId, type_)
go
create index IX_713072A8 on pml_RecieverGroup (userName)
go
create index IX_DFC52A2D on pml_RecieverGroup (userName, type_)
go

create index IX_F88C2FA1 on pml_agency (agencycode)
go
create index IX_F036A8A7 on pml_agency (agencycode, agencyname, description)
go
create index IX_A904CBF on pml_agency (agencyname)
go
create index IX_64EE6A51 on pml_agency (description)
go

create index IX_B1E9DBB8 on pml_agencyleader (agencyId)
go
create index IX_39E841FE on pml_agencyleader (userId)
go

create index IX_DAEDA857 on pml_attachedfile (attachedfilecode)
go
create index IX_3B085E76 on pml_attachedfile (attachedfilecode, attachedfilename, description)
go
create index IX_ECF1C575 on pml_attachedfile (attachedfilename)
go
create index IX_3648AFD6 on pml_attachedfile (description)
go

create index IX_BD1C5906 on pml_car_resource (carCode, companyId)
go
create index IX_BB4C3AF9 on pml_car_resource (companyId)
go

create index IX_8A35C013 on pml_career (careercode)
go
create index IX_5E23A45C on pml_career (careercode, careername, description)
go
create index IX_9C39DD31 on pml_career (careername)
go
create index IX_F31FDB8 on pml_career (description)
go

create index IX_923002F7 on pml_chi_tiet_hscv (id_cong_van_den)
go
create index IX_C2A6BC7F on pml_chi_tiet_hscv (id_cong_van_di)
go
create index IX_F7D3D244 on pml_chi_tiet_hscv (id_ho_so_cong_viec)
go
create index IX_1B406F27 on pml_chi_tiet_hscv (id_ho_so_cong_viec, id_cong_van_den)
go
create index IX_7CC00A4F on pml_chi_tiet_hscv (id_ho_so_cong_viec, id_cong_van_di)
go

create index IX_3461E29B on pml_city (active)
go
create index IX_FDA6104D on pml_city (cityCode)
go
create index IX_3FA09675 on pml_city (cityCode, cityName, description)
go
create index IX_FAA2D6B on pml_city (cityName)
go
create index IX_B4C69D60 on pml_city (countryid)
go
create index IX_FDD6E82B on pml_city (description)
go

create index IX_B0F6ED33 on pml_conf_phongban_hscv (departmentsId)
go

create index IX_5C17FC4B on pml_delegate (assigner)
go
create index IX_99BC9FAE on pml_delegate (assigner, receiver)
go
create index IX_771BE1E7 on pml_delegate (assigner, receiver, startdate, enddate)
go
create index IX_200281EE on pml_delegate (canceldelegate)
go
create index IX_45A908CF on pml_delegate (datecreated)
go
create index IX_2B691F9E on pml_delegate (receiver)
go
create index IX_1DD7D351 on pml_delegate (receiver, canceldelegate)
go
create index IX_A14C32B1 on pml_delegate (receiver, startdate, canceldate, canceldelegate)
go
create index IX_2BF909D7 on pml_delegate (receiver, startdate, enddate)
go
create index IX_5B262B8A on pml_delegate (receiver, startdate, enddate, canceldelegate)
go

create index IX_448EF07B on pml_departmentleader (clericalid)
go
create index IX_D88249DB on pml_departmentleader (departmentsId)
go
create index IX_BA719715 on pml_departmentleader (departmentsId, userId)
go
create index IX_BA1D974B on pml_departmentleader (userId)
go

create index IX_F958ACE1 on pml_departments (abbreviatename)
go
create index IX_CC20E6B1 on pml_departments (active)
go
create index IX_6B9E2EEB on pml_departments (agencyId)
go
create index IX_6BACBACB on pml_departments (agencyid)
go
create index IX_14823E3F on pml_departments (departmentsParentId)
go
create index IX_8D4EA2A7 on pml_departments (departmentscode)
go
create index IX_9EEF10DB on pml_departments (departmentscode, agencyId)
go
create index IX_9EFD9CBB on pml_departments (departmentscode, agencyid)
go
create index IX_63A5BF8D on pml_departments (departmentscode, departmentsname, abbreviatename, description)
go
create index IX_A696C777 on pml_departments (departmentscode, departmentsname, description)
go
create index IX_9F52BFC5 on pml_departments (departmentsname)
go
create index IX_9DBEEDFF on pml_departments (departmentsparentid)
go
create index IX_5E6501D5 on pml_departments (description)
go
create index IX_D3074E90 on pml_departments (hasteam)
go
create index IX_1EFA98FC on pml_departments (roleid)
go

create index IX_57BED4FE on pml_district (active)
go
create index IX_65B319BE on pml_district (cityID)
go
create index IX_31B0FBA8 on pml_district (description)
go
create index IX_1A5F56D3 on pml_district (districtCode)
go
create index IX_E7D49132 on pml_district (districtCode, districtName, cityID, description)
go
create index IX_2C6373F1 on pml_district (districtName)
go

create index IX_7DDBAE38 on pml_do_quan_trong (ten_do_quan_trong)
go

create index IX_D48B8868 on pml_documentreceipt_issuingplace_log (documentReceiptId, processor, step)
go
create index IX_7CF5591A on pml_documentreceipt_issuingplace_log (documentReceiptId, step)
go

create index IX_61702019 on pml_documentreceipt_log (dateprocess)
go
create index IX_F2B17075 on pml_documentreceipt_log (departmentprocess)
go
create index IX_C34DE10 on pml_documentreceipt_log (departmentprocessid)
go
create index IX_5DA377E9 on pml_documentreceipt_log (departmentreceive)
go
create index IX_82C2D884 on pml_documentreceipt_log (departmentreceiveid)
go
create index IX_9AC1A170 on pml_documentreceipt_log (documentreceiptid)
go
create index IX_F13EA49C on pml_documentreceipt_log (documentreceiptid, processer)
go
create index IX_60F6FFCE on pml_documentreceipt_log (documentreceiptid, processer, receivedate, stateprocessidafter)
go
create index IX_51D1F577 on pml_documentreceipt_log (documentreceiptid, processer, stateprocessidafter)
go
create index IX_B32A8F5C on pml_documentreceipt_log (documentreceiptid, processer, step)
go
create index IX_4569DA93 on pml_documentreceipt_log (documentreceiptid, receiver)
go
create index IX_5130EFE0 on pml_documentreceipt_log (documentreceiptid, receiver, stateprocessidafter)
go
create index IX_D3E3577A on pml_documentreceipt_log (documentreceiptid, receiver, stateprocessidafter, transition_)
go
create index IX_402827C on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore)
go
create index IX_BEAAE410 on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore, processer)
go
create index IX_1A7DDC9F on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore, receiver)
go
create index IX_24299D30 on pml_documentreceipt_log (documentreceiptid, step)
go
create index IX_F97BAFEA on pml_documentreceipt_log (documentreceiptid, transition_)
go
create index IX_5BF8A5E2 on pml_documentreceipt_log (documentreceiptid, transition_, processer)
go
create index IX_9F0F4A65 on pml_documentreceipt_log (documentreceiptid, type_)
go
create index IX_1C2DC0EB on pml_documentreceipt_log (expireddate)
go
create index IX_5B3152F7 on pml_documentreceipt_log (maindepartmentprocessid)
go
create index IX_189C629E on pml_documentreceipt_log (mainuserprocessid)
go
create index IX_BE581447 on pml_documentreceipt_log (numdateprocess)
go
create index IX_EB41C334 on pml_documentreceipt_log (processer)
go
create index IX_8A503D37 on pml_documentreceipt_log (processinstanceid)
go
create index IX_1DCAA8B5 on pml_documentreceipt_log (processinstanceid, stateprocessidafter, dateprocess)
go
create index IX_990CD0CE on pml_documentreceipt_log (processinstanceid, stateprocessidbefore, dateprocess)
go
create index IX_C9F630BE on pml_documentreceipt_log (processinstanceid, type_)
go
create index IX_2A554629 on pml_documentreceipt_log (receivedate)
go
create index IX_55BC88FB on pml_documentreceipt_log (receiver)
go
create index IX_DC6AC441 on pml_documentreceipt_log (senddatebefore)
go
create index IX_DF02C5BB on pml_documentreceipt_log (stateprocessidafter)
go
create index IX_1CFAD4E4 on pml_documentreceipt_log (stateprocessidbefore)
go
create index IX_B5D974FD on pml_documentreceipt_log (type_)
go

create index IX_F9949A1 on pml_documentreceipt_wf (documentreceiptid)
go
create index IX_813F3D38 on pml_documentreceipt_wf (documentreceiptid, ismain)
go

create index IX_BF3D5193 on pml_documentsend_log (dateprocess)
go
create index IX_EDDF58A on pml_documentsend_log (departmentprocessid)
go
create index IX_856BEFFE on pml_documentsend_log (departmentreceiveid)
go
create index IX_95446B90 on pml_documentsend_log (documentsendid)
go
create index IX_D42E467C on pml_documentsend_log (documentsendid, processer)
go
create index IX_166629AE on pml_documentsend_log (documentsendid, processer, receivedate, stateprocessidafter)
go
create index IX_B9A43F97 on pml_documentsend_log (documentsendid, processer, stateprocessidafter)
go
create index IX_7B91493C on pml_documentsend_log (documentsendid, processer, step)
go
create index IX_970E7CB3 on pml_documentsend_log (documentsendid, receiver)
go
create index IX_BA24F49C on pml_documentsend_log (documentsendid, stateprocessidbefore)
go
create index IX_825026BF on pml_documentsend_log (documentsendid, stateprocessidbefore, receiver)
go
create index IX_FCB44F50 on pml_documentsend_log (documentsendid, step)
go
create index IX_DF0A59CA on pml_documentsend_log (documentsendid, transition_)
go
create index IX_79FAF265 on pml_documentsend_log (expireddate)
go
create index IX_87E8B88D on pml_documentsend_log (numdateprocess)
go
create index IX_6BC10B2E on pml_documentsend_log (processer)
go
create index IX_9727582F on pml_documentsend_log (processinstanceid, stateprocessidafter, dateprocess)
go
create index IX_4B461094 on pml_documentsend_log (processinstanceid, stateprocessidbefore, dateprocess)
go
create index IX_882277A3 on pml_documentsend_log (receivedate)
go
create index IX_309759C1 on pml_documentsend_log (receiver)
go
create index IX_A5FB6887 on pml_documentsend_log (senddatebefore)
go
create index IX_E1ABDD35 on pml_documentsend_log (stateprocessidafter)
go
create index IX_6F74ACAA on pml_documentsend_log (stateprocessidbefore)
go

create index IX_EF559A19 on pml_documentsend_wf (processid)
go

create index IX_DF61BFE8 on pml_edm_answerdetail (documentsendid)
go

create index IX_9A5F97E6 on pml_edm_attachedfile (attachedfilename)
go
create index IX_9AA1EC3 on pml_edm_attachedfile (datecreated)
go
create index IX_BC68EC12 on pml_edm_attachedfile (fileid)
go
create index IX_59EC5531 on pml_edm_attachedfile (filetype)
go
create index IX_38A173FE on pml_edm_attachedfile (objectcontentid)
go
create index IX_3B07BA2B on pml_edm_attachedfile (objectcontentid, objecttype)
go
create index IX_F431D674 on pml_edm_attachedfile (objecttype)
go
create index IX_45D87F60 on pml_edm_attachedfile (path)
go

create index IX_B6759412 on pml_edm_bookdocumentrecordto (datecomplete)
go
create index IX_AA87ECD5 on pml_edm_bookdocumentrecordto (datecreate)
go
create index IX_3104DFB1 on pml_edm_bookdocumentrecordto (documentreceiptid)
go
create index IX_896B2527 on pml_edm_bookdocumentrecordto (documentreceiptid, documentrecordtoid)
go
create index IX_E6BAE7AD on pml_edm_bookdocumentrecordto (documentrecordtoid)
go

create index IX_C213CCC7 on pml_edm_bookdocumentsend (agencyid)
go
create index IX_6951E23A on pml_edm_bookdocumentsend (agencyid, departmentsid, documentrecordtypeid)
go
create index IX_C2147AA3 on pml_edm_bookdocumentsend (agencyid, yearinuse, documentrecordtypeid)
go
create index IX_B3B1DB27 on pml_edm_bookdocumentsend (currentrecord)
go
create index IX_12A9A257 on pml_edm_bookdocumentsend (datecreated)
go
create index IX_7E34CBD9 on pml_edm_bookdocumentsend (departmentsid)
go
create index IX_DB1A8728 on pml_edm_bookdocumentsend (documentrecordtypeid)
go
create index IX_217A93FC on pml_edm_bookdocumentsend (documentrecordtypeid, agencyid)
go
create index IX_BD633DC4 on pml_edm_bookdocumentsend (documentrecordtypeid, departmentsid)
go
create index IX_5C6A0756 on pml_edm_bookdocumentsend (yearinuse, agencyid)
go
create index IX_D6B7D2AA on pml_edm_bookdocumentsend (yearinuse, departmentsid)
go
create index IX_79A204DF on pml_edm_bookdocumentsend (yearinuse, departmentsid, documentrecordtypeid)
go

create index IX_CE3025EE on pml_edm_cadre (departmentsid)
go
create index IX_EA107351 on pml_edm_cadre (handphone)
go
create index IX_393FE4B6 on pml_edm_cadre (positionid)
go

create index IX_F30AEFD6 on pml_edm_confidentiallevel (confidentiallevelname)
go

create index IX_8A4FDF66 on pml_edm_docconfuser (userId)
go

create index IX_F635B970 on pml_edm_documentdelegate (userIsDelegateId)
go

create index IX_6C706605 on pml_edm_documentreceipt (confidentiallevelid)
go
create index IX_A5806B65 on pml_edm_documentreceipt (docreceipttempid)
go
create index IX_F7702835 on pml_edm_documentreceipt (docreceipttempid, orgexternalid)
go
create index IX_195C7CCB on pml_edm_documentreceipt (documenttype)
go
create index IX_344E2CE6 on pml_edm_documentreceipt (documenttypeid)
go
create index IX_F4D3AF82 on pml_edm_documentreceipt (issuingplaceid)
go
create index IX_44318C15 on pml_edm_documentreceipt (levelsendid)
go
create index IX_5095AB4D on pml_edm_documentreceipt (maindepartmentprocessid)
go
create index IX_A4E73374 on pml_edm_documentreceipt (mainuserprocessid)
go
create index IX_FE328031 on pml_edm_documentreceipt (numberlocaldocumentreceipt)
go
create index IX_1C937938 on pml_edm_documentreceipt (orgexternalid)
go
create index IX_7D644D84 on pml_edm_documentreceipt (privilegelevelid)
go
create index IX_41D2A81C on pml_edm_documentreceipt (socongvandiphucdap)
go
create index IX_FF31DE83 on pml_edm_documentreceipt (statusid)
go

create index IX_8ABCB96A on pml_edm_documentreceipt_temp (confidentiallevelid)
go
create index IX_4B990106 on pml_edm_documentreceipt_temp (documenttype)
go
create index IX_C97A8E61 on pml_edm_documentreceipt_temp (documenttypeid)
go
create index IX_8A0010FD on pml_edm_documentreceipt_temp (issuingplaceid)
go
create index IX_1C86147A on pml_edm_documentreceipt_temp (levelsendid)
go
create index IX_FC432 on pml_edm_documentreceipt_temp (maindepartmentprocessid)
go
create index IX_1C8B1C19 on pml_edm_documentreceipt_temp (mainuserprocessid)
go
create index IX_BA18BC33 on pml_edm_documentreceipt_temp (numberdocumentreceipt, orgexternalid)
go
create index IX_6FC9812C on pml_edm_documentreceipt_temp (numberlocaldocumentreceipt)
go
create index IX_31E77C5D on pml_edm_documentreceipt_temp (orgexternalid)
go
create index IX_78FE3C3F on pml_edm_documentreceipt_temp (privilegelevelid)
go
create index IX_BEABD417 on pml_edm_documentreceipt_temp (socongvandiphucdap)
go
create index IX_FFB7B83E on pml_edm_documentreceipt_temp (statusid)
go

create index IX_3CFED46C on pml_edm_documentreceiptextend (documentreceiptid)
go

create index IX_26138E35 on pml_edm_documentreceiptprocesstype (documentReceiptId)
go

create index IX_38A6EC62 on pml_edm_documentrecordto (agencyid)
go
create index IX_909AF77F on pml_edm_documentrecordto (agencyid, departmentsid, documentrecordtypeid)
go
create index IX_59EE8497 on pml_edm_documentrecordto (agencyid, documentrecordtypeid)
go
create index IX_84DCFA68 on pml_edm_documentrecordto (agencyid, yearinuse, documentrecordtypeid)
go
create index IX_4FB9446C on pml_edm_documentrecordto (currentrecord)
go
create index IX_E515482C on pml_edm_documentrecordto (datecreate)
go
create index IX_1A3C351E on pml_edm_documentrecordto (departmentsid)
go
create index IX_544C1643 on pml_edm_documentrecordto (documentrecordtypeid)
go
create index IX_5643D57 on pml_edm_documentrecordto (documentrecordtypeid, agencyid)
go
create index IX_E1643549 on pml_edm_documentrecordto (documentrecordtypeid, departmentsid)
go
create index IX_62D856C7 on pml_edm_documentrecordto (yearinuse)
go
create index IX_478CA8DB on pml_edm_documentrecordto (yearinuse, agencyid)
go
create index IX_30065C45 on pml_edm_documentrecordto (yearinuse, departmentsid)
go
create index IX_3B7B983A on pml_edm_documentrecordto (yearinuse, departmentsid, documentrecordtypeid)
go

create index IX_ACE905D4 on pml_edm_documentrecordtype (documentrecordtypecode)
go
create index IX_BEED22F2 on pml_edm_documentrecordtype (documentrecordtypename)
go


create index IX_96281CBD on pml_edm_documentsend (confidentiallevelid)
go
create index IX_7FB46F6 on pml_edm_documentsend (documentreference)
go
create index IX_ABCFC10E on pml_edm_documentsend (documentsendcode)
go
create index IX_665D232E on pml_edm_documentsend (documenttypeid)
go
create index IX_609C46C6 on pml_edm_documentsend (editorid)
go
create index IX_1D01FC6A on pml_edm_documentsend (issuingdate)
go
create index IX_348309D6 on pml_edm_documentsend (numberpage)
go
create index IX_1C0C48C on pml_edm_documentsend (numberpublish)
go
create index IX_FD2899F0 on pml_edm_documentsend (orgexternalid)
go
create index IX_E564F13C on pml_edm_documentsend (position_)
go
create index IX_678ED1CC on pml_edm_documentsend (privilegelevelid)
go
create index IX_F6373734 on pml_edm_documentsend (senddate)
go
create index IX_83BE6E03 on pml_edm_documentsend (signerid)
go
create index IX_965879F3 on pml_edm_documentsend (signername)
go
create index IX_CC292ACB on pml_edm_documentsend (statusid)
go

create index IX_FC3F0EF1 on pml_edm_documenttype (documentrecordtypeid)
go
create index IX_189CF563 on pml_edm_documenttype (documentsymbol)
go
create index IX_2DA48310 on pml_edm_documenttype (documenttypename)
go
create index IX_CA49CA8C on pml_edm_documenttype (sendreceiptdistinction)
go

create index IX_7506C14C on pml_edm_issuingplace (address)
go
create index IX_E2A13874 on pml_edm_issuingplace (email)
go
create index IX_D322EF77 on pml_edm_issuingplace (handphone)
go
create index IX_51947C2A on pml_edm_issuingplace (issuingplacecode)
go
create index IX_63989948 on pml_edm_issuingplace (issuingplacename)
go
create index IX_40E6F8AC on pml_edm_issuingplace (tablephone)
go

create index IX_6B1386B8 on pml_edm_levelsend (levelsendcode)
go
create index IX_7D17A3D6 on pml_edm_levelsend (levelsendname)
go

create index IX_96C78722 on pml_edm_levelsenddetail (issuingPlaceId)
go
create index IX_A510EC75 on pml_edm_levelsenddetail (levelsendid)
go
create index IX_6FFCD535 on pml_edm_levelsenddetail (levelsendid, issuingPlaceId)
go

create index IX_55886F8C on pml_edm_privilegelevel (privilegelevelname)
go

create index IX_707D1D62 on pml_edm_processdocumentreceiptdetail (documentreceiptid)
go
create index IX_F222C540 on pml_edm_processdocumentreceiptdetail (userid)
go

create index IX_F963C762 on pml_edm_writedocumentsend (bookdocumentsendid)
go
create index IX_438BB903 on pml_edm_writedocumentsend (datecreated)
go
create index IX_34A68AF9 on pml_edm_writedocumentsend (documentsendid)
go

create index IX_15C023FC on pml_field (departmentsId)
go
create index IX_4483E71C on pml_field (description)
go
create index IX_C99E25E7 on pml_field (fieldCode)
go
create index IX_4D7208CE on pml_field (fieldCode, fieldName)
go
create index IX_DBA24305 on pml_field (fieldName)
go

create index IX_596B556B on pml_file (applicantName)
go
create index IX_D45EFE9C on pml_file (applicationDate)
go
create index IX_4D50D500 on pml_file (authorisedLetter)
go
create index IX_A972ABD8 on pml_file (dateCreated)
go
create index IX_5351F437 on pml_file (fileTypeId)
go
create index IX_5F9DE377 on pml_file (fileTypeId, applicationDate)
go
create index IX_E3AD19AC on pml_file (fileTypeId, exactReturningDate)
go
create index IX_A4791A88 on pml_file (fileTypeId, numberReceipt)
go
create index IX_B02ADD59 on pml_file (organization)
go
create index IX_38EB14CC on pml_file (permanentAddress)
go

create index IX_61D51B08 on pml_file_attachedfile (attachedFileId)
go
create index IX_4977F9B8 on pml_file_attachedfile (attachedFileName)
go
create index IX_56516844 on pml_file_attachedfile (fileId)
go

create index IX_71CC95A4 on pml_file_pccc (applicantcategory)
go
create index IX_41FD1EE7 on pml_file_pccc (fileName)
go
create index IX_F0267148 on pml_file_pccc (projectname)
go
create index IX_AACDDDA2 on pml_file_pccc (receiveofunit)
go

create index IX_84D37C45 on pml_filepccc_attachedfile (attachedfilename)
go
create index IX_2D22BB04 on pml_filepccc_attachedfile (datecreated)
go
create index IX_582E144 on pml_filepccc_attachedfile (filepcccid)
go
create index IX_C0016E71 on pml_filepccc_attachedfile (filepcccid, objecttype)
go
create index IX_665E0890 on pml_filepccc_attachedfile (filetype)
go
create index IX_AB042E13 on pml_filepccc_attachedfile (objecttype)
go
create index IX_40B0BA3F on pml_filepccc_attachedfile (path)
go

create index IX_1D541E7E on pml_filereturninginfo (billnumber)
go
create index IX_6C028719 on pml_filereturninginfo (conclude)
go
create index IX_18347992 on pml_filereturninginfo (documentnumber)
go
create index IX_31A6CC45 on pml_filereturninginfo (fileid)
go
create index IX_674A1FCA on pml_filereturninginfo (fileid, filereturninginfoid)
go
create index IX_E90EDEDF on pml_filereturninginfo (filesender)
go
create index IX_415DBCEB on pml_filereturninginfo (issuingdatelicense)
go
create index IX_870F0CC0 on pml_filereturninginfo (licensenumber)
go
create index IX_62C25CE0 on pml_filereturninginfo (note)
go
create index IX_CA4BAECD on pml_filereturninginfo (numbermoney)
go
create index IX_4B4BAA1A on pml_filereturninginfo (receivelicensedate)
go

create index IX_5935E6C8 on pml_filestatus (description)
go
create index IX_22A22EF3 on pml_filestatus (filestatuscode)
go
create index IX_267CE161 on pml_filestatus (filestatuscode, type)
go
create index IX_34A64C11 on pml_filestatus (filestatusname)
go
create index IX_8037DA92 on pml_filestatus (type)
go

create index IX_1AB3D3C2 on pml_filestatus_stateprocess (filestatusid)
go
create index IX_CC0394F on pml_filestatus_stateprocess (filestatusid, stateprocessid)
go
create index IX_46DF2252 on pml_filestatus_stateprocess (stateprocessid)
go

create index IX_A0F11380 on pml_filetype (description)
go
create index IX_894651F9 on pml_filetype (fieldId)
go
create index IX_38394B43 on pml_filetype (fileTypeCode)
go
create index IX_BF4F1638 on pml_filetype (fileTypeCode, fileTypeName)
go
create index IX_4A3D6861 on pml_filetype (fileTypeName)
go
create index IX_BDCA23D6 on pml_filetype (receiptTemplate)
go

create index IX_3F989A8E on pml_filetype_attachedfile (attachedFileId)
go
create index IX_C459AFBE on pml_filetype_attachedfile (attachedFileName)
go
create index IX_685D30A4 on pml_filetype_attachedfile (attachedFileName, note)
go
create index IX_8EEEF5BD on pml_filetype_attachedfile (attachedFileName, original, copy_, note)
go
create index IX_16CE77B on pml_filetype_attachedfile (copy_)
go
create index IX_1D1C5FC0 on pml_filetype_attachedfile (copy_, fileTypeId)
go
create index IX_A8123DA4 on pml_filetype_attachedfile (fileTypeId)
go
create index IX_C87FFF85 on pml_filetype_attachedfile (note)
go
create index IX_7969B8CA on pml_filetype_attachedfile (note, fileTypeId)
go
create index IX_96238524 on pml_filetype_attachedfile (original)
go
create index IX_204EC7E9 on pml_filetype_attachedfile (original, fileTypeId)
go

create index IX_EEEA49C5 on pml_filetypedelegate (delegateid)
go
create index IX_8711D276 on pml_filetypedelegate (filetypeid)
go
create index IX_4F36494A on pml_filetypedelegate (filetypeid, delegateid)
go

create index IX_22B22256 on pml_ho_so_cong_viec (id_do_quan_trong)
go
create index IX_4B004359 on pml_ho_so_cong_viec (id_hscv_cha)
go
create index IX_E4A110BA on pml_ho_so_cong_viec (id_linh_vuc)
go
create index IX_3583860E on pml_ho_so_cong_viec (id_tinh_chat)
go
create index IX_F5AC1C84 on pml_ho_so_cong_viec (id_trang_thai_hscv)
go
create index IX_6641DAF3 on pml_ho_so_cong_viec (so_hieu_hscv)
go
create index IX_8CAC1550 on pml_ho_so_cong_viec (userId)
go

create index IX_6FE7F965 on pml_holiday (from_date)
go
create index IX_DA2F71DD on pml_holiday (from_date, to_date)
go
create index IX_BE96F7E3 on pml_holiday (holiday_type)
go
create index IX_B000EB7 on pml_holiday (holiday_type, holiday_value)
go
create index IX_54EFF34C on pml_holiday (holiday_value)
go
create index IX_AC2C1974 on pml_holiday (to_date)
go

create index IX_B6A8CE01 on pml_main_support (processid_main)
go
create index IX_2B8908B4 on pml_main_support (processid_main, type_)
go
create index IX_3DADA2F6 on pml_main_support (supportinfomation)
go
create index IX_B29867F6 on pml_main_support (type_)
go

create index IX_2070F48B on pml_manage_documentworkflow (type_)
go
create index IX_55510545 on pml_manage_documentworkflow (version_)
go
create index IX_56BF56C8 on pml_manage_documentworkflow (workflowname)
go

create index IX_D3C8915E on pml_message_note (createDate)
go
create index IX_3B0D672A on pml_message_note (documentId)
go
create index IX_5187B7B on pml_message_note (documentId, fromUserId, objectType)
go
create index IX_F26FDBA4 on pml_message_note (fromUserId)
go
create index IX_CC62AA2E on pml_message_note (fromUserId, documentId)
go
create index IX_BFE701F5 on pml_message_note (toUserId)
go

create index IX_9E1C1904 on pml_nation (countryid)
go
create index IX_E7BC0ACF on pml_nation (description)
go
create index IX_7BB3C125 on pml_nation (nationcode)
go
create index IX_AD004521 on pml_nation (nationcode, nationname, description)
go
create index IX_B64C62E0 on pml_nation (nationcode, nationname, description, countryid)
go
create index IX_8DB7DE43 on pml_nation (nationname)
go

create index IX_DC4571BF on pml_organization_external (orgexternalcode)
go
create index IX_EE498EDD on pml_organization_external (orgexternalname)
go

create index IX_1A4A0D1A on pml_paintdocument (fileid)
go
create index IX_9AF230CE on pml_paintdocument (quantity)
go

create index IX_F9124CAD on pml_position (description)
go
create index IX_C722BFA9 on pml_position (positioncode)
go
create index IX_40E870BB on pml_position (positioncode, positionname, description)
go
create index IX_D926DCC7 on pml_position (positionname)
go

create index IX_16BA87EB on pml_processdispose (dateprocess)
go
create index IX_5A6F9F0A on pml_processdispose (delegateuser)
go
create index IX_D17828BD on pml_processdispose (expireddate)
go
create index IX_86178411 on pml_processdispose (fileid)
go
create index IX_ACA8C122 on pml_processdispose (fileid, stateprocessidafter)
go
create index IX_414465D on pml_processdispose (fileid, stateprocessidbefore)
go
create index IX_B8C0DAE9 on pml_processdispose (fileid, transition_)
go
create index IX_947F786 on pml_processdispose (processer)
go
create index IX_DF9FADFB on pml_processdispose (receivedate)
go
create index IX_DAD58269 on pml_processdispose (receiver)
go
create index IX_73C1DF0 on pml_processdispose (senddate)
go
create index IX_D3193B8D on pml_processdispose (stateprocessidafter)
go
create index IX_ABB31952 on pml_processdispose (stateprocessidbefore)
go
create index IX_347BF054 on pml_processdispose (transition_)
go

create index IX_6740CD8E on pml_processtype (flagprocesstype)
go
create index IX_6F02DFE on pml_processtype (name)
go

create index IX_8189A9C0 on pml_role (description)
go
create index IX_3EA90583 on pml_role (rolecode)
go
create index IX_5A584BB4 on pml_role (rolecode, rolename, description)
go
create index IX_50AD22A1 on pml_role (rolename)
go

create index IX_5B7B5B20 on pml_room_resource (companyId)
go
create index IX_9C76B966 on pml_room_resource (roomName, companyId)
go

create index IX_7C75D901 on pml_saveprocesstype (docId)
go
create index IX_2F8EFE4B on pml_saveprocesstype (flagprocesstype)
go

create index IX_4BE268DA on pml_signer (userId)
go

create index IX_D9BC27D7 on pml_state_department (departmentid)
go
create index IX_D57677B5 on pml_state_department (statewfid)
go

create index IX_923D54E6 on pml_state_wf (solvingtime)
go
create index IX_E95EB980 on pml_state_wf (stateprocessid)
go
create index IX_DDD4126 on pml_state_wf (workflow)
go
create index IX_FFD4EEAE on pml_state_wf (workflow, stateprocessid, version_)
go
create index IX_83F19D61 on pml_state_wf (workflow, version_)
go

create index IX_9225FC78 on pml_stateprocess (description)
go
create index IX_7608CFF1 on pml_stateprocess (filestatusid)
go
create index IX_75268613 on pml_stateprocess (stateprocesscode)
go
create index IX_D2E7C250 on pml_stateprocess (stateprocesscode, stateprocessname)
go
create index IX_872AA331 on pml_stateprocess (stateprocessname)
go

create index IX_C8F855DB on pml_street (streetName)
go

create index IX_81CDA715 on pml_team (companyid)
go
create index IX_5F105874 on pml_team (departmentid)
go
create index IX_4F4A1B2 on pml_team (departmentid, teamcode)
go
create index IX_F351D895 on pml_team (organizationid)
go
create index IX_8D369D91 on pml_team (teamcode)
go
create index IX_9F3ABAAF on pml_team (teamname)
go

create index IX_8A699036 on pml_teamleader (userid)
go

create index IX_9088E4B1 on pml_template (departmentId)
go

create index IX_723E8560 on pml_template_file (templateId)
go

create index IX_81341A38 on pml_tinh_chat (ten_tinh_chat)
go

create index IX_787D1D78 on pml_trang_thai_hscv (ten_trang_thai_hscv)
go

create index IX_39228010 on pml_transition (filetypeid)
go
create index IX_994CBFCB on pml_transition (filetypeid, version_)
go
create index IX_8BB21315 on pml_transition (notransition)
go
create index IX_20816340 on pml_transition (stateprocesscurrent)
go
create index IX_40267CB0 on pml_transition (stateprocessnext)
go
create index IX_D61160DF on pml_transition (transitionname)
go
create index IX_96AFFA06 on pml_transition (version_)
go

create index IX_4871D6EB on pml_user (departmentsId)
go
create index IX_4A13A6AE on pml_user (handphone)
go
create index IX_8EF417A7 on pml_user (note)
go
create index IX_D9949119 on pml_user (positionId)
go
create index IX_54858438 on pml_user (positionId, departmentsId, roleId)
go
create index IX_3439E366 on pml_user (roleId)
go
create index IX_E0B7E5AD on pml_user (teamid)
go

create index IX_25F95C64 on pml_user_file_type (filetypeid)
go
create index IX_82420779 on pml_user_file_type (userid)
go

create index IX_E695A0FF on pml_wards (description)
go
create index IX_A171A34A on pml_wards (districtId)
go
create index IX_D65D0747 on pml_wards (wardsCode)
go
create index IX_139E1304 on pml_wards (wardsCode, wardsName, districtId, description)
go
create index IX_E8612465 on pml_wards (wardsName)
go

create index IX_6F3C858B on pml_wf_onedoor (nodeId)
go
create index IX_30AE8040 on pml_wf_onedoor (processId)
go

create index IX_4C98D3A on pml_workflow (fileTypeId)
go
create index IX_5BD98D66 on pml_workflow (fileTypeId, startDate)
go
create index IX_4ACCE075 on pml_workflow (fileTypeId, version_)
go
create index IX_77A8AE63 on pml_workflow (workflow, version_)
go


