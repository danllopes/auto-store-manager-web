CREATE TABLE IF NOT EXISTS `motorcycle` (
    `id` VARCHAR(36) PRIMARY KEY NOT NULL,
    `cylinder_capacity` SMALLINT NOT NULL,
    `bike_type` VARCHAR(10) NOT NULL,
    FOREIGN KEY (`id`) REFERENCES `vehicle`(`id`)
)