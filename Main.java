package gympackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{





    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Customer> customers = Gym.getCustomers();



        while (true)
        {

            System.out.println("Say name or personnummer of person you want to look up. press 'q' to end program");

            String customerId = scanner.nextLine();

            if (customerId.equals("q") || customerId.equals("Q") )
            {
                break;
            }



            Gym.checkCustomer(customerId, customers);





        }








    }







}