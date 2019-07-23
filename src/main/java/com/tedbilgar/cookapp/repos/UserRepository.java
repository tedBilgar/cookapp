package com.tedbilgar.cookapp.repos;

import com.tedbilgar.cookapp.entities.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<UserEntity,Long> {

}
