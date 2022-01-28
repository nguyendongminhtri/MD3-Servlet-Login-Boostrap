package chinh.anh.service;

import chinh.anh.model.Users;

public interface IUserService {
    Users findByUsernameAndPassword(String username, String password);
}
