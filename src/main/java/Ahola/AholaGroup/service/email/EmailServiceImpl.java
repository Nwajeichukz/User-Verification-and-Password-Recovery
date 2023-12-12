package Ahola.AholaGroup.service.email;

import Ahola.AholaGroup.dto.EmailDto;

public interface EmailServiceImpl {
    void sendEmailAlert(EmailDto emailDto);
}
