ALTER TABLE vehicles ADD CONSTRAINT fk_parking_id FOREIGN KEY (parking_id) REFERENCES parkings(id);
