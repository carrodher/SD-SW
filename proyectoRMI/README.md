# Proyecto RMI
[![Build Status](https://travis-ci.org/carrodher/SDSW.svg?branch=master)](https://travis-ci.org/carrodher/SDSW)

## Índice
1. [Motivación](#motivación)
2. [Introducción](#introducción)
3. [Implementación](#implementación)
4. [Compilación y ejecución](#compilación-y-ejecución)
5. [Funcionamiento](#funcionamiento)
6. [Relación con la asignatura](#relación-con-la-asignatura)
7. [Autores](#autores)

## Motivación
En este primer trabajo de la asignatura se pide realizar un proyecto basado en RMI usando los conceptos de sistemas distribuidos que se han dado a lo largo de las primeras 6 prácticas.

## Introducción
Se pretende diseñar un sistema de alertas de emergencias centralizado (estilo 112) en el que se disponga de un servicio de centralita al que llegan los diferentes mensajes de los clientes. A esta centralita estánconectados, como observadores, los diferentes Servicios de Emergencia (bomberos, sanitarios, guardia civil, policía local, policía nacional, etc), de manera que cuando la centralita recibe un mensaje con alguna incidencia, determina a qué servicio o servicios redirigir esta incidencia. En paralelo, la centralita incorpora un servicio de log para dejar constancia de todos los eventos procesados.

![alt tag](https://github.com/carrodher/SDSW/blob/master/proyectoRMI/Documentos/EsquemaInicial.png "Esquema inicial")

## Implementación
Este proyecto consta de 3 partes diferenciadas:

1. **Clientes**

    Los clientes son la parte más numerosa en cuanto a cantidad de dispositivos, puesto que simulan a los usuarios habituales en la vida real, por tanto puede ser una cifra muy elevada.

    Su funcionamiento consiste en mandar un mensaje de texto a la centralita en el que se dan detalles de la situación que requiere la presencia de los Servicios de Emergencia, así como alguna información extra como la dirección del suceso, un número de teléfono, etc.

    En la ejecución del programa el usuario mantendrá una conversación guiada con la centralita, la cual va registrando las respuestas dadas por el usuario. Una vez que finalice la entrada de texto y envíe el mensaje, esperará hasta recibir confirmación sobre los Servicios de Emergencia avisados.

2. **Centralita**

    La centralita es un único elemento que hace la función de servidor, controlador, distribuidor y registro de log.

    Su funcionamiento es el siguiente:
    * Recibe un mensaje por parte de algún cliente.
    * Extrae los diferentes campos de ese mensaje (texto, teléfono, dirección, fecha-hora, etc).
    * Mediante expresiones regulares trata el campo "mensaje" para determinar a qué Servicio o Servicios de Emergencia redirigir la alerta. Por ejmplo, si detecta que en el campo texto se hace uso de las palabras _fuego_, _incendio_, _humo_, etc; la centralita determinará que esa alerta debe dirigirla hacia los bomberos.
    * Una vez que sabe a qué Servicio de Emergencia avisar, forma el mensaje de salida y lo manda hacia el servicio en cuestión. De igual manera avisa al usuario con los Servicios que han sido alertados.

    A parte de avisar a los diferentes Servicios de Emergencia, la centralita también realiza un control interno tanto de los mensajes recibidos como de los mensajes enviados haciendo uso de servicios de log y mostrando por pantalla toda esta información.

3. **Observadores**

    Por último, los observadores son los diferentes Servicios de Emergencia que están suscritos a las notificaciones de la centralita, en este caso está restringido a 4 actores (Policía, Bomberos, Sanitarios y Guardia Civil).

    El funcionamiento de los observadores se inicia con la petición de añadirse a la lista de la centralita, una vez adscritos esperan la recepción de un mensaje con los datos sobre alguna alerta. Este mensaje se muestra por pantalla para que los profesionales del servicio en cuestión puedan actuar.

![alt tag](https://github.com/carrodher/SDSW/blob/master/proyectoRMI/Documentos/EsquemaLlamadas.png "Esquema llamadas")

## Compilación y ejecución
Compilación limpia, los diferentes _makefiles_ copian los ficheros _.class_ necesarios de un directorio a otro:
```bash
bash ./compila.sh
```
Para ejecutarlo se abren diferentes terminales.

Terminal 1 (centralita):
```bash
cd centralita
rmiregistry 54321 &
make exeCentralita
```
Terminal 2 (observador):
```bash
cd observador
make exeObservador
```
Terminal 3 (cliente):
```bash
cd cliente
make exeCliente
```
NOTA: Para ejecutarlo en diferentes equipos hay que cambiar en los _makefiles_ la IP en la orden de ejcución. Sustituir _localhost_ por las IPs deseadas.

## Funcionamiento
Ejecución del cliente por parte de un usuario. Preguntas de la centralita y respuestas del usuario. Como se puede ver, el mensaje hace referencia a un incendio con heridos, por tanto la centralita determina que hay que avisar a Bomberos y Sanitarios:

![alt tag](https://github.com/carrodher/SDSW/blob/master/proyectoRMI/Documentos/Cliente.png "Cliente")

Registro de 4 observadores (cada uno identificado por su nombre y código de color):

![alt tag](https://github.com/carrodher/SDSW/blob/master/proyectoRMI/Documentos/Observadores.png "Observadores")

Ejecución de la centralita en la que se ve el registro/baja de los observadores y cuando se hace _match_:

![alt tag](https://github.com/carrodher/SDSW/blob/master/proyectoRMI/Documentos/Centralita.png "Centralita")

Alerta en los observadores avisados (Bomberos y Sanitarios) y no en el resto:

![alt tag](https://github.com/carrodher/SDSW/blob/master/proyectoRMI/Documentos/ObservadoresAlertas.png "ObservadoresAlertas")

## Relación con la asignatura
Como se puede observar, en este proyecto se va a hacer uso de casi todos los elementos vistos en las prácticas, utilizando conceptos de todas ellas, tales como aspectos relacionados con el servicio de chat, la fábrica de logs, el servicio de alarmas, las marcas de tiempo, etc.

## Autores
Ana Lucero Fernández [@analucfer](https://github.com/analucfer "Ana")

Carlos Rodríguez Hernández [@carrodher](https://github.com/carrodher "Carlos")
