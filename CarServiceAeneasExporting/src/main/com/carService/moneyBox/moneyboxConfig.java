package main.com.carService.moneyBox;

import java.util.Calendar;

import main.com.carService.loginNeeds.user;
import main.com.carService.loginNeeds.userAppServiceImpl;
import main.com.carService.moneyTransactionDetails.moneybox_transaction_details;
import main.com.carService.moneyTransactionDetails.moneybox_transaction_detailsAppServiceImpl;

public class moneyboxConfig {

	public static void depositeMoney(float amount
			,user fromMe
			,userAppServiceImpl userFasced,moneyboxAppServiceImpl moneyfascede
			,moneybox_transaction_detailsAppServiceImpl moneyBoxtransactionFasced,
			String description) {
		
		moneybox myMoneyBox = moneyfascede.getByUserId(fromMe.getId());
		float totalAvailable = myMoneyBox.getAvailableMoney();
		
		//Set the new amount
		myMoneyBox.setAvailableMoney(totalAvailable+amount);
		moneyfascede.addmoneybox(myMoneyBox);
		
		//add new transaction
		moneybox_transaction_details transaction=new moneybox_transaction_details();
		transaction.setAmount(amount);
		transaction.setAmountBefore(totalAvailable);
		transaction.setTypeOfTransaction(moneybox_transaction_details.depositeTypes.Deposite.getType());
		transaction.setDate(Calendar.getInstance().getTime());
		transaction.setMoneyBoxId(myMoneyBox);
		transaction.setDescription(description);
		
		moneyBoxtransactionFasced.addmoneybox_transaction_details(transaction);
		
	}
	
	
	public static void makeaPayment(float amount
			,user fromMe,
			user toAccount
			,userAppServiceImpl userFasced,moneyboxAppServiceImpl moneyfascede
			,moneybox_transaction_detailsAppServiceImpl moneyBoxtransactionFasced,
			String description) {
		
		moneybox myMoneyBox = moneyfascede.getByUserId(fromMe.getId());
		float totalAvailable = myMoneyBox.getAvailableMoney();
		float totalSpend = myMoneyBox.getTotalUsed();
		
		//Set the new amount
		myMoneyBox.setAvailableMoney(totalAvailable-amount);
		myMoneyBox.setTotalUsed(totalSpend+amount);
		moneyfascede.addmoneybox(myMoneyBox);
		
		//add new transaction
		moneybox_transaction_details transaction=new moneybox_transaction_details();
		transaction.setAmount(amount);
		transaction.setAmountBefore(totalAvailable);
		transaction.setTypeOfTransaction(moneybox_transaction_details.depositeTypes.Payment.getType());
		transaction.setDate(Calendar.getInstance().getTime());
		transaction.setMoneyBoxId(myMoneyBox);
		transaction.setDescription(description);
		
		moneyBoxtransactionFasced.addmoneybox_transaction_details(transaction);
		
		//AddMoneyToTheMainUser
		user theMainAccount = userFasced.getById(toAccount.getId());
		moneybox mainAccountMoneyBox = moneyfascede.getByUserId(theMainAccount.getId());
		float totalAvailableMainAccount = mainAccountMoneyBox.getAvailableMoney();
		mainAccountMoneyBox.setAvailableMoney(totalAvailableMainAccount+amount);
		moneyfascede.addmoneybox(mainAccountMoneyBox);
		
		
		//add new transaction for MainAccount
		moneybox_transaction_details transactionMain=new moneybox_transaction_details();
		transactionMain.setAmount(amount);
		transactionMain.setAmountBefore(totalAvailableMainAccount);
		transactionMain.setTypeOfTransaction(moneybox_transaction_details.depositeTypes.Inserted.getType());
		transactionMain.setDate(Calendar.getInstance().getTime());
		transactionMain.setMoneyBoxId(mainAccountMoneyBox);
				
		moneyBoxtransactionFasced.addmoneybox_transaction_details(transactionMain);
		
	}
	
	
}
