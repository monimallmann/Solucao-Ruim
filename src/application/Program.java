package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
		System.out.print("Quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Data do check-in: ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data do check-out: ");
		Date checkout = sdf.parse(sc.next());

		Reservation reservation = new Reservation(numQuarto, checkin, checkout);
		System.out.println("Reserva: " + reservation);

		System.out.println();
		System.out.println("Informe os dados atualizados da reserva: ");
		System.out.print("Check-in: ");
		checkin = sdf.parse(sc.next());
		System.out.print("Check-out: ");
		checkout = sdf.parse(sc.next());

		reservation.atualizacao(checkin, checkout);
		System.out.println("Reserva: " + reservation);
		
		}
		catch(ParseException e) {
			System.out.println("Formato inválido!");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: "+ e.getMessage());
		}
		sc.close();

	}

}
