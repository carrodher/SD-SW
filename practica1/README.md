# Práctica 1

## RPC
Cada programa RPC consta de 4 componentes:
- El fichero RPC: ___.x
- Librería: ___.h
- El lado del cliente: ___.c
- El lado del servidor: ___.c

Generados con `rcpgen -N -c ___.x` a partir del ___.x, aunque se pueden personalizar otros diferentes.
En estas prácticas hay más archivos de los 4 que se indican aquí, esto es porque se han realizado clientes y servidores personalizados para conseguir diferentes funcionalidades.

Ejemplo: `gcc -W -Wall _clnt/svc.c cliente/servidor.c _xdr.c -o nombre_ejecutable_cliente/servidor`

### CalcularRPC
Realiza una suma remota mediante RPC.

### CalcularRPCarg
Realiza una suma remota mediante RPC de los valores pasados como argumentos.

### CalcularRPCcomp
Realiza una suma o una resta remota mediante RPC en función de los parámetros pasados como argumentos.

### CalcularRPCoper
Realiza una suma, resta o multiplicación remota mediante RPC en función de los parámetros pasados como argumentos.