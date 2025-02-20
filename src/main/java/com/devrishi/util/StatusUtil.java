package com.devrishi.util;

import com.devrishi.todo.contract.ResponseStatusVO;
import java.time.LocalDateTime; 

public class StatusUtil {
	public static ResponseStatusVO getStatus (String message) {
		ResponseStatusVO status = new ResponseStatusVO();
		status.setMessage(message);
		status.setTime(LocalDateTime.now());
		return status;
	}


}
