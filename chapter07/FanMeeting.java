import java.io.*;
import java.util.*;

public class FanMeeting {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int testCase = Integer.parseInt(scan.nextLine());

    while(testCase > 0) {

      String idolStrig = scan.nextLine();
      String fanString = scan.nextLine();

      int idolSize = idolStrig.length();
      int fanSize = fanString.length();

      byte[] idol = new byte[idolSize];
      byte[] fan = new byte[fanSize];

      for(int i=0; i<idolSize; i++) {
        idol[i] = (byte)((idolStrig.charAt(i) == 'M') ? 1 : 0);
      }

      for(int i=0; i<fanSize; i++) {
        fan[i] = (byte)((fanString.charAt(i) == 'M') ? 1 : 0);
      }

      int hugCount;
      int result = 0;

      for(int i=0; i<=(fanSize - idolSize); i++) {

        hugCount = 0;
        for(int j=0; j<idolSize; j++) {

          if ((fan[i+j] & idol[j]) == 1) break;
          hugCount++;
        }

        if (hugCount == idolSize) result++;
      }


      System.out.println(result);
      testCase--;
    }
  }
}