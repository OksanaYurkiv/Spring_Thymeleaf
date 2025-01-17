INSERT INTO usuario (username, password) VALUES ('user1', '$2a$10$elPcGroibXN7J7PBN2HWGOznv42L2sac56bBbmvBdNpVTk1bUR9.y');
INSERT INTO usuario (username, password) VALUES ('user2', '$2a$10$elPcGroibXN7J7PBN2HWGOznv42L2sac56bBbmvBdNpVTk1bUR9.y');
INSERT INTO usuario (username, password) VALUES ('user3', '$2a$10$elPcGroibXN7J7PBN2HWGOznv42L2sac56bBbmvBdNpVTk1bUR9.y');

INSERT INTO rol (nombre, id_usuario) VALUES ('ROLE_ADMIN', 1);
INSERT INTO rol (nombre, id_usuario) VALUES ('ROLE_USER', 1);
INSERT INTO rol (nombre, id_usuario) VALUES ('ROLE_USER', 2);
INSERT INTO rol (nombre, id_usuario) VALUES ('ROLE_MANAGER', 3);
INSERT INTO rol (nombre, id_usuario) VALUES ('ROLE_VIEWER', 3);


INSERT INTO cliente (nombre, apellido, email, telefono, saldo)
VALUES
('Carlos', 'Gonzalez', 'carlos.gonzalez@example.com', '555123456', 1200.00);

INSERT INTO cliente (nombre, apellido, email, telefono, saldo)
VALUES
('Maria', 'Lopez', 'maria.lopez@example.com', '555987654', 2500.50);
