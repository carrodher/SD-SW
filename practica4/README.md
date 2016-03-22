# Práctica 4
[![Build Status](https://travis-ci.org/carrodher/SDSW.svg?branch=master)](https://travis-ci.org/carrodher/SDSW)

## RMI
Cada programa RMI consta de, al menos, dos directorios con los siguientes componentes:
- Cliente:
  - Cliente.java
- Servidor:
  - Servicio.java
  - ServicioImpl.java
  - Servidor.java

En _Cliente.java_ y _Servidor.java_ se realiza la implementación del Cliente y Servidor del servicio en cuestión. En _Servicio.java_ se declara la interfaz y el método que realiza las acciones del servicio, y por último en _ServicioImpl.java_ se implementa dicho método o métodos.

Compilación:
```
cd Servidor
javac *.java  // Genera .class
cp Servicio.class ../Cliente
cd ../Cliente
javac *java   // Genera .class
```
Ejecución Servidor:
```
cd Servidor
rmiregistry 54321 &   // Arranca registro Java RMI puerto 54321
java -Djava.security.policy=servidor.permisos Servidor 54321 [Argumentos]
```
Ejecución Cliente (nueva terminal):
```
cd ../Cliente
java -Djava.security.policy=cliente.permisos Cliente [IPServidor] 54321 [Argumentos]
```
Finalizar:
```
ps              // Proceso rmiregistry
kill -9 _____   // Terminar dicho proceso
```

Se procede de igual manera en caso de que haya varios roles más, copiando el _.class_ pertinente en caso de que sea necesario para la compilación.

### chat
Cliente y servidor que hacen eco de los argumentos pasados usando RMI.

### alarmaTemp
Cliente, Servidor y varios Observadores.
- El servidor registra la suscripción y eliminación de los Observadores.
- El cliente incrementa cada segundo la temperatura en 1º. Por defecto comienza en 35º y acaba en 50º, aunque se puede modificar esto por línea de comandos.
- Los observadores reciben las actualizaciones de temperatura cuando se supera el umbral inferior (warning), modificando el color y la alerta en función de varios umbrales: WARNING +40º y DANGER +45º.
