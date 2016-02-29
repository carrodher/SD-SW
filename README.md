[![License](https://img.shields.io/badge/license-CC | By+NC-green.svg)](http://es.creativecommons.org/blog/licencias/) 
[![Linkedin](https://img.shields.io/badge/LinkedIn-Carlos-blue.svg)](https://es.linkedin.com/in/carlosrodriguezhernandez)
[![Twitter](https://img.shields.io/badge/Twitter-carrodher-blue.svg)](https://twitter.com/carrodher)

# SD-SW
Prácticas de la asignatura "Sistemas Distribuidos y Servicios Web"

## Contenido
- [RPC](#rpc)
  - [Práctica 1](#práctica-1)
  - [Práctica 2](#práctica-2)
- [RMI](#rmi)
 - [Práctica 3](#práctica-3)

### RPC
Cada programa RPC consta de 4 componentes:
- El fichero RPC: ___.x
- Librería: ___.h
- El lado del cliente: ___.c
- El lado del servidor: ___.c

Generados con `rcpgen -N -c ___.x` a partir del ___.x, aunque se pueden personalizar otros diferentes.
En estas prácticas hay más archivos de los 4 que se indican aquí, esto es porque se han realizado clientes y servidores personalizados para conseguir diferentes funcionalidades.

Ejemplo: `gcc -W -Wall _clnt/svc.c cliente/servidor.c _xdr.c -o nombre_ejecutable_cliente/servidor`

#### Práctica 1
Llamadas a Procedimiento Remoto

#### Práctica 2
Servidores con y sin estado mediante RPC

### RMI
Cada programa RMI consta de dos directorios con los siguientes componentes:
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

#### Práctica 3
Invocación de métodos remotos
