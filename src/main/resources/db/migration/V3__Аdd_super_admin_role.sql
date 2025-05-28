CREATE TABLE roles (
  id   BIGINT       NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
UNIQUE KEY ux_roles_name (name)
);
INSERT IGNORE INTO roles (name)
VALUES ('ROLE_SUPER_ADMIN');