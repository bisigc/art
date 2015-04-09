INSERT INTO property(categorie,attribute,name,description,orderidx)
VALUES  ('SmellGroups','group1','Group 1','desc',1),
        ('SmellGroups','group2','Group 2','desc',2),
        ('SmellGroups','group3','Group 3','desc',3),
        ('SmellGroups','group4','Group 4','desc',4),
        ('SmellGroups','group5','Group 5','desc',5),
        ('SmellGroups','group6','Group 6','desc',6),
        ('SmellGroups','group7','Group 7','desc',7),
        ('OtherCategorie','group5','Group 5','desc',5),
        ('OtherCategorie','group5','Group 5','desc',5);

INSERT INTO smell(name,description,keywords,weight,group_id,tecdebtidx,status,modified,created)
VALUES ('Smell1','This is Smell1','keyword1,keyword2,keyword3',2.0,1,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell2','This is Smell2','keyword2,keyword4,keyword5',2.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell3','This is Smell3','keyword1,keyword2,keyword3',3.0,1,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell4','This is Smell4','keyword5,keyword6,keyword7',1.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell5','This is Smell5','keyword5,keyword6,keyword7',5.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell6','This is Smell6','keyword5,keyword6,keyword7',6.0,2,'lm','published',Current_timestamp,Current_timestamp),
       ('Smell7','This is Smell7','keyword5,keyword6,keyword7',1.0,2,'lm','published',Current_timestamp,Current_timestamp);

INSERT INTO menuitem
        (id, name,            fullname,                tooltip,                               image,                        type,           url,   pos,     ordering, menuitem_id)
VALUES  (1,  'root',          'Root',                  '',                                    '',                           'root',         '',    '',      0,        1),
        (2,  'home',          'home',                  '',                                    'images/art_logo_small.png',  'home',         '',    'left',  5,        1),
        (3,  'ars',           'AR Browser',            'Architectural Refactoring Browser',   '',                           'include',      '',    'left',  10,       1),
        (4,  'smellbrowser',  'Smell Browser',         '',                                    '',                           'include',      '',    'left',  15,       1),
        (5,  'taskbrowser',   'Task Browser',          '',                                    '',                           'include',      '',    'left',  25,       1),
        (6,  'smellasses',    'Smell Self-Assessment', 'Refactoring Qualification',           '',                           'include',      '',    'left',  30,       1),
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
       (3, 'Applier', 'Searchs for architectural refactorings base on smells.');
       
       
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
