-- Roles base del sistema. INSERT IGNORE evita duplicados en cada arranque.
INSERT IGNORE INTO roles (nombre) VALUES
    ('Estudiante'),
    ('Docente'),
    ('Administrador'),
    ('SuperAdministrador');
