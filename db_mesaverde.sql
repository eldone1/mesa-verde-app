-- -----------------------------------------------------
-- Creación de la base de datos (opcional, si ya existe, se omitirá)
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `gestion_prestamos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `gestion_prestamos`;

-- -----------------------------------------------------
-- Table `monedas`
-- Almacena los tipos de moneda soportados.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `monedas` (
  `id_moneda` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(3) NOT NULL UNIQUE COMMENT 'Ej. USD, EUR, PEN',
  `nombre` VARCHAR(50) NOT NULL COMMENT 'Ej. Dólar Estadounidense, Euro, Sol Peruano',
  `simbolo` VARCHAR(5) NOT NULL COMMENT 'Ej. $, €, S/',
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_moneda`)
);

-- -----------------------------------------------------
-- Table `clientes`
-- Almacena la información de los clientes.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `tipo_documento` VARCHAR(20) NOT NULL COMMENT 'Ej. DNI, RUC, Pasaporte',
  `numero_documento` VARCHAR(50) NOT NULL UNIQUE,
  `fecha_nacimiento` DATE NULL,
  `direccion` VARCHAR(255) NULL,
  `telefono` VARCHAR(20) NULL,
  `email` VARCHAR(100) NULL UNIQUE,
  `estado` ENUM('ACTIVO', 'INACTIVO', 'BLOQUEADO') NOT NULL DEFAULT 'ACTIVO',
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_cliente`)
);

-- -----------------------------------------------------
-- Table `roles`
-- Almacena los roles de usuario.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roles` (
  `id_rol` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_rol` VARCHAR(50) NOT NULL UNIQUE COMMENT 'Ej. CLIENTE, CAJERO, ADMINISTRADOR, GERENTE',
  `descripcion` VARCHAR(255) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_rol`)
);

-- -----------------------------------------------------
-- Table `usuarios`
-- Almacena las credenciales y el estado de los usuarios del sistema.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL UNIQUE,
  `password_hash` VARCHAR(255) NOT NULL,
  `password_salt` VARCHAR(64) NULL COMMENT 'Cadena aleatoria (salt) utilizada para el hashing de contraseña', -- Renombrado de 'salt'
  `id_cliente` INT UNSIGNED NULL UNIQUE COMMENT 'FK a clientes si el usuario es un cliente',
  `email` VARCHAR(100) NULL UNIQUE COMMENT 'Email del usuario para recuperación de contraseña',
  `estado_usuario` ENUM('ACTIVO', 'INACTIVO', 'BLOQUEADO', 'PENDIENTE_ACTIVACION') NOT NULL DEFAULT 'ACTIVO',
  `ultima_sesion` DATETIME NULL,
  `intentos_fallidos` INT NOT NULL DEFAULT 0,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_usuario`),
  INDEX `idx_usuarios_id_cliente` (`id_cliente` ASC) VISIBLE, -- Renombre de índice para consistencia
  CONSTRAINT `fk_usuarios_a_clientes` -- Renombre de constraint
    FOREIGN KEY (`id_cliente`)
    REFERENCES `clientes` (`id_cliente`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `usuario_rol`
-- Tabla intermedia para la relación N:M entre usuarios y roles.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario_rol` (
  `id_usuario` INT UNSIGNED NOT NULL,
  `id_rol` INT UNSIGNED NOT NULL,
  `fecha_asignacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_usuario`, `id_rol`),
  INDEX `idx_usuario_rol_id_rol` (`id_rol` ASC) VISIBLE, -- Renombre de índice
  CONSTRAINT `fk_usuario_rol_a_usuarios` -- Renombre de constraint
    FOREIGN KEY (`id_usuario`)
    REFERENCES `usuarios` (`id_usuario`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_rol_a_roles` -- Renombre de constraint
    FOREIGN KEY (`id_rol`)
    REFERENCES `roles` (`id_rol`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `tipo_cuenta`
-- Almacena los tipos de cuentas bancarias (ej. Ahorro, Corriente, Crédito, Préstamo).
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tipo_cuenta` (
  `id_tipo_cuenta` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_tipo` VARCHAR(50) NOT NULL UNIQUE COMMENT 'Ej. Cuenta de Ahorro, Cuenta Corriente, Cuenta de Préstamo',
  `descripcion` VARCHAR(255) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_tipo_cuenta`)
);

