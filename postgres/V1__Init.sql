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

CREATE TABLE challenges.QUESTION (
  id BIGINT PRIMARY KEY,
  text TEXT NOT NULL,
  image_url TEXT,
  help_text TEXT,
  help_image_url TEXT,
  challenge_type_name TEXT NOT NULL REFERENCES challenges.CHALLENGE_TYPE(name)
);

CREATE TABLE challenges.CHOICES(
  id BIGINT PRIMARY KEY,
  text TEXT NOT NULL,
  score BIGINT NOT NULL,
  image_url TEXT,
  knowledge_text TEXT NOT NULL,
  knowledge_image_url TEXT,
  question_id BIGINT NOT NULL REFERENCES challenges.QUESTION(id)
);

CREATE TABLE challenges.SUBMISSION(
  id BIGINT PRIMARY KEY,
  student_name TEXT NOT NULL,
  score BIGINT NOT NULL,
  challenge_code TEXT NOT NULL REFERENCES challenges.CHALLENGE(code)
);

CREATE TABLE challenges.SUBMISSION_CHOICE(
  submission_id BIGINT NOT NULL REFERENCES challenges.SUBMISSION(id),
  choice_id BIGINT NOT NULL REFERENCES challenges.CHOICES(id),
  PRIMARY KEY(submission_id, choice_id)
);