package com.backed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backed.entity.Account;
import com.backed.entity.Department;
import com.backed.entity.Position;
import com.backed.form.AccountForm;
import com.backed.responsitory.DerpartmentResponsitory;
import com.backed.responsitory.IAccountResponsitory;
import com.backed.responsitory.IPositionResponsitory;
import com.backed.update.AccoountUpdate;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private IAccountResponsitory accountResponsitory;

	@Autowired
	private DerpartmentResponsitory derpartmentResponsitory;

	@Autowired
	private IPositionResponsitory positionResponsitory;

	@Override
	public List<Account> getAllAccount() {
		List<Account> accounts = accountResponsitory.findAll();
		return accounts;
	}

	@Override
	public Account getAllAccountByID(short id) {
		Account account = accountResponsitory.findById(id).get();
		return account;
	}

	@Override
	public Account accountCreate(AccountForm accountForm) {
		Account account = new Account();
		Department department = derpartmentResponsitory.findById(accountForm.getDepartment()).get();
		Position position = positionResponsitory.findById(accountForm.getPosition()).get();
		account.setAcc_email(accountForm.getEmail());
		account.setAcc_Department(department);
		account.setAcc_username(accountForm.getUsername());
		account.setAcc_fristname(accountForm.getFirst());
		account.setAcc_Position(position);
		Account accounted = accountResponsitory.save(account);
		return accounted;
	}

	@Override
	public Account UpdateCreate(short id, AccoountUpdate accountUpdate) {
		Account account = new Account();
		account = accountResponsitory.findById(id).get();
		Department department = derpartmentResponsitory.findById(accountUpdate.getDepartment()).get();
		Position position = positionResponsitory.findById(accountUpdate.getPosition()).get();
		account.getAcc_email();
		account.setAcc_Department(department);
		account.setAcc_Position(position);
		account.getAcc_fristname();
		account.getAcc_username();
		Account accounted = accountResponsitory.save(account);
		return accounted;
	}

	@Override
	public void DeleteAccount(short id) {
		accountResponsitory.deleteById(id);
	}

}
