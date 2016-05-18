.PHONY: clean parkingwebservice

all: parking coche propietario parkingwebservice

# Compilaciones
parking:
	javac parkingwebservice/Parking.java

coche:
	javac parkingwebservice/Coche.java

propietario:
	javac parkingwebservice/Propietario.java

parkingwebservice:
	jar cvf parkingwebservice.jar parkingwebservice/*.class

axis:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./axis-1_4/./axis-1_4/mail.jar:./axis-1_4/./axis-1_4/activation.jar:./axis-1_4/./axis-1_4/parkingwebservice.jar:./ org.apache.axis.transport.http.SimpleAxisServer -p 8888

## a) Custom Deployment (WSDD)
deploy:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./mail.jar:./activation.jar org.apache.axis.client.AdminClient -p 8888 ./axis-1_4/webapps/axis/deploy.wsdd

parkingClient:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient.java

añadir:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient añadir

eliminar:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient eliminar

aparcar:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient aparcar

salir:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient salir

getCoches:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient getCoches

getPropietario:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient getPropietario

## b) WSDL
parkingWsdl:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./mail.jar:./activation.jar org.apache.axis.wsdl.WSDL2Java "http://localhost:8888/axis/services/Parking?wsdl"

parkingClient2:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient2.java

parkingClient2Exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient2


# Limpieza
clean:
	rm -rf *.class
	rm -rf parkingwebservice/*.class
	rm -rf parkingwebservice.jar
