package com.verdolaganation.Verdolaga_Nation.Follow;

import com.verdolaganation.Verdolaga_Nation.User.User;
import com.verdolaganation.Verdolaga_Nation.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public FollowService(FollowRepository followRepository, UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    public Follow followUser(int followerId, int followedId) {
        if (followerId == followedId) {
            throw new IllegalArgumentException("Un usuario no puede seguirse a sí mismo.");
        }

        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Usuario seguidor no encontrado"));

        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new RuntimeException("Usuario seguido no encontrado"));

        if (followRepository.existsByFollowerAndFollowed(follower, followed)) {
            throw new IllegalStateException("Ya sigues a este usuario.");
        }

        Follow follow = new Follow(follower, followed);
        return followRepository.save(follow);
    }

    public void unfollowUser(int followerId, int followedId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Usuario seguidor no encontrado"));

        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new RuntimeException("Usuario seguido no encontrado"));

        Follow follow = followRepository.findByFollowerAndFollowed(follower, followed)
                .orElseThrow(() -> new RuntimeException("No sigues a este usuario"));

        followRepository.delete(follow);
    }

    public List<Follow> getFollowing(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return followRepository.findByFollower(user);
    }

    public List<Follow> getFollowers(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return followRepository.findByFollowed(user);
    }

    public boolean isFollowing(int followerId, int followedId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Usuario seguidor no encontrado"));

        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new RuntimeException("Usuario seguido no encontrado"));

        return followRepository.existsByFollowerAndFollowed(follower, followed);
    }
}
