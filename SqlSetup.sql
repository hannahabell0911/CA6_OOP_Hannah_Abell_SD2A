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
  artist_id INT NOT NULL,
  artist_name VARCHAR(255) NOT NULL,
  release_year YEAR,
  price INT NOT NULL,
  PRIMARY KEY (album_id)
);
--
-- Dumping data for table `album`
--
INSERT INTO album (album_title, artist_id, artist_name, release_year, price) VALUES
  ('Thriller', 1, 'Michael Jackson', 1982, 10),
  ('The Dark Side of the Moon', 2, 'Pink Floyd', 1973, 12),
  ('Nevermind', 3, 'Nirvana', 1991, 8),
  ('Abbey Road', 4, 'The Beatles', 1969, 15),
  ('The Chronic', 5, 'Dr. Dre', 1992, 9),
  ('The Miseducation of Lauryn Hill', 6, 'Lauryn Hill', 1998, 11),
  ('The College Dropout', 7, 'Kanye West', 2004, 10),
  ('Bad', 1, 'Michael Jackson', 1987, 10),
  ('Back in Black', 8, 'AC/DC', 1980, 13),
  ('Appetite for Destruction', 9, 'Guns N\' Roses', 1987, 12);





