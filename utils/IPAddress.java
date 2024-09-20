/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:utils/IPAddress.java
package utils;
=======
<<<<<<< HEAD
package utils;
=======
package projet_transport.utils;
>>>>>>> master
>>>>>>> master:src/utils/IPAddress.java

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aziz
 */
public class IPAddress {
    static Boolean verifier=false;
    
  public static String getIpAdress() 
  {
      try {    
          return  String.valueOf(InetAddress.getLocalHost());
      } catch (UnknownHostException ex) {
          Logger.getLogger(IPAddress.class.getName()).log(Level.SEVERE, null, ex);
      }
   return "";
  }
  public static boolean checkIpAdress(String ip)
  {
       
     Map<String,String> list=new HashMap();
     list.put("40.224.0.0","47.231.255.255");
     list.put("154.0.0.0","154.255.255.255");
     list.put("154.0.0.0","154.255.255.255");
     list.put("192.0.0.0","192.255.255.255");
     list.put("193.0.0.0","193.255.255.255");
     list.put("196.0.0.0","196.255.255.255");
     list.put("196.0.0.0","196.255.255.255");
     list.put("197.0.0.0","197.255.255.255");
     list.put("213.150.160.0","213.150.191.255");
    list.forEach((key, value)->{
             if (compare(ip,value) <= 0 && compare(ip,key) >= 0) {
                 verifier=true;
             }
         });

      return verifier;
   }
    
   public static int compare(String s1, String s2) {
      String[] parts1 = s1.split("\\.");
      String[] parts2 = s2.split("\\.");
      for (int i = 0; i < 4; i++) {
         int octet1 = Integer.parseInt(parts1[i]);
         int octet2 = Integer.parseInt(parts2[i]);
         int result = Integer.compare(octet1, octet2);
         if (result != 0) {
            return result;
         }
      }
      return 0;
   }
 
}
