package com.keyManage.service.contain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Contain;
import com.keyManage.bean.KindOfKey;
import com.keyManage.dao.contain.ContainDAO;
import com.keyManage.dao.kindOfKey.KindOfKeyDAO;
import com.keyManage.util.CountObject;

public class ContainServiceImpl implements ContainService {
	
	private ContainDAO containDAO;
	private KindOfKeyDAO kindOfKeyDAO;

	@Override
	public void addContain(Contain contain) {
		containDAO.insert(contain);
	}
	
	@Override
	public void update(Contain contain) {
		containDAO.update(contain);
	}
	
	@Override
	public void removeAll(String[] ids) {
		Contain contain;
		for(String id:ids){
			contain=containDAO.findByPrimaryKey(id);
			contain.setIsDelete("0");
			containDAO.update(contain);
		}
		
	}

	@Override
	public Contain findByPrimaryKey(String id) {
		return containDAO.findByPrimaryKey(id);
	}

	@Override
	public List<Contain> findListByParams(Map<String, Object> params) {
		return containDAO.findListByParams(params);
	}

	@Override
	public PaginationSupport findByPage(Map<String, Object> params,
			int currentPage, int pageSize) {
		return containDAO.findByPage(params, currentPage, pageSize);
	}
//	@Override
//	public List findCountByKindOfKeyID(String saveOrTake) {
//		return containDAO.findCountByKindOfKeyID(saveOrTake);
//	}
//	@Override
//	public List findCountIDByKindOfKeyID(String saveOrTake) {
//		return containDAO.findCountIDByKindOfKeyID(saveOrTake);
////		return containDAO.findw();
//	}
	
	/**
	 * 按KindOfKeyID算取各种锁的剩余数量
	 * */
	public List<CountObject> findLastKey(){
		List<CountObject> countObjectList = containDAO.findCountByKindOfKeyID("0");
		List<CountObject> countTokenList = containDAO.findCountByKindOfKeyID("1");
		String[] ids=new String[countObjectList.size()];
		for(int i=0;i<countObjectList.size();i++){
			ids[i]=countObjectList.get(i).getItem();
		}
		List<KindOfKey> kindOfKeyList=kindOfKeyDAO.findByIds(ids);
		
		for(int i=0;i<countObjectList.size();i++){
		//往CountObject中添加name与备注
			CountObject addItem = countObjectList.get(i);
			addItem.setName(kindOfKeyList.get(i).getKindName());
			addItem.setRemark(kindOfKeyList.get(i).getRemark());
			for(CountObject c:countTokenList){
				if(addItem.getItem().equals(c.getItem())){
				//入库减去出库
					addItem.setNum(addItem.getNum()-c.getNum());
				}
			}
		}
		
		return countObjectList;
	}
	
	public ContainDAO getContainDAO() {
		return containDAO;
	}

	public void setContainDAO(ContainDAO containDAO) {
		this.containDAO = containDAO;
	}

	public KindOfKeyDAO getKindOfKeyDAO() {
		return kindOfKeyDAO;
	}

	public void setKindOfKeyDAO(KindOfKeyDAO kindOfKeyDAO) {
		this.kindOfKeyDAO = kindOfKeyDAO;
	}

}
