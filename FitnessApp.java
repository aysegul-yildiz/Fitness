import java.util.Scanner;

public class FitnessApp 
{
    public static void main(String[] args) 
    {
        // define variables 
        Scanner scan;
        String birthdate;
        double height;
        int weight;
        int restingHeartRate;
        int waist;
        int hips;
        char gender;
        int choice;

        // get needed inputs
        scan = new Scanner(System.in);
        System.out.print("Enter birthdate (YYYY-MM-DD): ");
        birthdate = scan.next();
        System.out.println();
        System.out.print("Enter gender (f)emale/(m)ale: ");
        gender = scan.next().charAt(0);
        System.out.println();
        System.out.print("Enter height(m) weight(kg): ");
        height = scan.nextDouble();
        weight = scan.nextInt();
        System.out.println();
        System.out.print("Enter waist and hip measurments (cm):");
        waist = scan.nextInt();
        hips = scan.nextInt();
        System.out.println();
        System.out.print("Enter resting heart rate: ");
        restingHeartRate = scan.nextInt();
        System.out.println();

        // create FitnessAssessment object
        FitnessAssessment fitness = new FitnessAssessment(birthdate, height, weight, restingHeartRate, waist, hips, gender);

        // do while loop to ask for choice until the choice is 5
        do
        {
            System.out.printf("--------------MENU-------------- %n1 - Calculate Target Heart Rate %n2 - Calculate Waist/Hip Ratio %n3 - Body Mass Index %n4 - Display Fitness Level %n5 - Quit");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scan.nextInt();
            
            // if statements to determine which method to call from the FitnessAssessment class
            if ( choice == 1 )
            {
                int age = fitness.calculateAge();
                int maxHeartRate = fitness.calculateMaxHeartRate(age);
                System.out.printf("Target Heart Rate: %.1f %n" ,  fitness.calculateTargetHeartRate( maxHeartRate ) );
            }
            else if ( choice == 2 )
            {
                System.out.printf("Waist/ Hip Ratio: %.1f %n", fitness.calculateWaistHipRatio( hips, waist ));
            }
            else if ( choice == 3 )
            {
                double bmi = fitness.calculateBMI(weight, height);
                System.out.printf("Your BMI is: %.1f  Category: %s %n",fitness.calculateBMI( weight, height ), fitness.findBMICategory(bmi));
            }
            else if ( choice == 4 )
            {
                double bmi = fitness.calculateBMI(weight, height);
                double waistHipRatio = fitness.calculateWaistHipRatio(hips, weight);
                System.out.println("Your fitness level is: " + fitness.determineFitnessLevel( bmi, gender, restingHeartRate, waistHipRatio));
            }

        }while ( choice != 5 );
        scan.close();

        


        
    }
    
}
