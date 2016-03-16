
	/* Author- Sonali Guleria
	 
	   Description- Project 2 and Activity 3-Play Rainbow Explosion with.
	   Player can choose to play with or without hint. 
	   To play the game program cycles through the list of secret words in a random order for each game the player chooses to play as read from the external file.
	   Player guess a letter at a time or the complete word.For Every Incorrect guess Player earns a Tick.Player can only get at max 6 ticks after which the game's up.
	   Game can be played any number of times till the user wants. Maintains a list of guesses words and letters to inform user that he has already guessed it and no tick is recorded.
	   Game is not case sensitive. meaning both upper case and lower case treated as same(even for the guessed lists). 
	   Extends a class that has the purpose to maintain the potential list of secret words from the external text file. 
	    

	   Date Created- 10-16-2015
	  

	   
	*/	


	import java.io.File;
import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Scanner;

	public class P2A3_GULERIA_SONALI extends P2A3_GULERIA_SONALI_WORLIST {

	    
	    private String guessMe;												 //the word to be guessed
	    private String wordStatus="",secretWord = " ";					    //string variables to store mid results
	    private char[] guessChar;                                          //converting the secret word into char array to compare it with the guesses
	    private String input,repeat,color;								  //string variables to store strings for input, color name and if user wants to repeat the game
	    private int tick = 0,gameEnd=0;									 //int variables to keep track of ticks and Game end status
	    char gChar =' ';											   //character to save the the guess from user
	    int listSize,typeOfGame;
	    ArrayList <Character> guessedList = new ArrayList<Character>();	     //Arraylist to store the guessed characters by player
	    ArrayList <String> guessedWords = new ArrayList<String>();      	//Arraylist to store the guessed Words by player
	    StringBuilder searchMe = new StringBuilder(30);						//String builder to create underscores and replace characters
	    Scanner answer = new Scanner(System.in);
	    Scanner type = new Scanner(System.in);
	    String hint, word;
	    public static void main(String[] args) {
	   
	    	
	   	 System.out.println("Hey...Welcome..We are going to play Rainbow Explosion..!!\nThere's a secret word and you have to guess it!"); 
	   	 System.out.println("You can guess a letter at a time or the complete word.\nFor Every Incorrect guess you earn a tick.\nYou can only get at max 6 ticks after which the game's up. "); 
	   	 System.out.println("1 tick = RED\n2 ticks = ORANGE\n3 ticks = YELLOW\n4 ticks=GREEN\n5 ticks=BLUE\n6 ticks = PURPLE....BOOM...Bomb Explodes..Enjoy the Colors!");
		    
	   	P2A3_GULERIA_SONALI Starter = new P2A3_GULERIA_SONALI ();                                       //an object created for class GuessWord    
        
	   	
	   	System.out.println("How you would like to play the game, Enter 1 to play with Secret Word and Enter 2 to play with secret word and hint");
	   	Starter.typeOfGame = Starter.type.nextInt();
	   	
	   	 try {
	   		    
	   		   /* System.out.println("\nPlease give full path of your file");
	   		    String filePath = Starter.answer.nextLine();*/    //  to get file path from user
                
	   		    //File dir = new File(".");
		        //File filepath = new File(dir.getCanonicalPath()+ File.separator + "P2A3_GULERIA_SONALI.txt");
	   		    File filepath = new File("P2A3_GULERIA_SONALI.txt");
	   		    
		        Starter.addWordsFromFile(filepath);
	   		
			  } 
	   	 catch (FileNotFoundException e)
	   	   {
				System.out.println("File Not Found  "+"Make sure it exists.");
			}
		
	   	catch(IOException ex) 
	   	 {
	   		System.out.println("Error reading file");
	   	 }
		 
	   	 Starter.listSize = Starter.numWords();
          
	   	 do{	
	   	    	
	   			
	   	    	
	   		
	   			Starter.word = Starter.getRandomWord(Starter.listSize);
	   			Starter.guessMe = Starter.hintWord(Starter.word);
	   			Starter.gameEnd =0;												   //reset game status
	   	    	Starter.guessChar= Starter.guessMe.toLowerCase().toCharArray();
	   	    	Starter.setsecretWord(Starter.guessMe);  							//call the method to create underscore string
	   	    	System.out.println("\n...And....your Word is\n\n"+Starter.secretWord);

	   	    	
	   	    do{
			        
	   	    	System.out.println("\nGuess the word or a character.");
	   	    	Starter.input = Starter.answer.nextLine();

			
			        if (Starter.input.length()==1)                                      //checks if a char is entered; if char calls char method
	   	    	    {
	   	    	    	
	   	    	    Starter.gChar = Starter.input.charAt(0);
	   	    	    Starter.checkGuess(Starter.gChar);
	   	    	  
	   	    	    }
			else                                                              // if a string is entered; calls the string function
	   	    	    {
	   	    	    	
	   	    	    Starter.checkGuess(Starter.input);
	   	    	    
	   	    	    }                    
	   	    }while(Starter.gameEnd!=1);                                          //repeats while the game ends;continues till the word is guessed
	   	    

	   	    System.out.println("Do you Want to Continue Playing? Enter Y for Yes or any key to Exit??");
	   	    Starter.repeat = Starter.answer.nextLine();
	   	    
	    }while(Starter.repeat.equalsIgnoreCase("Y"));                              //repeats while till the user wants to stop
	   	    

	    }              //end of main

	    
	   	  

	   /*method to set the word as '_' */
	    
	    public void setsecretWord(String word)
	    {
	       
	       for (int count=0; count < word.length(); count++)
	       searchMe.append('-');
	       secretWord = searchMe.toString();
	       
	    }
	    
	    
	   
	   /*checkGuess Method for checking if the char entered by user is in the Secret Word */
	   
	    public void checkGuess(char a)
	    
	    {
	   	 
		 if(guessedList.contains(a))                 //checks if entered char has already been entered.
	   			 
	   		{

			        System.out.println("You Have Guessed that already..make a new Guess!");
			        System.out.println("Now, Your Word is\n\n"+secretWord);
	   			 
	   		}
	   		 
	   	 else
	   		 
	   		{
	   		 a=Character.toLowerCase(a);
	   		 
	   		 if(guessMe.toLowerCase().contains(String.valueOf(a)))
			        {
	   			  
	   			  
	                for(int i = 0; i< guessMe.length();i++)
	                {
	                	if(guessChar[i]==a)
	                	searchMe.setCharAt(i,a);
	                	 
	                
	                }
			        	  
					    System.out.println("You guessed it Right!!\n");
			        	
			        	            
			    		           
					                wordStatus = searchMe.toString();
			    		            secretWord=wordStatus;
			    		            System.out.println("Now,your Word is\n\n"+searchMe);
			       		            guessedList.add(a);  
			       		            guessedList.add(Character.toUpperCase(a));
			       		            if(guessMe.equalsIgnoreCase(searchMe.toString()))
			       		             {
			       		            	System.out.println("Congratulations!! You Win...Bomb Detonates  ");
			       		        	   gameEnd =1;
			       		        	   ClearArrayList();
			       		        	 }
			       		
			        }
	   		       		               
					    
	   		           else
	   			  
	   		               {

					                  tick++;
	  	    		                  guessedList.add(a);
	  	    		                  guessedList.add(Character.toUpperCase(a));
				                      checkStatus();
					                 
					      
	   		               }
				             }
	    }
	   		
	   	            
	    /*checkGuess Method for checking if the word entered by user is the Secret Word. If not the word is entered to the guessedList pool and user is informed*/   	  

	    public void checkGuess(String a)
	    {
	          if(guessedWords.contains(a))
	          {
	       	   System.out.println("Come on..You Have Guessed that once already..make a new Guess!");
	       	   System.out.println("Now, Your Word is\n\n"+secretWord);
	          }
	          else
	          {
	       	   
	          
		    	if(guessMe.equalsIgnoreCase(a))
		    	{
		    	
		    		System.out.println("CONGRATULATIONS!!!! You guessed it correctly  Bomb Detonates");
		    		gameEnd =1;
		    		ClearArrayList();
		         }
		    	else
		    	{
		    		guessedWords.add(a);
		    		tick++;
		    		checkStatus();
		    		
		    	}
		    	
	   	 
	          }
	   }
	    
	    /*checks the status of the bomb on incorrect guess*/
	    
	    public void checkStatus()
	    {
	   	 
	   	 if(tick < 6)
	   		{
	   		
	   		 checktick();
	   		
	    	    
	   		}
	   		else
	   		{
	   		color = "Purple";
	   		System.out.println("Your Rainbow got the final color " +color);
	   		System.out.println("Boom....GAME OVER!!");
	   		System.out.println("The Secret Word was:"+guessMe);
	   		gameEnd=1;
		    	ClearArrayList();
	   		
	   		}
	   	 
	    }
	    
	    /* checks and displays the color of the Bomb */
	    
	    public void checktick()
	    {
	   	 switch (tick)
	        {
	           case 1:
	              
	           	color = "RED";
	           	
	           	System.out.println("Sorry incorrect Guess.You have 5 more chances.Your Rainbow color is "+color+"\n");
	           	System.out.println("Now, Your Word is\n\n"+secretWord);
	           	break;
	           	 
	           case 2:
	           	
	           	color = "Orange";
	           	System.out.println("Sorry incorrect Guess.You have 4 more chances.Your Rainbow color is "+color+"\n");
	           	System.out.println("Now, Your Word is\n\n"+secretWord);
	              break;
	           case 3:
	           	color = "Yellow";
	           	System.out.println("Sorry incorrect Guess.You have 3 more chances.Your Rainbow color is "+color+"\n");
	           	System.out.println("Now, Your Word is\n\n"+secretWord);
	              break;
	           case 4:
	           	color = "Green";
	           	System.out.println("Sorry incorrect Guess.You have 2 more chances.Your Rainbow color is "+color+"\n");
	           	System.out.println("Now, Your Word is\n\n"+secretWord);
	              break;
	           case 5:
	           	color = "Blue";
	           	System.out.println("Sorry incorrect Guess.You have 1 last chance.Good Luck.\nYour Rainbow color is "+color+"\n");
	           	System.out.println("Now, Your Word is\n\n"+secretWord);
	           	break;
	           case 6:
	           	color = "Purple";
	           	break;
	 	   
	        }
	    }
	    
	    //Clear the ArrayList for guessed words and letters along with the Stringbuilder used to save and store word at the end of a round
	    public void ClearArrayList()
	    {
	   	    
	   	    searchMe.setLength(0);
	   	    guessedList.clear();
	   	    guessedWords.clear();
	   	    tick = 0;
	   	   
	    }   
	    
	 /* function to display hint if required */ 
	    
	    public String hintWord(String a)
	    
	    {
	      
	       String breakWord [] = a.split(",");	   
	       guessMe = breakWord[0];
	       hint = breakWord[1];
	       if (typeOfGame==2)
	       {  
	       System.out.println("The hint for your word is:\n\n"+ hint);
	       }
	       return guessMe;
	    
	    }
	    
	    
	}
