.PHONY: clean

all: cent

# Compilaciones distribuidas
cent: central centralImpl
	cp *.class ../cliente
	cp *.class ../observador

central:
	javac ServicioCentralita.java

centralImpl:
	javac ServicioCentralitaImpl.java

# Compilación local
centralita:
	javac Servidor.java

# Activación servicios
exeCentralita:
	java -Djava.security.policy=servidor.permisos Servidor 54321

# Limpieza
clean:
	rm -rf ../*/*.class
