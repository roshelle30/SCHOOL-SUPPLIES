package org.example.model;

public record User (int user_id, String full_name,String username,String password_hash, String role, String status){
    @Override
    public String toString(){
        return String.format("[%d] %s %s (%s) - Status: %s", user_id, username, role, status);
    }
}
