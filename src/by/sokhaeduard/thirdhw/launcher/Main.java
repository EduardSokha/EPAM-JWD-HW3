package by.sokhaeduard.thirdhw.launcher;

import by.sokhaeduard.thirdhw.service.BasketService;
import by.sokhaeduard.thirdhw.service.ServiceException;
import by.sokhaeduard.thirdhw.service.ServiceProvider;

public class Main {
	public static void main(String[] args) {
		try {
			BasketService basketService = ServiceProvider.getInstance().getBasketService();
			int numberBallsInBasket = basketService.getNumberBallsInBasket();
			int weightBallsInBasket = basketService.getWeightBallsInBasket();
			System.out.println(numberBallsInBasket);
			System.out.println(weightBallsInBasket);

		} catch (ServiceException e) {
			System.out.println("File nor found, try later");
		}
	}
}
