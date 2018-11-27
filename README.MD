### Polls Application

##### To add a new question:
curl -X POST "http://localhost:8080/questions" -H "accept: */*" -H "Content-Type: application/json" -d '{ "question": "Favourite programming language?", "published_at": "2018-11-23T01:05:37.869", "choices": [ { "choice": "Swift", "votes": 44 }, { "choice": "Python", "votes": 1048 } ]}'

##### To find all questions:
curl -X GET http://localhost:8080/questions
