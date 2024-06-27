package com.itheima;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    Account loginAccount = null;

    //    欢迎页面
    public void start() {
        while (true) {
            System.out.println("===Welcome U Into ATM System===");
            System.out.println("1. User Login");
            System.out.println("2. User Create A Account");
            System.out.println("Please choose: ");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                default:
                    System.out.println("There is no this choice~~");
            }
        }

    }

    public void createAccount() {
        // 完成用户开户操作
        // 创建一个账户对象，用于封装用户的开户信息
        System.out.println("===User Create A Account===");
        Account acc = new Account();

        // 需要用户输入自己的开户信息，赋值给账户对象
        System.out.println("Please Input Your Account Name: ");
        String name = sc.next();
        acc.setUserName(name);

        while (true) {
            System.out.println("Please Input Your Sex(male or female): ");
            String sex = sc.next();
            if (sex.equals("male") || sex.equals("female")) {
                acc.setSex(sex);
                break;
            } else {
                System.out.println("Wrong Input, Only male or female~");
            }
        }
        while (true) {
            System.out.println("Please Input Your Account PassWord: ");
            String passWord = sc.next();
            System.out.println("Please Input Your Confirm PassWord: ");
            String okPassWord = sc.next();
            if (passWord.equals(okPassWord)) {
                acc.setPassWord(passWord);
                break;
            } else {
                System.out.println("The PassWords Entered do not Match, Please Try again~");
            }
        }
        System.out.println("Please Input Your Cash Withdrawal Limit: ");
        Double limit = sc.nextDouble();
        acc.setLimit(limit);

        //生成卡号
        String newCardId = createCardId();
        acc.setCardID(newCardId);
        //创建账户
//        accounts.add(acc);
        System.out.println("Congratulate " + acc.getUserName() +
                " Create A Account Successfully, and Your Card Number is " + newCardId);
    }

    //用户登录
    private void login() {
        System.out.println("===ATM System Login===");
        boolean isLogin = true;
        boolean isPassWord = true;
        if (accounts.size() == 0) {
            System.out.println("There is no any Account");
            return;
        }
        while (isLogin) {
            System.out.println("Please Input Your Login CardId: ");
            String cardId = sc.next();
            Account acc = getAccountByCarId(cardId);
            if (acc == null) {
                System.out.println("Sorry!This User does not Exist");
                System.out.println("Do u Wanna Try again(yes or no)?: ");
                String ans = sc.next();
                if (ans.equals("yes")) {
                    isLogin = true;
                } else {
                    isLogin = false;
                }
            } else {
                while (isPassWord) {
                    System.out.println("Please Input Your PassWord: ");
                    String passWord = sc.next();
                    if (passWord.equals(acc.getPassWord())) {
                        loginAccount = acc;
                        System.out.println("Welcome " + acc.getUserName() + " enter ATM System "
                                + "And Your CardId is " + cardId);
                        showUserCommand();
                        return;
                    } else {
                        System.out.println("The PassWord is not Correct");
                        System.out.println("Do U Wanna Try again(yes or no)?: ");
                        String ans = sc.next();
                        if (ans.equals("yes")) {
                            isPassWord = true;
                        } else {
                            isPassWord = false;
                        }

                    }
                }
            }
        }

    }

    //操作界面
    private void showUserCommand() {
        boolean isShow = true;
        while (isShow) {
            System.out.println("U can Choose These Commands to Handle Account: ");
            System.out.println("1. Check");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Transfer");
            System.out.println("5. Change Password");
            System.out.println("6. Exit");
            System.out.println("7. Log Off");
            System.out.println("Please Choose: ");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    showLoginAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdrawal();
                    break;
                case 4:
                    tranferMoney();
                    break;
                case 5:
                    ChangePassword();
                    return;
                case 6:
                    System.out.println(loginAccount.getUserName() + ", U Log Out Successfully!");
                    return;
                case 7:
                    if(logoff()){
                        return;
                    }
                    break;
                default:
                    System.out.println("There is no this Command");
                    System.out.println("Do U Wanna Try again(yes or no): ");
                    String ans = sc.next();
                    if (ans.equals("yes")) {
                        isShow = true;
                    } else {
                        isShow = false;
                    }

            }
        }
    }

    private boolean logoff() {
        System.out.println("Are U sure wanna Log off this Account(yes/no)?");
        String ans = sc.next();
        if(ans.equals("yes")){
            if(loginAccount.getMoney()==0){
                accounts.remove(loginAccount);
                System.out.println("Log off Successfully!");
                return true;

            }else{
                System.out.println("Your Account still have Money, cant log off");
                return false;
            }
        }else{
            System.out.println("Your Account saved");
            return false;
        }
    }

    private void ChangePassword() {
        System.out.println("===Change Password===");
        while (true) {
            System.out.println("Please Input Your Older password: ");
            String oldPassword = sc.next();
            if (oldPassword.equals(loginAccount.getPassWord())) {
                while (true) {
                    System.out.println("Please Input Your New Password: ");
                    String newPassword = sc.next();
                    if (newPassword.equals(oldPassword)) {
                        System.out.println("The NewPassword is same as oldPassword");
                        System.out.println("Please Try Again");
                    } else {
                        System.out.println("Confirm Your newPassword: ");
                        String confirmNewPassword = sc.next();
                        if (confirmNewPassword.equals(newPassword)) {
                            loginAccount.setPassWord(newPassword);
                            System.out.println("Change Password Successfully!");
                            return;
                        } else {
                            System.out.println("Two Password are not match, Please Try again");
                        }
                    }
                }

            } else {
                System.out.println("Sorry, the Password is not Correct, Please Try Again");

            }
        }
    }


    //转账
    private void tranferMoney() {
        System.out.println("===Transfer Money===");
        if (accounts.size() < 2) {
            System.out.println("There is less than 2 users, cant Transfer");
            return;
        }
        if (loginAccount.getMoney() == 0) {
            System.out.println("Your Balance is empty, cant Transfer");
            return;
        }

        while (true) {
            System.out.println("Please Input CardId U wanna Transfer: ");
            String cardId = sc.next();
            Account acc = getAccountByCarId(cardId);
            if (acc == null) {
                System.out.println("Sorry, This User is not exist");
                System.out.println("Please Try again");
            } else {
                String name = "*" + acc.getUserName().substring(1);
                System.out.println("Please Input " + name + " 's First name: ");
                String firstName = sc.next();
                if (acc.getUserName().startsWith(firstName)) {
                    while (true) {
                        System.out.println("Please Input the Transfer Money");
                        double money = sc.nextDouble();
                        if (loginAccount.getMoney() < money) {
                            System.out.println("Sorry Balance is " + loginAccount.getMoney() + " not Enough");
                            System.out.println("Please Try again");
                        } else {
                            loginAccount.setMoney(loginAccount.getMoney() - money);
                            acc.setMoney(acc.getMoney() + money);
                            System.out.println("Transfer Successfully, and Balance is " + loginAccount.getMoney());
                            return;
                        }
                    }
                }else{
                    System.out.println("Authentication failed");
                }

            }

        }
    }

    //展示登录后的账户
    private void showLoginAccount() {
        System.out.println("===Welcome " + loginAccount.getUserName() + " ! Your Information is Displayed as follow===");
        System.out.println("CardId: " + loginAccount.getCardID());
        System.out.println("Sex: " + loginAccount.getSex());
        System.out.println("Balance: " + loginAccount.getMoney());
        System.out.println("Withdrawal Limit: " + loginAccount.getLimit());
    }

    // 存款
    private void deposit() {
        System.out.println("===Deposit===");
        System.out.println("Please Input Deposit Amount: ");
        double depositAmount = sc.nextDouble();
        loginAccount.setMoney(depositAmount + loginAccount.getMoney());
        System.out.println("Deposit Successfully, and Balance is " + loginAccount.getMoney());
    }

    //取款
    private void withdrawal() {
        System.out.println("===Withdrawal===");
        if (loginAccount.getMoney() < 100) {
            System.out.println("The Balance is " + loginAccount.getMoney());
            System.out.println("Sorry, the Balance less than 100");
            return;
        }
        while (true) {
            System.out.println("Please Input Your Withdrawal Amount: ");
            double withdrawalAmount = sc.nextDouble();
            if (withdrawalAmount <= loginAccount.getLimit()) {
                if (withdrawalAmount <= loginAccount.getMoney()) {
                    loginAccount.setMoney(loginAccount.getMoney() - withdrawalAmount);
                    System.out.println("Withdrawal Successfully, and Balance is " + loginAccount.getMoney());
                    break;
                } else {
                    System.out.println("Your Balance is " + loginAccount.getMoney() + " not Enough!");
                    System.out.println("Please Try Again");
                }

            } else {
                System.out.println("WithdrawAmount cannot more than Withdrawal Limit " + loginAccount.getLimit());
                System.out.println("Please Try Again");
            }
        }
    }

    //返回一个8为数字的卡号，且不能重复
    private String createCardId() {
        while (true) {
            String cardId = "";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                int data = r.nextInt(10);   //0-9
                cardId += data;
            }
            Account acc = getAccountByCarId(cardId);
            if (acc == null) {
                return cardId;
            }
        }
    }

    private Account getAccountByCarId(String cardId) {
        for (int i = 0; i < accounts.size(); i++) {
//            Account acc = accounts.get(i);
//            if (cardId.equals(acc.getCardID())) {
//                return acc;
//            }
        }
        return null;
    }

}
