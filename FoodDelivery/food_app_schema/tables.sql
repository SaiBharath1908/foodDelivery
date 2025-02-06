-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: food_app
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `Menu_id` int NOT NULL AUTO_INCREMENT,
  `Restaurant_id` int DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `isAvailable` tinyint DEFAULT NULL,
  `imagePath` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Menu_id`),
  UNIQUE KEY `Menu_id_UNIQUE` (`Menu_id`),
  KEY `Restaurant_id_idx` (`Restaurant_id`),
  CONSTRAINT `Restaurant_id` FOREIGN KEY (`Restaurant_id`) REFERENCES `restaurant` (`Restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,1,'Masala Dosa','Crispy dosa filled with spiced potato filling, served with chutney and sambar',150,1,'/images/restaurants/masala-dosa-.jpg'),(2,1,'Onion Dosa','Crispy dosa topped with onions, served with chutney and sambar',180,1,'/images/restaurants/onion-dosa.jpg'),(3,1,'Vada','A traditional South Indian snack made of deep-fried lentil dough',80,1,'/images/restaurants/vada.webp'),(4,2,'Butter Chicken','Tender chicken cooked in a creamy tomato-based gravy',250,1,'/images/restaurants/butter-chicken.jpg'),(5,2,'Dal Makhani','Rich black lentils cooked with butter and cream',180,1,'/images/restaurants/Dal-Makhani.webp'),(6,2,'Tandoori Roti','Soft, fluffy bread baked in a traditional tandoor',30,1,'/images/restaurants/tandoori-roti.jpg'),(10,3,'Kung Pao Chicken','Stir-fried chicken with peanuts, chili peppers, and a savory sauce',200,1,'/images/restaurants/kung-pao.jfif'),(11,3,'Vegetable Spring Rolls','Crispy rolls stuffed with vegetables, served with sweet chili sauce',130,1,'/images/restaurants/veg-spring.jfif'),(12,3,'Sweet and Sour Pork','Pork cooked in a tangy sweet and sour sauce',230,1,'/images/restaurants/sweet.jpg'),(13,5,'Chicken Biryani','Aromatic rice cooked with tender chicken, spices, and saffron',300,1,'/images/restaurants/chicken-biryani.jpg'),(14,5,'Mutton Biryani','Aromatic rice cooked with tender mutton, spices, and saffron',350,1,'/images/restaurants/mutton-biryani.jpg'),(15,5,'Raita','Cool yogurt with cucumber and spices, a perfect side for biryani',50,1,'/images/restaurants/raita.jpg'),(16,6,'California Roll','A sushi roll filled with crab, avocado, and cucumber',500,1,'/images/restaurants/tobiko-roll.jpg'),(17,6,'Dragon Roll','A sushi roll with shrimp tempura, avocado, and eel sauce',600,1,'/images/restaurants/Dragon-Roll.jpg'),(18,6,'Miso Soup','A traditional Japanese soup with tofu and seaweed',130,1,'/images/restaurants/miso-soup.webp'),(19,7,'Beef Tacos','Soft corn tortillas filled with seasoned beef, lettuce, and cheese',150,1,'/images/restaurants/Beef-Tacos.jpg'),(20,7,'Chicken Quesadilla','Flour tortilla filled with grilled chicken, cheese, and vegetables',200,1,'/images/restaurants/chicken-quesa.jpg'),(21,7,'Guacamole','Fresh mashed avocado with lime and cilantro',100,1,'/images/restaurants/guaca.jpg'),(22,8,'Chicken Kebab','Tender chicken marinated in spices and grilled to perfection',230,1,'/images/restaurants/c-kebab.webp'),(23,8,'Lamb Kebab','Juicy lamb marinated in herbs and spices, served with pita bread',280,1,'/images/restaurants/lamp-kebab.jfif'),(24,8,'Hummus','A creamy dip made from blended chickpeas, tahini, and olive oil',100,1,'/images/restaurants/hummus.jpg'),(25,9,'Veggie Burger','A delicious vegetarian burger with a variety of fresh toppings',150,1,'/images/restaurants/Veggie-Burger.webp'),(26,9,'Vegetable Pizza','Pizza topped with a variety of fresh vegetables and cheese',250,1,'/images/restaurants/Veggie-Pizza.webp'),(27,9,'Paneer Tikka','Grilled Indian cottage cheese marinated in spices',200,1,'/images/restaurants/paneer.jfif'),(31,10,'Grilled Salmon','Freshly grilled salmon with a lemon butter sauce',500,1,'/images/restaurants/grilled-salmon.jpg'),(32,10,'Seafood Paella','A traditional Spanish dish made with a variety of seafood',600,1,'/images/restaurants/Seafood-Paella.jpg'),(33,10,'Shrimp Cocktail','Chilled shrimp served with tangy cocktail sauce',300,1,'/images/restaurants/shrimp.jpg'),(34,4,'Margherita Pizza','Classic pizza topped with tomato sauce, mozzarella, and fresh basil leaves.',250,1,'/images/restaurants/marg-pizza.jpg'),(35,4,'Pepperoni Pizza','A savory pizza topped with pepperoni slices, cheese, and tomato sauce.',280,1,'/images/restaurants/pepp-pizza.jpg'),(36,4,'Veggie Pizza','A delicious pizza loaded with bell peppers, mushrooms, onions, and olives.',270,1,'/images/restaurants/veg-pizza.jpg');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderhistory`
--

DROP TABLE IF EXISTS `orderhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderhistory` (
  `OrderHistory_Id` int NOT NULL AUTO_INCREMENT,
  `Order_Id` int DEFAULT NULL,
  `user_Id` int DEFAULT NULL,
  `totalAmount` int DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  PRIMARY KEY (`OrderHistory_Id`),
  UNIQUE KEY `OrderHistory_Id_UNIQUE` (`OrderHistory_Id`),
  KEY `Order_Id_idx` (`Order_Id`),
  KEY `user_Id_idx` (`user_Id`),
  KEY `fk_orderhistory_Order_Id_idx` (`Order_Id`),
  KEY `fk_orderhistory_user_Id_idx` (`user_Id`),
  CONSTRAINT `fk_orderhistory_order_id` FOREIGN KEY (`Order_Id`) REFERENCES `orders` (`Order_Id`),
  CONSTRAINT `fk_orderhistory_user_id` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`),
  CONSTRAINT `FK_OrderHistoryOrderId` FOREIGN KEY (`Order_Id`) REFERENCES `orders` (`Order_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderhistory`
--

LOCK TABLES `orderhistory` WRITE;
/*!40000 ALTER TABLE `orderhistory` DISABLE KEYS */;
INSERT INTO `orderhistory` VALUES (1,10,2,430,'pending','2025-01-15 00:00:00'),(2,11,2,330,'pending','2025-01-15 00:00:00');
/*!40000 ALTER TABLE `orderhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitems` (
  `OrderItems_Id` int NOT NULL AUTO_INCREMENT,
  `Order_Id` int DEFAULT NULL,
  `Menu_id` int DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `ItemTotal` int DEFAULT NULL,
  PRIMARY KEY (`OrderItems_Id`),
  UNIQUE KEY `OrderItems_Id_UNIQUE` (`OrderItems_Id`),
  KEY `Order_Id_idx` (`Order_Id`),
  KEY `Menu_id_idx` (`Menu_id`),
  CONSTRAINT `FK_OrderId` FOREIGN KEY (`Order_Id`) REFERENCES `orders` (`Order_Id`),
  CONSTRAINT `Menu_id` FOREIGN KEY (`Menu_id`) REFERENCES `menu` (`Menu_id`),
  CONSTRAINT `Order_Id` FOREIGN KEY (`Order_Id`) REFERENCES `orders` (`Order_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

LOCK TABLES `orderitems` WRITE;
/*!40000 ALTER TABLE `orderitems` DISABLE KEYS */;
INSERT INTO `orderitems` VALUES (1,10,4,1,250),(2,10,5,1,180),(3,11,1,1,150),(4,11,5,1,180);
/*!40000 ALTER TABLE `orderitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `Order_Id` int NOT NULL AUTO_INCREMENT,
  `user_Id` int DEFAULT NULL,
  `Restaurant_id` int DEFAULT NULL,
  `order_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `TotalAmount` float DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `paymentMode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Order_Id`),
  UNIQUE KEY `Order_Id_UNIQUE` (`Order_Id`),
  KEY `user_id_idx` (`user_Id`),
  KEY `fk_restaurant_id` (`Restaurant_id`),
  CONSTRAINT `fk_restaurant_id` FOREIGN KEY (`Restaurant_id`) REFERENCES `restaurant` (`Restaurant_id`),
  CONSTRAINT `user_Id` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,2,'2025-01-14 16:34:08',250,'pending','creditCard'),(2,1,2,'2025-01-14 16:53:36',250,'pending','creditCard'),(3,1,3,'2025-01-14 16:56:37',200,'pending','creditCard'),(4,1,2,'2025-01-14 16:58:20',250,'pending','creditCard'),(5,1,2,'2025-01-14 16:58:52',250,'pending','creditCard'),(6,1,1,'2025-01-14 17:01:27',150,'pending','creditCard'),(7,1,5,'2025-01-14 21:53:24',300,'pending','creditCard'),(8,2,8,'2025-01-14 22:30:24',510,'pending','creditCard'),(9,2,8,'2025-01-14 22:45:42',510,'pending','creditCard'),(10,2,2,'2025-01-15 11:45:43',430,'pending','creditCard'),(11,2,2,'2025-01-15 11:59:17',330,'pending','upi');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `Restaurant_id` int NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `CuisineType` varchar(45) DEFAULT NULL,
  `DeliveryTime` varchar(60) DEFAULT NULL,
  `Address` varchar(70) DEFAULT NULL,
  `Ratings` float DEFAULT NULL,
  `isActive` tinyint DEFAULT NULL,
  `ImagePath` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Restaurant_id`),
  UNIQUE KEY `restaurant_id_UNIQUE` (`Restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'Dosa Delight','South Indian','30-40 min','100, 5th Cross, Indiranagar, Bangalore 560038',4.5,1,'/images/restaurants/dosa.webp'),(2,'Punjabi Dhaba','North Indian','35-45 min','22, 12th Main, Koramangala 4th Block, Bangalore 560034',4.2,1,'/images/restaurants/punjabi-dhaba.jpg'),(3,'Wok & Roll','Chinese','25-35 min','45, 80 Feet Road, HSR Layout, Bangalore 560102',4,1,'/images/restaurants/wok-roll.jpg'),(4,'Pizza Paradise','Italian','40-50 min','78, 100 Feet Road, JP Nagar 3rd Phase, Bangalore 560078',4.3,1,'/images/restaurants/paradise.jpg'),(5,'Biryani Bazaar','Mughlai','35-45 min','156, Brigade Road, Bangalore 560001',4.6,1,'/images/restaurants/biryani-bazar.webp'),(6,'Sushi Sensation','Japanese','45-55 min','33, Lavelle Road, Bangalore 560001',4.4,1,'/images/restaurants/sushi.webp'),(7,'Taco Fiesta','Mexican','30-40 min','89, Church Street, Bangalore 560001',4.1,1,'/images/restaurants/mexican.jpg'),(8,'Kebab Corner','Middle Eastern','35-45 min','12, Mosque Road, Frazer Town, Bangalore 560005',4.3,1,'/images/restaurants/kebab.png'),(9,'Veggie Delight','Vegetarian','25-35 min','56, 15th Cross, Malleshwaram, Bangalore 560003',4.2,1,'/images/restaurants/veg.jpg'),(10,'Seafood Harbor','Seafood','40-50 min','23, MG Road, Bangalore 560001',4.5,0,'/images/restaurants/seafood.jpg');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_Id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `Created_Date` datetime DEFAULT CURRENT_TIMESTAMP,
  `Last_Login_Date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_Id`),
  UNIQUE KEY `user_Id_UNIQUE` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Sai','Sai@123','sai@gmail.com','BTM, Banglore','2025-01-07 13:31:37','2025-01-07 13:31:37'),(2,'Bharath','bharath@123','bharath@gmail.com','BTM, Banglore','2025-01-07 13:35:26','2025-01-07 13:35:26');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-16 21:36:22
