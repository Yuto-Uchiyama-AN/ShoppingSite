package jp.co.aforce.various;

import jp.co.aforce.bean.SweetBean;

public class Look2 {

	public SweetBean put(
			String id,
			String name,
			int price,
			String info,
			String imgname

			) throws Exception {

		SweetBean bean = null;


		bean = new SweetBean(
				id,
				name,
				price,
				info,
				imgname
				);


		return bean;
	}

}
