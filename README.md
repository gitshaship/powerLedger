# PowerLedger

How to run

dependencies - Java 11 or higher, mvn 3.x
steps:-
1. clone the project
2. Run "mvn clean install" command to build the project, run tests and generate execuatable jar file
3. Run "java -jar target/powerLedger-0.0.1.jar" to start the application

API list

1. Post battery list

  curl --location --request POST 'http://localhost:8082/battery-list' \
  --header 'Content-Type: application/json' \
  --data-raw '[
    {
      "name": "Cannington",
      "postcode": "6107",
      "capacity": 13500
    },
    {
      "name": "Midland",
      "postcode": "6057",
      "capacity": 50500
    }
  ]'


2. Get battery list for given post code range

 curl --location --request GET 'http://localhost:8082/battery-list/statistics?StartCode=6000&EndCode=6200'

