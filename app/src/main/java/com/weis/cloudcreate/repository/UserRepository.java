package com.weis.cloudcreate.repository;

import com.weis.cloudcreate.bean.User;

import io.reactivex.Observable;

public class UserRepository extends BaseRepository {
    public User user;

    private static class Holder {
        static UserRepository instance = new UserRepository();
    }

    public UserRepository getInstance() {
        return Holder.instance;
    }

    private UserRepository() {
    }

    public User getCurrentUser() {
        /*Maybe.concat(Maybe.just(archiveModelOptional),
                mArchiveDao.getLoginArchive()
                        .filter(archive -> !ObjectsCompat.equals(archive.getArchiveId(), null))
                        .map(archiveModel -> {
                            archiveModelOptional = Optional.of(archiveModel);
                            return archiveModelOptional;
                        }))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .firstElement()
                .compose(ReactivexCompat.maybeThreadSchedule());*/
        if (user != null) {
            return user;
        }
        return Observable.merge(Observable.just(user), Observable.just(user))
                .firstElement()
                .blockingGet();

    }
}
