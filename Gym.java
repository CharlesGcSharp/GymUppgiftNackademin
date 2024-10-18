package gympackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Gym
{


    public static void checkCustomer(String customerId, ArrayList<Customer> customers)
    {




            for (Customer customer : customers)
            {

                if ( customerId.equals(customer.name))
                {

                     customer.getStatus();
                    return;
                }


            }

            for (Customer customer : customers)
            {

                if ( customerId.equals(customer.personnummer))
                {
                    System.out.println(customer.personnummer);
                    customer.getStatus();
                    return;
                }


            }

        System.out.println("The person is neither a member nor a former member. No entry");
        System.out.println();


    }

    public static ArrayList<Customer> getCustomers()
    {

        ArrayList<Customer> customers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\BestGymUppgift\\src\\main\\java\\gympackage\\data_inlamningsuppg2.txt")))
        {

            String personnummerAndAge;


            while ((personnummerAndAge = bufferedReader.readLine()) != null)
            {

                String[] personnummerAndAgeArray = personnummerAndAge.split(", ");



                String personnummerTrimmed = personnummerAndAgeArray[0].trim();

                String nameTrimmed = personnummerAndAgeArray[1].trim();

                String dateLastPaidTrimmed = bufferedReader.readLine().trim();

                Customer customer = new Customer(personnummerTrimmed, nameTrimmed, dateLastPaidTrimmed);

                customers.add(customer);




            }


        }
        catch (FileNotFoundException notFoundException)
        {
            System.out.println("The customer file could not be found.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }



        return customers;


    }


}








