# aplikacja interview-task

Serwis pierwszy wystawiony jest na: `http://localhost:8080/generate/json/{size}`

size - ilość obiektów do wygenerowania.

Serwis drugi wystawiony jest na dwóch endpointach: 

1`http://localhost:6060/graphql/basicDataOfClient/`
   używa requestParams: size. Zwraca wartości dla domyślnych kluczy: type, _id, name, type, latitude, longitude.
   Przykład: `http://localhost:6060/graphql/basicDataOfClient?size=3`

2`http://localhost:6060/graphql/optionalDataOfClient/`
  i używa dwóch requestParams: size i params - ciąg kluczy odseparowanych ", " np.:
  `http://localhost:6060/graphql/optionalDataOfClient/?size=10&params=fullName, name,_id`


  Endpointy zwracają dane w formacie CSV.
```
Mica Hudson, Mica, 7846696103810826476, 0.0504281213016623
Rosalva Jacobi, Rosalva, 5712534966929259100, 0.14071406817807086
Roxanne Willms, Roxanne, 3426074220761756438, 0.2689067639371714
```