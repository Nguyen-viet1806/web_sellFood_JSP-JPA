package vietnqv.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RRShare_Utils {
	public static Map<Long, HttpServletRequest> requests = new HashMap<Long, HttpServletRequest>();
	public static Map<Long, HttpServletResponse> responses = new HashMap<Long, HttpServletResponse>();

	public static void addRR(HttpServletRequest req,HttpServletResponse res) {
		requests.put(Thread.currentThread().getId(), req);
		responses.put(Thread.currentThread().getId(), res);
	}

	public static void remove() {
		requests.remove(Thread.currentThread().getId());
		responses.remove(Thread.currentThread().getId());
	}
	public static HttpServletRequest request() {
		return requests.get(Thread.currentThread().getId());
	}
	public static HttpServletResponse response() {
		return responses.get(Thread.currentThread().getId());
	}
}
