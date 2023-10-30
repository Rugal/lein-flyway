CREATE TABLE student
(
  id        INT AUTO_INCREMENT PRIMARY KEY,
  name      VARCHAR(100) NOT NULL,
  create_at BIGINT,
  update_at BIGINT
);

CREATE TABLE course
(
  id        INT AUTO_INCREMENT PRIMARY KEY,
  name      VARCHAR(100) NOT NULL,
  create_at BIGINT,
  update_at BIGINT
);

CREATE TABLE registration
(
  id         INT AUTO_INCREMENT PRIMARY KEY,
  student_id INT NOT NULL REFERENCES student(id),
  course_id  INT NOT NULL REFERENCES course(id),
  score      INT,
  create_at  BIGINT,
  update_at  BIGINT
);
