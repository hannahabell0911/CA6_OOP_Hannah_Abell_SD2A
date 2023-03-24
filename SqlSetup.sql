--
-- Database: `music`
--

DROP DATABASE IF EXISTS music;
CREATE DATABASE IF NOT EXISTS `music`;
USE `music`;
-- --------------------------------------------------------

--
-- Table structure for table `album`
--
CREATE TABLE album (
  album_id INT NOT NULL AUTO_INCREMENT,
  album_title VARCHAR(255) NOT NULL,
  artist_name VARCHAR(255) NOT NULL,
  release_year INT NOT NULL,
  price FLOAT NOT NULL,
  PRIMARY KEY (album_id)
);
--
-- Dumping data for table `album`
--
INSERT INTO album (album_title, artist_name, release_year, price) VALUES
  ('Thriller',  'Michael Jackson', 1982, 10.0),
  ('The Dark Side of the Moon',  'Pink Floyd', 1973, 12.2),
  ('Nevermind', 'Nirvana', 1991, 8.6),
  ('Abbey Road',  'The Beatles', 1969, 15.1),
  ('The Chronic', 'Dr. Dre', 1992, 9.3),
  ('The Miseducation of Lauryn Hill',  'Lauryn Hill', 1998, 11.9),
  ('The College Dropout',  'Kanye West', 2004, 10.99),
  ('Bad', 'Michael Jackson', 1987, 10.50),
  ('Back in Black',  'AC/DC', 1980, 13.9),
  ('Appetite for Destruction',  'Guns N\' Roses', 1987, 12.3);





