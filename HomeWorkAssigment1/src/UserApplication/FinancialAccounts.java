/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserApplication;

/**
 *
 * @author Menita Koonani
 */
public class FinancialAccounts extends Person{
    private CheckingAccount checkingAcc;
    private SavingsAccount savingsAcc;

    public FinancialAccounts() {
        this.checkingAcc = new CheckingAccount();
        this.savingsAcc = new SavingsAccount();
    }
    public CheckingAccount getCheckingAcc() {
        return checkingAcc;
    }

    public void setCheckingAcc(CheckingAccount checkingAcc) {
        this.checkingAcc = checkingAcc;
    }

    public SavingsAccount getSavingsAcc() {
        return savingsAcc;
    }

    public void setSavingsAcc(SavingsAccount savingsAcc) {
        this.savingsAcc = savingsAcc;
    }
}
