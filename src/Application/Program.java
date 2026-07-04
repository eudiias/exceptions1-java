package Application;

import entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int number;
        LocalDate checkIn, checkOut;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        number = sc.nextInt();
        sc.nextLine();

        System.out.print("Check-IN date (dd/MM/yyyy): ");
        checkIn = LocalDate.parse(sc.nextLine(), formatter);

        System.out.print("Check-OUT date (dd/MM/yyyy): ");
        checkOut = LocalDate.parse(sc.nextLine(), formatter);

        if (!checkOut.isAfter(checkIn))
        {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else
        {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.print("Check-IN date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), formatter);

            System.out.print("Check-OUT date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), formatter);

            LocalDate now = LocalDate.now();

            if (checkIn.isBefore(now) || checkOut.isBefore(now))
            {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.isAfter(checkIn))
            {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else
            {
                reservation.updateDates(checkIn,checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }


        sc.close();
    }
}
