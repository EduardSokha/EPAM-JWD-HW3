package by.sokhaeduard.thirdhw.dao;

import java.util.List;

import by.sokhaeduard.thirdhw.entity.Ball;
import by.sokhaeduard.thirdhw.entity.Basket;

public interface ReaderDao {

	List<Ball> getAllBalls() throws DAOException;

	Basket getBascket() throws DAOException;
}
