CREATE TABLE IF NOT EXISTS `car` (
    `id` VARCHAR(36) PRIMARY KEY NOT NULL,
    `num_doors` TINYINT NOT NULL,
    `engine_capacity` DECIMAL(2,1) NOT NULL,
    `car_type` VARCHAR(10) NOT NULL,
    FOREIGN KEY (`id`) REFERENCES `vehicle`(`id`)
)