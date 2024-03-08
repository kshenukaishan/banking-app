package dao;

import dao.custom.impl.AccountDaoImpl;
import dao.custom.impl.ClientDaoImpl;
import dao.custom.impl.UserDaoImpl;

public class DaoFactory {

    private DaoFactory daoFactory;

    private DaoFactory() {
    }

    public enum DaoType {
        ACCOUNT, USER, CLIENT
    }

    public static <T> T getDao(DaoType daoType){
        switch (daoType){
            case ACCOUNT:
                return (T) new AccountDaoImpl();
            case USER:
                return (T) new UserDaoImpl();
            case CLIENT:
                return (T) new ClientDaoImpl();
            default:
                return null;
        }
    }
}
