package pekan4_2511532009;
import java.util.*;
public class ReverseData_2511532009 {

	public static void main(String[] args) {
		Queue<Integer> q_2009 = new LinkedList <Integer>();
		q_2009.add(1);
		q_2009.add(2);
		q_2009.add(3); // [1, 2, 3]
		System.out.println("Sebeleum reverse" + q_2009);
		Stack<Integer> s_2009 = new Stack<Integer>();
		while (!q_2009.isEmpty()) { // Q -> S
			s_2009.push(q_2009.remove());
	}
		while (!s_2009.isEmpty()) { // S -> Q
			q_2009.add(s_2009.pop());
		}
		System.out.println("Sesudah reverse = " + q_2009);// [3, 2, 1]

}
}