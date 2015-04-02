# --- !Ups
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('SmellGroups','group1','Group 1','desc',1);
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('SmellGroups','group2','Group 2','desc',2);
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('SmellGroups','group3','Group 3','desc',3);
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('SmellGroups','group4','Group 4','desc',4);
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('SmellGroups','group5','Group 5','desc',5);
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('SmellGroups','group6','Group 6','desc',6);
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('SmellGroups','group7','Group 7','desc',7);
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('OtherCategorie','group5','Group 5','desc',5);
INSERT INTO property(categorie,key,name,description,orderidx) VALUES ('OtherCategorie','group5','Group 5','desc',5);

INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,modified,created)
VALUES ('Smell1','This is Smell1','keyword1,keyword2,keyword3',2.0,1,'lm',Current_timestamp,Current_timestamp);

INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,modified,created)
VALUES ('Smell2','This is Smell2','keyword2,keyword4,keyword5',2.0,2,'lm',Current_timestamp,Current_timestamp);

INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,modified,created)
VALUES ('Smell3','This is Smell3','keyword1,keyword2,keyword3',3.0,1,'lm',Current_timestamp,Current_timestamp);

INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,modified,created)
VALUES ('Smell4','This is Smell4','keyword5,keyword6,keyword7',1.0,2,'lm',Current_timestamp,Current_timestamp);

INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,modified,created)
VALUES ('Smell5','This is Smell5','keyword5,keyword6,keyword7',5.0,2,'lm',Current_timestamp,Current_timestamp);

INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,modified,created)
VALUES ('Smell6','This is Smell6','keyword5,keyword6,keyword7',6.0,2,'lm',Current_timestamp,Current_timestamp);

INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,modified,created)
VALUES ('Smell7','This is Smell7','keyword5,keyword6,keyword7',1.0,2,'lm',Current_timestamp,Current_timestamp);
