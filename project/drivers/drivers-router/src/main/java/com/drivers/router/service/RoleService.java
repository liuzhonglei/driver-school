package com.drivers.router.service;//package com.drivers.manager.service;
//
//import com.drivers.manager.web.dto.RoleDTO;
//import com.drivers.manager.web.mapper.RoleRepository;
//import com.istart.drivers.entity.Role;
//import com.istart.drivers.repository.RoleRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.stereotype.Service;
//
///**
// * Service Implementation for managing Role.
// */
//@Service
//@Transactional
//@Slf4j
//public class RoleService{
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private RoleRepository roleMapper;
//
//
//    /**
//     * Save a role.
//     *
//     * @param roleDTO the entity to save
//     * @return the persisted entity
//     */
//    public RoleDTO save(RoleDTO roleDTO) {
//        log.debug("Request to save Role : {}", roleDTO);
//        Role role = roleMapper.roleDTOToRole(roleDTO);
//        role = roleRepository.insert(role);
//        RoleDTO result = roleMapper.roleToRoleDTO(role);
//        return result;
//    }
//
//    /**
//     *  Get all the roles.
//     *
//     *  @param pageable the pagination information
//     *  @return the list of entities
//     */
//    @Transactional(readOnly = true)
//    public Page<Role> findAll(Pageable pageable) {
//        log.debug("Request to get all Roles");
//        Page<Role> result = roleRepository.findAll(pageable);
//        return result;
//    }
//
//    /**
//     *  Get one role by id.
//     *
//     *  @param id the id of the entity
//     *  @return the entity
//     */
//    @Transactional(readOnly = true)
//    public RoleDTO findOne(Long id) {
//        log.debug("Request to get Role : {}", id);
//        Role role = roleRepository.findOne(id);
//        RoleDTO roleDTO = roleMapper.roleToRoleDTO(role);
//        return roleDTO;
//    }
//
//    /**
//     *  Delete the  role by id.
//     *
//     *  @param id the id of the entity
//     */
//    public void delete(Long id) {
//        log.debug("Request to delete Role : {}", id);
//        roleRepository.delete(id);
//    }
//
//    /**
//     * Search for the role corresponding to the query.
//     *
//     *  @param query the query of the search
//     *  @return the list of entities
//     */
////    @Transactional(readOnly = true)
////    public Page<Role> search(String query, Pageable pageable) {
////        log.debug("Request to search for a page of Roles for query {}", query);
////        return roleSearchRepository.search(queryStringQuery(query), pageable);
////    }
//}
