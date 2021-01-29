class ProgrammingAssignment9 
{


public static void main(String[] args) 
{


int result1 = daysInMonth(1,2000);
System.out.println(result1);

int result2 = daysInMonth(13,2000);//incorrect month
System.out.println(result2);

int result3 = daysInMonth(2,1700);//leap year
System.out.println(result3);

int result4 = daysInMonth(2,2000);
System.out.println(result4);

int result5 = daysInMonth(12,1600);//incorrect year
System.out.println(result5);

int result6 = daysInMonth(2);//error; just one argument
System.out.println(result6);




}//End of main


public static int daysInMonth(int month, int year)
{
//Checking for the right year
if(year < 1700)
{
return -1;
}

//define variables 
int leapDay = 28;//for the february

//Checking for the leap year
if (year % 4 != 0) {
        leapDay = 28;
    } else if (year % 400 == 0) {
        leapDay = 29;;
    } else if (year % 100 == 0) {
        leapDay = 28;
    } else {
        leapDay = 28;
    }
//end of if else

switch (month)//I use switch for several different options
{
           case 1:  return 31; // January                    
           
           case 2:   return leapDay; // February
                     
            case 3:  return 31; //March
                     
            case 4:  return 30; // April
                     
            case 5:  return 31; //May
                     
            case 6:  return 30; //June
                     
            case 7:  return 31; //July
                     
            case 8:  return 31; //August
                     
            case 9:  return 30; //September
                     
            case 10: return 31; //October
                     
            case 11: return 30; //November
                     
            case 12: return 31; //December
                     
            default: return -1;
                     


}//end of switch statement


}//end of method











}//End of class