package com.vishnus1224.teamworkapidemo.subscriber;

import com.vishnus1224.teamworkapidemo.model.ProjectDto;

import java.util.List;

import rx.Subscriber;
import rx.subjects.Subject;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class ProjectDatabaseSubscriber extends Subscriber<List<ProjectDto>> {

    private Subject<List<ProjectDto>, List<ProjectDto>> subject;

    public ProjectDatabaseSubscriber(Subject<List<ProjectDto>, List<ProjectDto>> subject) {
        this.subject = subject;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        subject.onError(e);

    }

    @Override
    public void onNext(List<ProjectDto> projectDtoList) {

        subject.onNext(projectDtoList);

    }
}
