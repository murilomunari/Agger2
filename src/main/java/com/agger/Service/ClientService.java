package com.agger.Service;

import com.agger.DTO.ClientDTO;
import com.agger.Exception.ClientException;
import com.agger.Model.Client;
import com.agger.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create (ClientDTO data) {

        Optional<Client> cpfExist = clientRepository.findByCpf(data.cpf());

        if (cpfExist.isEmpty()) {
            throw new ClientException("Cpf do cliente ja existe na base");
        }

        Client client = new Client();
        client.setFirstName(data.firstName());
        client.setLastName(data.lastName());
        client.setCpf(data.cpf());
        client.setPhoneNumber(data.phoneNumber());
        client.setCep(data.cep());
        client.setNumberHouse(data.numberHouse());

        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }
}
