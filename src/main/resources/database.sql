# Аутентификация через почту и пароль:
#     admin@mail.ru : admin
#     user@mail.ru : user

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    age TINYINT NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    enabled BIT NOT NULL
                  );

CREATE TABLE roles(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
                  );

CREATE TABLE user_roles (
    user_id int NOT NULL,
    role_id int NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
                        );

INSERT INTO roles(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles(id, name) VALUES (2, 'ROLE_USER');

INSERT INTO users(id, name, surname, age, email, password)
VALUES (1, 'admin', 'admin', 25, 'admin@mail.ru', '$2y$12$NTfc/QDBde6g1nHZQ.U8j.4wc9uo/IG0UdwZWt3gEclk/t/UZf9em');

INSERT INTO users(id, name, surname, age, email, password)
VALUES (2, 'user', 'user', 20, 'user@mail.ru', '$2y$12$tJxGNFeSP4auZSYdvsz6ROTAUA.x/mvxrYNOZHTIkfqq6tMSFTVle');

INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (2, 2);