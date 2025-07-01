package com.agger.Service;

import com.agger.DTO.ApoliceDTO;
import com.agger.Exception.ApoliceException;
import com.agger.Model.Apolice;
import com.agger.Model.Client;
import com.agger.Repository.ApoliceRepository;
import com.agger.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoliceService {

    private final ApoliceRepository apoliceRepository;

    private final ClientRepository clientRepository;

    public ApoliceService(ApoliceRepository apoliceRepository, ClientRepository clientRepository) {
        this.apoliceRepository = apoliceRepository;
        this.clientRepository = clientRepository;
    }

    public Apolice create(ApoliceDTO data) {

        Optional<Apolice> numberExist = apoliceRepository.findByNumber(data.number());

        if (numberExist.isPresent()) {
            throw new ApoliceException("Apolice ja cadastrada no sistema");
        }

        Apolice apolice = new Apolice();

        apolice.setNumber(data.number());
        apolice.setDateTime(data.dataTime());


        Optional<Client> client = clientRepository.findById(data.clientId());

        if (client.isEmpty()) {
            throw new ApoliceException("Cliente não cadastrado no sistema" + data.clientId());
        }

        apolice.setClient(client.get());

        return apoliceRepository.save(apolice);
    }

    public List<Apolice> findAll () {
        return apoliceRepository.findAll();
    }

    public Optional<Apolice> findByNumber(String number) {
        return apoliceRepository.findByNumber(number);
    }
}
