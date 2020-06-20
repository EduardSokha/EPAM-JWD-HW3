package by.sokhaeduard.thirdhw.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private Integer volume;
	private Integer maxWeight;
	private List<Ball> balls;

	public Basket() {
	}

	public Basket(Integer volume, Integer maxWeight) {
		this.volume = volume;
		this.maxWeight = maxWeight;
		balls = new ArrayList<Ball>();
	}

	public boolean addBall(Ball ball) {
		boolean result = false;
		if (volume - ball.getVolume() > 0 && maxWeight - ball.getWeight() > 0) {
			balls.add(ball);
			volume -= ball.getVolume();
			maxWeight -= ball.getWeight();
			result = true;
		}
		return result;
	}

	public List<Ball> getBalls() {
		return balls;
	}
}
