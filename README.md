# Practica 3
## Version `0.0.1-SNAPSHOT`
## Descripción
Es una aplicación en Java, que se ejectua sobre el puerto 8081,
la cual tiene por objetivo brindar servicios REST de clientes,
seguros, companias, siniestros y peritos.
Fue desarrollada en Spring Boot con Spring Tools 4.

1. Se usa el schema SEGUNI
2. Posee Querys DSL
3. Tiene servicios paginados
4. Genera token JWT

# Requisitos del entorno
Para que la aplicación funcione se necesita:
1. Java(TM) SE Runtime Environment (build 17.0.5+9-LTS-191)
2. Maven 3.8.6
3. Oracle XE 22.2.1.234 Build 234.1810

## En sistemas operativos tipo Unix
```sh
apt install openjdk-17-jdk openjdk-17-jre maven
```

## En Windows
Se descargan las dependencias, se instalan y se agregan al PATH.

# Configurar aplicación
Antes de compilar se modifica el archivo `application.properties`.

### Si desea cambiar el puerto:

    server.port=8081

### Si desea crear la base de datos en automatico:

    spring.jpa.hibernate.ddl-auto=update

# Compilar
```
./mvnw package
```

Generandose un JAR en la carpeta `target`, que se puede ejecutar con:
```sh
java -jar practicatres-0.0.1-SNAPSHOT.jar
```

Para detener la ejecucion del programa:

Se oprime <kbd>ctrl</kbd>+<kbd>c</kbd> en la consola.

