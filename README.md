## 1. Ejecuta el Script SQL

1. Ejecuta el script SQL proporcionado en el archivo `SQL_Script_CalvoPablo.sql`. Este script creará la base de datos y la tabla necesaria.

   ```bash
   mysql -u tu_usuario -p < SQL_Script_CalvoPablo.sql
   ```

   Reemplaza `tu_usuario` con tu nombre de usuario de MySQL. Se te pedirá ingresar la contraseña correspondiente.

## 2. Modifica las Credenciales en `DatabaseEnvironmentData.java`

1. Abre el archivo `DatabaseEnvironmentData.java` ubicado en `src/com/database`.

2. Busca las siguientes líneas de código:

   ```java
	String url = "jdbc:mysql://localhost:3306/productosdb";
	String usuario = "tu_usuario";
	String contraseña = "tu_contraseña";
   ```

3. Cambia `"tu_usuario"` y `"tu_contraseña"` por tus propias credenciales de MySQL.

## 3. Ejecutar la Aplicación

Ahora que has configurado la base de datos y modificado las credenciales en `DatabaseEnvironmentData.java`, puedes ejecutar la aplicación.

¡Listo! La aplicación debería estar configurada para funcionar con tu base de datos local.

[Enlace al Repositorio](https://github.com/PabloCalvo03/DWES2324_Practica2_PabloCalvo)

## 5. Si la Aplicación da fallos

1. Cierra las instancias de Tomcat, limpia el proyecto y vuelve a ejecutar.

2. Verifica que la base de datos se ha creado bien.