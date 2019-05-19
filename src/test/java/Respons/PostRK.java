package Respons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRK {

    public String userId;
    public String id;
    public String title;
    public String body;
}
