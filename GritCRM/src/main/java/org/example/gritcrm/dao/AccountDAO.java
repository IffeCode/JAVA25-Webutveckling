package org.example.gritcrm.dao;

import org.example.gritcrm.model.Account;

public class AccountDAO extends GenericDAO<Account, Integer>{

    public AccountDAO() {
        super(Account.class);
    }
}
