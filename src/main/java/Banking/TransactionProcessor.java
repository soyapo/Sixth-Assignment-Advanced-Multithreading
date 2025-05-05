package Banking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class TransactionProcessor implements Runnable {
    private final BankAccount account;
    private final String filePath;
    private final List<BankAccount> allAccounts;

    public TransactionProcessor(BankAccount account, String filePath, List<BankAccount> allAccounts) {
        this.account = account;
        this.filePath = filePath;
        this.allAccounts = allAccounts;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 0) continue;

                switch (parts[0]) {
                    case "Deposit":
                        int depositAmount = Integer.parseInt(parts[1]);
                        account.deposit(depositAmount);
                        break;

                    case "Withdraw":
                        int withdrawAmount = Integer.parseInt(parts[1]);
                        account.withdraw(withdrawAmount);
                        break;

                    case "Transfer":
                        int targetIndex = Integer.parseInt(parts[1])-1;
                        int transferAmount = Integer.parseInt(parts[2]);

                        BankAccount target = allAccounts.get(targetIndex);
                        account.transfer(target, transferAmount);
                        break;
                }
            }

            System.out.println("Final balance of Account Number " + (allAccounts.indexOf(account)+1) + " : " + account.getBalance());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

