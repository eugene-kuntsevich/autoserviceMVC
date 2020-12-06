package org.autoservice.service.impl;

import org.autoservice.dao.api.MasterDao;
import org.autoservice.model.Master;
import org.autoservice.service.AbstractService;
import org.autoservice.service.api.MasterService;
import org.autoservice.service.dto.MasterDto;
import org.autoservice.service.dtoconverter.MasterDtoConverter;
import org.autoservice.service.validators.MasterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MasterServiceImpl extends AbstractService<Master, MasterDto> implements MasterService {
    private MasterDao masterDao;
    private MasterDtoConverter masterDtoConverter;

    @Autowired
    public MasterServiceImpl(MasterDao masterDao, MasterDtoConverter masterDtoConverter, MasterValidator masterValidator) {
        super(masterDao, masterDtoConverter, masterValidator);
        this.masterDao = masterDao;
        this.masterDtoConverter = masterDtoConverter;
    }

    @Override
    public List<MasterDto> getFreeMasters() {
        return masterDtoConverter.convertListToDto(masterDao.getFreeMasters());
    }
}