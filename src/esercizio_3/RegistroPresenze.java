package esercizio_3;

import java.io.File;
import java.io.IOException;
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

		for (Entry<UUID, Presenza> p : presenze.entrySet()) {
			Application.logger.info(p.getKey() + "," + p.getValue().getNome() + "," + p.getValue().getGiorno());
			try {
				FileUtils.writeStringToFile(file,
						p.getKey() + "," + p.getValue().getNome() + "," + p.getValue().getGiorno(), "UTF-8", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void caricaDaDisco(File file) throws IOException {
		presenze.clear();
		List<String> readRecords = FileUtils.readLines(file, "UTF-8");
		for (String line : readRecords) {
			String[] record = line.split(",");
			UUID id = UUID.fromString(record[0]);
			String nome = record[1];
			int giorno = Integer.parseInt(record[2]);
			Presenza p = new Presenza(nome, giorno);
			presenze.put(id, p);
		}
	}

	public HashMap<UUID, Presenza> getPresenze() {
		return presenze;
	}
}
