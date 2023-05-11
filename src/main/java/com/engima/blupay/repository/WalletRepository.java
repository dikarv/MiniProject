package com.engima.blupay.repository;

import com.engima.blupay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {

    
     @Query(value = "SELECT * FROM wallets WHERE phone_number = ?1", nativeQuery = true)
    public Wallet findWalletByPhoneNumber(String phoneNumber);

}
