-- ==========================
-- USUARIOS
-- ==========================
INSERT INTO users (id, username, name, email, password, cardnumber, created_at) VALUES
(1, 'ivan', 'Ivan', 'ivan@user.com', '$2a$12$nTxOBOe88BIFjM1ojC0uhuj3WcFpmCiNv..VE2YZ5sf9201g2m7yO', '1111-2222-3333-4444', NOW()),
(2, 'debora', 'Débora', 'debora@user.com', '$2a$12$nTxOBOe88BIFjM1ojC0uhuj3WcFpmCiNv..VE2YZ5sf9201g2m7yO', '2222-3333-4444-5555', NOW()),
(3, 'paola', 'Paola', 'paola@user.com', '$2a$12$nTxOBOe88BIFjM1ojC0uhuj3WcFpmCiNv..VE2YZ5sf9201g2m7yO', '3333-4444-5555-6666', NOW()),
(4, 'alberto', 'Alberto', 'alberto@user.com', '$2a$12$nTxOBOe88BIFjM1ojC0uhuj3WcFpmCiNv..VE2YZ5sf9201g2m7yO', '4444-5555-6666-7777', NOW()),
(5, 'esther', 'Esther', 'esther@user.com', '$2a$12$nTxOBOe88BIFjM1ojC0uhuj3WcFpmCiNv..VE2YZ5sf9201g2m7yO', '5555-6666-7777-8888', NOW()),
(6, 'gabriela', 'Gabriela', 'gabriela@user.com', '$2a$12$nTxOBOe88BIFjM1ojC0uhuj3WcFpmCiNv..VE2YZ5sf9201g2m7yO', '6666-7777-8888-9999', NOW());

-- ==========================
-- MEDICACIONES
-- ==========================
INSERT INTO medications (id_medication, user_id, name, description, quantity, units, type) VALUES
-- Ivan
(1, 1, 'Ibuprofeno', 'Antiinflamatorio en comprimidos', 20, 'mg', 'PASTILLAS'),
(2, 1, 'Paracetamol', 'Analgésico y antipirético', 15, 'mg', 'PASTILLAS'),

-- Débora
(3, 2, 'Amoxicilina', 'Antibiótico oral', 10, 'capsulas', 'SOBRES'),
(4, 2, 'Ventolin', 'Inhalador para asma', 2, 'sprays', 'GOTAS'),

-- Paola
(5, 3, 'Omeprazol', 'Protector gástrico', 30, 'mg', 'PASTILLAS'),
(6, 3, 'Loratadina', 'Antihistamínico oral', 20, 'mg', 'PASTILLAS'),

-- Alberto
(7, 4, 'Insulina', 'Inyección subcutánea', 5, 'ml', 'INYECCION'),
(8, 4, 'Vitamina C', 'Complemento vitamínico', 25, 'mg', 'PASTILLAS'),

-- Esther
(9, 5, 'Clorfenamina', 'Tratamiento para alergias', 10, 'mg', 'PASTILLAS'),
(10, 5, 'Colirio', 'Gotas para ojos irritados', 1, 'frasco', 'GOTAS'),

-- Gabriela
(11, 6, 'Metformina', 'Tratamiento para la diabetes tipo 2', 20, 'mg', 'PASTILLAS'),
(12, 6, 'Hierro', 'Suplemento contra la anemia', 15, 'mg', 'PASTILLAS');

-- ==========================
-- TRATAMIENTOS
-- ==========================
INSERT INTO treatments (id, user_id, medication_id, dosage, dosage_unit, indefinite, start_date, end_date, active) VALUES
-- Ivan
(1, 1, 1, '1 pastilla cada 8h', 1, false, '2024-09-01 09:00:00', '2024-09-10 09:00:00', true),
(2, 1, 2, '1 pastilla cada 12h', 1, true, '2024-08-15 08:00:00', NULL, true),

-- Débora
(3, 2, 3, '1 sobre cada 12h', 1, false, '2024-09-05 10:00:00', '2024-09-15 10:00:00', true),
(4, 2, 4, '2 inhalaciones al día', 2, true, '2024-07-20 09:30:00', NULL, true),

-- Paola
(5, 3, 5, '1 cápsula diaria', 1, true, '2024-06-01 07:30:00', NULL, true),
(6, 3, 6, '1 pastilla cada 24h', 1, false, '2024-09-02 08:00:00', '2024-09-12 08:00:00', true),

-- Alberto
(7, 4, 7, '1 inyección diaria', 1, true, '2024-05-10 08:00:00', NULL, true),
(8, 4, 8, '1 comprimido al día', 1, false, '2024-09-01 09:00:00', '2024-09-30 09:00:00', true),

-- Esther
(9, 5, 9, '1 pastilla cada 12h', 1, false, '2024-08-10 08:00:00', '2024-08-20 08:00:00', true),
(10, 5, 10, '2 gotas en cada ojo 3 veces al día', 2, true, '2024-09-01 07:00:00', NULL, true),

-- Gabriela
(11, 6, 11, '1 pastilla con desayuno y cena', 1, true, '2024-07-01 08:30:00', NULL, true),
(12, 6, 12, '1 cápsula diaria', 1, false, '2024-09-05 08:00:00', '2024-09-20 08:00:00', true);