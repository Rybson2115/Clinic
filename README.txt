How to add patient?
localhost:8080/patient -> POST

"name": "{name}",
"surname": "{surname}",
"address": "{address}"

How to get patients? 
localhost:8080/patient -> GET

How to edit patient?
localhost:8080/patient -> PUT

"id": id,
"name": "{name}",
"surname": "{surname}",
"address": "{address}"

How to delete patient?
localhost:8080/patient/{id} -> DELETE

#######################################

How to add doctor?
localhost:8080/doctor -> POST

"name": "{name}",
"surname": "{surname}",
"specialization": {0-4}

How to get doctors? 
localhost:8080/doctor -> GET

How to edit doctor?
localhost:8080/doctor -> PUT

"id": id,
"name": "{name}",
"surname": "{surname}",
"specialization": {0-4}

How to delete doctor?
localhost:8080/doctor/{id} -> DELETE

#######################################

How to add visit?
localhost:8080/visit -> POST

"room": {room},
        "patient": {
            
		"id": id,
		"name": "{name}",
		"surname": "{surname}",
		"address": "{address}"

        },
        "doctor": {
         	 "id": id,
		"name": "{name}",
		"surname": "{surname}",
		"specialization": {0-4}
        },
        "date": "{date}",
        "time": "{time}"

How to get visit? 
localhost:8080/visit -> GET

How to edit visit?
localhost:8080/visit -> PUT
"id": id,
"room": {room},
        "patient": {
            
		"id": id,
		"name": "{name}",
		"surname": "{surname}",
		"address": "{address}"

        },
        "doctor": {
         	 "id": id,
		"name": "{name}",
		"surname": "{surname}",
		"specialization": {0-4}
        },
        "date": "{date}",
        "time": "{time}"

How to delete visit?
localhost:8080/visit/{id} -> DELETE

How to find patient visits?
localhost:8080/visit/find/patient/{id} -> GET


How to find doctor visit?
localhost:8080/visit/find/doctor/{id} -> GET

