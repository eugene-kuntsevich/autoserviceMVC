package org.autoservice.service.api;

import org.autoservice.model.Master;
import org.autoservice.service.dto.MasterDto;

import java.util.List;

public interface MasterService extends GenericService<Master, MasterDto>{
    List<MasterDto> getFreeMasters();
}
