DROP TABLE IF EXISTS WeatherD;


CREATE TABLE WeatherD (
  id INT PRIMARY KEY,
  date_recorded DATE NOT NULL
);

DROP TABLE IF EXISTS LocationD;


CREATE TABLE LocationD (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  weather_id INT,
  city_name VARCHAR(250) NOT NULL,
  state_name VARCHAR(250) NOT NULL,
  latitude DECIMAL(20, 2),
  longitude DECIMAL(20, 2)
);

ALTER TABLE LocationD
    ADD FOREIGN KEY (weather_id) 
    REFERENCES WeatherD(id);

DROP TABLE IF EXISTS TempratureD;


CREATE TABLE TempratureD (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  weather_id INT,
  temperature DECIMAL(20, 2) NOT NULL
);

ALTER TABLE TempratureD
    ADD FOREIGN KEY (weather_id) 
    REFERENCES WeatherD(id);

