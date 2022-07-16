package Clients;

import Accounts.Credit;
import Accounts.Debit;
import Accounts.Deposit;
import Exceptions.CancelException;
import Exceptions.ChoiceException;
import Exceptions.MoneyException;
import Exceptions.TimeDepositException;
import Transactions.AddTransaction;
import Transactions.ITransaction;
import Transactions.TransferTransaction;
import Transactions.WithDrawTransaction;

import java.util.ArrayList;
import java.util.List;
public class Client {
    public int id;
    public String name;
    public String surname;
    public String address = "";
    public String passport = "";
    double checkLimit;

    List<Debit> debits = new ArrayList<>();
    List<Deposit> deposits = new ArrayList<>();
    List<Credit> credits = new ArrayList<>();
    List<ITransaction> transactions= new ArrayList();
    public Client(int id, String name, String surname, double checklim) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.checkLimit = checklim;
    }
    public void addAddress(String address) {
        this.address = address;
    }
    public void addPassport(String passport) {
        this.passport = passport;
    }
    public void AddDeposit(double money, int time, double percent) {
        deposits.add(new Deposit(deposits.size() + 1, money, time, percent));
    }
    public void AddDebit(double money, double percent) {
        debits.add(new Debit(debits.size() + 1, money, percent));
    }
    public void AddCredit(double money, double commission, double limit) {
        credits.add(new Credit(credits.size() + 1, money, commission, limit));
    }
    public void viewAccs() {
        System.out.println("Debits:");
        for (Debit item : debits) {
            System.out.println(item.id + ".Value:" + item.total);
        }
        System.out.println("Deposits:");
        for (Deposit item : deposits) {
            System.out.println(item.id + ".Value:" + item.total + ". Remained time:" + item.time);
        }
        System.out.println("Credits:");
        for (Credit item : credits) {
            System.out.println(item.id + ".Value:" + item.total);
        }
    }
    public void AddMoney(int choice, int accid, double money) throws TimeDepositException, MoneyException, ChoiceException {
        switch (choice) {
            case (1) -> {
                if (accid <= 0 || accid > debits.size()) throw new ChoiceException("Unavailable choice");
                if (debits.get(accid - 1).total < 0) throw new MoneyException("This account is unavailable");
                debits.get(accid - 1).Plus(money);
            }
            case (2) -> {
                if (accid <= 0 || accid > deposits.size()) throw new ChoiceException("Unvaailable choice");
                deposits.get(accid - 1).Plus(money);
            }
            case (3) -> {
                if (accid <= 0 || accid > credits.size()) throw new ChoiceException("Unavailable choice");
                if (credits.get(accid - 1).total < credits.get(accid - 1).limit)
                    throw new MoneyException("This account is unavailable");
                credits.get(accid - 1).Plus(money);
            }
            default -> throw new ChoiceException("Unavailable choice");
        }
        transactions.add(new AddTransaction(transactions.size()+1, choice,accid, money));
    }
    public void WithDraw(int choice, int accid, double money) throws TimeDepositException, MoneyException, ChoiceException {
        if (address.equals("") && passport.equals("") && money > checkLimit) {
            throw new MoneyException("You are a questionable customer. That's why you can't withdraw such a large amount");
        }
        switch (choice) {
            case (1) -> {
                if (accid <= 0 || accid > debits.size()) throw new ChoiceException("Unvailable choice");
                if (debits.get(accid - 1).total < 0) throw new MoneyException("This account is unavailable");
                debits.get(accid - 1).Minus(money);
            }
            case (2) -> {
                if (accid <= 0 || accid > deposits.size()) throw new ChoiceException("Unvailable choice");
                deposits.get(accid - 1).Minus(money);
            }
            case (3) -> {
                if (accid <= 0 || accid > credits.size()) throw new ChoiceException("Unvailable choice");
                if (credits.get(accid - 1).total < credits.get(accid - 1).limit)
                    throw new MoneyException("This account is unavailable");
                credits.get(accid - 1).Minus(money);
            }
            default -> throw new ChoiceException("Unvailable choice");
        }
        transactions.add(new WithDrawTransaction(transactions.size()+1, choice ,accid, money));
    }
    public void TransferMoney(int choice1, int accid1, int choice2, int accid2, double money) throws MoneyException, ChoiceException,
            TimeDepositException {
        if (address.equals("") && passport.equals("") && money > checkLimit) {
            throw new MoneyException("You are a questionable customer. That's why you can't withdraw such a large amount");
        }
        WithDraw(choice1, accid1, money);
        AddMoney(choice2, accid2, money);
        transactions.remove(transactions.get(transactions.size()-1));
        transactions.remove(transactions.get(transactions.size()-1));
        transactions.add(new TransferTransaction(transactions.size()+1, choice1 ,accid1, choice2, accid2, money));
    }
    public void Cancel(int transid) throws CancelException, MoneyException, ChoiceException, TimeDepositException {
        var transaction = transactions.get(transid);
        var client = transaction.Undo(this);
        this.debits=client.debits;
        this.deposits = client.deposits;
        this.credits = client.credits;
        this.transactions= client.transactions;
        transactions.remove(transaction);
    }
    public void Time(int time) {
        for (Debit item : debits) {
            item.Time(time);
        }
        for (Deposit item : deposits) {
            item.Time(time);
        }
        for (Credit item : credits) {
            item.Time(time);
        }
    }
    public void CheckClient() {
        if (address.equals("") || passport.equals("")) System.out.println("Client is questionable");
        else System.out.println("Client is normal");
    }
    public void ClientInfo() {
        System.out.println("Фамилия:" + surname);
        System.out.println("Имя:" + name);
        System.out.println("Адрес:" + address);
        System.out.println("Данные паспорта:" + passport);
    }
}
