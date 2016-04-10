all: banco cuenta titular bancowebservice bancoClient

# Compilaciones
banco:
	javac bancowebservice/Banco.java

cuenta:
	javac bancowebservice/Cuenta.java

titular:
	javac bancowebservice/Titular.java

bancowebservice:
	jar cvf bancowebservice.jar bancowebservice/*.class

bancoClient:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient.java

bancoClient2:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient2.java

# Activación servicios
axis:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./axis-1_4/./axis-1_4/mail.jar:./axis-1_4/./axis-1_4/activation.jar:./axis-1_4/./axis-1_4/bancowebservice.jar:./ org.apache.axis.transport.http.SimpleAxisServer -p 8888

deploy:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./mail.jar:./activation.jar org.apache.axis.client.AdminClient -p 8888 ./axis-1_4/webapps/axis/deploy.wsdd

bancoWsdl:
	java -cp ./axis-1_4/lib/axis-ant.jar:./axis-1_4/lib/commons-logging-1.0.4.jar:./axis-1_4/lib/axis.jar:./axis-1_4/lib/jaxrpc.jar:./axis-1_4/lib/saaj.jar:./axis-1_4/lib/commons-discovery-0.2.jar:./axis-1_4/lib/log4j-1.2.8.jar:./axis-1_4/lib/wsdl4j-1.5.1.jar:./mail.jar:./activation.jar org.apache.axis.wsdl.WSDL2Java "http://localhost:8888/axis/services/Banco?wsdl"

# Ejecuciones
crear:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient crear 968745877 JuanPedro 4587568N

crear2:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient crear 658521587 JuanPedro 4587568N

crear3:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient crear 021458874 Paco 6987521M

cerrarOk:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient cerrar 968745877

cerrarError:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient cerrar 965875877

ingresar:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient ingresar 968745877 50

retirar:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient retirar 968745877 30

getCuentas:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient cuentas 4587568N

getTitular:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient titular 968745877

bancoClient2Exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ BancoClient2


# Limpieza
clean:
	rm -rf *.class
	rm -rf bancowebservice/*.class
