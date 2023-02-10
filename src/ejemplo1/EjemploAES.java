package ejemplo1;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EjemploAES {

	public static void main(String[] args) {
		try {
			System.out.println("Obteniendo generador de claves con cifrado AES");
			KeyGenerator keygen = KeyGenerator.getInstance("AES");

			System.out.println("Generando la clave");
			SecretKey key = keygen.generateKey();

			System.out.println("Obteniendo objeto Cipher con cifrado AES");
			Cipher aesCipher = Cipher.getInstance("AES");

			System.out.println("Configurando Cipher para encriptar");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);

			String mensaje = "Mensaje que se cifrará con AES";
			System.out.println("mensaje original: " + mensaje);

			String mensajeCifrado = new String(aesCipher.doFinal(mensaje.getBytes()));
			System.out.println("Mensaje cifrado: " + mensajeCifrado);
			System.out.println("Configurando Cipher para desencriptar");

			aesCipher.init(Cipher.DECRYPT_MODE, key);
			String mensajeDescifrado = new String(aesCipher.doFinal(mensajeCifrado.getBytes()));
			System.out.println("Mensaje descifrado: " + mensajeDescifrado);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
