package com.blog.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String content ;
    private String description;
    private String title;



    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL,orphanRemoval = true)   // "post"  not Post , reference variable of Post(  Entity )
                                                                                      // created in Comment Entity
      private List<Comment> comments = new ArrayList<>();



}
