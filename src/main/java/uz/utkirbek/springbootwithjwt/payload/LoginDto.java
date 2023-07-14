package uz.utkirbek.springbootwithjwt.payload;

import lombok.Data;

/**
 * Author: utkirbek.
 * Time: 21:45:05
 * Date: July 14, 2023, Friday
 */
@Data
public class LoginDto {
    private String username;
    private String password;
}
