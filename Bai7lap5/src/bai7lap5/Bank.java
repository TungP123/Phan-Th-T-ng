/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai7lap5;

/**
 *
 * @author ASUS
 */
public class Bank
{
double[] accounts;
public Bank(int n, double initBalance)
{
accounts = new double[n];
for (int i = 0; i < accounts.length; i++)
{
accounts[i] = initBalance;
}
}
public int size()
{
return accounts.length;
}
public synchronized double getTotalBalance()
{
double total = 0;
for (int i = 0; i < accounts.length; i++)
{
total+=accounts[i];
}
return total;
}
public synchronized void transfer(int from, int to, double amount)
{
try
{
while(accounts[from] < amount)
{
System.out.println(Thread.currentThread().getName()+"đợi đủ tiền");
wait();
System.out.println(Thread.currentThread().getName()+"tiếp tục giao dịch");
}
accounts[from] -= amount;
accounts[to] += amount;
System.out.println("Chuyên " + amount + " từ account " + from + " sang account " + to);
System.out.println("Tông tiên cua các account: " +
getTotalBalance());
notifyAll();
}
catch (InterruptedException ex)
{
InterruptedException("Giao dich bi gian đoạn");
}
}

    private void InterruptedException(String giao_dich_bi_gian_đoạn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}