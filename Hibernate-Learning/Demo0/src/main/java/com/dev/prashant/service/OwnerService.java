package com.dev.prashant.service;

import java.util.List;

import com.dev.prashant.dto.OwnerDTO;
import com.dev.prashant.exception.DuplicateOwnerException;
import com.dev.prashant.exception.OwnerNotFoundException;

/**
 * @author devPrashatKumar
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException;

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;

	List<OwnerDTO> findAllOwners();
}