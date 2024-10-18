package gympackage;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Customer
{

    public String name;

    public String personnummer;

    private String membershipStatus;

    public String dateLastTrained;

    public String membershipFeeLastPaid;

    public Customer(String personnummer, String name, String membershipFeeLastPaid)
    {

        this.name = name;
        this.personnummer = personnummer;
        this.membershipFeeLastPaid = membershipFeeLastPaid;

    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }


    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void getStatus()
    {




        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate paymentDate = null;

        LocalDate today = LocalDate.now();

        try
        {
           paymentDate = LocalDate.parse(membershipFeeLastPaid, formatter);
        }
        catch (DateTimeParseException e)
        {
            System.out.println("The payment date could not be read.");
            return;
        }

        long daysSinceFeePaid = ChronoUnit.DAYS.between(paymentDate, today);





        if (daysSinceFeePaid < 365)
        {
            System.out.println("The person is a member");
            System.out.println();

            trainAndLog();
        }
        else
        {
            System.out.println("The person is a former member.");
            System.out.println();
        }



    }

    public void trainAndLog()
    {
        LocalDate dateTrainedInLD = LocalDate.now();

        String dateTrainedInString = dateTrainedInLD.toString();

        dateLastTrained = dateTrainedInString;



       try ( BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter("C:\\Users\\Admin\\IdeaProjects\\BestGymUppgift\\src\\main\\java\\gympackage\\trainingLog.txt", true)))
       {

            bufferedWriter.newLine();
            bufferedWriter.write(name + ", " + personnummer + ", " + dateTrainedInString);



       }
       catch (FileNotFoundException notFoundException)
       {
           System.out.println("The log file could not be found.");
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
           e.printStackTrace();

       }


    }


}
