package com.iot.dto.assembler;

import com.iot.controller.ContinentController;
import com.iot.domain.ContinentEntity;
import com.iot.dto.ContinentEntityDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ContinentDtoAssembler implements RepresentationModelAssembler<ContinentEntity,ContinentEntityDto > {
    @Override
    public ContinentEntityDto toModel(ContinentEntity entity) {
        ContinentEntityDto continentEntityDto = ContinentEntityDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
        Link selfLink = linkTo(methodOn(ContinentController.class).getContinent(continentEntityDto.getId())).withSelfRel();
        continentEntityDto.add(selfLink);
        return continentEntityDto;
    }

    @Override
    public CollectionModel<ContinentEntityDto> toCollectionModel(Iterable<? extends ContinentEntity> entities) {
        CollectionModel<ContinentEntityDto> continentEntityDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ContinentController.class).getAllContinents()).withSelfRel();
        continentEntityDtos.add(selfLink);
        return continentEntityDtos;
    }
}
