.PHONY: clean

all: calc

# Compilaciones distribuidas
calc: idl comp

# Compilación interfaz IDL
idl:
	idlj -f all tiempo.idl

# Compilación ficheros java
comp:
	javac tiempoApp/*.java

# Ejecución servidor
exeServidor:
	java tiempoApp.Servidor | tee IOR

# Ejecución cliente
exeCliente:
	java tiempoApp.Cliente

# Limpieza
clean:
	rm -rf ./*/*.class
