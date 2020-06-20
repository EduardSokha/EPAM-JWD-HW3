package by.sokhaeduard.thirdhw.service.impl;


import java.util.List;
import java.util.Random;

import by.sokhaeduard.thirdhw.dao.DAOException;
import by.sokhaeduard.thirdhw.dao.DaoProvider;
import by.sokhaeduard.thirdhw.dao.ReaderDao;
import by.sokhaeduard.thirdhw.entity.Ball;
import by.sokhaeduard.thirdhw.entity.Basket;
import by.sokhaeduard.thirdhw.entity.Color;
import by.sokhaeduard.thirdhw.service.BasketService;
import by.sokhaeduard.thirdhw.service.ServiceException;

public class BasketServiceImpl implements BasketService {
	private ReaderDao readerDao;

	public BasketServiceImpl() {
		readerDao = DaoProvider.getInstance().getReaderDao();
	}

	@Override
	public int getWeightBallsInBasket() throws ServiceException {
		Basket fullBasket = getFullBasket();
		int weightBalls = 0;
		List<Ball> balls = fullBasket.getBalls();
		for (Ball ball : balls) {
			weightBalls += ball.getWeight();
		}
		return weightBalls;
	}

	@Override
	public int getNumberBallsInBasket() throws ServiceException {
		Basket fullBasket = getFullBasket();
		Integer numberBalls = 0;
		List<Ball> balls = fullBasket.getBalls();
		for (Ball ball : balls) {
			if (ball.getColor().toString().equals(Color.BLUE.toString())) {
				numberBalls++;
			}
		}
		return numberBalls;
	}

	private Basket getFullBasket() throws ServiceException {
		Basket bascket = null;
		List<Ball> allBalls = null;
		
		try {
			bascket = readerDao.getBascket();
			allBalls = readerDao.getAllBalls();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		
		int indexElement = new Random().nextInt(allBalls.size());

		while (bascket.addBall(allBalls.get(indexElement))) {
			indexElement = new Random().nextInt(allBalls.size());
		}

		return bascket;
	}

}
