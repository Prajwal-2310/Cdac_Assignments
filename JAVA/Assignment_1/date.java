public class date {
    private int day;
    private int month;
    private int year;

   
    public void setDate(){
        System.out.print("Enter the Date : ");
        day = ConsoleInput.getInt();
        System.out.print("Enter the Month : ");
        month = ConsoleInput.getInt();
        System.out.print("Enter a Year : ");
        year = ConsoleInput.getInt();

        if (month >=1 && month <=12) {   
        
            if (isLeapYear() && month ==2) {
                    if (day >= 1 && day <= 29) {
                        System.out.println("Date set successfully.");
                    }else{
                        System.out.println("Enter the day between 1 to 29");
                    } 
                
            } else {
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day >=1 && day<= 31) {
                        System.out.println("Date set successfully.");
                    }else{
                        System.out.println("Enter the day between 1 to 31");
                    }
                }else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day >=1 && day <= 30) {
                        System.out.println("Date set successfully.");
                    }else{
                        System.out.println("Enter the day between 1 to 30");
                    }
                }else if (month == 2) {
                    if (day >=1 && day <= 28) {
                       System.out.println("Date set successfully.");
                    }else{
                        System.out.println("Enter the day between 1 to 28");
                    }
                }
            }
        }else{
        System.out.println("Enter The Valid Month");
    }
}

    boolean isLeapYear(){
        if (year % 4 == 0 && year %100 !=0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void display(){
        System.out.println(day + "/"+month+"/"+year);
    }

    public void addDays(){
        int adddays = 0;
        System.out.print("Enter the Number of days : ");
        adddays = ConsoleInput.getInt();

        adddays = adddays + day;

        while (true) {
            if (isLeapYear() && month == 2) {
                if (adddays > 29) {
                    adddays = adddays - 29;
                    month++;
                }else{
                    day = adddays;
                    break;
                }
            } else {
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month==8 || month == 10 || month == 12) {
                    if (adddays > 31) {
                        adddays = adddays - 31;
                        month++;
                    }else{
                        day = adddays;
                        break;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (adddays > 30) {
                        adddays = adddays - 30;
                        month++;
                    }else{
                        day = adddays;
                        break;
                    }
                }else if (month == 2) {
                    if (adddays > 28) {
                        adddays = adddays - 28;
                        month++;
                    }else{
                        day = adddays;
                        break;
                    }
                }
            }
            if (month == 13) {
                month = 1;
                year++;
            }
        }    
    }

    public void addMonths(){
        int addMonth = 0;
        System.out.print("Enter the Number of Months : ");
        addMonth = ConsoleInput.getInt();

        addMonth = addMonth + month;
        while (true) {
            if (addMonth > 12) {
                addMonth = addMonth - 12;
                year++;
            }else{
                month = addMonth;
                break;
            }
        }
        if (month == 2 && day == 29 && !isLeapYear()) {
            day = 28;
        }
    }

    public void addYear(){
        int addYear = 0;
        System.out.print("Enter a number of year : ");
        addYear = ConsoleInput.getInt();

        addYear = addYear + year;

        if (month == 2 && day == 29 && !isLeapYear()) {
            day = 28;
        }
    }

    public void CompareDates(){
        System.out.println("Not Functional");
    }
}


