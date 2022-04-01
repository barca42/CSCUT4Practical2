import java.io.*;
import java.util.*;
import java.util.List;


/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) throws IOException {
        String argument = args[0];
        if (argument.contains("FormatNames -u")){
            String files = argument.substring(20);
            String input = files.split(" ")[0];
            String output = files.split(" ")[1];

            formatStrings(input,output,"upperCase");
        }
        else if (argument.contains("FormatNamesm")){
            String files = argument.substring(18);
            String input = files.split(" ")[0];
            String output = files.split(" ")[1];
            formatStrings(input,output,"middleUpperCase");
        }
        else if (argument.contains("FormatNames")){
            String files = argument.substring(17);
            String input = files.split(" ")[0];
            String output = files.split(" ")[1];

            formatStrings(input,output,"firstUpperCase");
        }

    } // main

    public static void formatStrings(String input, String output, String formatWay) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            //transforms line into First Name and Last name both starting with uppercase + appropriate date format
            if (formatWay.equals("firstUpperCase")){
                String first = line.split(" ")[0];
                first = first.substring(0, 1).toUpperCase() + first.substring(1);
                String last = line.split(" ")[1];
                last = last.substring(0, 1).toUpperCase() + last.substring(1);
                String date = (line.split(" ")[2]);
                date = date.substring(0,2)+"/"+date.substring(2,4)+"/"+date.substring(4,8);
                line = first+ " "+ last + " "+ date;

            }
            if (formatWay.equals("upperCase")){
                //transforms whole name into upperCase and formats date appropriately
                String first = line.split(" ")[0];
                first = first.toUpperCase();
                String last = line.split(" ")[1];
                last = last.toUpperCase();
                String date = (line.split(" ")[2]);
                date = date.substring(0,2)+"/"+date.substring(2,4)+"/"+date.substring(4,8);
                line = first+ " "+ last + " "+ date;

            }
            if (formatWay.equals("middleUpperCase")){
                if (line.split(" ").length==4){
                    String first = line.split(" ")[0];
                    first = first.substring(0, 1).toUpperCase() + first.substring(1);
                    String middle = line.split(" ")[1];
                    middle = middle.toUpperCase();
                    String last = line.split(" ")[2];
                    last = last.substring(0, 1).toUpperCase() + last.substring(1);
                    String date = (line.split(" ")[3]);
                    date = date.substring(0,2)+"/"+date.substring(2,4)+"/"+date.substring(4,8);
                    line = first+ " "+middle+ ". " + last + " "+ date;
                }
                else{
                    String first = line.split(" ")[0];
                    first = first.substring(0, 1).toUpperCase() + first.substring(1);
                    String last = line.split(" ")[1];
                    last = last.substring(0, 1).toUpperCase() + last.substring(1);
                    String date = (line.split(" ")[2]);
                    date = date.substring(0,2)+"/"+date.substring(2,4)+"/"+date.substring(4,8);
                    line = first+ " "+ last + " "+ date;
                }
            }
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        // delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();
        String content = stringBuilder.toString();

        try (PrintWriter out = new PrintWriter(output)) {
            out.println(content);
        }
    }
} // FilesInOut
