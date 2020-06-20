package by.sokhaeduard.thirdhw.service;

import by.sokhaeduard.thirdhw.service.impl.BasketServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private final BasketService basketService = new BasketServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public BasketService getBasketService() {
		return basketService;
	}
}
