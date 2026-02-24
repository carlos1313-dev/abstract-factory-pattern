/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.exception;

/**
 *
 * @author sangr
 */
public class UserCancelledException extends RuntimeException {
    public UserCancelledException(String message) {
        super(message);
    }
}
