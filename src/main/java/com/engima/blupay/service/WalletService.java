package com.engima.blupay.service;

import com.engima.blupay.repository.WalletRepository;
import  com.engima.blupay.entity.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {

    public Wallet debit(String phoneNummber, BigDecimal amount);
    public Wallet createWallet(Wallet wallet);
    public  Wallet topUp(BigDecimal topUpAmount , String phoneNUmber);
    public List<Wallet> findAllWallet();
}
