package com.blog.payload;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private long id ;

    @NotEmpty
    @Size(min = 2, message = "title should be at least 2 characters")
    private String title;

    @NotEmpty
    @Size(min = 4, message = "description should be at least 4 characters")
    private String description;

    @NotEmpty
    @Size(min = 4, message = "content should be at least 4 characters")
    private String content;




}
