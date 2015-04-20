INSERT INTO property(categorie,attribute,name,description,orderidx)
VALUES  ('OtherCategorie','group5','Group 5','desc',5),
        ('OtherCategorie','group5','Group 5','desc',5);
        
INSERT INTO smellgroup(name,description)
VALUES  ('Performance','desc'),
        ('Complexity','desc'),
        ('Dependency','desc'),
        ('Security','desc'),
        ('Standards','desc');
        
INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,status,modified,created)
VALUES ('Smell1','This is Smell1','keyword1,keyword2,keyword3',2.0,1,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell2','This is Smell2','keyword2,keyword4,keyword5',2.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell3','This is Smell3','keyword1,keyword2,keyword3',3.0,1,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell4','This is Smell4','keyword5,keyword6,keyword7',1.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell5','This is Smell5','keyword5,keyword6,keyword7',5.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell6','This is Smell6','keyword5,keyword6,keyword7',6.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell7','This is Smell7','keyword5,keyword6,keyword7',1.0,1,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell8','This is Smell8','keyword5,keyword6,keyword7',1.0,1,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell9','This is Smell9','keyword5,keyword6,keyword7',1.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell10','This is Smell10','keyword5,keyword6,keyword7',1.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell11','This is Smell11','keyword5,keyword6,keyword7',1.0,3,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell12','This is Smell12','keyword5,keyword6,keyword7',1.0,4,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell13','This is Smell13','keyword5,keyword6,keyword7',1.0,5,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell14','This is Smell14','keyword5,keyword6,keyword7',1.0,1,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell15','This is Smell15','keyword5,keyword6,keyword7',1.0,1,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell16','This is Smell16','keyword5,keyword6,keyword7',1.0,3,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell17','This is Smell17','keyword5,keyword6,keyword7',1.0,5,'lm','published',Current_timestamp,Current_timestamp);

INSERT INTO question(question,smell_id)
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

INSERT INTO menuitem
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


INSERT INTO role
       (id, name, description)
VALUES (1, 'Admin',   'ART Administrator'),
       (2, 'Editor',  'Architecture Expert entering architectural refactorings into the ART.'),
       (3, 'Applier', 'Searchs for architectural refactorings base on smells.'),
       (4, 'nonLogin', 'Non Login User with only read rights.');
       
       
INSERT INTO ExecTaskType
       (id, description, name, ordering, parent_id)
VALUES (1,  '', 'root', 1, 1),	
       (2,  '', 'Execution Task Type', 1, 1),
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
