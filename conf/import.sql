LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'ART Administrator','Admin'),(2,'Architecture Expert entering architectural refactorings into the ART.','Editor'),(3,'Searchs for architectural refactorings base on smells.','Applier'),(4,'Non Login User with only read rights.','nonLogin');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `Permission` WRITE;
/*!40000 ALTER TABLE `Permission` DISABLE KEYS */;
INSERT INTO `Permission` VALUES (1,'smell','POST'),(2,'smell','PUT'),(3,'smell','DELETE'),(4,'smellgroup','POST'),(5,'smellgroup','PUT'),(6,'smellgroup','DELETE'),(7,'property','POST'),(8,'property','PUT'),(9,'property','DELETE'),(10,'menu','POST'),(11,'menu','PUT'),(12,'menu','DELETE'),(13,'user','POST'),(14,'user','PUT'),(15,'user','DELETE'),(16,'changepw','PUT'),(17,'exectasktype','POST'),(18,'exectasktype','PUT'),(19,'exectasktype','DELETE'),(20,'discussion','POST'),(21,'discussion','PUT'),(22,'discussion','DELETE'),(23,'comment','POST'),(24,'comment','PUT'),(25,'comment','DELETE'),(26,'like','PUT'),(27,'avatar','POST'),(28,'usersearch','GET'),(29,'usersearch','POST'),(30,'usersearch','DELETE'),(31,'task','POST'),(32,'task','PUT'),(33,'task','DELETE'),(34,'modelelement','POST'),(35,'modelelement','PUT'),(36,'modelelement','DELETE'),(37,'ar','POST'),(38,'ar','PUT'),(39,'ar','DELETE'),(40,'arversion','POST'),(41,'arversion','PUT'),(42,'arversion','DELETE');
/*!40000 ALTER TABLE `Permission` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Role_Permission` WRITE;
/*!40000 ALTER TABLE `Role_Permission` DISABLE KEYS */;
INSERT INTO `Role_Permission` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(2,1),(2,2),(2,14),(2,16),(2,17),(2,18),(2,19),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(2,29),(2,30),(2,31),(2,32),(2,33),(1,34),(1,35),(1,37),(1,38),(1,40),(1,41),(3,23),(3,24),(3,25),(3,26),(3,27),(3,28),(3,29),(3,30);
/*!40000 ALTER TABLE `Role_Permission` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,NULL,'2015-05-26 09:45:12','cbisig@hsr.ch','Christian','http://www.hsr.ch','Bisig','2015-05-26 09:45:12','HSR','stay',1),(2,NULL,'2015-05-26 09:45:12','admin@hsr.ch','Hans','http://www.hsr.ch','Admin','2015-05-26 09:45:12','HSR','stay',1),(3,NULL,'2015-05-26 09:45:12','editor@hsr.ch','Hugo','http://www.hsr.ch','Editor','2015-05-26 09:45:12','HSR','stay',2),(4,NULL,'2015-05-26 09:45:12','applier@hsr.ch','Rudolf','http://www.hsr.ch','Applier','2015-05-26 09:45:12','HSR','stay',3),(5,NULL,NULL,'ozimmerm@hsr.ch','Olaf','http://www.ifs.hsr.ch/Olaf-Zimmermann.11623.0.html?&L=4','Zimmermann',NULL,'HSR FHO, Institute for Software','arbrowser',1),(6,NULL,NULL,'test@test.org','TEst','www.google.ch','test',NULL,'test','arbrowser',2),(7,NULL,NULL,'tbd@t.b.c','OLAF','TBC','Zimm',NULL,'tbd','home',2);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Digest` WRITE;
/*!40000 ALTER TABLE `Digest` DISABLE KEYS */;
INSERT INTO `Digest` VALUES (1,'6jXwcJwzde0gnHW77GSxww==','7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),(2,'6jXwcJwzde0gnHW77GSxww==','7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),(3,'6jXwcJwzde0gnHW77GSxww==','7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),(4,'6jXwcJwzde0gnHW77GSxww==','7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),(5,'UVe6rIH30kUqZpxeoJ3FRQ==','szvPfWiU4mwmiqNzNNs0ALT/dPEMOfsgj4BEGq6yUfQ='),(6,'A+4GOr0IVUAESa14FgR0Zg==','1iH4mxiK+tCV8c6mB+BcH+i8S6CPdBY38yILLqt2Rqo='),(7,'1xBl3UFSF6a+By8AfPGT4A==','6ORGjY7M8YsLqFNrY+pd7VTnmewaz7TCRkX1Q4IC/NI=');
/*!40000 ALTER TABLE `Digest` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `TaskPropertyType` WRITE;
/*!40000 ALTER TABLE `TaskPropertyType` DISABLE KEYS */;
INSERT INTO `TaskPropertyType` VALUES (7,'Assignee'),(8,'Type'),(9,'Description'),(10,'Priority'),(11,'Due Date'),(12,'Estimated Duration');
/*!40000 ALTER TABLE `TaskPropertyType` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `TaskTemplate` WRITE;
/*!40000 ALTER TABLE `TaskTemplate` DISABLE KEYS */;
INSERT INTO `TaskTemplate` VALUES (1,'Create SAD',NULL),(2,'Organise project status meeting',NULL),(3,'Organise code review meeting',NULL),(4,'Implement change',NULL),(5,'Execute load test',NULL),(6,'Execute integration test',NULL),(7,'Deploy application',NULL),(8,'Purchase 3rd party software license',NULL),(9,'Emit current application performance',NULL),(10,'Software Architecture Design sign-off',NULL),(11,'Order Server Hardware',NULL),(12,'Redesign layer (ZIO)',NULL),(13,'Design document layout (i.e., the pendant to the machine-readable SQL DDL)',NULL),(14,'Get work done',NULL),(16,'Design system the rational way :-)',NULL),(17,'Determine used Session parameters',NULL),(20,'Evaluate Session State Store',NULL),(21,'Adjust current Application Design',NULL),(22,'Create attribute migration plan',NULL),(23,'Change generation of data model representation (from XML to JSON)',NULL),(24,'Update interface specifications',NULL);
/*!40000 ALTER TABLE `TaskTemplate` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `TaskProperty` WRITE;
/*!40000 ALTER TABLE `TaskProperty` DISABLE KEYS */;
INSERT INTO `TaskProperty` VALUES (1,'Design Task',8,1),(2,'high',10,1),(3,'20h',12,1),(4,'Communication Task',8,2),(5,'medium',10,2),(6,'10h',12,2),(7,'Development Task',8,3),(8,'medium',10,3),(9,'10h',12,3),(10,'Development Task',8,4),(11,'medium',10,4),(12,'1h',12,4),(13,'Testing Task',8,5),(14,'low',10,5),(15,'15h',12,5),(16,'Testing Task',8,6),(17,'medium',10,6),(19,'Integration Task',8,7),(20,'high',10,7),(21,'8h',12,7),(22,'Commercial Task',8,8),(23,'high',10,8),(24,'40h',12,8),(25,'Measurement Task',8,9),(26,'medium',10,9),(27,'3h',12,9),(28,'Design Task',8,10),(29,'medium',10,10),(30,'1h',12,10),(32,'low',10,11),(33,'19h',12,11),(34,'qwq',12,16),(35,'<p>See <a href=\"http://epf.eclipse.org/wikis/openup/\">OpenUP</a><br/></p>',9,16),(36,'Analysis Task',8,17),(37,'<p>Analyse the current implementation, which attributes are saved in the client side cookie.&#160;</p>',9,17),(40,'Decision Task',8,20),(42,'Softwarearchitect',7,21),(43,'Design Task',8,21),(44,'Softwarearchitect',7,22),(45,'Design Task',8,22),(46,'<ul><li>Compare a list of the current attributes and with a list of the future attributes.</li><li>Search for the affected program parts</li><li>Create a data migration mapping</li></ul>',9,22),(47,'Development Task',8,23),(48,'Software Engineer',7,23),(49,'<p>Instead of using an XML mapping library like JAXB, use an JSON mapping library.</p>',9,23),(50,'Softwarearchitect / Designer',7,24),(51,'Design Task',8,24),(52,'<p>Update the description of the interface which will be used by interface application as guidance how to program against the interface.</p>',9,24);
/*!40000 ALTER TABLE `TaskProperty` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `SmellGroup` WRITE;
/*!40000 ALTER TABLE `SmellGroup` DISABLE KEYS */;
INSERT INTO `SmellGroup` VALUES (1,'desc','Performance'),(2,'desc','Complexity'),(3,'desc','Dependency'),(4,'desc','Security'),(5,'desc','Standards');
/*!40000 ALTER TABLE `SmellGroup` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Smell` WRITE;
/*!40000 ALTER TABLE `Smell` DISABLE KEYS */;
INSERT INTO `Smell` VALUES (18,'2015-05-26 13:31:07','<p>It takes rather long to migrate existing data after an update to the data model (database schema)<br/></p>','Database, flexibility','2015-05-26 13:52:24','Migration Problems','draft','hh',1,2),(19,'2015-05-26 13:32:43','<p>dds<br/></p>','ZIO','2015-05-26 13:32:43','ZIO-Smell','draft','ll',1,2),(22,'2015-08-19 16:46:41','<p>TODO tbd<br/></p>','Infrastructure design','2015-08-19 16:49:12','Performance s***s','draft','hh',0,1),(23,'2015-08-19 16:58:09',NULL,NULL,'2015-08-19 16:58:09','New smell created within AR','draft','mm',0,1),(24,'2015-08-19 18:04:02','','scalability,performance,high volume of requests','2015-10-14 07:28:47','Scalability issue','draft','hm',0,2),(25,'2015-09-29 14:20:39','<p>Scenario 1:</p><p>During the evolution of an application it might be possible, that more and more session attributes are necessary. The amount of attributes reaches the limit of the session store (e.x. a client side cookie (4093 Bytes)).</p><p><br/></p><p>Scenario 2:</p><p>Your newly developing an application which requires a lot of session attributes.</p>','session, state, attributes','2015-09-29 14:20:39','Large amount of session attributes','draft','mh',0,1),(26,'2015-09-29 16:23:08',NULL,NULL,'2015-09-29 16:23:08','Sensitive Session Data','draft','hh',0,4),(27,'2015-10-14 06:58:46',NULL,'soap,rest,complexity,interface','2015-10-14 06:58:46','Complex interface','draft','hm',0,2),(28,'2015-10-14 07:28:24',NULL,'performance loss','2015-10-14 07:28:24','Performance loss','draft','hm',0,1),(29,'2015-10-14 09:19:28',NULL,NULL,'2015-10-14 09:19:28','New Smell','draft','mm',0,1),(30,'2015-10-14 09:29:12',NULL,NULL,'2015-10-14 09:29:26','asdfasdf','draft','mm',0,1);
/*!40000 ALTER TABLE `Smell` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Question` WRITE;
/*!40000 ALTER TABLE `Question` DISABLE KEYS */;
INSERT INTO `Question` VALUES (27,'Are?',18),(28,'you',18),(33,'HELLO?, what is going on here???',22),(34,'This is another Q?',22),(36,'Are you reaching the limit of your session state storage?',25),(37,'Does your session state contain sensitive session data?',26),(38,'Have interface partners problems programming against your interface?',27),(39,'Is it difficult to implement changes for an interface?',27),(40,'Does your application not scale well for a high volume of request?',24),(41,'Are the response times of your application constant but to high?',28),(42,'Are the response times of your application not constant?',24),(43,'asdfasdf',30);
/*!40000 ALTER TABLE `Question` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Ar` WRITE;
/*!40000 ALTER TABLE `Ar` DISABLE KEYS */;
INSERT INTO `Ar` VALUES (6),(7),(9),(11),(12),(13),(14);
/*!40000 ALTER TABLE `Ar` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `ArVersion` WRITE;
/*!40000 ALTER TABLE `ArVersion` DISABLE KEYS */;
INSERT INTO `ArVersion` VALUES (12,'2015-05-26 13:28:39','<p><i>This </i>is the Doodle example to identify the knowledge elements that are apparent and important to know to be able to apply the same AR in a similar project context. See the <a href=\"http://www.computer.org/csdl/mags/so/2015/02/mso2015020026-abs.html\" target=\"_blank\">research paper</a> for details: <a href=\"http://www.computer.org/csdl/mags/so/2015/02/mso2015020026-abs.html\">http://www.computer.org/csdl/mags/so/2015/02/mso2015020026-abs.html</a></p><p><img src=\"http://www.eaipatterns.com/img/MessageChannelSolution.gif\" alt=\"Selfhtml\"/></p>','2015-05-26 13:28:39','De-SQL','published',6,5),(13,'2015-05-26 14:10:01','<p><b>Execution Tasks:</b><br/></p><ul><li>Design document layout (i.e., the pendant to the machine-readable SQL DDL)</li><li>Write new data access layer, implement SQLish query capabilities within project&#8226;Decide on transaction boundaries (if any)</li><li>Documentcument the changes to database administration changes (e.g., command-line DDL/DML, backup)<br/></li></ul>','2015-05-26 14:10:01','ZIO-AR3','draft',7,5),(15,'2015-08-19 16:36:31','<p>Add a tier in <i>physical </i>viewpooint:</p><ul><li>install server</li><li>Follow step documented here: <a href=\"http://www.ifs.hsr.ch/Olaf-Zimmermann.11623.0.html?&amp;L=4\">TODO</a><br/></li></ul><p><u><i><b>tbc</b></i></u></p><p><br/></p><p><a href=\"http://www.exitcertified.com/training/images/featureSheet/topImages/random6.gif\"><u><i><b>http://www.exitcertified.com/training/images/featureSheet/topImages/random6.gif</b></i></u></a><br/></p>','2015-08-19 16:36:31','Add Tier','draft',9,1),(16,'2015-08-19 16:43:36','<p>Add a tier in <i>physical </i>viewpooint:</p><ul><li>install server</li><li>Follow step documented here: <a href=\"http://www.ifs.hsr.ch/Olaf-Zimmermann.11623.0.html?&amp;L=4\">TODO</a><br/></li></ul><p><u><i><b>tbc</b></i></u></p><p><br/></p><p><img src=\"http://www.exitcertified.com/training/images/featureSheet/topImages/random6.gif\"/></p>','2015-08-19 16:43:36','Add Tier','draft',9,1),(18,'2015-09-29 11:16:04','<p></p><p><span>A Client Session State has some disadvantages which can become unhandy when an application runs in a cloud environment.</span><br/></p><p>One major disadvantage for client session state is its limitation of space. For example a cookie can hold only 4093 Bytes. Not be able to store too much data on the client side makes sense, since this forces the development to use either server (not recommended to use in a cloud environment, see <a href=\"http://sinv-56041.edu.hsr.ch/art-app/#/ar/12\">http://sinv-56041.edu.hsr.ch/art-app/#/ar/12</a>) or database session state.</p><p>Also the use of the client session state implies, that all session attributes are transfered back and forth between the client and the server even though not all of the attributes might be used (e.x. to display) on the client side.</p><p>Other advantages of the database session state are for example, that the session gets not lost after connection loss between client and server or after a either one of them crashes.</p><p>In addition Database Session State copes better with a clustered environment than a common Server Session State. Since the session is stored in the database layer, multiple webservers can have access to it (Session migration) and therefore it is not necessary to have Session affinity (only one server which handles the session).</p><p><b>Remark</b>: Remember, at least one attribute (user identifier / session id) has to be stored always on the client side.</p><p></p><hr/><p></p>Affected by the session state migration are the business application (most probably only the backend) and the middleware. Current middleware (e.x. RDBMS) can be used or new middleware (e.x. noSQL Key-Value-Store) has to be put in place.&#160;<span>The first step would be to determine all necessary Session attributes.</span><p>For a new application you are free in the design and choice of storage.&#160;</p>','2015-09-29 11:16:04','Migrate from Client to Database Session State','draft',11,1),(19,'2015-09-29 13:01:54',NULL,'2015-09-29 13:01:54','Migrate from Server to Database Session State','draft',12,1),(20,'2015-10-03 18:18:14','<p>SOAP based Webservices might often have a high complexity (Use of schemas, RPC configuration, use of WSDL, UDDI) and often use XML. Whereby a typical REST Service interface provides the main CRUD operations on a specific resource using standard HTTP protocol and the lightweight JSON data representation (can have any other format (XML, text, binary, ...), but todays most common representation seems to be JSON).</p><hr/><p>Remote Procedure Invocation according to Hope and Woolf (Enterprise Intergration Patterns):<br/></p><p><i>Quote: </i><i>Remote Procedure Invocation</i><span><i><span class=\"Apple-converted-space\">&#160;</span>applies the principle of encapsulation to integrating applications. If an application needs some information that is owned by another application, it asks that application directly. If one application needs to modify the data of another, then it does so by making a call to the other application. Each application can maintain the integrity of the data it owns. Furthermore, each application can alter its internal data without having every other application be affected.</i></span><br/></p><p><img src=\"http://www.enterpriseintegrationpatterns.com/img/EncapsulatedSynchronousIntegration.gif\"/></p><hr/><p><span>The main difference between SOAP and REST Services is speaking to an Object/Resource rather than functions. In an SOAP Service you normally provide arguments to functions which then act depending on this arguments. In REST you request, provide or change resources. See Details on Richardson Maturity Model described by Martin Fowler:&#160;<a href=\"http://martinfowler.com/articles/richardsonMaturityModel.html\">http://martinfowler.com/articles/richardsonMaturityModel.html</a></span><br/></p><p>The mentioned resource are always reachable with the same unique identifier.&#160;</p><p>The REST architecture complies very well with the OO-paradigm and with upcoming noSQL Database as well with RDBMS (using common OR-Mappers as Hibernate and JSON Libaries).</p><p><br/></p><p><span><br/></span></p>','2015-10-14 06:09:01','Migrate SOAP-based Web service to REST','draft',13,1),(21,'2015-10-05 09:13:02','<p>It can have many different reasons if your application does not scale well. The reasons could be directly in your program code or architectural decision in your application, but they can as well lie in the setup of your cloud hosting or the choice of middleware you use.</p><h4>Choice of Data Store</h4><p>Depending of your application requirements. For example high volume of transactions (Update, Insert), large data objects, many user, etc. The choice of the data store has to be revisited. For a high volume of small transactions, the choice of an in-memory database such as MemSQL might be a good choice.</p><h4>Choice of Interface</h4><p>Due to high interface overhead or complexity the choice of interface might have to be revisited and change according your applications and mostly your interface partners needs. For example see AR Migrate from SOAP to REST&#160;<a href=\"http://sinv-56041.edu.hsr.ch/art-app/#/ar/13\">http://sinv-56041.edu.hsr.ch/art-app/#/ar/13</a></p>','2015-10-14 07:20:39','Improve application scalability','draft',14,1);
/*!40000 ALTER TABLE `ArVersion` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Discussion` WRITE;
/*!40000 ALTER TABLE `Discussion` DISABLE KEYS */;
INSERT INTO `Discussion` VALUES (12,'2015-05-26 13:28:39','DISCUSSION',12),(13,'2015-05-26 14:10:01','DISCUSSION',13),(15,'2015-08-19 16:36:31','DISCUSSION',15),(16,'2015-08-19 16:43:36','DISCUSSION',16),(18,'2015-09-29 11:16:04','DISCUSSION',18),(19,'2015-09-29 13:01:54','DISCUSSION',19),(20,'2015-10-14 06:09:01','DISCUSSION',20),(21,'2015-10-14 07:20:39','DISCUSSION',21);
/*!40000 ALTER TABLE `Discussion` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
INSERT INTO `Comment` VALUES (12,'Need to find balance betweenb free form and popups','2015-05-26 14:10:21','2015-05-26 14:10:21',13,5),(13,'Does this really make sense?','2015-08-19 16:38:49','2015-08-19 16:38:49',15,1),(14,'Dunno','2015-08-19 16:38:55','2015-08-19 16:38:55',15,1);
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Likeing` WRITE;
/*!40000 ALTER TABLE `Likeing` DISABLE KEYS */;
INSERT INTO `Likeing` VALUES (2,13,1),(1,14,1);
/*!40000 ALTER TABLE `Likeing` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `ModelElementLink` WRITE;
/*!40000 ALTER TABLE `ModelElementLink` DISABLE KEYS */;
INSERT INTO `ModelElementLink` VALUES (1,NULL,'Context View','ContextElementLink'),(2,NULL,'Functional View','ContextElementLink'),(3,NULL,'Information View','ContextElementLink'),(4,NULL,'Concurrency View','ContextElementLink'),(5,NULL,'Logical View','ContextElementLink'),(6,NULL,'Process View','ContextElementLink'),(7,NULL,'Development View','ContextElementLink'),(8,NULL,'Physical View','ContextElementLink'),(9,NULL,'Scenarios','ContextElementLink'),(10,NULL,'Deployment View','ContextElementLink'),(11,'http://en.wikipedia.org/wiki/Computer_performance','Performance','QASElementLink'),(12,NULL,'Scalability','QASElementLink'),(13,NULL,'Costs','QASElementLink'),(14,NULL,'Complexity','QASElementLink'),(15,NULL,'Dependency','QASElementLink'),(16,NULL,'Probability','QASElementLink'),(17,NULL,'Data integrety','QASElementLink'),(18,NULL,'High parallelisation','DecisionElementLink'),(19,NULL,'Choice of hardware plattform','DecisionElementLink'),(20,NULL,'Choice of operating system','DecisionElementLink'),(21,NULL,'Choice of middleware','DecisionElementLink'),(22,NULL,'Choice of thirdparty vendor','DecisionElementLink'),(24,NULL,'Approach to threading (concurrency management)','DecisionElementLink'),(25,NULL,'Approach to resource protection','DecisionElementLink'),(33,NULL,'Hardware (server)','ComponentElementLink'),(34,NULL,'Application software (Business software)','ComponentElementLink'),(35,NULL,'Operating system','ComponentElementLink'),(36,NULL,'Middleware','ComponentElementLink'),(37,NULL,'Interfaces','ComponentElementLink'),(38,NULL,'Scheduler','ComponentElementLink'),(39,NULL,'Other applications','ComponentElementLink'),(40,NULL,'Quality assurance of service','ComponentElementLink'),(41,NULL,'Unit of work','ComponentElementLink'),(42,NULL,'Software Systems Architecture [Rozanski & Woods]','ReferenceElementLink'),(43,NULL,'Applying UML and Patterns [Larman]','ReferenceElementLink'),(44,NULL,'UML Distilled [Fowler]','ReferenceElementLink'),(45,NULL,'Refactoring To Patterns [Kerievsky]','ReferenceElementLink'),(46,NULL,'Just Enough Software Architecture [Fairbanks]','ReferenceElementLink'),(47,NULL,'Flexibility','QASElementLink'),(48,'http://philippe.kruchten.com/2011/02/10/the-frog-and-the-octopus-go-to-snowbird/','OCTOPUS-1','ContextElementLink'),(49,'http://www.eaipatterns.com/ramblings/74_messaging.html','EIP Website','ReferenceElementLink'),(50,'tbd','Maintainability (ZIO)','QASElementLink'),(51,NULL,'DD-ZIO','DecisionElementLink'),(53,'tbd','Choice of data modeling paradigm (current decision is: relational)','DecisionElementLink'),(54,NULL,'Choice of metamodel and query language (current decision is SQL)','DecisionElementLink'),(55,NULL,'tbc','DecisionElementLink'),(56,NULL,'tbd','DecisionElementLink'),(58,NULL,'Scenario VP','ContextElementLink'),(60,'As an end user, I want to experience subsecond response times so that I can get a lot of work done every time I work withteh system.','Performance IS everything','QASElementLink'),(61,'http://martinfowler.com/books/eaa.html','Patterns of Enterprise Application Architecture [Martin Fowler]','ReferenceElementLink'),(62,NULL,'Security','QASElementLink'),(63,NULL,'Choice of session state management','DecisionElementLink'),(64,NULL,'Conceptual Level','ContextElementLink'),(65,NULL,'Cloud Computing Patterns [Fehling, Leymann, Retter, Schupeck, Arbitter]','ReferenceElementLink'),(66,NULL,'Cloud Migration [T. Höllwarth]','ReferenceElementLink'),(67,NULL,'Elasticity','QASElementLink'),(68,NULL,'Robustness','QASElementLink'),(69,'http://martinfowler.com/articles/richardsonMaturityModel.html','Richardson Maturity Model [Fowler]','ReferenceElementLink'),(70,NULL,'Enterprise Integration Patterns [Hope, Woolf]','ReferenceElementLink'),(71,NULL,'Choice of Interface','DecisionElementLink'),(72,NULL,'Choice of Protocol','DecisionElementLink'),(73,NULL,'Simplicity','QASElementLink'),(74,NULL,'Choice of data source/store','DecisionElementLink'),(75,NULL,'Choice of messaging system','DecisionElementLink'),(76,NULL,'Technology Level','ContextElementLink'),(77,NULL,'Productivity','QASElementLink'),(78,'http://www8.cs.umu.se/kurser/5DV095/HT09/literature/restvsbig.pdf','RESTful Web Services vs. “Big” Web Services','ReferenceElementLink');
/*!40000 ALTER TABLE `ModelElementLink` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `ArVersion_ModelElementLink` WRITE;
/*!40000 ALTER TABLE `ArVersion_ModelElementLink` DISABLE KEYS */;
INSERT INTO `ArVersion_ModelElementLink` VALUES (13,50,0),(13,1,1),(13,38,2),(13,34,3),(13,37,4),(13,35,5),(13,40,6),(13,41,7),(13,51,8),(13,49,9),(12,1,0),(12,48,1),(12,24,2),(12,33,3),(12,49,4),(19,61,0),(18,12,0),(18,62,1),(18,5,2),(18,64,3),(18,63,4),(18,34,5),(18,61,6),(15,60,0),(15,11,1),(15,10,2),(15,33,3),(15,25,4),(15,45,5),(16,60,0),(16,11,1),(16,10,2),(16,33,3),(16,25,4),(16,45,5),(20,68,0),(20,14,1),(20,73,2),(20,47,3),(20,77,4),(20,7,5),(20,76,6),(20,34,7),(20,37,8),(20,71,9),(20,72,10),(20,65,11),(20,69,12),(20,70,13),(20,78,14),(21,11,0),(21,12,1),(21,4,2),(21,34,3),(21,37,4),(21,36,5),(21,21,6),(21,74,7),(21,71,8),(21,75,9);
/*!40000 ALTER TABLE `ArVersion_ModelElementLink` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `ArVersion_Smell` WRITE;
/*!40000 ALTER TABLE `ArVersion_Smell` DISABLE KEYS */;
INSERT INTO `ArVersion_Smell` VALUES (13,18,0),(12,18,0),(12,19,1),(18,25,0),(18,26,1),(16,23,0),(16,22,1),(16,29,2),(16,25,3),(20,27,0),(20,24,1),(21,24,0),(21,28,1);
/*!40000 ALTER TABLE `ArVersion_Smell` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `ArVersion_TaskTemplate` WRITE;
/*!40000 ALTER TABLE `ArVersion_TaskTemplate` DISABLE KEYS */;
INSERT INTO `ArVersion_TaskTemplate` VALUES (13,12,0),(12,5,0),(18,17,0),(18,20,1),(18,21,2),(18,22,3),(15,3,0),(15,2,1),(16,3,0),(16,2,1),(20,23,0),(20,24,1);
/*!40000 ALTER TABLE `ArVersion_TaskTemplate` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `ExecTaskType` WRITE;
/*!40000 ALTER TABLE `ExecTaskType` DISABLE KEYS */;
INSERT INTO `ExecTaskType` VALUES (1,'','root',1,1),(2,'ZIO Task','Execution Task Type',1,1),(3,'','Analysis Task',0,2),(4,'','Measurement Task',0,3),(5,'','Design Task',0,2),(6,'','Decision Task',0,5),(7,'','Development Task',0,2),(8,'','Admin Task',0,2),(9,'','Systemmanagement Task',0,8),(10,'','ITIL Task',0,9),(11,'','Testing Task',0,2),(12,'','Integration Task',0,2),(13,'','Commercial Task',0,2),(14,'','Communication Task',0,2),(15,'','Hold Meeting (ZIO)',0,14),(17,'','New Execution Task Type',0,14),(18,'','Leadership Tasks',0,2),(19,'','EAM Tasks',0,2),(20,'See this article for templates: http://www.ifs.hsr.ch/fileadmin/user_upload/customers/ifs.hsr.ch/Home/projekte/ADMentor-WICSA2015ubmissionv11nc.pdf','Update TOGAF ADM Repo and ADs log',0,19);
/*!40000 ALTER TABLE `ExecTaskType` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Menuitem` WRITE;
/*!40000 ALTER TABLE `Menuitem` DISABLE KEYS */;
INSERT INTO `Menuitem` VALUES (1,'Root','','root',0,'','','','root','',1),(3,'AR Browser','','root.arbrowser',10,'left','','Architectural Refactoring Browser','include','',1),(4,'Smell Browser','','root.smellbrowser',15,'left','','','include','',1),(5,'Task Browser','','root.taskbrowser',25,'left','','','include','',1),(6,'Smell Self-Assessment','','root.smellassess',30,'left','','Refactoring Qualification','include','',1),(7,'Admin','','root.admin',40,'left','Admin,Editor','','dropdown','',1),(9,'Execution Task Types','','root.exectypes',10,'left','Admin,Editor','Edit Execution Task Types','include','',7),(10,'AR Meta Data','','root.modelelement',15,'left','Admin,Editor','','include','',7),(11,'Smell Groups','','root.smellgroup',20,'left','Admin,Editor','','include','',7),(12,'About','','root.about',45,'left','','','include','',1),(13,'Profile','','root.profile',50,'right','','','include','',1),(14,'Login','','root.login',55,'right','','','login-logout','',1);
/*!40000 ALTER TABLE `Menuitem` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Property` WRITE;
/*!40000 ALTER TABLE `Property` DISABLE KEYS */;
INSERT INTO `Property` VALUES (1,'group5','OtherCategorie','desc','Group 5',5),(2,'group5','OtherCategorie','desc','Group 5',5);
/*!40000 ALTER TABLE `Property` ENABLE KEYS */;
UNLOCK TABLES;
