package esercizio_3;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	public static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegistroPresenze registro = new RegistroPresenze();
		registro.aggiungiPresenza(new Presenza("Mario Rossi", 10));
		registro.aggiungiPresenza(new Presenza("Luigi Bianchi", 8));
		try {
			registro.salvaSuDisco(new File("presenze.txt"));
			registro.caricaDaDisco(new File("presenze.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

//		for (Presenza p : registro.getPresenze()) {
//			System.out.println(p.getNome() + ": " + p.getGiorni());
//		}
	}

}