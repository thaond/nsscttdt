
create table nss_certificate (
	userId LONG not null primary key,
	x509Certificate TEXT null
);

create table nss_signature (
	signatureId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	articlePrimKey LONG,
	articleId VARCHAR(75) null,
	version DOUBLE,
	signData STRING null
);
