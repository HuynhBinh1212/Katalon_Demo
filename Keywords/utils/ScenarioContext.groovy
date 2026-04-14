package utils

import java.util.HashMap
import java.util.Map

public class ScenarioContext {
	
	// Sử dụng ThreadLocal để đảm bảo an toàn khi chạy song song
    private static ThreadLocal<Map<String, Object>> scenarioData = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    // Lưu dữ liệu
    public static void setContext(String key, Object value) {
        scenarioData.get().put(key, value);
    }

    // Lấy dữ liệu
    public static Object getContext(String key) {
        return scenarioData.get().get(key);
    }

    // Kiểm tra dữ liệu có tồn tại không
    public static Boolean isContains(String key) {
        return scenarioData.get().containsKey(key);
    }

    // Xóa dữ liệu sau mỗi Scenario
    public static void clear() {
        scenarioData.remove();
    }


}
