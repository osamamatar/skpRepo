package com.oma.b2b.util;

import com.oma.b2b.dto.MessageRequest;

public interface Notifier {

    public void send(MessageRequest messageRequest);


}
