-- TODO data
-- example
-- 멤버
insert into members (name, password, role, last_modified_date) values('bob', '$2a$10$LdzB2k1ddcNvx9y425D3YORJPEo71nHOInTtD9SdVwHmsLw.IzLty','ROLE_ADMIN', now());
insert into members (name, password, role, last_modified_date) values('test1','$2a$10$LdzB2k1ddcNvx9y425D3YORJPEo71nHOInTtD9SdVwHmsLw.IzLty', 'ROLE_USER', now());
insert into members (name, password, role, last_modified_date) values('test2','$2a$10$LdzB2k1ddcNvx9y425D3YORJPEo71nHOInTtD9SdVwHmsLw.IzLty', 'ROLE_USER', now());

-- 게시판
insert into contents (title, description, view_count, created_by, created_date) values ('test1번 게시물', 'test1번 게시물 test1가 작성', 0 , 'test1', now());
insert into contents (title, description, view_count, created_by, created_date) values ('test2번 게시물', 'test1번 게시물 test2가 작성', 0 , 'test2', now());
insert into contents (title, description, view_count, created_by, created_date) values ('admin번 게시물', 'admin 게시물 bob이 작성', 0 , 'bob', now());
