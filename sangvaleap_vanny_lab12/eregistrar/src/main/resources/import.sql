INSERT INTO roles VALUES (null, 'ROLE_ADMIN');
INSERT INTO roles VALUES (null, 'ROLE_REGISTRAR');
INSERT INTO roles VALUES (null, 'ROLE_STUDENT');
INSERT INTO users VALUES (null, b'1',  b'1',  b'1', 'ana.admin@eregistrar.com',b'1', 'Ana', 'Test', 'Admin', '$2a$10$ogq095yZjfs9P2hWAufFdO0lQ3sxvQhGLlScDqnP0LPqzCO3MnR0y', 'ana.admin@eregistrar.com');
INSERT INTO users_roles VALUES (1, 1);
INSERT INTO users_roles VALUES (1, 2);
INSERT INTO users_roles VALUES (1, 3);
INSERT INTO users VALUES (null,  b'1',  b'1',  b'1', 'bob.registrar@eregistrar.com',b'1', 'Bob', 'Test', 'Registrar', '$2a$10$ogq095yZjfs9P2hWAufFdO0lQ3sxvQhGLlScDqnP0LPqzCO3MnR0y', 'bob.registrar@eregistrar.com');
INSERT INTO users_roles VALUES (2, 2);
INSERT INTO users VALUES (null,  b'1',  b'1',  b'1', 'carlos.student@eregistrar.com',b'1', 'Carlos', 'Test', 'Student', '$2a$10$ogq095yZjfs9P2hWAufFdO0lQ3sxvQhGLlScDqnP0LPqzCO3MnR0y', 'carlos.student@eregistrar.com');
INSERT INTO users_roles VALUES (3, 3);
