package com.backed.service;

import java.util.List;

import com.backed.entity.Account;
import com.backed.form.AccountForm;
import com.backed.update.AccoountUpdate;

public interface IAccountService {

	List<Account> getAllAccount();

	Account getAllAccountByID(short id);

	Account accountCreate(AccountForm accountForm);

	Account UpdateCreate(short id, AccoountUpdate accountUpdate);

	void DeleteAccount(short id);

}
