package com.peierlong.service.impl;

import com.peierlong.service.ListenerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Qualifier("voice")
public class VoiceListenerServiceImpl implements ListenerService {

    @Override
    public String processListenerContent(Map<String, String> map) {
        return null;
    }

}
