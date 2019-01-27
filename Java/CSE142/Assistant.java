// Class to represent a specific type of employee, 
//   an assistant, at a law firm.
public class Assistant extends Employee {
   // States that the assistant has booked a meeting at the
   //   specified time.
   //
   // String time - the time at which the meeting should occur
   public void bookMeeting(String time) {
      System.out.println("Booking a meeting at: " + time);
   }
}