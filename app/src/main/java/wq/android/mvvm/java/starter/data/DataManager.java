package wq.android.mvvm.java.starter.data;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author wangqi
 */
@Singleton
public class DataManager {
    private final ApiService apiService;

    @Inject
    public DataManager(ApiService apiService) {
        this.apiService = apiService;
    }

    public void loadData() {
        apiService.loadData();
    }
}
