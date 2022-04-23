package com.enigma.opo.Repository;

import com.enigma.opo.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {

    public Wallet findWalletByPhoneNumber(String phoneNumber);


}
