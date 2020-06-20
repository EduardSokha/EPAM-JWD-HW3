package by.sokhaeduard.thirdhw.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.sokhaeduard.thirdhw.dao.DAOException;
import by.sokhaeduard.thirdhw.dao.ReaderDao;
import by.sokhaeduard.thirdhw.entity.Ball;
import by.sokhaeduard.thirdhw.entity.Basket;
import by.sokhaeduard.thirdhw.entity.Color;

public class ReaderDaoImpl implements ReaderDao {

	@Override
	public List<Ball> getAllBalls() throws DAOException {
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		List<Ball> balls = new ArrayList<Ball>();
		String line = null;

		try {
			reader = new FileReader(FilePath.FILE_BALL);
			bufferedReader = new BufferedReader(reader);

			while ((line = bufferedReader.readLine()) != null) {
				balls.add(ballFactory(line));
			}

		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}

		return balls;
	}

	@Override
	public Basket getBascket() throws DAOException {
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		String line = null;
		Basket basket = null;
		try {
			reader = new FileReader(FilePath.FILE_BASKET);
			bufferedReader = new BufferedReader(reader);

			while ((line = bufferedReader.readLine()) != null) {
				basket = basketFactory(line);
			}

		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}

		return basket;
	}

	private Ball ballFactory(String line) {
		String[] parseLines = line.split("\\s+");
		Integer volume = Integer.parseInt(parseLines[0]);
		Integer weight = Integer.parseInt(parseLines[1]);
		Color color = Color.valueOf(parseLines[2]);
		Ball ball = new Ball(volume, weight, color);
		return ball;
	}

	private Basket basketFactory(String line) {
		String[] parseLines = line.split("\\s+");
		Integer volume = Integer.parseInt(parseLines[0]);
		Integer maxWeight = Integer.parseInt(parseLines[1]);
		Basket basket = new Basket(volume, maxWeight);
		return basket;
	}
}
