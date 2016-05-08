# Práctica 7
[![Build Status](https://travis-ci.org/carrodher/SDSW.svg?branch=master)](https://travis-ci.org/carrodher/SDSW)

Al compilar IDL `idlj -f all xxx.idl` se generan los siguientes ficheros:
- **xxxHelper.java** y **xxxHolder.java**

  Contienen métodos estáticos que pueden ser ejecutados sin necesidad de crear un objeto de esa clase. En la clase Helper existe un método llamado **narrow** y que se va a usar a menudo. Este método sirve para convertir una referencia a un objeto genérico CORBA a un objeto de un cierto tipo. Las referencias genéricas a objetos Java son convertidas en referencias de un cierto tipo habitualmente mediante la utilización de un molde o cast. Sin embargo, una referencia a un objeto genérico CORBA no se puede convertir a una referencia a objeto de un tipo concreto usando un molde, siendo necesario usar el método narrow.
- **xxx.java** y **xxxOperations.java**

  Interfaces con las operaciones del servicio.
- **xxxPOA.java**

  Contiene la clase de la que va a derivar la clase de la implementación. Es el adaptador de objeto para el servidor. El adaptador de objetos es el que recibe la petición y la dirige al método adecuado de la implementación, realizando las operaciones oportunas (sería lo que hemos llamado hasta ahora soporte del servidor).
- **xxxStub.java**

  Contiene el soporte del cliente.

## Calculadora
```shell
make all            # Compila IDL y *.class
make exeServidor
make exeCliente
```

## Hello
```shell
make all            # Compila IDL, *.class y ejecuta servicio de nombrado
make exeServidor
make exeCliente
```

## Tiempo
### v1
En esta versión se ha quitado todo lo relativo a `struct tiempo` puesto que esto crea un package que no encuentra el compilador.

```shell
make all            # Compila IDL y *.class
make exeServidor
make exeCliente
```

### v2
En esta versión se incluye la estructura `struct tiempo`, de esta manera se crea un paquete `TiempoPackage` en el que se encuentran los 3 ficheros para su uso.
Al compilar todo lo que hay dentro de `TiempoApp` (que es únicamente los ficheros generados por IDL) da errores al no encontrar el package creado.
Además, si añadimos los ficheros `Cliente.java`, `Servidor.java` y `TiempoImpl.java` aumentan los errores al no encontrar dicho package.

```shell
make idl            # Compila IDL
make comp           # Compila *.java
make exeServidor
make exeCliente
```

### v3
En esta versión se incluye la estructura `struct tiempo`, de esta manera se crea un paquete `TiempoPackage` en el que se encuentran los 3 ficheros para su uso; sacando los ficheros de este package y poniéndolos en la misma carpeta que el resto de ficheros y cambiando en el código todo lo relativo a dicho package se puede conseguir que compile sin errores; pero no se llega a ejecutar.

```shell
# Compilación IDL ya hecha, si no habría que volver a modificar el código
make comp           # Compila *.java
make exeServidor
make exeCliente
```
