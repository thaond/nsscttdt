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
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	modifiedDate datetime null,
	folderId decimal(20,0),
	name varchar(255) null,
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

create table BrowserTracker (
	browserTrackerId decimal(20,0) not null primary key,
	userId decimal(20,0),
	browserKey decimal(20,0)
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
	remindBy int,
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
	homeURL varchar(1000) null,
	logoId decimal(20,0),
	system int
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
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	versionUserId decimal(20,0),
	versionUserName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	folderId decimal(20,0),
	name varchar(255) null,
	title varchar(255) null,
	description varchar(1000) null,
	version float,
	size_ int,
	readCount int,
	extraSettings text null
)
go

create table DLFileRank (
	fileRankId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	folderId decimal(20,0),
	name varchar(255) null
)
go

create table DLFileShortcut (
	uuid_ varchar(75) null,
	fileShortcutId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	folderId decimal(20,0),
	toFolderId decimal(20,0),
	toName varchar(255) null
)
go

create table DLFileVersion (
	fileVersionId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	folderId decimal(20,0),
	name varchar(255) null,
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
	companyId decimal(20,0),
	tableId decimal(20,0),
	name varchar(75) null,
	type_ int,
	defaultData varchar(1000) null,
	typeSettings text null
)
go

create table ExpandoRow (
	rowId_ decimal(20,0) not null primary key,
	companyId decimal(20,0),
	tableId decimal(20,0),
	classPK decimal(20,0)
)
go

create table ExpandoTable (
	tableId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	classNameId decimal(20,0),
	name varchar(75) null
)
go

