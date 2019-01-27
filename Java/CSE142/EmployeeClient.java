// Program to demonstrate the basics of inheritance.
//
// Notice that each type of employee has their own results when
//   the program is run, and that some types of employees have 
//   behavior specific to them.

public class EmployeeClient {
   public static void main(String[] args) {
      System.out.println("Employee: ");
      Employee eddie = new Employee();
      System.out.print(eddie.getHours() + " hours/week, ");
      System.out.printf("$%.2f, ", eddie.getSalary());
      System.out.print(eddie.getVacationDays() + " vacation days, using ");
      System.out.println(eddie.getVacationForm() + " form");
      System.out.println();
      
      System.out.println("Assistant: ");
      Assistant al = new Assistant();
      System.out.print(al.getHours() + " hours/week, ");
      System.out.printf("$%.2f, ", al.getSalary());
      System.out.print(al.getVacationDays() + " vacation days, using ");
      System.out.println(al.getVacationForm() + " form");
      al.bookMeeting("3:00pm");
      System.out.println();
      
      System.out.println("Laywer: ");
      Lawyer lucy = new Lawyer();
      System.out.print(lucy.getHours() + " hours/week, ");
      System.out.printf("$%.2f, ", lucy.getSalary());
      System.out.print(lucy.getVacationDays() + " vacation days, using ");
      System.out.println(lucy.getVacationForm() + " form");
      lucy.sue();
      System.out.println();
      
      System.out.println("Legal Assistant: ");
      LegalAssistant lou = new LegalAssistant();
      System.out.print(lou.getHours() + " hours/week, ");
      System.out.printf("$%.2f, ", lou.getSalary());
      System.out.print(lou.getVacationDays() + " vacation days, using ");
      System.out.println(lou.getVacationForm() + " form");
      lou.bookMeeting("1:30pm");
      lou.fileLegalBrief();
      System.out.println();
   }
}