import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import map.Map;
import map.TreeMap;

public class Main {
	private static StringTokenizer st;
	private static BufferedReader br;
	private static Map<String, String> map;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		map = new TreeMap<>();
		run();
		br.close();
	}

	private static void run() throws IOException {
		for (String command = nextToken(); command.compareTo("Quit") != 0; command = nextToken()) {
			switch (command) {
			case "ContainsKey":
				System.out.println("Contains key - Enter key as a single word: ");
				System.out.println("Result: " + map.containsKey(nextToken()));
				break;
			case "ContainsValue":
				System.out.println("Contains value - Enter value as a single word: ");
				System.out.println("Result: " + map.containsValue(nextToken()));
				break;
			case "Get":
				System.out.println("Get - Enter key as a single word: ");
				System.out.println("Result: " + map.get(nextToken()));
				break;
			case "IsEmpty":
				System.out.println("Is empty - result: " + map.isEmpty());
				break;
			case "Put":
				System.out.println("Put- Enter key and value as a two words: ");
				System.out.println("Result: " + map.put(nextToken(), nextToken()));
				break;
			case "Remove":
				System.out.println("Remove - Enter key as a single word: ");
				System.out.println("Result: " + map.remove(nextToken()));
				break;
			case "Size":
				System.out.println("Size - result: " + map.size());
				break;
			case "ToString":
				System.out.println("To string - result: " + map.toString());
				break;
			default:
				System.out.println("Command not recognized: " + command + ", avaliable commands: "
						+ "\n\tContainsKey\n\tContainsValue\n\tGet\n\tIsEmpty\n\tPut\n\tRemove\n\tSize\n\tToString\n\tQuit\n");
				break;
			}
		}
	}

	private static String nextToken() throws IOException {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}

		return st.nextToken();
	}
}
