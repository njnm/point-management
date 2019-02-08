
CREATE DATABASE point_db;

USE point_db;

CREATE TABLE IF NOT EXISTS POINTS(
	 id      				INT auto_increment PRIMARY KEY NOT NULL,
     measurement_value    	FLOAT(10) NOT NULL,
     measurement_location   VARCHAR(30) NOT NULL,
     measurement_year    	TIMESTAMP NOT NULL,
     unique(measurement_location, measurement_year),
	 created_by				VARCHAR(30)  NULL,
	 created_date			TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	 last_modified_by 		VARCHAR(30)  NULL,
     last_modified_date 	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)