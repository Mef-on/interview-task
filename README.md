# Aplikacja interview-task

Projekt napisany w Java 11.

# Opis aplikacji :\

Serwis pierwszy wystawiony jest na: `http://localhost:8080/generate/json/{size}`

size - ilość obiektów do wygenerowania.

Serwis drugi wystawiony jest na dwóch endpointach: 

1`http://localhost:6060/basicDataOfClient/`
   używa requestParams: size. Zwraca wartości dla domyślnych kluczy: type, _id, name, type, latitude, longitude.
   Przykład: `http://localhost:6060/basicDataOfClient?size=3`

2`http://localhost:6060/optionalDataOfClient/`
  i używa dwóch requestParams: size i params - ciąg kluczy odseparowanych ", " np.:
  `http://localhost:6060/optionalDataOfClient/?size=10&params=fullName, name,_id`


  Endpointy zwracają dane w formacie CSV.
```
Mica Hudson, Mica, 7846696103810826476, 0.0504281213016623
Rosalva Jacobi, Rosalva, 5712534966929259100, 0.14071406817807086
Roxanne Willms, Roxanne, 3426074220761756438, 0.2689067639371714
```
# Swagger
serwis 1. http://localhost:8080/swagger-ui/#/
serwis 2. http://localhost:8081/swagger-ui/#/

*porty są poprawne dla aplikacji uruchomionej z poziomu  Dockera*

# Docker
Instrukcja stawiania kontenerów dla serwisu 1. i 2. 
na portach 8080 i 8081.

serwis 1.
poziom:
``
~/interview-task/service1
``

``
$ docker build -f Dockerfile -t service1:1.0 .
$ docker run -p 8081:6060 -d --name service2 service2:1.0
``
serwis 2.
poziom:
``
~/interview-task/service2
``
``
$ docker build -f Dockerfile -t service2:1.0 .
$ docker run -p 8081:6060 -d --name service2 service2:1.0
``




