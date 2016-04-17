.PHONY: clean

all: obs

# Compilaciones distribuidas
obs: observador observadorImpl
	cp *.class ../cliente
	cp *.class ../centralita

observador:
	javac Observador.java

observadorImpl:
	javac ObservadorImpl.java

# Compilación local
cliente:
	javac ObservadorCentralita.java

# Activación servicios
exeObservador:
	java -Djava.security.policy=observador.permisos ObservadorCentralita localhost 54321 

# Limpieza
clean:
	rm -rf ../*/*.class
