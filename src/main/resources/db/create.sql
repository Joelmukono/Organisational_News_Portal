SET MODE PostgreSQL;


CREATE TABLE IF NOT EXISTS users (
 userId int PRIMARY KEY auto_increment,
 userName VARCHAR,
 placement VARCHAR,
 department VARCHAR,

);

