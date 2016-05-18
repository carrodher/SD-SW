.PHONY: clean parkingwebservice

all: parking coche propietario parkingwebservice parkingClient

# Compilaciones
parking:
	javac parkingwebservice/Parking.java

coche:
	javac parkingwebservice/Coche.java

propietario:
	javac parkingwebservice/Propietario.java

parkingwebservice:
	jar cvf parkingwebservice.jar parkingwebservice/*.class

parkingClient:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient.java

parkingClient2:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient2.java

# Activación servicios
axis:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./axis-1_4/./axis-1_4/mail.jar:./axis-1_4/./axis-1_4/activation.jar:./axis-1_4/./axis-1_4/parkingwebservice.jar:./ org.apache.axis.transport.http.SimpleAxisServer -p 8888

deploy:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./mail.jar:./activation.jar org.apache.axis.client.AdminClient -p 8888 ./axis-1_4/webapps/axis/deploy.wsdd

parkingWsdl:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./mail.jar:./activation.jar org.apache.axis.wsdl.WSDL2Java "http://localhost:8888/axis/services/Parking?wsdl"

# Ejecuciones
#crear:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient crear 968745877 JuanPedro 4587568N

#crear2:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient crear 658521587 JuanPedro 4587568N

#crear3:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient crear 021458874 Paco 6987521M

#cerrarOk:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient cerrar 968745877

#cerrarError:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient cerrar 965875877

#ingresar:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient ingresar 968745877 50

#retirar:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient retirar 968745877 30

#getCoches:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient coches 4587568N

#getPropietario:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient propietario 968745877

#parkingClient2Exe:
#	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ParkingClient2


# Limpieza
clean:
	rm -rf *.class
	rm -rf parkingwebservice/*.class
	rm -rf parkingwebservice.jar
