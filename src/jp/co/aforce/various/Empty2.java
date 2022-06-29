package jp.co.aforce.various;

public class Empty2 {

	public String nullCheck(
			String id,
			String name,
			String price,
			String info,
			String imgname
			) {
		if(id.equals("")) {
			return "ID";
		}
		if(name.equals("")) {
			return "名前";
		}

		if(price.equals("")) {
			return "値段";
		}

		if(info.equals("")) {
			return "説明";
		}

		if(imgname.equals("")) {
			return "画像";
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
