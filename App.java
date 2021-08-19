import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VitualKeyMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Virtual Key for Your Repositories");
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        FileManagerBOImpl FileManager = new FileManagerBOImpl("C:\\root");
        System.out.println("Application Name: Console File Manager");
        System.out.println("Developer Name: Jonas Ermert");
        System.out.println("2021");
        System.out.println("Simplilearn");
        do {
            System.out.println("File Menu");
            System.out.println("-------------------------");
            System.out.println("1)List Filenames");
            System.out.println("2)Manage Files");
            System.out.println("3)EXIT");
            System.out.println("-------------------------");
            System.out.print("Enter your choice: ");
            try {
                ch = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("only numbers allowed");
                continue;
            }
            System.out.println("-------------------------");
            switch (ch) {
                case 1:
                    System.out.println();
                    System.out.println("File List");
                    System.out.println();
                    String headers = String.format("%-50s | %-10s | %-50s | %s", "Name", "Length", "Parent", "Path");
                    System.out.println(headers);

                    List<FileDetail> Files = FileManager.getAllFiles();
                    Collections.sort(Files);
                    for (FileDetail filedetail : Files) {
                        System.out.println(filedetail.toString());
                    }
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    do {
                        System.out.println();
                        System.out.println();
                        System.out.println("Manage Files Menu");
                        System.out.println("-------------------------");
                        System.out.println("1)Add File");
                        System.out.println("2)Delete File");
                        System.out.println("3)Search FIle");
                        System.out.println("4)Exit to main");
                        System.out.println("-------------------------");
                        System.out.print("Enter your choice: ");

                        try {
                            ch = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("only numbers allowed");
                            continue;
                        }
                        System.out.println("-------------------------");
                        System.out.println();
                        System.out.println();
                        switch (ch) {
                            case 1:
                                System.out.print("Enter Filename: ");
                                String newFile = scanner.nextLine();

                                System.out.println();
                                System.out.println();
                                try {
                                    FileDetail filedetail = FileManager.createFile(newFile);
                                    System.out.println(filedetail.toString());

                                } catch (AlphaNumericOnly e) {
                                    System.out.println(e.getMessage());
                                }

                                catch (SecurityException e) {
                                    System.out.println("Please provide access to C:\\");
                                    System.exit(0);
                                }

                                catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }

                                break;
                            case 2:
                                System.out.print("Enter Filename: ");
                                String fileToDelete = scanner.nextLine();
                                System.out.println();
                                try {
                                    FileManager.deleteFile(fileToDelete);
                                } catch (FileNameNotFoundException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                break;

                            case 3:
                                System.out.print("Enter Filename: ");
                                String fileTosearch = scanner.nextLine();
                                System.out.println();
                                if (FileManager.deleteFile(fileTosearch)) {
                                    System.out.println("File found");
                                } else {
                                    System.out.println("File not found");
                                }
                                break;
                            case 4:
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid option Try again");
                                break;
                        }
                    } while (ch != 4);
                    break;

                case 3:
                    System.out.println("Thank you for using our app");
                    break;

                default:
                    System.out.println("Invalid option Try again");
                    break;
            }
        } while (ch != 3);

    }

}
