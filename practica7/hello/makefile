.PHONY: clean

all: hello

# Compilaciones distribuidas
hello: idl comp nombr

# Compilación interfaz IDL
idl:
	idlj -f all Hello.idl

# Compilación ficheros java
comp:
	javac *.java

nombr:
	orbd -ORBInitialPort 1080

# Ejecución servidor
exeServidor:
	java HelloServer -ORBInitialPort 1080

# Ejecución cliente
exeCliente:
	java HelloClient -ORBInitialPort 1080 -ORBInitialHost localhost

# Limpieza
clean:
	rm -rf ./HelloApp/*.class
	rm -rf ./*.class
