# RxJavaTeamworkClient
A reactive Teamwork API client written using RxJava.

##Workflow Demo

![](https://github.com/vishnus1224/RxJavaTeamworkClient/blob/master/demo/demo.gif)

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

To get all the latest activity   

        LatestActivityApiClient latestActivityClient = new LatestActivityApiClient(teamworkApiConfig);
        latestActivityApiClient.maxItems(10).onlyStarred(false).getLatestActivity().subscribe(new Subscriber<List<LatestActivityDto>>() {
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

**ProjectApiClient**   
Handles all the operations related to the teamworks projects api. All the options that can be passed in while fetching projects can be set on this client with the help of the fluent interface.

To get all the projects    

        ProjectApiClient projectApiClient = new ProjectApiClient(teamworkApiConfig);
        //set the page number to fetch the results from using the page method.
        projectApiClient.page(2).getAllProjects().subscribe(new Subscriber<List<ProjectDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<ProjectDto> projectDtoList) {

            }
        });
        
#Sample   
A sample project is included which demonstrates the usage of the API client. The sample displays a list of latest activity and projects exactly as per the current teamwork android app.   

The sample is built using the MVP architecture alongwith RxJava, Retrofit2, Dagger2, Picasso and Realm.

