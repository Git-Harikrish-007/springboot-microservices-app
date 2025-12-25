package com.harikrish.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harikrish.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	Organization findByOrganizationCode(String organizationCode);

}
