package com.engima.blupay.repository;

import com.engima.blupay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {

    public  Wallet findWalletByPhoneNumber(String phoneNumber);

}
