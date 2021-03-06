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
        Wallet wallet = walletRepository.findWalletByPhoneNumber(phoneNummber);//nampung object wallet
        BigDecimal money = wallet.getBalance();
        wallet.setBalance(money.subtract(amount));//subtract mengurangi
        if (!wallet.getBalance().subtract(amount).equals(0)){
            System.out.println("Saldo ada ");
        }
        walletRepository.save(wallet);

        return wallet;
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
