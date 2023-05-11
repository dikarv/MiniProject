package com.enigma.opo.Repository;

import com.enigma.opo.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WalletRepository extends JpaRepository<Wallet, String> {

    @Query(value = "SELECT * FROM wallet WHERE phone_number = ?", nativeQuery = true )
    public Wallet findWalletByPhoneNumber(String phoneNumber);


}
