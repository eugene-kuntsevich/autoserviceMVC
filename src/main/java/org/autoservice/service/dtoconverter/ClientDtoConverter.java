package org.autoservice.service.dtoconverter;

import org.autoservice.model.Client;
import org.autoservice.service.dto.ClientDto;
import org.springframework.stereotype.Service;

@Service
public class ClientDtoConverter extends AbstractDtoConverter<Client, ClientDto>{
    public ClientDtoConverter() {
        super(Client.class, ClientDto.class);
    }
}
