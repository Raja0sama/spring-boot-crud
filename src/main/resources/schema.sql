
DROP TABLE IF EXISTS CARS;
CREATE TABLE CARS (
                      id INTEGER PRIMARY KEY AUTO_INCREMENT,
                      model VARCHAR(255) NOT NULL,
                      base_price VARCHAR(255) NOT NULL,
                      image_link VARCHAR(255) NOT NULL
);
DROP TABLE IF EXISTS features;
CREATE TABLE features (
                               id INTEGER PRIMARY KEY AUTO_INCREMENT,
                               car_id INTEGER NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               price VARCHAR(255) NOT NULL,
                               FOREIGN KEY (car_id) REFERENCES cars(id)
);
DROP TABLE IF EXISTS exterior_colors;
CREATE TABLE exterior_colors (
                                      id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                      car_id INTEGER NOT NULL,
                                      name VARCHAR(255) NOT NULL,
                                      price VARCHAR(255) NOT NULL,
                                      FOREIGN KEY (car_id) REFERENCES cars(id)
);
DROP TABLE IF EXISTS interior_options;
CREATE TABLE interior_options (
                                       id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                       car_id INTEGER NOT NULL,
                                       name VARCHAR(255) NOT NULL,
                                       price VARCHAR(255) NOT NULL,
                                       FOREIGN KEY (car_id) REFERENCES cars(id)
);
DROP TABLE IF EXISTS autopilot_options;
CREATE TABLE autopilot_options (
                                        id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                        car_id INTEGER NOT NULL,
                                        name VARCHAR(255) NOT NULL,
                                        price VARCHAR(255) NOT NULL,
                                        FOREIGN KEY (car_id) REFERENCES cars(id)
);