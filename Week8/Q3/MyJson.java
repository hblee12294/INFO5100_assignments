package Q3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyJson {

    private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException {
        FileReader reader = new FileReader(file);
        Scanner sc = new Scanner(reader);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String[] record;

        sc.nextLine();      // abandon the fist line
        while (sc.hasNextLine()) {
            record = sc.nextLine().split("~");
            Vehicle vehicle = new Vehicle(record);
            vehicles.add(vehicle);
        }
        reader.close();

        return vehicles;
    }

    public static String getJsonString(ArrayList<Vehicle> vehicles) {
        String json = "{\n\"" + vehicles.get(0).webId + "\" : [\n";
        for (Vehicle vehicle : vehicles) {
            json += "{\n";
            json += "\"id\" : \"" + vehicle.id + "\"\n";
            json += "\"category\" : \"" + vehicle.category + "\"\n";
            json += "\"year\" : \"" + vehicle.year + "\"\n";
            json += "\"make\" : \"" + vehicle.make + "\"\n";
            json += "\"model\" : \"" + vehicle.model + "\"\n";
            json += "\"trim\" : \"" + vehicle.trim + "\"\n";
            json += "\"type\" : \"" + vehicle.type + "\"\n";
            json += "\"price\" : \"" + vehicle.price + "\"\n";
            json += "\"photo\" : \"" + vehicle.photo + "\"\n";
            json += "},\n";
        }
        json += "]\n}";

        return json;
    }

    public static void writeToFile(String inputToWrite, String filePath) throws IOException{
        File file;
        if (filePath == null)
            file = new File("camino_output.txt");
        else
            file = new File(filePath + "camino_output.txt");

        FileWriter writer = new FileWriter(file);
        System.out.println("*** Writing " + file.getName() + " ***");
        writer.write(inputToWrite);
        System.out.println("*** Write ends ***");
        writer.close();
    }

    // extra credit: Create the original text file from the json text file
    public static void writeTextFromJson(File inputFile) throws IOException {
        FileReader reader = new FileReader(inputFile);
        String json = new String();

        // read json from json file
        System.out.println("*** Reading " + inputFile.getName() + " ***");
        Scanner sc = new Scanner(reader);
        while (sc.hasNextLine())
            json += sc.nextLine();
        String[] record = json.split("\"");
        String webId = record[1];

        // write to new file as original text
        String originalText = "id~webId~category~year~make~model~trim~type~price~photo\n";
        for (int i = 5, j = 1; i < record.length; i += 4, j = j % 9 + 1) {
            if (j == 9)
                originalText += record[i] + "\n";
            else if (j == 2)
                // attach webId & make category to uppercase
                originalText += webId +  "~" + record[i].toLowerCase() + "~";
            else
                originalText += record[i] + "~";
        }
        System.out.println("*** Read ends ***");
        reader.close();

        // store json to new file "camino_restore.txt"
        File outputFile = new File("camino_restore.txt");
        FileWriter writer = new FileWriter(outputFile);
        System.out.println("*** Writing " + outputFile.getName() + " ***");
        writer.write(originalText);
        System.out.println("*** Write ends ***");
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("camino.txt");
        ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
        String s = getJsonString(vehicles);
        writeToFile(s, file.getParent());

        // test extra credit
        file = new File("camino_output.txt");
        writeTextFromJson(file);
    }
}
