# Práctica 2

## RPC
Cada programa RPC consta de 4 componentes:
- El fichero RPC: ___.x
- Librería: ___.h
- El lado del cliente: ___.c
- El lado del servidor: ___.c

Generados con `rcpgen -N -c ___.x` a partir del ___.x, aunque se pueden personalizar otros diferentes.
En estas prácticas hay más archivos de los 4 que se indican aquí, esto es porque se han realizado clientes y servidores personalizados para conseguir diferentes funcionalidades.

Ejemplo: `gcc -W -Wall _clnt/svc.c cliente/servidor.c _xdr.c -o nombre_ejecutable_cliente/servidor`

### fscon
Servidor CON estado que escribe un texto en un fichero que previamente tiene que abrir y después cerrar.

### fssin
Servicio SIN estado que escribe un texto en un fichero, como no tiene estado, en cada operación tiene que abrir y cerrar el fichero.