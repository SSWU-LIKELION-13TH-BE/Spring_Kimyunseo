package com.example.demo1.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(name = "user_id", length = 20, nullable = false, unique = true)
 private String userId;
 @Column(name = "password", length = 255, nullable = false)
 private String password;
 @Column(name = "name", length = 20, nullable = false)
 private String name;
 @Column(name = "profile_image", length = 1000)
 private String profileImage;

}