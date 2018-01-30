create database hrsys default charset=utf8;

use hrsys;

create table t_user(
	
	uId Integer auto_increment not null,
	uName varchar(40) not null,
	uPwd varchar(50) not null,
	uLoginName varchar(50) not null,
	uState int not null,
	uCreateTime date not null,
	primary key(uId)
);

create table t_department(
	dId Integer auto_increment not null,
	dName varchar(50) not null,
	dDes varchar(200) not null,
	primary key(dId)
);

create table t_job(

	jId integer	auto_increment not null,
	jName varchar(50) not null,
	jDes varchar(200) not null,
	primary key(jId)
);

create table t_employee(
	eId integer auto_increment not null,
	eName varchar(50) not null,
	eGender bit not null,
	eTelNum varchar(11) not null,
	eEmail varchar(50) not null,
	jId integer not null,
	eStu varchar(20) not null,
	dId integer (20) not null,
	eIdCard varchar(50) not null,
	eCreateTime date not null,
	eAddress varchar(100) not null,
	eState Integer not null
	primary key(eId)
);

alter table t_employee add jState bit not null default 1 after eAddress;

alter table t_employee add constraint fk_job_jId foreign key(jId)
references t_job(jId) on update cascade;

alter table t_employee add constraint fk_department_dId foreign key(dId) references t_department(dId) on update cascade;

create table t_notice(

	nId integer auto_increment not null,
	nName varchar(50) not null,
	nContent varchar(500) not null,
	nCreateTime date not null,
	uId Integer not null,
	primary key(nId)
)

alter table t_notice add constraint fk_user_uId foreign key(uId) references t_user(uId) on update cascade;


create table t_download(
	doId integer auto_increment not null,
	doDescrip varchar(100) not null,
	doTitle varchar(100) not null,
	doCreateTime date not null,
	uId integer not null,
	url varchar(50),
	primary key(doId)
);

alter table t_download add constraint fk1_user_uId foreign key(uId)references t_user(uId) on update cascade

