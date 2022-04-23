package com.enigma.opo.service;

import com.enigma.opo.entity.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {
    public Wallet debit(String phoneNummber, BigDecimal amount);
    public Wallet createWallet(Wallet wallet);
    public  Wallet topUp(BigDecimal topUpAmount , String phoneNUmber);
    public List<Wallet> findAllWallet();
}
