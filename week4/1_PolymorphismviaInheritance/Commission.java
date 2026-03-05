//********************************************************************
// Commission.java
//
// Represents an hourly employee that also earns commission.
//********************************************************************

public class Commission extends Hourly
{
    private double totalSales;
    private double commissionRate;

    //-----------------------------------------------------------------
    // Sets up this commissioned employee using the specified info
    //-----------------------------------------------------------------
    public Commission(String eName, String eAddress, String ePhone,
                      String socSecNumber, double rate, double commissionRate)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
        totalSales = 0;
    }

    //-----------------------------------------------------------------
    // Adds the specified sales to the total sales
    //-----------------------------------------------------------------
    public void addSales(double sales)
    {
        totalSales += sales;
    }

    //-----------------------------------------------------------------
    // Computes and returns the pay for this commissioned employee
    //-----------------------------------------------------------------
    public double pay()
    {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales = 0;
        return payment;
    }

    //-----------------------------------------------------------------
    // Returns information about this employee as a string
    //-----------------------------------------------------------------
    public String toString()
    {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        result += "\nCommission Rate: " + commissionRate;
        return result;
    }
}