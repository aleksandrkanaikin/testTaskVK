package org.example.testtaskvk.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {
    public int userId;
    public int id;
    public String title;
}
