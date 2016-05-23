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
make getRegistrados		# Obtiene los coches registrados
make getAparcados		# Obtiene los coches aparcados

# 3 Método WSDL
## 3.1 Ejecuta WSDL
make parkingWsdl
## 3.2 Compila Cliente
make parkingClient2
## 3.3 Ejecuta cliente
make parkingClient2Exe
```

## Guión presentación
```shell
############ WSDD ############
## 1 Limpia lo anterior y compila todas las clases
make clean
make all

## 2 Ejecuta axis (Nueva terminal (Siempre abierta))
make axis

## 3 Ejecuta Deploy
make deploy

## 4 Compila Cliente
make parkingClient

# 1.- Añadir 2 propietarios/coches diferentes
make añadir # Ana (Abonado)
make añadir # Carlos (No abonado)

# 2.- Consultar los registrados y aparcados
make getRegistrados
make getAparcados

# 3.- Aparcar los dos coches
make aparcar
make aparcar

# 4.- Consultar los aparcados
make getAparcados

# 5.- Sacar los dos coches y ver diferencia
make salir
make salir

# 6.- Añadir nuevo coche a mismo propietario
make añadir

# 7.- Consultar los registrados
make getRegistrados

# 8.- Consultar coches asociados a DNI
make getCoches

# 9.- Consular propietario de un coche
make getPropietario

# 10.- Eliminar y ver que se elimina
make eliminar
make getRegistrados

# Cualquier operación de las anteriores hacerla mal también para ver excepción

############ WSDL ############
## 1 Ejecuta WSDL
make parkingWsdl

## 2 Compila Cliente
make parkingClient2

# 1.- Ejecuta cliente
make parkingClient2Exe
```

## Autores
Ana Lucero Fernández [@analucfer](https://github.com/analucfer "Ana")

Carlos Rodríguez Hernández [@carrodher](https://github.com/carrodher "Carlos")
