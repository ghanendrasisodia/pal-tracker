package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    @Value("${PORT}")
    private String port;

    @Value("${MEMORY_LIMIT}")
    private String memoryLimit;

    @Value("${PORT}")
    private String cfInstanceIndex;

    @Value("${PORT}")
    private String cfInstanceAddr;

    public EnvController() {
        super();
    }
    public EnvController(String port, String memoryLimit, String cfInstanceIndex, String cfInstanceAddr) {
        this.port=port;
        this.memoryLimit=memoryLimit;
        this.cfInstanceIndex=cfInstanceIndex;
        this.cfInstanceAddr=cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {

        Map<String, String> envMap = new HashMap<>();
        envMap.put("PORT", port);
        envMap.put("MEMORY_LIMIT", memoryLimit);
        envMap.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        envMap.put("CF_INSTANCE_ADDR", cfInstanceAddr);

        return envMap;
    }
}
