## 1. Ejecuta el Script SQL

1. Ejecuta el script SQL proporcionado en el archivo `SQL_Script_CalvoPablo.sql`. Este script creará la base de datos y las tablas necesarias, ademas de datos inventados.

   ```bash
   mysql -u tu_usuario -p < SQL_Script_CalvoPablo.sql
   ```

   Reemplaza `tu_usuario` con tu nombre de usuario de MySQL. Se te pedirá ingresar la contraseña correspondiente.

## 2. Descarga un servidor Apache Tomcat (version 10 en adelante)

1. Descarga el servidor desde Eclipse

2. Agregar Servlet API al Build Path

3. Añade las librerias que se encuentran en la carpeta lib al build path.

## 3. Modifica las Credenciales en `config.properties`

1. Abre el archivo `config.properties` ubicado en `src/main/webapp/WEB-INF/classes/config.properties`.

2. Busca las siguientes líneas de código:

   ```
   	bbdd.jdbc=jdbc:mysql://localhost:3306/productosdb
	bbdd.user=tu_usuario
	bbdd.pass=tu_usuario
   ```

3. Cambia `"tu_usuario"` y `"tu_contraseña"` por tus propias credenciales de MySQL.

## 4. Ejecutar la Aplicación

Ahora que has configurado la base de datos, descargado Apache Tomcat y modificado las credenciales en `config.properties`, puedes ejecutar la aplicación.

¡Listo! La aplicación debería estar configurada para funcionar con tu base de datos local.

[Enlace al Repositorio](https://github.com/PabloCalvo03/DWES2324_Practica3_PabloCalvo)

## 5. Si la Aplicación da fallos

1. Cierra las instancias de Tomcat, limpia el proyecto y vuelve a ejecutar.

2. Verifica que la base de datos se ha creado bien.

# 6. Fallo muy importante que puede dar

1. La aplicacion puede estar configurada para una version de java y que luego no funcione si tratas de ejecutarla teniendo otra version de java. Para arreglarlo debes acceder a Properties (del proyecto) -> Project Facets y cambiar la version de java a la que tengas tu instalada.
