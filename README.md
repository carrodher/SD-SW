![C](https://img.shields.io/badge/C-11-yellow.svg)
[![License](https://img.shields.io/badge/license-CreativeCommons | NC-green.svg)](http://es.creativecommons.org/blog/licencias/) 
[![Linkedin](https://img.shields.io/badge/LinkedIn-Carlos-blue.svg)](https://es.linkedin.com/in/carlosrodriguezhernandez)
[![Twitter](https://img.shields.io/badge/Twitter-carrodher-blue.svg)](https://twitter.com/carrodher)

# SD-SW
Prácticas de la asignatura "Sistemas Distribuidos y Servicios Web"

### Conceptos
Cada programa RPC necesita 4 componentes:
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
Servidores con y sin estado

