# RxJavaTeamworkClient
A reactive Teamwork API client written using RxJava.

#Usage

**Authentication**
Authentication is done using the `AuthenticationApiClient`. It has a single method `authenticate()` which returns an `Observable` of type `AccountResponse`.    

    AuthenticationApiClient authClient = new AuthenticationApiClient("token");    
    authClient.authenticate().subscribe(new Subscriber<AccountResponse>(){    
        @Override
        public void onCompleted() {
            
        }
        @Override
        public void onError(Throwable e) {
            
        }
        @Override
        public void onNext(AccountResponse accountResponse) {
            
            Account account = accountResponse.getAccount();
            
            //get the account url.
            String url = account.getURL();
            
        }});

