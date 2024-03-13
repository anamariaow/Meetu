CREATE TABLE user (
  record_status tinyint NOT NULL,
  id bigint  PRIMARY key AUTO_INCREMENT,
  email varchar(255) NOT null UNIQUE KEY,
  gender_enum varchar(255) NOT NULL,
  interest_list varchar(255) DEFAULT NULL,
  more_info varchar(255) DEFAULT NULL,
  name varchar(255) NOT NULL,
  orientation_enum varchar(255) DEFAULT NULL,
  password varchar(255) NOT NULL,
  zodiac_sign_enum varchar(255) DEFAULT NULL,
  CONSTRAINT user_experience FOREIGN KEY (experience_id)
    REFERENCES Experience(experience_id),
  CONSTRAINT user_review FOREIGN KEY (review_id)
      REFERENCES Review(review_id),
  CONSTRAINT user_meets FOREIGN KEY (meets_id)
      REFERENCES Meets(meets_id),
  CONSTRAINT user_booking FOREIGN KEY (booking_id)
      REFERENCES Booking(booking_id),
  CONSTRAINT user_chk_1 CHECK ((record_status between 0 and 1))
);
CREATE TABLE meets (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  quantity int NOT NULL,
  record_status tinyint NOT NULL,
  release_date datetime(6) NOT NULL,
  user_id bigint DEFAULT NULL,
  CONSTRAINT meets_chk_1 CHECK ((record_status between 0 and 1))
);
CREATE TABLE review (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  date_of_review date DEFAULT NULL,
  grade double DEFAULT NULL,
  record_status tinyint NOT NULL,
  user_id bigint DEFAULT NULL,
  text varchar(255) DEFAULT NULL,
  CONSTRAINT user_review FOREIGN KEY (review_id)
        REFERENCES Review(review_id),
  CONSTRAINT review_chk_1 CHECK ((record_status between 0 and 1))
);
CREATE TABLE booking (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  price double NOT NULL,
  record_status tinyint NOT NULL,
  experience_id bigint DEFAULT NULL,
  user_id bigint DEFAULT NULL UNIQUE KEY,
  description varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  type_experience varchar(255) NOT NULL,
  CONSTRAINT user_booking FOREIGN KEY (user_id)
        REFERENCES User(user_id),
  CONSTRAINT experience_booking FOREIGN KEY (experience_id)
        REFERENCES Experience(experience_id),
  CONSTRAINT booking_chk_1 CHECK ((record_status between 0 and 1))
);
CREATE TABLE experience (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  experience_value int NOT NULL,
  id_userfk int NOT NULL,
  price double NOT NULL,
  record_status tinyint NOT NULL,
  description varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  type_experience varchar(255) NOT NULL,
  CONSTRAINT user_review FOREIGN KEY (user_id)
          REFERENCES User(user_id),
  CONSTRAINT experience_booking FOREIGN KEY (booking_id)
          REFERENCES Booking(booking_id),
  CONSTRAINT experience_chk_1 CHECK ((record_status between 0 and 1))
);

ALTER TABLE user
ADD CONSTRAINT user_meets
FOREIGN KEY (id)
REFERENCES meets(id);

CREATE TABLE experience_booking (
  booking_id bigint NOT NULL UNIQUE KEY,
  experience_id bigint NOT NULL ,
  FOREIGN KEY (booking_id) REFERENCES booking (id),
  FOREIGN KEY (experience_id) REFERENCES experience (id)
);
CREATE TABLE user_booking_list (
  booking_list_id bigint NOT NULL UNIQUE KEY,
  user_id bigint NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (booking_list_id) REFERENCES booking (id)
);
CREATE TABLE user_experience (
  experience_id bigint NOT NULL,
  user_id bigint NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (experience_id) REFERENCES experience (id)
);
CREATE TABLE user_review_list (
  review_list_id bigint NOT NULL UNIQUE KEY,
  user_id bigint NOT NULL,
  FOREIGN KEY (review_list_id) REFERENCES review (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);