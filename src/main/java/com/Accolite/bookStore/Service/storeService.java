package com.Accolite.bookStore.Service;

import com.Accolite.bookStore.Module.Users;

import java.util.List;

public interface storeService {
    List<Users> getAllUsers();

    Users getUserById(long userId);

    Users createUser(Users user);

    Users updateUser(Users user);

    void suspendUser(long userId);
}
