/*
 * InternetUser class
 */
class InternetUser 
{
   public static final int MIN_NAME_LENGTH = 2;
   public static final int MAX_NAME_LENGTH = 50;
   public static final int MIN_IP_LENGTH = 7;
   public static final int MAX_IP_LENGTH = 15;
   public static final String DEFAULT_IP = "0.0.0.0";
   public static final String DEFAULT_NAME = "(UNDEFINED)";
   
   private String name;
   private String ip;
 
   // Default constructor
   public InternetUser()
   {
      name = DEFAULT_NAME;
      ip = DEFAULT_IP;
   }
   
   // Constructor with 2 parameters; name and ip
   public InternetUser(String name, String ip)
   {
      if( !setName(name) )
      {
         this.name = DEFAULT_NAME;
      }
      if( !setIP(ip) )
      {
         this.ip = DEFAULT_IP;
      }
   }
   
   // accessor
   public String getName()
   {
      return name;
   }
   
   // mutator
   public boolean setName(String newName)
   {
      if( !isValidName(newName) )
      {
         return false;
      } else 
      {
         name = newName;
         return true;
      }
   }
   
// accessor
   public String getIP()
   {
      return ip;
   }
   
   // mutator
   public boolean setIP(String newIP)
   {
      if( !isValidIP(newIP) )
      {
         return false;
      } else
      {
         ip = newIP;
         return true;
      }
   }
   
   // Test length boundaries for Name
   private boolean isValidName( String testName )
   {
      if( testName.length() < MIN_NAME_LENGTH || testName.length() > MAX_NAME_LENGTH )
      {
         return false;
      } return true;
   }
   
// Test length boundaries for Name
   private boolean isValidIP( String testIP )
   {
      if( testIP.length() < MIN_IP_LENGTH || testIP.length() > MAX_IP_LENGTH )
      {
         return false;
      } return true;
   }
   
   public String toString()
   {
      String str = "Name: " + name + "\n";
      str += "IP Addr: " + ip + "\n";
      return str;
   }
}
