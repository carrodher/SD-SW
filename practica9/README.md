# Práctica 9
[![Build Status](https://travis-ci.org/carrodher/SDSW.svg?branch=master)](https://travis-ci.org/carrodher/SDSW)

## Servicios web

El objetivo de esta práctica es desarrollar un ejemplo básico de servicio Web, así como
conocer algunas de las tecnologías implicadas en el desarrollo de servicios Web (SOAP, WSDL
y UDDI). También se construye un cliente de servicio Web remoto conocida la interfaz WSDL
de dicho servicio Web. Para la realización de la práctica se utiliza un software basado en Java de
libre distribución: Axis, de la Apache Software Foundation.

## Compilación y Ejecución
#### Compila HolaMundoClient.java
```
javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar HolaMundoClient.java
```

#### Para ejecutar el SimpleAxisServer en el directorio axis-1_4/webapps:
```
java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.transport.http.SimpleAxisServer -p 8888
```

#### Ejecuta HolaMundoClient
```
java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ HolaMundoClient -p 8888
```

#### Para ejecutar el tcpmonitor en el directorio axis-1_4/webapps:
```
java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.utils.tcpmon 9999 localhost 8888
```

#### Ejecuta HolaMundoClient en el puerto 9999 para probar con monitor
```
java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ HolaMundoClient -p 9999
```

#### Compila ConversorClient.java
```
javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar ConversorClient.java
```

#### Ejecuta ConversorClient en el puerto 9999 para probar con monitor
```
java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ConversorClient hola -p 9999
```

#### Compila Periodico
```
javac newswebservice/Periodico.java
```

#### Compila PeriodicoClient
```
javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient.java
```

#### Crea newswebservice.jar con Periodico y Noticia
```
jar cvf newswebservice.jar newswebservice/*.class
```

#### Para ejecutar el SimpleAxisServer en el directorio axis-1_4/webapps para el ejemplo news:
```
java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar:../../newswebservice.jar:./ org.apache.axis.transport.http.SimpleAxisServer -p 8888
```

#### Para desplegar el servidor del ejemplo news en el directorio axis-1_4/webapps:
```
java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.client.AdminClient -p 8888 axis/deploy.wsdd
```
Salida:
```
Processing file axis/deploy.wsdd
<Admin>Done processing</Admin>
```

#### Ejecuta PeriodicoClient para insert
```
java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient insert Titular1 desc URL
```

#### Ejecuta PeriodicoClient para query
```
java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient query Titular1
```

#### Compila Periodico 2 con clases generadas a partir del wsdl
```
javac -cp
axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient2.java
```

#### Para generar el wsdl de Periodico desde el directorio axis-1_4/webapps:
```
java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.wsdl.WSDL2Java "http://localhost:8888/axis/services/Periodico?wsdl"
```

#### Copiar las carpetas generadas dentro de axis en el directorio de la práctica (en mi caso Es y lenovo son las carpetas) Ejecuta Periodico 2 con clases generadas a partir del wsdl
```
java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient2
```

#### Compila Agenda
```
javac agendawebservice/Agenda.java
```

#### Compila Telefono
```
javac agendawebservice/Telefono.java
```

#### Compila AgendaClient
```
javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ AgendaClient.java
```

#### Crea agendawebservice.jar con Agenda y Telefono
```
jar cvf agendawebservice.jar agendawebservice/*.class
```

#### Para ejecutar el SimpleAxisServer en el directorio axis-1_4/webapps para el ejemplo agenda:
```
java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar:../../agendawebservice.jar:./ org.apache.axis.transport.http.SimpleAxisServer -p 8888
```

#### Para desplegar el servidor del ejemplo agenda en el directorio axis-1_4/webapps:
```
java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.client.AdminClient -p 8888 axis/deploy.wsdd
```
Salida:
```
Processing file axis/deploy.wsdd
<Admin>Done processing</Admin>
```

#### Ejecuta AgendaClient para insert
```
java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ AgendaClient insert JuanPedro casa 924723536
```

#### Ejecuta AgendaClient para query
```
java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ AgendaClient query JuanPedro
```
