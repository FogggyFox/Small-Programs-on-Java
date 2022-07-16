import Exceptions.*;

import java.util.Scanner;

public class oop5 {
    public static void main(String[] args) {
        int accid = 0;
        int choice = 0;
        int accid2 = 0;
        int choice2 = 0;
        int clid;
        int bankid;
        double money = 0;
        int time = 365;
        BankManager bm = new BankManager();
        bm.AddBank("Sberbank", 3, 4.5, 200, -5000, 3000);
        bm.AddBank("Alfabank", 2.5, 6.5, 250, -7000, 3500);
        bm.addClientToBank(1, "Gena", "Bukin");
        bm.addClientToBank(1, "Maria", "Kovaleva");
        bm.addClientToBank(2, "Andrey", "Chursin");
        bm.addAddress(1, 1, "Moscow");
        bm.addPassport(1, 1, "123456");
        bm.addAddress(2, 1, "Saratov");
        bm.addAddress(2, 1, "122345");
        bm.addCredit(1, 1, 60000);
        bm.addCredit(1, 2, 30000);
        bm.addCredit(2, 1, 60000);
        bm.addDebit(1, 1, 70000);
        bm.addDebit(1, 2, 40000);
        bm.addDebit(2, 1, 70000);
        bm.addDeposit(1, 1, 80000, 365);
        bm.addDeposit(1, 2, 30000, 500);
        bm.addDeposit(2, 1, 80000, 365);
        int quit1 = 0;
        Scanner in = new Scanner(System.in);
        while (quit1 == 0) {
            System.out.println("Меню:\n 1.Посмотреть все банки.\n 2.Зайти в банк \n 3.Добавить банк \n 4. Перемотать время \n 0. Выйти");
            int m1;
            try {
                m1 = in.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input");
                continue;
            }
            switch (m1) {
                case (1):
                    bm.ViewBanks();
                    break;
                case (2):
                    bm.ViewBanks();
                    System.out.println("Введите id нужного банка");
                    try {
                        bankid = in.nextInt();
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    int quit2 = 0;
                    while (quit2 == 0) {
                        bm.InfoBank(bankid);
                        System.out.println("Меню: \n 1.Посмотреть всех клиентов банка. \n 2. Посмотреть информацию о клиенте. \n3. Добавить клиента \n 0. Назад");
                        int m2;
                        try {
                            m2 = in.nextInt();
                        } catch (Exception e) {
                            System.out.println("Wrong input");
                            continue;
                        }
                        switch (m2) {
                            case (1):
                                bm.viewClients(bankid);
                                break;
                            case (2):
                                bm.viewClients(bankid);
                                System.out.println("Введите id нужного клиента");
                                try {
                                    clid = in.nextInt();
                                } catch (Exception e) {
                                    System.out.println("Wrong input");
                                    continue;
                                }
                                int quit3 = 0;
                                while (quit3 == 0) {
                                    bm.InfoClient(bankid, clid);
                                    System.out.println("Меню:");
                                    System.out.println("1.Добавить счет:");
                                    System.out.println("2.Посмотреть счета");
                                    System.out.println("3.Положить деньги на счет");
                                    System.out.println("4.Снять деньги со счета");
                                    System.out.println("5.Перевести деньги с одного счета на другой");
                                    System.out.println("6. Отменить последнюю операцию");
                                    System.out.println("7. Проверить доверие клиенту");
                                    System.out.println("8. Добавить доп.данные");
                                    System.out.println("0. Назад");
                                    int m3 = 0;
                                    try {
                                        m3 = in.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("Wrong input");
                                    }
                                    switch (m3) {
                                        case (1):
                                            System.out.println("Какой счет вы хотите добавить?");
                                            System.out.println("1.Дебетовый\n2.Депозит\n3.Кредитный\n0.Назад");
                                            int m4 = 0;
                                            try {
                                                m4 = in.nextInt();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            switch (m4) {
                                                case (1):
                                                    System.out.println("Введите деньги с которыми вы хотите стартовать счет");
                                                    try {
                                                        money = in.nextDouble();
                                                    } catch (Exception e) {
                                                        System.out.println("Wrong input");
                                                    }
                                                    bm.addDebit(bankid, clid, money);
                                                    break;
                                                case (2):
                                                    System.out.println("Введите деньги с которыми вы хотите стартовать счет");
                                                    try {
                                                        money = in.nextDouble();
                                                        System.out.println("Введите срок вашего депозита");
                                                        time = in.nextInt();
                                                    } catch (Exception e) {
                                                        System.out.println("Wrong input");
                                                    }
                                                    bm.addDeposit(bankid, clid, money, time);
                                                    break;
                                                case (3):
                                                    System.out.println("Введите деньги с которыми вы хотите стартовать счет");
                                                    try {
                                                        money = in.nextDouble();
                                                    } catch (Exception e) {
                                                        System.out.println("Wrong input");
                                                    }
                                                    bm.addCredit(bankid, clid, money);
                                                default:
                                                    break;
                                            }
                                            break;
                                        case (2):
                                            bm.viewAccounts(bankid, clid);
                                            break;
                                        case (3):
                                            bm.viewAccounts(bankid, clid);
                                            System.out.println("В какой счет вы хотите внести средства?");
                                            System.out.println("1.Дебетовый\n2.Депозит\n3.Кредитный\n0.Назад");
                                            try {
                                                choice = in.nextInt();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            if (choice == 0) break;
                                            System.out.println("Введите id нужного аккаунта");
                                            try {
                                                accid = in.nextInt();
                                                System.out.println("Введите ваши средства");
                                                money = in.nextDouble();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            try {
                                                bm.AddMoney(bankid, clid, choice, accid, money);
                                            } catch (MoneyException | ChoiceException | TimeDepositException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case (4):
                                            bm.viewAccounts(bankid, clid);
                                            System.out.println("С какого счета вы хотите снять средства?");
                                            System.out.println("1.Дебетовый\n2.Депозит\n3.Кредитный\n0.Назад");
                                            try {
                                                choice = in.nextInt();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            if (choice == 0) break;
                                            System.out.println("Введите id нужного аккаунта");
                                            try {
                                                accid = in.nextInt();
                                                System.out.println("Введите нужные средства");
                                                money = in.nextDouble();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            try {
                                                bm.WithDraw(bankid, clid, choice, accid, money);
                                            } catch (MoneyException | ChoiceException | TimeDepositException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case (5):
                                            bm.viewAccounts(bankid, clid);
                                            System.out.println("С какого счета вы хотите снять средства?");
                                            System.out.println("1.Дебетовый\n2.Депозит\n3.Кредитный\n0.Назад");
                                            try {
                                                choice = in.nextInt();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            if (choice == 0) break;
                                            System.out.println("Введите id нужного аккаунта");
                                            try {
                                                accid = in.nextInt();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            bm.viewAccounts(bankid, clid);
                                            System.out.println("На какой счет вы хотите внести средства?");
                                            System.out.println("1.Дебетовый\n2.Депозит\n3.Кредитный");
                                            try {
                                                choice2 = in.nextInt();
                                                System.out.println("Введите id нужного аккаунта");
                                                accid2 = in.nextInt();
                                                System.out.println("Введите ваши средства");
                                                money = in.nextDouble();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            try {
                                                bm.Transfer(bankid, clid, choice, accid, choice2, accid2, money);
                                            } catch (MoneyException | ChoiceException | TimeDepositException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case (6):
                                            try {
                                                bm.Cancel(bankid, clid);
                                            } catch (MoneyException | CancelException | TimeDepositException | ChoiceException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case (7):
                                            bm.CheckClient(bankid, clid);
                                            break;
                                        case (8):
                                            System.out.println("1.Добавить адрес\n2.Добавить паспорт\n0.Назад");
                                            int m5 = 0;
                                            try {
                                                m5 = in.nextInt();
                                            } catch (Exception e) {
                                                System.out.println("Wrong input");
                                            }
                                            if (m5 == 1) {
                                                System.out.println("Введите адрес");
                                                String address = in.next();
                                                bm.addAddress(bankid, clid, address);
                                            } else if (m5 == 2) {
                                                System.out.println("Введите паспорт");
                                                String passport = in.next();
                                                bm.addAddress(bankid, clid, passport);
                                            }
                                            break;
                                        case (0):
                                            quit3 = 1;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                            case (3):
                                System.out.println("Введите имя клиента");
                                String name = in.next();
                                System.out.println("Введите фамилию клиента");
                                String surname = in.next();
                                bm.addClientToBank(bankid, name, surname);
                                break;
                            case (0):
                                quit2 = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case (3):
                    System.out.println("Напишите название банка");
                    String name = in.next();
                    double debitpercent = 0;
                    double depositpercent = 0;
                    double creditcom = 0;
                    double creditlim = 0;
                    double checklim = 0;
                    try {
                        System.out.println("Дебитовый процент на остаток:");
                        debitpercent = in.nextDouble();
                        System.out.println("Депозитный процент на остаток:");
                        depositpercent = in.nextDouble();
                        System.out.println("Кредитная комиссия:");
                        creditcom = in.nextDouble();
                        System.out.println("Кредитный лимит:");
                        creditlim = in.nextDouble();
                        System.out.println("Предел снятия денег или перевода для сомнительных клиентов:");
                        checklim = in.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                    }
                    bm.AddBank(name, debitpercent, depositpercent, creditcom, creditlim, checklim);
                    break;
                case (4):
                    System.out.println("Введите кол-во суток на которые вы хотите перевести время");
                    try {
                        time = in.nextInt();
                    } catch (Exception e) {
                        System.out.println("wrong input");
                    }
                    try {
                        bm.Time(time);
                    } catch (TimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case (0):
                    quit1 = 1;
                    break;
                default:
                    break;
            }
        }
    }
}
