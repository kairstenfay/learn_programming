// Class to represent a specific type of employee, 
//   a legal assistant, at a law firm.
public class LegalAssistant extends Assistant {
   // Returns the legal assistant's salary.
   // Legal Assistants make $45,000/year instead of the normal $40,000
   public double getSalary() {
      return 45000.0;
   }
   
   // States that this legal assistant is filing a legal brief.
   public void fileLegalBrief() {
      System.out.println("We're right! Here's why!");
   }
}