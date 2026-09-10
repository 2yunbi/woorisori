CREATE DATABASE woorisori
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

use woorisori;

-- 사용자 테이블
drop table if exists member cascade;
create table member
(
    id bigint primary key,
    emp_no varchar(10) not null unique,
    password varchar(255) not null,
    user_name varchar(50) not null,
    email varchar(200) not null unique,
    role varchar(20) default 'USER',
    is_use varchar(1) default 'Y',
    join_date datetime default CURRENT_TIMESTAMP,
    modify_date datetime default CURRENT_TIMESTAMP on update current_timestamp,
    delete_date datetime default CURRENT_TIMESTAMP
)
-- 고충처리 게시판 테이블
drop table if exists complaint cascade;
create table complaint
(
    id bigint auto_increment primary key,
    writer_id bigint not null,
    subject varchar(200) not null,
    content text not null,
    status varchar(20) not null default 'RECEIVED',
    create_date datetime default CURRENT_TIMESTAMP,
    modify_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    delete_date datetime,
    constraint fk_complaint_writer foreign key (writer_id) references member(id)
);