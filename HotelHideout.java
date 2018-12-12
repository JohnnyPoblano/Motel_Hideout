/********************************************************************************************************************
  *  HotelHideout.java
  *  Author: John G
  * 
  *  A fugitive is holed up in a hotel room and the FBI need our help in finding which room. 
  *  The hotel has 60 rooms, numbered from 1 to 60. 
  * 
  *  1. The fugitive is not in a room with the lowest 10 room numbers.
  *  2. The fugitive is not in the highest room number. 
  *  3. The fugitive is not in a room with the room number having 2 even digits.
  *  4. The fugitive is not in a room with the room number having 2 odd digits.
  *  5. The fugitive is not in a room when the second digit is not at least twice as large as the first digit. 
  *     For example, 57 would be eliminated because 7 is not > (5 * 2)). 
  *  6. The fugitive is not in a room that is divisable by 7. 
  *  7. The fugitive is not in a room whose room number digits when switched is not a valid room number in the hotel. 
  * 
  *  As you eliminate rooms, print the room number and why it has been eliminated. You can use these: 
     System.out.println("Room number " + i + " is the room we are seeking.");
     System.out.println("Room number " + i + " has been eliminated due to being less than 11."); 
     System.out.println("Room number " + i + " has been eliminated due to both digits being even."); 
     System.out.println("Room number " + i + " has been eliminated due to both digits being odd."); 
     System.out.println("Room number " + i + " has been eliminated due to the second digit not being twice as large as the first.");
     System.out.println("Room number " + i + " has been eliminated due to being divisable by 7.");
     System.out.println("Room number " + i + " has been eliminated due to switched digits not being a valid room number (" + newRoomNbr + ").");
  * 
  *  You should end up with 1 room number left where the fugitive is holed up. 
  * 
  * Turn in to D2L by the end of class: Class Exercise #10 
  * 
  ********************************************************************************************************************/
public class HotelHideout{
   final static int NBR_OF_ROOMS = 60;
   
   public static void main(String[] args){
      
      // initialize all rooms to true (0-59 = 1-60)
      boolean[] array = new boolean[NBR_OF_ROOMS];
      for (int i = 0; i < NBR_OF_ROOMS; i++) {
         array[i] = true;
      }
      
      for (int i = 0; i < NBR_OF_ROOMS; i++) {
         if ((i + 1) < 11) {
            array[i] = false;
            System.out.println("Room number " + (i+1) + " has been eliminated due to being less than 11.");
         }
         if ((i + 1) % 2 == 0 && ((i + 1) / 10) % 2 == 0) {
            array[i] = false;
            System.out.println("Room number " + (i+1) + " has been eliminated due to both digits being even.");
         }
         if ((i + 1) % 2 != 0 && ((i + 1) / 10) % 2 != 0) {
            array[i] = false;
            System.out.println("Room number " + (i+1) + " has been eliminated due to both digits being odd.");
         }
         if (((i + 1) - ((i + 1) / 10) * 10) <= (((i + 1) / 10))*2) {
            array[i] = false;
            System.out.println("Room number " + (i+1) + " has been eliminated due to the second digit not being twice as large as the first.");
         }
         if ((i + 1) % 7 == 0) {
            array[i] = false;
            System.out.println("Room number " + (i+1) + " has been eliminated due to being divisable by 7.");
         }
         int newRoomNbr = ((i + 1) - ((i + 1) / 10) * 10)*10 + ((i + 1) / 10);
         if (newRoomNbr > NBR_OF_ROOMS) {
            array[i] = false;
            System.out.println("Room number " + i + " has been eliminated due to switched digits not being a valid room number (" + newRoomNbr + ").");
         }
      }
      
      for (int i = 0; i < NBR_OF_ROOMS; i ++) {
         if (array[i] == true) {
            System.out.println("Room number " + (i+1) + " is the room we are seeking.");
         }
      }


      // print array
      printArray(array);
      

      
      
      
      
   }//end of main ----------------------------------------------------------------------------------------------------
   
   // Print array
   public static void printArray(boolean[] array) {
      for (int i = 0; i < array.length; i++) {
         System.out.println(array[i]);
      }
   }
   
   
}//end of class