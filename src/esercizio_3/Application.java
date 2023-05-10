package esercizio_3;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	public static Logger logger = LoggerFactory.getLogger(Application.class);
	private static File file = new File("presenze.txt");

	public static void main(String[] args) {
		if (file.exists()) {
			try {
				FileUtils.delete(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		RegistroPresenze registro = new RegistroPresenze();
		Scanner input = new Scanner(System.in);
		String options[] = { "0 Per Uscire", "1 Aggiungi contatto", "2 Salva su disco", "3 Leggi da disco" };
		choice: while (true) {
			try {
				System.out.println("Seleziona una delle seguenti opzioni: ");
				System.out.println(Arrays.asList(options));
				int option = Math.abs(Integer.parseInt(input.nextLine()));
				switch (option) {
				case 0:
					input.close();
					break choice;
				case 1:
					System.out.print("Input name:");
					String name = input.nextLine();
					System.out.print("Input day:");
					int day = Math.abs(Integer.parseInt(input.nextLine()));
					registro.aggiungiPresenza(new Presenza(name, day));
					break;
				case 2:
					try {
						registro.salvaSuDisco(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						registro.caricaDaDisco(file);
						for (Entry<UUID, Presenza> p : registro.getPresenze().entrySet()) {
							Application.logger
									.info(p.getKey() + "," + p.getValue().getNome() + "," + p.getValue().getGiorno());
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("L'opzione inserita " + option + " non è valida!");
					break;
				}
			} catch (NumberFormatException e) {
				Application.logger.info("Devi inserire un numero intero positivo!!");
			}

		}
	}
}
