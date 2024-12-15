import java.util.*;

public class OfficeRostering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of employees and friendships
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        
        List<Integer>[] friends = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        // Read friendship pairs
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            friends[a].add(b);
            friends[b].add(a);
        }

        // Read the maximum number of employees allowed in the office
        int K = scanner.nextInt();

        // Initialize attendance for all employees (1 = present, 0 = absent)
        int[] attendance = new int[N];
        Arrays.fill(attendance, 1);

        int totalInOffice = N; // Start with all employees in the office
        int days = 0; // Count the number of days required

        // Edge case: if the initial total is already less than or equal to K
        if (totalInOffice <= K) {
            System.out.println(days);
            scanner.close();
            return;
        }

        // Process until the number of employees in the office <= K
        while (totalInOffice > K) {
            days++;
            int[] nextAttendance = new int[N];

            for (int i = 0; i < N; i++) {
                int inOfficeFriends = 0;
                for (int friend : friends[i]) {
                    if (attendance[friend] == 1) {
                        inOfficeFriends++;
                    }
                }

                // Determine next day's attendance for employee i
                if (attendance[i] == 1) {
                    nextAttendance[i] = (inOfficeFriends >= 3) ? 1 : 0;
                } else {
                    nextAttendance[i] = (inOfficeFriends < 3) ? 1 : 0;
                }
            }

            // Update attendance and count employees in the office
            attendance = nextAttendance;
            totalInOffice = 0;
            for (int i = 0; i < N; i++) {
                totalInOffice += attendance[i];
            }
        }

        // Output the number of days
        System.out.println(days);

        scanner.close();
    }
}