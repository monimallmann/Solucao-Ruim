package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Data do check-in: ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data do check-out: ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Erro de reserva: Não é possível fazer o check-out em data anterior ao check-in.");
		} else {
			Reservation reservation = new Reservation(numQuarto, checkin, checkout);
			System.out.println("Reserva: " + reservation);

			System.out.println();
			System.out.println("Informe os dados atualizados da reserva: ");
			System.out.print("Check-in: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out: ");
			checkout = sdf.parse(sc.next());

			Date now = new Date();
			if (checkout.before(now) || checkin.before(now)) {
				System.out.println("Erro de reserva: Só é permitido fazer reservas em datas futuras.");
			}

			else if (!checkout.after(checkin)) {
				System.out.println("Erro de reserva: Não é possível fazer o check-out em data anterior ao check-in.");
			}

			else {
				reservation.atualizacao(checkin, checkout);
				System.out.println("Reserva: " + reservation);
			}
		}
		sc.close();

	}

}
