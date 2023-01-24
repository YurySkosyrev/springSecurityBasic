create table users
(
    -- BIGINT can not be auto increment
    id         serial
        constraint users_pk
            primary key,
    email      VARCHAR(255)                 not null,
    first_name VARCHAR(50)                  not null,
    last_name  VARCHAR(100),
    password   VARCHAR(250),
    role       VARCHAR(50) default 'USER'   not null,
    status     VARCHAR(50) default 'ACTIVE' not null
);



INSERT INTO users (id, email, first_name, last_name, password, role, status) VALUES (1, 'admin@mail.com', 'Admin', 'Adminov', '$2a$12$QeH8I1KMDbSyWrJL/PaPOeLXWhFNBiAMQGdzqSjPSBMvhHO7lBt8K', 'ADMIN', 'ACTIVE');
INSERT INTO users (id, email, first_name, last_name, password, role, status) VALUES (2, 'user@mail.com', 'User', 'Userov', '$2a$12$BTB0okT5BL28.NOKJKlHruvt7p36T9HJULc5x504mi6YtGVDw0eiO', 'USER', 'BANNED');
