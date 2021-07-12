alter table rms.room add column if not exists floor integer not null;
alter table rms.room add column if not exists description varchar(512) not null;