package jp.co.aforce.various;

public class Empty {

	public String nullCheck(
			String id,
			String name,
			String password
			) {
		if(id.equals("")) {
			return "ID";
		}
		if(name.equals("")) {
			return "名前";
		}

		if(password.equals("")) {
			return "パスワード";
		}

		return "";

	}

	public String nullCheckById(String id) {
		if(id.equals("")) {
			return "会員番号";
		}
		return "";
	}

}
