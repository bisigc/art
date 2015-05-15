INSERT INTO Property(categorie,attribute,name,description,orderidx)
VALUES  ('OtherCategorie','group5','Group 5','desc',5),
        ('OtherCategorie','group5','Group 5','desc',5);
        
INSERT INTO SmellGroup(name,description)
VALUES  ('Performance','desc'),
        ('Complexity','desc'),
        ('Dependency','desc'),
        ('Security','desc'),
        ('Standards','desc');
        
INSERT INTO Smell(id, name,description,keywords,weight,group_id,tecdebtidx,status,modified,created)
VALUES (1, 'Smell1','This is Smell1','keyword1,keyword2,keyword3',2,1,'lm','published',Current_timestamp,Current_timestamp),
       (2, 'Smell2','This is Smell2','keyword2,keyword4,keyword5',2,2,'lm','published',Current_timestamp,Current_timestamp),
       (3, 'Smell3','This is Smell3','keyword1,keyword2,keyword3',3,1,'lm','published',Current_timestamp,Current_timestamp),
       (4, 'Smell4','This is Smell4','keyword5,keyword6,keyword7',1,2,'lm','published',Current_timestamp,Current_timestamp),
       (5, 'Smell5','This is Smell5','keyword5,keyword6,keyword7',5,2,'lm','published',Current_timestamp,Current_timestamp),
       (6, 'Smell6','This is Smell6','keyword5,keyword6,keyword7',6,2,'lm','published',Current_timestamp,Current_timestamp),
       (7, 'Smell7','This is Smell7','keyword5,keyword6,keyword7',1,1,'lm','published',Current_timestamp,Current_timestamp),
       (8, 'Smell8','This is Smell8','keyword5,keyword6,keyword7',1,1,'lm','published',Current_timestamp,Current_timestamp),
       (9, 'Smell9','This is Smell9','keyword5,keyword6,keyword7',1,2,'lm','published',Current_timestamp,Current_timestamp),
       (10, 'Smell10','This is Smell10','keyword5,keyword6,keyword7',1,2,'lm','published',Current_timestamp,Current_timestamp),
       (11, 'Smell11','This is Smell11','keyword5,keyword6,keyword7',1,3,'lm','published',Current_timestamp,Current_timestamp),
       (12, 'Smell12','This is Smell12','keyword5,keyword6,keyword7',1,4,'lm','published',Current_timestamp,Current_timestamp),
       (13, 'Smell13','This is Smell13','keyword5,keyword6,keyword7',1,5,'lm','published',Current_timestamp,Current_timestamp),
       (14, 'Smell14','This is Smell14','keyword5,keyword6,keyword7',1,1,'lm','published',Current_timestamp,Current_timestamp),
       (15, 'Smell15','This is Smell15','keyword5,keyword6,keyword7',1,1,'lm','published',Current_timestamp,Current_timestamp),
       (16, 'Smell16','This is Smell16','keyword5,keyword6,keyword7',1,3,'lm','published',Current_timestamp,Current_timestamp),
       (17, 'Smell17','This is Smell17','keyword5,keyword6,keyword7',1,5,'lm','published',Current_timestamp,Current_timestamp);

INSERT INTO Question(question,smell_id)
VALUES ("Question1",1),
       ("Question2",1),
       ("Question3",6),
       ("Question4",8),
       ("Question5",5),
       ("Question6",3),
       ("Question7",2),
       ("Question8",10),
       ("Question9",14),
       ("Question10",15),
       ("Question11",17),
       ("Question12",2),
       ("Question13",4),
       ("Question14",11),
       ("Question15",13),
       ("Question16",12),
       ("Question17",9),
       ("Question18",10),
       ("Question19",9),
       ("Question20",17),
       ("Question21",16),
       ("Question22",15),
       ("Question23",1),
       ("Question24",12),
       ("Question25",3),
       ("Question26",4);

INSERT INTO Menuitem
        (id, name,            fullname,                tooltip,                               image,                        type,           url,   pos,     ordering, menuitem_id)
VALUES  (1,  'root',          'Root',                  '',                                    '',                           'root',         '',    '',      0,        1),
        (2,  'home',          'home',                  '',                                    'images/art_logo_small.png',  'home',         '',    'left',  5,        1),
        (3,  'arbrowser',     'AR Browser',            'Architectural Refactoring Browser',   '',                           'include',      '',    'left',  10,       1),
        (4,  'smellbrowser',  'Smell Browser',         '',                                    '',                           'include',      '',    'left',  15,       1),
        (5,  'taskbrowser',   'Task Browser',          '',                                    '',                           'include',      '',    'left',  25,       1),
        (6,  'smellassess',   'Smell Self-Assessment', 'Refactoring Qualification',           '',                           'include',      '',    'left',  30,       1),
        (7,  'admin',         'Admin',                 '',                                    '',                           'dropdown',     '',    'left',  40,       1),
        (8,  'users',         'Users',                 '',                                    '',                           'include',      '',    'left',  5,        7),
        (9,  'exectypes',     'Execution Task Types',  'Edit Execution Task Types',           '',                           'include',      '',    'left',  10,       7),
        (10, 'armeta',        'AR Meta Info',          'Architectural Refactoring Meta Info', '',                           'include',      '',    'left',  15,       7),
        (11, 'other',         'Other',                 '',                                    '',                           'include',      '',    'left',  20,       7),
        (12, 'about',         'About',                 '',                                    '',                           'include',      '',    'left',  45,       1),
        (13, 'profile',       'Profile',               '',                                    '',                           'include',      '',    'right', 50,       1),
        (15, 'login',         'Login',                 '',                                    '',                           'login-logout', '',    'right', 55,       1);


