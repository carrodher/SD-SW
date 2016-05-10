.PHONY: clean

all: idl comp

# Compilación interfaz IDL
idl:
	idlj -f all tiempo.idl

# Compilación ficheros java
comp:
	javac TiempoApp/*.java

# Ejecución servidor
exeServidor:
	java TiempoApp.Servidor | tee IOR

# Ejecución cliente
exeCliente:
	java TiempoApp.Cliente

# Limpieza
clean:
	rm -rf ./TiempoApp/*.class
