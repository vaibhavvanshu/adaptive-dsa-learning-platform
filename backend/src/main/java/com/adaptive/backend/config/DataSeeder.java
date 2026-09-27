package com.adaptive.backend.config;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.Problem;
import com.adaptive.backend.entity.Topic;
import com.adaptive.backend.repository.ProblemRepository;
import com.adaptive.backend.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(
            TopicRepository topicRepository,
            ProblemRepository problemRepository
    ) {
        return args -> {

            if (topicRepository.count() > 0) {
                return;
            }

            Topic arrays = topicRepository.save(
                    Topic.builder()
                            .name("Arrays")
                            .description("Problems involving arrays, searching, sorting, and array manipulation.")
                            .build()
            );

            Topic strings = topicRepository.save(
                    Topic.builder()
                            .name("Strings")
                            .description("Problems involving string processing, matching, and character manipulation.")
                            .build()
            );

            Topic linkedLists = topicRepository.save(
                    Topic.builder()
                            .name("Linked Lists")
                            .description("Problems involving singly and doubly linked lists.")
                            .build()
            );

            Topic stacksQueues = topicRepository.save(
                    Topic.builder()
                            .name("Stacks and Queues")
                            .description("Problems involving stack and queue based data structures.")
                            .build()
            );

            Topic trees = topicRepository.save(
                    Topic.builder()
                            .name("Trees")
                            .description("Problems involving binary trees and tree traversal.")
                            .build()
            );

            Topic graphs = topicRepository.save(
                    Topic.builder()
                            .name("Graphs")
                            .description("Problems involving graph traversal and connectivity.")
                            .build()
            );

            Topic dynamicProgramming = topicRepository.save(
                    Topic.builder()
                            .name("Dynamic Programming")
                            .description("Problems involving overlapping subproblems and optimal substructure.")
                            .build()
            );

            problemRepository.save(
                    Problem.builder()
                            .title("Two Sum")
                            .description("Given an array of integers and a target value, return the indices of two numbers whose sum equals the target.")
                            .difficulty(Problem.Difficulty.EASY)
                            .constraints("The array contains at least two elements.")
                            .expectedApproach("HashMap")
                            .topic(arrays)
                            .build()
            );

            problemRepository.save(
                    Problem.builder()
                            .title("Maximum Subarray")
                            .description("Find the contiguous subarray with the largest possible sum.")
                            .difficulty(Problem.Difficulty.MEDIUM)
                            .constraints("The array contains at least one integer.")
                            .expectedApproach("Kadane's Algorithm")
                            .topic(arrays)
                            .build()
            );

            problemRepository.save(
                    Problem.builder()
                            .title("Valid Anagram")
                            .description("Determine whether two strings are anagrams of each other.")
                            .difficulty(Problem.Difficulty.EASY)
                            .constraints("The strings contain lowercase English letters.")
                            .expectedApproach("Frequency Counting")
                            .topic(strings)
                            .build()
            );

            problemRepository.save(
                    Problem.builder()
                            .title("Reverse Linked List")
                            .description("Reverse a singly linked list and return the new head.")
                            .difficulty(Problem.Difficulty.EASY)
                            .constraints("The list may be empty.")
                            .expectedApproach("Iterative Pointer Manipulation")
                            .topic(linkedLists)
                            .build()
            );

            problemRepository.save(
                    Problem.builder()
                            .title("Valid Parentheses")
                            .description("Determine whether a string containing brackets has valid matching and ordering of brackets.")
                            .difficulty(Problem.Difficulty.EASY)
                            .constraints("The string contains only bracket characters.")
                            .expectedApproach("Stack")
                            .topic(stacksQueues)
                            .build()
            );

            problemRepository.save(
                    Problem.builder()
                            .title("Maximum Depth of Binary Tree")
                            .description("Find the maximum depth of a binary tree.")
                            .difficulty(Problem.Difficulty.EASY)
                            .constraints("The tree may be empty.")
                            .expectedApproach("DFS")
                            .topic(trees)
                            .build()
            );

            problemRepository.save(
                    Problem.builder()
                            .title("Number of Islands")
                            .description("Given a grid of land and water cells, count the number of connected islands.")
                            .difficulty(Problem.Difficulty.MEDIUM)
                            .constraints("The grid contains rows and columns of land or water cells.")
                            .expectedApproach("DFS or BFS")
                            .topic(graphs)
                            .build()
            );

            problemRepository.save(
                    Problem.builder()
                            .title("Climbing Stairs")
                            .description("Count the number of distinct ways to reach the top of a staircase when one or two steps can be taken at a time.")
                            .difficulty(Problem.Difficulty.EASY)
                            .constraints("The number of steps is a positive integer.")
                            .expectedApproach("Dynamic Programming")
                            .topic(dynamicProgramming)
                            .build()
            );

            System.out.println("Initial DSA data seeded successfully.");
        };
    }
}