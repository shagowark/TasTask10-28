package LogicModule;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Logic {
    public static ArrayList<Apartment> filterAparts(ArrayList<Apartment> apartsList, AdvertFilter filter){
        ArrayList<Apartment> goodAparts = new ArrayList<>();
        for (Apartment apart : apartsList) {
            if (filter.filter(apart)) {
                goodAparts.add(apart);
            }
        }
        return goodAparts;
    }

    public static ArrayList<Apartment> readApartsListFromFile(String fileName) throws Exception {
        ArrayList<Apartment> apartList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName), StandardCharsets.UTF_8);
        String line = "";
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line == null) {
                break;
            } else {
                apartList.add(parseLineIntoApartment(line));
            }
        }

        return apartList;
    }

    public static ArrayList<Apartment> readApartsListFromJtable(JTable table){
        ArrayList<Apartment> apartsList = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < table.getColumnCount(); j++){
                sb.append(table.getModel().getValueAt(i, j));
                sb.append(" ");
            }
            apartsList.add(Logic.parseLineIntoApartment(new String(sb)));
        }
        return apartsList;
    }

    public static Apartment parseLineIntoApartment(String line) {
        line.trim();
        String[] data = line.split(" ");
        Apartment apart = new Apartment();
        apart.setDistrict(data[0]);
        apart.setRoomsNumber(Integer.parseInt(data[1]));
        apart.setArea(Integer.parseInt(data[2]));
        apart.setKitchenArea(Integer.parseInt(data[3]));
        apart.setPrice(Integer.parseInt(data[4]));

        return apart;
    }


    public static void saveOutputIntoFile(String fileName, ArrayList<Apartment> apartsList) throws FileNotFoundException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Apartment apart : apartsList) {
                StringBuilder sb = new StringBuilder();
                sb.append(apart.getDistrict());
                sb.append(" ");
                sb.append(apart.getRoomsNumber());
                sb.append(" ");
                sb.append(apart.getArea());
                sb.append(" ");
                sb.append(apart.getKitchenArea());
                sb.append(" ");
                sb.append(apart.getPrice());

                String currentApart = new String(sb);


                writer.write(currentApart + "\n");
                writer.flush();

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void saveOutputIntoFile(String fileName, String str) throws Exception {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(str);
            writer.flush();
        } catch (Exception e) {
        System.err.println(e);
        }
    }

    public static void checkIfArrayListIsNull(ArrayList<Apartment> aparts) throws Exception {
        if (aparts == null) {
            throw new Exception("Такой input-файл не существует");
        }
    }


    public static void checkIfArrayListIsEmpty(ArrayList<Apartment> aparts) throws NoSuchElementException{
        if (aparts.size() == 0) {
            throw new NoSuchElementException("Пустой массив");
        }
    }

}
