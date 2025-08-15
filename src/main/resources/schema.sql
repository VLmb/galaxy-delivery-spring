-- Удаляем таблицу, если она уже существует, чтобы избежать ошибок при перезапуске
DROP TABLE IF EXISTS parcel;

-- Создаем таблицу parcel
CREATE TABLE parcel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tracking_number VARCHAR(255) NOT NULL,
    destination VARCHAR(255),
    status VARCHAR(255),
    weight DOUBLE NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);