-- -----------------------------------------------------
-- Table `bancos`
-- Almacena la información de otros bancos externos.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancos` (
  `id_banco` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_banco` VARCHAR(100) NOT NULL UNIQUE COMMENT 'Nombre completo del banco',
  `codigo_banco` VARCHAR(20) UNIQUE NULL COMMENT 'Código de identificación del banco (ej. SWIFT, CLABE, ABA)',
  `pais` VARCHAR(50) NOT NULL,
  `ciudad` VARCHAR(50) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_banco`)
);

-- -----------------------------------------------------
-- Table `cuentas_bancarias`
-- Almacena las cuentas bancarias de los clientes de nuestro banco,
-- incluyendo el número de cuenta normal y el CCI (Código de Cuenta Interbancario).
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cuentas_bancarias` (
  `id_cuenta` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_cliente` INT UNSIGNED NOT NULL,
  `id_tipo_cuenta` INT UNSIGNED NOT NULL,
  `id_moneda` INT UNSIGNED NOT NULL,
  `numero_cuenta` VARCHAR(50) NOT NULL UNIQUE COMMENT 'Número de cuenta interno del banco',
  `numero_cci_interbancario` VARCHAR(64) UNIQUE NULL COMMENT 'Código de Cuenta Interbancario (CLABE en MX, CCI en PE, IBAN en EU, etc.)', -- Campo CCI agregado
  `saldo` DECIMAL(18, 4) NOT NULL DEFAULT 0.0000,
  `fecha_apertura` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado_cuenta` ENUM('ACTIVA', 'CERRADA', 'BLOQUEADA') NOT NULL DEFAULT 'ACTIVA',
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_cuenta`),
  INDEX `idx_cuentas_bancarias_id_cliente` (`id_cliente` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_cuentas_bancarias_id_tipo_cuenta` (`id_tipo_cuenta` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_cuentas_bancarias_id_moneda` (`id_moneda` ASC) VISIBLE, -- Renombre de índice
  CONSTRAINT `fk_cuentas_bancarias_a_clientes` -- Renombre de constraint
    FOREIGN KEY (`id_cliente`)
    REFERENCES `clientes` (`id_cliente`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_cuentas_bancarias_a_tipo_cuenta` -- Renombre de constraint
    FOREIGN KEY (`id_tipo_cuenta`)
    REFERENCES `tipo_cuenta` (`id_tipo_cuenta`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_cuentas_bancarias_a_monedas` -- Renombre de constraint
    FOREIGN KEY (`id_moneda`)
    REFERENCES `monedas` (`id_moneda`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `transacciones`
-- Almacena cada evento de transacción (depósito, retiro, transferencia, pago de préstamo).
-- Incluye campos para transacciones interbancarias.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacciones` (
  `id_transaccion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_cuenta_origen` INT UNSIGNED NULL COMMENT 'Cuenta interna del banco de origen (nuestro banco). NULL si es un depósito en efectivo o transferencia recibida.',
  `id_cuenta_destino` INT UNSIGNED NULL COMMENT 'Cuenta interna del banco de destino (nuestro banco). NULL si es un retiro en efectivo o transferencia enviada.',

  `id_banco_origen_externo` INT UNSIGNED NULL COMMENT 'FK a bancos, si la cuenta origen es de otro banco.',
  `numero_cuenta_origen_externo` VARCHAR(64) NULL COMMENT 'Número de cuenta externa (ej. CCI, IBAN) si es interbancaria de origen.', -- Longitud aumentada
  `nombre_titular_origen_externo` VARCHAR(200) NULL COMMENT 'Nombre del titular de la cuenta externa de origen.',

  `id_banco_destino_externo` INT UNSIGNED NULL COMMENT 'FK a bancos, si la cuenta destino es de otro banco.',
  `numero_cuenta_destino_externo` VARCHAR(64) NULL COMMENT 'Número de cuenta externa (ej. CCI, IBAN) si es interbancaria de destino.', -- Longitud aumentada
  `nombre_titular_destino_externo` VARCHAR(200) NULL COMMENT 'Nombre del titular de la cuenta externa de destino.',

  `tipo_transaccion` ENUM('DEPOSITO', 'RETIRO', 'TRANSFERENCIA_INTERNA', 'TRANSFERENCIA_INTERBANCARIA', 'PAGO_PRESTAMO', 'COBRO_PRESTAMO', 'AJUSTE') NOT NULL,
  `monto` DECIMAL(18, 4) NOT NULL,
  `id_moneda` INT UNSIGNED NOT NULL,
  `fecha_hora_transaccion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado_transaccion` ENUM('PENDIENTE', 'COMPLETADA', 'FALLIDA', 'REVERTIDA') NOT NULL DEFAULT 'PENDIENTE',
  `referencia_externa` VARCHAR(100) NULL COMMENT 'Número de cheque, ID de transferencia externa, etc.',
  `descripcion` VARCHAR(255) NULL,
  `id_usuario_registro` INT UNSIGNED NULL COMMENT 'FK a usuarios, quien realizó la transacción',
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_transaccion`),
  INDEX `idx_transacciones_cuenta_origen` (`id_cuenta_origen` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_transacciones_cuenta_destino` (`id_cuenta_destino` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_transacciones_id_moneda` (`id_moneda` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_transacciones_id_usuario_registro` (`id_usuario_registro` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_transacciones_id_banco_origen_externo` (`id_banco_origen_externo` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_transacciones_id_banco_destino_externo` (`id_banco_destino_externo` ASC) VISIBLE, -- Renombre de índice
  CONSTRAINT `fk_transacciones_a_cuenta_origen` -- Renombre de constraint
    FOREIGN KEY (`id_cuenta_origen`)
    REFERENCES `cuentas_bancarias` (`id_cuenta`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_transacciones_a_cuenta_destino` -- Renombre de constraint
    FOREIGN KEY (`id_cuenta_destino`)
    REFERENCES `cuentas_bancarias` (`id_cuenta`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_transacciones_a_moneda` -- Renombre de constraint
    FOREIGN KEY (`id_moneda`)
    REFERENCES `monedas` (`id_moneda`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_transacciones_a_usuario_registro` -- Renombre de constraint
    FOREIGN KEY (`id_usuario_registro`)
    REFERENCES `usuarios` (`id_usuario`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_transacciones_a_banco_origen_externo` -- Renombre de constraint
    FOREIGN KEY (`id_banco_origen_externo`)
    REFERENCES `bancos` (`id_banco`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_transacciones_a_banco_destino_externo` -- Renombre de constraint
    FOREIGN KEY (`id_banco_destino_externo`)
    REFERENCES `bancos` (`id_banco`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `prestamos`
-- Almacena la información de los préstamos otorgados.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prestamos` (
  `id_prestamo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_cliente` INT UNSIGNED NOT NULL,
  `id_cuenta_desembolso` INT UNSIGNED NOT NULL COMMENT 'Cuenta del cliente donde se desembolsa el préstamo.',
  `id_moneda` INT UNSIGNED NOT NULL,
  `monto_principal` DECIMAL(18, 4) NOT NULL,
  `tasa_interes` DECIMAL(5, 4) NOT NULL COMMENT 'Ej. 0.05 para 5%',
  `plazo_meses` INT UNSIGNED NOT NULL,
  `fecha_inicio` DATE NOT NULL DEFAULT (CURRENT_DATE()), -- CURRENT_DATE() para MySQL
  `fecha_fin_estimada` DATE NOT NULL,
  `monto_cuota_mensual` DECIMAL(18, 4) NOT NULL,
  `saldo_pendiente` DECIMAL(18, 4) NOT NULL,
  `estado_prestamo` ENUM('ACTIVO', 'PAGADO', 'ATRASADO', 'CASTIGADO') NOT NULL DEFAULT 'ACTIVO',
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_prestamo`),
  INDEX `idx_prestamos_id_cliente` (`id_cliente` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_prestamos_id_cuenta_desembolso` (`id_cuenta_desembolso` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_prestamos_id_moneda` (`id_moneda` ASC) VISIBLE, -- Renombre de índice
  CONSTRAINT `fk_prestamos_a_clientes` -- Renombre de constraint
    FOREIGN KEY (`id_cliente`)
    REFERENCES `clientes` (`id_cliente`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_prestamos_a_cuenta_desembolso` -- Renombre de constraint
    FOREIGN KEY (`id_cuenta_desembolso`)
    REFERENCES `cuentas_bancarias` (`id_cuenta`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_prestamos_a_monedas` -- Renombre de constraint
    FOREIGN KEY (`id_moneda`)
    REFERENCES `monedas` (`id_moneda`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `movimientos`
-- Registra el impacto de cada transacción en las cuentas internas individuales.
-- Una transacción puede generar uno o dos movimientos (débito/crédito) en cuentas internas.
-- Esta tabla es CRUCIAL para la auditoría y el cálculo de saldos.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movimientos` (
  `id_movimiento` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_transaccion` INT UNSIGNED NOT NULL,
  `id_cuenta` INT UNSIGNED NOT NULL COMMENT 'Siempre se refiere a una cuenta INTERNA de NUESTRO banco',
  `tipo_movimiento` ENUM('DEBITO', 'CREDITO') NOT NULL,
  `monto_movimiento` DECIMAL(18, 4) NOT NULL,
  `id_moneda` INT UNSIGNED NOT NULL,
  `saldo_antes_movimiento` DECIMAL(18, 4) NOT NULL COMMENT 'Saldo de la cuenta antes de aplicar este movimiento.',
  `saldo_despues_movimiento` DECIMAL(18, 4) NOT NULL COMMENT 'Saldo de la cuenta después de aplicar este movimiento.',
  `fecha_hora_movimiento` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `descripcion_movimiento` VARCHAR(255) NULL,
  `id_prestamo` INT UNSIGNED NULL COMMENT 'FK a prestamos, si este movimiento es un pago o desembolso de préstamo.',
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_movimiento`),
  INDEX `idx_movimientos_id_transaccion` (`id_transaccion` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_movimientos_id_cuenta` (`id_cuenta` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_movimientos_id_moneda` (`id_moneda` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_movimientos_id_prestamo` (`id_prestamo` ASC) VISIBLE, -- Renombre de índice
  CONSTRAINT `fk_movimientos_a_transacciones` -- Renombre de constraint
    FOREIGN KEY (`id_transaccion`)
    REFERENCES `transacciones` (`id_transaccion`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_movimientos_a_cuentas_bancarias` -- Renombre de constraint
    FOREIGN KEY (`id_cuenta`)
    REFERENCES `cuentas_bancarias` (`id_cuenta`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_movimientos_a_monedas` -- Renombre de constraint
    FOREIGN KEY (`id_moneda`)
    REFERENCES `monedas` (`id_moneda`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_movimientos_a_prestamos` -- Renombre de constraint
    FOREIGN KEY (`id_prestamo`)
    REFERENCES `prestamos` (`id_prestamo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `cuotas_prestamo`
-- Almacena el detalle de cada cuota de un préstamo.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cuotas_prestamo` (
  `id_cuota` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_prestamo` INT UNSIGNED NOT NULL,
  `numero_cuota` INT UNSIGNED NOT NULL COMMENT 'Número secuencial de la cuota (1, 2, 3...)',
  `fecha_vencimiento` DATE NOT NULL,
  `monto_capital` DECIMAL(18, 4) NOT NULL,
  `monto_interes` DECIMAL(18, 4) NOT NULL,
  `monto_total_cuota` DECIMAL(18, 4) NOT NULL COMMENT 'Capital + Interés',
  `monto_pagado` DECIMAL(18, 4) NOT NULL DEFAULT 0.0000,
  `fecha_pago` DATETIME NULL,
  `estado_cuota` ENUM('PENDIENTE', 'PAGADA', 'ATRASADA', 'PAGO_PARCIAL') NOT NULL DEFAULT 'PENDIENTE',
  `id_movimiento_pago` BIGINT UNSIGNED NULL UNIQUE COMMENT 'FK al movimiento que registró el pago de esta cuota.',
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_creacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_actualizacion` VARCHAR(100) NOT NULL DEFAULT 'SYSTEM',
  PRIMARY KEY (`id_cuota`),
  UNIQUE KEY `uq_prestamo_cuota` (`id_prestamo`, `numero_cuota`), -- Para asegurar unicidad de cuota por préstamo
  INDEX `idx_cuotas_prestamo_id_prestamo` (`id_prestamo` ASC) VISIBLE, -- Renombre de índice
  INDEX `idx_cuotas_prestamo_id_movimiento_pago` (`id_movimiento_pago` ASC) VISIBLE, -- Renombre de índice
  CONSTRAINT `fk_cuotas_prestamo_a_prestamos` -- Renombre de constraint
    FOREIGN KEY (`id_prestamo`)
    REFERENCES `prestamos` (`id_prestamo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_cuotas_prestamo_a_movimiento_pago` -- Renombre de constraint
    FOREIGN KEY (`id_movimiento_pago`)
    REFERENCES `movimientos` (`id_movimiento`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);