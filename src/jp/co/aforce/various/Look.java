package jp.co.aforce.various;

import jp.co.aforce.bean.MemberBean;

public class Look {

		public MemberBean put(
				String id,
				String name,
				String password
				) throws Exception {

			MemberBean bean = null;


			bean = new MemberBean(
					id,
					name,
					password
					);


			return bean;
		}

	}
