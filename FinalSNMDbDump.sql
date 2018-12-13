CREATE DATABASE  IF NOT EXISTS `snm_final` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `snm_final`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: snm_final
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `genrelist`
--

DROP TABLE IF EXISTS `genrelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `genrelist` (
  `genre` varchar(45) NOT NULL,
  `movie_ID` int(11) NOT NULL,
  PRIMARY KEY (`genre`,`movie_ID`),
  KEY `genrelist_fk0` (`movie_ID`),
  CONSTRAINT `FKmovie_ID` FOREIGN KEY (`movie_ID`) REFERENCES `moviedetail` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genrelist`
--

LOCK TABLES `genrelist` WRITE;
/*!40000 ALTER TABLE `genrelist` DISABLE KEYS */;
INSERT INTO `genrelist` VALUES ('crime\ndrama\nthriller',2),('crime',2),('drama',2),('thriller',2),('action\nadventure\nsciencefiction',3),('action',3),('adventure',3),('sciencefiction',3),('drama\nromance',4),('drama',4),('romance',4),('action\ndrama\nfantasy',5),('action',5),('drama',5),('fantasy',5),('drama',6),('drama\nromance',7),('drama',7),('romance',7),('action\ndrama\nhistory\nromance\nwar',8),('action',8),('drama',8),('history',8),('romance',8),('war',8),('action\ncrime',9),('action',9),('crime',9),('comedy\ndrama\nromance',10),('comedy',10),('drama',10),('romance',10),('drama\nfamily',11),('drama',11),('family',11),('action\ncrime\nthriller',12),('action',12),('crime',12),('thriller',12),('action\nbiography\ndrama\nsport',13),('action',13),('biography',13),('drama',13),('sport',13),('biography\ndrama\nsport',14),('biography',14),('drama',14),('sport',14),('comedy\ndrama\nromance',15),('comedy',15),('drama',15),('romance',15),('biography\ndrama\nhistory ',16),('biography',16),('drama',16),('history',16),('biography\ndrama\nhistory ',17),('biography',17),('drama',17),('history',17),('drama\nfantasy\nwar ',18),('drama',18),('fantasy',18),('war',18),('adventure',19),('drama',19),('thriller',19),('action\nfantasy',20),('action',20),('fantasy',20),('drama\nromance',21),('drama',21),('romance',21),('drama',22),('comedy\ndrama\nromance',23),('comedy',23),('drama',23),('romance',23),('action',24),('adventure',24),('fantasy',24),('action',25),('drama',25);
/*!40000 ALTER TABLE `genrelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `languagelist`
--

DROP TABLE IF EXISTS `languagelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `languagelist` (
  `language` varchar(45) NOT NULL,
  `movie_ID` int(11) NOT NULL,
  PRIMARY KEY (`language`,`movie_ID`),
  KEY `FKLanguage_idx` (`movie_ID`),
  CONSTRAINT `FKLanguage` FOREIGN KEY (`movie_ID`) REFERENCES `moviedetail` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `languagelist`
--

LOCK TABLES `languagelist` WRITE;
/*!40000 ALTER TABLE `languagelist` DISABLE KEYS */;
INSERT INTO `languagelist` VALUES ('en',2),('english',2),('en',3),('english',3),('de',4),('en',4),('english\nfrench\ngerman\nitalian',4),('english',4),('fr',4),('french',4),('german',4),('it',4),('italian',4),('hi',5),('hindi',5),('te',5),('telugu\nhindi',5),('telugu',5),('te',6),('telugu',6),('te',7),('telugu',7),('hi',8),('hindi',8),('ta',9),('tamil',9),('ka',10),('kannada',10),('ka',11),('kannada',11),('ta',12),('tamil',12),('hi',13),('hindi',13),('hi',14),('hindi',14),('ma',15),('malayalam',15),('de',16),('german',16),('de',17),('german',17),('sp',18),('spanish',18),('hi',19),('hindi',19),('ka ',19),('kannada \ntelugu\nhindi\ntamil\nmalyalam',19),('kannada ',19),('ma',19),('malyalam',19),('ta',19),('tamil',19),('te',19),('telugu',19),('en',20),('english',20),('hi',21),('hindi',21),('en',22),('english\n',22),('ka',23),('kannada',23),('en',24),('en',25),('english',25);
/*!40000 ALTER TABLE `languagelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moviedetail`
--

DROP TABLE IF EXISTS `moviedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `moviedetail` (
  `movie_ID` int(11) NOT NULL,
  `movie_name` varchar(45) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `cast_and_crew` varchar(400) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `critics_review` varchar(1000) DEFAULT NULL,
  `release_details` varchar(100) DEFAULT NULL,
  `censorboard_ratings` varchar(45) DEFAULT NULL,
  `genres` varchar(255) DEFAULT NULL,
  `languages` varchar(255) DEFAULT NULL,
  `ratecount` int(11) DEFAULT NULL,
  `releasedate` date DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`movie_ID`),
  KEY `FKe9k3gq4gcgn9aq675qbkmxymv` (`genres`,`movie_ID`),
  KEY `FK9fn6bv2bw1oj3r8c8pwyi38pp` (`languages`,`movie_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moviedetail`
--

LOCK TABLES `moviedetail` WRITE;
/*!40000 ALTER TABLE `moviedetail` DISABLE KEYS */;
INSERT INTO `moviedetail` VALUES (0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,'pirates of the caribbean: at world\'s end\n\n','Captain Barbossa, long believed to be dead, has come back to life and is headed to the edge of the Earth with Will Turner and Elizabeth Swann. But nothing is quite as it seems.','Gore Verbinski, Johnny Depp, Orlando Bloom',6.9,'In all fairness, Pirates of the Caribbean is pure popcorn. It\'s loud, fast, and mind-boggling.','2D, 3D','UA','Adventure, Fantasy, Action','English',1,'2007-12-24',NULL,NULL),(2,'the dark knight rises','Following the death of District Attorney Harvey Dent, Batman assumes responsibility for Dent\'s crimes to protect the late attorney\'s reputation and is subsequently hunted by the Gotham City Police Department. Eight years later, Batman encounters the mysterious Selina Kyle and the villainous Bane, a new terrorist leader who overwhelms Gotham\'s finest. The Dark Knight resurfaces to protect a city that has branded him an enemy.','Christopher Nolan, Christian Bale, Anne Hathaway',7.6,'I would just simply describe it as decent. Not terrible, but nothing extraordinary. ','2D, 3D','UA','Crime, Drama, Thriller','English',1,'2012-07-26',NULL,NULL),(3,'avengers: age of ultron','When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth‰Ûªs Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.','Joss Whedon, Tony Stark Jr.',7.3,'For me, I thought it detracted from the story instead of going with the story\'s flow, and much of it didn\'t seem necessary later on. ','2D, 3D, 4D','UA','Action, Adventure, Science Fiction','English',1,'2015-04-23',NULL,NULL),(4,'titanic','84 years later, a 101-year-old woman named Rose DeWitt Bukater tells the story to her granddaughter Lizzy Calvert, Brock Lovett, Lewis Bodine, Bobby Buell and Anatoly Mikailavich on the Keldysh about her life set in April 10th 1912, on a ship called Titanic when young Rose boards the departing ship with the upper-class passengers and her mother, Ruth DeWitt Bukater, and her fiancÌ©, Caledon Hockley. Meanwhile, a drifter and artist named Jack Dawson and his best friend Fabrizio De Rossi win third-class tickets to the ship in a game. And she explains the whole story from departure until the death of Titanic on its first and last voyage April 15th, 1912 at 2:20 in the morning.','James Cameron, Leonardo Di Caprio, Kate Winslet',12.5,'It was an amazing film experience.','2D','UA','Drama, Romance','English,French,German, Italian',2,'1998-01-08',NULL,NULL),(5,'baahubali : the beginning','When Sanga and her husband, part of a tribe living around the province of Mahismathi, save a drowning infant, little do they know the background of the infant or what the future holds for him. The kid grows up to as Shivudu, a free-spirit wanting to explore the mountains and in the process learns of his roots and then realizes the whole purpose of his life and ends up confronting the mighty Bhallala Deva!Ê','Prabhas, Rana Daggubati, Ramya Krishna',8.2,'A result of devoted and highly entertaining imagination','2D, 3D','UA','Action, Drama, Fantasy','Telugu, Hindi',1,'2016-04-28',NULL,NULL),(6,'leader','A well educated idealist, who is a son of Political leader in power wants to correct the rigged political system of favors and corruption. However, this soon becomes a game of power. How would he navigate through the strategies and achieve progress?','Rana Daggubati, Richa Gangopadhyay',8,'There is nothing more to say about the plot Ð it succumbed to all the clichŽs and ended exactly as you might expect.','2D','UA','Drama','Telugu',1,'2010-02-19',NULL,NULL),(7,'geetha govindam','An innocent young lecturer is misunderstood as a pervert and despised by a woman who co-incidentally turns out to be the younger sister of his brother-in-law. Eventually differences subside and love blooms between them.','Parasuram, Vijay Devarakonda, Rashmika Mandanna',8.1,'On a whole, Geetha Govindam is an adorable romantic comedy with a stunning lead pair and pleasing songs.','2D','UA','Drama, Romance','Telugu',1,'2018-08-14',NULL,NULL),(8,'bajirao mastani','Bajirao 1, who fought over 41 major battles and many others, was reputed never to have lost a single one of them. Bajirao is described as \"RANMARD\" a man made of and for the battlefield. Bajirao said to his brother \"Remember that night has nothing to do with sleep. It was created by God, to raid territory held by your enemy. The night is your shield, your screen against the cannons and swords of vastly superior enemy forces. \"Ê','Sanjay Leela Bhansali, Ranveer Singh, Deepika Padukone',7.2,'In all, Bajirao Mastani is an experience. And one that needs to be savoured in a theatre.','2D','U','Action, Drama, History, Romance, War','Hindi',1,'2015-12-18',NULL,NULL),(9,'vada chennai ','A young carrom player in north Chennai becomes a reluctant participant in a war between two warring gangsters.','Vetrimaaran, Dhanush, Ameer Sultan',20.2,'Vada Chennai ends on a high note, while it deals with political overtones in a manner underneath itÕs a peoples film about displacement and development. ','2D','A','Action, Crime','Tamil',3,'2018-10-17',NULL,NULL),(10,'kirik party','Kirik Party is the story of a gang of mischievous students, led by the protagonist Karna (Rakshit Shetty), who have just joined an engineering college. They belong to different streams of engineering but develop a bond while staying together in the hostel. The treatment is stylish with light humour throughout while exploring the college life of these youngsters.Ê','Rakshit Shetty, Rashmika Mandanna',8.5,'It has something for everyone to reminiscence about their college life.','2D','UA','Comedy, Drama, Romance','Kannada ',1,'2017-01-29',NULL,NULL),(11,'godhi banna sadharana mykattu','The film is about Venkob Rao (Anant Nag), a middle class simpleton ailing with Alzheimer\'s, who goes missing. His son, Shiva (Rakshit Shetty) is a career driven person, who is forced to pause his hectic life to search for his father. Sahana (Shruti Hariharan), a doctor who takes care of Venkob Rao also gets involved.Ê','Anant Nag, Rakshit Shetty',8.9,'ItÕs a straightforward narration, but there is attention to detail in every frame and there is absolutely no done to death formulas. May be it looks a tad repetitive in the second half, but otherwise the film is beautifully crafted.','2D','U','Drama, Family','Kannada ',1,'2016-03-06',NULL,NULL),(12,'vikram vedha','A badass cop Vikram leads a special task force formed to eliminate a kickass Vedha\'s gang running amok on the streets of Chennai, making a mockery of Law and Order. An encounter planned by a Vikram\'s friend Simon, kills Vedha\'s trusted aides and brings him out of hiding.Ê','Madhavan, Vijay Sethupathi',19.8,'The stylish film bending slightly towards realism using the fine craft of film-making and especially storytelling in a captivating manner is an interesting film, worth.','2D','UA','Action, Crime, Thriller','Tamil',3,'2017-07-21',NULL,NULL),(13,'dangal','Biopic ofÊMahavir Singh Phogat, who taught wrestling to his daughtersÊBabita KumariÊandÊGeeta Phogat. Geeta Phogat was India\'s first female wrestler to win at the 2010 Commonwealth Games, where she won the gold medal (55 kg) while her sister Babita Kumari won the silver (51 kg).Ê','Aamir Khan, Fatima Sana Shaikh',27.2,'Dangal is a powerhouse of a film that takes the idea of gender equality to a whole new level','2D','UA','Action, Biography, Drama, Sport','Hindi',4,'2016-12-22',NULL,NULL),(14,'bhaag milkha bhaag','The true story of the \"Flying Sikh\" - world champion runner and Olympian Milkha Singh -- who overcame the massacre of his family, civil war during the India-Pakistan partition, and homelessness to become one of India\'s most iconic athletes.Ê','Farhan Akthar, Sonam Kapoor',8.2,'A consummate biopic impeccably woven into a pastiche of sprint, drama, tunes and synergy.','2D','U','Biography, Drama, Sport','Hindi',1,'2013-11-07',NULL,NULL),(15,'bangalore days','Bangalore Days begins with an intro from Kuttan (Nivin Pauly) introducing himself and his cousins namely Divya (Nazriya) and Aju (Dulquer) who share a very friendly relationship right from the childhood.They get separated after their schooling but are reunited at Bangalore after the marriage of Divya to Das. The story revolves around how their life turns at Bangalore.','Anjali menon, Nazriya Nazim',8.3,'Although the film focuses on relationships, family, community and the three love stories, there is plenty more happening in the background. The film interposes the traditional values of rural India with the reality of modern city life, starting with the idea that community is lost in the city. ','2D','U','Comedy, Drama, Romance','Malayalam',1,'2014-05-30',NULL,NULL),(16,'downfall','n 1942, young Traudl Junge (Alexandra Maria Lara) lands her dream job -- secretary to Adolf Hitler (Bruno Ganz) at the peak of his power. Three years later, Hitler\'s empire is now his underground bunker. The real-life Traudl narrates Hitler\'s final days as he rages against imagined betrayers and barks orders to phantom armies, while his mistress, Eva Braun (Juliane Kšhler), clucks over his emotional distance, and other infamous Nazis prepare for the end.',' Bruno Ganz, Alexandra Maria Lara, Ulrich Matthes',9.2,' I don\'t really understand why anyone would find this movie exceptionally good. It\'s not bad, and the horrific story about the war is one that can\'t be told too often, but not taking the intentional emotional shocks (the killing of the children...) into account, I wasn\'t overwhelmed by it.','2D','UA','Biography,Drama,History','German',2,'2004-09-16',NULL,NULL),(17,'schindler\'s list','In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazi Germans.','ÊLiam Neeson,ÊRalph Fiennes,ÊBen KingsleyÊ',13.9,'This is a film in which every element works very well. The story is moving, the dialogue is engaging, the acting is superb, the cinematography is gorgeous, and the themes are powerful and timeless.','2D','UA','Biography,Drama,History','German',2,'1994-03-01',NULL,NULL),(18,'pan\'s labyrinth','In the falangist Spain of 1944, the bookish young stepdaughter of a sadistic army officer escapes into an eerie but captivating fantasy world.','Ivana Baquero,ÊAriadna Gil,ÊSergi L—pez',8.2,'True enough, I was bored with Pan\'s Labyrinth. Really bored. Not that it wasn\'t a beautifully made film. It is, and the sets and costumes all looked like no effort was spared in trying to recreate the 1940s Spain, as well as the fantastical elements in the storyline.','2D','UA','Drama,Fantasy,War','Spanish',1,'2006-06-10',NULL,NULL),(19,'kgf','A period drama narrates the 17000-year-old history of oppressed waging wars against their oppressors. Set in the early 80s, KGF - the first chapter centers the protagonist who leads a battle against oppressors.','Yash, Srinidhi Shetty, Prashant Neel',24.4,'','2D','UA','Drama, Thriller','Kannada ',4,'2018-12-21',NULL,NULL),(20,'mowgli','Human child Mowgli is raised by a wolf pack in the jungles of India. As he learns the often harsh rules of the jungle, under the tutelage of a bear named Baloo and a panther named Bagheera, Mowgli becomes accepted by the animals of the jungle as one of their own, but the fearsome tiger Shere Khan doesn\'t take a liking to him. But there may be greater dangers lurking in the jungle, as Mowgli comes face to face with his human origins.','Christian Bale, Cate Blanchett, Benedict Cumberbatch, Naomie Harris, Andy Serkis, Matthew Rhys, Freida Pinto, Rohan Chand',44.5,' This is a darker, less family-friendly version of the Jungle Book. MowgliÕs story has always had something to say about fitting in, and whether how we look has ever been the best way to judge who is one of us, and who is not. ','2D','U','Adventure,Action,Fantasy','English',7,'2018-11-29',NULL,NULL),(21,'zero','The story revolves around Bauua Singh, a vertically challenged man, who is full of charm and wit, with a pinch of arrogance. Born to a wealthy family and raised in an environment of affluence and indulgence, Bauua was never failed by Meerut or its people. But when he meets two women, his experiences with these women take him on a journey to complete his incompleteness\' and broaden his horizons to find a purpose he never knew he had.','Shah Rukh Khan, Anushka Sharma, Katrina Kaif, Aanand L Rai',5,'','2D','UA','Drama, Romance','Hindi',1,'2018-12-21',NULL,NULL),(22,'destroyer','Destroyer is an English movie starring Sebastian Stan and Nicole Kidman in prominent roles. The movie also stars Toby Kebbell, Tatiana Maslany and Bradley Whitford. It is an action crime drama directed by Karyn Kusama with Theodore Shapiro as musician, forming part of the crew.','Nicole Kidman, Tonby Kebbell, Karyn Kusama',0,'','2D','UA','Drama','English',0,'2019-04-01',NULL,NULL),(23,'orange','While on a train journey, a rich lad Ganesh meets a cute bubbly girl Khushi and falls in love with her. He gathers the courage to talk to her but loses her in the crowd. Will Ganesh be able to find Khushi again? Will he be able to profess her love to her?','Ganesh, Priya Anand, Prashant Raj',15.2,'The movie has all the commercial ingredients to entertain to a large extent, but it is not without its flaws. One feels that the movie could have been trimmed at places, as it feels tedious and predictable. ','2D','UA','Comedy, Drama, Romance','Kannada ',2,'2018-12-07',NULL,NULL),(24,'aquaman','Immediately following the events of Justice League, Arthur Curry, the reluctant heir to the underwater kingdom of Atlantis, tries to balance the world of the surface dwellers and his own people. But where does his loyalty lie? In the water or on the land? While Aquaman finds himself at crossroads with these questions, closer to home a known foe tries to dethrone him.','Jason Mamoa, Amber Heard, James Wan',0,'','2D, 3D','UA','Action, Adventure, Fantasy','English',0,'2018-12-14',NULL,NULL),(25,'creed','Adonis Johnson (Michael B. Jordan) never knew his famous father, boxing champion Apollo Creed, who died before Adonis was born. However, boxing is in his blood, so he seeks out Rocky Balboa (Sylvester Stallone) and asks the retired champ to be his trainer.','Sylvester Stallon, Micheal B Jordan',16,'Complete movie with right amount of action and drama.','2D','U/A','Action,Drama','English',2,'2016-01-04',NULL,NULL);
/*!40000 ALTER TABLE `moviedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferences`
--

DROP TABLE IF EXISTS `preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `preferences` (
  `email_ID` varchar(45) NOT NULL,
  `genre` varchar(45) NOT NULL,
  PRIMARY KEY (`email_ID`,`genre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferences`
--

LOCK TABLES `preferences` WRITE;
/*!40000 ALTER TABLE `preferences` DISABLE KEYS */;
INSERT INTO `preferences` VALUES ('a','action'),('a','adventure'),('a','biography'),('a','comedy'),('a','crime'),('a','drama'),('a','family'),('a','fantasy'),('a','history'),('a','romance'),('a','sciencefiction'),('a','sport'),('a','thriller'),('a','war'),('abcd@gmail.com','action'),('abcd@gmail.com','drama'),('akshaykumar@gmail.com','action'),('akshaykumar@gmail.com','romance'),('binita@gmail.com','action'),('binita@gmail.com','drama'),('gauri@gmail.com','adventure'),('gauri@gmail.com','sport'),('nithin@gmail.com','action'),('nithin@gmail.com','drama'),('qwerty@gmail.com','action'),('qwerty@gmail.com','drama'),('smith@gmail.com','action'),('smith@gmail.com','drama'),('sumuka@gmail.com','action'),('sumuka@gmail.com','family'),('sumuka@gmail.com','war');
/*!40000 ALTER TABLE `preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userprofile`
--

DROP TABLE IF EXISTS `userprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userprofile` (
  `email_ID` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userprofile`
--

LOCK TABLES `userprofile` WRITE;
/*!40000 ALTER TABLE `userprofile` DISABLE KEYS */;
INSERT INTO `userprofile` VALUES ('a','a','a','10','0cc175b9c0f1b6a831c399e269772661'),('abcd@gmail.com','John','Smith','23','0b3bc9ce555f07d127c6da44337e364f'),('akshaykumar@gmail.com','Akshay','Kumar','24','d916b8aefcb6c41a645ecce6c6890c91'),('b',NULL,'b','10','0cc175b9c0f1b6a831c399e269772661'),('binita@gmail.com',NULL,NULL,'20','d916b8aefcb6c41a645ecce6c6890c91'),('gauri@gmail.com','Gauri','L','25','d916b8aefcb6c41a645ecce6c6890c91'),('nithin@gmail.com','nithin','bhardwaj','25','d916b8aefcb6c41a645ecce6c6890c91'),('qwerty@gmail.com','abc','def','22','c1e1c1944c1b5dc24cbf7edd83168d9f'),('smith@gmail.com','smith','julian','22','bec80e8c711b1fedbc1dddbcdc07cb43'),('sumuka@gmail.com','Sumuka','G','20','d916b8aefcb6c41a645ecce6c6890c91');
/*!40000 ALTER TABLE `userprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userratingcheck`
--

DROP TABLE IF EXISTS `userratingcheck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userratingcheck` (
  `email_ID` varchar(40) NOT NULL,
  `movie_ID` varchar(45) NOT NULL,
  PRIMARY KEY (`email_ID`,`movie_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userratingcheck`
--

LOCK TABLES `userratingcheck` WRITE;
/*!40000 ALTER TABLE `userratingcheck` DISABLE KEYS */;
INSERT INTO `userratingcheck` VALUES ('a','12'),('a','13'),('a','17'),('a','19'),('a','20'),('a','23'),('a','9'),('abcd@gmail.com','13'),('abcd@gmail.com','9'),('b','12'),('qwerty@gmail.com','13'),('qwerty@gmail.com','20'),('smith@gmail.com','16'),('smith@gmail.com','19'),('smith@gmail.com','20');
/*!40000 ALTER TABLE `userratingcheck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userreview`
--

DROP TABLE IF EXISTS `userreview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userreview` (
  `email_ID` varchar(45) NOT NULL,
  `movie_ID` int(11) NOT NULL,
  `review` varchar(450) DEFAULT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`email_ID`,`movie_ID`,`timestamp`),
  KEY `FkUsrRv1` (`movie_ID`),
  CONSTRAINT `Fk2UsrRv2` FOREIGN KEY (`email_ID`) REFERENCES `userprofile` (`email_id`),
  CONSTRAINT `FkUsrRv1` FOREIGN KEY (`movie_ID`) REFERENCES `moviedetail` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userreview`
--

LOCK TABLES `userreview` WRITE;
/*!40000 ALTER TABLE `userreview` DISABLE KEYS */;
INSERT INTO `userreview` VALUES ('a',15,'A decent movie to watch when you are bored','2018-12-11 00:06:56'),('a',19,'Amazing movie','2018-12-10 00:30:00'),('a',19,'super hit','2018-12-10 00:32:10'),('a',19,'biggest sandlwood movie','2018-12-11 23:10:26'),('a',25,'super hit','2018-12-11 14:03:11'),('abcd@gmail.com',13,'superb movie','2018-12-11 18:34:39'),('akshaykumar@gmail.com',25,'Sylvester Stallon at his best, re-leaving rocky again AWESOME movie!!','2018-12-12 11:43:18'),('binita@gmail.com',25,'good movie','2018-12-10 14:38:58'),('nithin@gmail.com',25,'Action packed drama, must watch movie.','2018-12-12 11:28:20'),('qwerty@gmail.com',20,'good movie','2018-12-11 19:21:01'),('smith@gmail.com',20,'nive to watch','2018-12-11 19:59:33'),('sumuka@gmail.com',25,'Good movie, can have fun watching it once.','2018-12-11 00:00:41');
/*!40000 ALTER TABLE `userreview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `watchlist`
--

DROP TABLE IF EXISTS `watchlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `watchlist` (
  `email_ID` varchar(45) NOT NULL,
  `movie_ID` int(11) NOT NULL,
  PRIMARY KEY (`email_ID`,`movie_ID`),
  KEY `fk0wl_idx` (`movie_ID`),
  CONSTRAINT `fk0WL` FOREIGN KEY (`movie_ID`) REFERENCES `moviedetail` (`movie_id`),
  CONSTRAINT `fk1wl` FOREIGN KEY (`email_ID`) REFERENCES `userprofile` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `watchlist`
--

LOCK TABLES `watchlist` WRITE;
/*!40000 ALTER TABLE `watchlist` DISABLE KEYS */;
INSERT INTO `watchlist` VALUES ('a',13),('abcd@gmail.com',13),('binita@gmail.com',13),('sumuka@gmail.com',17),('a',19),('qwerty@gmail.com',20),('a',23),('sumuka@gmail.com',23),('smith@gmail.com',24);
/*!40000 ALTER TABLE `watchlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 11:49:50
