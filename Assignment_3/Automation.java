// Automation
class Automation 
{
   // constants
   public final static int MAX_DISPLAY_WIDTH = 121;
   
   // private members
   private boolean rules[];
   private String thisGen;
   String extremeBit;
   int displayWidth;
   
   // public methods
   public Automation(int new_rule)
   {
      rules = new boolean[8];
      resetFirstGen();
      extremeBit = " ";
      setDisplayWidth(MAX_DISPLAY_WIDTH);
      setRule(new_rule);
   }
   
   // Overrides constructor with default
   public Automation()
   {
      this(0);
   }
   
   public void resetFirstGen()
   {
      thisGen = "*";
   }
   
   // set new rule
   public boolean setRule(int new_rule)
   {
      if(new_rule > 255 || new_rule < 0)
      {
         for (int i = 0; i < rules.length; i++)
         {
            rules[i] = false;
         }
         return false;
      } else
      {
         for (int i = 0; i < rules.length; i++)
         {
            if(new_rule % 2 == 1)
            {
               rules[i] = true;
            } else
            {
               rules[i] = false;
            }
            new_rule = new_rule / 2;
         }
      }
      return true;
   }
   
   // set display width
   public boolean setDisplayWidth(int width)
   {
      if(width > MAX_DISPLAY_WIDTH)
      {
         return false;
      }
      displayWidth = width;
      return true;
   }
   
   // String representation
   // Centers it if less than displayWidth
   // Truncate both sides if greater 
   public String toStringCurrentGen()
   {
      int blanks = (displayWidth - thisGen.length()) / 2;
      String buffer = "";
      String newString = thisGen;
      
      if(blanks > 0)
      {
         for (int i = 0; i < blanks; i++)
         {
            buffer = buffer + extremeBit;
         }
         
         newString = buffer + thisGen + buffer;
      }
      else if (blanks < 0)
      {
         newString = newString.substring(-blanks, thisGen.length()+blanks);
      }
      return newString;
   }
   
   // propagate new gen
   public void propagateNewGeneration()
   {
      String newGen = "";
      thisGen = extremeBit + extremeBit + thisGen + extremeBit + extremeBit;
      
      for (int i = 1; i < thisGen.length()-1; i++)
      {
         int bin = 0;
         int pow = 4;
         for (int j = 0; j < 3; j++)
         {
            if (thisGen.charAt(i-1+j) == '*')
            {
               bin += pow;
            }
            pow = pow / 2;
         }
         if(rules[bin])
         {
            newGen = newGen + '*';
         }
         else 
         {
            newGen = newGen + ' ';
         }
      }
      
      if(extremeBit == " " && rules[0] )
      {
         extremeBit = "*";
      }
      if(extremeBit == "*" && !rules[7] )
      {
         extremeBit = " ";
      }
      thisGen = newGen;
   }
}
