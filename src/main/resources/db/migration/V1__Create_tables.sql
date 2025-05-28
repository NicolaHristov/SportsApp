
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  email    VARCHAR(100) NOT NULL UNIQUE,
  role     VARCHAR(20)  NOT NULL
);


CREATE TABLE sports (
  id   BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100)     NOT NULL UNIQUE
);


CREATE TABLE disciplines (
  id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
  name                 VARCHAR(100) NOT NULL,
  world_record_holder  VARCHAR(255),
  world_record_time    VARCHAR(255),
  sport_id             BIGINT       NOT NULL,
  FOREIGN KEY (sport_id) REFERENCES sports(id)
);


CREATE TABLE comments (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  content       VARCHAR(500) NOT NULL,
  date_time     DATETIME      NOT NULL,
  user_id       BIGINT        NOT NULL,
  discipline_id BIGINT        NOT NULL,
  FOREIGN KEY (user_id)       REFERENCES users(id),
FOREIGN KEY (discipline_id) REFERENCES disciplines(id)
);
