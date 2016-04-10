.PHONY: newswebservice agendawebservice clean

all: periodico_comp noticia_comp newswebservice agenda_comp telefono_comp agendawebservice

holamundo_comp:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar HolaMundoClient.java

axis:
	java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.transport.http.SimpleAxisServer -p 8888

holamundo_exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ HolaMundoClient -p 8888

tcpmon:
	java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.utils.tcpmon 9999 localhost 8888

holamundoMon_exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ HolaMundoClient -p 9999

conversor_comp:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar ConversorClient.java

conversor_exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ ConversorClient hola -p 9999

periodico_comp:
	javac newswebservice/Periodico.java

noticia_comp:
	javac newswebservice/Noticia.java

periodicoclient_comp:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient.java

newswebservice:
	jar cvf newswebservice.jar newswebservice/*.class

axis_news:
	java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar:../../newswebservice.jar:./ org.apache.axis.transport.http.SimpleAxisServer -p 8888

deploy_news:
	java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.client.AdminClient -p 8888 axis/deploy.wsdd

periodicoinsert_exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient insert Titular1 desc URL

periodicoquery_exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient query Titular1

periodico2_comp:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient2.java

periodico_wsdl:
	java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.wsdl.WSDL2Java "http://localhost:8888/axis/services/Periodico?wsdl"

periodicoclient2_exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ PeriodicoClient2

agenda_comp:
	javac agendawebservice/Agenda.java

telefono_comp:
	javac agendawebservice/Telefono.java

agendaclient_comp:
	javac -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ AgendaClient.java

agendawebservice:
	jar cvf agendawebservice.jar agendawebservice/*.class

axis_agenda:
	java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar:../../agendawebservice.jar:./ org.apache.axis.transport.http.SimpleAxisServer -p 8888

deploy_agenda:
	java -cp ../lib/axis-ant.jar:../lib/commons-logging-1.0.4.jar:../lib/axis.jar:../lib/jaxrpc.jar:../lib/saaj.jar:../lib/commons-discovery-0.2.jar:../lib/log4j-1.2.8.jar:../lib/wsdl4j-1.5.1.jar:../../mail.jar:../../activation.jar org.apache.axis.client.AdminClient -p 8888 axis/deploy.wsdd

agendainsert_exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ AgendaClient insert JuanPedro casa 924723536

agendaquery_exe:
	java -cp axis-1_4/lib/axis-ant.jar:axis-1_4/lib/commons-logging-1.0.4.jar:axis-1_4/lib/axis.jar:axis-1_4/lib/jaxrpc.jar:axis-1_4/lib/saaj.jar:axis-1_4/lib/commons-discovery-0.2.jar:axis-1_4/lib/log4j-1.2.8.jar:axis-1_4/lib/wsdl4j-1.5.1.jar:mail.jar:activation.jar:./ AgendaClient query JuanPedro
