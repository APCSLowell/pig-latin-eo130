import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
 if(sWord.length() > 0)
  for(int i = 0; i< sWord.length(); i++) {
  if(sWord.charAt(i) == 'a' || sWord.charAt(i) == 'e' || sWord.charAt(i) == 'i' || sWord.charAt(i) == 'o' || sWord.charAt(i) == 'u')
  return i;  
  }
  return -1;
}
    public String pigLatin(String sWord) {
int consequence = findFirstVowel(sWord);
  if(sWord.length()>0 && sWord.substring(0,2).equals("qu")){
    return sWord.substring(2) + sWord.substring(0,2) + "ay";
  }
      if(sWord.length()>0 && consequence > 0){
    return sWord.substring(consequence) + sWord.substring(0,consequence) + "ay";
      }
  if(sWord.length()>0 && findFirstVowel(sWord) == -1)
  {
    return sWord + "ay";
  }
  if(sWord.length()>0 && findFirstVowel(sWord) == 0)
  {
    return sWord.substring(consequence) + sWord.substring(0,consequence) + "way";
  }
else
  {
    return "ERROR!";
  }
  }
