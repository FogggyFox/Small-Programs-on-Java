package Accounts;

import Exceptions.MoneyException;
import Exceptions.TimeDepositException;

public interface Account {
    void Time(int time);

    void Plus(double money) throws MoneyException, TimeDepositException;

    void Minus(double money) throws MoneyException, TimeDepositException;
}
