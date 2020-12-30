drop table t_auth cascade constraint ;
create table t_auth(
   id	number,
   url varchar2(200),
   name varchar2(100),
   parentId number,
   status char(1),
   constraint t_auth_pk primary key(id),
   constraint t_auth_fk foreign key(parentId) references t_auth(id)
);
drop table t_role cascade constraint ;
create table t_role(
   id	number,
   name varchar2(100),
   status char(1),
   constraint t_role_pk primary key(id)
);
drop table t_roleAuth cascade constraint ;
create table t_roleAuth(
    roleId number,
    authId number,
    constraint t_roleauth_pk primary key(roleId,authId),
    constraint t_roleauth_fk1 foreign key(roleId) references t_role(id),
    constraint t_roleauth_fk2 foreign key(authId) references t_auth(id)  
)
drop table t_user cascade constraint ;
create table t_user(
   id	number,
   name varchar2(100),
   pass varchar2(20),
   status char(1),
   roleId number,
   constraint t_user_pk primary key(id),
   constraint t_user_fk1 foreign key(roleId) references t_role(id)
);
select * from t_auth;
select * from t_role;
select * from t_roleAuth;
select * from t_user;
