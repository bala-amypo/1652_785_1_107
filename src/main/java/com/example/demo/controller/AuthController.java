package com.example.demo.controller;
@RestController
public class AuthController {
    
    @Autowired UserService service;

    @PostMapping("/post")
    public UserEntity senddata(@RequestBody UserEntity e){
        return service.saveuser(e);
    }
    @GetMapping("/get")
    public List<UserEntity> getvalue(){
        return service.getAlldata();
    }
    @DeleteMapping("/delete/{id}")
    public String deletevalue(@PathVariable int id){
        return service.Deletedata(id);
    }
    @GetMapping("/find/{id}")
    public UserEntity finddata(@PathVariable int id){
        return service.getdata(id);
    }
    @putMapping("/put/{id}")
    public UserEntity putdata(@PathVariable int id,@RequestBody UserEntity)
}