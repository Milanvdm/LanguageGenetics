package articles;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TitleExtractor {

	public static void main(String [] args)
	{
		String path = askInput();
		File file = new File(path);
		
		try {
			
			PrintWriter out = new PrintWriter("titles.txt");	
			ArticleFinder parser = new ArticleFinder(file);
			
			while(parser.hasNext()) {
				Article page = parser.next();
				String title = page.title;
				
				out.println(title);
				
			}
			
			out.close();
			parser.close();
			
			
		} catch (IOException e) {
			System.out.println("It broke.");
		}
		
		
	}

	private static String askInput() {
		
		//  prompt the user to enter the path
		System.out.print("Enter the Simple English Wikipedia corpus: ");

		//  open up standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String path = null;

		//  read the path from the command-line; need to use try/catch with the
		//  readLine() method
		try {
			path = br.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your path!");
			System.exit(1);
		}
		return path;
	}
	
	


}
