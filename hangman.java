import java.util.*;
public class hangman
{
    static Scanner input = new Scanner (System.in);
    static Random rn = new Random();
    
    static String word = randomWord();

    public static void main (String[] args){
        
        char[] chars = createCharArray(word);
        char[] wrongChars = new char[8];

        int wrongs = 0;

        while (wrongs < 9){
            boolean continueGame = picture(wrongs);
            if (!continueGame)
            {
                wrongs++;
                break;
            }
            printArray(chars);
            System.out.println();
            System.out.println("Incorrectly Guessed Letters:");
            printWrongArray(wrongChars);

            char guessedChar = guessLetter(wrongChars);
            int notThere = 0;
            for (int i = 0; i < word.length(); i ++){
                if (guessedChar == word.charAt(i)){
                    chars[i] = guessedChar;
                }
                else {
                    notThere++;   
                }
            }
            if (notThere == word.length()) {
                wrongChars[wrongs] = guessedChar;
                wrongs++;
            }
            boolean hasWon = checkIfWon(chars);
            if (hasWon) {
                System.out.println("Congratulations, you have guessed the word!");
                break;
            }
        }
    }

    public static boolean picture (int wrongs)
    {
        if (wrongs == 0)
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("=======");
            return true;
        }
        else if (wrongs == 1)
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |      |   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("=======");
            return true;
        }
        else if (wrongs == 2)
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |      |i i|");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("=======");
            return true;
        }
        else if (wrongs == 3)
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |      |i_i|");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("=======");
            return true;
        }
        else if (wrongs == 4)
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |      |i_i|");
            System.out.println("   |        |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("=======");
            return true;
        }
        else if (wrongs == 5)
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |      |i_i|");
            System.out.println("   |        |");
            System.out.println("   |      --|--");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("=======");
            return true;
        } 
        else if (wrongs == 6)
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |      |i_i|");
            System.out.println("   |        |");
            System.out.println("   |      --|--");
            System.out.println("   |        |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("=======");
            return true;
        } 
        else if (wrongs == 7)
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |      |i_i|");
            System.out.println("   |        |");
            System.out.println("   |      --|--");
            System.out.println("   |        |");
            System.out.println("   |        |");
            System.out.println("   |");
            System.out.println("=======");
            return true;
        } 
        else
        {
            System.out.println();
            System.out.println("   __________");
            System.out.println("   |        |");
            System.out.println("   |      |i_i|");
            System.out.println("   |        |");
            System.out.println("   |      --|--");
            System.out.println("   |        |");
            System.out.println("   |       _|_");
            System.out.println("   |");
            System.out.println("=======");
            System.out.println("The correct word was " + word + ".");
            System.out.println("YOU LOSE! PLEASE PLAY AGAIN!");
            return false;
        } 
    }

    public static char guessLetter(char[] wrongLetters){
        boolean valid = false; 
        String returnStr = "";

        //Prompts for letter guess
        System.out.println();
        System.out.println("Please guess a letter.");
        while(!valid){


            String guessChar = input.nextLine();
            String guessStr = guessChar.toUpperCase();
            returnStr = guessStr;

            //if more (or less) than one letter has been inputted
            if (guessStr.length() != 1){
                //System.out.println("Sorry, that is an invalid input.");
            }
            //if letter and not punctiation, space, number, or symbol
            //has been inputted
            else if (guessStr.charAt(0) < 65 || guessStr.charAt(0) > 91) {
                //System.out.println("Sorry, that is an invalid input.");
            }
            else if (!hasBeenGuessed(wrongLetters, guessStr.charAt(0))){
                //System.out.println("Sorry, that is an invalid input.");
            }
            else {
                valid = true;
            }
        }

        //return guessed character
        return returnStr.charAt(0);
    }

    public static void printArray(char[] array)
    {
        //Will print array
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
    }

    public static void printWrongArray(char[] array)
    {
        //Will print array
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static char[] createCharArray(String word)
    {
        //Will return a char[] where each letter is replace
        //with "_" but all punctuation and spaces remain

        char[] characters = new char[word.length()];

        for (int i = 0; i < word.length(); i++){
            if(word.charAt(i) > 64 && word.charAt(i) < 91) {
                characters[i] = '_';
            }
            else {
                characters[i] = word.charAt(i);
            }
        }

        return characters;
    }

    public static String randomWord()
    {
        //Will return random word from list below

        String[] wordBank = new String[] {
                "NORTHERN",
                "APOPLEXY",
                "BANANA",
                "DON'T",
                "COMPUTER SCIENCE",
                "LITURGY",
                "LATVIAN FOLK MUSIC",
                "DEFFERED PROSECUTION",
                "FLATTERY",
                "INVESTMENTS",
                "ASPIC",
                "METRICULATE",
                "GRUNTLED",
                "PTERODACTYL",
                "ALLITERATION",
                "ALCOVE",
                "CACOPHONY",
                "EUPHONY",
                "BRAILLE",
                "EUPHONIUM",
                "EUPHORIA",
                "PYRAMID SCHEME",
                "PULMONARY ARTERIES",
                "DISSERTATION",
                "AUGMENTATIONS",
                "ALTITUDE",
                "ERRONEOUS BILATERAL-DISENFRANCHISEMENT",
                "ATTITUDE",
                "BLACK PUDDING",
                "CATHARSIS",
                "HAMSTER CAGE",
                "ASPECT",
                "AGRICULTURE",
                "TYPHOID FEVER",
                "I'M COMPLETELY DISINTERESTED",
                "CELTIBERIANS",
                "PNEUMONIA",
                "REMORSE!",
                "AMORPHUS BLOB",
                "PLAQUE",
                "DIGRESSION",
                "WAIT, NO!",
                "OSTEOPEROSIS",
                "EXPOSITION",
                "CONUNDRUM",
                "PALINDROME",
                "PRIME NUMBER",
                "APPENDECTOMY",
                "PASSACAGLIA",
                "STAPH INFECTION",//50 words thusfar
            };

        int wordNumber = rn.nextInt(wordBank.length);

        return wordBank[wordNumber];
    }

    public static boolean checkIfWon(char[] array){
        int blank = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '_'){
                blank++;
            }
        }

        if (blank == 0) {
            return true;   
        }
        else {
            return false;
        }
    }

    public static boolean hasBeenGuessed(char[] array, char character){
        boolean isValid = true;

        for(int i = 0; i < array.length; i++){
            if (character == array[i]){
                isValid = false;   
            }
        }

        return isValid;
    }
}
