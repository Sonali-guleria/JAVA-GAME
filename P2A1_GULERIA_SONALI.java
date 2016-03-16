/* Author- Sonali Guleria
 
   Description- Project 2 and Activity 1-Hardcoded word to play Rainbow Explosion with.
   Player guess a letter at a time or the complete word.For Every Incorrect guess Player earns a Tick.Player can only get at max 6 ticks after which the game's up.
   Game can be played any number of times till the user wants. Maintains a list of guesses words and letters to inform user that he has already guessed it and no tick is recorded.
   Game is not case sensitive. meaning both upper case and lower case treated as same(even for the guessed lists). \
   
   Modification:Changed from GUI to text based.
    
   Date Created- 10-10-2015
   Date Modified- 10-10-2015

   
*/	
	import java.util.ArrayList;
	import java.util.List;
    import java.util.Scanner;

	public class P2A1_GULERIA_SONALI {
		
	     
	     private final String GuessMe = "Nirvana";						//the word to be guessed
	     private String WordStatus="",SecretWord = " ";					    //string variables to store mid results
	     private char[] GuessChar = GuessMe.toLowerCase().toCharArray();    //converting the secret word into char array to compare it with the guesses
	     private String input,repeat,color;								    //string variables to store strings for input, color name and if user wants to repeat the game
	     private int Tick = 0,GameEnd=0;									//int variables to keep track of ticks and Game end status
	     char GChar =' ';													//character to save the the guess from user
	     
	     ArrayList <Character> GuessedList = new ArrayList<Character>();	//Arraylist to store the guessed characters by player
	     ArrayList <String> GuessedWords = new ArrayList<String>();      	//Arraylist to store the guessed Words by player
	     
	     StringBuilder SearchMe = new StringBuilder(30);						//String builder to create underscores and replace characters
	     Scanner Answer = new Scanner(System.in);
	     
	     public static void main(String[] args){
	    
	    	 System.out.println("Hey...Welcome..We are going to play Rainbow Explosion..!!\nThere's a secret word and you have to guess it!"); 
	    	 System.out.println("You can guess a letter at a time or the complete word.\nFor Every Incorrect guess you earn a Tick.\nYou can only get at max 6 ticks after which the game's up. "); 
	    	 System.out.println("1 Tick = RED\n2 Ticks = ORANGE\n3 Ticks = YELLOW\n4 Ticks=GREEN\n5 Ticks=BLUE\n6 Ticks = PURPLE....BOOM...Bomb Explodes..Enjoy the Colors!");
		    
	    	 P2A1_GULERIA_SONALI Starter = new P2A1_GULERIA_SONALI();                                       //an object created for class GuessWord    
	    	 
	    	    
	    	    
	    	    do{	
	    	    	Starter.setSecretWord(Starter.GuessMe);  							//call the method to create underscore string
	    	    	Starter.GameEnd =0;												   //reset game status
	    	    	System.out.println("Lets Start..your word is "+Starter.SecretWord);
	    	    	
	    	    	
	    	    do{
			        
	    	    	System.out.println("Guess the word or a character.");
	    	    	Starter.input = Starter.Answer.nextLine();

			
			        if (Starter.input.length()==1)                                      //checks if a char is entered; if char calls char method
	    	    	    {
	    	    	    	
	    	    	    Starter.GChar = Starter.input.charAt(0);
	    	    	    Starter.checkGuess(Starter.GChar);
	    	    	  
	    	    	    }
			else                                                              // if a string is entered; calls the string function
	    	    	    {
	    	    	    	
	    	    	    Starter.checkGuess(Starter.input);
	    	    	    
	    	    	    }                    
	    	    }while(Starter.GameEnd!=1);                                          //repeats while the game ends;continues till the word is guessed
	    	    

	    	    System.out.println("Do you Want to Continue Playing? Enter Y for Yes or any key to Exit??");
	    	    Starter.repeat = Starter.Answer.nextLine();
	    	    
	     }while(Starter.repeat.equalsIgnoreCase("Y"));                              //repeats while till the user wants to stop
	    	    

	     }              //end of main

	     
	    	    


	    /*method to set the word as '_' */
	     
	     public void setSecretWord(String word)
	     {
	        
	        for (int count=0; count < word.length(); count++)
	        SearchMe.append('-');
	        SecretWord = SearchMe.toString();
	        
	     }
	     
	     
	    
	    /*checkGuess Method for checking if the char entered by user is in the Secret Word */
	    
	     public void checkGuess(char a)
	     
	     {
	    	 
		 if(GuessedList.contains(a))                 //checks if entered char has already been entered.
	    			 
	    		{

			        System.out.println("You Have Guessed that already..make a new Guess!");
	    			 
	    		}
	    		 
	    	 else
	    		 
	    		{
	    		 a=Character.toLowerCase(a);
	    		 
	    		 if(GuessMe.toLowerCase().contains(String.valueOf(a)))
			        {
	    			  
	    			  
	                 for(int i = 0; i< GuessMe.length();i++)
	                 {
	                 	if(GuessChar[i]==a)
	                 	SearchMe.setCharAt(i,a);
	                 	 
	                 
	                 }
			        	  
					    System.out.println("You guessed it Right!!");
			        	
			        	            
			    		           
					                WordStatus = SearchMe.toString();
			    		            SecretWord=WordStatus;
			    		            System.out.println("Now,your word is "+SearchMe);
			       		            GuessedList.add(a);  
			       		            GuessedList.add(Character.toUpperCase(a));

			       		               if(GuessMe.equalsIgnoreCase(SearchMe.toString()))
			       		             {
			       		            	System.out.println("Congratulations!! You Win...Bomb Detonates  ");
			       		        	   GameEnd =1;
			       		        	   ClearArrayList();
			       		        	 }
			       		
			        }
	    		       		               
					    
	    		           else
	    			  
	    		               {

					                  Tick++;
	   	    		                  GuessedList.add(a);
	   	    		                  GuessedList.add(Character.toUpperCase(a));
				                      checkStatus();
					                 
					      
	    		               }
				             }
	     }
	    		
	    	            
	     /*checkGuess Method for checking if the word entered by user is the Secret Word. If not the word is entered to the Guessedlist pool and user is informed*/   	  

	     public void checkGuess(String a)
	     {
	           if(GuessedWords.contains(a))
	           {
	        	   System.out.println("Come on..You Have Guessed that once already..make a new Guess!");
	           }
	           else
	           {
	        	   
	           
	 	    	if(GuessMe.equalsIgnoreCase(a))
	 	    	{
	 	    	
	 	    		System.out.println("CONGRATULATIONS!!!! You guessed it correctly  Bomb Detonates");
	 	    		GameEnd =1;
	 	    		ClearArrayList();
	 	         }
	 	    	else
	 	    	{
	 	    		GuessedWords.add(a);
	 	    		Tick++;
	 	    		checkStatus();
	 	    		
	 	    	}
	 	    		
	    	 
	           }
	    }
	     
	     /*checks the status of the bomb on incorrect guess*/
	     
	     public void checkStatus()
	     {
	    	 
	    	 if(Tick < 6)
	    		{
	    		
	    		 checkTick();
	    		
	     	    
	    		}
	    		else
	    		{
	    			
	    		System.out.println("Boom....GAME OVER!!");
	    		GameEnd=1;
		    	ClearArrayList();
	    		
	    		}
	    	 
	     }
	     
	     /* checks and displays the color of the Bomb */
	     
	     public void checkTick()
	     {
	    	 switch (Tick)
	         {
	            case 1:
	               
	            	color = "RED";
	            	
	            	System.out.println("Sorry incorrect Guess.You have 5 more chances.Your Rainbow color is "+color);
	            	System.out.println("Now, Your Word is "+SecretWord);
	            	
	               break;
	            case 2:
	            	
	            	color = "Orange";
	            	System.out.println("Sorry incorrect Guess.You have 4 more chances.Your Rainbow color is "+color);
	            	System.out.println("Now, Your Word is "+SecretWord);
	               break;
	            case 3:
	            	color = "Yellow";
	            	System.out.println("Sorry incorrect Guess.You have 3 more chances.Your Rainbow color is "+color);
	            	System.out.println("Now, Your Word is "+SecretWord);
	               break;
	            case 4:
	            	color = "Green";
	            	System.out.println("Sorry incorrect Guess.You have 2 more chances.Your Rainbow color is "+color);
	            	System.out.println("Now, Your Word is "+SecretWord);
	               break;
	            case 5:
	            	color = "Blue";
	            	System.out.println("Sorry incorrect Guess.You have 1 last chance.Good Luck.\nYour Rainbow color is "+color);
	            	System.out.println("Now, Your Word is "+SecretWord);
	            	break;
	            case 6:
	            	color = "Purple";
	            	
	               break;
	  	   
	         }
	     }
	     
	     //Clear the ArrayList for guessed words and letters along with the Stringbuilder used to save and store word at the end of a round
	     public void ClearArrayList()
	     {
	    	    
	    	    SearchMe.setLength(0);
	    	    GuessedList.clear();
	    	    GuessedWords.clear();
	    	    Tick = 0;
	    	    
	    	   
	     }   
	    
	}  //Class ends

