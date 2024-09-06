package com.backed.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backed.entity.Account;

public interface IAccountResponsitory extends JpaRepository<Account, Short> {

}
