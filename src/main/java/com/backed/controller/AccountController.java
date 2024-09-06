package com.backed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backed.dto.AccountDTO;
import com.backed.entity.Account;
import com.backed.form.AccountForm;
import com.backed.service.IAccountService;
import com.backed.update.AccoountUpdate;

@RestController
@RequestMapping(value = "api/backend/account")
@CrossOrigin("*")
public class AccountController {
	@Autowired
	private IAccountService accountService;

	@GetMapping
	public ResponseEntity<?> getAllAccount() {
		List<Account> accounts = new ArrayList<>();
		List<AccountDTO> accountDTOs = new ArrayList<>();
		accounts = accountService.getAllAccount();
		for (Account account : accounts) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setId(account.getAcc_iD());
			accountDTO.setUsername(account.getAcc_username());
			accountDTO.setEmail(account.getAcc_email());
			accountDTO.setFullname(account.getAcc_fristname());
			accountDTO.setAcc_Department(account.getAcc_Department().getDep_Name());
			accountDTO.setCreatDate(account.getAcc_createDate());
			accountDTO.setPosition(account.getAcc_Position().getPos_Name().toString());
			accountDTOs.add(accountDTO);
		}
		return new ResponseEntity<>(accountDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAllAccountByID(@PathVariable(name = "id") short id) {
		Account account = accountService.getAllAccountByID(id);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> accountCreate(@RequestBody AccountForm accountForm) {
		Account account = accountService.accountCreate(accountForm);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> UpdateCreate(@PathVariable(name = "id") short id,
			@RequestBody AccoountUpdate accountUpdate) {
		Account account = accountService.UpdateCreate(id, accountUpdate);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> DeleteAccount(@PathVariable(name = "id") short id) {
		accountService.DeleteAccount(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

}
