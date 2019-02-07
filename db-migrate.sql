
CREATE DATABASE point_db;

USE point_db;

CREATE TABLE IF NOT EXISTS POINTS(
	 id      				INT auto_increment PRIMARY KEY NOT NULL,
     measurement_value    	FLOAT(10) NOT NULL,
     measurement_location   ENUM('EE','FI','LI') NOT NULL,
     measurement_year    	TIMESTAMP NOT NULL,
	 created_by				VARCHAR(30) NOT NULL,
	 created_date			TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	 last_modified_by 		VARCHAR(30) NOT NULL,
     last_modified_date 	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)