create table ExpandoValue (
	valueId decimal(20,0) not null primary key,
	companyId decimal(20,0),
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
	groupId decimal(20,0),
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

create table InstanceBean (
	processInstanceId decimal(20,0) not null primary key,
	businessProcessId decimal(20,0),
	articleId decimal(20,0),
	categoryId decimal(20,0),
	previousNode varchar(75) null,
	status varchar(75) null,
	createUserId decimal(20,0),
	finish int
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
	urlTitle varchar(150) null,
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
	elInstanceId varchar(75) null,
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

create table JournalProcessDefinition (
	journalProcessDefinitionId decimal(20,0) not null primary key,
	name varchar(75) null,
	version varchar(75) null,
	content varchar(75) null
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
	parentStructureId varchar(75) null,
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
	threadCount int,
	messageCount int,
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

create table MBMailingList (
	uuid_ varchar(75) null,
	mailingListId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	categoryId decimal(20,0),
	emailAddress varchar(75) null,
	inProtocol varchar(75) null,
	inServerName varchar(75) null,
	inServerPort int,
	inUseSSL int,
	inUserName varchar(75) null,
	inPassword varchar(75) null,
	inReadInterval int,
	outEmailAddress varchar(75) null,
	outCustom int,
	outServerName varchar(75) null,
	outServerPort int,
	outUseSSL int,
	outUserName varchar(75) null,
	outPassword varchar(75) null,
	active_ int
)
go

create table MBMessage (
	uuid_ varchar(75) null,
	messageId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	categoryId decimal(20,0),
	threadId decimal(20,0),
	parentMessageId decimal(20,0),
	subject varchar(75) null,
	body text null,
	attachments int,
	anonymous int,
	priority float
)
go

create table MBMessageFlag (
	messageFlagId decimal(20,0) not null primary key,
	userId decimal(20,0),
	modifiedDate datetime null,
	threadId decimal(20,0),
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
	groupId decimal(20,0),
	categoryId decimal(20,0),
	rootMessageId decimal(20,0),
	messageCount int,
	viewCount int,
	lastPostByUserId decimal(20,0),
	lastPostDate datetime null,
	priority float
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
	leftOrganizationId decimal(20,0),
	rightOrganizationId decimal(20,0),
	name varchar(100) null,
	type_ varchar(75) null,
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
	verified int,
	testString varchar(1024) null
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
	primKey varchar(255) null
)
go

create table ResourceAction (
	resourceActionId decimal(20,0) not null primary key,
	name varchar(75) null,
	actionId varchar(75) null,
	bitwiseValue decimal(20,0)
)
go

create table ResourceCode (
	codeId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	name varchar(255) null,
	scope int
)
go

create table ResourcePermission (
	resourcePermissionId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	name varchar(255) null,
	scope int,
	primKey varchar(255) null,
	roleId decimal(20,0),
	actionIds decimal(20,0)
)
go

create table Role_ (
	roleId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	classNameId decimal(20,0),
	classPK decimal(20,0),
	name varchar(75) null,
	title varchar(1000) null,
	description varchar(1000) null,
	type_ int,
	subtype varchar(75) null
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
	tags varchar(255) null,
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

create table Shard (
	shardId decimal(20,0) not null primary key,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	name varchar(75) null
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
	visible int,
	startDate datetime null,
	endDate datetime null,
	publishDate datetime null,
	expirationDate datetime null,
	mimeType varchar(75) null,
	title varchar(255) null,
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
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	parentEntryId decimal(20,0),
	name varchar(75) null,
	vocabularyId decimal(20,0)
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
	value varchar(255) null
)
go

create table TagsSource (
	sourceId decimal(20,0) not null primary key,
	parentSourceId decimal(20,0),
	name varchar(75) null,
	acronym varchar(75) null
)
go

create table TagsVocabulary (
	vocabularyId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null,
	description varchar(75) null,
	folksonomy int
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
	reminderQueryQuestion varchar(75) null,
	reminderQueryAnswer varchar(75) null,
	graceLoginCount int,
	screenName varchar(75) null,
	emailAddress varchar(75) null,
	openId varchar(1024) null,
	portraitId decimal(20,0),
	languageId varchar(75) null,
	timeZoneId varchar(75) null,
	greeting varchar(255) null,
	comments varchar(1000) null,
	firstName varchar(75) null,
	middleName varchar(75) null,
	lastName varchar(75) null,
	jobTitle varchar(75) null,
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
	userGroupId decimal(20,0) not null,
	userId decimal(20,0) not null,
	primary key (userGroupId, userId)
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

create table Vocabulary (
	vocabularyId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null,
	description varchar(75) null,
	folksonomy int
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
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	nodeId decimal(20,0),
	title varchar(255) null,
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

create table instancebean (
	processInstanceId decimal(20,0) not null primary key,
	businessProcessId decimal(20,0),
	articleId decimal(20,0),
	categoryId decimal(20,0),
	previousNode varchar(75) null,
	status varchar(75) null,
	createUserId decimal(20,0),
	finish int
)
go

create table log_workflow_journal_article (
	logWorkflowJournalArticleId decimal(20,0) not null primary key,
	resourcePrimkey decimal(20,0),
	transition int,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userIds varchar(75) null,
	dateReceiptOfUserReceipt datetime null,
	dateProcessOfUserReceipt datetime null,
	dateSendOfUserReceipt datetime null,
	useridProcess decimal(20,0),
	userIdsProcess varchar(75) null,
	processInformation varchar(75) null,
	workflowStatusBefore varchar(75) null,
	workflowStatusAfter varchar(75) null
)
go

create table nss_certificate (
	userId decimal(20,0) not null primary key,
	x509Certificate varchar(75) null
)
go

create table nss_contact_book (
	contactBookId decimal(20,0) not null primary key,
	contactBookCode varchar(75) null,
	contactBookName varchar(75) null,
	contactDescription varchar(75) null,
	contactActive int,
	companyid decimal(20,0),
	userid decimal(20,0)
)
go

create table nss_detail_book (
	detailBookId decimal(20,0) not null primary key,
	detailBookCode varchar(75) null,
	detailBookName varchar(75) null,
	detailDescription varchar(75) null,
	detailActive int,
	zip varchar(75) null,
	internal_ varchar(75) null,
	home varchar(75) null,
	mobile varchar(75) null,
	contactBookId decimal(20,0),
	companyid decimal(20,0),
	userid decimal(20,0)
)
go

create table nss_image_signer (
	imageSignerId decimal(20,0) not null primary key,
	imageIdSign decimal(20,0),
	imageIdUnSign decimal(20,0),
	userId decimal(20,0)
)
go

create table nss_quan_ly_quy_trinh_duyet_tin (
	managementWorkflowJournalId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	processDefinitionId decimal(20,0),
	workflowname varchar(75) null,
	version_ int,
	description varchar(75) null,
	dateFrom datetime null,
	dateTo datetime null
)
go

create table nss_signature (
	signatureId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	articlePrimKey decimal(20,0),
	articleId varchar(75) null,
	version float,
	signData varchar(75) null
)
go

create table nss_workflow_journal_article (
	workflowJournalArticleId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userIds varchar(75) null,
	processDefinitionId decimal(20,0),
	processInstanceId decimal(20,0),
	resourcePrimkey decimal(20,0),
	countImageOfArticle int,
	datecomplete datetime null,
	statuscurrent varchar(75) null
)
go

create table processdefinition (
	journalProcessDefinitionId decimal(20,0) not null primary key,
	name varchar(75) null,
	version varchar(75) null,
	content varchar(75) null
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

insert into Region (regionId, countryId, regionCode, name, active_) values (1001, 1, 'AB', 'Alberta', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1002, 1, 'BC', 'British Columbia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1003, 1, 'MB', 'Manitoba', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1004, 1, 'NB', 'New Brunswick', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1005, 1, 'NL', 'Newfoundland and Labrador', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1006, 1, 'NT', 'Northwest Territories', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1007, 1, 'NS', 'Nova Scotia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1008, 1, 'NU', 'Nunavut', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1009, 1, 'ON', 'Ontario', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1010, 1, 'PE', 'Prince Edward Island', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1011, 1, 'QC', 'Quebec', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1012, 1, 'SK', 'Saskatchewan', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (1013, 1, 'YT', 'Yukon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3001, 3, 'A', 'Alsace', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3002, 3, 'B', 'Aquitaine', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3003, 3, 'C', 'Auvergne', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3004, 3, 'P', 'Basse-Normandie', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3005, 3, 'D', 'Bourgogne', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3006, 3, 'E', 'Bretagne', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3007, 3, 'F', 'Centre', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3008, 3, 'G', 'Champagne-Ardenne', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3009, 3, 'H', 'Corse', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3010, 3, 'GF', 'Guyane', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3011, 3, 'I', 'Franche Comté', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3012, 3, 'GP', 'Guadeloupe', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3013, 3, 'Q', 'Haute-Normandie', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3014, 3, 'J', 'Île-de-France', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3015, 3, 'K', 'Languedoc-Roussillon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3016, 3, 'L', 'Limousin', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3017, 3, 'M', 'Lorraine', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3018, 3, 'MQ', 'Martinique', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3019, 3, 'N', 'Midi-Pyrénées', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3020, 3, 'O', 'Nord Pas de Calais', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3021, 3, 'R', 'Pays de la Loire', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3022, 3, 'S', 'Picardie', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3023, 3, 'T', 'Poitou-Charentes', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3024, 3, 'U', 'Provence-Alpes-Côte-d''Azur', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3025, 3, 'RE', 'Réunion', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (3026, 3, 'V', 'Rhône-Alpes', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4001, 4, 'BW', 'Baden-Württemberg', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4002, 4, 'BY', 'Bayern', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4003, 4, 'BE', 'Berlin', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4004, 4, 'BR', 'Brandenburg', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4005, 4, 'HB', 'Bremen', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4006, 4, 'HH', 'Hamburg', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4007, 4, 'HE', 'Hessen', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4008, 4, 'MV', 'Mecklenburg-Vorpommern', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4009, 4, 'NI', 'Niedersachsen', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4010, 4, 'NW', 'Nordrhein-Westfalen', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4011, 4, 'RP', 'Rheinland-Pfalz', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4012, 4, 'SL', 'Saarland', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4013, 4, 'SN', 'Sachsen', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4014, 4, 'ST', 'Sachsen-Anhalt', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4015, 4, 'SH', 'Schleswig-Holstein', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (4016, 4, 'TH', 'Thüringen', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8001, 8, 'AG', 'Agrigento', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8002, 8, 'AL', 'Alessandria', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8003, 8, 'AN', 'Ancona', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8004, 8, 'AO', 'Aosta', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8005, 8, 'AR', 'Arezzo', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8006, 8, 'AP', 'Ascoli Piceno', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8007, 8, 'AT', 'Asti', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8008, 8, 'AV', 'Avellino', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8009, 8, 'BA', 'Bari', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8010, 8, 'BT', 'Barletta-Andria-Trani', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8011, 8, 'BL', 'Belluno', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8012, 8, 'BN', 'Benevento', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8013, 8, 'BG', 'Bergamo', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8014, 8, 'BI', 'Biella', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8015, 8, 'BO', 'Bologna', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8016, 8, 'BZ', 'Bolzano', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8017, 8, 'BS', 'Brescia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8018, 8, 'BR', 'Brindisi', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8019, 8, 'CA', 'Cagliari', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8020, 8, 'CL', 'Caltanissetta', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8021, 8, 'CB', 'Campobasso', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8022, 8, 'CI', 'Carbonia-Iglesias', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8023, 8, 'CE', 'Caserta', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8024, 8, 'CT', 'Catania', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8025, 8, 'CZ', 'Catanzaro', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8026, 8, 'CH', 'Chieti', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8027, 8, 'CO', 'Como', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8028, 8, 'CS', 'Cosenza', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8029, 8, 'CR', 'Cremona', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8030, 8, 'KR', 'Crotone', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8031, 8, 'CN', 'Cuneo', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8032, 8, 'EN', 'Enna', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8033, 8, 'FM', 'Fermo', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8034, 8, 'FE', 'Ferrara', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8035, 8, 'FI', 'Firenze', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8036, 8, 'FG', 'Foggia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8037, 8, 'FC', 'Forli-Cesena', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8038, 8, 'FR', 'Frosinone', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8039, 8, 'GE', 'Genova', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8040, 8, 'GO', 'Gorizia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8041, 8, 'GR', 'Grosseto', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8042, 8, 'IM', 'Imperia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8043, 8, 'IS', 'Isernia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8044, 8, 'AQ', 'L''Aquila', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8045, 8, 'SP', 'La Spezia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8046, 8, 'LT', 'Latina', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8047, 8, 'LE', 'Lecce', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8048, 8, 'LC', 'Lecco', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8049, 8, 'LI', 'Livorno', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8050, 8, 'LO', 'Lodi', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8051, 8, 'LU', 'Lucca', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8052, 8, 'MC', 'Macerata', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8053, 8, 'MN', 'Mantova', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8054, 8, 'MS', 'Massa-Carrara', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8055, 8, 'MT', 'Matera', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8056, 8, 'MA', 'Medio Campidano', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8057, 8, 'ME', 'Messina', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8058, 8, 'MI', 'Milano', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8059, 8, 'MO', 'Modena', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8060, 8, 'MZ', 'Monza', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8061, 8, 'NA', 'Napoli', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8062, 8, 'NO', 'Novara', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8063, 8, 'NU', 'Nuoro', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8064, 8, 'OG', 'Ogliastra', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8065, 8, 'OT', 'Olbia-Tempio', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8066, 8, 'OR', 'Oristano', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8067, 8, 'PD', 'Padova', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8068, 8, 'PA', 'Palermo', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8069, 8, 'PR', 'Parma', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8070, 8, 'PV', 'Pavia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8071, 8, 'PG', 'Perugia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8072, 8, 'PU', 'Pesaro e Urbino', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8073, 8, 'PE', 'Pescara', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8074, 8, 'PC', 'Piacenza', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8075, 8, 'PI', 'Pisa', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8076, 8, 'PT', 'Pistoia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8077, 8, 'PN', 'Pordenone', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8078, 8, 'PZ', 'Potenza', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8079, 8, 'PO', 'Prato', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8080, 8, 'RG', 'Ragusa', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8081, 8, 'RA', 'Ravenna', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8082, 8, 'RC', 'Reggio Calabria', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8083, 8, 'RE', 'Reggio Emilia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8084, 8, 'RI', 'Rieti', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8085, 8, 'RN', 'Rimini', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8086, 8, 'RM', 'Roma', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8087, 8, 'RO', 'Rovigo', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8088, 8, 'SA', 'Salerno', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8089, 8, 'SS', 'Sassari', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8090, 8, 'SV', 'Savona', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8091, 8, 'SI', 'Siena', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8092, 8, 'SR', 'Siracusa', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8093, 8, 'SO', 'Sondrio', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8094, 8, 'TA', 'Taranto', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8095, 8, 'TE', 'Teramo', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8096, 8, 'TR', 'Terni', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8097, 8, 'TO', 'Torino', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8098, 8, 'TP', 'Trapani', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8099, 8, 'TN', 'Trento', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8100, 8, 'TV', 'Treviso', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8101, 8, 'TS', 'Trieste', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8102, 8, 'UD', 'Udine', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8103, 8, 'VA', 'Varese', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8104, 8, 'VE', 'Venezia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8105, 8, 'VB', 'Verbano-Cusio-Ossola', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8106, 8, 'VC', 'Vercelli', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8107, 8, 'VR', 'Verona', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8108, 8, 'VV', 'Vibo Valentia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8109, 8, 'VI', 'Vicenza', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (8110, 8, 'VT', 'Viterbo', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15001, 15, 'AN', 'Andalusia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15002, 15, 'AR', 'Aragon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15003, 15, 'AS', 'Asturias', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15004, 15, 'IB', 'Balearic Islands', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15005, 15, 'PV', 'Basque Country', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15006, 15, 'CN', 'Canary Islands', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15007, 15, 'CB', 'Cantabria', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15008, 15, 'CL', 'Castile and Leon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15009, 15, 'CM', 'Castile-La Mancha', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15010, 15, 'CT', 'Catalonia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15011, 15, 'CE', 'Ceuta', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15012, 15, 'EX', 'Extremadura', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15013, 15, 'GA', 'Galicia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15014, 15, 'LO', 'La Rioja', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15015, 15, 'M', 'Madrid', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15016, 15, 'ML', 'Melilla', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15017, 15, 'MU', 'Murcia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15018, 15, 'NA', 'Navarra', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (15019, 15, 'VC', 'Valencia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19001, 19, 'AL', 'Alabama', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19002, 19, 'AK', 'Alaska', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19003, 19, 'AZ', 'Arizona', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19004, 19, 'AR', 'Arkansas', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19005, 19, 'CA', 'California', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19006, 19, 'CO', 'Colorado', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19007, 19, 'CT', 'Connecticut', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19008, 19, 'DC', 'District of Columbia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19009, 19, 'DE', 'Delaware', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19010, 19, 'FL', 'Florida', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19011, 19, 'GA', 'Georgia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19012, 19, 'HI', 'Hawaii', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19013, 19, 'ID', 'Idaho', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19014, 19, 'IL', 'Illinois', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19015, 19, 'IN', 'Indiana', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19016, 19, 'IA', 'Iowa', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19017, 19, 'KS', 'Kansas', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19018, 19, 'KY', 'Kentucky ', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19019, 19, 'LA', 'Louisiana ', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19020, 19, 'ME', 'Maine', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19021, 19, 'MD', 'Maryland', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19022, 19, 'MA', 'Massachusetts', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19023, 19, 'MI', 'Michigan', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19024, 19, 'MN', 'Minnesota', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19025, 19, 'MS', 'Mississippi', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19026, 19, 'MO', 'Missouri', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19027, 19, 'MT', 'Montana', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19028, 19, 'NE', 'Nebraska', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19029, 19, 'NV', 'Nevada', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19030, 19, 'NH', 'New Hampshire', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19031, 19, 'NJ', 'New Jersey', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19032, 19, 'NM', 'New Mexico', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19033, 19, 'NY', 'New York', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19034, 19, 'NC', 'North Carolina', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19035, 19, 'ND', 'North Dakota', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19036, 19, 'OH', 'Ohio', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19037, 19, 'OK', 'Oklahoma ', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19038, 19, 'OR', 'Oregon', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19039, 19, 'PA', 'Pennsylvania', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19040, 19, 'PR', 'Puerto Rico', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19041, 19, 'RI', 'Rhode Island', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19042, 19, 'SC', 'South Carolina', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19043, 19, 'SD', 'South Dakota', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19044, 19, 'TN', 'Tennessee', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19045, 19, 'TX', 'Texas', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19046, 19, 'UT', 'Utah', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19047, 19, 'VT', 'Vermont', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19048, 19, 'VA', 'Virginia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19049, 19, 'WA', 'Washington', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19050, 19, 'WV', 'West Virginia', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19051, 19, 'WI', 'Wisconsin', 1)
go
insert into Region (regionId, countryId, regionCode, name, active_) values (19052, 19, 'WY', 'Wyoming', 1)
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


insert into ClassName_ (classNameId, value) values (8, 'com.liferay.portal.model.Group')
go
insert into ClassName_ (classNameId, value) values (9, 'com.liferay.portal.model.Organization')
go
insert into ClassName_ (classNameId, value) values (10, 'com.liferay.portal.model.Role')
go
insert into ClassName_ (classNameId, value) values (11, 'com.liferay.portal.model.User')
go


insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (12, 1, 10, 12, 'Administrator', '', 1)
go
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (13, 1, 10, 13, 'Guest', '', 1)
go
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (14, 1, 10, 14, 'Power User', '', 1)
go
insert into Role_ (roleId, companyId, classNameId, classPK, name, description, type_) values (15, 1, 10, 15, 'User', '', 1)
go


insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (16, 1, 5, 8, 16, 0, 0, 'Guest', '/guest', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (17, 1, 16, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (18, 1, 16, 0, 0, 'classic', '01', 0)
go


insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (19, 1, 0, 'Liferay, Inc.', 'regular-organization', 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (20, 1, 5, 9, 19, 0, 0, '20', '/20', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (21, 1, 20, 1, 0, 'classic', '01', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (22, 1, 20, 0, 0, 'classic', '01', 1)
go
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (23, 20, 1, 0, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Liferay, Inc. Extranet</name>
</root>', 'portlet', 'layout-template-id=2_columns_ii
column-1=3,
column-2=19,', 0, '/1', 0)
go
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (24, 20, 1, 1, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Liferay, Inc. Intranet</name>
</root>', 'portlet', 'layout-template-id=2_columns_ii
column-1=3,
column-2=19,', 0, '/1', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (25, 1, 19, 'Liferay Engineering', 'regular-organization', 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (26, 1, 5, 9, 25, 0, 0, '26', '/26', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (27, 1, 26, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (28, 1, 26, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (29, 1, 19, 'Liferay Consulting', 'regular-organization', 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (30, 1, 5, 9, 29, 0, 0, '30', '/30', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (31, 1, 30, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (32, 1, 30, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (33, 1, 19, 'Liferay Support', 'regular-organization', 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (34, 1, 5, 9, 33, 0, 0, '34', '/34', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (35, 1, 34, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (36, 1, 34, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (37, 1, 19, 'Liferay Sales', 'regular-organization', 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (38, 1, 5, 9, 37, 0, 0, '38', '/38', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (39, 1, 38, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (40, 1, 38, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (41, 1, 19, 'Liferay Marketing', 'regular-organization', 1, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (42, 1, 5, 9, 41, 0, 0, '42', '/42', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (43, 1, 42, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (44, 1, 42, 0, 0, 'classic', '01', 0)
go


insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (45, 1, 19, 'Liferay Los Angeles', 'location', 0, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (46, 1, 5, 9, 45, 0, 0, '46', '/46', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (47, 1, 46, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (48, 1, 46, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (49, 1, 19, 'Liferay San Francisco', 'location', 0, 5, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (50, 1, 5, 9, 49, 0, 0, '50', '/50', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (51, 1, 50, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (52, 1, 50, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (53, 1, 19, 'Liferay Chicago', 'location', 0, 14, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (54, 1, 5, 9, 53, 0, 0, '54', '/54', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (55, 1, 54, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (56, 1, 54, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (57, 1, 19, 'Liferay New York', 'location', 0, 33, 19, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (58, 1, 5, 9, 57, 0, 0, '58', '/58', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (59, 1, 58, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (60, 1, 58, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (61, 1, 19, 'Liferay Sao Paulo', 'location', 0, 0, 48, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (62, 1, 5, 9, 61, 0, 0, '62', '/62', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (63, 1, 62, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (64, 1, 62, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (65, 1, 19, 'Liferay Frankfurt', 'location', 0, 0, 4, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (66, 1, 5, 9, 65, 0, 0, '66', '/66', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (67, 1, 66, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (68, 1, 66, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (69, 1, 19, 'Liferay Madrid', 'location', 0, 0, 15, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (70, 1, 5, 9, 69, 0, 0, '70', '/70', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (71, 1, 70, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (72, 1, 70, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (73, 1, 19, 'Liferay Dalian', 'location', 0, 0, 2, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (74, 1, 5, 9, 73, 0, 0, '74', '/74', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (75, 1, 74, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (76, 1, 74, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (77, 1, 19, 'Liferay Hong Kong', 'location', 0, 0, 2, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (78, 1, 5, 9, 77, 0, 0, '78', '/78', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (79, 1, 78, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (80, 1, 78, 0, 0, 'classic', '01', 0)
go

insert into Organization_ (organizationId, companyId, parentOrganizationId, name, type_, recursable, regionId, countryId, statusId, comments) values (81, 1, 19, 'Liferay Kuala Lumpur', 'location', 0, 0, 135, 12017, '')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (82, 1, 5, 9, 81, 0, 0, '82', '/82', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (83, 1, 82, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (84, 1, 82, 0, 0, 'classic', '01', 0)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (5, 1, getdate(), getdate(), 1, 6, 'password', 0, 0, '5', 'default@liferay.com', 'Welcome!', '', '', '', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (6, 1, 5, '', getdate(), getdate(), 7, 0, '', '', '', 1, '19700101')
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (2, 1, getdate(), getdate(), 0, 3, 'test', 0, 0, 'joebloggs', 'test@liferay.com', 'Welcome Joe Bloggs!', 'Joe', '', 'Bloggs', getdate(), 0, 0, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (3, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Joe', '', 'Bloggs', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (85, 1, 2, 11, 2, 0, 0, '85', '/85', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (86, 1, 85, 1, 0, 'classic', '01', 2)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (87, 1, 85, 0, 0, 'classic', '01', 0)
go
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (88, 85, 1, 1, 1, 0, '<?xml version="1.0"?>

<root>
  <name>Home</name>
</root>', 'portlet', 'column-1=71_INSTANCE_OY0d,82,23,61,
column-2=9,79,29,8,19,
layout-template-id=2_columns_ii
', 0, '/home', 0)
go
insert into Layout (plid, groupId, companyId, privateLayout, layoutId, parentLayoutId, name, type_, typeSettings, hidden_, friendlyURL, priority) values (89, 85, 1, 1, 2, 0, '<?xml version="1.0"?>

<root>
  <name>Plugins</name>
</root>', 'portlet', 'column-1=
column-2=111,
layout-template-id=2_columns_ii
', 0, '/plugins', 1)
go

insert into Users_Groups values (2, 16)
go

insert into Users_Orgs (userId, organizationId) values (2, 19)
go
insert into Users_Orgs (userId, organizationId) values (2, 45)
go

insert into Users_Roles values (2, 12)
go
insert into Users_Roles values (2, 14)
go
insert into Users_Roles values (2, 15)
go


insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (90, 1, getdate(), getdate(), 0, 91, 'test', 0, 0, 'lax1', 'test.lax.1@liferay.com', 'Welcome Test LAX 1!', 'Test', '', 'LAX 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (91, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (92, 1, 90, 11, 90, 0, 0, '92', '/92', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (93, 1, 92, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (94, 1, 92, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (90, 16)
go

insert into Users_Orgs (userId, organizationId) values (90, 19)
go
insert into Users_Orgs (userId, organizationId) values (90, 45)
go

insert into Users_Roles values (90, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (95, 1, getdate(), getdate(), 0, 96, 'test', 0, 0, 'lax2', 'test.lax.2@liferay.com', 'Welcome Test LAX 2!', 'Test', '', 'LAX 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (96, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (97, 1, 95, 11, 95, 0, 0, '97', '/97', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (98, 1, 97, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (99, 1, 97, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (95, 16)
go

insert into Users_Orgs (userId, organizationId) values (95, 19)
go
insert into Users_Orgs (userId, organizationId) values (95, 45)
go

insert into Users_Roles values (95, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (100, 1, getdate(), getdate(), 0, 101, 'test', 0, 0, 'lax3', 'test.lax.3@liferay.com', 'Welcome Test LAX 3!', 'Test', '', 'LAX 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (101, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (102, 1, 100, 11, 100, 0, 0, '102', '/102', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (103, 1, 102, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (104, 1, 102, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (100, 16)
go

insert into Users_Orgs (userId, organizationId) values (100, 19)
go
insert into Users_Orgs (userId, organizationId) values (100, 45)
go

insert into Users_Roles values (100, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (105, 1, getdate(), getdate(), 0, 106, 'test', 0, 0, 'lax4', 'test.lax.4@liferay.com', 'Welcome Test LAX 4!', 'Test', '', 'LAX 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (106, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (107, 1, 105, 11, 105, 0, 0, '107', '/107', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (108, 1, 107, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (109, 1, 107, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (105, 16)
go

insert into Users_Orgs (userId, organizationId) values (105, 19)
go
insert into Users_Orgs (userId, organizationId) values (105, 45)
go

insert into Users_Roles values (105, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (110, 1, getdate(), getdate(), 0, 111, 'test', 0, 0, 'lax5', 'test.lax.5@liferay.com', 'Welcome Test LAX 5!', 'Test', '', 'LAX 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (111, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (112, 1, 110, 11, 110, 0, 0, '112', '/112', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (113, 1, 112, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (114, 1, 112, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (110, 16)
go

insert into Users_Orgs (userId, organizationId) values (110, 19)
go
insert into Users_Orgs (userId, organizationId) values (110, 45)
go

insert into Users_Roles values (110, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (115, 1, getdate(), getdate(), 0, 116, 'test', 0, 0, 'lax6', 'test.lax.6@liferay.com', 'Welcome Test LAX 6!', 'Test', '', 'LAX 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (116, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (117, 1, 115, 11, 115, 0, 0, '117', '/117', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (118, 1, 117, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (119, 1, 117, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (115, 16)
go

insert into Users_Orgs (userId, organizationId) values (115, 19)
go
insert into Users_Orgs (userId, organizationId) values (115, 45)
go

insert into Users_Roles values (115, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (120, 1, getdate(), getdate(), 0, 121, 'test', 0, 0, 'lax7', 'test.lax.7@liferay.com', 'Welcome Test LAX 7!', 'Test', '', 'LAX 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (121, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (122, 1, 120, 11, 120, 0, 0, '122', '/122', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (123, 1, 122, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (124, 1, 122, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (120, 16)
go

insert into Users_Orgs (userId, organizationId) values (120, 19)
go
insert into Users_Orgs (userId, organizationId) values (120, 45)
go

insert into Users_Roles values (120, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (125, 1, getdate(), getdate(), 0, 126, 'test', 0, 0, 'lax8', 'test.lax.8@liferay.com', 'Welcome Test LAX 8!', 'Test', '', 'LAX 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (126, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (127, 1, 125, 11, 125, 0, 0, '127', '/127', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (128, 1, 127, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (129, 1, 127, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (125, 16)
go

insert into Users_Orgs (userId, organizationId) values (125, 19)
go
insert into Users_Orgs (userId, organizationId) values (125, 45)
go

insert into Users_Roles values (125, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (130, 1, getdate(), getdate(), 0, 131, 'test', 0, 0, 'lax9', 'test.lax.9@liferay.com', 'Welcome Test LAX 9!', 'Test', '', 'LAX 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (131, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (132, 1, 130, 11, 130, 0, 0, '132', '/132', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (133, 1, 132, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (134, 1, 132, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (130, 16)
go

insert into Users_Orgs (userId, organizationId) values (130, 19)
go
insert into Users_Orgs (userId, organizationId) values (130, 45)
go

insert into Users_Roles values (130, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (135, 1, getdate(), getdate(), 0, 136, 'test', 0, 0, 'lax10', 'test.lax.10@liferay.com', 'Welcome Test LAX 10!', 'Test', '', 'LAX 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (136, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (137, 1, 135, 11, 135, 0, 0, '137', '/137', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (138, 1, 137, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (139, 1, 137, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (135, 16)
go

insert into Users_Orgs (userId, organizationId) values (135, 19)
go
insert into Users_Orgs (userId, organizationId) values (135, 45)
go

insert into Users_Roles values (135, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (140, 1, getdate(), getdate(), 0, 141, 'test', 0, 0, 'lax11', 'test.lax.11@liferay.com', 'Welcome Test LAX 11!', 'Test', '', 'LAX 11', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (141, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 11', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (142, 1, 140, 11, 140, 0, 0, '142', '/142', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (143, 1, 142, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (144, 1, 142, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (140, 16)
go

insert into Users_Orgs (userId, organizationId) values (140, 19)
go
insert into Users_Orgs (userId, organizationId) values (140, 45)
go

insert into Users_Roles values (140, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (145, 1, getdate(), getdate(), 0, 146, 'test', 0, 0, 'lax12', 'test.lax.12@liferay.com', 'Welcome Test LAX 12!', 'Test', '', 'LAX 12', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (146, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 12', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (147, 1, 145, 11, 145, 0, 0, '147', '/147', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (148, 1, 147, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (149, 1, 147, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (145, 16)
go

insert into Users_Orgs (userId, organizationId) values (145, 19)
go
insert into Users_Orgs (userId, organizationId) values (145, 45)
go

insert into Users_Roles values (145, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (150, 1, getdate(), getdate(), 0, 151, 'test', 0, 0, 'lax13', 'test.lax.13@liferay.com', 'Welcome Test LAX 13!', 'Test', '', 'LAX 13', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (151, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 13', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (152, 1, 150, 11, 150, 0, 0, '152', '/152', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (153, 1, 152, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (154, 1, 152, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (150, 16)
go

insert into Users_Orgs (userId, organizationId) values (150, 19)
go
insert into Users_Orgs (userId, organizationId) values (150, 45)
go

insert into Users_Roles values (150, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (155, 1, getdate(), getdate(), 0, 156, 'test', 0, 0, 'lax14', 'test.lax.14@liferay.com', 'Welcome Test LAX 14!', 'Test', '', 'LAX 14', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (156, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 14', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (157, 1, 155, 11, 155, 0, 0, '157', '/157', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (158, 1, 157, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (159, 1, 157, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (155, 16)
go

insert into Users_Orgs (userId, organizationId) values (155, 19)
go
insert into Users_Orgs (userId, organizationId) values (155, 45)
go

insert into Users_Roles values (155, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (160, 1, getdate(), getdate(), 0, 161, 'test', 0, 0, 'lax15', 'test.lax.15@liferay.com', 'Welcome Test LAX 15!', 'Test', '', 'LAX 15', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (161, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 15', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (162, 1, 160, 11, 160, 0, 0, '162', '/162', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (163, 1, 162, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (164, 1, 162, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (160, 16)
go

insert into Users_Orgs (userId, organizationId) values (160, 19)
go
insert into Users_Orgs (userId, organizationId) values (160, 45)
go

insert into Users_Roles values (160, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (165, 1, getdate(), getdate(), 0, 166, 'test', 0, 0, 'lax16', 'test.lax.16@liferay.com', 'Welcome Test LAX 16!', 'Test', '', 'LAX 16', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (166, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 16', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (167, 1, 165, 11, 165, 0, 0, '167', '/167', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (168, 1, 167, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (169, 1, 167, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (165, 16)
go

insert into Users_Orgs (userId, organizationId) values (165, 19)
go
insert into Users_Orgs (userId, organizationId) values (165, 45)
go

insert into Users_Roles values (165, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (170, 1, getdate(), getdate(), 0, 171, 'test', 0, 0, 'lax17', 'test.lax.17@liferay.com', 'Welcome Test LAX 17!', 'Test', '', 'LAX 17', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (171, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 17', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (172, 1, 170, 11, 170, 0, 0, '172', '/172', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (173, 1, 172, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (174, 1, 172, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (170, 16)
go

insert into Users_Orgs (userId, organizationId) values (170, 19)
go
insert into Users_Orgs (userId, organizationId) values (170, 45)
go

insert into Users_Roles values (170, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (175, 1, getdate(), getdate(), 0, 176, 'test', 0, 0, 'lax18', 'test.lax.18@liferay.com', 'Welcome Test LAX 18!', 'Test', '', 'LAX 18', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (176, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 18', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (177, 1, 175, 11, 175, 0, 0, '177', '/177', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (178, 1, 177, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (179, 1, 177, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (175, 16)
go

insert into Users_Orgs (userId, organizationId) values (175, 19)
go
insert into Users_Orgs (userId, organizationId) values (175, 45)
go

insert into Users_Roles values (175, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (180, 1, getdate(), getdate(), 0, 181, 'test', 0, 0, 'lax19', 'test.lax.19@liferay.com', 'Welcome Test LAX 19!', 'Test', '', 'LAX 19', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (181, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 19', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (182, 1, 180, 11, 180, 0, 0, '182', '/182', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (183, 1, 182, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (184, 1, 182, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (180, 16)
go

insert into Users_Orgs (userId, organizationId) values (180, 19)
go
insert into Users_Orgs (userId, organizationId) values (180, 45)
go

insert into Users_Roles values (180, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (185, 1, getdate(), getdate(), 0, 186, 'test', 0, 0, 'lax20', 'test.lax.20@liferay.com', 'Welcome Test LAX 20!', 'Test', '', 'LAX 20', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (186, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 20', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (187, 1, 185, 11, 185, 0, 0, '187', '/187', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (188, 1, 187, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (189, 1, 187, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (185, 16)
go

insert into Users_Orgs (userId, organizationId) values (185, 19)
go
insert into Users_Orgs (userId, organizationId) values (185, 45)
go

insert into Users_Roles values (185, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (190, 1, getdate(), getdate(), 0, 191, 'test', 0, 0, 'lax21', 'test.lax.21@liferay.com', 'Welcome Test LAX 21!', 'Test', '', 'LAX 21', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (191, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 21', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (192, 1, 190, 11, 190, 0, 0, '192', '/192', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (193, 1, 192, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (194, 1, 192, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (190, 16)
go

insert into Users_Orgs (userId, organizationId) values (190, 19)
go
insert into Users_Orgs (userId, organizationId) values (190, 45)
go

insert into Users_Roles values (190, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (195, 1, getdate(), getdate(), 0, 196, 'test', 0, 0, 'lax22', 'test.lax.22@liferay.com', 'Welcome Test LAX 22!', 'Test', '', 'LAX 22', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (196, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 22', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (197, 1, 195, 11, 195, 0, 0, '197', '/197', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (198, 1, 197, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (199, 1, 197, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (195, 16)
go

insert into Users_Orgs (userId, organizationId) values (195, 19)
go
insert into Users_Orgs (userId, organizationId) values (195, 45)
go

insert into Users_Roles values (195, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (200, 1, getdate(), getdate(), 0, 201, 'test', 0, 0, 'lax23', 'test.lax.23@liferay.com', 'Welcome Test LAX 23!', 'Test', '', 'LAX 23', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (201, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 23', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (202, 1, 200, 11, 200, 0, 0, '202', '/202', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (203, 1, 202, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (204, 1, 202, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (200, 16)
go

insert into Users_Orgs (userId, organizationId) values (200, 19)
go
insert into Users_Orgs (userId, organizationId) values (200, 45)
go

insert into Users_Roles values (200, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (205, 1, getdate(), getdate(), 0, 206, 'test', 0, 0, 'lax24', 'test.lax.24@liferay.com', 'Welcome Test LAX 24!', 'Test', '', 'LAX 24', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (206, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 24', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (207, 1, 205, 11, 205, 0, 0, '207', '/207', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (208, 1, 207, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (209, 1, 207, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (205, 16)
go

insert into Users_Orgs (userId, organizationId) values (205, 19)
go
insert into Users_Orgs (userId, organizationId) values (205, 45)
go

insert into Users_Roles values (205, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (210, 1, getdate(), getdate(), 0, 211, 'test', 0, 0, 'lax25', 'test.lax.25@liferay.com', 'Welcome Test LAX 25!', 'Test', '', 'LAX 25', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (211, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 25', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (212, 1, 210, 11, 210, 0, 0, '212', '/212', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (213, 1, 212, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (214, 1, 212, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (210, 16)
go

insert into Users_Orgs (userId, organizationId) values (210, 19)
go
insert into Users_Orgs (userId, organizationId) values (210, 45)
go

insert into Users_Roles values (210, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (215, 1, getdate(), getdate(), 0, 216, 'test', 0, 0, 'lax26', 'test.lax.26@liferay.com', 'Welcome Test LAX 26!', 'Test', '', 'LAX 26', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (216, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 26', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (217, 1, 215, 11, 215, 0, 0, '217', '/217', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (218, 1, 217, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (219, 1, 217, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (215, 16)
go

insert into Users_Orgs (userId, organizationId) values (215, 19)
go
insert into Users_Orgs (userId, organizationId) values (215, 45)
go

insert into Users_Roles values (215, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (220, 1, getdate(), getdate(), 0, 221, 'test', 0, 0, 'lax27', 'test.lax.27@liferay.com', 'Welcome Test LAX 27!', 'Test', '', 'LAX 27', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (221, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 27', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (222, 1, 220, 11, 220, 0, 0, '222', '/222', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (223, 1, 222, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (224, 1, 222, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (220, 16)
go

insert into Users_Orgs (userId, organizationId) values (220, 19)
go
insert into Users_Orgs (userId, organizationId) values (220, 45)
go

insert into Users_Roles values (220, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (225, 1, getdate(), getdate(), 0, 226, 'test', 0, 0, 'lax28', 'test.lax.28@liferay.com', 'Welcome Test LAX 28!', 'Test', '', 'LAX 28', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (226, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 28', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (227, 1, 225, 11, 225, 0, 0, '227', '/227', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (228, 1, 227, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (229, 1, 227, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (225, 16)
go

insert into Users_Orgs (userId, organizationId) values (225, 19)
go
insert into Users_Orgs (userId, organizationId) values (225, 45)
go

insert into Users_Roles values (225, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (230, 1, getdate(), getdate(), 0, 231, 'test', 0, 0, 'lax29', 'test.lax.29@liferay.com', 'Welcome Test LAX 29!', 'Test', '', 'LAX 29', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (231, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 29', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (232, 1, 230, 11, 230, 0, 0, '232', '/232', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (233, 1, 232, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (234, 1, 232, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (230, 16)
go

insert into Users_Orgs (userId, organizationId) values (230, 19)
go
insert into Users_Orgs (userId, organizationId) values (230, 45)
go

insert into Users_Roles values (230, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (235, 1, getdate(), getdate(), 0, 236, 'test', 0, 0, 'lax30', 'test.lax.30@liferay.com', 'Welcome Test LAX 30!', 'Test', '', 'LAX 30', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (236, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 30', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (237, 1, 235, 11, 235, 0, 0, '237', '/237', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (238, 1, 237, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (239, 1, 237, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (235, 16)
go

insert into Users_Orgs (userId, organizationId) values (235, 19)
go
insert into Users_Orgs (userId, organizationId) values (235, 45)
go

insert into Users_Roles values (235, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (240, 1, getdate(), getdate(), 0, 241, 'test', 0, 0, 'lax31', 'test.lax.31@liferay.com', 'Welcome Test LAX 31!', 'Test', '', 'LAX 31', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (241, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 31', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (242, 1, 240, 11, 240, 0, 0, '242', '/242', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (243, 1, 242, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (244, 1, 242, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (240, 16)
go

insert into Users_Orgs (userId, organizationId) values (240, 19)
go
insert into Users_Orgs (userId, organizationId) values (240, 45)
go

insert into Users_Roles values (240, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (245, 1, getdate(), getdate(), 0, 246, 'test', 0, 0, 'lax32', 'test.lax.32@liferay.com', 'Welcome Test LAX 32!', 'Test', '', 'LAX 32', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (246, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 32', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (247, 1, 245, 11, 245, 0, 0, '247', '/247', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (248, 1, 247, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (249, 1, 247, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (245, 16)
go

insert into Users_Orgs (userId, organizationId) values (245, 19)
go
insert into Users_Orgs (userId, organizationId) values (245, 45)
go

insert into Users_Roles values (245, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (250, 1, getdate(), getdate(), 0, 251, 'test', 0, 0, 'lax33', 'test.lax.33@liferay.com', 'Welcome Test LAX 33!', 'Test', '', 'LAX 33', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (251, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 33', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (252, 1, 250, 11, 250, 0, 0, '252', '/252', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (253, 1, 252, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (254, 1, 252, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (250, 16)
go

insert into Users_Orgs (userId, organizationId) values (250, 19)
go
insert into Users_Orgs (userId, organizationId) values (250, 45)
go

insert into Users_Roles values (250, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (255, 1, getdate(), getdate(), 0, 256, 'test', 0, 0, 'lax34', 'test.lax.34@liferay.com', 'Welcome Test LAX 34!', 'Test', '', 'LAX 34', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (256, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 34', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (257, 1, 255, 11, 255, 0, 0, '257', '/257', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (258, 1, 257, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (259, 1, 257, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (255, 16)
go

insert into Users_Orgs (userId, organizationId) values (255, 19)
go
insert into Users_Orgs (userId, organizationId) values (255, 45)
go

insert into Users_Roles values (255, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (260, 1, getdate(), getdate(), 0, 261, 'test', 0, 0, 'lax35', 'test.lax.35@liferay.com', 'Welcome Test LAX 35!', 'Test', '', 'LAX 35', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (261, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 35', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (262, 1, 260, 11, 260, 0, 0, '262', '/262', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (263, 1, 262, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (264, 1, 262, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (260, 16)
go

insert into Users_Orgs (userId, organizationId) values (260, 19)
go
insert into Users_Orgs (userId, organizationId) values (260, 45)
go

insert into Users_Roles values (260, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (265, 1, getdate(), getdate(), 0, 266, 'test', 0, 0, 'lax36', 'test.lax.36@liferay.com', 'Welcome Test LAX 36!', 'Test', '', 'LAX 36', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (266, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 36', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (267, 1, 265, 11, 265, 0, 0, '267', '/267', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (268, 1, 267, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (269, 1, 267, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (265, 16)
go

insert into Users_Orgs (userId, organizationId) values (265, 19)
go
insert into Users_Orgs (userId, organizationId) values (265, 45)
go

insert into Users_Roles values (265, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (270, 1, getdate(), getdate(), 0, 271, 'test', 0, 0, 'lax37', 'test.lax.37@liferay.com', 'Welcome Test LAX 37!', 'Test', '', 'LAX 37', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (271, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 37', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (272, 1, 270, 11, 270, 0, 0, '272', '/272', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (273, 1, 272, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (274, 1, 272, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (270, 16)
go

insert into Users_Orgs (userId, organizationId) values (270, 19)
go
insert into Users_Orgs (userId, organizationId) values (270, 45)
go

insert into Users_Roles values (270, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (275, 1, getdate(), getdate(), 0, 276, 'test', 0, 0, 'lax38', 'test.lax.38@liferay.com', 'Welcome Test LAX 38!', 'Test', '', 'LAX 38', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (276, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 38', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (277, 1, 275, 11, 275, 0, 0, '277', '/277', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (278, 1, 277, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (279, 1, 277, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (275, 16)
go

insert into Users_Orgs (userId, organizationId) values (275, 19)
go
insert into Users_Orgs (userId, organizationId) values (275, 45)
go

insert into Users_Roles values (275, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (280, 1, getdate(), getdate(), 0, 281, 'test', 0, 0, 'lax39', 'test.lax.39@liferay.com', 'Welcome Test LAX 39!', 'Test', '', 'LAX 39', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (281, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 39', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (282, 1, 280, 11, 280, 0, 0, '282', '/282', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (283, 1, 282, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (284, 1, 282, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (280, 16)
go

insert into Users_Orgs (userId, organizationId) values (280, 19)
go
insert into Users_Orgs (userId, organizationId) values (280, 45)
go

insert into Users_Roles values (280, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (285, 1, getdate(), getdate(), 0, 286, 'test', 0, 0, 'lax40', 'test.lax.40@liferay.com', 'Welcome Test LAX 40!', 'Test', '', 'LAX 40', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (286, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 40', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (287, 1, 285, 11, 285, 0, 0, '287', '/287', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (288, 1, 287, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (289, 1, 287, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (285, 16)
go

insert into Users_Orgs (userId, organizationId) values (285, 19)
go
insert into Users_Orgs (userId, organizationId) values (285, 45)
go

insert into Users_Roles values (285, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (290, 1, getdate(), getdate(), 0, 291, 'test', 0, 0, 'lax41', 'test.lax.41@liferay.com', 'Welcome Test LAX 41!', 'Test', '', 'LAX 41', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (291, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 41', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (292, 1, 290, 11, 290, 0, 0, '292', '/292', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (293, 1, 292, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (294, 1, 292, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (290, 16)
go

insert into Users_Orgs (userId, organizationId) values (290, 19)
go
insert into Users_Orgs (userId, organizationId) values (290, 45)
go

insert into Users_Roles values (290, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (295, 1, getdate(), getdate(), 0, 296, 'test', 0, 0, 'lax42', 'test.lax.42@liferay.com', 'Welcome Test LAX 42!', 'Test', '', 'LAX 42', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (296, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 42', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (297, 1, 295, 11, 295, 0, 0, '297', '/297', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (298, 1, 297, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (299, 1, 297, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (295, 16)
go

insert into Users_Orgs (userId, organizationId) values (295, 19)
go
insert into Users_Orgs (userId, organizationId) values (295, 45)
go

insert into Users_Roles values (295, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (300, 1, getdate(), getdate(), 0, 301, 'test', 0, 0, 'lax43', 'test.lax.43@liferay.com', 'Welcome Test LAX 43!', 'Test', '', 'LAX 43', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (301, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 43', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (302, 1, 300, 11, 300, 0, 0, '302', '/302', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (303, 1, 302, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (304, 1, 302, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (300, 16)
go

insert into Users_Orgs (userId, organizationId) values (300, 19)
go
insert into Users_Orgs (userId, organizationId) values (300, 45)
go

insert into Users_Roles values (300, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (305, 1, getdate(), getdate(), 0, 306, 'test', 0, 0, 'lax44', 'test.lax.44@liferay.com', 'Welcome Test LAX 44!', 'Test', '', 'LAX 44', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (306, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 44', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (307, 1, 305, 11, 305, 0, 0, '307', '/307', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (308, 1, 307, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (309, 1, 307, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (305, 16)
go

insert into Users_Orgs (userId, organizationId) values (305, 19)
go
insert into Users_Orgs (userId, organizationId) values (305, 45)
go

insert into Users_Roles values (305, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (310, 1, getdate(), getdate(), 0, 311, 'test', 0, 0, 'lax45', 'test.lax.45@liferay.com', 'Welcome Test LAX 45!', 'Test', '', 'LAX 45', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (311, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 45', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (312, 1, 310, 11, 310, 0, 0, '312', '/312', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (313, 1, 312, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (314, 1, 312, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (310, 16)
go

insert into Users_Orgs (userId, organizationId) values (310, 19)
go
insert into Users_Orgs (userId, organizationId) values (310, 45)
go

insert into Users_Roles values (310, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (315, 1, getdate(), getdate(), 0, 316, 'test', 0, 0, 'lax46', 'test.lax.46@liferay.com', 'Welcome Test LAX 46!', 'Test', '', 'LAX 46', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (316, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 46', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (317, 1, 315, 11, 315, 0, 0, '317', '/317', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (318, 1, 317, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (319, 1, 317, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (315, 16)
go

insert into Users_Orgs (userId, organizationId) values (315, 19)
go
insert into Users_Orgs (userId, organizationId) values (315, 45)
go

insert into Users_Roles values (315, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (320, 1, getdate(), getdate(), 0, 321, 'test', 0, 0, 'lax47', 'test.lax.47@liferay.com', 'Welcome Test LAX 47!', 'Test', '', 'LAX 47', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (321, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 47', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (322, 1, 320, 11, 320, 0, 0, '322', '/322', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (323, 1, 322, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (324, 1, 322, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (320, 16)
go

insert into Users_Orgs (userId, organizationId) values (320, 19)
go
insert into Users_Orgs (userId, organizationId) values (320, 45)
go

insert into Users_Roles values (320, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (325, 1, getdate(), getdate(), 0, 326, 'test', 0, 0, 'lax48', 'test.lax.48@liferay.com', 'Welcome Test LAX 48!', 'Test', '', 'LAX 48', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (326, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 48', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (327, 1, 325, 11, 325, 0, 0, '327', '/327', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (328, 1, 327, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (329, 1, 327, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (325, 16)
go

insert into Users_Orgs (userId, organizationId) values (325, 19)
go
insert into Users_Orgs (userId, organizationId) values (325, 45)
go

insert into Users_Roles values (325, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (330, 1, getdate(), getdate(), 0, 331, 'test', 0, 0, 'lax49', 'test.lax.49@liferay.com', 'Welcome Test LAX 49!', 'Test', '', 'LAX 49', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (331, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 49', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (332, 1, 330, 11, 330, 0, 0, '332', '/332', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (333, 1, 332, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (334, 1, 332, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (330, 16)
go

insert into Users_Orgs (userId, organizationId) values (330, 19)
go
insert into Users_Orgs (userId, organizationId) values (330, 45)
go

insert into Users_Roles values (330, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (335, 1, getdate(), getdate(), 0, 336, 'test', 0, 0, 'lax50', 'test.lax.50@liferay.com', 'Welcome Test LAX 50!', 'Test', '', 'LAX 50', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (336, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 50', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (337, 1, 335, 11, 335, 0, 0, '337', '/337', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (338, 1, 337, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (339, 1, 337, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (335, 16)
go

insert into Users_Orgs (userId, organizationId) values (335, 19)
go
insert into Users_Orgs (userId, organizationId) values (335, 45)
go

insert into Users_Roles values (335, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (340, 1, getdate(), getdate(), 0, 341, 'test', 0, 0, 'lax51', 'test.lax.51@liferay.com', 'Welcome Test LAX 51!', 'Test', '', 'LAX 51', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (341, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 51', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (342, 1, 340, 11, 340, 0, 0, '342', '/342', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (343, 1, 342, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (344, 1, 342, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (340, 16)
go

insert into Users_Orgs (userId, organizationId) values (340, 19)
go
insert into Users_Orgs (userId, organizationId) values (340, 45)
go

insert into Users_Roles values (340, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (345, 1, getdate(), getdate(), 0, 346, 'test', 0, 0, 'lax52', 'test.lax.52@liferay.com', 'Welcome Test LAX 52!', 'Test', '', 'LAX 52', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (346, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 52', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (347, 1, 345, 11, 345, 0, 0, '347', '/347', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (348, 1, 347, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (349, 1, 347, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (345, 16)
go

insert into Users_Orgs (userId, organizationId) values (345, 19)
go
insert into Users_Orgs (userId, organizationId) values (345, 45)
go

insert into Users_Roles values (345, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (350, 1, getdate(), getdate(), 0, 351, 'test', 0, 0, 'lax53', 'test.lax.53@liferay.com', 'Welcome Test LAX 53!', 'Test', '', 'LAX 53', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (351, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 53', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (352, 1, 350, 11, 350, 0, 0, '352', '/352', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (353, 1, 352, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (354, 1, 352, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (350, 16)
go

insert into Users_Orgs (userId, organizationId) values (350, 19)
go
insert into Users_Orgs (userId, organizationId) values (350, 45)
go

insert into Users_Roles values (350, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (355, 1, getdate(), getdate(), 0, 356, 'test', 0, 0, 'lax54', 'test.lax.54@liferay.com', 'Welcome Test LAX 54!', 'Test', '', 'LAX 54', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (356, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 54', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (357, 1, 355, 11, 355, 0, 0, '357', '/357', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (358, 1, 357, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (359, 1, 357, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (355, 16)
go

insert into Users_Orgs (userId, organizationId) values (355, 19)
go
insert into Users_Orgs (userId, organizationId) values (355, 45)
go

insert into Users_Roles values (355, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (360, 1, getdate(), getdate(), 0, 361, 'test', 0, 0, 'lax55', 'test.lax.55@liferay.com', 'Welcome Test LAX 55!', 'Test', '', 'LAX 55', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (361, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 55', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (362, 1, 360, 11, 360, 0, 0, '362', '/362', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (363, 1, 362, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (364, 1, 362, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (360, 16)
go

insert into Users_Orgs (userId, organizationId) values (360, 19)
go
insert into Users_Orgs (userId, organizationId) values (360, 45)
go

insert into Users_Roles values (360, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (365, 1, getdate(), getdate(), 0, 366, 'test', 0, 0, 'lax56', 'test.lax.56@liferay.com', 'Welcome Test LAX 56!', 'Test', '', 'LAX 56', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (366, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 56', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (367, 1, 365, 11, 365, 0, 0, '367', '/367', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (368, 1, 367, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (369, 1, 367, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (365, 16)
go

insert into Users_Orgs (userId, organizationId) values (365, 19)
go
insert into Users_Orgs (userId, organizationId) values (365, 45)
go

insert into Users_Roles values (365, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (370, 1, getdate(), getdate(), 0, 371, 'test', 0, 0, 'lax57', 'test.lax.57@liferay.com', 'Welcome Test LAX 57!', 'Test', '', 'LAX 57', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (371, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 57', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (372, 1, 370, 11, 370, 0, 0, '372', '/372', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (373, 1, 372, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (374, 1, 372, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (370, 16)
go

insert into Users_Orgs (userId, organizationId) values (370, 19)
go
insert into Users_Orgs (userId, organizationId) values (370, 45)
go

insert into Users_Roles values (370, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (375, 1, getdate(), getdate(), 0, 376, 'test', 0, 0, 'lax58', 'test.lax.58@liferay.com', 'Welcome Test LAX 58!', 'Test', '', 'LAX 58', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (376, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 58', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (377, 1, 375, 11, 375, 0, 0, '377', '/377', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (378, 1, 377, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (379, 1, 377, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (375, 16)
go

insert into Users_Orgs (userId, organizationId) values (375, 19)
go
insert into Users_Orgs (userId, organizationId) values (375, 45)
go

insert into Users_Roles values (375, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (380, 1, getdate(), getdate(), 0, 381, 'test', 0, 0, 'lax59', 'test.lax.59@liferay.com', 'Welcome Test LAX 59!', 'Test', '', 'LAX 59', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (381, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 59', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (382, 1, 380, 11, 380, 0, 0, '382', '/382', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (383, 1, 382, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (384, 1, 382, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (380, 16)
go

insert into Users_Orgs (userId, organizationId) values (380, 19)
go
insert into Users_Orgs (userId, organizationId) values (380, 45)
go

insert into Users_Roles values (380, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (385, 1, getdate(), getdate(), 0, 386, 'test', 0, 0, 'lax60', 'test.lax.60@liferay.com', 'Welcome Test LAX 60!', 'Test', '', 'LAX 60', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (386, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 60', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (387, 1, 385, 11, 385, 0, 0, '387', '/387', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (388, 1, 387, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (389, 1, 387, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (385, 16)
go

insert into Users_Orgs (userId, organizationId) values (385, 19)
go
insert into Users_Orgs (userId, organizationId) values (385, 45)
go

insert into Users_Roles values (385, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (390, 1, getdate(), getdate(), 0, 391, 'test', 0, 0, 'lax61', 'test.lax.61@liferay.com', 'Welcome Test LAX 61!', 'Test', '', 'LAX 61', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (391, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 61', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (392, 1, 390, 11, 390, 0, 0, '392', '/392', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (393, 1, 392, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (394, 1, 392, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (390, 16)
go

insert into Users_Orgs (userId, organizationId) values (390, 19)
go
insert into Users_Orgs (userId, organizationId) values (390, 45)
go

insert into Users_Roles values (390, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (395, 1, getdate(), getdate(), 0, 396, 'test', 0, 0, 'lax62', 'test.lax.62@liferay.com', 'Welcome Test LAX 62!', 'Test', '', 'LAX 62', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (396, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 62', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (397, 1, 395, 11, 395, 0, 0, '397', '/397', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (398, 1, 397, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (399, 1, 397, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (395, 16)
go

insert into Users_Orgs (userId, organizationId) values (395, 19)
go
insert into Users_Orgs (userId, organizationId) values (395, 45)
go

insert into Users_Roles values (395, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (400, 1, getdate(), getdate(), 0, 401, 'test', 0, 0, 'lax63', 'test.lax.63@liferay.com', 'Welcome Test LAX 63!', 'Test', '', 'LAX 63', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (401, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 63', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (402, 1, 400, 11, 400, 0, 0, '402', '/402', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (403, 1, 402, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (404, 1, 402, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (400, 16)
go

insert into Users_Orgs (userId, organizationId) values (400, 19)
go
insert into Users_Orgs (userId, organizationId) values (400, 45)
go

insert into Users_Roles values (400, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (405, 1, getdate(), getdate(), 0, 406, 'test', 0, 0, 'lax64', 'test.lax.64@liferay.com', 'Welcome Test LAX 64!', 'Test', '', 'LAX 64', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (406, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 64', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (407, 1, 405, 11, 405, 0, 0, '407', '/407', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (408, 1, 407, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (409, 1, 407, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (405, 16)
go

insert into Users_Orgs (userId, organizationId) values (405, 19)
go
insert into Users_Orgs (userId, organizationId) values (405, 45)
go

insert into Users_Roles values (405, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (410, 1, getdate(), getdate(), 0, 411, 'test', 0, 0, 'lax65', 'test.lax.65@liferay.com', 'Welcome Test LAX 65!', 'Test', '', 'LAX 65', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (411, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 65', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (412, 1, 410, 11, 410, 0, 0, '412', '/412', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (413, 1, 412, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (414, 1, 412, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (410, 16)
go

insert into Users_Orgs (userId, organizationId) values (410, 19)
go
insert into Users_Orgs (userId, organizationId) values (410, 45)
go

insert into Users_Roles values (410, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (415, 1, getdate(), getdate(), 0, 416, 'test', 0, 0, 'lax66', 'test.lax.66@liferay.com', 'Welcome Test LAX 66!', 'Test', '', 'LAX 66', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (416, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 66', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (417, 1, 415, 11, 415, 0, 0, '417', '/417', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (418, 1, 417, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (419, 1, 417, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (415, 16)
go

insert into Users_Orgs (userId, organizationId) values (415, 19)
go
insert into Users_Orgs (userId, organizationId) values (415, 45)
go

insert into Users_Roles values (415, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (420, 1, getdate(), getdate(), 0, 421, 'test', 0, 0, 'lax67', 'test.lax.67@liferay.com', 'Welcome Test LAX 67!', 'Test', '', 'LAX 67', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (421, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 67', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (422, 1, 420, 11, 420, 0, 0, '422', '/422', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (423, 1, 422, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (424, 1, 422, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (420, 16)
go

insert into Users_Orgs (userId, organizationId) values (420, 19)
go
insert into Users_Orgs (userId, organizationId) values (420, 45)
go

insert into Users_Roles values (420, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (425, 1, getdate(), getdate(), 0, 426, 'test', 0, 0, 'lax68', 'test.lax.68@liferay.com', 'Welcome Test LAX 68!', 'Test', '', 'LAX 68', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (426, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 68', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (427, 1, 425, 11, 425, 0, 0, '427', '/427', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (428, 1, 427, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (429, 1, 427, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (425, 16)
go

insert into Users_Orgs (userId, organizationId) values (425, 19)
go
insert into Users_Orgs (userId, organizationId) values (425, 45)
go

insert into Users_Roles values (425, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (430, 1, getdate(), getdate(), 0, 431, 'test', 0, 0, 'lax69', 'test.lax.69@liferay.com', 'Welcome Test LAX 69!', 'Test', '', 'LAX 69', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (431, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 69', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (432, 1, 430, 11, 430, 0, 0, '432', '/432', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (433, 1, 432, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (434, 1, 432, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (430, 16)
go

insert into Users_Orgs (userId, organizationId) values (430, 19)
go
insert into Users_Orgs (userId, organizationId) values (430, 45)
go

insert into Users_Roles values (430, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (435, 1, getdate(), getdate(), 0, 436, 'test', 0, 0, 'lax70', 'test.lax.70@liferay.com', 'Welcome Test LAX 70!', 'Test', '', 'LAX 70', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (436, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 70', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (437, 1, 435, 11, 435, 0, 0, '437', '/437', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (438, 1, 437, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (439, 1, 437, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (435, 16)
go

insert into Users_Orgs (userId, organizationId) values (435, 19)
go
insert into Users_Orgs (userId, organizationId) values (435, 45)
go

insert into Users_Roles values (435, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (440, 1, getdate(), getdate(), 0, 441, 'test', 0, 0, 'lax71', 'test.lax.71@liferay.com', 'Welcome Test LAX 71!', 'Test', '', 'LAX 71', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (441, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 71', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (442, 1, 440, 11, 440, 0, 0, '442', '/442', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (443, 1, 442, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (444, 1, 442, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (440, 16)
go

insert into Users_Orgs (userId, organizationId) values (440, 19)
go
insert into Users_Orgs (userId, organizationId) values (440, 45)
go

insert into Users_Roles values (440, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (445, 1, getdate(), getdate(), 0, 446, 'test', 0, 0, 'lax72', 'test.lax.72@liferay.com', 'Welcome Test LAX 72!', 'Test', '', 'LAX 72', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (446, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 72', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (447, 1, 445, 11, 445, 0, 0, '447', '/447', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (448, 1, 447, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (449, 1, 447, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (445, 16)
go

insert into Users_Orgs (userId, organizationId) values (445, 19)
go
insert into Users_Orgs (userId, organizationId) values (445, 45)
go

insert into Users_Roles values (445, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (450, 1, getdate(), getdate(), 0, 451, 'test', 0, 0, 'lax73', 'test.lax.73@liferay.com', 'Welcome Test LAX 73!', 'Test', '', 'LAX 73', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (451, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 73', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (452, 1, 450, 11, 450, 0, 0, '452', '/452', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (453, 1, 452, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (454, 1, 452, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (450, 16)
go

insert into Users_Orgs (userId, organizationId) values (450, 19)
go
insert into Users_Orgs (userId, organizationId) values (450, 45)
go

insert into Users_Roles values (450, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (455, 1, getdate(), getdate(), 0, 456, 'test', 0, 0, 'lax74', 'test.lax.74@liferay.com', 'Welcome Test LAX 74!', 'Test', '', 'LAX 74', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (456, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 74', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (457, 1, 455, 11, 455, 0, 0, '457', '/457', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (458, 1, 457, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (459, 1, 457, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (455, 16)
go

insert into Users_Orgs (userId, organizationId) values (455, 19)
go
insert into Users_Orgs (userId, organizationId) values (455, 45)
go

insert into Users_Roles values (455, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (460, 1, getdate(), getdate(), 0, 461, 'test', 0, 0, 'lax75', 'test.lax.75@liferay.com', 'Welcome Test LAX 75!', 'Test', '', 'LAX 75', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (461, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 75', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (462, 1, 460, 11, 460, 0, 0, '462', '/462', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (463, 1, 462, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (464, 1, 462, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (460, 16)
go

insert into Users_Orgs (userId, organizationId) values (460, 19)
go
insert into Users_Orgs (userId, organizationId) values (460, 45)
go

insert into Users_Roles values (460, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (465, 1, getdate(), getdate(), 0, 466, 'test', 0, 0, 'lax76', 'test.lax.76@liferay.com', 'Welcome Test LAX 76!', 'Test', '', 'LAX 76', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (466, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 76', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (467, 1, 465, 11, 465, 0, 0, '467', '/467', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (468, 1, 467, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (469, 1, 467, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (465, 16)
go

insert into Users_Orgs (userId, organizationId) values (465, 19)
go
insert into Users_Orgs (userId, organizationId) values (465, 45)
go

insert into Users_Roles values (465, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (470, 1, getdate(), getdate(), 0, 471, 'test', 0, 0, 'lax77', 'test.lax.77@liferay.com', 'Welcome Test LAX 77!', 'Test', '', 'LAX 77', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (471, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 77', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (472, 1, 470, 11, 470, 0, 0, '472', '/472', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (473, 1, 472, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (474, 1, 472, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (470, 16)
go

insert into Users_Orgs (userId, organizationId) values (470, 19)
go
insert into Users_Orgs (userId, organizationId) values (470, 45)
go

insert into Users_Roles values (470, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (475, 1, getdate(), getdate(), 0, 476, 'test', 0, 0, 'lax78', 'test.lax.78@liferay.com', 'Welcome Test LAX 78!', 'Test', '', 'LAX 78', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (476, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 78', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (477, 1, 475, 11, 475, 0, 0, '477', '/477', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (478, 1, 477, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (479, 1, 477, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (475, 16)
go

insert into Users_Orgs (userId, organizationId) values (475, 19)
go
insert into Users_Orgs (userId, organizationId) values (475, 45)
go

insert into Users_Roles values (475, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (480, 1, getdate(), getdate(), 0, 481, 'test', 0, 0, 'lax79', 'test.lax.79@liferay.com', 'Welcome Test LAX 79!', 'Test', '', 'LAX 79', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (481, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 79', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (482, 1, 480, 11, 480, 0, 0, '482', '/482', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (483, 1, 482, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (484, 1, 482, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (480, 16)
go

insert into Users_Orgs (userId, organizationId) values (480, 19)
go
insert into Users_Orgs (userId, organizationId) values (480, 45)
go

insert into Users_Roles values (480, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (485, 1, getdate(), getdate(), 0, 486, 'test', 0, 0, 'lax80', 'test.lax.80@liferay.com', 'Welcome Test LAX 80!', 'Test', '', 'LAX 80', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (486, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 80', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (487, 1, 485, 11, 485, 0, 0, '487', '/487', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (488, 1, 487, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (489, 1, 487, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (485, 16)
go

insert into Users_Orgs (userId, organizationId) values (485, 19)
go
insert into Users_Orgs (userId, organizationId) values (485, 45)
go

insert into Users_Roles values (485, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (490, 1, getdate(), getdate(), 0, 491, 'test', 0, 0, 'lax81', 'test.lax.81@liferay.com', 'Welcome Test LAX 81!', 'Test', '', 'LAX 81', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (491, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 81', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (492, 1, 490, 11, 490, 0, 0, '492', '/492', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (493, 1, 492, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (494, 1, 492, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (490, 16)
go

insert into Users_Orgs (userId, organizationId) values (490, 19)
go
insert into Users_Orgs (userId, organizationId) values (490, 45)
go

insert into Users_Roles values (490, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (495, 1, getdate(), getdate(), 0, 496, 'test', 0, 0, 'lax82', 'test.lax.82@liferay.com', 'Welcome Test LAX 82!', 'Test', '', 'LAX 82', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (496, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 82', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (497, 1, 495, 11, 495, 0, 0, '497', '/497', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (498, 1, 497, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (499, 1, 497, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (495, 16)
go

insert into Users_Orgs (userId, organizationId) values (495, 19)
go
insert into Users_Orgs (userId, organizationId) values (495, 45)
go

insert into Users_Roles values (495, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (500, 1, getdate(), getdate(), 0, 501, 'test', 0, 0, 'lax83', 'test.lax.83@liferay.com', 'Welcome Test LAX 83!', 'Test', '', 'LAX 83', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (501, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 83', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (502, 1, 500, 11, 500, 0, 0, '502', '/502', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (503, 1, 502, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (504, 1, 502, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (500, 16)
go

insert into Users_Orgs (userId, organizationId) values (500, 19)
go
insert into Users_Orgs (userId, organizationId) values (500, 45)
go

insert into Users_Roles values (500, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (505, 1, getdate(), getdate(), 0, 506, 'test', 0, 0, 'lax84', 'test.lax.84@liferay.com', 'Welcome Test LAX 84!', 'Test', '', 'LAX 84', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (506, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 84', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (507, 1, 505, 11, 505, 0, 0, '507', '/507', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (508, 1, 507, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (509, 1, 507, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (505, 16)
go

insert into Users_Orgs (userId, organizationId) values (505, 19)
go
insert into Users_Orgs (userId, organizationId) values (505, 45)
go

insert into Users_Roles values (505, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (510, 1, getdate(), getdate(), 0, 511, 'test', 0, 0, 'lax85', 'test.lax.85@liferay.com', 'Welcome Test LAX 85!', 'Test', '', 'LAX 85', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (511, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 85', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (512, 1, 510, 11, 510, 0, 0, '512', '/512', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (513, 1, 512, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (514, 1, 512, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (510, 16)
go

insert into Users_Orgs (userId, organizationId) values (510, 19)
go
insert into Users_Orgs (userId, organizationId) values (510, 45)
go

insert into Users_Roles values (510, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (515, 1, getdate(), getdate(), 0, 516, 'test', 0, 0, 'lax86', 'test.lax.86@liferay.com', 'Welcome Test LAX 86!', 'Test', '', 'LAX 86', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (516, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 86', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (517, 1, 515, 11, 515, 0, 0, '517', '/517', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (518, 1, 517, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (519, 1, 517, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (515, 16)
go

insert into Users_Orgs (userId, organizationId) values (515, 19)
go
insert into Users_Orgs (userId, organizationId) values (515, 45)
go

insert into Users_Roles values (515, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (520, 1, getdate(), getdate(), 0, 521, 'test', 0, 0, 'lax87', 'test.lax.87@liferay.com', 'Welcome Test LAX 87!', 'Test', '', 'LAX 87', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (521, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 87', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (522, 1, 520, 11, 520, 0, 0, '522', '/522', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (523, 1, 522, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (524, 1, 522, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (520, 16)
go

insert into Users_Orgs (userId, organizationId) values (520, 19)
go
insert into Users_Orgs (userId, organizationId) values (520, 45)
go

insert into Users_Roles values (520, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (525, 1, getdate(), getdate(), 0, 526, 'test', 0, 0, 'lax88', 'test.lax.88@liferay.com', 'Welcome Test LAX 88!', 'Test', '', 'LAX 88', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (526, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 88', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (527, 1, 525, 11, 525, 0, 0, '527', '/527', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (528, 1, 527, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (529, 1, 527, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (525, 16)
go

insert into Users_Orgs (userId, organizationId) values (525, 19)
go
insert into Users_Orgs (userId, organizationId) values (525, 45)
go

insert into Users_Roles values (525, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (530, 1, getdate(), getdate(), 0, 531, 'test', 0, 0, 'lax89', 'test.lax.89@liferay.com', 'Welcome Test LAX 89!', 'Test', '', 'LAX 89', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (531, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 89', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (532, 1, 530, 11, 530, 0, 0, '532', '/532', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (533, 1, 532, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (534, 1, 532, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (530, 16)
go

insert into Users_Orgs (userId, organizationId) values (530, 19)
go
insert into Users_Orgs (userId, organizationId) values (530, 45)
go

insert into Users_Roles values (530, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (535, 1, getdate(), getdate(), 0, 536, 'test', 0, 0, 'lax90', 'test.lax.90@liferay.com', 'Welcome Test LAX 90!', 'Test', '', 'LAX 90', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (536, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 90', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (537, 1, 535, 11, 535, 0, 0, '537', '/537', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (538, 1, 537, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (539, 1, 537, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (535, 16)
go

insert into Users_Orgs (userId, organizationId) values (535, 19)
go
insert into Users_Orgs (userId, organizationId) values (535, 45)
go

insert into Users_Roles values (535, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (540, 1, getdate(), getdate(), 0, 541, 'test', 0, 0, 'lax91', 'test.lax.91@liferay.com', 'Welcome Test LAX 91!', 'Test', '', 'LAX 91', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (541, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 91', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (542, 1, 540, 11, 540, 0, 0, '542', '/542', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (543, 1, 542, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (544, 1, 542, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (540, 16)
go

insert into Users_Orgs (userId, organizationId) values (540, 19)
go
insert into Users_Orgs (userId, organizationId) values (540, 45)
go

insert into Users_Roles values (540, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (545, 1, getdate(), getdate(), 0, 546, 'test', 0, 0, 'lax92', 'test.lax.92@liferay.com', 'Welcome Test LAX 92!', 'Test', '', 'LAX 92', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (546, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 92', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (547, 1, 545, 11, 545, 0, 0, '547', '/547', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (548, 1, 547, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (549, 1, 547, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (545, 16)
go

insert into Users_Orgs (userId, organizationId) values (545, 19)
go
insert into Users_Orgs (userId, organizationId) values (545, 45)
go

insert into Users_Roles values (545, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (550, 1, getdate(), getdate(), 0, 551, 'test', 0, 0, 'lax93', 'test.lax.93@liferay.com', 'Welcome Test LAX 93!', 'Test', '', 'LAX 93', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (551, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 93', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (552, 1, 550, 11, 550, 0, 0, '552', '/552', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (553, 1, 552, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (554, 1, 552, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (550, 16)
go

insert into Users_Orgs (userId, organizationId) values (550, 19)
go
insert into Users_Orgs (userId, organizationId) values (550, 45)
go

insert into Users_Roles values (550, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (555, 1, getdate(), getdate(), 0, 556, 'test', 0, 0, 'lax94', 'test.lax.94@liferay.com', 'Welcome Test LAX 94!', 'Test', '', 'LAX 94', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (556, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 94', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (557, 1, 555, 11, 555, 0, 0, '557', '/557', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (558, 1, 557, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (559, 1, 557, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (555, 16)
go

insert into Users_Orgs (userId, organizationId) values (555, 19)
go
insert into Users_Orgs (userId, organizationId) values (555, 45)
go

insert into Users_Roles values (555, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (560, 1, getdate(), getdate(), 0, 561, 'test', 0, 0, 'lax95', 'test.lax.95@liferay.com', 'Welcome Test LAX 95!', 'Test', '', 'LAX 95', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (561, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 95', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (562, 1, 560, 11, 560, 0, 0, '562', '/562', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (563, 1, 562, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (564, 1, 562, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (560, 16)
go

insert into Users_Orgs (userId, organizationId) values (560, 19)
go
insert into Users_Orgs (userId, organizationId) values (560, 45)
go

insert into Users_Roles values (560, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (565, 1, getdate(), getdate(), 0, 566, 'test', 0, 0, 'lax96', 'test.lax.96@liferay.com', 'Welcome Test LAX 96!', 'Test', '', 'LAX 96', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (566, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 96', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (567, 1, 565, 11, 565, 0, 0, '567', '/567', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (568, 1, 567, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (569, 1, 567, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (565, 16)
go

insert into Users_Orgs (userId, organizationId) values (565, 19)
go
insert into Users_Orgs (userId, organizationId) values (565, 45)
go

insert into Users_Roles values (565, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (570, 1, getdate(), getdate(), 0, 571, 'test', 0, 0, 'lax97', 'test.lax.97@liferay.com', 'Welcome Test LAX 97!', 'Test', '', 'LAX 97', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (571, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 97', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (572, 1, 570, 11, 570, 0, 0, '572', '/572', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (573, 1, 572, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (574, 1, 572, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (570, 16)
go

insert into Users_Orgs (userId, organizationId) values (570, 19)
go
insert into Users_Orgs (userId, organizationId) values (570, 45)
go

insert into Users_Roles values (570, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (575, 1, getdate(), getdate(), 0, 576, 'test', 0, 0, 'lax98', 'test.lax.98@liferay.com', 'Welcome Test LAX 98!', 'Test', '', 'LAX 98', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (576, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 98', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (577, 1, 575, 11, 575, 0, 0, '577', '/577', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (578, 1, 577, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (579, 1, 577, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (575, 16)
go

insert into Users_Orgs (userId, organizationId) values (575, 19)
go
insert into Users_Orgs (userId, organizationId) values (575, 45)
go

insert into Users_Roles values (575, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (580, 1, getdate(), getdate(), 0, 581, 'test', 0, 0, 'lax99', 'test.lax.99@liferay.com', 'Welcome Test LAX 99!', 'Test', '', 'LAX 99', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (581, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 99', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (582, 1, 580, 11, 580, 0, 0, '582', '/582', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (583, 1, 582, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (584, 1, 582, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (580, 16)
go

insert into Users_Orgs (userId, organizationId) values (580, 19)
go
insert into Users_Orgs (userId, organizationId) values (580, 45)
go

insert into Users_Roles values (580, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (585, 1, getdate(), getdate(), 0, 586, 'test', 0, 0, 'lax100', 'test.lax.100@liferay.com', 'Welcome Test LAX 100!', 'Test', '', 'LAX 100', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (586, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'LAX 100', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (587, 1, 585, 11, 585, 0, 0, '587', '/587', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (588, 1, 587, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (589, 1, 587, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (585, 16)
go

insert into Users_Orgs (userId, organizationId) values (585, 19)
go
insert into Users_Orgs (userId, organizationId) values (585, 45)
go

insert into Users_Roles values (585, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (590, 1, getdate(), getdate(), 0, 591, 'test', 0, 0, 'sfo1', 'test.sfo.1@liferay.com', 'Welcome Test SFO 1!', 'Test', '', 'SFO 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (591, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (592, 1, 590, 11, 590, 0, 0, '592', '/592', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (593, 1, 592, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (594, 1, 592, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (590, 16)
go

insert into Users_Orgs (userId, organizationId) values (590, 19)
go
insert into Users_Orgs (userId, organizationId) values (590, 49)
go

insert into Users_Roles values (590, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (595, 1, getdate(), getdate(), 0, 596, 'test', 0, 0, 'sfo2', 'test.sfo.2@liferay.com', 'Welcome Test SFO 2!', 'Test', '', 'SFO 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (596, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (597, 1, 595, 11, 595, 0, 0, '597', '/597', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (598, 1, 597, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (599, 1, 597, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (595, 16)
go

insert into Users_Orgs (userId, organizationId) values (595, 19)
go
insert into Users_Orgs (userId, organizationId) values (595, 49)
go

insert into Users_Roles values (595, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (600, 1, getdate(), getdate(), 0, 601, 'test', 0, 0, 'sfo3', 'test.sfo.3@liferay.com', 'Welcome Test SFO 3!', 'Test', '', 'SFO 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (601, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (602, 1, 600, 11, 600, 0, 0, '602', '/602', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (603, 1, 602, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (604, 1, 602, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (600, 16)
go

insert into Users_Orgs (userId, organizationId) values (600, 19)
go
insert into Users_Orgs (userId, organizationId) values (600, 49)
go

insert into Users_Roles values (600, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (605, 1, getdate(), getdate(), 0, 606, 'test', 0, 0, 'sfo4', 'test.sfo.4@liferay.com', 'Welcome Test SFO 4!', 'Test', '', 'SFO 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (606, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (607, 1, 605, 11, 605, 0, 0, '607', '/607', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (608, 1, 607, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (609, 1, 607, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (605, 16)
go

insert into Users_Orgs (userId, organizationId) values (605, 19)
go
insert into Users_Orgs (userId, organizationId) values (605, 49)
go

insert into Users_Roles values (605, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (610, 1, getdate(), getdate(), 0, 611, 'test', 0, 0, 'sfo5', 'test.sfo.5@liferay.com', 'Welcome Test SFO 5!', 'Test', '', 'SFO 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (611, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (612, 1, 610, 11, 610, 0, 0, '612', '/612', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (613, 1, 612, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (614, 1, 612, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (610, 16)
go

insert into Users_Orgs (userId, organizationId) values (610, 19)
go
insert into Users_Orgs (userId, organizationId) values (610, 49)
go

insert into Users_Roles values (610, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (615, 1, getdate(), getdate(), 0, 616, 'test', 0, 0, 'sfo6', 'test.sfo.6@liferay.com', 'Welcome Test SFO 6!', 'Test', '', 'SFO 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (616, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (617, 1, 615, 11, 615, 0, 0, '617', '/617', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (618, 1, 617, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (619, 1, 617, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (615, 16)
go

insert into Users_Orgs (userId, organizationId) values (615, 19)
go
insert into Users_Orgs (userId, organizationId) values (615, 49)
go

insert into Users_Roles values (615, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (620, 1, getdate(), getdate(), 0, 621, 'test', 0, 0, 'sfo7', 'test.sfo.7@liferay.com', 'Welcome Test SFO 7!', 'Test', '', 'SFO 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (621, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (622, 1, 620, 11, 620, 0, 0, '622', '/622', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (623, 1, 622, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (624, 1, 622, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (620, 16)
go

insert into Users_Orgs (userId, organizationId) values (620, 19)
go
insert into Users_Orgs (userId, organizationId) values (620, 49)
go

insert into Users_Roles values (620, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (625, 1, getdate(), getdate(), 0, 626, 'test', 0, 0, 'sfo8', 'test.sfo.8@liferay.com', 'Welcome Test SFO 8!', 'Test', '', 'SFO 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (626, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (627, 1, 625, 11, 625, 0, 0, '627', '/627', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (628, 1, 627, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (629, 1, 627, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (625, 16)
go

insert into Users_Orgs (userId, organizationId) values (625, 19)
go
insert into Users_Orgs (userId, organizationId) values (625, 49)
go

insert into Users_Roles values (625, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (630, 1, getdate(), getdate(), 0, 631, 'test', 0, 0, 'sfo9', 'test.sfo.9@liferay.com', 'Welcome Test SFO 9!', 'Test', '', 'SFO 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (631, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (632, 1, 630, 11, 630, 0, 0, '632', '/632', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (633, 1, 632, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (634, 1, 632, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (630, 16)
go

insert into Users_Orgs (userId, organizationId) values (630, 19)
go
insert into Users_Orgs (userId, organizationId) values (630, 49)
go

insert into Users_Roles values (630, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (635, 1, getdate(), getdate(), 0, 636, 'test', 0, 0, 'sfo10', 'test.sfo.10@liferay.com', 'Welcome Test SFO 10!', 'Test', '', 'SFO 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (636, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'SFO 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (637, 1, 635, 11, 635, 0, 0, '637', '/637', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (638, 1, 637, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (639, 1, 637, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (635, 16)
go

insert into Users_Orgs (userId, organizationId) values (635, 19)
go
insert into Users_Orgs (userId, organizationId) values (635, 49)
go

insert into Users_Roles values (635, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (640, 1, getdate(), getdate(), 0, 641, 'test', 0, 0, 'ord1', 'test.ord.1@liferay.com', 'Welcome Test ORD 1!', 'Test', '', 'ORD 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (641, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (642, 1, 640, 11, 640, 0, 0, '642', '/642', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (643, 1, 642, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (644, 1, 642, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (640, 16)
go

insert into Users_Orgs (userId, organizationId) values (640, 19)
go
insert into Users_Orgs (userId, organizationId) values (640, 53)
go

insert into Users_Roles values (640, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (645, 1, getdate(), getdate(), 0, 646, 'test', 0, 0, 'ord2', 'test.ord.2@liferay.com', 'Welcome Test ORD 2!', 'Test', '', 'ORD 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (646, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (647, 1, 645, 11, 645, 0, 0, '647', '/647', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (648, 1, 647, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (649, 1, 647, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (645, 16)
go

insert into Users_Orgs (userId, organizationId) values (645, 19)
go
insert into Users_Orgs (userId, organizationId) values (645, 53)
go

insert into Users_Roles values (645, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (650, 1, getdate(), getdate(), 0, 651, 'test', 0, 0, 'ord3', 'test.ord.3@liferay.com', 'Welcome Test ORD 3!', 'Test', '', 'ORD 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (651, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (652, 1, 650, 11, 650, 0, 0, '652', '/652', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (653, 1, 652, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (654, 1, 652, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (650, 16)
go

insert into Users_Orgs (userId, organizationId) values (650, 19)
go
insert into Users_Orgs (userId, organizationId) values (650, 53)
go

insert into Users_Roles values (650, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (655, 1, getdate(), getdate(), 0, 656, 'test', 0, 0, 'ord4', 'test.ord.4@liferay.com', 'Welcome Test ORD 4!', 'Test', '', 'ORD 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (656, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (657, 1, 655, 11, 655, 0, 0, '657', '/657', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (658, 1, 657, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (659, 1, 657, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (655, 16)
go

insert into Users_Orgs (userId, organizationId) values (655, 19)
go
insert into Users_Orgs (userId, organizationId) values (655, 53)
go

insert into Users_Roles values (655, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (660, 1, getdate(), getdate(), 0, 661, 'test', 0, 0, 'ord5', 'test.ord.5@liferay.com', 'Welcome Test ORD 5!', 'Test', '', 'ORD 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (661, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (662, 1, 660, 11, 660, 0, 0, '662', '/662', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (663, 1, 662, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (664, 1, 662, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (660, 16)
go

insert into Users_Orgs (userId, organizationId) values (660, 19)
go
insert into Users_Orgs (userId, organizationId) values (660, 53)
go

insert into Users_Roles values (660, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (665, 1, getdate(), getdate(), 0, 666, 'test', 0, 0, 'ord6', 'test.ord.6@liferay.com', 'Welcome Test ORD 6!', 'Test', '', 'ORD 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (666, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (667, 1, 665, 11, 665, 0, 0, '667', '/667', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (668, 1, 667, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (669, 1, 667, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (665, 16)
go

insert into Users_Orgs (userId, organizationId) values (665, 19)
go
insert into Users_Orgs (userId, organizationId) values (665, 53)
go

insert into Users_Roles values (665, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (670, 1, getdate(), getdate(), 0, 671, 'test', 0, 0, 'ord7', 'test.ord.7@liferay.com', 'Welcome Test ORD 7!', 'Test', '', 'ORD 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (671, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (672, 1, 670, 11, 670, 0, 0, '672', '/672', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (673, 1, 672, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (674, 1, 672, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (670, 16)
go

insert into Users_Orgs (userId, organizationId) values (670, 19)
go
insert into Users_Orgs (userId, organizationId) values (670, 53)
go

insert into Users_Roles values (670, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (675, 1, getdate(), getdate(), 0, 676, 'test', 0, 0, 'ord8', 'test.ord.8@liferay.com', 'Welcome Test ORD 8!', 'Test', '', 'ORD 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (676, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (677, 1, 675, 11, 675, 0, 0, '677', '/677', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (678, 1, 677, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (679, 1, 677, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (675, 16)
go

insert into Users_Orgs (userId, organizationId) values (675, 19)
go
insert into Users_Orgs (userId, organizationId) values (675, 53)
go

insert into Users_Roles values (675, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (680, 1, getdate(), getdate(), 0, 681, 'test', 0, 0, 'ord9', 'test.ord.9@liferay.com', 'Welcome Test ORD 9!', 'Test', '', 'ORD 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (681, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (682, 1, 680, 11, 680, 0, 0, '682', '/682', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (683, 1, 682, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (684, 1, 682, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (680, 16)
go

insert into Users_Orgs (userId, organizationId) values (680, 19)
go
insert into Users_Orgs (userId, organizationId) values (680, 53)
go

insert into Users_Roles values (680, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (685, 1, getdate(), getdate(), 0, 686, 'test', 0, 0, 'ord10', 'test.ord.10@liferay.com', 'Welcome Test ORD 10!', 'Test', '', 'ORD 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (686, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'ORD 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (687, 1, 685, 11, 685, 0, 0, '687', '/687', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (688, 1, 687, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (689, 1, 687, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (685, 16)
go

insert into Users_Orgs (userId, organizationId) values (685, 19)
go
insert into Users_Orgs (userId, organizationId) values (685, 53)
go

insert into Users_Roles values (685, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (690, 1, getdate(), getdate(), 0, 691, 'test', 0, 0, 'nyc1', 'test.nyc.1@liferay.com', 'Welcome Test NYC 1!', 'Test', '', 'NYC 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (691, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (692, 1, 690, 11, 690, 0, 0, '692', '/692', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (693, 1, 692, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (694, 1, 692, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (690, 16)
go

insert into Users_Orgs (userId, organizationId) values (690, 19)
go
insert into Users_Orgs (userId, organizationId) values (690, 57)
go

insert into Users_Roles values (690, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (695, 1, getdate(), getdate(), 0, 696, 'test', 0, 0, 'nyc2', 'test.nyc.2@liferay.com', 'Welcome Test NYC 2!', 'Test', '', 'NYC 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (696, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (697, 1, 695, 11, 695, 0, 0, '697', '/697', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (698, 1, 697, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (699, 1, 697, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (695, 16)
go

insert into Users_Orgs (userId, organizationId) values (695, 19)
go
insert into Users_Orgs (userId, organizationId) values (695, 57)
go

insert into Users_Roles values (695, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (700, 1, getdate(), getdate(), 0, 701, 'test', 0, 0, 'nyc3', 'test.nyc.3@liferay.com', 'Welcome Test NYC 3!', 'Test', '', 'NYC 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (701, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (702, 1, 700, 11, 700, 0, 0, '702', '/702', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (703, 1, 702, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (704, 1, 702, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (700, 16)
go

insert into Users_Orgs (userId, organizationId) values (700, 19)
go
insert into Users_Orgs (userId, organizationId) values (700, 57)
go

insert into Users_Roles values (700, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (705, 1, getdate(), getdate(), 0, 706, 'test', 0, 0, 'nyc4', 'test.nyc.4@liferay.com', 'Welcome Test NYC 4!', 'Test', '', 'NYC 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (706, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (707, 1, 705, 11, 705, 0, 0, '707', '/707', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (708, 1, 707, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (709, 1, 707, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (705, 16)
go

insert into Users_Orgs (userId, organizationId) values (705, 19)
go
insert into Users_Orgs (userId, organizationId) values (705, 57)
go

insert into Users_Roles values (705, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (710, 1, getdate(), getdate(), 0, 711, 'test', 0, 0, 'nyc5', 'test.nyc.5@liferay.com', 'Welcome Test NYC 5!', 'Test', '', 'NYC 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (711, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (712, 1, 710, 11, 710, 0, 0, '712', '/712', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (713, 1, 712, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (714, 1, 712, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (710, 16)
go

insert into Users_Orgs (userId, organizationId) values (710, 19)
go
insert into Users_Orgs (userId, organizationId) values (710, 57)
go

insert into Users_Roles values (710, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (715, 1, getdate(), getdate(), 0, 716, 'test', 0, 0, 'nyc6', 'test.nyc.6@liferay.com', 'Welcome Test NYC 6!', 'Test', '', 'NYC 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (716, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (717, 1, 715, 11, 715, 0, 0, '717', '/717', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (718, 1, 717, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (719, 1, 717, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (715, 16)
go

insert into Users_Orgs (userId, organizationId) values (715, 19)
go
insert into Users_Orgs (userId, organizationId) values (715, 57)
go

insert into Users_Roles values (715, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (720, 1, getdate(), getdate(), 0, 721, 'test', 0, 0, 'nyc7', 'test.nyc.7@liferay.com', 'Welcome Test NYC 7!', 'Test', '', 'NYC 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (721, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (722, 1, 720, 11, 720, 0, 0, '722', '/722', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (723, 1, 722, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (724, 1, 722, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (720, 16)
go

insert into Users_Orgs (userId, organizationId) values (720, 19)
go
insert into Users_Orgs (userId, organizationId) values (720, 57)
go

insert into Users_Roles values (720, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (725, 1, getdate(), getdate(), 0, 726, 'test', 0, 0, 'nyc8', 'test.nyc.8@liferay.com', 'Welcome Test NYC 8!', 'Test', '', 'NYC 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (726, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (727, 1, 725, 11, 725, 0, 0, '727', '/727', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (728, 1, 727, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (729, 1, 727, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (725, 16)
go

insert into Users_Orgs (userId, organizationId) values (725, 19)
go
insert into Users_Orgs (userId, organizationId) values (725, 57)
go

insert into Users_Roles values (725, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (730, 1, getdate(), getdate(), 0, 731, 'test', 0, 0, 'nyc9', 'test.nyc.9@liferay.com', 'Welcome Test NYC 9!', 'Test', '', 'NYC 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (731, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (732, 1, 730, 11, 730, 0, 0, '732', '/732', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (733, 1, 732, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (734, 1, 732, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (730, 16)
go

insert into Users_Orgs (userId, organizationId) values (730, 19)
go
insert into Users_Orgs (userId, organizationId) values (730, 57)
go

insert into Users_Roles values (730, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (735, 1, getdate(), getdate(), 0, 736, 'test', 0, 0, 'nyc10', 'test.nyc.10@liferay.com', 'Welcome Test NYC 10!', 'Test', '', 'NYC 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (736, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'NYC 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (737, 1, 735, 11, 735, 0, 0, '737', '/737', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (738, 1, 737, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (739, 1, 737, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (735, 16)
go

insert into Users_Orgs (userId, organizationId) values (735, 19)
go
insert into Users_Orgs (userId, organizationId) values (735, 57)
go

insert into Users_Roles values (735, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (740, 1, getdate(), getdate(), 0, 741, 'test', 0, 0, 'gru1', 'test.gru.1@liferay.com', 'Welcome Test GRU 1!', 'Test', '', 'GRU 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (741, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (742, 1, 740, 11, 740, 0, 0, '742', '/742', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (743, 1, 742, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (744, 1, 742, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (740, 16)
go

insert into Users_Orgs (userId, organizationId) values (740, 19)
go
insert into Users_Orgs (userId, organizationId) values (740, 61)
go

insert into Users_Roles values (740, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (745, 1, getdate(), getdate(), 0, 746, 'test', 0, 0, 'gru2', 'test.gru.2@liferay.com', 'Welcome Test GRU 2!', 'Test', '', 'GRU 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (746, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (747, 1, 745, 11, 745, 0, 0, '747', '/747', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (748, 1, 747, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (749, 1, 747, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (745, 16)
go

insert into Users_Orgs (userId, organizationId) values (745, 19)
go
insert into Users_Orgs (userId, organizationId) values (745, 61)
go

insert into Users_Roles values (745, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (750, 1, getdate(), getdate(), 0, 751, 'test', 0, 0, 'gru3', 'test.gru.3@liferay.com', 'Welcome Test GRU 3!', 'Test', '', 'GRU 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (751, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (752, 1, 750, 11, 750, 0, 0, '752', '/752', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (753, 1, 752, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (754, 1, 752, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (750, 16)
go

insert into Users_Orgs (userId, organizationId) values (750, 19)
go
insert into Users_Orgs (userId, organizationId) values (750, 61)
go

insert into Users_Roles values (750, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (755, 1, getdate(), getdate(), 0, 756, 'test', 0, 0, 'gru4', 'test.gru.4@liferay.com', 'Welcome Test GRU 4!', 'Test', '', 'GRU 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (756, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (757, 1, 755, 11, 755, 0, 0, '757', '/757', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (758, 1, 757, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (759, 1, 757, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (755, 16)
go

insert into Users_Orgs (userId, organizationId) values (755, 19)
go
insert into Users_Orgs (userId, organizationId) values (755, 61)
go

insert into Users_Roles values (755, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (760, 1, getdate(), getdate(), 0, 761, 'test', 0, 0, 'gru5', 'test.gru.5@liferay.com', 'Welcome Test GRU 5!', 'Test', '', 'GRU 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (761, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (762, 1, 760, 11, 760, 0, 0, '762', '/762', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (763, 1, 762, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (764, 1, 762, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (760, 16)
go

insert into Users_Orgs (userId, organizationId) values (760, 19)
go
insert into Users_Orgs (userId, organizationId) values (760, 61)
go

insert into Users_Roles values (760, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (765, 1, getdate(), getdate(), 0, 766, 'test', 0, 0, 'gru6', 'test.gru.6@liferay.com', 'Welcome Test GRU 6!', 'Test', '', 'GRU 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (766, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (767, 1, 765, 11, 765, 0, 0, '767', '/767', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (768, 1, 767, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (769, 1, 767, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (765, 16)
go

insert into Users_Orgs (userId, organizationId) values (765, 19)
go
insert into Users_Orgs (userId, organizationId) values (765, 61)
go

insert into Users_Roles values (765, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (770, 1, getdate(), getdate(), 0, 771, 'test', 0, 0, 'gru7', 'test.gru.7@liferay.com', 'Welcome Test GRU 7!', 'Test', '', 'GRU 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (771, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (772, 1, 770, 11, 770, 0, 0, '772', '/772', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (773, 1, 772, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (774, 1, 772, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (770, 16)
go

insert into Users_Orgs (userId, organizationId) values (770, 19)
go
insert into Users_Orgs (userId, organizationId) values (770, 61)
go

insert into Users_Roles values (770, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (775, 1, getdate(), getdate(), 0, 776, 'test', 0, 0, 'gru8', 'test.gru.8@liferay.com', 'Welcome Test GRU 8!', 'Test', '', 'GRU 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (776, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (777, 1, 775, 11, 775, 0, 0, '777', '/777', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (778, 1, 777, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (779, 1, 777, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (775, 16)
go

insert into Users_Orgs (userId, organizationId) values (775, 19)
go
insert into Users_Orgs (userId, organizationId) values (775, 61)
go

insert into Users_Roles values (775, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (780, 1, getdate(), getdate(), 0, 781, 'test', 0, 0, 'gru9', 'test.gru.9@liferay.com', 'Welcome Test GRU 9!', 'Test', '', 'GRU 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (781, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (782, 1, 780, 11, 780, 0, 0, '782', '/782', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (783, 1, 782, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (784, 1, 782, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (780, 16)
go

insert into Users_Orgs (userId, organizationId) values (780, 19)
go
insert into Users_Orgs (userId, organizationId) values (780, 61)
go

insert into Users_Roles values (780, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (785, 1, getdate(), getdate(), 0, 786, 'test', 0, 0, 'gru10', 'test.gru.10@liferay.com', 'Welcome Test GRU 10!', 'Test', '', 'GRU 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (786, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'GRU 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (787, 1, 785, 11, 785, 0, 0, '787', '/787', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (788, 1, 787, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (789, 1, 787, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (785, 16)
go

insert into Users_Orgs (userId, organizationId) values (785, 19)
go
insert into Users_Orgs (userId, organizationId) values (785, 61)
go

insert into Users_Roles values (785, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (790, 1, getdate(), getdate(), 0, 791, 'test', 0, 0, 'fra1', 'test.fra.1@liferay.com', 'Welcome Test FRA 1!', 'Test', '', 'FRA 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (791, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (792, 1, 790, 11, 790, 0, 0, '792', '/792', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (793, 1, 792, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (794, 1, 792, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (790, 16)
go

insert into Users_Orgs (userId, organizationId) values (790, 19)
go
insert into Users_Orgs (userId, organizationId) values (790, 65)
go

insert into Users_Roles values (790, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (795, 1, getdate(), getdate(), 0, 796, 'test', 0, 0, 'fra2', 'test.fra.2@liferay.com', 'Welcome Test FRA 2!', 'Test', '', 'FRA 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (796, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (797, 1, 795, 11, 795, 0, 0, '797', '/797', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (798, 1, 797, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (799, 1, 797, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (795, 16)
go

insert into Users_Orgs (userId, organizationId) values (795, 19)
go
insert into Users_Orgs (userId, organizationId) values (795, 65)
go

insert into Users_Roles values (795, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (800, 1, getdate(), getdate(), 0, 801, 'test', 0, 0, 'fra3', 'test.fra.3@liferay.com', 'Welcome Test FRA 3!', 'Test', '', 'FRA 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (801, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (802, 1, 800, 11, 800, 0, 0, '802', '/802', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (803, 1, 802, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (804, 1, 802, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (800, 16)
go

insert into Users_Orgs (userId, organizationId) values (800, 19)
go
insert into Users_Orgs (userId, organizationId) values (800, 65)
go

insert into Users_Roles values (800, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (805, 1, getdate(), getdate(), 0, 806, 'test', 0, 0, 'fra4', 'test.fra.4@liferay.com', 'Welcome Test FRA 4!', 'Test', '', 'FRA 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (806, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (807, 1, 805, 11, 805, 0, 0, '807', '/807', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (808, 1, 807, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (809, 1, 807, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (805, 16)
go

insert into Users_Orgs (userId, organizationId) values (805, 19)
go
insert into Users_Orgs (userId, organizationId) values (805, 65)
go

insert into Users_Roles values (805, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (810, 1, getdate(), getdate(), 0, 811, 'test', 0, 0, 'fra5', 'test.fra.5@liferay.com', 'Welcome Test FRA 5!', 'Test', '', 'FRA 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (811, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (812, 1, 810, 11, 810, 0, 0, '812', '/812', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (813, 1, 812, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (814, 1, 812, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (810, 16)
go

insert into Users_Orgs (userId, organizationId) values (810, 19)
go
insert into Users_Orgs (userId, organizationId) values (810, 65)
go

insert into Users_Roles values (810, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (815, 1, getdate(), getdate(), 0, 816, 'test', 0, 0, 'fra6', 'test.fra.6@liferay.com', 'Welcome Test FRA 6!', 'Test', '', 'FRA 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (816, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (817, 1, 815, 11, 815, 0, 0, '817', '/817', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (818, 1, 817, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (819, 1, 817, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (815, 16)
go

insert into Users_Orgs (userId, organizationId) values (815, 19)
go
insert into Users_Orgs (userId, organizationId) values (815, 65)
go

insert into Users_Roles values (815, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (820, 1, getdate(), getdate(), 0, 821, 'test', 0, 0, 'fra7', 'test.fra.7@liferay.com', 'Welcome Test FRA 7!', 'Test', '', 'FRA 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (821, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (822, 1, 820, 11, 820, 0, 0, '822', '/822', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (823, 1, 822, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (824, 1, 822, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (820, 16)
go

insert into Users_Orgs (userId, organizationId) values (820, 19)
go
insert into Users_Orgs (userId, organizationId) values (820, 65)
go

insert into Users_Roles values (820, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (825, 1, getdate(), getdate(), 0, 826, 'test', 0, 0, 'fra8', 'test.fra.8@liferay.com', 'Welcome Test FRA 8!', 'Test', '', 'FRA 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (826, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (827, 1, 825, 11, 825, 0, 0, '827', '/827', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (828, 1, 827, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (829, 1, 827, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (825, 16)
go

insert into Users_Orgs (userId, organizationId) values (825, 19)
go
insert into Users_Orgs (userId, organizationId) values (825, 65)
go

insert into Users_Roles values (825, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (830, 1, getdate(), getdate(), 0, 831, 'test', 0, 0, 'fra9', 'test.fra.9@liferay.com', 'Welcome Test FRA 9!', 'Test', '', 'FRA 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (831, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (832, 1, 830, 11, 830, 0, 0, '832', '/832', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (833, 1, 832, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (834, 1, 832, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (830, 16)
go

insert into Users_Orgs (userId, organizationId) values (830, 19)
go
insert into Users_Orgs (userId, organizationId) values (830, 65)
go

insert into Users_Roles values (830, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (835, 1, getdate(), getdate(), 0, 836, 'test', 0, 0, 'fra10', 'test.fra.10@liferay.com', 'Welcome Test FRA 10!', 'Test', '', 'FRA 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (836, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'FRA 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (837, 1, 835, 11, 835, 0, 0, '837', '/837', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (838, 1, 837, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (839, 1, 837, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (835, 16)
go

insert into Users_Orgs (userId, organizationId) values (835, 19)
go
insert into Users_Orgs (userId, organizationId) values (835, 65)
go

insert into Users_Roles values (835, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (840, 1, getdate(), getdate(), 0, 841, 'test', 0, 0, 'mad1', 'test.mad.1@liferay.com', 'Welcome Test MAD 1!', 'Test', '', 'MAD 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (841, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (842, 1, 840, 11, 840, 0, 0, '842', '/842', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (843, 1, 842, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (844, 1, 842, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (840, 16)
go

insert into Users_Orgs (userId, organizationId) values (840, 19)
go
insert into Users_Orgs (userId, organizationId) values (840, 69)
go

insert into Users_Roles values (840, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (845, 1, getdate(), getdate(), 0, 846, 'test', 0, 0, 'mad2', 'test.mad.2@liferay.com', 'Welcome Test MAD 2!', 'Test', '', 'MAD 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (846, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (847, 1, 845, 11, 845, 0, 0, '847', '/847', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (848, 1, 847, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (849, 1, 847, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (845, 16)
go

insert into Users_Orgs (userId, organizationId) values (845, 19)
go
insert into Users_Orgs (userId, organizationId) values (845, 69)
go

insert into Users_Roles values (845, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (850, 1, getdate(), getdate(), 0, 851, 'test', 0, 0, 'mad3', 'test.mad.3@liferay.com', 'Welcome Test MAD 3!', 'Test', '', 'MAD 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (851, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (852, 1, 850, 11, 850, 0, 0, '852', '/852', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (853, 1, 852, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (854, 1, 852, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (850, 16)
go

insert into Users_Orgs (userId, organizationId) values (850, 19)
go
insert into Users_Orgs (userId, organizationId) values (850, 69)
go

insert into Users_Roles values (850, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (855, 1, getdate(), getdate(), 0, 856, 'test', 0, 0, 'mad4', 'test.mad.4@liferay.com', 'Welcome Test MAD 4!', 'Test', '', 'MAD 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (856, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (857, 1, 855, 11, 855, 0, 0, '857', '/857', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (858, 1, 857, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (859, 1, 857, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (855, 16)
go

insert into Users_Orgs (userId, organizationId) values (855, 19)
go
insert into Users_Orgs (userId, organizationId) values (855, 69)
go

insert into Users_Roles values (855, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (860, 1, getdate(), getdate(), 0, 861, 'test', 0, 0, 'mad5', 'test.mad.5@liferay.com', 'Welcome Test MAD 5!', 'Test', '', 'MAD 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (861, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (862, 1, 860, 11, 860, 0, 0, '862', '/862', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (863, 1, 862, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (864, 1, 862, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (860, 16)
go

insert into Users_Orgs (userId, organizationId) values (860, 19)
go
insert into Users_Orgs (userId, organizationId) values (860, 69)
go

insert into Users_Roles values (860, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (865, 1, getdate(), getdate(), 0, 866, 'test', 0, 0, 'mad6', 'test.mad.6@liferay.com', 'Welcome Test MAD 6!', 'Test', '', 'MAD 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (866, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (867, 1, 865, 11, 865, 0, 0, '867', '/867', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (868, 1, 867, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (869, 1, 867, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (865, 16)
go

insert into Users_Orgs (userId, organizationId) values (865, 19)
go
insert into Users_Orgs (userId, organizationId) values (865, 69)
go

insert into Users_Roles values (865, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (870, 1, getdate(), getdate(), 0, 871, 'test', 0, 0, 'mad7', 'test.mad.7@liferay.com', 'Welcome Test MAD 7!', 'Test', '', 'MAD 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (871, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (872, 1, 870, 11, 870, 0, 0, '872', '/872', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (873, 1, 872, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (874, 1, 872, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (870, 16)
go

insert into Users_Orgs (userId, organizationId) values (870, 19)
go
insert into Users_Orgs (userId, organizationId) values (870, 69)
go

insert into Users_Roles values (870, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (875, 1, getdate(), getdate(), 0, 876, 'test', 0, 0, 'mad8', 'test.mad.8@liferay.com', 'Welcome Test MAD 8!', 'Test', '', 'MAD 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (876, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (877, 1, 875, 11, 875, 0, 0, '877', '/877', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (878, 1, 877, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (879, 1, 877, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (875, 16)
go

insert into Users_Orgs (userId, organizationId) values (875, 19)
go
insert into Users_Orgs (userId, organizationId) values (875, 69)
go

insert into Users_Roles values (875, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (880, 1, getdate(), getdate(), 0, 881, 'test', 0, 0, 'mad9', 'test.mad.9@liferay.com', 'Welcome Test MAD 9!', 'Test', '', 'MAD 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (881, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (882, 1, 880, 11, 880, 0, 0, '882', '/882', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (883, 1, 882, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (884, 1, 882, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (880, 16)
go

insert into Users_Orgs (userId, organizationId) values (880, 19)
go
insert into Users_Orgs (userId, organizationId) values (880, 69)
go

insert into Users_Roles values (880, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (885, 1, getdate(), getdate(), 0, 886, 'test', 0, 0, 'mad10', 'test.mad.10@liferay.com', 'Welcome Test MAD 10!', 'Test', '', 'MAD 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (886, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'MAD 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (887, 1, 885, 11, 885, 0, 0, '887', '/887', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (888, 1, 887, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (889, 1, 887, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (885, 16)
go

insert into Users_Orgs (userId, organizationId) values (885, 19)
go
insert into Users_Orgs (userId, organizationId) values (885, 69)
go

insert into Users_Roles values (885, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (890, 1, getdate(), getdate(), 0, 891, 'test', 0, 0, 'dlc1', 'test.dlc.1@liferay.com', 'Welcome Test DLC 1!', 'Test', '', 'DLC 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (891, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (892, 1, 890, 11, 890, 0, 0, '892', '/892', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (893, 1, 892, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (894, 1, 892, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (890, 16)
go

insert into Users_Orgs (userId, organizationId) values (890, 19)
go
insert into Users_Orgs (userId, organizationId) values (890, 73)
go

insert into Users_Roles values (890, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (895, 1, getdate(), getdate(), 0, 896, 'test', 0, 0, 'dlc2', 'test.dlc.2@liferay.com', 'Welcome Test DLC 2!', 'Test', '', 'DLC 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (896, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (897, 1, 895, 11, 895, 0, 0, '897', '/897', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (898, 1, 897, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (899, 1, 897, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (895, 16)
go

insert into Users_Orgs (userId, organizationId) values (895, 19)
go
insert into Users_Orgs (userId, organizationId) values (895, 73)
go

insert into Users_Roles values (895, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (900, 1, getdate(), getdate(), 0, 901, 'test', 0, 0, 'dlc3', 'test.dlc.3@liferay.com', 'Welcome Test DLC 3!', 'Test', '', 'DLC 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (901, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (902, 1, 900, 11, 900, 0, 0, '902', '/902', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (903, 1, 902, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (904, 1, 902, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (900, 16)
go

insert into Users_Orgs (userId, organizationId) values (900, 19)
go
insert into Users_Orgs (userId, organizationId) values (900, 73)
go

insert into Users_Roles values (900, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (905, 1, getdate(), getdate(), 0, 906, 'test', 0, 0, 'dlc4', 'test.dlc.4@liferay.com', 'Welcome Test DLC 4!', 'Test', '', 'DLC 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (906, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (907, 1, 905, 11, 905, 0, 0, '907', '/907', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (908, 1, 907, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (909, 1, 907, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (905, 16)
go

insert into Users_Orgs (userId, organizationId) values (905, 19)
go
insert into Users_Orgs (userId, organizationId) values (905, 73)
go

insert into Users_Roles values (905, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (910, 1, getdate(), getdate(), 0, 911, 'test', 0, 0, 'dlc5', 'test.dlc.5@liferay.com', 'Welcome Test DLC 5!', 'Test', '', 'DLC 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (911, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (912, 1, 910, 11, 910, 0, 0, '912', '/912', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (913, 1, 912, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (914, 1, 912, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (910, 16)
go

insert into Users_Orgs (userId, organizationId) values (910, 19)
go
insert into Users_Orgs (userId, organizationId) values (910, 73)
go

insert into Users_Roles values (910, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (915, 1, getdate(), getdate(), 0, 916, 'test', 0, 0, 'dlc6', 'test.dlc.6@liferay.com', 'Welcome Test DLC 6!', 'Test', '', 'DLC 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (916, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (917, 1, 915, 11, 915, 0, 0, '917', '/917', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (918, 1, 917, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (919, 1, 917, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (915, 16)
go

insert into Users_Orgs (userId, organizationId) values (915, 19)
go
insert into Users_Orgs (userId, organizationId) values (915, 73)
go

insert into Users_Roles values (915, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (920, 1, getdate(), getdate(), 0, 921, 'test', 0, 0, 'dlc7', 'test.dlc.7@liferay.com', 'Welcome Test DLC 7!', 'Test', '', 'DLC 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (921, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (922, 1, 920, 11, 920, 0, 0, '922', '/922', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (923, 1, 922, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (924, 1, 922, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (920, 16)
go

insert into Users_Orgs (userId, organizationId) values (920, 19)
go
insert into Users_Orgs (userId, organizationId) values (920, 73)
go

insert into Users_Roles values (920, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (925, 1, getdate(), getdate(), 0, 926, 'test', 0, 0, 'dlc8', 'test.dlc.8@liferay.com', 'Welcome Test DLC 8!', 'Test', '', 'DLC 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (926, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (927, 1, 925, 11, 925, 0, 0, '927', '/927', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (928, 1, 927, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (929, 1, 927, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (925, 16)
go

insert into Users_Orgs (userId, organizationId) values (925, 19)
go
insert into Users_Orgs (userId, organizationId) values (925, 73)
go

insert into Users_Roles values (925, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (930, 1, getdate(), getdate(), 0, 931, 'test', 0, 0, 'dlc9', 'test.dlc.9@liferay.com', 'Welcome Test DLC 9!', 'Test', '', 'DLC 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (931, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (932, 1, 930, 11, 930, 0, 0, '932', '/932', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (933, 1, 932, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (934, 1, 932, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (930, 16)
go

insert into Users_Orgs (userId, organizationId) values (930, 19)
go
insert into Users_Orgs (userId, organizationId) values (930, 73)
go

insert into Users_Roles values (930, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (935, 1, getdate(), getdate(), 0, 936, 'test', 0, 0, 'dlc10', 'test.dlc.10@liferay.com', 'Welcome Test DLC 10!', 'Test', '', 'DLC 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (936, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'DLC 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (937, 1, 935, 11, 935, 0, 0, '937', '/937', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (938, 1, 937, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (939, 1, 937, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (935, 16)
go

insert into Users_Orgs (userId, organizationId) values (935, 19)
go
insert into Users_Orgs (userId, organizationId) values (935, 73)
go

insert into Users_Roles values (935, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (940, 1, getdate(), getdate(), 0, 941, 'test', 0, 0, 'hkg1', 'test.hkg.1@liferay.com', 'Welcome Test HKG 1!', 'Test', '', 'HKG 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (941, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (942, 1, 940, 11, 940, 0, 0, '942', '/942', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (943, 1, 942, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (944, 1, 942, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (940, 16)
go

insert into Users_Orgs (userId, organizationId) values (940, 19)
go
insert into Users_Orgs (userId, organizationId) values (940, 77)
go

insert into Users_Roles values (940, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (945, 1, getdate(), getdate(), 0, 946, 'test', 0, 0, 'hkg2', 'test.hkg.2@liferay.com', 'Welcome Test HKG 2!', 'Test', '', 'HKG 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (946, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (947, 1, 945, 11, 945, 0, 0, '947', '/947', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (948, 1, 947, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (949, 1, 947, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (945, 16)
go

insert into Users_Orgs (userId, organizationId) values (945, 19)
go
insert into Users_Orgs (userId, organizationId) values (945, 77)
go

insert into Users_Roles values (945, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (950, 1, getdate(), getdate(), 0, 951, 'test', 0, 0, 'hkg3', 'test.hkg.3@liferay.com', 'Welcome Test HKG 3!', 'Test', '', 'HKG 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (951, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (952, 1, 950, 11, 950, 0, 0, '952', '/952', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (953, 1, 952, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (954, 1, 952, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (950, 16)
go

insert into Users_Orgs (userId, organizationId) values (950, 19)
go
insert into Users_Orgs (userId, organizationId) values (950, 77)
go

insert into Users_Roles values (950, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (955, 1, getdate(), getdate(), 0, 956, 'test', 0, 0, 'hkg4', 'test.hkg.4@liferay.com', 'Welcome Test HKG 4!', 'Test', '', 'HKG 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (956, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (957, 1, 955, 11, 955, 0, 0, '957', '/957', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (958, 1, 957, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (959, 1, 957, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (955, 16)
go

insert into Users_Orgs (userId, organizationId) values (955, 19)
go
insert into Users_Orgs (userId, organizationId) values (955, 77)
go

insert into Users_Roles values (955, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (960, 1, getdate(), getdate(), 0, 961, 'test', 0, 0, 'hkg5', 'test.hkg.5@liferay.com', 'Welcome Test HKG 5!', 'Test', '', 'HKG 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (961, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (962, 1, 960, 11, 960, 0, 0, '962', '/962', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (963, 1, 962, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (964, 1, 962, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (960, 16)
go

insert into Users_Orgs (userId, organizationId) values (960, 19)
go
insert into Users_Orgs (userId, organizationId) values (960, 77)
go

insert into Users_Roles values (960, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (965, 1, getdate(), getdate(), 0, 966, 'test', 0, 0, 'hkg6', 'test.hkg.6@liferay.com', 'Welcome Test HKG 6!', 'Test', '', 'HKG 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (966, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (967, 1, 965, 11, 965, 0, 0, '967', '/967', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (968, 1, 967, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (969, 1, 967, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (965, 16)
go

insert into Users_Orgs (userId, organizationId) values (965, 19)
go
insert into Users_Orgs (userId, organizationId) values (965, 77)
go

insert into Users_Roles values (965, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (970, 1, getdate(), getdate(), 0, 971, 'test', 0, 0, 'hkg7', 'test.hkg.7@liferay.com', 'Welcome Test HKG 7!', 'Test', '', 'HKG 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (971, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (972, 1, 970, 11, 970, 0, 0, '972', '/972', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (973, 1, 972, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (974, 1, 972, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (970, 16)
go

insert into Users_Orgs (userId, organizationId) values (970, 19)
go
insert into Users_Orgs (userId, organizationId) values (970, 77)
go

insert into Users_Roles values (970, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (975, 1, getdate(), getdate(), 0, 976, 'test', 0, 0, 'hkg8', 'test.hkg.8@liferay.com', 'Welcome Test HKG 8!', 'Test', '', 'HKG 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (976, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (977, 1, 975, 11, 975, 0, 0, '977', '/977', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (978, 1, 977, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (979, 1, 977, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (975, 16)
go

insert into Users_Orgs (userId, organizationId) values (975, 19)
go
insert into Users_Orgs (userId, organizationId) values (975, 77)
go

insert into Users_Roles values (975, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (980, 1, getdate(), getdate(), 0, 981, 'test', 0, 0, 'hkg9', 'test.hkg.9@liferay.com', 'Welcome Test HKG 9!', 'Test', '', 'HKG 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (981, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (982, 1, 980, 11, 980, 0, 0, '982', '/982', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (983, 1, 982, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (984, 1, 982, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (980, 16)
go

insert into Users_Orgs (userId, organizationId) values (980, 19)
go
insert into Users_Orgs (userId, organizationId) values (980, 77)
go

insert into Users_Roles values (980, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (985, 1, getdate(), getdate(), 0, 986, 'test', 0, 0, 'hkg10', 'test.hkg.10@liferay.com', 'Welcome Test HKG 10!', 'Test', '', 'HKG 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (986, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'HKG 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (987, 1, 985, 11, 985, 0, 0, '987', '/987', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (988, 1, 987, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (989, 1, 987, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (985, 16)
go

insert into Users_Orgs (userId, organizationId) values (985, 19)
go
insert into Users_Orgs (userId, organizationId) values (985, 77)
go

insert into Users_Roles values (985, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (990, 1, getdate(), getdate(), 0, 991, 'test', 0, 0, 'kul1', 'test.kul.1@liferay.com', 'Welcome Test KUL 1!', 'Test', '', 'KUL 1', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (991, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 1', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (992, 1, 990, 11, 990, 0, 0, '992', '/992', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (993, 1, 992, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (994, 1, 992, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (990, 16)
go

insert into Users_Orgs (userId, organizationId) values (990, 19)
go
insert into Users_Orgs (userId, organizationId) values (990, 81)
go

insert into Users_Roles values (990, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (995, 1, getdate(), getdate(), 0, 996, 'test', 0, 0, 'kul2', 'test.kul.2@liferay.com', 'Welcome Test KUL 2!', 'Test', '', 'KUL 2', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (996, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 2', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (997, 1, 995, 11, 995, 0, 0, '997', '/997', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (998, 1, 997, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (999, 1, 997, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (995, 16)
go

insert into Users_Orgs (userId, organizationId) values (995, 19)
go
insert into Users_Orgs (userId, organizationId) values (995, 81)
go

insert into Users_Roles values (995, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1000, 1, getdate(), getdate(), 0, 1001, 'test', 0, 0, 'kul3', 'test.kul.3@liferay.com', 'Welcome Test KUL 3!', 'Test', '', 'KUL 3', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1001, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 3', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1002, 1, 1000, 11, 1000, 0, 0, '1002', '/1002', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1003, 1, 1002, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1004, 1, 1002, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1000, 16)
go

insert into Users_Orgs (userId, organizationId) values (1000, 19)
go
insert into Users_Orgs (userId, organizationId) values (1000, 81)
go

insert into Users_Roles values (1000, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1005, 1, getdate(), getdate(), 0, 1006, 'test', 0, 0, 'kul4', 'test.kul.4@liferay.com', 'Welcome Test KUL 4!', 'Test', '', 'KUL 4', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1006, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 4', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1007, 1, 1005, 11, 1005, 0, 0, '1007', '/1007', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1008, 1, 1007, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1009, 1, 1007, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1005, 16)
go

insert into Users_Orgs (userId, organizationId) values (1005, 19)
go
insert into Users_Orgs (userId, organizationId) values (1005, 81)
go

insert into Users_Roles values (1005, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1010, 1, getdate(), getdate(), 0, 1011, 'test', 0, 0, 'kul5', 'test.kul.5@liferay.com', 'Welcome Test KUL 5!', 'Test', '', 'KUL 5', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1011, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 5', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1012, 1, 1010, 11, 1010, 0, 0, '1012', '/1012', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1013, 1, 1012, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1014, 1, 1012, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1010, 16)
go

insert into Users_Orgs (userId, organizationId) values (1010, 19)
go
insert into Users_Orgs (userId, organizationId) values (1010, 81)
go

insert into Users_Roles values (1010, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1015, 1, getdate(), getdate(), 0, 1016, 'test', 0, 0, 'kul6', 'test.kul.6@liferay.com', 'Welcome Test KUL 6!', 'Test', '', 'KUL 6', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1016, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 6', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1017, 1, 1015, 11, 1015, 0, 0, '1017', '/1017', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1018, 1, 1017, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1019, 1, 1017, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1015, 16)
go

insert into Users_Orgs (userId, organizationId) values (1015, 19)
go
insert into Users_Orgs (userId, organizationId) values (1015, 81)
go

insert into Users_Roles values (1015, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1020, 1, getdate(), getdate(), 0, 1021, 'test', 0, 0, 'kul7', 'test.kul.7@liferay.com', 'Welcome Test KUL 7!', 'Test', '', 'KUL 7', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1021, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 7', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1022, 1, 1020, 11, 1020, 0, 0, '1022', '/1022', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1023, 1, 1022, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1024, 1, 1022, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1020, 16)
go

insert into Users_Orgs (userId, organizationId) values (1020, 19)
go
insert into Users_Orgs (userId, organizationId) values (1020, 81)
go

insert into Users_Roles values (1020, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1025, 1, getdate(), getdate(), 0, 1026, 'test', 0, 0, 'kul8', 'test.kul.8@liferay.com', 'Welcome Test KUL 8!', 'Test', '', 'KUL 8', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1026, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 8', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1027, 1, 1025, 11, 1025, 0, 0, '1027', '/1027', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1028, 1, 1027, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1029, 1, 1027, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1025, 16)
go

insert into Users_Orgs (userId, organizationId) values (1025, 19)
go
insert into Users_Orgs (userId, organizationId) values (1025, 81)
go

insert into Users_Roles values (1025, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1030, 1, getdate(), getdate(), 0, 1031, 'test', 0, 0, 'kul9', 'test.kul.9@liferay.com', 'Welcome Test KUL 9!', 'Test', '', 'KUL 9', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1031, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 9', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1032, 1, 1030, 11, 1030, 0, 0, '1032', '/1032', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1033, 1, 1032, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1034, 1, 1032, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1030, 16)
go

insert into Users_Orgs (userId, organizationId) values (1030, 19)
go
insert into Users_Orgs (userId, organizationId) values (1030, 81)
go

insert into Users_Roles values (1030, 15)
go

insert into User_ (userId, companyId, createDate, modifiedDate, defaultUser, contactId, password_, passwordEncrypted, passwordReset, screenName, emailAddress, greeting, firstName, middleName, lastName, loginDate, failedLoginAttempts, agreedToTermsOfUse, active_) values (1035, 1, getdate(), getdate(), 0, 1036, 'test', 0, 0, 'kul10', 'test.kul.10@liferay.com', 'Welcome Test KUL 10!', 'Test', '', 'KUL 10', getdate(), 0, 1, 1)
go
insert into Contact_ (contactId, companyId, userId, userName, createDate, modifiedDate, accountId, parentContactId, firstName, middleName, lastName, male, birthday) values (1036, 1, 2, 'Joe Bloggs', getdate(), getdate(), 7, 0, 'Test', '', 'KUL 10', 1, '19700101')
go

insert into Group_ (groupId, companyId, creatorUserId, classNameId, classPK, parentGroupId, liveGroupId, name, friendlyURL, active_) values (1037, 1, 1035, 11, 1035, 0, 0, '1037', '/1037', 1)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1038, 1, 1037, 1, 0, 'classic', '01', 0)
go
insert into LayoutSet (layoutSetId, companyId, groupId, privateLayout, logo, themeId, colorSchemeId, pageCount) values (1039, 1, 1037, 0, 0, 'classic', '01', 0)
go

insert into Users_Groups values (1035, 16)
go

insert into Users_Orgs (userId, organizationId) values (1035, 19)
go
insert into Users_Orgs (userId, organizationId) values (1035, 81)
go

insert into Users_Roles values (1035, 15)
go












insert into Release_ (releaseId, createDate, modifiedDate, buildNumber, verified) values (1, getdate(), getdate(), 5203, 0)
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
create unique index IX_BA4413D5 on AnnouncementsDelivery (userId, type_)
go

create index IX_A6EF0B81 on AnnouncementsEntry (classNameId, classPK)
go
create index IX_D49C2E66 on AnnouncementsEntry (userId)
go
create index IX_1AFBDE08 on AnnouncementsEntry (uuid_)
go

create index IX_9C7EB9F on AnnouncementsFlag (entryId)
go
create unique index IX_4539A99C on AnnouncementsFlag (userId, entryId, value)
go

create index IX_72EF6041 on BlogsEntry (companyId)
go
create index IX_81A50303 on BlogsEntry (groupId)
go
create unique index IX_DB780A20 on BlogsEntry (groupId, urlTitle)
go
create index IX_C07CA83D on BlogsEntry (groupId, userId)
go
create index IX_69157A4D on BlogsEntry (uuid_)
go
create unique index IX_1B1040FD on BlogsEntry (uuid_, groupId)
go

create index IX_90CDA39A on BlogsStatsUser (companyId, entryCount)
go
create index IX_43840EEB on BlogsStatsUser (groupId)
go
create index IX_28C78D5C on BlogsStatsUser (groupId, entryCount)
go
create unique index IX_82254C25 on BlogsStatsUser (groupId, userId)
go
create index IX_BB51F1D9 on BlogsStatsUser (userId)
go

create index IX_443BDC38 on BookmarksEntry (folderId)
go
create index IX_E52FF7EF on BookmarksEntry (groupId)
go
create index IX_E2E9F129 on BookmarksEntry (groupId, userId)
go
create index IX_B670BA39 on BookmarksEntry (uuid_)
go
create unique index IX_EAA02A91 on BookmarksEntry (uuid_, groupId)
go

create index IX_2ABA25D7 on BookmarksFolder (companyId)
go
create index IX_7F703619 on BookmarksFolder (groupId)
go
create index IX_967799C0 on BookmarksFolder (groupId, parentFolderId)
go
create index IX_451E7AE3 on BookmarksFolder (uuid_)
go
create unique index IX_DC2F8927 on BookmarksFolder (uuid_, groupId)
go

create unique index IX_E7B95510 on BrowserTracker (userId)
go

create index IX_D6FD9496 on CalEvent (companyId)
go
create index IX_12EE4898 on CalEvent (groupId)
go
create index IX_FCD7C63D on CalEvent (groupId, type_)
go
create index IX_F6006202 on CalEvent (remindBy)
go
create index IX_C1AD2122 on CalEvent (uuid_)
go
create unique index IX_5CCE79C8 on CalEvent (uuid_, groupId)
go

create unique index IX_B27A301F on ClassName_ (value)
go

create index IX_38EFE3FD on Company (logoId)
go
create index IX_12566EC2 on Company (mx)
go
create unique index IX_975996C0 on Company (virtualHost)
go
create unique index IX_EC00543C on Company (webId)
go

create index IX_66D496A3 on Contact_ (companyId)
go

create unique index IX_717B97E1 on Country (a2)
go
create unique index IX_717B9BA2 on Country (a3)
go
create unique index IX_19DA007B on Country (name)
go

create index IX_4CB1B2B4 on DLFileEntry (companyId)
go
create index IX_24A846D1 on DLFileEntry (folderId)
go
create unique index IX_8F6C75D0 on DLFileEntry (folderId, name)
go
create index IX_A9951F17 on DLFileEntry (folderId, title)
go
create index IX_F4AF5636 on DLFileEntry (groupId)
go
create index IX_43261870 on DLFileEntry (groupId, userId)
go
create index IX_64F0FE40 on DLFileEntry (uuid_)
go
create unique index IX_BC2E7E6A on DLFileEntry (uuid_, groupId)
go

create unique index IX_CE705D48 on DLFileRank (companyId, userId, folderId, name)
go
create index IX_40B56512 on DLFileRank (folderId, name)
go
create index IX_BAFB116E on DLFileRank (groupId, userId)
go
create index IX_EED06670 on DLFileRank (userId)
go

create index IX_E56EC6AD on DLFileShortcut (folderId)
go
create index IX_CA2708A2 on DLFileShortcut (toFolderId, toName)
go
create index IX_4831EBE4 on DLFileShortcut (uuid_)
go
create unique index IX_FDB4A946 on DLFileShortcut (uuid_, groupId)
go

create index IX_9CD91DB6 on DLFileVersion (folderId, name)
go
create unique index IX_6C5E6512 on DLFileVersion (folderId, name, version)
go

create index IX_A74DB14C on DLFolder (companyId)
go
create index IX_F2EA1ACE on DLFolder (groupId)
go
create index IX_49C37475 on DLFolder (groupId, parentFolderId)
go
create unique index IX_902FD874 on DLFolder (groupId, parentFolderId, name)
go
create index IX_51556082 on DLFolder (parentFolderId, name)
go
create index IX_CBC408D8 on DLFolder (uuid_)
go
create unique index IX_3CC1DED2 on DLFolder (uuid_, groupId)
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
create unique index IX_FEFC8DA7 on ExpandoColumn (tableId, name)
go

create index IX_D3F5D7AE on ExpandoRow (tableId)
go
create unique index IX_81EFBFF5 on ExpandoRow (tableId, classPK)
go

create index IX_B5AE8A85 on ExpandoTable (companyId, classNameId)
go
create unique index IX_37562284 on ExpandoTable (companyId, classNameId, name)
go

create index IX_B29FEF17 on ExpandoValue (classNameId, classPK)
go
create index IX_F7DD0987 on ExpandoValue (columnId)
go
create unique index IX_9DDD21E5 on ExpandoValue (columnId, rowId_)
go
create index IX_9112A7A0 on ExpandoValue (rowId_)
go
create index IX_F0566A77 on ExpandoValue (tableId)
go
create index IX_1BD3F4C on ExpandoValue (tableId, classPK)
go
create index IX_CA9AFB7C on ExpandoValue (tableId, columnId)
go
create unique index IX_D27B03E7 on ExpandoValue (tableId, columnId, classPK)
go
create index IX_B71E92D5 on ExpandoValue (tableId, rowId_)
go

create unique index IX_D0D5E397 on Group_ (companyId, classNameId, classPK)
go
create unique index IX_5DE0BE11 on Group_ (companyId, classNameId, liveGroupId, name)
go
create unique index IX_5BDDB872 on Group_ (companyId, friendlyURL)
go
create unique index IX_BBCA55B on Group_ (companyId, liveGroupId, name)
go
create unique index IX_5AA68501 on Group_ (companyId, name)
go
create index IX_16218A38 on Group_ (liveGroupId)
go

create index IX_75267DCA on Groups_Orgs (groupId)
go
create index IX_6BBB7682 on Groups_Orgs (organizationId)
go

create index IX_C48736B on Groups_Permissions (groupId)
go
create index IX_EC97689D on Groups_Permissions (permissionId)
go

create index IX_84471FD2 on Groups_Roles (groupId)
go
create index IX_3103EF3D on Groups_Roles (roleId)
go

create index IX_31FB749A on Groups_UserGroups (groupId)
go
create index IX_3B69160F on Groups_UserGroups (userGroupId)
go

create index IX_60214CF6 on IGFolder (companyId)
go
create index IX_206498F8 on IGFolder (groupId)
go
create index IX_1A605E9F on IGFolder (groupId, parentFolderId)
go
create unique index IX_9BBAFB1E on IGFolder (groupId, parentFolderId, name)
go
create index IX_F73C0982 on IGFolder (uuid_)
go
create unique index IX_B10EFD68 on IGFolder (uuid_, groupId)
go

create index IX_E597322D on IGImage (custom1ImageId)
go
create index IX_D9E0A34C on IGImage (custom2ImageId)
go
create index IX_4438CA80 on IGImage (folderId)
go
create index IX_BCB13A3F on IGImage (folderId, name)
go
create index IX_63820A7 on IGImage (groupId)
go
create index IX_BE79E1E1 on IGImage (groupId, userId)
go
create index IX_64F0B572 on IGImage (largeImageId)
go
create index IX_D3D32126 on IGImage (smallImageId)
go
create index IX_265BB0F1 on IGImage (uuid_)
go
create unique index IX_E97342D9 on IGImage (uuid_, groupId)
go

create index IX_6A925A4D on Image (size_)
go

create index IX_13EE3871 on InstanceBean (status)
go

create index IX_DFF98523 on JournalArticle (companyId)
go
create index IX_9356F865 on JournalArticle (groupId)
go
create index IX_68C0F69C on JournalArticle (groupId, articleId)
go
create unique index IX_85C52EEC on JournalArticle (groupId, articleId, version)
go
create index IX_2E207659 on JournalArticle (groupId, structureId)
go
create index IX_8DEAE14E on JournalArticle (groupId, templateId)
go
create index IX_22882D02 on JournalArticle (groupId, urlTitle)
go
create index IX_EF9B7028 on JournalArticle (smallImageId)
go
create index IX_F029602F on JournalArticle (uuid_)
go
create unique index IX_3463D95B on JournalArticle (uuid_, groupId)
go

create index IX_3B51BB68 on JournalArticleImage (groupId)
go
create index IX_158B526F on JournalArticleImage (groupId, articleId, version)
go
create unique index IX_103D6207 on JournalArticleImage (groupId, articleId, version, elInstanceId, elName, languageId)
go

create index IX_F8433677 on JournalArticleResource (groupId)
go
create unique index IX_88DF994A on JournalArticleResource (groupId, articleId)
go

create index IX_6838E427 on JournalContentSearch (groupId, articleId)
go

create index IX_35A2DB2F on JournalFeed (groupId)
go
create unique index IX_65576CBC on JournalFeed (groupId, feedId)
go
create index IX_50C36D79 on JournalFeed (uuid_)
go
create unique index IX_39031F51 on JournalFeed (uuid_, groupId)
go

create index IX_B97F5608 on JournalStructure (groupId)
go
create index IX_CA0BD48C on JournalStructure (groupId, parentStructureId)
go
create unique index IX_AB6E9996 on JournalStructure (groupId, structureId)
go
create index IX_8831E4FC on JournalStructure (structureId)
go
create index IX_6702CA92 on JournalStructure (uuid_)
go
create unique index IX_42E86E58 on JournalStructure (uuid_, groupId)
go

create index IX_77923653 on JournalTemplate (groupId)
go
create index IX_1701CB2B on JournalTemplate (groupId, structureId)
go
create unique index IX_E802AA3C on JournalTemplate (groupId, templateId)
go
create index IX_25FFB6FA on JournalTemplate (smallImageId)
go
create index IX_1B12CA20 on JournalTemplate (templateId)
go
create index IX_2857419D on JournalTemplate (uuid_)
go
create unique index IX_62D1B3AD on JournalTemplate (uuid_, groupId)
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
create unique index IX_8ABC4E3B on MBBan (groupId, banUserId)
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
create unique index IX_F7D28C2F on MBCategory (uuid_, groupId)
go

create index IX_79D0120B on MBDiscussion (classNameId)
go
create unique index IX_33A4DE38 on MBDiscussion (classNameId, classPK)
go
create unique index IX_B5CA2DC on MBDiscussion (threadId)
go

create unique index IX_ADA16FE7 on MBMailingList (categoryId)
go
create index IX_4115EC7A on MBMailingList (uuid_)
go
create unique index IX_E858F170 on MBMailingList (uuid_, groupId)
go

create index IX_3C865EE5 on MBMessage (categoryId)
go
create index IX_138C7F1E on MBMessage (categoryId, threadId)
go
create index IX_51A8D44D on MBMessage (classNameId, classPK)
go
create index IX_B1432D30 on MBMessage (companyId)
go
create index IX_5B153FB2 on MBMessage (groupId)
go
create index IX_8EB8C5EC on MBMessage (groupId, userId)
go
create index IX_75B95071 on MBMessage (threadId)
go
create index IX_A7038CD7 on MBMessage (threadId, parentMessageId)
go
create index IX_C57B16BC on MBMessage (uuid_)
go
create unique index IX_8D12316E on MBMessage (uuid_, groupId)
go

create index IX_D180D4AE on MBMessageFlag (messageId)
go
create index IX_A6973A8E on MBMessageFlag (messageId, flag)
go
create index IX_C1C9A8FD on MBMessageFlag (threadId)
go
create index IX_3CFD579D on MBMessageFlag (threadId, flag)
go
create index IX_7B2917BE on MBMessageFlag (userId)
go
create unique index IX_E9EB6194 on MBMessageFlag (userId, messageId, flag)
go
create index IX_2EA537D7 on MBMessageFlag (userId, threadId, flag)
go

create index IX_A00A898F on MBStatsUser (groupId)
go
create index IX_FAB5A88B on MBStatsUser (groupId, messageCount)
go
create unique index IX_9168E2C9 on MBStatsUser (groupId, userId)
go
create index IX_847F92B5 on MBStatsUser (userId)
go

create index IX_CB854772 on MBThread (categoryId)
go
create index IX_19D8B60A on MBThread (categoryId, lastPostDate)
go
create index IX_95C0EA45 on MBThread (groupId)
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
create unique index IX_E301BDF5 on Organization_ (companyId, name)
go
create index IX_418E4522 on Organization_ (companyId, parentOrganizationId)
go

create unique index IX_3FBFA9F4 on PasswordPolicy (companyId, name)
go

create index IX_C3A17327 on PasswordPolicyRel (classNameId, classPK)
go
create index IX_ED7CF243 on PasswordPolicyRel (passwordPolicyId, classNameId, classPK)
go

create index IX_326F75BD on PasswordTracker (userId)
go

create unique index IX_4D19C2B8 on Permission_ (actionId, resourceId)
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
create unique index IX_7171B2E8 on PluginSetting (companyId, pluginId, pluginType)
go

create index IX_EC370F10 on PollsChoice (questionId)
go
create unique index IX_D76DD2CF on PollsChoice (questionId, name)
go
create index IX_6660B399 on PollsChoice (uuid_)
go

create index IX_9FF342EA on PollsQuestion (groupId)
go
create index IX_51F087F4 on PollsQuestion (uuid_)
go
create unique index IX_F3C9F36 on PollsQuestion (uuid_, groupId)
go

create index IX_D5DF7B54 on PollsVote (choiceId)
go
create index IX_12112599 on PollsVote (questionId)
go
create unique index IX_1BBFD4D3 on PollsVote (questionId, userId)
go

create index IX_80CC9508 on Portlet (companyId)
go
create unique index IX_12B5E51D on Portlet (companyId, portletId)
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
create unique index IX_C7057FF7 on PortletPreferences (ownerId, ownerType, plid, portletId)
go
create index IX_F15C1C4F on PortletPreferences (plid)
go
create index IX_D340DB76 on PortletPreferences (plid, portletId)
go

create index IX_16184D57 on RatingsEntry (classNameId, classPK)
go
create unique index IX_B47E3C11 on RatingsEntry (userId, classNameId, classPK)
go

create unique index IX_A6E99284 on RatingsStats (classNameId, classPK)
go

create index IX_16D87CA7 on Region (countryId)
go

create index IX_882E56F on ReportsEntry (companyId)
go
create index IX_C74E5453 on ReportsEntry (userId)
go

create index IX_81F2DB09 on ResourceAction (name)
go
create unique index IX_EDB9986E on ResourceAction (name, actionId)
go

create index IX_717FDD47 on ResourceCode (companyId)
go
create unique index IX_A32C097E on ResourceCode (companyId, name, scope)
go
create index IX_AACAFF40 on ResourceCode (name)
go

create index IX_60B99860 on ResourcePermission (companyId, name, scope)
go
create index IX_2200AA69 on ResourcePermission (companyId, name, scope, primKey)
go
create unique index IX_8D83D0CE on ResourcePermission (companyId, name, scope, primKey, roleId)
go
create index IX_A37A0588 on ResourcePermission (roleId)
go

create index IX_2578FBD3 on Resource_ (codeId)
go
create unique index IX_67DE7856 on Resource_ (codeId, primKey)
go

create index IX_449A10B9 on Role_ (companyId)
go
create unique index IX_A88E424E on Role_ (companyId, classNameId, classPK)
go
create unique index IX_EBC931B8 on Role_ (companyId, name)
go
create index IX_CBE204 on Role_ (type_, subtype)
go

create index IX_7A3619C6 on Roles_Permissions (permissionId)
go
create index IX_E04E486D on Roles_Permissions (roleId)
go

create index IX_3BB93ECA on SCFrameworkVersi_SCProductVers (frameworkVersionId)
go
create index IX_E8D33FF9 on SCFrameworkVersi_SCProductVers (productVersionId)
go

create index IX_C98C0D78 on SCFrameworkVersion (companyId)
go
create index IX_272991FA on SCFrameworkVersion (groupId)
go


create index IX_27006638 on SCLicenses_SCProductEntries (licenseId)
go
create index IX_D7710A66 on SCLicenses_SCProductEntries (productEntryId)
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
create unique index IX_4F0315B8 on ServiceComponent (buildNamespace, buildNumber)
go

create index IX_DA5F4359 on Shard (classNameId, classPK)
go
create index IX_941BA8C3 on Shard (name)
go

create index IX_C28B41DC on ShoppingCart (groupId)
go
create unique index IX_FC46FE16 on ShoppingCart (groupId, userId)
go
create index IX_54101CC8 on ShoppingCart (userId)
go

create index IX_5F615D3E on ShoppingCategory (groupId)
go
create index IX_1E6464F5 on ShoppingCategory (groupId, parentCategoryId)
go

create unique index IX_DC60CFAE on ShoppingCoupon (code_)
go
create index IX_3251AF16 on ShoppingCoupon (groupId)
go

create index IX_C8EACF2E on ShoppingItem (categoryId)
go
create unique index IX_1C717CA6 on ShoppingItem (companyId, sku)
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
create unique index IX_D7D6E87A on ShoppingOrder (number_)
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
create unique index IX_8F32DEC9 on SocialActivity (groupId, userId, createDate, classNameId, classPK, type_, receiverUserId)
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
create unique index IX_12A92145 on SocialRelation (userId1, userId2, type_)
go
create index IX_5A40D18D on SocialRelation (userId2)
go
create index IX_3F9C2FA8 on SocialRelation (userId2, type_)
go
create index IX_F0CA24A5 on SocialRelation (uuid_)
go

create index IX_D3425487 on SocialRequest (classNameId, classPK, type_, receiverUserId, status)
go
create index IX_A90FE5A0 on SocialRequest (companyId)
go
create index IX_32292ED1 on SocialRequest (receiverUserId)
go
create index IX_D9380CB7 on SocialRequest (receiverUserId, status)
go
create index IX_80F7A9C2 on SocialRequest (userId)
go
create unique index IX_36A90CA7 on SocialRequest (userId, classNameId, classPK, type_, receiverUserId)
go
create index IX_CC86A444 on SocialRequest (userId, classNameId, classPK, type_, status)
go
create index IX_AB5906A8 on SocialRequest (userId, status)
go
create index IX_49D5872C on SocialRequest (uuid_)
go
create unique index IX_4F973EFE on SocialRequest (uuid_, groupId)
go

create index IX_786D171A on Subscription (companyId, classNameId, classPK)
go
create unique index IX_2E1A92D4 on Subscription (companyId, userId, classNameId, classPK)
go
create index IX_54243AFD on Subscription (userId)
go
create index IX_E8F34171 on Subscription (userId, classNameId)
go

create unique index IX_1AB6D6D2 on TagsAsset (classNameId, classPK)
go
create index IX_AB3D8BCB on TagsAsset (companyId)
go

create index IX_B22F3A1 on TagsAssets_TagsEntries (assetId)
go
create index IX_A02A8023 on TagsAssets_TagsEntries (entryId)
go

create index IX_EE55ED49 on TagsEntry (parentEntryId, vocabularyId)
go
create index IX_28E8954 on TagsEntry (vocabularyId)
go

create index IX_C134234 on TagsProperty (companyId)
go
create index IX_EB974D08 on TagsProperty (companyId, key_)
go
create index IX_5200A629 on TagsProperty (entryId)
go
create unique index IX_F505253D on TagsProperty (entryId, key_)
go

create unique index IX_F9E51044 on TagsVocabulary (groupId, name)
go

create unique index IX_181A4A1B on TasksProposal (classNameId, classPK)
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
create unique index IX_5C6BE4C7 on TasksReview (userId, proposalId)
go

create index IX_524FEFCE on UserGroup (companyId)
go
create unique index IX_23EAD0D on UserGroup (companyId, name)
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

create unique index IX_41A32E0D on UserIdMapper (type_, externalUserId)
go
create index IX_E60EA987 on UserIdMapper (userId)
go
create unique index IX_D1C44A6E on UserIdMapper (userId, type_)
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
create unique index IX_615E9F7A on User_ (companyId, emailAddress)
go
create unique index IX_C5806019 on User_ (companyId, screenName)
go
create unique index IX_9782AD88 on User_ (companyId, userId)
go
create unique index IX_5ADBE171 on User_ (contactId)
go
create index IX_762F63C6 on User_ (emailAddress)
go
create index IX_A9ED7DD3 on User_ (openId)
go
create index IX_A18034A4 on User_ (portraitId)
go
create index IX_E0422BDA on User_ (uuid_)
go

create index IX_C4F9E699 on Users_Groups (groupId)
go
create index IX_F10B6C6B on Users_Groups (userId)
go

create index IX_7EF4EC0E on Users_Orgs (organizationId)
go
create index IX_FB646CA6 on Users_Orgs (userId)
go

create index IX_8AE58A91 on Users_Permissions (permissionId)
go
create index IX_C26AA64D on Users_Permissions (userId)
go

create index IX_C19E5F31 on Users_Roles (roleId)
go
create index IX_C1A01806 on Users_Roles (userId)
go

create index IX_66FF2503 on Users_UserGroups (userGroupId)
go
create index IX_BE8102D6 on Users_UserGroups (userId)
go

create unique index IX_97DFA146 on WebDAVProps (classNameId, classPK)
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
create unique index IX_920CD8B1 on WikiNode (groupId, name)
go
create index IX_6C112D7C on WikiNode (uuid_)
go
create unique index IX_7609B2AE on WikiNode (uuid_, groupId)
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
create unique index IX_3D4AF476 on WikiPage (nodeId, title, version)
go
create index IX_9C0E478F on WikiPage (uuid_)
go
create unique index IX_899D3DFB on WikiPage (uuid_, groupId)
go

create unique index IX_21277664 on WikiPageResource (nodeId, title)
go

create index IX_205EC031 on instancebean (status)
go

create index IX_6B798ECC on log_workflow_journal_article (resourcePrimkey)
go

create index IX_66B4029 on nss_contact_book (companyid)
go

create index IX_E9CED857 on nss_quan_ly_quy_trinh_duyet_tin (workflowname, version_)
go

create index IX_895462F4 on nss_signature (articleId)
go
create index IX_55D889C4 on nss_signature (articlePrimKey)
go
create index IX_4B61DDFE on nss_signature (articlePrimKey, userId)
go
create index IX_A890C763 on nss_signature (articlePrimKey, userId, articleId)
go

create index IX_3C7F46EA on nss_workflow_journal_article (processInstanceId)
go
create index IX_7BD52FD6 on nss_workflow_journal_article (resourcePrimkey)
go

