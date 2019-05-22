package co.com.aplication.AplicacionActivosFijos.conection.interfaz;

import java.io.IOException;

public interface ConetionInterfaz {
	
	void conectar() throws IOException;
	void desconectar() throws IOException;

}
