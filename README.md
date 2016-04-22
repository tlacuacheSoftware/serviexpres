# Readme

Area de trabajo de Rodrigo

Para crear la base de datos esta un archivo tlacuachesoft.sql esta la creacion de tablas y agregacion de datosa .

## Instrucciones de creación de la base de datos

En una terminal ejecutar el siguiente comando

```sh
createdb tlacuachesoft
```

Esto crea una base de datos llamada tlacuachesoft que es donde va estar toda la información de la aplicación.
Después hay que ejecutar el siguiente comando:

```sh
psql tlacuachesoft -f tlacuachesoft.sql
```

El cuál va a cargar los DDL de las tablas, así como insertar nuevos registros en las tablas.

## Instrucciones de ejecución de la aplicación

### Dependencias

* Primefaces 5
* Hibernate
