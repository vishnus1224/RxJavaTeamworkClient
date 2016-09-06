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
        
        
**TeamworkApiConfig**    
A TeamworkApiConfig instance is needed to make any kind of request. This object is formed by passing in the apiToken and the userURL obtained from the authentication. The config is used to authenticate the user requests.

        TeamworkApiConfig config = new TeamworkApiConfig("token", "url");


**LatestActivityApiClient**   
The LatestActivityApiClient provides all the information about latest activities of an user. The client offers a fluent interface for setting query parameter on the request.    

        LatestActivityApiClient latestActivityClient = new LatestActivityApiClient(teamworkApiConfig);
        latestActivityApiClient.maxItems(10).onlyStarred(false).subscribe(new Subscriber<List<LatestActivityDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<LatestActivityDto> latestActivityDtoList) {

                latestActivitiesView.showLatestActivity(convertToSections(latestActivityDtoList));

            }
        });

By default, `maxItems` are set to 60 and `onlyStarred` is false.
