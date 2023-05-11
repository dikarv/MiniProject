package com.engima.blupay.service;

import com.engima.blupay.entity.Wallet;
import com.engima.blupay.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet debit(String phoneNummber, BigDecimal amount) {
         List<Wallet> wallets = walletRepository.findAllByPhoneNumber(phoneNummber);

    wallets.stream().forEach(wallet -> {
        BigDecimal balance = wallet.getBalance();
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("Saldo tidak mencukupi");
        }
        wallet.setBalance(newBalance);
    });

    walletRepository.saveAll(wallets);

    return wallets.get(0);
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet topUp(BigDecimal topUpAmount, String phoneNUmber) {
        Wallet wallet = walletRepository.findWalletByPhoneNumber(phoneNUmber);
        wallet.setBalance(wallet.getBalance().add(topUpAmount));
        return walletRepository.save(wallet);
    }

    @Override
    public List<Wallet> findAllWallet() {
        return walletRepository.findAll();
    }
}
