//*****************************************
// Salesperson.java
//
// Represents a salesperson with a first
// name, last name, and total sales.
//*****************************************

public class Salesperson implements Comparable
{
   private String firstName, lastName;
   private int totalSales;

   public Salesperson(String first, String last, int sales)
   {
      firstName = first;
      lastName = last;
      totalSales = sales;
   }

   public String toString()
   {
      return lastName + ", " + firstName + ": \t" + totalSales;
   }

   public boolean equals(Object other)
   {
      return (lastName.equals(((Salesperson)other).getLastName()) &&
              firstName.equals(((Salesperson)other).getFirstName()));
   }

   public int compareTo(Object other)
   {
      Salesperson otherSales = (Salesperson) other;

      if (this.totalSales < otherSales.totalSales)
         return -1;
      else if (this.totalSales > otherSales.totalSales)
         return 1;
      else
      {
         int lastCompare = this.lastName.compareTo(otherSales.lastName);

         if (lastCompare != 0)
            return lastCompare;
         else
            return this.firstName.compareTo(otherSales.firstName);
      }
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public int getSales()
   {
      return totalSales;
   }
}