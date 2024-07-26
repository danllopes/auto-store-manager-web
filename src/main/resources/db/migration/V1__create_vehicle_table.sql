CREATE TABLE IF NOT EXISTS `vehicle` (
    `id` VARCHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    `brand` VARCHAR(25) NOT NULL,
    `model` VARCHAR(25) NOT NULL,
    `model_year` TINYINT NOT NULL,
    `condition` VARCHAR(10) NOT NULL,
    `fuel_type` VARCHAR(8) NOT NULL,
    `transmission_type` VARCHAR(10) NOT NULL,
    `mileage` INT NOT NULL
)