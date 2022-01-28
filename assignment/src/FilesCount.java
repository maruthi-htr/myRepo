
/*The actual output will like this

The number of files created in October is
The number of files created in November is 2
The number of files created in December is 1*/


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormatSymbols;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FilesCount {

    public static void main(String[] args) throws IOException {

        // creates a file object
        File file = new File("/Users/maruthi-htr/Documents/htr-partner-android");

        // returns an array of all files
        File[] fileList = file.listFiles();

        List<Integer> monthNumber = new ArrayList<>();

        for (File file1 : fileList) {
            BasicFileAttributes attr = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
            int month = new Date(attr.creationTime().toMillis()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue();
            monthNumber.add(month);
        }

        int n = monthNumber.size();
        countFreq(monthNumber, n);
    }

    public static void countFreq(List<Integer> monthList, int n) {
        boolean visited[] = new boolean[n];

        Arrays.fill(visited, false);

        // Traverse through array elements and count frequencies
        for (int i = 0; i < n; i++) {

            // Skip this element if already processed
            if (visited[i] == true)
                continue;

            // Count frequency
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (monthList.get(i) == monthList.get(j)) {
                    visited[j] = true;
                    count++;
                }
            }
            String monthString = new DateFormatSymbols().getMonths()[monthList.get(i) - 1];
            System.out.println("The number of files created in " + monthString + " is " + count);
        }
    }

}