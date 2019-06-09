package com.studentapp.gradesapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class Application {
    static Scanner scan;
    static Scanner scanS;
    static boolean on;
    static String fileLocation1 = "/Users/garyknapik/Downloads/Project/Appfolder";
    public static List<String> results = new ArrayList<String>();

    static {
        scan = new Scanner(System.in);
        scanS = new Scanner(System.in);
        on = true;
    }

    Application() throws IOException {
        menu();
    }

    static void menu() throws IOException {
        while(on) {
            path();
            System.out.println("\n0. Change File Location \n1. Enter New Student\n2. Enter Grades\n3. Calculate Class Average\n4. Calculate Min and Max Grades\n5. Exit Application");

            while(!scan.hasNextInt()) {
                System.out.println("Please enter integer command");
                scan.nextLine();
            }

            int choice = scan.nextInt();
            switch(choice) {
                case 0:
                    fileConfig();
                    break;
                case 1:
                    createStudent();
                    break;
                case 2:
                    enterGrade();
                    break;
                case 3:
                    calcAvg();
                    break;
                case 4:
                    minMax();
                    break;
                case 5:
                    System.out.println("Thanks for using this application!");
                    on = false;
                    break;
                default:
                    System.out.println("Please enter between 1 and 5: ");
            }
            results.clear();
        }

    }

    static void fileConfig()  {
        boolean what = true;
        System.out.println("Current file location: "+ fileLocation1);


        System.out.println("Would you like to change file location?\n1. Yes\n2. No");

        while (what) {

            while(!scan.hasNextInt()) {
                System.out.println("Please enter integer command");
                scan.nextLine();
            }

            int choice1 = scan.nextInt();

            if (choice1 == 1) {

                System.out.println("Enter file location: ");

                while (!scanS.hasNext()) {
                    System.out.println("Enter file location: ");
                    scanS.nextLine();
                }

                fileLocation1 = scanS.nextLine();
                what = false;
            } else {
                what = false;
            }

        }

        System.out.println("Application will work with "+fileLocation1);

    }

    static void createStudent() throws IOException {
        System.out.println("Enter student name: ");
        String tempName = scanS.nextLine();

        System.out.println("Enter student email: ");
        String tempEmail = scanS.nextLine();
        while(!emailCheck(tempEmail)){
            System.out.println("Invalid email address.");
            tempEmail = scanS.nextLine();
        }

        new Student(tempName, tempEmail);
        System.out.println("Student " + tempName + " has been created.");
        writeToF(tempName, tempEmail);
    }

    static boolean emailCheck(String email) {
        System.out.println("Enter student email: ");

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return  matcher.matches();
    }

    static void enterGrade()  {
        List<String> arr = new ArrayList();
        boolean check = true;
        String sName = "";

        while(check) {
            System.out.println("Enter student name");
            sName = scanS.nextLine();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileLocation1+ "/" + sName + ".txt"));

                String line;
                while((line = reader.readLine()) != null) {
                    arr.add(line);
                }

                check = false;
            } catch (Exception var10) {
                System.out.println("Can't read it");
            }
        }

        System.out.println(arr);
        System.out.println("Enter Java Grade: ");
        int javag = scanS.nextInt();
        System.out.println("Enter SQL Grade: ");
        int sqlg = scanS.nextInt();
        System.out.println("Enter JSP Grade: ");
        int jspg = scanS.nextInt();
        System.out.println("Enter Spring Grade: ");
        int sprg = scanS.nextInt();

        try {
            writeToF(sName, (String)arr.get(1), javag, sqlg, jspg, sprg);
            System.out.println("Successfully written");
        } catch (Exception var9) {
            System.out.println("Couldn't write to file");
        }

    }

    static void calcAvg() {
        boolean ch = true;

        while(true) {
            while(ch) {
                System.out.println("Which Subject?\n1.Java\n2.SQL\n3.JSP\n4.Spring\n5.Leave");

                while(!scan.hasNextInt()) {
                    System.out.println("Please enter integer command");
                    scan.nextLine();
                }

                int choice1 = scan.nextInt();
                double avg;
                int count = 0;
                int total = 0;
                switch(choice1) {
                    case 1:
                        for (int yes : returnAllArray(2)){
                            total += yes;
                            count += 1;
                        }

                        if (count > 0) {
                            avg = total / count;
                            System.out.println("Java average: " + avg);
                        } else {
                            System.out.println("No scores found");
                        }
                        break;
                    case 2:
                        for (int yes : returnAllArray(3)){
                            total += yes;
                            count += 1;
                        }

                        if (count > 0) {
                            avg = total / count;
                            System.out.println("SQL average: " + avg);
                        } else {
                            System.out.println("No scores found");
                        }
                        break;
                    case 3:
                        for (int yes : returnAllArray(4)){
                            total += yes;
                            count += 1;
                        }

                        if (count > 0) {
                            avg = total / count;
                            System.out.println("JSP average: " + avg);
                        } else {
                            System.out.println("No scores found");
                        }
                        break;
                    case 4:
                        for (int yes : returnAllArray(5)){
                            total += yes;
                            count += 1;
                        }

                        if (count > 0) {
                            avg = total / count;
                            System.out.println("Spring average: " + avg);
                        } else {
                            System.out.println("No scores found");
                        }
                        break;
                    case 5:
                        System.out.println("See ya!");
                        ch = false;
                        break;
                    default:
                        System.out.println("Try a valid integer");
                }
            }

            return;
        }
    }

    static void minMax()  {


            while(true) {
                int count = 0;
                int min = 100;
                int max = 0;
                System.out.println("Which Subject?\n1.Java\n2.SQL\n3.JSP\n4.Spring\n5.Leave");

                while(!scan.hasNextInt()) {
                    System.out.println("Please enter integer command");
                    scan.nextLine();
                }

                int choice1 = scan.nextInt();

                switch(choice1) {
                    case 1:
                         for (int a :returnAllArray(2)){
                             if (max < a){
                                 max = a;
                             }
                             if (min > a){
                                 min = a;
                             }
                             count ++;
                         }
                        if (count > 0) {
                            System.out.println("Java Min: " + min);
                            System.out.println("Java Max: " + max);
                        } else {
                            System.out.println("No scores");
                        }
                        continue;
                    case 2:
                        for (int a :returnAllArray(3)){
                            if (max < a){
                                max = a;
                            }
                            if (min > a){
                                min = a;
                            }
                            count++;
                        }
                        if (count > 0) {
                            System.out.println("SQL Min: " + min);
                            System.out.println("SQL Max: " + max);
                        } else {
                            System.out.println("No scores");
                        }
                        continue;
                    case 3:
                        for (int a :returnAllArray(4)){
                            if (max < a){
                                max = a;
                            }
                            if (min > a){
                                min = a;
                            }
                            count++;
                        }
                        if (count > 0) {
                            System.out.println("JSP Min: " + min);
                            System.out.println("JSP Max: " + max);
                        } else {
                            System.out.println("No scores");
                        }
                        continue;
                    case 4:
                        for (int a :returnAllArray(5)){
                            if (max < a){
                                max = a;
                            }
                            if (min > a){
                                min = a;
                            }
                            count++;
                        }
                        if (count > 0) {
                            System.out.println("Spring Min: " + min);
                            System.out.println("Spring Max: " + max);
                        } else {
                            System.out.println("No scores");
                        }
                        continue;
                    case 5:
                        System.out.println("See ya!");
                        break;
                    default:
                        System.out.println("Try a valid integer");
                }


            return;
        }
    }

    static void writeToF(String name, String email, int java, int sql, int jsp, int spring) throws IOException {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fileLocation1 +"/" + name + ".txt"));
            bw.write(name + "\n");
            bw.write(email + "\n");
            bw.write(java + "\n");
            bw.write(sql + "\n");
            bw.write(jsp + "\n");
            bw.write(spring + "\n");
        } catch (Exception var8) {
            System.out.println("Error in writing to file!");
        }

        bw.flush();
        bw.close();
    }

    static void writeToF(String name, String email) throws IOException {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fileLocation1 + "/" + name + ".txt"));
            bw.write(name + "\n");
            bw.write(email + "\n");
        } catch (Exception var4) {
            System.out.println("Error in writing to file!");
        }

        bw.flush();
        bw.close();
    }

    static void path() {
        // This method creates the arraylist of all files in chosen directory
         File[] files = new File(fileLocation1).listFiles(new FilenameFilter() {
             public boolean accept(File dir, String name) {
                 return !name.equals(".DS_Store");}});
                 //If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
        if (file.isFile()) {
            results.add(file.getName());
            }
         }

        System.out.print(results);
    }

    static List<Integer> returnAllArray(int x){
        //java iterate through and take line 3 of every file from arraylist results, add them together
        List <String> readfile = new ArrayList<String>();
        List <Integer> allArray = new ArrayList<Integer>();

        String line;


        try {
            for (String a : results){
                FileInputStream fstream = new FileInputStream(fileLocation1+"/"+a);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                while ((line = br.readLine()) != null)   {
                    readfile.add(line);
                }
                in.close();

                if (readfile.size() > x) {
                    allArray.add(Integer.parseInt(readfile.get(x)));
                }
                readfile.clear();

            }

            } catch (Exception var10) {
                System.out.println("Mistakes were made");
            }

        return allArray;
    }



}