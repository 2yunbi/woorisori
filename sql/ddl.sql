CREATE DATABASE woorisori
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

use woorisori;

drop table if exists member cascade;member
create table member
(
    id bigint primary key,
    emp_no varchar(10) Not null unique,
    password varchar(255) not null,
    user_name varchar(50) not null,
    email varchar(200) not null unique,
    role varchar(20) default 'USER',
    is_use varchar(1) default 'Y',
    join_date datetime default CURRENT_TIMESTAMP,
    modify_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    delete_date datetime default CURRENT_TIMESTAMP
)