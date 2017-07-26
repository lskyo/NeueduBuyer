prompt PL/SQL Developer import file
prompt Created on 2017年3月2日 by Administrator
set feedback off
set define off
prompt Dropping AREA...
drop table AREA cascade constraints;
prompt Dropping CATEGORY...
drop table CATEGORY cascade constraints;
prompt Dropping DEPARTMENT...
drop table DEPARTMENT cascade constraints;
prompt Dropping BALANCE...
drop table BALANCE cascade constraints;
prompt Dropping PROVIDER...
drop table PROVIDER cascade constraints;
prompt Dropping BUY...
drop table BUY cascade constraints;
prompt Dropping REPAIR...
drop table REPAIR cascade constraints;
prompt Dropping SCRAP...
drop table SCRAP cascade constraints;
prompt Dropping TRANSLATE...
drop table TRANSLATE cascade constraints;
prompt Dropping CHECKBALANCE...
drop table CHECKBALANCE cascade constraints;
prompt Dropping DEMO...
drop table DEMO cascade constraints;
prompt Dropping PRIVILEGELIST...
drop table PRIVILEGELIST cascade constraints;
prompt Dropping PRODUCT...
drop table PRODUCT cascade constraints;
prompt Dropping ROLELIST...
drop table ROLELIST cascade constraints;
prompt Dropping ROLEPRIVILEGE...
drop table ROLEPRIVILEGE cascade constraints;
prompt Dropping T_USER...
drop table T_USER cascade constraints;
prompt Dropping USERACCOUNT...
drop table USERACCOUNT cascade constraints;
prompt Creating AREA...
create table AREA
(
  areaid   NUMBER not null,
  areaname NVARCHAR2(50) not null,
  relative NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table AREA
  add constraint PK_AREA primary key (AREAID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table AREA
  add constraint UN_AREA_AREANAME unique (AREANAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating CATEGORY...
create table CATEGORY
(
  cid   NUMBER(9) not null,
  cname VARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CATEGORY
  add constraint PK_CATEGORY primary key (CID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CATEGORY
  add constraint UN_CATEGORY_CNAME unique (CNAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating DEPARTMENT...
create table DEPARTMENT
(
  departid   NUMBER not null,
  departname NVARCHAR2(20) not null,
  areaid     NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DEPARTMENT
  add constraint PK_DEPARTMENT primary key (DEPARTID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DEPARTMENT
  add constraint FK_DEPARTMENT_AREA foreign key (AREAID)
  references AREA (AREAID);

prompt Creating BALANCE...
create table BALANCE
(
  bid      NUMBER not null,
  bname    VARCHAR2(50) not null,
  bcount   NUMBER(7) not null,
  price    NUMBER(7,2) not null,
  bdate    DATE not null,
  cid      NUMBER not null,
  departid NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BALANCE
  add constraint PK_BALANCE primary key (BID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BALANCE
  add constraint UN_BALANCE_BNAME unique (BNAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BALANCE
  add constraint FK_BALANCE_CATEGORY foreign key (CID)
  references CATEGORY (CID);
alter table BALANCE
  add constraint FK_BALANCE_DEPARTMENT foreign key (DEPARTID)
  references DEPARTMENT (DEPARTID);

prompt Creating PROVIDER...
create table PROVIDER
(
  provid   NUMBER not null,
  provname VARCHAR2(50) not null,
  address  VARCHAR2(50) not null,
  phone    VARCHAR2(20) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PROVIDER
  add constraint PK_PROVIDER primary key (PROVID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PROVIDER
  add constraint UN_PROVIDER_PROVIDER_PROVNAME unique (PROVNAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating BUY...
create table BUY
(
  buyid    NUMBER not null,
  buycount NUMBER(7) not null,
  buytime  DATE not null,
  provid   NUMBER not null,
  departid NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BUY
  add constraint PK_BUY primary key (BUYID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BUY
  add constraint FK_BUY_DEPARTMENT_DEPARTID foreign key (DEPARTID)
  references DEPARTMENT (DEPARTID);
alter table BUY
  add constraint FK_BUY_PROVIDER_PROVID foreign key (PROVID)
  references PROVIDER (PROVID);

prompt Creating REPAIR...
create table REPAIR
(
  repairid NUMBER not null,
  rcount   NUMBER(7) not null,
  rtime    DATE not null,
  departid NUMBER not null,
  bid      NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table REPAIR
  add constraint PK_REPAIR primary key (REPAIRID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table REPAIR
  add constraint FK_REPAIR_BALANCE_BID foreign key (BID)
  references BALANCE (BID);
alter table REPAIR
  add constraint FK_REPAIR_DEPARTMENT_DEPARTID foreign key (DEPARTID)
  references DEPARTMENT (DEPARTID);

prompt Creating SCRAP...
create table SCRAP
(
  sid      NUMBER not null,
  scount   NUMBER(7) not null,
  stime    DATE not null,
  bid      NUMBER not null,
  departid NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SCRAP
  add constraint PK_SCRAP primary key (SID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SCRAP
  add constraint FK_SCRAP_BALANCE_BID foreign key (BID)
  references BALANCE (BID);
alter table SCRAP
  add constraint FK_SCRAP_DEPARTMENT_DEPARTID foreign key (DEPARTID)
  references DEPARTMENT (DEPARTID);

prompt Creating TRANSLATE...
create table TRANSLATE
(
  tid      NUMBER not null,
  tcount   NUMBER(7) not null,
  trtime   DATE not null,
  bid      NUMBER not null,
  departid NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TRANSLATE
  add constraint PK_TRANSLATE primary key (TID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TRANSLATE
  add constraint FK_TRANSLATE_BALANCE_BID foreign key (BID)
  references BALANCE (BID);
alter table TRANSLATE
  add constraint FK_TRANSLATE_DEPARTMENT foreign key (DEPARTID)
  references DEPARTMENT (DEPARTID);

prompt Creating CHECKBALANCE...
create table CHECKBALANCE
(
  chid     NUMBER not null,
  buyid    NUMBER not null,
  bid      NUMBER not null,
  repairid NUMBER not null,
  sid      NUMBER not null,
  tid      NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CHECKBALANCE
  add constraint PK_CHECKBALANCE primary key (CHID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CHECKBALANCE
  add constraint FK_CHECKBALANCE_BALANCE_BID foreign key (BID)
  references BALANCE (BID);
alter table CHECKBALANCE
  add constraint FK_CHECKBALANCE_BUY_BUYID foreign key (BUYID)
  references BUY (BUYID);
alter table CHECKBALANCE
  add constraint FK_CHECKBALANCE_REPAIR foreign key (REPAIRID)
  references REPAIR (REPAIRID);
alter table CHECKBALANCE
  add constraint FK_CHECKBALANCE_SCRAP_SID foreign key (SID)
  references SCRAP (SID);
alter table CHECKBALANCE
  add constraint FK_CHECKBALANCE_SCRAP_TID foreign key (TID)
  references TRANSLATE (TID);

prompt Creating DEMO...
create table DEMO
(
  id   NUMBER,
  name NVARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating PRIVILEGELIST...
create table PRIVILEGELIST
(
  pid      NUMBER not null,
  pname    NVARCHAR2(50) not null,
  purl     NVARCHAR2(255),
  parentid NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column PRIVILEGELIST.parentid
  is '自关联pid列，0表示顶级权限';
alter table PRIVILEGELIST
  add constraint PK_PRIVILEGELIST primary key (PID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRIVILEGELIST
  add constraint UN_PRIVILEGELIST_PNAME unique (PNAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating PRODUCT...
create table PRODUCT
(
  prodid    NUMBER not null,
  prodname  VARCHAR2(50) not null,
  prodcount NUMBER(7) not null,
  provid    NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRODUCT
  add constraint PK_PRODUCT primary key (PRODID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRODUCT
  add constraint UN_PRODUCT_PRODNAME unique (PRODNAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRODUCT
  add constraint FK_PRODUCT_PROVIDER_PROVID foreign key (PROVID)
  references PROVIDER (PROVID);

prompt Creating ROLELIST...
create table ROLELIST
(
  rid   NUMBER not null,
  rname NVARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ROLELIST
  add constraint PK_ROLELIST primary key (RID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ROLELIST
  add constraint UN_ROLELIST_RNAME unique (RNAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating ROLEPRIVILEGE...
create table ROLEPRIVILEGE
(
  rpid NUMBER not null,
  rid  NUMBER not null,
  pid  NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ROLEPRIVILEGE
  add constraint PK_ROLEPRIVILEGE primary key (RPID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ROLEPRIVILEGE
  add constraint UN_ROLEPRIVILEGE_RID_PID unique (RID, PID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ROLEPRIVILEGE
  add constraint FK_ROLEPRIVILEGE_PRIVILEGELIST foreign key (PID)
  references PRIVILEGELIST (PID);
alter table ROLEPRIVILEGE
  add constraint FK_ROLEPRIVILEGE_ROLELIST foreign key (RID)
  references ROLELIST (RID);

prompt Creating T_USER...
create table T_USER
(
  user_id   NUMBER not null,
  user_name NVARCHAR2(20),
  user_age  NVARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_USER
  add constraint PK_T_USER_ID primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating USERACCOUNT...
create table USERACCOUNT
(
  userid   NUMBER not null,
  username NVARCHAR2(20) not null,
  accounts NVARCHAR2(20) not null,
  password NVARCHAR2(32) not null,
  sex      NVARCHAR2(20) not null,
  age      DATE not null,
  phone    NVARCHAR2(20) not null,
  ragedate DATE not null,
  rid      NUMBER not null,
  departid NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERACCOUNT
  add constraint PK_USERACCOUNT primary key (USERID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERACCOUNT
  add constraint UN_USERACCOUNT unique (ACCOUNTS)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERACCOUNT
  add constraint FK_USERACCOUNT_DEPARTMENT foreign key (DEPARTID)
  references DEPARTMENT (DEPARTID);
alter table USERACCOUNT
  add constraint FK_USERACCOUNT_ROLELIST foreign key (RID)
  references ROLELIST (RID);

prompt Disabling triggers for AREA...
alter table AREA disable all triggers;
prompt Disabling triggers for CATEGORY...
alter table CATEGORY disable all triggers;
prompt Disabling triggers for DEPARTMENT...
alter table DEPARTMENT disable all triggers;
prompt Disabling triggers for BALANCE...
alter table BALANCE disable all triggers;
prompt Disabling triggers for PROVIDER...
alter table PROVIDER disable all triggers;
prompt Disabling triggers for BUY...
alter table BUY disable all triggers;
prompt Disabling triggers for REPAIR...
alter table REPAIR disable all triggers;
prompt Disabling triggers for SCRAP...
alter table SCRAP disable all triggers;
prompt Disabling triggers for TRANSLATE...
alter table TRANSLATE disable all triggers;
prompt Disabling triggers for CHECKBALANCE...
alter table CHECKBALANCE disable all triggers;
prompt Disabling triggers for DEMO...
alter table DEMO disable all triggers;
prompt Disabling triggers for PRIVILEGELIST...
alter table PRIVILEGELIST disable all triggers;
prompt Disabling triggers for PRODUCT...
alter table PRODUCT disable all triggers;
prompt Disabling triggers for ROLELIST...
alter table ROLELIST disable all triggers;
prompt Disabling triggers for ROLEPRIVILEGE...
alter table ROLEPRIVILEGE disable all triggers;
prompt Disabling triggers for T_USER...
alter table T_USER disable all triggers;
prompt Disabling triggers for USERACCOUNT...
alter table USERACCOUNT disable all triggers;
prompt Disabling foreign key constraints for DEPARTMENT...
alter table DEPARTMENT disable constraint FK_DEPARTMENT_AREA;
prompt Disabling foreign key constraints for BALANCE...
alter table BALANCE disable constraint FK_BALANCE_CATEGORY;
alter table BALANCE disable constraint FK_BALANCE_DEPARTMENT;
prompt Disabling foreign key constraints for BUY...
alter table BUY disable constraint FK_BUY_DEPARTMENT_DEPARTID;
alter table BUY disable constraint FK_BUY_PROVIDER_PROVID;
prompt Disabling foreign key constraints for REPAIR...
alter table REPAIR disable constraint FK_REPAIR_BALANCE_BID;
alter table REPAIR disable constraint FK_REPAIR_DEPARTMENT_DEPARTID;
prompt Disabling foreign key constraints for SCRAP...
alter table SCRAP disable constraint FK_SCRAP_BALANCE_BID;
alter table SCRAP disable constraint FK_SCRAP_DEPARTMENT_DEPARTID;
prompt Disabling foreign key constraints for TRANSLATE...
alter table TRANSLATE disable constraint FK_TRANSLATE_BALANCE_BID;
alter table TRANSLATE disable constraint FK_TRANSLATE_DEPARTMENT;
prompt Disabling foreign key constraints for CHECKBALANCE...
alter table CHECKBALANCE disable constraint FK_CHECKBALANCE_BALANCE_BID;
alter table CHECKBALANCE disable constraint FK_CHECKBALANCE_BUY_BUYID;
alter table CHECKBALANCE disable constraint FK_CHECKBALANCE_REPAIR;
alter table CHECKBALANCE disable constraint FK_CHECKBALANCE_SCRAP_SID;
alter table CHECKBALANCE disable constraint FK_CHECKBALANCE_SCRAP_TID;
prompt Disabling foreign key constraints for PRODUCT...
alter table PRODUCT disable constraint FK_PRODUCT_PROVIDER_PROVID;
prompt Disabling foreign key constraints for ROLEPRIVILEGE...
alter table ROLEPRIVILEGE disable constraint FK_ROLEPRIVILEGE_PRIVILEGELIST;
alter table ROLEPRIVILEGE disable constraint FK_ROLEPRIVILEGE_ROLELIST;
prompt Disabling foreign key constraints for USERACCOUNT...
alter table USERACCOUNT disable constraint FK_USERACCOUNT_DEPARTMENT;
alter table USERACCOUNT disable constraint FK_USERACCOUNT_ROLELIST;
prompt Loading AREA...
insert into AREA (areaid, areaname, relative)
values (1, '华北地区', 0);
insert into AREA (areaid, areaname, relative)
values (2, '华南地区', null);
commit;
prompt 2 records loaded
prompt Loading CATEGORY...
insert into CATEGORY (cid, cname)
values (1, '办公用品');
insert into CATEGORY (cid, cname)
values (3, '房产');
insert into CATEGORY (cid, cname)
values (2, '设备');
commit;
prompt 3 records loaded
prompt Loading DEPARTMENT...
insert into DEPARTMENT (departid, departname, areaid)
values (1, '开发部', 1);
insert into DEPARTMENT (departid, departname, areaid)
values (2, '市场部', 1);
insert into DEPARTMENT (departid, departname, areaid)
values (3, '销售部', 2);
commit;
prompt 3 records loaded
prompt Loading BALANCE...
insert into BALANCE (bid, bname, bcount, price, bdate, cid, departid)
values (1, '电脑', 200, 10000, to_date('01-01-2017', 'dd-mm-yyyy'), 1, 1);
insert into BALANCE (bid, bname, bcount, price, bdate, cid, departid)
values (2, '办公桌', 100, 2000, to_date('13-01-2017', 'dd-mm-yyyy'), 1, 1);
commit;
prompt 2 records loaded
prompt Loading PROVIDER...
insert into PROVIDER (provid, provname, address, phone)
values (1, '深圳电脑批发厂', '深圳市', '15077788999');
insert into PROVIDER (provid, provname, address, phone)
values (2, '广州电脑生产商', '广州市', '13677778888');
commit;
prompt 2 records loaded
prompt Loading BUY...
insert into BUY (buyid, buycount, buytime, provid, departid)
values (1, 100, to_date('13-01-2017', 'dd-mm-yyyy'), 1, 2);
insert into BUY (buyid, buycount, buytime, provid, departid)
values (2, 150, to_date('05-01-2017', 'dd-mm-yyyy'), 2, 3);
commit;
prompt 2 records loaded
prompt Loading REPAIR...
insert into REPAIR (repairid, rcount, rtime, departid, bid)
values (1, 10, to_date('02-12-2016', 'dd-mm-yyyy'), 2, 1);
insert into REPAIR (repairid, rcount, rtime, departid, bid)
values (2, 5, to_date('30-11-2016', 'dd-mm-yyyy'), 1, 2);
commit;
prompt 2 records loaded
prompt Loading SCRAP...
insert into SCRAP (sid, scount, stime, bid, departid)
values (1, 10, to_date('03-01-2017', 'dd-mm-yyyy'), 1, 1);
insert into SCRAP (sid, scount, stime, bid, departid)
values (2, 10, to_date('02-01-2017', 'dd-mm-yyyy'), 2, 1);
commit;
prompt 2 records loaded
prompt Loading TRANSLATE...
insert into TRANSLATE (tid, tcount, trtime, bid, departid)
values (1, 20, to_date('02-01-2017', 'dd-mm-yyyy'), 1, 3);
insert into TRANSLATE (tid, tcount, trtime, bid, departid)
values (2, 10, to_date('23-11-2016', 'dd-mm-yyyy'), 1, 2);
commit;
prompt 2 records loaded
prompt Loading CHECKBALANCE...
insert into CHECKBALANCE (chid, buyid, bid, repairid, sid, tid)
values (1, 1, 1, 1, 1, 1);
insert into CHECKBALANCE (chid, buyid, bid, repairid, sid, tid)
values (2, 2, 2, 2, 2, 2);
commit;
prompt 2 records loaded
prompt Loading DEMO...
insert into DEMO (id, name)
values (1, 'test');
commit;
prompt 1 records loaded
prompt Loading PRIVILEGELIST...
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (1, '基础数据管理', null, 0);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (2, '资产管理', null, 0);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (3, '使用统计管理', null, 0);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (4, '供应商管理', null, 0);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (201, '采购管理', null, 2);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (202, '盘点管理', null, 2);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (101, '资产分类设置', null, 1);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (102, '部门设置', null, 1);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (103, '资产录入', null, 1);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (104, '区域管理', null, 1);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10101, '新增分类', null, 101);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10102, '修改分类', null, 101);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10103, '删除分类', null, 101);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10104, '查询分类', null, 101);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10201, '新增部门', null, 102);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10202, '修改部门', null, 102);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10203, '删除部门', null, 102);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10204, '查询部门', null, 102);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10301, '新增资产', null, 103);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10401, '新增区域', null, 104);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10402, '修改区域', null, 104);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10403, '删除区域', null, 104);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (10404, '查询区域', null, 104);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20102, '修改采购单', null, 201);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (5, '系统管理', null, 0);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (203, '跨部门调配管理', null, 2);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (204, '报修管理', null, 2);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (205, '报废管理', null, 2);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20101, '新增采购单', null, 201);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20103, '删除采购单', null, 201);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20104, '查询采购单', null, 201);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (301, '资产总数', null, 3);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (302, '采购记录', null, 3);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (303, '跨部门调配记录', null, 3);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (304, '报修记录', null, 3);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (305, '报废记录', null, 3);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (306, '盘点记录', null, 3);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (402, '产品信息查看', null, 4);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (30101, '统计1', null, 301);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (30201, '统计2', null, 302);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (30301, '统计3', null, 303);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (30401, '统计4', null, 304);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (30501, '统计5', null, 305);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (30601, '统计6', null, 306);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (401, '供应商信息查看', null, 4);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (40101, '新增供应商', null, 401);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (40102, '修改供应商', null, 401);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (40103, '删除供应商', null, 401);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (40104, '查询供应商', null, 401);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (40201, '新增产品', null, 402);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (40202, '修改产品', null, 402);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (40203, '删除产品', null, 402);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (40204, '查询产品', null, 402);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (501, '用户管理', null, 5);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (50102, '修改用户', null, 501);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (50103, '删除用户', null, 501);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (502, '角色管理', null, 5);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (503, '权限管理', null, 5);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (50101, '新增用户', null, 501);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (50104, '查询用户', null, 501);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (50201, '新增角色', null, 502);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (50202, '修改角色', null, 502);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (50203, '删除角色', null, 502);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (50204, '查询角色', null, 502);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20201, '新增盘点', null, 202);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20202, '修改盘点', null, 202);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20203, '删除盘点', null, 202);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20204, '查询盘点', null, 202);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20301, '新增调配', null, 203);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20302, '修改调配', null, 203);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20303, '删除调配', null, 203);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20304, '查询调配', null, 203);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20401, '新增报修', null, 204);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20402, '修改报修', null, 204);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20403, '删除报修', null, 204);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20404, '查询报修', null, 204);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20501, '新增报废', null, 205);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20502, '修改报废', null, 205);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20503, '删除报废', null, 205);
insert into PRIVILEGELIST (pid, pname, purl, parentid)
values (20504, '查询报废', null, 205);
commit;
prompt 80 records loaded
prompt Loading PRODUCT...
insert into PRODUCT (prodid, prodname, prodcount, provid)
values (1, '电脑', 10000, 1);
insert into PRODUCT (prodid, prodname, prodcount, provid)
values (2, '显示器', 2000, 2);
commit;
prompt 2 records loaded
prompt Loading ROLELIST...
insert into ROLELIST (rid, rname)
values (3, '普通员工');
insert into ROLELIST (rid, rname)
values (1, '系统管理员');
insert into ROLELIST (rid, rname)
values (2, '资产管理员');
commit;
prompt 3 records loaded
prompt Loading ROLEPRIVILEGE...
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (241, 1, 1);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (242, 1, 2);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (243, 1, 3);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (244, 1, 4);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (245, 1, 5);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (246, 1, 101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (247, 1, 102);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (248, 1, 103);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (249, 1, 104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (250, 1, 201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (251, 1, 202);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (252, 1, 203);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (253, 1, 204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (254, 1, 205);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (255, 1, 301);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (256, 1, 302);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (257, 1, 303);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (258, 1, 304);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (259, 1, 305);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (260, 1, 306);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (261, 1, 401);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (262, 1, 402);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (263, 1, 501);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (264, 1, 502);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (265, 1, 503);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (266, 1, 10101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (267, 1, 10102);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (268, 1, 10103);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (269, 1, 10104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (270, 1, 10201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (271, 1, 10202);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (272, 1, 10203);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (273, 1, 10204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (274, 1, 10301);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (275, 1, 10401);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (276, 1, 10402);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (277, 1, 10403);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (278, 1, 10404);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (279, 1, 20101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (280, 1, 20102);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (281, 1, 20103);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (282, 1, 20104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (283, 1, 20201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (284, 1, 20202);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (285, 1, 20203);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (286, 1, 20204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (287, 1, 20301);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (288, 1, 20302);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (289, 1, 20303);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (290, 1, 20304);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (291, 1, 20401);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (292, 1, 20402);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (293, 1, 20403);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (294, 1, 20404);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (295, 1, 20501);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (296, 1, 20502);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (297, 1, 20503);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (298, 1, 20504);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (299, 1, 30101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (300, 1, 30201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (301, 1, 30301);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (302, 1, 30401);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (303, 1, 30501);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (304, 1, 30601);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (305, 1, 40101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (306, 1, 40102);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (307, 1, 40103);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (308, 1, 40104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (309, 1, 40201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (310, 1, 40202);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (311, 1, 40203);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (312, 1, 40204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (313, 1, 50101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (314, 1, 50102);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (315, 1, 50103);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (316, 1, 50104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (317, 1, 50201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (318, 1, 50202);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (319, 1, 50203);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (320, 1, 50204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (355, 2, 1);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (356, 2, 201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (357, 2, 202);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (358, 2, 203);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (359, 2, 204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (360, 2, 205);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (361, 2, 301);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (362, 2, 302);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (363, 2, 303);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (364, 2, 304);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (365, 2, 305);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (366, 2, 306);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (367, 2, 401);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (368, 2, 402);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (321, 2, 20101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (322, 2, 20102);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (323, 2, 20103);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (324, 2, 20104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (325, 2, 20201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (326, 2, 20202);
commit;
prompt 100 records committed...
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (327, 2, 20203);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (328, 2, 20204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (329, 2, 20301);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (330, 2, 20302);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (331, 2, 20303);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (332, 2, 20304);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (333, 2, 20401);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (334, 2, 20402);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (335, 2, 20403);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (336, 2, 20404);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (337, 2, 20501);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (338, 2, 20502);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (339, 2, 20503);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (340, 2, 20504);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (341, 2, 30101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (342, 2, 30201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (343, 2, 30301);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (344, 2, 30401);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (345, 2, 30501);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (346, 2, 30601);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (347, 2, 40101);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (348, 2, 40102);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (349, 2, 40103);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (350, 2, 40104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (351, 2, 40201);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (352, 2, 40202);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (353, 2, 40203);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (354, 2, 40204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (369, 3, 2);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (370, 3, 20104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (371, 3, 20204);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (372, 3, 20304);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (373, 3, 20404);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (374, 3, 20504);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (375, 3, 40104);
insert into ROLEPRIVILEGE (rpid, rid, pid)
values (376, 3, 40204);
commit;
prompt 136 records loaded
prompt Loading T_USER...
prompt Table is empty
prompt Loading USERACCOUNT...
insert into USERACCOUNT (userid, username, accounts, password, sex, age, phone, ragedate, rid, departid)
values (1, '张明', 'zhangming01', '123', '男', to_date('01-01-1985', 'dd-mm-yyyy'), '13878009999', to_date('01-06-2013', 'dd-mm-yyyy'), 3, 1);
insert into USERACCOUNT (userid, username, accounts, password, sex, age, phone, ragedate, rid, departid)
values (2, 'admin', '李华', '456', '男', to_date('10-07-1985', 'dd-mm-yyyy'), '15077730988', to_date('01-05-2013', 'dd-mm-yyyy'), 2, 1);
insert into USERACCOUNT (userid, username, accounts, password, sex, age, phone, ragedate, rid, departid)
values (3, 'superadmin', '刘浩', '123', '男', to_date('09-07-1975', 'dd-mm-yyyy'), '13878008888', to_date('20-01-2010', 'dd-mm-yyyy'), 1, 1);
commit;
prompt 3 records loaded
prompt Enabling foreign key constraints for DEPARTMENT...
alter table DEPARTMENT enable constraint FK_DEPARTMENT_AREA;
prompt Enabling foreign key constraints for BALANCE...
alter table BALANCE enable constraint FK_BALANCE_CATEGORY;
alter table BALANCE enable constraint FK_BALANCE_DEPARTMENT;
prompt Enabling foreign key constraints for BUY...
alter table BUY enable constraint FK_BUY_DEPARTMENT_DEPARTID;
alter table BUY enable constraint FK_BUY_PROVIDER_PROVID;
prompt Enabling foreign key constraints for REPAIR...
alter table REPAIR enable constraint FK_REPAIR_BALANCE_BID;
alter table REPAIR enable constraint FK_REPAIR_DEPARTMENT_DEPARTID;
prompt Enabling foreign key constraints for SCRAP...
alter table SCRAP enable constraint FK_SCRAP_BALANCE_BID;
alter table SCRAP enable constraint FK_SCRAP_DEPARTMENT_DEPARTID;
prompt Enabling foreign key constraints for TRANSLATE...
alter table TRANSLATE enable constraint FK_TRANSLATE_BALANCE_BID;
alter table TRANSLATE enable constraint FK_TRANSLATE_DEPARTMENT;
prompt Enabling foreign key constraints for CHECKBALANCE...
alter table CHECKBALANCE enable constraint FK_CHECKBALANCE_BALANCE_BID;
alter table CHECKBALANCE enable constraint FK_CHECKBALANCE_BUY_BUYID;
alter table CHECKBALANCE enable constraint FK_CHECKBALANCE_REPAIR;
alter table CHECKBALANCE enable constraint FK_CHECKBALANCE_SCRAP_SID;
alter table CHECKBALANCE enable constraint FK_CHECKBALANCE_SCRAP_TID;
prompt Enabling foreign key constraints for PRODUCT...
alter table PRODUCT enable constraint FK_PRODUCT_PROVIDER_PROVID;
prompt Enabling foreign key constraints for ROLEPRIVILEGE...
alter table ROLEPRIVILEGE enable constraint FK_ROLEPRIVILEGE_PRIVILEGELIST;
alter table ROLEPRIVILEGE enable constraint FK_ROLEPRIVILEGE_ROLELIST;
prompt Enabling foreign key constraints for USERACCOUNT...
alter table USERACCOUNT enable constraint FK_USERACCOUNT_DEPARTMENT;
alter table USERACCOUNT enable constraint FK_USERACCOUNT_ROLELIST;
prompt Enabling triggers for AREA...
alter table AREA enable all triggers;
prompt Enabling triggers for CATEGORY...
alter table CATEGORY enable all triggers;
prompt Enabling triggers for DEPARTMENT...
alter table DEPARTMENT enable all triggers;
prompt Enabling triggers for BALANCE...
alter table BALANCE enable all triggers;
prompt Enabling triggers for PROVIDER...
alter table PROVIDER enable all triggers;
prompt Enabling triggers for BUY...
alter table BUY enable all triggers;
prompt Enabling triggers for REPAIR...
alter table REPAIR enable all triggers;
prompt Enabling triggers for SCRAP...
alter table SCRAP enable all triggers;
prompt Enabling triggers for TRANSLATE...
alter table TRANSLATE enable all triggers;
prompt Enabling triggers for CHECKBALANCE...
alter table CHECKBALANCE enable all triggers;
prompt Enabling triggers for DEMO...
alter table DEMO enable all triggers;
prompt Enabling triggers for PRIVILEGELIST...
alter table PRIVILEGELIST enable all triggers;
prompt Enabling triggers for PRODUCT...
alter table PRODUCT enable all triggers;
prompt Enabling triggers for ROLELIST...
alter table ROLELIST enable all triggers;
prompt Enabling triggers for ROLEPRIVILEGE...
alter table ROLEPRIVILEGE enable all triggers;
prompt Enabling triggers for T_USER...
alter table T_USER enable all triggers;
prompt Enabling triggers for USERACCOUNT...
alter table USERACCOUNT enable all triggers;
set feedback on
set define on
prompt Done.
