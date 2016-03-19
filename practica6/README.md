# Práctica 6

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
javac *.java                // Genera .class
cp Cuenta.class ../Cliente
cp Banco.class ../Cliente
cp Titular.class ../Cliente
cd ../Cliente
javac *java                 // Genera .class
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

### banco
Implementación de un banco en el que el servidor hace el papel de banco, el cual tiene una fábrica de cuentas, que permite realizar diferentes operaciones.
Esta vez las cuentas son identificadas mediante la clase Titular.

### fabricaLogCompleta
Mejora del servicio de log implementado en prácticas anteriores, esta vez se ha introducido la opción de crear estos ficheros de log mediante la figura de una fábrica.
