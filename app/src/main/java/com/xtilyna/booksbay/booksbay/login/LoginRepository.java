package com.xtilyna.booksbay.booksbay.login;


public interface LoginRepository {

    void loginUser(String email, String passsword);
    void createLoginSession();

}
