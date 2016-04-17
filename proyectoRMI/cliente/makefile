.PHONY: clean

all: cliente

# Compilación local
cliente:
	javac ClienteCentralita.java

# Activación servicios
exeCliente:
	java -Djava.security.policy=cliente.permisos ClienteCentralita localhost 54321

# Limpieza
clean:
	rm -rf ../*/*.class
