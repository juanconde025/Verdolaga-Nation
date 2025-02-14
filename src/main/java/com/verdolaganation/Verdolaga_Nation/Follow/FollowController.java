package com.verdolaganation.Verdolaga_Nation.Follow;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {
    private FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/{followerId}/follow/{followedId}")
    public ResponseEntity<String> followUser(@PathVariable int followerId, @PathVariable int followedId) {
        followService.followUser(followerId, followedId);
        return ResponseEntity.ok("Followed user added");
    }

    @DeleteMapping("/{followerId}/unfollow/{followedId}")
    public ResponseEntity<String> unfollowUser(@PathVariable int followerId, @PathVariable int followedId) {
        followService.unfollowUser(followerId, followedId);
        return ResponseEntity.ok("Unfollowed user added");
    }


    @GetMapping("/{userId}/following")
    public ResponseEntity<List<Follow>> getFollowing(@PathVariable int userId) {
        List<Follow> following = followService.getFollowing(userId);
        return ResponseEntity.ok(following);
    }

    @GetMapping("/{userId}/followers")
    public ResponseEntity<List<Follow>> getFollowers(@PathVariable int userId) {
        List<Follow> followers = followService.getFollowers(userId);
        return ResponseEntity.ok(followers);
    }

    @GetMapping("/{followerId}/isFollowing/{followedId}")
    public ResponseEntity<Boolean> isFollowing(@PathVariable int followerId, @PathVariable int followedId) {
        boolean following = followService.isFollowing(followerId, followedId);
        return ResponseEntity.ok(following);
    }
}
