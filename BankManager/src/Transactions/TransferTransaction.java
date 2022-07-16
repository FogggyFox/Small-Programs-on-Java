package Transactions;

import Accounts.Account;
import Clients.Client;
import Exceptions.ChoiceException;
import Exceptions.MoneyException;
import Exceptions.TimeDepositException;

public class TransferTransaction implements ITransaction {
    public int choice1;
    public int accid1;
    public int choice2;
    public int accid2;
    public double money;
    public int id;

    public TransferTransaction(int id, int accid1, int choice1, int accid2, int choice2, double money){
        this.id = id;
        this.choice1=choice1;
        this.accid1 = accid1;
        this.choice2=choice2;
        this.accid2 = accid2;
        this.money = money;
    }


    public Client Undo(Client client) throws MoneyException, ChoiceException, TimeDepositException {
        client.WithDraw(choice1, accid1, money);
        client.AddMoney(choice2, accid2, money);
        return client;
    }
}
