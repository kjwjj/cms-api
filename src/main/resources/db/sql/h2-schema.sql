-- TODO schema
-- example
create table members
(
    id                 bigint primary key      not null auto_increment,
    name               varchar(50)             not null unique,
    password           varchar(100)            not null,
    created_date       timestamp default now() not null,
    last_modified_date timestamp,
    role               varchar(20) default 'ROLE_USER' not null
);

create table contents
(
    id                  bigint primary key not null auto_increment,
    title               varchar(50) not null, -- 제목
    description         text,                 -- 내용
    view_count          bigint not null default 0, -- 조회수
    created_date        timestamp default now() not null, -- 생성일
    created_by          varchar(50) not null,  -- 생성자
    last_modified_date  timestamp,  -- 수정일
    last_modified_by    varchar(50)  -- 수정자
)