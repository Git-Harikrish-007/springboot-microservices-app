package com.harikrish.organizationservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.harikrish.organizationservice.dto.OrganizationDto;
import com.harikrish.organizationservice.entity.Organization;
import com.harikrish.organizationservice.repository.OrganizationRepository;
import com.harikrish.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

	private OrganizationRepository organizationRepository;

	private ModelMapper modelMapper;

	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

		Organization organization = modelMapper.map(organizationDto, Organization.class);

		Organization savedOrganization = organizationRepository.save(organization);

		return modelMapper.map(savedOrganization, OrganizationDto.class);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {

		Organization savedOrganizationCode = organizationRepository.findByOrganizationCode(organizationCode);

		return modelMapper.map(savedOrganizationCode, OrganizationDto.class);
	}

}
