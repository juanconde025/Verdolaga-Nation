package com.verdolaganation.Verdolaga_Nation.Follow;

import com.verdolaganation.Verdolaga_Nation.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {
    Optional<Follow> findByFollowerAndFollowed(User follower, User followed);

    List<Follow> findByFollower(User follower);

    List<Follow> findByFollowed(User followed);

    boolean existsByFollowerAndFollowed(User follower, User followed);

    void deleteByFollowerAndFollowed(User follower, User followed);
}
