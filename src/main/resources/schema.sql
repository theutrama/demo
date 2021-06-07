DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS post;

CREATE TABLE user (
                              userid INT AUTO_INCREMENT PRIMARY KEY,
                              first_name VARCHAR(30) NOT NULL,
                              last_name VARCHAR(30) NOT NULL,
                              email VARCHAR(30) NOT NULL,
                              username VARCHAR(20) NOT NULL
);

create table "Post"
(
    "postId" INT auto_increment,
    "creationDate" DATE not null,
    USER LONG not null,
    CONTENT TEXT not null,
    constraint POST_PK
        primary key ("postId"),
    constraint POST_USER_USERID_FK
        foreign key ("postId") references USER (USERID)
);

create unique index POST_USER_UINDEX
	on "Post" (USER);

