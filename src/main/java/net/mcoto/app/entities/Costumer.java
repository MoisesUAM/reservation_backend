package net.mcoto.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {
    private Long costumerId;
    private String costumerName;
    private String mobile;
    private String email;
}