INSERT INTO Role
       (id, name, description)
VALUES (1, 'Admin',   'ART Administrator'),
       (2, 'Editor',  'Architecture Expert entering architectural refactorings into the ART.'),
       (3, 'Applier', 'Searchs for architectural refactorings base on smells.'),
       (4, 'nonLogin', 'Non Login User with only read rights.');
       
INSERT INTO Permission
       (id, function, httpMethod)
VALUES (1,  'smell','POST'),
       (2,  'smell','PUT'),
       (3,  'smell','DELETE'),
       (4,  'smellgroup','POST'),
       (5,  'smellgroup','PUT'),
       (6,  'smellgroup','DELETE'),
       (7,  'property','POST'),
       (8,  'property','PUT'),
       (9,  'property','DELETE'),
       (10, 'menu','POST'),
       (11, 'menu','PUT'),
       (12, 'menu','DELETE'),
       (13, 'user','POST'),
       (14, 'user','PUT'),
       (15, 'user','DELETE'),
       (16, 'changepw','PUT'),
       (17, 'exectasktype','POST'),
       (18, 'exectasktype','PUT'),
       (19, 'exectasktype','DELETE'),
       (20, 'discussion','POST'),
       (21, 'discussion','PUT'),
       (22, 'discussion','DELETE'),
       (23, 'comment','POST'),
       (24, 'comment','PUT'),
       (25, 'comment','DELETE'),
       (26, 'like','PUT'),
       (27, 'avatar', 'POST'),
       (28, 'usersearch', 'GET'),
       (29, 'usersearch', 'POST'),
       (30, 'usersearch', 'DELETE');
       
INSERT INTO Role_Permission
       (role_id, permissions_id)
VALUES (1,1),
       (1,2),
       (1,3),
       (1,4),
       (1,5),
       (1,6),
       (1,7),
       (1,8),
       (1,9),
       (1,10),
       (1,11),
       (1,12),
       (1,13),
       (1,14),
       (1,15),
       (1,16),
       (1,17),
       (1,18),
       (1,19),
       (1,20),
       (1,21),
       (1,22),
       (1,23),
       (1,24),
       (1,25),
       (1,26),
       (1,27),
       (1,28),
       (1,29),
       (1,30),
       (2,1),
       (2,2),
       (2,14),
       (2,16),
       (2,17),
       (2,18),
       (2,19),       
       (2,23),       
       (2,24),       
       (2,25),       
       (2,26),
       (2,27),
       (2,28),
       (2,29),
       (2,30),
       (3,23),       
       (3,24),       
       (3,25),
       (3,26),       
       (3,27),       
       (3,28),       
       (3,29),       
       (3,30);       
       
INSERT INTO Digest
       (id, salt, scrypt)
