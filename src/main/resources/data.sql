INSERT INTO cars (model, base_price, image_link)
VALUES ('Model 3', '184,000', 'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PPMR,$W40B,$IBB1&view=STUD_FRONT34&model=m3&size=1920&bkba_opt=1&crop=1300,500,300,300&version=v0121-459f1b30d202212210637'),
       ('Model Y', '219,000', 'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PMNG,$W40B,$IBB1&view=STUD_FRONT34&model=m3&size=1920&bkba_opt=1&crop=1300,500,300,300&version=v0121-459f1b30d202212210637'),
       ('Model S', '467,000', 'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PPSB,$W40B,$IBB1&view=STUD_FRONT34&model=m3&size=1920&bkba_opt=1&crop=1300,500,300,300&version=v0121-459f1b30d202212210637'),
       ('Model X', '477,000', 'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PPMR,$W40B,$IBB1&view=STUD_FRONT34&model=m3&size=1920&bkba_opt=1&crop=1300,500,300,300&version=v0121-459f1b30d202212210637');

INSERT INTO features (car_id, name, price)
SELECT id, 'Performance', '235,000'
FROM cars
WHERE model = 'Model 3';

INSERT INTO features (car_id, name, price)
SELECT id, 'Long Range', '215,000'
FROM cars
WHERE model = 'Model 3';

INSERT INTO features(car_id, name, price)
SELECT id, 'Performance', '269,000'
FROM cars
WHERE model = 'Model Y';

INSERT INTO features (car_id, name, price)
SELECT id, 'Long Range', '246,000'
FROM cars
WHERE model = 'Model Y';

INSERT INTO features (car_id, name, price)
SELECT id, 'Performance', '467,000'
FROM cars
WHERE model = 'Model S';

INSERT INTO features (car_id, name, price)
SELECT id, 'Performance', '477,000'
FROM cars
WHERE model = 'Model X';

INSERT INTO exterior_colors (car_id, name, price)
SELECT id, 'Pearl White', 'Included'
FROM cars;

INSERT INTO exterior_colors (car_id, name, price)
SELECT id, 'Solid Black', '4500'
FROM cars
WHERE model = 'Model 3' OR model = 'Model Y';

INSERT INTO exterior_colors (car_id, name, price)
SELECT id, 'Solid Black', '6,000'
FROM cars
WHERE model = 'Model S' OR model = 'Model X';

INSERT INTO exterior_colors (car_id, name, price)
SELECT id, 'Midnight Silver', '6000'
FROM cars;

INSERT INTO exterior_colors (car_id, name, price)
SELECT id, 'Deep Blue', '6000'
FROM cars;

INSERT INTO exterior_colors (car_id, name, price)
SELECT id, 'Red Multi-Coat', '7500'
FROM cars;

INSERT INTO interior_options (car_id, name, price)
SELECT id, 'All Black', 'Included'
FROM cars;

INSERT INTO interior_options (car_id, name, price)
SELECT id, 'Black & White', '4,500'
FROM cars
WHERE model = 'Model 3' OR model = 'Model Y';

INSERT INTO interior_options (car_id, name, price)
SELECT id, 'Black & White', '8,100'
FROM cars
WHERE model = 'Model S' OR model = 'Model X';

INSERT INTO autopilot_options (car_id, name, price)
SELECT id, 'Autopilot', '14,000'
FROM cars;

INSERT INTO autopilot_options (car_id, name, price)
SELECT id, 'Full self-driving', '28,000'
FROM cars;

CREATE SEQUENCE cars_seq
    START WITH 5
    INCREMENT BY 1;

CREATE SEQUENCE autopilot_options_seq
    START WITH 9
    INCREMENT BY 1;

CREATE SEQUENCE exterior_colors_seq
    START WITH 21
    INCREMENT BY 1;

CREATE SEQUENCE features_seq
    START WITH 7
    INCREMENT BY 1;

CREATE SEQUENCE interior_options_seq
    START WITH 9
    INCREMENT BY 1;
