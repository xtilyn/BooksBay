package com.xtilyna.booksbay.booksbay.register;



public interface RegisterRepository {

    void registerNewUser(String email, String password, String displayName, String location);
    void sendVerificationEmail(String email, String displayName, String location);

}
