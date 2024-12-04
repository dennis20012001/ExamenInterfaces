package socketsObjects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	private static ServerSocket server;
	private static int port = 9876;

	public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {

		server = new ServerSocket(port);
		Socket socket = new Socket();
		ObjectInputStream entrada;
		ObjectOutputStream salida;

		while (true) {
			socket = server.accept();

			entrada = new ObjectInputStream(socket.getInputStream());

			String message = (String) entrada.readObject();
			salida = new ObjectOutputStream(socket.getOutputStream());

			Persona p = new Persona();
			p.setNif("16078123X");
			p.setNombre("Pepito");
			p.setApellido("Grillo");

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String dateInString = "01-01-1990";
			Date date = formatter.parse(dateInString);
			p.setFechaNacimiento(date);
			p.setGenero('M');
			
			salida.writeObject("Nif: " + p.getNif() + 
					" ,Nombre: " + p.getNombre() + ",Apellido: " + p.getApellido()
					+ " ,Fecha Nacimiento: " + p.getFechaNacimiento() + " ,Genero: " + p.getGenero());

			entrada.close();
			salida.close();

			if (message.equalsIgnoreCase("exit")) {
				break;
			}
		}
		socket.close();
		server.close();
	}
}
