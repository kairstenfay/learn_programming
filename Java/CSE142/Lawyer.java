// Class to represent a specific type of employee, 
//   a lawyer, at a law firm.
public class Lawyer extends Employee {
   // Returns the lawyer's salary.
   // Laywers make $75,000/year instead of the normal $40,000
   public double getSalary() {
      return 75000.0;
   }

   // Returns the color of the form the employee uses to request vacation.
   // Lawyers use pink forms to request vacation instead of the normal yellow.
   public String getVacationForm() {
      return "pink";
   }
   
   // State that this lawyer is suing....something.
   public void sue() {
      System.out.println("See you in court!!");
   }
}