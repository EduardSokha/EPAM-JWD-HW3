package by.sokhaeduard.thirdhw.dao;

import by.sokhaeduard.thirdhw.dao.impl.ReaderDaoImpl;

public final class DaoProvider {

	private static final DaoProvider instance = new DaoProvider();

	private final ReaderDao readerDao = new ReaderDaoImpl();

	private DaoProvider() {
	}

	public ReaderDao getReaderDao() {
		return readerDao;
	}

	public static DaoProvider getInstance() {
		return instance;
	}

}
