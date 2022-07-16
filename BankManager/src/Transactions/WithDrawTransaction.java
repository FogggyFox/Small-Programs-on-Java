package Transactions;

import Accounts.Account;
import Clients.Client;
import Exceptions.ChoiceException;
import Exceptions.MoneyException;
import Exceptions.TimeDepositException;

public class WithDrawTransaction implements ITransaction {

    public int id;
    public int accid;
    public int choice;
    public double money;

    public WithDrawTransaction(int id, int accid, int choice, double money){
        this.id = id;
        this.choice=choice;
        this.accid = accid;
        this.money = money;
    }
    public Client Undo(Client client) throws MoneyException, ChoiceException, TimeDepositException {
        client.AddMoney(choice, accid, money);
        return client;
    }
}
