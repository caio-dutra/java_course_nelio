package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		
		String path = "/home/caio_ubuntu/Music/votes.csv";
		
		Map<String, Integer> votes = new LinkedHashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);

				if (votes.containsKey(name)) {
					int votesSoFar = votes.get(name);
					votes.put(name, count + votesSoFar);
				}
				else {
					votes.put(name, count);
				}
				
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}

		for (String key : votes.keySet()) {
			System.out.println(key + ": " + votes.get(key));
		}
	}
}
