package com.xtilyna.booksbay.booksbay.Register;



public interface RegisterRepository {

    void registerNewUser(String email, String password);
    void sendVerificationEmail();

}
