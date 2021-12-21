package day1;

import java.io.*;
import java.nio.file.*;

public class DepthComparator {

	public DepthComparator() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws IOException {
		Path data = Paths.get("./src/day1/data_input.txt");
		System.out.println(data);
		int count = 0;
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(Files.newInputStream(data)))) {
			
			int antecedant = in.readInt();
			System.out.println(antecedant);
			
			int current = in.readInt();
			System.out.println(current);
			
			if (current - antecedant > 0) {
				count++;
			}
			
			while (true) {
				antecedant = current;
				current = in.readInt();
				if (current - antecedant > 0) {
					count++;
					//System.out.println(count);
				}
			}
			
		} catch (java.io.EOFException e) {
			System.err.println("FIN DE FICHIER");
			System.out.println(count);
		} catch (IOException e) {
			System.err.println("Un problème dans l'écriture de " + data);
		}
	}

}
