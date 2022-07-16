import Exceptions.*;
import java.util.ArrayList;
import java.util.List;
public class BankManager {
    List<Bank> banks;
    public BankManager() {
        banks = new ArrayList<>();
    }
    public void AddBank(String name, double debitpercent, double depositpercent, double creditcomission, double creditlimit, double checklim) {
        banks.add(new Bank(banks.size() + 1, name, debitpercent, depositpercent, creditcomission, creditlimit, checklim));
    }
    public void ViewBanks() {
        System.out.println("Banks:");
        for (Bank item : banks) {
            System.out.println(item.id + "." + item.name);
        }
    }
    public void Time(int time) throws TimeException {
        if (time < 0) throw new TimeException("Time can't be negative");
        for (Bank item : banks) {
            item.Time(time);
        }
    }
    public void addClientToBank(int id, String name, String surname) {
        banks.get(id - 1).addClient(name, surname);
    }
    public void viewClients(int id) {
        banks.get(id - 1).viewClients();
    }
    public void addDeposit(int id, int clid, double money, int time) {
        banks.get(id - 1).addDepositToClient(clid, money, time);
    }
    public void addDebit(int id, int clid, double money) {
        banks.get(id - 1).addDebitToClient(clid, money);
    }
    public void addCredit(int id, int clid, double money) {
        banks.get(id - 1).addCreditToClient(clid, money);
    }
    public void addAddress(int id, int clid, String address) {
        banks.get(id - 1).addAddressToClient(clid, address);
    }
    public void addPassport(int id, int clid, String passport) {
        banks.get(id - 1).addPassportToClient(clid, passport);
    }
    public void viewAccounts(int id, int clid) {
        banks.get(id - 1).viewClientAccounts(clid);
    }
    public void AddMoney(int id, int clid, int choice, int accid, double money) throws MoneyException, ChoiceException,
            TimeDepositException {
        banks.get(id - 1).AddMoney(clid, choice, accid, money);
    }
    public void WithDraw(int id, int clid, int choice, int accid, double money) throws MoneyException, ChoiceException, TimeDepositException
    {
        banks.get(id - 1).WithDraw(clid, choice, accid, money);
    }
    public void Transfer(int id, int clid, int choice1, int accid1, int choice2, int accid2, double money) throws MoneyException, ChoiceException,
            TimeDepositException {
        banks.get(id - 1).Transfer(clid, choice1, accid1, choice2, accid2, money);
    }
    public void Cancel(int id, int clid) throws MoneyException, CancelException, TimeDepositException, ChoiceException {
        banks.get(id - 1).Cancel(clid);
    }
    public void CheckClient(int id, int clid) {
        banks.get(id - 1).CheckClient(clid);
    }
    public void InfoBank(int id) {
        banks.get(id - 1).InfoBank();
    }
    public void InfoClient(int id, int clid) {
        banks.get(id - 1).InfoClient(clid);
    }
}
