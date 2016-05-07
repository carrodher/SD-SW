.PHONY: clean

all: calc

# Compilaciones distribuidas
calc: idl comp

# Compilación interfaz IDL
idl:
	idlj -f all Calculadora.idl

# Compilación ficheros java
comp:
	javac prueba/*.java

# Ejecución servidor
exeServidor:
	java prueba.Servidor | tee IOR

# Ejecución cliente
exeCliente:
	java prueba.Cliente

# Limpieza
clean:
	rm -rf ./prueba/*.class
