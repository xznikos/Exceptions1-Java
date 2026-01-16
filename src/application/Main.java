package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        try (Scanner sc = new Scanner(System.in)) {

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {

                System.out.print("Room number: ");
                int number = sc.nextInt();

                System.out.print("Check-in date (dd/MM/yyyy): ");
                LocalDate checkin = LocalDate.parse(sc.next(), fmt);

                System.out.print("Check-out date (dd/MM/yyyy): ");
                LocalDate checkout = LocalDate.parse(sc.next(), fmt);

                Reservation reservation = new Reservation(number, checkin, checkout);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation: ");

                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkin = LocalDate.parse(sc.next(), fmt);

                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkout = LocalDate.parse(sc.next(), fmt);

                reservation.updateDate(checkin, checkout);
                System.out.println("Reservation: " + reservation);
            }

            catch (InputMismatchException e) {
                System.out.println("Invalid date format");
            }

            catch (DomainException e) {
                System.out.println("Error in reservation: " + e.getMessage());
            }

            catch (RuntimeException e) {
                System.out.println("Unexpected error");
            }
        }
    }
}
