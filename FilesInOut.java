import java.io.*;


/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {
    /**
     *  main method to identify which format way we are going to use
     *  separates two names of the files and put them into formatStrings method
     *
     * @param args a way to format a file, input from a file, output to a file
     * @throws IOException
     *
     */
    public static void main(String[] args) throws IOException {
        String argument = args[0];

        if (argument.contains("Java FormatNames -u")){
            String files = argument.substring(20);
            String input = files.split(" ")[0];
            String output = files.split(" ")[1];

            formatStrings(input,output,"upperCase");
        }
        else if (argument.contains("Java FormatNamesm")){
            String files = argument.substring(18);
            String input = files.split(" ")[0];
            String output = files.split(" ")[1];
            formatStrings(input,output,"middleUpperCase");
        }
        else if (argument.contains("Java FormatNames")){
            String files = argument.substring(17);
            String input = files.split(" ")[0];
            String output = files.split(" ")[1];

            formatStrings(input,output,"firstUpperCase");
        }

    } // main

    /**
     * This method creates new buffer reader and reads the contents of input into string
     * goes line by line and depending on what formatWay argument it has it will transform the line in other method
     * then writes the whole string of the lines into output file
     *
     * @param input name of the file we want to read from
     * @param output name of the file we want to output the string
     * @param formatWay which way are we to format the file
     * @throws IOException
     */
    public static void formatStrings(String input, String output, String formatWay) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            if (formatWay.equals("firstUpperCase")) {
                line= firstUpperCase(line);

            }
            if (formatWay.equals("upperCase")) {
                line=upperCase(line);

            }
            if (formatWay.equals("middleUpperCase")) {
                if (line.split(" ").length == 4) {
                    line = middleUpperCase(line);
                } else {
                    line= firstUpperCase(line);
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

    /**
     * method to transform first and last name beginning with upper case letter
     * transform the date into our desired format
     *
     * @param line line from the input file
     * @return formatted line
     */
    public static String firstUpperCase (String line){
        String first = line.split(" ")[0];
        first = first.substring(0, 1).toUpperCase() + first.substring(1);
        String last = line.split(" ")[1];
        last = last.substring(0, 1).toUpperCase() + last.substring(1);
        String date = (line.split(" ")[2]);
        date = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
        line = first + " " + last + " " + date;
        return line;
    }
    /**
     * method to transform first and last name into upper case and middle name into uppercase
     * transform the date into our desired format
     *
     * @param line line from the input file
     * @return formatted line
     */
    public static String middleUpperCase(String line){
        String first = line.split(" ")[0];
        first = first.substring(0, 1).toUpperCase() + first.substring(1);
        String middle = line.split(" ")[1];
        middle = middle.toUpperCase();
        String last = line.split(" ")[2];
        last = last.substring(0, 1).toUpperCase() + last.substring(1);
        String date = (line.split(" ")[3]);
        date = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
        line = first + " " + middle + ". " + last + " " + date;
        return line;
    }
    /**
     * method to transform both names to upper case
     * transform the date into our desired format
     *
     * @param line line from the input file
     * @return formatted line
     */
    public static String upperCase(String line){
        String first = line.split(" ")[0];
        first = first.toUpperCase();
        String last = line.split(" ")[1];
        last = last.toUpperCase();
        String date = (line.split(" ")[2]);
        date = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
        line = first + " " + last + " " + date;
        return line;
    }

} // FilesInOut
