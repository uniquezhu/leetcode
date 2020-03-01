import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0 || accounts.size() == 1) {
            return accounts;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        map.put(accounts.get(0).get(0), accounts.get(0));

        for (int i = 1; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            List<String> value = map.get(name);
            if (value != null) {
                boolean isSameAccount = false;
                for (int j = 1; j < account.size(); j++) {
                    String email = account.get(j);
                    if (value.contains(email) && email != value.get(0)) {
                        isSameAccount = true;
                    }
                }
                if (isSameAccount) {
                    for (int k = 1; k < account.size(); k++) {
                        String email = account.get(k);
                        if (!value.contains(email)) {
                            value.add(email);
                        }
                    }
                } else {
                    map.put(account.get(0), account);
                }
            } else {
                map.put(account.get(0), account);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> value = map.get(key);
            value.remove(0);
            Collections.sort(value);
            value.add(0, key);
            result.add(value);
        }
        return result;
    }
}
