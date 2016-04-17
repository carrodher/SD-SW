.PHONY: clean

all: cent

# Compilaciones distribuidas
cent: centralita centralitaImpl
	cp *.class ../cliente
	cp *.class ../observador

centralita:
	javac ServicioCentralita.java

centralitaImpl:
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
