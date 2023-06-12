package step.step1;

import java.util.Map;

public class AuthKeyManager {
    private static final String API_KEY_ENV_VARIABLE = "MY_API_KEY";
    private static String apiKey;

    static {
        // 환경 변수에서 인증 키를 가져옵니다.
        Map<String, String> env = System.getenv();
        apiKey = env.get(API_KEY_ENV_VARIABLE);
    }

    public static String getApiKey() {
        return apiKey;
    }
}
