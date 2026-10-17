public class StudentAttendanceSystem {

    static int countPresent(int[] arr){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if (arr[i] == 1) {
                count++;
            }
        }
        return count;
    }

    static double percentage(int present, int total){
        if (total == 0) 
            return 0.0;
        return (present * 100.0) / total;
    }

    static void longestStreak(int[] arr, int value){
        int current = 0;
        int best = 0;
        int bestEnd = -1;

        for(int i=0; i< arr.length; i++){

            if (arr[i] == value) {
                 current++;

                if (current > best) {
                    best = current;
                    bestEnd = i;
                }
            }else{
                current = 0;
            }   
        }
        if (best == 0) {
            System.out.println("Longest Streak: 0 Days");
            return ;
        }

        int bestStart = bestEnd - best + 1;

        System.out.println("Longest streak : " + best +" days (day " + (bestStart + 1) +" to day " + (bestEnd + 1) + ")"
        );
    }

    static int daysNeeded(int present, int total){
        int days = 0;
        
        while (percentage(present, total) < 75.0) {
            present++;
            total++;
            days++;
        }
        return days;
    }
    public static void main(String[] args) {
          int[] attendance = {
            1, 1, 0, 1, 1,
            1, 1, 0, 0, 1, 
            1, 1, 1, 1, 0
        };


        // Number of present days
        int present = countPresent(attendance);

        int total = attendance.length;


        // Attendance percentage
        double percent = percentage(present, total);


        // Display basic information
        System.out.println("Days present : " + present + " of " + total);

        System.out.printf("Attendance : %.2f %%\n", percent);


        // Eligibility
        if (percent >= 75.0) {
            System.out.println("Eligible : YES");
        } else {
            System.out.println("Eligible : NO");

            int days = daysNeeded(present, total);

            System.out.println("Days needed for 75%: " + days);

            // Show what percentage will be after required days
            int newPresent = present + days;
            int newTotal = total + days;

            System.out.printf(
                "After %d days: %d of %d = %.2f %%\n",
                days,
                newPresent,
                newTotal,
                percentage(newPresent, newTotal)
            );
        }


        // Longest presence streak
        System.out.print("Longest presence : ");
        longestStreak(attendance, 1);


        // Longest absence streak
        System.out.print("Longest absence : ");
        longestStreak(attendance, 0);
    
    }
}
