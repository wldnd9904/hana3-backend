use mydb;
desc member;

select now();


-- 회원가입 테이블 만들기
drop table member;
create table member (
                        id bigint primary key auto_increment,
                        user_id varchar(255) not null,
                        user_pw varchar(255) not null,
                        user_name varchar(255),
                        user_role varchar(255) default 'ROLE_USER',
                        join_date date default (current_date)
);

-- 데이터 추가하기
delete from member where id>0;

insert into member(user_id, user_pw, user_name) values
                                                    ('hong','1234','홍길동'),
                                                    ('kong','1234','콩길동'),
                                                    ('pong','1234','퐁길동');

insert into member values
                       (1, 'hong', '1234','홍길동','ROLE_USER','2024-01-01'),
                       (2, 'tom', '1234','톰아저씨','ROLE_USER','2024-02-02'),
                       (3, 'admin', '1234','관리자','ROLE_ADMIN','2024-03-03');



select * from member;