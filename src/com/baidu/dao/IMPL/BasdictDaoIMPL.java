package com.baidu.dao.IMPL;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.dao.BasdictDao;
import com.baidu.struts.entity.BasDict;
import com.baidu.struts.form.BasdictForm;

public class BasdictDaoIMPL extends HibernateDaoSupport implements BasdictDao {

	@Override
	public List<BasDict> findAllBasDicts(BasdictForm basdictForm) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from BasDict where 1=1");
		if (basdictForm.getDictType() != null
				&& basdictForm.getDictType().trim() != "") {
			stringBuffer.append(" and dictType like '%"
					+ basdictForm.getDictType() + "%'");
		}
		if (basdictForm.getDictItem() != null
				&& basdictForm.getDictItem().trim() != "") {
			stringBuffer.append(" and dictItem like '%"
					+ basdictForm.getDictItem() + "%'");
		}
		if (basdictForm.getDictValue() != null
				&& basdictForm.getDictValue().trim() != "") {
			stringBuffer.append(" and dictValue like '%"
					+ basdictForm.getDictValue() + "%'");
		}
		//String sql = "from BasDict";
		List<BasDict> list = getSession().createQuery(stringBuffer.toString()).list();
		return list;
	}

	@Override
	public int addbasDict(BasDict basDict) {
		// TODO Auto-generated method stub
		int num = 1;// 添加成功
		try {
			getSession().save(basDict);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			num = 0;// 添加失败
		}
		return num;
	}

	@Override
	public BasDict findByID(int dict_id) {
		// TODO Auto-generated method stub
		BasDict basDict = (BasDict) getSession().load(BasDict.class, dict_id);
		return basDict;
	}

	@Override
	public int updatebasdict(BasDict basDict) {
		// TODO Auto-generated method stub
		int num = 1;// 修改成功
		try {
			getSession().update(basDict);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			num = 0;// 修改失败
		}
		return num;
	}

	@Override
	public int deletebasdict(int dict_id) {
		// TODO Auto-generated method stub
		int num = 1;// 删除成功
		try {
			BasDict basDict = (BasDict) getSession().load(BasDict.class,
					dict_id);
			getSession().delete(basDict);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			num = 0;// 删除失败
		}
		return num;
	}
}
