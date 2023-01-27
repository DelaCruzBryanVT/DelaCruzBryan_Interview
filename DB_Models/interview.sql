/*==============================================================*/
/* DBMS name:      MySQL 4.0                                    */
/* Created on:     25/1/2023 11:50:12                           */
/*==============================================================*/


drop index ENT_DEP_FK on DEPARTMENT;

drop table if exists DEPARTMENT;

drop index EMP_DEP_EMP_FK on DEPARTMENT_EMPLOYEE;

drop index DEP_DEP_EMP_FK on DEPARTMENT_EMPLOYEE;

drop table if exists DEPARTMENT_EMPLOYEE;

drop table if exists EMPLOYEE;

drop table if exists ENTERPRISE;

/*==============================================================*/
/* Table: DEPARTMENT                                            */
/*==============================================================*/
create table DEPARTMENT
(
   DEP_ID                         int                            not null AUTO_INCREMENT,
   ENT_ID                         int,
   DEP_CREATED_BY                 varchar(200),
   DEP_CREATED_DATE               date,
   DEP_MODIFIED_BY                varchar(200),
   DEP_MODIFIED_DATE              date,
   DEP_STATUS                     tinyint,
   DEP_DESCRIPTION                varchar(200),
   DEP_NAME                       varchar(200),
   DEP_PHONE                      varchar(50),
   primary key (DEP_ID)
)
ENGINE = InnoDB;

/*==============================================================*/
/* Index: ENT_DEP_FK                                            */
/*==============================================================*/
create index ENT_DEP_FK on DEPARTMENT
(
   ENT_ID
);

/*==============================================================*/
/* Table: DEPARTMENT_EMPLOYEE                                   */
/*==============================================================*/
create table DEPARTMENT_EMPLOYEE
(
   DEP_EMP_ID                     int                            not null AUTO_INCREMENT,
   DEP_ID                         int,
   EMP_ID                         int,
   DEP_EMP_CREATED_BY             varchar(200),
   DEP_EMP_CREATED_DATE           date,
   DEP_EMP_MODIFIED_BY            varchar(200),
   DEP_EMP_MODIFIED_DATE          date,
   DEP_EMP_STATUS                 tinyint,
   primary key (DEP_EMP_ID)
)
ENGINE = InnoDB;

/*==============================================================*/
/* Index: DEP_DEP_EMP_FK                                        */
/*==============================================================*/
create index DEP_DEP_EMP_FK on DEPARTMENT_EMPLOYEE
(
   DEP_ID
);

/*==============================================================*/
/* Index: EMP_DEP_EMP_FK                                        */
/*==============================================================*/
create index EMP_DEP_EMP_FK on DEPARTMENT_EMPLOYEE
(
   EMP_ID
);

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE
(
   EMP_ID                         int                            not null AUTO_INCREMENT,
   EMP_CREATED_BY                 varchar(200),
   EMP_CREATED_DATE               date,
   EMP_MODIFIED_BY                varchar(200),
   EM_MODIFIED_DATE               date,
   EMP_STATUS                     tinyint,
   EMP_AGE                        int,
   EMP_EMAIL                      varchar(200),
   EMP_NAME                       varchar(200),
   EMP_POSITION                   varchar(200),
   EMP_SURNAME                    varchar(200),
   primary key (EMP_ID)
)
ENGINE = InnoDB;

/*==============================================================*/
/* Table: ENTERPRISE                                            */
/*==============================================================*/
create table ENTERPRISE
(
   ENT_ID                         int                            not null AUTO_INCREMENT,
   ENT_CREATED_BY                 varchar(200),
   ENT_CREATED_DATE               date,
   ENT_MODIFIED_BY                varchar(200),
   ENT_MODIFIED_DATE              date,
   ENT_STATUS                     tinyint,
   ENT_ADDRESS                    varchar(200),
   ENT_NAME                       varchar(200),
   ENT_PHONE                      varchar(50),
   primary key (ENT_ID)
)
ENGINE = InnoDB;

alter table DEPARTMENT add constraint FK_ENT_DEP foreign key (ENT_ID)
      references ENTERPRISE (ENT_ID) on delete restrict on update restrict;

alter table DEPARTMENT_EMPLOYEE add constraint FK_DEP_DEP_EMP foreign key (DEP_ID)
      references DEPARTMENT (DEP_ID) on delete restrict on update restrict;

alter table DEPARTMENT_EMPLOYEE add constraint FK_EMP_DEP_EMP foreign key (EMP_ID)
      references EMPLOYEE (EMP_ID) on delete restrict on update restrict;

