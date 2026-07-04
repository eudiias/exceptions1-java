package Application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

        try {
            System.out.print("Room number: ");
            number = sc.nextInt();
            sc.nextLine();

            System.out.print("Check-IN date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), formatter);

            System.out.print("Check-OUT date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), formatter);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.print("Check-IN date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), formatter);

            System.out.print("Check-OUT date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), formatter);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (DateTimeParseException e)
        {
            System.out.println("Invalid date Format");
        }
        catch (DomainException e)
        {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e)
        {
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}
