# Proyecto Servicios Web
[![Build Status](https://travis-ci.org/carrodher/SDSW.svg?branch=master)](https://travis-ci.org/carrodher/SDSW)

## Compilación/Ejecución
```shell
# 1 General
## 1.1 Limpia lo anterior y compila todas las clases
make clean
make all
## 1.2 Ejecuta axis (Nueva terminal (Siempre abierta))
make axis

# 2 Método WSDD
## 2.1 Ejecuta Deploy
make deploy
## 2.2 Compila Cliente
make parkingClient
## 2.3 Ejecuta métodos
make añadir				# Añade un coche a la BBDD de coches
make eliminar			# Elimina un coche de la BBDD de coches
make aparcar			# Entra coche en el párking en función de la matrícula
make salir				# Sale coche del párking en función de la matrícula
make getCoches			# Obtiene los coches asociados a un DNI
make getPropietario		# Obtiene el propietario de un coche en base a la matrícula

# 3 Método WSDL
## 3.1 Ejecuta WSDL
make parkingWsdl
## 3.2 Compila Cliente
make parkingClient2
## 3.3 Ejecuta cliente
make parkingClient2Exe
```

## Autores
Ana Lucero Fernández [@analucfer](https://github.com/analucfer "Ana")

Carlos Rodríguez Hernández [@carrodher](https://github.com/carrodher "Carlos")
