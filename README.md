# Project PA API

Este proyecto es una API RESTful construida con Java, SQL, Spring Boot y Maven. Este documento describe cómo interactuar con la API utilizando las solicitudes HTTP proporcionadas en la colección Postman.

El proyecto ya tiene datos precargados en la base de datos H2, por lo que no es necesario cargar datos adicionales, lo puedes hacer para probar los endponints.

## Requisitos

- Java 11
- Maven
- Base de datos en memoria H2
- Postman
- Git
- IDE (IntelliJ IDEA, Eclipse, etc.)
- Lombok Plugin
- Spring Boot Plugin

## Configuración

1. Clona el repositorio:

```bash
git clone 
```

1. Importa el proyecto en tu IDE.
2. Ejecuta el proyecto.
3. Importa la colección de Postman en tu aplicación Postman.
4. Ejecuta las solicitudes de la colección.
5. ¡Listo!


## Autenticación

La API utiliza autenticación de tipo Bearer. Debes obtener un token de autenticación válido a través del endpoint de login y luego incluirlo en el encabezado `Authorization` de tus solicitudes.

### LOGIN

- Método: POST
- URL: http://localhost:8080/auth/login
- Body:

```json
{
    "username": "<username>",
    "password": "<password>"
}
```

### SIGNUP

- Método: POST
- URL: http://localhost:8080/auth/signup
- Body:

```json
{
    "username": "<username>",
    "password": "<password>",
    "first_name": "<first_name>",
    "last_name": "<last_name>",
    "email": "<email>",
    "phone": "<phone>",
    "address": "<address>"
}
```

### Productos

- Método: POST
- URL: http://localhost:8080/products/create
- Body:
```json
    {
    "name": "<product_name>",
    "description": "<product_description>",
    "price": "<product_price>",
    "category": "<category_id>"

}
```

### Obtener Producto por ID

- Método: GET
- URL: http://localhost:8080/products/product?id=<product_id>

### Obtener Productos por Categoría

- Método: GET
- URL: http://localhost:8080/products/products-category?category=<category_name>


### Obtener Todos los Productos

- Método: GET
- URL: http://localhost:8080/products/products