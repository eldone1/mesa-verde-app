-- -----------------------------------------------------
-- Inserción de datos en la tabla `monedas`
-- -----------------------------------------------------
INSERT INTO `monedas` (`codigo`, `nombre`, `simbolo`) VALUES ('USD', 'Dólar Estadounidense', '$');
INSERT INTO `monedas` (`codigo`, `nombre`, `simbolo`) VALUES ('EUR', 'Euro', '€');
INSERT INTO `monedas` (`codigo`, `nombre`, `simbolo`) VALUES ('PEN', 'Sol Peruano', 'S/');
INSERT INTO `monedas` (`codigo`, `nombre`, `simbolo`) VALUES ('MXN', 'Peso Mexicano', '$');
INSERT INTO `monedas` (`codigo`, `nombre`, `simbolo`) VALUES ('CLP', 'Peso Chileno', '$');

-- -----------------------------------------------------
-- Inserción de datos en la tabla `clientes` (10 clientes)
-- -----------------------------------------------------
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('Juan', 'Pérez García', 'DNI', '12345678', '1985-05-15', 'Av. Los Olivos 123, Lima', '987654321', 'juan.perez@example.com', 'ACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('María', 'Gómez Torres', 'DNI', '87654321', '1990-11-22', 'Calle Las Flores 456, Callao', '912345678', 'maria.gomez@example.com', 'ACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('Carlos', 'Ramírez Castro', 'Pasaporte', 'P1234567', '1978-02-10', 'Jr. Miraflores 789, Miraflores', '998877665', 'carlos.ramirez@example.com', 'ACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('Ana', 'Sánchez López', 'RUC', '20123456789', '1995-08-01', 'Av. El Sol 101, Santiago', '955443322', 'ana.sanchez@example.com', 'ACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('Pedro', 'Vargas Fernández', 'DNI', '44556677', '1982-04-30', 'Av. Grau 202, Arequipa', '933221100', 'pedro.vargas@example.com', 'ACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('Sofía', 'Herrera Díaz', 'DNI', '66778899', '1993-07-25', 'Jr. Puno 303, Cusco', '944556677', 'sofia.herrera@example.com', 'ACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('Roberto', 'Castañeda Luna', 'DNI', '55667788', '1975-01-18', 'Calle Huayna Cápac 500, Trujillo', '966778899', 'roberto.castaneda@example.com', 'ACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('Laura', 'Morales Mendoza', 'DNI', '99887766', '1998-03-05', 'Av. de la Cultura 120, Cusco', '977889900', 'laura.morales@example.com', 'ACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('José', 'Ortiz Vargas', 'Pasaporte', 'P9876543', '1989-09-12', 'Av. La Marina 800, Piura', '922334455', 'jose.ortiz@example.com', 'INACTIVO');
INSERT INTO `clientes` (`nombre`, `apellido`, `tipo_documento`, `numero_documento`, `fecha_nacimiento`, `direccion`, `telefono`, `email`, `estado`) VALUES ('Fátima', 'Ruiz Salas', 'RUC', '20987654321', '1991-06-28', 'Calle Los Jazmines 30, Chiclayo', '911223344', 'fatima.ruiz@example.com', 'ACTIVO');

-- -----------------------------------------------------
-- Inserción de datos en la tabla `roles`
-- -----------------------------------------------------
INSERT INTO `roles` (`nombre_rol`, `descripcion`) VALUES ('CLIENTE', 'Rol por defecto para clientes del banco.');
INSERT INTO `roles` (`nombre_rol`, `descripcion`) VALUES ('CAJERO', 'Personal de caja con permisos limitados.');
INSERT INTO `roles` (`nombre_rol`, `descripcion`) VALUES ('ADMINISTRADOR', 'Personal con permisos de gestión del sistema.');
INSERT INTO `roles` (`nombre_rol`, `descripcion`) VALUES ('GERENTE', 'Personal de alta dirección con amplios permisos.');
INSERT INTO `roles` (`nombre_rol`, `descripcion`) VALUES ('CONTADOR', 'Personal del área contable.');

-- -----------------------------------------------------
-- Inserción de datos en la tabla `usuarios` (6 usuarios)
-- -----------------------------------------------------
INSERT INTO `usuarios` (`username`, `password_hash`, `password_salt`, `id_cliente`, `email`) VALUES ('juan.perez', 'hash_jp', 'salt_jp', 1, 'juan.perez@example.com');
INSERT INTO `usuarios` (`username`, `password_hash`, `password_salt`, `id_cliente`, `email`) VALUES ('maria.gomez', 'hash_mg', 'salt_mg', 2, 'maria.gomez@example.com');
INSERT INTO `usuarios` (`username`, `password_hash`, `password_salt`, `id_cliente`, `email`) VALUES ('cajero_a', 'hash_ca', 'salt_ca', NULL, 'cajero_a@gestionprestamos.com');
INSERT INTO `usuarios` (`username`, `password_hash`, `password_salt`, `id_cliente`, `email`) VALUES ('admin_a', 'hash_aa', 'salt_aa', NULL, 'admin_a@gestionprestamos.com');
INSERT INTO `usuarios` (`username`, `password_hash`, `password_salt`, `id_cliente`, `email`) VALUES ('carlos.r', 'hash_cr', 'salt_cr', 3, 'carlos.ramirez@example.com');
INSERT INTO `usuarios` (`username`, `password_hash`, `password_salt`, `id_cliente`, `email`) VALUES ('gerente_b', 'hash_gb', 'salt_gb', NULL, 'gerente_b@gestionprestamos.com');

-- -----------------------------------------------------
-- Inserción de datos en la tabla `usuario_rol`
-- -----------------------------------------------------
INSERT INTO `usuario_rol` (`id_usuario`, `id_rol`) VALUES (1, 1); -- Juan Perez es un CLIENTE
INSERT INTO `usuario_rol` (`id_usuario`, `id_rol`) VALUES (2, 1); -- María Gomez es una CLIENTE
INSERT INTO `usuario_rol` (`id_usuario`, `id_rol`) VALUES (3, 2); -- Cajero_A es un CAJERO
INSERT INTO `usuario_rol` (`id_usuario`, `id_rol`) VALUES (4, 3); -- Admin_A es un ADMINISTRADOR
INSERT INTO `usuario_rol` (`id_usuario`, `id_rol`) VALUES (5, 1); -- Carlos Ramírez es un CLIENTE
INSERT INTO `usuario_rol` (`id_usuario`, `id_rol`) VALUES (6, 4); -- Gerente_B es un GERENTE

-- -----------------------------------------------------
-- Inserción de datos en la tabla `tipo_cuenta`
-- -----------------------------------------------------
INSERT INTO `tipo_cuenta` (`nombre_tipo`, `descripcion`) VALUES ('Cuenta de Ahorro', 'Cuenta para ahorrar dinero con intereses.');
INSERT INTO `tipo_cuenta` (`nombre_tipo`, `descripcion`) VALUES ('Cuenta Corriente', 'Cuenta para transacciones diarias.');
INSERT INTO `tipo_cuenta` (`nombre_tipo`, `descripcion`) VALUES ('Cuenta de Préstamo', 'Cuenta utilizada para gestionar el saldo de un préstamo.');
INSERT INTO `tipo_cuenta` (`nombre_tipo`, `descripcion`) VALUES ('Cuenta a Plazo Fijo', 'Cuenta de ahorro con un plazo de inversión.');

-- -----------------------------------------------------
-- Inserción de datos en la tabla `bancos`
-- -----------------------------------------------------
INSERT INTO `bancos` (`nombre_banco`, `codigo_banco`, `pais`, `ciudad`) VALUES ('Banco de Crédito del Perú', 'BCP', 'Perú', 'Lima');
INSERT INTO `bancos` (`nombre_banco`, `codigo_banco`, `pais`, `ciudad`) VALUES ('Interbank', 'IBK', 'Perú', 'Lima');
INSERT INTO `bancos` (`nombre_banco`, `codigo_banco`, `pais`, `ciudad`) VALUES ('Scotiabank Perú', 'SBP', 'Perú', 'Lima');
INSERT INTO `bancos` (`nombre_banco`, `codigo_banco`, `pais`, `ciudad`) VALUES ('BBVA', 'BBVA', 'Perú', 'Lima');
INSERT INTO `bancos` (`nombre_banco`, `codigo_banco`, `pais`, `ciudad`) VALUES ('Banco Interbank', 'BI', 'México', 'Ciudad de México');

-- -----------------------------------------------------
-- Inserción de datos en la tabla `cuentas_bancarias` (10 cuentas)
-- -----------------------------------------------------
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (1, 1, 1, '123-001-00001', '003-123-001-00001', 1500.00); -- Juan Perez - Ahorro USD
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (1, 2, 3, '123-002-00002', '003-123-002-00002', 5000.00); -- Juan Perez - Corriente PEN
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (2, 1, 3, '123-003-00003', '003-123-003-00003', 2500.00); -- Maria Gomez - Ahorro PEN
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (2, 2, 1, '123-004-00004', '003-123-004-00004', 800.00); -- Maria Gomez - Corriente USD
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (3, 1, 3, '123-005-00005', '003-123-005-00005', 10000.00); -- Carlos Ramírez - Ahorro PEN
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (4, 1, 1, '123-006-00006', '003-123-006-00006', 750.50); -- Ana Sánchez - Ahorro USD
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (5, 2, 3, '123-007-00007', '003-123-007-00007', 12000.00); -- Pedro Vargas - Corriente PEN
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (6, 1, 1, '123-008-00008', '003-123-008-00008', 350.75); -- Sofía Herrera - Ahorro USD
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (7, 1, 3, '123-009-00009', '003-123-009-00009', 20000.00); -- Roberto Castañeda - Ahorro PEN
INSERT INTO `cuentas_bancarias` (`id_cliente`, `id_tipo_cuenta`, `id_moneda`, `numero_cuenta`, `numero_cci_interbancario`, `saldo`) VALUES (10, 2, 1, '123-010-00010', '003-123-010-00010', 450.25); -- Fátima Ruiz - Corriente USD

-- -----------------------------------------------------
-- Inserción de datos en la tabla `prestamos` (3 préstamos)
-- -----------------------------------------------------
-- Préstamo 1: Juan Pérez (USD)
INSERT INTO `prestamos` (`id_cliente`, `id_cuenta_desembolso`, `id_moneda`, `monto_principal`, `tasa_interes`, `plazo_meses`, `fecha_inicio`, `fecha_fin_estimada`, `monto_cuota_mensual`, `saldo_pendiente`) VALUES (1, 1, 1, 10000.00, 0.10, 12, '2025-07-01', '2026-07-01', 900.00, 10000.00);
-- Préstamo 2: María Gómez (PEN)
INSERT INTO `prestamos` (`id_cliente`, `id_cuenta_desembolso`, `id_moneda`, `monto_principal`, `tasa_interes`, `plazo_meses`, `fecha_inicio`, `fecha_fin_estimada`, `monto_cuota_mensual`, `saldo_pendiente`) VALUES (2, 3, 3, 25000.00, 0.12, 24, '2025-06-15', '2027-06-15', 1200.00, 25000.00);
-- Préstamo 3: Roberto Castañeda (PEN)
INSERT INTO `prestamos` (`id_cliente`, `id_cuenta_desembolso`, `id_moneda`, `monto_principal`, `tasa_interes`, `plazo_meses`, `fecha_inicio`, `fecha_fin_estimada`, `monto_cuota_mensual`, `saldo_pendiente`) VALUES (7, 9, 3, 50000.00, 0.08, 36, '2025-05-20', '2028-05-20', 1566.00, 50000.00);


-- -----------------------------------------------------
-- Inserción de datos en la tabla `transacciones` y `movimientos`
-- Se utilizan variables de sesión (@) para ligar los inserts
-- -----------------------------------------------------

-- Transacción 1: Desembolso del préstamo de Juan Pérez
INSERT INTO `transacciones` (`id_cuenta_destino`, `tipo_transaccion`, `monto`, `id_moneda`, `estado_transaccion`, `descripcion`, `id_usuario_registro`) VALUES (1, 'COBRO_PRESTAMO', 10000.00, 1, 'COMPLETADA', 'Desembolso de préstamo #1 a Juan Perez', 4);
SET @last_transaccion_id = LAST_INSERT_ID();
INSERT INTO `movimientos` (`id_transaccion`, `id_cuenta`, `tipo_movimiento`, `monto_movimiento`, `id_moneda`, `saldo_antes_movimiento`, `saldo_despues_movimiento`, `descripcion_movimiento`, `id_prestamo`) VALUES (@last_transaccion_id, 1, 'CREDITO', 10000.00, 1, 1500.00, 11500.00, 'Desembolso de préstamo #1', 1);
UPDATE `cuentas_bancarias` SET `saldo` = `saldo` + 10000.00 WHERE `id_cuenta` = 1;

-- Transacción 2: Depósito en efectivo a la cuenta de María Gómez
INSERT INTO `transacciones` (`id_cuenta_destino`, `tipo_transaccion`, `monto`, `id_moneda`, `estado_transaccion`, `descripcion`, `id_usuario_registro`) VALUES (3, 'DEPOSITO', 500.00, 3, 'COMPLETADA', 'Depósito en efectivo', 3);
SET @last_transaccion_id = LAST_INSERT_ID();
INSERT INTO `movimientos` (`id_transaccion`, `id_cuenta`, `tipo_movimiento`, `monto_movimiento`, `id_moneda`, `saldo_antes_movimiento`, `saldo_despues_movimiento`, `descripcion_movimiento`, `id_prestamo`) VALUES (@last_transaccion_id, 3, 'CREDITO', 500.00, 3, 2500.00, 3000.00, 'Depósito en efectivo', NULL);
UPDATE `cuentas_bancarias` SET `saldo` = `saldo` + 500.00 WHERE `id_cuenta` = 3;

-- Transacción 3: Transferencia interna de Juan Pérez a María Gómez
INSERT INTO `transacciones` (`id_cuenta_origen`, `id_cuenta_destino`, `tipo_transaccion`, `monto`, `id_moneda`, `estado_transaccion`, `descripcion`, `id_usuario_registro`) VALUES (2, 3, 'TRANSFERENCIA_INTERNA', 200.00, 3, 'COMPLETADA', 'Transferencia de Juan a Maria', 1);
SET @last_transaccion_id = LAST_INSERT_ID();
INSERT INTO `movimientos` (`id_transaccion`, `id_cuenta`, `tipo_movimiento`, `monto_movimiento`, `id_moneda`, `saldo_antes_movimiento`, `saldo_despues_movimiento`, `descripcion_movimiento`, `id_prestamo`) VALUES (@last_transaccion_id, 2, 'DEBITO', 200.00, 3, 5000.00, 4800.00, 'Transferencia enviada a Maria', NULL);
INSERT INTO `movimientos` (`id_transaccion`, `id_cuenta`, `tipo_movimiento`, `monto_movimiento`, `id_moneda`, `saldo_antes_movimiento`, `saldo_despues_movimiento`, `descripcion_movimiento`, `id_prestamo`) VALUES (@last_transaccion_id, 3, 'CREDITO', 200.00, 3, 3000.00, 3200.00, 'Transferencia recibida de Juan', NULL);
UPDATE `cuentas_bancarias` SET `saldo` = `saldo` - 200.00 WHERE `id_cuenta` = 2;
UPDATE `cuentas_bancarias` SET `saldo` = `saldo` + 200.00 WHERE `id_cuenta` = 3;

-- Transacción 4: Transferencia interbancaria de Ana Sánchez a un banco externo (BBVA)
INSERT INTO `transacciones` (`id_cuenta_origen`, `id_banco_destino_externo`, `numero_cuenta_destino_externo`, `nombre_titular_destino_externo`, `tipo_transaccion`, `monto`, `id_moneda`, `estado_transaccion`, `descripcion`, `id_usuario_registro`) VALUES (6, 4, '001-456-789-0101', 'Beneficiario Externo', 'TRANSFERENCIA_INTERBANCARIA', 150.00, 1, 'COMPLETADA', 'Transferencia a cuenta BBVA', 4);
SET @last_transaccion_id = LAST_INSERT_ID();
INSERT INTO `movimientos` (`id_transaccion`, `id_cuenta`, `tipo_movimiento`, `monto_movimiento`, `id_moneda`, `saldo_antes_movimiento`, `saldo_despues_movimiento`, `descripcion_movimiento`, `id_prestamo`) VALUES (@last_transaccion_id, 6, 'DEBITO', 150.00, 1, 750.50, 600.50, 'Transferencia interbancaria enviada', NULL);
UPDATE `cuentas_bancarias` SET `saldo` = `saldo` - 150.00 WHERE `id_cuenta` = 6;

-- Transacción 5: Retiro en efectivo de Pedro Vargas
INSERT INTO `transacciones` (`id_cuenta_origen`, `tipo_transaccion`, `monto`, `id_moneda`, `estado_transaccion`, `descripcion`, `id_usuario_registro`) VALUES (7, 'RETIRO', 500.00, 3, 'COMPLETADA', 'Retiro en cajero', 3);
SET @last_transaccion_id = LAST_INSERT_ID();
INSERT INTO `movimientos` (`id_transaccion`, `id_cuenta`, `tipo_movimiento`, `monto_movimiento`, `id_moneda`, `saldo_antes_movimiento`, `saldo_despues_movimiento`, `descripcion_movimiento`, `id_prestamo`) VALUES (@last_transaccion_id, 7, 'DEBITO', 500.00, 3, 12000.00, 11500.00, 'Retiro de efectivo', NULL);
UPDATE `cuentas_bancarias` SET `saldo` = `saldo` - 500.00 WHERE `id_cuenta` = 7;

-- -----------------------------------------------------
-- Inserción de datos en la tabla `cuotas_prestamo`
-- -----------------------------------------------------
-- Cuotas para el préstamo 1 (Juan Pérez)
INSERT INTO `cuotas_prestamo` (`id_prestamo`, `numero_cuota`, `fecha_vencimiento`, `monto_capital`, `monto_interes`, `monto_total_cuota`, `monto_pagado`, `fecha_pago`, `estado_cuota`, `id_movimiento_pago`) VALUES (1, 1, '2025-08-01', 833.33, 66.67, 900.00, 900.00, NOW(), 'PAGADA', NULL);
INSERT INTO `cuotas_prestamo` (`id_prestamo`, `numero_cuota`, `fecha_vencimiento`, `monto_capital`, `monto_interes`, `monto_total_cuota`, `monto_pagado`, `fecha_pago`, `estado_cuota`, `id_movimiento_pago`) VALUES (1, 2, '2025-09-01', 833.33, 66.67, 900.00, 0.00, NULL, 'PENDIENTE', NULL);

-- Cuotas para el préstamo 2 (María Gómez)
INSERT INTO `cuotas_prestamo` (`id_prestamo`, `numero_cuota`, `fecha_vencimiento`, `monto_capital`, `monto_interes`, `monto_total_cuota`, `monto_pagado`, `fecha_pago`, `estado_cuota`, `id_movimiento_pago`) VALUES (2, 1, '2025-07-15', 1000.00, 200.00, 1200.00, 0.00, NULL, 'PENDIENTE', NULL);
INSERT INTO `cuotas_prestamo` (`id_prestamo`, `numero_cuota`, `fecha_vencimiento`, `monto_capital`, `monto_interes`, `monto_total_cuota`, `monto_pagado`, `fecha_pago`, `estado_cuota`, `id_movimiento_pago`) VALUES (2, 2, '2025-08-15', 1000.00, 200.00, 1200.00, 0.00, NULL, 'PENDIENTE', NULL);

-- Cuotas para el préstamo 3 (Roberto Castañeda)
INSERT INTO `cuotas_prestamo` (`id_prestamo`, `numero_cuota`, `fecha_vencimiento`, `monto_capital`, `monto_interes`, `monto_total_cuota`, `monto_pagado`, `fecha_pago`, `estado_cuota`, `id_movimiento_pago`) VALUES (3, 1, '2025-06-20', 1300.00, 266.00, 1566.00, 1566.00, NOW(), 'PAGADA', NULL);
INSERT INTO `cuotas_prestamo` (`id_prestamo`, `numero_cuota`, `fecha_vencimiento`, `monto_capital`, `monto_interes`, `monto_total_cuota`, `monto_pagado`, `fecha_pago`, `estado_cuota`, `id_movimiento_pago`) VALUES (3, 2, '2025-07-20', 1300.00, 266.00, 1566.00, 0.00, NULL, 'ATRASADA', NULL);