VALUES (1, '6jXwcJwzde0gnHW77GSxww==', '7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),
       (2, '6jXwcJwzde0gnHW77GSxww==', '7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),
       (3, '6jXwcJwzde0gnHW77GSxww==', '7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),
       (4, '6jXwcJwzde0gnHW77GSxww==', '7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc=');

INSERT INTO User
       (id, firstname, lastname, email, organisation, startpage, homepage, role_id, modified, created)
VALUES (1, 'Christian', 'Bisig', 'cbisig@hsr.ch', 'HSR', 'stay', 'http://www.hsr.ch', 1, Current_timestamp, Current_timestamp),
       (2, 'Hans', 'Admin', 'admin@hsr.ch', 'HSR', 'stay', 'http://www.hsr.ch', 1, Current_timestamp, Current_timestamp),
       (3, 'Hugo', 'Editor', 'editor@hsr.ch', 'HSR', 'stay', 'http://www.hsr.ch', 2, Current_timestamp, Current_timestamp),
       (4, 'Rudolf', 'Applier', 'applier@hsr.ch', 'HSR', 'stay', 'http://www.hsr.ch', 3, Current_timestamp, Current_timestamp);
       
INSERT INTO ExecTaskType
       (id, description, name, ordering, parent_id)
VALUES (1,  '','root', 1, 1),	
       (2,  '','Execution Task Type', 1, 1),
	   (3,  '','Analysis Task',0,2),
       (4,  '','Measurement Task',0,3),
       (5,  '','Design Task',0,2),
       (6,  '','Decision Task',0,5),
       (7,  '','Development Task',0,2),
       (8,  '','Admin Task',0,2),
       (9,  '','Systemmanagement Task',0,8),
       (10, '','ITIL Task',0,9),
       (11, '','Testing Task',0,2),
       (12, '','Integration Task',0,2),
       (13, '','Commercial Task',0,2),
       (14, '','Communication Task',0,2),
       (15, '','Documentation Task',0,14);
       
INSERT INTO Ar
       (id)
VALUES (1),
       (2),
       (3),
       (4),       
       (5);       
       
INSERT INTO ArVersion
       (id, name, arhead_id, description, editor_id, status, modified, created)
VALUES (1, "AR 1", 1, "Architectural Refactoring 1", 1, "published", current_timestamp, '2015-05-07 13:00:00'),
       (2, "AR 1", 1, "Architectural Refactoring 1", 1, "published", current_timestamp, '2015-05-07 13:00:01'),
       (3, "AR 1", 1, "Architectural Refactoring 1", 1, "published", current_timestamp, '2015-05-07 13:00:02'),
       (4, "AR 2", 2, "Architectural Refactoring 2", 1, "published", current_timestamp, '2015-05-07 13:00:03'),
       (5, "AR 2", 2, "Architectural Refactoring 2", 1, "published", current_timestamp, '2015-05-07 13:00:04'),
       (6, "AR 2", 2, "Architectural Refactoring 2", 1, "published", current_timestamp, '2015-05-07 13:00:05'),
       (7, "AR 3", 3, "Architectural Refactoring 3", 1, "draft", current_timestamp, '2015-05-07 13:00:06'),
       (8, "AR 4", 4, "Architectural Refactoring 4", 1, "published", current_timestamp, '2015-05-07 13:00:07'),
       (9, "AR 4", 4, "Architectural Refactoring 4", 1, "accepted", current_timestamp, '2015-05-07 13:00:08'),
       (10, "AR 5", 5, "Architectural Refactoring 5", 1, "published", current_timestamp, '2015-05-07 13:00:10'),
       (11, "AR 5", 5, "Architectural Refactoring 5", 1, "deprecated", current_timestamp, '2015-05-07 13:00:11');
       
INSERT INTO ArVersion_Smell
       (ArVersion_id, smells_id)
VALUES (1,1),
       (1,2),
       (1,7),
       (2,3),
       (2,5),
       (2,11),
       (2,14),
       (3,11),
       (3,14),
       (4,2),
       (4,16),
       (5,12),
       (5,13),
       (6,15),
       (7,2),
       (7,3),
       (7,4),
       (8,1),
       (8,2),
       (9,3),
       (9,7),
       (10,8),
       (11,10);
       
INSERT INTO Discussion
       (id, type, ar_id, created)
VALUES (1, "DISCUSSION", 1, current_timestamp),
       (2, "DISCUSSION", 2, current_timestamp),
       (3, "DISCUSSION", 3, current_timestamp),
       (4, "DISCUSSION", 4, current_timestamp),
       (5, "DISCUSSION", 5, current_timestamp),
       (6, "DISCUSSION", 6, current_timestamp),
       (7, "DISCUSSION", 7, current_timestamp),
       (8, "DISCUSSION", 8, current_timestamp),
       (9, "DISCUSSION", 9, current_timestamp),
       (10, "DISCUSSION", 10, current_timestamp),
       (11, "DISCUSSION", 11, current_timestamp);
       
INSERT INTO Comment
       (id, comment, discussion_id, user_id, modified, created)
VALUES (1, "Comment 1", 1, 1, current_timestamp, current_timestamp),
       (2, "Comment 2", 2, 1, current_timestamp, current_timestamp),       
       (3, "Comment 3", 3, 1, current_timestamp, current_timestamp),       
       (4, "Comment 4", 4, 1, current_timestamp, current_timestamp),       
       (5, "Comment 5", 5, 1, current_timestamp, current_timestamp),       
       (6, "Comment 6", 6, 1, current_timestamp, current_timestamp),       
       (7, "Comment 7", 7, 1, current_timestamp, current_timestamp),       
       (8, "Comment 8", 8, 1, current_timestamp, current_timestamp),       
       (9, "Comment 9", 9, 1, current_timestamp, current_timestamp),       
       (10, "Comment 10", 10, 1, current_timestamp, current_timestamp),       
       (11, "Comment 11", 11, 1, current_timestamp, current_timestamp);
       
INSERT INTO TaskPropertyType
       (id, name)
VALUES (7,"Assignee"),
       (8,"Type"),
       (9,"Description"),
       (10,"Priority"),
       (11,"Due Date"),
       (12,"Estimated Duration");        
       