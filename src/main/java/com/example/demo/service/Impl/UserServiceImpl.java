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
    @Override
    public String Deletedata(int id){
        users.deleteById(id);
        return "Delete Successfully";
    }
    @Override
    public UserEntity getdata(int id){
        return users.findById(id);
    }
    @Override
    public UserEntity update(int id,StudentEntity entity){
        if(users.existsById(id)){
         entity.setId(id);
         return users.save(entity);

        }
        return null;
    }
}