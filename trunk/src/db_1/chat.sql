-- Table: chat_entry

-- DROP TABLE chat_entry;

CREATE TABLE chat_entry
(
  entryid bigint NOT NULL,
  createdate bigint,
  fromuserid bigint,
  touserid bigint,
  "content" text,
  CONSTRAINT chat_entry_pkey PRIMARY KEY (entryid)
)
WITH (OIDS=FALSE);
ALTER TABLE chat_entry OWNER TO postgres;

-- Index: ix_16384be6

-- DROP INDEX ix_16384be6;

CREATE INDEX ix_16384be6
  ON chat_entry
  USING btree
  (touserid);

-- Index: ix_2a17a23f

-- DROP INDEX ix_2a17a23f;

CREATE INDEX ix_2a17a23f
  ON chat_entry
  USING btree
  (fromuserid, touserid, content);

-- Index: ix_8be273a4

-- DROP INDEX ix_8be273a4;

CREATE INDEX ix_8be273a4
  ON chat_entry
  USING btree
  (createdate, touserid);

-- Index: ix_ad559d93

-- DROP INDEX ix_ad559d93;

CREATE INDEX ix_ad559d93
  ON chat_entry
  USING btree
  (createdate, fromuserid);

-- Index: ix_d9e49928

-- DROP INDEX ix_d9e49928;

CREATE INDEX ix_d9e49928
  ON chat_entry
  USING btree
  (createdate, fromuserid, touserid);

-- Index: ix_daef230f

-- DROP INDEX ix_daef230f;

CREATE INDEX ix_daef230f
  ON chat_entry
  USING btree
  (createdate);

-- Index: ix_f9966d55

-- DROP INDEX ix_f9966d55;

CREATE INDEX ix_f9966d55
  ON chat_entry
  USING btree
  (fromuserid);

-- Table: chat_status

-- DROP TABLE chat_status;

CREATE TABLE chat_status
(
  statusid bigint NOT NULL,
  userid bigint,
  modifieddate bigint,
  online_ boolean,
  awake boolean,
  activebrowserkey character varying(75),
  activepanelid character varying(75),
  message text,
  playsound boolean,
  CONSTRAINT chat_status_pkey PRIMARY KEY (statusid)
)
WITH (OIDS=FALSE);
ALTER TABLE chat_status OWNER TO postgres;

-- Index: ix_15bd544a

-- DROP INDEX ix_15bd544a;

CREATE INDEX ix_15bd544a
  ON chat_status
  USING btree
  (modifieddate);

-- Index: ix_32531b3d

-- DROP INDEX ix_32531b3d;

CREATE INDEX ix_32531b3d
  ON chat_status
  USING btree
  (online_);

-- Index: ix_b723b792

-- DROP INDEX ix_b723b792;

CREATE INDEX ix_b723b792
  ON chat_status
  USING btree
  (modifieddate, online_);

-- Index: ix_e17ebd79

-- DROP INDEX ix_e17ebd79;

CREATE INDEX ix_e17ebd79
  ON chat_status
  USING btree
  (userid);

-- Table: nss_thong_tin_can_thiet

-- DROP TABLE nss_thong_tin_can_thiet;

