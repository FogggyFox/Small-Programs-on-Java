package Transactions;

import Clients.*;
import Exceptions.ChoiceException;
import Exceptions.MoneyException;
import Exceptions.TimeDepositException;


public interface ITransaction {
    int mark=0;
    int choice1 = 0;
    int accid1 = 0;
    int choice2 = 0;
    int accid2 = 0;
    double money = 0;
    int id = 0;
    int choice =0;
    int accid = 0;
    Client Undo(Client client) throws MoneyException, ChoiceException, TimeDepositException;

}
