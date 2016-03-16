
/* Author- Sonali Guleria

Description- Project 2 and Activity 3-The purpose to maintain the potential list of secret words from the external text file.
Maintains a secret wordlist which is collection of words from the external file. Also returns the size of the wordlist, randomly picks up 
a word and returns to the subclass P2A2_GULERIA_SONALI_WORDLIST. It also has the additional addWord method which can be used later if someone wants
give functionality of adding the word to the wordlist.


Date Created- 10-16-2015



*/	



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class P2A3_GULERIA_SONALI_WORLIST	 {

	/* variable declaration starts */
	
	private BufferedReader bufferedReader;					//BufferedReader variable reference to hold the bufferedReader object which will data of external file
	private FileReader wordFile;					       //FileReader variable reference to hold the FileReader object.
	private String text;								  
	private String selectedWord;						  
	private ArrayList<String> wordList = new ArrayList<String>();
	private Random RandomNumbers = new Random();
	private int listSize,RandomIndex=0;

	/* variable declaration ends */

	/* addWord method to add the word to wordlist (additional functionality) */
	public void addWord(String text) 
	{
	
		wordList.add(text);
		
	}
	
	/* addwords from external file to Secret Wordlist */
	
	public  void addWordsFromFile(File filePath) throws IOException
	{
		wordFile = new FileReader(filePath);
		bufferedReader = new BufferedReader(wordFile);
		while((text = bufferedReader.readLine()) != null) 
		{
         wordList.add(text);
     }  
		//System.out.println("Secret List Loaded");
		
	}
	
	/* gets the Secret Wordlist (additional method to return Word List)*/
	
	private ArrayList<String> getwordList()
	
	{
		
		return (wordList);
	}
	
	/* gets a random word from the Secret Wordlist */	
	
	public String getRandomWord(int a)
	{
		
		
		
		RandomIndex = RandomNumbers.nextInt(a);	
		selectedWord=wordList.get(RandomIndex);
		return(selectedWord);
		
	}
	
	
	/* gets the size of the Secret Wordlist */
	
	public int numWords()
	
			{
		
			
		  
		    listSize =wordList.size();
			return listSize;
			}
	
 
	
		
		

	}
