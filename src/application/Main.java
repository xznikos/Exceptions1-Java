package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static void main() {
        try (Scanner sc = new Scanner(System.in)) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("Room number: ");
            int number = sc.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkin = LocalDate.parse(sc.next(), fmt);

            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkout = LocalDate.parse(sc.next(), fmt);

            if (!checkout.isAfter(checkin)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                Reservation reservation = new Reservation(number, checkin, checkout);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation: ");

                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkin = LocalDate.parse(sc.next(), fmt);

                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkout = LocalDate.parse(sc.next(), fmt);

                String error = reservation.updateDate(checkin, checkout);

                if (error != null) {
                    System.out.println("Error in reservation: " + error);
                }
                else {
                    System.out.println("Reservation: " + reservation);
                }

            }
        }
    }
}
