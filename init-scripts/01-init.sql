-- Initialize database for ABM Sucursales
-- This script will be executed when MySQL container starts for the first time

USE abm_sucursales;

-- Wait for tables to be created by Hibernate, then insert data
-- Note: This script runs before the Spring Boot app starts, so we need to create tables manually

-- Create sucursales table
CREATE TABLE IF NOT EXISTS sucursales (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    responsable_sucursal VARCHAR(255) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    telefono VARCHAR(255),
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

-- Create areas table
CREATE TABLE IF NOT EXISTS areas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL
);

-- Create the join table for sucursales-areas relationship
CREATE TABLE IF NOT EXISTS sucursales_areas (
    sucursal_entity_id BIGINT,
    areas_id BIGINT,
    FOREIGN KEY (sucursal_entity_id) REFERENCES sucursales(id),
    FOREIGN KEY (areas_id) REFERENCES areas(id)
);

-- Insert initial data for testing
INSERT INTO sucursales (descripcion, responsable_sucursal, ubicacion, correo, telefono, activo)
VALUES
    ('Sucursal Central', 'Juan Pérez', 'Av. Principal 123, Centro', 'central@empresa.com', '+54-11-4567-8901', true),
    ('Sucursal Norte', 'María González', 'Av. Libertador 456, Zona Norte', 'norte@empresa.com', '+54-11-4567-8902', true),
    ('Sucursal Sur', 'Carlos Rodríguez', 'Av. Rivadavia 789, Zona Sur', 'sur@empresa.com', '+54-11-4567-8903', true),
    ('Sucursal Oeste', 'Ana Martínez', 'Av. San Martín 321, Zona Oeste', 'oeste@empresa.com', '+54-11-4567-8904', true),
    ('Sucursal Este', 'Luis Fernández', 'Av. Corrientes 654, Zona Este', 'este@empresa.com', '+54-11-4567-8905', true);

INSERT INTO areas (descripcion)
VALUES
    ('Administración'),
    ('Ventas'),
    ('Soporte Técnico'),
    ('Recursos Humanos'),
    ('Contabilidad'),
    ('Marketing'),
    ('Logística'),
    ('Atención al Cliente'),
    ('Sistemas'),
    ('Seguridad');

-- Note: The relationship between sucursales and areas will be handled by the application
-- since it uses @OneToMany with cascade operations
