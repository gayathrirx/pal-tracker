package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private Map<String, String> envMap = new HashMap<String, String>();

    public EnvController(@Value("${PORT:NOT SET}")String port,
                         @Value("${MEMORY_LIMIT:NOT SET}")String memLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}")String instanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}")String instanceAddress){
        envMap.put("PORT", port);
        envMap.put("MEMORY_LIMIT", memLimit);
        envMap.put("CF_INSTANCE_INDEX", instanceIndex);
        envMap.put("CF_INSTANCE_ADDR", instanceAddress);
    }
    @GetMapping("/env")
    public Map<String, String> getEnv(){

        return  envMap ;

    }
}
