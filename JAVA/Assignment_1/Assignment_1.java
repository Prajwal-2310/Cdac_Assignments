public class Assignment_1 {
    public static void main(String[] args) {
        
        date d = new date();

        boolean menu = true;
        while (menu) {
            System.out.println("1 : setDate\n 2 : Display\n 3 : Add Days\n 4 : Add Months\n 5 : Add Year\n 6 : Compare Dates\n 7 : Exit");
            System.out.print("Enter Your Choise : ");
            int choise = ConsoleInput.getInt();

            switch (choise) {
                case 1:
                    d.setDate();
                    break;

                case 2:
                    d.display();
                    break;

                case 3:
                    d.addDays();
                    break;

                case 4:
                    d.addMonths();
                    break;

                case 5:
                    d.addYear();
                    break;

                case 6:
                    d.CompareDates();
                    break;

                case 7:
                    System.out.println("Exit From the System");
                    menu = false;
                    break;
            
                default:
                    System.out.println("Enter Valid Entry");
                    break;
            }
        }
    }
}
