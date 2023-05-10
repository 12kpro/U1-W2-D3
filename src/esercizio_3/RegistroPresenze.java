package esercizio_3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {

	private HashMap<UUID, Presenza> presenze;

	public RegistroPresenze() {
		presenze = new HashMap<UUID, Presenza>();
	}

	public void aggiungiPresenza(Presenza p) {
		presenze.put(UUID.randomUUID(), p);
	}

	public void salvaSuDisco(File file) throws IOException {
		List<String> stringRecords = new ArrayList<String>();
		for (Entry<UUID, Presenza> p : presenze.entrySet()) {
			Application.logger.info(p.getKey() + " = " + p.getValue());
			stringRecords.add(p.getKey() + " = " + p.getValue());
		}
		try {
			FileUtils.writeLines(file, stringRecords);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void caricaDaDisco(File file) throws IOException {
		List<String> readRecords = FileUtils.readLines(file, "UTF-8");
		for (String line : readRecords) {
//			String[] parts = line.split(",");
//			String nome = parts[0];
//			int giorni = Integer.parseInt(parts[1]);
//			Presenza p = new Presenza(nome, giorni);
//			getPresenze().add(p);
			Application.logger.info("Totale: " + line);
		}
	}

	public HashMap<UUID, Presenza> getPresenze() {
		return presenze;
	}
}
