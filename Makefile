BIN = ./bin
SRC = ./src
OBJ = ./obj


compilar:
	@javac $(SRC)/*.java -d $(OBJ)/
	@cd obj/ ; jar cvmf MANIFEST.MF Servidor.jar AhorcadoServidor.class Procesador.class >> /dev/null ; jar cvmf MANIFEST2.MF Cliente.jar AhorcadoCliente.class >> /dev/null; mv Servidor.jar ../bin/; mv Cliente.jar ../bin/

servidor:
	@java -jar $(BIN)/Servidor.jar

cliente:
	@java -jar $(BIN)/Cliente.jar

clean:
	@rm $(OBJ)/*.class	
	@rm $(BIN)/*.jar