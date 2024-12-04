package socketsObjects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	public static void main(String[] args)
			throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException, ParseException {

		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream salida = null;
		ObjectInputStream entrada = null;

		for (int i = 1; i < 2; i++) {

			socket = new Socket(host.getHostName(), 9876);

			salida = new ObjectOutputStream(socket.getOutputStream());
			
			Persona p = new Persona();
			p.setNombre("Carmen");
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String dateInString = "01-01-1983";
			Date date = formatter.parse(dateInString);
			p.setFechaNacimiento(date);

			if (i == 2) {
				salida.writeObject("exit");
			} else
				System.out.println("Nif: " + p.getNif() + " ,Nombre: " + p.getNombre() + ",Apellido: " + p.getApellido()
					+ " ,Fecha Nacimiento: " + p.getFechaNacimiento() + " ,Genero: " + p.getGenero());

			entrada = new ObjectInputStream(socket.getInputStream());

			String message = (String) entrada.readObject();
			System.out.println("Cliente: " + message);

			entrada.close();
			entrada.close();
			socket.close();
			Thread.sleep(100);
		}

	}

}
