/**
* File: WordCounter.java
* Reads text file and creates a binary search tree
* Author: Samuel Munoz
* Course: CS231
* Date: 10-17-19
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WordCounter {
	private OpenHashMap<String,Integer> map; // holds the binary search tree
	private int totalWordCount; // counts the number of words recorded

	// creates an empty tree and sets the word count to zero
	public WordCounter() {
		this.map = new OpenHashMap<String,Integer>(1000003);
		this.totalWordCount = 0;
	}

	// 
	public void analyze(String filename) throws FileNotFoundException, IOException {
		FileReader reader = new FileReader(filename);
		BufferedReader buffer = new BufferedReader(reader);
		String line = buffer.readLine();
	    this.map.clear();

		// split line into words. The regular expression can be interpreted
    	// as split on anything that is not (^) (a-z or A-Z or 0-9 or ').
		while(line != null) {
	    	String[] words = line.split("[^a-zA-Z0-9']");
		    for (int i = 0; i < words.length; i++) {
		        String word = words[i].trim().toLowerCase();
		        // System.out.println(word);
			    if(word.length() != 0) {
			        this.totalWordCount++;
			        Integer value = this.map.get(word);
			        if(value != null)
			        	map.put(word,value + 1);
			        else 
			        	map.put(word,1);
			    }
			}
			line = buffer.readLine();
		}
		buffer.close();
	        // Might want to check for a word of length 0 and not process it
	        // Write code to update the map
	}

	// returns the total word of the file
	public int getTotalWordCount() { return this.totalWordCount; }

	// returns the total number of unique words
	public int getUniqueWordCount() { return this.map.size(); }

	// returns the frequency of a particular word in the tree
	public int getCount(String word) {
		Integer intObj = this.map.get(word);
		if(intObj != null)
			return intObj.intValue();
		return 0;
	}

	// returns the value associated with this word divided by the total word count. Use a cast to ensure this is a floating point calculation
	public double getFrequency( String word ) {
		if(this.totalWordCount != 0)
			return this.getCount(word) / this.totalWordCount;
		return 0;
	}

	// writes on a file the word count for the document and for each unique word using a String
	public void writeWordCountFile( String filename ) throws FileNotFoundException, IOException {
		FileWriter writer = new FileWriter(filename); // this file must exist prior to running this code
		writer.write("totalWordCount : " + this.getTotalWordCount() + "\n");		
		writer.write("totalUniqueWords : " + this.getUniqueWordCount() + "\n");
		writer.write("collusions : " + this.map.collusions() + "\n");
		if(this.map.size() != 0) {
			ArrayList<KeyValuePair<String,Integer>> list = this.map.entrySet();
			for(KeyValuePair<String,Integer> pair : list)
				writer.write(pair.getKey().toString() + " " + pair.getValue().toString() + "\n");
		}
		writer.close();
	}
	
	// reads from a file written in writeWordCountFile and creates the tree from that 
	public void readWordCountFile( String filename ) throws FileNotFoundException, IOException {
		FileReader reader = new FileReader(filename);
		BufferedReader buffer = new BufferedReader(reader);
		String line = buffer.readLine();
		
		// empties the tree
		this.map = new OpenHashMap<String,Integer>(this.map.capacity());
		
		// first line
		String[] lines = line.split(":");
		line = buffer.readLine(); // skip second line
		line = buffer.readLine(); // skip third line
		this.totalWordCount = Integer.parseInt(lines[1].trim().toLowerCase());

		while(line != null) {
			lines = line.split(" ");
			String key = lines[0].trim().toLowerCase();
			Integer value = Integer.parseInt(lines[1].trim().toLowerCase());
			this.map.put(key,value);
			line = buffer.readLine();
		}
		buffer.close();
	}

	public static void mainMethod1(String args[]) throws FileNotFoundException, IOException {
		WordCounter wc = new WordCounter();
		long startTime, endTime;
		if(args.length > 3) {
			startTime = System.currentTimeMillis();
			wc.analyze(args[0]);
			wc.writeWordCountFile(args[1]);
			System.out.println(wc.map);
			wc.readWordCountFile(args[2]);
			wc.writeWordCountFile(args[3]);
			endTime = System.currentTimeMillis();
			System.out.println(wc.map);
			System.out.println("Time taken: " + (endTime-startTime) + "ms");
		}
		else {
			System.out.println("You need 4 arguments.");
		}
	}
	
	public static void mainMethod2(String[] args) throws FileNotFoundException, IOException {
		WordCounter wc = new WordCounter();
		long startTime, endTime;
		if(args.length > 0) {
			startTime = System.currentTimeMillis();
			wc.analyze(args[0]);
			System.out.println(wc.map);
			endTime = System.currentTimeMillis();
			System.out.println("Time taken: " + (endTime-startTime) + "ms");
		}
		else {
			System.out.println("You need 1 arguments.");
		}
	}
	
	public static void mainMethod3(String[] args) throws FileNotFoundException, IOException { 
		WordCounter wc = new WordCounter();
		TimeManager t = new TimeManager(5);
		if(args.length > 1) {
			for(int count = 0;count < 5;count++) {
				t.enterTime(WordCounter.processFile(wc,args));
			}
			System.out.println("Average time: " + t.average() + "ms");
		}
		else {
			System.out.println("You need 2 arguments.");
		}
	}

	public static void mainMethod4(String[] args) throws FileNotFoundException, IOException {
		WordCounter wc = new WordCounter();
		long startTime, endTime;
		if(args.length > 0) {
			startTime = System.currentTimeMillis();
			wc.analyze(args[0]);
			endTime = System.currentTimeMillis();
			System.out.println("Time taken: " + (endTime-startTime) + "ms");
		}
		else {
			System.out.println("You need 1 arguments.");
		}
	}

	public static void mainMethod5(String[] args) throws FileNotFoundException, IOException { 
		WordCounter wc = new WordCounter();
		long startTime, endTime;
		if(args.length > 1) {
			startTime = System.currentTimeMillis();
			wc.analyze(args[0]);
			long analyzeTime = System.currentTimeMillis();
			System.out.println("Time to analyze file: " + (analyzeTime-startTime) + "ms");
			wc.writeWordCountFile(args[1]);
			endTime = System.currentTimeMillis();
			System.out.println("Time to write data: " + (endTime-analyzeTime) + "ms");
			System.out.println("Time taken: " + (endTime-startTime) + "ms");
		}
		else {
			System.out.println("You need 2 arguments.");
		}
	}

	public static long processFile(WordCounter wc, String[] args) throws FileNotFoundException, IOException {
		long startTime, analyzeTime, endTime;
		startTime = System.currentTimeMillis();
		wc.analyze(args[0]);
		analyzeTime = System.currentTimeMillis();
		System.out.println("Time to analyze file: " + (analyzeTime-startTime) + "ms");
		wc.writeWordCountFile(args[1]);
		endTime = System.currentTimeMillis();
		System.out.println("Time to write data: " + (endTime-analyzeTime) + "ms"); 
		System.out.println("Time taken: " + (endTime-startTime) + "ms");
		return endTime-startTime;
	}

	// debugging main method
	public static void main(String[] args) throws FileNotFoundException, IOException {
		WordCounter.mainMethod3(args);
	}
}