package org.autoservice.service.validators;

import org.autoservice.service.dto.MasterDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.stereotype.Component;

@Component
public class MasterValidator implements Validator<MasterDto> {
    @Override
    public void isValid(MasterDto entity) throws ValidatorException {
        if (entity != null) {
            if (entity.getFirstName().equals("")) {
                throw new ValidatorException("Master has empty first name");
            }

            if (entity.getLastName().equals("")) {
                throw new ValidatorException("Master has empty last name");
            }
        } else {
            throw new ValidatorException("Master is null");
        }
    }
}
