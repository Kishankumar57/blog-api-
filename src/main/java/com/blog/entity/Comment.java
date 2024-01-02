package com.blog.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "comments")
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String body ;


    @ManyToOne
    @JoinColumn(name = "post_id") // foreign key  here it becomes   (id = post_id)....id is the primary key of Post entity class
                                  // post_id is the coloum of comment entity  class.
    private Post  post ;


}
