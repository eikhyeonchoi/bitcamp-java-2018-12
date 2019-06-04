package com.eomcs.lms.service;

import java.util.Map;

public interface FaceBookService {
 Map<String, Object> getLoginUser(String accessToken);
}
