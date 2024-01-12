package com.jonatasmateus.desafio;

import com.jonatasmateus.desafio.entities.Order;
import com.jonatasmateus.desafio.services.OrderService;
import com.jonatasmateus.desafio.services.ShippingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {

		SpringApplication.run(DesafioApplication.class, args);

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("\nENTRADA (dados do pedido)");
		System.out.print("Código: ");
		Integer code = sc.nextInt();
		System.out.print("Valor: ");
		Double basic = sc.nextDouble();
		System.out.print("Porcentagem de desconto: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		OrderService orderService = new OrderService(new ShippingService());
		double total = orderService.total(order);

		System.out.println("\nSAÍDA");
		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: " + total);
	}

}
