package com.example.demo.service.Impl;
@Service
public class UserServiceImpl implements UserService {
    @Autowired UserRepository users;

    @Override
    public UserEntity saveuser(UserEntity user){
        return users.save(user);
    }
    @Override
    public List<UserEntity>getAlldata(){
        return users.findAll();
    }
}