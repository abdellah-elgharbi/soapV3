package com.example.gestioncompte;

import com.example.gestioncompte.entities.Compte;
import com.example.gestioncompte.entities.TypeCompte;
import com.example.gestioncompte.respositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GestionCompteApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCompteApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository repository, CompteRepository compteRepository) {
        return args -> {

            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT));
              compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPAGNE));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(compte -> {
                 System.out.println(compte.toString() );
            });


        };
    }

}
