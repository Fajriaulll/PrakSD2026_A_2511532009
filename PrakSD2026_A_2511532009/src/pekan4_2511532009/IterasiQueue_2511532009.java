package pekan4_2511532009;
import java.util.*;
public class IterasiQueue_2511532009 {

	public static void main(String[] args) {
		Queue<String> q_2009 = new LinkedList<> ();
		
		q_2009.add("Praktikum");
		q_2009.add("Struktur");
		q_2009.add("Data");
		q_2009.add("Dan");
		q_2009.add("Algoritma");
		Iterator<String> iterator_2009 = q_2009.iterator();
		while (iterator_2009.hasNext()) {
			System.out.print(iterator_2009.next() + " ");
		}
		

	}

}
