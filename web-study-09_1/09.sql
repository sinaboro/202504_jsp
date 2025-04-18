
DROP TABLE MEMBER;  --테이블 삭제

create table member(
    name varchar2(30) NOT null,
    userid varchar2(30) ,
    pwd varchar2(20) NOT null,
    email varchar2(30),
    phone char(13),  -- 010-3380-6423
    admin number(1) default 0, -- 사용자: 0, 관리자:1
    primary key(userid)
);

insert into member values('이소미', 'somi', '1234', 'gmd@naver.com','010-2362-5157', 0);
insert into member values('하상오', 'sang12', '1234', 'ha12@naver.com','010-5926-8888', 1);
insert into member values('김윤승', 'light', '1234', 'youn1004@naver.com','010-9999-8282', 0);

commit;

SELECT *
FROM MEMBER;

DESC MEMBER;

DESCRIBE member;


create table employees(
    id varchar2(10) not null primary key ,
    pass VARCHAR2(10) not null,
    name varchar2(24),
    lev char(1) default 'A',
    enter date default sysdate,
    gender char(1) default '1',
    phone varchar2(30)  
);

insert into employees(id,pass,name,lev,gender,phone) values('pinksung', '3333','성윤정','A','2','010-2222-3333');
insert into employees(id,pass,name,lev,gender,phone) values('subin', '1234','전원지','B','1','010-3333-4444');
insert into employees(id,pass,name,lev,gender,phone) values('admin', '1234','정운영','A','1','010-0000-0000');

commit;
