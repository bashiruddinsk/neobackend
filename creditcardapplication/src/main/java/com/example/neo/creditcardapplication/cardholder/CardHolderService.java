package com.example.neo.creditcardapplication.cardholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardHolderService
{

    @Autowired
    private CardHolderJpaRepository cardHolderJpaRepository;

    public boolean validateCardHolder(CardHolderEntity cardHolder) {
        Optional<CardHolderEntity> existingCardHolder = cardHolderJpaRepository.findByPhoneNumber(cardHolder.getPhoneNumber());

        System.out.println("from CardHolder Service = "+existingCardHolder);
        // Compare the password if the user exists
        return existingCardHolder.isPresent() && existingCardHolder.get().getPassword().equals(cardHolder.getPassword());
    }
}
