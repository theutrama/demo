/*
DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS user;



CREATE TABLE user (
                              userid INT AUTO_INCREMENT PRIMARY KEY,
                              first_name VARCHAR(30) NOT NULL,
                              last_name VARCHAR(30) NOT NULL,
                              email VARCHAR(30) NOT NULL,
                              username VARCHAR(20) NOT NULL,
                              postId INT
);

create table Post
(
    postId INT auto_increment,
    creationDate DATE not null,
    CONTENT TEXT not null,
    constraint POST_PK
        primary key (postId)
    /*constraint POST_USER_USERID_FK
        foreign key (userid) references USER(userid)*/
);


ALTER TABLE user ADD constraint USER_POST_POSTID_FK foreign key (postid) references POST(postid);
*/