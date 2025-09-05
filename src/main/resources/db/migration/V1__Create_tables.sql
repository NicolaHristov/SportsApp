CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  username VARCHAR(50)  NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  email    VARCHAR(100) NOT NULL UNIQUE,
  role     VARCHAR(20)  NOT NULL
);

CREATE TABLE sports (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE disciplines (
  id                  BIGSERIAL PRIMARY KEY,
  name                VARCHAR(100) NOT NULL,
  world_record_holder VARCHAR(255),
  world_record_time   VARCHAR(255),
  sport_id            BIGINT NOT NULL REFERENCES sports(id) ON DELETE CASCADE
);

CREATE TABLE comments (
  id            BIGSERIAL PRIMARY KEY,
  content       VARCHAR(500) NOT NULL,
  date_time     TIMESTAMP    NOT NULL,
  user_id       BIGINT       NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  discipline_id BIGINT       NOT NULL REFERENCES disciplines(id) ON DELETE CASCADE
);

CREATE INDEX idx_disciplines_sport_id ON disciplines(sport_id);
CREATE INDEX idx_comments_user_id     ON comments(user_id);
CREATE INDEX idx_comments_disc_id     ON comments(discipline_id);
