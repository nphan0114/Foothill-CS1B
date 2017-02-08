
import java.util.Scanner;

/**
 * Main class that tests the automation
 * @author Nghia
 *
 */
public class Foothill
{
   public static void main(String args[])
   {
      int rule;
      String userInput;
      
      Scanner read = new Scanner(System.in);
      Automation auto;
      
      // get user input
      do
      {
         System.out.print("Enter rule (0-255): ");
         userInput = read.nextLine();
         rule = Integer.parseInt(userInput);
      } while (rule < 0 || rule > 255 );

      // create automation
      auto = new Automation(rule);
      auto.setDisplayWidth(79);
      
      // Display output
      System.out.println("Display width = " + auto.displayWidth);
      System.out.println("start ");
      
      for (int i = 0; i < 100; i++)
      {
         System.out.println(auto.toStringCurrentGen());
         auto.propagateNewGeneration();
      }
      System.out.println("end ");
      read.close();
      
   }
}