CREATE TABLE nss_thong_tin_can_thiet
(
  mathongtincanthiet bigint NOT NULL,
  tenthongtincanthiet character varying(75),
  urlwebsite character varying(75),
  motathongtincanthiet character varying(75),
  companyid bigint,
  userid bigint,
  createdate date,
  modifieddate date,
  thututhongtin integer,
  target character varying(75),
  imageid_liferay bigint,
  active_ integer,
  CONSTRAINT nss_thong_tin_can_thiet_pkey PRIMARY KEY (mathongtincanthiet)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE nss_thong_tin_can_thiet OWNER TO postgres;

-- Table: nss_quang_cao

-- DROP TABLE nss_quang_cao;

CREATE TABLE nss_quang_cao
(
  maquangcao bigint NOT NULL,
  tenquangcao character varying(75),
  urlwebsite character varying(75),
  motaquangcao character varying(75),
  companyid bigint,
  userid bigint,
  createdate date,
  modifieddate date,
  thutuquangcao integer,
  target character varying(75),
  imageid_liferay bigint,
  active_ integer,
  CONSTRAINT nss_quang_cao_pkey PRIMARY KEY (maquangcao)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_quang_cao OWNER TO postgres;


-- Table: nss_loai_thu_tuc

-- DROP TABLE nss_loai_thu_tuc;

CREATE TABLE nss_loai_thu_tuc
(
  maloaithutuchanhchinh bigint NOT NULL,
  tenloaithutuchanhchinh character varying(75),
  companyid bigint,
  userid bigint,
  createdate date,
  modifieddate date,
  active integer,
  description character varying(75),
  CONSTRAINT nss_loai_thu_tuc_pkey PRIMARY KEY (maloaithutuchanhchinh)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_loai_thu_tuc OWNER TO postgres;


-- Table: nss_linh_vuc_thu_tuc

-- DROP TABLE nss_linh_vuc_thu_tuc;

CREATE TABLE nss_linh_vuc_thu_tuc
(
  malinhvucthutuchanhchinh bigint NOT NULL,
  tenlinhvucthutuchanhchinh character varying(75),
  maloaithutuchanhchinh bigint,
  companyid bigint,
  userid bigint,
  createdate date,
  modifieddate date,
  active integer,
  description character varying(75),
  CONSTRAINT nss_linh_vuc_thu_tuc_pkey PRIMARY KEY (malinhvucthutuchanhchinh)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_linh_vuc_thu_tuc OWNER TO postgres;


-- Table: nss_don_vi_thu_tuc

-- DROP TABLE nss_don_vi_thu_tuc;

CREATE TABLE nss_don_vi_thu_tuc
(
  ma_don_vi_thu_tuc bigint NOT NULL,
  ten_don_vi_thu_tuc character varying(75),
  companyid bigint,
  userid bigint,
  createdate date,
  modifieddate date,
  active integer,
  description character varying(75),
  CONSTRAINT nss_don_vi_thu_tuc_pkey PRIMARY KEY (ma_don_vi_thu_tuc)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_don_vi_thu_tuc OWNER TO postgres;


-- Table: nss_thu_tuc_hanh_chinh

-- DROP TABLE nss_thu_tuc_hanh_chinh;

CREATE TABLE nss_thu_tuc_hanh_chinh
(
  mathutuchanhchinh bigint NOT NULL,
  tenthutuchanhchinh character varying(200),
  diachilienhe character varying(200),
  malinhvucthutuchanhchinh bigint,
  madonvithutuchanhchinh bigint,
  companyid bigint,
  userid bigint,
  createdate date,
  modifieddate date,
  active integer,
  description character varying(75),
  CONSTRAINT nss_thu_tuc_hanh_chinh_pkey PRIMARY KEY (mathutuchanhchinh)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_thu_tuc_hanh_chinh OWNER TO postgres;


-- Table: nss_file_dinh_kem_tthc

-- DROP TABLE nss_file_dinh_kem_tthc;

CREATE TABLE nss_file_dinh_kem_tthc
(
  mafiledinhkemtthc bigint NOT NULL,
  mathutuchanhchinh bigint,
  tenfile character varying(100),
  mo_ta character varying(100),
  kichthuoc bigint,
  duongdan character varying(100),
  phienban integer,
  CONSTRAINT nss_file_dinh_kem_tthc_pkey PRIMARY KEY (mafiledinhkemtthc)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_file_dinh_kem_tthc OWNER TO postgres;

-- Table: nss_qa_chu_de

-- DROP TABLE nss_qa_chu_de;

CREATE TABLE nss_qa_chu_de
(
  machudecauhoi bigint NOT NULL,
  tenchudecauhoi character varying(200),
  active integer,
  CONSTRAINT nss_qa_chu_de_pkey PRIMARY KEY (machudecauhoi)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_qa_chu_de OWNER TO postgres;

-- Table: nss_qa_cau_hoi

-- DROP TABLE nss_qa_cau_hoi;

CREATE TABLE nss_qa_cau_hoi
(
  macauhoiqa bigint NOT NULL,
  machudecauhoi bigint,
  tieude character varying(200),
  tennguoihoi character varying(75),
  email character varying(75),
  noidunghoi character varying(3000),
  createdate timestamp without time zone,
  publishdate timestamp without time zone,
  publish boolean,
  CONSTRAINT nss_qa_cau_hoi_pkey PRIMARY KEY (macauhoiqa)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_qa_cau_hoi OWNER TO postgres;


-- Table: nss_qa_file_dinh_kem

-- DROP TABLE nss_qa_file_dinh_kem;

CREATE TABLE nss_qa_file_dinh_kem
(
  mafiledinhkemqa bigint NOT NULL,
  macauhoi bigint,
  macautraloi bigint,
  tenfile character varying(200),
  kichthuoc bigint,
  duongdan character varying(200),
  CONSTRAINT nss_qa_file_dinh_kem_pkey PRIMARY KEY (mafiledinhkemqa)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_qa_file_dinh_kem OWNER TO postgres;

-- Table: nss_qa_cau_tra_loi

-- DROP TABLE nss_qa_cau_tra_loi;

CREATE TABLE nss_qa_cau_tra_loi
(
  macautraloiqa bigint NOT NULL,
  macauhoiqa bigint,
  manguoitraloi bigint,
  noidungtraloi character varying(3000),
  createdate timestamp without time zone,
  publishdate timestamp without time zone,
  publish boolean,
  CONSTRAINT nss_qa_cau_tra_loi_pkey PRIMARY KEY (macautraloiqa)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_qa_cau_tra_loi OWNER TO postgres;

-- Table: nss_qa_phan_quyen

-- DROP TABLE nss_qa_phan_quyen;

CREATE TABLE nss_qa_phan_quyen
(
  maphanquyen bigint NOT NULL,
  machudecauhoi bigint,
  manguoitraloi bigint,
  quyenxem boolean,
  quyencapnhat boolean,
  quyentraloi boolean,
  quyenduyet boolean,
  CONSTRAINT nss_qa_phan_quyen_pkey PRIMARY KEY (maphanquyen)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_qa_phan_quyen OWNER TO postgres;

-- table forum
-- Table: mbcategory

-- DROP TABLE mbcategory;

CREATE TABLE mbcategory
(
  uuid_ character varying(75),
  categoryid bigint NOT NULL,
  groupid bigint,
  companyid bigint,
  userid bigint,
  username character varying(75),
  createdate timestamp without time zone,
  modifieddate timestamp without time zone,
  parentcategoryid bigint,
  "name" character varying(75),
  description text,
  threadcount integer,
  messagecount integer,
  lastpostdate timestamp without time zone,
  image_liferay bigint,
  ordernumber integer ,
  CONSTRAINT mb
  CONSTRAINT mbcategory_pkey PRIMARY KEY (categoryid)
)
WITH (OIDS=FALSE);
ALTER TABLE mbcategory OWNER TO postgres;

-- Index: ix_bb870c11

-- DROP INDEX ix_bb870c11;

CREATE INDEX ix_bb870c11
  ON mbcategory
  USING btree
  (groupid);

-- Index: ix_bc735dcf

-- DROP INDEX ix_bc735dcf;

CREATE INDEX ix_bc735dcf
  ON mbcategory
  USING btree
  (companyid);

-- Index: ix_c2626edb

-- DROP INDEX ix_c2626edb;

CREATE INDEX ix_c2626edb
  ON mbcategory
  USING btree
  (uuid_);

-- Index: ix_ed292508

-- DROP INDEX ix_ed292508;

CREATE INDEX ix_ed292508
  ON mbcategory
  USING btree
  (groupid, parentcategoryid);

-- Index: ix_f7d28c2f

-- DROP INDEX ix_f7d28c2f;

CREATE UNIQUE INDEX ix_f7d28c2f
  ON mbcategory
  USING btree
  (uuid_, groupid);

--- end table forum

-- Table: nss_media_chu_de

-- DROP TABLE nss_media_chu_de;

CREATE TABLE nss_media_chu_de
(
  mamediachude bigint NOT NULL,
  tenmediachude character varying(75),
  active_ boolean,
  CONSTRAINT nss_media_chu_de_pkey PRIMARY KEY (mamediachude)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_media_chu_de OWNER TO postgres;

-- Table: nss_media_library

-- DROP TABLE nss_media_library;

CREATE TABLE nss_media_library
(
  mamedialibrary bigint NOT NULL,
  mamediachude bigint,
  tieudemedialibrary character varying(200),
  tenmedialibrary character varying(2000),
  kichthuoc bigint,
  luotxem bigint,
  duongdan character varying(2000),
  userid bigint,
  createdate timestamp without time zone,
  modifieddate timestamp without time zone,
  active_ boolean,
  CONSTRAINT nss_media_library_pkey PRIMARY KEY (mamedialibrary)
)
WITH (OIDS=FALSE);
ALTER TABLE nss_media_library OWNER TO postgres;



CREATE TABLE meetingcalcomponent
(
  mcalid bigint NOT NULL,
  groupids character varying(75),
  startdate timestamp without time zone,
  CONSTRAINT meetingcalcomponent_pkey PRIMARY KEY (mcalid)
)
WITH (OIDS=FALSE);
ALTER TABLE meetingcalcomponent OWNER TO postgres;

CREATE TABLE meetingcalendar
(
  uuid_ character varying(75),
  mcalid bigint NOT NULL,
  groupid bigint,
  companyid bigint,
  userid bigint,
  username character varying(75),
  state integer,
  place character varying(75),
  place_diff character varying(75),
  sponsor character varying(75),
  component character varying(75),
  note character varying(75),
  userapproved bigint,
  dateapproved timestamp without time zone,
  movemcalid bigint,
  repeatweek boolean,
  filename character varying(75),
  morning boolean,
  afternoon boolean,
  evening boolean,
  stt integer,
  "prior" boolean,
  CONSTRAINT meetingcalendar_pkey PRIMARY KEY (mcalid)
)
WITH (OIDS=FALSE);
ALTER TABLE meetingcalendar OWNER TO postgres;

CREATE TABLE meetingdetailweek
(
  mdweekid bigint NOT NULL,
  groupid bigint,
  companyid bigint,
  userid bigint,
  username character varying(75),
  focus text,
  note character varying(500),
  receive character varying(500),
  week bigint,
  "year" bigint,
  CONSTRAINT meetingdetailweek_pkey PRIMARY KEY (mdweekid)
)
WITH (OIDS=FALSE);
ALTER TABLE meetingdetailweek OWNER TO postgres;


