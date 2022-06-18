package com.osama.skp.utilityClasses;


import com.osama.skp.utilityClasses.dto.MessageRequest;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

public interface Notifier {

    public void send(MessageRequest messageRequest) throws AddressException, MessagingException, IOException;


}
