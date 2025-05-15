package com.dev.prashant.repository;

import java.util.List;

import com.dev.prashant.dto.OwnerDTO;

/**
 * @author devPrashatKumar
 *
 */
public interface OwnerRepository {
	void saveOwner(OwnerDTO owner);

	OwnerDTO findOwner(int ownerId);

	void updatePetDetails(int ownerId, String petName);

	void deleteOwner(int ownerId);

	List<OwnerDTO> findAllOwners();
}
