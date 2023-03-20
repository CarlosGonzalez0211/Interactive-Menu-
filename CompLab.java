import java.io.File;
import java.io.FileNotFoundException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

import javax.swing.SpringLayout;

public class CompLab {

    public static void main(String[] args) throws FileNotFoundException {

        // Carlos Gonzalez
        // [ Comprehensive Lab 1
        // This work is to be done individually. It is not permitted to.
        // share, reproduce, or alter any part of this assignment for any
        // purpose. Students are not permitted from sharing code, uploading
        // this assignment online in any form, or viewing/rece iving/
        // modifying code written from anyone else. This assignment is part.
        // of an academic course at The University of Texas at El Paso and
        // a grade will be assigned for the work produced individually by
        // the student.

        String source = "food 1.txt";
        File dataFile = new File(source); // File declaration

        Scanner input = new Scanner(System.in);
        Scanner fileInput = new Scanner(dataFile); // File reading

        int foodAmount = 0;
        int foodTotal = 0;
        double subTotal = 0;
        double total = 0;
        double tax = 7.25;

        while (true) {

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("WELCOME TO UTEP EATS");
            System.out.println("=====================");
            System.out.println("1. Add a food");
            System.out.println("2. View order");
            System.out.println("3. Clear order");
            System.out.println("4. Checkout");
            System.out.println("5. Exit UTEP Eats");
            System.out.println("=====================");

            System.out.println("Please make a selection: ");
            int selection = input.nextInt();

            switch (selection) {

                case 1:

                    while (fileInput.hasNext()) {

                        // here we are printing the list with those foods of 2 words together, so it's
                        // the job of future
                        // carlos to find out how to do it with a space
                        // maybe reading it backwards
                        String product = fileInput.next();
                        Float price = fileInput.nextFloat();
                        System.out.println(product + " $" + price);

                    }

                    while (true) {

                        fileInput = new Scanner(dataFile); // File reading

                        System.out.println("Make a food selection:");
                        String foodSelection = input.next();

                        while (fileInput.hasNextLine()) {

                            String product = fileInput.next();
                            Double price = fileInput.nextDouble();

                            if (product.equalsIgnoreCase(foodSelection)) {

                                System.out.println("how many " + foodSelection + " do you want?");
                                foodAmount = input.nextInt();

                                foodTotal += foodAmount;
                                subTotal = foodAmount * price;
                                total += foodAmount * price;
                                break;

                            } else if (!product.equalsIgnoreCase(foodSelection)) {
                                System.out.println("Invalid input. Please Try again");
                                break;
                            }

                        }

                        fileInput = new Scanner(dataFile); // File reading
                        System.out.println("============================");
                        System.out.println("Subtotal of your order: " + subTotal);
                        System.out.println("============================");
                        break;
                    }

                case 2:
                    System.out.println("=========Cart=========");
                    System.out.println("Number of items: " + foodTotal);
                    System.out.println("Total: $" + total);
                    System.out.println("======================");
                    break;

                case 3:
                    System.out.println("======================");
                    System.out.println("Are you sure you want to clear your order? Y/N");
                    String clearOrder = input.next();

                    if (clearOrder.equalsIgnoreCase("Y")) {
                        foodTotal = 0;
                        total = 0;
                        System.out.println("Number of items: " + foodTotal);
                        System.out.println("Total: " + total);
                        System.out.println("The cart has been cleaned");

                    } else if (clearOrder.equalsIgnoreCase("N")) {
                        System.out.println("The cart will be the same");
                    }
                    System.out.println("=====================");
                    break;

                case 4:

                    System.out.println("=======Checkout=======");
                    System.out.println("Number of items:" + foodTotal);
                    System.out.println("Total: $" + total);
                    System.out.println("Tax: " + tax + "%");
                    total = ((tax / 100) * total + total);
                    System.out.println("Total including taxes: $" + total);

                    System.out.println("Type 1 for pickup or type 2 for delivery");
                    int pickOrDeli = input.nextInt();

                    if (pickOrDeli == 2) {

                        System.out.println("Please enter your adress: ");
                        String address = input.next();

                        System.out.println("This wil add $5.00 to you total ");
                        total += 5.00;
                        System.out.println("Your total will be: $" + total);
                        System.out.println("Would you like to add a tip? Y/N");
                        String tipChoice = input.next();

                        input = new Scanner(System.in);

                        if (tipChoice.equalsIgnoreCase("Y")) {

                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println("What percentage of your order would you like to give as a tip?");
                            double tip = input.nextDouble();

                            total = ((tip / 100) * total + total);

                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println("Your total will be: $" + total);

                        }

                    }

                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Please enter your 16 digit card numbers: ");
                    String cardNum = input.next();

                    while (cardNum.length() != 16) {

                        System.out.println(" ");
                        System.out.println("Invalid card number");
                        System.out.println(" ");
                        System.out.println("Please enter your 16 digit card numbers: ");
                        cardNum = input.next();

                    }

                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Your purchase was successful!");
                    System.out.println("Thank you for shopping with UTEP Eats");
                    System.out.println(" ");
                    System.out.println("========Receipt========");
                    System.out.println("Number of items: " + foodTotal);
                    System.out.println("Total: " + total);
                    System.out.println(" ");

                    System.out.println("=====================================");
                    System.out.println("Thank you for using UTEP Eats. Good bye!");
                    System.out.println("=====================================");

                    foodTotal = 0;
                    total = 0;
                    break;

                case 5:
                    System.out.println("=====================================");
                    System.out.println("Thank you for using UTEP Eats. Good bye!");
                    System.out.println("=====================================");
                    break;

                default:
                    System.out.println("Invalid Input, type only a value between 1 and 5");
            }

        }
    }

}