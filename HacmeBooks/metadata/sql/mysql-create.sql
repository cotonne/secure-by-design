create database if not exists HacmeBooks;
grant all privileges on HacmeBooks.* to test@"%" identified by "test";
grant all privileges on HacmeBooks.* to test@localhost identified by "test";

-- You may have to explicitly define your hostname in order for things
-- to work correctly.  For example:
-- grant all privileges on HacmeBooks.* to test@host.domain.com identified by "test";