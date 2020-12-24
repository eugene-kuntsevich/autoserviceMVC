package org.autoservice.service.validators;

import org.autoservice.service.dto.ClientDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ClientValidator implements Validator<ClientDto> {
    private final Pattern emailPattern =
            Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$(.+)@(.+)^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    private boolean validateEmail(String email) {
        Matcher matcher = emailPattern.matcher(email);

        return matcher.matches();
    }

    @Override
    public void isValid(ClientDto entity) throws ValidatorException {
        if (entity != null) {
            if (entity.getFirstName().equals("")) {
                throw new ValidatorException("Client has empty first name");
            }

            if (entity.getLastName().equals("")) {
                throw new ValidatorException("Client has empty last name");
            }

            if (entity.getEmail().equals("")) {
                throw new ValidatorException("Client has empty email");
            } else {
                if (validateEmail(entity.getEmail())) {
                    throw new ValidatorException("Client's email is not correct");
                }
            }
        } else {
            throw new ValidatorException("Client is null");
        }
    }
}
