package com.iot.service;

import com.iot.domain.ElementEntity;

public interface ElementService extends GeneralService<ElementEntity, Integer>{
    void manyToManyRel(String panelType, String batteryType);
}
