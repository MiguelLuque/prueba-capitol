# Prueba-capitol

Prueba técnica para capitol consulting

## Consideraciones de diseño

* Se ha cambiado el nombre de la propiedad precio a value ya que es un nombre rendundante, además no se han creado tablas relacionadas con Prices y sus relaciones pues considero que no aporta demasiado a la naturaleza de esta prueba.
* Se han controlado las excepciones básicas y se devuelve un error genérico, en el que no he profundizado más debido a que no lo he creido necesario al ser una prueba técnica corta.
* No se ha usado usado TDD para el desarrollo ya que lo he visto innecesario debido a la sencillez de la prueba.
* No se ha seguido un gitflow por el mismo motivo a pesar de ser una buena práctica y necesaria en cualquier proyecto y más si se trabaja en equipo.
* Considero que el uso de flyway es una buena práctica para poder seguir los cambios y migraciones en db pero para este caso por falta de tiempo lo he descartado
* Se han hecho dos endpoints con el mismo funcionamiento pero con diferente tipo de parámetro de entrada.
* No estaba claro el formato de la prueba ya que el txt no me parece muy claro en algunos aspectos pero he tomado el price_list como id de la tabla.
* He desarrollado un par de tests unitarios pero considero que no es necesario cumplir con toda la cobertura dado que es una prueba técnica.

## Testing en postman

Para facilitar las pruebas he añadido unos tests de postman ya montados y listos para ejecutar, tan solo habría que levantar el proyecto y una vez importada la colección de postman ejecutar los tests.

Los tests contienen los 6 casos planteados 
