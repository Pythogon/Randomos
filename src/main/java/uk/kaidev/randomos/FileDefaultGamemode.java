package uk.kaidev.randomos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileDefaultGamemode {
	public static String readDefaultGamemode() throws IOException {
		String path = Randomos.folder + "/defaultGamemode.txt";
		List<String> content = Files.readAllLines(Paths.get(path));
		String gm = "";
		for (String temp : content) {
			gm += temp;
		}
		return gm;
	}
	
	public static void writeDefaultGamemode(String gm) throws IOException {
		String path = Randomos.folder + "/defaultGamemode.txt";
		FileWriter writer = new FileWriter(path);
		writer.write(gm);
		writer.close();
		return;
	}
}
