.PHONY: clean

all: obs

# Compilaciones distribuidas
obs: obs obsImpl
	cp *.class ../cliente
	cp *.class ../centralita

obsr:
	javac Observador.java

obsImpl:
	javac ObservadorImpl.java

# Compilación local
observador:
	javac ObservadorCentralita.java

# Activación servicios
exeObservador:
	java -Djava.security.policy=observador.permisos ObservadorCentralita localhost 54321

# Limpieza
clean:
	rm -rf ../*/*.class
