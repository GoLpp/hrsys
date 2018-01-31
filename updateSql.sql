alter table t_department add dState int not null default 1 after dDes;
alter table t_download add downState int not null default 1 after uId;
alter table t_job add jState int not null default 1 after jDes;
alter table t_notice add nState int not null default 1 after uId;
