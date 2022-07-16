package Transactions;

import Accounts.Account;
import Accounts.Debit;
import Accounts.Deposit;
import Clients.Client;
import Exceptions.ChoiceException;
import Exceptions.MoneyException;
import Exceptions.TimeDepositException;

import java.util.List;

public class AddTransaction implements  ITransaction {

    public int id;
    public int accid;
    public int choice;
    public double money;

    public AddTransaction(int id, int accid, int choice, double money){
        this.id = id;
        this.choice=choice;
        this.accid = accid;
        this.money = money;
    }


    public Client Undo(Client client) throws MoneyException, ChoiceException, TimeDepositException {
        client.WithDraw(choice, accid, money);
        return client;
    }
}
