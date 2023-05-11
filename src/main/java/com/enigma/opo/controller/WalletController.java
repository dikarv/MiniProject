package com.enigma.opo.controller;

import com.enigma.opo.entity.Wallet;
import com.enigma.opo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class WalletController  {

    @Autowired
    WalletService walletService;


    @PostMapping("/debit")
    public Wallet debitAmount(@RequestParam (name = "phoneNumber") String phoneNummber,
                            @RequestParam (name = "amount") BigDecimal amount){
       return walletService.debit(phoneNummber,amount);
    }

    @PostMapping("/wallets")
    public Wallet createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @PostMapping("/topup")
    public Wallet topUp( @RequestParam (name = "topup") BigDecimal topUpAmount,
                         @RequestParam(name = "phone") String phoneNUmber) {
        return walletService.topUp(topUpAmount,phoneNUmber);
    }

    @GetMapping("/wallets")
    public List<Wallet> findAllWallet() {
        return walletService.findAllWallet();
    }
    @PostMapping("/get/balance")
    public List<Wallet> getAllWalletsbyBalance(@RequestParam (name = "balance") BigDecimal balance) {
        return walletService.getAllWalletsbyBalance(balance);
    }
}

