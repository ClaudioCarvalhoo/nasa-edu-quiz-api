CREATE SCHEMA IF NOT EXISTS challenges;

CREATE TABLE challenges.TEACHER (
    login TEXT PRIMARY KEY
);

CREATE TABLE challenges.CHALLENGE_TYPE (
  name TEXT PRIMARY KEY,
  description TEXT NOT NULL
);

CREATE TABLE challenges.CHALLENGE (
  code TEXT PRIMARY KEY,
  teacher_login TEXT NOT NULL REFERENCES challenges.TEACHER(login),
  challenge_type_name TEXT NOT NULL REFERENCES challenges.CHALLENGE_TYPE(name)
);

CREATE SEQUENCE challenges.QUESTION_SEQ AS BIGINT;
CREATE TABLE challenges.QUESTION (
  id BIGINT DEFAULT nextval('challenges.QUESTION_SEQ') PRIMARY KEY,
  text TEXT NOT NULL,
  image_url TEXT,
  help_text TEXT,
  help_image_url TEXT,
  challenge_type_name TEXT NOT NULL REFERENCES challenges.CHALLENGE_TYPE(name)
);

CREATE SEQUENCE challenges.CHOICE_SEQ AS BIGINT;
CREATE TABLE challenges.CHOICE(
  id BIGINT DEFAULT nextval('challenges.CHOICE_SEQ') PRIMARY KEY,
  text TEXT NOT NULL,
  score BIGINT NOT NULL,
  image_url TEXT,
  knowledge_text TEXT NOT NULL,
  knowledge_image_url TEXT,
  question_id BIGINT NOT NULL REFERENCES challenges.QUESTION(id)
);

CREATE SEQUENCE challenges.SUBMISSION_SEQ AS BIGINT;
CREATE TABLE challenges.SUBMISSION(
  id BIGINT DEFAULT nextval('challenges.SUBMISSION_SEQ') PRIMARY KEY,
  student_name TEXT NOT NULL,
  score BIGINT NOT NULL,
  challenge_code TEXT NOT NULL REFERENCES challenges.CHALLENGE(code)
);

CREATE TABLE challenges.SUBMISSION_CHOICE(
  submission_id BIGINT NOT NULL REFERENCES challenges.SUBMISSION(id),
  choice_id BIGINT NOT NULL REFERENCES challenges.CHOICE(id),
  PRIMARY KEY(submission_id, choice_id)
);