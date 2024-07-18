package com.yasarbilgi.UserDeskReservation.Message;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PasswordResetMessage {
    private boolean success;
    private String message;

    public PasswordResetMessage(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
