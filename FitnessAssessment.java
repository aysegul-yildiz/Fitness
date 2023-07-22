import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FitnessAssessment
{
    private String birthdate;
    private double height;
    private int weight;
    private int restingHeartRate;
    private int waist;
    private int hips;
    private char gender;

    public FitnessAssessment(String birthdate, double height, int weight, int restingHeartRate, int waist, int hips, char gender)
    {
        this.height = height;
        this.weight = weight;
        this.restingHeartRate = restingHeartRate;
        this.waist = waist;
        this.hips = hips;
        this.gender = gender;
        setBirthdate(birthdate);
    }

    public String getBirthdate() {
       return birthdate;
    }

    public void setBirthdate(String birthdate) {
        LocalDate localDate = LocalDate.parse( birthdate );    
        this.birthdate = localDate.format( DateTimeFormatter.ISO_LOCAL_DATE );
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRestingHeartRate() {
        return restingHeartRate;
    }

    public void setRestingHeartRate(int restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public char getGender() {
        return gender;
    }

    public void setGender( char gender) {
        this.gender = gender;
    }
    /**
     * calculate the age using now and birthdate
     * @return int age of the person
     */
    public int calculateAge()
    {
        LocalDate birth = LocalDate.parse(birthdate);
        LocalDate now = LocalDate.now();
        Period p = Period.between(birth, now);
        int age = p.getYears();
        return age;
    }

    /**
     * calculate the maximum heart rate substracting age from 220
     * @param age
     * @return int maxHeartRate 
     */
    public int calculateMaxHeartRate( int age)
    {
        int maxHeartRate = 220 - age;
        return maxHeartRate;
    }

    /**
     * calculate target heart rate using max heart rate 
     * @param maxHeartRate
     * @return double target heart rate
     */
    public double calculateTargetHeartRate( int maxHeartRate )
    {
        double targetHeartRate;
        targetHeartRate = ( (double) maxHeartRate * 85 / 100 );
        return targetHeartRate;
    }

    /**
     * calculate waist hip ratio by dividing waist by hip measurment
     * @param hips
     * @param waist
     * @return double waist hip ratio
     */
    public double calculateWaistHipRatio( int hips, int waist)
    {
        double waistHipRatio;
        waistHipRatio = ((double)waist) / ((double)hips);
        return waistHipRatio;
    }

    /**
     * calculate bmi by dividing weight by square of height
     * @param weight
     * @param height
     * @return double bmi
     */
    public double calculateBMI( int weight, double height)
    {
        double bmi;
        bmi = weight / Math.pow(height, 2);
        return bmi;
    }

    /**
     * determine bmi category
     * @param bmi
     * @return String bmi category
     */
    public String findBMICategory( double bmi)
    {
        String bmiCategory;
        if ( bmi > 30 )
        {
            bmiCategory = "obese";
        }
        else if ( bmi <= 30 && bmi > 25 )
        {
            bmiCategory = "overweight";
        }
        else if ( bmi <= 25 && bmi >20 )
        {
            bmiCategory = "normal";
        }
        else 
        {
            bmiCategory = "underweight";
        }
        return bmiCategory;
    }

    /**
     * determine fitness level by checking statements
     * @param bmi
     * @param gender
     * @param restingHeartRate
     * @param waistHipRatio
     * @return String fitness level
     */
    public String determineFitnessLevel( double bmi, char gender, int restingHeartRate, double waistHipRatio)
    {
        int count = 0;
        if ( bmi <= 24 && bmi >= 20 )
        {
            count++;
        }
        if ( restingHeartRate < 70 )
        {
            count++;
        }
        if ( gender == 'f' && waistHipRatio < 0.9 )
        {
            count++;
        }
        else if ( gender == 'm' && waistHipRatio < 1 )
        {
            count++;
        }
        String fitnessLevel = " ";
        if ( count == 0 )
        {
            fitnessLevel = "POOR";
        }
        else if ( count == 1 )
        {
            fitnessLevel = "AVERAGE";
        }
        else if ( count == 2)
        {
            fitnessLevel = "GOOD";
        }
        else if ( count == 3 )
        {
            fitnessLevel = "EXCELLENT";
        }
        return fitnessLevel;
    }
    
}