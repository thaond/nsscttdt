-- Table: pml_template

-- DROP TABLE pml_template;

CREATE TABLE pml_template
(
  templateid bigint NOT NULL,
  templatecode character varying(75),
  templatename character varying(75),
  numberofdocument integer,
  publishdate timestamp without time zone,
  departmentid character varying(75),
  CONSTRAINT pml_template_pkey PRIMARY KEY (templateid)
)
WITH (OIDS=FALSE);
ALTER TABLE pml_template OWNER TO postgres;

-- Table: pml_template_file

-- DROP TABLE pml_template_file;

CREATE TABLE pml_template_file
(
  filetemplateid bigint NOT NULL,
  templateid bigint,
  tenfile character varying(200),
  kichthuoc bigint,
  duongdan character varying(1000),
  CONSTRAINT pml_template_file_pkey PRIMARY KEY (filetemplateid)
)
WITH (OIDS=FALSE);
ALTER TABLE pml_template_file OWNER TO postgres;

-- Table: pml_file

-- DROP TABLE pml_file;

CREATE TABLE pml_file
(
  fileid character varying(30) NOT NULL,
  cityid character varying(20),
  districtid character varying(20),
  wardsid character varying(20),
  streetid character varying(20),
  exactreturningdate date,
  validdate date,
  expectedreturningdate date,
  applicationdate timestamp without time zone,
  othercontent text,
  briefcontent text,
  applicantname text,
  organization text,
  authorisedletter text,
  idnumber character varying(20),
  issuingdate date,
  issuingplace character varying(50),
  telephone character varying(50),
  gender character varying(1),
  streetnumber text,
  permanentaddress text,
  contactinfomation text,
  oldnumberreceipt character varying(50),
  numberreceipt character varying(50),
  filetypeid character varying(20),
  fieldid character varying(20),
  solvingtime numeric(18),
  amendedcontent text,
  landcheckingdate date,
  decisionnotice character varying(1),
  receiver character varying(50),
  datecreated date,
  lastupdate date,
  receiverid bigint,
  lasttestprocessinfo character varying(200),
  active character varying(1),
  generalorderno bigint,
  CONSTRAINT pml_file_pkey PRIMARY KEY (fileid)
)
WITH (OIDS=FALSE);
ALTER TABLE pml_file OWNER TO postgres;

-- Table: pml_organization_external

-- DROP TABLE pml_organization_external;

-- Table: pml_organization_external

-- DROP TABLE pml_organization_external;

CREATE TABLE pml_organization_external
(
  orgexternalid bigint NOT NULL,
  orgexternalcode character varying(75),
  orgexternalname character varying(75),
  isownerorg boolean,
  CONSTRAINT pml_organization_external_pkey PRIMARY KEY (orgexternalid)
)
WITH (OIDS=FALSE);
ALTER TABLE pml_organization_external OWNER TO postgres;


create table pml_receiver (
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

create table pml_receivergroup (
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


-- minh update 
CREATE TABLE pml_screencalendar_height
(
  screencalendarheightid bigint
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pml_screencalendar_height OWNER TO postgres;