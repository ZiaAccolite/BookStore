package com.Accolite.bookStore.Service;

import com.Accolite.bookStore.Exception.storeException;
import com.Accolite.bookStore.Module.Users;
import com.Accolite.bookStore.Repository.storeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class storeServiceImpl implements  storeService{

    @Autowired
    private com.Accolite.bookStore.Repository.storeRepo storeRepo;

    @Override
    public Users createUser(Users user){
        return storeRepo.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return this.storeRepo.findAll();
    }

    @Override
    public Users getUserById(long userId) {
        Optional<Users> userObj = this.storeRepo.findById(userId);

        if (userObj.isPresent()){
            return userObj.get();
        }else {
            throw new storeException("User not found with ID:" + userId);
        }
    }

    @Override
    public void suspendUser(long userId){
        Optional<Users> userObj=this.storeRepo.findById(userId);
        if(userObj.isPresent()){
            this.storeRepo.deleteById(userId);
        }
        else{
            throw new storeException("the user with the given id was not present"+ userId);
        }
    }
    @Override
    public Users updateUser(Users user){
        Optional<Users> userObj = this.storeRepo.findById((long) user.getUserId());

        if(userObj.isPresent()) {
            Users userUpdate = userObj.get();
            userUpdate.setUserId(user.getUserId());
            userUpdate.setUserName(user.getUserName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPhoneNumber(user.getPhoneNumber());

            return this.storeRepo.save(userUpdate);
        }else{
            throw new storeException("User not found with ID: " + user.getUserId());
        }

    }
}
