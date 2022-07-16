import Exceptions.CancelException;
import Exceptions.ChoiceException;
import Exceptions.MoneyException;
import Exceptions.TimeDepositException;
import Clients.*;
import java.util.ArrayList;
import java.util.List;
public class Bank {
    public int id;
    public String name;
    public double debitpercent;
    public double depositpercent;
    public double creditcomission;
    public double creditlimit;
    public double checklim;
    List<Client> clients = new ArrayList<>();
    public Bank(int id, String name, double debitpercent, double depositpercent, double creditcomission, double creditlimit, double checklim) {
        this.id = id;
        this.name = name;
        this.debitpercent = debitpercent;
        this.depositpercent = depositpercent;
        this.creditcomission = creditcomission;
        this.creditlimit = creditlimit;
        this.checklim = checklim;
    }
    public void InfoBank() {
        System.out.println("Название банка:" + name);
        System.out.println("Дебитовый процент на остаток:" + debitpercent);
        System.out.println("Депозитный процент на остаток: меньше 50000 " + (depositpercent - 0.5) + ", меньше 100000 " + depositpercent);
        System.out.println("больше 100000 " + (depositpercent + 0.5));
        System.out.println("Кредитная комиссия:" + creditcomission);
        System.out.println("Кредитный лимит:" + creditlimit);
        System.out.println("Предел снятия денег или перевода для сомнительных клиентов:" + checklim);
    }
    public void InfoClient(int id) {
        clients.get(id -1).ClientInfo();
    }
    public void addClient(String name, String surname) {
        clients.add(new Client(clients.size() + 1, name, surname, checklim));
    }
    public void viewClients() {
        System.out.println("Clients");
        for (Client item : clients) {
            System.out.println(item.id + "." + item.surname + " " + item.name);
        }
    }
    public void addDepositToClient(int id, double money, int time) {
        clients.get(id - 1).AddDeposit(money, time, depositpercent);
    }
    public void addDebitToClient(int id, double money) {
        clients.get(id - 1).AddDebit(money, debitpercent);
    }
    public void addCreditToClient(int id, double money) {
        clients.get(id - 1).AddCredit(money, creditcomission, creditlimit);
    }
    public void addAddressToClient(int id, String address) {
        clients.get(id - 1).addAddress(address);
    }
    public void addPassportToClient(int id, String passport) {
        clients.get(id - 1).addPassport(passport);
    }
    public void viewClientAccounts(int id) {
        clients.get(id - 1).viewAccs();
    }
    public void AddMoney(int id, int choice, int accid, double money) throws MoneyException, ChoiceException, TimeDepositException {
        clients.get(id - 1).AddMoney(choice, accid, money);
    }
    public void WithDraw(int id, int choice, int accid, double money) throws MoneyException, ChoiceException, TimeDepositException {
        clients.get(id - 1).WithDraw(choice, accid, money);
    }
    public void Transfer(int id, int choice1, int accid1, int choice2, int accid2, double money) throws MoneyException, ChoiceException,
            TimeDepositException {
        clients.get(id - 1).TransferMoney(choice1, accid1, choice2, accid2, money);
    }
    public void Cancel(int id) throws MoneyException, CancelException, TimeDepositException, ChoiceException {
        clients.get(id - 1).Cancel(3);
    }
    public void Time(int time) {
        for (Client item : clients) {
            item.Time(time);
        }
    }
    public void CheckClient(int id) {
        clients.get(id - 1).CheckClient();
    }
}
