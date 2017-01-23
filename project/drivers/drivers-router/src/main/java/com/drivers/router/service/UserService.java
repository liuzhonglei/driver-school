//package com.drivers.manager.service;
//
//import com.drivers.manager.security.SecurityUtils;
//import com.drivers.manager.service.util.RandomUtil;
//import com.drivers.manager.web.dto.ManagedUserDTO;
//import com.drivers.entity.Role;
//import com.drivers.entity.User;
//import com.drivers.repository.RoleRepository;
//import com.drivers.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.ZonedDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Slf4j
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private RoleRepository authorityRepository;
////    public Optional<User> getUserById(long id) {
////        log.debug("Getting user={}", id);
////        return Optional.ofNullable(userRepository.findOne(id));
////    }
////
////    public Optional<User> getUserByEmail(String email) {
////        log.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
////        return userRepository.findOneByEmail(email);
////    }
////
////    public Collection<User> getAllUsers() {
////        log.debug("Getting all users");
////        return userRepository.findAll(new Sort("email"));
////    }
////
////    public User create(UserCreateForm form) {
////        User user = new User();
////        user.setEmail(form.getEmail());
////        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
//////        user.setRole(form.getRole());
////        return userRepository.save(user);
////    }
//
//
//    //------------------------------
//
//    /**
//     * 激活用户
//     * @param key
//     * @return
//     */
//    public Optional<User> activateRegistration(String key){
//        log.debug("Activating user for activation key {}", key);
//        return  Optional.ofNullable(userRepository.findOneByActivationKey(key))
//                .map(user -> {
//                    // activate given user for the registration key.
//                    user.setActivated(true);
//                    user.setActivationKey(null);
//                    userRepository.updateByPrimaryKey(user);
//                    log.debug("Activated user: {}", user);
//                    return user;
//                });
//    }
//
//    public Optional<User> completePasswordReset(String newPassword, String key){
//        log.debug("Reset user password for reset key {}", key);
//        return Optional.ofNullable(userRepository.findOneByResetKey(key))
//                .filter(user -> {
//                    ZonedDateTime oneDayAgo = ZonedDateTime.now().minusHours(24);
//                    return user.getResetDate().isAfter(oneDayAgo);
//                })
//                .map(user -> {
//                    user.setPassword(passwordEncoder.encode(newPassword));
//                    user.setResetKey(null);
//                    user.setResetDate(null);
//                    userRepository.updateByPrimaryKey(user);
//                    return user;
//                });
//    }
//
//    public Optional<User> requestPasswordReset(String mail) {
//        return Optional.ofNullable(userRepository.findOneByEmail(mail))
//                .filter(User::getActivated)
//                .map(user -> {
//                    user.setResetKey(RandomUtil.generateResetKey());
//                    user.setResetDate(ZonedDateTime.now());
//                    userRepository.updateByPrimaryKey(user);
//                    return user;
//                });
//    }
//
//    public User createUserInformation(String login, String password, String firstName, String lastName, String email,
//                                      String langKey) {
//        User newUser = new User();
//        Role authority = authorityRepository.findByName("ROLE_USER");
//        List<Role> authorities = new ArrayList<>();
//        String encryptedPassword = passwordEncoder.encode(password);
//        newUser.setLogin(login);
//        // new user gets initially a generated password
//        newUser.setPassword(encryptedPassword);
//        newUser.setFirstName(firstName);
//        newUser.setLastName(lastName);
//        newUser.setEmail(email);
//        newUser.setLangKey(langKey);
//        // new user is not active
//        newUser.setActivated(false);
//        // new user gets registration key
//        newUser.setActivationKey(RandomUtil.generateActivationKey());
//        authorities.add(authority);
//        newUser.setRoles(authorities);
//        userRepository.insert(newUser);
//        authorityRepository.insertList(authorities);
////        userRepository.save(newUser);
//        log.debug("Created Information for User: {}", newUser);
//        return newUser;
//    }
//    public User createUser(ManagedUserDTO managedUserDTO) {
//        User user = new User();
//        user.setLogin(managedUserDTO.getLogin());
//        user.setFirstName(managedUserDTO.getFirstName());
//        user.setLastName(managedUserDTO.getLastName());
//        user.setEmail(managedUserDTO.getEmail());
//        if (managedUserDTO.getLangKey() == null) {
//            user.setLangKey("en"); // default language
//        } else {
//            user.setLangKey(managedUserDTO.getLangKey());
//        }
//        if (managedUserDTO.getRoles() != null) {
//            List<Role> roles = new ArrayList<>();
//            managedUserDTO.getRoles().stream().forEach(
//                    authority -> roles.add(authorityRepository.findByName(authority))
//            );
//            user.setRoles(roles);
//        }
//        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
//        user.setPassword(encryptedPassword);
//        user.setResetKey(RandomUtil.generateResetKey());
//        user.setResetDate(ZonedDateTime.now());
//        user.setActivated(true);
//        userRepository.updateByPrimaryKey(user);
//        log.debug("Created Information for User: {}", user);
//        return user;
//    }
//        /**
//         * 更新登录用户的信息
//         * @param firstName
//         * @param lastName
//         * @param email
//         * @param langKey
//         */
//    public void updateUserInformation(String firstName, String lastName, String email, String langKey){
//        String login = SecurityUtils.getCurrentUserLogin();
//        Optional.ofNullable(userRepository.findOneByLogin(login))
//                .ifPresent(u -> {
//                    u.setFirstName(firstName);
//                    u.setLastName(lastName);
//                    u.setEmail(email);
//                    u.setLangKey(langKey);
//                    userRepository.updateByPrimaryKey(u);
//                    log.debug("Changed Information for User: {}", u);
//                });
//    }
//
//    public void deleteUserInformation(String login){
//        Optional.ofNullable(userRepository.findOneByLogin(login)).ifPresent(u -> {
//            userRepository.delete(u);
//            log.debug("Deleted User: {}", u);
//        });
//    }
//
//    public void changePassword(String password) {
//        Optional.ofNullable(userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin())).ifPresent(u -> {
//            String encryptedPassword = passwordEncoder.encode(password);
//            u.setPassword(encryptedPassword);
//            userRepository.updateByPrimaryKey(u);
//            log.debug("Changed password for User: {}", u);
//        });
//    }
//    /**
//     * 查询用户信息(包含权限信息)
//     * @param login 用户名
//     * @return
//     */
//    @Transactional(readOnly = true)
//    public Optional<User> getUserWithAuthoritiesByLogin(String login) {
//        return Optional.ofNullable(userRepository.findOneByLogin(login)).map(u -> {
//            u.getRoles().size();
//            return u;
//        });
//    }
//
//    /**
//     * 查询用户信息(包含权限信息)
//     * @param id 用户数据ID
//     * @return
//     */
//    @Transactional(readOnly = true)
//    public User getUserWithAuthorities(Long id) {
//        User user = userRepository.findUserWithAuthorities(id);
//        user.getRoles().size(); // eagerly load the association
//        return user;
//    }
//
//    /**
//     * 根据当前登录用户的用户名（Spring security维护），查询用户信息(包含权限信息)
//     * @return
//     */
//    @Transactional(readOnly = true)
//    public User getUserWithAuthorities() {
//        User user = userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin());
//        user.getRoles().size(); // eagerly load the association
//        return user;
//    }
//}
