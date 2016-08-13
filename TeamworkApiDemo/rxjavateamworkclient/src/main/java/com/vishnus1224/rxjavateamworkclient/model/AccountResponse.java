package com.vishnus1224.rxjavateamworkclient.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by Vishnu on 8/13/2016.
 */
@JsonObject
public class AccountResponse extends BaseResponse {

    @JsonField
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
