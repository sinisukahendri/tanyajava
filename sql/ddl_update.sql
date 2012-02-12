alter table T_QUESTION add column ANSWER_COUNT bigint(20) default 0;
alter table T_QUESTION add column VOTED_UP bigint(20) default 0;
alter table T_QUESTION add column VOTED_DOWN bigint(20) default 0;

alter table T_DOWNLOAD add column DOWNLOAD_COUNT int(11) default 0;
