-- Spring Boot data initialization
-- This file is executed after Hibernate creates the schema

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
