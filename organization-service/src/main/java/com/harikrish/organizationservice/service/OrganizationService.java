package com.harikrish.organizationservice.service;

import com.harikrish.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto saveOrganization(OrganizationDto organizationDto);

	OrganizationDto getOrganizationByCode(String organizationCode);

}
