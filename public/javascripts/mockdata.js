var user = 
    {    
        "id":1,
        "firstname":"Christian",
        "surname":"Bisig",
        "organisation":"HSR",
        "email":"cbisig@hsr.ch",
        "role_id":1,
        "startpage":"profile",
        "loggedin": true,
        "avatar": 'images/avatars/avatar1.png'
    };

var smellgroups = 
    [
        {   
            "id":1, 
            "name": "Performance", 
            "questions": 
            [
                {   
                    "id":1,
                    "question":"Does your application lack in performance?",
                    "smell_id":2
                },
                {   
                    "id":2,
                    "question":"Does your application have slow response times?",  
                    "smell_id":4
                }
            ]
        },
        {   
            "id":1,
            "name": "Complexity",
            "questions": 
            [
                {   
                    "id":3,
                    "question":"Does your application has to complex code?",
                    "smell_id":5
                },
                {   
                    "id":4,
                    "question":"Does your application has to many dependencies?",
                    "smell_id":6
                }
            ]
        }
    ];

var ars = 
    [
        { 
            "name":"AR1", 
            "desc":"blabladesc 1", 
            "smells": 
            [
                {
                    "id":1,
                    "name":"Smell1"
                },
                {
                    "id":5,
                    "name":"Smell5"
                }
            ]
        },
        {
            "name":"AR2",
            "desc":"Holderadio 2",
            "smells":
            [
                {
                    "id":2,
                    "name":"Smell2"
                },
                {
                    "id":5,
                    "name":"Smell5"
                }
            ]
        },
        {
            "name":"AR3",
            "desc":"Auto Velo 3",
            "smells":
            [
                {
                    "id":2,
                    "name":"Smell2"
                },
                {
                    "id":7,
                    "name":"Smell7"
                }
            ]
        },
        {
            "name":"AR4",
            "desc":"blabladesc 1",
            "smells":
            [
                {
                    "id":2,
                    "name":"Smell2"
                },
                {
                    "id":6,
                    "name":"Smell6"
                }
            ]
        },
        {
            "name":"AR5",
            "desc":"Holderadio 2",
            "smells":
            [
                {
                    "id":1,
                    "name":"Smell1"
                },
                {
                    "id":5,
                    "name":"Smell5"
                }
            ]
        },
        {
            "name":"AR6",
            "desc":"Auto Velo 3",
            "smells":
            [
                {
                    "id":3,
                    "name":"Smell3"
                },
                {
                    "id":5,
                    "name":"Smell5"
                }
            ]
        },
        {
            "name":"AR7",
            "desc":"blabladesc 1",
            "smells":
            [
                {
                    "id":3,
                    "name":"Smell3"
                },
                {
                    "id":4,
                    "name":"Smell4"
                }
            ]
        },
        {
            "name":"AR8",
            "desc":"Holderadio 2",
            "smells":
            [
                {
                    "id":4,
                    "name":"Smell4"
                },
                {
                    "id":7,
                    "name":"Smell7"
                }
            ]
        },
        {
            "name":"AR9",
            "desc":"Auto Velo 3",
            "smells":
            [
                {
                    "id":1,
                    "name":"Smell1"
                },
                {
                    "id":5,
                    "name":"Smell5"
                }
            ]
        }
    ];
